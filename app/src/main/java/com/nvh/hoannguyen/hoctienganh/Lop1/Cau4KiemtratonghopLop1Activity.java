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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau3KiemtratonghopLop1Activity.TH3;

public class Cau4KiemtratonghopLop1Activity extends AppCompatActivity {

    RadioButton tha4,thb4,thc4,thd4;
    Button btnnextth4lop1;
    TextView timeth4lop1;
    CountDownTimer timerth4lop1;
    public static final String TH4="TH4";
    Integer z4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4_kiemtratonghop_lop1);

        Intent th3= getIntent();
        String c=th3.getStringExtra(TH3);
        z4=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");

        btnnextth4lop1= (Button) findViewById(R.id.btnnextth4lop1);
        timeth4lop1=(TextView) findViewById(R.id.timeth4lop1);
        tha4=(RadioButton) findViewById(R.id.tha4);
        thb4=(RadioButton) findViewById(R.id.thb4);
        thc4=(RadioButton) findViewById(R.id.thc4);
        thd4=(RadioButton) findViewById(R.id.thd4);

        timerth4lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeth4lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau4KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z4+0;
                byExtra(d);
            }
        }.start();

        btnnextth4lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (thd4.isChecked()){
                    Integer d=z4+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z4+0;
                    byExtra(d);
                }
                timerth4lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th4=new Intent(Cau4KiemtratonghopLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau5KiemtratonghopLop1Activity.class);
        th4.putExtra(TH4, d.toString());
        startActivity(th4);
    }
}
