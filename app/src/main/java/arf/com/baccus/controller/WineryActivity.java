package arf.com.baccus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


import arf.com.baccus.R;
import arf.com.baccus.model.Wine;

public class WineryActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winery);

        Wine vegabal = new Wine("Vegaval","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);
        Wine bembibre = new Wine("Bembibre","Tinto",R.drawable.logo_facebook,"Bembibre", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);


        //Esto funciona pq el id del contenedor padre del xml es tipo tabhost
        TabHost tabhost = getTabHost();


        Intent intentVegabal = new Intent(this, WineActivity.class);
        intentVegabal.putExtra(WineActivity.EXTRA_WINE, vegabal);

        //Esto es el código de la pestañan

        TabHost.TabSpec specVegabal = tabhost.
                newTabSpec(vegabal.getName()).
                setIndicator(vegabal.getName()).
                setContent(intentVegabal);


        tabhost.addTab(specVegabal);


        //Tab Bembibre

        Intent intentBembibre = new Intent(this, WineActivity.class);
        intentBembibre.putExtra(WineActivity.EXTRA_WINE, bembibre);

        TabHost.TabSpec specBembibre = tabhost.
                newTabSpec(bembibre.getName()).
                setIndicator(bembibre.getName()).
                setContent(intentBembibre);

        tabhost.addTab(specBembibre);





    }

}

