package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import kotlindemo.forwor.com.eventbusdemo.TestOneActivity;

/**
 * Created by Myy on 2019/3/5 10:09
 */
public class TestViewModel extends AndroidViewModel {
    private MutableLiveData<User> mUser = new MutableLiveData<>();

    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<User> getUser() {//网络层获取数据
        User user = new User();
        user.setUserName("李四");
        setUser(user);
        return mUser;
    }

    private void setUser(User user) {//这个可以不要
       mUser.setValue(user);
    }

    public void onBtnClick(View view) {
        if (mUser.getValue() != null)
        Toast.makeText(getApplication(), mUser.getValue().getUserName(), Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplication(),"哈哈",Toast.LENGTH_SHORT).show();
        view.getContext().startActivity(new Intent(view.getContext(),TestOneActivity.class));
    }

    //自定义ImageView属性
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