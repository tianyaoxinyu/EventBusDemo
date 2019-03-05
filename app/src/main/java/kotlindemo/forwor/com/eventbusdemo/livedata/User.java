package kotlindemo.forwor.com.eventbusdemo.livedata;
/**
 * Created by Myy on 2019/3/5 09:01
 */
public class User {
    private String userName;
    private String imgUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

   /* @BindingAdapter(value = {"imageUrl","error"},requireAll = false)
    public static void loadImage(ImageView view,String url,RequestBuilder<Drawable> error) {
       Glide.with(view.getContext()).load(url).error(error).into(view);
    }*/
}
