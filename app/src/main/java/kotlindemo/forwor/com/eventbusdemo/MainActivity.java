package kotlindemo.forwor.com.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import kotlindemo.forwor.com.eventbusdemo.entity.StickyEvent;
import kotlindemo.forwor.com.eventbusdemo.utils.AppUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUtil.initialize(getApplication());
        findViewById(R.id.tv_send_msg).setOnClickListener(this);
        findViewById(R.id.tv_send_msg_two).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {//第二步:发送粘性事件
        switch (v.getId()) {
            case R.id.tv_send_msg:
                EventBus.getDefault().postSticky(new StickyEvent("one","我是一号消息"));
                startActivity(new Intent(MainActivity.this,TestOneActivity.class));
                break;
            case R.id.tv_send_msg_two:
                EventBus.getDefault().postSticky(new StickyEvent("two","我是二号消息"));
                startActivity(new Intent(MainActivity.this,TestTwoActivity.class));
                break;
        }
    }
}
