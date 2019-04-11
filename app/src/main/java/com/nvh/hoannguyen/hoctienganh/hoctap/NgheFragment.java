package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nvh.hoannguyen.hoctienganh.Lop1.Cau1KiemtrangheLop1Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NgheFragment extends Fragment {

    ImageButton imbtnlop1,imbtnlop2,imbtnlop3,imbtnlop4,imbtnlop5;

    public NgheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Kiểm tra nghe");
        return inflater.inflate(R.layout.fragment_nghe, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imbtnlop1=(ImageButton) getActivity().findViewById(R.id.imbtnlop1);

        imbtnlop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentn1=new Intent(getActivity(), Cau1KiemtrangheLop1Activity.class);
                startActivity(intentn1);
            }
        });

    }

}
