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
    }
}
