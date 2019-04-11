package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.nvh.hoannguyen.hoctienganh.R;

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau4KiemtratonghopLop1Activity.TH4;

public class Cau5KiemtratonghopLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe2;
    RadioButton anghe2,bnghe2,cnghe2,dnghe2;
    Button btnnextnghe2lop1;
    public static final String TH5="TH5";
    Integer z5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5_kiemtratonghop_lop1);

        Intent th4= getIntent();
        String c=th4.getStringExtra(TH4);
        z5=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");
        imbtnnghe2= (ImageButton) findViewById(R.id.imbtnnghe2);
        anghe2=(RadioButton) findViewById(R.id.anghe2);
        bnghe2=(RadioButton) findViewById(R.id.bnghe2);
        cnghe2=(RadioButton) findViewById(R.id.cnghe2);
        dnghe2=(RadioButton) findViewById(R.id.dnghe2);
        btnnextnghe2lop1=(Button) findViewById(R.id.btnnextnghe2lop1);

        imbtnnghe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau5KiemtratonghopLop1Activity.this, R.raw.kiem_tra_nghe_1);
                mediaPlayer.start();
            }
        });

        btnnextnghe2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anghe2.isChecked())
                {
                    Integer d=z5+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z5+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent th5= new Intent(Cau5KiemtratonghopLop1Activity.this,Cau6KiemtratonghopLop1Activity.class);
        th5.putExtra(TH5,d.toString());
        startActivity(th5);
    }
}
