package com.lanxiang.spring.model;

/**
 * Created by lanxiang on 2017/4/13.
 */

public class User {

    private int id;

    private String name;

    private int grade;

    public User(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public User() {
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
