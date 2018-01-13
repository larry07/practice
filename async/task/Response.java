package com.yl.async.task;

/**
 * Created by Yulong on 2018/1/11.
 */

import java.util.List;
import java.util.Map;

/**
 * 服务器响应
 */
public class Response {
    //Response
    private int responseCode;
    //请求对象
    private Request request;
    /**
     * 响应数据  可能是bimap等等
     */
    private String result;
    /**
     * 服务器的响应头
     */
    private Map<String,List<String>> responseHeaders;
    private Exception exception;

    Response(int responseCode, String result, Exception exception) {
        this.responseCode = responseCode;
        this.result = result;
        this.exception = exception;
    }

    Response(int responseCode, Request request, String result,Map<String,List<String>> responseHeaders,Exception exception) {
        this.responseCode = responseCode;
        this.request = request;
        this.result = result;
        this.exception = exception;
        this.responseHeaders=responseHeaders;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Request getRequest() {
        return request;
    }

    public String getResult() {
        return result;
    }

    Exception getException() {
        return exception;
    }
}
