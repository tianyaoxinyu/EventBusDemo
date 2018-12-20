package kotlindemo.forwor.com.eventbusdemo.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import kotlindemo.forwor.com.eventbusdemo.adapter.FilterSpcificAdapter;

/**
 * Created by Myy on 2018/12/20 15:53
 */
public class SpcificTitle extends AbstractExpandableItem<Spcific> implements MultiItemEntity {
    private String title;

    public SpcificTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return FilterSpcificAdapter.TITLE;
    }
}
