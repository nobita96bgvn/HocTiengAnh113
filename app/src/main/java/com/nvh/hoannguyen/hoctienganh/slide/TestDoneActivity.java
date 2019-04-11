package com.nvh.hoannguyen.hoctienganh.slide;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.R;
import com.nvh.hoannguyen.hoctienganh.cauhoi.cauhoi;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<cauhoi> arr_QuesBegin= new ArrayList<cauhoi>();
    int NumNoAns=0;
    int NumTrue=0;
    int NumFalse=0;
    int TotalScore=0;

    TextView tvTrue,tvFalse,tvNotAns,tvTotalScore;
    Button btnAgain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        final Intent intent= getIntent();
        arr_QuesBegin= (ArrayList<cauhoi>) intent.getExtras().getSerializable("arr_Ques");

        begin();
        checkResult();
        TotalScore= NumTrue*1;
        tvNotAns.setText(""+NumNoAns);
        tvFalse.setText(""+NumFalse);
        tvTrue.setText(""+NumTrue);
        tvTotalScore.setText(""+TotalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                finish();
                Intent intent2= new Intent(TestDoneActivity.this,ScreenSlideActivity.class);
                intent2.putExtra("arr_Ques",arr_QuesBegin);
                intent2.putExtra("test","no");
                startActivity(intent2);
            }
        });

    }

    public void refresh(){
        for (int i=0;i<arr_QuesBegin.size();i++){
            arr_QuesBegin.get(i).setTraloi("");
        }
    }

    public void begin(){
        tvFalse=(TextView) findViewById(R.id.tvFalse);
        tvTrue=(TextView) findViewById(R.id.tvTrue);
        tvNotAns=(TextView) findViewById(R.id.tvNotAns);
        tvTotalScore=(TextView) findViewById(R.id.tvTotalPoint);
        btnAgain=(Button) findViewById(R.id.btnAgain);
        btnExit=(Button) findViewById(R.id.btnExit);

    }

    public void checkResult(){
        for(int i=0; i<arr_QuesBegin.size();i++) {
            if (arr_QuesBegin.get(i).getTraloi().equals("")==true){
                NumNoAns++;
            }else if (arr_QuesBegin.get(i).getKetqua().equals(arr_QuesBegin.get(i).getTraloi())==true){
                NumTrue++;
            }else NumFalse++;
        }
    }

}
