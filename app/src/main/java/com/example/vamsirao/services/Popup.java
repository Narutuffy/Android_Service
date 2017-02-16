package com.example.vamsirao.services;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Popup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popup);

        VideoView videoView=(VideoView)findViewById(R.id.video_view);
        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //specify the location of media file
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ad1);
        //Setting Mediacontroller and URI, then starting the Video View
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        mediaController.setVisibility(View.GONE);
        MediaPlayer mp = MediaPlayer.create(this, uri);
        int duration = mp.getDuration();

      //  videoView.setMediaController(null);
        videoView.start();


        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },duration);
    }
}
