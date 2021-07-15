package com.example.demo.pojo;

import java.io.Serializable;

public class Card implements Serializable {
    private String id;
    private Date beginTime;
    private Date endTime;
    private Integer if_times; // 0 : 年卡. 1 : 次卡
    private Integer card_level;
    private Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBeginTim() {
        return beginTime;
    }
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    public Date getEndTim() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIf_times() {
        return if_times;
    }
    public void setIf_times(Integer if_times) {
        this.if_times = if_times;
    }
    public Integer getCard_level() {
        return card_level;
    }
    public void setCard_level(Integer card_level) {
        this.card_level = card_level;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", beginTime='" + beginTime +
                ", endTime=" + endTime +
                ", if_times=" + if_times +
                ", card_level=" + card_level +
                ", amount='" + amount +
                '}';
    }
}
