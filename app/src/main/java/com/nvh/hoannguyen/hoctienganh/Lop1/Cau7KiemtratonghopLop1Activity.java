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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau6KiemtratonghopLop1Activity.TH6;

public class Cau7KiemtratonghopLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe10;
    EditText edtnghe10;
    Button btnnextnghe10lop1;
    public static final String TH7="TH7";
    Integer z7=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau7_kiemtratonghop_lop1);

        Intent th6= getIntent();
        String c=th6.getStringExtra(TH6);
        z7=Integer.parseInt(c);
        this.setTitle("Kiểm tra tổng hợp");
        imbtnnghe10= (ImageButton) findViewById(R.id.imbtnnghe10);
        edtnghe10=(EditText) findViewById(R.id.edtnghe10);
        btnnextnghe10lop1=(Button) findViewById(R.id.btnnextnghe10lop1);

        imbtnnghe10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau7KiemtratonghopLop1Activity.this, R.raw.kiem_tra_nghe_4);
                mediaPlayer.start();
            }
        });

        btnnextnghe10lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtnghe10.getText().toString();
                if (kq.equals("desk")||kq.equals("Desk"))
                {
                    Integer d=z7+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=z7+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent th7= new Intent(Cau7KiemtratonghopLop1Activity.this,Cau8KiemtratonghopLop1Activity.class);
        th7.putExtra(TH7,d.toString());
        startActivity(th7);
    }
}
