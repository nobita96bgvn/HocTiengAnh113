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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau1De1KiemtravietLop1Activity.V1;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau1De2KiemtravietLop1Activity.VD1;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau2De1KiemtravietLop1Activity.V2;
import static com.nvh.hoannguyen.hoctienganh.R.id.btnnextcau2de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.edtcau2de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.timecau2de1lop1;

public class Cau2De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau2de2lop1;
    TextView timecau2de2lop1;
    EditText edtcau2de2lop1;
    CountDownTimer timercau2de2lop1;
    public static final String VD2="VD2";
    Integer xd2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_de2_kiemtraviet_lop1);

        Intent vd1= getIntent();
        String c=vd1.getStringExtra(VD1);
        xd2=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau2de2lop1= (Button) findViewById(R.id.btnnextcau2de2lop1);
        timecau2de2lop1=(TextView) findViewById(R.id.timecau2de2lop1);
        edtcau2de2lop1=(EditText) findViewById(R.id.edtcau2de2lop1);

        timercau2de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau2de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau2De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd2+0;
                byExtra(d);
            }
        }.start();

        btnnextcau2de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau2de2lop1.getText().toString();
                if (kq.equals("fish")||kq.equals("Fish")){
                    Integer d=xd2+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd2+0;
                    byExtra(d);
                }
                timercau2de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd2=new Intent(Cau2De2KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau3De2KiemtravietLop1Activity.class);
        vd2.putExtra(VD2, d.toString());
        startActivity(vd2);
    }
}
