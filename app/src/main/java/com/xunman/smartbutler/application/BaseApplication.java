package com.xunman.smartbutler.application;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;
import com.xunman.smartbutler.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/8 0008 18:18
 * 包名：com.xunman.smartbutler.ui
 * 文件名： ${name}
 * 描述：  application
 */

public class BaseApplication  extends Application{

    //创建
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化  bugly  建议在测试阶段建议设置成true，发布时设置为false。
        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, true);
        //第一种方式：默认初始化Bmob
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
    }
}
