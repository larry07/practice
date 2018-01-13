package com.yl.async.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulong on 2018/1/10.
 */

public class Request {
    private String url;//请求地址

    private RequestMethod method;//请求方法
    /**
     * 请求参数
     */
    private List<KeyValue> keyValues;

    public Request(String url) {
        this(url,RequestMethod.GET);
    }
    public Request(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
        keyValues = new ArrayList<>();
    }
    /**
     * 让外部可以添加参数到里面
     */
    public void add(String key,int value){
        keyValues.add(new KeyValue(key,Integer.toString(value)));
    }
    public void add(String key,Long value){
        keyValues.add(new KeyValue(key,Long.toString(value)));
    }
    public void add(String key,String value){
        keyValues.add(new KeyValue(key,value));
    }
    public void add(String key,File value){
        keyValues.add(new KeyValue(key,value));
    }

    @Override
    public String toString() {
        return "url:"+url+";method:"+method+";params:"+keyValues.toString();
    }
}
