package com.yl.async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yl.async.task.HttpListener;
import com.yl.async.task.Request;
import com.yl.async.task.RequestExecutor;
import com.yl.async.task.Response;
import com.yl.async.util.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_get).setOnClickListener(this);
        findViewById(R.id.btn_head).setOnClickListener(this);
        findViewById(R.id.btn_post).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_get:{
                requestGet();
                break;
            }
            case R.id.btn_head:{
                break;
            }
            case R.id.btn_post:{
                break;
            }
            default:break;
        }
    }

    private void requestGet() {
        Request request=new Request("http://www.yanzhenjie.com");
        request.add("userName","杨振杰");
        request.add("pwd","123");
        request.add("sex","man");
        RequestExecutor.INSTANCE.execute(request, new HttpListener() {

            @Override
            public void onSucceed(Response response) {
                Logger.i("Activity接收到的相应码："+response.getResponseCode());
                Logger.i("Activity接收到的结果："+response.getResult());
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
