package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
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
         mBinding = DataBindingUtil.setContentView(this,R.layout.activity_test_bind);
         mTestViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
         //User user = new User();
         //mTestViewModel.setUser(user);
        //需要持有同一种数据对象(binding和viewmodel)
         mBinding.setUser(mTestViewModel.getUser().getValue());
         mBinding.setViewModel(mTestViewModel);
         mBinding.setLifecycleOwner(this);
    }
}
