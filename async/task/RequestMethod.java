package com.yl.async.task;

/**
 * Created by Yulong on 2018/1/10.
 */

public enum RequestMethod {
    GET("GET"),

    POST("POST"),

    HEAD("HEAD"),

    DELETE("DELETE");

    private String value;
    RequestMethod(String value){//都要传入  厉害了
        this.value=value;
    }

    public String value(){
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}
