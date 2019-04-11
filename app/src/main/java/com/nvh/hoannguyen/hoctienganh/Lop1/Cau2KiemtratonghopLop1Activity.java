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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau1KiemtratonghopLop1Activity.TH1;

public class Cau2KiemtratonghopLop1Activity extends AppCompatActivity {

    RadioButton tha2,thb2,thc2,thd2;
    Button btnnextth2lop1;
    TextView timeth2lop1;
    CountDownTimer timerth2lop1;
    public static final String TH2="TH2";
    Integer z2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_kiemtratonghop_lop1);

        Intent th1= getIntent();
        String c=th1.getStringExtra(TH1);
        z2=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");

        btnnextth2lop1= (Button) findViewById(R.id.btnnextth2lop1);
        timeth2lop1=(TextView) findViewById(R.id.timeth2lop1);
        tha2=(RadioButton) findViewById(R.id.tha2);
        thb2=(RadioButton) findViewById(R.id.thb2);
        thc2=(RadioButton) findViewById(R.id.thc2);
        thd2=(RadioButton) findViewById(R.id.thd2);

        timerth2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeth2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau2KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z2+0;
                byExtra(d);
            }
        }.start();

        btnnextth2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tha2.isChecked()){
                    Integer d=z2+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z2+0;
                    byExtra(d);
                }
                timerth2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th2=new Intent(Cau2KiemtratonghopLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau3KiemtratonghopLop1Activity.class);
        th2.putExtra(TH2, d.toString());
        startActivity(th2);
    }
}
