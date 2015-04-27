package com.cookpad.android.issuereporter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Locale;

public class SystemProfile {

    private CharSequence appLabel;

    private String appPackageName;

    private String appVersionName;

    private int appVersionCode;

    private String manufacturer;

    private String model;

    private String sdkInt;

    private String language;

    private String country;

    private int screenLayout;

    private float density;

    public SystemProfile(Context context) {
        Resources resources = context.getResources();
        appPackageName = context.getPackageName();

        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo a = pm.getApplicationInfo(appPackageName, 0);
            PackageInfo p = pm.getPackageInfo(appPackageName, 0);

            appLabel = pm.getApplicationLabel(a);
            appVersionName = p.versionName;
            appVersionCode = p.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("never reached", e);
        }

        manufacturer = android.os.Build.MANUFACTURER;
        model = android.os.Build.MODEL;
        sdkInt = String.valueOf(android.os.Build.VERSION.SDK_INT);

        Locale locale = resources.getConfiguration().locale;
        language = locale.getLanguage();
        country = locale.getCountry();

        screenLayout = Configuration.SCREENLAYOUT_SIZE_MASK & resources
                .getConfiguration().screenLayout;
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(metrics);
        density = metrics.density;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("appLabel=").append(appLabel).append("\n");
        builder.append("appPackageName=").append(appPackageName).append("\n");
        builder.append("appVersion=").append(appVersionName)
                .append(" (").append(appVersionCode).append(")\n");
        builder.append("\n");
        builder.append("manufacturer=").append(manufacturer).append("\n");
        builder.append("model=").append(model).append("\n");
        builder.append("sdk-int=").append(sdkInt).append("\n");
        builder.append("language=").append(language).append("\n");
        builder.append("country=").append(country).append("\n");
        builder.append("screen-layout=").append(screenLayout).append("\n");
        builder.append("density=").append(density).append("\n");
        return builder.toString();
    }

}
