package com.db.ui.listview;

/**
 * @描述：     @自定义水果类，作为ListView适配器的适配类型
 * @作者：     @Bin
 * @创建时间： @2018/11/9 16:36
 */
public class Fruit {

    private String name;

    private int imageId;

    public Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
