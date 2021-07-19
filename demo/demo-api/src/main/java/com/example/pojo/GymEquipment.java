package com.example.pojo;

import java.util.Date;

public class GymEquipment {
    private Long id;

    private String detail;

    private Long timeUsageHour;

    private Date lastUse;

    private String maintain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Long getTimeUsageHour() {
        return timeUsageHour;
    }

    public void setTimeUsageHour(Long timeUsageHour) {
        this.timeUsageHour = timeUsageHour;
    }

    public Date getLastUse() {
        return lastUse;
    }

    public void setLastUse(Date lastUse) {
        this.lastUse = lastUse;
    }

    public String getMaintain() {
        return maintain;
    }

    public void setMaintain(String maintain) {
        this.maintain = maintain == null ? null : maintain.trim();
    }
}