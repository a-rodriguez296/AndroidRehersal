package arf.com.baccus.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import arf.com.baccus.R;
import arf.com.baccus.model.Wine;


public class WineActivity extends Activity {

    private ImageView mWineImage = null;
    private Wine mWine = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);


        Log.v("Baccus", "Hola mundo");

        mWineImage = (ImageView) findViewById(R.id.wine_image);
        mWine = new Wine("Vegaval","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "","","Valdepeñas",5);
    }

    public void changeImage(View v){

        mWineImage.setImageResource(mWine.getPhoto());
    }
}
