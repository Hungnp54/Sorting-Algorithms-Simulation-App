package com.example.bachelorthesisversion1anh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class portaitView extends sortingAlgorithms {
   private LinearLayout portraitView;
   private Button startButton;
    int[] arr;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portait_view);

        portraitView = (LinearLayout) findViewById(R.id.portraitView);
        startButton = (Button) findViewById(R.id.portraitStartButton);
        int numberElement = getIntent().getIntExtra("number element",1);
        final int sortingAl = getIntent().getIntExtra("sorting alogrithm",1);
        //DRAW VIEW
        int scrHeight = (screenDemension.getScreenHeight())/4*3-200;
        arr = generateArrayValue(scrHeight,numberElement);
        int viewWidth = (screenDemension.getScreenWidth())/arr.length-1;
        drawViews(arr,viewWidth);
        //
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDemo(sortingAl,arr, 0,arr.length-1, portraitView);
                startButton.setVisibility(View.GONE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void drawViews(int[] viewHeight, int viewWidth){
        for(int i=0; i<viewHeight.length; i++){
            int number = viewHeight[i];
            View view = LayoutInflater.from(portaitView.this).inflate(R.layout.item_number, null, false);
            view.setBackgroundColor(Color.BLUE);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(viewWidth,number);
            p.setMarginEnd(1);
            view.setLayoutParams(p);
            portraitView.addView(view);
        }

    }
}
