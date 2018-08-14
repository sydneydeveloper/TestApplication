package com.example.testapplication.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;


import com.example.testapplication.di.ActivityContext;
import com.example.testapplication.di.PerActivity;
import com.example.testapplication.userinterface.MainMvpPresenter;
import com.example.testapplication.userinterface.MainMvpView;
import com.example.testapplication.userinterface.MainPresenter;
import com.example.testapplication.userinterface.scenario2.Scenario2MvpPresenter;
import com.example.testapplication.userinterface.scenario2.Scenario2MvpView;
import com.example.testapplication.userinterface.scenario2.Scenario2Presenter;
import com.example.testapplication.utils.rx.AppSchedulerProvider;
import com.example.testapplication.utils.rx.SchedulerProvider;


import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;



@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
                    MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    Scenario2MvpPresenter<Scenario2MvpView> provideScenario2Presenter(
            Scenario2Presenter<Scenario2MvpView> presenter) {
        return presenter;
    }


}
