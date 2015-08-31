package com.soontm.kilroy.log;

/**
 * Created by Hannes on 26.08.2015.
 */
public class Log {
  //took the code from And11MappingMyLocation project from grips
    public static final boolean DEBUG = true;
    public static final String TAG = "kilroy";

    public static void d(String tag, String msg) {
        if (DEBUG) {
            android.util.Log.d(tag, msg);
        }
    }


    public static void d(String msg) {
        if (DEBUG) {
            android.util.Log.d(TAG, msg);
        }
    }

}
