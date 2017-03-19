package com.example.mylibrary.animation;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/12/24 0024.
 */

//viewpager滑动效果类

public class ZoomOutPageTransformer implements ViewPager.PageTransformer
{
    private static final String TAG = "ZoomOutPageTransformer";


    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;




    @SuppressLint("NewApi")
    public void transformPage(View view, float position)
    {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        Log.e("TAG", view + " , " + position + "");

        if (position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
        { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0)
            {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else
            {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }


            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                    / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }


//    private static final float MIN_SCALE = 0.85f;
//    private static final float MIN_ALPHA = 0.5f;
//
//
//    private float currP=0;//当前位置


//    @SuppressLint("NewApi")
//    public void transformPage(View view, float position)
//    {
//        int pageWidth = view.getWidth();
//        int pageHeight = view.getHeight();
//        if (Math.abs(currP-position)>1){
//            view.setScaleX(pageWidth);
//            view.setScaleY(pageHeight);
//            Log.e(TAG, "transformPage: 远---------------------------" );
//        }else{
//            Log.e(TAG, "transformPage: 近---------------------------" );
//
//
////        Log.e("TAG", view + " , " + position + "");
//
//        if (position < -1)
//        { // [-Infinity,-1)
//            // This page is way off-screen to the left.
//            view.setAlpha(0);
//
//        } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
//        { // [-1,1]
//            // Modify the default slide transition to shrink the page as well
//            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
//            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
//            if (position < 0)
//            {
//                view.setTranslationX(horzMargin - vertMargin / 2);
//            } else
//            {
//                view.setTranslationX(-horzMargin + vertMargin / 2);
//            }
//
//            // Scale the page down (between MIN_SCALE and 1)
//            view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
//
//            // Fade the page relative to its size.
//            view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
//                    / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
//
//        } else
//        { // (1,+Infinity]
//            // This page is way off-screen to the right.
//            view.setAlpha(0);
//        }

//        }
//       currP=position;
//    }
}