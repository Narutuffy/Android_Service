package com.example.vamsirao.services;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   // Button startButton= (Button)findViewById(R.id.start_button);

    public void startService(View view){
        startService(new Intent(getBaseContext(),Background.class));
    }

    public void stopService(View view){
        stopService(new Intent(MainActivity.this,Background.class));
    }

}
