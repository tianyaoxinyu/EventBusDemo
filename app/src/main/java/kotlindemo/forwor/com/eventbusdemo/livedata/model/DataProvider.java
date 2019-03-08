package kotlindemo.forwor.com.eventbusdemo.livedata.model;

import java.util.ArrayList;
import java.util.List;

import kotlindemo.forwor.com.eventbusdemo.entity.Flower;

/**
 * Created by Myy on 2019/3/8 09:38
 */
public class DataProvider {
    public static List<Flower> getFlowers() {
        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            flowers.add(new Flower("红的" + i, "白的" + i, "雪的" + i, Flower.FLOWER_TYPE));
            flowers.add(new Flower("玫瑰" + i, "梅花" + i, Flower.FLOWER_NAME));
            flowers.add(new Flower("500", Flower.FLOWER_TOTAL_PRICE));
        }
        return flowers;
    }
}
