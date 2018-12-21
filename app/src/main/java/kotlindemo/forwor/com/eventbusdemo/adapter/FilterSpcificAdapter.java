package kotlindemo.forwor.com.eventbusdemo.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.entity.Spcific;
import kotlindemo.forwor.com.eventbusdemo.entity.SpcificTitle;

/**
 * Created by Myy on 2018/12/20 15:44
 */
public class FilterSpcificAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {
    public static final int TITLE = 0;
    public static final int CONTENT = 1;
    /**
     * @param data 数据集合
     */
    public FilterSpcificAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TITLE,R.layout.item_rcl_specif_spac_title);
        addItemType(CONTENT,R.layout.item_rcl_specif_spac_content);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TITLE:
                if (helper.getLayoutPosition() == 0) {//此处动态设置分割线隐藏必须有else不然会导致隐藏异常
                    Log.e("posion",helper.getLayoutPosition() + "");
                    helper.setGone(R.id.line,false);
                }else {
                    helper.setGone(R.id.line,true);
                }
                SpcificTitle title = (SpcificTitle) item;
                helper.setText(R.id.title,title.getTitle());
                break;
            case CONTENT:
                final Spcific spcific = (Spcific) item;
                helper.setText(R.id.content,spcific.getCotent());
                final SpcificTitle parent = (SpcificTitle) getData().get(getParentPosition(spcific));
                helper.getView(R.id.content).setSelected(spcific.isSelected());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < parent.getSubItems().size(); i++) {
                            if (spcific == parent.getSubItem(i)) {
                                if (!spcific.isSelected()) {
                                    spcific.setSelected(true);
                                }else {
                                    spcific.setSelected(false);
                                }
                            }else if (parent.getSubItem(i).isSelected()) {
                                parent.getSubItem(i).setSelected(false);
                            }
                        }
                        notifyDataSetChanged();
                    }
                });
                break;
        }
    }
}
