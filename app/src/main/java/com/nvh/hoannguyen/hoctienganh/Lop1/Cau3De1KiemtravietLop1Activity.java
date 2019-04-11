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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau2De1KiemtravietLop1Activity.V2;

public class Cau3De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau3de1lop1;
    TextView timecau3de1lop1;
    EditText edtcau3de1lop1;
    CountDownTimer timercau3de1lop1;
    public static final String V3="V3";
    Integer x3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3_de1_kiemtraviet_lop1);


        Intent v2= getIntent();
        String c=v2.getStringExtra(V2);
        x3=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau3de1lop1= (Button) findViewById(R.id.btnnextcau3de1lop1);
        timecau3de1lop1=(TextView) findViewById(R.id.timecau3de1lop1);
        edtcau3de1lop1=(EditText) findViewById(R.id.edtcau3de1lop1);

        timercau3de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau3de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau3De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x3+0;
                byExtra(d);
            }
        }.start();

        btnnextcau3de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau3de1lop1.getText().toString();
                if (kq.equals("snake")){
                    Integer d=x3+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x3+0;
                    byExtra(d);
                }
                timercau3de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v3=new Intent(Cau3De1KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau4De1KiemtravietLop1Activity.class);
        v3.putExtra(V3, d.toString());
        startActivity(v3);
    }
}
