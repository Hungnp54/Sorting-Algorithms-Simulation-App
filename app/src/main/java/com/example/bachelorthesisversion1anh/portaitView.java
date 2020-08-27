package com.example.bachelorthesisversion1anh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class portaitView extends sortingAlgorithms {
   private LinearLayout portraitView, portraitCodeView;
   private Button startButton;
    int[] arr;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portait_view);

        portraitView = (LinearLayout) findViewById(R.id.portraitView);
        portraitCodeView = (LinearLayout)findViewById(R.id.portraitCodeView);
        startButton = (Button) findViewById(R.id.portraitStartButton);
        int numberElement = getIntent().getIntExtra("number element",1);
        final int sortingAl = getIntent().getIntExtra("sorting alogrithm",1);
        //DRAW VIEW
        int scrHeight = (screenDemension.getScreenHeight())/4*3-200;
        arr = generateArrayValue(scrHeight,numberElement);
        int viewWidth = (screenDemension.getScreenWidth())/arr.length-1;
        portraitCodeView.setVisibility(View.INVISIBLE);
        drawViews(arr,viewWidth);
        //Click Start button to run program
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runProgram(sortingAl,arr, 0,arr.length-1, portraitView, portraitCodeView);
                startButton.setVisibility(View.GONE);
            }
        });
    }
//Draw View on Screen
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void drawViews(int[] viewHeight, int viewWidth){
        for (int number : viewHeight) {
            View view = LayoutInflater.from(portaitView.this).inflate(R.layout.item_number, null, false);
            view.setBackgroundColor(Color.parseColor("#0277bd"));
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(viewWidth, number);
            p.setMarginEnd(1);
            view.setLayoutParams(p);
            portraitView.addView(view);
        }

    }
}
