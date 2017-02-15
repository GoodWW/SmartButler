package com.xunman.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xunman.smartbutler.R;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/10 0010 16:35
 * 包名：com.xunman.smartbutler.ui
 * 文件名： ${name}
 * 描述：  登录
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    //注册按钮
    private Button btn_register;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intiView();
    }

    private void intiView() {
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }

}
