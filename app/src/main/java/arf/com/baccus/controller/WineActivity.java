package arf.com.baccus.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import arf.com.baccus.R;
import arf.com.baccus.model.Wine;


public class WineActivity extends Activity {

    //Vistas
    private ImageView mWineImage = null;
    private TextView mWineName = null;
    private TextView mWineTypeText = null;
    private TextView mWineOriginText = null;
    private RatingBar mWineRating = null;
    private TextView mWineCompanyText = null;
    private TextView mWineNotesText = null;
    private ViewGroup mWineGrapesContainer = null;
    private Button mGoToWeb = null;


    //Modelo
    private Wine mWine = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);


        Log.v("Baccus", "Hola mundo");

        mWineImage = (ImageView) findViewById(R.id.wine_image);
        mWine = new Wine("Vegaval","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);

        //Añadir tipos de uvas
        mWine.addGrape("Mencía");


        //Inicializar las vistas
        mWineImage = (ImageView) findViewById(R.id.wine_image);
        mWineName = (TextView) findViewById(R.id.wine_name);
        mWineTypeText = (TextView) findViewById(R.id.wine_type);
        mWineOriginText = (TextView) findViewById(R.id.wine_origin);
        mWineRating = (RatingBar) findViewById(R.id.wine_rating_bar);
        mWineCompanyText = (TextView) findViewById(R.id.wine_company);
        mWineNotesText = (TextView) findViewById(R.id.wine_notes);
        mWineGrapesContainer = (ViewGroup) findViewById(R.id.grapes_container);
        mGoToWeb = (Button) findViewById(R.id.go_to_web);


        //Dar los valores
        mWineImage.setImageResource(mWine.getPhoto());
        mWineName.setText(mWine.getName());
        mWineTypeText.setText(mWine.getType());
        mWineOriginText.setText(mWine.getOrigin());
        mWineRating.setRating(mWine.getRating());
        mWineCompanyText.setText(mWine.getCompanyName());
        mWineNotesText.setText(mWine.getName());



        //Actualizar lista de uvas
        for (int i = 0; i<mWine.getGrapesCount();i++){

            TextView textView = new TextView(this);
            textView.setText(mWine.getGrape(i));
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            mWineGrapesContainer.addView(textView);

        }


        //Configurar botón
        mGoToWeb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(WineActivity.this, WebActivity.class);
                webIntent.putExtra(WebActivity.EXTRA_WINE, mWine);
                startActivity(webIntent);
            }
        });
    }

    public void changeImage(View v){

        mWineImage.setImageResource(mWine.getPhoto());
    }
}
