package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nvh.hoannguyen.hoctienganh.R;

import java.util.ArrayList;

public class Hoctuvunglop1Activity extends AppCompatActivity {
    ListView lv;
    //Sử dụng ListView để hiển thị danh sách bài học từ vựng theo chủ đề
    ArrayList<Baihoctuvung> arrayBaihoc;
    //Dùng mảng để lưu trữ các bài học
    BaihocAdapter adapter;
    //Dùng Adapter để lấy dữ liệu trong arrayBaihoc và hiển thị dữ liệu trên ListView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoctuvunglop1);
        lv = (ListView) findViewById(R.id.lisstviewbaihoc);
        //ánh xạ
        //Thêm dữ liệu vào mảng arrayBaihoc
        arrayBaihoc = new ArrayList<>();
        arrayBaihoc.add(new Baihoctuvung("Bai 1: English Alphabet","A B C ",R.drawable.bai3));
        arrayBaihoc.add(new Baihoctuvung("Bai 2: House","desk, broom",R.drawable.bai4));
        arrayBaihoc.add(new Baihoctuvung("Bai 3: Number","one, two, three",R.drawable.bai5));
        arrayBaihoc.add(new Baihoctuvung("Bai 4: Vihicle","Plane, train, truck",R.drawable.bai6));
            arrayBaihoc.add(new Baihoctuvung("Bai 5: Color ","black, red, gray",R.drawable.bai7));
        arrayBaihoc.add(new Baihoctuvung("Bai 6: Animal","Cat, dog",R.drawable.bai3));
        arrayBaihoc.add(new Baihoctuvung("Bai 7: Fruit","Lemon, cherry, banana",R.drawable.bai4));
        arrayBaihoc.add(new Baihoctuvung("Bai 8: School","Board, pen, bag",R.drawable.bai5));

        adapter = new BaihocAdapter(this,R.layout.dong_baihoc1,arrayBaihoc);
        // Gán Data Source (ArrayList object) vào ArrayAdapter
        lv.setAdapter(adapter);
        // gán Adapter vào ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Xử lý sự kiện chọn một phần tử trong ListView
                // với mỗi phần tử ( vị trí ) khi người dùng nhấn vào sẽ dùng Intent để schuyển đến bài học tương ứng
                if(position == 0){
                    Intent in = new Intent(view.getContext(),baituvung1lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 1){
                    Intent in = new Intent(view.getContext(),baihoctuvung2lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 2){
                    Intent in = new Intent(view.getContext(),baihoctuvung3lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 3){
                    Intent in = new Intent(view.getContext(),baihoctuvung4lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 4){
                    Intent in = new Intent(view.getContext(),baihoctuvung5lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 5){
                    Intent in = new Intent(view.getContext(),baihoctuvung6lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 6){
                    Intent in = new Intent(view.getContext(),baihoctuvung7lop1.class);
                    startActivityForResult(in,0);
                }
                if(position == 7){
                    Intent in = new Intent(view.getContext(),baihoctuvung8lop1.class);
                    startActivityForResult(in,0);
                }
            }
        });
    }
}
