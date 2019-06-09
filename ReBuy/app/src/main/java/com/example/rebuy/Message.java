package com.example.rebuy;

/**
 * Created by dell on 2019/6/8.
 */

public class Message {
    private int imageId;
    private String name;
    private String operate;
    private String time;
    public Message(int imageId, String name, String operate, String time){
        this.imageId = imageId;
        this.name = name;
        this.operate = operate;
        this.time = time;
    }

    public int getImageId(){
        return imageId;
    }
    public String getName(){
        return name;
    }
    public String getOperate(){
        return operate;
    }
    public String getTime(){
        return time;
    }

}
