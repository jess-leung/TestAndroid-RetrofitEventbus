package com.example.jleung.testapplication.main.presenter;

import com.example.jleung.testapplication.main.model.User;
import com.example.jleung.testapplication.main.service.event.ErrorEvent;
import com.example.jleung.testapplication.main.service.GithubUserService;
import com.example.jleung.testapplication.main.service.event.UserLoadedEvent;
import com.example.jleung.testapplication.main.view.MainView;

import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;

public class MainPresenterImpl implements MainPresenter {

    MainView mainView;
    EventBus eventBus = EventBus.getDefault();
    private GithubUserService githubUserService = new GithubUserService();


    public MainPresenterImpl(MainView view) {
        mainView = view;
    }

    public void onCreate() {
        eventBus.register(this);
    }

    public void onDestroy() {
        eventBus.unregister(this);
        eventBus = null;
    }

    @Override
    public void onItemClick(String username) {
        githubUserService.getUser(username);
    }

    public void onEvent(UserLoadedEvent userLoadedEvent) {
        User user = userLoadedEvent.getUser();
        mainView.changeText(user.getName());
    }

    public void onEvent(ErrorEvent errorEvent) {
        RetrofitError retrofitError = errorEvent.getRetrofitError();
        // do something with error
    }
}
