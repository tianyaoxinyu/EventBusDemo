package kotlindemo.forwor.com.eventbusdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Myy on 2019/3/8 08:36
 */
public class Flower implements MultiItemEntity {
    public static final int FLOWER_TYPE = 1;
    public static final int FLOWER_NAME = 2;
    public static final int FLOWER_TOTAL_PRICE = 3;
    private String flowerType1;
    private String flowerType2;
    private String flowerType3;
    private String flowerName1;
    private String flowerName2;
    private String flowerTotalPrice;
    private int itemType;

    public Flower(String flowerType1, String flowerType2, String flowerType3, int itemType) {
        this.flowerType1 = flowerType1;
        this.flowerType2 = flowerType2;
        this.flowerType3 = flowerType3;
        this.itemType = itemType;
    }

    public Flower(String flowerName1, String flowerName2, int itemType) {
        this.flowerName1 = flowerName1;
        this.flowerName2 = flowerName2;
        this.itemType = itemType;
    }

    public Flower(String flowerTotalPrice, int itemType) {
        this.flowerTotalPrice = flowerTotalPrice;
        this.itemType = itemType;
    }

    public String getFlowerType1() {
        return flowerType1;
    }

    public void setFlowerType1(String flowerType1) {
        this.flowerType1 = flowerType1;
    }

    public String getFlowerType2() {
        return flowerType2;
    }

    public void setFlowerType2(String flowerType2) {
        this.flowerType2 = flowerType2;
    }

    public String getFlowerType3() {
        return flowerType3;
    }

    public void setFlowerType3(String flowerType3) {
        this.flowerType3 = flowerType3;
    }

    public String getFlowerName1() {
        return flowerName1;
    }

    public void setFlowerName1(String flowerName1) {
        this.flowerName1 = flowerName1;
    }

    public String getFlowerName2() {
        return flowerName2;
    }

    public void setFlowerName2(String flowerName2) {
        this.flowerName2 = flowerName2;
    }

    public String getFlowerTotalPrice() {
        return flowerTotalPrice;
    }

    public void setFlowerTotalPrice(String flowerTotalPrice) {
        this.flowerTotalPrice = flowerTotalPrice;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
