package kotlindemo.forwor.com.eventbusdemo.livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Myy on 2019/3/5 10:09
 */
public class TestViewModel extends AndroidViewModel {
    private MutableLiveData<User> mUser;

    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<User> getUser() {//网络层获取数据
        if (mUser == null) mUser = new MutableLiveData<>();
        //网络请求，然后给mUser赋值
        User user = new User();
        user.setUserName("小明");
        mUser.setValue(user);
        return mUser;
    }

    public void onBtnClick(View view) {
        if (mUser.getValue() != null) {
            //数据变化改变UI
          /*  User user = getUser().getValue();
            if (user != null) user.setUserName("小风");
            mUser.setValue(user);*/
           //ui上数据变化后保存到数据源
            Toast.makeText(getApplication(), mUser.getValue().getUserName(), Toast.LENGTH_SHORT).show();
            //view.getContext().startActivity(new Intent(view.getContext(),TestOneActivity.class));
        } else Toast.makeText(getApplication(), "哈哈", Toast.LENGTH_SHORT).show();
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
