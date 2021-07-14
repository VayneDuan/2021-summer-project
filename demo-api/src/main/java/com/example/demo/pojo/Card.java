package com.example.demo.pojo;

import java.util.Calendar;

/**
 * 会员卡表
 */
public class Card {
    private Integer id;
    private Calendar beginTime;
    private Calendar endTime;
    private Integer dict_level;
    private Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDict_level() {
        return dict_level;
    }

    public void setDict_level(Integer dict_level) {
        this.dict_level = dict_level;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", dict_level=" + dict_level +
                ", amount=" + amount +
                '}';
    }
}
