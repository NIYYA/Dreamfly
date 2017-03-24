package com.example.administrator.firster.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.firster.bean.Bean;
import com.example.administrator.firster.R;
import com.example.administrator.firster.MainActivity;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

/**
 * 注册页面
 * Created by Administrator on 2017/3/23 0023.
 */

public class ZhuCheyemian extends Bean implements View.OnClickListener {
    private EditText zhanghao, miam, mima2;
    private Button zhuce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuche);
        intint();
    }

    private void intint() {
        zhanghao = (EditText) findViewById(R.id.zhuche_zhanghao);
        miam = (EditText) findViewById(R.id.zhuche_mima);
        mima2 = (EditText) findViewById(R.id.zhuche_mima2);
        zhuce = (Button) findViewById(R.id.zhuche_zhuce);
        zhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strz = zhanghao.getText().toString();
        String strm = miam.getText().toString();
        String strm2 = mima2.getText().toString();
        int cheak = cheak(strz, strm, strm2);
        switch (cheak){
            case 0:
                try {
                    EMClient.getInstance().createAccount(strz,strm);
                    toast(ZhuCheyemian.this,"注册成功");
                    intent(ZhuCheyemian.this,new Intent(ZhuCheyemian.this,MainActivity.class));
                } catch (HyphenateException e) {
                    finish();
                    e.printStackTrace();
                }
                break;
            default:
                emps(cheak); // 友好提示吧
                break;
        }

    }

    private int cheak(String uesname, String password, String password1) {
        if (TextUtils.isEmpty(uesname)) {
            return 1;
        }
        if (TextUtils.isEmpty(password)) {
            return 2;
        }
        if (TextUtils.isEmpty(password1)) {
            return 3;
        }
        if (!password.equals(password1)) {
            return 4;
        }
        return 0;

    }
}
