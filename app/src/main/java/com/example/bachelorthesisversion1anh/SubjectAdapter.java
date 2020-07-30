package com.example.bachelorthesisversion1anh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Subject> subjectList;

    public SubjectAdapter(Context context, int layout, List<Subject> subjectList) {
        this.context = context;
        this.layout = layout;
        this.subjectList = subjectList;
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView txtName = (TextView) convertView.findViewById(R.id.subjectName);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.subjectDescription);
        ImageView imgSubject = (ImageView) convertView.findViewById(R.id.subjectImage);

        Subject subject = subjectList.get(position);

        txtName.setText(subject.getName());
        txtDescription.setText(subject.getDescription());
        imgSubject.setImageResource(subject.getImg());

        return convertView;
    }
}
