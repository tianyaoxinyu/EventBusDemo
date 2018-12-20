package kotlindemo.forwor.com.eventbusdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionEntity;

import java.util.List;

/**
 * Created by Myy on 2018/12/19 20:19
 */
public class SpcificCombin extends SectionEntity<SpecificSelelt> {

    public SpcificCombin(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SpcificCombin(SpecificSelelt s) {
        super(s);
    }

}
