package com.mstztrk.j6_9broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Sms Geldi", Toast.LENGTH_SHORT).show();
        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");
        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String messageBody = smsMessage.getMessageBody();
            //Toast.makeText(context, "Gönderen: " + sender + " Gelen Mesaj: " + messageBody, Toast.LENGTH_SHORT).show();
            if (sender.equals("05555555555")) {
                Toast.makeText(context, "Aktivasyon Kodu: " + messageBody, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
