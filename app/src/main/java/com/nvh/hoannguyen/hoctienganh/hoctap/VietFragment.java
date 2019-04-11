package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nvh.hoannguyen.hoctienganh.Lop1.Cau1De1KiemtravietLop1Activity;
import com.nvh.hoannguyen.hoctienganh.Lop1.Cau1De2KiemtravietLop1Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VietFragment extends Fragment {

    Button btnlop1de1,btnlop1de2,btnlop2de1,btnlop2de2,btnlop3de1,btnlop3de2,btnlop4de1,btnlop4de2,btnlop5de1,btnlop5de2;

    public VietFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Kiểm tra viết");
        return inflater.inflate(R.layout.fragment_viet, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnlop1de1=(Button) getActivity().findViewById(R.id.btnlop1de1);
        btnlop1de2=(Button) getActivity().findViewById(R.id.btnlop1de2);
        btnlop2de1=(Button) getActivity().findViewById(R.id.btnlop2de1);
        btnlop2de2=(Button) getActivity().findViewById(R.id.btnlop2de2);
        btnlop3de1=(Button) getActivity().findViewById(R.id.btnlop3de1);
        btnlop3de2=(Button) getActivity().findViewById(R.id.btnlop3de2);
        btnlop4de1=(Button) getActivity().findViewById(R.id.btnlop4de1);
        btnlop4de2=(Button) getActivity().findViewById(R.id.btnlop4de2);
        btnlop5de1=(Button) getActivity().findViewById(R.id.btnlop5de1);
        btnlop5de2=(Button) getActivity().findViewById(R.id.btnlop5de2);

        btnlop1de1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentv1=new Intent(getActivity(), Cau1De1KiemtravietLop1Activity.class);
                startActivity(intentv1);
            }
        });

        btnlop1de2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentv2=new Intent(getActivity(), Cau1De2KiemtravietLop1Activity.class);
                startActivity(intentv2);
            }
        });
    }

}
