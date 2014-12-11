package com.cookpad.android.issuereporter.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class IOUtils {

    public static File getCacheDirectory(@NonNull Context context) throws IOException {
        File cacheDirectory = context.getCacheDir();
        if (cacheDirectory == null) {
            throw new IOException("External storage not found");
        }
        String screenshotDirectoryPath = cacheDirectory.getAbsolutePath() + File.separator
                + "screenshot" + File.separator;
        File screenshotDirecotry = new File(screenshotDirectoryPath);
        if (screenshotDirecotry.exists() && screenshotDirecotry.isDirectory()) {
            return screenshotDirecotry;
        }

        if (!screenshotDirecotry.mkdirs()) {
            throw new IOException("Couldn't make screenshot directory");
        }

        return screenshotDirecotry;
    }

    public static File newUniqueTempFile(String directory, String extension) {
        String filePath = directory + File.separator +
                UUID.randomUUID().toString() + "." + extension;
        File file = new File(filePath);
        if (file.exists()) {
            return newUniqueTempFile(directory, extension);
        }
        return file;
    }

    public static File saveBitmap(Bitmap bitmap, File bitmapFile) throws IOException {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(bitmapFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
        return bitmapFile;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();
        } catch (IOException e) {
            // ignore
        }
    }

}
