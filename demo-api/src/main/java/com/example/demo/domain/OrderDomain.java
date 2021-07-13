package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderDomain implements Serializable {
    private Integer id;
    private Integer orderNum;
    private LocalDateTime gmtCreate;

    public OrderDomain() {

    }

    public OrderDomain(Integer id, Integer orderNum, LocalDateTime gmtCreate) {
        this.id = id;
        this.orderNum = orderNum;
        this.gmtCreate = gmtCreate;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "OrderDomain:{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                '}';
    }
}
