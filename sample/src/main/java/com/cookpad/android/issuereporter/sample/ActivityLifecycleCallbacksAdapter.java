package com.cookpad.android.issuereporter.sample;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class ActivityLifecycleCallbacksAdapter implements Application.ActivityLifecycleCallbacks {
    private Callback callback;

    public ActivityLifecycleCallbacksAdapter(Application application, Callback callback) {
        application.registerActivityLifecycleCallbacks(this);
        this.callback = callback;
    }

    public void unregister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        callback.onCreated(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    public static interface Callback {
        public void onCreated(Activity activity);
    }
}

