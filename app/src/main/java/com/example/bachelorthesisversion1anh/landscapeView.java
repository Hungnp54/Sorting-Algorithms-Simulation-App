package com.example.bachelorthesisversion1anh;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class landscapeView extends AppCompatActivity {
    private LinearLayout landscapeView, landscapeCode;
    private Button lsStart;
    int[] arr;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape_view);

        landscapeView = (LinearLayout) findViewById(R.id.landscapeView);
        landscapeCode = (LinearLayout) findViewById(R.id.landscapeCode);
        lsStart = (Button) findViewById(R.id.lsStartButton);

        int numberElement = getIntent().getIntExtra("number element",1);
        int sortingAl = getIntent().getIntExtra("sorting alogrithm",1);
        int scrHeight = screenDemension.getScreenHeight()-200;
        arr = sortingAlogrithms.generateArrayValue(scrHeight,numberElement);
        int viewWidth = (screenDemension.getScreenWidth())/(2*arr.length)-1;
        drawViews(arr,viewWidth);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void drawViews(int[] viewHeight, int viewWidth) {
        for (int i = 0; i < viewHeight.length; i++) {
            int number = viewHeight[i];
            View view = LayoutInflater.from(landscapeView.this).inflate(R.layout.item_number, null, false);
            view.setBackgroundColor(Color.BLUE);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(viewWidth, number);
            p.setMarginEnd(1);
            view.setLayoutParams(p);
            landscapeView.addView(view);
        }
    }
}
