package com.xunman.smartbutler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xunman.smartbutler.R;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/15 0015 9:16
 * 包名：com.xunman.smartbutler.adapter
 * 文件名： ${name}
 * 描述：  TODO
 */

public class MyBaseAdapter extends BaseAdapter {
   Context context;
    LayoutInflater inflater;
    public MyBaseAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return 10;
}

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.layout1,null);
        }
        return convertView;
    }
}
