package com.example.vamsirao.services;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main);
        Intent intent= new Intent(MainActivity.this,Broadcast.class);
        //performing a broadcast with PendingIntent
        PendingIntent pendingIntent= PendingIntent.getBroadcast(
                this.getApplicationContext(),0,intent,0);
        long interval= 1*60*1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 60);
        AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),interval,pendingIntent);
        Toast.makeText(this,"Pop-up set in 1min",Toast.LENGTH_SHORT).show();
        finish();
    }



/*    public void startService(View view){
//        startService(new Intent(getBaseContext(),Background.class))
        Intent intent= new Intent(MainActivity.this,Broadcast.class);
        //performing a broadcast with PendingIntent
        PendingIntent pendingIntent= PendingIntent.getBroadcast(
                                        this.getApplicationContext(),0,intent,0);
        long interval= 1*60*1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 60);
        AlarmManager alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),interval,pendingIntent);
        Toast.makeText(this,"Pop-up set in 1min",Toast.LENGTH_SHORT).show();
    }*/

  /*  public void stopService(View view){
        //Creating exactly the same pending intent which was used to broadcast, to cancel
        Intent intent= new Intent(MainActivity.this,Broadcast.class);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(this,"Pop-ups cancelled",Toast.LENGTH_SHORT).show();


    }
*/
}
