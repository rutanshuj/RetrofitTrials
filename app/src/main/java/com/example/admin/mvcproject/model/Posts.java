package com.example.admin.mvcproject.model;


import com.google.gson.annotations.SerializedName;

public class Posts {
    @SerializedName("userId")
    private Integer user_id;
    @SerializedName("id")
    private Integer p_id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public Posts(Integer user_id, Integer p_id, String title, String body) {
        this.user_id = user_id;
        this.p_id = p_id;
        this.title = title;
        this.body = body;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
