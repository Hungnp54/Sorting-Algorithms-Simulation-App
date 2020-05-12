package com.example.bachelorthesisversion1anh;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class sortingAlgorithms extends AppCompatActivity {
    public int[] generateArrayValue(int layoutHeight, int numberElement){
        int[] arrayValue = new int[numberElement];
        int min = 10;
        for(int i = 0; i<numberElement;i++){
            int number =new Random().nextInt(layoutHeight-min+1)+min;
            arrayValue[i]=number;
        }
        return arrayValue;
    }

    public void testDemo(final int method, final int[] arr, final int left, final int right, final LinearLayout currentView1, final LinearLayout currentView2){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                switch (method) {
                    case 1:

                        quickSort(arr, left, right, currentView1);
                        break;
                    case 2:
                        selectionSort(arr, currentView1);
                        break;
                    case 3:
                        mergeSort(arr, left, right, currentView1);
                        break;
                    case 4:
                        addBubbleSortCode(currentView2);
                        bubbleSort(arr, currentView1, currentView2);
                        break;
                    case 5:
                        insertionSort(arr, currentView1);
                        break;
                }

            }
        });
        thread.start();
    }


    //Sorting Algorithms
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
               // swapNumber(arr[i],arr[j]);
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
    public void selectionSort(int[] arr, LinearLayout currentView){
        int tmp = arr.length;
        for (int i=0; i < tmp-1; i++){
            int min = i;
            for(int j=i+1 ; j < tmp ; j++ ) {
                if (arr[j] < arr[min])
                    min = j;
            }

                    //swapNumber(arr[i], arr[min]);
                    highLight(i, true,currentView);
                    highLight(min, true,currentView);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                    highLight(i, false,currentView);
                    highLight(min, false,currentView);
                    swapView(i, min, currentView);
        }

    }

    public void mergeSort(int[] arr, int left, int right, LinearLayout currentView){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr, left, middle, currentView);
            mergeSort(arr,middle+1, right, currentView);
            merge(arr,left,middle,right,currentView);
        }
    }
    public void merge(int[] arr, int left, int middle, int right, LinearLayout currentView){

                int[] arrTemp = new int[right-left+1];
                int[] viewTemp = new int[right-left+1];
                int i, j, k =0;
                i = left;
                j=middle+1;

                while((i<middle+1)&&(j<right+1)){
                    if(arr[i]<arr[j]){
                        arrTemp[k] = arr[i];
                        viewTemp[k] = i;
                        k++;
                        i++;

                    }
                    else{
                        arrTemp[k]=arr[j];
                        viewTemp[k] = j;
                        k++;
                        j++;
                    }
                }

                while(i<middle+1){
                    arrTemp[k]=arr[i];
                    viewTemp[k] = i;
                    k++;
                    i++;
                }
                while(j<right+1){
                    arrTemp[k]=arr[j];
                    viewTemp[k] = j;
                    k++;
                    j++;
                }
                i = left;
                for(k=0; k<(right-left+1); k++){
                    arr[i] = arrTemp[k];
                    i++;
                    highLight(viewTemp[k], true,currentView);
                }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(k=0; k<(right-left+1); k++){

            highLight(viewTemp[k], false,currentView);
        }

                addView(left, viewTemp,currentView);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insertionSort(int[] arr, LinearLayout currentView){
        int i, key, j;
        for (i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;
            highLight(j, true,currentView);
            highLight(j+1, true,currentView);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                highLight(j, true,currentView);
                highLight(j+1, true,currentView);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                swapView(j, j+1, currentView);
                highLight(j, false,currentView);
                highLight(j+1, false,currentView);
                j--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            highLight(j, false,currentView);
            highLight(j+1, false,currentView);
            arr[j + 1] = key;
        }
    }

    public void bubbleSort(int[] arr, LinearLayout currentView, LinearLayout currentView2){
        int i, j;
        int n = arr.length;
        for (i = 0; i < n-1; i++)
            // Last i elements are already in place
            for (j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    highLight(j, true,currentView);
                    highLight(j+1, true,currentView);
                    highLightCode(2,true,currentView2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    highLightCode(2,false,currentView2);
                    highLightCode(3,true,currentView2);
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapView(j, j+1, currentView);
                    highLight(j, false,currentView);
                    highLight(j+1, false,currentView);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    highLightCode(3,false,currentView2);
                }
            }
    }

    @SuppressLint("SetTextI18n")
    public void addBubbleSortCode(LinearLayout currentView){
        TextView tView1 = new TextView(this);
        tView1.setText(" "+"int i, j;\n"+"int n = arr.length;\n"+"// Last i elements are already in place\n"+"for (i = 0; i < n-1; i++)");
        currentView.addView(tView1);
        TextView tView2 = new TextView(this);
        tView2.setText(" "+"\tfor (j = 0; j < n-i-1; j++) {\n" +
                "                if (arr[j] > arr[j + 1]) {");
        currentView.addView(tView2);
        TextView tView3 = new TextView(this);
        tView3.setText("             int tmp = arr[j];\n" +
                "                    arr[j] = arr[j+1];\n" +
                "                    arr[j+1] = tmp;");
        currentView.addView(tView3);

    }

    //support Methods
    public void swapView(final int index1, final int index2, final LinearLayout currentView){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View view1 = currentView.getChildAt(index1);
                View view2 = currentView.getChildAt(index2);
// create a copy of current view
                int childCount = currentView.getChildCount();
                View[] children = new View[childCount];
                for (int i = 0; i < childCount; i++) {
                    children[i] = currentView.getChildAt(i);
                }
// remove the old view
                currentView.removeAllViews();
//add the new one to the screen
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
    public void highLightCode(final int index, final boolean isHighLight, final LinearLayout currentView){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View view = currentView.getChildAt(index);
                if(view != null)
                    view.setBackgroundColor(isHighLight ? Color.YELLOW : Color.TRANSPARENT);
            }
        });
    }

    public void addView(final int position, final int[] arrView, final LinearLayout currentView){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//view temp
                int n = arrView.length;
                int k = 0;
                int j = position;
                View[] viewTemp = new View[n];
                for (int i = 0; i < n; i++) {
                    viewTemp[i] = currentView.getChildAt(arrView[i]);
                }
//make a copy of temp view
                int childCount = currentView.getChildCount();
                View[] children = new View[childCount];
                for (int i = 0; i < childCount; i++) {
                    children[i] = currentView.getChildAt(i);
                }
// remove the old view
                currentView.removeAllViews();
//add the new one to the screen
                for (int i = 0; i < childCount; i++) {
                    if (i == j && k < n) {
                        currentView.addView(viewTemp[k]);
                        j++;
                        k++;
                    }
                     else {
                        currentView.addView(children[i]);
                    }
                }
                currentView.requestLayout();
            }
        });
    }
}