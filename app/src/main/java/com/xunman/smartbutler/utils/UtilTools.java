package com.xunman.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/8 0008 18:33
 * 包名：com.xunman.smartbutler.utils
 * 文件名： ${name}
 * 描述：  TODO
 */

public class UtilTools {

    //设置字体    引号内填写字体的具体路径
    public static void setFont(Context mContext, TextView mTextView){
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(),"");
        mTextView.setTypeface(typeface);
    }
}
