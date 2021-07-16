package com.atguigu.boot.bean;

import java.awt.print.PrinterAbortException;
import java.net.URL;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/14 13:52
 * @Description:
 */
public class Person {
    private String name;
    private Integer age;
    private String img;

    public Person(){
    };

    public Person(String name, Integer age, String url){
        this.age = age;
        this.name = name;
        this.img = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name:'" + name + '\'' +
                "age:'" + age + '\'' +
                '}';
    }



}
