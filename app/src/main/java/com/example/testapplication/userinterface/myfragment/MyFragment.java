package com.example.testapplication.userinterface.myfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapplication.R;
import com.example.testapplication.userinterface.base.BaseFragment;
import com.example.testapplication.userinterface.scenario1.Scenario1MvpView;

public class MyFragment extends BaseFragment implements MyFragmentMvpView {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	
	public static final MyFragment newInstance(String message)
	{
		MyFragment f = new MyFragment();
		Bundle bdl = new Bundle(1);
	    bdl.putString(EXTRA_MESSAGE, message);
	    f.setArguments(bdl);
	    return f;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		String message = getArguments().getString(EXTRA_MESSAGE);
		View v = inflater.inflate(R.layout.myfragment_layout, container, false);
		TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		messageTextView.setText(message);
		
        return v;
    }

	@Override
	protected void setUp(View v) {


	}
}
