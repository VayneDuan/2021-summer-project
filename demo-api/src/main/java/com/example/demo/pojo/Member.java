package com.example.demo.pojo;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer id;
    private String sex;
    private Integer age;
    private Float height;
    private Float weight;
    private String imgUrl;
    private String gym_member_name;
    private String phone;
    private Integer card_id;
    private Integer coach_id;
    private String passwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGym_member_name() {
        return gym_member_name;
    }

    public void setGym_member_name(String gym_member_name) {
        this.gym_member_name = gym_member_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public Integer getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", imgUrl='" + imgUrl + '\'' +
                ", gym_member_name='" + gym_member_name + '\'' +
                ", phone='" + phone + '\'' +
                ", card_id=" + card_id +
                ", coach_id=" + coach_id +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
