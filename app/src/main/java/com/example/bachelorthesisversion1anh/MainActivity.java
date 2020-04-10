package com.example.bachelorthesisversion1anh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioSelection, radioView;
    EditText numberOfElement;
    Button generateButton;
    int tmp1=0, tmp2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioSelection = (RadioGroup) findViewById(R.id.selectGroup);
        radioView = (RadioGroup) findViewById(R.id.viewGroup);
        numberOfElement = (EditText) findViewById(R.id.editText);
        generateButton = (Button) findViewById(R.id.button);

        //code select alogrithms
        radioSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //id from button
                switch (checkedId){
                    case R.id.quickSort:
                        tmp1 = 1;
                        break;
                    case  R.id.selectGroup:
                        tmp1 = 2;
                        break;
                    case R.id.mergeSort:
                        tmp1 = 3;
                        break;
                    case R.id.bubbleSort:
                        tmp1 = 4;
                        break;
                    case R.id.insertSort:
                        tmp1 = 5;
                        break;
                }
            }
        });
        // code View
        radioView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.portrait:
                       tmp2 = 1;
                        break;
                    case R.id.landscape:
                        tmp2=2;
                        break;
                }
            }
        });

        //BUTTON
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberElement = numberOfElement.getText().toString().trim();
                if(numberElement.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please insert the number elements",Toast.LENGTH_SHORT).show();
                }if(tmp1==0){
                    Toast.makeText(MainActivity.this,"Please select sorting alogrithm",Toast.LENGTH_SHORT).show();
                }if(tmp2==0){
                    Toast.makeText(MainActivity.this,"Please select View",Toast.LENGTH_SHORT).show();
                }
                if(numberElement.isEmpty()==false&&tmp1!=0&&tmp2!=0){
                    int number = Integer.parseInt(numberElement);
                    if(tmp2==1){
                        Intent intent = new Intent(MainActivity.this, portaitView.class);
                        intent.putExtra("number element",number);
                        intent.putExtra("sorting alogrithm", tmp1);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this, landscapeView.class);
                        intent.putExtra("number element",number);
                        intent.putExtra("sorting alogrithm", tmp1);
                        startActivity(intent);
                    }
                }

            }
        });
    }


}
