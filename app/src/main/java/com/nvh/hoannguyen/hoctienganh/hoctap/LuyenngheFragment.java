package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nvh.hoannguyen.hoctienganh.Lop1.Luyennghelop1Activity;
import com.nvh.hoannguyen.hoctienganh.Lop2.Luyennghelop2Activity;
import com.nvh.hoannguyen.hoctienganh.Lop3.Luyennghelop3Activity;
import com.nvh.hoannguyen.hoctienganh.Lop4.Luyennghelop4Activity;
import com.nvh.hoannguyen.hoctienganh.Lop5.Luyennghelop5Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuyenngheFragment extends Fragment {

    Button btnluyennghelop1,btnluyennghelop2,btnluyennghelop3,btnluyennghelop4,btnluyennghelop5;

    public LuyenngheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Luyện nghe");
        return inflater.inflate(R.layout.fragment_luyennghe, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnluyennghelop1= (Button) getActivity().findViewById(R.id.btnluyennghelop1);
        btnluyennghelop2= (Button) getActivity().findViewById(R.id.btnluyennghelop2);
        btnluyennghelop3= (Button) getActivity().findViewById(R.id.btnluyennghelop3);
        btnluyennghelop4= (Button) getActivity().findViewById(R.id.btnluyennghelop4);
        btnluyennghelop5= (Button) getActivity().findViewById(R.id.btnluyennghelop5);
        btnluyennghelop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1= new Intent(getActivity(), Luyennghelop1Activity.class);
                startActivity(in1);
            }
        });

        btnluyennghelop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2= new Intent(getActivity(), Luyennghelop2Activity.class);
                startActivity(in2);
            }
        });

        btnluyennghelop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3= new Intent(getActivity(), Luyennghelop3Activity.class);
                startActivity(in3);
            }
        });

        btnluyennghelop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4= new Intent(getActivity(), Luyennghelop4Activity.class);
                startActivity(in4);
            }
        });

        btnluyennghelop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in5= new Intent(getActivity(), Luyennghelop5Activity.class);
                startActivity(in5);
            }
        });

    }

}
