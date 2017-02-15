package com.xunman.smartbutler.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.xunman.smartbutler.R;

/**
 * 项目名： SmartButler
 * 创建者： xxxxx
 * 创建时间：  2017/2/15 0015 8:37
 * 包名：com.xunman.smartbutler.customView
 * 文件名： ${name}
 * 描述：  刷新加载LIstView
 */

public class MyListView extends ListView implements AbsListView.OnScrollListener {
    //底布局
    View footer;
    //当前总的数量
    int totalItemCount;
    //最后一个可见的item
    int lastVisbileItem;
    //正在加载
    boolean isLoading;
    //定义一个接口 用于加载更多数据
    ILoadListenner iLoadListenner;

    public MyListView(Context context) {
        super(context);
        intiView(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        intiView(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiView(context);
    }

    private void intiView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.list_footer, null);
        footer.findViewById(R.id.lv_footer).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
//        this.addHeaderView(footer);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //如果当前滚动item等于总的item数同时当前滚动已经停止
        if (totalItemCount == lastVisbileItem && scrollState == SCROLL_STATE_IDLE) {
            if (!isLoading) {
                isLoading = true;
                //显示出底布局
                footer.findViewById(R.id.lv_footer).setVisibility(View.VISIBLE);
                //3、加载更多数据   用接口回调方式访问调用listView的类
                iLoadListenner.onLoad();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.lastVisbileItem = firstVisibleItem + visibleItemCount;
        this.totalItemCount = totalItemCount;
    }

    //2、本方法用于在onScrollStateChanged中加载接口，加载跟多数据
    public void setInterface(ILoadListenner iLoadListenner){
        this.iLoadListenner = iLoadListenner;
    }

    //1、加载更多数据的回调接口
    public interface ILoadListenner {
        public void onLoad();
    }
}
