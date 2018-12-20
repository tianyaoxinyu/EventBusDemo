package kotlindemo.forwor.com.eventbusdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import kotlindemo.forwor.com.eventbusdemo.adapter.FilterSpcificAdapter;

/**
 * Created by Myy on 2018/12/20 15:41
 */
public class Spcific implements MultiItemEntity {
    private String cotent;
    private boolean isSelected;

    public Spcific(String cotent, boolean isSelected) {
        this.cotent = cotent;
        this.isSelected = isSelected;
    }

    public String getCotent() {
        return cotent;
    }

    public void setCotent(String cotent) {
        this.cotent = cotent;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int getItemType() {
        return FilterSpcificAdapter.CONTENT;
    }
}
