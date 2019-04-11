package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VietanhFragment extends Fragment {


    public VietanhFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Từ điển Việt - Anh");
        return inflater.inflate(R.layout.fragment_vietanh, container, false);
    }

}
