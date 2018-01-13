package com.yl.async.task;


import com.yl.async.util.Logger;

/**
 * Created by Yulong on 2018/1/10.
 */

public class RequestTask implements Runnable{

    private Request request;

    private HttpListener httpListener;
    /**
     * 通过构造方法拿过来 在run方法中执行请求
     * @param request
     */
    public RequestTask(Request request,HttpListener httpListener) {
        this.request = request;
        this.httpListener=httpListener;
    }

    @Override

    public void run() {
        Logger.i("执行请求开始："+request.toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.i("执行请求完成。");

        //TODO  执行请求
        Response response=new Response(200,request,"我是相应数据",null,null);
        Message message=new Message(response,httpListener);

        //信使  发送响应数据到主线程
        Poster.getInstance().post(message);//Handler 的 post 其中runnable在主线程执行
        //handler.post(new Runnable() {})
    }
}
