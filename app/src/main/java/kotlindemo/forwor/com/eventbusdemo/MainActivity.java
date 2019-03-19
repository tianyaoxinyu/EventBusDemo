package kotlindemo.forwor.com.eventbusdemo;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.bugly.crashreport.CrashReport;

import org.greenrobot.eventbus.EventBus;

import kotlindemo.forwor.com.eventbusdemo.entity.StickyEvent;
import kotlindemo.forwor.com.eventbusdemo.utils.AppUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTwo;
    ImageView mIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUtil.initialize(getApplication());
        findViewById(R.id.tv_send_msg).setOnClickListener(this);
        mTwo = findViewById(R.id.tv_send_msg_two);
        mIv = findViewById(R.id.iv);
        mTwo.setOnClickListener(this);
        findViewById(R.id.testDataBinding).setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIv.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.slt_text_accent)));
        }else {
            Drawable icon = getResources().getDrawable(R.drawable.banner_default);
            Drawable tintIcon = DrawableCompat.wrap(icon);
            DrawableCompat.setTintList(tintIcon, getResources().getColorStateList(R.color.slt_text_accent));
            mIv.setImageDrawable(tintIcon);
        }
    }

    @Override
    public void onClick(View v) {//第二步:发送粘性事件
        switch (v.getId()) {
            case R.id.testDataBinding:
                CrashReport.testJavaCrash();
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
                break;
            case R.id.tv_send_msg:
                CrashReport.testANRCrash();
                EventBus.getDefault().postSticky(new StickyEvent("one","我是一号消息"));
                startActivity(new Intent(MainActivity.this,TestOneActivity.class));
                break;
            case R.id.tv_send_msg_two:
                CrashReport.testNativeCrash();
                EventBus.getDefault().postSticky(new StickyEvent("two","我是二号消息"));
                startActivity(new Intent(MainActivity.this,TestTwoActivity.class));
                break;
        }
    }
}
