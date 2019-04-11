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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau6De2KiemtravietLop1Activity.VD6;

public class Cau7De2KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau7de2lop1;
    TextView timecau7de2lop1;
    EditText edtcau7de2lop1;
    CountDownTimer timercau7de2lop1;
    public static final String VD7="VD7";
    Integer xd7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau7_de2_kiemtraviet_lop1);

        Intent vd6= getIntent();
        String c=vd6.getStringExtra(VD6);
        xd7=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau7de2lop1= (Button) findViewById(R.id.btnnextcau7de2lop1);
        timecau7de2lop1=(TextView) findViewById(R.id.timecau7de2lop1);
        edtcau7de2lop1=(EditText) findViewById(R.id.edtcau7de2lop1);

        timercau7de2lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau7de2lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau7De2KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=xd7+0;
                byExtra(d);
            }
        }.start();

        btnnextcau7de2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau7de2lop1.getText().toString();
                if (kq.equals("Where are you from?")){
                    Integer d=xd7+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=xd7+0;
                    byExtra(d);
                }
                timercau7de2lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent vd7=new Intent(Cau7De2KiemtravietLop1Activity.this, Cau8De2KiemtravietLop1Activity.class);
        vd7.putExtra(VD7, d.toString());
        startActivity(vd7);
    }
}
