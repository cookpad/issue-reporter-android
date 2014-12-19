package com.cookpad.android.issuereporter.sample;

import android.app.Application;

import com.cookpad.android.issuereporter.IssueReporter;

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String mailAddress = "support@example.com";
        String subject = "Report an issue";
        IssueReporter.initialize(this, mailAddress, subject);
    }

    @Override
    public void onTerminate() {
        IssueReporter.destroy(this);
        super.onTerminate();
    }
}
