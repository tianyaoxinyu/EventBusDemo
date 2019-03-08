package kotlindemo.forwor.com.eventbusdemo.livedata.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.BR;
import kotlindemo.forwor.com.eventbusdemo.entity.Movie;
import kotlindemo.forwor.com.eventbusdemo.livedata.inter.OnRclItemClickListener;

/**
 * Created by Myy on 2019/3/7 14:35
 */
public class DataBindingUseAdapter extends BaseQuickAdapter<Movie,BaseViewHolder> {
    private OnRclClickListener mListener;
    public DataBindingUseAdapter(int layoutResId, @Nullable List<Movie> data) {
        super(layoutResId, data);
        mListener = new OnRclClickListener();
    }

    @Override
    protected void convert(BaseViewHolder helper, Movie item) {
        ViewDataBinding binding = DataBindingUtil.bind(helper.itemView);
        //此处RecyclerView若有头尾可能要减掉头尾个数
        item.position = helper.getAdapterPosition();
        if (binding != null) {
            binding.setVariable(BR.movie,item);
            binding.setVariable(BR.listener,mListener);
            binding.executePendingBindings();
        }
    }

    //点击事件写在有数据源的地方才能自动更新数据，一定是继承AndroidViewModel的类，而且调用了LiveData的setValue或postValue方法与在activity中调用了observe方法
    public class OnRclClickListener implements OnRclItemClickListener {
        @Override
        public void onItemClick(View v,Movie movie) {
            Toast.makeText(v.getContext(),"嗯嗯" +  movie.position, Toast.LENGTH_SHORT).show();
            if (movie.position == 0) {
                movie.name = "小明";
                notifyItemChanged(movie.position);
            }
        }
    }

}
