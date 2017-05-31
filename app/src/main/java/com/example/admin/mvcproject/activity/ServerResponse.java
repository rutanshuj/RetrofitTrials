package com.example.admin.mvcproject.activity;


import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("message")
    String message;
    @SerializedName("success")
    boolean success;

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
