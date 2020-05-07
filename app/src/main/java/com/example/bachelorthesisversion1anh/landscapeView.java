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

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;

public class landscapeView extends sortingAlgorithms {
    private LinearLayout landscapeView, landscapeCode;
    private Button lsStart;
    private CodeView codeView;
    int[] arr;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape_view);

        codeView = (CodeView) findViewById(R.id.code_view);
        landscapeView = (LinearLayout) findViewById(R.id.landscapeView);
        //landscapeCode = (LinearLayout) findViewById(R.id.landscapeCode);
        lsStart = (Button) findViewById(R.id.lsStartButton);

        int numberElement = getIntent().getIntExtra("number element", 1);
        final int sortingAl = getIntent().getIntExtra("sorting alogrithm", 1);
        int scrHeight = screenDemension.getScreenHeight() - 200;
        arr = generateArrayValue(scrHeight, numberElement);
        int viewWidth = (screenDemension.getScreenWidth()) / (2 * arr.length) - 1;
        drawViews(arr, viewWidth);


        lsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                testDemo(sortingAl, arr, 0, arr.length - 1, landscapeView);

                lsStart.setVisibility(View.GONE);
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                codeView.setCode("" +
                        "package io.github.kbiakov.codeviewexample;\n" +
                        "\n" +
                        "import android.os.Bundle;\n" +
                        "import android.support.annotation.Nullable;\n" +
                        "import android.support.v7.app.AppCompatActivity;\n" +
                        "import android.util.Log;\n" +
                        "\n" +
                        "import org.jetbrains.annotations.NotNull;\n" +
                        "\n" +
                        "import io.github.kbiakov.codeview.CodeView;\n" +
                        "import io.github.kbiakov.codeview.OnCodeLineClickListener;\n" +
                        "import io.github.kbiakov.codeview.adapters.CodeWithDiffsAdapter;\n" +
                        "import io.github.kbiakov.codeview.adapters.Options;\n" +
                        "import io.github.kbiakov.codeview.highlight.ColorTheme;\n" +
                        "import io.github.kbiakov.codeview.highlight.ColorThemeData;\n" +
                        "import io.github.kbiakov.codeview.highlight.Font;\n" +
                        "import io.github.kbiakov.codeview.highlight.FontCache;\n" +
                        "import io.github.kbiakov.codeview.views.DiffModel;\n" +
                        "\n" +
                        "public class ListingsActivity extends AppCompatActivity {\n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected void onCreate(@Nullable Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.activity_listings);\n" +
                        "\n" +
                        "        final CodeView codeView = (CodeView) findViewById(R.id.code_view);\n" +
                        "\n" +
                        "        /*\n" +
                        "         * 1: set code content\n" +
                        "         */\n" +
                        "\n" +
                        "        // auto language recognition\n" +
                        "        codeView.setCode(getString(R.string.listing_js));\n" +
                        "\n" +
                        "        // specify language for code listing\n" +
                        "        codeView.setCode(getString(R.string.listing_py), \"py\");" +
                        "    }\n" +
                        "}", "java");

            }
        });
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
