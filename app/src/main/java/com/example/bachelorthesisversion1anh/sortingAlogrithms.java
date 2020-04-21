package com.example.bachelorthesisversion1anh;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class sortingAlogrithms extends AppCompatActivity {
    public int[] generateArrayValue(int layoutHeight, int numberElement){
        int[] arrayValue = new int[numberElement];
        int min = 10;
        for(int i = 0; i<numberElement;i++){
            int number =new Random().nextInt(layoutHeight-min+1)+min;
            arrayValue[i]=number;
        }
        return arrayValue;
    }

    public void testDemo(final int method, final int[] arr, final int left, final int right, final LinearLayout currentView){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(method == 1)
                    quickSort(arr, left, right, currentView);
                else
                    Toast.makeText(sortingAlogrithms.this,"Wrong",Toast.LENGTH_SHORT).show();
            }
        });
        thread.start();
    }

    public void quickSort(int[] arr, int left, int right, LinearLayout currentView){
        if(arr==null || arr.length == 0)
            return;
        if(left >= right)
            return;
        int middle = left + (right - left)/2;
        int pivot = arr[middle];
        int i=left, j=right;
        while (i <= j){
            while(arr[i]<pivot) {
                i++;
            }
            while(arr[j]>pivot) {
                j--;
            }
            if(i<=j){
                highLight(i, true,currentView);
                highLight(j, true,currentView);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                highLight(i, false,currentView);
                highLight(j, false,currentView);

                swapView(i, j, currentView);

                i++;
                j--;
            }
        }

        if(left < j)
            quickSort(arr,left,j,currentView);
        if(right > i)
            quickSort(arr, i, right, currentView);

    }


    public void swapView(final int index1, final int index2, final LinearLayout currentView){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
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
            });
    }
    public void highLight(final int index, final boolean isHighLight, final LinearLayout currentView){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View view = currentView.getChildAt(index);
                if(view != null)
                    view.setBackgroundColor(isHighLight ? Color.RED : Color.GREEN);
            }
        });

    }
}