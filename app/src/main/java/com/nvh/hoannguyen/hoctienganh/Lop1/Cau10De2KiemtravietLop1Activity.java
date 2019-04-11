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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau9De2KiemtravietLop1Activity.VD9;

public class Cau10De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau10de2lop1;
    TextView timecau10de2lop1;
    EditText edtcau10de2lop1;
    CountDownTimer timercau10de2lop1;
    public static final String VD10="VD10";
    Integer xd10=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau10_de2_kiemtraviet_lop1);

        Intent vd9= getIntent();
        String c=vd9.getStringExtra(VD9);
        xd10=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau10de2lop1= (Button) findViewById(R.id.btnnextcau10de2lop1);
        timecau10de2lop1=(TextView) findViewById(R.id.timecau10de2lop1);
        edtcau10de2lop1=(EditText) findViewById(R.id.edtcau10de2lop1);

        timercau10de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau10de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau10De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd10+0;
                byExtra(d);
            }
        }.start();

        btnnextcau10de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau10de2lop1.getText().toString();
                if (kq.equals("How do you spell your name?")){
                    Integer d=xd10+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd10+0;
                    byExtra(d);
                }
                timercau10de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd10=new Intent(Cau10De2KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.KetquaDe2Lop1Activity.class);
        vd10.putExtra(VD10, d.toString());
        startActivity(vd10);
    }
}
