package arf.com.baccus.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arf.com.baccus.R;
import arf.com.baccus.controller.adapter.WineryPagerAdapter;
import arf.com.baccus.model.Winery;


/**
 * Created by arodriguez on 9/6/15.
 */
public class WineryFragment extends Fragment implements ViewPager.OnPageChangeListener{


    private ViewPager mPager = null;
    private ActionBar mActionBar = null;
    private Winery mWinery = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root =  inflater.inflate(R.layout.fragment_winery, container, false);

        mWinery = Winery.getInstance();

        mPager = (ViewPager) root.findViewById(R.id.pager);
        mPager.setAdapter(new WineryPagerAdapter(getFragmentManager()));

        mActionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        mPager.setOnPageChangeListener(this);

        updateActionBar(0);


        return root;
    }

    private void updateActionBar(int index){

        mActionBar.setTitle(mWinery.getWine(index).getName());
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        updateActionBar(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
