package com.example.testapplication.di.module;

import android.app.Application;
import android.content.Context;

import com.example.testapplication.di.ApplicationContext;


import dagger.Module;
import dagger.Provides;




@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}
