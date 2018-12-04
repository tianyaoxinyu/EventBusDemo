package kotlindemo.forwor.com.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import kotlindemo.forwor.com.eventbusdemo.entity.StickyEvent;

public class TestOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
        //第三步:Activity创建时注册
        EventBus.getDefault().register(this);
    }

    /**
     * @param event
     * ThreadMode.MAIN 表示这个方法在主线程中执行
     *
     * ThreadMode.BACKGROUND 表示该方法在后台执行，不能并发处理
     *
     * ThreadMode.ASYNC 也表示在后台执行，可以异步并发处理
     *
     * ThreadMode.POSTING 表示该方法和消息发送方在同一个线程中执行
     *
     * sticky=true表示使用粘性事件
     */
    //第四步:编写接收粘性事件的方法
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void receiveStickyEvent(StickyEvent event) {
        switch (event.type) {
            case "one":
                Toast.makeText(this, event.msg, Toast.LENGTH_SHORT).show();
                break;
            case "two":
                Toast.makeText(this, event.msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {//第五步:移除粘性事件
        //移除所有粘性事件
        EventBus.getDefault().removeAllStickyEvents();
        //移除指定类型的粘性事件
        //EventBus.getDefault().removeStickyEvent(new StickyEvent("one","我是一号消息"));
        //Activity销毁时取消注册
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
