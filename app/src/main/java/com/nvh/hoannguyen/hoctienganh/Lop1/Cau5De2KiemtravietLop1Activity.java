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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau4De2KiemtravietLop1Activity.VD4;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau5De1KiemtravietLop1Activity.V5;

public class Cau5De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau5de2lop1;
    TextView timecau5de2lop1;
    EditText edtcau5de2lop1;
    CountDownTimer timercau5de2lop1;
    public static final String VD5="VD5";
    Integer xd5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5_de2_kiemtraviet_lop1);

        Intent vd4= getIntent();
        String c=vd4.getStringExtra(VD4);
        xd5=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

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
                Toast.makeText(Cau5De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd5+0;
                byExtra(d);
            }
        }.start();

        btnnextcau5de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau5de2lop1.getText().toString();
                if (kq.equals("Her name is Dina")){
                    Integer d=xd5+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd5+0;
                    byExtra(d);
                }
                timercau5de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd5=new Intent(Cau5De2KiemtravietLop1Activity.this, Cau6De2KiemtravietLop1Activity.class);
        vd5.putExtra(VD5, d.toString());
        startActivity(vd5);
    }
}
