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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau2KiemtrangheLop1Activity.N2;

public class Cau3KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe3;
    RadioButton anghe3,bnghe3,cnghe3,dnghe3;
    Button btnnextnghe3lop1;
    public static final String N3="N3";
    Integer ntd3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3_kiemtranghe_lop1);

        Intent n2= getIntent();
        String c=n2.getStringExtra(N2);
        ntd3=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe3= (ImageButton) findViewById(R.id.imbtnnghe3);
        anghe3=(RadioButton) findViewById(R.id.anghe3);
        bnghe3=(RadioButton) findViewById(R.id.bnghe3);
        cnghe3=(RadioButton) findViewById(R.id.cnghe3);
        dnghe3=(RadioButton) findViewById(R.id.dnghe3);
        btnnextnghe3lop1=(Button) findViewById(R.id.btnnextnghe3lop1);

        imbtnnghe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau3KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_1);
                mediaPlayer.start();
            }
        });

        btnnextnghe3lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnghe3.isChecked())
                {
                    Integer d=ntd3+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd3+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n3= new Intent(Cau3KiemtrangheLop1Activity.this,Cau4KiemtrangheLop1Activity.class);
        n3.putExtra(N3,d.toString());
        startActivity(n3);
    }
}
