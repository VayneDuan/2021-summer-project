package com.example.demo.pojo;

import java.util.Calendar;

public class Equipment {
    private Integer id;
    private String detail;
    private Float time_usage;
    private Calendar last_use;
    private String maintain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Float getTime_usage() {
        return time_usage;
    }

    public void setTime_usage(Float time_usage) {
        this.time_usage = time_usage;
    }

    public Calendar getLast_use() {
        return last_use;
    }

    public void setLast_use(Calendar last_use) {
        this.last_use = last_use;
    }

    public String getMaintain() {
        return maintain;
    }

    public void setMaintain(String maintain) {
        this.maintain = maintain;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", time_usage=" + time_usage +
                ", last_use=" + last_use +
                ", maintain='" + maintain + '\'' +
                '}';
    }
}
