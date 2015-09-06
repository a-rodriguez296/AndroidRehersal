package arf.com.baccus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import arf.com.baccus.controller.fragment.WebFragment;

/**
 * Created by arodriguez on 9/1/15.
 */


//Para poder el verl menu hay que heredar de AppCompactActivity. DLC, no se ve
public class WebActivity extends FragmentContainerActivity {


    public static final String EXTRA_WINE = "wine_extra";


    @Override
    protected Fragment createFragment() {

        Bundle arguments = new Bundle();

        //Le paso a web fragment el extra que me llega como paramentro
        arguments.putSerializable(WebFragment.ARG_WINE, getIntent().getSerializableExtra(EXTRA_WINE));


        WebFragment webFragment = new WebFragment();
        webFragment.setArguments(arguments);

        return webFragment;
    }
}
