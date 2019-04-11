package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nvh.hoannguyen.hoctienganh.R;

public class Cau1KiemtratonghopLop1Activity extends AppCompatActivity {

RadioButton tha1,thb1,thc1,thd1;
    Button btnnextth1lop1;
    TextView timeth1lop1;
    CountDownTimer timerth1lop1;
    public static final String TH1="TH1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_kiemtratonghop_lop1);

        this.setTitle("Kiểm tra tổng hợp");
        tha1=(RadioButton) findViewById(R.id.tha1);
        thb1=(RadioButton) findViewById(R.id.thb1);
        thc1=(RadioButton) findViewById(R.id.thc1);
        thd1=(RadioButton) findViewById(R.id.thd1);
        btnnextth1lop1=(Button) findViewById(R.id.btnnextth1lop1);
        timeth1lop1=(TextView) findViewById(R.id.timeth1lop1);

        timerth1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeth1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau1KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=0;
                byExtra(d);
            }
        }.start();

        btnnextth1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (thc1.isChecked()){
                    Integer d=1;
                    byExtra(d);
                }
                else
                {
                    Integer d=0;
                    byExtra(d);
                }
                timerth1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th1=new Intent(Cau1KiemtratonghopLop1Activity.this, Cau2KiemtratonghopLop1Activity.class);
        th1.putExtra(TH1, d.toString());
        startActivity(th1);


    }

}
