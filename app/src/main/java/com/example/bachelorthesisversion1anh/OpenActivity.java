package com.example.bachelorthesisversion1anh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OpenActivity extends AppCompatActivity {
    ListView listSubject;
    ArrayList<Subject> arraySubject;
    SubjectAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        inputSubject();

        adapter = new SubjectAdapter(this,R.layout.subject_line, arraySubject);
        listSubject.setAdapter(adapter);

        listSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(OpenActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(OpenActivity.this,"Example Test 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(OpenActivity.this,"Example Test 2", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    private void inputSubject(){
        listSubject = (ListView) findViewById(R.id.ListSubject);
        arraySubject = new ArrayList<>();

        arraySubject.add(new Subject("Algorithms and Data structure", "Sorting Algorithms Visualization",R.drawable.algo3));
        arraySubject.add(new Subject("Example Name", "Example Description",R.drawable.algo1));
        arraySubject.add(new Subject("Example Name", "Example Description",R.drawable.algo2));
    }
}
