package com.example.vamsirao.services;

import android.app.Service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Vamsi Rao on 1/21/2017.
 */

public class Background extends Service {

    private static Timer timer = new Timer();
    Intent intent= new Intent();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.scheduleAtFixedRate(new mainTask(),0,60000);
       Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service is Destroyed",Toast.LENGTH_LONG).show();

    }

    private class mainTask extends TimerTask{

        @Override
        public void run() {

            intent.setClass(Background.this,Popup.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
