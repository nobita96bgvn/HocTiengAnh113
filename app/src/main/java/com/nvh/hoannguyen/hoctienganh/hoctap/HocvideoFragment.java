package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nvh.hoannguyen.hoctienganh.Lop1.Hocvideolop1Activity;
import com.nvh.hoannguyen.hoctienganh.Lop2.Hocvideolop2Activity;
import com.nvh.hoannguyen.hoctienganh.Lop3.Hocvideolop3Activity;
import com.nvh.hoannguyen.hoctienganh.Lop4.Hocvideolop4Activity;
import com.nvh.hoannguyen.hoctienganh.Lop5.Hocvideolop5Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HocvideoFragment extends Fragment {

    Button btnhocvideolop1,btnhocvideolop2,btnhocvideolop3,btnhocvideolop4,btnhocvideolop5;

    public HocvideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Học video");
        return inflater.inflate(R.layout.fragment_hocvideo, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnhocvideolop1= (Button) getActivity().findViewById(R.id.btnhocvideolop1);
        btnhocvideolop2= (Button) getActivity().findViewById(R.id.btnhocvideolop2);
        btnhocvideolop3= (Button) getActivity().findViewById(R.id.btnhocvideolop3);
        btnhocvideolop4= (Button) getActivity().findViewById(R.id.btnhocvideolop4);
        btnhocvideolop5= (Button) getActivity().findViewById(R.id.btnhocvideolop5);
        btnhocvideolop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iv1= new Intent(getActivity(), Hocvideolop1Activity.class);
                startActivity(iv1);
            }
        });

        btnhocvideolop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iv2= new Intent(getActivity(), Hocvideolop2Activity.class);
                startActivity(iv2);
            }
        });

        btnhocvideolop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iv3= new Intent(getActivity(), Hocvideolop3Activity.class);
                startActivity(iv3);
            }
        });

        btnhocvideolop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iv4= new Intent(getActivity(), Hocvideolop4Activity.class);
                startActivity(iv4);
            }
        });

        btnhocvideolop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iv5= new Intent(getActivity(), Hocvideolop5Activity.class);
                startActivity(iv5);
            }
        });

    }

}
