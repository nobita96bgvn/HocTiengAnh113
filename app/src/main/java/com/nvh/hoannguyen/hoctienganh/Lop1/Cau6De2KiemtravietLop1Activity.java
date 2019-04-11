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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau5De2KiemtravietLop1Activity.VD5;

public class Cau6De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau6de2lop1;
    TextView timecau6de2lop1;
    EditText edtcau6de2lop1;
    CountDownTimer timercau6de2lop1;
    public static final String VD6="VD6";
    Integer xd6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau6_de2_kiemtraviet_lop1);

        Intent vd5= getIntent();
        String c=vd5.getStringExtra(VD5);
        xd6=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau6de2lop1= (Button) findViewById(R.id.btnnextcau6de2lop1);
        timecau6de2lop1=(TextView) findViewById(R.id.timecau6de2lop1);
        edtcau6de2lop1=(EditText) findViewById(R.id.edtcau6de2lop1);

        timercau6de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau6de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau6De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd6+0;
                byExtra(d);
            }
        }.start();

        btnnextcau6de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau6de2lop1.getText().toString();
                if (kq.equals("My mother is twenty night years old")){
                    Integer d=xd6+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd6+0;
                    byExtra(d);
                }
                timercau6de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd6=new Intent(Cau6De2KiemtravietLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau7De2KiemtravietLop1Activity.class);
        vd6.putExtra(VD6, d.toString());
        startActivity(vd6);
    }
}
