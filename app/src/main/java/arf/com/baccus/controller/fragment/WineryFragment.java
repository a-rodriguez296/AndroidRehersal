package arf.com.baccus.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arf.com.baccus.R;
import arf.com.baccus.controller.adapter.WineryPagerAdapter;


/**
 * Created by arodriguez on 9/6/15.
 */
public class WineryFragment extends Fragment {


    private ViewPager mPager = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root =  inflater.inflate(R.layout.fragment_winery, container, false);

        mPager = (ViewPager) root.findViewById(R.id.pager);
        mPager.setAdapter(new WineryPagerAdapter(getFragmentManager()));


        /*Winery winery = Winery.getInstance();

        Wine vegabal = winery.getWine(0);
        Wine bembibre = winery.getWine(1);



        //Obtener referencia al tabHost

        FragmentTabHost tabHost = (FragmentTabHost) root.findViewById(android.R.id.tabhost);
        tabHost.setup(getActivity(), getActivity().getSupportFragmentManager(), android.R.id.tabcontent);

        //Primera pestaña
        Bundle arguments = new Bundle();
        arguments.putSerializable(WineFragment.ARG_WINE, bembibre);
        tabHost.addTab(tabHost.newTabSpec(bembibre.getName()).
                setIndicator(bembibre.getName()), WineFragment.class, arguments);



        //Segunda pestaña
        arguments = new Bundle();
        arguments.putSerializable(WineFragment.ARG_WINE, vegabal);
        tabHost.addTab(tabHost.newTabSpec(vegabal.getName()).
                setIndicator(vegabal.getName()), WineFragment.class, arguments);*/

        return root;
    }
}
