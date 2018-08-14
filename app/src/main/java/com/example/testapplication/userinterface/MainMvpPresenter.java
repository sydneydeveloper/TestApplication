package com.example.testapplication.userinterface;


import com.example.testapplication.di.PerActivity;
import com.example.testapplication.userinterface.base.MvpPresenter;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {


}
