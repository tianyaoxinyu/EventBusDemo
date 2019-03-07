package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;

/**
 * Created by Myy on 2019/3/7 14:51
 */
public class RecyclerViewModel extends AndroidViewModel {
    private MutableLiveData<List<Movie>> mList = new MutableLiveData<>();
    private DataBindingUseAdapter mAdapter = new DataBindingUseAdapter(R.layout.item_recycler_bind,mList.getValue());
    public RecyclerViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Movie>> getList() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Movie movie = new Movie();
            movie.name = "好" + i;
            movie.content = "哈" + i;
            movies.add(movie);
        }
        mList.setValue(movies);
        return mList;
    }

    public void setList(MutableLiveData<List<Movie>> mList) {
        this.mList = mList;
    }

    public DataBindingUseAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(DataBindingUseAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    //这玩意可能写哪都行
   /* @BindingAdapter(value = {"rows"},requireAll = false)
    public static void setRclDirection(RecyclerView view, int rows) {
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            ((GridLayoutManager)layoutManager).setSpanCount(rows);
        }
    }*/
}
