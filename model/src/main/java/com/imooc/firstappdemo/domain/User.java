package com.imooc.firstappdemo.domain;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * 用户模型
 */
public class User {

    private int id;

    /**
     * 用户的名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString可以方便调试
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
