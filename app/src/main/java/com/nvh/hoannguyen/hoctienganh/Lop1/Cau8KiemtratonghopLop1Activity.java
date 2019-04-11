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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau7KiemtratonghopLop1Activity.TH7;

public class Cau8KiemtratonghopLop1Activity extends AppCompatActivity {

    Button btnnextcau5de2lop1;
    TextView timecau5de2lop1;
    EditText edtcau5de2lop1;
    CountDownTimer timercau5de2lop1;
    public static final String TH8="TH8";
    Integer z8=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau8_kiemtratonghop_lop1);

        Intent th7= getIntent();
        String c=th7.getStringExtra(TH7);
        z8=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");

        btnnextcau5de2lop1= (Button) findViewById(R.id.btnnextcau5de2lop1);
        timecau5de2lop1=(TextView) findViewById(R.id.timecau5de2lop1);
        edtcau5de2lop1=(EditText) findViewById(R.id.edtcau5de2lop1);

        timercau5de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau5de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau8KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z8+0;
                byExtra(d);
            }
        }.start();

        btnnextcau5de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau5de2lop1.getText().toString();
                if (kq.equals("Her name is Dina")){
                    Integer d=z8+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z8+0;
                    byExtra(d);
                }
                timercau5de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th8=new Intent(Cau8KiemtratonghopLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau9KiemtratonghopLop1Activity.class);
        th8.putExtra(TH8, d.toString());
        startActivity(th8);
    }
}
