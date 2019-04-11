package com.nvh.hoannguyen.hoctienganh.Lop4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.Lop1.Song;
import com.nvh.hoannguyen.hoctienganh.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Luyennghelop4Activity extends AppCompatActivity {
    TextView title, bdau,kthuc;
    SeekBar seekBar;
    ImageButton pre,play,stop,next;
    ImageView  imageView;
    ArrayList<Song> arraySong;
    int position =0;
    MediaPlayer mediaPlayer;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luyennghelop1);
        title = (TextView) findViewById(R.id.title);
        bdau  = (TextView) findViewById(R.id.bdau);
        kthuc  = (TextView) findViewById(R.id.kthuc);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        pre = (ImageButton) findViewById(R.id.pre);
        play = (ImageButton) findViewById(R.id.play);
        stop = (ImageButton) findViewById(R.id.stop);
        next = (ImageButton) findViewById(R.id.next);
        imageView = (ImageView) findViewById(R.id.imageView4);
        addSong();
        animation = AnimationUtils.loadAnimation(this,R.anim.dia_xoay);
        khoitaomedia();
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position<0)
                {
                    position = arraySong.size() -1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                khoitaomedia();
                mediaPlayer.start();
                play.setImageResource(R.drawable.bpau);
                tongthoigian();
                capnhatthoigian();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > arraySong.size() -1){
                    position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                khoitaomedia();
                mediaPlayer.start();
                play.setImageResource(R.drawable.bpau);
                tongthoigian();
                capnhatthoigian();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                play.setImageResource(R.drawable.btplay);
                khoitaomedia();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.btplay);
                }else{
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.bpau);
                }
                tongthoigian();
                capnhatthoigian();

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }
    private void capnhatthoigian(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
                                    bdau.setText(dinhdanggio.format(mediaPlayer.getCurrentPosition()));
                                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mp) {
                                            position++;
                                            if(position > arraySong.size() -1){
                                                position=0;
                                            }
                                            if(mediaPlayer.isPlaying()){
                                                mediaPlayer.stop();
                                            }
                                            khoitaomedia();
                                            mediaPlayer.start();
                                            play.setImageResource(R.drawable.bpau);
                                            tongthoigian();
                                            capnhatthoigian();
                                        }
                                    });
                                    handler.postDelayed(this,500);
                                }
                            },100
        );
    }
    private void tongthoigian(){
        SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
        kthuc.setText(dinhdanggio.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
    private void khoitaomedia(){
        mediaPlayer = MediaPlayer.create(Luyennghelop4Activity.this, arraySong.get(position).getFile());
        title.setText(arraySong.get(position).getTitle());
    }
    private  void addSong(){
        arraySong = new ArrayList<>();

        arraySong.add(new Song("Bài 1: What are going to do ", R.raw.gogo_38_what_are_you_going_to_do));
        arraySong.add(new Song("Bài 2: How are you ", R.raw.how_are_you_or_how_old_are_you_song_for_kids_grade_1));
        arraySong.add(new Song("Bài 3: Sam and Mel ", R.raw.lesson_1_sam_and_mel_english_for_children));


    }
}
