package com.example.zhou.job4.utils;

import android.content.Context;

import java.io.File;

public class CacheUtils {
    private static final long cacheSize = 10 * 1024 * 1024;

    public static long getCacheSize() {
        return cacheSize;
    }
    public static File getDir(Context context){
        File dir = new File(context.getExternalCacheDir()+"/lottery");
        if(!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }
}
