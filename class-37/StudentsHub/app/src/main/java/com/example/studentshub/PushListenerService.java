package com.example.studentshub;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.amazonaws.mobileconnectors.pinpoint.targeting.notification.NotificationClient;
import com.amazonaws.mobileconnectors.pinpoint.targeting.notification.NotificationDetails;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;

public class PushListenerService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        Log.d("UPDATE", "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
        MainActivity.getPinpointManager(getApplicationContext()).getNotificationClient().registerDeviceToken(token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("REMOTE", "Message: " + remoteMessage.getData());

        final NotificationClient notificationClient = MainActivity.getPinpointManager(getApplicationContext()).getNotificationClient();

        final NotificationDetails notificationDetails = NotificationDetails.builder()
                .from(remoteMessage.getFrom())
                .mapData(remoteMessage.getData())
                .intentAction(NotificationClient.FCM_INTENT_ACTION)
                .build();

        NotificationClient.CampaignPushResult pushResult = notificationClient.handleCampaignPush(notificationDetails);

        if (!NotificationClient.CampaignPushResult.NOT_HANDLED.equals(pushResult)) {
            /**
             The push message was due to a Pinpoint campaign.
             If the app was in the background, a local notification was added
             in the notification center. If the app was in the foreground, an
             event was recorded indicating the app was in the foreground,
             for the demo, we will broadcast the notification to let the main
             activity display it in a dialog.
             */
            if (NotificationClient.CampaignPushResult.APP_IN_FOREGROUND.equals(pushResult)) {
                /* Create a message that will display the raw data of the campaign push in a dialog. */
                final HashMap<String, String> dataMap = new HashMap<>(remoteMessage.getData());
                //TODO: if we wanted to trigger code to happen when a message came in this seems like the best place
                broadcast(remoteMessage.getFrom(), dataMap);
            }
            return;
        }
    }

    private void broadcast(final String from, final HashMap<String, String> dataMap) {
        Intent intent = new Intent("push-notification");
        intent.putExtra("from", from);
        intent.putExtra("data", dataMap);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /**
     * Helper method to extract push message from bundle.
     *
     * @param data bundle
     * @return message string from push notification
     */
    public static String getMessage(Bundle data) {
        return ((HashMap) data.get("data")).toString();
    }


}
