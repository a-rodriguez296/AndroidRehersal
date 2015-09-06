package arf.com.baccus.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
import arf.com.baccus.controller.activity.SettingsActivity;
import arf.com.baccus.controller.activity.WebActivity;
import arf.com.baccus.model.Wine;

/**
 * Created by arodriguez on 9/6/15.
 */
public class WineFragment extends Fragment{


    private static final int SETTINGS_REQUEST = 1;
    private static final String STATE_IMAGE_SCALE_TYPE = "STATE_IMAGE_SCALE_TYPE";

    //Clave para vino que llega por parametro
    public static final String ARG_WINE = "extra_wine";


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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View root =   inflater.inflate(R.layout.fragment_wine, container, false);


        mWineImage = (ImageView) root.findViewById(R.id.wine_image);

        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_IMAGE_SCALE_TYPE)){

            mWineImage.setScaleType((ImageView.ScaleType) savedInstanceState.getSerializable(STATE_IMAGE_SCALE_TYPE));
        }

        mWine = (Wine) getArguments().getSerializable(ARG_WINE);



        //Añadir tipos de uvas
        mWine.addGrape("Mencía");


        //Inicializar las vistas
        mWineImage = (ImageView) root.findViewById(R.id.wine_image);
        mWineName = (TextView) root.findViewById(R.id.wine_name);
        mWineTypeText = (TextView) root.findViewById(R.id.wine_type);
        mWineOriginText = (TextView) root.findViewById(R.id.wine_origin);
        mWineRating = (RatingBar) root.findViewById(R.id.wine_rating_bar);
        mWineCompanyText = (TextView) root.findViewById(R.id.wine_company);
        mWineNotesText = (TextView) root.findViewById(R.id.wine_notes);
        mWineGrapesContainer = (ViewGroup) root.findViewById(R.id.grapes_container);
        mGoToWeb = (Button) root.findViewById(R.id.go_to_web);


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

            TextView textView = new TextView(getActivity());
            textView.setText(mWine.getGrape(i));
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            mWineGrapesContainer.addView(textView);

        }


        /*Si en vez de llamar al onClick del botón se hubiera hecho en un método afuera, la aplicación
        fallaría, dado que el SO busca el método en una actividad y esto es un Fragment*/


        //Configurar botón
        mGoToWeb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(getActivity(), WebActivity.class);
                webIntent.putExtra(WebActivity.EXTRA_WINE, mWine);
                startActivity(webIntent);
            }
        });


        return root;
    }

    public void changeImage(View v){

        mWineImage.setImageResource(mWine.getPhoto());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_wine, menu);
    }


    //Menu

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wine, menu);

        return true;

    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menu_settings) {

            //Un fragment no puede ser un contexto. Por esa razón es que hay que hacer getActivity y no WineActivity.this
            Intent settingsIntent = new Intent(getActivity(), SettingsActivity.class);
            settingsIntent.putExtra(SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE, mWineImage.getScaleType());
            startActivityForResult(settingsIntent, SETTINGS_REQUEST);

            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Result_OK no existe en fragment. Por eso hay que hacer Activity.RESULT_OK
        if (requestCode == SETTINGS_REQUEST && resultCode == Activity.RESULT_OK){

            ImageView.ScaleType scaleType = (ImageView.ScaleType) data.getSerializableExtra(SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE);
            mWineImage.setScaleType(scaleType);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putSerializable(STATE_IMAGE_SCALE_TYPE, mWineImage.getScaleType());
    }

}
