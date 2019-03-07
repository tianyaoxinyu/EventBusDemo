package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.databinding.ActivityRecyclerBindBinding;
import kotlindemo.forwor.com.eventbusdemo.databinding.ActivityRecyclerViewBinding;

public class RecyclerBindActivity extends AppCompatActivity {

    private ActivityRecyclerBindBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_recycler_bind);
        RecyclerViewModel model = ViewModelProviders.of(this).get(RecyclerViewModel.class);
        model.getList().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                mBinding.getViewModel().getAdapter().setNewData(movies);
            }
        });
        mBinding.setViewModel(model);
        mBinding.setLifecycleOwner(this);
    }
}
