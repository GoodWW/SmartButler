package com.xunman.smartbutler.entity;

import cn.bmob.v3.BmobUser;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/13 0013 11:25
 * 包名：com.xunman.smartbutler.entity
 * 文件名： ${name}
 * 描述：  用户属性
 */

public class MyUser extends BmobUser {
    private int age;
    //性别  true代表是男  false代表是女3
    private boolean sex;
    //描述
    private String desc;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
