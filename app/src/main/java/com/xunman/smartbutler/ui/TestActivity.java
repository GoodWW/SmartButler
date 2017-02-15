package com.xunman.smartbutler.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xunman.smartbutler.R;
import com.xunman.smartbutler.adapter.MyBaseAdapter;
import com.xunman.smartbutler.customView.MyListView;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/15 0015 8:53
 * 包名：com.xunman.smartbutler.ui
 * 文件名： ${name}
 * 描述：  测试LIastView刷新和加载
 */

public class TestActivity extends AppCompatActivity implements MyListView.ILoadListenner {
    private MyListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        intiView();
    }

    private void intiView() {
        Log.e("++++","-----");
        lv = (MyListView) findViewById(R.id.lv_my_list_view1);
        lv.setAdapter(new MyBaseAdapter(this));
    }

    @Override
    public void onLoad() {
        //获取更多数据、
        //更新listView显示
    }
}
