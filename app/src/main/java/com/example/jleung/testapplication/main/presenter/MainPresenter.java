package com.example.jleung.testapplication.main.presenter;


import com.example.jleung.testapplication.main.service.event.ErrorEvent;
import com.example.jleung.testapplication.main.service.event.UserLoadedEvent;

public interface MainPresenter {

    void onItemClick(String username);

    void onEvent(UserLoadedEvent userLoadedEvent);

    void onEvent(ErrorEvent errorEvent);

    void onCreate();

    void onDestroy();
}
