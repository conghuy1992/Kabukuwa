package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.zukan_main;

import com.daydelight.kabukuwa.R;

import java.util.List;

/**
 * Created by goood on 5/20/15.
 */
public class story extends Activity {
    VideoView mvideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_layout);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);


        mvideoView = (VideoView) findViewById(R.id.videoView);
        String SrcPath = "android.resource://" + getPackageName() + "/" + R.raw.story1;
        MediaController ctrl = new MediaController(this);
        ctrl.setVisibility(View.GONE);
        mvideoView.setMediaController(ctrl);
        mvideoView.setVideoPath(SrcPath);
        mvideoView.requestFocus();
        mvideoView.start();
        mvideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                finish();
                Intent intent = new Intent(story.this, zukan_main.class);
                startActivity(intent);
            }
        });
        mvideoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                finish();
                Intent intent = new Intent(story.this, zukan_main.class);
                startActivity(intent);
                return false;
            }
        });
    }


    int stopPosition;

    @Override
    protected void onPause() {
        super.onPause();
        stopPosition = mvideoView.getCurrentPosition(); //stopPosition is an int
        mvideoView.pause();
        try {
            if (main_intro.mediaPlayer.isPlaying()) {
                main_intro.mediaPlayer.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvideoView.seekTo(stopPosition);
        mvideoView.start();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        try {
            if (pre.getBoolean("sound", true) == true) {
                main_intro.mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
