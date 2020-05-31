package com.example.bachelorthesisversion1anh;

import androidx.annotation.RequiresApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class landscapeView extends sortingAlgorithms {
    private LinearLayout landscapeView, landscapeCode;
    private Button lsStart;
    private ScrollView codeView;
    int[] arr;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape_view);

        landscapeView = (LinearLayout) findViewById(R.id.landscapeView);
        landscapeCode = (LinearLayout) findViewById(R.id.landscapeCode);
        lsStart = (Button) findViewById(R.id.lsStartButton);
        //codeView = (ScrollView) findViewById(R.id.scrollView);

        int numberElement = getIntent().getIntExtra("number element",1);
        final int sortingAl = getIntent().getIntExtra("sorting alogrithm",1);
        int scrHeight = screenDemension.getScreenHeight()-200;
        arr = generateArrayValue(scrHeight,numberElement);
        int viewWidth = (screenDemension.getScreenWidth())/(2*arr.length);
        drawViews(arr,viewWidth);

        lsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testDemo(sortingAl, arr, 0, arr.length-1, landscapeView, landscapeCode);
                lsStart.setVisibility(View.GONE);
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void drawViews(int[] viewHeight, int viewWidth) {
        for (int number : viewHeight) {
            View view = LayoutInflater.from(landscapeView.this).inflate(R.layout.item_number, null, false);
            view.setBackgroundColor(Color.BLUE);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(viewWidth, number);
            p.setMarginEnd(1);
            view.setLayoutParams(p);
            landscapeView.addView(view);
        }
    }
}
