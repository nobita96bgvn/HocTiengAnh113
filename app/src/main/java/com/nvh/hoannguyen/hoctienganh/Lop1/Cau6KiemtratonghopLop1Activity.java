package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.nvh.hoannguyen.hoctienganh.R;

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau5KiemtratonghopLop1Activity.TH5;

public class Cau6KiemtratonghopLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe8;
    EditText edtnghe8;
    Button btnnextnghe8lop1;
    public static final String TH6="TH6";
    Integer z6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau6_kiemtratonghop_lop1);

        Intent th5= getIntent();
        String c=th5.getStringExtra(TH5);
        z6=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");
        imbtnnghe8= (ImageButton) findViewById(R.id.imbtnnghe8);
        edtnghe8=(EditText) findViewById(R.id.edtnghe8);
        btnnextnghe8lop1=(Button) findViewById(R.id.btnnextnghe8lop1);

        imbtnnghe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau6KiemtratonghopLop1Activity.this, R.raw.kiem_tra_nghe_3);
                mediaPlayer.start();
            }
        });

        btnnextnghe8lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtnghe8.getText().toString();
                if (kq.equals("Nice to meet you Tony"))
                {
                    Integer d=z6+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z6+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent th6= new Intent(Cau6KiemtratonghopLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau7KiemtratonghopLop1Activity.class);
        th6.putExtra(TH6,d.toString());
        startActivity(th6);
    }
}
