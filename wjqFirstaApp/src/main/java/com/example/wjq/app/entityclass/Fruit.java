package com.example.wjq.app.entityclass;

import com.example.wjq.app.R;

/**
 * Created by 王瑞青 on 2017/4/6.
 */

public class Fruit {

    private String name;
    private String itemId;
    private int imageId;

    public Fruit(String name, int imageId, String itemId) {
        this.name = name;
        this.imageId = imageId;
        this.itemId = itemId;
//        this.imageId = R.drawable.baidu_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getItemId() {
        return itemId;
    }
}
