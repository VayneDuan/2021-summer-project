package com.example.demo.pojo;

import java.io.Serializable;

public class Video implements Serializable {
    private long id;
    private String videoUrl;
    private String gym_video_name;
    private double price;

    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getVideoUrl(){
        return this.videoUrl;
    }
    public void setVideoUrl(String videoUrl){
        this.videoUrl  = videoUrl;
    }
    public String getGym_video_name(){
        return this.gym_video_name;
    }
    public void setGym_video_name(String gym_video_name){
        this.gym_video_name = gym_video_name;
    }
    public double getPrice(){
        return this.price;
    }
    public  void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", videoUrl='" + videoUrl +
                ", gym_video_name=" + gym_video_name +
                ", price=" + price +
                '}';
    }
}
