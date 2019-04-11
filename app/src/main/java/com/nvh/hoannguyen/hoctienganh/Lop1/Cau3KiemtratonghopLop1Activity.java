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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau2KiemtratonghopLop1Activity.TH2;

public class Cau3KiemtratonghopLop1Activity extends AppCompatActivity {

    RadioButton tha3,thb3,thc3,thd3;
    Button btnnextth3lop1;
    TextView timeth3lop1;
    CountDownTimer timerth3lop1;
    public static final String TH3="TH3";
    Integer z3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3_kiemtratonghop_lop1);

        Intent th2= getIntent();
        String c=th2.getStringExtra(TH2);
        z3=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");

        btnnextth3lop1= (Button) findViewById(R.id.btnnextth3lop1);
        timeth3lop1=(TextView) findViewById(R.id.timeth3lop1);
        tha3=(RadioButton) findViewById(R.id.tha3);
        thb3=(RadioButton) findViewById(R.id.thb3);
        thc3=(RadioButton) findViewById(R.id.thc3);
        thd3=(RadioButton) findViewById(R.id.thd3);

        timerth3lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeth3lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau3KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z3+0;
                byExtra(d);
            }
        }.start();

        btnnextth3lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (thb3.isChecked()){
                    Integer d=z3+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z3+0;
                    byExtra(d);
                }
                timerth3lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th3=new Intent(Cau3KiemtratonghopLop1Activity.this, Cau4KiemtratonghopLop1Activity.class);
        th3.putExtra(TH3, d.toString());
        startActivity(th3);
    }
}
