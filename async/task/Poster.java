package com.yl.async.task;


import android.os.Handler;
import android.os.Looper;

/**
 * Created by Yulong on 2018/1/10.
 */

public class Poster extends Handler {
    private static Poster instance;
    public static Poster getInstance(){
        if(instance==null)
            synchronized (Poster.class) {
                if (instance == null)
                    instance = new Poster();
            }
        return instance;
    }
    private Poster(){
        //主线程任何地方都可以把消息发送出去
        super(Looper.getMainLooper());
    }
}
