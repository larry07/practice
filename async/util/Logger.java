package com.yl.async.util;

import android.util.Log;

/**
 * Created by Yulong on 2018/1/9.
 */

public class Logger {
    public static final String TAG="IMOOCUpload";
    /**
     * 打印开关
     */
    public static final boolean DEBUG=true;
    public static String getMessage(Object o){
        return o==null?"null":o.toString();
    }
    public static void i(Object msg){
        if(DEBUG)
            Log.i(TAG,getMessage(msg));
    }

    /**
     * 打印调试信息
     * @param msg
     */
    public static void d(Object msg){
        if(DEBUG)
            Log.d(TAG,getMessage(msg));
    }

    /**
     * 警告信息
     * @param msg
     */
    public static void w(Object msg){
        if(DEBUG)
            Log.w(TAG,getMessage(msg));
    }

    /**
     * 错误信息
     * @param msg
     */
    public static void e(Object msg){
        if(DEBUG)
            Log.e(TAG,getMessage(msg));
    }
}
