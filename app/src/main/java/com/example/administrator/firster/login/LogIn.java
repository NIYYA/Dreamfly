package com.example.administrator.firster.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.firster.bean.Bean;
import com.example.administrator.firster.R;
import com.example.administrator.firster.activity.MainActivity;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

/**
 * 登陆页面
 * Created by Administrator on 2017/3/23 0023.
 */

public class LogIn extends Bean implements View.OnClickListener {
    private static final String TAG = "LogIn";
    private Button denglu, zhuce;
    private EditText zhang, mima;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        init();


    }

    private void init() {
        denglu = (Button) findViewById(R.id.denglu_bu_denglu);
        zhuce = (Button) findViewById(R.id.denglu_bt_zhuce);
        zhang = (EditText) findViewById(R.id.denglu_et_zhang);
        mima = (EditText) findViewById(R.id.denglu_et_mi);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        mima.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    intvoid();
                }
                return false;
            }
        });

    }

    private void intvoid() {
        String strz = zhang.getText().toString();
        String strm = mima.getText().toString();
        int cheak = cheak(strz, strm);
        switch (cheak) {
            case 1:
                log(strz, strm);
                break;
            default:
              emps(cheak);
                break;

        }

    }

    private void log(String usename, String password) {
        EMClient.getInstance().login(usename, password, new EMCallBack() {
            // 调用第三方方法，实现回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                intent(LogIn.this, new Intent(LogIn.this, MainActivity.class));
                finish();
                toast(LogIn.this, "登陆成功");           }

            @Override
            public void onError(int i, String s) {
                Log.i("TAG", "登录聊天服务器失败");
                toast(LogIn.this, "登陆失败，无法登陆到服务器");
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });


    }

    private int cheak(String usename, String password) {
        if (TextUtils.isEmpty(usename)) {
            return 1;
        }
        if (TextUtils.isEmpty(password)) {
            return 2;
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denglu_bu_denglu:
                intvoid();
                break;
            case R.id.denglu_bt_zhuce:


        }
    }
}
