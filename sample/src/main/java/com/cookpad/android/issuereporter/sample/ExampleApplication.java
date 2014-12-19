package com.cookpad.android.issuereporter.sample;

import android.app.Application;

import com.cookpad.android.issuereporter.IssueReporter;
import com.cookpad.android.issuereporter.ReportMail;
import com.cookpad.android.issuereporter.SystemProfileBuilder;

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ReportMail reportMail = new ReportMail.Builder()
                .email("support@example.com")
                .subject("Report an issue")
                .body(new SystemProfileBuilder(this).build())
                .build();
        IssueReporter.initialize(this, reportMail);
    }

    @Override
    public void onTerminate() {
        IssueReporter.destroy(this);
        super.onTerminate();
    }
}
