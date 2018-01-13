package com.yl.async.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yulong on 2018/1/10.
 */

public enum RequestExecutor {
    //enum 全局单例 枚举
    INSTANCE;

    private  ExecutorService mExecutorService;
    RequestExecutor(){//枚举居然有构造方法
        mExecutorService= Executors.newSingleThreadExecutor();
    }

    /**
     * 执行一个请求
     * @param request 请求对象{@link Request}
     */
    public void execute(Request request,HttpListener httpListener){
        mExecutorService.execute(new RequestTask(request,httpListener));
    }
}
