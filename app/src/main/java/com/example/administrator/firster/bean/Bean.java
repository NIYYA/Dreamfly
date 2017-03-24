package com.example.administrator.firster.bean;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.*;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class Bean extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    // 已经封装好的跳转方法吧，
    public void intent(final Activity activity,final Intent intent){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.startActivity(intent);
            }
        });
    }
    // 已经封装好的吐丝方法吧
    public void toast(final  Activity activity,final String msg){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 公共方法，在账号密码检查时所用到调用
    public void emps(int emp) {
        String str = "";
        switch (emp) {
            case 1:
                str = "账号不能为空";
                break;
            case 2:
                str = "密码不能为空";
                break;
            case 3:
                str = "请再次输入密码";
                break;
            case 4:
                str = "密码不匹配";
                break;
            default:
                str = "账号异常，请尽快联系人工";
                break;
        }
        toast(this, str);
    }
}
