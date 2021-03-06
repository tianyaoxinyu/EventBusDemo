package kotlindemo.forwor.com.eventbusdemo.livedata.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.entity.Movie;
import kotlindemo.forwor.com.eventbusdemo.livedata.adapter.DataBindingUseAdapter;

/**
 * Created by Myy on 2019/3/7 14:51
 */
public class RecyclerViewModel extends AndroidViewModel {
    private MutableLiveData<List<Movie>> mList = new MutableLiveData<>();
    //如果把adapter分离出去就需要重新写个类继承AndroidViewModel,activity或fragment要设置这个ViewModel,可能吧
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

    //这玩意可能写哪都行,也不一定可能要继承AndroidViewModel
   /* @BindingAdapter(value = {"rows"},requireAll = false)
    public static void setRclDirection(RecyclerView view, int rows) {
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            ((GridLayoutManager)layoutManager).setSpanCount(rows);
        }
    }*/
}
