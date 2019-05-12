package com.example.chesterwong.iaproject;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

/**
 * Created by Aaron on 26/1/2018.
 */

public class playVideoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);

        Button btnVideo = (Button)findViewById(R.id.btnVideo);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        //displays a video file
        VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView1);
        String uriPath2 = "android.resource://com.example.chesterwong.iaproject/"+R.raw.video;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
    //    mVideoView2.start();
        btnVideo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView1);
                // VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.example.chesterwong.iaproject/" + R.raw.video;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });
    }
}
