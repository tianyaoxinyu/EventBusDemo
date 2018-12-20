package kotlindemo.forwor.com.eventbusdemo.decoration;

import android.graphics.Rect;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import kotlindemo.forwor.com.eventbusdemo.adapter.FilterSpcificAdapter;

/**
 * Created by Myy on 2018/12/20 17:31
 */
public class GridMuiltItemDecoration extends RecyclerView.ItemDecoration{
    private float gapHorizontalDp;
    private float gapVerticalDp;
    private float sectionEdgeHPaddingDp;
    private float sectionEdgeVPaddingDp;
    private int gapHSizePx = -1;
    private int gapVSizePx = -1;
    private int sectionEdgeHPaddingPx;
    private int eachItemHPaddingPx; //每个条目应该在水平方向上加的padding 总大小，即=paddingLeft+paddingRight
    private int sectionEdgeVPaddingPx;
    private Rect preRect = new Rect();
    private boolean isPreItemHeader = false;
    private int sectionStartItemPos = 0;
    private int sectionEndItemPos = 0;
    private int sectionItemCount = 0;

    /**
     * @param gapHorizontalDp       水平间距
     * @param gapVerticalDp         垂直间距
     * @param sectionEdgeHPaddingDp 左右两端的padding大小
     * @param sectionEdgeVPaddingDp 上下两端的padding大小
     */
    public GridMuiltItemDecoration(float gapHorizontalDp, float gapVerticalDp, float sectionEdgeHPaddingDp, float sectionEdgeVPaddingDp) {
        this.gapHorizontalDp = gapHorizontalDp;
        this.gapVerticalDp = gapVerticalDp;
        this.sectionEdgeHPaddingDp = sectionEdgeHPaddingDp;
        this.sectionEdgeVPaddingDp = sectionEdgeVPaddingDp;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof GridLayoutManager && parent.getAdapter() instanceof BaseMultiItemQuickAdapter) {
            GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> adapter = (BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>) parent.getAdapter();
            int spanCount = layoutManager.getSpanCount();
            int position = parent.getChildAdapterPosition(view);
            MultiItemEntity entity = adapter.getItem(position);

            if (entity != null && entity.getItemType() == FilterSpcificAdapter.TITLE) {
                //不处理header
                isPreItemHeader = true;
                outRect.set(0,0,0,0);
//                Log.w("GridAverageGapItem", "pos=" + position + "," + outRect.toShortString());
                return;
            }

            if (isPreItemHeader) {
                sectionStartItemPos = position;
                sectionEndItemPos = findSectionLastItemPos(position, adapter);
                sectionItemCount = sectionEndItemPos - sectionStartItemPos + 1;
//                Log.w("GridAverageGapItem", "new section=" + sectionStartItemPos + "-" + sectionEndItemPos);
            }

            if (gapHSizePx < 0 || gapVSizePx < 0) {
                transformGapDefinition(parent, spanCount);
            }
            outRect.top = gapVSizePx;
            outRect.bottom = 0;

            //下面的visualPos为单个Section内的视觉Pos
            int visualPos = position + 1 - sectionStartItemPos;
            if (visualPos % spanCount == 1) {
                //第一列
                outRect.left = sectionEdgeHPaddingPx;
                Log.e("left",outRect.left + "");
                outRect.right = eachItemHPaddingPx - sectionEdgeHPaddingPx;
            } else if (visualPos % spanCount == 0) {
                //最后一列
                outRect.left = eachItemHPaddingPx - sectionEdgeHPaddingPx;
                outRect.right = sectionEdgeHPaddingPx;
                Log.e("left1", outRect.left + "");
            } else {
                //此处需要固定，根据日志打印情况取合适的固定值，以免权重下的RecyclerView下面有布局时导致条目间隔改变
                outRect.left = 45;
                Log.e("left2",outRect.left + "");
                outRect.right = eachItemHPaddingPx - outRect.left;
            }

            if (visualPos - spanCount <= 0) {
                //每个section的第一行
                outRect.top = sectionEdgeVPaddingPx;
            }
            //存在即是第一行，又是最后一行的情况，故不用elseif
            if (isLastRow(visualPos, spanCount, sectionItemCount)) {
                //每个section的最后一行
                outRect.bottom = sectionEdgeVPaddingPx;
            }
            preRect = new Rect(outRect);
            isPreItemHeader = false;
//            Log.w("GridAverageGapItem", "pos=" + position + "," + outRect.toShortString());
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    private void transformGapDefinition(RecyclerView parent, int spanCount) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            parent.getDisplay().getMetrics(displayMetrics);
        }
        gapHSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, gapHorizontalDp, displayMetrics);
        gapVSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, gapVerticalDp, displayMetrics);
        sectionEdgeHPaddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sectionEdgeHPaddingDp, displayMetrics);
        sectionEdgeVPaddingPx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sectionEdgeVPaddingDp, displayMetrics);
        eachItemHPaddingPx = (sectionEdgeHPaddingPx * 2 + gapHSizePx * (spanCount - 1)) / spanCount;
    }

    private int findSectionLastItemPos(int curPos, BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> adapter) {
        int count = adapter.getItemCount();
        if (count == curPos + 1) {
            return curPos;
        }
        MultiItemEntity entity = null;
        for (int i = curPos + 1; i < count; i++) {
            entity = adapter.getItem(i);
            if (entity != null && entity.getItemType() == FilterSpcificAdapter.TITLE) {
                return i - 1;
            }
        }
        return count - 1;
    }

    private boolean isLastRow(int visualPos, int spanCount, int sectionItemCount) {
        int lastRowCount = sectionItemCount % spanCount;
        lastRowCount = lastRowCount == 0 ? spanCount : lastRowCount;
        return visualPos > sectionItemCount - lastRowCount;
    }
}
