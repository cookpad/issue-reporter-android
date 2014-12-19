package com.cookpad.android.issuereporter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.cookpad.android.issuereporter.service.IntentReceiveService;
import com.cookpad.android.issuereporter.util.Utils;

public class ReportNotification {
    private static final String NOTIFICATION_TAG = ReportNotification.class.getName();
    private static final int NOTIFICATION_ID = 0;

    public static void show(Context context) {
        PendingIntent pendingIntent = IntentReceiveService.createPendingIntent(context, 0, 0);
        Notification notification = buildNotification(context, pendingIntent);

        NotificationManager notificationManager = getNotificationManager(context);
        notificationManager.notify(NOTIFICATION_TAG, NOTIFICATION_ID, notification);
    }

    public static void cancel(Context context) {
        NotificationManager notificationManager = getNotificationManager(context);
        notificationManager.cancel(NOTIFICATION_TAG, NOTIFICATION_ID);
    }

    private static Notification buildNotification(Context context, PendingIntent pendingIntent) {
        String applicationName = Utils.getApplicationName(context).toString();
        String title = context.getResources().getString(R.string.notification_title);
        String description = context.getResources().getString(R.string.notification_description, applicationName);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker(title);
        builder.setContentTitle(title);
        builder.setContentText(description);
        builder.setSmallIcon(R.drawable.notification);
        builder.setContentIntent(pendingIntent);
        return builder.build();
    }

    protected static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
