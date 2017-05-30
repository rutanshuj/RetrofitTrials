package com.example.admin.mvcproject.rest;


import com.example.admin.mvcproject.model.Posts;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostsInterface {

    @POST("/posts")
    @FormUrlEncoded
    Call<Posts> savePost(@Field("userId") int userId,
                         @Field("id") int id,
                         @Field("title") String title,
                         @Field("body") String body);
}
