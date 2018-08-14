package com.example.testapplication.userinterface.scenario2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testapplication.R;
import com.example.testapplication.di.component.ActivityComponent;
import com.example.testapplication.userinterface.base.BaseFragment;
import com.example.testapplication.utils.SessionItem;

import org.json.JSONObject;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@SuppressLint("NewApi")
public class Scenario2_Fragment  extends BaseFragment implements
		Scenario2MvpView, AdapterView.OnItemSelectedListener {

	private static final String TAG = "OpenSourceFragment";

	@Inject
	Scenario2MvpPresenter<Scenario2MvpView> mPresenter;

    @BindView(R.id.spinner1)
    Spinner spinner;

    @BindView(R.id.car)
	TextView car;

	@BindView(R.id.train)
	TextView train;

	@BindView(R.id.navigate)
	Button navigate;

	public static Scenario2_Fragment newInstance() {
		Bundle args = new Bundle();
		Scenario2_Fragment fragment = new Scenario2_Fragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.scenario2_fragment, container, false);

		ActivityComponent component = getActivityComponent();
		if (component != null) {
			component.inject(this);
			setUnBinder(ButterKnife.bind(this, rootView));
			mPresenter.onAttach(this);
		}
        return rootView;
	}

	@Override
	protected void setUp(View v) {
		mPresenter.onViewPrepared();

	}

	@Override
	public void updateList(List v){
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, v);
        spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		handleModeOfTransport(0);
	}

	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		handleModeOfTransport(position);
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {

	}

	private void handleModeOfTransport(int position){

		try {
			System.out.println();
			car.setText("");
			train.setText("");
			JSONObject obj =SessionItem.getArray().getJSONObject(position).getJSONObject("fromcentral");
			String carTime =obj.get("car").toString();
			if(carTime!=null) {
				car.setText("Car - " + carTime);
			}

			String trainTime = obj.get("train").toString();
			if(trainTime!=null){
				train.setText("Train - " + trainTime);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}


	@OnClick(R.id.navigate)
	public void navigateClicked(){
		try {
			JSONObject obj =  SessionItem.getArray().getJSONObject(spinner.getSelectedItemPosition()).getJSONObject("location");
			double latitude =(Double)obj.get("latitude");
			double longitude = (Double)obj.get("longitude");
			String label = spinner.getSelectedItem().toString();
			String uriBegin = "geo:" + latitude + "," + longitude;
			String query = latitude + "," + longitude + "(" + label + ")";
			String encodedQuery = Uri.encode(query);
			String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
			Uri uri = Uri.parse(uriString);
			Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
			startActivity(mapIntent);

		}catch (Exception ex){
			ex.printStackTrace();
		}
	}


}
