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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau8KiemtrangheLop1Activity.N8;

public class Cau9KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe9;
    EditText edtnghe9;
    Button btnnextnghe9lop1;
    public static final String N9="N9";
    Integer ntd9=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau9_kiemtranghe_lop1);

        Intent n8= getIntent();
        String c=n8.getStringExtra(N8);
        ntd9=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe9= (ImageButton) findViewById(R.id.imbtnnghe9);
        edtnghe9=(EditText) findViewById(R.id.edtnghe9);
        btnnextnghe9lop1=(Button) findViewById(R.id.btnnextnghe9lop1);

        imbtnnghe9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau9KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_3);
                mediaPlayer.start();
            }
        });

        btnnextnghe9lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtnghe9.getText().toString();
                if (kq.equals("Goodbye Gogo"))
                {
                    Integer d=ntd9+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd9+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n9= new Intent(Cau9KiemtrangheLop1Activity.this,Cau10KiemtrangheLop1Activity.class);
        n9.putExtra(N9,d.toString());
        startActivity(n9);
    }
}
