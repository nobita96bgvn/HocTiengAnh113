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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau7De1KiemtravietLop1Activity.V7;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau7De2KiemtravietLop1Activity.VD7;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau8De1KiemtravietLop1Activity.V8;
import static com.nvh.hoannguyen.hoctienganh.R.id.btnnextcau8de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.edtcau8de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.timecau8de1lop1;

public class Cau8De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau8de2lop1;
    TextView timecau8de2lop1;
    EditText edtcau8de2lop1;
    CountDownTimer timercau8de2lop1;
    public static final String VD8="VD8";
    Integer xd8=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau8_de2_kiemtraviet_lop1);

        Intent vd7= getIntent();
        String c=vd7.getStringExtra(VD7);
        xd8=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau8de2lop1= (Button) findViewById(R.id.btnnextcau8de2lop1);
        timecau8de2lop1=(TextView) findViewById(R.id.timecau8de2lop1);
        edtcau8de2lop1=(EditText) findViewById(R.id.edtcau8de2lop1);

        timercau8de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau8de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau8De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd8+0;
                byExtra(d);
            }
        }.start();

        btnnextcau8de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau8de2lop1.getText().toString();
                if (kq.equals("I'm fine")||kq.equals("I'm fine. Thanks")||kq.equals("I'm fine. Thank you")){
                    Integer d=xd8+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd8+0;
                    byExtra(d);
                }
                timercau8de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd8=new Intent(Cau8De2KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau9De2KiemtravietLop1Activity.class);
        vd8.putExtra(VD8, d.toString());
        startActivity(vd8);
    }
}
