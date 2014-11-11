package com.main.wearnotify;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;

public class NotifyWearActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		Button wearButton = (Button)findViewById(R.id.wearButton);
        wearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notificationId = 001;
 
                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(NotifyWearActivity.this)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Hello,")
                                .setContentText("I am sample notification. Swipe me left to open Google")
                                .addAction(R.drawable.ic_launcher, "Open Google", getPendingIntent());
 
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(NotifyWearActivity.this);
 
                notificationManager.notify(notificationId, notificationBuilder.build());
            }
        });
	}
	
	public PendingIntent getPendingIntent(){
	    // Build an intent for an action to open a url
		Intent urlIntent = new Intent(Intent.ACTION_VIEW);
		Uri uri = Uri.parse("http://www.google.com");
		urlIntent.setData(uri);
		PendingIntent urlPendingIntent = PendingIntent.getActivity(this, 0, urlIntent, 0);
		return urlPendingIntent;
	} 
}