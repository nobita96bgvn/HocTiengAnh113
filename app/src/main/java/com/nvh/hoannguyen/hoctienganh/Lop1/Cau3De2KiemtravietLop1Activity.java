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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau2De2KiemtravietLop1Activity.VD2;

public class Cau3De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau3de2lop1;
    TextView timecau3de2lop1;
    EditText edtcau3de2lop1;
    CountDownTimer timercau3de2lop1;
    public static final String VD3="VD3";
    Integer xd3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3_de2_kiemtraviet_lop1);

        Intent vd2= getIntent();
        String c=vd2.getStringExtra(VD2);
        xd3=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau3de2lop1= (Button) findViewById(R.id.btnnextcau3de2lop1);
        timecau3de2lop1=(TextView) findViewById(R.id.timecau3de2lop1);
        edtcau3de2lop1=(EditText) findViewById(R.id.edtcau3de2lop1);

        timercau3de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau3de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau3De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd3+0;
                byExtra(d);
            }
        }.start();

        btnnextcau3de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau3de2lop1.getText().toString();
                if (kq.equals("elephant")){
                    Integer d=xd3+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd3+0;
                    byExtra(d);
                }
                timercau3de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd3=new Intent(Cau3De2KiemtravietLop1Activity.this, Cau4De2KiemtravietLop1Activity.class);
        vd3.putExtra(VD3, d.toString());
        startActivity(vd3);
    }
}
