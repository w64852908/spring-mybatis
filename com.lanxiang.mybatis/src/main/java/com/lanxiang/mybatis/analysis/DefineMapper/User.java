package com.lanxiang.mybatis.analysis.definemapper;

/**
 * Created by lanxiang on 2017/3/25.
 */
public class User {

    private Integer id;

    private String name;

    private int age;

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
