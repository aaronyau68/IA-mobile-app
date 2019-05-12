package com.example.chesterwong.iaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.Timer;
import java.util.TimerTask;

public class addToGoogleExcel extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_google_excel);
        Intent ii = this.getIntent();
        String urlString = "https://script.google.com/macros/s/AKfycbwuRsvwZktXueyR5WPwwZhiaoAv3lsxjgkRAPcFcLkQcPu8HBLO/exec?";
        urlString+="date="+ii.getStringExtra("date")+"&" ;
        urlString+="time="+ii.getStringExtra("time")+"&" ;
        urlString+="color="+ii.getStringExtra("color")+"&" ;
        urlString+="shape="+ii.getStringExtra("shape")+"&" ;
        urlString+="quantity="+ii.getStringExtra("quantity")+"&" ;
        urlString+="exercise="+ii.getStringExtra("exercise");
         webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(urlString);

        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                webView.destroy();
            }
        }, 8000); */
        // Intent iii = new Intent(addToGoogleExcel.this,MainActivity.class);

        //startActivity(iii);// 開始跳往add record page
    }

}
