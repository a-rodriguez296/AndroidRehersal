package arf.com.baccus.controller;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import arf.com.baccus.R;
import arf.com.baccus.model.Wine;

/**
 * Created by arodriguez on 9/1/15.
 */


//Para poder el verl menu hay que heredar de AppCompactActivity. DLC, no se ve
public class WebActivity extends AppCompatActivity {



    private static final String STATE_URL= "url";

    //Vistas
    private WebView mBrowser = null;
    private ProgressBar mProgressBar = null;


    //Modelo
    private Wine mWine = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);

        mWine = new Wine("Vegaval","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com/","adsfasdfadsf1","Valdepeñas",3);


        mBrowser = (WebView) findViewById(R.id.browser);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


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



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_URL, mBrowser.getUrl());
    }



    //Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menu_reload){
            mBrowser.reload();
        }

        return true;
    }
}
