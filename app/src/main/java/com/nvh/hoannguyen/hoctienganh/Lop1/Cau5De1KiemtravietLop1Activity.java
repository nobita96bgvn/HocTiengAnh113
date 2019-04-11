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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau4De1KiemtravietLop1Activity.V4;

public class Cau5De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau5de1lop1;
    TextView timecau5de1lop1;
    EditText edtcau5de1lop1;
    CountDownTimer timercau5de1lop1;
    public static final String V5="V5";
    Integer x5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5_de1_kiemtraviet_lop1);


        Intent v4= getIntent();
        String c=v4.getStringExtra(V4);
        x5=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau5de1lop1= (Button) findViewById(R.id.btnnextcau5de1lop1);
        timecau5de1lop1=(TextView) findViewById(R.id.timecau5de1lop1);
        edtcau5de1lop1=(EditText) findViewById(R.id.edtcau5de1lop1);

        timercau5de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau5de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau5De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x5+0;
                byExtra(d);
            }
        }.start();

        btnnextcau5de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau5de1lop1.getText().toString();
                if (kq.equals("My name is Linda")){
                    Integer d=x5+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x5+0;
                    byExtra(d);
                }
                timercau5de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v5=new Intent(Cau5De1KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau6De1KiemtravietLop1Activity.class);
        v5.putExtra(V5, d.toString());
        startActivity(v5);
    }
}
