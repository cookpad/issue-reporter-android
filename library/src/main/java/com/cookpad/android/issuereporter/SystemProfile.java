package com.cookpad.android.issuereporter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Locale;

public class SystemProfile {
    private String packageName;
    private String manufacturer;
    private String model;
    private String sdkInt;
    private String language;
    private String country;
    private int screenLayout;
    private float density;

    public SystemProfile(Context context) {
        Resources resources = context.getResources();
        this.packageName = context.getPackageName();
        this.manufacturer = android.os.Build.MANUFACTURER;
        this.model = android.os.Build.MODEL;
        this.sdkInt = String.valueOf(android.os.Build.VERSION.SDK_INT);

        Locale locale = resources.getConfiguration().locale;
        this.language = locale.getLanguage();
        this.country = locale.getCountry();

        this.screenLayout = Configuration.SCREENLAYOUT_SIZE_MASK & resources.getConfiguration().screenLayout;
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        this.density = metrics.density;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("packageName=").append(packageName).append("\n");
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
