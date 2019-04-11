package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.nvh.hoannguyen.hoctienganh.R;

public class baihoctuvung8lop1 extends AppCompatActivity {
    ImageView imageView;
    int[] manghinh ={R.drawable.d_bang,R.drawable.d_but,R.drawable.d_butchi,R.drawable.d_caikeo,R.drawable.d_cap,R.drawable.d_cuctay,R.drawable.d_giayviet,R.drawable.d_gotbutchiok,R.drawable.d_keodan,R.drawable.d_mauve,R.drawable.d_maytinh,R.drawable.d_phanviet,R.drawable.d_sach,R.drawable.d_thuoc};
    int position =0;
    GestureDetector gestureDetector;
    int SWIPE_THRESHOLD = 100;
    int SWIPE_VELOCITY_THRESHOLD =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihoctuvung2lop1);
        imageView = (ImageView) findViewById(R.id.imghinh);
        imageView.setImageResource(manghinh[position]);
        gestureDetector = new GestureDetector(this, new myGesture());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
    class myGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX)> SWIPE_VELOCITY_THRESHOLD){
                position--;
                if(position < 0){
                    position = manghinh.length - 1;
                }
                imageView.setImageResource(manghinh[position]);
            }
            if(e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX)> SWIPE_VELOCITY_THRESHOLD){
                position++;
                if(position > manghinh.length -1){
                    position = 0;
                }
                imageView.setImageResource(manghinh[position]);
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
