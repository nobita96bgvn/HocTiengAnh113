package com.nvh.hoannguyen.hoctienganh.hoctap;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nvh.hoannguyen.hoctienganh.Lop1.Hoctuvunglop1Activity;
import com.nvh.hoannguyen.hoctienganh.Lop2.Hoctuvunglop2Activity;
import com.nvh.hoannguyen.hoctienganh.Lop3.Hoctuvunglop3Activity;
import com.nvh.hoannguyen.hoctienganh.Lop4.Hoctuvunglop4Activity;
import com.nvh.hoannguyen.hoctienganh.Lop5.Hoctuvunglop5Activity;
import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

public class HoctuvungFragment extends Fragment {

    Button btntuvunglop1,btntuvunglop2,btntuvunglop3,btntuvunglop4,btntuvunglop5;

    public HoctuvungFragment() {

    }
    // phương thức khởi tạo

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // chuyển layout cho Fragment học từ vựng
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Học từ vựng");
        return inflater.inflate(R.layout.fragment_hoctuvung, container, false);
    }
    /*
    Phương thức Inflate
Công việc của LayoutInflater là đọc xml layout file và chuyển đổi các thuộc tính của nó thành 1 View trong Java code.
Sau khi có đối tượng LayoutInflater, ta có thể dùng phương thức inflate để chuyển đổi 1 xml layout file thành 1 View trong java.
-Tham số thứ nhất là: int resource, nó chính là xml layout file mà chúng ta muốn chuyển đổi thành View.
-Tham số thứ hai là: ViewGroup parent, nó là ViewGroup nơi mà xml layout file(tham số thứ nhất) có thể được nhúng vào,
LayoutInflater sẽ chuyển đổi xml layout file thành View và sử dụng các thuộc tính phù hợp với ViewGroup parrent.
-Tham số thứ ba là: attachToRoot, khi mà attachToRoot=true thì ngay sau khi quá trình chuyển đổi xml file(resource)
thành View hoàn thành thì nó sẽ nhúng View đó vào ViewGroup parent (RIGHT NOW) , khi attachToRoot = false thì nó chỉ chuyển đổi xml file(resource) thành View trong java mà không thêm ngay vào ViewGroup(NOT NOW)
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btntuvunglop1= (Button) getActivity().findViewById(R.id.btntuvunglop1);
        btntuvunglop2= (Button) getActivity().findViewById(R.id.btntuvunglop2);
        btntuvunglop3= (Button) getActivity().findViewById(R.id.btntuvunglop3);
        btntuvunglop4= (Button) getActivity().findViewById(R.id.btntuvunglop4);
        btntuvunglop5= (Button) getActivity().findViewById(R.id.btntuvunglop5);
        //ánh xạ các Button tại layout Fragment Học từ vựng
        btntuvunglop1.setOnClickListener(new View.OnClickListener() {
            //Bắt sự kiện khi người dùng chọn Button "Lớp 1"
            //Khi người dùng chọn lớp 1 sẽ dùng Intent để chuyển đến bài học từ vựng dành cho hs lớp 1 ( Hoctuvunglop1Activity.class)
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(getActivity(), Hoctuvunglop1Activity.class);
                    startActivity(i1);
            }
        });

        btntuvunglop2.setOnClickListener(new View.OnClickListener() {
            //Bắt sự kiện khi người dùng chọn Button "Lớp 2"
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(getActivity(), Hoctuvunglop2Activity.class);
                startActivity(i2);
            }
        });

        btntuvunglop3.setOnClickListener(new View.OnClickListener() {
            //Bắt sự kiện khi người dùng chọn Button "Lớp 3"
            @Override
            public void onClick(View v) {
                Intent i3= new Intent(getActivity(), Hoctuvunglop3Activity.class);
                startActivity(i3);
            }
        });
        btntuvunglop4.setOnClickListener(new View.OnClickListener() {
            //Bắt sự kiện khi người dùng chọn Button "Lớp 4"
            @Override
            public void onClick(View v) {
                Intent i4= new Intent(getActivity(), Hoctuvunglop4Activity.class);
                startActivity(i4);
            }
        });
        btntuvunglop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bắt sự kiện khi người dùng chọn Button "Lớp 5"
                Intent i5= new Intent(getActivity(), Hoctuvunglop5Activity.class);
                startActivity(i5);
            }
        });
    }
}
