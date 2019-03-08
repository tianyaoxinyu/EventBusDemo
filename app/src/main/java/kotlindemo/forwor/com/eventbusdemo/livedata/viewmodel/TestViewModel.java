package kotlindemo.forwor.com.eventbusdemo.livedata.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;
import kotlindemo.forwor.com.eventbusdemo.TestOneActivity;
import kotlindemo.forwor.com.eventbusdemo.entity.User;

/**
 * Created by Myy on 2019/3/5 10:09
 */
public class TestViewModel extends AndroidViewModel {
    private MutableLiveData<User> mUser;

    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<User> getUser() {//网络层获取数据
        if (mUser == null) mUser = new MutableLiveData<>();
        //网络请求，然后给mUser赋值
        User user = new User();
        user.setUserName("小明");
        user.setUserNick("雨墨");
        mUser.setValue(user);
        return mUser;
    }

    public void onBtnClick(View view) {
        if (mUser.getValue() != null) {
            //数据变化改变UI
            mUser.getValue().setUserNick("小艾");
            //数据改变后需要重新设置，同一数据源
            //数据变化时推送给观察者
           // mUser.setValue(mUser.getValue());//主线程
            mUser.postValue(mUser.getValue());//子线程,数据量大时使用
            //ui上数据变化后保存到数据源
            Toast.makeText(getApplication(), mUser.getValue().getUserName(), Toast.LENGTH_SHORT).show();
            view.getContext().startActivity(new Intent(view.getContext(),TestOneActivity.class));
        } else Toast.makeText(getApplication(), "哈哈", Toast.LENGTH_SHORT).show();
    }

    //自定义ImageView属性,当requireAll为false时，ImageView的xml的属性设置imageUrl与error是任何一个属性配置后都会调用loadImage方法，若不配置requireAll字段则要2个属性同时配置在一个ImageView上才会调用loadImage方法
     /* @BindingAdapter(value = {"imageUrl","error"},requireAll = false)
    public static void loadImage(ImageView view,String url,RequestBuilder<Drawable> error) {
       Glide.with(view.getContext()).load(url).error(error).into(view);
    }*/

    @Override
    protected void onCleared() {
        //清理资源
        super.onCleared();
    }
}
