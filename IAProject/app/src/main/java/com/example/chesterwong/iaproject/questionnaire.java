package com.example.chesterwong.iaproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Aaron on 27/12/2017.
 */

public class questionnaire extends Activity {

    WebView webview;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_view);
        webview = (WebView)findViewById(R.id.webView);
        btnBack = (Button)findViewById(R.id.btnBack);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        webview .loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdnPLbrYYkvKysm35dLA9y-l-H_dbsqUaahXYkFf8Ox_22OMg/viewform"); //before

    }
    public void back(View view){
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }
}
