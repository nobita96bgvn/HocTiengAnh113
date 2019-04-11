package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.nvh.hoannguyen.hoctienganh.R;

public class baituvung1lop1 extends AppCompatActivity {
    ImageView imageView;
    int[] manghinh ={R.drawable.ic_chu_a,R.drawable.ic_chu_b,R.drawable.ic_chu_c,R.drawable.ic_chu_d,R.drawable.ic_chu_e,R.drawable.ic_chu_f,R.drawable.ic_chu_g,R.drawable.ic_chu_h,R.drawable.ic_chu_i,R.drawable.ic_chu_j,R.drawable.ic_chu_k,R.drawable.ic_chu_m,R.drawable.ic_chu_n,R.drawable.ic_chu_l,R.drawable.ic_chu_o,R.drawable.ic_chu_p,R.drawable.ic_chu_q,R.drawable.ic_chu_r,R.drawable.ic_chu_s,R.drawable.ic_chu_t,R.drawable.ic_chu_u,R.drawable.ic_chu_v,R.drawable.ic_chu_w,R.drawable.ic_chu_x,R.drawable.ic_chu_y,R.drawable.ic_chu_z,R.drawable.name};
    //Mảng lưu trữ các hình ảnh từ vựng
    int position =0;
    //vị trí
    GestureDetector gestureDetector; //Gesture ( cử chỉ  ) - những thao tác với màn hình điện thoại như vuốt, kéo, thả, chạm
    int SWIPE_THRESHOLD = 100;   // ngưỡng quẹt
    int SWIPE_VELOCITY_THRESHOLD =100;  // vận tốc ngưỡng quẹt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baituvung1lop1);
        imageView = (ImageView) findViewById(R.id.imghinh); // ánh xạ imageView
        imageView.setImageResource(manghinh[position]);     // Set hình ảnh tại vị trí màn hình
        gestureDetector = new GestureDetector(this, new myGesture());
        // khởi tạo đối tượng GestureDetectorCompat.
        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
        //bắt sự kiện khi người dùng chạm vào ảnh các từ vựng ( TochEvent)

    }
    //kế thừa lớp myGesture với GestureDetector. SimpleOnGestureListener để hoạt động như là một Listener
    // và ghi đè một số phương thức ( onFling)


    class myGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX)> SWIPE_VELOCITY_THRESHOLD){
                //người dùng vuốt từ phải sang trái
                position--;
                if(position < 0){
                    position = manghinh.length - 1;
                }
                imageView.setImageResource(manghinh[position]);
            }
            if(e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX)> SWIPE_VELOCITY_THRESHOLD){
                // người dùng vuốt Trái sang Phải
                position++;
                if(position > manghinh.length -1){
                    position = 0;
                }
                imageView.setImageResource(manghinh[position]);
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
        /*
        Phương thức boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
        Thông báo về một sự kiện liệng (fling) khi nó xảy ra với ban đầu là cú chạm xuống, quẹt và đi lên.
        Vận tốc tính toán được cung cấp dọc theo trục x và y theo số pixel trên mỗi giây.
        @param e1 sự kiện chuyển động xuống đầu tiên bắt đầu quăng ra.
        @param e2 sự kiện chuyển động di chuyển mà gây ra sự onFling hiện hành.
        @param velocityX Vận tốc của fling này đo bằng pixel mỗi giây dọc theo trục x.
        @param velocityY Vận tốc của fling này đo bằng pixel mỗi giây dọc theo trục y.
        @return true nếu sự kiện này được tiêu thụ (consumed), ngược lại trả về false.
         */
    }
}
