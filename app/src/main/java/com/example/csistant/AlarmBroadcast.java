package com.example.csistant;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class AlarmBroadcast extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

//        public static final String channelID = "channelID";
//        public static final String channelName = "Channel Name";
//
//        private NotificationManager mManager;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            createChannel();
//        }
//
//        @TargetApi(Build.VERSION_CODES.O)
//        private void createChannel() {
//            NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
//
//            getManager().createNotificationChannel(channel);
//        }
//
//        public NotificationManager getManager() {
//            if (mManager == null) {
//                mManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//            }
//            return mManager;
//        }
//attemp1...................
        //Getting data from createEvent class
//        Log.e("SF","inside alarm broadcast");
//        Bundle bundle = intent.getExtras();
//        String text = bundle.getString("event");
//        String date = bundle.getString("date");
//        String time = bundle.getString("time");
//
//        //Click on Notification. Passing data to notification class.
//        Intent intent1 = new Intent(context, Notification.class);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent1.putExtra("eventname", text);
//        intent1.putExtra("eventdate",date);
//        intent1.putExtra("eventtime",time);
//
//        //Notification Builder
////        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_ONE_SHOT);
////        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
////        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "notify_001");
//
//        //here we set all the properties for the notification
////        RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.activity_notification);
////        contentView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
////        PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
////        contentView.setOnClickPendingIntent(R.id.Button_Available, pendingSwitchIntent);
////        contentView.setTextViewText(R.id.message, text);
////        contentView.setTextViewText(R.id.date, date);
////        mBuilder.setSmallIcon(R.drawable.ic_clock);
////        mBuilder.setAutoCancel(true);
////        mBuilder.setOngoing(true);
////        mBuilder.setAutoCancel(true);
////        mBuilder.setPriority(Notification.PRIORITY_HIGH);
////        mBuilder.setOnlyAlertOnce(true);
////        mBuilder.build().flags = Notification.FLAG_NO_CLEAR | Notification.PRIORITY_HIGH;
////        mBuilder.setContent(contentView);
////        mBuilder.setContentIntent(pendingIntent);
//
//
//        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.activity_notification);
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "notify_001");
//        Notification customNotification = new NotificationCompat.Builder(context, "notify_001")
//                .setSmallIcon(R.drawable.ic_clock)
//                .setContentTitle(text)
//                .setContentText(date +"  "+ time)
//                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
//                .setCustomContentView(remoteView)
//                .build();
//
//
//        //we have to create notification channel after api level 26
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Log.w("SF","inside for building channels ");
//            String channelId = "channel_id";
//            NotificationChannel channel = new NotificationChannel(channelId, "channel name", NotificationManager.IMPORTANCE_HIGH);
//            channel.enableVibration(true);
//            notificationManager.createNotificationChannel(channel);
//            mBuilder.setChannelId(channelId);
//        }
//
////        android.app.Notification notification = mBuilder.build();
////        notificationManager.notify(1, notification);



        //last try
        Bundle bundle = intent.getExtras();
        String text = bundle.getString("event");
        String date = bundle.getString("date");
        String time = bundle.getString("time");

        Log.e("SF","inside alarm broadcast");
        NotificationHandler notificationHelper = new NotificationHandler(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());

//        //last last enthusiastic try
//        Log.e("SF","inside alarm broadcast");
//        Bundle bundle = intent.getExtras();
//        String text = bundle.getString("event");
//        String date = bundle.getString("date");
//        String time = bundle.getString("time");
//
//        Intent intent1 = new Intent(context, Notification.class);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent1.putExtra("eventname", text);
//        intent1.putExtra("eventdate",date);
//        intent1.putExtra("eventtime",time);
//
//        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.activity_notification);
//        NotificationCompat.Builder customNotification = new NotificationCompat.Builder(context, "notify_001")
//                .setSmallIcon(R.drawable.ic_clock)
//                .setContentTitle(text)
//                .setContentText(date +"  "+ time)
//                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
//                .setCustomContentView(remoteView);
//
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(0, customNotification.build());
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Log.w("SF","inside for building channels ");
//            String channelId = "channel_id";
//            NotificationChannel channel = new NotificationChannel(channelId, "channel name", NotificationManager.IMPORTANCE_HIGH);
//            channel.enableVibration(true);
//            manager.createNotificationChannel(channel);
//            customNotification.setChannelId(channelId);
//        }

        //pakka last
//        Bundle bundle = intent.getExtras();
//        String text = bundle.getString("event");
//        String date = bundle.getString("date");
//        String time = bundle.getString("time");
//
//        Intent intent1 = new Intent(context, Notification.class);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent1.putExtra("eventname", text);
//        intent1.putExtra("eventdate",date);
//        intent1.putExtra("eventtime",time);
//
//        Log.e("SF","inside alarm broadcast");
//        NotificationHandler notificationHelper = new NotificationHandler(context);
//        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
//        notificationHelper.getManager().notify(1, nb.build());
    }
}