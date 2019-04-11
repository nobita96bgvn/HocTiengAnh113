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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau1KiemtrangheLop1Activity.N1;

public class Cau2KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe2;
    RadioButton anghe2,bnghe2,cnghe2,dnghe2;
    Button btnnextnghe2lop1;
    public static final String N2="N2";
    Integer ntd2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_kiemtranghe_lop1);

        Intent n1= getIntent();
        String c=n1.getStringExtra(N1);
        ntd2=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe2= (ImageButton) findViewById(R.id.imbtnnghe2);
        anghe2=(RadioButton) findViewById(R.id.anghe2);
        bnghe2=(RadioButton) findViewById(R.id.bnghe2);
        cnghe2=(RadioButton) findViewById(R.id.cnghe2);
        dnghe2=(RadioButton) findViewById(R.id.dnghe2);
        btnnextnghe2lop1=(Button) findViewById(R.id.btnnextnghe2lop1);

        imbtnnghe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau2KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_1);
                mediaPlayer.start();
            }
        });

        btnnextnghe2lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anghe2.isChecked())
                {
                    Integer d=ntd2+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd2+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n2= new Intent(Cau2KiemtrangheLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau3KiemtrangheLop1Activity.class);
        n2.putExtra(N2,d.toString());
        startActivity(n2);
    }
}
