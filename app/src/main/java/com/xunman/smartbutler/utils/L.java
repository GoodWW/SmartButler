package com.xunman.smartbutler.utils;

import android.util.Log;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/9 0009 16:03
 * 包名：com.xunman.smartbutler.utils
 * 文件名： ${name}
 * 描述：  Log封装类
 */

public class L {
    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "smartbutler";
    //五个等级DIWEF

    public static void d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }
}
