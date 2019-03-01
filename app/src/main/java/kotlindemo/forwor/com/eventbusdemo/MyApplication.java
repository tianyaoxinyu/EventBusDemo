package kotlindemo.forwor.com.eventbusdemo;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Myy on 2019/2/18 14:22
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        strategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() {
            @Override
            public synchronized Map<String, String> onCrashHandleStart(int i, String s, String s1, String s2) {
                LinkedHashMap<String,String> map = new LinkedHashMap<>();
                map.put("errorType",s);
                map.put("errorMessage",s1);
                map.put("errorStack",s2);
                return map;
            }

            @Override
            public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String s, String s1, String s2) {
                try {
                    return s2.getBytes("UTF-8");
                }catch (Exception e) {
                    return null;
                }
            }
        });
        CrashReport.initCrashReport(this,"57475a9f4a",true,strategy);
    }
}
