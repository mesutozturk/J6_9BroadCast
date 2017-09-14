package com.mstztrk.j6_9broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mesut on 14.09.2017.
 */

public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int gelen = intent.getExtras().getInt("msg");
        Log.i("x", "Action: " + intent.getAction());
        Log.i("x", "Gelen mesaj: " + gelen);
        Toast.makeText(context, "Gelen mesaj: " + gelen, Toast.LENGTH_LONG).show();
    }
}
