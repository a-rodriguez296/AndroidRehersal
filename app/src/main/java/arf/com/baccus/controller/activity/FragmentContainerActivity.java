package arf.com.baccus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import arf.com.baccus.R;


public abstract class FragmentContainerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);


        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);


        //Averiguar si existe el fragment
        if (fragment == null){
            fragment = createFragment();

            //Añadir el fragment al fragment_container
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }



        Toolbar toolBar = (Toolbar)findViewById(R.id.toolbar);
        toolBar.setTitle("Baccus");
        setSupportActionBar(toolBar);

    }

    protected abstract Fragment createFragment();
}


