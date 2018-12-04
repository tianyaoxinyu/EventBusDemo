package kotlindemo.forwor.com.eventbusdemo.entity;

/**
 * 第一步:创建粘性事件实体类
 */
public class StickyEvent {
    //类型字段
    public String type;
    //消息字段, 也可以是一个实体类，总称传递内容
    public String msg;

    /**
     * @param type
     * @param msg
     * 粘性事件构造方法
     */
    public StickyEvent(String type,String msg) {
        this.type = type;
        this.msg = msg;
    }
}
