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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau9KiemtrangheLop1Activity.N9;

public class Cau10KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe10;
    EditText edtnghe10;
    Button btnnextnghe10lop1;
    public static final String N10="N10";
    Integer ntd10=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau10_kiemtranghe_lop1);

        Intent n9= getIntent();
        String c=n9.getStringExtra(N9);
        ntd10=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe10= (ImageButton) findViewById(R.id.imbtnnghe10);
        edtnghe10=(EditText) findViewById(R.id.edtnghe10);
        btnnextnghe10lop1=(Button) findViewById(R.id.btnnextnghe10lop1);

        imbtnnghe10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau10KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_4);
                mediaPlayer.start();
            }
        });

        btnnextnghe10lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtnghe10.getText().toString();
                if (kq.equals("desk")||kq.equals("Desk"))
                {
                    Integer d=ntd10+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd10+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n10= new Intent(Cau10KiemtrangheLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.KetquaKiemtrangheLop1Activity.class);
        n10.putExtra(N10,d.toString());
        startActivity(n10);
    }
}
