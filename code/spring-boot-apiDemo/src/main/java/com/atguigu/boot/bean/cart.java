package com.atguigu.boot.bean;

import java.util.List;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/17 2:25
 * @Description:
 */
public class cart {
    private String name;
    private List<cls> arr;

    public cart(String name, List<cls> arr){
        this.name = name;
        this.arr = arr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArr(List<cls> arr) {
        this.arr = arr;
    }

    public List<cls> getArr() {
        return arr;
    }
}
