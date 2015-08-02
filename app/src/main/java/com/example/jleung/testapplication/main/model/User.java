package com.example.jleung.testapplication.main.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("login")
    String login;

    @SerializedName("id")
    String id;

    @SerializedName("avatar_url")
    String avatarUrl;

    @SerializedName("gravatar_id")
    String gravatarId;

    @SerializedName("repos_url")
    String reposUrl;

    @SerializedName("name")
    String name;

    @SerializedName("location")
    String location;

    public User(String login, String id, String avatarUrl, String gravatarId, String reposUrl,
                String name, String location) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.reposUrl = reposUrl;
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

}
