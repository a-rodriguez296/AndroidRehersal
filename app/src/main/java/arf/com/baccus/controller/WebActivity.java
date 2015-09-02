package arf.com.baccus.controller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
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
public class WebActivity extends Activity {



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

}
