package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nvh.hoannguyen.hoctienganh.R;

public class Cau1De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau1de2lop1;
    TextView timecau1de2lop1;
    EditText edtcau1de2lop1;
    CountDownTimer timercau1de2lop1;
    public static final String VD1="VD1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_de2_kiemtraviet_lop1);

        this.setTitle("Kiểm tra viết");
        btnnextcau1de2lop1= (Button) findViewById(R.id.btnnextcau1de2lop1);
        timecau1de2lop1=(TextView) findViewById(R.id.timecau1de2lop1);
        edtcau1de2lop1=(EditText) findViewById(R.id.edtcau1de2lop1);

        timercau1de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau1de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau1De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=0;
                byExtra(d);
            }
        }.start();

        btnnextcau1de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau1de2lop1.getText().toString();
                if (kq.equals("bird")||kq.equals("Bird")){
                    Integer d=1;
                    byExtra(d);
                }
                else
                {
                    Integer d=0;
                    byExtra(d);
                }
                timercau1de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd1=new Intent(Cau1De2KiemtravietLop1Activity.this, Cau2De2KiemtravietLop1Activity.class);
        vd1.putExtra(VD1, d.toString());
        startActivity(vd1);
    }
}
