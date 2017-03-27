package com.example.administrator.firster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.firster.bean.Bean;
import com.example.administrator.firster.R;
import com.example.administrator.firster.login.LogIn;
import com.hyphenate.chat.EMClient;

/**
 * 开屏页面
 * Created by Administrator on 2017/3/23 0023.
 */

public class SplashActivity extends Bean{
    //延迟时间
    private static final long sleeptime=4000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (EMClient.getInstance().isLoggedInBefore()){
                    long start = System.currentTimeMillis();
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    long costTime = System.currentTimeMillis() - start;
                    try {
                        Thread.sleep(2000-costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    intent(SplashActivity.this,new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }else {
                    try {
                        Thread.sleep(sleeptime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    intent(SplashActivity.this,new Intent(SplashActivity.this,LogIn.class));
                    finish();
                }
            }
        }).start();
    }
}
