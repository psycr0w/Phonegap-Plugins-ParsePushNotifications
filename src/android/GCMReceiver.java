package com.stratogos.cordova.parsePushNotifications;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
// import com.google.android.gcm.GCMBroadcastReceiver;
import com.parse.ParsePushBroadcastReceiver;
import android.util.Log;

// public class GCMReceiver extends GCMBroadcastReceiver {
public class GCMReceiver extends ParsePushBroadcastReceiver {
    // @Override
    // protected String getGCMIntentServiceClassName(Context context) {
    //     return "com.stratogos.cordova.parsePushNotifications.GCMIntentService";
    // }

// ParsePushBroadcastReceiver.onPushReceive(Context, Intent), 
// ParsePushBroadcastReceiver.onPushOpen(Context, Intent),
// ParsePushBroadcastReceiver.onPushDismiss(Context, Intent). 


// ParsePushBroadcastReceiver.getSmallIconId(Context, Intent)
// ParsePushBroadcastReceiver.getLargeIcon(Context, Intent).

	@Override
	protected Class<? extends Activity> getActivity(Context context, Intent intent) {		
		Log.d("Subclass of ParsePushBroadcastReceiver","GMCReceiver was asked for the activity");

		return PushHandlerActivity.class;
	}

	public GCMReceiver() {
        super();
		Log.d("Subclass of ParsePushBroadcastReceiver","GMCReceiver was instantiated");
    }

	@Override
	protected void onPushReceive(Context context, Intent intent) {
		Log.d("Subclass of ParsePushBroadcastReceiver", "onPushReceive - context: " + context);

		if(ParsePushNotificationPlugin.isInForeground()){
			Log.d("Subclass of ParsePushBroadcastReceiver", "Foreground! Calling NotificationReceived on ParsePushNotificationPlugin");
		
            ParsePushNotificationPlugin.NotificationReceived(intent.getExtras().getString("com.parse.Data"), true);
        } else {
			Log.d("Subclass of ParsePushBroadcastReceiver", "Not Foreground! Calling super.onPushReceive");

        	super.onPushReceive(context,intent);
        }
	}


}