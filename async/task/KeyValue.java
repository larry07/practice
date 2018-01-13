package com.yl.async.task;

import java.io.File;

/**
 * Created by Yulong on 2018/1/10.
 */

public class KeyValue {
    private String key;
    private Object value;

    //限制不同类型value
    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public KeyValue(String key, File value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "key="+key+";value="+value;
    }
}
