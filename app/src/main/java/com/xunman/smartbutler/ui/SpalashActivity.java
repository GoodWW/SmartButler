package com.xunman.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xunman.smartbutler.MainActivity;
import com.xunman.smartbutler.R;
import com.xunman.smartbutler.utils.ShareUtils;
import com.xunman.smartbutler.utils.StaticClass;


/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/9 0009 17:01
 * 包名：com.xunman.smartbutler.ui
 * 文件名： ${name}
 * 描述：  欢迎界面
 */

public class SpalashActivity extends AppCompatActivity {
    /**
     * 1、延时2000毫秒
     * 2、判断程序是否是第一次运行
     * 3、自定义字体
     * 4、Activity全屏主题
     */
    private TextView tv_splash;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLE_SPLASH:
                    //判断程序是否第第一次运行
                    if (isFirst()) {
                        startActivity(new Intent(SpalashActivity.this,GuideActivity.class));
                    }else{
                        startActivity(new Intent(SpalashActivity.this,GuideActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        intiView();

    }

    //初始化View
    private void intiView() {
        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLE_SPLASH, 2000);
        tv_splash = (TextView) findViewById(R.id.tv_splash);
        //设置字体

    }

    //判断程序是否是第一次运行
    public boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this, StaticClass.SHARE_IS_FIRST, true);
        if (isFirst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
            //是第一次运行
            return true;
        }else {
            //不是第一次运行
            return false;
        }
    }

    //禁止返回键    只要不去调用父类的方法就禁止了
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
