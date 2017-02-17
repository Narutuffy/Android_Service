package com.example.vamsirao.services;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Popup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popup);

        /*VideoView videoView=(VideoView)findViewById(R.id.video_view);
        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //specify the location of media file
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.coke_ad);
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
*/
//--------------------------------------------------------------------
        String s = "";

        try {
            InputStream inputStream = this.openFileInput("adNum.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                s = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            s="1";
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("adNum.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(s);
                outputStreamWriter.close();
            }
            catch (IOException f) {
                Log.e("Exception", "File write failed: " + f.toString());
            }
        } catch (IOException f) {
            Log.e("login activity", "Can not read file: " + f.toString());
        }

        VideoView videoView=(VideoView)findViewById(R.id.video_view);
        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //specify the location of media file
        String ad="ad"+s;
        Resources res = this.getResources();
        int vid = res.getIdentifier(ad, "raw", this.getPackageName());
        Uri uri= Uri.parse("android.resource://"+getPackageName()+"/"+vid);
        //Setting Mediacontroller and URI, then starting the Video View
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        mediaController.setVisibility(View.GONE);
        MediaPlayer mp = MediaPlayer.create(this, uri);
        int duration = mp.getDuration();
        int adN=Integer.parseInt(s)+1;
        if(adN>2)
            adN=1;
        s=Integer.toString(adN);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("adNum.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(s);
            outputStreamWriter.close();
        }
        catch (IOException f) {
            Log.e("Exception", "File write failed: " + f.toString());
        }
        //  videoView.setMediaController(null);
        videoView.start();
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
                System.exit(0);
            }
        },duration);
    }
}