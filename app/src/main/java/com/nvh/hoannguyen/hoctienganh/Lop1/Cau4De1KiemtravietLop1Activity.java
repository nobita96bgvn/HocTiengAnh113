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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau3De1KiemtravietLop1Activity.V3;

public class Cau4De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau4de1lop1;
    TextView timecau4de1lop1;
    EditText edtcau4de1lop1;
    CountDownTimer timercau4de1lop1;
    public static final String V4="V4";
    Integer x4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4_de1_kiemtraviet_lop1);


        Intent v3= getIntent();
        String c=v3.getStringExtra(V3);
        x4=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau4de1lop1= (Button) findViewById(R.id.btnnextcau4de1lop1);
        timecau4de1lop1=(TextView) findViewById(R.id.timecau4de1lop1);
        edtcau4de1lop1=(EditText) findViewById(R.id.edtcau4de1lop1);

        timercau4de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau4de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau4De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x4+0;
                byExtra(d);
            }
        }.start();

        btnnextcau4de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau4de1lop1.getText().toString();
                if (kq.equals("dog")){
                    Integer d=x4+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x4+0;
                    byExtra(d);
                }
                timercau4de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v4=new Intent(Cau4De1KiemtravietLop1Activity.this, Cau5De1KiemtravietLop1Activity.class);
        v4.putExtra(V4, d.toString());
        startActivity(v4);
    }
}
