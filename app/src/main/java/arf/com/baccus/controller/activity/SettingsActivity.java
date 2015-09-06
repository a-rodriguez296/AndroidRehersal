package arf.com.baccus.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import arf.com.baccus.R;

/**
 * Created by arodriguez on 9/2/15.
 */
public class SettingsActivity extends Activity {


    public static final String EXTRA_WINE_IMAGE_SCALE_TYPE = "image_scale_type";

    //Vistas
    private RadioGroup mRadioGroup = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);





        mRadioGroup = (RadioGroup) findViewById(R.id.scale_type_radio);

        if (getIntent().getSerializableExtra(EXTRA_WINE_IMAGE_SCALE_TYPE).equals(ImageView.ScaleType.FIT_XY)){
            mRadioGroup.check(R.id.fit_radio);
        }
        else{
            mRadioGroup.check(R.id.centered_radio);
        }


        Button cancelButton = (Button) findViewById(R.id.btn_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancelSettings();

            }
        });
        Button saveButton = (Button) findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveSettings();

            }
        });

    }




    private void  saveSettings(){

        Intent config = new Intent();
        if ( mRadioGroup.getCheckedRadioButtonId() == R.id.fit_radio){
            config.putExtra(EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_XY);
        }
        else if(mRadioGroup.getCheckedRadioButtonId() == R.id.centered_radio){
            config.putExtra(EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_CENTER);
        }

        setResult(RESULT_OK,config);
        finish();

    }


    private void cancelSettings(){


        //Esto es para hacer dismiss del modal
        setResult(RESULT_CANCELED);
        finish();

    }

}


