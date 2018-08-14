package com.example.testapplication;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import com.example.testapplication.di.component.ApplicationComponent;
import com.example.testapplication.di.component.DaggerApplicationComponent;
import com.example.testapplication.di.module.ApplicationModule;
import com.example.testapplication.utils.AppLogger;


public class TestApplication extends Application {


    private ApplicationComponent mApplicationComponent;
    private static final String TAG ="TestApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "App creating");
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
        Log.d(TAG, "app create finish");
        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


}
