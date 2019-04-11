package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.R;

import java.util.ArrayList;


public class ExamAdapter extends ArrayAdapter<Exam> {

    TextView tvname;
    ImageView imgicon;

    public ExamAdapter(Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        }

        tvname = (TextView) convertView.findViewById(R.id.tvNumExam);
        imgicon = (ImageView) convertView.findViewById(R.id.imgicon);

        Exam p = getItem(position);
        if (p!=null){
            tvname.setText("" + p.getName());
            imgicon.setImageResource(R.drawable.anhsao);
        }


        return convertView;
    }
}
