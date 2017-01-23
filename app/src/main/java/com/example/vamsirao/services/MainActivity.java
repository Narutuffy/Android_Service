package com.example.vamsirao.services;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startService(View view){
//        startService(new Intent(getBaseContext(),Background.class));
        Intent intent= new Intent(MainActivity.this,Broadcast.class);
        //performing a broadcast with pnding intent
        PendingIntent pendingIntent= PendingIntent.getBroadcast(
                                        this.getApplicationContext(),7777,intent,0);

        AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,pendingIntent);
        Toast.makeText(this,"Alarm set in 10 secs",Toast.LENGTH_SHORT).show();
    }

  /*  public void stopService(View view){
        stopService(new Intent(MainActivity.this,Background.class));
    }
*/
}
