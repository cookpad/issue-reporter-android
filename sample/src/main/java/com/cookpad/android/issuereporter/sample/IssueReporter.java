package com.cookpad.android.issuereporter.sample;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentActivity;

import com.cookpad.android.issuereporter.ReportMail;
import com.cookpad.android.issuereporter.fragment.IssueReporterFragment;

public class IssueReporter {
    private static IssueReporter INSTANCE;

    private ReportMail reportMail;

    private ActivityLifecycleCallbacksAdapter activityLifecycleCallbacksAdapter;
    private ActivityLifecycleCallbacksAdapter.Callback callback = new ActivityLifecycleCallbacksAdapter.Callback() {
        @Override
        public void onCreated(Activity activity) {
            if (activity instanceof FragmentActivity) {
                IssueReporterFragment.apply((FragmentActivity) activity, reportMail);
            }
        }
    };

    public IssueReporter(Application application, ReportMail reportMail) {
        this.reportMail = reportMail;
        this.activityLifecycleCallbacksAdapter = new ActivityLifecycleCallbacksAdapter(application, callback);
    }

    public static synchronized void start(Application application, ReportMail reportMail) {
        if (INSTANCE == null) {
            INSTANCE = new IssueReporter(application, reportMail);
        }
    }

    public static synchronized void stop(Application application) {
        if (INSTANCE != null) {
            INSTANCE.activityLifecycleCallbacksAdapter.unregister(application);
            INSTANCE = null;
        }
    }
}
