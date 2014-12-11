package com.cookpad.android.issuereporter.task;

import com.cookpad.android.issuereporter.util.IOUtils;
import com.cookpad.android.issuereporter.util.ViewUtils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;

public class ScreenshotTask extends AsyncTask<Void, Void, File> {

    Activity activity;

    Callback callback;

    Bitmap bitmap;

    IOException ioException;

    public ScreenshotTask(Activity activity, Callback callback) {
        if (activity == null) {
            throw new IllegalArgumentException("activity must not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }

        this.activity = activity;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        bitmap = ViewUtils.getDecorViewBitmap(activity);
    }

    @Override
    protected File doInBackground(Void... params) {
        try {
            File bitmapFile = obtineNewBitmapFile();
            IOUtils.saveBitmap(bitmap, bitmapFile);
            return bitmapFile;
        } catch (IOException e) {
            ioException = e;
            return null;
        }
    }

    private File obtineNewBitmapFile() throws IOException {
        File directory = IOUtils.getCacheDirectory(activity);
        String cacheDirectoryPath = directory.getAbsolutePath();
        return IOUtils.newUniqueTempFile(cacheDirectoryPath, "jpg");
    }

    @Override
    protected void onPostExecute(File bitmapFile) {
        if (ioException != null) {
            callback.onCatchIOException(ioException);
        } else {
            callback.onTakeScreenshot(bitmapFile);
        }
    }

    public interface Callback {

        void onTakeScreenshot(File bitmapFile);

        void onCatchIOException(IOException e);

    }

}
