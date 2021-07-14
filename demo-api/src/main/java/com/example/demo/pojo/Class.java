package com.example.demo.pojo;

import java.util.Calendar;

public class Class {
    private Integer  id;
    private String gym_class_name;
    private Integer week;
    private Calendar beginTime;
    private Calendar endTime;
    private Integer emp_id;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGym_class_name() {
        return gym_class_name;
    }

    public void setGym_class_name(String gym_class_name) {
        this.gym_class_name = gym_class_name;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Calendar getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", gym_class_name='" + gym_class_name + '\'' +
                ", week=" + week +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", emp_id=" + emp_id +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
