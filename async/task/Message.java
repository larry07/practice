package com.yl.async.task;

/**
 * Created by Yulong on 2018/1/11.
 */

public class Message implements Runnable{

    private Response response;

    private HttpListener httpListener;

    public Message(Response response,HttpListener httpListener) {
        this.response = response;
        this.httpListener=httpListener;
    }

    @Override
    public void run() {
        //这里被回调到主线程   httpListener.(...)
        Exception exception=response.getException();
        if(exception!=null){
            httpListener.onFailed(exception);
        }else{//没有异常则请求成功
            httpListener.onSucceed(response);
        }
    }
}
