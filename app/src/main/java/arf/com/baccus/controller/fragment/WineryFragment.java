package arf.com.baccus.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import arf.com.baccus.R;
import arf.com.baccus.controller.activity.WineActivity;
import arf.com.baccus.model.Wine;

/**
 * Created by arodriguez on 9/6/15.
 */
public class WineryFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root =  inflater.inflate(R.layout.activity_winery, container, false);



        Wine vegabal = new Wine("Vegaval","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);
        Wine bembibre = new Wine("Bembibre","Tinto",R.drawable.logo_facebook,"Bembibre", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);


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
                setIndicator(vegabal.getName()), WineFragment.class, arguments);

        return root;
    }
}
