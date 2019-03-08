package kotlindemo.forwor.com.eventbusdemo.livedata.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.BR;
import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.entity.Flower;

/**
 * Created by Myy on 2019/3/8 08:34
 */
public class MultiItemBindAdapter extends BaseMultiItemQuickAdapter<Flower, BaseViewHolder> {

    public MultiItemBindAdapter(List<Flower> data) {
        super(data);
        addItemType(Flower.FLOWER_TYPE, R.layout.item_head);
        addItemType(Flower.FLOWER_NAME, R.layout.item_center);
        addItemType(Flower.FLOWER_TOTAL_PRICE, R.layout.item_footer);
    }

    @Override
    protected void convert(BaseViewHolder helper, Flower item) {
        ViewDataBinding binding = DataBindingUtil.bind(helper.itemView);
        if (binding != null) {
            binding.setVariable(BR.flower, item);
            binding.executePendingBindings();
        }
    }

}
