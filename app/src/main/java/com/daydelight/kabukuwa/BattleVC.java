package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;


public class BattleVC extends Activity {
    long mLastClickTime = 0;
    boolean bsound = false;
    Animation zoomin, zoomin2, zoomout, zoomout2;
    LinearLayout rootbattlevc;
    private PublisherAdView mAdView;
    int wingNosale, faceNosale, neckNosale, bodyNosale, horn2Nosale, hornNosale, headNosale, matsale, _level, idpetsell;
    int _head, _horn, _horn2, _wing, _body, _neck, _face, lv, imagoDropPartsIndex;
    String loaisale = "", namesell = "", name_cpu = "";
    int cpu_kind, inKind;
    TextView Name, NameCPU, hpcpu, hpplayer, msgcpu, msgplayer, adexp, textcoin, adcoin, txtuplv, txtwin, txtexp, txtget, txtgetpart, txtgetpart2;
    ImageView horn, horn2, head, body, neck, wing, face, horn_cpu, horn2_cpu, head_cpu, body_cpu, neck_cpu, wing_cpu, face_cpu,
            pl_head, pl_horn, pl_horn2, pl_face, pl_neck, cpu_head, cpu_horn, cpu_horn2, cpu_face, cpu_neck, battle_skip,
            btl_roulette_attack, btl_roulette_attack2, btl_roulette_attack3, btl_roulette_attack4, btl_roulette_attack5,
            btl_roulette_attack6, btl_roulette_attack7, btl_roulette_attack8, battle_win, battle_lose, battle_dust1, battle_dust2,
            battle_dust3, battle_dust4, battle_dust5, battle_dust6, battle_dust7, battle_dust8, battle_result_win, battle_ready,
            partbonus, battle_word1, battle_word2, battle_life_img, battle_word3, battle_word32, battle_word33,
            btl_arrow_attack, btl_arrow_attack2, btl_arrow_attack3, btl_arrow_attack4, btl_arrow_attack5, btl_arrow_attack6, btl_arrow_attack7, btl_arrow_attack8;
    ArrayList<Integer> CPUhead;
    ArrayList<Integer> CPUhorn;
    ArrayList<Integer> CPUhorn2;
    ArrayList<Integer> CPUwing;
    ArrayList<Integer> CPUbody;
    ArrayList<Integer> CPUneck;
    ArrayList<Integer> CPUface;
    ArrayList<String> list_name;
    LinearLayout cheering;
    Animation jump_cheer;
    TranslateAnimation trans_battle, trans_battle2, trans_battle3;
    dbHandler db;
    MediaPlayer kSEBattleStart, kSEBattleEnd, kSEBattleResultStart, kSEBattleResultEnd, playerAttack, cpuAttack;
    FrameLayout cheer1, cheer2, cheer3, cheer4, cheer5, cheer6, cheer7, frplayer, frcpu, frtop, battle_dust, battle_dust_bg, battle_effect_win,
            battle_frame, battle_frame_flip, btl_base, confetti;
    boolean ready_battle = false;
    int s_at = 0, s_hp = 0, s_criat = 0, s_de = 0, s_cri = 0, s_avoid = 0, s_luc = 0, s_spe = 0, s_hp_temp = 0;
    int pl_at = 0, pl_criat = 0, pl_de = 0, pl_cri = 0, pl_avoid = 0, pl_luc = 0, pl_spe = 0, pl_hp_temp = 0;
    int margin_word[] = {25, 50, 75, 90, 100, 125, 140, 150, 160, 175, 190, 200, 225};
    ProgressBar battle_life_cpu, battle_life_player, pr_bg_btl_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_vc);
//        getWindow().setFlags(
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
//                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        getData();
        _initView();
        handler.post(_prepareBattle);
    }

    FrameLayout.LayoutParams params_Dust1, params_Dust2, params_word1, params_word2;
    int Dust_mg[] = {50, 75, 100, 125, 150, 175, 200, 220};

    public void _initView() {
        handler = new Handler();
        jump_cheer = AnimationUtils.loadAnimation(this, R.anim.jump_cheer);
        kSEBattleStart = MediaPlayer.create(this, R.raw.se023);
        kSEBattleEnd = MediaPlayer.create(this, R.raw.se024);
        kSEBattleResultStart = MediaPlayer.create(this, R.raw.se025);
        kSEBattleResultEnd = MediaPlayer.create(this, R.raw.se026);
        playerAttack = MediaPlayer.create(this, R.raw.se035);
        cpuAttack = MediaPlayer.create(this, R.raw.se031);
        db = new dbHandler(this);
        int _w = (int) convertDpToPixel(60);
        params_Dust1 = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
        params_Dust2 = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
        params_word1 = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
        params_word2 = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
        params_Dust1.gravity = Gravity.CENTER | Gravity.TOP;
        params_Dust2.gravity = Gravity.CENTER | Gravity.TOP;
        params_word1.gravity = Gravity.CENTER;
        params_word2.gravity = Gravity.CENTER;
        int a_trans_battle = -70;
        int a_trans_battle2 = -160;
        if (mypage._Width <= 480) {
            a_trans_battle = -61;
            a_trans_battle2 = -140;
        }
        trans_battle = new TranslateAnimation(0, 0, 0, a_trans_battle);
        trans_battle.setDuration(200);
        trans_battle2 = new TranslateAnimation(0, 0, 0, a_trans_battle2);
        trans_battle2.setDuration(200);
        trans_battle2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                frcpu.setLayerType(View.LAYER_TYPE_NONE, null);
                frcpu.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        trans_battle3 = new TranslateAnimation(0, 0, 0, a_trans_battle2);
        trans_battle3.setDuration(200);
        trans_battle3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                frplayer.setLayerType(View.LAYER_TYPE_NONE, null);
                frplayer.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                handler.post(roulette_attack);
            }
        });
        battle_word3 = (ImageView) findViewById(R.id.battle_word3);
        battle_word32 = (ImageView) findViewById(R.id.battle_word32);
        battle_word33 = (ImageView) findViewById(R.id.battle_word33);
        battle_life_img = (ImageView) findViewById(R.id.battle_life_img);
        battle_life_cpu = (ProgressBar) findViewById(R.id.battle_life_cpu);
        battle_life_cpu.setMax(s_hp_temp);
        battle_life_player = (ProgressBar) findViewById(R.id.battle_life_player);
        pr_bg_btl_base = (ProgressBar) findViewById(R.id.pr_bg_btl_base);

        battle_life_player.setMax(pl_hp_temp);
        if (mypage._hp < mypage.pl_hp) {
            battle_life_player.setProgress(mypage._hp);
            battle_life_img.setVisibility(View.GONE);
        }
        Name = (TextView) findViewById(R.id.Name);
        NameCPU = (TextView) findViewById(R.id.NameCPU);
        hpcpu = (TextView) findViewById(R.id.hpcpu);
        hpplayer = (TextView) findViewById(R.id.hpplayer);
        msgplayer = (TextView) findViewById(R.id.msgplayer);
        adexp = (TextView) findViewById(R.id.adexp);
        textcoin = (TextView) findViewById(R.id.textcoin);
        adcoin = (TextView) findViewById(R.id.adcoin);
        txtuplv = (TextView) findViewById(R.id.txtuplv);
        txtwin = (TextView) findViewById(R.id.txtwin);
        txtexp = (TextView) findViewById(R.id.txtexp);
        txtget = (TextView) findViewById(R.id.txtget);
        txtgetpart = (TextView) findViewById(R.id.txtgetpart);
        txtgetpart2 = (TextView) findViewById(R.id.txtgetpart2);

        msgcpu = (TextView) findViewById(R.id.msgcpu);
        msgplayer.setText("" + Chat.startMessageForPlayer[new Random().nextInt(Chat.startMessageForPlayer.length)]);
        msgcpu.setText("" + Chat.startMessageForCPU[new Random().nextInt(Chat.startMessageForCPU.length)]);

        hpcpu.setText("" + s_hp + "/" + s_hp_temp);
        hpplayer.setText("" + mypage._hp + "/" + pl_hp_temp);
        Name.setText("" + namesell);
        NameCPU.setText("" + name_cpu + " Lv." + lv);
        horn = (ImageView) findViewById(R.id.horn);
        horn2 = (ImageView) findViewById(R.id.horn2);
        head = (ImageView) findViewById(R.id.head);
        neck = (ImageView) findViewById(R.id.neck);
        body = (ImageView) findViewById(R.id.body);
        wing = (ImageView) findViewById(R.id.wing);
        face = (ImageView) findViewById(R.id.face);
        horn_cpu = (ImageView) findViewById(R.id.horn_cpu);
        horn2_cpu = (ImageView) findViewById(R.id.horn2_cpu);
        head_cpu = (ImageView) findViewById(R.id.head_cpu);
        face_cpu = (ImageView) findViewById(R.id.face_cpu);
        wing_cpu = (ImageView) findViewById(R.id.wing_cpu);
        body_cpu = (ImageView) findViewById(R.id.body_cpu);
        neck_cpu = (ImageView) findViewById(R.id.neck_cpu);
        pl_head = (ImageView) findViewById(R.id.pl_head);
        pl_horn = (ImageView) findViewById(R.id.pl_horn);
        pl_horn2 = (ImageView) findViewById(R.id.pl_horn2);
        pl_face = (ImageView) findViewById(R.id.pl_face);
        pl_neck = (ImageView) findViewById(R.id.pl_neck);
        cpu_head = (ImageView) findViewById(R.id.cpu_head);
        cpu_horn = (ImageView) findViewById(R.id.cpu_horn);
        cpu_horn2 = (ImageView) findViewById(R.id.cpu_horn2);
        cpu_face = (ImageView) findViewById(R.id.cpu_face);
        cpu_neck = (ImageView) findViewById(R.id.cpu_neck);
        cheering = (LinearLayout) findViewById(R.id.cheering);
        cheer1 = (FrameLayout) findViewById(R.id.cheer1);
        cheer2 = (FrameLayout) findViewById(R.id.cheer2);
        cheer3 = (FrameLayout) findViewById(R.id.cheer3);
        cheer4 = (FrameLayout) findViewById(R.id.cheer4);
        cheer5 = (FrameLayout) findViewById(R.id.cheer5);
        cheer6 = (FrameLayout) findViewById(R.id.cheer6);
        cheer7 = (FrameLayout) findViewById(R.id.cheer7);
        frplayer = (FrameLayout) findViewById(R.id.frplayer);
        frcpu = (FrameLayout) findViewById(R.id.frcpu);
        frplayer.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        frcpu.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        frtop = (FrameLayout) findViewById(R.id.frtop);
        battle_dust = (FrameLayout) findViewById(R.id.battle_dust);
        battle_dust_bg = (FrameLayout) findViewById(R.id.battle_dust_bg);
        battle_effect_win = (FrameLayout) findViewById(R.id.battle_effect_win);
        battle_frame_flip = (FrameLayout) findViewById(R.id.battle_frame_flip);
        battle_frame = (FrameLayout) findViewById(R.id.battle_frame);
        btl_base = (FrameLayout) findViewById(R.id.btl_base);
        confetti = (FrameLayout) findViewById(R.id.confetti);
        btl_base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ready_battle)
                    updateStore();
            }
        });

        CPUhead = new ArrayList<Integer>();
        CPUhorn = new ArrayList<Integer>();
        CPUhorn2 = new ArrayList<Integer>();
        CPUwing = new ArrayList<Integer>();
        CPUbody = new ArrayList<Integer>();
        CPUneck = new ArrayList<Integer>();
        CPUface = new ArrayList<Integer>();
        list_name = new ArrayList<String>();
        battle_skip = (ImageView) findViewById(R.id.battle_skip);
        battle_win = (ImageView) findViewById(R.id.battle_win);
        battle_lose = (ImageView) findViewById(R.id.battle_lose);

        battle_dust1 = (ImageView) findViewById(R.id.battle_dust1);
        battle_dust2 = (ImageView) findViewById(R.id.battle_dust2);
        battle_dust3 = (ImageView) findViewById(R.id.battle_dust3);
        battle_dust4 = (ImageView) findViewById(R.id.battle_dust4);
        battle_dust5 = (ImageView) findViewById(R.id.battle_dust5);
        battle_dust6 = (ImageView) findViewById(R.id.battle_dust6);
        battle_dust7 = (ImageView) findViewById(R.id.battle_dust7);
        battle_dust8 = (ImageView) findViewById(R.id.battle_dust8);
        battle_dust3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_dust4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_dust5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_dust6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_dust7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_dust8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        battle_result_win = (ImageView) findViewById(R.id.battle_result_win);
        battle_ready = (ImageView) findViewById(R.id.battle_ready);
        partbonus = (ImageView) findViewById(R.id.partbonus);
        battle_word1 = (ImageView) findViewById(R.id.battle_word1);
        battle_word2 = (ImageView) findViewById(R.id.battle_word2);

        rootbattlevc = (LinearLayout) findViewById(R.id.rootbattlevc);
        btl_roulette_attack = (ImageView) findViewById(R.id.btl_roulette_attack);
        btl_roulette_attack2 = (ImageView) findViewById(R.id.btl_roulette_attack2);
        btl_roulette_attack3 = (ImageView) findViewById(R.id.btl_roulette_attack3);
        btl_roulette_attack4 = (ImageView) findViewById(R.id.btl_roulette_attack4);
        btl_roulette_attack5 = (ImageView) findViewById(R.id.btl_roulette_attack5);
        btl_roulette_attack6 = (ImageView) findViewById(R.id.btl_roulette_attack6);
        btl_roulette_attack7 = (ImageView) findViewById(R.id.btl_roulette_attack7);
        btl_roulette_attack8 = (ImageView) findViewById(R.id.btl_roulette_attack8);

        btl_arrow_attack = (ImageView) findViewById(R.id.btl_arrow_attack);
        btl_arrow_attack2 = (ImageView) findViewById(R.id.btl_arrow_attack2);
        btl_arrow_attack3 = (ImageView) findViewById(R.id.btl_arrow_attack3);
        btl_arrow_attack4 = (ImageView) findViewById(R.id.btl_arrow_attack4);
        btl_arrow_attack5 = (ImageView) findViewById(R.id.btl_arrow_attack5);
        btl_arrow_attack6 = (ImageView) findViewById(R.id.btl_arrow_attack6);
        btl_arrow_attack7 = (ImageView) findViewById(R.id.btl_arrow_attack7);
        btl_arrow_attack8 = (ImageView) findViewById(R.id.btl_arrow_attack8);
//        btl_arrow_attack.setRotation(110);
//        btl_arrow_attack2.setRotation(160);
//        btl_arrow_attack3.setRotation(200);
//        btl_arrow_attack4.setRotation(250);

        btl_roulette_attack2.setRotation(45);
        btl_roulette_attack3.setRotation(90);
        btl_roulette_attack4.setRotation(135);
        btl_roulette_attack5.setRotation(180);
        btl_roulette_attack6.setRotation(225);
        btl_roulette_attack7.setRotation(270);
        btl_roulette_attack8.setRotation(315);
        rootbattlevc.setEnabled(false);
        rootbattlevc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                finish();
            }
        });
        battle_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                _sleep = 200;
                roulette_attack_speed = 70;
            }
        });
        _animDust();
        _createCheering();
        _animCheer();
        setImageforPlayer();
        setimageforCPU();
        if (loaisale.equals("loai3") || loaisale.equals("loai6")) {
            int a = (int) convertDpToPixel(140);
            if (mypage._Width <= 480)
                a = (int) convertDpToPixel(122);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(a, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.setMargins(0, 0, (int) convertDpToPixel(45), (int) convertDpToPixel(40));
            frplayer.setLayoutParams(params);
        } else if (loaisale.equals("loai8")) {
            int a = (int) convertDpToPixel(150);
            if (mypage._Width <= 480)
                a = (int) convertDpToPixel(131);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(a, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.setMargins(0, 0, (int) convertDpToPixel(45), (int) convertDpToPixel(40));
            frplayer.setLayoutParams(params);
        }
        if (cpu_kind == 1 || cpu_kind == 1002) {
            int a = (int) convertDpToPixel(140);
            if (mypage._Width <= 480)
                a = (int) convertDpToPixel(122);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(a, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.setMargins((int) convertDpToPixel(45), 0, 0, (int) convertDpToPixel(40));
            frcpu.setLayoutParams(params);
        } else if (cpu_kind == 3) {
            int a = (int) convertDpToPixel(150);
            if (mypage._Width <= 480)
                a = (int) convertDpToPixel(131);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(a, FrameLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.setMargins((int) convertDpToPixel(45), 0, 0, (int) convertDpToPixel(40));
            frcpu.setLayoutParams(params);
        }
    }

    public void _animDust() {
        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin_dust);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout_dust);
        zoomin2 = AnimationUtils.loadAnimation(this, R.anim.zoomin_dust);
        zoomout2 = AnimationUtils.loadAnimation(this, R.anim.zoomout_dust);
        battle_dust3.startAnimation(zoomin);
        battle_dust4.startAnimation(zoomin);
        battle_dust5.startAnimation(zoomin);
        battle_dust6.startAnimation(zoomout);
        battle_dust7.startAnimation(zoomout);
        battle_dust8.startAnimation(zoomout);
//        zoomin.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//                battle_dust3.startAnimation(zoomout);
//                battle_dust5.startAnimation(zoomout);
//                battle_dust7.startAnimation(zoomout);
//                battle_dust3.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust5.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust7.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            }
//        });
//        zoomout.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//                battle_dust3.startAnimation(zoomin);
//                battle_dust5.startAnimation(zoomin);
//                battle_dust7.startAnimation(zoomin);
//                battle_dust3.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust5.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust7.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            }
//        });
//
//        zoomin2.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//                battle_dust4.startAnimation(zoomout2);
//                battle_dust6.startAnimation(zoomout2);
//                battle_dust8.startAnimation(zoomout2);
//                battle_dust4.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust6.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust8.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            }
//        });
//        zoomout2.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation arg0) {
//                battle_dust4.startAnimation(zoomin2);
//                battle_dust6.startAnimation(zoomin2);
//                battle_dust8.startAnimation(zoomin2);
//                battle_dust4.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust6.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//                battle_dust8.setLayerType(View.LAYER_TYPE_NONE, null);
//                battle_dust8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
//            }
//        });
    }


    public void setimageforCPU() {
        if (name_cpu.equals("カブトムシ")) {
            if (_wing > 4)
                _wing = 4;
            if (_face > 5)
                _face = 5;
            if (_neck > 3)
                _neck = 3;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing[_wing - 1]);
            body_cpu.setImageResource(Chat.body[_body]);
            neck_cpu.setImageResource(Chat.neck[_neck]);
            head_cpu.setImageResource(Chat.head[_head]);
            horn_cpu.setImageResource(Chat.horn[_horn]);
            face_cpu.setImageResource(Chat.face[_face]);

            cpu_neck.setImageResource(Chat.neck[_neck]);
            cpu_head.setImageResource(Chat.head[_head]);
            cpu_horn.setImageResource(Chat.horn[_horn]);
            cpu_face.setImageResource(Chat.face[_face]);
        } else if (name_cpu.equals("コクワ")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 2)
                _neck = 2;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing2[_wing - 1]);
            body_cpu.setImageResource(Chat.body2[_body]);
            neck_cpu.setImageResource(Chat.neck2[_neck]);
            head_cpu.setImageResource(Chat.head2[_head]);
            horn_cpu.setImageResource(Chat.horn2[_horn]);
            face_cpu.setImageResource(Chat.face2[_face]);

            cpu_neck.setImageResource(Chat.neck2[_neck]);
            cpu_head.setImageResource(Chat.head2[_head]);
            cpu_horn.setImageResource(Chat.horn2[_horn]);
            cpu_face.setImageResource(Chat.face2[_face]);
        } else if (name_cpu.equals("コーカサス")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 4)
                _neck = 4;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing3[_wing - 1]);
            body_cpu.setImageResource(Chat.body3[_body]);
            neck_cpu.setImageResource(Chat.neck3[_neck]);
            horn_cpu.setImageResource(Chat.horn3[_horn]);
            head_cpu.setImageResource(Chat.head3[_head]);
            horn2_cpu.setImageResource(Chat.horn33[_horn2]);
            face_cpu.setImageResource(Chat.face3[_face]);

            cpu_neck.setImageResource(Chat.neck3[_neck]);
            cpu_horn.setImageResource(Chat.horn3[_horn]);
            cpu_head.setImageResource(Chat.head3[_head]);
            cpu_horn2.setImageResource(Chat.horn33[_horn2]);
            cpu_face.setImageResource(Chat.face3[_face]);
        } else if (name_cpu.equals("オオクワ")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 2)
                _neck = 2;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing4[_wing - 1]);
            body_cpu.setImageResource(Chat.body4[_body]);
            neck_cpu.setImageResource(Chat.neck4[_neck]);
            head_cpu.setImageResource(Chat.head4[_head]);
            horn_cpu.setImageResource(Chat.horn4[_horn]);
            face_cpu.setImageResource(Chat.face4[_face]);

            cpu_neck.setImageResource(Chat.neck4[_neck]);
            cpu_head.setImageResource(Chat.head4[_head]);
            cpu_horn.setImageResource(Chat.horn4[_horn]);
            cpu_face.setImageResource(Chat.face4[_face]);
        } else if (name_cpu.equals("サタン")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 3)
                _neck = 3;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing5[_wing - 1]);
            body_cpu.setImageResource(Chat.body5[_body]);
            neck_cpu.setImageResource(Chat.neck5[_neck]);
            horn_cpu.setImageResource(Chat.horn5[_horn]);
            head_cpu.setImageResource(Chat.head5[_head]);
            horn2_cpu.setImageResource(Chat.horn55[_horn2]);
            face_cpu.setImageResource(Chat.face5[_face]);

            cpu_neck.setImageResource(Chat.neck5[_neck]);
            cpu_horn.setImageResource(Chat.horn5[_horn]);
            cpu_head.setImageResource(Chat.head5[_head]);
            cpu_horn2.setImageResource(Chat.horn55[_horn2]);
            cpu_face.setImageResource(Chat.face5[_face]);
        } else if (name_cpu.equals("ギラファ")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 2)
                _neck = 2;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing6[_wing - 1]);
            body_cpu.setImageResource(Chat.body6[_body]);
            neck_cpu.setImageResource(Chat.neck6[_neck]);
            horn_cpu.setImageResource(Chat.horn6[_horn]);
            head_cpu.setImageResource(Chat.head6[_head]);
            face_cpu.setImageResource(Chat.face6[_face]);

            cpu_neck.setImageResource(Chat.neck6[_neck]);
            cpu_horn.setImageResource(Chat.horn6[_horn]);
            cpu_head.setImageResource(Chat.head6[_head]);
            cpu_face.setImageResource(Chat.face6[_face]);
        } else if (name_cpu.equals("オニクワ")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 2)
                _neck = 2;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing7[_wing - 1]);
            body_cpu.setImageResource(Chat.body7[_body]);
            neck_cpu.setImageResource(Chat.neck7[_neck]);
            horn_cpu.setImageResource(Chat.horn7[_horn]);
            head_cpu.setImageResource(Chat.head7[_head]);
            face_cpu.setImageResource(Chat.face7[_face]);

            cpu_neck.setImageResource(Chat.neck7[_neck]);
            cpu_horn.setImageResource(Chat.horn7[_horn]);
            cpu_head.setImageResource(Chat.head7[_head]);
            cpu_face.setImageResource(Chat.face7[_face]);
        } else if (name_cpu.equals("ヘラクレス")) {
            if (_wing > 4)
                _wing = 4;
            if (_neck > 3)
                _neck = 3;
            if (_face > 5)
                _face = 5;
            if (_wing > 0)
                wing_cpu.setImageResource(Chat.wing8[_wing - 1]);
            body_cpu.setImageResource(Chat.body8[_body]);
            neck_cpu.setImageResource(Chat.neck8[_neck]);
            horn_cpu.setImageResource(Chat.horn8[_horn]);
            head_cpu.setImageResource(Chat.head8[_head]);
            horn2_cpu.setImageResource(Chat.horn88[_horn2]);
            face_cpu.setImageResource(Chat.face8[_face]);

            cpu_neck.setImageResource(Chat.neck8[_neck]);
            cpu_horn.setImageResource(Chat.horn8[_horn]);
            cpu_head.setImageResource(Chat.head8[_head]);
            cpu_horn2.setImageResource(Chat.horn88[_horn2]);
            cpu_face.setImageResource(Chat.face8[_face]);
        }
    }

    public void setImageforPlayer() {
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing[wingNosale - 1]);
            body.setImageResource(Chat.body[bodyNosale]);
            neck.setImageResource(Chat.neck[neckNosale]);
            head.setImageResource(Chat.head[headNosale]);
            horn.setImageResource(Chat.horn[hornNosale]);

            pl_neck.setImageResource(Chat.neck[neckNosale]);
            pl_head.setImageResource(Chat.head[headNosale]);
            pl_horn.setImageResource(Chat.horn[hornNosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0000_10);
                pl_face.setImageResource(R.drawable.face_0000_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face[faceNosale]);
                pl_face.setImageResource(Chat.face[faceNosale]);
            }
        } else if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing2[wingNosale - 1]);
            body.setImageResource(Chat.body2[bodyNosale]);
            neck.setImageResource(Chat.neck2[neckNosale]);
            head.setImageResource(Chat.head2[headNosale]);
            horn.setImageResource(Chat.horn2[hornNosale]);

            pl_neck.setImageResource(Chat.neck2[neckNosale]);
            pl_head.setImageResource(Chat.head2[headNosale]);
            pl_horn.setImageResource(Chat.horn2[hornNosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0100_10);
                pl_face.setImageResource(R.drawable.face_0100_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face2[faceNosale]);
                pl_face.setImageResource(Chat.face2[faceNosale]);
            }
        } else if (loaisale.equals("loai3")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 4)
                neckNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing3[wingNosale - 1]);
            body.setImageResource(Chat.body3[bodyNosale]);
            neck.setImageResource(Chat.neck3[neckNosale]);
            horn.setImageResource(Chat.horn3[hornNosale]);
            head.setImageResource(Chat.head3[headNosale]);
            horn2.setImageResource(Chat.horn33[horn2Nosale]);

            pl_neck.setImageResource(Chat.neck3[neckNosale]);
            pl_horn.setImageResource(Chat.horn3[hornNosale]);
            pl_head.setImageResource(Chat.head3[headNosale]);
            pl_horn2.setImageResource(Chat.horn33[horn2Nosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0001_10);
                pl_face.setImageResource(R.drawable.face_0001_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face3[faceNosale]);
                pl_face.setImageResource(Chat.face3[faceNosale]);
            }
        } else if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing4[wingNosale - 1]);
            body.setImageResource(Chat.body4[bodyNosale]);
            neck.setImageResource(Chat.neck4[neckNosale]);
            head.setImageResource(Chat.head4[headNosale]);
            horn.setImageResource(Chat.horn4[hornNosale]);

            pl_neck.setImageResource(Chat.neck4[neckNosale]);
            pl_head.setImageResource(Chat.head4[headNosale]);
            pl_horn.setImageResource(Chat.horn4[hornNosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0101_10);
                pl_face.setImageResource(R.drawable.face_0101_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face4[faceNosale]);
                pl_face.setImageResource(Chat.face4[faceNosale]);
            }
        } else if (loaisale.equals("loai5")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing5[wingNosale - 1]);
            body.setImageResource(Chat.body5[bodyNosale]);
            neck.setImageResource(Chat.neck5[neckNosale]);
            horn.setImageResource(Chat.horn5[hornNosale]);
            head.setImageResource(Chat.head5[headNosale]);
            horn2.setImageResource(Chat.horn55[horn2Nosale]);

            pl_neck.setImageResource(Chat.neck5[neckNosale]);
            pl_horn.setImageResource(Chat.horn5[hornNosale]);
            pl_head.setImageResource(Chat.head5[headNosale]);
            pl_horn2.setImageResource(Chat.horn55[horn2Nosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0002_10);
                pl_face.setImageResource(R.drawable.face_0002_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face5[faceNosale]);
                pl_face.setImageResource(Chat.face5[faceNosale]);
            }
        } else if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing6[wingNosale - 1]);
            body.setImageResource(Chat.body6[bodyNosale]);
            neck.setImageResource(Chat.neck6[neckNosale]);
            horn.setImageResource(Chat.horn6[hornNosale]);
            head.setImageResource(Chat.head6[headNosale]);

            pl_neck.setImageResource(Chat.neck6[neckNosale]);
            pl_horn.setImageResource(Chat.horn6[hornNosale]);
            pl_head.setImageResource(Chat.head6[headNosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0102_10);
                pl_face.setImageResource(R.drawable.face_0102_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face6[faceNosale]);
                pl_face.setImageResource(Chat.face6[faceNosale]);
            }
        } else if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing7[wingNosale - 1]);
            body.setImageResource(Chat.body7[bodyNosale]);
            neck.setImageResource(Chat.neck7[neckNosale]);
            horn.setImageResource(Chat.horn7[hornNosale]);
            head.setImageResource(Chat.head7[headNosale]);

            pl_neck.setImageResource(Chat.neck7[neckNosale]);
            pl_horn.setImageResource(Chat.horn7[hornNosale]);
            pl_head.setImageResource(Chat.head7[headNosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0103_10);
                pl_face.setImageResource(R.drawable.face_0103_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face7[faceNosale]);
                pl_face.setImageResource(Chat.face7[faceNosale]);
            }
        } else if (loaisale.equals("loai8")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            if (wingNosale > 0)
                wing.setImageResource(Chat.wing8[wingNosale - 1]);
            body.setImageResource(Chat.body8[bodyNosale]);
            neck.setImageResource(Chat.neck8[neckNosale]);
            horn.setImageResource(Chat.horn8[hornNosale]);
            head.setImageResource(Chat.head8[headNosale]);
            horn2.setImageResource(Chat.horn88[horn2Nosale]);

            pl_neck.setImageResource(Chat.neck8[neckNosale]);
            pl_horn.setImageResource(Chat.horn8[hornNosale]);
            pl_head.setImageResource(Chat.head8[headNosale]);
            pl_horn2.setImageResource(Chat.horn88[horn2Nosale]);
            if (matsale == 1) {
                face.setImageResource(R.drawable.face_0003_10);
                pl_face.setImageResource(R.drawable.face_0003_10);
            } else if (matsale == 0) {
                face.setImageResource(Chat.face8[faceNosale]);
                pl_face.setImageResource(Chat.face8[faceNosale]);
            }
        }
    }

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
        idpetsell = intent.getIntExtra("idpetsell", 0);
        _level = intent.getIntExtra("_level", 0);

        _head = intent.getIntExtra("arr_head", 0);
        _horn = intent.getIntExtra("arr_horn", 0);
        _horn2 = intent.getIntExtra("arr_horn2", 0);
        _face = intent.getIntExtra("arr_face", 0);
        _body = intent.getIntExtra("arr_body", 0);
        _wing = intent.getIntExtra("arr_wing", 0);
        _neck = intent.getIntExtra("arr_neck", 0);
        inKind = intent.getIntExtra("inKind", 0);
        cpu_kind = intent.getIntExtra("cpu_kind", 0);
        lv = intent.getIntExtra("lv", 0);
        name_cpu = intent.getStringExtra("name_cpu");
        imagoDropPartsIndex = intent.getIntExtra("part_index", 0);
        s_hp = intent.getIntExtra("arr_s_hp", 0);
        s_hp_temp = s_hp;
        s_at = intent.getIntExtra("arr_s_at", 0);
        s_criat = intent.getIntExtra("arr_s_criat", 0);
        s_de = intent.getIntExtra("arr_s_de", 0);
        s_cri = intent.getIntExtra("arr_s_cri", 0);
        s_avoid = intent.getIntExtra("arr_s_avoid", 0);
        s_luc = intent.getIntExtra("arr_s_luc", 0);
        s_spe = intent.getIntExtra("arr_s_spe", 0);
        if (s_spe < 0)
            s_spe *= -1;
//        pl_hp = intent.getIntExtra("pl_hp", 0);
//        pl_hp_temp = pl_hp;
        pl_hp_temp = mypage.pl_hp;
        pl_at = intent.getIntExtra("pl_at", 0);
        pl_criat = intent.getIntExtra("pl_criat", 0);
        pl_de = intent.getIntExtra("pl_de", 0);
        pl_cri = intent.getIntExtra("pl_cri", 0);
        pl_avoid = intent.getIntExtra("pl_avoid", 0);
        pl_luc = intent.getIntExtra("pl_luc", 0);
        pl_spe = intent.getIntExtra("pl_spe", 0);
        if (pl_spe < 0)
            pl_spe *= -1;
//        Log.e("param", "" + mypage._hp + "-" + pl_at + "-" + pl_criat + "-" + pl_de + "-" + pl_cri + "-" + pl_avoid + "-" + pl_luc + "-" + pl_spe);

//        Log.e("pl_hp", "" + pl_hp);
//        Log.e("s_at", "" + pl_at);
//        Log.e("s_criat", "" + pl_criat);
//        Log.e("s_de", "" + pl_de);
//        Log.e("s_cri", "" + pl_cri);
//        Log.e("s_avoid", "" + pl_avoid);
//        Log.e("s_luc", "" + pl_luc);
//        Log.e("s_spe", "" + pl_spe);
    }

    @Override
    protected void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    int _exp;

    @Override
    protected void onResume() {
        super.onResume();
        bsound = false;
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        _exp = pre.getInt("exp", 0);
        if (mAdView != null) {
            mAdView.resume();
        }
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
        for (int i = 0; i < confetti.getChildCount(); i++) {
            View view = confetti.getChildAt(i);
            view.clearAnimation();
        }
        confetti.removeAllViews();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("exp", _exp);
        editor.putInt("joinbattle", 1);
        editor.putInt("fightsum", 1);
        editor.commit();
        handler.removeCallbacks(_jump_cheer);
        if (lan1 == 1)
            handler.removeCallbacks(roulette_attack);
        bsound = true;
        if (mAdView != null) {
            mAdView.pause();
        }
        try {
            if (Battle.soundbg.isPlaying()) {
                Battle.soundbg.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void _createCheering() {
        Intent intent = getIntent();
        int _pos = intent.getIntExtra("lv2", 0);
        list_name = intent.getStringArrayListExtra("list_name");
        CPUhead = intent.getIntegerArrayListExtra("head_cpu");
        CPUhorn = intent.getIntegerArrayListExtra("horn_cpu");
        CPUhorn2 = intent.getIntegerArrayListExtra("horn2_cpu");
        CPUwing = intent.getIntegerArrayListExtra("wing_cpu");
        CPUbody = intent.getIntegerArrayListExtra("body_cpu");
        CPUface = intent.getIntegerArrayListExtra("face_cpu");
        CPUneck = intent.getIntegerArrayListExtra("neck_cpu");

        CPUhead.remove(_pos);
        CPUhorn.remove(_pos);
        CPUhorn2.remove(_pos);
        CPUwing.remove(_pos);
        CPUbody.remove(_pos);
        CPUneck.remove(_pos);
        CPUface.remove(_pos);
        list_name.remove(_pos);

        for (int i = 0; i < 7; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            FrameLayout linearLayout = new FrameLayout(this);
            linearLayout.setLayoutParams(params);
            FrameLayout.LayoutParams paramsIMG = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            ImageView head = new ImageView(this);
            ImageView horn = new ImageView(this);
            ImageView horn2 = new ImageView(this);
            ImageView neck = new ImageView(this);
            ImageView face = new ImageView(this);
            ImageView wing = new ImageView(this);
            ImageView body = new ImageView(this);
            head.setAdjustViewBounds(true);
            horn2.setAdjustViewBounds(true);
            horn.setAdjustViewBounds(true);
            wing.setAdjustViewBounds(true);
            body.setAdjustViewBounds(true);
            neck.setAdjustViewBounds(true);
            face.setAdjustViewBounds(true);
            head.setLayoutParams(paramsIMG);
            horn.setLayoutParams(paramsIMG);
            horn2.setLayoutParams(paramsIMG);
            wing.setLayoutParams(paramsIMG);
            body.setLayoutParams(paramsIMG);
            neck.setLayoutParams(paramsIMG);
            face.setLayoutParams(paramsIMG);

            int value_wing = CPUwing.get(i);
            int value_face = CPUface.get(i);
            int value_neck = CPUneck.get(i);
            int value_horn = CPUhorn.get(i);
            int value_horn2 = CPUhorn2.get(i);
            int value_body = CPUbody.get(i);
            int value_head = CPUhead.get(i);
            String name = list_name.get(i);

            if (name.equals("カブトムシ")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_face > 5)
                    value_face = 5;
                if (value_neck > 3)
                    value_neck = 3;
                wing.setImageResource(Chat.wing[value_wing]);
                body.setImageResource(Chat.body[value_body]);
                neck.setImageResource(Chat.neck[value_neck]);
                head.setImageResource(Chat.head[value_head]);
                horn.setImageResource(Chat.horn[value_horn]);
                face.setImageResource(Chat.face[value_face]);
            } else if (name.equals("コクワ")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 2)
                    value_neck = 2;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing2[value_wing]);
                body.setImageResource(Chat.body2[value_body]);
                neck.setImageResource(Chat.neck2[value_neck]);
                head.setImageResource(Chat.head2[value_head]);
                horn.setImageResource(Chat.horn2[value_horn]);
                face.setImageResource(Chat.face2[value_face]);
            } else if (name.equals("コーカサス")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 4)
                    value_neck = 4;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing3[value_wing]);
                body.setImageResource(Chat.body3[value_body]);
                body.setImageResource(Chat.body3[value_body]);
                neck.setImageResource(Chat.neck3[value_neck]);
                horn.setImageResource(Chat.horn3[value_horn]);
                head.setImageResource(Chat.head3[value_head]);
                horn2.setImageResource(Chat.horn33[value_horn2]);
                face.setImageResource(Chat.face3[value_face]);
            } else if (name.equals("オオクワ")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 2)
                    value_neck = 2;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing4[value_wing]);
                body.setImageResource(Chat.body4[value_body]);
                neck.setImageResource(Chat.neck4[value_neck]);
                head.setImageResource(Chat.head4[value_head]);
                horn.setImageResource(Chat.horn4[value_horn]);
                face.setImageResource(Chat.face4[value_face]);
            } else if (name.equals("サタン")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 3)
                    value_neck = 3;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing5[value_wing]);
                body.setImageResource(Chat.body5[value_body]);
                neck.setImageResource(Chat.neck5[value_neck]);
                horn.setImageResource(Chat.horn5[value_horn]);
                head.setImageResource(Chat.head5[value_head]);
                horn2.setImageResource(Chat.horn55[value_horn2]);
                face.setImageResource(Chat.face5[value_face]);
            } else if (name.equals("ギラファ")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 2)
                    value_neck = 2;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing6[value_wing]);
                body.setImageResource(Chat.body6[value_body]);
                neck.setImageResource(Chat.neck6[value_neck]);
                horn.setImageResource(Chat.horn6[value_horn]);
                head.setImageResource(Chat.head6[value_head]);
                face.setImageResource(Chat.face6[value_face]);
            } else if (name.equals("オニクワ")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 2)
                    value_neck = 2;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing7[value_wing]);
                body.setImageResource(Chat.body7[value_body]);
                neck.setImageResource(Chat.neck7[value_neck]);
                horn.setImageResource(Chat.horn7[value_horn]);
                head.setImageResource(Chat.head7[value_head]);
                face.setImageResource(Chat.face7[value_face]);
            } else if (name.equals("ヘラクレス")) {
                if (value_wing > 3)
                    value_wing = 3;
                if (value_neck > 3)
                    value_neck = 3;
                if (value_face > 5)
                    value_face = 5;
                wing.setImageResource(Chat.wing8[value_wing]);
                body.setImageResource(Chat.body8[value_body]);
                neck.setImageResource(Chat.neck8[value_neck]);
                horn.setImageResource(Chat.horn8[value_horn]);
                head.setImageResource(Chat.head8[value_head]);
                horn2.setImageResource(Chat.horn88[value_horn2]);
                face.setImageResource(Chat.face8[value_face]);
            }
            if (i == 0) {
                cheer1.addView(wing);
                cheer1.addView(horn2);
                cheer1.addView(head);
                cheer1.addView(body);
                cheer1.addView(neck);
                cheer1.addView(face);
                cheer1.addView(horn);
            } else if (i == 1) {
                cheer2.addView(wing);
                cheer2.addView(horn2);
                cheer2.addView(head);
                cheer2.addView(body);
                cheer2.addView(neck);
                cheer2.addView(face);
                cheer2.addView(horn);
            } else if (i == 2) {
                cheer3.addView(wing);
                cheer3.addView(horn2);
                cheer3.addView(head);
                cheer3.addView(body);
                cheer3.addView(neck);
                cheer3.addView(face);
                cheer3.addView(horn);
            } else if (i == 3) {
                cheer4.addView(wing);
                cheer4.addView(horn2);
                cheer4.addView(head);
                cheer4.addView(body);
                cheer4.addView(neck);
                cheer4.addView(face);
                cheer4.addView(horn);
            } else if (i == 4) {
                cheer5.addView(wing);
                cheer5.addView(horn2);
                cheer5.addView(head);
                cheer5.addView(body);
                cheer5.addView(neck);
                cheer5.addView(face);
                cheer5.addView(horn);
            } else if (i == 5) {
                cheer6.addView(wing);
                cheer6.addView(horn2);
                cheer6.addView(head);
                cheer6.addView(body);
                cheer6.addView(neck);
                cheer6.addView(face);
                cheer6.addView(horn);
            } else if (i == 6) {
                cheer7.addView(wing);
                cheer7.addView(horn2);
                cheer7.addView(head);
                cheer7.addView(body);
                cheer7.addView(neck);
                cheer7.addView(face);
                cheer7.addView(horn);
            }
            if (mypage._Width >= 1080) {

            }
        }
    }

    ImageView img = null;

    public void _animCheer() {
        handler.postDelayed(_jump_cheer, 1000);
    }

    public int calcNormalAttackByAttacker(int species, int lv, int _attack, int lucky, int imagoHornRank, int imagoHorn2Rank,
                                          int imagoHeadRank, int imagoFaceRank, int imagoNeckRank, int imagoBodyRank, int imagoWingRank,
                                          int inDefenderObj_defense, int inDefenderObj_lucky, double inRouletteRatio) {
        //通常攻撃 ((Lv(A) + 1) / 2 + (装備しているパーツのランクの合計値)) * (こうげき(A) + ラッキー(A)/2 *乱数 - (ぼうぎょ(D) / 2 * 乱数)) / (ぼうぎょ(D) + ラッキー(D) * 乱数)
        //攻撃側
        double level = lv;
        double attack = _attack;
        double luckyAttacker = lucky;

        double totalPartsRank = 0;
        if (imagoHornRank >= 0)
            totalPartsRank += imagoHornRank;
        if (species == 1 || species == 2 || species == 3) {
            if (imagoHorn2Rank >= 0)
                totalPartsRank += imagoHorn2Rank;
        }
        if (imagoHeadRank >= 0)
            totalPartsRank += imagoHeadRank;
        if (imagoFaceRank >= 0)
            totalPartsRank += imagoFaceRank;
        if (imagoNeckRank >= 0)
            totalPartsRank += imagoNeckRank;
        if (imagoBodyRank >= 0)
            totalPartsRank += imagoBodyRank;
        if (imagoWingRank >= 0)
            totalPartsRank += imagoWingRank;

        //防御側
        double defense = inDefenderObj_defense;
        double luckyDefender = inDefenderObj_lucky;

        // ---- ダメージ計算
        //((Lv(A) + 1) / 2 + (装備しているパーツのランクの合計値))
        double param1 = ((level + 1.0) / 2.0 + totalPartsRank);

        //(こうげき(A) + ラッキー(A)/2 *乱数 - (ぼうぎょ(D) / 2 * 乱数))
        double param2 = (attack + (luckyAttacker / 2.0) * floatingRandomValue()
                - (defense / 2 * floatingRandomValue()));

        //(ぼうぎょ(D) + ラッキー(D) * 乱数)
        double param3 = (defense + luckyDefender * floatingRandomValue());

        //ルーレットで選択された番号に従った係数
        double rouletteRatio = inRouletteRatio;
        int damage = (int) Math.round((param1 * param2 / param3) * rouletteRatio);
        if (damage < 1)
            return (1);
        return damage;
    }

    public int calcCriticalAttack(int inAttackerObj_attackCritical, int inAttackerObj_lucky, int inDefenderObj_defense,
                                  int inDefenderObj_lucky, double inRouletteRatio) {
        //クリティカル攻撃 攻撃(クリティカル)(A) + ラッキー(A )/2 * 乱数) - (ラッキー(D)/2 + ぼうぎょ(D)) * 乱数)

        //攻撃側
        double attacker = inAttackerObj_attackCritical;
        double luckyAttacker = inAttackerObj_lucky;

        //防御側
        double defense = inDefenderObj_defense;
        double luckyDefender = inDefenderObj_lucky;

        // ---- ダメージ計算
        //攻撃(クリティカル)(A)
        double param1 = attacker;

        //ラッキー(A )/2 * 乱数)
        double param2 = luckyAttacker / 2.0 * floatingRandomValue();

        //(ラッキー(D)/2 + ぼうぎょ(D)) * 乱数)
        double param3 = (luckyDefender / 2 + defense) * floatingRandomValue();

        //ルーレットで選択された番号に従った係数
        double rouletteRatio = inRouletteRatio;
        int damage = (int) Math.round((param1 + param2 - param3) * rouletteRatio);

        if (damage < 2)
            return (2);
        return (damage);
    }

    public boolean invokeCritical(int inCriticalValue) {
        int criticalValue = (int) Math.round(5.0 + 3.0 * ((double) inCriticalValue / 100.0));
        int rndValue = (int) Math.round(floatingRandomValue() * 100.0);

        if (criticalValue > rndValue)
            return true;
        return false;
    }

    public boolean isAvoidSuccess(int inAvoidValue) {
        int avoidValue = (int) Math.round(10.0 + 5.0 * ((double) inAvoidValue / 100.0));
        int rndValue = (int) Math.round(floatingRandomValue() * 100.0);
        if (avoidValue > rndValue)
            return true;
        return false;
    }

    public float floatingRandomValue() {
        float a = 0;
        int b = new Random().nextInt(11);
        a = (float) (b * 0.1);
        return a;
    }

    double pl_store = 0, cpu_store = 0, minusHp;
    boolean inWon = false;
    boolean dropped = false;
    int coin, round_count = 0, inRouletteNumber;

    public void updateStore() {
        double _pl = Math.round((Math.log(pl_spe + (int) (pl_luc * floatingRandomValue()) / Math.log(2))) * 1000.0) / 1000.0;
        if (_pl < 0)
            _pl = 0;
        double _cpu = Math.round((Math.log(s_spe + (int) (s_luc * floatingRandomValue()) / Math.log(2))) * 1000.0) / 1000.0;
        if (_cpu < 0)
            _cpu = 0;
        pl_store += _pl;
        cpu_store += _cpu;
//        Log.e("TAG", "pl_store:" + pl_store + "   cpu_store:" + cpu_store);
//        int inRouletteNumber = new Random().nextInt(8) + 1;
        double rouletteRatio = rouletteNumberToDamageRatio(inRouletteNumber);
        if (pl_store > 10 && pl_store > cpu_store) {
            if (isAvoidSuccess(s_avoid)) {
//                Log.e("CPU", "CPU avoid success");
                int point = new Random().nextInt(20) + 20;
                frplayer.setRotation(point);
                frcpu.setRotation(point);
            } else if (!isAvoidSuccess(s_avoid)) {
                handler.removeCallbacks(roulette_attack);
//                Log.e("TAG", "inRouletteNumber:" + inRouletteNumber);
                frplayer.startAnimation(trans_battle3);
                frcpu.startAnimation(trans_battle2);
                int point = new Random().nextInt(20) + 20;
                frplayer.setRotation(point + 20);
                frcpu.setRotation(point - 10);
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                if (pre.getBoolean("soundaction", true) && bsound == false)
                    playerAttack.start();
                round_count += inRouletteNumber;
//                Toast.makeText(getApplicationContext(), "round_count:" + round_count, Toast.LENGTH_SHORT).show();
                pr_bg_btl_base.setProgress(round_count);
                if (invokeCritical(pl_cri)) {
                    minusHp = calcCriticalAttack(pl_criat, pl_luc, s_de, s_luc, rouletteRatio);
                } else if (!invokeCritical(pl_cri)) {
                    minusHp = calcNormalAttackByAttacker(inKind, _level, pl_at, pl_luc, hornNosale, horn2Nosale,
                            headNosale, faceNosale, neckNosale, bodyNosale, wingNosale, s_de, s_luc, rouletteRatio);
                }
                s_hp -= minusHp;
                if (s_hp <= 0)
                    s_hp = 0;
                hpcpu.setText("" + s_hp + "/" + s_hp_temp);
                int _remaining = s_hp_temp - s_hp;
                battle_life_cpu.setProgress(_remaining);
                if (s_hp <= 0) {
                    frcpu.setVisibility(View.GONE);
                    frplayer.setRotation(0);
                    if (lan1 == 0) {
                        frplayer.setRotation(0);
                        lan1 = 1;
                        s_hp = 0;
                        flaganim.set(false);
                        _Confetti();
                        ready_battle = false;
                        if (Battle.inLevelRegion == 0) {
                            if (Battle._click == Battle.cur_CPU) {
                                int next = Battle._click + 1;
                                editor.putInt("cur_CPU", next);
                                if (Battle._click == 7)
                                    editor.putInt("normal_cpu", 1);
                                editor.commit();
                            }
                        } else if (Battle.inLevelRegion == 1) {
                            if (Battle._click == Battle.cur_CPU2) {
                                int next = Battle._click + 1;
                                editor.putInt("cur_CPU2", next);
                                if (Battle._click == 15)
                                    editor.putInt("hard_cpu", 1);
                                editor.commit();
                            }
                        } else if (Battle.inLevelRegion == 2) {
                            if (Battle._click == Battle.cur_CPU3) {
                                int next = Battle._click + 1;
                                editor.putInt("cur_CPU3", next);
//                            if (Battle._click == 23) // future
//                                editor.putInt("king_cpu", 1);
                                editor.commit();
                            }
                        }

                        if (pre.getBoolean("soundaction", true) && bsound == false)
                            kSEBattleEnd.start();
                        battle_word1.setVisibility(View.GONE);
                        battle_word2.setVisibility(View.GONE);
                        textcoin.setText("   コイン ");
                        txtexp.setText("経験値 ");
                        txtget.setText("   Get");
                        int _ran = new Random().nextInt(Chat.massagesWin.length);
                        txtwin.setText("" + Chat.massagesWin[_ran]);
                        int dropPartsRank = partsRankAtPartsIndex(imagoDropPartsIndex);
                        dropped = Chat.decideWhetherPartsDrop(lv, dropPartsRank);
                        coin = battleCoin();
                        adcoin.setText("" + coin);
                        int _coin = pre.getInt("money", 0) + coin;
                        editor.putInt("money", _coin);
                        editor.putInt("win", 1);
                        editor.commit();
                        if (dropped) {
                            txtwin.setVisibility(View.GONE);
                            int itemId = itemIdOfSubKind(cpu_kind, imagoDropPartsIndex, dropPartsRank);
                            for (int i = 1; i < mypage.itemId.size(); i++) {
                                if (Integer.parseInt(mypage.itemId.get(i)) == itemId) {
                                    txtgetpart.setText("" + mypage.itemDes.get(i));
                                    txtgetpart2.setText(" Get");
                                }
                            }
                            String str = "" + itemId;
                            int value = pre.getInt(str, 0) + 1;
                            db.update_Sumpart(itemId, value);
                            editor.putInt(str, value);
                            editor.commit();
                            String name = "";
                            String part = "";
                            if (str.substring(0, 3).equals("100"))
                                name = "kabutomushi";
                            else if (str.substring(0, 3).equals("101"))
                                name = "caucasus";
                            else if (str.substring(0, 3).equals("102"))
                                name = "satanas";
                            else if (str.substring(0, 3).equals("103"))
                                name = "hercules";
                            else if (str.substring(0, 3).equals("110"))
                                name = "kokuwagata";
                            else if (str.substring(0, 3).equals("111"))
                                name = "oukuwagata";
                            else if (str.substring(0, 3).equals("112"))
                                name = "giraffa";
                            else if (str.substring(0, 3).equals("113"))
                                name = "golden";
                            if (str.substring(3, 4).equals("0"))
                                part = "horn";
                            else if (str.substring(3, 4).equals("1"))
                                part = "horn2";
                            else if (str.substring(3, 4).equals("2"))
                                part = "head";
                            else if (str.substring(3, 4).equals("3"))
                                part = "face";
                            else if (str.substring(3, 4).equals("4"))
                                part = "neck";
                            else if (str.substring(3, 4).equals("5"))
                                part = "body";
                            else if (str.substring(3, 4).equals("6"))
                                part = "wing";
                            String pos = str.substring(4, 6);
                            String pImg = "" + name + part + pos;
                            int resID = getResources().getIdentifier("@drawable/" + pImg, "drawable", getPackageName());
                            partbonus.setImageResource(resID);
                            final Animation ap_out = AnimationUtils.loadAnimation(this, R.anim.alphaout);
                            final Animation ap_in = AnimationUtils.loadAnimation(this, R.anim.alphain);
                            partbonus.startAnimation(ap_out);
                            ap_out.setAnimationListener(new Animation.AnimationListener() {

                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    partbonus.startAnimation(ap_in);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            ap_in.setAnimationListener(new Animation.AnimationListener() {

                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    partbonus.startAnimation(ap_out);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                        inWon = true;
                        int exp = Chat.battleExp(cpu_kind, lv, _horn, _horn2, _head,
                                _face, _neck, _body, _wing, inWon);
                        adexp.setText("" + exp);
                        _exp += exp;
                        mypage._exp += exp;
                        if (mypage._exp > mypage.Sum_Exp) {
                            mypage._exp = mypage._exp - mypage.Sum_Exp;
                            mypage._level++;
                            txtuplv.setText("レベルアップ！！");
                        }
                        db.update_exp(idpetsell, mypage._exp);
                        db.update_level(idpetsell, mypage._level);
                        int _curHp = mypage._hp * 100 / mypage.pl_hp;
                        db.update_hp(idpetsell, _curHp);
                        mypage._fightWin += 1;
//                        Log.e("WIN", "win:" + mypage._fightWin);
                        db.update_fightwin(idpetsell, mypage._fightWin);
                        int w_msg = (int) convertDpToPixel(108);
                        int h_msg = (int) convertDpToPixel(50);
                        if (mypage._Width <= 480) {
                            w_msg = (int) convertDpToPixel(94);
                            h_msg = (int) convertDpToPixel(43);
                        }
                        FrameLayout.LayoutParams paramsmsg = new FrameLayout.LayoutParams(w_msg, h_msg);
                        paramsmsg.gravity = Gravity.CENTER;
                        if (mypage._Width <= 480) {
                            paramsmsg.setMargins(0, 0, 148, 175);
                        } else {
                            paramsmsg.setMargins(0, 0, 170, 200);
                        }
                        battle_frame.setLayoutParams(paramsmsg);
                        msgplayer.setText("" + Chat.winnerMessageForPlayer[new Random().nextInt(Chat.winnerMessageForPlayer.length)]);
                        battle_frame.setVisibility(View.VISIBLE);
                        int _w = (int) convertDpToPixel(140);
                        if (mypage._Width <= 480)
                            _w = (int) convertDpToPixel(122);
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
                        params.gravity = Gravity.CENTER;
                        params.setMargins(0, 0, 0, 90);
                        frplayer.setLayoutParams(params);
                        battle_result_win.setImageResource(R.drawable.battle_result_win);
                        battle_effect_win.setBackgroundResource(R.drawable.battle_effect_win);
                        battle_dust_bg.setVisibility(View.GONE);
                        battle_dust.setVisibility(View.GONE);
                        rootbattlevc.setEnabled(true);
                        battle_win.setVisibility(View.VISIBLE);
                        start_kSEBattleResultEnd();
                        handler.removeCallbacks(roulette_attack);
                    }
                }
            }
        }

        if (cpu_store > 10 && cpu_store > pl_store) {
            if (isAvoidSuccess(pl_avoid)) {
//                Log.e("PL", "Player avoid success");
                int point = new Random().nextInt(20) + 20;
                point = point * -1;
                frplayer.setRotation(point);
                frcpu.setRotation(point);
            } else if (!isAvoidSuccess(pl_avoid)) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                if (pre.getBoolean("soundaction", true) && bsound == false)
                    cpuAttack.start();
                frplayer.startAnimation(trans_battle2);
                frcpu.startAnimation(trans_battle2);
                int point = new Random().nextInt(20) + 20;
                point = point * -1;
                frplayer.setRotation(point + 10);
                frcpu.setRotation(point - 20);
                if (invokeCritical(s_cri)) {
                    minusHp = calcCriticalAttack(s_criat, s_luc, pl_de, pl_luc, rouletteRatio);
                } else if (!invokeCritical(s_cri)) {
                    minusHp = calcNormalAttackByAttacker(cpu_kind, lv, s_at, s_luc, _horn, _horn2,
                            _head, _face, _neck, _body, _wing, pl_de, pl_luc, rouletteRatio);
                }
                mypage._hp -= minusHp;
                if (mypage._hp <= 0)
                    mypage._hp = 0;
                hpplayer.setText("" + mypage._hp + "/" + pl_hp_temp);
                if (battle_life_img.isShown())
                    battle_life_img.setVisibility(View.GONE);
                battle_life_player.setProgress(mypage._hp);

                if (mypage._hp <= 0) {
                    frplayer.setVisibility(View.GONE);
                    frcpu.setRotation(0);
                    if (lan1 == 0) {
                        lan1 = 1;
                        flaganim.set(false);
                        ready_battle = false;
                        kSEBattleEnd.start();
                        battle_word1.setVisibility(View.GONE);
                        battle_word2.setVisibility(View.GONE);
                        txtexp.setText("経験値 ");
                        txtget.setText("   Get");
                        int _ran = new Random().nextInt(Chat.massagesLose.length);
                        txtwin.setText("" + Chat.massagesLose[_ran]);
                        inWon = false;
                        int exp = Chat.battleExp(cpu_kind, lv, _horn, _horn2, _head,
                                _face, _neck, _body, _wing, inWon);
                        adexp.setText("" + exp);
                        mypage._exp += exp;
                        if (mypage._exp > mypage.Sum_Exp) {
                            mypage._exp = mypage._exp - mypage.Sum_Exp;
                            mypage._level++;
                        }
                        db.update_exp(idpetsell, mypage._exp);
                        db.update_level(idpetsell, mypage._level);
                        db.update_hp(idpetsell, 1);
                        int w_msg = (int) convertDpToPixel(108);
                        int h_msg = (int) convertDpToPixel(50);
                        if (mypage._Width <= 480) {
                            w_msg = (int) convertDpToPixel(94);
                            h_msg = (int) convertDpToPixel(43);
                        }
                        FrameLayout.LayoutParams paramsmsg = new FrameLayout.LayoutParams(w_msg, h_msg);
                        paramsmsg.gravity = Gravity.CENTER;
                        if (mypage._Width <= 480) {
                            paramsmsg.setMargins(148, 0, 0, 175);
                        } else {
                            paramsmsg.setMargins(170, 0, 0, 200);
                        }
                        battle_frame_flip.setLayoutParams(paramsmsg);
                        msgcpu.setText("" + Chat.winnerMessageForCPU[new Random().nextInt(Chat.winnerMessageForCPU.length)]);
                        battle_frame_flip.setVisibility(View.VISIBLE);
                        int _w = (int) convertDpToPixel(140);
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(_w, FrameLayout.LayoutParams.WRAP_CONTENT);
                        params.gravity = Gravity.CENTER;
                        params.setMargins(0, 0, 0, 90);
                        frcpu.setLayoutParams(params);
                        battle_result_win.setImageResource(R.drawable.battle_result_lose);
                        battle_effect_win.setBackgroundResource(R.drawable.battle_effect_lose);
                        battle_dust_bg.setVisibility(View.GONE);
                        battle_dust.setVisibility(View.GONE);
                        rootbattlevc.setEnabled(true);
                        battle_lose.setVisibility(View.VISIBLE);
                        start_kSEBattleResultEnd();
                        handler.removeCallbacks(roulette_attack);
                    }
                }
            }
        }
        if (pl_store > 10 && pl_store > cpu_store)
            pl_store -= 10;
        if (cpu_store > 10 && cpu_store > pl_store)
            cpu_store -= 10;
    }

    public void start_kSEBattleResultEnd() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i < 2; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                Log.e("i", "i:" + i);
                                if (i == 1)
                                    if (pre.getBoolean("soundaction", true) && bsound == false) {
                                        kSEBattleResultEnd.start();
//                                        Log.e("TAG", "start");
                                    }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public double rouletteNumberToDamageRatio(int inRouletteNumber) {
        double result = 0.1;
        switch (inRouletteNumber) {
            case 1:
                result = 0.1;
                break;
            case 2:
                result = 0.2;
                break;
            case 3:
                result = 0.3;
                break;
            case 4:
                result = 0.5;
                break;
            case 5:
                result = 0.8;
                break;
            case 6:
                result = 1.0;
                break;
            case 7:
                result = 1.2;
                break;
            case 8:
                result = 1.5;
                break;
            default:
                break;
        }
        return (result);
    }

    Handler handler;
    int _bt = 0;
    Runnable _prepareBattle = new Runnable() {
        @Override
        public void run() {
            _bt++;
            if (_bt <= 13) {
                handler.postDelayed(_prepareBattle, 1000);
//                Log.e("bt", "" + _bt);
                if (_bt == 6 || _bt == 8)
                    frplayer.startAnimation(trans_battle);
                if (_bt == 7 || _bt == 9)
                    frcpu.startAnimation(trans_battle);
                if (_bt == 10)
                    battle_ready.setImageResource(R.drawable.battle_ready);
                if (_bt == 11) {
                    handler.post(roulette_attack);
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    if (pre.getBoolean("soundaction", true) && bsound == false)
                        kSEBattleStart.start();
                    battle_ready.setImageResource(R.drawable.battle_fight);
                    _battle();
                    ready_battle = true;
                    battle_skip.setVisibility(View.VISIBLE);
                    battle_word1.setVisibility(View.VISIBLE);
                    battle_word2.setVisibility(View.VISIBLE);
                }
                if (_bt == 13)
                    battle_ready.setVisibility(View.GONE);
            } else {
                handler.post(_prepareBattle);
            }
        }
    };

    AtomicBoolean flaganim = new AtomicBoolean(false);
    int _sleep = 2000;

    public void _battle() {
        flaganim.set(false);
        battle_frame.setVisibility(View.GONE);
        battle_frame_flip.setVisibility(View.GONE);
        battle_dust_bg.setVisibility(View.VISIBLE);
        battle_dust.setVisibility(View.VISIBLE);
        Thread t = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i >= 0 && flaganim.get(); i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateStore();
                                if (lan1 == 1) {
                                    frplayer.setRotation(0);
                                    frcpu.setRotation(0);
                                }
                                int r = (int) convertDpToPixel(90);
                                int a = new Random().nextInt(Dust_mg.length);
                                int b = new Random().nextInt(Dust_mg.length);
                                params_Dust1.setMargins(0, Dust_mg[a], r, 0);
                                params_Dust2.setMargins(r, Dust_mg[b], 0, 0);
                                int wt = new Random().nextInt(margin_word.length);
                                int wl = new Random().nextInt(margin_word.length);
                                int wb = new Random().nextInt(margin_word.length);
                                int wr = new Random().nextInt(margin_word.length);
                                params_word1.setMargins(margin_word[wl], margin_word[wt], r, 0);
                                params_word2.setMargins(0, 0, margin_word[wr], margin_word[wb]);
                                battle_dust2.setLayoutParams(params_Dust2);
                                battle_dust1.setLayoutParams(params_Dust1);
                                battle_word1.setLayoutParams(params_word1);
                                battle_word2.setLayoutParams(params_word2);
                            }
                        });
                        Thread.sleep(_sleep);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        flaganim.set(true);
        t.start();
    }

    public int partsRankAtPartsIndex(int inPartsIndex) {
        switch (inPartsIndex) {
            case 0:
                return _horn;
            case 1:
                return _horn2;
            case 2:
                return _head;
            case 3:
                return _face;
            case 4:
                return _neck;
            case 5:
                return _body;
            case 6:
                return _wing;
        }
        return 0;
    }

    public int itemIdOfSubKind(int inSubKind, int inPartsIndex, int inRank) {
        int itemId = Chat.kShopItemNo_Parts_Imago_Start;
        // 10000の位はカブトムシかクワガタか
        itemId += (inSubKind / 1000) * 10000;
        // 1000の位は0=カブトムシ/コクワガタ、1=コーカサス/オオクワガタ、2=サタン/ギラファ、3=ヘラクレス/オウゴンオニクワガタ
        itemId += (inSubKind % 1000) * 1000;
        // 100の位はパーツNo
        itemId += inPartsIndex * 100;
        // 10の二桁はパーツのランク
        itemId += inRank;
        return (itemId);
    }

    public int battleCoin() {
        int jewel = 0;
        int price = Chat.priceImageWithType(cpu_kind, _wing, _body, _neck, _head, _face, _horn, _horn2);
        double multi = (double) (lv + 1) / 25.0;
        double fPrice = (double) price / 99.0 * multi;
        price = (int) Math.round(fPrice * (1.0 + (jewel / 100.0)));
        return (price);
    }

    boolean flag = false;

    public void _hide() {
        btl_roulette_attack.setVisibility(View.GONE);
        btl_roulette_attack2.setVisibility(View.GONE);
        btl_roulette_attack3.setVisibility(View.GONE);
        btl_roulette_attack4.setVisibility(View.GONE);
        btl_roulette_attack5.setVisibility(View.GONE);
        btl_roulette_attack6.setVisibility(View.GONE);
        btl_roulette_attack7.setVisibility(View.GONE);
        btl_roulette_attack8.setVisibility(View.GONE);

        btl_arrow_attack.setVisibility(View.GONE);
        btl_arrow_attack2.setVisibility(View.GONE);
        btl_arrow_attack3.setVisibility(View.GONE);
        btl_arrow_attack4.setVisibility(View.GONE);
        btl_arrow_attack5.setVisibility(View.GONE);
        btl_arrow_attack6.setVisibility(View.GONE);
        btl_arrow_attack7.setVisibility(View.GONE);
        btl_arrow_attack8.setVisibility(View.GONE);
    }

    int a = 1, roulette_attack_speed = 150;
    Runnable roulette_attack = new Runnable() {
        @Override
        public void run() {
            a++;
            if (a >= 0) {
                handler.postDelayed(roulette_attack, roulette_attack_speed);
                if (a > 8)
                    a = 1;
                inRouletteNumber = a;
//                Log.e("TAG", "a:" + a);
                if (a == 1) {
                    _hide();
                    btl_roulette_attack.setVisibility(View.VISIBLE);
                    btl_arrow_attack.setVisibility(View.VISIBLE);
                }
                if (a == 2) {
                    _hide();
                    btl_roulette_attack2.setVisibility(View.VISIBLE);
                    btl_arrow_attack2.setVisibility(View.VISIBLE);
                }
                if (a == 3) {
                    _hide();
                    btl_roulette_attack3.setVisibility(View.VISIBLE);
                    btl_arrow_attack3.setVisibility(View.VISIBLE);
                }
                if (a == 4) {
                    _hide();
                    btl_roulette_attack4.setVisibility(View.VISIBLE);
                    btl_arrow_attack4.setVisibility(View.VISIBLE);
                }
                if (a == 5) {
                    _hide();
                    btl_roulette_attack5.setVisibility(View.VISIBLE);
                    btl_arrow_attack5.setVisibility(View.VISIBLE);
                }
                if (a == 6) {
                    _hide();
                    btl_roulette_attack6.setVisibility(View.VISIBLE);
                    btl_arrow_attack6.setVisibility(View.VISIBLE);
                }
                if (a == 7) {
                    _hide();
                    btl_roulette_attack7.setVisibility(View.VISIBLE);
                    btl_arrow_attack7.setVisibility(View.VISIBLE);
                }
                if (a == 8) {
                    _hide();
                    btl_roulette_attack8.setVisibility(View.VISIBLE);
                    btl_arrow_attack8.setVisibility(View.VISIBLE);
                }
            } else {
                handler.post(roulette_attack);
            }
        }
    };

    public void _Confetti() {
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = 0; i < 5; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) _createConfetti();
                                if (i == 2) _createConfetti();
                                if (i == 3) _createConfetti();
                                if (i == 4) _createConfetti();
                            }
                        });
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        th.start();
    }

    public void _createConfetti() {
        int size = (int) Chat.convertDpToPixel(10);
        for (int i = 0; i < 10; i++) {
            int a = new Random().nextInt(4);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);
            int w = mypage._Width - 100;
            int mg = new Random().nextInt(w) + 50;
            int mt = new Random().nextInt(80);
            params.setMargins(mg, -mt, 0, 0);
            final ImageView img = new ImageView(this);
            if (a == 0)
                img.setImageResource(R.drawable.confetti_green);
            else if (a == 1)
                img.setImageResource(R.drawable.confetti_pink);
            else if (a == 2)
                img.setImageResource(R.drawable.confetti_white);
            else if (a == 3)
                img.setImageResource(R.drawable.confetti_yellow);
            img.setLayoutParams(params);
            confetti.addView(img);
            img.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            AnimationSet snowMov1 = new AnimationSet(true);
            RotateAnimation rotate1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate1.setStartOffset(50);
            rotate1.setDuration(2000);
            rotate1.setRepeatCount(-1);
            snowMov1.addAnimation(rotate1);
            TranslateAnimation trans1 = new TranslateAnimation(0, new Random().nextInt(w) + 50, 0, 1000);
            trans1.setDuration(4000);
            trans1.setRepeatCount(-1);
            snowMov1.addAnimation(trans1);
            snowMov1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    img.setLayerType(View.LAYER_TYPE_NONE, null);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            img.startAnimation(snowMov1);
        }
    }

    int lan1 = 0, cheer = 0;

    public void _anim_battle_word() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 50);
        params.gravity = Gravity.CENTER | Gravity.LEFT;
        int l = new Random().nextInt(400) + 50;
        int t = new Random().nextInt(100);
        int b = new Random().nextInt(200);
        params.setMargins(l, t, 0, b);

        FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 50);
        params.gravity = Gravity.CENTER | Gravity.LEFT;
        int l2 = new Random().nextInt(400) + 50;
        int t2 = new Random().nextInt(100);
        int b2 = new Random().nextInt(200);
        params2.setMargins(l2, t2, 0, b2);

        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 50);
        params.gravity = Gravity.CENTER | Gravity.LEFT;
        int l3 = new Random().nextInt(400) + 50;
        int t3 = new Random().nextInt(100);
        int b3 = new Random().nextInt(200);
        params3.setMargins(l3, t3, 0, b3);

        battle_word3.setLayoutParams(params);
        battle_word32.setLayoutParams(params2);
        battle_word33.setLayoutParams(params3);
    }

    Runnable _jump_cheer = new Runnable() {
        @Override
        public void run() {
            cheer++;
            _anim_battle_word();
            handler.postDelayed(this, 1000);
            if (cheer > 7) {
                cheer = 0;
            }
            if (cheer == 1)
                cheer1.startAnimation(jump_cheer);
            if (cheer == 2)
                cheer2.startAnimation(jump_cheer);
            if (cheer == 3)
                cheer3.startAnimation(jump_cheer);
            if (cheer == 4)
                cheer4.startAnimation(jump_cheer);
            if (cheer == 5)
                cheer5.startAnimation(jump_cheer);
            if (cheer == 6)
                cheer6.startAnimation(jump_cheer);
            if (cheer == 7)
                cheer7.startAnimation(jump_cheer);
        }
    };

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}