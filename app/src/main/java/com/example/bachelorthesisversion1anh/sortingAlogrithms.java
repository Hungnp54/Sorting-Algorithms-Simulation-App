package com.example.bachelorthesisversion1anh;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class sortingAlogrithms {
    public  static int[] generateArrayValue(int layoutHeight, int numberElement){
        int[] arrayValue = new int[numberElement];
        int min = 10;
        for(int i = 0; i<numberElement;i++){
            int number =new Random().nextInt(layoutHeight-min+1)+min;
            arrayValue[i]=number;
        }
        return arrayValue;
    }

    public static void quickSort(final int[] arr, final int left,final int right, final LinearLayout currentView){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                quickSort(arr,left,right,currentView);
            }
        });

    }

    public static void swapView(int index1, int index2, LinearLayout currentView){

                View view1 = currentView.getChildAt(index1);
                View view2 = currentView.getChildAt(index2);

                int childCount = currentView.getChildCount();
                View[] children = new View[childCount];
                for (int i = 0; i < childCount; i++) {
                    children[i] = currentView.getChildAt(i);
                }

                currentView.removeAllViews();

                for (int i = 0; i < childCount; i++) {
                    if (i == index1) {
                        currentView.addView(view2);
                    } else if (i == index2) {
                        currentView.addView(view1);
                    } else {
                        currentView.addView(children[i]);
                    }
                }
                currentView.requestLayout();
    }
    public static void highLight(int index, boolean isHighLight, LinearLayout currentView){
        View view = currentView.getChildAt(index);
        if(view != null)
            view.setBackgroundColor(isHighLight ? Color.RED : Color.GREEN);
    }
}