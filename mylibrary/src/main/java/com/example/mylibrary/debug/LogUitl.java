package com.example.mylibrary.debug;


import android.util.Log;

import com.example.mylibrary.common.Constants;

/**
 * Created by Administrator on 2017/2/8 0008.
 */

/**
 * 日志工具类
 */
public class LogUitl {

    public static void show(String tag,String msg){
        if (Constants.isDeug) {
            log(tag,msg,Constants.DEUGE);

        }
    }

    public static void show(String tag,String msg,int level){
        if (Constants.isDeug) {
            log(tag,msg,level);

        }
    }


    private static void log(String tag,String msg,int level){
        switch (level) {
            case Constants.DEUGI:
                Log.i(tag, msg);
                break;
            case Constants.DEUGE:
                Log.e(tag, msg);
                break;
            case Constants.DEUGW:
                Log.w(tag, msg);
                break;
            case Constants.DEUGD:
                Log.d(tag, msg);
                break;
            case Constants.DEUGM:
                Log.d(tag, "log() called with: tag = [" + tag + "], msg = [" + msg + "], level = [" + level + "]");
                break;



        }

    }


}
