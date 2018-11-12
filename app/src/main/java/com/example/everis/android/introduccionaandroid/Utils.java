package com.example.everis.android.introduccionaandroid;

import android.os.Handler;
import android.os.Looper;

public class Utils {

    public static void runOnUIThread(Runnable runnable, long delay) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, delay);
    }
}
