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


public class Cau1KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe1;
    RadioButton anghe1,bnghe1,cnghe1,dnghe1;
    Button btnnextnghe1lop1;
    public static final String N1="N1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_kiemtranghe_lop1);

        this.setTitle("Kiểm tra nghe");
        imbtnnghe1= (ImageButton) findViewById(R.id.imbtnnghe1);
        anghe1=(RadioButton) findViewById(R.id.anghe1);
        bnghe1=(RadioButton) findViewById(R.id.bnghe1);
        cnghe1=(RadioButton) findViewById(R.id.cnghe1);
        dnghe1=(RadioButton) findViewById(R.id.dnghe1);
        btnnextnghe1lop1=(Button) findViewById(R.id.btnnextnghe1lop1);

        imbtnnghe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau1KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_1);
                mediaPlayer.start();
            }
        });

        btnnextnghe1lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bnghe1.isChecked())
                {
                    Integer d=1;
                    byExtra(d);
                }
                else
                {
                    Integer d=0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){

        Intent n1= new Intent(Cau1KiemtrangheLop1Activity.this,Cau2KiemtrangheLop1Activity.class);
        n1.putExtra(N1,d.toString());
        startActivity(n1);
    }
}
