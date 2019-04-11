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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau3De2KiemtravietLop1Activity.VD3;

public class Cau4De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau4de2lop1;
    TextView timecau4de2lop1;
    EditText edtcau4de2lop1;
    CountDownTimer timercau4de2lop1;
    public static final String VD4="VD4";
    Integer xd4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4_de2_kiemtraviet_lop1);

        Intent vd3= getIntent();
        String c=vd3.getStringExtra(VD3);
        xd4=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau4de2lop1= (Button) findViewById(R.id.btnnextcau4de2lop1);
        timecau4de2lop1=(TextView) findViewById(R.id.timecau4de2lop1);
        edtcau4de2lop1=(EditText) findViewById(R.id.edtcau4de2lop1);

        timercau4de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau4de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau4De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd4+0;
                byExtra(d);
            }
        }.start();

        btnnextcau4de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau4de2lop1.getText().toString();
                if (kq.equals("chicken")){
                    Integer d=xd4+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd4+0;
                    byExtra(d);
                }
                timercau4de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd4=new Intent(Cau4De2KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau5De2KiemtravietLop1Activity.class);
        vd4.putExtra(VD4, d.toString());
        startActivity(vd4);
    }
}
