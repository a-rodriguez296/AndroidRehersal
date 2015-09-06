package arf.com.baccus.controller.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import arf.com.baccus.R;
import arf.com.baccus.model.Wine;

/**
 * Created by arodriguez on 9/6/15.
 */
public class WebFragment extends Fragment{

    public static final String ARG_WINE = "wine_extra";

    private static final String STATE_URL= "url";

    //Vistas
    private WebView mBrowser = null;
    private ProgressBar mProgressBar = null;


    //Modelo
    private Wine mWine = null;


    //Con esto se le dice explicitamente al Fragment que debe tener un menú
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Este es como el set contentView del Activity. Como estoy en un fragment se hace así.
        //Como retorna un view, este es el que se va a agregar al container. Por esta razón se pone false como parametro
       View root =   inflater.inflate(R.layout.fragment_web, container, false);


        //Forma de los fragmentos de recibir argumentos
        mWine = (Wine) getArguments().getSerializable(ARG_WINE);

        //Hay que poner root. para buscar las vistas a partir de la raíz

        mBrowser = (WebView) root.findViewById(R.id.browser);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);


        mBrowser.setWebViewClient(new WebViewClient(){


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                mProgressBar.setVisibility(View.VISIBLE);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

                mProgressBar.setVisibility(View.GONE);
            }
        });

        mBrowser.getSettings().setJavaScriptEnabled(true);
        mBrowser.getSettings().setBuiltInZoomControls(true);


        if (savedInstanceState == null || !savedInstanceState.containsKey(STATE_URL)){
            mBrowser.loadUrl(mWine.getCompanyWeb());
        }
        else{
            mBrowser.loadUrl(savedInstanceState.getString(STATE_URL));
        }




        return root;
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_URL, mBrowser.getUrl());
    }

    //Menu forma Fragment

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_web, menu);
    }


    //Menu Forma Activity
 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_web, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menu_reload){
            mBrowser.reload();
        }

        return true;
    }
}
