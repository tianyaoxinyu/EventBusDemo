package kotlindemo.forwor.com.eventbusdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Myy on 2018/12/19 21:37
 */
public class DataProvider {
    public static List<SpcificCombin> getSpcificCombinData() {
        List<SpcificCombin> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new SpcificCombin(true,"美丽的" + i));
            for (int j = 0; j < 6; j++) {
                list.add(new SpcificCombin(new SpecificSelelt("美丽的" + i,false,"item" + j)));
            }
        }
        return list;
    }

    public static List<MultiItemEntity> getSpecifics() {
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            SpcificTitle lv0 = new SpcificTitle("title" + i);
            for (int j = 0; j < 5; j++) {
                lv0.addSubItem(new Spcific("content" + j,false));
            }
            res.add(lv0);
        }
        return res;
    }
}
