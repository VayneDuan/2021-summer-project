package com.atguigu.boot.bean;

import javax.naming.Name;
import java.util.List;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/16 16:40
 * @Description:
 */
public class forTrainerDetail {
    private String name;
    private String img;
    private String birthDate;
    private String signature;
    private double score;
    private String introduction;
    private List<String> coursesList;

    public forTrainerDetail(String name, String img,String birthDate, String signature, double score, String introduction, List<String> coursesList){
        this.name = name;
        this.img = img;
        this.birthDate = birthDate;
        this.signature = signature;
        this.score =score;
        this.introduction = introduction;
        this.coursesList = coursesList;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double getScore() {
        return score;
    }

    public String getSignature() {
        return signature;
    }

    public String getIntroduction() {
        return introduction;
    }

    public List<String> getCoursesList() {
        return coursesList;
    }
}
