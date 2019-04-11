package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

public class KetquaDe2Lop1Activity extends AppCompatActivity {

    TextView diemde2lop1;
    Button btnokde2lop1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua_de2_lop1);

        this.setTitle("Kết quả kiểm tra viết");

        diemde2lop1=(TextView) findViewById(R.id.diemde2lop1);
        btnokde2lop1=(Button) findViewById(R.id.btnokde2lop1);

        Intent vd10= getIntent();
        String c=vd10.getStringExtra(Cau10De2KiemtravietLop1Activity.VD10);
        diemde2lop1.setText(c);


        btnokde2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vd11=new Intent(KetquaDe2Lop1Activity.this, MainActivity.class);
                startActivity(vd11);
            }
        });
    }
}
