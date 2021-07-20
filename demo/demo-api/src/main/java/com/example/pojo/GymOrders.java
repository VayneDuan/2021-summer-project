package com.example.pojo;

import java.io.Serializable;
import java.util.Date;

public class GymOrders implements Serializable {
    private String id;

    private Integer classVideo;

    private Long cvId;

    private String cardId;

    private Date createTime;

    private Integer price;

    private Integer ifUsed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getClassVideo() {
        return classVideo;
    }

    public void setClassVideo(Integer classVideo) {
        this.classVideo = classVideo;
    }

    public Long getCvId() {
        return cvId;
    }

    public void setCvId(Long cvId) {
        this.cvId = cvId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIfUsed() {
        return ifUsed;
    }

    public void setIfUsed(Integer ifUsed) {
        this.ifUsed = ifUsed;
    }
}