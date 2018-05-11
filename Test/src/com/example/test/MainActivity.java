package com.example.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;  
import android.media.MediaPlayer;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.TextView;  


public class MainActivity extends Activity {  
    private Button stop;  
    private Button start;  
    private Button pause;  
    MediaPlayer mMediaPlayer;  
    private TextView mTextView;  
    private boolean bIsPlaying = false;  
    private boolean bIsReleased = true;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        mMediaPlayer = new MediaPlayer();  
        start = (Button) findViewById(R.id.start);  
        stop = (Button) findViewById(R.id.stop);  
        pause = (Button) findViewById(R.id.pause);  
        mTextView = (TextView) findViewById(R.id.textView);  
        start.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                if (mMediaPlayer.isPlaying()) {  
                    mMediaPlayer.reset();  
                }  
                mMediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.music_k);  
                mMediaPlayer.setLooping(true);  
                mMediaPlayer.start();  
                mTextView.setText("ÕýÔÚ²¥·Å");  
//                start.setVisibility(View.GONE);  
//                stop.setVisibility(View.VISIBLE);  
//                pause.setVisibility(View.VISIBLE);  
  
            }  
        });  
        stop.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                if(mMediaPlayer.isPlaying()){  
                    mMediaPlayer.reset();  
                    mTextView.setText("Í£Ö¹");  
//                    stop.setVisibility(View.GONE);  
//                    start.setVisibility(View.VISIBLE);  
//                    pause.setVisibility(View.VISIBLE);  
                }  
            }  
        });  
        pause.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                if(mMediaPlayer.isPlaying()){  
                    mMediaPlayer.pause();  
                }else{  
                    mMediaPlayer.start();  
                }  
//                pause.setVisibility(View.GONE);  
//                start.setVisibility(View.VISIBLE);  
//                stop.setVisibility(View.VISIBLE);  
                mTextView.setText("ÔÝÍ£");  
            }  
        });  
    }  
}  
