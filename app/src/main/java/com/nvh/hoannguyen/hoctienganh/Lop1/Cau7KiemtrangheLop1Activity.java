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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau6KiemtrangheLop1Activity.N6;

public class Cau7KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe7;
    RadioButton anghe7,bnghe7,cnghe7,dnghe7;
    Button btnnextnghe7lop1;
    public static final String N7="N7";
    Integer ntd7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau7_kiemtranghe_lop1);

        Intent n6= getIntent();
        String c=n6.getStringExtra(N6);
        ntd7=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe7= (ImageButton) findViewById(R.id.imbtnnghe7);
        anghe7=(RadioButton) findViewById(R.id.anghe7);
        bnghe7=(RadioButton) findViewById(R.id.bnghe7);
        cnghe7=(RadioButton) findViewById(R.id.cnghe7);
        dnghe7=(RadioButton) findViewById(R.id.dnghe7);
        btnnextnghe7lop1=(Button) findViewById(R.id.btnnextnghe7lop1);

        imbtnnghe7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau7KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_3);
                mediaPlayer.start();
            }
        });

        btnnextnghe7lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnghe7.isChecked())
                {
                    Integer d=ntd7+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd7+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n7= new Intent(Cau7KiemtrangheLop1Activity.this,Cau8KiemtrangheLop1Activity.class);
        n7.putExtra(N7,d.toString());
        startActivity(n7);
    }
}
