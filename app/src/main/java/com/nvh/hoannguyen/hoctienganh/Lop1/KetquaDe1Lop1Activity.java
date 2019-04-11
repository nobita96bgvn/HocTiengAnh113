package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.MainActivity;
import com.nvh.hoannguyen.hoctienganh.R;

public class KetquaDe1Lop1Activity extends AppCompatActivity {

    TextView diemde1lop1;
    Button btnokde1lop1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua_de1_lop1);

        this.setTitle("Kết quả kiểm tra viết");

        diemde1lop1=(TextView) findViewById(R.id.diemde1lop1);
        btnokde1lop1=(Button) findViewById(R.id.btnokde1lop1);

        Intent v10= getIntent();
        String c=v10.getStringExtra(Cau10De1KiemtravietLop1Activity.V10);
        diemde1lop1.setText(c);


        btnokde1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent v11=new Intent(KetquaDe1Lop1Activity.this, MainActivity.class);
                startActivity(v11);
            }
        });

    }
}
