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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau9De1KiemtravietLop1Activity.V9;

public class Cau10De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau10de1lop1;
    TextView timecau10de1lop1;
    EditText edtcau10de1lop1;
    CountDownTimer timercau10de1lop1;
    public static final String V10="V10";
    Integer x10=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau10_de1_kiemtraviet_lop1);

        Intent v9= getIntent();
        String c=v9.getStringExtra(V9);
        x10=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau10de1lop1= (Button) findViewById(R.id.btnnextcau10de1lop1);
        timecau10de1lop1=(TextView) findViewById(R.id.timecau10de1lop1);
        edtcau10de1lop1=(EditText) findViewById(R.id.edtcau10de1lop1);

        timercau10de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau10de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau10De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x10+0;
                byExtra(d);
            }
        }.start();

        btnnextcau10de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau10de1lop1.getText().toString();
                if (kq.equals("How do you spell your name?")){
                    Integer d=x10+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x10+0;
                    byExtra(d);
                }
                timercau10de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v10=new Intent(Cau10De1KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.KetquaDe1Lop1Activity.class);
        v10.putExtra(V10, d.toString());
        startActivity(v10);
    }
}
