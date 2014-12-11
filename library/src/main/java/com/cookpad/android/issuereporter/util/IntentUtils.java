package com.cookpad.android.issuereporter.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

public class IntentUtils {

    public static void sendMail(Activity activity, String email, String subject, String body,
            Uri fileUri) {
        Intent intent = ShareCompat.IntentBuilder.from(activity)
                .addEmailTo(email)
                .setSubject(subject)
                .setText(body)
                .setType("text/plain")
                .setStream(fileUri)
                .getIntent()
                .addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                        | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        activity.startActivity(intent);
    }

}
