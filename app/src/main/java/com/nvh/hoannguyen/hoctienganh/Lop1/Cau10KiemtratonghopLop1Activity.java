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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau9KiemtratonghopLop1Activity.TH9;

public class Cau10KiemtratonghopLop1Activity extends AppCompatActivity {

    Button btnnextcau10de1lop1;
    TextView timecau10de1lop1;
    EditText edtcau10de1lop1;
    CountDownTimer timercau10de1lop1;
    public static final String TH10="TH10";
    Integer z10=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau10_kiemtratonghop_lop1);

        Intent th9= getIntent();
        String c=th9.getStringExtra(TH9);
        z10=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");

        btnnextcau10de1lop1= (Button) findViewById(R.id.btnnextcau10de1lop1);
        timecau10de1lop1=(TextView) findViewById(R.id.timecau10de1lop1);
        edtcau10de1lop1=(EditText) findViewById(R.id.edtcau10de1lop1);

        timercau10de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau10de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau10KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z10+0;
                byExtra(d);
            }
        }.start();

        btnnextcau10de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau10de1lop1.getText().toString();
                if (kq.equals("How do you spell your name?")){
                    Integer d=z10+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z10+0;
                    byExtra(d);
                }
                timercau10de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th10=new Intent(Cau10KiemtratonghopLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.KetquaKiemtratonghopLop1Activity.class);
        th10.putExtra(TH10, d.toString());
        startActivity(th10);
    }
}
