package com.example.testapplication.di.component;


import com.example.testapplication.di.PerActivity;
import com.example.testapplication.di.module.ActivityModule;
import com.example.testapplication.userinterface.MainActivity;
import com.example.testapplication.userinterface.scenario2.Scenario2_Fragment;

import dagger.Component;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(Scenario2_Fragment fragment);


}
