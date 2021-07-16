package com.atguigu.boot.bean;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/14 22:54
 * @Description:
 */
public class Course {
    private String cname;
    private String year;
    private String start_time;
    private String end_time;
    private String img_url;
    private String trainer;
    private String introduction;
    private String sub_course_name[] = {"01.Fitness Class", "02.Body Building", "03.Train", "04.Running", "06.Yoga"};
    private String sub_course_url[] = {"images/classes-detail.png","#","#","#","#","#"};

    public String getCname() {
        return cname;
    }

    public String getYear() {
        return year;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getImg_url() {
        return img_url;
    }

    public String[] getSub_course_name() {
        return sub_course_name;
    }

    public String[] getSub_course_url() {
        return sub_course_url;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Course(String s0, String s1, String s2, String s3, String s4, String s5, String s6) {
        this.cname = s0;
        this.year = s1;
        this.start_time = s2;
        this.end_time = s3;
        this.img_url = s4;
        this.trainer = s5;
        this.introduction = s6;
    }

}
