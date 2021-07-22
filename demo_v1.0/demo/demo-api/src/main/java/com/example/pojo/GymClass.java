package com.example.pojo;

import java.io.Serializable;
import java.util.Date;

public class GymClass implements Serializable {
    private Long id;

    private String gymClassName;

    private String details;

    private String chooseReason;

    private Integer classWeek;

    private Date begintime;

    private Date endtime;

    private Long empId;

    private Integer price;

    private String img1url;

    private String img2url;

    private String img3url;

    private String img4url;

    private String gymEmpName;

    public String getGymEmpName() {
        return gymEmpName;
    }

    public void setGymEmpName(String gymEmpName) {
        this.gymEmpName = gymEmpName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGymClassName() {
        return gymClassName;
    }

    public void setGymClassName(String gymClassName) {
        this.gymClassName = gymClassName == null ? null : gymClassName.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getChooseReason() {
        return chooseReason;
    }

    public void setChooseReason(String chooseReason) {
        this.chooseReason = chooseReason == null ? null : chooseReason.trim();
    }

    public Integer getClassWeek() {
        return classWeek;
    }

    public void setClassWeek(Integer classWeek) {
        this.classWeek = classWeek;
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

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg1url() {
        return img1url;
    }

    public void setImg1url(String img1url) {
        this.img1url = img1url == null ? null : img1url.trim();
    }

    public String getImg2url() {
        return img2url;
    }

    public void setImg2url(String img2url) {
        this.img2url = img2url == null ? null : img2url.trim();
    }

    public String getImg3url() {
        return img3url;
    }

    public void setImg3url(String img3url) {
        this.img3url = img3url == null ? null : img3url.trim();
    }

    public String getImg4url() {
        return img4url;
    }

    public void setImg4url(String img4url) {
        this.img4url = img4url == null ? null : img4url.trim();
    }
}