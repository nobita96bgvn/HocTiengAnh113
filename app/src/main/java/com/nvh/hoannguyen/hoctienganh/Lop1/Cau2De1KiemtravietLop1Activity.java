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

public class Cau2De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau2de1lop1;
    TextView timecau2de1lop1;
    EditText edtcau2de1lop1;
    CountDownTimer timercau2de1lop1;
    public static final String V2="V2";
    Integer x2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_de1_kiemtraviet_lop1);

        Intent v1= getIntent();
        String c=v1.getStringExtra(V1);
        x2=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau2de1lop1= (Button) findViewById(R.id.btnnextcau2de1lop1);
        timecau2de1lop1=(TextView) findViewById(R.id.timecau2de1lop1);
        edtcau2de1lop1=(EditText) findViewById(R.id.edtcau2de1lop1);

        timercau2de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau2de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau2De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x2+0;
                byExtra(d);
            }
        }.start();

        btnnextcau2de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau2de1lop1.getText().toString();
                if (kq.equals("duck")){
                    Integer d=x2+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x2+0;
                    byExtra(d);
                }
                timercau2de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v2=new Intent(Cau2De1KiemtravietLop1Activity.this, Cau3De1KiemtravietLop1Activity.class);
        v2.putExtra(V2, d.toString());
        startActivity(v2);
    }


}
