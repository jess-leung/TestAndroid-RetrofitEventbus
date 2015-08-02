package com.example.jleung.testapplication.main.service.event;

import com.example.jleung.testapplication.main.model.User;

public class UserLoadedEvent {

    private User user;

    public UserLoadedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
