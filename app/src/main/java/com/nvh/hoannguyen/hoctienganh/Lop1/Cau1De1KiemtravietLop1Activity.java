package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nvh.hoannguyen.hoctienganh.R;

public class Cau1De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau1de1lop1;
    TextView timecau1de1lop1;
    EditText edtcau1de1lop1;
    CountDownTimer timercau1de1lop1;
    public static final String V1="V1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_de1_kiemtraviet_lop1);

        this.setTitle("Kiểm tra viết");
        btnnextcau1de1lop1= (Button) findViewById(R.id.btnnextcau1de1lop1);
        timecau1de1lop1=(TextView) findViewById(R.id.timecau1de1lop1);
        edtcau1de1lop1=(EditText) findViewById(R.id.edtcau1de1lop1);

        timercau1de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau1de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau1De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=0;
                byExtra(d);
            }
        }.start();

        btnnextcau1de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau1de1lop1.getText().toString();
                if (kq.equals("bee")){
                    Integer d=1;
                    byExtra(d);
                }
                else
                {
                    Integer d=0;
                    byExtra(d);
                }
                timercau1de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v1=new Intent(Cau1De1KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau2De1KiemtravietLop1Activity.class);
        v1.putExtra(V1, d.toString());
        startActivity(v1);
    }
}
