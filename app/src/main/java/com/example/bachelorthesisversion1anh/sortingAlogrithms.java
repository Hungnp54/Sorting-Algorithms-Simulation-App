package com.example.bachelorthesisversion1anh;

import android.view.LayoutInflater;
import android.view.View;

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

}
