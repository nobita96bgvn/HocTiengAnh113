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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau3KiemtrangheLop1Activity.N3;

public class Cau4KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe4;
    RadioButton anghe4,bnghe4,cnghe4,dnghe4;
    Button btnnextnghe4lop1;
    public static final String N4="N4";
    Integer ntd4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4_kiemtranghe_lop1);

        Intent n3= getIntent();
        String c=n3.getStringExtra(N3);
        ntd4=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe4= (ImageButton) findViewById(R.id.imbtnnghe4);
        anghe4=(RadioButton) findViewById(R.id.anghe4);
        bnghe4=(RadioButton) findViewById(R.id.bnghe4);
        cnghe4=(RadioButton) findViewById(R.id.cnghe4);
        dnghe4=(RadioButton) findViewById(R.id.dnghe4);
        btnnextnghe4lop1=(Button) findViewById(R.id.btnnextnghe4lop1);

        imbtnnghe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau4KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_1);
                mediaPlayer.start();
            }
        });

        btnnextnghe4lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anghe4.isChecked())
                {
                    Integer d=ntd4+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd4+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n4= new Intent(Cau4KiemtrangheLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau5KiemtrangheLop1Activity.class);
        n4.putExtra(N4,d.toString());
        startActivity(n4);
    }
}
