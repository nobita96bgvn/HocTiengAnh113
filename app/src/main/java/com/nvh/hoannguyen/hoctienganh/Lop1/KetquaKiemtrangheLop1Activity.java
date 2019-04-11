package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

public class KetquaKiemtrangheLop1Activity extends AppCompatActivity {

    TextView diemnghelop1;
    Button btnoknghelop1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua_kiemtranghe_lop1);

        this.setTitle("Kết quả kiểm tra nghe");

        diemnghelop1=(TextView) findViewById(R.id.diemnghelop1);
        btnoknghelop1=(Button) findViewById(R.id.btnoknghelop1);

        Intent n10= getIntent();
        String c=n10.getStringExtra(Cau10KiemtrangheLop1Activity.N10);
        diemnghelop1.setText(c);


        btnoknghelop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n11=new Intent(KetquaKiemtrangheLop1Activity.this, MainActivity.class);
                startActivity(n11);
            }
        });
    }
}
