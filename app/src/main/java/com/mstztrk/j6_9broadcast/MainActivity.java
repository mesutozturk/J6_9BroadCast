package com.mstztrk.j6_9broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtAktivasyon;

    BroadcastReceiver receiver = new BootReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle data = intent.getExtras();

            Object[] pdus = (Object[]) data.get("pdus");
            for (int i = 0; i < pdus.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String sender = smsMessage.getDisplayOriginatingAddress();
                String messageBody = smsMessage.getMessageBody();
                if (sender.equals("05123456")) {
                    txtAktivasyon.setText(messageBody);
                }
            }
        }
    };
    IntentFilter iFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAktivasyon = (TextView) findViewById(R.id.txtActivasyonKodu);
        iFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (receiver != null)
            registerReceiver(receiver, iFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver != null)
            unregisterReceiver(receiver);
    }
}
