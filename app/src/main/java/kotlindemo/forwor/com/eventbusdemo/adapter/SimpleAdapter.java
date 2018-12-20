package kotlindemo.forwor.com.eventbusdemo.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Myy on 2018/12/19 18:49
 */
public class SimpleAdapter<T> extends RecyclerView.Adapter<SimpleAdapter.BaseViewHolder> {
    private List<T> itemDatas;
    private int defaultLayout;
    private int brId;

    public SimpleAdapter(List<T> itemDatas, int defaultLayout, int brId) {
        this.itemDatas = itemDatas;
        this.defaultLayout = defaultLayout;
        this.brId = brId;
    }

    public int getItemLayout(T itemData) {
        return defaultLayout;
    }

    public void addListener(ViewDataBinding binding, T itemData, int position) {
    }

    public void onItemDatasChanged(List<T> newItemDatas) {
        this.itemDatas = newItemDatas;
        notifyDataSetChanged();
    }

    protected void onItemRangeChanged(List<T> newItemDatas, int positionStart, int itemCount) {
        this.itemDatas = newItemDatas;
        notifyItemRangeChanged(positionStart, itemCount);
    }

    protected void onItemRangeInserted(List<T> newItemDatas, int positionStart, int itemCount) {
        this.itemDatas = newItemDatas;
        notifyItemRangeInserted(positionStart, itemCount);
    }

    protected void onItemRangeRemoved(List<T> newItemDatas, int positionStart, int itemCount) {
        this.itemDatas = newItemDatas;
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemLayout(itemDatas.get(position));
    }

    @Override
    public SimpleAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new BaseViewHolder(binding);
    }
   //@NonNull标识holder不可为空
    @Override
    public void onBindViewHolder(@NonNull SimpleAdapter.BaseViewHolder holder, int position) {
        holder.binding.setVariable(brId, itemDatas.get(position));
        addListener(holder.binding, itemDatas.get(position), position);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return itemDatas == null ? 0 : itemDatas.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        BaseViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
