package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nvh.hoannguyen.hoctienganh.Lop1.Cau1KiemtratonghopLop1Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KiemtratonghopFragment extends Fragment {


    ImageButton imbtnthlop1,imbtnthlop2,imbtnthlop3,imbtnthlop4,imbtnthlop5;

    public KiemtratonghopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Kiểm tra tổng hợp");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kiemtratonghop, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imbtnthlop1 = (ImageButton) getActivity().findViewById(R.id.imbtnthlop1);

        imbtnthlop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentth1 = new Intent(getActivity(), Cau1KiemtratonghopLop1Activity.class);
                startActivity(intentth1);
            }
        });
    }

}
