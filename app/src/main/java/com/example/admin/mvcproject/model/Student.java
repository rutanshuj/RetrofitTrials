package com.example.admin.mvcproject.model;

public class Student {

    private String name;
    private String address;
    private int mobile;

    public Student(String name, String address, int mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
