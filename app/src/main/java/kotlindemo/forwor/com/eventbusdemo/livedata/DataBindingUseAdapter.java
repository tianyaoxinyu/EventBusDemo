package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.BR;
import kotlindemo.forwor.com.eventbusdemo.R;

/**
 * Created by Myy on 2019/3/7 14:35
 */
public class DataBindingUseAdapter extends BaseQuickAdapter<Movie,DataBindingUseAdapter.MovieViewHolder> {
    private OnRclClickListener mListener;
    public DataBindingUseAdapter(int layoutResId, @Nullable List<Movie> data) {
        super(layoutResId, data);
        mListener = new OnRclClickListener();
    }

    @Override
    protected void convert(MovieViewHolder helper, Movie item) {
        ViewDataBinding binding = helper.getBinding();
        item.position = helper.getAdapterPosition();
        binding.setVariable(BR.movie,item);
        binding.setVariable(BR.listener,mListener);
        binding.executePendingBindings();
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater,layoutResId,parent,false);
        if (binding == null) return super.getItemView(layoutResId, parent);
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support,binding);
        return view;
    }

    public class OnRclClickListener implements OnRclItemClickListener{
        @Override
        public void onItemClick(View v,Movie movie) {
            Toast.makeText(v.getContext(),"嗯嗯" +  movie.position, Toast.LENGTH_SHORT).show();
            if (movie.position == 0) {
                movie.name = "小明";
                notifyItemChanged(movie.position);
            }
        }
    }

    public static class MovieViewHolder extends BaseViewHolder {

        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }

}
