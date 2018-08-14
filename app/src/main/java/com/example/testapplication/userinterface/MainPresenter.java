package com.example.testapplication.userinterface;


import com.example.testapplication.userinterface.base.BasePresenter;
import com.example.testapplication.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;



public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(
            SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }


}
