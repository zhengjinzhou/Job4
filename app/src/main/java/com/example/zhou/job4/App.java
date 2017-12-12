package com.example.zhou.job4;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

public class App extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
        appContext = this;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
