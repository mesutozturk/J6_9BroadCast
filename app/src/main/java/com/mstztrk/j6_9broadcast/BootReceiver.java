package com.mstztrk.j6_9broadcast;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by Mesut on 14.09.2017.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Telefon Başladı", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:911"));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // !!
        context.startActivity(i);
    }
}
