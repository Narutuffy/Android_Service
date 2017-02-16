package com.example.vamsirao.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Vamsi Rao on 1/23/2017.
 */

public class Broadcast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Alarm",Toast.LENGTH_LONG).show();
        Intent scheduledIntent= new Intent(context,Popup.class);
        scheduledIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(scheduledIntent);
    }
}
