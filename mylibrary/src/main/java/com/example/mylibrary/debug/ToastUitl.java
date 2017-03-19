package com.example.mylibrary.debug;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/8 0008.
 */

public class ToastUitl {
    private static Toast t;

    public static void toastShow( Context c,String msg,int time){
        if (t==null){
           t=Toast.makeText(c,msg,Toast.LENGTH_LONG);
            t.show();
        }else{
            t.setText(msg);
            t.setDuration(time);
            t.show();
        }
    }
}
