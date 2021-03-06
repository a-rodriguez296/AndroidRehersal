package arf.com.baccus.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import arf.com.baccus.R;
import arf.com.baccus.model.Wine;


public class WineActivity extends AppCompatActivity {

/*    private static final int SETTINGS_REQUEST = 1;
    private static final String STATE_IMAGE_SCALE_TYPE = "STATE_IMAGE_SCALE_TYPE";

    //Clave para vino que llega por parametro
    public static final String EXTRA_WINE = "extra_wine";


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
        setContentView(R.layout.fragment_wine);


        Log.v("Baccus", "Hola mundo");

        mWineImage = (ImageView) findViewById(R.id.wine_image);

        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_IMAGE_SCALE_TYPE)){

            mWineImage.setScaleType((ImageView.ScaleType) savedInstanceState.getSerializable(STATE_IMAGE_SCALE_TYPE));
        }

        mWine = (Wine) getIntent().getSerializableExtra(EXTRA_WINE);



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



    //Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wine, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menu_settings) {


            Intent settingsIntent = new Intent(WineActivity.this, SettingsActivity.class);
            settingsIntent.putExtra(SettingsActivity.ARG_WINE_IMAGE_SCALE_TYPE, mWineImage.getScaleType());
            startActivityForResult(settingsIntent, SETTINGS_REQUEST);

            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SETTINGS_REQUEST && resultCode == RESULT_OK){

            ImageView.ScaleType scaleType = (ImageView.ScaleType) data.getSerializableExtra(SettingsActivity.ARG_WINE_IMAGE_SCALE_TYPE);
            mWineImage.setScaleType(scaleType);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putSerializable(STATE_IMAGE_SCALE_TYPE, mWineImage.getScaleType());
    }*/
}
