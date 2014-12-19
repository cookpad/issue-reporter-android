package com.cookpad.android.issuereporter.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

import com.cookpad.android.issuereporter.ReportMail;

public class IntentUtils {

    public static void sendMail(Activity activity, ReportMail reportMail, Uri fileUri) {
        Intent intent = ShareCompat.IntentBuilder.from(activity)
                .addEmailTo(reportMail.getEmail())
                .setSubject(reportMail.getSubject())
                .setText(reportMail.getBody())
                .setType("text/plain")
                .setStream(fileUri)
                .getIntent()
                .addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                        | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        activity.startActivity(intent);
    }

}
