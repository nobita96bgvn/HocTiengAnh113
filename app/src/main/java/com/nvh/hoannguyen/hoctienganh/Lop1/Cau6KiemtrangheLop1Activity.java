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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau5KiemtrangheLop1Activity.N5;

public class Cau6KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe6;
    RadioButton anghe6,bnghe6,cnghe6,dnghe6;
    Button btnnextnghe6lop1;
    public static final String N6="N6";
    Integer ntd6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau6_kiemtranghe_lop1);

        Intent n5= getIntent();
        String c=n5.getStringExtra(N5);
        ntd6=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe6= (ImageButton) findViewById(R.id.imbtnnghe6);
        anghe6=(RadioButton) findViewById(R.id.anghe6);
        bnghe6=(RadioButton) findViewById(R.id.bnghe6);
        cnghe6=(RadioButton) findViewById(R.id.cnghe6);
        dnghe6=(RadioButton) findViewById(R.id.dnghe6);
        btnnextnghe6lop1=(Button) findViewById(R.id.btnnextnghe6lop1);

        imbtnnghe6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau6KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_2);
                mediaPlayer.start();
            }
        });

        btnnextnghe6lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dnghe6.isChecked())
                {
                    Integer d=ntd6+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd6+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n6= new Intent(Cau6KiemtrangheLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau7KiemtrangheLop1Activity.class);
        n6.putExtra(N6,d.toString());
        startActivity(n6);
    }
}
