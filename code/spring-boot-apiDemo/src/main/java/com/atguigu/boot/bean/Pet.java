package com.atguigu.boot.bean;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/14 13:51
 * @Description:
 */
public class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Pet{" +
                "name:'" + name + '\'' +
                '}';
    }
}
