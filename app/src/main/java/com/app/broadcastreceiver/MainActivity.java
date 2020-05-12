package com.app.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);

        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(new MyReceiver(), filter);

    }

    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //if anyone of above event happens then onRecieve will be invoked
            if (intent.getAction() == Intent.ACTION_HEADSET_PLUG) {
                textView.setText("headset plugin");
            } else if (intent.getAction() == Intent.ACTION_SCREEN_ON) {
                textView.setText("Screen on");
            } else if (intent.getAction() == Intent.ACTION_SCREEN_OFF) {
                textView.setText("Screen off");
            } else if (intent.getAction() == Intent.ACTION_BATTERY_LOW) {
                textView.setText("battery is low");
            } else if (intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
                textView.setText("Power connected");
            }else if (intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
                textView.setText("Power connected");
            }
        }
    }
}