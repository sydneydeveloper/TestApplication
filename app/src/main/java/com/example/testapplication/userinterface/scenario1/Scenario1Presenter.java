

package com.example.testapplication.userinterface.scenario1;


import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.testapplication.userinterface.base.BasePresenter;
import com.example.testapplication.utils.ApiEndPoint;
import com.example.testapplication.utils.SessionItem;
import com.example.testapplication.utils.rx.SchedulerProvider;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class Scenario1Presenter<V extends Scenario1MvpView> extends BasePresenter<V>
        implements Scenario1MvpPresenter<V> {

    private static final String TAG = "MyFragmentPresenter";



    @Inject
    public Scenario1Presenter(SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }



}
