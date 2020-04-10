package com.example.bachelorthesisversion1anh;

import android.content.res.Resources;

public class screenDemension {
    public static int getScreenWidth(){
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    public static int getScreenHeight(){
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
