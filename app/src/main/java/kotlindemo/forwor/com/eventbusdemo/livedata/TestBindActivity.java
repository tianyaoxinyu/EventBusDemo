package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kotlindemo.forwor.com.eventbusdemo.R;
import kotlindemo.forwor.com.eventbusdemo.databinding.ActivityTestBindBinding;

public class TestBindActivity extends AppCompatActivity {
    ActivityTestBindBinding mBinding;
    TestViewModel mTestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_bind);
        mTestViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        //User user = new User();
        //mTestViewModel.setUser(user);
        //需要持有同一种数据对象(binding和viewmodel)
        Observer<User> user = new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mBinding.setUser(user);
            }
        };
        mTestViewModel.getUser().observe(this, user);
        mBinding.setUser(mTestViewModel.getUser().getValue());//为databing设置数据源
        mBinding.setViewModel(mTestViewModel);
        mBinding.setLifecycleOwner(this);
    }
}
