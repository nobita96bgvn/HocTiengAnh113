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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau5De1KiemtravietLop1Activity.V5;
import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau6De1KiemtravietLop1Activity.V6;
import static com.nvh.hoannguyen.hoctienganh.R.id.btnnextcau6de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.edtcau6de1lop1;
import static com.nvh.hoannguyen.hoctienganh.R.id.timecau6de1lop1;

public class Cau7De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau7de1lop1;
    TextView timecau7de1lop1;
    EditText edtcau7de1lop1;
    CountDownTimer timercau7de1lop1;
    public static final String V7="V7";
    Integer x7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau7_de1_kiemtraviet_lop1);

        Intent v6= getIntent();
        String c=v6.getStringExtra(V6);
        x7=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau7de1lop1= (Button) findViewById(R.id.btnnextcau7de1lop1);
        timecau7de1lop1=(TextView) findViewById(R.id.timecau7de1lop1);
        edtcau7de1lop1=(EditText) findViewById(R.id.edtcau7de1lop1);

        timercau7de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau7de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau7De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x7+0;
                byExtra(d);
            }
        }.start();

        btnnextcau7de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau7de1lop1.getText().toString();
                if (kq.equals("Where are you from?")){
                    Integer d=x7+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x7+0;
                    byExtra(d);
                }
                timercau7de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v7=new Intent(Cau7De1KiemtravietLop1Activity.this, Cau8De1KiemtravietLop1Activity.class);
        v7.putExtra(V7, d.toString());
        startActivity(v7);
    }
}
