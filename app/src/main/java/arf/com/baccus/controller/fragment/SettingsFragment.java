package arf.com.baccus.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import arf.com.baccus.R;
import arf.com.baccus.controller.activity.SettingsActivity;

/**
 * Created by arodriguez on 9/6/15.
 */
public class SettingsFragment extends Fragment {



    public static final String ARG_WINE_IMAGE_SCALE_TYPE = "image_scale_type";

    //Vistas
    private RadioGroup mRadioGroup = null;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View root = inflater.inflate(R.layout.fragment_settings, container, false);


        mRadioGroup = (RadioGroup) root.findViewById(R.id.scale_type_radio);

        if (getArguments().getSerializable(ARG_WINE_IMAGE_SCALE_TYPE).equals(ImageView.ScaleType.FIT_XY)){
            mRadioGroup.check(R.id.fit_radio);
        }
        else{
            mRadioGroup.check(R.id.centered_radio);
        }


        Button cancelButton = (Button) root.findViewById(R.id.btn_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancelSettings();

            }
        });
        Button saveButton = (Button) root.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveSettings();

            }
        });

        return root;

    }

    private void  saveSettings(){

        Intent config = new Intent();
        if ( mRadioGroup.getCheckedRadioButtonId() == R.id.fit_radio){
            config.putExtra(SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_XY);
        }
        else if(mRadioGroup.getCheckedRadioButtonId() == R.id.centered_radio){
            config.putExtra(SettingsActivity.EXTRA_WINE_IMAGE_SCALE_TYPE, ImageView.ScaleType.FIT_CENTER);
        }

        getActivity().setResult(Activity.RESULT_OK, config);
        getActivity().finish();

    }


    private void cancelSettings(){


        //Esto es para hacer dismiss del modal
        getActivity().setResult(Activity.RESULT_CANCELED);
        getActivity().finish();

    }

}
