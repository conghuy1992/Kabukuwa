package com.daydelight.kabukuwa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by goood on 11/19/15.
 */
public class Chairmain extends Activity {
    LinearLayout fightsum;
    ImageView chairman;
    int _fight;
    Animation anim;
    FrameLayout root;
    String loaisale = "", namesell = "", name_cpu = "";
    int wingNosale, faceNosale, neckNosale, bodyNosale, horn2Nosale, hornNosale, headNosale, matsale, _level, idpetsell;
    int _head, _horn, _horn2, _wing, _body, _neck, _face, lv, lv2;
    ArrayList<Integer> head_cpu;
    ArrayList<Integer> horn_cpu;
    ArrayList<Integer> horn2_cpu;
    ArrayList<Integer> wing_cpu;
    ArrayList<Integer> body_cpu;
    ArrayList<Integer> neck_cpu;
    ArrayList<Integer> face_cpu;
    ArrayList<String> list_name;
    int s_at = 0, s_hp = 0, s_criat = 0, s_de = 0, s_cri = 0, s_avoid = 0, s_luc = 0, s_spe = 0;
    int pl_at = 0, pl_hp = 0, pl_criat = 0, pl_de = 0, pl_cri = 0, pl_avoid = 0, pl_luc = 0, pl_spe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chairman_layout);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        getData();
        fightsum = (LinearLayout) findViewById(R.id.fightsum);
        chairman = (ImageView) findViewById(R.id.chairman);
        root = (FrameLayout) findViewById(R.id.root);

        list_name = new ArrayList<String>();
        head_cpu = new ArrayList<Integer>();
        horn_cpu = new ArrayList<Integer>();
        horn2_cpu = new ArrayList<Integer>();
        wing_cpu = new ArrayList<Integer>();
        body_cpu = new ArrayList<Integer>();
        face_cpu = new ArrayList<Integer>();
        neck_cpu = new ArrayList<Integer>();
        Intent i = getIntent();
        _fight = i.getIntExtra("_fight", 0);
        DrawLevel(fightsum, _fight);
        anim = AnimationUtils.loadAnimation(this, R.anim.jump_player);
        chairman.startAnimation(anim);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _transdata();
            }
        });
        _gotobattleVC();
    }

    long mLastClickTime = 0;

    public void getData() {
        Intent intent = getIntent();
        loaisale = intent.getStringExtra("loaisale");
        namesell = intent.getStringExtra("namesell");
        wingNosale = intent.getIntExtra("wingNosale", 0);
        faceNosale = intent.getIntExtra("faceNosale", 0);
        neckNosale = intent.getIntExtra("neckNosale", 0);
        bodyNosale = intent.getIntExtra("bodyNosale", 0);
        horn2Nosale = intent.getIntExtra("horn2Nosale", 0);
        hornNosale = intent.getIntExtra("hornNosale", 0);
        headNosale = intent.getIntExtra("headNosale", 0);
        matsale = intent.getIntExtra("matsale", 0);
        _level = intent.getIntExtra("_level", 0);
//        Log.e("_level", "" + _level);

        _head = intent.getIntExtra("arr_head", 0);
        _horn = intent.getIntExtra("arr_horn", 0);
        _horn2 = intent.getIntExtra("arr_horn2", 0);
        _face = intent.getIntExtra("arr_face", 0);
        _body = intent.getIntExtra("arr_body", 0);
        _wing = intent.getIntExtra("arr_wing", 0);
        _neck = intent.getIntExtra("arr_neck", 0);

        s_hp = intent.getIntExtra("arr_s_hp", 0);
        s_at = intent.getIntExtra("arr_s_at", 0);
        s_criat = intent.getIntExtra("arr_s_criat", 0);
        s_de = intent.getIntExtra("arr_s_de", 0);
        s_cri = intent.getIntExtra("arr_s_cri", 0);
        s_avoid = intent.getIntExtra("arr_s_avoid", 0);
        s_luc = intent.getIntExtra("arr_s_luc", 0);
        s_spe = intent.getIntExtra("arr_s_spe", 0);

        pl_hp = intent.getIntExtra("pl_hp", 0);
        pl_at = intent.getIntExtra("pl_at", 0);
        pl_criat = intent.getIntExtra("pl_criat", 0);
        pl_de = intent.getIntExtra("pl_de", 0);
        pl_cri = intent.getIntExtra("pl_cri", 0);
        pl_avoid = intent.getIntExtra("pl_avoid", 0);
        pl_luc = intent.getIntExtra("pl_luc", 0);
        pl_spe = intent.getIntExtra("pl_spe", 0);

//        Log.e("s_hp", "" + pl_hp);
//        Log.e("s_at",""+pl_at);
//        Log.e("s_criat",""+pl_criat);
//        Log.e("s_de",""+pl_de);
//        Log.e("s_cri",""+pl_cri);
//        Log.e("s_avoid",""+pl_avoid);
//        Log.e("s_luc",""+pl_luc);
//        Log.e("s_spe",""+pl_spe);

        lv = intent.getIntExtra("lv", 0);
        name_cpu = intent.getStringExtra("str_CPU");
    }

    public void _transdata() {
        Intent i = new Intent(Chairmain.this, BattleVC.class);
        i.putExtra("loaisale", loaisale);
        i.putExtra("namesell", namesell);
        i.putExtra("wingNosale", wingNosale);
        i.putExtra("faceNosale", faceNosale);
        i.putExtra("neckNosale", neckNosale);
        i.putExtra("bodyNosale", bodyNosale);
        i.putExtra("horn2Nosale", horn2Nosale);
        i.putExtra("hornNosale", hornNosale);
        i.putExtra("headNosale", headNosale);
        i.putExtra("matsale", matsale);
        i.putExtra("_level", _level);

        i.putExtra("arr_head", _head);
        i.putExtra("arr_horn", _horn);
        i.putExtra("arr_horn2", _horn2);
        i.putExtra("arr_face", _face);
        i.putExtra("arr_body", _body);
        i.putExtra("arr_wing", _wing);
        i.putExtra("arr_neck", _neck);
        i.putExtra("name_cpu", name_cpu);
        i.putExtra("lv", lv);
        Intent intent = getIntent();

        i.putExtra("inKind", intent.getIntExtra("inKind", 0));
        i.putExtra("cpu_kind", intent.getIntExtra("cpu_kind", 0));

        lv2 = intent.getIntExtra("lv2", 0);
        i.putExtra("part_index", intent.getIntExtra("part_index", 0));
        i.putExtra("idpetsell", intent.getIntExtra("idpetsell", 0));

        head_cpu = intent.getIntegerArrayListExtra("head_cpu");
        list_name = intent.getStringArrayListExtra("list_name");
        horn_cpu = intent.getIntegerArrayListExtra("horn_cpu");
        horn2_cpu = intent.getIntegerArrayListExtra("horn2_cpu");
        wing_cpu = intent.getIntegerArrayListExtra("wing_cpu");
        body_cpu = intent.getIntegerArrayListExtra("body_cpu");
        face_cpu = intent.getIntegerArrayListExtra("face_cpu");
        neck_cpu = intent.getIntegerArrayListExtra("neck_cpu");
        i.putExtra("lv2", lv2);
        i.putIntegerArrayListExtra("head_cpu", head_cpu);
        i.putIntegerArrayListExtra("horn_cpu", horn_cpu);
        i.putIntegerArrayListExtra("horn2_cpu", horn2_cpu);
        i.putIntegerArrayListExtra("wing_cpu", wing_cpu);
        i.putIntegerArrayListExtra("body_cpu", body_cpu);
        i.putIntegerArrayListExtra("neck_cpu", neck_cpu);
        i.putIntegerArrayListExtra("face_cpu", face_cpu);
        i.putStringArrayListExtra("list_name", list_name);

        i.putExtra("arr_s_hp", s_hp);
        i.putExtra("arr_s_at", s_at);
        i.putExtra("arr_s_criat", s_criat);
        i.putExtra("arr_s_de", s_de);
        i.putExtra("arr_s_cri", s_cri);
        i.putExtra("arr_s_avoid", s_avoid);
        i.putExtra("arr_s_luc", s_luc);
        i.putExtra("arr_s_spe", s_spe);

        i.putExtra("pl_hp", pl_hp);
        i.putExtra("pl_at", pl_at);
        i.putExtra("pl_criat", pl_criat);
        i.putExtra("pl_de", pl_de);
        i.putExtra("pl_cri", pl_cri);
        i.putExtra("pl_avoid", pl_avoid);
        i.putExtra("pl_luc", pl_luc);
        i.putExtra("pl_spe", pl_spe);

        startActivity(i);
        finish();
    }

    AtomicBoolean d = new AtomicBoolean(false);

    public void _gotobattleVC() {
        d.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i < 11 && d.get(); i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10)
                                    _transdata();
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        d.set(true);
        th.start();
    }

    public void DrawLevel(LinearLayout layoutLevel, int lv) {
        if (layoutLevel != null)
            layoutLevel.removeAllViews();
        String str = "" + lv;
        String[] arr = str.split("");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < arr.length; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(params);
            img.setAdjustViewBounds(true);
            if (arr[i].equals("0"))
                img.setImageResource(R.drawable.chairman_0);
            else if (arr[i].equals("1"))
                img.setImageResource(R.drawable.chairman_1);
            else if (arr[i].equals("2"))
                img.setImageResource(R.drawable.chairman_2);
            else if (arr[i].equals("3"))
                img.setImageResource(R.drawable.chairman_3);
            else if (arr[i].equals("4"))
                img.setImageResource(R.drawable.chairman_4);
            else if (arr[i].equals("5"))
                img.setImageResource(R.drawable.chairman_5);
            else if (arr[i].equals("6"))
                img.setImageResource(R.drawable.chairman_6);
            else if (arr[i].equals("7"))
                img.setImageResource(R.drawable.chairman_7);
            else if (arr[i].equals("8"))
                img.setImageResource(R.drawable.chairman_8);
            else if (arr[i].equals("9"))
                img.setImageResource(R.drawable.chairman_9);
            layoutLevel.addView(img);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        try {
            if (pre.getBoolean("sound", true) == true) {
                Battle.soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        d.set(false);
        try {
            if (Battle.soundbg.isPlaying()) {
                Battle.soundbg.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
