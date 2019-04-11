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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau8De2KiemtravietLop1Activity.VD8;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau8KiemtratonghopLop1Activity.TH8;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau9De2KiemtravietLop1Activity.VD9;

public class Cau9KiemtratonghopLop1Activity extends AppCompatActivity {

    Button btnnextcau9de2lop1;
    TextView timecau9de2lop1;
    EditText edtcau9de2lop1;
    CountDownTimer timercau9de2lop1;
    public static final String TH9="TH9";
    Integer z9=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau9_kiemtratonghop_lop1);

        Intent th8= getIntent();
        String c=th8.getStringExtra(TH8);
        z9=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau9de2lop1= (Button) findViewById(R.id.btnnextcau9de2lop1);
        timecau9de2lop1=(TextView) findViewById(R.id.timecau9de2lop1);
        edtcau9de2lop1=(EditText) findViewById(R.id.edtcau9de2lop1);

        timercau9de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau9de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau9KiemtratonghopLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=z9+0;
                byExtra(d);
            }
        }.start();

        btnnextcau9de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau9de2lop1.getText().toString();
                if (kq.equals("I'm six years old")||kq.equals("I'm seven years old")){
                    Integer d=z9+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z9+0;
                    byExtra(d);
                }
                timercau9de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent th9=new Intent(Cau9KiemtratonghopLop1Activity.this, Cau10KiemtratonghopLop1Activity.class);
        th9.putExtra(TH9, d.toString());
        startActivity(th9);
    }
}
