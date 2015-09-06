package arf.com.baccus.controller.activity;

import android.support.v4.app.Fragment;

import arf.com.baccus.controller.fragment.WineryFragment;

public class WineryActivity extends FragmentContainerActivity
{


    @Override
    protected Fragment createFragment() {
        return new WineryFragment();
    }
}

