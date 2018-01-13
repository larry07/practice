package com.yl.async.task;

/**
 * Created by Yulong on 2018/1/11.
 */

public interface HttpListener {
    /**
     * 请求成功
     * @param response 响应数据
     */
    void onSucceed(Response response);

    /**
     * 请求失败
     * @param e
     */
    void onFailed(Exception e);
}
