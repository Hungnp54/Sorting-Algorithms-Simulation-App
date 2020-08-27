package com.example.bachelorthesisversion1anh;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class sortingAlgorithms extends AppCompatActivity {
    //Method to generate a random array based on maximum height of bars and number of elements
    public int[] generateArrayValue(int layoutHeight, int numberElement){
        int[] arrayValue = new int[numberElement];
        int min = 10;
        for(int i = 0; i<numberElement;i++){
            int number =new Random().nextInt(layoutHeight-min+1)+min;
            arrayValue[i]=number;
        }
        return arrayValue;
    }
//main method to run program
    public void runProgram(final int method, final int[] arr, final int left, final int right, final LinearLayout currentView, final LinearLayout codeView){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                switch (method) {
                    case 1:
                        addQuickSortCode(codeView);
                        quickSort(arr, left, right, currentView, codeView);
                        break;
                    case 2:
                        addSelectionSortCode(codeView);
                        selectionSort(arr, currentView, codeView);
                        break;
                    case 3:
                        addMergeSortCode(codeView);
                        mergeSort(arr, left, right, currentView, codeView);
                        break;
                    case 4:
                        addBubbleSortCode(codeView);
                        bubbleSort(arr, currentView, codeView);
                        break;
                    case 5:
                        addInsertionSortCode(codeView);
                        insertionSort(arr, currentView,codeView);
                        break;
                }
            }
        });
        thread.start();
    }

    //Sorting Algorithms and code View
    public void quickSort(int[] arr, int left, int right, LinearLayout currentView, LinearLayout codeView){
        if(arr==null || arr.length == 0)
            return;
        if(left >= right)
            return;
        int middle = left + (right - left)/2;
        int pivot = arr[middle];
        int i=left, j=right;
        highLight(middle,true, currentView);

        while (i <= j){
            while(arr[i]<pivot) {
                i++;
            }
            while(arr[j]>pivot) {
                j--;
            }
            if(i<=j){
                wait(1000);
                highLight(i, true,currentView);
                highLight(j, true,currentView);
                highLightCode(1, true, codeView);
                highLightCode(2, true, codeView);

                wait(1000);
               // swapNumber(arr[i],arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                highLightCode(1, false, codeView);
                highLightCode(2, false, codeView);
                highLight(i, false,currentView);
                highLight(j, false,currentView);
                swapView(i, j, currentView);
                i++;
                j--;
            }
        }
        wait(1000);
        highLightCode(3,true, codeView);
        highLight(middle,false,currentView);
        wait(1000);
        highLightCode(3,false, codeView);

        if(left < j)
            quickSort(arr,left,j,currentView, codeView);
        if(right > i)
            quickSort(arr, i, right, currentView, codeView);
    }
    @SuppressLint("SetTextI18n")
    public void addQuickSortCode(LinearLayout currentView){
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tView1 = new TextView(this);
        tView1.setText(""+"public void quickSort(int[] arr, int left, int right){\n"+
                "    int middle = left + (right -left)/2;\n"+
                "    int pivot = arr[middle];\n" +
                "    int i = left, j = right;");
        TextView tView2 = new TextView(this);
        tView2.setText("    "+"while (i <= j) {\n" +
                "        while(arr[i] < pivot) {\n"+
                "            i++;\n"+
                "        }\n"+
                "        while(arr[j] > pivot) {\n"+
                "            j--;\n"+
                "        }");

        TextView tView3 = new TextView(this);
        tView3.setText("        if(i <= j) {\n" +
                "            int temp = arr[i];\n" +
                "            arr[i] = arr[j];\n"+
                "            arr[j] = temp;\n"+
                "            i++;\n"+
                "            j--;\n" +
                "        }");

        TextView tView4 = new TextView(this);
        tView4.setText("    if(left < j)\n"+
                "        quickSort(arr, left, j);\n"+
                "    if(right > i)\n"+
                "        quickSort(arr, i, right)\n"+
                "}");
        tView1.setLayoutParams(p);
        tView2.setLayoutParams(p);
        tView3.setLayoutParams(p);
        tView4.setLayoutParams(p);
        currentView.addView(tView1);
        currentView.addView(tView2);
        currentView.addView(tView3);
        currentView.addView(tView4);
    }
    public void selectionSort(int[] arr, LinearLayout currentView, LinearLayout codeView){
        int tmp = arr.length;
        for (int i=0; i < tmp-1; i++) {
            int min = i;
            highLight(i, true, currentView);
            wait(1000);
            for (int j = i + 1; j < tmp; j++) {
                if (arr[j] < arr[min])
                    min = j;

            }
            highLight(min, true, currentView);

            highLightCode(2, true, codeView);
            wait(1000);

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            swapView(i, min, currentView);
            highLightCode(2, false, codeView);
            highLight(i, false, currentView);
            highLight(min, false, currentView);

            highLightCode(3, true, codeView);
            wait(1000);
            highLightCode(3, false, codeView);
        }

    }
    @SuppressLint("SetTextI18n")
    public void addSelectionSortCode(LinearLayout currentView){
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tView1 = new TextView(this);
        tView1.setText(""+"public void selectionSort(int[] arr){\n"+
                "    int tmp = arr.length;");
        TextView tView2 = new TextView(this);
        tView2.setText("    "+"for (int i=0; i < tmp-1; i++) {\n" +
                "        int min = i;");

        TextView tView3 = new TextView(this);
        tView3.setText("        for (int j = i + 1; j < tmp; j++) {\n" +
                "            if (arr[j] < arr[min])\n" +
                "                min = j;\n"+
                "        }");

        TextView tView4 = new TextView(this);
        tView4.setText("        int temp = arr[i];\n"+
                "        arr[i] = arr[min];\n"+
                "        arr[min] = temp;\n"+
                "    }\n"+
                "}");
        tView1.setLayoutParams(p);
        tView2.setLayoutParams(p);
        tView3.setLayoutParams(p);
        tView4.setLayoutParams(p);
        currentView.addView(tView1);
        currentView.addView(tView2);
        currentView.addView(tView3);
        currentView.addView(tView4);
    }
    public void mergeSort(int[] arr, int left, int right, LinearLayout currentView, LinearLayout codeView){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr, left, middle, currentView, codeView);
            mergeSort(arr,middle+1, right, currentView, codeView);
            merge(arr,left,middle,right,currentView, codeView);
        }
    }
    public void merge(int[] arr, int left, int middle, int right, LinearLayout currentView, LinearLayout codeView){

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
                    highLightCode(1,true, codeView);
                }
        wait(1000);
                highLightCode(1, false,codeView);
        for(k=0; k<(right-left+1); k++){
            highLight(viewTemp[k], false,currentView);
            highLightCode(2,true, codeView);
        }
                addView(left, viewTemp,currentView);
        wait(1000);
        highLightCode(2, false, codeView);
    }
    @SuppressLint("SetTextI18n")
    public void addMergeSortCode(LinearLayout currentView){
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tView1 = new TextView(this);
        tView1.setText(""+"void mergeSort(int[] arr, int left, int right){\n"+"    //At the beginning left = 0 and right = arr.length -1\n"+"    if(left < right){");
        TextView tView2 = new TextView(this);
        tView2.setText("        int middle = (left + right)/2;\n"+
                       "        mergeSort(arr, left, middle);\n"+
                       "        mergeSort(arr, middle+1, right);");

        TextView tView3 = new TextView(this);
        tView3.setText("        Merge(arr, left, middle, right);\n"+
                "    }\n"+
                "}");

        TextView tView4 = new TextView(this);
        tView4.setText("public void merge(int[] arr, int left, int middle, int right){\n" +
                "\n" +
                "                int[] arrTemp = new int[right-left+1];\n"+
                "                int i, j, k =0;\n" +
                "                i = left;\n" +
                "                j=middle+1;\n" +
                "                while((i<middle+1)&&(j<right+1)){\n" +
                "                    if(arr[i]<arr[j]){\n" +
                "                        arrTemp[k] = arr[i];\n" +
                "                        k++;\n" +
                "                        i++;\n" +
                "                    }\n" +
                "                    else{\n" +
                "                        arrTemp[k]=arr[j];\n" +
                "                        k++;\n" +
                "                        j++;\n" +
                "                    }\n" +
                "                }\n" +
                "                while(i<middle+1){\n" +
                "                    arrTemp[k]=arr[i];\n" +
                "                    k++;\n" +
                "                    i++;\n" +
                "                }\n" +
                "                while(j<right+1){\n" +
                "                    arrTemp[k]=arr[j];\n" +
                "                    k++;\n" +
                "                    j++;\n" +
                "                }\n" +
                "                i = left;\n" +
                "                for(k=0; k<(right-left+1); k++){\n" +
                "                    arr[i] = arrTemp[k];\n" +
                "                    i++;\n" +
                "                }\n"+
                "    }");
        tView1.setLayoutParams(p);
        tView2.setLayoutParams(p);
        tView3.setLayoutParams(p);
        tView4.setLayoutParams(p);
        currentView.addView(tView1);
        currentView.addView(tView2);
        currentView.addView(tView3);
        currentView.addView(tView4);
    }
    public void insertionSort(int[] arr, LinearLayout currentView, LinearLayout codeView){
        int i, key, j;
        for (i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;
            highLight(i, true,currentView);
           // highLight(j+1, true,currentView);
            highLightCode(1,true,codeView);
            wait(1000);
            highLightCode(1,false,codeView);
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                highLight(j, true,currentView);
                highLight(j+1, true,currentView);
                highLightCode(2,true,codeView);
                wait(1000);
                highLightCode(2,false,codeView);
                swapView(j, j+1, currentView);
                highLight(j, false,currentView);
                highLight(j+1, false,currentView);
                j--;
                wait(1000);
                highLightCode(2,false,codeView);
            }
            highLightCode(3,true,codeView);
            highLight(j, false,currentView);
            highLight(j+1, false,currentView);
            arr[j + 1] = key;
            wait(1000);
            highLightCode(3,false,codeView);

        }
    }
    @SuppressLint("SetTextI18n")
    public void addInsertionSortCode(LinearLayout codeView){
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tView1 = new TextView(this);
        tView1.setText("int i, key, j;\n" + "for (i = 1; i < arr.length; i++){");

        TextView tView2 = new TextView(this);
        tView2.setText("    key = arr[i];\n" +
                "    j = i - 1;");

        TextView tView3 = new TextView(this);
        tView3.setText("    while (j >= 0 && arr[j] > key){\n" +
                "        arr[j + 1] = arr[j];\n"+
                "        j--;\n"+
                "    }");

        TextView tView4 = new TextView(this);
        tView4.setText("    arr[j + 1] = key;\n" +
                "}");

        tView1.setLayoutParams(p);
        tView2.setLayoutParams(p);
        tView3.setLayoutParams(p);
        tView4.setLayoutParams(p);
        codeView.addView(tView1);
        codeView.addView(tView2);
        codeView.addView(tView3);
        codeView.addView(tView4);
    }
    public void bubbleSort(int[] arr, LinearLayout currentView,LinearLayout codeView){
        int i, j;
        int n = arr.length;
        for (i = 0; i < n-1; i++)
            // Last i elements are already in place
            for (j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    highLight(j, true,currentView);
                    highLight(j+1, true,currentView);
                    highLightCode(1,true,codeView);
                    wait(1000);
                    highLightCode(1,false,codeView);
                    highLightCode(2,true,codeView);
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapView(j, j+1, currentView);
                    highLight(j, false,currentView);
                    highLight(j+1, false,currentView);
                    wait(1000);
                    highLightCode(2,false,codeView);
                }
            }
    }
    @SuppressLint("SetTextI18n")
    public void addBubbleSortCode(LinearLayout currentView){
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tView1 = new TextView(this);
        tView1.setText(""+"int i, j;\n"+"int n = arr.length;\n"+"for (i = 0; i < n-1; i++)");
        TextView tView2 = new TextView(this);
        tView2.setText("    "+"for (j = 0; j < n-i-1; j++) {\n" +
                "        if (arr[j] > arr[j + 1]) {");

        TextView tView3 = new TextView(this);
        tView3.setText("            int tmp = arr[j];\n" +
                "            arr[j] = arr[j+1];\n" +
                "            arr[j+1] = tmp;\n"+
                "        }\n"+
                "    }");
        tView1.setLayoutParams(p);
        tView2.setLayoutParams(p);
        tView3.setLayoutParams(p);
        currentView.addView(tView1);
        currentView.addView(tView2);
        currentView.addView(tView3);
    }

    //support Methods
    public void wait(int tmp){
        try {
            Thread.sleep(tmp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
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
                    view.setBackgroundColor(isHighLight ? Color.parseColor("#C70E3F") : Color.parseColor("#04B925"));
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