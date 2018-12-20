package kotlindemo.forwor.com.eventbusdemo.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.entity.SpcificCombin;

/**
 * Created by Myy on 2018/12/19 20:38
 */
public class SpcificAdapter extends BaseSectionQuickAdapter<SpcificCombin,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SpcificAdapter(int layoutResId, int sectionHeadResId, List<SpcificCombin> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SpcificCombin item) {
        if (helper.getLayoutPosition() == 0) {
          /*  View v = helper.getView(R.id.line);
            //这个view是包裹在LinearLayout中的所以要用LinearLayout设置参数
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(v.getLayoutParams());
            lp.setMargins(0,0,0,0);
            v.setLayoutParams(lp);*/
          helper.setGone(R.id.line,false);
        }
        helper.setText(R.id.title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpcificCombin item) {
        helper.setText(R.id.content,item.t.getContent());
        helper.getView(R.id.content).setSelected(item.t.isSelected());
    }
}
