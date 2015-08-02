package com.example.jleung.testapplication.main.service.event;

import retrofit.RetrofitError;

public class ErrorEvent {

    RetrofitError retrofitError;

    public ErrorEvent(RetrofitError retrofitError) {
            this.retrofitError = retrofitError;
    }

    public RetrofitError getRetrofitError() {
        return retrofitError;
    }
}
