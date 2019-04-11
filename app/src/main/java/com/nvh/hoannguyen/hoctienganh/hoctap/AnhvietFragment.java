package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

import static com.nvh.hoannguyen.hoctienganh.R.id.web;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnhvietFragment extends Fragment {
WebView webView;

    public AnhvietFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Từ điển Anh - Việt");
        return inflater.inflate(R.layout.fragment_anhviet, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView = (WebView) getActivity().findViewById(web);
        //https://translate.google.com/?hl=vi
       webView.loadUrl("https://translate.google.com/?hl=vi");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
    }
}
