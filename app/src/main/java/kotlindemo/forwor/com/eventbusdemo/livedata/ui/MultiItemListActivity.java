package kotlindemo.forwor.com.eventbusdemo.livedata.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.databinding.ActivityMultiItemListBinding;
import kotlindemo.forwor.com.eventbusdemo.entity.Flower;
import kotlindemo.forwor.com.eventbusdemo.livedata.viewmodel.MultiViewModel;

public class MultiItemListActivity extends AppCompatActivity {

    private MultiViewModel multiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMultiItemListBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_multi_item_list);
        multiViewModel = ViewModelProviders.of(this).get(MultiViewModel.class);
        multiViewModel.getList().observe(this, new Observer<List<Flower>>() {
            @Override
            public void onChanged(@Nullable List<Flower> flowers) {
                multiViewModel.getAdapter().setNewData(flowers);
            }
        });
        mBinding.setViewModel(multiViewModel);
        mBinding.setLifecycleOwner(this);
    }
}
