package com.example.demo.pojo;

import java.util.Calendar;

public class Lockers {
    private Integer id;
    private String gym_lockers_location;
    private Calendar beginTime;
    private Calendar endTime;
    private Integer member_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGym_lockers_location() {
        return gym_lockers_location;
    }

    public void setGym_lockers_location(String gym_lockers_location) {
        this.gym_lockers_location = gym_lockers_location;
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

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "Lockers{" +
                "id=" + id +
                ", gym_lockers_location='" + gym_lockers_location + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", member_id=" + member_id +
                '}';
    }
}
