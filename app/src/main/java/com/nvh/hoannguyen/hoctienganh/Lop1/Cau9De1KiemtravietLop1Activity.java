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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau8De1KiemtravietLop1Activity.V8;

public class Cau9De1KiemtravietLop1Activity extends AppCompatActivity {

    Button btnnextcau9de1lop1;
    TextView timecau9de1lop1;
    EditText edtcau9de1lop1;
    CountDownTimer timercau9de1lop1;
    public static final String V9="V9";
    Integer x9=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau9_de1_kiemtraviet_lop1);

        Intent v8= getIntent();
        String c=v8.getStringExtra(V8);
        x9=Integer.parseInt(c);
        this.setTitle("Kiểm tra viết");

        btnnextcau9de1lop1= (Button) findViewById(R.id.btnnextcau9de1lop1);
        timecau9de1lop1=(TextView) findViewById(R.id.timecau9de1lop1);
        edtcau9de1lop1=(EditText) findViewById(R.id.edtcau9de1lop1);

        timercau9de1lop1= new CountDownTimer(50*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timecau9de1lop1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Cau9De1KiemtravietLop1Activity.this,"Hết giờ", Toast.LENGTH_SHORT).show();
                Integer d=x9+0;
                byExtra(d);
            }
        }.start();

        btnnextcau9de1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtcau9de1lop1.getText().toString();
                if (kq.equals("I'm six years old")||kq.equals("I'm seven years old")){
                    Integer d=x9+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=x9+0;
                    byExtra(d);
                }
                timercau9de1lop1.cancel();
            }
        });

    }

    private void byExtra(Integer d) {
        Intent v9=new Intent(Cau9De1KiemtravietLop1Activity.this, Cau10De1KiemtravietLop1Activity.class);
        v9.putExtra(V9, d.toString());
        startActivity(v9);
    }
}
