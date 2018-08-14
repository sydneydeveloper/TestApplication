package com.example.testapplication.di.component;

import android.app.Application;
import android.content.Context;

import com.example.testapplication.TestApplication;

import com.example.testapplication.di.ApplicationContext;
import com.example.testapplication.di.module.ApplicationModule;


import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(TestApplication app);

    @ApplicationContext
    Context context();

    Application application();

}