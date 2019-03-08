package kotlindemo.forwor.com.eventbusdemo.livedata.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.entity.Flower;
import kotlindemo.forwor.com.eventbusdemo.livedata.adapter.MultiItemBindAdapter;
import kotlindemo.forwor.com.eventbusdemo.livedata.model.DataProvider;

/**
 * Created by Myy on 2019/3/8 10:43
 */
public class MultiViewModel extends AndroidViewModel {
    private MutableLiveData<List<Flower>> list = new MutableLiveData<>();
    private MultiItemBindAdapter adapter = new MultiItemBindAdapter(list.getValue());
    public MultiViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Flower>> getList() {
        list.setValue(DataProvider.getFlowers());
        return list;
    }

    public void setList(MutableLiveData<List<Flower>> list) {
        this.list = list;
    }

    public MultiItemBindAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(MultiItemBindAdapter adapter) {
        this.adapter = adapter;
    }
}
