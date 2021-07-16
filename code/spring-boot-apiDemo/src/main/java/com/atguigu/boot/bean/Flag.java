package com.atguigu.boot.bean;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @Author: Yiming Yang
 * @Edition: V1.0
 * @CreateDate: 2021/7/17 1:01
 * @Description:
 */
public class Flag {
    private boolean flag;

    public Flag(boolean flag){
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {
        return flag;
    }
}
