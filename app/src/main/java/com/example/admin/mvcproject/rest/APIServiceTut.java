package com.example.admin.mvcproject.rest;


import com.example.admin.mvcproject.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServiceTut {

    @GET("/my_json")
    Call<List<Student>> getPeopleDetails();

}
