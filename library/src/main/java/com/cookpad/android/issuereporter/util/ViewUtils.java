package com.cookpad.android.issuereporter.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;

public class ViewUtils {

    public static Bitmap getDecorViewBitmap(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        return getViewBitmap(decorView);
    }

    public static Bitmap getViewBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap cache = view.getDrawingCache();
        if (cache == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(cache);
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

}
