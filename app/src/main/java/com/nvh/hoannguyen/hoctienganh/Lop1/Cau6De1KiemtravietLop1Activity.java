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

public class Cau6De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau6de1lop1;
    TextView timecau6de1lop1;
    EditText edtcau6de1lop1;
    CountDownTimer timercau6de1lop1;
    public static final String V6="V6";
    Integer x6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau6_de1_kiemtraviet_lop1);

        Intent v5= getIntent();
        String c=v5.getStringExtra(V5);
        x6=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau6de1lop1= (Button) findViewById(R.id.btnnextcau6de1lop1);
        timecau6de1lop1=(TextView) findViewById(R.id.timecau6de1lop1);
        edtcau6de1lop1=(EditText) findViewById(R.id.edtcau6de1lop1);

        timercau6de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau6de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau6De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x6+0;
                byExtra(d);
            }
        }.start();

        btnnextcau6de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau6de1lop1.getText().toString();
                if (kq.equals("I'm six years old")){
                    Integer d=x6+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x6+0;
                    byExtra(d);
                }
                timercau6de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v6=new Intent(Cau6De1KiemtravietLop1Activity.this, Cau7De1KiemtravietLop1Activity.class);
        v6.putExtra(V6, d.toString());
        startActivity(v6);
    }
}
