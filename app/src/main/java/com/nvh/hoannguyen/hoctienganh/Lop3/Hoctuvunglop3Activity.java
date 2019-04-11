package com.nvh.hoannguyen.hoctienganh.Lop3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nvh.hoannguyen.hoctienganh.Lop1.BaihocAdapter;
import com.nvh.hoannguyen.hoctienganh.Lop1.Baihoctuvung;
import com.nvh.hoannguyen.hoctienganh.R;

import java.util.ArrayList;

public class Hoctuvunglop3Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<Baihoctuvung> arrayBaihoc;
    BaihocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoctuvunglop1);
        lv = (ListView) findViewById(R.id.lisstviewbaihoc);

        arrayBaihoc = new ArrayList<>();
        arrayBaihoc.add(new Baihoctuvung("Bai 1: Weather","Sunny, Winny",R.drawable.bai3));
        arrayBaihoc.add(new Baihoctuvung("Bai 2: What is it?","Windows, Lag",R.drawable.bai4));
        arrayBaihoc.add(new Baihoctuvung("Bai 3: Hopital","car",R.drawable.bai5));
        arrayBaihoc.add(new Baihoctuvung("Bai 4: Road","Left, Right",R.drawable.bai6));
        arrayBaihoc.add(new Baihoctuvung("Bai 5: Beach? ","doll, gray",R.drawable.bai7));


        adapter = new BaihocAdapter(this,R.layout.dong_baihoc1,arrayBaihoc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent in = new Intent(view.getContext(),baihoctuvung1lop3.class);
                    startActivityForResult(in,0);
                }

            }
        });
    }
}
