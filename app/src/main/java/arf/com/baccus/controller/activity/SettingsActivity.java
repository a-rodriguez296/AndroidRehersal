package arf.com.baccus.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import arf.com.baccus.R;
import arf.com.baccus.controller.fragment.SettingsFragment;

/**
 * Created by arodriguez on 9/2/15.
 */
public class SettingsActivity extends FragmentContainerActivity {


    public static final String EXTRA_WINE_IMAGE_SCALE_TYPE = "image_scale_type";


    @Override
    protected Fragment createFragment() {

        Bundle arguments = new Bundle();
        //Pongo en el key ARG_WINE_IMAGE_SCALE_TYPE, el valor que me llega en el intent en el key EXTRA_WINE_IMAGE_SCALE_TYPE
        arguments.putSerializable(SettingsFragment.ARG_WINE_IMAGE_SCALE_TYPE, getIntent().getSerializableExtra(EXTRA_WINE_IMAGE_SCALE_TYPE));

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(arguments);

        return fragment;
    }
}


