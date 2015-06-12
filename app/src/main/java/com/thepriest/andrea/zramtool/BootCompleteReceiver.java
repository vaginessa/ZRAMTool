package com.thepriest.andrea.zramtool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class BootCompleteReceiver extends BroadcastReceiver {
    //public static final String PREFS_NAME = "SharedPreferences.xml";
    public static final String PREFS_NAME = "com.thepriest.andrea.zramtool";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Log.d("boot completed", "boot completed caught");;
            Boolean autoRestart = false;
            SharedPreferences sp = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            autoRestart = sp.getBoolean("enable_notification", false);

            if (autoRestart) {

                Log.d("boot completed", "auto restart true");

                Intent i = new Intent(context, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        }


    }
}