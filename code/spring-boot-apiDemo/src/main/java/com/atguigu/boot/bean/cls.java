package com.atguigu.boot.bean;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/17 2:31
 * @Description:
 */
public class cls {
    private String cname;
    private String trainer;
    private int num;
    private int price;

    public cls(String name, String trainer, int num, int price){
        this.cname = name;
        this.trainer = trainer;
        this.num = num;
        this.price = price;
    }

    public void setCname(String name) {
        this.cname = name;
    }

    public String getName() {
        return cname;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
