package kotlindemo.forwor.com.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import kotlindemo.forwor.com.eventbusdemo.entity.StickyEvent;

public class TestTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_two);
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
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onReceiveEvent(StickyEvent event) {
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
       // EventBus.getDefault().removeAllStickyEvents();

        //官方推荐此法移除:更好地检查事件是否实际发布过此事件,用这个更好
        StickyEvent stickyEvent = EventBus.getDefault().removeStickyEvent(StickyEvent.class);
        if (stickyEvent != null) {
            EventBus.getDefault().removeStickyEvent(stickyEvent);
        }

        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
