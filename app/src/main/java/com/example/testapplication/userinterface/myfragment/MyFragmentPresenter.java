

package com.example.testapplication.userinterface.myfragment;


import com.example.testapplication.userinterface.base.BasePresenter;
import com.example.testapplication.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class MyFragmentPresenter<V extends MyFragmentMvpView> extends BasePresenter<V>
        implements MyFragmentMvpPresenter<V> {

    private static final String TAG = "MyFragmentPresenter";



    @Inject
    public MyFragmentPresenter(SchedulerProvider schedulerProvider,
                               CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }



}
