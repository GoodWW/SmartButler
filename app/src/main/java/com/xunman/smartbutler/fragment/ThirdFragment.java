package com.xunman.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xunman.smartbutler.R;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/9 0009 8:54
 * 包名：com.xunman.smartbutler.fragment
 * 文件名： ${name}
 * 描述：  第三个
 */

public class ThirdFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.fragment_third,container,false);
        return view;
    }
}
