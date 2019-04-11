package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.nvh.hoannguyen.hoctienganh.Lop1.Exam;
import com.nvh.hoannguyen.hoctienganh.Lop1.ExamAdapter;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;
import com.nvh.hoannguyen.hoctienganh.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TracnghiemFragment extends Fragment {

ExamAdapter examAdapter;
    GridView gvtracnghiem;
    ArrayList<Exam> arr_exam = new ArrayList<Exam>();

    public TracnghiemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Kiểm tra trắc nghiêm");
        return inflater.inflate(R.layout.fragment_tracnghiem, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvtracnghiem= (GridView) getActivity().findViewById(R.id.gvtracnghiem);
        arr_exam.add(new Exam("Lớp 1 - Đề 1"));
        arr_exam.add(new Exam("Lớp 1 - Đề 2"));
        arr_exam.add(new Exam("Lớp 2 - Đề 1"));
        arr_exam.add(new Exam("Lớp 2 - Đề 2"));
        arr_exam.add(new Exam("Lớp 3 - Đề 1"));
        arr_exam.add(new Exam("Lớp 3 - Đề 2"));
        arr_exam.add(new Exam("Lớp 4 - Đề 1"));
        arr_exam.add(new Exam("Lớp 4 - Đề 2"));
        arr_exam.add(new Exam("Lớp 5 - Đề 1"));
        arr_exam.add(new Exam("Lớp 5 - Đề 2"));

        examAdapter=new ExamAdapter(getActivity(),arr_exam);
        gvtracnghiem.setAdapter(examAdapter);
        gvtracnghiem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("sode",i+1);
                intent.putExtra("lop","1");
                intent.putExtra("test","yes");

                startActivity(intent);
            }
        });

    }
}
