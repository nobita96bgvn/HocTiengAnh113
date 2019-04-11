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

import static com.nvh.hoannguyen.hoctienganh.Lop1.Cau7KiemtrangheLop1Activity.N7;

public class Cau8KiemtrangheLop1Activity extends AppCompatActivity {

    ImageButton imbtnnghe8;
    EditText edtnghe8;
    Button btnnextnghe8lop1;
    public static final String N8="N8";
    Integer ntd8=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau8_kiemtranghe_lop1);

        Intent n7= getIntent();
        String c=n7.getStringExtra(N7);
        ntd8=Integer.parseInt(c);
        this.setTitle("Kiểm tra nghe");
        imbtnnghe8= (ImageButton) findViewById(R.id.imbtnnghe8);
        edtnghe8=(EditText) findViewById(R.id.edtnghe8);
        btnnextnghe8lop1=(Button) findViewById(R.id.btnnextnghe8lop1);

        imbtnnghe8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer= MediaPlayer.create(Cau8KiemtrangheLop1Activity.this, R.raw.kiem_tra_nghe_3);
                mediaPlayer.start();
            }
        });

        btnnextnghe8lop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq= edtnghe8.getText().toString();
                if (kq.equals("Nice to meet you Tony"))
                {
                    Integer d=ntd8+1;
                    byExtra(d);
                }
                else
                {
                    Integer d=ntd8+0;
                    byExtra(d);
                }
            }
        });

    }

    public void byExtra(Integer d){
        Intent n8= new Intent(Cau8KiemtrangheLop1Activity.this, com.nvh.hoannguyen.hoctienganh.Lop1.Cau9KiemtrangheLop1Activity.class);
        n8.putExtra(N8,d.toString());
        startActivity(n8);
    }
}
