package com.example.testapplication.userinterface.scenario1;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentActivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapplication.userinterface.myfragment.MyFragment;
import com.example.testapplication.R;
import com.example.testapplication.userinterface.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.relex.circleindicator.CircleIndicator;


@SuppressLint("NewApi")
public class Scenario1_Fragment extends BaseFragment implements View.OnClickListener, Scenario1MvpView {

	TabLayout tabLayout;
	MyPageAdapter pageAdapter;
	TextView nameOfTab;
	Button redBtn;
	Button blueBtn;
	Button greenBtn;
	RelativeLayout colorLayout;

    @Inject
    Scenario1MvpPresenter<Scenario1MvpView> mPresenter;

	public static Scenario1_Fragment newInstance() {
		Bundle args = new Bundle();
		Scenario1_Fragment fragment = new Scenario1_Fragment();
		fragment.setArguments(args);
		return fragment;
	}

    @Override
    protected void setUp(View v) {


    }

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {
		View rootView = inflater
				.inflate(R.layout.scenario1_fragment, container, false);

		tabLayout = rootView.findViewById(R.id.tabs);
        nameOfTab = rootView.findViewById(R.id.nameOfTab);
        redBtn = rootView.findViewById(R.id.redBtn);
        blueBtn = rootView.findViewById(R.id.blueBtn);
        greenBtn = rootView.findViewById(R.id.greenBtn);
        colorLayout = rootView.findViewById(R.id.colorlayout);


		tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab4"));
		tabLayout.addTab(tabLayout.newTab().setText("Tab5"));

		tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				nameOfTab.setText("Tab selected is " + tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});

		List<android.support.v4.app.Fragment> fragments = getFragments();


		pageAdapter = new MyPageAdapter(getBaseActivity().getSupportFragmentManager(), fragments);

		ViewPager pager = (ViewPager)rootView.findViewById(R.id.viewpager);
		pager.setAdapter(pageAdapter);



		CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);

		indicator.setViewPager(pager);

		redBtn.setOnClickListener(this);
		blueBtn.setOnClickListener(this);
		greenBtn.setOnClickListener(this);


		nameOfTab.setText("Tab selected is " + tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText());

		return rootView;
	}


	public void onClick(View v){

		switch (v.getId()){
			case R.id.redBtn:
				colorLayout.setBackgroundColor(getResources().getColor(R.color.red));
				break;
			case R.id.blueBtn:
				colorLayout.setBackgroundColor(getResources().getColor(R.color.blue));
				break;
			case R.id.greenBtn:
				colorLayout.setBackgroundColor(getResources().getColor(R.color.green));
				break;
		}
	}

	private List<android.support.v4.app.Fragment> getFragments(){
		List<android.support.v4.app.Fragment> fList = new ArrayList<android.support.v4.app.Fragment>();

		fList.add(MyFragment.newInstance("Fragment 1"));
		fList.add(MyFragment.newInstance("Fragment 2"));
		fList.add(MyFragment.newInstance("Fragment 3"));
        fList.add(MyFragment.newInstance("Fragment 4"));

		return fList;
	}

	private class MyPageAdapter extends FragmentPagerAdapter {
		private List<android.support.v4.app.Fragment> fragments;

		public MyPageAdapter(FragmentManager fm, List<android.support.v4.app.Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		@Override
		public android.support.v4.app.Fragment getItem(int position) {
			return this.fragments.get(position);
		}

		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}

	/*@Override
	public void onAttach(Activity activity) {
		myContext=(FragmentActivity) activity;
		super.onAttach(activity);
	}*/
}
