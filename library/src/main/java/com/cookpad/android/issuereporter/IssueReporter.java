package com.cookpad.android.issuereporter;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentActivity;

import com.cookpad.android.issuereporter.fragment.IssueReporterFragment;

public class IssueReporter {
    private static final Object LOCK = new Object();

    private static IssueReporter INSTANCE;

    private final String mailAddress;
    private final String subject;
    private ActivityLifecycleCallbacksAdapter activityLifecycleCallbacksAdapter;

    private ActivityLifecycleCallbacksAdapter.ActivityCreatedCallback callback = new ActivityLifecycleCallbacksAdapter.ActivityCreatedCallback() {
        @Override
        public void onCreated(Activity activity) {
            IssueReporterFragment.apply((FragmentActivity) activity, mailAddress, subject);
        }
    };

    public IssueReporter(Application application, String mailAddress, String subject) {
        this.mailAddress = mailAddress;
        this.subject = subject;
        this.activityLifecycleCallbacksAdapter = new ActivityLifecycleCallbacksAdapter(application, callback);
    }

    public static void initialize(Application application, String mailAddress, String subject) {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = new IssueReporter(application, mailAddress, subject);
            }
        }
    }

    public static void destroy(Application application) {
        synchronized (LOCK) {
            if (INSTANCE != null) {
                INSTANCE.activityLifecycleCallbacksAdapter.destroy(application);
                INSTANCE = null;
            }
        }
    }
}
