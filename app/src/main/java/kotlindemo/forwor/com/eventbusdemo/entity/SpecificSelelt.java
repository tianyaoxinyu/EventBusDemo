package kotlindemo.forwor.com.eventbusdemo.entity;

/**
 * Created by Myy on 2018/12/20 10:18
 */
public class SpecificSelelt {
    private boolean isSelected;
    private String content;
    private String header;

    public SpecificSelelt(String header,boolean isSelected, String content) {
        this.header = header;
        this.isSelected = isSelected;
        this.content = content;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
