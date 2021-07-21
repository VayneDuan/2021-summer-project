package com.example.pojo;

import java.io.Serializable;
import java.util.Date;

public class GymCard implements Serializable {
    private String id;

    private Date begintime;

    private Date endtime;

    private Integer ifTimes;

    private Integer cardLevel;

    private Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIfTimes() {
        return ifTimes;
    }

    public void setIfTimes(Integer ifTimes) {
        this.ifTimes = ifTimes;
    }

    public Integer getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(Integer cardLevel) {
        this.cardLevel = cardLevel;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}