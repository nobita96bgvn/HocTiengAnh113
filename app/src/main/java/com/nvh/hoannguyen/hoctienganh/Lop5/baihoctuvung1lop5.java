package com.nvh.hoannguyen.hoctienganh.Lop5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.nvh.hoannguyen.hoctienganh.R;

public class baihoctuvung1lop5 extends AppCompatActivity {
    ImageView imageView;
    int[] manghinh ={R.drawable.c_banhmiok,R.drawable.c_banhngotok,R.drawable.c_batcom,R.drawable.c_khoaitay,R.drawable.c_miongok,R.drawable.c_phomatok,R.drawable.c_pizzaok,R.drawable.c_phomatok,R.drawable.c_rautronok,R.drawable.c_sandwichok,R.drawable.c_sup,R.drawable.c_trungok,R.drawable.c_xxok};
    int position =0;
    GestureDetector gestureDetector;
    int SWIPE_THRESHOLD = 100;
    int SWIPE_VELOCITY_THRESHOLD =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baituvung1lop1);
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
