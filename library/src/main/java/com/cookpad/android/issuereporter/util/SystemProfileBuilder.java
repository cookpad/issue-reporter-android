package com.cookpad.android.issuereporter.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Locale;

public class SystemProfileBuilder {

    private Context context;

    public SystemProfileBuilder(Context context) {
        this.context = context.getApplicationContext();
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        Resources resources = context.getResources();

        String packageName = context.getPackageName();
        builder.append("packageName=").append(packageName).append("\n");

        String manufacturer = android.os.Build.MANUFACTURER;
        builder.append("manufacturer=").append(manufacturer).append("\n");

        String model = android.os.Build.MODEL;
        builder.append("model=").append(model).append("\n");

        String sdkInt = String.valueOf(android.os.Build.VERSION.SDK_INT);
        builder.append("sdk-int=").append(sdkInt).append("\n");

        Locale locale = resources.getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        builder.append("language=").append(language).append("\n");
        builder.append("country=").append(country).append("\n");

        int screenLayout = Configuration.SCREENLAYOUT_SIZE_MASK & resources
                .getConfiguration().screenLayout;
        builder.append("screen-layout=").append(screenLayout).append("\n");

        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(metrics);
        float density = metrics.density;
        builder.append("density=").append(density).append("\n");

        return builder.toString();
    }

}
