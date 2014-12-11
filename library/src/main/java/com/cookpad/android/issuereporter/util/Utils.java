package com.cookpad.android.issuereporter.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class Utils {

    public static CharSequence getApplicationName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return context.getApplicationInfo().loadLabel(packageManager);
    }

}
