package com.example.jleung.testapplication.main.service;

import com.example.jleung.testapplication.main.model.User;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GithubEndpointInterface {

    @GET("/users/{username}")
    void getUser(@Path("username") String username, Callback<User> cb);

}
