package kotlindemo.forwor.com.eventbusdemo.entity;
/**
 * Created by Myy on 2019/3/5 09:01
 */
public class User {
    private String userName;
    private String imgUrl;
    private String userNick;

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

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
