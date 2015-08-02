package com.example.jleung.testapplication.main.service;

import com.example.jleung.testapplication.main.model.User;
import com.example.jleung.testapplication.main.service.event.ErrorEvent;
import com.example.jleung.testapplication.main.service.event.UserLoadedEvent;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GithubUserService {

    public static final String BASE_URL = "https://api.github.com";

    private GithubEndpointInterface githubUserService;
    EventBus eventBus = EventBus.getDefault();

    public GithubUserService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        githubUserService = restAdapter.create(GithubEndpointInterface.class);
    }

    public void getUser(String username) {
        githubUserService.getUser(username, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                User u = user;
                eventBus.post(new UserLoadedEvent(user));
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                eventBus.post(new ErrorEvent(retrofitError));
                // Log error here since request failed
            }
        });
    }

}
