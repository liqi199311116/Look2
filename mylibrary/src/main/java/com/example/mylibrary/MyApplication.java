package com.example.mylibrary;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/1/24 0024.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能. x.Ext.init(this);
    }
}
