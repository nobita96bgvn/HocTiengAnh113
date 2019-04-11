package com.nvh.hoannguyen.hoctienganh.Lop2;

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

public class Hoctuvunglop2Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<Baihoctuvung> arrayBaihoc;
    BaihocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoctuvunglop1);
        lv = (ListView) findViewById(R.id.lisstviewbaihoc);

        arrayBaihoc = new ArrayList<>();
        arrayBaihoc.add(new Baihoctuvung("Bai 1: Food","Ice Cream, Rice",R.drawable.bai3));
        arrayBaihoc.add(new Baihoctuvung("Bai 2: Flower ","Rose, Daisy",R.drawable.bai4));
        arrayBaihoc.add(new Baihoctuvung("Bai 3: Fruit","Orange, Lemon",R.drawable.bai5));
        arrayBaihoc.add(new Baihoctuvung("Bai 4: Family","Mother, Father",R.drawable.bai6));
        arrayBaihoc.add(new Baihoctuvung("Bai 5: Zoo ","Monkey, Elephent",R.drawable.bai7));


        adapter = new BaihocAdapter(this,R.layout.dong_baihoc1,arrayBaihoc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent in = new Intent(view.getContext(),baihoctuvung1lop2.class);
                    startActivityForResult(in,0);
                }

            }
        });
    }
}
