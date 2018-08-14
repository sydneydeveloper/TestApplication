

package com.example.testapplication.userinterface.scenario2;


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



public class Scenario2Presenter<V extends Scenario2MvpView> extends BasePresenter<V>
        implements Scenario2MvpPresenter<V> {

    private static final String TAG = "MyFragmentPresenter";



    @Inject
    public Scenario2Presenter(SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        // getMvpView().showLoading();

        getOpenSourceApiCall();

    }


    private void getOpenSourceApiCall() {

         Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response
                        try {

                            List<String> names = new ArrayList<String>();
                            for (int i = 0; i < response.length(); i++) {
                                response.getJSONObject(i);
                                names.add(response.getJSONObject(i).get("name").toString());
                            }


                            SessionItem.setArray(response);
                            getMvpView().updateList(names);

                        }catch(Exception ex){

                        }

                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        System.out.println("error::");
                    }
                });
    }

}
