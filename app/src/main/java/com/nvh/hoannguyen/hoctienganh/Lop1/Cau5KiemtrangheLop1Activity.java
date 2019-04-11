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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau4KiemtrangheLop1Activity.N4;

public class Cau5KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe5;
    RadioButton anghe5,bnghe5,cnghe5,dnghe5;
    Button btnnextnghe5lop1;
    public static final String N5="N5";
    Integer ntd5=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5_kiemtranghe_lop1);

        Intent n4= getIntent();
        String c=n4.getStringExtra(N4);
        ntd5=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe5= (ImageButton) findViewById(R.id.imbtnnghe5);
        anghe5=(RadioButton) findViewById(R.id.anghe5);
        bnghe5=(RadioButton) findViewById(R.id.bnghe5);
        cnghe5=(RadioButton) findViewById(R.id.cnghe5);
        dnghe5=(RadioButton) findViewById(R.id.dnghe5);
        btnnextnghe5lop1=(Button) findViewById(R.id.btnnextnghe5lop1);

        imbtnnghe5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau5KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_2);
                mediaPlayer.start();
            }
        });

        btnnextnghe5lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnghe5.isChecked())
                {
                    Integer d=ntd5+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd5+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n5= new Intent(Cau5KiemtrangheLop1Activity.this,Cau6KiemtrangheLop1Activity.class);
        n5.putExtra(N5,d.toString());
        startActivity(n5);
    }
}
