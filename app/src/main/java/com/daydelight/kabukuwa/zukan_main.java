package com.daydelight.kabukuwa;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.main_intro;
import com.daydelight.kabukuwa.shop;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import com.daydelight.kabukuwa.R;


/**
 * Created by goood on 5/20/15.
 */
public class zukan_main extends Activity implements SimpleGestureFilter.SimpleGestureListener {
    ArrayList<Integer> arrpet;
    MediaPlayer soundbg;
    boolean uptime = false;
    ProgressIndicator indicator;
    long lastCleanTime = mypage.lastCleanTime, lastCleanTime2 = mypage.lastCleanTime2, lastCleanTime3 = mypage.lastCleanTime3,
            lastCleanTime4 = mypage.lastCleanTime4, lastCleanTime5 = mypage.lastCleanTime5, lastCleanTime6 = mypage.lastCleanTime6,
            lastCleanTime7 = mypage.lastCleanTime7, lastCleanTime8 = mypage.lastCleanTime8;
    long runpaStartTime = mypage.runpaStartTime,
            runpaStartTime2 = mypage.runpaStartTime2,
            runpaStartTime3 = mypage.runpaStartTime3,
            runpaStartTime4 = mypage.runpaStartTime4,
            runpaStartTime5 = mypage.runpaStartTime5,
            runpaStartTime6 = mypage.runpaStartTime6,
            runpaStartTime7 = mypage.runpaStartTime7,
            runpaStartTime8 = mypage.runpaStartTime8;
    private PublisherAdView mAdView;
    TextView khatnuoc2, t9, textView22, activeitem, txtngu, _tenzukan, txtlv, txtan,
            txtnuoc, t1, t2, t3, t20, t22, t18, txttientrien, txttruongthanh, txtsucmanh, txtbanbe,
            txtnuoc2, txtnuoc3, txtnuoc4, txtnuoc5, txtnuoc6, txtnuoc7, txtnuoc8, txtan2, txtan3, txtan4, txtan5, txtan6, txtan7, txtan8;
    int _FOOD, _FOODBIG, _FOODBIG2, _FOODBIG3, _FOODBIG4, _FOODBIG5, _FOODBIG6, _FOODBIG7, _FOODBIG8,
            _DRINK, _DRINKBIG, _ITEM, _ITEMBIG, _ITEMBIG2, _ITEMBIG3, _ITEMBIG4, _ITEMBIG5, _CLEAN;
    ImageView button24, btn19, btnBack, txtstt, imgprepopup, imgnextpopup, btnstt, btnplus, btnminus,
            bginfo, imgnext, imgpre, ribbon1, ribbon2, ribbon3, ribbon4, worm, pill, clay1, clay2, imgcloud1, imgcloud2, imgcloud3;
    LinearLayout t4, t11, layoutLevel;
    TranslateAnimation animtoi, animlui, anim_pill, anim_pilllui, anim_worm, anim_wormlui,
            anim_itm_runpa1, anim_itm_runpa1_after,
            anim_itm_runpa2, anim_itm_runpa1_after2,
            anim_itm_runpa3, anim_itm_runpa1_after3,
            anim_itm_runpa4, anim_itm_runpa1_after4,
            anim_itm_runpa5, anim_itm_runpa1_after5,
            anim_itm_runpa6, anim_itm_runpa1_after6,
            anim_itm_runpa7, anim_itm_runpa1_after7,
            anim_itm_runpa8, anim_itm_runpa1_after8;
    int xX = 450, yY = -100;
    AnimationDrawable frameAnimation, frameAnimation2, animpill, animpilllui, animworm, animwormlui, animclay, animclay2, animribbon1, animribbon2, animribbon3, animribbon4;
    Button btnicon, btnClosePopup;
    TextView btndaitien, txtmsg, textView25, t6, t7, t14, t15, t16, t17, t19, tfl1, tfl2;
    ImageView imgzukan, imgzukan2, imgzukan3, imgzukan4, imgzukan5, imgzukan6, imgzukan7,
            imgzukan8, btnfood, btndrink, btnitem, btnquetnha, btntam, imgbutterfly,
            itm_runpa1, itm_runpa2, itm_runpa3, itm_runpa4, itm_runpa5, itm_runpa6, itm_runpa7, itm_runpa8;
    FrameLayout bglayout, frcolor, lnlevel, layoutOver, layoutUnder, frimgbutterfly, frworm, frpill, frcloud,
            fritm_runpa1, fritm_runpa2, fritm_runpa3, fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8;
    Handler handler;
    RelativeLayout lnmsg;
    int _CLICK, _FLIP = 0;
    ProgressBar progressBar3, progressBar6, progressBar7,
            progressBar32, progressBar33, progressBar34, progressBar35, progressBar36, progressBar37, progressBar38;

    String _name = "", _name2 = "", _name3 = "", _name4 = "", _name5 = "", _name6 = "", _name7 = "", _name8 = "";
    int temp = mypage.temp, temp2 = mypage.temp2, temp3 = mypage.temp3, temp4 = mypage.temp4, temp5 = mypage.temp5,
            temp6 = mypage.temp6, temp7 = mypage.temp7, temp8 = mypage.temp8;
    private SimpleGestureFilter detector;
    boolean sleeping = false, sleeping2 = false, sleeping3 = false, sleeping4 = false, sleeping5 = false, sleeping6 = false,
            sleeping7 = false, sleeping8 = false;
    boolean timeUpAge = false;
    boolean UpAge2 = false;
    boolean UpAge2Nho = false;
    boolean ban = false;
    boolean buong = false, buong2 = false;
    boolean bnha = false, bsound = false;
    TranslateAnimation anim, anim2, animpet2, anim2pet2, animpet3, animpet4, animpet5, animpet6, animpet7, animpet8,
            anim2pet3, anim2pet4, anim2pet5, anim2pet6, anim2pet7, anim2pet8, animclould1, animclould2, animclould3;
    //
    int dTimeMinute = 1 * 60;
    int dTimeHour = dTimeMinute * 60;
    int dTimeDay = dTimeHour * 24;
    int kPhase_Egg = 5 * dTimeMinute;
    int kPhase_1stGrub = 24 * dTimeHour;
    int kPhase_2ndGrub = 2 * 24 * dTimeHour;
    int kPhase_3rdGrub = 3 * 24 * dTimeHour;
    int kPhase_PrePupa = 3 * dTimeHour;
    int kPhase_Pupa = 24 * dTimeHour;
    int kPhase_PreImago = 24 * dTimeHour;
    int kPhase_Imago = 365 * 24 * dTimeHour;
    boolean alive = true;
    Random random = new Random();
    int parID = 0;
    int kind, sleep;
    int kBeetleForm_Max = 1000;    // かっこよさMAX
    int kBeetleSizeMax = 10000;
    int kBeetleMood_Max = 1000;    // 機嫌MAX
    int kBeetleStrength_Max = 1000;    // 強さMAX
    int kBeetleAlbinoEstablishment = 1000;// アルビノが産まれる確立、実際には1/1000ということ
    int kBeetlePersonality_Max = 1000;    // 0→おとなしい、1000→攻撃的
    int kBeetleMoisture_Max = 1000;    // 水分MAX
    int kBeetleLife_Max = 10000;    // 生命力MAX
    int size = mypage.size, size2 = mypage.size2, size3 = mypage.size3, size4 = mypage.size4,
            size5 = mypage.size5, size6 = mypage.size6, size7 = mypage.size7, size8 = mypage.size8;    // 卵の大きさは一律30パーセント
    int persent;
    int color, albino, personality = mypage.personality, personality2 = mypage.personality2, personality3 = mypage.personality3, personality4 = mypage.personality4, personality5 = mypage.personality5,
            personality6 = mypage.personality6, personality7 = mypage.personality7, personality8 = mypage.personality8, subKind = 0;
    int moodMax = kBeetleMood_Max;
    int mood = mypage.mood, mood2 = mypage.mood2, mood3 = mypage.mood3, mood4 = mypage.mood4, mood5 = mypage.mood5,
            mood6 = mypage.mood6, mood7 = mypage.mood7, mood8 = mypage.mood8;
    int daitien = mypage.daitien, daitien2 = mypage.daitien2, daitien3 = mypage.daitien3, daitien4 = mypage.daitien4, daitien5 = mypage.daitien5,
            daitien6 = mypage.daitien6, daitien7 = mypage.daitien7, daitien8 = mypage.daitien8;
    int tieutien = mypage.tieutien, tieutien2 = mypage.tieutien2, tieutien3 = mypage.tieutien3, tieutien4 = mypage.tieutien4,
            tieutien5 = mypage.tieutien5, tieutien6 = mypage.tieutien6, tieutien7 = mypage.tieutien7, tieutien8 = mypage.tieutien8;
    boolean nowBreeding;
    int kBeetleSubKind_Caucasus;                // コーカサスカブトムシ
    int kBeetleSubKind_Satanas;                        // サタンオオカブト
    int kBeetleSubKind_Hercules;                    // ヘラクレスオオカブト
    int kBeetleSubKind_JapanDorcusRectus = 1000;    // 日本コクワガタ
    int kBeetleSubKind_JapanDorcusCurvidens = 1001;    // 日本オオクワガタ
    int kBeetleSubKind_ProsopocoilusGiraffa = 1002;    // ギラファノコギリクワガタ
    int kBeetleSubKind_AllotopusRosenbergi = 1003;    // オウゴンオニクワガタ
    int personalityMax = (int) (kBeetlePersonality_Max * parameterRatio());
    int form = mypage.form, form2 = mypage.form2, form3 = mypage.form3, form4 = mypage.form4, form5 = mypage.form5,
            form6 = mypage.form6, form7 = mypage.form7, form8 = mypage.form8,
            strength = mypage.strength, strength2 = mypage.strength2, strength3 = mypage.strength3, strength4 = mypage.strength4, strength5 = mypage.strength5,
            strength6 = mypage.strength6, strength7 = mypage.strength7, strength8 = mypage.strength8,
            life, life2, life3, life4, life5, life6, life7, life8;
    int friendly = mypage.friendly, friendly2 = mypage.friendly2, friendly3 = mypage.friendly3, friendly4 = mypage.friendly4,
            friendly5 = mypage.friendly5, friendly6 = mypage.friendly6, friendly7 = mypage.friendly7, friendly8 = mypage.friendly8;
    int formMax = (int) (kBeetleForm_Max * parameterRatio());
    int strengthMax = (int) (kBeetleStrength_Max * parameterRatio());
    double rank;
    int health = mypage.health, health2 = mypage.health2, health3 = mypage.health3, health4 = mypage.health4, health5 = mypage.health5,
            health6 = mypage.health6, health7 = mypage.health7, health8 = mypage.health8;
    int kBeetleSleepingETimeMax = 150;
    int kBeetleSleep_Max = 1000;// 眠気MAX
    int sleepmax = (int) (0.8 * kBeetleSleep_Max);
    //
    ArrayList<Contact> imageArry = new ArrayList<Contact>();
    int imgfinish = 1;
    Button btnicon2, btnicon3, btnicon4, btnicon5, btnicon6, btnicon7, btnicon8;
    MediaPlayer mPClick, mPEffect, mPDrink, mPEat, mPShower, mPCleaning, mPTouchZukan, mPTouchZukan2, mPSleep, mPDeath, mPKhatNuoc, kSEDefecation;


    public int rankpet1(float age) {
        int a = 0;
        if (age < 1)
            a = 400;
        if (age >= 1 && age < 2)
            a = 640;
        if (age >= 2)
            a = 800;
        return a;
    }

    public void _DoNha2() {
        t22.setBackgroundResource(R.drawable.trush2_fw);
        t4.setBackgroundResource(R.drawable.trush2_fw);
        t6.setBackgroundResource(R.drawable.trush2_fw);
        t7.setBackgroundResource(R.drawable.trush2_fw);
        t9.setBackgroundResource(R.drawable.trush2_fw);
        t11.setBackgroundResource(R.drawable.trush2_fw);
        t14.setBackgroundResource(R.drawable.trush2_fw);
        t15.setBackgroundResource(R.drawable.trush2_fw);
        t16.setBackgroundResource(R.drawable.trush2_fw);
        t19.setBackgroundResource(R.drawable.trush2_fw);
        tfl1.setBackgroundResource(R.drawable.trush2_fw);
        tfl2.setBackgroundResource(R.drawable.trush2_fw);
        t9.setAlpha(0.3f);
        t11.setAlpha(0.3f);
        t14.setAlpha(0.3f);
        t15.setAlpha(0.3f);
        t16.setAlpha(0.3f);
        t19.setAlpha(0.3f);
        tfl1.setAlpha(0.3f);
        tfl2.setAlpha(0.3f);
        t22.setAlpha(0.3f);
        t4.setAlpha(0.3f);
        t6.setAlpha(0.3f);
        t7.setAlpha(0.3f);
    }

    public void _DoNha() {
        t1.setBackgroundResource(R.drawable.trush2_fw);
        t2.setBackgroundResource(R.drawable.trush2_fw);
        t3.setBackgroundResource(R.drawable.trush2_fw);
        t18.setBackgroundResource(R.drawable.trush2_fw);
        t1.setAlpha(0.3f);
        t2.setAlpha(0.3f);
        t3.setAlpha(0.3f);
        t18.setAlpha(0.2f);
    }

    public void _SachNha() {
        t1.setBackgroundResource(Color.parseColor("#00000000"));
        t2.setBackgroundResource(Color.parseColor("#00000000"));
        t3.setBackgroundResource(Color.parseColor("#00000000"));
        t18.setBackgroundResource(Color.parseColor("#00000000"));
        t22.setBackgroundResource(Color.parseColor("#00000000"));
        t4.setBackgroundResource(Color.parseColor("#00000000"));
        t9.setBackgroundResource(Color.parseColor("#00000000"));
        t11.setBackgroundResource(Color.parseColor("#00000000"));
        t14.setBackgroundResource(Color.parseColor("#00000000"));
        t15.setBackgroundResource(Color.parseColor("#00000000"));
        t16.setBackgroundResource(Color.parseColor("#00000000"));
        t19.setBackgroundResource(Color.parseColor("#00000000"));
        tfl1.setBackgroundResource(Color.parseColor("#00000000"));
        tfl2.setBackgroundResource(Color.parseColor("#00000000"));
        t6.setBackgroundResource(Color.parseColor("#00000000"));
        t7.setBackgroundResource(Color.parseColor("#00000000"));
    }

    public void noikhi4tuoi() {
        ShowLnmsg(Chat.NoiKhiThanhNhong.length, Chat.NoiKhiThanhNhong);
    }

    public void ShowFinish() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (_TRUONGTHANH == 2) {
            setRank(size2, health2, mood2, form2, strength2, personality2);
            if (age2 < 1)
                button24.setImageResource(R.drawable.stag_beetle_phase01_p15_a01);
            if (age2 > 1 && age2 < 2)
                button24.setImageResource(R.drawable.stag_beetle_phase02_p15_a01);
            if (age2 > 2 && age2 < 3)
                button24.setImageResource(R.drawable.stag_beetle_phase03_p15_a01);
            if (age2 > 3 && age2 < 4)
                button24.setImageResource(R.drawable.stag_beetle_phase03_p15_a01);
            if (age2 > 4) {
                int hornNo = (int) ((float) life2 / 8000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength2 / 800 * 7);
                int wingNo = (int) ((float) friendly2 / 800 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health2 / 800 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form2 / 800 * 4);
                if (neckNo > 1)
                    neckNo = 1;
                int faceNo = (int) ((float) mood2 / 800 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality2 / 800 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead2[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing2[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody2[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck2[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn2[hornNo]);

                frdau.setBackgroundResource(Chat.head2[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing2[wingNo]);
                frbody.setBackgroundResource(Chat.body2[bodyNo]);
                frco.setBackgroundResource(Chat.neck2[neckNo]);
                frhorn.setBackgroundResource(Chat.horn2[hornNo]);
                if (pre.getInt("mat2", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0100_10);
                else if (pre.getInt("mat2", 0) == 0)
                    frmat.setBackgroundResource(Chat.face2[faceNo]);
            }
        }
        if (_TRUONGTHANH == 4) {
            setRank(size4, health4, mood4, form4, strength4, personality4);
            if (age4 < 1)
                button24.setImageResource(R.drawable.stag_beetle_phase01_p15_a01);
            if (age4 > 1 && age4 < 2)
                button24.setImageResource(R.drawable.stag_beetle_phase02_p15_a01);
            if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                button24.setImageResource(R.drawable.stag_beetle_phase03_p15_a01);
            if (age4 > 4) {
                int hornNo = (int) ((float) life4 / 20000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength4 / 2000 * 7);
                int wingNo = (int) ((float) friendly4 / 2000 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health4 / 2000 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form4 / 2000 * 4);
                if (neckNo > 1)
                    neckNo = 1;
                int faceNo = (int) ((float) mood4 / 2000 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality4 / 2000 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead4[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing4[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody4[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck4[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn4[hornNo]);

                frdau.setBackgroundResource(Chat.head4[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing4[wingNo]);
                frbody.setBackgroundResource(Chat.body4[bodyNo]);
                frco.setBackgroundResource(Chat.neck4[neckNo]);
                frhorn.setBackgroundResource(Chat.horn4[hornNo]);
                if (pre.getInt("mat4", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0101_10);
                else if (pre.getInt("mat4", 0) == 0)
                    frmat.setBackgroundResource(Chat.face4[faceNo]);
            }
        }
        if (_TRUONGTHANH == 6) {
            setRank(size6, health6, mood6, form6, strength6, personality6);
            if (age6 < 1)
                button24.setImageResource(R.drawable.stag_beetle_phase01_p15_a01);
            if (age6 > 1 && age6 < 2)
                button24.setImageResource(R.drawable.stag_beetle_phase02_p15_a01);
            if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                button24.setImageResource(R.drawable.stag_beetle_phase03_p15_a01);
            if (age6 > 4) {
                int hornNo = (int) ((float) life6 / 20000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength6 / 2000 * 7);
                int wingNo = (int) ((float) friendly6 / 2000 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health6 / 2000 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form6 / 2000 * 4);
                if (neckNo > 1)
                    neckNo = 1;
                int faceNo = (int) ((float) mood6 / 2000 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality6 / 2000 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead6[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing6[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody6[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck6[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn6[hornNo]);
                frdau.setBackgroundResource(Chat.head6[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing6[wingNo]);
                frbody.setBackgroundResource(Chat.body6[bodyNo]);
                frco.setBackgroundResource(Chat.neck6[neckNo]);
                frhorn.setBackgroundResource(Chat.horn6[hornNo]);
                if (pre.getInt("mat6", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0102_10);
                else if (pre.getInt("mat6", 0) == 0)
                    frmat.setBackgroundResource(Chat.face6[faceNo]);
            }
        }
        if (_TRUONGTHANH == 8) {
            setRank(size8, health8, mood8, form8, strength8, personality8);
            if (age8 < 1)
                button24.setImageResource(R.drawable.beetle_phase01_p15_a01);
            if (age8 > 1 && age8 < 2)
                button24.setImageResource(R.drawable.beetle_phase02_p15_a01);
            if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                button24.setImageResource(R.drawable.beetle_phase03_p15_a01);
            if (age8 > 4) {
                int hornNo = (int) ((float) life8 / 30000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength8 / 3000 * 7);
                if (horn2No > 6)
                    horn2No = 6;
                int wingNo = (int) ((float) friendly8 / 3000 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health8 / 3000 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form8 / 3000 * 4);
                if (neckNo > 2)
                    neckNo = 2;
                int faceNo = (int) ((float) mood8 / 3000 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality8 / 3000 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead8[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing8[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody8[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck8[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn8[hornNo]);
                bgfrhorn2.setBackgroundResource(Chat.bghorn88[horn2No]);
                //-------------------------------------------------------------
                frdau.setBackgroundResource(Chat.head8[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing8[wingNo]);
                frbody.setBackgroundResource(Chat.body8[bodyNo]);
                frco.setBackgroundResource(Chat.neck8[neckNo]);
                frhorn.setBackgroundResource(Chat.horn8[hornNo]);
                frhorn2.setBackgroundResource(Chat.horn88[horn2No]);
                if (pre.getInt("mat8", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0003_10);
                else if (pre.getInt("mat8", 0) == 0)
                    frmat.setBackgroundResource(Chat.face8[faceNo]);
            }
        }
        if (_TRUONGTHANH == 1) {
            setRank(size, health, mood, form, strength, personality);
            if (age < 1)
                button24.setImageResource(R.drawable.beetle_phase01_p15_a01);
            if (age > 1 && age < 2)
                button24.setImageResource(R.drawable.beetle_phase02_p15_a01);
            if ((age > 2 && age < 3) || (age > 3 && age < 4))
                button24.setImageResource(R.drawable.beetle_phase03_p15_a01);
            if (age > 4) {
                int hornNo = (int) ((float) life / 8000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength / 800 * 7);
                int wingNo = (int) ((float) friendly / 800 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health / 800 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form / 800 * 4);
                if (neckNo > 2)
                    neckNo = 2;
                int faceNo = (int) ((float) mood / 800 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality / 800 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
//                Log.e("TAG", "life:"+life+":" + hornNo + ":" + wingNo + ":" + headNo + ":" + neckNo + ":" + faceNo + ":" + bodyNo);
                bgfrdau.setBackgroundResource(Chat.bghead[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn[hornNo]);
                //-------------------------------------------------------------
                frdau.setBackgroundResource(Chat.head[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing[wingNo]);
                frbody.setBackgroundResource(Chat.body[bodyNo]);
                frco.setBackgroundResource(Chat.neck[neckNo]);
                frhorn.setBackgroundResource(Chat.horn[hornNo]);
                if (pre.getInt("mat1", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0000_10);
                else if (pre.getInt("mat1", 0) == 0)
                    frmat.setBackgroundResource(Chat.face[faceNo]);
            }
        }
        if (_TRUONGTHANH == 3) {
            setRank(size3, health3, mood3, form3, strength3, personality3);
            if (age3 < 1)
                button24.setImageResource(R.drawable.beetle_phase01_p15_a01);
            if (age3 > 1 && age3 < 2)
                button24.setImageResource(R.drawable.beetle_phase02_p15_a01);
            if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                button24.setImageResource(R.drawable.beetle_phase03_p15_a01);
            if (age3 > 4) {
                int hornNo = (int) ((float) life3 / 10000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength3 / 1000 * 7);
                if (horn2No > 6)
                    horn2No = 6;
                int wingNo = (int) ((float) friendly3 / 1000 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health3 / 1000 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form3 / 1000 * 4);
                if (neckNo > 3)
                    neckNo = 3;
                int faceNo = (int) ((float) mood3 / 1000 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality3 / 1000 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead3[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing3[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody3[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck3[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn3[hornNo]);
                bgfrhorn2.setBackgroundResource(Chat.bghorn33[horn2No]);

                frdau.setBackgroundResource(Chat.head3[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing3[wingNo]);
                frbody.setBackgroundResource(Chat.body[bodyNo]);
                frco.setBackgroundResource(Chat.neck3[neckNo]);
                frhorn.setBackgroundResource(Chat.horn3[hornNo]);
                frhorn2.setBackgroundResource(Chat.horn33[horn2No]);
                if (pre.getInt("mat3", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0001_10);
                else if (pre.getInt("mat3", 0) == 0)
                    frmat.setBackgroundResource(Chat.face3[faceNo]);
            }
        }
        if (_TRUONGTHANH == 5) {
            setRank(size5, health5, mood5, form5, strength5, personality5);
            if (age5 < 1)
                button24.setImageResource(R.drawable.beetle_phase01_p15_a01);
            if (age5 > 1 && age5 < 2)
                button24.setImageResource(R.drawable.beetle_phase02_p15_a01);
            if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                button24.setImageResource(R.drawable.beetle_phase03_p15_a01);
            if (age5 > 4) {
                int hornNo = (int) ((float) life5 / 20000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength5 / 2000 * 7);
                int wingNo = (int) ((float) friendly5 / 2000 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health5 / 2000 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form5 / 2000 * 4);
                if (neckNo > 2)
                    neckNo = 2;
                int faceNo = (int) ((float) mood5 / 2000 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality5 / 2000 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead5[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing5[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody5[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck5[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn5[hornNo]);

                frdau.setBackgroundResource(Chat.head5[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing5[wingNo]);
                frbody.setBackgroundResource(Chat.body5[bodyNo]);
                frco.setBackgroundResource(Chat.neck5[neckNo]);
                frhorn.setBackgroundResource(Chat.horn5[hornNo]);
                if (pre.getInt("mat5", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0002_10);
                else if (pre.getInt("mat5", 0) == 0)
                    frmat.setBackgroundResource(Chat.face5[faceNo]);
            }
        }
        if (_TRUONGTHANH == 7) {
            setRank(size7, health7, mood7, form7, strength7, personality7);
            if (age7 < 1)
                button24.setImageResource(R.drawable.stag_beetle_phase01_p15_a01);
            if (age7 > 1 && age7 < 2)
                button24.setImageResource(R.drawable.stag_beetle_phase02_p15_a01);
            if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                button24.setImageResource(R.drawable.stag_beetle_phase03_p15_a01);
            if (age7 > 4) {
                int hornNo = (int) ((float) life7 / 15000 * 7);
                if (hornNo > 6)
                    hornNo = 6;
                int horn2No = (int) ((float) strength7 / 1500 * 7);
                int wingNo = (int) ((float) friendly7 / 1500 * 4);
                if (wingNo > 3)
                    wingNo = 3;
                int headNo = (int) ((float) health7 / 1500 * 7);
                if (headNo > 6)
                    headNo = 6;
                int neckNo = (int) ((float) form7 / 1500 * 4);
                if (neckNo > 2)
                    neckNo = 2;
                int faceNo = (int) ((float) mood7 / 1500 * 7);
                if (faceNo > 4)
                    faceNo = 4;
                int bodyNo = (int) ((float) personality7 / 1500 * 7);
                if (bodyNo > 6)
                    bodyNo = 6;
                if (hornNo < 0) hornNo = 0;
                if (horn2No < 0) horn2No = 0;
                if (headNo < 0) headNo = 0;
                if (neckNo < 0) neckNo = 0;
                if (bodyNo < 0) bodyNo = 0;
                if (wingNo < 0) wingNo = 0;
                if (faceNo < 0) faceNo = 0;
                bgfrdau.setBackgroundResource(Chat.bghead7[headNo]);
                if (wingNo > 0)
                    bgfrcanh.setBackgroundResource(Chat.bgwing7[wingNo - 1]);
                bgfrbody.setBackgroundResource(Chat.bgbody7[bodyNo]);
                bgfrco.setBackgroundResource(Chat.bgneck7[neckNo]);
                bgfrhorn.setBackgroundResource(Chat.bghorn7[hornNo]);

                frdau.setBackgroundResource(Chat.head7[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing7[wingNo]);
                frbody.setBackgroundResource(Chat.body7[bodyNo]);
                frco.setBackgroundResource(Chat.neck7[neckNo]);
                frhorn.setBackgroundResource(Chat.horn7[hornNo]);
                if (pre.getInt("mat7", 0) == 1)
                    frmat.setBackgroundResource(R.drawable.face_0103_10);
                else if (pre.getInt("mat7", 0) == 0)
                    frmat.setBackgroundResource(Chat.face7[faceNo]);
            }
        }
    }

    public void createBeetleWithKind() {
        persent = random.nextInt(30) + 10;
        life = strength * 10;
        life2 = strength2 * 10;
        life3 = strength3 * 10;
        life4 = strength4 * 10;
        life5 = strength5 * 10;
        life6 = strength6 * 10;
        life7 = strength7 * 10;
        life8 = strength8 * 10;
        nowBreeding = true;
    }

    public float parameterRatio() {
        switch (subKind) {
            case 0:                // 日本カブトムシ
                return (float) 0.8;
            case 1000:    // 日本コクワガタ
                return (float) 0.8;
            case 1001:    // 日本オオクワガタ
                return (float) 2.0;
            case 1002:    // ギラファノコギリクワガタ
                return (float) 2.0;
            case 1003:    // オウゴンオニクワガタ
                return (float) 1.5;

            default:
                return (float) 1.0;
        }
    }

    int kBeetleRank_Max = 10;

    public double calcRank(int size, int health, int mood, int form, int strength, int personality) {
        double percent;
        percent = (double) (health + mood + form + strength + personality) / 5.0 / 10.0;
        if (size > 7000)
            percent += (size - 7000.0) / 10.0;
        int rank = (int) (percent / 10.0);
        if (rank >= kBeetleRank_Max)
            rank = kBeetleRank_Max - 1;
        if (rank < 0)
            rank = 0;
        return rank;
    }

    int prolength_action = 60;
    boolean baction = false, baction2 = false, baction3 = false, baction4 = false,
            baction5 = false, baction6 = false, baction7 = false, baction8 = false;
    Runnable runnable_action = new Runnable() {
        @Override
        public void run() {
            prolength_action--;
            baction = true;
            if (prolength_action >= 0) {
                handler.postDelayed(runnable_action, 700);
//                Log.e("TAG", "1:" + prolength_action);
                if (prolength_action == 55) {
                    _FLIP++;
                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true)) {
                        noi_nham(age);
                    }
                }
                if (prolength_action == 50 || prolength_action == 48) {
                    ac_2(age, imgzukan);
                }
                if (prolength_action == 49 || prolength_action == 47) {
                    ac_3(age, imgzukan);
                }
                if ((prolength_action > 50 && prolength_action <= 60) || (prolength_action > 38 && prolength_action < 47) || (prolength_action > 1 && prolength_action < 15)) {
                    img_normal(age, imgzukan);
                }
                if (prolength_action == 38) {
                    if (swipe == false)
                        if (_FLIP % 2 != 0)
                            imgzukan.startAnimation(anim);
                        else if (_FLIP % 2 == 0)
                            imgzukan.startAnimation(anim2);
                }
                if (prolength_action == 30 || prolength_action == 36) {
                    ac_go1(age, imgzukan, _FLIP);
                }
                if (prolength_action == 31 || prolength_action == 37) {
                    ac_go2(age, imgzukan, _FLIP);
                }
                if (prolength_action == 32 || prolength_action == 38) {
                    ac_go1(age, imgzukan, _FLIP);
                }
                if (prolength_action == 25) {
                    if (swipe == false)
                        if (_FLIP % 2 != 0)
                            imgzukan.startAnimation(anim2);
                        else if (_FLIP % 2 == 0)
                            imgzukan.startAnimation(anim);
                }
                if (prolength_action == 25 || prolength_action == 23) {
                    if (age > 0 && age < 1) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a01_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a01_l);
                    } else if (age > 1 && age < 2) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a02_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a02_bl);
                    } else if ((age > 2 && age < 3) || (age > 3 && age < 4)) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a02_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a02_bl);
                    }
                }
                if (prolength_action == 24 || prolength_action == 22) {
                    if (age > 0 && age < 1) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a02_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a02_l);
                    } else if (age > 1 && age < 2) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a03_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a03_bl);
                    } else if ((age > 2 && age < 3) || (age > 3 && age < 4)) {
                        if (_FLIP % 2 != 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a03_b);
                        else if (_FLIP % 2 == 0)
                            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a03_bl);
                    }
                }
                if (prolength_action < 22 && prolength_action > 15) {
                    if (age > 0 && age < 1)
                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01_b);
                    else if (age > 1 && age < 2)
                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01_b);
                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01_b);
                }
                if (prolength_action == 1)
                    prolength_action = 60;
            } else {
                handler.post(runnable_action);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action3 = 60;

    Runnable runnable_action3 = new Runnable() {
        @Override
        public void run() {
            prolength_action3--;
            baction3 = true;
            if (prolength_action3 >= 0) {
                handler.postDelayed(runnable_action3, 700);
                if (prolength_action3 == 55) {
                    if ((swipe3 == false && sleeping3 == false) || (swipe3 == true && sleeping3 == true)) {
                        noi_nham(age3);
                    }
                }
                if (prolength_action3 == 50) {
                    if (swipe3 == false)
                        imgzukan3.startAnimation(animpet3);
                }
                if (prolength_action3 == 50 || prolength_action3 == 48) {
                    ac_2(age3, imgzukan3);
                }
                if (prolength_action3 == 49 || prolength_action3 == 47) {
                    ac_3(age3, imgzukan3);
                }
                if ((prolength_action3 > 50 && prolength_action3 <= 60) || (prolength_action3 > 25 && prolength_action3 < 47) || (prolength_action3 > 1 && prolength_action3 < 15)) {
                    img_normal(age3, imgzukan3);
                }
                if (prolength_action3 == 25) {
                    if (swipe3 == false)
                        imgzukan3.startAnimation(anim2pet3);
                }
                if (prolength_action3 == 25 || prolength_action3 == 23) {
                    if (age3 > 0 && age3 < 1)
                        imgzukan3.setImageResource(R.drawable.beetle_phase01_p02_a01_b);
                    if (age3 > 1 && age3 < 2)
                        imgzukan3.setImageResource(R.drawable.beetle_phase02_p02_a02_b);
                    if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                        imgzukan3.setImageResource(R.drawable.beetle_phase03_p02_a02_b);
                }
                if (prolength_action3 == 24 || prolength_action3 == 22) {
                    if (age3 > 0 && age3 < 1)
                        imgzukan3.setImageResource(R.drawable.beetle_phase01_p02_a02_b);
                    if (age3 > 1 && age3 < 2)
                        imgzukan3.setImageResource(R.drawable.beetle_phase02_p02_a03_b);
                    if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                        imgzukan3.setImageResource(R.drawable.beetle_phase03_p02_a03_b);
                }
                if (prolength_action3 < 22 && prolength_action3 > 15) {
                    if (age3 > 0 && age3 < 1)
                        imgzukan3.setImageResource(R.drawable.beetle_phase01_p01_a01_b);
                    if (age3 > 1 && age3 < 2)
                        imgzukan3.setImageResource(R.drawable.beetle_phase02_p01_a01_b);
                    if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                        imgzukan3.setImageResource(R.drawable.beetle_phase03_p01_a01_b);
                }
                if (prolength_action3 == 1)
                    prolength_action3 = 60;
            } else {
                handler.post(runnable_action3);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action5 = 60;

    Runnable runnable_action5 = new Runnable() {
        @Override
        public void run() {

            prolength_action5--;
            baction5 = true;
            if (prolength_action5 >= 0) {
                handler.postDelayed(runnable_action5, 700);
                if (prolength_action5 == 55) {
                    if ((swipe5 == false && sleeping5 == false) || (swipe5 == true && sleeping5 == true)) {
                        noi_nham(age5);
                    }
                }
                if (prolength_action5 == 50) {
                    if (swipe5 == false)
                        imgzukan5.startAnimation(animpet5);
                }
                if (prolength_action5 == 50 || prolength_action5 == 48) {
                    ac_2(age5, imgzukan5);
                }
                if (prolength_action5 == 49 || prolength_action5 == 47) {
                    ac_3(age5, imgzukan5);
                }
                if ((prolength_action5 > 50 && prolength_action5 <= 60) || (prolength_action5 > 25 && prolength_action5 < 47) || (prolength_action5 > 1 && prolength_action5 < 15)) {
                    img_normal(age5, imgzukan5);
                }
                if (prolength_action5 == 25) {
                    if (swipe5 == false)
                        imgzukan5.startAnimation(anim2pet5);
                }
                if (prolength_action5 == 25 || prolength_action5 == 23) {
                    if (age5 > 0 && age5 < 1)
                        imgzukan5.setImageResource(R.drawable.beetle_phase01_p02_a01_b);
                    if (age5 > 1 && age5 < 2)
                        imgzukan5.setImageResource(R.drawable.beetle_phase02_p02_a02_b);
                    if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                        imgzukan5.setImageResource(R.drawable.beetle_phase03_p02_a02_b);
                }
                if (prolength_action5 == 24 || prolength_action5 == 22) {
                    if (age5 > 0 && age5 < 1)
                        imgzukan5.setImageResource(R.drawable.beetle_phase01_p02_a02_b);
                    if (age5 > 1 && age5 < 2)
                        imgzukan5.setImageResource(R.drawable.beetle_phase02_p02_a03_b);
                    if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                        imgzukan5.setImageResource(R.drawable.beetle_phase03_p02_a03_b);
                }
                if (prolength_action5 < 22 && prolength_action5 > 15) {
                    if (age5 > 0 && age5 < 1)
                        imgzukan5.setImageResource(R.drawable.beetle_phase01_p01_a01_b);
                    if (age5 > 1 && age5 < 2)
                        imgzukan5.setImageResource(R.drawable.beetle_phase02_p01_a01_b);
                    if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                        imgzukan5.setImageResource(R.drawable.beetle_phase03_p01_a01_b);
                }
                if (prolength_action5 == 1)
                    prolength_action5 = 60;
            } else {
                handler.post(runnable_action5);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action7 = 60;

    Runnable runnable_action7 = new Runnable() {
        @Override
        public void run() {

            prolength_action7--;
            baction7 = true;
            if (prolength_action7 >= 0) {
                handler.postDelayed(runnable_action7, 700);
                if (prolength_action7 == 55) {
                    if ((swipe7 == false && sleeping7 == false) || (swipe7 == true && sleeping7 == true)) {
                        noi_nham(age7);
                    }
                }
                if (prolength_action7 == 50) {
                    if (swipe7 == false)
                        imgzukan7.startAnimation(animpet7);
                }
                if (prolength_action7 == 50 || prolength_action7 == 48) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p02_a02);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p02_a02);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p02_a02);
                }
                if (prolength_action7 == 49 || prolength_action7 == 47) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p02_a03);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p02_a03);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p02_a03);
                }
                if ((prolength_action7 > 50 && prolength_action7 <= 60) || (prolength_action7 > 25 && prolength_action7 < 47) || (prolength_action7 > 1 && prolength_action7 < 15)) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                }
                if (prolength_action7 == 25) {
                    if (swipe7 == false)
                        imgzukan7.startAnimation(anim2pet7);
                }
                if (prolength_action7 == 25 || prolength_action7 == 23) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p02_a02_b);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p02_a02_b);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p02_a02_b);
                }
                if (prolength_action7 == 24 || prolength_action7 == 22) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p02_a02_b);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p02_a03_b);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p02_a03_b);
                }
                if (prolength_action7 < 22 && prolength_action7 > 15) {
                    if (age7 > 0 && age7 < 1)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p01_a01_b);
                    if (age7 > 1 && age7 < 2)
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p01_a01_b);
                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p02_a01_b);
                }
                if (prolength_action7 == 1)
                    prolength_action7 = 60;
            } else {
                handler.post(runnable_action7);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action2 = 60;

    Runnable runnable_action2 = new Runnable() {
        @Override
        public void run() {
            prolength_action2--;
            baction2 = true;
            if (prolength_action2 >= 0) {
                handler.postDelayed(runnable_action2, 700);
//                Log.e("TAG", "2:" + prolength_action2);
                if (prolength_action2 == 55) {
                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true)) {
                        noi_nham(age2);
                    }
                }
                if (prolength_action2 == 50) {
                    if (swipe2 == false)
                        imgzukan2.startAnimation(animpet2);
                }
                if (prolength_action2 == 50 || prolength_action2 == 48) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p02_a02);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p02_a02);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p02_a02);
                }
                if (prolength_action2 == 49 || prolength_action2 == 47) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p02_a03);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p02_a03);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p02_a03);
                }
                if ((prolength_action2 > 50 && prolength_action2 <= 60) || (prolength_action2 > 25 && prolength_action2 < 47) || (prolength_action2 > 1 && prolength_action2 < 15)) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                }
                if (prolength_action2 == 25) {
                    if (swipe2 == false)
                        imgzukan2.startAnimation(anim2pet2);
                }
                if (prolength_action2 == 25 || prolength_action2 == 23) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p02_a02_b);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p02_a02_b);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p02_a02_b);
                }
                if (prolength_action2 == 24 || prolength_action2 == 22) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p02_a03_b);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p02_a03_b);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p02_a03_b);
                }
                if (prolength_action2 < 22 && prolength_action2 > 15) {
                    if (age2 > 0 && age2 < 1)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01_b);
                    if (age2 > 1 && age2 < 2)
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01_b);
                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p02_a01_b);
                }
                if (prolength_action2 == 1)
                    prolength_action2 = 60;
            } else {
                handler.post(runnable_action2);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action4 = 60;

    Runnable runnable_action4 = new Runnable() {
        @Override
        public void run() {
            prolength_action4--;
            baction4 = true;
            if (prolength_action4 >= 0) {
                handler.postDelayed(runnable_action4, 700);
                if (prolength_action4 == 55) {
                    if ((swipe4 == false && sleeping4 == false) || (swipe4 == true && sleeping4 == true)) {
                        noi_nham(age4);
                    }
                }
                if (prolength_action4 == 50) {
                    if (swipe4 == false)
                        imgzukan4.startAnimation(animpet4);
                }
                if (prolength_action4 == 50 || prolength_action4 == 48) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p02_a02);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p02_a02);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p02_a02);
                }
                if (prolength_action4 == 49 || prolength_action4 == 47) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p02_a03);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p02_a03);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p02_a03);
                }
                if ((prolength_action4 > 50 && prolength_action4 <= 60) || (prolength_action4 > 25 && prolength_action4 < 47) || (prolength_action4 > 1 && prolength_action4 < 15)) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                }
                if (prolength_action4 == 25) {
                    if (swipe4 == false)
                        imgzukan4.startAnimation(anim2pet4);
                }
                if (prolength_action4 == 25 || prolength_action4 == 23) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p02_a02_b);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p02_a02_b);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p02_a02_b);
                }
                if (prolength_action4 == 24 || prolength_action4 == 22) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p02_a03_b);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p02_a03_b);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p02_a03_b);
                }
                if (prolength_action4 < 22 && prolength_action4 > 15) {
                    if (age4 > 0 && age4 < 1)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p01_a01_b);
                    if (age4 > 1 && age4 < 2)
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p01_a01_b);
                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p02_a01_b);
                }
                if (prolength_action4 == 1)
                    prolength_action4 = 60;
            } else {
                handler.post(runnable_action4);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action6 = 60;

    Runnable runnable_action6 = new Runnable() {
        @Override
        public void run() {

            prolength_action6--;
            baction6 = true;
            if (prolength_action6 >= 0) {
                handler.postDelayed(runnable_action6, 700);
                if (prolength_action6 == 55) {
                    if ((swipe6 == false && sleeping6 == false) || (swipe6 == true && sleeping6 == true)) {
                        noi_nham(age6);
                    }
                }
                if (prolength_action6 == 50) {
                    if (swipe6 == false)
                        imgzukan6.startAnimation(animpet6);
                }
                if (prolength_action6 == 50 || prolength_action6 == 48) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p02_a02);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p02_a02);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p02_a02);
                }
                if (prolength_action6 == 49 || prolength_action6 == 47) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p02_a03);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p02_a03);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p02_a03);
                }
                if ((prolength_action6 > 50 && prolength_action6 <= 60) || (prolength_action6 > 25 && prolength_action6 < 47) || (prolength_action6 > 1 && prolength_action6 < 15)) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                }
                if (prolength_action6 == 25) {
                    if (swipe6 == false)
                        imgzukan6.startAnimation(anim2pet6);
                }
                if (prolength_action6 == 25 || prolength_action6 == 23) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p02_a02_b);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p02_a02_b);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p02_a02_b);
                }
                if (prolength_action6 == 24 || prolength_action6 == 22) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p02_a03_b);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p02_a03_b);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p02_a03_b);
                }
                if (prolength_action6 < 22 && prolength_action6 > 15) {
                    if (age6 > 0 && age6 < 1)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p01_a01_b);
                    if (age6 > 1 && age6 < 2)
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p01_a01_b);
                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p02_a01_b);
                }
                if (prolength_action6 == 1)
                    prolength_action6 = 60;
            } else {
                handler.post(runnable_action6);
            }
        }
    };
    //-------------------------------------------------------------
    int prolength_action8 = 60;

    Runnable runnable_action8 = new Runnable() {
        @Override
        public void run() {

            prolength_action8--;
            baction8 = true;
            if (prolength_action8 >= 0) {
                handler.postDelayed(runnable_action8, 700);
                if (prolength_action8 == 55) {
                    if ((swipe8 == false && sleeping8 == false) || (swipe8 == true && sleeping8 == true)) {
                        noi_nham(age8);
                    }
                }
                if (prolength_action8 == 50) {
                    if (swipe8 == false)
                        imgzukan8.startAnimation(animpet8);
                }
                if (prolength_action8 == 50 || prolength_action8 == 48) {
                    ac_2(age8, imgzukan8);
                }
                if (prolength_action8 == 49 || prolength_action8 == 47) {
                    ac_3(age8, imgzukan8);
                }
                if ((prolength_action8 > 50 && prolength_action8 <= 60) || (prolength_action8 > 25 && prolength_action8 < 47) || (prolength_action8 > 1 && prolength_action8 < 15)) {
                    img_normal(age8, imgzukan8);
                }
                if (prolength_action8 == 25) {
                    if (swipe8 == false)
                        imgzukan8.startAnimation(anim2pet8);
                }
                if (prolength_action8 == 25 || prolength_action8 == 23) {
                    if (age8 > 0 && age8 < 1)
                        imgzukan8.setImageResource(R.drawable.beetle_phase01_p02_a02_b);
                    if (age8 > 1 && age8 < 2)
                        imgzukan8.setImageResource(R.drawable.beetle_phase02_p02_a02_b);
                    if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                        imgzukan8.setImageResource(R.drawable.beetle_phase03_p02_a02_b);
                }
                if (prolength_action8 == 24 || prolength_action8 == 22) {
                    if (age8 > 0 && age8 < 1)
                        imgzukan8.setImageResource(R.drawable.beetle_phase01_p02_a03_b);
                    if (age8 > 1 && age8 < 2)
                        imgzukan8.setImageResource(R.drawable.beetle_phase02_p02_a03_b);
                    if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                        imgzukan8.setImageResource(R.drawable.beetle_phase03_p02_a03_b);
                }
                if (prolength_action8 < 22 && prolength_action8 > 15) {
                    if (age8 > 0 && age8 < 1)
                        imgzukan8.setImageResource(R.drawable.beetle_phase01_p01_a01_b);
                    if (age8 > 1 && age8 < 2)
                        imgzukan8.setImageResource(R.drawable.beetle_phase02_p01_a01_b);
                    if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                        imgzukan8.setImageResource(R.drawable.beetle_phase03_p01_a01_b);
                }
                if (prolength_action8 == 1)
                    prolength_action8 = 60;
            } else {
                handler.post(runnable_action8);
            }
        }
    };
    float age = mypage.age;

    public static Timer timer_age1;
    TimerTask timerTask_age1;

    public void _AGE() {
        timer_age1 = new Timer();
        initializeTimerTask_age1();
        timer_age1.schedule(timerTask_age1, 0, 1000);
    }

    public void initializeTimerTask_age1() {
        timerTask_age1 = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        age += 0.000120;
                        if (CLICK_PET == 1) {
                            setImageIcon(age, btnicon, imgzukan, txttruongthanh);
                            if (age >= 3) {
                                handler.removeCallbacks(runnable);
                                handler.removeCallbacks(runnable_action);
                                handler.removeCallbacks(runnable_uong);
                                handler.removeCallbacks(runnable_bb);
                                handler.removeCallbacks(runnable_sk);
                                handler.removeCallbacks(runnable_nha);
                                handler.removeCallbacks(runnable_sleep);
                                handler.removeCallbacks(runnablehealth);
                                handler.removeCallbacks(runnablemood);
                            }
                            if (dialog_lv.isShowing()) {
                                setimgshowfinish(age);
                            }
                            if (finish_dialog.isShowing())
                                ShowFinish();
                        }
                    }
                });
            }
        };
    }

    Runnable run_age3 = new Runnable() {
        @Override
        public void run() {
            age3 += 0.000120;
            bage3 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 3) {
                setImageIcon(age3, btnicon3, imgzukan3, txttruongthanh);
                if (age3 >= 3) {
                    handler.removeCallbacks(runnable3);
                    handler.removeCallbacks(runnable_action3);
                    handler.removeCallbacks(runnable_uong3);
                    handler.removeCallbacks(runnable3_sk);
                    handler.removeCallbacks(runnable_nha3);
                    handler.removeCallbacks(runnable_sleep3);
                    handler.removeCallbacks(runnablehealth3);
                    handler.removeCallbacks(runnablemood3);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish(age3);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };
    Runnable run_age5 = new Runnable() {
        @Override
        public void run() {
            age5 += 0.000120;
            bage5 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 5) {
                setImageIcon(age5, btnicon5, imgzukan5, txttruongthanh);
                if (age5 >= 3) {
                    handler.removeCallbacks(runnable5);
                    handler.removeCallbacks(runnable_action5);
                    handler.removeCallbacks(runnable_uong5);
                    handler.removeCallbacks(runnable5_sk);
                    handler.removeCallbacks(runnable_nha5);
                    handler.removeCallbacks(runnable_sleep5);
                    handler.removeCallbacks(runnablehealth5);
                    handler.removeCallbacks(runnablemood5);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish(age5);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };
    Runnable run_age7 = new Runnable() {
        @Override
        public void run() {
            age7 += 0.000120;
            bage7 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 7) {
                setImageIcon2(age7, btnicon7, imgzukan7);
                if (age7 >= 3) {
                    handler.removeCallbacks(runnable7);
                    handler.removeCallbacks(runnable_action7);
                    handler.removeCallbacks(runnable_uong7);
                    handler.removeCallbacks(runnable7_sk);
                    handler.removeCallbacks(runnable_nha7);
                    handler.removeCallbacks(runnable_sleep7);
                    handler.removeCallbacks(runnablehealth7);
                    handler.removeCallbacks(runnablemood7);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish2(age7);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };

    float age2 = mypage.age2;
    float age3 = mypage.age3;
    float age4 = mypage.age4;
    float age5 = mypage.age5;
    float age6 = mypage.age6;
    float age7 = mypage.age7;
    float age8 = mypage.age8;
    boolean bage2 = false, bage3 = false, bage4 = false, bage5 = false, bage6 = false, bage7 = false, bage8 = false;
    Runnable run_age2 = new Runnable() {
        @Override
        public void run() {
            age2 += 0.000120;
            bage2 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 2) {
                setImageIcon2(age2, btnicon2, imgzukan2);
                if (age2 >= 3) {
                    handler.removeCallbacks(runnable2);
                    handler.removeCallbacks(runnable_action2);
                    handler.removeCallbacks(runnable_uong2);
                    handler.removeCallbacks(runnable2_sk);
                    handler.removeCallbacks(runnable_nha2);
                    handler.removeCallbacks(runnable_sleep2);
                    handler.removeCallbacks(runnablehealth2);
                    handler.removeCallbacks(runnablemood2);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish2(age2);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };

    Runnable run_age4 = new Runnable() {
        @Override
        public void run() {
            age4 += 0.000120;
            bage4 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 4) {
                setImageIcon2(age4, btnicon4, imgzukan4);
                if (age4 >= 3) {
                    handler.removeCallbacks(runnable4);
                    handler.removeCallbacks(runnable_action4);
                    handler.removeCallbacks(runnable_uong4);
                    handler.removeCallbacks(runnable4_sk);
                    handler.removeCallbacks(runnable_nha4);
                    handler.removeCallbacks(runnable_sleep4);
                    handler.removeCallbacks(runnablehealth4);
                    handler.removeCallbacks(runnablemood4);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish2(age4);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };
    Runnable run_age6 = new Runnable() {
        @Override
        public void run() {
            age6 += 0.000120;
            bage6 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 6) {
                setImageIcon2(age6, btnicon6, imgzukan6);
                if (age6 >= 3) {
                    handler.removeCallbacks(runnable6);
                    handler.removeCallbacks(runnable_action6);
                    handler.removeCallbacks(runnable_uong6);
                    handler.removeCallbacks(runnable6_sk);
                    handler.removeCallbacks(runnable_nha6);
                    handler.removeCallbacks(runnable_sleep6);
                    handler.removeCallbacks(runnablehealth6);
                    handler.removeCallbacks(runnablemood6);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish2(age6);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };
    Runnable run_age8 = new Runnable() {
        @Override
        public void run() {
            age8 += 0.000120;
            bage8 = true;
            handler.postDelayed(this, 1000);
            if (CLICK_PET == 8) {
                setImageIcon(age8, btnicon8, imgzukan8, txttruongthanh);
                if (age8 >= 3) {
                    handler.removeCallbacks(runnable8);
                    handler.removeCallbacks(runnable_action8);
                    handler.removeCallbacks(runnable_uong8);
                    handler.removeCallbacks(runnable8_sk);
                    handler.removeCallbacks(runnable_nha8);
                    handler.removeCallbacks(runnable_sleep8);
                    handler.removeCallbacks(runnablehealth8);
                    handler.removeCallbacks(runnablemood8);
                }
                if (dialog_lv.isShowing()) {
                    setimgshowfinish(age8);
                }
                if (finish_dialog.isShowing())
                    ShowFinish();
            }
        }
    };

    boolean bsleep = false;
    int prolength_sleep = mypage.sleep;
    Runnable runnable_sleep = new Runnable() {
        @Override
        public void run() {
            bsleep = true;
            prolength_sleep--;
            if (prolength_sleep < 1) prolength_sleep = 1;
            if (prolength_sleep >= 1) {
//                Log.e("sleep ", "" + prolength_sleep);
                handler.postDelayed(runnable_sleep, 1000);
                if (CLICK_PET == 1) {
                    if (prolength_sleep < 2) {
                        sleeping = true;
                        if (age < 3)
                            imgzukan.setVisibility(View.GONE);
                        fritm_runpa1.setVisibility(View.GONE);
                        _SLEEPANIMATION();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep, 800);
                }
            } else {
                handler.post(runnable_sleep);
            }
        }
    };
    //----
    int prolength_sleep2 = mypage.sleep2;
    Runnable runnable_sleep2 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep2--;
            if (prolength_sleep2 < 1) prolength_sleep2 = 1;
            if (prolength_sleep2 >= 1) {
//                Log.e("sleep2 ", "" + prolength_sleep2);
                handler.postDelayed(runnable_sleep2, 1000);
                if (CLICK_PET == 2) {
                    if (prolength_sleep2 < 2) {
                        sleeping2 = true;
                        if (age2 < 3)
                            imgzukan2.setVisibility(View.GONE);
                        fritm_runpa2.setVisibility(View.GONE);
                        _SLEEPANIMATION2();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep2, 800);
                }
            } else {
                handler.post(runnable_sleep2);
            }
        }
    };
    //---
    int prolength_sleep4 = mypage.sleep4;
    Runnable runnable_sleep4 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep4--;
            if (prolength_sleep4 < 1) prolength_sleep4 = 1;
            if (prolength_sleep4 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep4);
                handler.postDelayed(runnable_sleep4, 1000);
                if (CLICK_PET == 4) {
                    if (prolength_sleep4 < 2) {
                        sleeping4 = true;
                        if (age4 < 3)
                            imgzukan4.setVisibility(View.GONE);
                        fritm_runpa4.setVisibility(View.GONE);
                        _SLEEPANIMATION4();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep4, 2000);
                }
            } else {
                handler.post(runnable_sleep4);
            }
        }
    };
    //---
    int prolength_sleep5 = mypage.sleep5;
    Runnable runnable_sleep5 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep5--;
            if (prolength_sleep5 < 1) prolength_sleep5 = 1;
            if (prolength_sleep5 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep5);
                handler.postDelayed(runnable_sleep5, 1000);
                if (CLICK_PET == 5) {
                    if (prolength_sleep5 < 2) {
                        sleeping5 = true;
                        if (age5 < 3)
                            imgzukan5.setVisibility(View.GONE);
                        fritm_runpa5.setVisibility(View.GONE);
                        _SLEEPANIMATION5();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep5, 2000);
                }
            } else {
                handler.post(runnable_sleep5);
            }
        }
    };
    //---
    int prolength_sleep6 = mypage.sleep6;
    Runnable runnable_sleep6 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep6--;
            if (prolength_sleep6 < 1) prolength_sleep6 = 1;
            if (prolength_sleep6 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep6);
                handler.postDelayed(runnable_sleep6, 1000);
                if (CLICK_PET == 6) {
                    if (prolength_sleep6 < 2) {
                        sleeping6 = true;
                        if (age6 < 3)
                            imgzukan6.setVisibility(View.GONE);
                        fritm_runpa6.setVisibility(View.GONE);
                        _SLEEPANIMATION6();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep6, 2000);
                }
            } else {
                handler.post(runnable_sleep6);
            }
        }
    };
    //---
    int prolength_sleep7 = mypage.sleep7;
    Runnable runnable_sleep7 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep7--;
            if (prolength_sleep7 < 1) prolength_sleep7 = 1;
            if (prolength_sleep7 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep7);
                handler.postDelayed(runnable_sleep7, 1000);
                if (CLICK_PET == 7) {
                    if (prolength_sleep7 < 2) {
                        sleeping7 = true;
                        if (age7 < 3)
                            imgzukan7.setVisibility(View.GONE);
                        fritm_runpa7.setVisibility(View.GONE);
                        _SLEEPANIMATION7();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep7, 1500);
                }
            } else {
                handler.post(runnable_sleep7);
            }
        }
    };
    //---
    int prolength_sleep8 = mypage.sleep8;
    Runnable runnable_sleep8 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep8--;
            if (prolength_sleep8 < 1) prolength_sleep8 = 1;
            if (prolength_sleep8 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep8);
                handler.postDelayed(runnable_sleep8, 1000);
                if (CLICK_PET == 8) {
                    if (prolength_sleep8 < 2) {
                        sleeping8 = true;
                        if (age8 < 3)
                            imgzukan8.setVisibility(View.GONE);
                        fritm_runpa8.setVisibility(View.GONE);
                        _SLEEPANIMATION8();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep8, 3000);
                }
            } else {
                handler.post(runnable_sleep8);
            }
        }
    };
    //---
    int prolength_sleep3 = mypage.sleep3;
    Runnable runnable_sleep3 = new Runnable() {
        @Override
        public void run() {
            prolength_sleep3--;
            if (prolength_sleep3 < 1) prolength_sleep3 = 1;
            if (prolength_sleep3 >= 1) {
//                Log.e("sleep ", "" + prolength_sleep3);
                handler.postDelayed(runnable_sleep3, 1000);
                if (CLICK_PET == 3) {
                    if (prolength_sleep3 < 2) {
                        sleeping3 = true;
                        if (age3 < 3)
                            imgzukan3.setVisibility(View.GONE);
                        fritm_runpa3.setVisibility(View.GONE);
                        _SLEEPANIMATION3();
                    }
                    if (dialog_lv.isShowing())
                        settextforsleep(prolength_sleep3, 1000);
                }
            } else {
                handler.post(runnable_sleep3);
            }
        }
    };
    Animation zoomin, zoomout;

    public void ZoomIMG() {
        zoomin = AnimationUtils.loadAnimation(this, R.anim.zoom_text);
        txtstt.startAnimation(zoomin);
    }

    int exp = mypage.exp;
    int prolength_nha = mypage._COUNTNHA;
    //    int prolength_nha = 188;
    Runnable runnable_nha = new Runnable() {
        @Override
        public void run() {
            bnha = true;
            prolength_nha--;
            if (prolength_nha < 0) prolength_nha = 0;
            if (prolength_nha >= 0) {
//                Log.e("nha", "" + prolength_nha);
                if (_USEITEM == 0)
                    handler.postDelayed(runnable_nha, 1000);
                if (_USEITEM == 2)
                    handler.postDelayed(runnable_nha, 600);
                if (_USEITEM == 1)
                    handler.postDelayed(runnable_nha, 800);
                if (CLICK_PET == 1) {
                    NhaPet(prolength_nha, swipe, 800);
                }
            } else {
                handler.post(runnable_nha);
            }
        }
    };
    //-----
    int prolength_nha2 = mypage._COUNTNHA2;
    //        int prolength_nha2 = 105;
    Runnable runnable_nha2 = new Runnable() {
        @Override
        public void run() {
            prolength_nha2--;
            if (prolength_nha2 < 0) prolength_nha2 = 0;
            if (prolength_nha2 >= 0) {
                if (_USEITEM2 == 0)
                    handler.postDelayed(runnable_nha2, 1000);
                if (_USEITEM2 == 2)
                    handler.postDelayed(runnable_nha2, 600);
                if (_USEITEM2 == 1)
                    handler.postDelayed(runnable_nha2, 800);
                if (CLICK_PET == 2) {
                    NhaPet(prolength_nha2, swipe2, 800);
                }
            } else {
                handler.post(runnable_nha2);
            }
        }
    };
    //-----
    int prolength_nha3 = mypage._COUNTNHA3;
    Runnable runnable_nha3 = new Runnable() {
        @Override
        public void run() {
            prolength_nha3--;
            if (prolength_nha3 < 0) prolength_nha3 = 0;
            if (prolength_nha3 >= 0) {
                if (_USEITEM3 == 0)
                    handler.postDelayed(runnable_nha3, 1000);
                if (_USEITEM3 == 2)
                    handler.postDelayed(runnable_nha3, 600);
                if (_USEITEM3 == 1)
                    handler.postDelayed(runnable_nha3, 800);
                if (CLICK_PET == 3) {
                    NhaPet(prolength_nha3, swipe3, 1000);
                }
            } else {
                handler.post(runnable_nha3);
            }
        }
    };
    //----
    int prolength_nha4 = mypage._COUNTNHA4;
    Runnable runnable_nha4 = new Runnable() {
        @Override
        public void run() {
            prolength_nha4--;
            if (prolength_nha4 < 0) prolength_nha4 = 0;
            if (prolength_nha4 >= 0) {
                if (_USEITEM4 == 0)
                    handler.postDelayed(runnable_nha4, 1000);
                if (_USEITEM4 == 2)
                    handler.postDelayed(runnable_nha4, 600);
                if (_USEITEM4 == 1)
                    handler.postDelayed(runnable_nha4, 800);
                if (CLICK_PET == 4) {
                    NhaPet(prolength_nha4, swipe4, 2000);
                }
            } else {
                handler.post(runnable_nha4);
            }
        }
    };
    //----
    int prolength_nha5 = mypage._COUNTNHA5;
    Runnable runnable_nha5 = new Runnable() {
        @Override
        public void run() {
            prolength_nha5--;
            if (prolength_nha5 < 0) prolength_nha5 = 0;
            if (prolength_nha5 >= 0) {
                if (_USEITEM5 == 0)
                    handler.postDelayed(runnable_nha5, 1000);
                if (_USEITEM5 == 2)
                    handler.postDelayed(runnable_nha5, 600);
                if (_USEITEM5 == 1)
                    handler.postDelayed(runnable_nha5, 800);
                if (CLICK_PET == 5) {
                    NhaPet(prolength_nha5, swipe5, 2000);
                }
            } else {
                handler.post(runnable_nha5);
            }
        }
    };
    //----
    int prolength_nha6 = mypage._COUNTNHA6;
    Runnable runnable_nha6 = new Runnable() {
        @Override
        public void run() {
            prolength_nha6--;
            if (prolength_nha6 < 0) prolength_nha6 = 0;
            if (prolength_nha6 >= 0) {
                if (_USEITEM6 == 0)
                    handler.postDelayed(runnable_nha6, 1000);
                if (_USEITEM6 == 2)
                    handler.postDelayed(runnable_nha6, 600);
                if (_USEITEM6 == 1)
                    handler.postDelayed(runnable_nha6, 800);
                if (CLICK_PET == 6) {
                    NhaPet(prolength_nha6, swipe6, 2000);
                }
            } else {
                handler.post(runnable_nha6);
            }
        }
    };
    //----
    int prolength_nha7 = mypage._COUNTNHA7;
    Runnable runnable_nha7 = new Runnable() {
        @Override
        public void run() {
            prolength_nha7--;
            if (prolength_nha7 < 0) prolength_nha7 = 0;
            if (prolength_nha7 >= 0) {
                if (_USEITEM7 == 0)
                    handler.postDelayed(runnable_nha7, 1000);
                if (_USEITEM7 == 2)
                    handler.postDelayed(runnable_nha7, 600);
                if (_USEITEM7 == 1)
                    handler.postDelayed(runnable_nha7, 800);
                if (CLICK_PET == 7) {
                    NhaPet(prolength_nha7, swipe7, 1500);
                }
            } else {
                handler.post(runnable_nha7);
            }
        }
    };
    //----
    int prolength_nha8 = mypage._COUNTNHA8;
    Runnable runnable_nha8 = new Runnable() {
        @Override
        public void run() {
            prolength_nha8--;
            if (prolength_nha8 < 0) prolength_nha8 = 0;
            if (prolength_nha8 >= 0) {
                if (_USEITEM8 == 0)
                    handler.postDelayed(runnable_nha8, 1000);
                if (_USEITEM8 == 2)
                    handler.postDelayed(runnable_nha8, 600);
                if (_USEITEM8 == 1)
                    handler.postDelayed(runnable_nha8, 800);
                if (CLICK_PET == 8) {
                    NhaPet(prolength_nha8, swipe8, 3000);
                }
            } else {
                handler.post(runnable_nha8);
            }
        }
    };

    AtomicBoolean loadpet1 = new AtomicBoolean(false);
    int p = mypage.p, p2 = mypage.p2, p3 = mypage.p3, p4 = mypage.p4, p5 = mypage.p5, p6 = mypage.p6, p7 = mypage.p7, p8 = mypage.p8;
    int gi = mypage.s, gi2 = mypage.s2, gi3 = mypage.s3, gi4 = mypage.s4, gi5 = mypage.s5, gi6 = mypage.s6, gi7 = mypage.s7, gi8 = mypage.s8;

    public void _Load14s() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putInt("pet_load1", 1);
        editor.commit();
        loadpet1.set(false);
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi; i >= 0 && loadpet1.get(); i--) {
                    gi = i;
                    if (i == 0) {
                        if (p > 0) {
                            p--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar3.setProgress(400);
                                atomicBoolean = true;
                                btnicon.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 1) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p, 1);
                                if (i == 1 && p == 0) {
                                    editor.putString("daload14s", "daload14s");
                                    editor.putInt("pet_load1", 0);
                                    editor.commit();
                                    handler.post(runnable);
                                    handler.post(runnable_uong);
                                    handler.post(runnable_nha);
                                    handler.post(runnable_sleep);
                                    handler.post(runnablehealth);
                                    handler.post(runnablemood);
                                    TieuTien();
                                    handler.post(dt);
                                    loadpet1.set(false);
                                    _AGE();
                                    atomicBoolean = false;
                                    handler.post(runnable_timeUpAge);
                                    p = 4;
                                    gi = 59;
                                    if (CLICK_PET == 1) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action);
                                        _StartEffect(imgzukan);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        loadpet1.set(true);
        th.start();
    }

    AtomicBoolean loadpet2 = new AtomicBoolean(false);

    public void _Load14s2() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putInt("pet_load2", 1);
        editor.commit();
        loadpet2.set(false);
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi2; i >= 0 && loadpet2.get(); i--) {
                    gi2 = i;
                    if (i == 0) {
                        if (p2 > 0) {
                            p2--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar32.setProgress(400);
                                atomicBoolean2 = true;
                                btnicon2.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 2) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan2.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p2) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p2, 2);
                                if (i == 1 && p2 == 0) {
                                    handler.post(run_age2);
                                    handler.post(runnable_timeUpAge2);
                                    handler.post(runnable2);
                                    handler.post(runnable_uong2);
                                    handler.post(runnable_nha2);
                                    handler.post(runnable_sleep2);
                                    handler.post(runnablehealth2);
                                    handler.post(runnablemood2);
                                    TieuTien2();
                                    handler.post(dt2);
                                    loadpet2.set(false);
                                    atomicBoolean2 = false;
                                    p2 = 4;
                                    gi2 = 59;
                                    if (CLICK_PET == 2) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action2);
                                        _StartEffect(imgzukan2);
                                    }
                                    editor.putString("daload14s2", "daload14s2");
                                    editor.putInt("pet_load2", 0);
                                    editor.commit();
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet2.set(true);
        th.start();
    }

    AtomicBoolean loadpet4 = new AtomicBoolean(false);

    public void _Load14s4() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putInt("pet_load4", 1);
        editor.commit();
        loadpet4.set(false);
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi4; i >= 0 && loadpet4.get(); i--) {
                    gi4 = i;
                    if (i == 0) {
                        if (p4 > 0) {
                            p4--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar34.setProgress(1000);
                                atomicBoolean4 = true;
                                btnicon4.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 4) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan4.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p4) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p4, 4);
                                if (i == 1 && p4 == 0) {
                                    editor.putString("daload14s4", "daload14s4");
                                    editor.putInt("pet_load4", 0);
                                    editor.commit();
                                    handler.post(runnable4);
                                    handler.post(runnable_uong4);
                                    handler.post(runnable_nha4);
                                    handler.post(runnable_sleep4);
                                    handler.post(runnablehealth4);
                                    handler.post(runnablemood4);
                                    TieuTien4();
                                    handler.post(dt4);
                                    loadpet4.set(false);
                                    handler.post(run_age4);
                                    atomicBoolean4 = false;
                                    handler.post(runnable_timeUpAge4);
                                    p4 = 4;
                                    gi4 = 59;
                                    if (CLICK_PET == 4) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action4);
                                        _StartEffect(imgzukan4);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet4.set(true);
        th.start();
    }

    AtomicBoolean loadpet6 = new AtomicBoolean(false);

    public void _Load14s6() {
        loadpet6.set(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putInt("pet_load6", 1);
        editor.commit();
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi6; i >= 0 && loadpet6.get(); i--) {
                    gi6 = i;
                    if (i == 0) {
                        if (p6 > 0) {
                            p6--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar36.setProgress(1000);
                                atomicBoolean6 = true;
                                btnicon6.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 6) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan6.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p6) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p6, 6);
                                if (i == 1 && p6 == 0) {
                                    editor.putString("daload14s6", "daload14s6");
                                    editor.putInt("pet_load6", 0);
                                    editor.commit();
                                    handler.post(runnable6);
                                    handler.post(runnable_uong6);
                                    handler.post(runnable_nha6);
                                    handler.post(runnable_sleep6);
                                    handler.post(runnablehealth6);
                                    handler.post(runnablemood6);
                                    TieuTien6();
                                    handler.post(dt6);
                                    loadpet6.set(false);
                                    handler.post(run_age6);
                                    atomicBoolean6 = false;
                                    handler.post(runnable_timeUpAge6);
                                    p6 = 4;
                                    gi6 = 59;
                                    if (CLICK_PET == 6) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action6);
                                        _StartEffect(imgzukan6);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet6.set(true);
        th.start();
    }

    AtomicBoolean loadpet8 = new AtomicBoolean(false);

    public void _Load14s8() {
        loadpet8.set(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putString("daload14s8", "daload14s8");
        editor.putInt("pet_load8", 1);
        editor.commit();
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi8; i >= 0 && loadpet8.get(); i--) {
                    gi8 = i;
                    if (i == 0) {
                        if (p8 > 0) {
                            p8--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar38.setProgress(1500);
                                atomicBoolean8 = true;
                                btnicon8.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 8) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan8.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p8) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p8, 8);
                                if (i == 1 && p8 == 0) {
                                    editor.putString("daload14s8", "daload14s8");
                                    editor.putInt("pet_load8", 0);
                                    editor.commit();
                                    handler.post(runnable8);
                                    handler.post(runnable_uong8);
                                    handler.post(runnable_nha8);
                                    handler.post(runnable_sleep8);
                                    handler.post(runnablehealth8);
                                    handler.post(runnablemood8);
                                    TieuTien8();
                                    handler.post(dt8);
                                    loadpet8.set(false);
                                    handler.post(run_age8);
                                    atomicBoolean8 = false;
                                    handler.post(runnable_timeUpAge8);
                                    p8 = 4;
                                    gi8 = 59;
                                    if (CLICK_PET == 8) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action8);
                                        _StartEffect(imgzukan8);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        loadpet8.set(true);
        th.start();
    }

    AtomicBoolean loadpet3 = new AtomicBoolean(false);

    public void _Load14s3() {
        loadpet3.set(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putInt("pet_load3", 1);
        editor.commit();
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi3; i >= 0 && loadpet3.get(); i--) {
                    gi3 = i;
                    if (i == 0) {
                        if (p3 > 0) {
                            p3--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar33.setProgress(500);
                                atomicBoolean3 = true;
                                btnicon3.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 3) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan3.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p3) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p3, 3);
                                if (i == 1 && p3 == 0) {
                                    editor.putString("daload14s3", "daload14s3");
                                    editor.putInt("pet_load3", 0);
                                    editor.commit();
                                    handler.post(runnable3);
                                    handler.post(runnable_uong3);
                                    handler.post(runnable_nha3);
                                    handler.post(runnable_sleep3);
                                    handler.post(runnablehealth3);
                                    handler.post(runnablemood3);
                                    TieuTien3();
                                    handler.post(dt3);
                                    loadpet3.set(false);
                                    handler.post(run_age3);
                                    atomicBoolean3 = false;
                                    handler.post(runnable_timeUpAge3);
                                    p3 = 4;
                                    gi3 = 59;
                                    if (CLICK_PET == 3) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action3);
                                        _StartEffect(imgzukan3);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet3.set(true);
        th.start();
    }

    AtomicBoolean loadpet5 = new AtomicBoolean(false);

    public void _Load14s5() {
        loadpet5.set(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putString("daload14s5", "daload14s5");
        editor.putInt("pet_load5", 1);
        editor.commit();
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi5; i >= 0 && loadpet5.get(); i--) {
                    gi5 = i;
                    if (i == 0) {
                        if (p5 > 0) {
                            p5--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar35.setProgress(1000);
                                atomicBoolean5 = true;
                                btnicon5.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 5) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan5.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p5) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p5, 5);
                                if (i == 1 && p5 == 0) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    SharedPreferences.Editor editor = pre.edit();
                                    editor.putString("daload14s5", "daload14s5");
                                    editor.putInt("pet_load5", 0);
                                    editor.commit();
                                    handler.post(runnable5);
                                    handler.post(runnable_uong5);
                                    handler.post(runnable_nha5);
                                    handler.post(runnable_sleep5);
                                    handler.post(runnablehealth5);
                                    handler.post(runnablemood5);
                                    TieuTien5();
                                    handler.post(dt5);
                                    loadpet5.set(false);
                                    handler.post(run_age5);
                                    atomicBoolean5 = false;
                                    handler.post(runnable_timeUpAge5);
                                    p5 = 4;
                                    gi5 = 59;
                                    if (CLICK_PET == 5) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action5);
                                        _StartEffect(imgzukan5);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet5.set(true);
        th.start();
    }

    AtomicBoolean loadpet7 = new AtomicBoolean(false);

    public void _Load14s7() {
        loadpet7.set(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        editor.putString("daload14s7", "daload14s7");
        editor.putInt("pet_load7", 1);
        editor.commit();
        Thread th = new Thread() {
            int i;
            int n = 0;
            int g = 0;

            @Override
            public void run() {
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                for (i = gi7; i >= 0 && loadpet7.get(); i--) {
                    gi7 = i;
                    if (i == 0) {
                        if (p7 > 0) {
                            p7--;
                            i = 59;
                        }
                    }
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar37.setProgress(750);
                                atomicBoolean7 = true;
                                btnicon7.setBackgroundResource(R.drawable.b00icon);
                                if (CLICK_PET == 7) {
                                    _SachNha();
                                    txttruongthanh.setText("卵");
                                    imgzukan7.setImageResource(R.drawable.egg_icon);
                                    bginfo.setImageResource(R.drawable.egg_icon);
                                    txttimesum.setText(formatter.format(n) + ":" + formatter.format(g) + ":" +
                                            formatter.format(p7) + ":" + formatter.format(i));
                                }
                                setprload14s(i, p7, 7);
                                if (i == 1 && p7 == 0) {
                                    handler.post(runnable7);
                                    handler.post(runnable_uong7);
                                    handler.post(runnable_nha7);
                                    handler.post(runnable_sleep7);
                                    handler.post(runnablehealth7);
                                    handler.post(runnablemood7);
                                    TieuTien7();
                                    handler.post(dt7);
                                    editor.putString("daload14s7", "daload14s7");
                                    editor.putInt("pet_load7", 0);
                                    editor.commit();
                                    loadpet7.set(false);
                                    handler.post(run_age7);
                                    atomicBoolean7 = false;
                                    handler.post(runnable_timeUpAge7);
                                    p7 = 4;
                                    gi7 = 59;
                                    if (CLICK_PET == 7) {
                                        indicator.setValue(0.04f);
                                        handler.post(runnable_action7);
                                        _StartEffect(imgzukan7);
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        loadpet7.set(true);
        th.start();
    }

    boolean atomicBoolean = false, atomicBoolean2 = false, atomicBoolean3 = false, atomicBoolean4 = false,
            atomicBoolean5 = false, atomicBoolean6 = false, atomicBoolean7 = false, atomicBoolean8 = false;
    Timer timer_effect;
    TimerTask timerTask_effect;
    int _effect = 0;

    public void _StartEffect(ImageView imgzukan) {
        timer_effect = new Timer();
        initializeTimerTask_eff(imgzukan);
        timer_effect.schedule(timerTask_effect, 0, 250);
    }

    public void initializeTimerTask_eff(final ImageView imgzukan) {
        timerTask_effect = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        _effect++;
                        if (_effect > 5) {
                            _effect = 0;
                            if (timer_effect != null) {
                                timer_effect.cancel();
                                timer_effect = null;
                            }
                        }
                        if (_effect == 1) {
                            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                            if (pre.getBoolean("soundaction", true))
                                mPEffect.start();
                            imgzukan.setImageResource(R.drawable.effect_a01);
                        }
                        if (_effect == 2)
                            imgzukan.setImageResource(R.drawable.effect_a02);
                        if (_effect == 3)
                            imgzukan.setImageResource(R.drawable.effect_a03);
                        if (_effect == 4)
                            imgzukan.setImageResource(R.drawable.effect_a04);
                    }
                });
            }
        };
    }

    int prolength_uong = mypage._COUNTUONG;
    Runnable runnable_uong = new Runnable() {
        @Override
        public void run() {
            prolength_uong--;
            buong = true;
            if (prolength_uong < 0) prolength_uong = 0;
            if (prolength_uong >= 1) {
//                Log.e("uong 1", "" + prolength_uong);
                if (_USEITEM == 0)
                    handler.postDelayed(runnable_uong, 1000);
                if (_USEITEM == 2)
                    handler.postDelayed(runnable_uong, 700);
                if (_USEITEM == 1)
                    handler.postDelayed(runnable_uong, 800);
                if (CLICK_PET == 1) {
                    if (dialog_lv.isShowing())
                        settextfordrink(age, prolength_uong, rankpet1(age));
                    if (prolength_uong == rankpet1(age) / 8) {
                        if (sleeping == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong);
            }
        }
    };
    //-------
    boolean buong3 = false;
    int prolength_uong3 = mypage._COUNTUONG3;
    Runnable runnable_uong3 = new Runnable() {
        @Override
        public void run() {

            prolength_uong3--;
            buong3 = true;
            if (prolength_uong3 < 0) prolength_uong3 = 0;
            if (prolength_uong3 >= 1) {
                if (_USEITEM3 == 0)
                    handler.postDelayed(runnable_uong3, 1000);
                if (_USEITEM3 == 2)
                    handler.postDelayed(runnable_uong3, 700);
                if (_USEITEM3 == 1)
                    handler.postDelayed(runnable_uong3, 800);
                if (CLICK_PET == 3) {
                    settextfordrink(age3, prolength_uong3, Chat.rankpet3(age3));
                    if (prolength_uong3 == rankpet1(age3) / 8) {
                        if (sleeping3 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong3);
            }
        }
    };
    //------
    boolean buong5 = false;
    int prolength_uong5 = mypage._COUNTUONG5;
    Runnable runnable_uong5 = new Runnable() {
        @Override
        public void run() {

            prolength_uong5--;
            buong5 = true;
            if (prolength_uong5 < 0) prolength_uong5 = 0;
            if (prolength_uong5 >= 1) {
//                Log.e("runnable_uong51", "" + prolength_uong5);
                if (_USEITEM5 == 0)
                    handler.postDelayed(runnable_uong5, 1000);
                if (_USEITEM5 == 2)
                    handler.postDelayed(runnable_uong5, 700);
                if (_USEITEM5 == 1)
                    handler.postDelayed(runnable_uong5, 800);
                if (CLICK_PET == 5) {
                    settextfordrink(age5, prolength_uong5, Chat.rankpet4(age5));
                    if (prolength_uong5 == rankpet1(age5) / 8) {
                        if (sleeping5 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong5);
            }
        }
    };
    //----
    boolean buong7 = false;
    int prolength_uong7 = mypage._COUNTUONG5;
    Runnable runnable_uong7 = new Runnable() {
        @Override
        public void run() {

            prolength_uong7--;
            buong7 = true;
            if (prolength_uong7 < 0) prolength_uong7 = 0;
            if (prolength_uong7 >= 1) {
//                Log.e("runnable_uong71", "" + prolength_uong7);
                if (_USEITEM7 == 0)
                    handler.postDelayed(runnable_uong7, 1000);
                if (_USEITEM7 == 2)
                    handler.postDelayed(runnable_uong7, 700);
                if (_USEITEM7 == 1)
                    handler.postDelayed(runnable_uong7, 800);
                if (CLICK_PET == 7) {
                    settextfordrink(age7, prolength_uong7, Chat.rankpet7(age7));
                    if (prolength_uong7 == Chat.rankpet7(age7) / 8) {
                        if (sleeping7 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong7);
            }
        }
    };
    //-------
    int prolength_uong2 = mypage._COUNTUONG2;
    Runnable runnable_uong2 = new Runnable() {
        @Override
        public void run() {
            prolength_uong2--;
            buong2 = true;
            if (prolength_uong2 < 0) prolength_uong2 = 0;
            if (prolength_uong2 >= 1) {
//                Log.e("uong 2", "" + prolength_uong2);
                if (_USEITEM2 == 0)
                    handler.postDelayed(runnable_uong2, 1000);
                if (_USEITEM2 == 2)
                    handler.postDelayed(runnable_uong2, 700);
                if (_USEITEM2 == 1)
                    handler.postDelayed(runnable_uong2, 800);
                if (CLICK_PET == 2) {
                    settextfordrink(age2, prolength_uong2, rankpet1(age2));
                    if (prolength_uong2 == rankpet1(age2) / 8) {
                        if (sleeping2 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong2);
            }
        }
    };
    //-------
    int prolength_uong4 = mypage._COUNTUONG4;
    boolean buong4 = false;
    Runnable runnable_uong4 = new Runnable() {
        @Override
        public void run() {

            prolength_uong4--;
            buong4 = true;
            if (prolength_uong4 < 0) prolength_uong4 = 0;
            if (prolength_uong4 >= 1) {
//                Log.e("runnable_uong41", "" + prolength_uong4);
                if (_USEITEM4 == 0)
                    handler.postDelayed(runnable_uong4, 1000);
                if (_USEITEM4 == 2)
                    handler.postDelayed(runnable_uong4, 700);
                if (_USEITEM4 == 1)
                    handler.postDelayed(runnable_uong4, 800);
                if (CLICK_PET == 4) {
                    settextfordrink(age4, prolength_uong4, Chat.rankpet4(age4));
                    if (prolength_uong4 == Chat.rankpet4(age4) / 8) {
                        if (sleeping4 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong4);
            }
        }
    };
    //-------
    int prolength_uong6 = mypage._COUNTUONG6;
    boolean buong6 = false;
    Runnable runnable_uong6 = new Runnable() {
        @Override
        public void run() {

            prolength_uong6--;
            buong6 = true;
            if (prolength_uong6 < 0) prolength_uong6 = 0;
            if (prolength_uong6 >= 1) {
//                Log.e("runnable_uong61", "" + prolength_uong6);
                if (_USEITEM6 == 0)
                    handler.postDelayed(runnable_uong6, 1000);
                if (_USEITEM6 == 2)
                    handler.postDelayed(runnable_uong6, 700);
                if (_USEITEM6 == 1)
                    handler.postDelayed(runnable_uong6, 800);
                if (CLICK_PET == 6) {
                    settextfordrink(age6, prolength_uong6, Chat.rankpet4(age6));
                    if (prolength_uong6 == Chat.rankpet4(age6) / 8) {
                        if (sleeping6 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong6);
            }
        }
    };
    //----
    int prolength_uong8 = mypage._COUNTUONG8;
    boolean buong8 = false;
    Runnable runnable_uong8 = new Runnable() {
        @Override
        public void run() {
            prolength_uong8--;
            buong8 = true;
            if (prolength_uong8 < 0) prolength_uong8 = 0;
            if (prolength_uong8 >= 1) {
//                Log.e("runnable_uong81", "" + prolength_uong8);
                if (_USEITEM8 == 0)
                    handler.postDelayed(runnable_uong8, 1000);
                if (_USEITEM8 == 2)
                    handler.postDelayed(runnable_uong8, 700);
                if (_USEITEM8 == 1)
                    handler.postDelayed(runnable_uong8, 800);
                if (CLICK_PET == 8) {
                    settextfordrink(age8, prolength_uong8, Chat.rankpet8(age8));
                    if (prolength_uong8 == rankpet1(age8) / 8) {
                        if (sleeping8 == false)
                            _SoundKhatNuoc();
                    }
                }
            } else {
                handler.post(runnable_uong8);
            }
        }
    };
    //----
    boolean b_mood = false, b_mood2 = false, b_mood3 = false, b_mood4 = false,
            b_mood5 = false, b_mood6 = false, b_mood7 = false, b_mood8 = false;
    Runnable runnablemood = new Runnable() {
        @Override
        public void run() {
            mood--;
            b_mood = true;
            if (mood < 0) mood = 0;
            if (mood >= 0) {
                handler.postDelayed(runnablemood, 1000);
                if (CLICK_PET == 1) {
                    if (dialog_lv.isShowing())
                        settextformood(mood, 800);
                    speak_mood(mood, age, imgzukan, 800);
                    if (prolength_nha < 100 || prolength < 200 || prolength_uong < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood > 400) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood);
            }
        }
    };
    Runnable runnablemood2 = new Runnable() {
        @Override
        public void run() {
            mood2--;
            b_mood2 = true;
            if (mood2 < 0) mood2 = 0;
            if (mood2 >= 0) {
                handler.postDelayed(runnablemood2, 1000);
                if (CLICK_PET == 2) {
                    if (dialog_lv.isShowing())
                        settextformood(mood2, 800);
                    speak_mood2(mood2, age2, imgzukan2, 800);
                    if (prolength_nha2 < 100 || prolength2 < 200 || prolength_uong2 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood2 > 400) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood2);
            }
        }
    };
    Runnable runnablemood3 = new Runnable() {
        @Override
        public void run() {
            mood3--;
            b_mood3 = true;
            if (mood3 < 0) mood3 = 0;
            if (mood3 >= 0) {
                handler.postDelayed(runnablemood3, 1000);
                if (CLICK_PET == 3) {
                    if (dialog_lv.isShowing())
                        settextformood(mood3, 1000);
                    speak_mood(mood3, age3, imgzukan3, 1000);
                    if (prolength_nha3 < 100 || prolength3 < 200 || prolength_uong3 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood3 > 500) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood3);
            }
        }
    };
    Runnable runnablemood4 = new Runnable() {
        @Override
        public void run() {
            mood4--;
            b_mood4 = true;
            if (mood4 < 0) mood4 = 0;
            if (mood4 >= 0) {
                handler.postDelayed(runnablemood4, 1000);
                if (CLICK_PET == 4) {
                    if (dialog_lv.isShowing())
                        settextformood(mood4, 2000);
                    speak_mood2(mood4, age4, imgzukan4, 2000);
                    if (prolength_nha4 < 100 || prolength4 < 200 || prolength_uong4 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood4 > 1000) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood4);
            }
        }
    };
    Runnable runnablemood5 = new Runnable() {
        @Override
        public void run() {
            mood5--;
            b_mood5 = true;
            if (mood5 < 0) mood5 = 0;
            if (mood5 >= 0) {
                handler.postDelayed(runnablemood5, 1000);
                if (CLICK_PET == 5) {
                    if (dialog_lv.isShowing())
                        settextformood(mood5, 2000);
                    speak_mood(mood5, age5, imgzukan5, 2000);
                    if (prolength_nha5 < 100 || prolength5 < 200 || prolength_uong5 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood5 > 1000) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood5);
            }
        }
    };
    Runnable runnablemood6 = new Runnable() {
        @Override
        public void run() {
            mood6--;
            b_mood6 = true;
            if (mood6 < 0) mood6 = 0;
            if (mood6 >= 0) {
                handler.postDelayed(runnablemood6, 1000);
                if (CLICK_PET == 6) {
                    if (dialog_lv.isShowing())
                        settextformood(mood6, 2000);
                    speak_mood2(mood6, age6, imgzukan6, 2000);
                    if (prolength_nha6 < 100 || prolength6 < 200 || prolength_uong6 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood6 > 1000) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood6);
            }
        }
    };
    Runnable runnablemood7 = new Runnable() {
        @Override
        public void run() {
            mood7--;
            b_mood7 = true;
            if (mood7 < 0) mood7 = 0;
            if (mood7 >= 0) {
                handler.postDelayed(runnablemood7, 1000);
                if (CLICK_PET == 7) {
                    if (dialog_lv.isShowing())
                        settextformood(mood7, 1500);
                    speak_mood2(mood7, age7, imgzukan7, 1500);
                    if (prolength_nha7 < 100 || prolength7 < 200 || prolength_uong7 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood7 > 750) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood7);
            }
        }
    };
    Runnable runnablemood8 = new Runnable() {
        @Override
        public void run() {
            mood8--;
            b_mood8 = true;
            if (mood8 < 0) mood8 = 0;
            if (mood8 >= 0) {
                handler.postDelayed(runnablemood8, 1000);
                if (CLICK_PET == 8) {
                    if (dialog_lv.isShowing())
                        settextformood(mood8, 3000);
                    speak_mood(mood8, age8, imgzukan8, 3000);
                    if (prolength_nha8 < 100 || prolength8 < 200 || prolength_uong8 < 200) {
                        btnstt.setImageResource(R.drawable.p03);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    } else if (mood8 > 1500) {
                        btnstt.setImageResource(R.drawable.p01);
                        txtstt.setImageResource(R.drawable.p01_comment);
                    }
                }
            } else {
                handler.post(runnablemood8);
            }
        }
    };
    boolean b_health = false, b_health2 = false, b_health3 = false, b_health4 = false,
            b_health5 = false, b_health6 = false, b_health7 = false, b_health8 = false;
    Runnable runnablehealth = new Runnable() {
        @Override
        public void run() {
            health--;
            b_health = true;
            if (health < 0) health = 0;
            if (health >= 0) {
                handler.postDelayed(runnablehealth, 1000);
                if (CLICK_PET == 1) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health, 800);
                    if (health == 2) {
                        handler.post(runnable_sk);
                        handler.post(runnable_bb);
                    } else if (health > 2) {
                        handler.removeCallbacks(runnable_sk);
                        handler.removeCallbacks(runnable_bb);
                    }
                }
            } else {
                handler.post(runnablehealth);
            }
        }
    };
    Runnable runnablehealth2 = new Runnable() {
        @Override
        public void run() {
            health2--;
            b_health2 = true;
            if (health2 < 0) health2 = 0;
            if (health2 >= 0) {
                handler.postDelayed(runnablehealth2, 1000);
                if (CLICK_PET == 2) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health2, 800);
                    if (health2 == 2)
                        handler.post(runnable2_sk);
                    else if (health2 > 2)
                        handler.removeCallbacks(runnable2_sk);
                }
            } else {
                handler.post(runnablehealth2);
            }
        }
    };
    Runnable runnablehealth3 = new Runnable() {
        @Override
        public void run() {
            health3--;
            b_health3 = true;
            if (health3 < 0) health3 = 0;
            if (health3 >= 0) {
                handler.postDelayed(runnablehealth3, 1000);
                if (CLICK_PET == 3) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health3, 1000);
                    if (health3 == 2)
                        handler.post(runnable3_sk);
                    else if (health3 > 2)
                        handler.removeCallbacks(runnable3_sk);
                }
            } else {
                handler.post(runnablehealth3);
            }
        }
    };
    Runnable runnablehealth4 = new Runnable() {
        @Override
        public void run() {
            health4--;
            b_health4 = true;
            if (health4 < 0) health4 = 0;
            if (health4 >= 0) {
                handler.postDelayed(runnablehealth4, 1000);
                if (CLICK_PET == 4) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health4, 2000);
                    if (health4 == 2)
                        handler.post(runnable4_sk);
                    else if (health4 > 2)
                        handler.removeCallbacks(runnable4_sk);
                }
            } else {
                handler.post(runnablehealth4);
            }
        }
    };
    Runnable runnablehealth5 = new Runnable() {
        @Override
        public void run() {
            health5--;
            b_health5 = true;
            if (health5 < 0) health5 = 0;
            if (health5 >= 0) {
                handler.postDelayed(runnablehealth5, 1000);
                if (CLICK_PET == 5) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health5, 2000);
                    if (health5 == 2)
                        handler.post(runnable5_sk);
                    else if (health5 > 2)
                        handler.removeCallbacks(runnable5_sk);
                }
            } else {
                handler.post(runnablehealth5);
            }
        }
    };
    Runnable runnablehealth6 = new Runnable() {
        @Override
        public void run() {
            health6--;
            b_health6 = true;
            if (health6 < 0) health6 = 0;
            if (health6 >= 0) {
                handler.postDelayed(runnablehealth6, 1000);
                if (CLICK_PET == 6) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health6, 2000);
                    if (health6 == 2)
                        handler.post(runnable6_sk);
                    else if (health6 > 2)
                        handler.removeCallbacks(runnable6_sk);
                }
            } else {
                handler.post(runnablehealth6);
            }
        }
    };
    Runnable runnablehealth7 = new Runnable() {
        @Override
        public void run() {
            health7--;
            b_health7 = true;
            if (health7 < 0) health7 = 0;
            if (health7 >= 0) {
                handler.postDelayed(runnablehealth7, 1000);
                if (CLICK_PET == 7) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health7, 1500);
                    if (health7 == 2)
                        handler.post(runnable7_sk);
                    else if (health7 > 2)
                        handler.removeCallbacks(runnable7_sk);
                }
            } else {
                handler.post(runnablehealth7);
            }
        }
    };
    Runnable runnablehealth8 = new Runnable() {
        @Override
        public void run() {
            health8--;
            b_health8 = true;
            if (health8 < 0) health8 = 0;
            if (health8 >= 0) {
                handler.postDelayed(runnablehealth8, 1000);
                if (CLICK_PET == 8) {
                    if (dialog_lv.isShowing())
                        settextforhealth(health8, 3000);
                    if (health8 == 2)
                        handler.post(runnable8_sk);
                    else if (health8 > 2)
                        handler.removeCallbacks(runnable8_sk);
                }
            } else {
                handler.post(runnablehealth8);
            }
        }
    };
    int _USEITEM = mypage.useitem, _USEITEM2 = mypage.useitem2, _USEITEM3 = mypage.useitem3, _USEITEM4 = mypage.useitem4,
            _USEITEM5 = mypage.useitem5, _USEITEM6 = mypage.useitem6, _USEITEM7 = mypage.useitem7, _USEITEM8 = mypage.useitem8;
    int prolength = mypage._COUNTAN;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            prolength--;
            ban = true;
            if (prolength < 0) prolength = 0;
            if (prolength >= 0) {
                if (_USEITEM == 0)
                    handler.postDelayed(runnable, 1000);
                else if (_USEITEM == 2)
                    handler.postDelayed(runnable, 500);
                else if (_USEITEM == 1)
                    handler.postDelayed(runnable, 800);
                if (CLICK_PET == 1) {
                    progressBar3.setProgress(prolength);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength, rankpet1(age));
                    img_eat(prolength, rankpet1(age), age, imgzukan, sleeping);

                }
            } else {
                progressBar3.setProgress(0);
                handler.post(runnable);
            }
        }
    };
    //-----
    boolean ban3 = false;
    int prolength3 = mypage._COUNTAN3;
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            prolength3--;
            ban3 = true;
            if (prolength3 < 0) prolength3 = 0;
            if (prolength3 >= 0) {
//                Log.e("run 3", "" + prolength3);
                if (_USEITEM3 == 0)
                    handler.postDelayed(runnable3, 1000);
                else if (_USEITEM3 == 2)
                    handler.postDelayed(runnable3, 500);
                else if (_USEITEM3 == 1)
                    handler.postDelayed(runnable3, 800);
                if (CLICK_PET == 3) {
                    progressBar33.setProgress(prolength3);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength3, Chat.rankpet3(age3));
                    img_eat(prolength3, Chat.rankpet3(age3), age3, imgzukan3, sleeping3);
                }
            } else {
                progressBar33.setProgress(0);
                handler.post(runnable3);
            }
        }
    };
    //-----
    boolean ban5 = false;
    int prolength5 = mypage._COUNTAN5;
    Runnable runnable5 = new Runnable() {
        @Override
        public void run() {
            prolength5--;
            ban5 = true;
            if (prolength5 < 0) prolength5 = 0;
            if (prolength5 >= 0) {
//                Log.e("an 1", "" + prolength5);
                if (_USEITEM5 == 0)
                    handler.postDelayed(runnable5, 1000);
                else if (_USEITEM5 == 2)
                    handler.postDelayed(runnable5, 500);
                else if (_USEITEM5 == 1)
                    handler.postDelayed(runnable5, 800);
                if (CLICK_PET == 5) {
                    progressBar35.setProgress(prolength5);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength5, Chat.rankpet4(age5));
                    img_eat(prolength5, Chat.rankpet4(age5), age5, imgzukan5, sleeping5);
                }
            } else {
                progressBar35.setProgress(0);
                handler.post(runnable5);
            }
        }
    };
    //----
    boolean ban7 = false;
    int prolength7 = mypage._COUNTAN7;
    Runnable runnable7 = new Runnable() {
        @Override
        public void run() {
            prolength7--;
            ban7 = true;
            if (prolength7 < 0) prolength7 = 0;
            if (prolength7 >= 0) {
//                Log.e("an 1", "" + prolength7);
                if (_USEITEM7 == 0)
                    handler.postDelayed(runnable7, 1000);
                else if (_USEITEM7 == 2)
                    handler.postDelayed(runnable7, 500);
                else if (_USEITEM7 == 1)
                    handler.postDelayed(runnable7, 800);
                if (CLICK_PET == 7) {
                    progressBar37.setProgress(prolength7);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength7, Chat.rankpet7(age7));
                    img_eat2(prolength7, Chat.rankpet7(age7), age7, imgzukan7, sleeping7);
                }
            } else {
                progressBar37.setProgress(0);
                handler.post(runnable7);
            }
        }
    };
    //-----
    int prolength2 = mypage._COUNTAN2;
    boolean ban2 = false;
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            prolength2--;
            ban2 = true;
            if (prolength2 < 0) prolength2 = 0;
            if (prolength2 >= 0) {
                if (_USEITEM2 == 0)
                    handler.postDelayed(runnable2, 1000);
                else if (_USEITEM2 == 2)
                    handler.postDelayed(runnable2, 500);
                else if (_USEITEM2 == 1)
                    handler.postDelayed(runnable2, 800);
                if (CLICK_PET == 2) {
                    progressBar32.setProgress(prolength2);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength2, rankpet1(age2));
                    img_eat2(prolength2, rankpet1(age2), age2, imgzukan2, sleeping2);
                }
            } else {
                progressBar32.setProgress(0);
                handler.post(runnable2);
            }
        }
    };
    //-----
    int prolength4 = mypage._COUNTAN4;
    boolean ban4 = false;
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            prolength4--;
            ban4 = true;
            if (prolength4 < 0) prolength4 = 0;
            if (prolength4 >= 0) {
//                Log.e("an 1", "" + prolength4);
                if (_USEITEM4 == 0)
                    handler.postDelayed(runnable4, 1000);
                else if (_USEITEM4 == 2)
                    handler.postDelayed(runnable4, 500);
                else if (_USEITEM4 == 1)
                    handler.postDelayed(runnable4, 800);
                if (CLICK_PET == 4) {
                    progressBar34.setProgress(prolength4);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength4, Chat.rankpet4(age4));
                    img_eat2(prolength4, Chat.rankpet4(age4), age4, imgzukan4, sleeping4);
                }
            } else {
                progressBar34.setProgress(0);
                handler.post(runnable4);
            }
        }
    };
    //-----
    int prolength6 = mypage._COUNTAN6;
    boolean ban6 = false;
    Runnable runnable6 = new Runnable() {
        @Override
        public void run() {
            prolength6--;
            ban6 = true;
            if (prolength6 < 0) prolength6 = 0;
            if (prolength6 >= 0) {
//                Log.e("an 1", "" + prolength6);
                if (_USEITEM6 == 0)
                    handler.postDelayed(runnable6, 1000);
                else if (_USEITEM6 == 2)
                    handler.postDelayed(runnable6, 500);
                else if (_USEITEM6 == 1)
                    handler.postDelayed(runnable6, 800);
                if (CLICK_PET == 6) {
                    progressBar36.setProgress(prolength6);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength6, Chat.rankpet4(age6));
                    img_eat2(prolength6, Chat.rankpet4(age6), age6, imgzukan6, sleeping6);
                }
            } else {
                progressBar36.setProgress(0);
                handler.post(runnable6);
            }
        }
    };
    //-----
    int prolength8 = mypage._COUNTAN8;
    boolean ban8 = false;
    Runnable runnable8 = new Runnable() {
        @Override
        public void run() {
            prolength8--;
            ban8 = true;
            if (prolength8 < 0) prolength8 = 0;
            if (prolength8 >= 0) {
//                Log.e("an 1", "" + prolength8);
                if (_USEITEM8 == 0)
                    handler.postDelayed(runnable8, 1000);
                else if (_USEITEM8 == 2)
                    handler.postDelayed(runnable8, 500);
                else if (_USEITEM8 == 1)
                    handler.postDelayed(runnable8, 800);
                if (CLICK_PET == 8) {
                    progressBar38.setProgress(prolength8);
                    if (dialog_lv.isShowing())
                        settextforeat(prolength8, Chat.rankpet8(age8));
                    img_eat(prolength8, Chat.rankpet8(age8), age8, imgzukan8, sleeping8);
                }
            } else {
                progressBar38.setProgress(0);
                handler.post(runnable8);
            }
        }
    };
    //-----

    public void StopAction() {
        handler.removeCallbacks(runnable_action);
        handler.removeCallbacks(runnable_action2);
        handler.removeCallbacks(runnable_action3);
        handler.removeCallbacks(runnable_action4);
        handler.removeCallbacks(runnable_action5);
        handler.removeCallbacks(runnable_action6);
        handler.removeCallbacks(runnable_action7);
        handler.removeCallbacks(runnable_action8);
    }


    public void _nuoc(final float age, final boolean swipe, final boolean sleeping, final TextView txtnuoc,
                      final ImageView imgzukan, final Runnable runnable_action, final Runnable runnable_sleep) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 8; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    handler.removeCallbacks(runnable_action);
                                    handler.removeCallbacks(runnable_sleep);
                                    _SoundShower();
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true)) {
                                        if (age > 0 && age < 1)
                                            ShowLnmsg(Chat.NoiKhiTam1tuoi.length, Chat.NoiKhiTam1tuoi);
                                        else if (age > 1 && age < 2)
                                            ShowLnmsg(Chat.NoiKhiTam2tuoi.length, Chat.NoiKhiTam2tuoi);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            ShowLnmsg(Chat.NoiKhiTam3Tuoi.length, Chat.NoiKhiTam3Tuoi);
                                    }
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a01);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p04_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p04_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p04_a01);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a02);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p04_a02);
                                    if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p04_a02);
                                    if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p04_a02);
                                }
                                if (i == 3 || i == 5) {
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a01);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p04_a01);
                                    if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p04_a01);
                                    if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p04_a01);
                                }
                                if (i == 8) {
                                    iconEnable();
                                    handler.post(runnable_action);
                                    handler.post(runnable_sleep);
                                    txtnuoc.setBackgroundResource(Color.parseColor("#00000000"));
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _nuoc2(final float age2, final boolean swipe2, final boolean sleeping2, final TextView txtnuoc2,
                       final ImageView imgzukan2, final Runnable runnable_action2, final Runnable runnable_sleep2) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 8; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    _SoundShower();
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true)) {
                                        if (age2 > 0 && age2 < 1)
                                            ShowLnmsg(Chat.NoiKhiTam1tuoi.length, Chat.NoiKhiTam1tuoi);
                                        else if (age2 > 1 && age2 < 2)
                                            ShowLnmsg(Chat.NoiKhiTam2tuoi.length, Chat.NoiKhiTam2tuoi);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                            ShowLnmsg(Chat.NoiKhiTam3Tuoi.length, Chat.NoiKhiTam3Tuoi);
                                    }
                                    handler.removeCallbacks(runnable_action2);
                                    handler.removeCallbacks(runnable_sleep2);
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a01);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p04_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p04_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p04_a01);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a02);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p04_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p04_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p04_a02);
                                }
                                if (i == 3 || i == 5) {
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtnuoc.setBackgroundResource(R.drawable.drop01_a01);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p04_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p04_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p04_a01);
                                }
                                if (i == 8) {
                                    iconEnable();
                                    handler.post(runnable_action2);
                                    txtnuoc.setBackgroundResource(Color.parseColor("#00000000"));
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _Touchzukan(final float age, final ImageView imgzukan) {
        new Thread() {
            int random;
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1)
                                    random = new Random().nextInt(2);
                                if (i == 2) {
                                    if (random == 0) {
                                        if (age > 0 && age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p08_a01);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p08_a01);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p08_a01);
                                    } else if (random == 1) {
                                        if (age > 0 && age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p07_a01);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p07_a01);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p07_a02);
                                    }
                                }
                                if (i == 3) {
                                    img_normal(age, imgzukan);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _Touchzukan2(final float age2, final ImageView imgzukan) {
        new Thread() {
            int random;
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1)
                                    random = new Random().nextInt(2);
                                if (i == 2) {
                                    if (random == 0) {
                                        if (age2 > 0 && age2 < 1)
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p08_a01);
                                        else if (age2 > 1 && age2 < 2)
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p08_a01);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p08_a01);
                                    } else if (random == 1) {
                                        if (age2 > 0 && age2 < 1)
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p07_a02);
                                        else if (age2 > 1 && age2 < 2)
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p07_a02);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p07_a02);
                                    }
                                }
                                if (i == 3) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _TouchzukanSleep(final float age, final ImageView imgzukan) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p08_a012);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p08_a012);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p08_a012);
                                }
                                if (i == 2) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a012);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a012);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a012);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _TouchzukanSleep2(final float age2, final ImageView imgzukan) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p07_a021);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p07_a021);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p07_a021);
                                }
                                if (i == 2) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p08_a011);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p08_a011);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p08_a011);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    int CLICK_PET;

    public void _SoundEat() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPEat.start();
    }

    public void _SoundDrink() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPDrink.start();
    }

    public void _SoundShower() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPShower.start();
    }

    public void _SoundClean() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPCleaning.start();
    }

    public void _SoundSleeping() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPSleep.start();
    }

    public void _SoundClick() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPClick.start();
    }

    public void _SoundKhatNuoc() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            mPKhatNuoc.start();
    }

    public void _SoundDaiTien() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true) && bsound == false)
            kSEDefecation.start();
    }

    private void _an(final float age, final boolean sleeping, final boolean swipe, final ImageView imgzukan,
                     final TextView txtan, final Runnable runnable_action,
                     final Runnable runnable_sleep) {

        new Thread() {
            int giatri;

            public void run() {
                for (giatri = 1; giatri <= 10; giatri++) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                if (giatri == 1) {
                                    iconDisable();
                                    handler.removeCallbacks(runnable_action);
//                                    handler.removeCallbacks(runnable_sleep);
                                    _SoundEat();
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true)) {
                                        speak_eat(age);
                                    }
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a01);
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a01);
                                }
                                if (giatri == 2) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a02);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a02);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a02);
                                }
                                if (giatri == 3) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a03);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a03);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a03);
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a02);
                                }
                                if (giatri == 4) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a04);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a04);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a04);
                                }
                                if (giatri == 5) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a01);
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a03);
                                }
                                if (giatri == 6) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a02);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a02);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a02);
                                }
                                if (giatri == 7) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a03);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a03);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a03);
                                }
                                if (giatri == 8) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p03_a04);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p03_a04);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p03_a04);
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a04);
                                }
                                if (giatri == 10) {
                                    iconEnable();
                                    handler.post(runnable_action);
//                                    handler.post(runnable_sleep);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    txtan.setBackgroundResource(Color.parseColor("#00000000"));
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    //----
    private void _an2(final float age2, final boolean sleeping2, final boolean swipe2, final ImageView imgzukan2, final TextView txtan,
                      final Runnable runnable_action2, final Runnable runnable_sleep2) {

        new Thread() {
            int giatri;

            public void run() {
                for (giatri = 1; giatri <= 10; giatri++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (giatri == 1) {
                                    handler.removeCallbacks(runnable_action2);
//                                    handler.removeCallbacks(runnable_sleep2);
                                    _SoundEat();
                                    iconDisable();
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true)) {
                                        speak_eat(age2);
                                    }
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a01);
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a01);
                                }
                                if (giatri == 2) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a02);
                                }
                                if (giatri == 3) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a03);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a03);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a03);
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a02);
                                }
                                if (giatri == 4) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a04);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a04);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a04);
                                }
                                if (giatri == 5) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a01);
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a03);
                                }
                                if (giatri == 6) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a02);
                                }
                                if (giatri == 7) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a03);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a03);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a03);
                                }
                                if (giatri == 8) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p03_a04);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p03_a04);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p03_a04);
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true))
                                        txtan.setBackgroundResource(R.drawable.food01_a04);
                                }
                                if (giatri == 10) {
                                    iconEnable();
                                    handler.post(runnable_action2);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    txtan.setBackgroundResource(Color.parseColor("#00000000"));
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    int _RAND;

    public void _uong(final float age, final boolean swipe, final boolean sleeping, final ImageView imgzukan,
                      final Runnable runnable_action, final Runnable runnable_sleep) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 10; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    handler.removeCallbacks(runnable_action);
                                    handler.removeCallbacks(runnable_sleep);
                                    _SoundDrink();
                                    iconDisable();
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true)) {
                                        int ran;
                                        Random random = new Random();
                                        lnmsg.setBackgroundResource(R.drawable.balloon1);
                                        txtmsg.setVisibility(View.VISIBLE);
                                        if (age > 0 && age < 1)
                                            ShowLnmsg(Chat.NoiKhiUong1tuoi.length, Chat.NoiKhiUong1tuoi);
                                        else if (age > 1 && age < 2)
                                            ShowLnmsg(Chat.NoiKhiUong2tuoi.length, Chat.NoiKhiUong2tuoi);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            ShowLnmsg(Chat.NoiKhiUong.length, Chat.NoiKhiUong);
                                    }
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a01);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a02);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a02);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a02);

                                }
                                if (i == 3 || i == 5 || i == 7) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a03);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a03);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a03);
                                }
                                if (i == 8) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a01);
                                }
                                if (i == 10) {
                                    iconEnable();
                                    handler.post(runnable_action);
                                    handler.post(runnable_sleep);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _uongr(final float age, final boolean swipe, final boolean sleeping, final ImageView imgzukan,
                       final Runnable runnable_action, final Runnable runnable_sleep) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 10; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    handler.removeCallbacks(runnable_action);
                                    handler.removeCallbacks(runnable_sleep);
                                    _SoundDrink();
                                    if ((swipe == false && sleeping == false) || (swipe == true && sleeping == true)) {
                                        if (age > 0 && age < 1)
                                            ShowLnmsg(Chat.NoiKhiUong1tuoi.length, Chat.NoiKhiUong1tuoi);
                                        else if (age > 1 && age < 2)
                                            ShowLnmsg(Chat.NoiKhiUong2tuoi.length, Chat.NoiKhiUong2tuoi);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            ShowLnmsg(Chat.NoiKhiUong.length, Chat.NoiKhiUong);
                                    }
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a01r);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a01r);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a01r);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a02r);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a02r);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a02r);
                                }
                                if (i == 3 || i == 5 || i == 7) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a03r);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a03r);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a03r);
                                }
                                if (i == 8) {
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p05_a01r);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p05_a01r);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p05_a01r);
                                }
                                if (i == 10) {
                                    iconEnable();
                                    handler.post(runnable_action);
                                    handler.post(runnable_sleep);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _uong2(final float age2, final boolean swipe2, final boolean sleeping2, final ImageView imgzukan2,
                       final Runnable runnable_action2, final Runnable runnable_sleep2) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 10; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    _SoundDrink();
                                    handler.removeCallbacks(runnable_action2);
                                    handler.removeCallbacks(runnable_sleep2);
                                    iconDisable();
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true)) {
                                        if (age2 > 0 && age2 < 1)
                                            ShowLnmsg(Chat.NoiKhiUong1tuoi.length, Chat.NoiKhiUong1tuoi);
                                        else if (age2 > 1 && age2 < 2)
                                            ShowLnmsg(Chat.NoiKhiUong2tuoi.length, Chat.NoiKhiUong2tuoi);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                            ShowLnmsg(Chat.NoiKhiUong.length, Chat.NoiKhiUong);
                                    }
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a01);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a02);
                                }
                                if (i == 3 || i == 5 || i == 7) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a03);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a03);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a03);
                                }

                                if (i == 8) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a01);
                                }
                                if (i == 10) {
                                    iconEnable();
                                    handler.post(runnable_action2);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _uong2r(final float age2, final boolean swipe2, final boolean sleeping2, final ImageView imgzukan2,
                        final Runnable runnable_action2, final Runnable runnable_sleep2) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 10; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    handler.removeCallbacks(runnable_action2);
                                    handler.removeCallbacks(runnable_sleep2);
                                    _SoundDrink();
                                    if ((swipe2 == false && sleeping2 == false) || (swipe2 == true && sleeping2 == true)) {
                                        if (age2 > 0 && age2 < 1)
                                            ShowLnmsg(Chat.NoiKhiUong1tuoi.length, Chat.NoiKhiUong1tuoi);
                                        else if (age2 > 1 && age2 < 2)
                                            ShowLnmsg(Chat.NoiKhiUong2tuoi.length, Chat.NoiKhiUong2tuoi);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                            ShowLnmsg(Chat.NoiKhiUong.length, Chat.NoiKhiUong);
                                    }
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a01r);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a01r);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a01r);
                                }
                                if (i == 2 || i == 4 || i == 6) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a02r);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a02r);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a02r);
                                }
                                if (i == 3 || i == 5 || i == 7) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a03r);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a03r);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a03r);
                                }
                                if (i == 8) {
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p05_a01r);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p05_a01r);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p05_a01r);
                                }
                                if (i == 10) {
                                    iconEnable();
                                    handler.post(runnable_action2);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    AtomicBoolean sleepatomic = new AtomicBoolean(false);
    AtomicBoolean sleepatomic2 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic3 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic4 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic5 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic6 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic7 = new AtomicBoolean(false);
    AtomicBoolean sleepatomic8 = new AtomicBoolean(false);

    public void _SLEEPANIMATION() {
        sleepatomic.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
//                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
//                for (i = mypage.ngu; i <= 90 && sleepatomic.get(); i++) {
                for (i = mypage.ngu; i <= 90 && sleepatomic.get(); i++) {
                    mypage.ngu = i;
//                    Log.e("tag", "" + i);
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 1)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    if (timer_age1 != null) {
                                        timer_age1.cancel();
                                        timer_age1 = null;
                                    }
                                    if (CLICK_PET == 1) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action);
                                        sleep_1(age, imgzukan);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 1) {
                                        sleep_2(age, imgzukan);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 1) {
                                        sleep_3(age, imgzukan);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 1) {
                                        sleep_4(age, imgzukan);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 1) {
                                        sleep_5(age, imgzukan);
                                    }
                                }
                                if (i == 90) {
                                    mypage.ngu = 1;
                                    if (age < 3) {
                                        sleeping = false;
                                        swipe = false;
                                        if (CLICK_PET == 1) {
                                            if (runpaStartTime != 0)
                                                fritm_runpa1.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 1) {
                                        _AGE();
                                        _ButtonEnable();
                                        if (age < 3) {
                                            imgzukan.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        handler.post(runnable_action);
                                        if (age > 0 && age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                        prolength_sleep += 800;
                                        if (prolength_sleep >= 800)
                                            prolength_sleep = 800;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic.set(true);
        th.start();
    }

    public void _SLEEPANIMATION2() {
        sleepatomic2.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu2; i <= 90 && sleepatomic2.get(); i++) {
                    mypage.ngu2 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 2)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age2);
                                    if (CLICK_PET == 2) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action2);
                                        sleep_rank21(age2, imgzukan2);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 2) {
                                        sleep_rank22(age2, imgzukan2);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 2) {
                                        sleep_rank23(age2, imgzukan2);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 2) {
                                        sleep_rank24(age2, imgzukan2);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 2) {
                                        sleep_rank25(age2, imgzukan2);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age2);
                                    mypage.ngu2 = 1;
                                    if (age2 < 3) {
                                        swipe2 = false;
                                        sleeping2 = false;
                                        if (CLICK_PET == 2) {
                                            if (runpaStartTime2 != 0)
                                                fritm_runpa2.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 2) {
                                        _ButtonEnable();
                                        handler.post(runnable_action2);
                                        if (age2 > 0 && age2 < 1)
                                            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                        else if (age2 > 1 && age2 < 2)
                                            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                        if (age2 < 3) {
                                            imgzukan2.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep2 += 800;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic2.set(true);
        th.start();
    }

    //---
    public void _SLEEPANIMATION4() {
        sleepatomic4.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu4; i <= 90 && sleepatomic4.get(); i++) {
                    mypage.ngu4 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 4)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age4);
                                    if (CLICK_PET == 4) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action4);
                                        sleep_rank21(age4, imgzukan4);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 4) {
                                        sleep_rank22(age4, imgzukan4);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 4) {
                                        sleep_rank23(age4, imgzukan4);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 4) {
                                        sleep_rank24(age4, imgzukan4);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 4) {
                                        sleep_rank25(age4, imgzukan4);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age4);
                                    mypage.ngu4 = 1;
                                    if (age4 < 3) {
                                        swipe4 = false;
                                        sleeping4 = false;
                                        if (CLICK_PET == 4) {
                                            if (runpaStartTime4 != 0)
                                                fritm_runpa4.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 4) {
                                        _ButtonEnable();
                                        handler.post(runnable_action4);
                                        if (age4 > 0 && age4 < 1)
                                            imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                        else if (age4 > 1 && age4 < 2)
                                            imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                        else if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                                            imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                        if (age4 < 3) {
                                            imgzukan4.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep4 = 2000;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic4.set(true);
        th.start();
    }

    public void _SLEEPANIMATION6() {
        sleepatomic6.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu6; i <= 90 && sleepatomic6.get(); i++) {
                    mypage.ngu6 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 6)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age6);
                                    if (CLICK_PET == 6) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action6);
                                        sleep_rank21(age6, imgzukan6);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 6) {
                                        sleep_rank22(age6, imgzukan6);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 6) {
                                        sleep_rank23(age6, imgzukan6);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 6) {
                                        sleep_rank24(age6, imgzukan6);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 6) {
                                        sleep_rank25(age6, imgzukan6);
                                    }
                                }
                                if (i == 90) {
                                    mypage.ngu6 = 1;
                                    if (age6 < 3) {
                                        swipe6 = false;
                                        sleeping6 = false;
                                        if (CLICK_PET == 6) {
                                            if (runpaStartTime6 != 0)
                                                fritm_runpa6.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 6) {
                                        handler.post(run_age6);
                                        _ButtonEnable();
                                        handler.post(runnable_action6);
                                        if (age6 > 0 && age6 < 1)
                                            imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                        else if (age6 > 1 && age6 < 2)
                                            imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                        else if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                                            imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                        if (age6 < 3) {
                                            imgzukan6.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep6 = 2000;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic6.set(true);
        th.start();
    }

    //---
    public void _SLEEPANIMATION8() {
        sleepatomic8.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu8; i <= 90 && sleepatomic8.get(); i++) {
                    mypage.ngu8 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 8)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age8);
                                    if (CLICK_PET == 8) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action8);
                                        sleep_1(age8, imgzukan8);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 8) {
                                        sleep_2(age8, imgzukan8);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 8) {
                                        sleep_3(age8, imgzukan8);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 8) {
                                        sleep_4(age8, imgzukan8);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 8) {
                                        sleep_5(age8, imgzukan8);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age8);
                                    mypage.ngu8 = 1;
                                    if (age8 < 3) {
                                        swipe8 = false;
                                        sleeping8 = false;
                                        if (CLICK_PET == 8) {
                                            if (runpaStartTime8 != 0)
                                                fritm_runpa8.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 8) {
                                        _ButtonEnable();
                                        handler.post(runnable_action8);
                                        if (age8 > 0 && age8 < 1)
                                            imgzukan8.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                        else if (age8 > 1 && age8 < 2)
                                            imgzukan8.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                        else if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                                            imgzukan8.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                        if (age8 < 3) {
                                            imgzukan8.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep8 = 3000;
                                    }
                                }
                            }
                        });
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic8.set(true);
        th.start();
    }

    public void _SLEEPANIMATION3() {
        sleepatomic3.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu3; i <= 90 && sleepatomic3.get(); i++) {
                    mypage.ngu3 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 3)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age3);
                                    if (CLICK_PET == 3) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action3);
                                        sleep_1(age3, imgzukan3);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 3) {
                                        sleep_2(age3, imgzukan3);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 3) {
                                        sleep_3(age3, imgzukan3);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 3) {
                                        sleep_4(age3, imgzukan3);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 3) {
                                        sleep_5(age3, imgzukan3);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age3);
                                    mypage.ngu3 = 1;
                                    if (age3 < 3) {
                                        swipe3 = false;
                                        sleeping3 = false;
                                        if (CLICK_PET == 3) {
                                            if (runpaStartTime3 != 0)
                                                fritm_runpa3.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 3) {
                                        _ButtonEnable();
                                        handler.post(runnable_action3);
                                        if (age3 > 0 && age3 < 1)
                                            imgzukan3.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                        else if (age3 > 1 && age3 < 2)
                                            imgzukan3.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                        else if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                                            imgzukan3.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                        if (age3 < 3) {
                                            imgzukan3.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep3 += 950;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic3.set(true);
        th.start();
    }

    public void _SLEEPANIMATION5() {
        sleepatomic5.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu5; i <= 90 && sleepatomic5.get(); i++) {
                    mypage.ngu5 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 5)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age5);
                                    if (CLICK_PET == 5) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action5);
                                        sleep_1(age5, imgzukan5);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 5) {
                                        sleep_2(age5, imgzukan5);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 5) {
                                        sleep_3(age5, imgzukan5);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 5) {
                                        sleep_4(age5, imgzukan5);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 5) {
                                        sleep_5(age5, imgzukan5);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age5);
                                    mypage.ngu5 = 1;
                                    if (age5 < 3) {
                                        swipe5 = false;
                                        sleeping5 = false;
                                        if (CLICK_PET == 5) {
                                            if (runpaStartTime5 != 0)
                                                fritm_runpa5.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 5) {
                                        _ButtonEnable();
                                        handler.post(runnable_action5);
                                        if (age5 > 0 && age5 < 1)
                                            imgzukan5.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                        else if (age5 > 1 && age5 < 2)
                                            imgzukan5.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                        else if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                                            imgzukan5.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                        if (age5 < 3) {
                                            imgzukan5.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep5 = 2000;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic5.set(true);
        th.start();
    }

    public void _SLEEPANIMATION7() {
        sleepatomic7.set(false);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                for (i = mypage.ngu7; i <= 90 && sleepatomic7.get(); i++) {
                    mypage.ngu7 = i;
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 10 || i == 90) {
                                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                    if (pre.getBoolean("soundaction", true) && bsound == false)
                                        mPEffect.start();
                                }
                                if (i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80) {
                                    if (CLICK_PET == 7)
                                        _SoundSleeping();
                                }
                                if (i == 81 || i == 86 || i == 11 || i == 16 || i == 21 || i == 26 || i == 31 || i == 36
                                        || i == 41 || i == 46 || i == 51 || i == 56 || i == 61 || i == 66 || i == 71 || i == 76) {
                                    handler.removeCallbacks(run_age7);
                                    if (CLICK_PET == 7) {
                                        _ButtonDisable();
                                        handler.removeCallbacks(runnable_action7);
                                        sleep_rank21(age7, imgzukan7);
                                    }
                                }
                                if (i == 82 || i == 87 || i == 12 || i == 17 || i == 22 || i == 27 || i == 32 || i == 37 || i == 42 || i == 47 || i == 52 || i == 57 || i == 62
                                        || i == 67 || i == 72 || i == 77) {
                                    if (CLICK_PET == 7) {
                                        sleep_rank22(age7, imgzukan7);
                                    }
                                }
                                if (i == 83 || i == 88 || i == 13 || i == 18 || i == 23 || i == 28 || i == 33 || i == 38 || i == 43 || i == 48
                                        || i == 53 || i == 58 || i == 63 || i == 68 || i == 73 || i == 78) {
                                    if (CLICK_PET == 7) {
                                        sleep_rank23(age7, imgzukan7);
                                    }
                                }
                                if (i == 84 || i == 89 || i == 14 || i == 19 || i == 24 || i == 29 || i == 34 || i == 39 || i == 44 || i == 49 || i == 54 || i == 59
                                        || i == 64 || i == 69 || i == 74 || i == 79) {
                                    if (CLICK_PET == 7) {
                                        sleep_rank24(age7, imgzukan7);
                                    }
                                }
                                if (i == 85 || i == 80 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50 || i == 55 || i == 60
                                        || i == 65 || i == 70 || i == 75) {
                                    if (CLICK_PET == 7) {
                                        sleep_rank25(age7, imgzukan7);
                                    }
                                }
                                if (i == 90) {
                                    handler.post(run_age7);
                                    mypage.ngu7 = 1;
                                    if (age7 < 3) {
                                        swipe7 = false;
                                        sleeping7 = false;
                                        if (CLICK_PET == 7) {
                                            if (runpaStartTime7 != 0)
                                                fritm_runpa7.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    if (CLICK_PET == 7) {
                                        _ButtonEnable();
                                        handler.post(runnable_action7);
                                        if (age7 > 0 && age7 < 1)
                                            imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                        else if (age7 > 1 && age7 < 2)
                                            imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                        else if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                                            imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                        if (age7 < 3) {
                                            imgzukan7.setVisibility(View.VISIBLE);
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg);
                                            ShowAnimation();
                                            imgupdown.setImageResource(R.drawable.bgdown);
                                        }
                                        prolength_sleep7 = 1500;
                                    }
                                }
                            }
                        });
                        Thread.sleep(700);
                    } catch (Exception e) {

                    }
                }
            }
        };
        sleepatomic7.set(true);
        th.start();
    }

    //----
    public void _quetnha() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    handler.removeCallbacks(runnable_action);
                                    handler.removeCallbacks(runnable_sleep);
                                    _SoundClean();
                                    if (swipe == false) {
                                        speak_clean(age);
                                    }
                                    clean_1(age, imgzukan);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_2(age, imgzukan);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_3(age, imgzukan);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_1(age, imgzukan);
                                }
                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action);
                                    handler.post(runnable_sleep);
                                    if (age > 0 && age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha = 800;
                                    if (prolength_nha > 800)
                                        prolength_nha = 800;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _quetnha3() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe3 == false) {
                                        speak_clean(age3);
                                    }
                                    clean_1(age3, imgzukan3);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_2(age3, imgzukan3);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_3(age3, imgzukan3);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_1(age3, imgzukan3);
                                }

                                if (i == 15) {
                                    iconEnable();
                                    if (age3 > 0 && age3 < 1)
                                        imgzukan3.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    if (age3 > 1 && age3 < 2)
                                        imgzukan3.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    if ((age3 > 2 && age3 < 3) || (age3 > 3 && age3 < 4))
                                        imgzukan3.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha3 = 1000;
                                    if (prolength_nha3 > 1000)
                                        prolength_nha3 = 1000;
                                    if (CLICK_PET == 3)
                                        handler.post(runnable_action3);
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _quetnha5() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe5 == false) {
                                        speak_clean(age5);
                                    }
                                    clean_1(age5, imgzukan5);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_2(age5, imgzukan5);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_3(age5, imgzukan5);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_1(age5, imgzukan5);
                                }
                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action5);
                                    if (age5 > 0 && age5 < 1)
                                        imgzukan5.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    if (age5 > 1 && age5 < 2)
                                        imgzukan5.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    if ((age5 > 2 && age5 < 3) || (age5 > 3 && age5 < 4))
                                        imgzukan5.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha5 = 2000;
                                    if (prolength_nha5 > 2000)
                                        prolength_nha5 = 2000;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _quetnha7() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe7 == false) {
                                        speak_clean(age7);
                                    }
                                    clean_rank21(age7, imgzukan7);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_rank22(age7, imgzukan7);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_rank23(age7, imgzukan7);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_rank21(age7, imgzukan7);
                                }

                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action7);
                                    if (age7 > 0 && age7 < 1)
                                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    if (age7 > 1 && age7 < 2)
                                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    if ((age7 > 2 && age7 < 3) || (age7 > 3 && age7 < 4))
                                        imgzukan7.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha7 = 1500;
                                    if (prolength_nha7 > 1500)
                                        prolength_nha7 = 1500;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    //----
    public void _quetnha2() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe2 == false) {
                                        speak_clean(age2);
                                    }
                                    clean_rank21(age2, imgzukan2);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_rank22(age2, imgzukan2);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_rank23(age2, imgzukan2);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_rank21(age2, imgzukan2);
                                }
                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action2);
                                    if (age2 > 0 && age2 < 1)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    if (age2 > 1 && age2 < 2)
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha2 = 800;
                                    if (prolength_nha2 > 800)
                                        prolength_nha2 = 800;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _quetnha4() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe4 == false) {
                                        speak_clean(age4);
                                    }
                                    clean_rank21(age4, imgzukan4);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_rank22(age4, imgzukan4);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_rank23(age4, imgzukan4);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_rank21(age4, imgzukan4);
                                }

                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action4);
                                    if (age4 > 0 && age4 < 1)
                                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    if (age4 > 1 && age4 < 2)
                                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    if ((age4 > 2 && age4 < 3) || (age4 > 3 && age4 < 4))
                                        imgzukan4.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha4 = 2000;
                                    if (prolength_nha4 > 2000)
                                        prolength_nha4 = 2000;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _quetnha6() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe6 == false) {
                                        speak_clean(age6);
                                    }
                                    clean_rank21(age6, imgzukan6);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_rank22(age6, imgzukan6);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_rank23(age6, imgzukan6);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_rank21(age6, imgzukan6);
                                }
                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action6);
                                    if (age6 > 0 && age6 < 1)
                                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    if (age6 > 1 && age6 < 2)
                                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    if ((age6 > 2 && age6 < 3) || (age6 > 3 && age6 < 4))
                                        imgzukan6.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha6 = 2000;
                                    if (prolength_nha6 > 2000)
                                        prolength_nha6 = 2000;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void _quetnha8() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 15; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) {
                                    iconDisable();
                                    StopAction();
                                    _SoundClean();
                                    if (swipe8 == false) {
                                        speak_clean(age8);
                                    }
                                    clean_1(age8, imgzukan8);
                                }
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 13) {
                                    clean_2(age8, imgzukan8);
                                }
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 14) {
                                    clean_3(age8, imgzukan8);
                                }
                                if (i == 4 || i == 7 || i == 10) {
                                    clean_1(age8, imgzukan8);
                                }
                                if (i == 15) {
                                    iconEnable();
                                    handler.post(runnable_action8);
                                    if (age8 > 0 && age8 < 1)
                                        imgzukan8.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                    if (age8 > 1 && age8 < 2)
                                        imgzukan8.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                    if ((age8 > 2 && age8 < 3) || (age8 > 3 && age8 < 4))
                                        imgzukan8.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    _ButtonEnable();
                                    _SachNha();
                                    prolength_nha8 = 3000;
                                    if (prolength_nha8 > 3000)
                                        prolength_nha8 = 3000;
                                }
                            }
                        });
                        Thread.sleep(300);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    Dialog dialog_lv;
    TextView txttimesum, txtuptime, txtno, txttrangthai, txtkhatnuoc, txttt, txtsuckhoe;
    int ngay = mypage.ngay;
    int gio = mypage.gio;
    int phut = mypage.phut;
    int giay = mypage.giay;
    //    int ngay = 0, gio = 0, phut = 0, giay = 8;
    //---
    int ngay2 = mypage.ngay2;
    int gio2 = mypage.gio2;
    int phut2 = mypage.phut2;
    int giay2 = mypage.giay2;
    //            int ngay2 = 0, gio2 = 0, phut2 = 0, giay2 = 8;
    //
    int ngay4 = mypage.ngay4;
    int gio4 = mypage.gio4;
    int phut4 = mypage.phut4;
    int giay4 = mypage.giay4;
    //    int ngay4 = 0, gio4 = 0, phut4 = 0, giay4 = 59;
    //---
    int ngay6 = mypage.ngay6;
    int gio6 = mypage.gio6;
    int phut6 = mypage.phut6;
    int giay6 = mypage.giay6;
    //    int ngay6 = 0, gio6 = 0, phut6 = 0, giay6 = 59;
    //---
    int ngay8 = mypage.ngay8;
    int gio8 = mypage.gio8;
    int phut8 = mypage.phut8;
    int giay8 = mypage.giay8;
    //    int ngay8 = 0, gio8 = 0, phut8 = 0, giay8 = 59;
    //----
    int ngay3 = mypage.ngay3;
    int gio3 = mypage.gio3;
    int phut3 = mypage.phut3;
    int giay3 = mypage.giay3;
    //    int ngay3 = 0, gio3 = 0, phut3 = 0, giay3 = 59;
    //----
    int ngay5 = mypage.ngay5;
    int gio5 = mypage.gio5;
    int phut5 = mypage.phut5;
    int giay5 = mypage.giay5;
    //    int ngay5 = 0, gio5 = 0, phut5 = 0, giay5 = 59;
    //----
    int ngay7 = mypage.ngay7;
    int gio7 = mypage.gio7;
    int phut7 = mypage.phut7;
    int giay7 = mypage.giay7;
//    int ngay7 = 0, gio7 = 0, phut7 = 0, giay7 = 59;

    int ngayup = mypage.ngayup;
    int gioup = mypage.gioup;
    int phutup = mypage.phutup;
    int giayup = 0;
    //
    int ngayup2 = mypage.ngayup2;
    int gioup2 = mypage.gioup2;
    int phutup2 = mypage.phutup2;
    int giayup2 = 0;
    //
    int ngayup3 = mypage.ngayup3;
    int gioup3 = mypage.gioup3;
    int phutup3 = mypage.phutup3;
    int giayup3 = 0;
    //
    int ngayup4 = mypage.ngayup4;
    int gioup4 = mypage.gioup4;
    int phutup4 = mypage.phutup4;
    int giayup4 = 0;
    //
    int ngayup5 = mypage.ngayup5;
    int gioup5 = mypage.gioup5;
    int phutup5 = mypage.phutup5;
    int giayup5 = 0;
    //
    int ngayup6 = mypage.ngayup6;
    int gioup6 = mypage.gioup6;
    int phutup6 = mypage.phutup6;
    int giayup6 = 0;
    //
    int ngayup7 = mypage.ngayup7;
    int gioup7 = mypage.gioup7;
    int phutup7 = mypage.phutup7;
    int giayup7 = 0;
    //
    int ngayup8 = mypage.ngayup8;
    int gioup8 = mypage.gioup8;
    int phutup8 = mypage.phutup8;
    int giayup8 = 0;
    TextView txtid, txtloai;
    EditText editten;

    public void Dialog_Level() {
        dialog_lv = new Dialog(zukan_main.this);
        dialog_lv.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_lv.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        dialog_lv.setContentView(R.layout.dialog_info);
        dialog_lv.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        editten = (EditText) dialog_lv.findViewById(R.id.editten);
        txtid = (TextView) dialog_lv.findViewById(R.id.txtid);
        txtloai = (TextView) dialog_lv.findViewById(R.id.txtloai);
        editten.setText("" + _tenzukan.getText().toString());
        dialog_lv.setCanceledOnTouchOutside(false);
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        Button btnClose = (Button) dialog_lv.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _SoundClick();
                if (editten.getText().toString().length() > 10) {
                    Dialog_notify();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                } else if (editten.getText().toString().length() == 0) {
                    Dialog_notify();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    editten.setText("" + _tenzukan.getText().toString());
                } else {
                    if (CLICK_PET == 1) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan", editten.getText().toString());
                            _name = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 2) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan2", editten.getText().toString());
                            _name2 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 3) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan3", editten.getText().toString());
                            _name3 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 4) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan4", editten.getText().toString());
                            _name4 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 5) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan5", editten.getText().toString());
                            _name5 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 6) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan6", editten.getText().toString());
                            _name6 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 7) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan", ""), pre.getString("tenzukan8", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan7", editten.getText().toString());
                            _name7 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                    if (CLICK_PET == 8) {
                        if (Chat.check_name(editten.getText().toString(), pre.getString("tenzukan2", ""),
                                pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                                pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                                pre.getString("tenzukan7", ""), pre.getString("tenzukan", "")) == 0) {
                            Dialog_notify();
                            txtyesbutton.setText("既にその名前は使用されています。\n名前を変えてください。");
                        } else {
                            editor.putString("tenzukan8", editten.getText().toString());
                            _name8 = editten.getText().toString();
                            editor.commit();
                            _tenzukan.setText("" + editten.getText().toString());
                            dialog_lv.dismiss();
                        }
                    }
                }
            }
        });
        txttimesum = (TextView) dialog_lv.findViewById(R.id.txttimesum);
        txtuptime = (TextView) dialog_lv.findViewById(R.id.txtuptime);
        txtno = (TextView) dialog_lv.findViewById(R.id.txtno);
        txttrangthai = (TextView) dialog_lv.findViewById(R.id.txttrangthai);
        txtkhatnuoc = (TextView) dialog_lv.findViewById(R.id.txtkhatnuoc);
        txttt = (TextView) dialog_lv.findViewById(R.id.txttt);
        txttt.setText("" + txttruongthanh.getText().toString());
        txtsuckhoe = (TextView) dialog_lv.findViewById(R.id.txtsuckhoe);
        txtsucmanh = (TextView) dialog_lv.findViewById(R.id.txtsucmanh);
        txtbanbe = (TextView) dialog_lv.findViewById(R.id.txtbanbe);
        txttientrien = (TextView) dialog_lv.findViewById(R.id.txttientrien);
        txtngu = (TextView) dialog_lv.findViewById(R.id.txtngu);
        bginfo = (ImageView) dialog_lv.findViewById(R.id.bginfo);
        if (CLICK_PET == 1) {
            txtsucmanh.setText("" + strength);
            txtbanbe.setText("" + friendly);
            settextfordrink(age, prolength_uong, rankpet1(age));
            settextformood(mood, 800);
            settextforhealth(health, 800);
        } else if (CLICK_PET == 2) {
            txtsucmanh.setText("" + strength2);
            txtbanbe.setText("" + friendly2);
            settextfordrink(age2, prolength_uong2, rankpet1(age2));
            settextformood(mood2, 800);
            settextforhealth(health2, 800);
        } else if (CLICK_PET == 3) {
            txtsucmanh.setText("" + strength3);
            txtbanbe.setText("" + friendly3);
            settextfordrink(age3, prolength_uong3, Chat.rankpet3(age3));
            settextformood(mood3, 1000);
            settextforhealth(health3, 1000);
        } else if (CLICK_PET == 4) {
            txtsucmanh.setText("" + strength4);
            txtbanbe.setText("" + friendly4);
            settextfordrink(age4, prolength_uong4, Chat.rankpet4(age4));
            settextformood(mood4, 2000);
            settextforhealth(health4, 2000);
        } else if (CLICK_PET == 5) {
            txtsucmanh.setText("" + strength5);
            txtbanbe.setText("" + friendly5);
            settextfordrink(age5, prolength_uong5, Chat.rankpet4(age5));
            settextformood(mood5, 2000);
            settextforhealth(health5, 2000);
        } else if (CLICK_PET == 6) {
            txtsucmanh.setText("" + strength6);
            txtbanbe.setText("" + friendly6);
            settextfordrink(age6, prolength_uong6, Chat.rankpet4(age6));
            settextformood(mood6, 2000);
            settextforhealth(health6, 2000);
        } else if (CLICK_PET == 7) {
            txtbanbe.setText("" + friendly7);
            txtsucmanh.setText("" + strength7);
            settextfordrink(age7, prolength_uong7, Chat.rankpet7(age7));
            settextformood(mood7, 1500);
            settextforhealth(health7, 1500);
        } else if (CLICK_PET == 8) {
            txtbanbe.setText("" + friendly8);
            txtsucmanh.setText("" + strength8);
            settextfordrink(age8, prolength_uong8, Chat.rankpet8(age8));
            settextformood(mood8, 3000);
            settextforhealth(health8, 3000);
        }
        if (pre.getString("tenzukan", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem", 0) == 0)
                            i++;
                        else if (pre.getInt("useitem", 0) == 1)
                            i += 2;
                        else if (pre.getInt("useitem", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 1) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup) + ":" + formatter.format(gioup) + ":"
                                                    + formatter.format(phutup) + ":" + i + "9");

                                    }
                                    if (phutup == 60) {
                                        phutup = 0;
                                        gioup++;
                                        if (pre.getString("daload14s", "").length() > 0) {
                                            float fa = (float) gioup / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup == 24) {
                                        gioup = 0;
                                        ngayup++;
                                        if (CLICK_PET == 1) {
                                            int a = ngayup + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //
        if (pre.getString("tenzukan2", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem2", 0) == 0)
                            i++;
                        if (pre.getInt("useitem2", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem2", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup2++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 2) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup2) + ":" + formatter.format(gioup2)
                                                    + ":" + formatter.format(phutup2) + ":" + i + "9");
                                    }
                                    if (phutup2 == 60) {
                                        phutup2 = 0;
                                        gioup2++;
                                        if (pre.getString("daload14s2", "").length() > 0) {
                                            float fa = (float) gioup2 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup2 == 24) {
                                        gioup2 = 0;
                                        ngayup2++;
                                        if (CLICK_PET == 2) {
                                            int a = ngayup2 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //-----
        if (pre.getString("tenzukan3", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem3", 0) == 0)
                            i++;
                        if (pre.getInt("useitem3", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem3", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup3++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 3) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup3) + ":" + formatter.format(gioup3) + ":"
                                                    + formatter.format(phutup3) + ":" + i + "9");
                                    }
                                    if (phutup3 == 60) {
                                        phutup3 = 0;
                                        gioup3++;
                                        if (pre.getString("daload14s3", "").length() > 0) {
                                            float fa = (float) gioup3 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup3 == 24) {
                                        gioup3 = 0;
                                        ngayup3++;
                                        if (CLICK_PET == 3) {
                                            int a = ngayup3 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //----
        if (pre.getString("tenzukan4", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem4", 0) == 0)
                            i++;
                        if (pre.getInt("useitem4", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem4", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup4++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 4) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup4) + ":" + formatter.format(gioup4) +
                                                    ":" + formatter.format(phutup4) + ":" + i + "9");
                                    }
                                    if (phutup4 == 60) {
                                        phutup4 = 0;
                                        gioup4++;
                                        if (pre.getString("daload14s4", "").length() > 0) {
                                            float fa = (float) gioup4 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup4 == 24) {
                                        gioup4 = 0;
                                        ngayup4++;
                                        if (CLICK_PET == 4) {
                                            int a = ngayup4 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //----
        if (pre.getString("tenzukan5", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem5", 0) == 0)
                            i++;
                        if (pre.getInt("useitem5", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem5", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup5++;
                        }

                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 5) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup5) + ":" + formatter.format(gioup5)
                                                    + ":" + formatter.format(phutup5) + ":" + i + "9");
                                    }
                                    if (phutup5 == 60) {
                                        phutup5 = 0;
                                        gioup5++;
                                        if (pre.getString("daload14s5", "").length() > 0) {
                                            float fa = (float) gioup5 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup5 == 24) {
                                        gioup5 = 0;
                                        ngayup5++;
                                        if (CLICK_PET == 5) {
                                            int a = ngayup5 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //----
        if (pre.getString("tenzukan6", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem6", 0) == 0)
                            i++;
                        if (pre.getInt("useitem6", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem6", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup6++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 6) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup6) + ":" + formatter.format(gioup6)
                                                    + ":" + formatter.format(phutup6) + ":" + i + "9");
                                    }
                                    if (phutup6 == 60) {
                                        phutup6 = 0;
                                        gioup6++;
                                        if (pre.getString("daload14s6", "").length() > 0) {
                                            float fa = (float) gioup6 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup6 == 24) {
                                        gioup6 = 0;
                                        ngayup6++;
                                        if (CLICK_PET == 6) {
                                            int a = ngayup6 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //-----
        if (pre.getString("tenzukan7", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem7", 0) == 0)
                            i++;
                        if (pre.getInt("useitem7", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem7", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup7++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 7) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup7) + ":" + formatter.format(gioup7)
                                                    + ":" + formatter.format(phutup7) + ":" + i + "9");
                                    }
                                    if (phutup7 == 60) {
                                        phutup7 = 0;
                                        gioup7++;
                                        if (pre.getString("daload14s7", "").length() > 0) {
                                            float fa = (float) gioup7 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup7 == 24) {
                                        gioup7 = 0;
                                        ngayup7++;
                                        if (CLICK_PET == 7) {
                                            int a = ngayup7 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //----
        if (pre.getString("tenzukan8", "").length() > 0) {
            new Thread() {
                int i = 0;

                @Override
                public void run() {
                    while (1 < 2 && !uptime) {
                        if (pre.getInt("useitem8", 0) == 0)
                            i++;
                        if (pre.getInt("useitem8", 0) == 1)
                            i += 2;
                        if (pre.getInt("useitem8", 0) == 2)
                            i += 5;
                        if (i > 5) {
                            i = 0;
                            phutup8++;
                        }
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (CLICK_PET == 8) {
                                        if (dialog_lv.isShowing())
                                            txtuptime.setText(formatter.format(ngayup8) + ":" + formatter.format(gioup8)
                                                    + ":" + formatter.format(phutup8) + ":" + i + "9");
                                    }
                                    if (phutup8 == 60) {
                                        phutup8 = 0;
                                        gioup8++;
                                        if (pre.getString("daload14s8", "").length() > 0) {
                                            float fa = (float) gioup8 / 24;
                                            updatepr(fa);
                                        }
                                    }
                                    if (gioup8 == 24) {
                                        gioup8 = 0;
                                        ngayup8++;
                                        if (CLICK_PET == 8) {
                                            int a = ngayup8 + 1;
                                            if (layoutLevel != null)
                                                layoutLevel.removeAllViews();
                                            String str = "" + a;
                                            DrawLevel(str, layoutLevel);
                                        }
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }.start();
        }
        //------
        runnable_timeUpAge = new Runnable() {
            @Override
            public void run() {
                timeUpAge = true;
                giay -= 2;
                if (giay >= 0) {
//                    Log.e("timeUpage ", "" + giay);
                    if (CLICK_PET == 1) {
                        if (gio > 24) {
                            ngay = gio / 24;
                            gio = gio % 24;
                        }
                        txttimesum.setText(ngay + ":" + formatter.format(gio) + ":" +
                                formatter.format(phut) + ":" + formatter.format(giay));
                    }
                    handler.postDelayed(runnable_timeUpAge, 1000);
                    if (giay < 2) {
                        if (phut == 0) {
                            CheckUpAge();
                        } else if (phut > 0) {
                            phut--;
                            giay = 61;
                        }
                    } else if (phut == 0) {
                        if (gio > 0) {
                            phut = 59;
                            gio--;
                        } else if (gio == 0) {
                            if (ngay > 0) {
                                gio = 24;
                                ngay--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge);
                }
            }
        };
        //------
        runnable_UpAge2 = new Runnable() {
            @Override
            public void run() {
                UpAge2 = true;
                giay -= 15;
                if (giay >= 0) {
//                    Log.e("UpAge ", "" + giay);
                    if (CLICK_PET == 1) {
                        if (gio > 24) {
                            ngay = gio / 24;
                            gio = gio % 24;
                        }
                        txttimesum.setText(ngay + ":" + formatter.format(gio) + ":"
                                + formatter.format(phut) + ":" + formatter.format(giay));
                    }
                    handler.postDelayed(runnable_UpAge2, 1000);
                    if (giay < 15) {
                        if (phut == 0) {
                            CheckUpAge();
                        } else if (phut > 0) {
                            phut--;
                            giay = 61;
                        }
                    } else if (phut == 0) {
                        if (gio > 0) {
                            phut = 59;
                            gio--;
                        } else if (gio == 0) {
                            if (ngay > 0) {
                                gio = 24;
                                ngay--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2);
                }
            }
        };
        //------
        runnable_UpAge22 = new Runnable() {
            @Override
            public void run() {
                giay2 -= 15;
                if (giay2 >= 0) {
//                    Log.e("UpAge ", "" + giay2);
                    if (CLICK_PET == 2) {
                        if (gio2 > 24) {
                            ngay2 = gio2 / 24;
                            gio2 = gio2 % 24;
                        }
                        txttimesum.setText(ngay2 + ":" + formatter.format(gio2) + ":"
                                + formatter.format(phut2) + ":" + formatter.format(giay2));
                    }
                    handler.postDelayed(runnable_UpAge22, 1000);
                    if (giay2 < 15) {
                        if (phut2 == 0) {
                            CheckUpage2();
                        } else if (phut2 > 0) {
                            phut2--;
                            giay2 = 61;
                        }
                    } else if (phut2 == 0) {
                        if (gio2 > 0) {
                            phut2 = 59;
                            gio2--;
                        } else if (gio2 == 0) {
                            if (ngay2 > 0) {
                                gio2 = 24;
                                ngay2--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge22);
                }
            }
        };
        //------
        runnable_UpAge23 = new Runnable() {
            @Override
            public void run() {
                giay3 -= 15;
                if (giay3 >= 0) {
                    if (CLICK_PET == 3) {
                        if (gio3 > 24) {
                            ngay3 = gio3 / 24;
                            gio3 = gio3 % 24;
                        }
                        txttimesum.setText(ngay3 + ":" + formatter.format(gio3) +
                                ":" + formatter.format(phut3) + ":" + formatter.format(giay3));
                    }
                    handler.postDelayed(runnable_UpAge23, 1000);
                    if (giay3 < 15) {
                        if (phut3 == 0) {
                            CheckUpage3();
                        } else if (phut3 > 0) {
                            phut3--;
                            giay3 = 61;
                        }
                    } else if (phut3 == 0) {
                        if (gio3 > 0) {
                            phut3 = 59;
                            gio3--;
                        } else if (gio3 == 0) {
                            if (ngay3 > 0) {
                                gio3 = 24;
                                ngay3--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge23);
                }
            }
        };
        //------
        runnable_UpAge24 = new Runnable() {
            @Override
            public void run() {
                giay4 -= 15;
                if (giay4 >= 0) {
                    if (CLICK_PET == 4) {
                        if (gio4 > 24) {
                            ngay4 = gio4 / 24;
                            gio4 = gio4 % 24;
                        }
                        txttimesum.setText(ngay4 + ":" + formatter.format(gio4) + ":"
                                + formatter.format(phut4) + ":" + formatter.format(giay4));
                    }
                    handler.postDelayed(runnable_UpAge24, 1000);
                    if (giay4 < 15) {
                        if (phut4 == 0) {
                            CheckUpage4();
                        } else if (phut4 > 0) {
                            phut4--;
                            giay4 = 61;
                        }
                    } else if (phut4 == 0) {
                        if (gio4 > 0) {
                            phut4 = 59;
                            gio4--;
                        } else if (gio4 == 0) {
                            if (ngay4 > 0) {
                                gio4 = 24;
                                ngay4--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge24);
                }
            }
        };
        //------
        runnable_UpAge25 = new Runnable() {
            @Override
            public void run() {
                giay5 -= 15;
                if (giay5 >= 0) {
                    if (CLICK_PET == 5) {
                        if (gio5 > 24) {
                            ngay5 = gio5 / 24;
                            gio5 = gio5 % 24;
                        }
                        txttimesum.setText(ngay5 + ":" + formatter.format(gio5) + ":"
                                + formatter.format(phut5) + ":" + formatter.format(giay5));
                    }
                    handler.postDelayed(runnable_UpAge25, 1000);
                    if (giay5 < 15) {
                        if (phut5 == 0) {
                            CheckUpage5();
                        } else if (phut5 > 0) {
                            phut5--;
                            giay5 = 61;
                        }
                    } else if (phut5 == 0) {
                        if (gio5 > 0) {
                            phut5 = 59;
                            gio5--;
                        } else if (gio5 == 0) {
                            if (ngay5 > 0) {
                                gio5 = 24;
                                ngay5--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge25);
                }
            }
        };
        //------
        runnable_UpAge26 = new Runnable() {
            @Override
            public void run() {
                giay6 -= 15;
                if (giay6 >= 0) {
                    if (CLICK_PET == 6) {
                        if (gio6 > 24) {
                            ngay6 = gio6 / 24;
                            gio6 = gio6 % 24;
                        }
                        txttimesum.setText(ngay6 + ":" + formatter.format(gio6) + ":"
                                + formatter.format(phut6) + ":" + formatter.format(giay6));
                    }
                    handler.postDelayed(runnable_UpAge26, 1000);
                    if (giay6 < 15) {
                        if (phut6 == 0) {
                            CheckUpage6();
                        } else if (phut6 > 0) {
                            phut6--;
                            giay6 = 61;
                        }
                    } else if (phut6 == 0) {
                        if (gio6 > 0) {
                            phut6 = 59;
                            gio6--;
                        } else if (gio6 == 0) {
                            if (ngay6 > 0) {
                                gio6 = 24;
                                ngay6--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge26);
                }
            }
        };
        //------
        runnable_UpAge27 = new Runnable() {
            @Override
            public void run() {
                giay7 -= 15;
                if (giay7 >= 0) {
                    if (CLICK_PET == 7) {
                        if (gio7 > 24) {
                            ngay7 = gio7 / 24;
                            gio7 = gio7 % 24;
                        }
                        txttimesum.setText(ngay7 + ":" + formatter.format(gio7) + ":"
                                + formatter.format(phut7) + ":" + formatter.format(giay7));
                    }
                    handler.postDelayed(runnable_UpAge27, 1000);
                    if (giay7 < 15) {
                        if (phut7 == 0) {
                            CheckUpage7();
                        } else if (phut7 > 0) {
                            phut7--;
                            giay7 = 61;
                        }
                    } else if (phut7 == 0) {
                        if (gio7 > 0) {
                            phut7 = 59;
                            gio7--;
                        } else if (gio7 == 0) {
                            if (ngay7 > 0) {
                                gio7 = 24;
                                ngay7--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge27);
                }
            }
        };
        //------
        runnable_UpAge28 = new Runnable() {
            @Override
            public void run() {
                giay8 -= 15;
                if (giay8 >= 0) {
                    if (CLICK_PET == 8) {
                        if (gio8 > 24) {
                            ngay8 = gio8 / 24;
                            gio8 = gio8 % 24;
                        }
                        txttimesum.setText(ngay8 + ":" + formatter.format(gio8) + ":" + formatter.format(phut8)
                                + ":" + formatter.format(giay8));
                    }
                    handler.postDelayed(runnable_UpAge28, 1000);
                    if (giay8 < 15) {
                        if (phut8 == 0) {
                            CheckUpage8();
                        } else if (phut8 > 0) {
                            phut8--;
                            giay8 = 61;
                        }
                    } else if (phut8 == 0) {
                        if (gio8 > 0) {
                            phut8 = 59;
                            gio8--;
                        } else if (gio8 == 0) {
                            if (ngay8 > 0) {
                                gio8 = 24;
                                ngay8--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge28);
                }
            }
        };
        //------
        runnable_UpAge2Nho = new Runnable() {
            @Override
            public void run() {
                UpAge2Nho = true;
                giay -= 4;
                if (giay >= 0) {
//                    Log.e("UpAgeNho ", "" + giay);
                    if (CLICK_PET == 1) {
                        if (gio > 24) {
                            ngay = gio / 24;
                            gio = gio % 24;
                        }
                        txttimesum.setText(ngay + ":" + formatter.format(gio)
                                + ":" + formatter.format(phut) + ":" + formatter.format(giay));
                    }
                    handler.postDelayed(runnable_UpAge2Nho, 1000);

                    if (giay < 4) {
                        if (phut == 0) {
                            CheckUpAge();
                        } else if (phut > 0) {
                            phut--;
                            giay = 61;
                        }
                    } else if (phut == 0) {
                        if (gio > 0) {
                            phut = 59;
                            gio--;
                        } else if (gio == 0) {
                            if (ngay > 0) {
                                gio = 24;
                                ngay--;
                            }
                        }
                    }

                } else {
                    handler.post(runnable_UpAge2Nho);
                }
            }
        };
        //------
        runnable_UpAge2Nho2 = new Runnable() {
            @Override
            public void run() {
                giay2 -= 4;
                if (giay2 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay2);
                    if (CLICK_PET == 2) {
                        if (gio2 > 24) {
                            ngay2 = gio2 / 24;
                            gio2 = gio2 % 24;
                        }
                        txttimesum.setText(ngay2 + ":" + formatter.format(gio2) + ":" +
                                formatter.format(phut2) + ":" + formatter.format(giay2));
                    }
                    handler.postDelayed(runnable_UpAge2Nho2, 1000);
                    if (giay2 < 4) {
                        if (phut2 == 0) {
                            CheckUpage2();

                        } else if (phut2 > 0) {
                            phut2--;
                            giay2 = 61;
                        }
                    } else if (phut2 == 0) {
                        if (gio2 > 0) {
                            phut2 = 59;
                            gio2--;
                        } else if (gio2 == 0) {
                            if (ngay2 > 0) {
                                gio2 = 24;
                                ngay2--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho2);
                }
            }
        };
        //------
        runnable_UpAge2Nho3 = new Runnable() {
            @Override
            public void run() {
                giay3 -= 4;
                if (giay3 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay3);
                    if (CLICK_PET == 3) {
                        if (gio3 > 24) {
                            ngay3 = gio3 / 24;
                            gio3 = gio3 % 24;
                        }
                        txttimesum.setText(ngay3 + ":" + formatter.format(gio3)
                                + ":" + formatter.format(phut3) + ":" + formatter.format(giay3));
                    }
                    handler.postDelayed(runnable_UpAge2Nho3, 1000);
                    if (giay3 < 4) {
                        if (phut3 == 0) {
                            CheckUpage3();

                        } else if (phut3 > 0) {
                            phut3--;
                            giay3 = 61;
                        }
                    } else if (phut3 == 0) {
                        if (gio3 > 0) {
                            phut3 = 59;
                            gio3--;
                        } else if (gio3 == 0) {
                            if (ngay3 > 0) {
                                gio3 = 24;
                                ngay3--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho3);
                }
            }
        };
        //------
        runnable_UpAge2Nho4 = new Runnable() {
            @Override
            public void run() {
                giay4 -= 4;
                if (giay4 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay4);
                    if (CLICK_PET == 4) {
                        if (gio4 > 24) {
                            ngay4 = gio4 / 24;
                            gio4 = gio4 % 24;
                        }
                        txttimesum.setText(ngay4 + ":" + formatter.format(gio4)
                                + ":" + formatter.format(phut4) + ":" + formatter.format(giay4));
                    }
                    handler.postDelayed(runnable_UpAge2Nho4, 1000);
                    if (giay4 < 4) {
                        if (phut4 == 0) {
                            CheckUpage4();

                        } else if (phut4 > 0) {
                            phut4--;
                            giay4 = 61;
                        }
                    } else if (phut4 == 0) {
                        if (gio4 > 0) {
                            phut4 = 59;
                            gio4--;
                        } else if (gio4 == 0) {
                            if (ngay4 > 0) {
                                gio4 = 24;
                                ngay4--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho4);
                }
            }
        };
        //------
        runnable_UpAge2Nho5 = new Runnable() {
            @Override
            public void run() {
                giay5 -= 4;
                if (giay5 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay5);
                    if (CLICK_PET == 5) {
                        if (gio5 > 24) {
                            ngay5 = gio5 / 24;
                            gio5 = gio5 % 24;
                        }
                        txttimesum.setText(ngay5 + ":" + formatter.format(gio5)
                                + ":" + formatter.format(phut5) + ":" + formatter.format(giay5));
                    }
                    handler.postDelayed(runnable_UpAge2Nho5, 1000);
                    if (giay5 < 4) {
                        if (phut5 == 0) {
                            CheckUpage5();
                        } else if (phut5 > 0) {
                            phut5--;
                            giay5 = 61;
                        }
                    } else if (phut5 == 0) {
                        if (gio5 > 0) {
                            phut5 = 59;
                            gio5--;
                        } else if (gio5 == 0) {
                            if (ngay5 > 0) {
                                gio5 = 24;
                                ngay5--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho5);
                }
            }
        };
        //------
        runnable_UpAge2Nho6 = new Runnable() {
            @Override
            public void run() {
                giay6 -= 4;
                if (giay6 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay6);
                    if (CLICK_PET == 6) {
                        if (gio6 > 24) {
                            ngay6 = gio6 / 24;
                            gio6 = gio6 % 24;
                        }
                        txttimesum.setText(ngay6 + ":" + formatter.format(gio6)
                                + ":" + formatter.format(phut6) + ":" + formatter.format(giay6));
                    }
                    handler.postDelayed(runnable_UpAge2Nho6, 1000);
                    if (giay6 < 4) {
                        if (phut6 == 0) {
                            CheckUpage6();

                        } else if (phut6 > 0) {
                            phut6--;
                            giay6 = 61;
                        }
                    } else if (phut6 == 0) {
                        if (gio6 > 0) {
                            phut6 = 59;
                            gio6--;
                        } else if (gio6 == 0) {
                            if (ngay6 > 0) {
                                gio6 = 24;
                                ngay6--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho6);
                }
            }
        };
        //------
        runnable_UpAge2Nho7 = new Runnable() {
            @Override
            public void run() {
                giay7 -= 4;
                if (giay7 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay7);
                    if (CLICK_PET == 7) {
                        if (gio7 > 24) {
                            ngay7 = gio7 / 24;
                            gio7 = gio7 % 24;
                        }
                        txttimesum.setText(ngay7 + ":" + formatter.format(gio7)
                                + ":" + formatter.format(phut7) + ":" + formatter.format(giay7));
                    }
                    handler.postDelayed(runnable_UpAge2Nho7, 1000);
                    if (giay7 < 4) {
                        if (phut7 == 0) {
                            CheckUpage7();

                        } else if (phut7 > 0) {
                            phut7--;
                            giay7 = 61;
                        }
                    } else if (phut7 == 0) {
                        if (gio7 > 0) {
                            phut7 = 59;
                            gio7--;
                        } else if (gio7 == 0) {
                            if (ngay7 > 0) {
                                gio7 = 24;
                                ngay7--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho7);
                }
            }
        };
        //------
        runnable_UpAge2Nho8 = new Runnable() {
            @Override
            public void run() {
                giay8 -= 4;
                if (giay8 >= 0) {
//                    Log.e("UpAgeNho ", "" + giay8);
                    if (CLICK_PET == 8) {
                        if (gio8 > 24) {
                            ngay8 = gio8 / 24;
                            gio8 = gio8 % 24;
                        }
                        txttimesum.setText(ngay8 + ":" + formatter.format(gio8)
                                + ":" + formatter.format(phut8) + ":" + formatter.format(giay8));
                    }
                    handler.postDelayed(runnable_UpAge2Nho8, 1000);
                    if (giay8 < 4) {
                        if (phut8 == 0) {
                            CheckUpage8();

                        } else if (phut8 > 0) {
                            phut8--;
                            giay8 = 61;
                        }
                    } else if (phut8 == 0) {
                        if (gio8 > 0) {
                            phut8 = 59;
                            gio8--;
                        } else if (gio8 == 0) {
                            if (ngay8 > 0) {
                                gio8 = 24;
                                ngay8--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_UpAge2Nho8);
                }
            }
        };
        //------
        runnable_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength", 200) * 10;
//            int prolength_sk = 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable_sk, 1000);
                    if (prolength_sk < (int) rankpet1(age) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 1;
                        imgzukan.setVisibility(View.GONE);
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable);
                        handler.removeCallbacks(runnable_action);
                        handler.removeCallbacks(runnable_uong);
                        handler.removeCallbacks(runnable_bb);
                        handler.removeCallbacks(runnable_sk);
                        handler.removeCallbacks(runnable_nha);
                        handler.removeCallbacks(runnable_timeUpAge);
                        handler.removeCallbacks(runnable_UpAge2);
                        handler.removeCallbacks(runnable_UpAge2Nho);
                        handler.removeCallbacks(runnable_sleep);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup + "日");
                                settexttuoichet(age);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 1 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 1)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable_sk);
                }
            }
        };
        //----
        runnable_bb = new Runnable() {
            @Override
            public void run() {
                prolength_bb--;
                progressBar7.setProgress(prolength_bb);
                if (prolength_bb >= 0) {
                    friendly = prolength_bb;
//                    Log.e("bb", "" + prolength_bb);
                    handler.postDelayed(runnable_bb, 1000);
                    if (prolength_bb == 0) {
                        friendly = 0;
                        progressBar7.setProgress(0);
                    }
                    if (dialog_lv.isShowing()) {
                        txtbanbe.setText("" + prolength_bb);
                    }
                } else {
                    handler.post(runnable_bb);
                }
            }
        };
        //----
        runnable_timeUpAge2 = new Runnable() {
            @Override
            public void run() {
                giay2 -= 2;
                if (giay2 >= 0) {
//                    Log.e("timeUpage ", "" + giay2);
                    if (CLICK_PET == 2) {
                        if (gio2 > 24) {
                            ngay2 = gio2 / 24;
                            gio2 = gio2 % 24;
                        }
                        txttimesum.setText(ngay2 + ":" + formatter.format(gio2)
                                + ":" + formatter.format(phut2) + ":" + formatter.format(giay2));
                    }
                    handler.postDelayed(runnable_timeUpAge2, 1000);

                    if (giay2 < 2) {
                        if (phut2 == 0) {
                            CheckUpage2();
                        } else if (phut2 > 0) {
                            phut2--;
                            giay2 = 61;
                        }
                    } else if (phut2 == 0) {
                        if (gio2 > 0) {
                            phut2 = 59;
                            gio2--;
                        } else if (gio2 == 0) {
                            if (ngay2 > 0) {
                                gio2 = 24;
                                ngay2--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge2);
                }
            }
        };
        //----
        runnable_timeUpAge4 = new Runnable() {
            @Override
            public void run() {
                giay4 -= 2;
                if (giay4 >= 0) {
//                    Log.e("timeUpage ", "" + giay4);
                    if (CLICK_PET == 4) {
                        if (gio4 > 24) {
                            ngay4 = gio4 / 24;
                            gio4 = gio4 % 24;
                        }
                        txttimesum.setText(ngay4 + ":" + formatter.format(gio4)
                                + ":" + formatter.format(phut4) + ":" + formatter.format(giay4));
                    }
                    handler.postDelayed(runnable_timeUpAge4, 1000);

                    if (giay4 < 2) {
                        if (phut4 == 0) {
                            CheckUpage4();
                        } else if (phut4 > 0) {
                            phut4--;
                            giay4 = 61;
                        }
                    } else if (phut4 == 0) {
                        if (gio4 > 0) {
                            phut4 = 59;
                            gio4--;
                        } else if (gio4 == 0) {
                            if (ngay4 > 0) {
                                gio4 = 24;
                                ngay4--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge4);
                }
            }
        };
        //----
        runnable_timeUpAge6 = new Runnable() {
            @Override
            public void run() {
                giay6 -= 2;
                if (giay6 >= 0) {
//                    Log.e("timeUpage ", "" + giay6);
                    if (CLICK_PET == 6) {
                        if (gio6 > 24) {
                            ngay6 = gio6 / 24;
                            gio6 = gio6 % 24;
                        }
                        txttimesum.setText(ngay6 + ":" + formatter.format(gio6)
                                + ":" + formatter.format(phut6) + ":" + formatter.format(giay6));
                    }
                    handler.postDelayed(runnable_timeUpAge6, 1000);

                    if (giay6 < 2) {
                        if (phut6 == 0) {
                            CheckUpage6();
                        } else if (phut6 > 0) {
                            phut6--;
                            giay6 = 61;
                        }
                    } else if (phut6 == 0) {
                        if (gio6 > 0) {
                            phut6 = 59;
                            gio6--;
                        } else if (gio6 == 0) {
                            if (ngay6 > 0) {
                                gio6 = 24;
                                ngay6--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge6);
                }
            }
        };
        //----
        runnable_timeUpAge8 = new Runnable() {
            @Override
            public void run() {
                giay8 -= 2;
                if (giay8 >= 0) {
//                    Log.e("timeUpage ", "" + giay8);
                    if (CLICK_PET == 8) {
                        if (gio8 > 24) {
                            ngay8 = gio8 / 24;
                            gio8 = gio8 % 24;
                        }
                        txttimesum.setText(ngay8 + ":" + formatter.format(gio8)
                                + ":" + formatter.format(phut8) + ":" + formatter.format(giay8));
                    }
                    handler.postDelayed(runnable_timeUpAge8, 1000);
                    if (giay8 < 2) {
                        if (phut8 == 0) {
                            CheckUpage8();
                        } else if (phut8 > 0) {
                            phut8--;
                            giay8 = 61;
                        }
                    } else if (phut8 == 0) {
                        if (gio8 > 0) {
                            phut8 = 59;
                            gio8--;
                        } else if (gio8 == 0) {
                            if (ngay8 > 0) {
                                gio8 = 24;
                                ngay8--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge8);
                }
            }
        };
        //----
        runnable_timeUpAge3 = new Runnable() {
            @Override
            public void run() {
                giay3 -= 2;
                if (giay3 >= 0) {
//                    Log.e("timeUpage ", "" + giay3);
                    if (CLICK_PET == 3) {
                        if (gio3 > 24) {
                            ngay3 = gio3 / 24;
                            gio3 = gio3 % 24;
                        }
                        txttimesum.setText(ngay3 + ":" + formatter.format(gio3)
                                + ":" + formatter.format(phut3) + ":" + formatter.format(giay3));
                    }
                    handler.postDelayed(runnable_timeUpAge3, 1000);

                    if (giay3 < 2) {
                        if (phut3 == 0) {
                            CheckUpage3();
                        } else if (phut3 > 0) {
                            phut3--;
                            giay3 = 61;
                        }
                    } else if (phut3 == 0) {
                        if (gio3 > 0) {
                            phut3 = 59;
                            gio3--;
                        } else if (gio3 == 0) {
                            if (ngay3 > 0) {
                                gio3 = 24;
                                ngay3--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge3);
                }
            }
        };
        //----
        runnable_timeUpAge5 = new Runnable() {
            @Override
            public void run() {
                giay5 -= 2;
                if (giay5 >= 0) {
//                    Log.e("timeUpage ", "" + giay5);
                    if (CLICK_PET == 5) {
                        if (gio5 > 24) {
                            ngay5 = gio5 / 24;
                            gio5 = gio5 % 24;
                        }
                        txttimesum.setText(ngay5 + ":" + formatter.format(gio5)
                                + ":" + formatter.format(phut5) + ":" + formatter.format(giay5));
                    }
                    handler.postDelayed(runnable_timeUpAge5, 1000);
                    if (giay5 < 2) {
                        if (phut5 == 0) {
                            CheckUpage5();
                        } else if (phut5 > 0) {
                            phut5--;
                            giay5 = 61;
                        }
                    } else if (phut5 == 0) {
                        if (gio5 > 0) {
                            phut5 = 59;
                            gio5--;
                        } else if (gio5 == 0) {
                            if (ngay5 > 0) {
                                gio5 = 24;
                                ngay5--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge5);
                }
            }
        };
        //----
        runnable_timeUpAge7 = new Runnable() {
            @Override
            public void run() {
                giay7 -= 2;
                if (giay7 >= 0) {
//                    Log.e("timeUpage ", "" + giay7);
                    if (CLICK_PET == 7) {
                        if (gio7 > 24) {
                            ngay7 = gio7 / 24;
                            gio7 = gio7 % 24;
                        }
                        txttimesum.setText(ngay7 + ":" + formatter.format(gio7) + ":" + formatter.format(phut7)
                                + ":" + formatter.format(giay7));
                    }
                    handler.postDelayed(runnable_timeUpAge7, 1000);

                    if (giay7 < 2) {
                        if (phut7 == 0) {
                            CheckUpage7();
                        } else if (phut7 > 0) {
                            phut7--;
                            giay7 = 61;
                        }
                    } else if (phut7 == 0) {
                        if (gio7 > 0) {
                            phut7 = 59;
                            gio7--;
                        } else if (gio7 == 0) {
                            if (ngay7 > 0) {
                                gio7 = 24;
                                ngay7--;
                            }
                        }
                    }
                } else {
                    handler.post(runnable_timeUpAge7);
                }
            }
        };
        //----
        runnable2_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength2", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk2", "" + prolength_sk);
                    handler.postDelayed(runnable2_sk, 1000);
                    if (prolength_sk < (int) rankpet1(age2) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 2;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable2);
                        handler.removeCallbacks(runnable_action2);
                        handler.removeCallbacks(runnable_uong2);
                        handler.removeCallbacks(runnable2_sk);
                        handler.removeCallbacks(runnable_timeUpAge2);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan2", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup2 + "日");
                                settexttuoichet(age2);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 2 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 2) {
                            txttientrien.setText("" + prolength_sk);
                        }
                    }
                } else {
                    handler.post(runnable2_sk);
                }
            }
        };
        //----
        runnable3_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength3", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable3_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet3(age3) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 3;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable3);
                        handler.removeCallbacks(runnable_action3);
                        handler.removeCallbacks(runnable_uong3);
                        handler.removeCallbacks(runnable3_sk);
                        handler.removeCallbacks(runnable_timeUpAge3);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan3", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup3 + "日");
                                settexttuoichet(age3);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 3 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 3)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable3_sk);
                }
            }
        };
        //----
        runnable5_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength5", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable5_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet4(age5) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 5;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable5);
                        handler.removeCallbacks(runnable_action5);
                        handler.removeCallbacks(runnable_uong5);
                        handler.removeCallbacks(runnable5_sk);
                        handler.removeCallbacks(runnable_timeUpAge5);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan5", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup5 + "日");
                                settexttuoichet(age5);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 5 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 5)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable5_sk);
                }
            }
        };
        //----
        runnable7_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength7", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable7_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet7(age7) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 7;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable7);
                        handler.removeCallbacks(runnable_action7);
                        handler.removeCallbacks(runnable_uong7);
                        handler.removeCallbacks(runnable7_sk);
                        handler.removeCallbacks(runnable_timeUpAge7);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan7", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup7 + "日");
                                settexttuoichet(age7);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 7 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 7)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable7_sk);
                }
            }
        };
        //----
        runnable4_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength4", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable4_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet4(age4) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 4;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable4);
                        handler.removeCallbacks(runnable_action4);
                        handler.removeCallbacks(runnable_uong4);
                        handler.removeCallbacks(runnable4_sk);
                        handler.removeCallbacks(runnable_timeUpAge4);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan4", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup4 + "日");
                                settexttuoichet(age4);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 4 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 4) {
                            txttientrien.setText("" + prolength_sk);
                        }
                    }
                } else {
                    handler.post(runnable4_sk);
                }
            }
        };
        //----
        runnable6_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength6", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable6_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet4(age6) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 6;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable6);
                        handler.removeCallbacks(runnable_action6);
                        handler.removeCallbacks(runnable_uong6);
                        handler.removeCallbacks(runnable6_sk);
                        handler.removeCallbacks(runnable_timeUpAge6);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan6", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup6 + "日");
                                settexttuoichet(age6);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 6 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 6)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable6_sk);
                }
            }
        };
        //----
        runnable8_sk = new Runnable() {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            int prolength_sk = pre.getInt("strength8", 200) * 10;

            @Override
            public void run() {
                prolength_sk--;
                progressBar6.setProgress(prolength_sk);
                if (prolength_sk >= 1) {
//                    Log.e("sk", "" + prolength_sk);
                    handler.postDelayed(runnable8_sk, 1000);
                    if (prolength_sk < (int) Chat.rankpet8(age8) * 0.05) {
                        btnstt.setImageResource(R.drawable.p04);
                        txtstt.setImageResource(R.drawable.p04_comment);
                    }
                    if (prolength_sk == 1) {
                        _TRUONGTHANH = 8;
                        progressBar6.setProgress(0);
                        handler.removeCallbacks(runnable8);
                        handler.removeCallbacks(runnable_action8);
                        handler.removeCallbacks(runnable_uong8);
                        handler.removeCallbacks(runnable8_sk);
                        handler.removeCallbacks(runnable_timeUpAge8);
                        try {
                            finish_dialog.show();
                            if (finish_dialog.isShowing()) {
                                textView22.setText("" + pre.getString("tenzukan8", "") + "が死んでしまいました。");
                                txtngaychet.setText("" + ngayup8 + "日");
                                settexttuoichet(age8);
                                ShowFinish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (CLICK_PET == 8 && mPSleep.isPlaying())
                            mPSleep.pause();
                    }
                    if (dialog_lv.isShowing()) {
                        if (CLICK_PET == 8)
                            txttientrien.setText("" + prolength_sk);
                    }
                } else {
                    handler.post(runnable8_sk);
                }
            }
        };
    }

    int prolength_bb;

    Runnable runnable_sk, runnable3_sk, runnable5_sk, runnable7_sk, runnable2_sk,
            runnable4_sk, runnable6_sk, runnable8_sk, runnable_bb,
            runnable_timeUpAge, runnable_UpAge2, runnable_UpAge22, runnable_UpAge23, runnable_UpAge24,
            runnable_UpAge25, runnable_UpAge26, runnable_UpAge27, runnable_UpAge28, runnable_UpAge2Nho, runnable_UpAge2Nho2,
            runnable_UpAge2Nho3, runnable_UpAge2Nho4, runnable_UpAge2Nho5,
            runnable_UpAge2Nho6, runnable_UpAge2Nho7, runnable_UpAge2Nho8, runnable_timeUpAge2, runnable_timeUpAge4,
            runnable_timeUpAge6, runnable_timeUpAge8, runnable_timeUpAge3, runnable_timeUpAge5, runnable_timeUpAge7;

    public void iconEnable() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getString("tenzukan", "").length() > 0)
            btnicon.setEnabled(true);
        if (pre.getString("tenzukan2", "").length() > 0)
            btnicon2.setEnabled(true);
        if (pre.getString("tenzukan3", "").length() > 0)
            btnicon3.setEnabled(true);
        if (pre.getString("tenzukan4", "").length() > 0)
            btnicon4.setEnabled(true);
        if (pre.getString("tenzukan5", "").length() > 0)
            btnicon5.setEnabled(true);
        if (pre.getString("tenzukan6", "").length() > 0)
            btnicon6.setEnabled(true);
        if (pre.getString("tenzukan7", "").length() > 0)
            btnicon7.setEnabled(true);
        if (pre.getString("tenzukan8", "").length() > 0)
            btnicon8.setEnabled(true);
    }

    public void iconDisable() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getString("tenzukan", "").length() > 0)
            btnicon.setEnabled(false);
        if (pre.getString("tenzukan2", "").length() > 0)
            btnicon2.setEnabled(false);
        if (pre.getString("tenzukan3", "").length() > 0)
            btnicon3.setEnabled(false);
        if (pre.getString("tenzukan4", "").length() > 0)
            btnicon4.setEnabled(false);
        if (pre.getString("tenzukan5", "").length() > 0)
            btnicon5.setEnabled(false);
        if (pre.getString("tenzukan6", "").length() > 0)
            btnicon6.setEnabled(false);
        if (pre.getString("tenzukan7", "").length() > 0)
            btnicon7.setEnabled(false);
        if (pre.getString("tenzukan8", "").length() > 0)
            btnicon8.setEnabled(false);
    }

    public void _ButtonDisable() {
        btnfood.setEnabled(false);
        btndrink.setEnabled(false);
        btnitem.setEnabled(false);
        btntam.setEnabled(false);
        btnquetnha.setEnabled(false);
    }

    public void _ButtonEnable() {
        btnfood.setEnabled(true);
        btndrink.setEnabled(true);
        btnitem.setEnabled(true);
        btntam.setEnabled(true);
        btnquetnha.setEnabled(true);
    }

    dbHandler db2;

    DataStt stt = new DataStt();
    List<DataStt> listDataStt;
    List<TablePart> _listTablePart;
    ImageView imgupdown;
    boolean updown = false;
    DecimalFormat formatter;
    Animation animTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zukan_layout);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        handler = new Handler();
        animTranslate = AnimationUtils.loadAnimation(this,
                R.anim.alpha);
        RestoreTime();
        formatter = new DecimalFormat("00");
        if (strength <= 0)
            strength = new Random().nextInt(100) + 200;
        if (strength2 <= 0)
            strength2 = new Random().nextInt(100) + 200;
        if (strength3 <= 0)
            strength3 = new Random().nextInt(100) + 300;
        if (strength4 <= 0)
            strength4 = new Random().nextInt(100) + 300;
        if (strength5 <= 0)
            strength5 = new Random().nextInt(100) + 300;
        if (strength6 <= 0)
            strength6 = new Random().nextInt(100) + 300;
        if (strength7 <= 0)
            strength7 = new Random().nextInt(100) + 300;
        if (strength8 <= 0)
            strength8 = new Random().nextInt(100) + 300;
        _StartLoad14s();

        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        indicator = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator1);
        indicator.setForegroundColor(Color.parseColor("#ebbd36"));
        indicator.setBackgroundColor(Color.parseColor("#000000"));
        indicator.setPieStyle(true);
        //
        arrpet = new ArrayList<Integer>();
        createBeetleWithKind();
        db2 = new dbHandler(this);
        listDataStt = db2.getAllDataStt();
        _listTablePart = db2.getAllPart();

        soundbg = MediaPlayer.create(this, R.raw.bgm005);
        soundbg.setLooping(true);
        mPEffect = MediaPlayer.create(this, R.raw.se001);
        mPDrink = MediaPlayer.create(this, R.raw.se003);
        mPEat = MediaPlayer.create(this, R.raw.se002);
        mPShower = MediaPlayer.create(this, R.raw.se004);
        mPTouchZukan = MediaPlayer.create(this, R.raw.se005);
        mPTouchZukan2 = MediaPlayer.create(this, R.raw.se014);
        mPCleaning = MediaPlayer.create(this, R.raw.se006);
        mPKhatNuoc = MediaPlayer.create(this, R.raw.se008);
        kSEDefecation = MediaPlayer.create(this, R.raw.se009);
        mPSleep = MediaPlayer.create(this, R.raw.se010);
        mPDeath = MediaPlayer.create(this, R.raw.se013);
        mPClick = MediaPlayer.create(this, R.raw.se065);
        //slide up , down, f , r
        detector = new SimpleGestureFilter(this, this);
        //
        lnlevel = (FrameLayout) findViewById(R.id.lnlevel);
        layoutOver = (FrameLayout) findViewById(R.id.layoutOver);
        layoutUnder = (FrameLayout) findViewById(R.id.layoutUnder);
        frimgbutterfly = (FrameLayout) findViewById(R.id.frimgbutterfly);
        frworm = (FrameLayout) findViewById(R.id.frworm);
        frpill = (FrameLayout) findViewById(R.id.frpill);
        frcloud = (FrameLayout) findViewById(R.id.frcloud);

        fritm_runpa1 = (FrameLayout) findViewById(R.id.fritm_runpa1);
        fritm_runpa2 = (FrameLayout) findViewById(R.id.fritm_runpa2);
        fritm_runpa3 = (FrameLayout) findViewById(R.id.fritm_runpa3);
        fritm_runpa4 = (FrameLayout) findViewById(R.id.fritm_runpa4);
        fritm_runpa5 = (FrameLayout) findViewById(R.id.fritm_runpa5);
        fritm_runpa6 = (FrameLayout) findViewById(R.id.fritm_runpa6);
        fritm_runpa7 = (FrameLayout) findViewById(R.id.fritm_runpa7);
        fritm_runpa8 = (FrameLayout) findViewById(R.id.fritm_runpa8);

        txtlv = (TextView) findViewById(R.id.txtlv);
        bglayout = (FrameLayout) findViewById(R.id.bglayout);
        bglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
//                Log.e("TAG", "Click");
            }
        });
        frcolor = (FrameLayout) findViewById(R.id.frcolor);
        lnmsg = (RelativeLayout) findViewById(R.id.lnmsg);
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        imgzukan = (ImageView) findViewById(R.id.imgzukan);
        imgzukan2 = (ImageView) findViewById(R.id.imgzukan2);
        imgzukan3 = (ImageView) findViewById(R.id.imgzukan3);
        imgzukan4 = (ImageView) findViewById(R.id.imgzukan4);
        imgzukan5 = (ImageView) findViewById(R.id.imgzukan5);
        imgzukan6 = (ImageView) findViewById(R.id.imgzukan6);
        imgzukan7 = (ImageView) findViewById(R.id.imgzukan7);
        imgzukan8 = (ImageView) findViewById(R.id.imgzukan8);
        imgzukan.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgzukan8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgbutterfly = (ImageView) findViewById(R.id.imgbutterfly);
        itm_runpa1 = (ImageView) findViewById(R.id.itm_runpa1);
        itm_runpa2 = (ImageView) findViewById(R.id.itm_runpa2);
        itm_runpa3 = (ImageView) findViewById(R.id.itm_runpa3);
        itm_runpa4 = (ImageView) findViewById(R.id.itm_runpa4);
        itm_runpa5 = (ImageView) findViewById(R.id.itm_runpa5);
        itm_runpa6 = (ImageView) findViewById(R.id.itm_runpa6);
        itm_runpa7 = (ImageView) findViewById(R.id.itm_runpa7);
        itm_runpa8 = (ImageView) findViewById(R.id.itm_runpa8);
        imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animtoi = new TranslateAnimation(0, xX, 0, yY);
        animtoi.setDuration(50000);
        animtoi.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imgbutterfly.getLayoutParams();
                params.topMargin += yY;
                params.leftMargin += xX;
                imgbutterfly.clearAnimation();
                imgbutterfly.setLayoutParams(params);
                imgbutterfly.setLayerType(View.LAYER_TYPE_NONE, null);
                imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                frameAnimation.stop();
                imgbutterfly.setBackgroundResource(R.drawable.animation_butterflylui);
                frameAnimation2 = (AnimationDrawable) imgbutterfly.getBackground();
                frameAnimation2.start();
                imgbutterfly.startAnimation(animlui);
            }
        });
        //
        animlui = new TranslateAnimation(0, -xX, 0, -yY);
        animlui.setDuration(50000);
        animlui.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imgbutterfly.getLayoutParams();
                params.topMargin -= yY;
                params.leftMargin -= xX;
                imgbutterfly.clearAnimation();
                imgbutterfly.setLayoutParams(params);
                imgbutterfly.setLayerType(View.LAYER_TYPE_NONE, null);
                imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                frameAnimation2.stop();
                imgbutterfly.setBackgroundResource(R.drawable.animation_butterfly);
                frameAnimation = (AnimationDrawable) imgbutterfly.getBackground();
                frameAnimation.start();
                xX = new Random().nextInt(400) + 350;
                yY = new Random().nextInt(400) + 250;
                imgbutterfly.startAnimation(animtoi);
            }
        });
        //
        imgbutterfly.setBackgroundResource(R.drawable.animation_butterfly);
        frameAnimation = (AnimationDrawable) imgbutterfly.getBackground();
        frameAnimation.start();
        imgbutterfly.startAnimation(animtoi);
        ribbon1 = (ImageView) findViewById(R.id.ribbon1);
        ribbon2 = (ImageView) findViewById(R.id.ribbon2);
        ribbon3 = (ImageView) findViewById(R.id.ribbon3);
        ribbon4 = (ImageView) findViewById(R.id.ribbon4);
        worm = (ImageView) findViewById(R.id.worm);
        pill = (ImageView) findViewById(R.id.pill);
        clay1 = (ImageView) findViewById(R.id.clay1);
        clay2 = (ImageView) findViewById(R.id.clay2);
        imgcloud1 = (ImageView) findViewById(R.id.imgcloud1);
        imgcloud2 = (ImageView) findViewById(R.id.imgcloud2);
        imgcloud3 = (ImageView) findViewById(R.id.imgcloud3);
        imgcloud1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgcloud2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgcloud3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animclould1 = new TranslateAnimation(0, 0, 0, 100);
        animclould1.setDuration(50000);
        animclould1.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgcloud1.setLayerType(View.LAYER_TYPE_NONE, null);
                imgcloud1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animation.setRepeatCount(TranslateAnimation.INFINITE);
            }
        });
        imgcloud1.startAnimation(animclould1);
        //
        animclould2 = new TranslateAnimation(0, 0, 0, -180);
        animclould2.setDuration(50000);
        animclould2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgcloud2.setLayerType(View.LAYER_TYPE_NONE, null);
                imgcloud2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animation.setRepeatCount(TranslateAnimation.INFINITE);
            }
        });
        imgcloud2.startAnimation(animclould2);
        //
        animclould3 = new TranslateAnimation(0, 0, 0, -200);
        animclould3.setDuration(50000);
        animclould3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgcloud3.setLayerType(View.LAYER_TYPE_NONE, null);
                imgcloud3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animation.setRepeatCount(TranslateAnimation.INFINITE);
            }
        });
        imgcloud3.startAnimation(animclould3);
        //
        ribbon1.setBackgroundResource(R.drawable.animation_ribbon1);
        animribbon1 = (AnimationDrawable) ribbon1.getBackground();
        animribbon1.start();
        ribbon2.setBackgroundResource(R.drawable.animation_ribbon2);
        animribbon2 = (AnimationDrawable) ribbon2.getBackground();
        animribbon2.start();
        ribbon3.setBackgroundResource(R.drawable.animation_ribbon3);
        animribbon3 = (AnimationDrawable) ribbon3.getBackground();
        animribbon3.start();
        ribbon4.setBackgroundResource(R.drawable.animation_ribbon4);
        animribbon4 = (AnimationDrawable) ribbon4.getBackground();
        animribbon4.start();
        //
        clay1.setBackgroundResource(R.drawable.animation_clay1);
        animclay = (AnimationDrawable) clay1.getBackground();
        animclay.start();
        clay2.setBackgroundResource(R.drawable.animation_clay2);
        animclay2 = (AnimationDrawable) clay2.getBackground();
        animclay2.start();
        //
        worm.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        worm.setBackgroundResource(R.drawable.animation_worm);
        animworm = (AnimationDrawable) worm.getBackground();
        animworm.start();
        anim_worm = new TranslateAnimation(0, -100, 0, 0);
        anim_worm.setDuration(50000);
        anim_worm.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) worm.getLayoutParams();
                params.topMargin -= 0;
                params.leftMargin -= 100;
                worm.clearAnimation();
                worm.setLayoutParams(params);
                worm.setLayerType(View.LAYER_TYPE_NONE, null);
                worm.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animworm.stop();
                worm.setBackgroundResource(R.drawable.animation_wormlui);
                animwormlui = (AnimationDrawable) worm.getBackground();
                animwormlui.start();
                worm.startAnimation(anim_wormlui);
            }
        });
        worm.startAnimation(anim_worm);
        anim_wormlui = new TranslateAnimation(0, 100, 0, 0);
        anim_wormlui.setDuration(50000);
        anim_wormlui.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) worm.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 100;
                worm.clearAnimation();
                worm.setLayoutParams(params);
                worm.setLayerType(View.LAYER_TYPE_NONE, null);
                worm.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animwormlui.stop();
                worm.setBackgroundResource(R.drawable.animation_worm);
                animworm = (AnimationDrawable) worm.getBackground();
                animworm.start();
                worm.startAnimation(anim_worm);
            }
        });
        //
        pill.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        pill.setBackgroundResource(R.drawable.animation_pill);
        animpill = (AnimationDrawable) pill.getBackground();
        animpill.start();
        anim_pill = new TranslateAnimation(0, 200, 0, 0);
        anim_pill.setDuration(50000);
        anim_pill.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) pill.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 200;
                pill.clearAnimation();
                pill.setLayoutParams(params);
                pill.setLayerType(View.LAYER_TYPE_NONE, null);
                pill.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animpill.stop();
                pill.setBackgroundResource(R.drawable.animation_pilllui);
                animpilllui = (AnimationDrawable) pill.getBackground();
                animpilllui.start();
                pill.startAnimation(anim_pilllui);
            }
        });
        pill.startAnimation(anim_pill);
        anim_pilllui = new TranslateAnimation(0, -200, 0, 0);
        anim_pilllui.setDuration(50000);
        anim_pilllui.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) pill.getLayoutParams();
                params.topMargin -= 0;
                params.leftMargin -= 200;
                pill.clearAnimation();
                pill.setLayoutParams(params);
                pill.setLayerType(View.LAYER_TYPE_NONE, null);
                pill.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                animpilllui.stop();
                pill.setBackgroundResource(R.drawable.animation_pill);
                animpill = (AnimationDrawable) pill.getBackground();
                animpill.start();
                pill.startAnimation(anim_pill);
            }
        });
        //
        imgpre = (ImageView) findViewById(R.id.imgpre);
        imgnext = (ImageView) findViewById(R.id.imgnext);
        textView25 = (TextView) findViewById(R.id.textView25);
        _tenzukan = (TextView) findViewById(R.id.txtnamezukan);
        txttruongthanh = (TextView) findViewById(R.id.txttruongthanh);
        t1 = (TextView) findViewById(R.id.t1);
        btndaitien = (TextView) findViewById(R.id.btndaitien);
        t14 = (TextView) findViewById(R.id.t14);
        t15 = (TextView) findViewById(R.id.t15);
        t16 = (TextView) findViewById(R.id.t16);
        t19 = (TextView) findViewById(R.id.t19);
        tfl1 = (TextView) findViewById(R.id.tfl1);
        tfl2 = (TextView) findViewById(R.id.tfl2);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t17 = (TextView) findViewById(R.id.t17);
        t18 = (TextView) findViewById(R.id.button18);
        t20 = (TextView) findViewById(R.id.button20);
        t22 = (TextView) findViewById(R.id.button22);
        t4 = (LinearLayout) findViewById(R.id.t4);
        t9 = (TextView) findViewById(R.id.t9);
        t11 = (LinearLayout) findViewById(R.id.t11);
        layoutLevel = (LinearLayout) findViewById(R.id.layoutLevel);
        khatnuoc2 = (TextView) findViewById(R.id.khatnuoc2);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        //
        progressBar6 = (ProgressBar) findViewById(R.id.progressBar6);
        progressBar7 = (ProgressBar) findViewById(R.id.progressBar7);
        //
        progressBar32 = (ProgressBar) findViewById(R.id.progressBar32);
        progressBar33 = (ProgressBar) findViewById(R.id.progressBar33);
        progressBar34 = (ProgressBar) findViewById(R.id.progressBar34);
        progressBar35 = (ProgressBar) findViewById(R.id.progressBar35);
        progressBar36 = (ProgressBar) findViewById(R.id.progressBar36);
        progressBar37 = (ProgressBar) findViewById(R.id.progressBar37);
        progressBar38 = (ProgressBar) findViewById(R.id.progressBar38);

        progressBar3.setMax(rankpet1(age));
        progressBar32.setMax(rankpet1(age2));
        progressBar33.setMax(Chat.rankpet3(age3));
        progressBar34.setMax(Chat.rankpet4(age4));
        progressBar35.setMax(Chat.rankpet4(age5));
        progressBar36.setMax(Chat.rankpet4(age6));
        progressBar37.setMax(rankpet1(age7));
        progressBar38.setMax(Chat.rankpet8(age8));
        progressBar3.setProgress(prolength);
        progressBar32.setProgress(prolength2);
        progressBar33.setProgress(prolength3);
        progressBar34.setProgress(prolength4);
        progressBar35.setProgress(prolength5);
        progressBar36.setProgress(prolength6);
        progressBar37.setProgress(prolength7);
        progressBar38.setProgress(prolength8);
        //
        for (int i = 0; i < listDataStt.size(); i++) {
            arrpet.add(listDataStt.get(i).getContent());
            final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            if (listDataStt.get(0).getContent() == 1) {
                CLICK_PET = 1;
                if (pre.getString("daload14s", "").length() > 0) {
                    float fa = (float) gioup / 24;
                    updatepr(fa);
                }
                int a = ngayup + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan", ""));
                textView25.setText("カブトムシ");
                progressBar3.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 2) {
                CLICK_PET = 2;
                if (pre.getString("daload14s2", "").length() > 0) {
                    float fa = (float) gioup2 / 24;
                    updatepr(fa);
                }
                imgzukan2.setVisibility(View.VISIBLE);
                int a = ngayup2 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                _tenzukan.setText("" + pre.getString("tenzukan2", ""));
                textView25.setText("コクワガタ");
                progressBar32.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 3) {
                CLICK_PET = 3;
                if (pre.getString("daload14s3", "").length() > 0) {
                    float fa = (float) gioup3 / 24;
                    updatepr(fa);
                }
                int a = ngayup3 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan3.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan3", ""));
                textView25.setText("コーカサスオオカブト");
                progressBar33.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 4) {
                CLICK_PET = 4;
                if (pre.getString("daload14s4", "").length() > 0) {
                    float fa = (float) gioup4 / 24;
                    updatepr(fa);
                }
                int a = ngayup4 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan4.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan4", ""));
                textView25.setText("オオクワガタ");
                progressBar34.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 5) {
                CLICK_PET = 5;
                if (pre.getString("daload14s5", "").length() > 0) {
                    float fa = (float) gioup5 / 24;
                    updatepr(fa);
                }
                int a = ngayup5 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan5.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan5", ""));
                textView25.setText("サタンオオカブト");
                progressBar35.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 6) {
                CLICK_PET = 6;
                if (pre.getString("daload14s6", "").length() > 0) {
                    float fa = (float) gioup6 / 24;
                    updatepr(fa);
                }
                int a = ngayup6 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan6.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan6", ""));
                textView25.setText("ギラファノコギリクワガタ");
                progressBar36.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 7) {
                CLICK_PET = 7;
                if (pre.getString("daload14s7", "").length() > 0) {
                    float fa = (float) gioup7 / 24;
                    updatepr(fa);
                }
                int a = ngayup7 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan7.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan7", ""));
                textView25.setText("オウゴンオニクワガタ");
                progressBar37.setVisibility(View.VISIBLE);
            }
            if (listDataStt.get(0).getContent() == 8) {
                CLICK_PET = 8;
                if (pre.getString("daload14s8", "").length() > 0) {
                    float fa = (float) gioup8 / 24;
                    updatepr(fa);
                }
                int a = ngayup8 + 1;
                if (layoutLevel != null)
                    layoutLevel.removeAllViews();
                String str = "" + a;
                DrawLevel(str, layoutLevel);
                imgzukan8.setVisibility(View.VISIBLE);
                _tenzukan.setText("" + pre.getString("tenzukan8", ""));
                textView25.setText("ヘラクレスオオカブト");
                progressBar38.setVisibility(View.VISIBLE);
            }
            int size_dp = (int) Chat.convertDpToPixel(35);
            FrameLayout.LayoutParams paramsbtn = new
                    FrameLayout.LayoutParams(size_dp, size_dp);
            paramsbtn.gravity = Gravity.CENTER | Gravity.RIGHT;
            if (listDataStt.get(i).getContent() == 1) {
                btnicon = new Button(this);
                if (CLICK_PET != 1)
                    btnicon.setVisibility(View.GONE);
                btnicon.setLayoutParams(paramsbtn);
                lnlevel.addView(btnicon);
                btnicon.setBackgroundColor(Color.parseColor("#00000000"));
            }
            if (listDataStt.get(i).getContent() == 2) {
                btnicon2 = new Button(this);
                if (CLICK_PET != 2)
                    btnicon2.setVisibility(View.GONE);
                btnicon2.setLayoutParams(paramsbtn);
                btnicon2.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon2);
            }
            if (listDataStt.get(i).getContent() == 3) {
                btnicon3 = new Button(this);
                if (CLICK_PET != 3)
                    btnicon3.setVisibility(View.GONE);
                btnicon3.setLayoutParams(paramsbtn);
                btnicon3.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon3);
            }
            if (listDataStt.get(i).getContent() == 4) {
                btnicon4 = new Button(this);
                if (CLICK_PET != 4)
                    btnicon4.setVisibility(View.GONE);
                btnicon4.setLayoutParams(paramsbtn);
                btnicon4.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon4);
            }
            if (listDataStt.get(i).getContent() == 5) {
                btnicon5 = new Button(this);
                if (CLICK_PET != 5)
                    btnicon5.setVisibility(View.GONE);
                btnicon5.setLayoutParams(paramsbtn);
                btnicon5.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon5);
            }
            if (listDataStt.get(i).getContent() == 6) {
                btnicon6 = new Button(this);
                if (CLICK_PET != 6)
                    btnicon6.setVisibility(View.GONE);
                btnicon6.setLayoutParams(paramsbtn);
                btnicon6.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon6);
            }
            if (listDataStt.get(i).getContent() == 7) {
                btnicon7 = new Button(this);
                if (CLICK_PET != 7)
                    btnicon7.setVisibility(View.GONE);
                btnicon7.setLayoutParams(paramsbtn);
                btnicon7.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon7);
            }
            if (listDataStt.get(i).getContent() == 8) {
                btnicon8 = new Button(this);
                if (CLICK_PET != 8)
                    btnicon8.setVisibility(View.GONE);
                btnicon8.setLayoutParams(paramsbtn);
                btnicon8.setBackgroundColor(Color.parseColor("#00000000"));
                lnlevel.addView(btnicon8);
            }
        }
        btnstt = (ImageView) findViewById(R.id.btnstt);
        btnstt.setImageResource(R.drawable.p02);
        txtstt = (ImageView) findViewById(R.id.txtstt);
        txtstt.setImageResource(R.drawable.p02_comment);
        activeitem = (TextView) findViewById(R.id.activeitem);

        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        _name = pre.getString("tenzukan", "");
        _name2 = pre.getString("tenzukan2", "");
        _name3 = pre.getString("tenzukan3", "");
        _name4 = pre.getString("tenzukan4", "");
        _name5 = pre.getString("tenzukan5", "");
        _name6 = pre.getString("tenzukan6", "");
        _name7 = pre.getString("tenzukan7", "");
        _name8 = pre.getString("tenzukan8", "");
        //
        btnfood = (ImageView) findViewById(R.id.btnfood);
        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
                if (CLICK_PET == 1) {
                    if (atomicBoolean == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean == false) {
                        if (age < 4) {
                            if (prolength > rankpet1(age) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength <= rankpet1(age) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 2) {
                    if (atomicBoolean2 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean2 == false) {
                        if (age2 < 4) {
                            if (prolength2 > rankpet1(age2) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength2 <= rankpet1(age2) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age2 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 3) {
                    if (atomicBoolean3 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean3 == false) {
                        if (age3 < 4) {
                            if (prolength3 > Chat.rankpet3(age3) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength3 <= Chat.rankpet3(age3) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age3 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 4) {
                    if (atomicBoolean4 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean4 == false) {
                        if (age4 < 4) {
                            if (prolength4 > Chat.rankpet4(age4) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength4 <= Chat.rankpet4(age4) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age4 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 5) {
                    if (atomicBoolean5 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean5 == false) {
                        if (age5 < 4) {
                            if (prolength5 > Chat.rankpet4(age5) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength5 <= Chat.rankpet4(age5) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age5 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 6) {
                    if (atomicBoolean6 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean6 == false) {
                        if (age6 < 4) {
                            if (prolength6 > Chat.rankpet4(age6) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength6 <= Chat.rankpet4(age6) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age6 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 7) {
                    if (atomicBoolean7 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean7 == false) {
                        if (age7 < 4) {
                            if (prolength7 > Chat.rankpet7(age7) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength7 <= Chat.rankpet7(age7) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age7 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 8) {
                    if (atomicBoolean8 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean8 == false) {
                        if (age8 < 4) {
                            if (prolength8 > Chat.rankpet8(age8) * 0.7) {
                                lnmsg.setBackgroundResource(R.drawable.balloon1);
                                txtmsg.setVisibility(View.VISIBLE);
                                txtmsg.setText("お腹がいっぱいだよ。");
                                new CountDownTimer(3000, 1000) {

                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                        txtmsg.setVisibility(View.GONE);
                                    }
                                }.start();
                            }
                            if (prolength8 <= Chat.rankpet8(age8) * 0.7)
                                KichItemKhiFalseFood();
                        } else if (age8 > 4)
                            noikhi4tuoi();
                    }
                }
            }
        });
        btndrink = (ImageView) findViewById(R.id.btndrink);
        btndrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
                if (CLICK_PET == 1) {
                    if (atomicBoolean == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean == false) {
                        if (age < 4)
                            KichItemKhiFlaseDrink();
                        else if (age > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 2) {
                    if (atomicBoolean2 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean2 == false) {
                        if (age2 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age2 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 3) {
                    if (atomicBoolean3 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean3 == false) {
                        if (age3 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age3 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 4) {
                    if (atomicBoolean4 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean4 == false) {
                        if (age4 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age4 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 5) {
                    if (atomicBoolean5 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean5 == false) {
                        if (age5 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age5 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 6) {
                    if (atomicBoolean6 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean6 == false) {
                        if (age6 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age6 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 7) {
                    if (atomicBoolean7 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean7 == false) {
                        if (age7 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age7 > 4)
                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 8) {
                    if (atomicBoolean8 == true)
                        KichItemKhiConTrung();
                    if (atomicBoolean8 == false) {
                        if (age8 < 4)
                            KichItemKhiFlaseDrink();
                        else if (age8 > 4)
                            noikhi4tuoi();
                    }
                }
            }
        });
        btnitem = (ImageView) findViewById(R.id.btnitem);
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
                if (CLICK_PET == 1) {
                    if (atomicBoolean == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean == false) {
//                        if (age < 4)
                        KichItemKhiFalseItem();
//                        else if (age > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 2) {
                    if (atomicBoolean2 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean2 == false) {
//                        if (age2 < 4)
                        KichItemKhiFalseItem();
//                        else if (age2 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 3) {
                    if (atomicBoolean3 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean3 == false) {
//                        if (age3 < 4)
                        KichItemKhiFalseItem();
//                        else if (age3 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 4) {
                    if (atomicBoolean4 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean4 == false) {
//                        if (age4 < 4)
                        KichItemKhiFalseItem();
//                        else if (age4 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 5) {
                    if (atomicBoolean5 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean5 == false) {
//                        if (age5 < 4)
                        KichItemKhiFalseItem();
//                        else if (age5 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 6) {
                    if (atomicBoolean6 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean6 == false) {
//                        if (age6 < 4)
                        KichItemKhiFalseItem();
//                        else if (age6 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 7) {
                    if (atomicBoolean7 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean7 == false) {
//                        if (age7 < 4)
                        KichItemKhiFalseItem();
//                        else if (age7 > 4)
//                            noikhi4tuoi();
                    }
                }
                if (CLICK_PET == 8) {
                    if (atomicBoolean8 == true)
                        KichItemKhiConTrung();
                    else if (atomicBoolean8 == false) {
//                        if (age8 < 4)
                        KichItemKhiFalseItem();
//                        else if (age8 > 4)
//                            noikhi4tuoi();
                    }
                }
            }
        });
        //
        txtnuoc = (TextView) findViewById(R.id.txtnuoc);
        txtnuoc2 = (TextView) findViewById(R.id.txtnuoc2);
        txtnuoc3 = (TextView) findViewById(R.id.txtnuoc3);
        txtnuoc4 = (TextView) findViewById(R.id.txtnuoc4);
        txtnuoc5 = (TextView) findViewById(R.id.txtnuoc5);
        txtnuoc6 = (TextView) findViewById(R.id.txtnuoc6);
        txtnuoc7 = (TextView) findViewById(R.id.txtnuoc7);
        txtnuoc8 = (TextView) findViewById(R.id.txtnuoc8);
        txtan = (TextView) findViewById(R.id.txtan);
        txtan2 = (TextView) findViewById(R.id.txtan2);
        txtan3 = (TextView) findViewById(R.id.txtan3);
        txtan4 = (TextView) findViewById(R.id.txtan4);
        txtan5 = (TextView) findViewById(R.id.txtan5);
        txtan6 = (TextView) findViewById(R.id.txtan6);
        txtan7 = (TextView) findViewById(R.id.txtan7);
        txtan8 = (TextView) findViewById(R.id.txtan8);

        btntam = (ImageView) findViewById(R.id.btntam);
        btntam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
                if (mypage.theluc < 1) {
                    CheckTheLuc();
                    return;
                }
                if (mypage.theluc >= 1)
                    mypage.theluc--;
                if (CLICK_PET == 1) {
                    if (atomicBoolean == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean == false) {
                        if (age >= 4) {
                            noikhi4tuoi();
                        } else if (age < 4) {
                            _ButtonDisable();
                            _nuoc(age, swipe, sleeping, txtnuoc, imgzukan, runnable_action, runnable_sleep);
                            exp += 1;
                            friendly += 10;
                            if (friendly >= 800)
                                friendly = 800;
                            prolength_nha -= 100;
                            if (prolength_nha <= 1)
                                prolength_nha = 1;
                            prolength_uong += 80;
                            if (prolength_uong >= rankpet1(age))
                                prolength_uong = rankpet1(age);
                            mood += 200;
                            if (mood >= 800)
                                mood = 800;
                            health += 100;
                            if (health >= 800)
                                health = 800;
                        }
                    }
                }
                if (CLICK_PET == 2) {
                    if (atomicBoolean2 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean2 == false) {
                        if (age2 >= 4) {
                            noikhi4tuoi();
                        } else if (age2 < 4) {
                            _ButtonDisable();
                            _nuoc2(age2, swipe2, sleeping2, txtnuoc2, imgzukan2, runnable_action2, runnable_sleep2);
                            exp += 1;
                            friendly2 += 10;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                            prolength_nha2 -= 100;
                            if (prolength_nha2 <= 1)
                                prolength_nha2 = 1;
                            prolength_uong2 += 80;
                            if (prolength_uong2 >= rankpet1(age2))
                                prolength_uong2 = rankpet1(age2);
                            mood2 += 200;
                            if (mood2 >= 800)
                                mood2 = 800;
                            health2 += 100;
                            if (health2 >= 800)
                                health2 = 800;
                        }
                    }
                }
                if (CLICK_PET == 3) {
                    if (atomicBoolean3 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean3 == false) {
                        if (age3 >= 4) {
                            noikhi4tuoi();
                        } else if (age3 < 4) {
                            _ButtonDisable();
                            _nuoc(age3, swipe3, sleeping3, txtnuoc3, imgzukan3, runnable_action3, runnable_sleep3);
                            exp += 1;
                            friendly3 += 10;
                            if (friendly3 >= 1000)
                                friendly3 = 1000;
                            prolength_nha3 -= 100;
                            if (prolength_nha3 <= 1)
                                prolength_nha3 = 1;
                            prolength_uong3 += 80;
                            if (prolength_uong3 >= Chat.rankpet3(age3))
                                prolength_uong3 = Chat.rankpet3(age3);
                            mood3 += 200;
                            if (mood3 >= 1000)
                                mood3 = 1000;
                            health3 += 100;
                            if (health3 >= 1000)
                                health3 = 1000;
                        }
                    }
                }
                if (CLICK_PET == 4) {
                    if (atomicBoolean4 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean4 == false) {
                        if (age4 >= 4) {
                            noikhi4tuoi();
                        } else if (age4 < 4) {
                            _ButtonDisable();
                            _nuoc2(age4, swipe4, sleeping4, txtnuoc4, imgzukan4, runnable_action4, runnable_sleep4);
                            exp += 1;
                            friendly4 += 10;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                            prolength_nha4 -= 100;
                            if (prolength_nha4 <= 1)
                                prolength_nha4 = 1;
                            prolength_uong4 += 80;
                            if (prolength_uong4 >= Chat.rankpet4(age4))
                                prolength_uong4 = Chat.rankpet4(age4);
                            mood4 += 200;
                            if (mood4 >= 2000)
                                mood4 = 2000;
                            health4 += 100;
                            if (health4 >= 2000)
                                health4 = 2000;
                        }
                    }
                }
                if (CLICK_PET == 5) {
                    if (atomicBoolean5 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean5 == false) {
                        if (age5 >= 4) {
                            noikhi4tuoi();
                        } else if (age5 < 4) {
                            _ButtonDisable();
                            _nuoc(age5, swipe5, sleeping5, txtnuoc5, imgzukan5, runnable_action5, runnable_sleep5);
                            exp += 1;
                            friendly5 += 10;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                            prolength_nha5 -= 100;
                            if (prolength_nha5 <= 1)
                                prolength_nha5 = 1;
                            prolength_uong5 += 80;
                            if (prolength_uong5 >= Chat.rankpet4(age5))
                                prolength_uong5 = Chat.rankpet4(age5);
                            mood5 += 200;
                            if (mood5 >= 2000)
                                mood5 = 2000;
                            health5 += 100;
                            if (health5 >= 2000)
                                health5 = 2000;
                        }
                    }
                }
                if (CLICK_PET == 6) {
                    if (atomicBoolean6 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean6 == false) {
                        if (age6 >= 4) {
                            noikhi4tuoi();
                        } else if (age6 < 4) {
                            _ButtonDisable();
                            _nuoc2(age6, swipe6, sleeping6, txtnuoc6, imgzukan6, runnable_action6, runnable_sleep6);
                            exp += 1;
                            friendly6 += 10;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                            prolength_nha6 -= 100;
                            if (prolength_nha6 <= 1)
                                prolength_nha6 = 1;
                            prolength_uong6 += 80;
                            if (prolength_uong6 >= Chat.rankpet4(age6))
                                prolength_uong6 = Chat.rankpet4(age6);
                            mood6 += 200;
                            if (mood6 >= 2000)
                                mood6 = 2000;
                            health6 += 100;
                            if (health6 >= 2000)
                                health6 = 2000;
                        }
                    }
                }
                if (CLICK_PET == 7) {
                    if (atomicBoolean7 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean7 == false) {
                        if (age7 >= 4) {
                            noikhi4tuoi();
                        } else if (age7 < 4) {
                            _ButtonDisable();
                            _nuoc2(age7, swipe7, sleeping7, txtnuoc7, imgzukan7, runnable_action7, runnable_sleep7);
                            exp += 1;
                            friendly7 += 10;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                            prolength_nha7 -= 100;
                            if (prolength_nha7 <= 1)
                                prolength_nha7 = 1;
                            prolength_uong7 += 80;
                            if (prolength_uong7 >= Chat.rankpet7(age7))
                                prolength_uong7 = Chat.rankpet7(age7);
                            mood7 += 200;
                            if (mood7 >= 1500)
                                mood7 = 1500;
                            health7 += 100;
                            if (health7 >= 1500)
                                health7 = 1500;
                        }
                    }
                }
                if (CLICK_PET == 8) {
                    if (atomicBoolean8 == true) {
                        KichItemKhiConTrung();
                    } else if (atomicBoolean8 == false) {
                        if (age8 >= 4) {
                            noikhi4tuoi();
                        } else if (age8 < 4) {
                            _ButtonDisable();
                            _nuoc(age8, swipe8, sleeping8, txtnuoc8, imgzukan8, runnable_action8, runnable_sleep8);
                            exp += 1;
                            friendly8 += 10;
                            if (friendly8 >= 3000)
                                friendly8 = 3000;
                            prolength_nha8 -= 100;
                            if (prolength_nha8 <= 1)
                                prolength_nha8 = 1;
                            prolength_uong8 += 80;
                            if (prolength_uong8 >= Chat.rankpet8(age8))
                                prolength_uong8 = Chat.rankpet8(age8);
                            mood8 += 200;
                            if (mood8 >= 3000)
                                mood8 = 3000;
                            health8 += 100;
                            if (health8 >= 3000)
                                health8 = 3000;
                        }
                    }
                }
            }
        });
        //
        btnquetnha = (ImageView) findViewById(R.id.btnquetnha);
        btnquetnha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (pwindo != null && pwindo.isShowing())
                    pwindo.dismiss();
                if (CLICK_PET == 1) {
                    if (age >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 2) {
                    if (age2 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 3) {
                    if (age3 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 4) {
                    if (age4 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 5) {
                    if (age5 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 6) {
                    if (age6 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 7) {
                    if (age7 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
                if (CLICK_PET == 8) {
                    if (age8 >= 4) {
                        noikhi4tuoi();
                    } else {
                        if (_CLEAN == 0) {
                            _actionClean();
                        } else {
                            setClean();
                        }
                    }
                }
            }
        });
        //
        lnlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _SoundClick();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String id = pre.getString("id", "");
                String id2 = pre.getString("id2", "");
                String id3 = pre.getString("id3", "");
                String id4 = pre.getString("id4", "");
                String id5 = pre.getString("id5", "");
                String id6 = pre.getString("id6", "");
                String id7 = pre.getString("id7", "");
                String id8 = pre.getString("id8", "");
                dialog_lv.show();
                if (CLICK_PET == 1) {
                    if (pre.getString("daload14s", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo(friendly, id, strength, age, pre.getString("daload14s", ""));
                    if (prolength < 10)
                        txtno.setText("空腹");
                    if (prolength_uong < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep, 800);
                } else if (CLICK_PET == 2) {
                    if (pre.getString("daload14s2", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo2(friendly2, strength2, id2, age2, pre.getString("daload14s2", ""));
                    if (prolength2 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong2 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep2, 800);
                } else if (CLICK_PET == 3) {
                    if (pre.getString("daload14s3", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo(friendly3, id3, strength3, age3, pre.getString("daload14s3", ""));
                    if (prolength3 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong3 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep3, 1000);
                } else if (CLICK_PET == 4) {
                    if (pre.getString("daload14s4", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo2(friendly4, strength4, id4, age4, pre.getString("daload14s4", ""));
                    if (prolength4 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong4 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep4, 2000);
                } else if (CLICK_PET == 5) {
                    if (pre.getString("daload14s5", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo(friendly5, id5, strength5, age5, pre.getString("daload14s5", ""));
                    if (prolength5 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong5 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep5, 2000);
                } else if (CLICK_PET == 6) {
                    if (pre.getString("daload14s6", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo2(friendly6, strength6, id6, age6, pre.getString("daload14s6", ""));
                    if (prolength6 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong6 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep6, 2000);
                } else if (CLICK_PET == 7) {
                    if (pre.getString("daload14s7", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo2(friendly7, strength7, id7, age7, pre.getString("daload14s7", ""));
                    if (prolength7 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong7 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep7, 1500);
                } else if (CLICK_PET == 8) {
                    if (pre.getString("daload14s8", "").length() == 0)
                        setsttfor0age();
                    settextfordialoginfo(friendly8, id8, strength8, age8, pre.getString("daload14s8", ""));
                    if (prolength8 < 10)
                        txtno.setText("空腹");
                    if (prolength_uong8 < 10)
                        txtkhatnuoc.setText("水分不足");
                    settextforsleep(prolength_sleep8, 3000);
                }
                int a = 10 * Integer.parseInt(txtsucmanh.getText().toString());
                txttientrien.setText("" + a);
                editten.setText("" + _tenzukan.getText().toString());
                txtloai.setText("" + textView25.getText().toString());
            }
        });
        imgzukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan(age, imgzukan, sleeping, atomicBoolean);
                friendly++;
                if (friendly > 800)
                    friendly = 800;
            }
        });
        imgzukan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan2(age2, imgzukan2, sleeping2, atomicBoolean2);
                friendly2++;
                if (friendly2 > 800)
                    friendly2 = 800;
            }
        });
        imgzukan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan(age3, imgzukan3, sleeping3, atomicBoolean3);
                friendly3++;
                if (friendly3 > 1000)
                    friendly3 = 1000;
            }
        });
        imgzukan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan2(age4, imgzukan4, sleeping4, atomicBoolean4);
                friendly4++;
                if (friendly4 > 2000)
                    friendly4 = 2000;
            }
        });
        imgzukan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan(age5, imgzukan5, sleeping5, atomicBoolean5);
                friendly5++;
                if (friendly5 > 2000)
                    friendly5 = 2000;
            }
        });
        imgzukan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan2(age6, imgzukan6, sleeping6, atomicBoolean6);
                friendly6++;
                if (friendly6 > 2000)
                    friendly6 = 2000;
            }
        });
        imgzukan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan2(age7, imgzukan7, sleeping7, atomicBoolean7);
                friendly7++;
                if (friendly7 > 1500)
                    friendly7 = 1500;
            }
        });
        imgzukan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toumultizukan(age8, imgzukan8, sleeping8, atomicBoolean8);
                friendly8++;
                if (friendly8 > 3000)
                    friendly8 = 3000;
            }
        });
        btn19 = (ImageView) findViewById(R.id.button19);
        btn19.setImageResource(R.drawable.temperature_p10);
        btnplus = (ImageView) findViewById(R.id.btnplus);
        btnminus = (ImageView) findViewById(R.id.btnminus);
        btnminus.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
//                v.startAnimation(mypage.animScale);
                try {
                    if (CLICK_PET == 1) {
                        temp--;
                        if (temp < 3)
                            temp = 3;
                        settempminus(temp);
                    } else if (CLICK_PET == 2) {
                        temp2--;
                        if (temp2 < 3)
                            temp2 = 3;
                        settempminus(temp2);
                    } else if (CLICK_PET == 3) {
                        temp3--;
                        if (temp3 < 3)
                            temp3 = 3;
                        settempminus(temp3);
                    } else if (CLICK_PET == 4) {
                        temp4--;
                        if (temp4 < 3)
                            temp4 = 3;
                        settempminus(temp4);
                    } else if (CLICK_PET == 5) {
                        temp5--;
                        if (temp5 < 3)
                            temp5 = 3;
                        settempminus(temp5);
                    } else if (CLICK_PET == 6) {
                        temp6--;
                        if (temp6 < 3)
                            temp6 = 3;
                        settempminus(temp6);
                    } else if (CLICK_PET == 7) {
                        temp7--;
                        if (temp7 < 3)
                            temp7 = 3;
                        settempminus(temp7);
                    } else if (CLICK_PET == 8) {
                        temp8--;
                        if (temp8 < 3)
                            temp8 = 3;
                        settempminus(temp8);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
//                v.startAnimation(mypage.animScale);
                try {
                    if (CLICK_PET == 1) {
                        temp++;
                        settempminus(temp);
                        if (temp > 11)
                            temp = 11;
                    } else if (CLICK_PET == 2) {
                        temp2++;
                        settempminus(temp2);
                        if (temp2 > 11)
                            temp2 = 11;
                    } else if (CLICK_PET == 3) {
                        temp3++;
                        settempminus(temp3);
                        if (temp3 > 11)
                            temp3 = 11;
                    } else if (CLICK_PET == 4) {
                        temp4++;
                        settempminus(temp4);
                        if (temp4 > 11)
                            temp4 = 11;
                    } else if (CLICK_PET == 5) {
                        temp5++;
                        settempminus(temp5);
                        if (temp5 > 11)
                            temp5 = 11;
                    } else if (CLICK_PET == 6) {
                        temp6++;
                        settempminus(temp6);
                        if (temp6 > 11)
                            temp6 = 11;
                    } else if (CLICK_PET == 7) {
                        temp7++;
                        settempminus(temp7);
                        if (temp7 > 11)
                            temp7 = 11;
                    } else if (CLICK_PET == 8) {
                        temp8++;
                        settempminus(temp8);
                        if (temp8 > 11)
                            temp8 = 11;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //
        btnBack = (ImageView) findViewById(R.id.imageView14);
        btnBack.setImageResource(R.drawable.zukanbtn_mypage);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                BackToMyPage();
            }
        });
        imgupdown = (ImageView) findViewById(R.id.imgupdown);
        imgupdown.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(zukan_main.this, R.anim.trans_left_in);
                animation.setDuration(400);
                imgupdown.setAnimation(animation);
                imgupdown.animate();
                animation.start();
                if (updown == false) {
                    setdataup();
                } else if (updown == true) {
                    setdatadown();
                }
            }
        });
        SetAnimForPet();
        final int max = arrpet.size() - 1;
//        Toast.makeText(getApplicationContext(),"max:"+max,Toast.LENGTH_SHORT).show();
        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                bglayout.startAnimation(animTranslate);
                if (_jump >= 0)
                    _jump--;
                if (_jump < 0)
                    _jump = max;
                CLICK_PET = arrpet.get(_jump);
                ShowIconClick(CLICK_PET);
                setSizeName();
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                bglayout.startAnimation(animTranslate);
                if (_jump <= max)
                    _jump++;
                if (_jump > max)
                    _jump = 0;
                CLICK_PET = arrpet.get(_jump);
                ShowIconClick(CLICK_PET);
                setSizeName();
            }
        });
        setSizeName();
        if (CLICK_PET == 1)
            Chat.ShowRunpa(swipe, runpaStartTime, fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 2)
            Chat.ShowRunpa(swipe2, runpaStartTime2, fritm_runpa2, fritm_runpa1, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 3)
            Chat.ShowRunpa(swipe3, runpaStartTime3, fritm_runpa3, fritm_runpa2, fritm_runpa1,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 4)
            Chat.ShowRunpa(swipe4, runpaStartTime4, fritm_runpa4, fritm_runpa2, fritm_runpa3,
                    fritm_runpa1, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 5)
            Chat.ShowRunpa(swipe5, runpaStartTime5, fritm_runpa5, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa1, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 6)
            Chat.ShowRunpa(swipe6, runpaStartTime6, fritm_runpa6, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa1, fritm_runpa7, fritm_runpa8);
        else if (CLICK_PET == 7)
            Chat.ShowRunpa(swipe7, runpaStartTime7, fritm_runpa7, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa1, fritm_runpa8);
        else if (CLICK_PET == 8)
            Chat.ShowRunpa(swipe8, runpaStartTime8, fritm_runpa8, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa1);
        handler.post(run_leaf);
//        if (sleeping = true)
//            Log.e("TAG", "true");
    }

    public void ShowIconClick(int click) {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (click == 1) {
            ShowIcon(btnicon, btnicon2, btnicon3, btnicon4, btnicon5, btnicon6, btnicon7, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s", "").length() > 0) {
                float fa = (float) gioup / 24;
                updatepr(fa);
            }
            int a = ngayup + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan, imgzukan2, imgzukan3, imgzukan4, imgzukan5, imgzukan6, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe, runpaStartTime, fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
            setstttruongthanh(age);
            _tenzukan.setText("" + _name);
            textView25.setText("カブトムシ");
            Chat.ShowProgressbar(progressBar3, progressBar32, progressBar33, progressBar34,
                    progressBar35, progressBar36, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s", ""), age, sleeping, prolength_nha, swipe, 800);
            int _i = pre.getInt("useitem", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping == false) {
                _ButtonEnable();
                imgzukan.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s", "").length() > 0)
                    handler.post(runnable_action);
            }
            if (sleeping == true)
                _ButtonDisable();
            if (sleeping == true && age >= 3)
                _ButtonEnable();
            settemp(swipe, sleeping, imgzukan, temp);
            getAgeForBG();
            if (prolength_nha < 100 || prolength < 200 || prolength_uong < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood > 400) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 2) {
            ShowIcon(btnicon2, btnicon, btnicon3, btnicon4, btnicon5, btnicon6, btnicon7, btnicon8,
                    pre.getString("tenzukan", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s2", "").length() > 0) {
                float fa = (float) gioup2 / 24;
                updatepr(fa);
            }
            int a = ngayup2 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan2, imgzukan, imgzukan3, imgzukan4, imgzukan5, imgzukan6, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe2, runpaStartTime2, fritm_runpa2, fritm_runpa1, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
            setstttruongthanh(age2);
            _tenzukan.setText("" + _name2);
            textView25.setText("コクワガタ");
            Chat.ShowProgressbar(progressBar32, progressBar3, progressBar33, progressBar34,
                    progressBar35, progressBar36, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s2", ""), age2, sleeping2, prolength_nha2, swipe2, 800);
            int _i = pre.getInt("useitem2", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping2 == false) {
                imgzukan2.setVisibility(View.VISIBLE);
                _ButtonEnable();
                if (pre.getString("daload14s2", "").length() > 0)
                    handler.post(runnable_action2);
            }
            if (sleeping2 == true)
                _ButtonDisable();
            if (sleeping2 == true && age2 >= 3)
                _ButtonEnable();
            settemp(swipe2, sleeping2, imgzukan2, temp2);
            getAgeForBG();
            if (prolength_nha2 < 100 || prolength2 < 200 || prolength_uong2 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood2 > 400) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 3) {
            ShowIcon(btnicon3, btnicon2, btnicon, btnicon4, btnicon5, btnicon6, btnicon7, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s3", "").length() > 0) {
                float fa = (float) gioup3 / 24;
                updatepr(fa);
            }
            int a = ngayup3 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan3, imgzukan2, imgzukan, imgzukan4, imgzukan5, imgzukan6, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe3, runpaStartTime3, fritm_runpa3, fritm_runpa2, fritm_runpa1,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
            setstttruongthanh(age3);
            _tenzukan.setText("" + _name3);
            textView25.setText("コーカサスオオカブト");
            Chat.ShowProgressbar(progressBar33, progressBar32, progressBar3, progressBar34,
                    progressBar35, progressBar36, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s3", ""), age3, sleeping3, prolength_nha3, swipe3, 1000);
            int _i = pre.getInt("useitem3", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping3 == false) {
                _ButtonEnable();
                imgzukan3.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s3", "").length() > 0)
                    handler.post(runnable_action3);
            }
            if (sleeping3 == true)
                _ButtonDisable();
            if (sleeping3 == true && age3 >= 3)
                _ButtonEnable();
            settemp(swipe3, sleeping3, imgzukan3, temp3);
            getAgeForBG();
            if (prolength_nha3 < 100 || prolength3 < 200 || prolength_uong3 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood3 > 500) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 4) {
            ShowIcon(btnicon4, btnicon2, btnicon3, btnicon, btnicon5, btnicon6, btnicon7, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s4", "").length() > 0) {
                float fa = (float) gioup4 / 24;
                updatepr(fa);
            }
            int a = ngayup4 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan4, imgzukan2, imgzukan3, imgzukan, imgzukan5, imgzukan6, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe4, runpaStartTime4, fritm_runpa4, fritm_runpa2, fritm_runpa3,
                    fritm_runpa1, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
            setstttruongthanh(age4);
            _tenzukan.setText("" + _name4);
            textView25.setText("オオクワガタ");
            Chat.ShowProgressbar(progressBar34, progressBar32, progressBar33, progressBar3,
                    progressBar35, progressBar36, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s4", ""), age4, sleeping4, prolength_nha4, swipe4, 2000);
            int _i = pre.getInt("useitem4", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping4 == false) {
                _ButtonEnable();
                imgzukan4.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s4", "").length() > 0)
                    handler.post(runnable_action4);
            }
            if (sleeping4 == true)
                _ButtonDisable();
            if (sleeping4 == true && age4 >= 3)
                _ButtonEnable();
            settemp(swipe4, sleeping4, imgzukan4, temp4);
            getAgeForBG();
            if (prolength_nha4 < 100 || prolength4 < 200 || prolength_uong4 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood4 > 1000) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 5) {
            ShowIcon(btnicon5, btnicon2, btnicon3, btnicon4, btnicon, btnicon6, btnicon7, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s5", "").length() > 0) {
                float fa = (float) gioup5 / 24;
                updatepr(fa);
            }
            int a = ngayup5 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan5, imgzukan2, imgzukan3, imgzukan4, imgzukan, imgzukan6, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe5, runpaStartTime5, fritm_runpa5, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa1, fritm_runpa6, fritm_runpa7, fritm_runpa8);
            setstttruongthanh(age5);
            _tenzukan.setText("" + _name5);
            textView25.setText("サタンオオカブト");
            Chat.ShowProgressbar(progressBar35, progressBar32, progressBar33, progressBar34,
                    progressBar3, progressBar36, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s5", ""), age5, sleeping5, prolength_nha5, swipe5, 2000);
            int _i = pre.getInt("useitem5", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping5 == false) {
                _ButtonEnable();
                imgzukan5.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s5", "").length() > 0)
                    handler.post(runnable_action5);
            }
            if (sleeping5 == true)
                _ButtonDisable();
            if (sleeping5 == true && age5 >= 3)
                _ButtonEnable();
            settemp(swipe5, sleeping5, imgzukan5, temp5);
            getAgeForBG();
            if (prolength_nha5 < 100 || prolength5 < 200 || prolength_uong5 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood5 > 1000) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 6) {
            ShowIcon(btnicon6, btnicon2, btnicon3, btnicon4, btnicon5, btnicon, btnicon7, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s6", "").length() > 0) {
                float fa = (float) gioup6 / 24;
                updatepr(fa);
            }
            int a = ngayup6 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            Chat.ShowImageZukan(imgzukan6, imgzukan2, imgzukan3, imgzukan4, imgzukan5, imgzukan, imgzukan7, imgzukan8);
            Chat.ShowRunpa(swipe6, runpaStartTime6, fritm_runpa6, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa1, fritm_runpa7, fritm_runpa8);

            setstttruongthanh(age6);
            _tenzukan.setText("" + _name6);
            textView25.setText("ギラファノコギリクワガタ");
            stopaction();
            Chat.ShowProgressbar(progressBar36, progressBar32, progressBar33, progressBar34,
                    progressBar35, progressBar3, progressBar37, progressBar38);
            setnhakhikich(pre.getString("daload14s6", ""), age6, sleeping6, prolength_nha6, swipe6, 2000);
            int _i = pre.getInt("useitem6", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping6 == false) {
                _ButtonEnable();
                imgzukan6.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s6", "").length() > 0)
                    handler.post(runnable_action6);
            }
            if (sleeping6 == true)
                _ButtonDisable();
            if (sleeping6 == true && age6 >= 3)
                _ButtonEnable();
            settemp(swipe6, sleeping6, imgzukan6, temp6);
            getAgeForBG();
            if (prolength_nha6 < 100 || prolength6 < 200 || prolength_uong6 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood6 > 1000) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 7) {
            ShowIcon(btnicon7, btnicon2, btnicon3, btnicon4, btnicon5, btnicon6, btnicon, btnicon8,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan", ""), pre.getString("tenzukan8", ""));
            if (pre.getString("daload14s7", "").length() > 0) {
                float fa = (float) gioup7 / 24;
                updatepr(fa);
            }
            int a = ngayup7 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            Chat.ShowImageZukan(imgzukan7, imgzukan2, imgzukan3, imgzukan4, imgzukan5, imgzukan6, imgzukan, imgzukan8);
            Chat.ShowRunpa(swipe7, runpaStartTime7, fritm_runpa7, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa1, fritm_runpa8);

            setstttruongthanh(age7);
            _tenzukan.setText("" + _name7);
            textView25.setText("オウゴンオニクワガタ");
            stopaction();
            Chat.ShowProgressbar(progressBar37, progressBar32, progressBar33, progressBar34,
                    progressBar35, progressBar36, progressBar3, progressBar38);
            setnhakhikich(pre.getString("daload14s7", ""), age7, sleeping7, prolength_nha7, swipe7, 1500);
            int _i = pre.getInt("useitem7", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping7 == false) {
                _ButtonEnable();
                imgzukan7.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s7", "").length() > 0)
                    handler.post(runnable_action7);
            }
            if (sleeping7 == true)
                _ButtonDisable();
            if (sleeping7 == true && age7 >= 3)
                _ButtonEnable();
            settemp(swipe7, sleeping7, imgzukan7, temp7);
            getAgeForBG();
            if (prolength_nha7 < 100 || prolength7 < 200 || prolength_uong7 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood7 > 750) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
        if (click == 8) {
            ShowIcon(btnicon8, btnicon2, btnicon3, btnicon4, btnicon5, btnicon6, btnicon7, btnicon,
                    pre.getString("tenzukan2", ""), pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                    pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""), pre.getString("tenzukan7", ""), pre.getString("tenzukan", ""));
            if (pre.getString("daload14s8", "").length() > 0) {
                float fa = (float) gioup8 / 24;
                updatepr(fa);
            }
            int a = ngayup8 + 1;
//            txtlv.setText("" + a);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String str = "" + a;
            DrawLevel(str, layoutLevel);
            stopaction();
            Chat.ShowImageZukan(imgzukan8, imgzukan2, imgzukan3, imgzukan4, imgzukan5, imgzukan6, imgzukan7, imgzukan);
            Chat.ShowRunpa(swipe8, runpaStartTime8, fritm_runpa8, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa1);
            setstttruongthanh(age8);
            _tenzukan.setText("" + _name8);
            textView25.setText("ヘラクレスオオカブト");
            Chat.ShowProgressbar(progressBar38, progressBar32, progressBar33, progressBar34,
                    progressBar35, progressBar36, progressBar37, progressBar3);
            setnhakhikich(pre.getString("daload14s8", ""), age8, sleeping8, prolength_nha8, swipe8, 3000);
            int _i = pre.getInt("useitem8", 0);
            Chat.settextItem(_i, activeitem);
            if (sleeping8 == false) {
                _ButtonEnable();
                imgzukan8.setVisibility(View.VISIBLE);
                if (pre.getString("daload14s8", "").length() > 0)
                    handler.post(runnable_action8);
            }
            if (sleeping8 == true)
                _ButtonDisable();
            if (sleeping8 == true && age8 >= 3)
                _ButtonEnable();
            settemp(swipe8, sleeping8, imgzukan8, temp8);
            getAgeForBG();
            if (prolength_nha8 < 100 || prolength8 < 200 || prolength_uong8 < 200) {
                btnstt.setImageResource(R.drawable.p03);
                txtstt.setImageResource(R.drawable.p04_comment);
            } else if (mood8 > 1500) {
                btnstt.setImageResource(R.drawable.p01);
                txtstt.setImageResource(R.drawable.p01_comment);
            }
        }
    }

    public void ShowIcon(Button btnicon, Button btnicon2, Button btnicon3, Button btnicon4, Button btnicon5,
                         Button btnicon6, Button btnicon7, Button btnicon8, String s1, String s2, String s3,
                         String s4, String s5, String s6, String s7) {
        btnicon.setVisibility(View.VISIBLE);
        if (s1.length() > 0)
            btnicon2.setVisibility(View.GONE);
        if (s2.length() > 0)
            btnicon3.setVisibility(View.GONE);
        if (s3.length() > 0)
            btnicon4.setVisibility(View.GONE);
        if (s4.length() > 0)
            btnicon5.setVisibility(View.GONE);
        if (s5.length() > 0)
            btnicon6.setVisibility(View.GONE);
        if (s6.length() > 0)
            btnicon7.setVisibility(View.GONE);
        if (s7.length() > 0)
            btnicon8.setVisibility(View.GONE);
    }

    int _jump = 0;

    public void SaveData() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (_TRUONGTHANH != 1)
            if (pre.getString("tenzukan", "").length() > 0) {
                int phaseETime = ngayup * 24 * 60 * 60 + gioup * 60 * 60 + phutup * 60;
                int phaseTime = ngay * 24 * 60 * 60 + gio * 60 * 60 + phut * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan", ""), "カブトムシ", "" + life, "loai1", 0, 0, age,
                        friendly, pre.getInt("mat1", 0), 1, 1, 1, 1, 1, 1, 1, personality,
                        tieutien, prolength, prolength_sleep, phaseETime, strength, pre.getLong("bornTime", 1443158537),
                        daitien, form, phaseTime, size, prolength_uong, health, mood, prolength_nha, lastCleanTime, pre.getString("id", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
            }
        if (_TRUONGTHANH != 3)
            if (pre.getString("tenzukan3", "").length() > 0) {
                int phaseETime = ngayup3 * 24 * 60 * 60 + gioup3 * 60 * 60 + phutup3 * 60;
                int phaseTime = ngay3 * 24 * 60 * 60 + gio3 * 60 * 60 + phut3 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan3", ""), "コーカサスオオカブト", "" + life3, "loai3", 0, 0, age3,
                        friendly3, pre.getInt("mat3", 0), 1, 1, 1, 1, 1, 1, 1, personality3,
                        tieutien3, prolength3, prolength_sleep3, phaseETime, strength3, pre.getLong("bornTime3", 1443158537),
                        daitien3, form3, phaseTime, size3, prolength_uong3, health3, mood3, prolength_nha3, lastCleanTime3, pre.getString("id3", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime3);
            }
        if (_TRUONGTHANH != 5)
            if (pre.getString("tenzukan5", "").length() > 0) {
                int phaseETime = ngayup5 * 24 * 60 * 60 + gioup5 * 60 * 60 + phutup5 * 60;
                int phaseTime = ngay5 * 24 * 60 * 60 + gio5 * 60 * 60 + phut5 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan5", ""), "サタンオオカブト", "" + life5, "loai5", 0, 0, age5,
                        friendly5, pre.getInt("mat5", 0), 1, 1, 1, 1, 1, 1, 1, personality5,
                        tieutien5, prolength5, prolength_sleep5, phaseETime, strength5, pre.getLong("bornTime5", 1443158537),
                        daitien5, form5, phaseTime, size5, prolength_uong5, health5, mood5, prolength_nha5, lastCleanTime5, pre.getString("id5", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime5);
            }
        if (_TRUONGTHANH != 7)
            if (pre.getString("tenzukan7", "").length() > 0) {
                int phaseETime = ngayup7 * 24 * 60 * 60 + gioup7 * 60 * 60 + phutup7 * 60;
                int phaseTime = ngay7 * 24 * 60 * 60 + gio7 * 60 * 60 + phut7 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan7", ""), "オウゴンオニクワガタ", "" + life7, "loai7", 0, 0, age7,
                        friendly7, pre.getInt("mat7", 0), 1, 1, 1, 1, 1, 1, 1, personality7,
                        tieutien7, prolength7, prolength_sleep7, phaseETime, strength7, pre.getLong("bornTime7", 1443158537),
                        daitien7, form7, phaseTime, size7, prolength_uong7, health7, mood7, prolength_nha7, lastCleanTime7, pre.getString("id7", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime7);
            }
        if (_TRUONGTHANH != 2)
            if (pre.getString("tenzukan2", "").length() > 0) {
                int phaseETime = ngayup2 * 24 * 60 * 60 + gioup2 * 60 * 60 + phutup2 * 60;
                int phaseTime = ngay2 * 24 * 60 * 60 + gio2 * 60 * 60 + phut2 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan2", ""), "コクワガタ", "" + life2, "loai2", 0, 0, age2,
                        friendly2, pre.getInt("mat2", 0), 1, 1, 1, 1, 1, 1, 1, personality2,
                        tieutien2, prolength2, prolength_sleep2, phaseETime, strength2, pre.getLong("bornTime2", 1443158537),
                        daitien2, form2, phaseTime, size2, prolength_uong2, health2, mood2, prolength_nha2, lastCleanTime2, pre.getString("id2", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime2);
            }
        if (_TRUONGTHANH != 4)
            if (pre.getString("tenzukan4", "").length() > 0) {
                int phaseETime = ngayup4 * 24 * 60 * 60 + gioup4 * 60 * 60 + phutup4 * 60;
                int phaseTime = ngay4 * 24 * 60 * 60 + gio4 * 60 * 60 + phut4 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan4", ""), "オオクワガタ", "" + life4, "loai4", 0, 0, age4,
                        friendly4, pre.getInt("mat4", 0), 1, 1, 1, 1, 1, 1, 1, personality4,
                        tieutien4, prolength4, prolength_sleep4, phaseETime, strength4, pre.getLong("bornTime4", 1443158537),
                        daitien4, form4, phaseTime, size4, prolength_uong4, health4, mood4, prolength_nha4, lastCleanTime4, pre.getString("id4", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime4);
            }
        if (_TRUONGTHANH != 6)
            if (pre.getString("tenzukan6", "").length() > 0) {
                int phaseETime = ngayup6 * 24 * 60 * 60 + gioup6 * 60 * 60 + phutup6 * 60;
                int phaseTime = ngay6 * 24 * 60 * 60 + gio6 * 60 * 60 + phut6 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan6", ""), "ギラファノコギリクワガタ", "" + life6, "loai6", 0, 0, age6,
                        friendly6, pre.getInt("mat6", 0), 1, 1, 1, 1, 1, 1, 1, personality6,
                        tieutien6, prolength6, prolength_sleep6, phaseETime, strength6, pre.getLong("bornTime6", 1443158537),
                        daitien6, form6, phaseTime, size6, prolength_uong6, health6, mood6, prolength_nha6, lastCleanTime6, pre.getString("id6", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime6);
            }
        if (_TRUONGTHANH != 8)
            if (pre.getString("tenzukan8", "").length() > 0) {
                int phaseETime = ngayup8 * 24 * 60 * 60 + gioup8 * 60 * 60 + phutup8 * 60;
                int phaseTime = ngay8 * 24 * 60 * 60 + gio8 * 60 * 60 + phut8 * 60;
                db2.adddata(getApplicationContext(), pre.getString("tenzukan8", ""), "ヘラクレスオオカブト", "" + life8, "loai8", 0, 0, age8,
                        friendly8, pre.getInt("mat8", 0), 1, 1, 1, 1, 1, 1, 1, personality8,
                        tieutien8, prolength8, prolength_sleep8, phaseETime, strength8, pre.getLong("bornTime8", 1443158537),
                        daitien8, form8, phaseTime, size8, prolength_uong8, health8, mood8, prolength_nha8, lastCleanTime8, pre.getString("id8", ""),
                        0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime8);
            }
        editor.putInt("_COUNTUONG", prolength_uong);
        editor.putInt("_COUNTAN", prolength);
        editor.putInt("_COUNTNHA", prolength_nha);
        editor.putFloat("age", age);
        editor.putInt("sleep", prolength_sleep);
//        editor.putInt("sleep", 1);
        editor.putInt("ngay", ngay);
        editor.putInt("gio", gio);
        editor.putInt("phut", phut);
//        editor.putInt("giay", giay);
        editor.putInt("gioup", gioup);
        editor.putInt("phutup", phutup);
        editor.putInt("ngayup", ngayup);
        editor.putInt("strength", strength);
        editor.putInt("friendly", friendly);
        editor.putInt("exp", exp);
        editor.putInt("health", health);
        editor.putInt("mood", mood);
        editor.putInt("theluc", mypage.theluc);

        //---
        editor.putInt("_COUNTUONG2", prolength_uong2);
        editor.putInt("_COUNTAN2", prolength2);
        editor.putInt("_COUNTNHA2", prolength_nha2);
        editor.putFloat("age2", age2);
        editor.putInt("strength2", strength2);
        editor.putInt("ngay2", ngay2);
        editor.putInt("gio2", gio2);
        editor.putInt("phut2", phut2);
        editor.putInt("sleep2", prolength_sleep2);
        editor.putInt("friendly2", friendly2);
        editor.putInt("gioup2", gioup2);
        editor.putInt("phutup2", phutup2);
        editor.putInt("ngayup2", ngayup2);
        editor.putInt("health2", health2);
        if (mood2 < 0) mood2 = 1;
        editor.putInt("mood2", mood2);
        handler.removeCallbacks(run_age2);
        //---
        editor.putInt("_COUNTUONG3", prolength_uong3);
        editor.putInt("_COUNTAN3", prolength3);
        editor.putInt("_COUNTNHA3", prolength_nha3);
        editor.putFloat("age3", age3);
        editor.putInt("strength3", strength3);
        editor.putInt("ngay3", ngay3);
        editor.putInt("gio3", gio3);
        editor.putInt("phut3", phut3);
        editor.putInt("sleep3", prolength_sleep3);
        editor.putInt("gioup3", gioup3);
        editor.putInt("phutup3", phutup3);
        editor.putInt("ngayup3", ngayup3);
        editor.putInt("health3", health3);
        if (mood3 < 0) mood3 = 1;
        editor.putInt("mood3", mood3);
        handler.removeCallbacks(run_age3);
        //---
        editor.putInt("_COUNTUONG4", prolength_uong4);
        editor.putInt("_COUNTAN4", prolength4);
        editor.putInt("_COUNTNHA4", prolength_nha4);
        editor.putFloat("age4", age4);
        editor.putInt("strength4", strength4);
        editor.putInt("ngay4", ngay4);
        editor.putInt("gio4", gio4);
        editor.putInt("phut4", phut4);
        editor.putInt("sleep4", prolength_sleep4);
        editor.putInt("gioup4", gioup4);
        editor.putInt("phutup4", phutup4);
        editor.putInt("ngayup4", ngayup4);
        editor.putInt("health4", health4);
        if (mood4 < 0) mood4 = 1;
        editor.putInt("mood4", mood4);
        handler.removeCallbacks(run_age4);
        //---
        editor.putInt("_COUNTUONG5", prolength_uong5);
        editor.putInt("_COUNTAN5", prolength5);
        editor.putInt("_COUNTNHA5", prolength_nha5);
        editor.putFloat("age5", age5);
        editor.putInt("strength5", strength5);
        editor.putInt("ngay5", ngay5);
        editor.putInt("gio5", gio5);
        editor.putInt("phut5", phut5);
        editor.putInt("sleep5", prolength_sleep5);
        editor.putInt("gioup5", gioup5);
        editor.putInt("phutup5", phutup5);
        editor.putInt("ngayup5", ngayup5);
        editor.putInt("health5", health5);
        if (mood5 < 0) mood5 = 1;
        editor.putInt("mood5", mood5);
        handler.removeCallbacks(run_age5);
        //---
        editor.putInt("_COUNTUONG6", prolength_uong6);
        editor.putInt("_COUNTAN6", prolength6);
        editor.putInt("_COUNTNHA6", prolength_nha6);
        editor.putFloat("age6", age6);
        editor.putInt("strength6", strength6);
        editor.putInt("ngay6", ngay6);
        editor.putInt("gio6", gio6);
        editor.putInt("phut6", phut6);
        editor.putInt("sleep6", prolength_sleep6);
        editor.putInt("gioup6", gioup6);
        editor.putInt("phutup6", phutup6);
        editor.putInt("ngayup6", ngayup6);
        editor.putInt("health6", health6);
        if (mood6 < 0) mood6 = 1;
        editor.putInt("mood6", mood6);
        handler.removeCallbacks(run_age6);
        //---
        editor.putInt("_COUNTUONG7", prolength_uong7);
        editor.putInt("_COUNTAN7", prolength7);
        editor.putInt("_COUNTNHA7", prolength_nha7);
        editor.putFloat("age7", age7);
        editor.putInt("strength7", strength7);
        editor.putInt("ngay7", ngay7);
        editor.putInt("gio7", gio7);
        editor.putInt("phut7", phut7);
        editor.putInt("sleep7", prolength_sleep7);
        editor.putInt("gioup7", gioup7);
        editor.putInt("phutup7", phutup7);
        editor.putInt("ngayup7", ngayup7);
        editor.putInt("health7", health7);
        if (mood7 < 0) mood7 = 1;
        editor.putInt("mood7", mood7);
        handler.removeCallbacks(run_age7);
        //---
        editor.putInt("_COUNTUONG8", prolength_uong8);
        editor.putInt("_COUNTAN8", prolength8);
        editor.putInt("_COUNTNHA8", prolength_nha8);
        editor.putFloat("age8", age8);
        editor.putInt("strength8", strength8);
        editor.putInt("ngay8", ngay8);
        editor.putInt("gio8", gio8);
        editor.putInt("phut8", phut8);
        editor.putInt("sleep8", prolength_sleep8);
        editor.putInt("gioup8", gioup8);
        editor.putInt("phutup8", phutup8);
        editor.putInt("ngayup8", ngayup8);
        editor.putInt("health8", health8);
        if (mood8 < 0) mood8 = 1;
        editor.putInt("mood8", mood8);
        handler.removeCallbacks(run_age8);
        //----
        editor.putInt("nhietdo", temp);
        editor.putInt("nhietdo2", temp2);
        editor.putInt("nhietdo3", temp3);
        editor.putInt("nhietdo4", temp4);
        editor.putInt("nhietdo5", temp5);
        editor.putInt("nhietdo6", temp6);
        editor.putInt("nhietdo7", temp7);
        editor.putInt("nhietdo8", temp8);
        //----
        editor.putInt("p", p);
        editor.putInt("p2", p2);
        editor.putInt("p3", p3);
        editor.putInt("p4", p4);
        editor.putInt("p5", p5);
        editor.putInt("p6", p6);
        editor.putInt("p7", p7);
        editor.putInt("p8", p8);
        //
        editor.putInt("g", gi);
        editor.putInt("g2", gi2);
        editor.putInt("g3", gi3);
        editor.putInt("g4", gi4);
        editor.putInt("g5", gi5);
        editor.putInt("g6", gi6);
        editor.putInt("g7", gi7);
        editor.putInt("g8", gi8);
        //----
        editor.putInt("ngu", mypage.ngu);
        editor.putInt("ngu2", mypage.ngu2);
        editor.putInt("ngu3", mypage.ngu3);
        editor.putInt("ngu4", mypage.ngu4);
        editor.putInt("ngu5", mypage.ngu5);
        editor.putInt("ngu6", mypage.ngu6);
        editor.putInt("ngu7", mypage.ngu7);
        editor.putInt("ngu8", mypage.ngu8);
        //---
        editor.putInt("tieutien", mypage.tieutien);
        editor.putInt("tieutien2", mypage.tieutien2);
        editor.putInt("tieutien3", mypage.tieutien3);
        editor.putInt("tieutien4", mypage.tieutien4);
        editor.putInt("tieutien5", mypage.tieutien5);
        editor.putInt("tieutien6", mypage.tieutien6);
        editor.putInt("tieutien7", mypage.tieutien7);
        editor.putInt("tieutien8", mypage.tieutien8);
        //
        editor.putInt("daitien", daitien);
        editor.putInt("daitien2", daitien2);
        editor.putInt("daitien3", daitien3);
        editor.putInt("daitien4", daitien4);
        editor.putInt("daitien5", daitien5);
        editor.putInt("daitien6", daitien6);
        editor.putInt("daitien7", daitien7);
        editor.putInt("daitien8", daitien8);
        //
        d.set(false);
        d2.set(false);
        d3.set(false);
        d4.set(false);
        d5.set(false);
        d6.set(false);
        d7.set(false);
        d8.set(false);
        //
        editor.putInt("personality", personality);
        editor.putInt("personality2", personality2);
        editor.putInt("personality3", personality3);
        editor.putInt("personality4", personality4);
        editor.putInt("personality5", personality5);
        editor.putInt("personality6", personality6);
        editor.putInt("personality7", personality7);
        editor.putInt("personality8", personality8);
        //
        editor.putInt("form", form);
        editor.putInt("form2", form2);
        editor.putInt("form3", form3);
        editor.putInt("form4", form4);
        editor.putInt("form5", form5);
        editor.putInt("form6", form6);
        editor.putInt("form7", form7);
        editor.putInt("form8", form8);
        //
        editor.putInt("size", size);
        editor.putInt("size2", size2);
        editor.putInt("size3", size3);
        editor.putInt("size4", size4);
        editor.putInt("size5", size5);
        editor.putInt("size6", size6);
        editor.putInt("size7", size7);
        editor.putInt("size8", size8);
        //---
        editor.putInt("friendly3", friendly3);
        editor.putInt("friendly4", friendly4);
        editor.putInt("friendly5", friendly5);
        editor.putInt("friendly6", friendly6);
        editor.putInt("friendly7", friendly7);
        editor.putInt("friendly8", friendly8);
        //---
        editor.putLong("lastCleanTime", lastCleanTime);
        editor.putLong("lastCleanTime2", lastCleanTime2);
        editor.putLong("lastCleanTime3", lastCleanTime3);
        editor.putLong("lastCleanTime4", lastCleanTime4);
        editor.putLong("lastCleanTime5", lastCleanTime5);
        editor.putLong("lastCleanTime6", lastCleanTime6);
        editor.putLong("lastCleanTime7", lastCleanTime7);
        editor.putLong("lastCleanTime8", lastCleanTime8);

        editor.putLong("runpaStartTime", runpaStartTime);
        editor.putLong("runpaStartTime2", runpaStartTime2);
        editor.putLong("runpaStartTime3", runpaStartTime3);
        editor.putLong("runpaStartTime4", runpaStartTime4);
        editor.putLong("runpaStartTime5", runpaStartTime5);
        editor.putLong("runpaStartTime6", runpaStartTime6);
        editor.putLong("runpaStartTime7", runpaStartTime7);
        editor.putLong("runpaStartTime8", runpaStartTime8);

        editor.putInt("loginfirst", 1);
        editor.putInt("03004", _CLEAN);
        //---
        editor.commit();
    }

    public void SaveTime() {
        SharedPreferences pre = getSharedPreferences
                (main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("zk_date", Calendar.getInstance().get(Calendar.DATE));
        editor.putInt("zk_month", Calendar.getInstance().get(Calendar.MONTH) + 1);
        editor.putInt("zk_year", Calendar.getInstance().get(Calendar.YEAR));
        editor.putInt("zk_hour", Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        editor.putInt("zk_minute", Calendar.getInstance().get(Calendar.MINUTE));
        editor.putInt("zk_second", Calendar.getInstance().get(Calendar.SECOND));
        editor.commit();
    }

    public void stopprocess() {
        handler.removeCallbacks(runnablehealth);
        handler.removeCallbacks(runnablehealth2);
        handler.removeCallbacks(runnablehealth3);
        handler.removeCallbacks(runnablehealth4);
        handler.removeCallbacks(runnablehealth5);
        handler.removeCallbacks(runnablehealth6);
        handler.removeCallbacks(runnablehealth7);
        handler.removeCallbacks(runnablehealth8);

        handler.removeCallbacks(runnablemood);
        handler.removeCallbacks(runnablemood2);
        handler.removeCallbacks(runnablemood3);
        handler.removeCallbacks(runnablemood4);
        handler.removeCallbacks(runnablemood5);
        handler.removeCallbacks(runnablemood6);
        handler.removeCallbacks(runnablemood7);
        handler.removeCallbacks(runnablemood8);

        handler.removeCallbacks(runnable);
        handler.removeCallbacks(runnable2);
        handler.removeCallbacks(runnable3);
        handler.removeCallbacks(runnable4);
        handler.removeCallbacks(runnable5);
        handler.removeCallbacks(runnable6);
        handler.removeCallbacks(runnable7);
        handler.removeCallbacks(runnable8);

        handler.removeCallbacks(runnable_uong);
        handler.removeCallbacks(runnable_uong2);
        handler.removeCallbacks(runnable_uong3);
        handler.removeCallbacks(runnable_uong4);
        handler.removeCallbacks(runnable_uong5);
        handler.removeCallbacks(runnable_uong6);
        handler.removeCallbacks(runnable_uong7);
        handler.removeCallbacks(runnable_uong8);
        stopaction();
//        handler.removeCallbacks(run_age2);
    }

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        stopprocess();
        SaveData();
        SaveTime();
        bsound = true;
        try {
//            if (isApplicationSentToBackground(this)) {
            if (soundbg.isPlaying()) {
                soundbg.pause();
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void RestoreTime() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getInt("loginfirst", 0) == 1) {
            int zk_date = pre.getInt("zk_date", 0);
            int zk_month = pre.getInt("zk_month", 0);
            int zk_year = pre.getInt("zk_year", 0);
            int zk_hour = pre.getInt("zk_hour", 0);
            int zk_minute = pre.getInt("zk_minute", 0);
            int zk_second = pre.getInt("zk_second", 0);

            int a = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            int b = Calendar.getInstance().get(Calendar.MINUTE);
            int c = Calendar.getInstance().get(Calendar.DATE);
            int d = Calendar.getInstance().get(Calendar.MONTH) + 1;
            int e = Calendar.getInstance().get(Calendar.YEAR);
            int s = Calendar.getInstance().get(Calendar.SECOND);
//        int checktime = (a * 60 + b + c * 24 * 60 + d * 30 * 24 * 60 + e * 12 * 30 * 24 * 60) -
//                (zk_hour * 60 + zk_minute + zk_date * 24 * 60 + zk_month * 30 * 24 * 60 + zk_year * 12 * 30 * 24 * 60);
            int Cur_second = 0, Cur_minute = 0, Cur_hour = 0, Cur_date = 0, Cur_month = 0, Cur_year = 0;
            if (s >= zk_second)
                Cur_second = s - zk_second;
            if (s < zk_second) {
                Cur_second = s + 60 - zk_second;
                b--;
            }
            if (b >= zk_minute)
                Cur_minute = b - zk_minute;
            if (b < zk_minute) {
                Cur_minute = b + 60 - zk_minute;
                a--;
            }
            if (a >= zk_hour)
                Cur_hour = a - zk_hour;
            if (a < zk_hour) {
                Cur_hour = a + 24 - zk_hour;
                c--;
            }
            if (c >= zk_date)
                Cur_date = c - zk_date;
            if (c < zk_date) {
                c = 0;
                a = 0;
                b = 0;
                s = 2;
            }
            Cur_month = d - zk_month;
            Cur_year = e - zk_year;

            if (pre.getString("daload14s", "").length() == 0 && pre.getString("tenzukan", "").length() > 0 && pre.getInt("pet_load1", 0) == 1) {
                if (gi >= Cur_second)
                    gi = gi - Cur_second;
                if (gi < Cur_second) {
                    gi = gi + 60 - Cur_second;
                    p--;
                }
                if (gi == 0) gi = 2;
                if (p >= Cur_minute)
                    p = p - Cur_minute;
                if (p < Cur_minute) {
                    p = 0;
                    gi = 2;
                }
            }
            if (pre.getString("daload14s2", "").length() == 0 && pre.getString("tenzukan2", "").length() > 0 && pre.getInt("pet_load2", 0) == 1) {
                if (gi2 >= Cur_second)
                    gi2 = gi2 - Cur_second;
                if (gi2 < Cur_second) {
                    gi2 = gi2 + 60 - Cur_second;
                    p2--;
                }
                if (gi2 == 0) gi2 = 2;
                if (p2 >= Cur_minute)
                    p2 = p2 - Cur_minute;
                if (p2 < Cur_minute) {
                    p2 = 0;
                    gi2 = 2;
                }
            }
            if (pre.getString("daload14s3", "").length() == 0 && pre.getString("tenzukan3", "").length() > 0 && pre.getInt("pet_load3", 0) == 1) {
                if (gi3 >= Cur_second)
                    gi3 = gi3 - Cur_second;
                if (gi3 < Cur_second) {
                    gi3 = gi3 + 60 - Cur_second;
                    p3--;
                }

                if (gi3 == 0) gi3 = 2;
                if (p3 >= Cur_minute)
                    p3 = p3 - Cur_minute;
                if (p3 < Cur_minute) {
                    p3 = 0;
                    gi3 = 2;
                }
            }
            if (pre.getString("daload14s4", "").length() == 0 && pre.getString("tenzukan4", "").length() > 0 && pre.getInt("pet_load4", 0) == 1) {
                if (gi4 >= Cur_second)
                    gi4 = gi4 - Cur_second;
                if (gi4 < Cur_second) {
                    gi4 = gi4 + 60 - Cur_second;
                    p4--;
                }
                if (gi4 == 0) gi4 = 2;
                if (p4 >= Cur_minute)
                    p4 = p4 - Cur_minute;
                if (p4 < Cur_minute) {
                    p4 = 0;
                    gi4 = 2;
                }
            }
            if (pre.getString("daload14s5", "").length() == 0 && pre.getString("tenzukan5", "").length() > 0 && pre.getInt("pet_load5", 0) == 1) {
                if (gi5 >= Cur_second)
                    gi5 = gi5 - Cur_second;
                if (gi5 < Cur_second) {
                    gi5 = gi5 + 60 - Cur_second;
                    p5--;
                }

                if (gi5 == 0) gi5 = 2;
                if (p5 >= Cur_minute)
                    p5 = p5 - Cur_minute;
                if (p5 < Cur_minute) {
                    p5 = 0;
                    gi5 = 2;
                }
            }
            if (pre.getString("daload14s6", "").length() == 0 && pre.getString("tenzukan6", "").length() > 0 && pre.getInt("pet_load6", 0) == 1) {
                if (gi6 >= Cur_second)
                    gi6 = gi6 - Cur_second;
                if (gi6 < Cur_second) {
                    gi6 = gi6 + 60 - Cur_second;
                    p6--;
                }

                if (gi6 == 0) gi6 = 2;
                if (p6 >= Cur_minute)
                    p6 = p6 - Cur_minute;
                if (p6 < Cur_minute) {
                    p6 = 0;
                    gi6 = 2;
                }
            }
            if (pre.getString("daload14s7", "").length() == 0 && pre.getString("tenzukan7", "").length() > 0 && pre.getInt("pet_load7", 0) == 1) {
                if (gi7 >= Cur_second)
                    gi7 = gi7 - Cur_second;
                if (gi7 < Cur_second) {
                    gi7 = gi7 + 60 - Cur_second;
                    p7--;
                }

                if (gi7 == 0) gi7 = 2;
                if (p7 >= Cur_minute)
                    p7 = p7 - Cur_minute;
                if (p7 < Cur_minute) {
                    p7 = 0;
                    gi7 = 2;
                }
            }
            if (pre.getString("daload14s8", "").length() == 0 && pre.getString("tenzukan8", "").length() > 0 && pre.getInt("pet_load8", 0) == 1) {
                if (gi8 >= Cur_second)
                    gi8 = gi8 - Cur_second;
                if (gi8 < Cur_second) {
                    gi8 = gi8 + 60 - Cur_second;
                    p8--;
                }

                if (gi8 == 0) gi8 = 2;
                if (p8 >= Cur_minute)
                    p8 = p8 - Cur_minute;
                if (p8 < Cur_minute) {
                    p8 = 0;
                    gi8 = 2;
                }
            }
            if (pre.getString("daload14s", "").length() > 0 && pre.getString("tenzukan", "").length() > 0) {
                phutup = phutup + Cur_minute;
                if (phutup > 59) {
                    phutup = 0;
                    gioup++;
                }
                gioup = gioup + Cur_hour;
                if (gioup > 23) {
                    gioup = 0;
                    ngayup++;
                }
                if (giay >= Cur_second)
                    giay = giay - Cur_second;
                if (giay < Cur_second) {
                    giay = giay + 60 - Cur_second;
                    phut--;
                }
                if (phut >= Cur_minute)
                    phut = phut - Cur_minute;
                if (phut < Cur_minute) {
                    phut = phut + 60 - Cur_minute;
                    gio--;
                }
                if (gio >= Cur_hour)
                    gio = gio - Cur_hour;
                if (gio < Cur_hour) {
                    gio = gio + 24 - Cur_hour;
                    ngay--;
                }
                if (ngay >= Cur_date)
                    ngay = ngay - Cur_date;
                if (ngay < Cur_date) {
                    phut = 0;
                    gio = 0;
                    ngay = 0;
                }
            }
            if (pre.getString("daload14s2", "").length() > 0 && pre.getString("tenzukan2", "").length() > 0) {
                phutup2 = phutup2 + Cur_minute;
                if (phutup2 > 59) {
                    phutup2 = 0;
                    gioup2++;
                }
                gioup2 = gioup2 + Cur_hour;
                if (gioup2 > 23) {
                    gioup2 = 0;
                    ngayup2++;
                }
                if (giay2 >= Cur_second)
                    giay2 = giay2 - Cur_second;
                if (giay2 < Cur_second) {
                    giay2 = giay2 + 60 - Cur_second;
                    phut2--;
                }
                if (phut2 >= Cur_minute)
                    phut2 = phut2 - Cur_minute;
                if (phut2 < Cur_minute) {
                    phut2 = phut2 + 60 - Cur_minute;
                    gio2--;
                }
                if (gio2 >= Cur_hour)
                    gio2 = gio2 - Cur_hour;
                if (gio2 < Cur_hour) {
                    gio2 = gio2 + 24 - Cur_hour;
                    ngay2--;
                }
                if (ngay2 >= Cur_date)
                    ngay2 = ngay2 - Cur_date;
                if (ngay2 < Cur_date) {
                    phut2 = 0;
                    gio2 = 0;
                    ngay2 = 0;
                }
            }
            if (pre.getString("daload14s3", "").length() > 0 && pre.getString("tenzukan3", "").length() > 0) {
                phutup3 = phutup3 + Cur_minute;
                if (phutup3 > 59) {
                    phutup3 = 0;
                    gioup3++;
                }
                gioup3 = gioup3 + Cur_hour;
                if (gioup3 > 23) {
                    gioup3 = 0;
                    ngayup3++;
                }
                if (giay3 >= Cur_second)
                    giay3 = giay3 - Cur_second;
                if (giay3 < Cur_second) {
                    giay3 = giay3 + 60 - Cur_second;
                    phut3--;
                }
                if (phut3 >= Cur_minute)
                    phut3 = phut3 - Cur_minute;
                if (phut3 < Cur_minute) {
                    phut3 = phut3 + 60 - Cur_minute;
                    gio3--;
                }
                if (gio3 >= Cur_hour)
                    gio3 = gio3 - Cur_hour;
                if (gio3 < Cur_hour) {
                    gio3 = gio3 + 24 - Cur_hour;
                    ngay3--;
                }
                if (ngay3 >= Cur_date)
                    ngay3 = ngay3 - Cur_date;
                if (ngay3 < Cur_date) {
                    phut3 = 0;
                    gio3 = 0;
                    ngay3 = 0;
                }
            }
            if (pre.getString("daload14s4", "").length() > 0 && pre.getString("tenzukan4", "").length() > 0) {
                phutup4 = phutup4 + Cur_minute;
                if (phutup4 > 59) {
                    phutup4 = 0;
                    gioup4++;
                }
                gioup4 = gioup4 + Cur_hour;
                if (gioup4 > 23) {
                    gioup4 = 0;
                    ngayup4++;
                }
                if (giay4 >= Cur_second)
                    giay4 = giay4 - Cur_second;
                if (giay4 < Cur_second) {
                    giay4 = giay4 + 60 - Cur_second;
                    phut4--;
                }
                if (phut4 >= Cur_minute)
                    phut4 = phut4 - Cur_minute;
                if (phut4 < Cur_minute) {
                    phut4 = phut4 + 60 - Cur_minute;
                    gio4--;
                }
                if (gio4 >= Cur_hour)
                    gio4 = gio4 - Cur_hour;
                if (gio4 < Cur_hour) {
                    gio4 = gio4 + 24 - Cur_hour;
                    ngay4--;
                }
                if (ngay4 >= Cur_date)
                    ngay4 = ngay4 - Cur_date;
                if (ngay4 < Cur_date) {
                    phut4 = 0;
                    gio4 = 0;
                    ngay4 = 0;
                }
            }
            if (pre.getString("daload14s5", "").length() > 0 && pre.getString("tenzukan5", "").length() > 0) {
                phutup5 = phutup5 + Cur_minute;
                if (phutup5 > 59) {
                    phutup5 = 0;
                    gioup5++;
                }
                gioup5 = gioup5 + Cur_hour;
                if (gioup5 > 23) {
                    gioup5 = 0;
                    ngayup5++;
                }
                if (giay5 >= Cur_second)
                    giay5 = giay5 - Cur_second;
                if (giay5 < Cur_second) {
                    giay5 = giay5 + 60 - Cur_second;
                    phut5--;
                }
                if (phut5 >= Cur_minute)
                    phut5 = phut5 - Cur_minute;
                if (phut5 < Cur_minute) {
                    phut5 = phut5 + 60 - Cur_minute;
                    gio5--;
                }
                if (gio5 >= Cur_hour)
                    gio5 = gio5 - Cur_hour;
                if (gio5 < Cur_hour) {
                    gio5 = gio5 + 24 - Cur_hour;
                    ngay5--;
                }
                if (ngay5 >= Cur_date)
                    ngay5 = ngay5 - Cur_date;
                if (ngay5 < Cur_date) {
                    phut5 = 0;
                    gio5 = 0;
                    ngay5 = 0;
                }
            }
            if (pre.getString("daload14s6", "").length() > 0 && pre.getString("tenzukan6", "").length() > 0) {
                phutup6 = phutup6 + Cur_minute;
                if (phutup6 > 59) {
                    phutup6 = 0;
                    gioup6++;
                }
                gioup6 = gioup6 + Cur_hour;
                if (gioup6 > 23) {
                    gioup6 = 0;
                    ngayup6++;
                }
                if (giay6 >= Cur_second)
                    giay6 = giay6 - Cur_second;
                if (giay6 < Cur_second) {
                    giay6 = giay6 + 60 - Cur_second;
                    phut6--;
                }
                if (phut6 >= Cur_minute)
                    phut6 = phut6 - Cur_minute;
                if (phut6 < Cur_minute) {
                    phut6 = phut6 + 60 - Cur_minute;
                    gio6--;
                }
                if (gio6 >= Cur_hour)
                    gio6 = gio6 - Cur_hour;
                if (gio6 < Cur_hour) {
                    gio6 = gio6 + 24 - Cur_hour;
                    ngay6--;
                }
                if (ngay6 >= Cur_date)
                    ngay6 = ngay6 - Cur_date;
                if (ngay6 < Cur_date) {
                    phut6 = 0;
                    gio6 = 0;
                    ngay6 = 0;
                }
            }
            if (pre.getString("daload14s7", "").length() > 0 && pre.getString("tenzukan7", "").length() > 0) {
                phutup7 = phutup7 + Cur_minute;
                if (phutup7 > 59) {
                    phutup7 = 0;
                    gioup7++;
                }
                gioup7 = gioup7 + Cur_hour;
                if (gioup7 > 23) {
                    gioup7 = 0;
                    ngayup7++;
                }
                if (giay7 >= Cur_second)
                    giay7 = giay7 - Cur_second;
                if (giay7 < Cur_second) {
                    giay7 = giay7 + 60 - Cur_second;
                    phut7--;
                }
                if (phut7 >= Cur_minute)
                    phut7 = phut7 - Cur_minute;
                if (phut7 < Cur_minute) {
                    phut7 = phut7 + 60 - Cur_minute;
                    gio7--;
                }
                if (gio7 >= Cur_hour)
                    gio7 = gio7 - Cur_hour;
                if (gio7 < Cur_hour) {
                    gio7 = gio7 + 24 - Cur_hour;
                    ngay7--;
                }
                if (ngay7 >= Cur_date)
                    ngay7 = ngay7 - Cur_date;
                if (ngay7 < Cur_date) {
                    phut7 = 0;
                    gio7 = 0;
                    ngay7 = 0;
                }
            }
            if (pre.getString("daload14s8", "").length() > 0 && pre.getString("tenzukan8", "").length() > 0) {
                phutup8 = phutup8 + Cur_minute;
                if (phutup8 > 59) {
                    phutup8 = 0;
                    gioup8++;
                }
                gioup8 = gioup8 + Cur_hour;
                if (gioup8 > 23) {
                    gioup8 = 0;
                    ngayup8++;
                }
                if (giay8 >= Cur_second)
                    giay8 = giay8 - Cur_second;
                if (giay8 < Cur_second) {
                    giay8 = giay8 + 60 - Cur_second;
                    phut8--;
                }
                if (phut8 >= Cur_minute)
                    phut8 = phut8 - Cur_minute;
                if (phut8 < Cur_minute) {
                    phut8 = phut8 + 60 - Cur_minute;
                    gio8--;
                }
                if (gio8 >= Cur_hour)
                    gio8 = gio8 - Cur_hour;
                if (gio8 < Cur_hour) {
                    gio8 = gio8 + 24 - Cur_hour;
                    ngay8--;
                }
                if (ngay8 >= Cur_date)
                    ngay8 = ngay8 - Cur_date;
                if (ngay8 < Cur_date) {
                    phut8 = 0;
                    gio8 = 0;
                    ngay8 = 0;
                }
            }
        }
    }

    public void restoreprocess() {
        if (b_health)
            handler.post(runnablehealth);
        if (b_health2)
            handler.post(runnablehealth2);
        if (b_health3)
            handler.post(runnablehealth3);
        if (b_health4)
            handler.post(runnablehealth4);
        if (b_health5)
            handler.post(runnablehealth5);
        if (b_health6)
            handler.post(runnablehealth6);
        if (b_health7)
            handler.post(runnablehealth7);
        if (b_health8)
            handler.post(runnablehealth8);

        if (b_mood)
            handler.post(runnablemood);
        if (b_mood2)
            handler.post(runnablemood2);
        if (b_mood3)
            handler.post(runnablemood3);
        if (b_mood4)
            handler.post(runnablemood4);
        if (b_mood5)
            handler.post(runnablemood5);
        if (b_mood6)
            handler.post(runnablemood6);
        if (b_mood7)
            handler.post(runnablemood7);
        if (b_mood8)
            handler.post(runnablemood8);

        if (ban)
            handler.post(runnable);
        if (ban2)
            handler.post(runnable2);
        if (ban3)
            handler.post(runnable3);
        if (ban4)
            handler.post(runnable4);
        if (ban5)
            handler.post(runnable5);
        if (ban6)
            handler.post(runnable6);
        if (ban7)
            handler.post(runnable7);
        if (ban8)
            handler.post(runnable8);

        if (buong)
            handler.post(runnable_uong);
        if (buong2)
            handler.post(runnable_uong2);
        if (buong3)
            handler.post(runnable_uong3);
        if (buong4)
            handler.post(runnable_uong4);
        if (buong5)
            handler.post(runnable_uong5);
        if (buong6)
            handler.post(runnable_uong6);
        if (buong7)
            handler.post(runnable_uong7);
        if (buong8)
            handler.post(runnable_uong8);

        if (baction && CLICK_PET == 1)
            handler.post(runnable_action);
        if (baction2 && CLICK_PET == 2)
            handler.post(runnable_action2);
        if (baction3 && CLICK_PET == 3)
            handler.post(runnable_action3);
        if (baction4 && CLICK_PET == 4)
            handler.post(runnable_action4);
        if (baction5 && CLICK_PET == 5)
            handler.post(runnable_action5);
        if (baction6 && CLICK_PET == 6)
            handler.post(runnable_action6);
        if (baction7 && CLICK_PET == 7)
            handler.post(runnable_action7);
        if (baction8 && CLICK_PET == 8)
            handler.post(runnable_action8);

        if (bage2)
            handler.post(run_age2);
        if (bage3)
            handler.post(run_age3);
        if (bage4)
            handler.post(run_age4);
        if (bage5)
            handler.post(run_age5);
        if (bage6)
            handler.post(run_age6);
        if (bage7)
            handler.post(run_age7);
        if (bage8)
            handler.post(run_age8);
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreprocess();
        if (mAdView != null) {
            mAdView.resume();
        }
        bsound = false;
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        _FOOD = pre.getInt("01001", 0);
        _FOODBIG = pre.getInt("01003", 0);
        _FOODBIG2 = pre.getInt("01013", 0);
        _FOODBIG3 = pre.getInt("01014", 0);
        _FOODBIG4 = pre.getInt("01011", 0);
        _FOODBIG5 = pre.getInt("01012", 0);
        _FOODBIG6 = pre.getInt("03003", 0);
        _FOODBIG7 = pre.getInt("01015", 0);
        _FOODBIG8 = pre.getInt("01016", 0);
        _DRINK = pre.getInt("00001", 0);
        _DRINKBIG = pre.getInt("00003", 0);
        _ITEM = pre.getInt("03001", 0);
        _ITEMBIG = pre.getInt("03002", 0);
        _ITEMBIG2 = pre.getInt("03004", 0);
        _ITEMBIG3 = pre.getInt("03005", 0);
        _ITEMBIG4 = pre.getInt("03006", 0);
        _ITEMBIG5 = pre.getInt("03007", 0);
        _CLEAN = pre.getInt("03004", 0);
//        if (pre.getFloat("age", 0) >= 4) {
//            sleeping = true;
//            swipe = true;
//            imgzukan.setVisibility(View.GONE);
//        }
        if (CLICK_PET == 1) {
            int _i = pre.getInt("useitem", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 2) {
            int _i = pre.getInt("useitem2", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 3) {
            int _i = pre.getInt("useitem3", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 4) {
            int _i = pre.getInt("useitem4", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 5) {
            int _i = pre.getInt("useitem5", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 6) {
            int _i = pre.getInt("useitem6", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 7) {
            int _i = pre.getInt("useitem7", 0);
            Chat.settextItem(_i, activeitem);
        } else if (CLICK_PET == 8) {
            int _i = pre.getInt("useitem8", 0);
            Chat.settextItem(_i, activeitem);
        }
        try {
            if (pwindo.isShowing()) {
                if (_CLICK == 1) {
                    setfood();
                }
                if (_CLICK == 2) {
                    setdrink();
                }
                if (_CLICK == 3) {
                    setitem();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        settempbg();
        try {
            if (pre.getBoolean("sound", true) == true) {
                soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pre.getString("gotomypage", "").equals("gotomypage")) {
            if (pwindo != null)
                pwindo.dismiss();
            finish();
        }
        try {
            db2.removePetLive();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startTimer();
    }

    public void settempbg() {
        if (CLICK_PET == 1)
            settemp(swipe, sleeping, imgzukan, temp);
        if (CLICK_PET == 2)
            settemp(swipe2, sleeping2, imgzukan2, temp2);
        if (CLICK_PET == 3)
            settemp(swipe3, sleeping3, imgzukan3, temp3);
        if (CLICK_PET == 4)
            settemp(swipe4, sleeping4, imgzukan4, temp4);
        if (CLICK_PET == 5)
            settemp(swipe5, sleeping5, imgzukan5, temp5);
        if (CLICK_PET == 6)
            settemp(swipe6, sleeping6, imgzukan6, temp6);
        if (CLICK_PET == 7)
            settemp(swipe7, sleeping7, imgzukan7, temp7);
        if (CLICK_PET == 8)
            settemp(swipe8, sleeping8, imgzukan8, temp8);
    }

    public void getAgeForBG() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (CLICK_PET == 1) {
            if (age >= 3) {
                sleeping = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan.setVisibility(View.VISIBLE);
//                swipe = false;
            }
        }
        if (CLICK_PET == 2) {
            if (age2 >= 3) {
                sleeping2 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan2.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 3) {
            if (age3 >= 3) {
                sleeping3 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan3.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 4) {
            if (age4 >= 3) {
                sleeping4 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan4.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 5) {
            if (age5 >= 3) {
                sleeping5 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan5.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 6) {
            if (age6 >= 3) {
                sleeping6 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan6.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 7) {
            if (age7 >= 3) {
                sleeping7 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan7.setVisibility(View.VISIBLE);
            }
        }
        if (CLICK_PET == 8) {
            if (age8 >= 3) {
                sleeping8 = true;
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
                imgupdown.setImageResource(R.drawable.bgup);
                imgzukan8.setVisibility(View.VISIBLE);
            }
        }
    }

    Dialog finish_dialog;
    TextView txthang, txttuoichet, txtngaychet;
    FrameLayout frhorn, bgfrhorn, frhorn2, bgfrhorn2, frdau, bgfrdau, frbody, bgfrbody, frcanh, bgfrcanh, frco, bgfrco, frmat, bgfrmat;

    public void Dialog_finish() {
        finish_dialog = new Dialog(zukan_main.this);
        finish_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        finish_dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        finish_dialog.setContentView(R.layout.finish_layout);
        finish_dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        finish_dialog.setCanceledOnTouchOutside(false);
        button24 = (ImageView) finish_dialog.findViewById(R.id.button24);
        txthang = (TextView) finish_dialog.findViewById(R.id.txthang);
        txtngaychet = (TextView) finish_dialog.findViewById(R.id.txtngaychet);
        txttuoichet = (TextView) finish_dialog.findViewById(R.id.txttuoichet);
        textView22 = (TextView) finish_dialog.findViewById(R.id.textView22);
        frhorn = (FrameLayout) finish_dialog.findViewById(R.id.horn);
        frhorn2 = (FrameLayout) finish_dialog.findViewById(R.id.horn2);
        frdau = (FrameLayout) finish_dialog.findViewById(R.id.dau);
        frbody = (FrameLayout) finish_dialog.findViewById(R.id.body);
        frcanh = (FrameLayout) finish_dialog.findViewById(R.id.canh);
        frco = (FrameLayout) finish_dialog.findViewById(R.id.co);
        frmat = (FrameLayout) finish_dialog.findViewById(R.id.mat);

        bgfrhorn = (FrameLayout) finish_dialog.findViewById(R.id.bghorn);
        bgfrhorn2 = (FrameLayout) finish_dialog.findViewById(R.id.bghorn2);
        bgfrdau = (FrameLayout) finish_dialog.findViewById(R.id.bgdau);
        bgfrbody = (FrameLayout) finish_dialog.findViewById(R.id.bgbody);
        bgfrcanh = (FrameLayout) finish_dialog.findViewById(R.id.bgcanh);
        bgfrco = (FrameLayout) finish_dialog.findViewById(R.id.bgco);
        bgfrmat = (FrameLayout) finish_dialog.findViewById(R.id.bgmat);

        Button button23 = (Button) finish_dialog.findViewById(R.id.button23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SaveData();
//                BackToMyPage();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                if (_TRUONGTHANH == 1) {
                    editor.putInt("useitem", 0);
                    editor.commit();
                    handler.removeCallbacks(runnable);
                    handler.removeCallbacks(runnable_action);
                    handler.removeCallbacks(runnable_uong);
                    handler.removeCallbacks(runnable_bb);
                    handler.removeCallbacks(runnable_sk);
                    handler.removeCallbacks(runnable_nha);
                    handler.removeCallbacks(runnable_timeUpAge);
                    handler.removeCallbacks(runnable_UpAge2);
                    handler.removeCallbacks(runnable_UpAge2Nho);
                    handler.removeCallbacks(runnable_sleep);

                    prolength = 400;
                    prolength_uong = 400;
                    prolength_nha = 800;
                    prolength_sleep = 800;
                    temp = 6;
                    ngay = 0;
                    phut = 59;
                    gio = 23;
                    phut = 30;
                    phutup = 0;
                    gioup = 0;
                    ngayup = 0;
                    savetoshopsell();
                    int persent = new Random().nextInt(30) + 10;
                    strength = 800 * persent / 100;
                    friendly = 0;
                    personality = new Random().nextInt(800);
                    form = new Random().nextInt(800);
                    mood = 800;
                    daitien = 0;
                    mypage.tieutien = 0;
                    health = 800;
                    age = 0;
                    db2.DeleteIconPetDeath(1);
                    _RESETGAME();
                }
                if (_TRUONGTHANH == 2) {
                    editor.putInt("useitem2", 0);
                    editor.putInt("strength2", 0);
                    editor.putInt("no5", 1);
                    temp2 = 6;
                    handler.removeCallbacks(runnable2);
                    handler.removeCallbacks(runnable_action2);
                    handler.removeCallbacks(runnable2_sk);
                    handler.removeCallbacks(runnable_timeUpAge2);
                    int hornNo = (int) ((float) life2 / 8000 * 7);
                    int horn2No = (int) ((float) strength2 / 800 * 7);
                    int wingNo = (int) ((float) friendly2 / 800 * 4);
                    int headNo = (int) ((float) health2 / 800 * 7);
                    int neckNo = (int) ((float) form2 / 800 * 4);
                    int faceNo = (int) ((float) mood2 / 800 * 7);
                    int bodyNo = (int) ((float) personality2 / 800 * 7);
                    //
                    int wingPrice = wingNo * 2000 / 10 * 3;
                    int bodyPrice = bodyNo * 2000 / 10;
                    int fHornPrice = hornNo * 2000 / 10 * 2;
                    int headPrice = headNo * 2000 / 10;
                    int facePrice = faceNo * 2000 / 10;
                    int neckPrice = neckNo * 2000 / 10;
                    int bHornPrice = horn2No * 2000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age2 > 4)
                        islive = 2;
                    if (age2 < 4)
                        islive = 1;
                    int phaseETime = ngayup2 * 24 * 60 * 60 + gioup2 * 60 * 60 + phutup2 * 60;
                    int phaseTime = ngay2 * 24 * 60 * 60 + gio2 * 60 * 60 + phut2 * 60;
                    if (neckNo > 1)
                        neckNo = 1;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan2", ""), "コクワガタ", "" + life2, "loai2", islive, 0, age2,
                            friendly2, pre.getInt("mat2", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality2,
                            tieutien2, prolength2, prolength_sleep2, phaseETime, strength2, pre.getLong("bornTime2", 1443158537),
                            daitien2, form2, phaseTime, size2, prolength_uong2, health2, mood2, prolength_nha2, lastCleanTime2, pre.getString("id2", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime2);
                    editor.putString("tenzukan2", "");
                    editor.putString("daload14s2", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat2", 0), "110310");
                    db2.DeleteIconPetDeath(2);
                    editor.putInt("mat2", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 3) {
                    editor.putInt("useitem3", 0);
                    editor.putInt("strength3", 0);
                    editor.putInt("no2", 1);
                    temp3 = 6;
                    handler.removeCallbacks(runnable3);
                    handler.removeCallbacks(runnable_action3);
                    handler.removeCallbacks(runnable3_sk);
                    handler.removeCallbacks(runnable_timeUpAge3);
                    int hornNo = (int) ((float) life3 / 10000 * 7);
                    int horn2No = (int) ((float) strength3 / 1000 * 7);
                    int wingNo = (int) ((float) friendly3 / 1000 * 4);
                    int headNo = (int) ((float) health3 / 1000 * 7);
                    int neckNo = (int) ((float) form3 / 1000 * 4);
                    int faceNo = (int) ((float) mood3 / 1000 * 7);
                    int bodyNo = (int) ((float) personality3 / 1000 * 7);
                    //
                    int wingPrice = wingNo * 5000 / 10 * 3;
                    int bodyPrice = bodyNo * 5000 / 10;
                    int fHornPrice = hornNo * 5000 / 10 * 2;
                    int headPrice = headNo * 5000 / 10;
                    int facePrice = faceNo * 5000 / 10;
                    int neckPrice = neckNo * 5000 / 10;
                    int bHornPrice = horn2No * 5000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age3 > 4)
                        islive = 2;
                    if (age3 < 4)
                        islive = 1;
                    int phaseETime = ngayup3 * 24 * 60 * 60 + gioup3 * 60 * 60 + phutup3 * 60;
                    int phaseTime = ngay3 * 24 * 60 * 60 + gio3 * 60 * 60 + phut3 * 60;
                    if (neckNo > 3)
                        neckNo = 3;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (horn2No > 6)
                        horn2No = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan3", ""), "コーカサスオオカブト", "" + life3, "loai3", islive, 0, age3,
                            friendly3, pre.getInt("mat3", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality3,
                            tieutien3, prolength3, prolength_sleep3, phaseETime, strength3, pre.getLong("bornTime3", 1443158537),
                            daitien3, form3, phaseTime, size3, prolength_uong3, health3, mood3, prolength_nha3, lastCleanTime3, pre.getString("id3", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime3);
                    editor.putString("tenzukan3", "");
                    editor.putString("daload14s3", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat3", 0), "101310");
                    db2.DeleteIconPetDeath(3);
                    editor.putInt("mat3", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 4) {
                    editor.putInt("useitem4", 0);
                    editor.putInt("strength4", 0);
                    editor.putInt("no6", 1);
                    temp4 = 6;
                    handler.removeCallbacks(runnable4);
                    handler.removeCallbacks(runnable_action4);
                    handler.removeCallbacks(runnable4_sk);
                    handler.removeCallbacks(runnable_timeUpAge4);
                    int hornNo = (int) ((float) life4 / 20000 * 7);
                    int horn2No = (int) ((float) strength4 / 2000 * 7);
                    int wingNo = (int) ((float) friendly4 / 2000 * 4);
                    int headNo = (int) ((float) health4 / 2000 * 7);
                    int neckNo = (int) ((float) form4 / 2000 * 4);
                    int faceNo = (int) ((float) mood4 / 2000 * 7);
                    int bodyNo = (int) ((float) personality4 / 2000 * 7);
                    //
                    int wingPrice = wingNo * 10000 / 10 * 3;
                    int bodyPrice = bodyNo * 10000 / 10;
                    int fHornPrice = hornNo * 10000 / 10 * 2;
                    int headPrice = headNo * 10000 / 10;
                    int facePrice = faceNo * 10000 / 10;
                    int neckPrice = neckNo * 10000 / 10;
                    int bHornPrice = horn2No * 10000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age4 > 4)
                        islive = 2;
                    if (age4 < 4)
                        islive = 1;
                    int phaseETime = ngayup4 * 24 * 60 * 60 + gioup4 * 60 * 60 + phutup4 * 60;
                    int phaseTime = ngay4 * 24 * 60 * 60 + gio4 * 60 * 60 + phut4 * 60;
                    if (neckNo > 1)
                        neckNo = 1;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan4", ""), "オオクワガタ", "" + life4, "loai4", islive, 0, age4,
                            friendly4, pre.getInt("mat4", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality4,
                            tieutien4, prolength4, prolength_sleep4, phaseETime, strength4, pre.getLong("bornTime4", 1443158537),
                            daitien4, form4, phaseTime, size4, prolength_uong4, health4, mood4, prolength_nha4, lastCleanTime4, pre.getString("id4", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime4);
                    editor.putString("tenzukan4", "");
                    editor.putString("daload14s4", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat4", 0), "111310");
                    db2.DeleteIconPetDeath(4);
                    editor.putInt("mat4", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 5) {
                    editor.putInt("useitem5", 0);
                    editor.putInt("strength5", 0);
                    editor.putInt("no3", 1);
                    temp5 = 6;
                    handler.removeCallbacks(runnable5);
                    handler.removeCallbacks(runnable_action5);
                    handler.removeCallbacks(runnable5_sk);
                    handler.removeCallbacks(runnable_timeUpAge5);
                    int hornNo = (int) ((float) life5 / 20000 * 7);
                    int horn2No = (int) ((float) strength5 / 2000 * 7);
                    int wingNo = (int) ((float) friendly5 / 2000 * 4);
                    int headNo = (int) ((float) health5 / 2000 * 7);
                    int neckNo = (int) ((float) form5 / 2000 * 4);
                    int faceNo = (int) ((float) mood5 / 2000 * 7);
                    int bodyNo = (int) ((float) personality5 / 2000 * 7);
                    //
                    int wingPrice = wingNo * 10000 / 10 * 3;
                    int bodyPrice = bodyNo * 10000 / 10;
                    int fHornPrice = hornNo * 10000 / 10 * 2;
                    int headPrice = headNo * 10000 / 10;
                    int facePrice = faceNo * 10000 / 10;
                    int neckPrice = neckNo * 10000 / 10;
                    int bHornPrice = horn2No * 10000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age5 > 4)
                        islive = 2;
                    if (age5 < 4)
                        islive = 1;
                    int phaseETime = ngayup5 * 24 * 60 * 60 + gioup5 * 60 * 60 + phutup5 * 60;
                    int phaseTime = ngay5 * 24 * 60 * 60 + gio5 * 60 * 60 + phut5 * 60;
                    if (neckNo > 2)
                        neckNo = 2;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan5", ""), "サタンオオカブト", "" + life5, "loai5", islive, 0, age5,
                            friendly5, pre.getInt("mat5", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality5,
                            tieutien5, prolength5, prolength_sleep5, phaseETime, strength5, pre.getLong("bornTime5", 1443158537),
                            daitien5, form5, phaseTime, size5, prolength_uong5, health5, mood5, prolength_nha5, lastCleanTime5, pre.getString("id5", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime5);
                    editor.putString("tenzukan5", "");
                    editor.putString("daload14s5", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat5", 0), "102310");
                    db2.DeleteIconPetDeath(5);
                    editor.putInt("mat5", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 6) {
                    editor.putInt("useitem6", 0);
                    editor.putInt("strength6", 0);
                    editor.putInt("no7", 1);
                    temp6 = 6;
                    handler.removeCallbacks(runnable6);
                    handler.removeCallbacks(runnable_action6);
                    handler.removeCallbacks(runnable6_sk);
                    handler.removeCallbacks(runnable_timeUpAge6);
                    int hornNo = (int) ((float) life6 / 20000 * 7);
                    int horn2No = (int) ((float) strength6 / 2000 * 7);
                    int wingNo = (int) ((float) friendly6 / 2000 * 4);
                    int headNo = (int) ((float) health6 / 2000 * 7);
                    int neckNo = (int) ((float) form6 / 2000 * 4);
                    int faceNo = (int) ((float) mood6 / 2000 * 7);
                    int bodyNo = (int) ((float) personality6 / 2000 * 7);
                    //
                    int wingPrice = wingNo * 20000 / 10 * 3;
                    int bodyPrice = bodyNo * 20000 / 10;
                    int fHornPrice = hornNo * 20000 / 10 * 2;
                    int headPrice = headNo * 20000 / 10;
                    int facePrice = faceNo * 20000 / 10;
                    int neckPrice = neckNo * 20000 / 10;
                    int bHornPrice = horn2No * 20000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age6 > 4)
                        islive = 2;
                    if (age6 < 4)
                        islive = 1;
                    int phaseETime = ngayup6 * 24 * 60 * 60 + gioup6 * 60 * 60 + phutup6 * 60;
                    int phaseTime = ngay6 * 24 * 60 * 60 + gio6 * 60 * 60 + phut6 * 60;
                    if (neckNo > 1)
                        neckNo = 1;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan6", ""), "ギラファノコギリクワガタ", "" + life6, "loai6", islive, 0, age6,
                            friendly6, pre.getInt("mat6", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality6,
                            tieutien6, prolength6, prolength_sleep6, phaseETime, strength6, pre.getLong("bornTime6", 1443158537),
                            daitien6, form6, phaseTime, size6, prolength_uong6, health6, mood6, prolength_nha6, lastCleanTime6, pre.getString("id6", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime6);
                    editor.putString("tenzukan6", "");
                    editor.putString("daload14s6", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat6", 0), "112310");
                    db2.DeleteIconPetDeath(6);
                    editor.putInt("mat6", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 7) {
                    editor.putInt("useitem7", 0);
                    editor.putInt("no8", 1);
                    editor.putInt("strength7", 0);
                    temp7 = 6;
                    handler.removeCallbacks(runnable7);
                    handler.removeCallbacks(runnable_action7);
                    handler.removeCallbacks(runnable7_sk);
                    handler.removeCallbacks(runnable_timeUpAge7);
                    int hornNo = (int) ((float) life7 / 15000 * 7);
                    int horn2No = (int) ((float) strength7 / 1500 * 7);
                    int wingNo = (int) ((float) friendly7 / 1500 * 4);
                    int headNo = (int) ((float) health7 / 1500 * 7);
                    int neckNo = (int) ((float) form7 / 1500 * 4);
                    int faceNo = (int) ((float) mood7 / 1500 * 7);
                    int bodyNo = (int) ((float) personality7 / 1500 * 7);
                    //
                    int wingPrice = wingNo * 40000 / 10 * 3;
                    int bodyPrice = bodyNo * 40000 / 10;
                    int fHornPrice = hornNo * 40000 / 10 * 2;
                    int headPrice = headNo * 40000 / 10;
                    int facePrice = faceNo * 40000 / 10;
                    int neckPrice = neckNo * 40000 / 10;
                    int bHornPrice = horn2No * 40000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age7 > 4)
                        islive = 2;
                    if (age7 < 4)
                        islive = 1;
                    int phaseETime = ngayup7 * 24 * 60 * 60 + gioup7 * 60 * 60 + phutup7 * 60;
                    int phaseTime = ngay7 * 24 * 60 * 60 + gio7 * 60 * 60 + phut7 * 60;
                    if (neckNo > 2)
                        neckNo = 2;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan7", ""), "オウゴンオニクワガタ", "" + life7, "loai7", islive, 0, age7,
                            friendly7, pre.getInt("mat7", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality7,
                            tieutien7, prolength7, prolength_sleep7, phaseETime, strength7, pre.getLong("bornTime7", 1443158537),
                            daitien7, form7, phaseTime, size7, prolength_uong7, health7, mood7, prolength_nha7, lastCleanTime7, pre.getString("id7", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime7);
                    editor.putString("tenzukan7", "");
                    editor.putString("daload14s7", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat7", 0), "113310");
                    db2.DeleteIconPetDeath(7);
                    editor.putInt("mat7", 0);
                    editor.commit();
                }
                if (_TRUONGTHANH == 8) {
                    editor.putInt("useitem8", 0);
                    editor.putInt("strength8", 0);
                    editor.putInt("no4", 1);
                    temp8 = 6;
                    handler.removeCallbacks(runnable8);
                    handler.removeCallbacks(runnable_action8);
                    handler.removeCallbacks(runnable8_sk);
                    handler.removeCallbacks(runnable_timeUpAge8);
                    int hornNo = (int) ((float) life8 / 30000 * 7);
                    int horn2No = (int) ((float) strength8 / 3000 * 7);
                    int wingNo = (int) ((float) friendly8 / 3000 * 4);
                    int headNo = (int) ((float) health8 / 3000 * 7);
                    int neckNo = (int) ((float) form8 / 3000 * 4);
                    int faceNo = (int) ((float) mood8 / 3000 * 7);
                    int bodyNo = (int) ((float) personality8 / 3000 * 7);
                    //
                    int wingPrice = wingNo * 50000 / 10 * 3;
                    int bodyPrice = bodyNo * 50000 / 10;
                    int fHornPrice = hornNo * 50000 / 10 * 2;
                    int headPrice = headNo * 50000 / 10;
                    int facePrice = faceNo * 50000 / 10;
                    int neckPrice = neckNo * 50000 / 10;
                    int bHornPrice = horn2No * 50000 / 10 * 2;
                    int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
                    if (age8 > 4)
                        islive = 2;
                    if (age8 < 4)
                        islive = 1;
                    int phaseETime = ngayup8 * 24 * 60 * 60 + gioup8 * 60 * 60 + phutup8 * 60;
                    int phaseTime = ngay8 * 24 * 60 * 60 + gio8 * 60 * 60 + phut8 * 60;
                    if (neckNo > 2)
                        neckNo = 2;
                    if (hornNo > 6)
                        hornNo = 6;
                    if (horn2No > 6)
                        horn2No = 6;
                    if (wingNo > 3)
                        wingNo = 3;
                    if (headNo > 6)
                        headNo = 6;
                    if (faceNo > 4)
                        faceNo = 4;
                    if (bodyNo > 6)
                        bodyNo = 6;
                    if (neckNo < 0) neckNo = 0;
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (headNo < 0) headNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    db2.adddata(getApplicationContext(), pre.getString("tenzukan8", ""), "ヘラクレスオオカブト", "" + life8, "loai8", islive, 0, age8,
                            friendly8, pre.getInt("mat8", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality8,
                            tieutien8, prolength8, prolength_sleep8, phaseETime, strength8, pre.getLong("bornTime8", 1443158537),
                            daitien8, form8, phaseTime, size8, prolength_uong8, health8, mood8, prolength_nha8, lastCleanTime8, pre.getString("id8", ""),
                            100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime8);
                    editor.putString("tenzukan8", "");
                    editor.putString("daload14s8", "");
                    if (hornNo < 0) hornNo = 0;
                    if (horn2No < 0) horn2No = 0;
                    if (headNo < 0) headNo = 0;
                    if (neckNo < 0) neckNo = 0;
                    if (bodyNo < 0) bodyNo = 0;
                    if (wingNo < 0) wingNo = 0;
                    if (faceNo < 0) faceNo = 0;
                    savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat8", 0), "103310");
                    db2.DeleteIconPetDeath(8);
                    editor.putInt("mat8", 0);
                    editor.commit();
                }
                finish_dialog.dismiss();
                finish();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    boolean swipe = false, swipe2 = false, swipe3 = false, swipe4 = false, swipe5 = false,
            swipe6 = false, swipe7 = false, swipe8 = false;

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            case SimpleGestureFilter.SWIPE_UP:
                setdataup();
                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                setdatadown();
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();

    }

    @Override
    public void onDoubleTap() {

    }

    int _itemUpLevel = 0;

    public void CheckUpAge() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age > 0 && age < 1) {
            if (_itemUpLevel == 0) {
                ngay = 1;
                gio = 23;
                phut = 59;
                giay = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly, mood);
            strength += 100 + bonus;
            size += 1000;
        }
        if (age > 1 && age < 2) {
            if (_itemUpLevel == 0) {
                ngay = 2;
                gio = 23;
                phut = 59;
                giay = 59;
            }
        }
        if (age > 2 && age < 3) {
            if (_itemUpLevel == 0) {
                ngay = 0;
                gio = 2;
                phut = 59;
                giay = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly, mood);
            size += 1000;
            size += bonus;
            strength += 100 + bonus;
            sleeping = true;
            swipe = true;
            if (CLICK_PET == 1) {
                itm_runpa1.clearAnimation();
                fritm_runpa1.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age > 3 && age < 4) {
            sleeping = true;
            swipe = true;
            if (CLICK_PET == 1) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha);
            handler.removeCallbacks(runnablemood);
            handler.removeCallbacks(runnablehealth);
            if (_itemUpLevel == 0) {
                ngay = 0;
                gio = 23;
                phut = 59;
                giay = 59;
            }
        }

        if (age > 4) {
            _TRUONGTHANH = 1;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup + "日");
                    textView22.setText("" + pre.getString("tenzukan", "") + " " + "が成虫になりました！");
                    SettextNgay(age);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            set0value();
        }
        if (timeUpAge == true)
            handler.removeCallbacks(runnable_timeUpAge);
        if (UpAge2 == true)
            handler.removeCallbacks(runnable_UpAge2);
        if (UpAge2Nho == true)
            handler.removeCallbacks(runnable_UpAge2Nho);
        _USEITEM = 0;
        handler.post(runnable_timeUpAge);
        if (CLICK_PET == 1)
            _StartEffect(imgzukan);
        age += 1;
        if (strength > 800)
            strength = 800;
        life = strength * 10;
        activeitem.setText("");
        editor.putInt("useitem", 0);
        editor.commit();
    }

    int _TRUONGTHANH = 0;

    public void CheckUpage2() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age2 > 0 && age2 < 1) {
            if (_itemUpLevel == 0) {
                ngay2 = 1;
                gio2 = 23;
                phut2 = 59;
                giay2 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly2, mood2);
            strength2 += 100 + bonus;
            size2 += 1000;
        }
        if (age2 > 1 && age2 < 2) {
            if (_itemUpLevel == 0) {
                ngay2 = 2;
                gio2 = 23;
                phut2 = 59;
                giay2 = 59;
            }
        }
        if (age2 > 2 && age2 < 3) {
            if (_itemUpLevel == 0) {
                ngay2 = 0;
                gio2 = 2;
                phut2 = 59;
                giay2 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly2, mood2);
            strength2 += 100 + bonus;
            size2 += 1000;
            size2 += bonus;
            sleeping2 = true;
            swipe2 = true;
            if (CLICK_PET == 2) {
                itm_runpa2.clearAnimation();
                fritm_runpa2.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age2 > 3 && age2 < 4) {
            sleeping2 = true;
            swipe2 = true;
            if (CLICK_PET == 2) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha2);
            handler.removeCallbacks(runnablemood2);
            handler.removeCallbacks(runnablehealth2);
            if (_itemUpLevel == 0) {
                ngay2 = 0;
                gio2 = 23;
                phut2 = 59;
                giay2 = 59;
            }
        }

        if (age2 > 4) {
            _TRUONGTHANH = 2;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup2 + "日");
                    textView22.setText("" + pre.getString("tenzukan2", "") + " " + "が成虫になりました！");
                    SettextNgay(age2);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge2);
        handler.removeCallbacks(runnable_UpAge22);
        handler.removeCallbacks(runnable_UpAge2Nho2);
        _USEITEM2 = 0;
        handler.post(runnable_timeUpAge2);
        if (CLICK_PET == 2)
            _StartEffect(imgzukan2);
        age2 += 1;
        if (strength2 > 800)
            strength2 = 800;
        life2 = strength2 * 10;
        activeitem.setText("");
        editor.putInt("useitem2", 0);
        editor.commit();
    }

    public void CheckUpage4() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age4 > 0 && age4 < 1) {
            if (_itemUpLevel == 0) {
                ngay4 = 1;
                gio4 = 23;
                phut4 = 59;
                giay4 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly4, mood4);
            strength4 += 100 + bonus;
            size4 += 1000;
        }
        if (age4 > 1 && age4 < 2) {
            if (_itemUpLevel == 0) {
                ngay4 = 2;
                gio4 = 23;
                phut4 = 59;
                giay4 = 59;
            }
        }
        if (age4 > 2 && age4 < 3) {
            if (_itemUpLevel == 0) {
                ngay4 = 0;
                gio4 = 2;
                phut4 = 59;
                giay4 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly4, mood4);
            strength4 += 100 + bonus;
            size4 += 1000;
            size4 += bonus;
            sleeping4 = true;
            swipe4 = true;
            if (CLICK_PET == 4) {
                itm_runpa4.clearAnimation();
                fritm_runpa4.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age4 > 3 && age4 < 4) {
            sleeping4 = true;
            swipe4 = true;
            if (CLICK_PET == 4) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha4);
            handler.removeCallbacks(runnablemood4);
            handler.removeCallbacks(runnablehealth4);
            if (_itemUpLevel == 0) {
                ngay4 = 0;
                gio4 = 23;
                phut4 = 59;
                giay4 = 59;
            }
        }
        if (age4 > 4) {
            _TRUONGTHANH = 4;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup4 + "日");
                    textView22.setText("" + pre.getString("tenzukan4", "") + " " + "が成虫になりました！");
                    SettextNgay(age4);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge4);
        handler.removeCallbacks(runnable_UpAge24);
        handler.removeCallbacks(runnable_UpAge2Nho4);
        _USEITEM4 = 0;
        handler.post(runnable_timeUpAge4);
        if (CLICK_PET == 4)
            _StartEffect(imgzukan4);
        age4 += 1;
        if (strength4 > 2000)
            strength4 = 2000;
        life4 = strength4 * 10;
        activeitem.setText("");
        editor.putInt("useitem4", 0);
        editor.commit();
    }

    public void CheckUpage5() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age5 > 0 && age5 < 1) {
            if (_itemUpLevel == 0) {
                ngay5 = 1;
                gio5 = 23;
                phut5 = 59;
                giay5 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly5, mood5);
            strength5 += 100 + bonus;
            size5 += 1000;
        }
        if (age5 > 1 && age5 < 2) {
            if (_itemUpLevel == 0) {
                ngay5 = 2;
                gio5 = 23;
                phut5 = 59;
                giay5 = 59;
            }
        }
        if (age5 > 2 && age5 < 3) {
            if (_itemUpLevel == 0) {
                ngay5 = 0;
                gio5 = 2;
                phut5 = 59;
                giay5 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly5, mood5);
            strength5 += 100 + bonus;
            size5 += 1000;
            size5 += bonus;
            sleeping5 = true;
            swipe5 = true;
            if (CLICK_PET == 5) {
                itm_runpa5.clearAnimation();
                fritm_runpa5.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age5 > 3 && age5 < 4) {
            sleeping5 = true;
            swipe5 = true;
            if (CLICK_PET == 5) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha5);
            handler.removeCallbacks(runnablemood5);
            handler.removeCallbacks(runnablehealth5);
            if (_itemUpLevel == 0) {
                ngay5 = 0;
                gio5 = 23;
                phut5 = 59;
                giay5 = 59;
            }
        }
        if (age5 > 4) {
            _TRUONGTHANH = 5;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup5 + "日");
                    textView22.setText("" + pre.getString("tenzukan5", "") + " " + "が成虫になりました！");
                    SettextNgay(age5);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge5);
        handler.removeCallbacks(runnable_UpAge25);
        handler.removeCallbacks(runnable_UpAge2Nho5);
        _USEITEM5 = 0;
        handler.post(runnable_timeUpAge5);
        if (CLICK_PET == 5)
            _StartEffect(imgzukan5);
        age5 += 1;
        if (strength5 > 2000)
            strength5 = 2000;
        life5 = strength5 * 10;
        activeitem.setText("");
        editor.putInt("useitem5", 0);
        editor.commit();
    }

    public void CheckUpage6() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age6 > 0 && age6 < 1) {
            if (_itemUpLevel == 0) {
                ngay6 = 1;
                gio6 = 23;
                phut6 = 59;
                giay6 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly6, mood6);
            strength6 += 100 + bonus;
            size6 += 1000;
        }
        if (age6 > 1 && age6 < 2) {
            if (_itemUpLevel == 0) {
                ngay6 = 2;
                gio6 = 23;
                phut6 = 59;
                giay6 = 59;
            }
        }
        if (age6 > 2 && age6 < 3) {
            if (_itemUpLevel == 0) {
                ngay6 = 0;
                gio6 = 2;
                phut6 = 59;
                giay6 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly6, mood6);
            strength6 += 100 + bonus;
            size6 += 1000;
            size6 += bonus;
            sleeping6 = true;
            swipe6 = true;
            if (CLICK_PET == 6) {
                itm_runpa6.clearAnimation();
                fritm_runpa6.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age6 > 3 && age6 < 4) {
            sleeping6 = true;
            swipe6 = true;
            if (CLICK_PET == 6) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha6);
            handler.removeCallbacks(runnablemood6);
            handler.removeCallbacks(runnablehealth6);
            if (_itemUpLevel == 0) {
                ngay6 = 0;
                gio6 = 23;
                phut6 = 59;
                giay6 = 59;
            }
        }
        if (age6 > 4) {
            _TRUONGTHANH = 6;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup6 + "日");
                    textView22.setText("" + pre.getString("tenzukan6", "") + " " + "が成虫になりました！");
                    SettextNgay(age6);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge6);
        handler.removeCallbacks(runnable_UpAge26);
        handler.removeCallbacks(runnable_UpAge2Nho6);
        _USEITEM6 = 0;
        handler.post(runnable_timeUpAge6);
        if (CLICK_PET == 6)
            _StartEffect(imgzukan6);
        age6 += 1;
        if (strength6 > 2000)
            strength6 = 2000;
        life6 = strength6 * 10;
        activeitem.setText("");
        editor.putInt("useitem6", 0);
        editor.commit();
    }

    //----
    public void CheckUpage7() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age7 > 0 && age7 < 1) {
            if (_itemUpLevel == 0) {
                ngay7 = 1;
                gio7 = 23;
                phut7 = 59;
                giay7 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly7, mood7);
            strength7 += 100 + bonus;
            size7 += 1000;
        }
        if (age7 > 1 && age7 < 2) {
            if (_itemUpLevel == 0) {
                ngay7 = 2;
                gio7 = 23;
                phut7 = 59;
                giay7 = 59;
            }
        }
        if (age7 > 2 && age7 < 3) {
            if (_itemUpLevel == 0) {
                ngay7 = 0;
                gio7 = 2;
                phut7 = 59;
                giay7 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly7, mood7);
            strength7 += 100 + bonus;
            size7 += 1000;
            size7 += bonus;
            sleeping7 = true;
            swipe7 = true;
            if (CLICK_PET == 7) {
                itm_runpa7.clearAnimation();
                fritm_runpa7.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age7 > 3 && age7 < 4) {
            sleeping7 = true;
            swipe7 = true;
            if (CLICK_PET == 7) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha7);
            handler.removeCallbacks(runnablemood7);
            handler.removeCallbacks(runnablehealth7);
            if (_itemUpLevel == 0) {
                ngay7 = 0;
                gio7 = 23;
                phut7 = 59;
                giay7 = 59;
            }
        }
        if (age7 > 4) {
            _TRUONGTHANH = 7;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup7 + "日");
                    textView22.setText("" + pre.getString("tenzukan7", "") + " " + "が成虫になりました！");
                    SettextNgay(age7);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge7);
        handler.removeCallbacks(runnable_UpAge27);
        handler.removeCallbacks(runnable_UpAge2Nho7);
        _USEITEM7 = 0;
        handler.post(runnable_timeUpAge7);
        if (CLICK_PET == 7)
            _StartEffect(imgzukan7);
        age7 += 1;
        if (strength7 > 1500)
            strength7 = 1500;
        life7 = strength7 * 10;
        activeitem.setText("");
        editor.putInt("useitem7", 0);
        editor.commit();
    }

    public void CheckUpage8() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age8 > 0 && age8 < 1) {
            if (_itemUpLevel == 0) {
                ngay8 = 1;
                gio8 = 23;
                phut8 = 59;
                giay8 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly8, mood8);
            strength8 += 100 + bonus;
            size8 += 1000;
        }
        if (age8 > 1 && age8 < 2) {
            if (_itemUpLevel == 0) {
                ngay8 = 2;
                gio8 = 23;
                phut8 = 59;
                giay8 = 59;
            }
        }
        if (age8 > 2 && age8 < 3) {
            if (_itemUpLevel == 0) {
                ngay8 = 0;
                gio8 = 2;
                phut8 = 59;
                giay8 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly8, mood8);
            strength8 += 100 + bonus;
            size8 += 1000;
            size8 += bonus;
            sleeping8 = true;
            swipe8 = true;
            if (CLICK_PET == 8) {
                itm_runpa8.clearAnimation();
                fritm_runpa8.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age8 > 3 && age8 < 4) {
            sleeping8 = true;
            swipe8 = true;
            if (CLICK_PET == 8) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha8);
            handler.removeCallbacks(runnablemood8);
            handler.removeCallbacks(runnablehealth8);
            if (_itemUpLevel == 0) {
                ngay8 = 0;
                gio8 = 23;
                phut8 = 59;
                giay8 = 59;
            }
        }
        if (age8 > 4) {
            _TRUONGTHANH = 8;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup8 + "日");
                    textView22.setText("" + pre.getString("tenzukan8", "") + " " + "が成虫になりました！");
                    SettextNgay(age8);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge8);
        handler.removeCallbacks(runnable_UpAge28);
        handler.removeCallbacks(runnable_UpAge2Nho8);
        _USEITEM8 = 0;
        handler.post(runnable_timeUpAge8);
        if (CLICK_PET == 8)
            _StartEffect(imgzukan8);
        age8 += 1;
        if (strength8 > 3000)
            strength8 = 3000;
        life8 = strength8 * 10;
        activeitem.setText("");
        editor.putInt("useitem8", 0);
        editor.commit();
    }

    public void CheckUpage3() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (age3 > 0 && age3 < 1) {
            if (_itemUpLevel == 0) {
                ngay3 = 1;
                gio3 = 23;
                phut3 = 59;
                giay3 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly3, mood3);
            strength3 += 100 + bonus;
            size3 += 1000;
        }
        if (age3 > 1 && age3 < 2) {
            if (_itemUpLevel == 0) {
                ngay3 = 2;
                gio3 = 23;
                phut3 = 59;
                giay3 = 59;
            }
        }
        if (age3 > 2 && age3 < 3) {
            if (_itemUpLevel == 0) {
                ngay3 = 0;
                gio3 = 2;
                phut3 = 59;
                giay3 = 59;
            }
            int bonus = Chat.bonusWithCondition(friendly3, mood3);
            strength3 += 100 + bonus;
            size3 += 1000;
            size3 += bonus;
            sleeping3 = true;
            swipe3 = true;
            if (CLICK_PET == 3) {
                itm_runpa3.clearAnimation();
                fritm_runpa3.setVisibility(View.GONE);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                imgupdown.setImageResource(R.drawable.bgup);
                HideAnimation();
            }
        }
        if (age3 > 3 && age3 < 4) {
            sleeping3 = true;
            swipe3 = true;
            if (CLICK_PET == 3) {
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
            handler.removeCallbacks(runnable_nha3);
            handler.removeCallbacks(runnablemood3);
            handler.removeCallbacks(runnablehealth3);
            if (_itemUpLevel == 0) {
                ngay3 = 0;
                gio3 = 23;
                phut3 = 59;
                giay3 = 59;
            }
        }

        if (age3 > 4) {
            _TRUONGTHANH = 3;
            try {
                finish_dialog.show();
                if (finish_dialog.isShowing()) {
                    txtngaychet.setText("" + ngayup3 + "日");
                    textView22.setText("" + pre.getString("tenzukan3", "") + " " + "が成虫になりました！");
                    SettextNgay(age3);
                    ShowFinish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        handler.removeCallbacks(runnable_timeUpAge3);
        handler.removeCallbacks(runnable_UpAge23);
        handler.removeCallbacks(runnable_UpAge2Nho3);
        _USEITEM3 = 0;
        handler.post(runnable_timeUpAge3);
        if (CLICK_PET == 3)
            _StartEffect(imgzukan3);
        age3 += 1;
        if (strength3 > 1000)
            strength3 = 1000;
        life3 = strength3 * 10;
        activeitem.setText("");
        editor.putInt("useitem3", 0);
        editor.commit();
    }

    public void set0value() {
        prolength_uong = 400;
        prolength = 400;
        prolength_nha = 400;

        ngay = 0;
        gio = 23;
        phut = 55;
        giay = 59;
        ngayup = 0;
        gioup = 0;
        phutup = 0;
        friendly = 0;
    }

    public void savetoshopsell() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        int hornNo = (int) ((float) life / 8000 * 7);
        int horn2No = (int) ((float) strength / 800 * 7);
        int wingNo = (int) ((float) friendly / 800 * 4);
        int headNo = (int) ((float) health / 800 * 7);
        int neckNo = (int) ((float) form / 800 * 4);
        int faceNo = (int) ((float) mood / 800 * 7);
        int bodyNo = (int) ((float) personality / 800 * 7);
        //
        int wingPrice = wingNo * 1000 / 10 * 3;
        int bodyPrice = bodyNo * 1000 / 10;
        int fHornPrice = hornNo * 1000 / 10 * 2;
        int headPrice = headNo * 1000 / 10;
        int facePrice = faceNo * 1000 / 10;
        int neckPrice = neckNo * 1000 / 10;
        int bHornPrice = horn2No * 1000 / 10 * 2;
        //
        int sum = wingPrice + bodyPrice + fHornPrice + headPrice + facePrice + neckPrice + bHornPrice;
        if (age > 4)
            islive = 2;
        if (age < 4)
            islive = 1;
        int phaseETime = ngayup * 24 * 60 * 60 + gioup * 60 * 60 + phutup * 60;
        int phaseTime = ngay * 24 * 60 * 60 + gio * 60 * 60 + phut * 60;
        if (neckNo > 2)
            neckNo = 2;
        if (hornNo > 6)
            hornNo = 6;
        if (wingNo > 3)
            wingNo = 3;
        if (headNo > 6)
            headNo = 6;
        if (faceNo > 4)
            faceNo = 4;
        if (bodyNo > 6)
            bodyNo = 6;
        if (neckNo < 0) neckNo = 0;
        if (hornNo < 0) hornNo = 0;
        if (horn2No < 0) horn2No = 0;
        if (wingNo < 0) wingNo = 0;
        if (headNo < 0) headNo = 0;
        if (faceNo < 0) faceNo = 0;
        if (bodyNo < 0) bodyNo = 0;
        db2.adddata(getApplicationContext(), pre.getString("tenzukan", ""), "カブトムシ", "" + life, "loai1", islive, 0, age, friendly,
                pre.getInt("mat1", 0), hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, personality,
                tieutien, prolength, prolength_sleep, phaseETime, strength, pre.getLong("bornTime", 1443158537),
                daitien, form, phaseTime, size, prolength_uong, health, mood, prolength_nha, lastCleanTime, pre.getString("id", ""),
                100, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
//        Log.e("TAG", "" + hornNo + ":" + horn2No + ":" + headNo + ":" + neckNo + ":" + bodyNo + ":" + wingNo + ":" + faceNo);
        if (hornNo < 0) hornNo = 0;
        if (horn2No < 0) horn2No = 0;
        if (headNo < 0) headNo = 0;
        if (neckNo < 0) neckNo = 0;
        if (bodyNo < 0) bodyNo = 0;
        if (wingNo < 0) wingNo = 0;
        if (faceNo < 0) faceNo = 0;
        savepart2(hornNo, horn2No, headNo, neckNo, bodyNo, wingNo, faceNo, _TRUONGTHANH, pre.getInt("mat1", 0), "100310");
        editor.putInt("mat1", 0);
        editor.putInt("no1", 1);
        editor.commit();
    }

    public void savepart2(int hornNo, int horn2No, int headNo, int neckNo, int bodyNo, int wingNo, int faceNo, int _TRUONGTHANH, int mat, String keymat) {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        savepart(hornNo, "0", _TRUONGTHANH);
        savepart(horn2No, "1", _TRUONGTHANH);
        savepart(headNo, "2", _TRUONGTHANH);
        savepart(neckNo, "4", _TRUONGTHANH);
        savepart(bodyNo, "5", _TRUONGTHANH);
        if (wingNo > 0)
            savepart(wingNo, "6", _TRUONGTHANH);
        if (mat == 0)
            savepart(faceNo, "3", _TRUONGTHANH);
        if (mat == 1) {
            int v = pre.getInt(keymat, 0) + 1;
            editor.putInt(keymat, v);
            long k = Long.parseLong(keymat);
            db2.update_Sumpart(k, v);
            for (int i = 0; i < _listTablePart.size(); i++) {
                if (_listTablePart.get(i).getName() == Integer.parseInt(keymat)) {
                    int _num = _listTablePart.get(i).getNum() + 1;
                    db2.update_Numpart(k, _num);
                }
            }
        }
        editor.commit();
    }

    public void savepart(int hornNo, String part2, int _TRUONGTHANH) {
        String part = "";
        if (_TRUONGTHANH == 1)
            part = "100";
        if (_TRUONGTHANH == 2)
            part = "110";
        if (_TRUONGTHANH == 3)
            part = "101";
        if (_TRUONGTHANH == 4)
            part = "111";
        if (_TRUONGTHANH == 5)
            part = "102";
        if (_TRUONGTHANH == 6)
            part = "112";
        if (_TRUONGTHANH == 7)
            part = "113";
        if (_TRUONGTHANH == 8)
            part = "103";
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        String key = part + part2 + "0" + hornNo;
        int value = pre.getInt(key, 0) + 1;
        long k = Long.parseLong(key);
//        Log.e("kkkkk", "k:" + key);
        db2.update_Sumpart(k, value);
        for (int i = 0; i < _listTablePart.size(); i++) {
            if (_listTablePart.get(i).getName() == Integer.parseInt(key)) {
                int _num = _listTablePart.get(i).getNum() + 1;
                db2.update_Numpart(k, _num);
            }
        }
        editor.putInt(key, value);
        editor.commit();
    }

    //---
    public void settempminus(int temp) {
        if (temp == 3) {
            btn19.setImageResource(R.drawable.temperature_m20);
            frcolor.setBackgroundColor(Color.parseColor("#597f00ff"));
        } else if (temp == 4) {
            btn19.setImageResource(R.drawable.temperature_m10);
            frcolor.setBackgroundColor(Color.parseColor("#4d7f00ff"));
        } else if (temp == 5) {
            btn19.setImageResource(R.drawable.temperature_p00);
            frcolor.setBackgroundColor(Color.parseColor("#337f00ff"));
        } else if (temp == 6) {
            btn19.setImageResource(R.drawable.temperature_p10);
            frcolor.setBackgroundColor(Color.parseColor("#00ff0000"));
        } else if (temp == 7) {
            btn19.setImageResource(R.drawable.temperature_p20);
            frcolor.setBackgroundColor(Color.parseColor("#0dff0000"));
        } else if (temp == 8) {
            btn19.setImageResource(R.drawable.temperature_p30);
            frcolor.setBackgroundColor(Color.parseColor("#1aff0000"));
        } else if (temp == 9) {
            btn19.setImageResource(R.drawable.temperature_p40);
            frcolor.setBackgroundColor(Color.parseColor("#26ff0000"));
        } else if (temp == 10) {
            btn19.setImageResource(R.drawable.temperature_p50);
            frcolor.setBackgroundColor(Color.parseColor("#33ff0000"));
        } else if (temp == 11) {
            btn19.setImageResource(R.drawable.temperature_p60);
            frcolor.setBackgroundColor(Color.parseColor("#40ff0000"));
        }
    }

    public void set1(boolean swipe, boolean sleeping, ImageView imgzukan, int temp) {
        if (swipe == false) {
            bglayout.setBackgroundResource(R.drawable.breeding_bg);
            ShowAnimation();
            imgupdown.setImageResource(R.drawable.bgdown);
        } else if (swipe == true) {
            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
            HideAnimation();
            imgupdown.setImageResource(R.drawable.bgup);
            if (sleeping == false)
                imgzukan.setVisibility(View.GONE);
        }
        if (temp == 3) {
            btn19.setImageResource(R.drawable.temperature_m20);
            frcolor.setBackgroundColor(Color.parseColor("#597f00ff"));
        } else if (temp == 4) {
            btn19.setImageResource(R.drawable.temperature_m10);
            frcolor.setBackgroundColor(Color.parseColor("#4d7f00ff"));
        } else if (temp == 5) {
            btn19.setImageResource(R.drawable.temperature_p00);
            frcolor.setBackgroundColor(Color.parseColor("#337f00ff"));
        } else if (temp == 6) {
            btn19.setImageResource(R.drawable.temperature_p10);
            frcolor.setBackgroundColor(Color.parseColor("#00ff0000"));
        } else if (temp == 7) {
            btn19.setImageResource(R.drawable.temperature_p20);
            frcolor.setBackgroundColor(Color.parseColor("#0dff0000"));
        } else if (temp == 8) {
            btn19.setImageResource(R.drawable.temperature_p30);
            frcolor.setBackgroundColor(Color.parseColor("#1aff0000"));
        } else if (temp == 9) {
            btn19.setImageResource(R.drawable.temperature_p40);
            frcolor.setBackgroundColor(Color.parseColor("#26ff0000"));
        } else if (temp == 10) {
            btn19.setImageResource(R.drawable.temperature_p50);
            frcolor.setBackgroundColor(Color.parseColor("#33ff0000"));
        } else if (temp == 11) {
            btn19.setImageResource(R.drawable.temperature_p60);
            frcolor.setBackgroundColor(Color.parseColor("#40ff0000"));
        }
    }

    int islive;

    public void _RESETGAME() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("_COUNTUONG", 400);
        editor.putInt("_COUNTAN", 400);
        editor.putInt("_COUNTNHA", 800);
        editor.putFloat("age", 0);
        editor.putInt("giay", 59);
        editor.putInt("phut", 59);
        editor.putInt("gio", 23);
        editor.putInt("ngay", 0);
        editor.putInt("friendly", 0);
        editor.putString("tenzukan", "");
        editor.putString("daload14s", "");
        editor.putInt("strength", 0);
        editor.putInt("friendly", 0);
        editor.putString("id", "");
        editor.putInt("txt25", 0);
        editor.putInt("phutup", 0);
        editor.putInt("gioup", 0);
        editor.putInt("ngayup", 0);
        editor.putInt("health", 800);
        editor.putInt("mood", 800);
        editor.putInt("daitien", 0);
        editor.putInt("tieutien", 0);
        editor.commit();
    }

    private PopupWindow pwindo;
    View layout;
    TextView txtsln, txtsll, txtsll2, txtsll3, txtsll4, txtn, txtl, txtl2, txtl3, txtl4, useforn, useforl;
    FrameLayout lnimgn, lnimgl, lnimgl2, lnimgl3, lnimgl4;
    ImageView imgn, imgl, imgl2, imgl3, imgl4, btnmypage;
    HorizontalScrollView scroll;

    private void initiatePopupWindow() {
        try {
            LayoutInflater inflater = (LayoutInflater) zukan_main.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.popup_layout,
                    (ViewGroup) findViewById(R.id.popup_element));
            layout.setBackgroundResource(R.drawable.breeding_food_bg2);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pwindo.isShowing())
                        pwindo.dismiss();
//                    Log.e("TAG", "click");
                }
            });
            pwindo = new PopupWindow(layout, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, true);
            pwindo.setFocusable(false);
            pwindo.setOutsideTouchable(true);
            int cao = (mypage._Height / 5) - 30;
            pwindo.showAtLocation(layout, Gravity.BOTTOM, 0, cao);
            scroll = (HorizontalScrollView) layout.findViewById(R.id.scroll);
            scroll.setHorizontalScrollBarEnabled(false);
            scroll.setHorizontalFadingEdgeEnabled(false);
            lnimgl = (FrameLayout) layout.findViewById(R.id.lnimgl);
            lnimgl2 = (FrameLayout) layout.findViewById(R.id.lnimgl2);
            lnimgl3 = (FrameLayout) layout.findViewById(R.id.lnimgl3);
            lnimgl4 = (FrameLayout) layout.findViewById(R.id.lnimgl4);
            lnimgn = (FrameLayout) layout.findViewById(R.id.lnimgn);
            FrameLayout frEnd = (FrameLayout) layout.findViewById(R.id.frEnd);
            FrameLayout frStart = (FrameLayout) layout.findViewById(R.id.frStart);
            frEnd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            frStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            txtn = (TextView) layout.findViewById(R.id.txtn);
            txtl = (TextView) layout.findViewById(R.id.txtl);
            txtl2 = (TextView) layout.findViewById(R.id.txtl2);
            txtl3 = (TextView) layout.findViewById(R.id.txtl3);
            txtl4 = (TextView) layout.findViewById(R.id.txtl4);
            txtsln = (TextView) layout.findViewById(R.id.txtsln);
            txtsll = (TextView) layout.findViewById(R.id.txtsll);
            useforn = (TextView) layout.findViewById(R.id.useforn);
            useforl = (TextView) layout.findViewById(R.id.useforl);
            txtsll2 = (TextView) layout.findViewById(R.id.txtsll2);
            txtsll3 = (TextView) layout.findViewById(R.id.txtsll3);
            txtsll4 = (TextView) layout.findViewById(R.id.txtsll4);
            imgn = (ImageView) layout.findViewById(R.id.imgn);
            imgl = (ImageView) layout.findViewById(R.id.imgl);
            imgl2 = (ImageView) layout.findViewById(R.id.imgl2);
            imgl3 = (ImageView) layout.findViewById(R.id.imgl3);
            imgl4 = (ImageView) layout.findViewById(R.id.imgl4);
            imgprepopup = (ImageView) layout.findViewById(R.id.imgpre);
            imgnextpopup = (ImageView) layout.findViewById(R.id.imgnext);
            imgprepopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(mypage.animScale);
                    scroll.fullScroll(HorizontalScrollView.FOCUS_LEFT);
                    v.setVisibility(View.GONE);
                    if (!imgnextpopup.isShown())
                        imgnextpopup.setVisibility(View.VISIBLE);
                }
            });
            imgnextpopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(mypage.animScale);
                    scroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
                    v.setVisibility(View.GONE);
                    if (!imgprepopup.isShown())
                        imgprepopup.setVisibility(View.VISIBLE);
                }
            });
            imgl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                    final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = pre.edit();
                    if (_CLICK == 1) {
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        if (_FOODBIG2 == 0) {
                            return;
                        }
                        _FOODBIG2--;
                        mypage.theluc--;
                        txtsll2.setText("" + _FOODBIG2);
                        exp += 1;
                        if (CLICK_PET == 1) {
                            if (prolength != 1) {
                                prolength = (int) (progressBar3.getProgress() + rankpet1(age));
                                if (prolength > rankpet1(age))
                                    prolength = rankpet1(age);
                                progressBar3.setProgress(prolength);
                                mood += 100 * 2;
                                if (mood > 800)
                                    mood = 800;
                                health += 100 * 2;
                                if (health > 800)
                                    health = 800;
                                prolength_sleep += 100 * 2;
                                if (prolength_sleep > 800)
                                    prolength_sleep = 800;
                            }
                            _an(age, sleeping, swipe, imgzukan, txtan, runnable_action, runnable_sleep);
                            daitien += 300;
                            if (daitien > rankpet1(age))
                                daitien = 0;
                            friendly += 10 * 2;
                            if (friendly >= 800)
                                friendly = 800;
                            life += 3000;
                            if (life > 800)
                                life = 800;
                        } else if (CLICK_PET == 3) {
                            if (prolength3 != 1) {
                                prolength3 = (int) (progressBar33.getProgress() + Chat.rankpet3(age3));
                                if (prolength3 > Chat.rankpet3(age3))
                                    prolength3 = Chat.rankpet3(age3);
                                progressBar33.setProgress(prolength3);
                                mood3 += 200;
                                if (mood3 > 1000)
                                    mood3 = 1000;
                                health3 += 200;
                                if (health3 > 1000)
                                    health3 = 1000;
                                prolength_sleep3 -= 200;
                                if (prolength_sleep3 < 5)
                                    prolength_sleep3 = 5;
                            }
                            _an(age3, sleeping3, swipe3, imgzukan3, txtan3, runnable_action3, runnable_sleep3);
                            daitien3 += 300;
                            if (daitien3 > Chat.rankpet3(age3))
                                daitien3 = 0;
                            life3 += 3000;
                            if (life3 > 1000)
                                life3 = 1000;
                            friendly3 += 10 * 2;
                            if (friendly3 > 1000)
                                friendly3 = 1000;
                        } else if (CLICK_PET == 5) {
                            if (prolength5 != 1) {
                                prolength5 = (int) (progressBar35.getProgress() + Chat.rankpet4(age5));
                                if (prolength5 > Chat.rankpet4(age5))
                                    prolength5 = Chat.rankpet4(age5);
                                progressBar35.setProgress(prolength5);
                                mood5 += 200;
                                if (mood5 > 2000)
                                    mood5 = 2000;
                                health5 += 200;
                                if (health5 > 2000)
                                    health5 = 2000;
                                prolength_sleep5 -= 200;
                                if (prolength_sleep5 < 5)
                                    prolength_sleep5 = 5;
                            }
                            _an(age5, sleeping5, swipe5, imgzukan5, txtan5, runnable_action5, runnable_sleep5);
                            daitien5 += 300;
                            if (daitien5 > Chat.rankpet4(age5))
                                daitien5 = 0;
                            life5 += 3000;
                            if (life5 > 2000)
                                life5 = 2000;
                            friendly5 += 10 * 2;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                        } else if (CLICK_PET == 7) {
                            if (prolength7 != 1) {
                                prolength7 = (int) (progressBar37.getProgress() + Chat.rankpet7(age7));
                                if (prolength7 > Chat.rankpet7(age7))
                                    prolength7 = Chat.rankpet7(age7);
                                progressBar37.setProgress(prolength7);
                                mood7 += 200;
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += 200;
                                if (health7 > 1500)
                                    health7 = 1500;
                                prolength_sleep7 -= 200;
                                if (prolength_sleep7 < 5)
                                    prolength_sleep7 = 5;
                            }
                            _an2(age7, sleeping7, swipe7, imgzukan7, txtan7, runnable_action7, runnable_sleep7);
                            daitien7 += 300;
                            if (daitien7 > Chat.rankpet7(age7))
                                daitien7 = 0;
                            life7 += 3000;
                            if (life7 > 1500)
                                life7 = 1500;
                            friendly7 += 10 * 2;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                        }
                        txtsll2.setText("" + _FOODBIG2);
                        editor.putInt("01013", _FOODBIG2);
                        editor.commit();
                        _ButtonDisable();
                    } else if (_CLICK == 3) {
                        final Dialog dialog = new Dialog(zukan_main.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setContentView(R.layout.createpet);
                        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                        Button btnno = (Button) dialog.findViewById(R.id.btnno);
                        TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                        textView20.setText("確認");
                        TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                        textView18.setText("若返りの薬[幼虫用]を使用しますか？");
                        btnyes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                if (CLICK_PET == 1) {
                                    if (age < 1 && pre.getString("daload14s", "").length() > 0) {
                                        editor.putString("daload14s", "");
                                        editor.commit();
                                        handler.removeCallbacks(runnable);
                                        handler.removeCallbacks(runnable_uong);
                                        handler.removeCallbacks(runnable_nha);
                                        handler.removeCallbacks(runnable_sleep);
                                        handler.removeCallbacks(runnablehealth);
                                        handler.removeCallbacks(runnablemood);
                                        handler.removeCallbacks(dt);
                                        handler.removeCallbacks(runnable_timeUpAge);
                                        handler.removeCallbacks(runnable_action);
                                        _Load14s();
                                    } else if (age >= 1)
                                        age--;
                                } else if (CLICK_PET == 2) {
                                    if (age2 < 1 && pre.getString("daload14s2", "").length() > 0) {
                                        editor.putString("daload14s2", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age2);
                                        handler.removeCallbacks(runnable2);
                                        handler.removeCallbacks(runnable_uong2);
                                        handler.removeCallbacks(runnable_nha2);
                                        handler.removeCallbacks(runnable_sleep2);
                                        handler.removeCallbacks(runnablehealth2);
                                        handler.removeCallbacks(runnablemood2);
                                        handler.removeCallbacks(dt2);
                                        handler.removeCallbacks(runnable_timeUpAge2);
                                        handler.removeCallbacks(runnable_action2);
                                        _Load14s2();
                                    } else if (age2 >= 1)
                                        age2--;
                                } else if (CLICK_PET == 3) {
                                    if (age3 < 1 && pre.getString("daload14s3", "").length() > 0) {
                                        editor.putString("daload14s3", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age3);
                                        handler.removeCallbacks(runnable3);
                                        handler.removeCallbacks(runnable_uong3);
                                        handler.removeCallbacks(runnable_nha3);
                                        handler.removeCallbacks(runnable_sleep3);
                                        handler.removeCallbacks(runnablehealth3);
                                        handler.removeCallbacks(runnablemood3);
                                        handler.removeCallbacks(dt3);
                                        handler.removeCallbacks(runnable_timeUpAge3);
                                        handler.removeCallbacks(runnable_action3);
                                        _Load14s3();
                                    } else if (age3 >= 1)
                                        age3--;
                                } else if (CLICK_PET == 4) {
                                    if (age4 < 1 && pre.getString("daload14s4", "").length() > 0) {
                                        editor.putString("daload14s4", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age4);
                                        handler.removeCallbacks(runnable4);
                                        handler.removeCallbacks(runnable_uong4);
                                        handler.removeCallbacks(runnable_nha4);
                                        handler.removeCallbacks(runnable_sleep4);
                                        handler.removeCallbacks(runnablehealth4);
                                        handler.removeCallbacks(runnablemood4);
                                        handler.removeCallbacks(dt4);
                                        handler.removeCallbacks(runnable_timeUpAge4);
                                        handler.removeCallbacks(runnable_action4);
                                        _Load14s4();
                                    } else if (age4 >= 1)
                                        age4--;
                                } else if (CLICK_PET == 5) {
                                    if (age5 < 1 && pre.getString("daload14s5", "").length() > 0) {
                                        editor.putString("daload14s5", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age5);
                                        handler.removeCallbacks(runnable5);
                                        handler.removeCallbacks(runnable_uong5);
                                        handler.removeCallbacks(runnable_nha5);
                                        handler.removeCallbacks(runnable_sleep5);
                                        handler.removeCallbacks(runnablehealth5);
                                        handler.removeCallbacks(runnablemood5);
                                        handler.removeCallbacks(dt5);
                                        handler.removeCallbacks(runnable_timeUpAge5);
                                        handler.removeCallbacks(runnable_action5);
                                        _Load14s5();
                                    } else if (age5 >= 1)
                                        age5--;
                                } else if (CLICK_PET == 6) {
                                    if (age6 < 1 && pre.getString("daload14s6", "").length() > 0) {
                                        editor.putString("daload14s6", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age6);
                                        handler.removeCallbacks(runnable6);
                                        handler.removeCallbacks(runnable_uong6);
                                        handler.removeCallbacks(runnable_nha6);
                                        handler.removeCallbacks(runnable_sleep6);
                                        handler.removeCallbacks(runnablehealth6);
                                        handler.removeCallbacks(runnablemood6);
                                        handler.removeCallbacks(dt6);
                                        handler.removeCallbacks(runnable_timeUpAge6);
                                        handler.removeCallbacks(runnable_action6);
                                        _Load14s6();
                                    } else if (age6 >= 1)
                                        age6--;
                                } else if (CLICK_PET == 7) {
                                    if (age7 < 1 && pre.getString("daload14s7", "").length() > 0) {
                                        editor.putString("daload14s7", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age7);
                                        handler.removeCallbacks(runnable7);
                                        handler.removeCallbacks(runnable_uong7);
                                        handler.removeCallbacks(runnable_nha7);
                                        handler.removeCallbacks(runnable_sleep7);
                                        handler.removeCallbacks(runnablehealth7);
                                        handler.removeCallbacks(runnablemood7);
                                        handler.removeCallbacks(dt7);
                                        handler.removeCallbacks(runnable_timeUpAge7);
                                        handler.removeCallbacks(runnable_action7);
                                        _Load14s7();
                                    } else if (age7 >= 1)
                                        age7--;
                                } else if (CLICK_PET == 8) {
                                    if (age8 < 1 && pre.getString("daload14s8", "").length() > 0) {
                                        editor.putString("daload14s8", "");
                                        editor.commit();
                                        handler.removeCallbacks(run_age8);
                                        handler.removeCallbacks(runnable8);
                                        handler.removeCallbacks(runnable_uong8);
                                        handler.removeCallbacks(runnable_nha8);
                                        handler.removeCallbacks(runnable_sleep8);
                                        handler.removeCallbacks(runnablehealth8);
                                        handler.removeCallbacks(runnablemood8);
                                        handler.removeCallbacks(dt8);
                                        handler.removeCallbacks(runnable_timeUpAge8);
                                        handler.removeCallbacks(runnable_action8);
                                        _Load14s8();
                                    } else if (age8 >= 1)
                                        age8--;
                                }
                                _ITEMBIG3--;
                                txtsll2.setText("x " + _ITEMBIG3);
                                editor.putInt("03005", _ITEMBIG3);
                                editor.commit();
                            }
                        });
                        btnno.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    }
                }
            });
            imgl3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    final SharedPreferences.Editor editor = pre.edit();
                    if (_CLICK == 1) {
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        if (_FOODBIG3 == 0) {
                            return;
                        }
                        _FOODBIG3--;
                        mypage.theluc--;
                        txtsll3.setText("" + _FOODBIG3);
                        exp += 1;
                        if (CLICK_PET == 2) {
                            if (prolength2 != 1) {
                                prolength2 = (int) (progressBar32.getProgress() + rankpet1(age2));
                                if (prolength2 > rankpet1(age2))
                                    prolength2 = rankpet1(age2);
                                progressBar32.setProgress(prolength2);
                                mood2 += 200;
                                if (mood2 > 800)
                                    mood2 = 800;
                                health2 += 200;
                                if (health2 > 800)
                                    health2 = 800;
                                prolength_sleep2 -= 200;
                                if (prolength_sleep2 < 5)
                                    prolength_sleep2 = 5;
                            }
                            _an2(age2, sleeping2, swipe2, imgzukan2, txtan2, runnable_action2, runnable_sleep2);
                            daitien2 += 300;
                            if (daitien2 > rankpet1(age2))
                                daitien2 = 0;
                            life2 += 3000;
                            if (life2 > 800)
                                life2 = 800;
                            friendly2 += 10 * 2;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                        } else if (CLICK_PET == 4) {
                            if (prolength4 != 1) {
                                prolength4 = (int) (progressBar34.getProgress() + Chat.rankpet4(age4));
                                if (prolength4 > Chat.rankpet4(age4))
                                    prolength4 = Chat.rankpet4(age4);
                                progressBar34.setProgress(prolength4);
                                mood4 += 200;
                                if (mood4 > 2000)
                                    mood4 = 2000;
                                health4 += 200;
                                if (health4 > 2000)
                                    health4 = 2000;
                                prolength_sleep4 -= 200;
                                if (prolength_sleep4 < 5)
                                    prolength_sleep4 = 5;
                            }
                            _an2(age4, sleeping4, swipe4, imgzukan4, txtan4, runnable_action4, runnable_sleep4);
                            daitien4 += 300;
                            if (daitien4 > Chat.rankpet4(age4))
                                daitien4 = 0;
                            life4 += 3000;
                            if (life4 > 2000)
                                life4 = 2000;
                            friendly4 += 10 * 2;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                        } else if (CLICK_PET == 6) {
                            if (prolength6 != 1) {
                                prolength6 = (int) (progressBar36.getProgress() + Chat.rankpet4(age6));
                                if (prolength6 > Chat.rankpet4(age6))
                                    prolength6 = Chat.rankpet4(age6);
                                progressBar36.setProgress(prolength6);
                                mood6 += 200;
                                if (mood6 > 2000)
                                    mood6 = 2000;
                                health6 += 200;
                                if (health6 > 2000)
                                    health6 = 2000;
                                prolength_sleep6 -= 200;
                                if (prolength_sleep6 < 5)
                                    prolength_sleep6 = 5;
                            }
                            _an2(age6, sleeping6, swipe6, imgzukan6, txtan6, runnable_action6, runnable_sleep6);
                            daitien6 += 300;
                            if (daitien6 > Chat.rankpet4(age6))
                                daitien6 = 0;
                            life6 += 3000;
                            if (life6 > 2000)
                                life6 = 2000;
                            friendly6 += 10 * 2;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                        } else if (CLICK_PET == 7) {
                            if (prolength7 != 1) {
                                prolength7 = (int) (progressBar37.getProgress() + Chat.rankpet7(age7));
                                if (prolength7 > Chat.rankpet7(age7))
                                    prolength7 = Chat.rankpet7(age7);
                                progressBar37.setProgress(prolength7);
                                mood7 += 200;
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += 200;
                                if (health7 > 1500)
                                    health7 = 1500;
                                prolength_sleep7 -= 200;
                                if (prolength_sleep7 < 5)
                                    prolength_sleep7 = 5;
                            }
                            _an2(age7, sleeping7, swipe7, imgzukan7, txtan7, runnable_action7, runnable_sleep7);
                            daitien7 += 300;
                            if (daitien7 > Chat.rankpet7(age7))
                                daitien7 = 0;
                            life7 += 3000;
                            if (life7 > 1500)
                                life7 = 1500;
                            friendly7 += 10 * 2;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                        }
                        txtsll3.setText("" + _FOODBIG3);
                        editor.putInt("01014", _FOODBIG3);
                        editor.commit();
                        _ButtonDisable();
                    } else if (_CLICK == 3) {
                        final Dialog dialog = new Dialog(zukan_main.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setContentView(R.layout.createpet);
                        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                        TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                        textView20.setText("確認");
                        Button btnno = (Button) dialog.findViewById(R.id.btnno);
                        TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                        textView18.setText("進化の薬[幼虫用]を使用しますか？");
                        btnyes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                if (CLICK_PET == 1) {
                                    _itemUpLevel = 1;
                                    CheckUpAge();
                                } else if (CLICK_PET == 2) {
                                    _itemUpLevel = 1;
                                    CheckUpage2();
                                } else if (CLICK_PET == 3) {
                                    _itemUpLevel = 1;
                                    CheckUpage3();
                                } else if (CLICK_PET == 4) {
                                    _itemUpLevel = 1;
                                    CheckUpage4();
                                } else if (CLICK_PET == 5) {
                                    _itemUpLevel = 1;
                                    CheckUpage5();
                                } else if (CLICK_PET == 6) {
                                    _itemUpLevel = 1;
                                    CheckUpage6();
                                } else if (CLICK_PET == 7) {
                                    _itemUpLevel = 1;
                                    CheckUpage7();
                                } else if (CLICK_PET == 8) {
                                    _itemUpLevel = 1;
                                    CheckUpage8();
                                }
                                _ITEMBIG4--;
                                _itemUpLevel = 0;
                                txtsll4.setText("" + _ITEMBIG4);
                                editor.putInt("03006", _ITEMBIG4);
                                editor.commit();
                            }
                        });
                        btnno.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    }
                }
            });
            imgl4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                    final Dialog dialog = new Dialog(zukan_main.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialog.setContentView(R.layout.createpet);
                    Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                    Button btnno = (Button) dialog.findViewById(R.id.btnno);
                    TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                    textView20.setText("確認");
                    TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                    textView18.setText("酸素カプセル[幼虫用]を使用しますか？");
                    btnyes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                            SharedPreferences.Editor editor = pre.edit();
                            _ITEMBIG5--;
                            txtsll4.setText("x " + _ITEMBIG5);
                            editor.putInt("03007", _ITEMBIG5);
                            editor.commit();
                            if (CLICK_PET == 1) {
                                mood = 800;
                                health += 800 * 0.5;
                                if (health > 800)
                                    health = 800;
                                prolength = (int) (progressBar3.getProgress() + rankpet1(age) * 0.5);
                                if (prolength > rankpet1(age))
                                    prolength = rankpet1(age);
                                progressBar3.setProgress(prolength);
                            } else if (CLICK_PET == 2) {
                                mood2 = 800;
                                health2 += 800 * 0.5;
                                if (health2 > 800)
                                    health2 = 800;
                                prolength2 = (int) (progressBar32.getProgress() + rankpet1(age2) * 0.5);
                                if (prolength2 > rankpet1(age2))
                                    prolength2 = rankpet1(age2);
                                progressBar32.setProgress(prolength2);
                            } else if (CLICK_PET == 3) {
                                mood3 = 1000;
                                health3 += 1000 * 0.5;
                                if (health3 > 1000)
                                    health3 = 1000;
                                prolength3 = (int) (progressBar33.getProgress() + Chat.rankpet3(age3) * 0.5);
                                if (prolength3 > Chat.rankpet3(age3))
                                    prolength3 = Chat.rankpet3(age3);
                                progressBar33.setProgress(prolength3);
                            } else if (CLICK_PET == 4) {
                                mood4 = 2000;
                                health4 += 2000 * 0.5;
                                if (health4 > 2000)
                                    health4 = 2000;
                                prolength4 = (int) (progressBar34.getProgress() + Chat.rankpet4(age4) * 0.5);
                                if (prolength4 > Chat.rankpet4(age4))
                                    prolength4 = Chat.rankpet4(age4);
                                progressBar34.setProgress(prolength4);
                            } else if (CLICK_PET == 5) {
                                mood5 = 2000;
                                health5 += 2000 * 0.5;
                                if (health5 > 2000)
                                    health5 = 2000;
                                prolength5 = (int) (progressBar35.getProgress() + Chat.rankpet4(age5) * 0.5);
                                if (prolength5 > Chat.rankpet4(age5))
                                    prolength5 = Chat.rankpet4(age5);
                                progressBar35.setProgress(prolength5);
                            } else if (CLICK_PET == 6) {
                                mood6 = 2000;
                                health6 += 2000 * 0.5;
                                if (health6 > 2000)
                                    health6 = 2000;
                                prolength6 = (int) (progressBar36.getProgress() + Chat.rankpet4(age6) * 0.5);
                                if (prolength6 > Chat.rankpet4(age6))
                                    prolength6 = Chat.rankpet4(age6);
                                progressBar36.setProgress(prolength6);
                            } else if (CLICK_PET == 7) {
                                mood7 = 1500;
                                health7 += 1500 * 0.5;
                                if (health7 > 1500)
                                    health7 = 1500;
                                prolength7 = (int) (progressBar37.getProgress() + Chat.rankpet7(age7) * 0.5);
                                if (prolength7 > Chat.rankpet7(age7))
                                    prolength7 = Chat.rankpet7(age7);
                                progressBar37.setProgress(prolength7);
                            } else if (CLICK_PET == 8) {
                                mood8 = 3000;
                                health8 += 3000 * 0.5;
                                if (health8 > 3000)
                                    health8 = 3000;
                                prolength8 = (int) (progressBar38.getProgress() + Chat.rankpet8(age8) * 0.5);
                                if (prolength8 > Chat.rankpet8(age8))
                                    prolength8 = Chat.rankpet8(age8);
                                progressBar38.setProgress(prolength8);
                            }
                        }
                    });
                    btnno.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }
            });
            imgl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Random r = new Random();
                    int right = r.nextInt(2);
                    pwindo.dismiss();
                    int rank = (int) calcRank(size, health, mood, form, strength, personality);
                    double ratio2 = Chat.ratio2(rank);
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pre.edit();
                    if (_CLICK == 1) {
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        if (_FOODBIG == 0) {
                            return;
                        }
                        _FOODBIG--;
                        mypage.theluc--;
                        txtsll.setText("" + _FOODBIG);
                        exp += 1;
                        if (CLICK_PET == 1) {
                            if (prolength != 1) {
                                prolength = (int) (progressBar3.getProgress() + rankpet1(age));
                                if (prolength > rankpet1(age))
                                    prolength = rankpet1(age);
                                progressBar3.setProgress(prolength);
                                mood += 100 * 2;
                                if (mood > 800)
                                    mood = 800;
                                health += 100 * 2;
                                if (health > 800)
                                    health = 800;
                                prolength_sleep += 100 * 2;
                                if (prolength_sleep > 800)
                                    prolength_sleep = 800;
                            }
                            _an(age, sleeping, swipe, imgzukan, txtan, runnable_action, runnable_sleep);
                            daitien += 300;
                            if (daitien > rankpet1(age))
                                daitien = 0;
                            friendly += 10 * 2;
                            if (friendly >= 800)
                                friendly = 800;
                            life += 3000;
                            if (life > 800)
                                life = 800;
                        } else if (CLICK_PET == 2) {
                            if (prolength2 != 1) {
                                prolength2 = (int) (progressBar32.getProgress() + rankpet1(age2));
                                if (prolength2 > rankpet1(age2))
                                    prolength2 = rankpet1(age2);
                                progressBar32.setProgress(prolength2);
                                mood2 += 200;
                                if (mood2 > 800)
                                    mood2 = 800;
                                health2 += 200;
                                if (health2 > 800)
                                    health2 = 800;
                                prolength_sleep2 -= 200;
                                if (prolength_sleep2 < 5)
                                    prolength_sleep2 = 5;
                            }
                            _an2(age2, sleeping2, swipe2, imgzukan2, txtan2, runnable_action2, runnable_sleep2);
                            daitien2 += 300;
                            if (daitien2 > rankpet1(age2))
                                daitien2 = 0;
                            life2 += 3000;
                            if (life2 > 800)
                                life2 = 800;
                            friendly2 += 10 * 2;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                        } else if (CLICK_PET == 3) {
                            if (prolength3 != 1) {
                                prolength3 = (int) (progressBar33.getProgress() + Chat.rankpet3(age3));
                                if (prolength3 > Chat.rankpet3(age3))
                                    prolength3 = Chat.rankpet3(age3);
                                progressBar33.setProgress(prolength3);
                                mood3 += 200;
                                if (mood3 > 1000)
                                    mood3 = 1000;
                                health3 += 200;
                                if (health3 > 1000)
                                    health3 = 1000;
                                prolength_sleep3 -= 200;
                                if (prolength_sleep3 < 5)
                                    prolength_sleep3 = 5;
                            }
                            _an(age3, sleeping3, swipe3, imgzukan3, txtan3, runnable_action3, runnable_sleep3);
                            daitien3 += 300;
                            if (daitien3 > Chat.rankpet3(age3))
                                daitien3 = 0;
                            life3 += 3000;
                            if (life3 > 1000)
                                life3 = 1000;
                            friendly3 += 10 * 2;
                            if (friendly3 > 1000)
                                friendly3 = 1000;
                        } else if (CLICK_PET == 4) {
                            if (prolength4 != 1) {
                                prolength4 = (int) (progressBar34.getProgress() + Chat.rankpet4(age4));
                                if (prolength4 > Chat.rankpet4(age4))
                                    prolength4 = Chat.rankpet4(age4);
                                progressBar34.setProgress(prolength4);
                                mood4 += 200;
                                if (mood4 > 2000)
                                    mood4 = 2000;
                                health4 += 200;
                                if (health4 > 2000)
                                    health4 = 2000;
                                prolength_sleep4 -= 200;
                                if (prolength_sleep4 < 5)
                                    prolength_sleep4 = 5;
                            }
                            _an2(age4, sleeping4, swipe4, imgzukan4, txtan4, runnable_action4, runnable_sleep4);
                            daitien4 += 300;
                            if (daitien4 > Chat.rankpet4(age4))
                                daitien4 = 0;
                            life4 += 3000;
                            if (life4 > 2000)
                                life4 = 2000;
                            friendly4 += 10 * 2;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                        } else if (CLICK_PET == 5) {
                            if (prolength5 != 1) {
                                prolength5 = (int) (progressBar35.getProgress() + Chat.rankpet4(age5));
                                if (prolength5 > Chat.rankpet4(age5))
                                    prolength5 = Chat.rankpet4(age5);
                                progressBar35.setProgress(prolength5);
                                mood5 += 200;
                                if (mood5 > 2000)
                                    mood5 = 2000;
                                health5 += 200;
                                if (health5 > 2000)
                                    health5 = 2000;
                                prolength_sleep5 -= 200;
                                if (prolength_sleep5 < 5)
                                    prolength_sleep5 = 5;
                            }
                            _an(age5, sleeping5, swipe5, imgzukan5, txtan5, runnable_action5, runnable_sleep5);
                            daitien5 += 300;
                            if (daitien5 > Chat.rankpet4(age5))
                                daitien5 = 0;
                            life5 += 3000;
                            if (life5 > 2000)
                                life5 = 2000;
                            friendly5 += 10 * 2;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                        } else if (CLICK_PET == 6) {
                            if (prolength6 != 1) {
                                prolength6 = (int) (progressBar36.getProgress() + Chat.rankpet4(age6));
                                if (prolength6 > Chat.rankpet4(age6))
                                    prolength6 = Chat.rankpet4(age6);
                                progressBar36.setProgress(prolength6);
                                mood6 += 200;
                                if (mood6 > 2000)
                                    mood6 = 2000;
                                health6 += 200;
                                if (health6 > 2000)
                                    health6 = 2000;
                                prolength_sleep6 -= 200;
                                if (prolength_sleep6 < 5)
                                    prolength_sleep6 = 5;
                            }
                            _an2(age6, sleeping6, swipe6, imgzukan6, txtan6, runnable_action6, runnable_sleep6);
                            daitien6 += 300;
                            if (daitien6 > Chat.rankpet4(age6))
                                daitien6 = 0;
                            life6 += 3000;
                            if (life6 > 2000)
                                life6 = 2000;
                            friendly6 += 10 * 2;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                        } else if (CLICK_PET == 7) {
                            if (prolength7 != 1) {
                                prolength7 = (int) (progressBar37.getProgress() + Chat.rankpet7(age7));
                                if (prolength7 > Chat.rankpet7(age7))
                                    prolength7 = Chat.rankpet7(age7);
                                progressBar37.setProgress(prolength7);
                                mood7 += 200;
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += 200;
                                if (health7 > 1500)
                                    health7 = 1500;
                                prolength_sleep7 -= 200;
                                if (prolength_sleep7 < 5)
                                    prolength_sleep7 = 5;
                            }
                            _an2(age7, sleeping7, swipe7, imgzukan7, txtan7, runnable_action7, runnable_sleep7);
                            daitien7 += 300;
                            if (daitien7 > Chat.rankpet7(age7))
                                daitien7 = 0;
                            life7 += 3000;
                            if (life7 > 1500)
                                life7 = 1500;
                            friendly7 += 10 * 2;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                        } else if (CLICK_PET == 8) {
                            if (prolength8 != 1) {
                                prolength8 = (int) (progressBar38.getProgress() + Chat.rankpet8(age8));
                                if (prolength8 > Chat.rankpet8(age8))
                                    prolength8 = Chat.rankpet8(age8);
                                progressBar38.setProgress(prolength8);
                                mood8 += 200;
                                if (mood8 > 3000)
                                    mood8 = 3000;
                                health8 += 200;
                                if (health8 > 3000)
                                    health8 = 3000;
                                prolength_sleep8 -= 200;
                                if (prolength_sleep8 < 5)
                                    prolength_sleep8 = 5;
                            }
                            _an(age8, sleeping8, swipe8, imgzukan8, txtan8, runnable_action8, runnable_sleep8);
                            daitien8 += 300;
                            if (daitien8 > Chat.rankpet8(age8))
                                daitien8 = 0;
                            life8 += 3000;
                            if (life8 > 3000)
                                life8 = 3000;
                            friendly8 += 10 * 2;
                            if (friendly8 >= 3000)
                                friendly8 = 3000;
                        }
                        txtsll.setText("" + _FOODBIG);
                        editor.putInt("01003", _FOODBIG);
                        editor.commit();
                        _ButtonDisable();
                    } else if (_CLICK == 2) {
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        if (_DRINKBIG == 0) {
                            return;
                        }
                        _DRINKBIG--;
                        mypage.theluc--;
                        txtsll.setText("" + _DRINKBIG);
                        exp += 1;
                        txtsll.setText("" + _DRINKBIG);
                        editor.putInt("00003", _DRINKBIG);
                        editor.commit();
                        if (CLICK_PET == 1) {
                            if (prolength_uong != 1) {
                                prolength_uong += (int) (prolength_uong + 200 * 2);
                                if (prolength_uong > rankpet1(age))
                                    prolength_uong = rankpet1(age);
                                mood += (int) (mood + 100 * 2);
                                if (mood > 800)
                                    mood = 800;
                                health += (int) (health + 100 * 2);
                                if (health > 800)
                                    health = 800;
                            }
                            friendly += 10 * 2;
                            if (friendly >= 800)
                                friendly = 800;
                            if (right == 0)
                                _uong(age, swipe, sleeping, imgzukan, runnable_action, runnable_sleep);
                            else if (right == 1)
                                _uongr(age, swipe, sleeping, imgzukan, runnable_action, runnable_sleep);
                            life += 500 * 2;
                            if (life > 1000)
                                life = 1000;
                        } else if (CLICK_PET == 2) {
                            if (prolength_uong2 != 1) {
                                prolength_uong2 += 200 * 2;
                                if (prolength_uong2 > rankpet1(age2))
                                    prolength_uong2 = rankpet1(age2);
                                mood2 += (int) (mood2 + 100 * 2);
                                if (mood2 > 800)
                                    mood2 = 800;
                                health2 += (int) (health2 + 100 * 2);
                                if (health2 > 800)
                                    health2 = 800;
                            }
                            friendly2 += 200;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                            if (right == 0)
                                _uong2(age2, swipe2, sleeping2, imgzukan2, runnable_action2, runnable_sleep2);
                            else if (right == 1)
                                _uong2r(age2, swipe2, sleeping2, imgzukan2, runnable_action2, runnable_sleep2);
                        } else if (CLICK_PET == 3) {
                            if (prolength_uong3 != 1) {
                                prolength_uong3 += (int) (prolength_uong3 + 200 * 2);
                                if (prolength_uong3 > Chat.rankpet3(age3))
                                    prolength_uong3 = Chat.rankpet3(age3);
                                mood3 += (int) (mood3 + 100 * 2);
                                if (mood3 > 1000)
                                    mood3 = 1000;
                                health3 += (int) (health3 + 100 * 2);
                                if (health3 > 1000)
                                    health3 = 1000;
                            }
                            friendly3 += 200;
                            if (friendly3 >= 1000)
                                friendly3 = 1000;
                            if (right == 0)
                                _uong(age3, swipe3, sleeping3, imgzukan3, runnable_action3, runnable_sleep3);
                            else if (right == 1)
                                _uongr(age3, swipe3, sleeping3, imgzukan3, runnable_action3, runnable_sleep3);
                        } else if (CLICK_PET == 4) {
                            if (prolength_uong4 != 1) {
                                prolength_uong4 += (int) (prolength_uong4 + 200 * 2);
                                if (prolength_uong4 > Chat.rankpet4(age4))
                                    prolength_uong4 = Chat.rankpet4(age4);
                                mood4 += (int) (mood4 + 100 * 2);
                                if (mood4 > 2000)
                                    mood4 = 2000;
                                health4 += (int) (health4 + 100 * 2);
                                if (health4 > 2000)
                                    health4 = 2000;
                            }
                            friendly4 += 20;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                            if (right == 0)
                                _uong2(age4, swipe4, sleeping4, imgzukan4, runnable_action4, runnable_sleep4);
                            else if (right == 1)
                                _uong2r(age4, swipe4, sleeping4, imgzukan4, runnable_action4, runnable_sleep4);
                        } else if (CLICK_PET == 5) {
                            if (prolength_uong5 != 1) {
                                prolength_uong5 += (int) (prolength_uong5 + 200 * 2);
                                if (prolength_uong5 > Chat.rankpet4(age5))
                                    prolength_uong5 = Chat.rankpet4(age5);
                                mood5 += (int) (mood5 + 100 * 2);
                                if (mood5 > 2000)
                                    mood5 = 2000;
                                health5 += (int) (health5 + 100 * 2);
                                if (health5 > 2000)
                                    health5 = 2000;
                            }
                            friendly5 += 20;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                            if (right == 0)
                                _uong(age5, swipe5, sleeping5, imgzukan5, runnable_action5, runnable_sleep5);
                            else if (right == 1)
                                _uongr(age5, swipe5, sleeping5, imgzukan5, runnable_action5, runnable_sleep5);
                        } else if (CLICK_PET == 6) {
                            if (prolength_uong6 != 1) {
                                prolength_uong6 += (int) (prolength_uong6 + 200 * 2);
                                if (prolength_uong6 > Chat.rankpet4(age6))
                                    prolength_uong6 = Chat.rankpet4(age6);
                                mood6 += (int) (mood6 + 100 * 2);
                                if (mood6 > 2000)
                                    mood6 = 2000;
                                health6 += (int) (health6 + 100 * 2);
                                if (health6 > 2000)
                                    health6 = 2000;
                            }
                            friendly6 += 200;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                            if (right == 0)
                                _uong2(age6, swipe6, sleeping6, imgzukan6, runnable_action6, runnable_sleep6);
                            else if (right == 1)
                                _uong2r(age6, swipe6, sleeping6, imgzukan6, runnable_action6, runnable_sleep6);
                        } else if (CLICK_PET == 7) {
                            if (prolength_uong7 != 1) {
                                prolength_uong7 += (int) (prolength_uong7 + 200 * 2);
                                if (prolength_uong7 > Chat.rankpet7(age7))
                                    prolength_uong7 = Chat.rankpet7(age7);
                                mood7 += (int) (mood7 + 100 * 2);
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += (int) (health7 + 100 * 2);
                                if (health7 > 1500)
                                    health7 = 1500;
                            }
                            friendly7 += 20;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                            if (right == 0)
                                _uong2(age7, swipe7, sleeping7, imgzukan7, runnable_action7, runnable_sleep7);
                            else if (right == 1)
                                _uong2r(age7, swipe7, sleeping7, imgzukan7, runnable_action7, runnable_sleep7);
                        } else if (CLICK_PET == 8) {
                            if (prolength_uong8 != 1) {
                                prolength_uong8 += (int) (prolength_uong8 + 200 * 2);
                                if (prolength_uong8 > Chat.rankpet8(age8))
                                    prolength_uong8 = Chat.rankpet8(age8);
                                mood8 += (int) (mood8 + 100 * 2);
                                if (mood8 > 3000)
                                    mood8 = 3000;
                                health8 += (int) (health8 + 100 * 2);
                                if (health8 > 3000)
                                    health8 = 3000;
                            }
                            friendly8 += 20;
                            if (friendly8 >= 3000)
                                friendly8 = 3000;
                            if (right == 0)
                                _uong(age8, swipe8, sleeping8, imgzukan8, runnable_action8, runnable_sleep8);
                            else if (right == 1)
                                _uongr(age8, swipe8, sleeping8, imgzukan8, runnable_action8, runnable_sleep8);
                        }
                        _ButtonDisable();
                    } else if (_CLICK == 3) {
                        final Dialog dialog = new Dialog(zukan_main.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setContentView(R.layout.createpet);
                        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                        Button btnno = (Button) dialog.findViewById(R.id.btnno);
                        TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                        textView20.setText("確認");
                        TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                        textView18.setText("成長促進剤 10 倍[幼虫用]を使用しますか？");
                        btnyes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                SharedPreferences.Editor editor = pre.edit();
                                if (CLICK_PET == 1) {
                                    if (timeUpAge == true)
                                        handler.removeCallbacks(runnable_timeUpAge);
                                    if (UpAge2 == true)
                                        handler.removeCallbacks(runnable_UpAge2);
                                    if (UpAge2Nho == true)
                                        handler.removeCallbacks(runnable_UpAge2Nho);
                                    _USEITEM = 2;
                                    handler.post(runnable_UpAge2);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0)
                                        return;
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 2) {
                                    handler.removeCallbacks(runnable_timeUpAge2);
                                    handler.removeCallbacks(runnable_UpAge22);
                                    handler.removeCallbacks(runnable_UpAge2Nho2);
                                    _USEITEM2 = 2;
                                    handler.post(runnable_UpAge22);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem2", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 3) {
                                    handler.removeCallbacks(runnable_timeUpAge3);
                                    handler.removeCallbacks(runnable_UpAge23);
                                    handler.removeCallbacks(runnable_UpAge2Nho3);
                                    _USEITEM3 = 2;
                                    handler.post(runnable_UpAge23);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem3", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 4) {
                                    handler.removeCallbacks(runnable_timeUpAge4);
                                    handler.removeCallbacks(runnable_UpAge24);
                                    handler.removeCallbacks(runnable_UpAge2Nho4);
                                    _USEITEM4 = 2;
                                    handler.post(runnable_UpAge24);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem4", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 5) {
                                    handler.removeCallbacks(runnable_timeUpAge5);
                                    handler.removeCallbacks(runnable_UpAge25);
                                    handler.removeCallbacks(runnable_UpAge2Nho5);
                                    _USEITEM5 = 2;
                                    handler.post(runnable_UpAge25);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem5", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 6) {
                                    handler.removeCallbacks(runnable_timeUpAge6);
                                    handler.removeCallbacks(runnable_UpAge26);
                                    handler.removeCallbacks(runnable_UpAge2Nho6);
                                    _USEITEM6 = 2;
                                    handler.post(runnable_UpAge26);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem6", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 7) {
                                    handler.removeCallbacks(runnable_timeUpAge7);
                                    handler.removeCallbacks(runnable_UpAge27);
                                    handler.removeCallbacks(runnable_UpAge2Nho7);
                                    _USEITEM7 = 2;
                                    handler.post(runnable_UpAge27);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem7", 2);
                                    editor.commit();
                                } else if (CLICK_PET == 8) {
                                    handler.removeCallbacks(runnable_timeUpAge8);
                                    handler.removeCallbacks(runnable_UpAge28);
                                    handler.removeCallbacks(runnable_UpAge2Nho8);
                                    _USEITEM8 = 2;
                                    handler.post(runnable_UpAge28);
                                    txtsll.setText("" + _ITEMBIG);
                                    if (_ITEMBIG == 0) {
                                        return;
                                    }
                                    _ITEMBIG--;
                                    txtsll.setText("" + _ITEMBIG);
                                    editor.putInt("03002", _ITEMBIG);
                                    editor.putInt("useitem8", 2);
                                    editor.commit();
                                }
                                activeitem.setText("SPx10");

                            }
                        });
                        btnno.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    } else if (_CLICK == 4) {
                        _CLEAN--;
                        if (CLICK_PET == 1) {
                            handler.removeCallbacks(runnable_nha);
                            prolength_nha = 800;
                            _actionRunpa(itm_runpa1, fritm_runpa1);
                            runpaStartTime = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 2) {
                            handler.removeCallbacks(runnable_nha2);
                            prolength_nha2 = 800;
                            _actionRunpa2(itm_runpa2, fritm_runpa2);
                            runpaStartTime2 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 3) {
                            handler.removeCallbacks(runnable_nha3);
                            prolength_nha3 = 1000;
                            _actionRunpa3(itm_runpa3, fritm_runpa3);
                            runpaStartTime3 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 4) {
                            handler.removeCallbacks(runnable_nha4);
                            prolength_nha4 = 2000;
                            _actionRunpa4(itm_runpa4, fritm_runpa4);
                            runpaStartTime4 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 5) {
                            handler.removeCallbacks(runnable_nha5);
                            prolength_nha5 = 2000;
                            _actionRunpa5(itm_runpa5, fritm_runpa5);
                            runpaStartTime5 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 6) {
                            handler.removeCallbacks(runnable_nha6);
                            prolength_nha6 = 2000;
                            _actionRunpa6(itm_runpa6, fritm_runpa6);
                            runpaStartTime6 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 7) {
                            handler.removeCallbacks(runnable_nha7);
                            prolength_nha7 = 2000;
                            _actionRunpa7(itm_runpa7, fritm_runpa7);
                            runpaStartTime7 = System.currentTimeMillis() / 1000;
                        } else if (CLICK_PET == 8) {
                            handler.removeCallbacks(runnable_nha8);
                            prolength_nha8 = 2000;
                            _actionRunpa8(itm_runpa8, fritm_runpa8);
                            runpaStartTime8 = System.currentTimeMillis() / 1000;
                        }
                    }
                }
            });

            imgn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Random r = new Random();
                    int right = r.nextInt(2);
                    pwindo.dismiss();
                    int rank = (int) calcRank(size, health, mood, form, strength, personality);
                    double ratio2 = Chat.ratio2(rank);
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pre.edit();
                    if (_CLICK == 1) {
                        if (_FOOD == 0) {
                            return;
                        }
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        _FOOD--;
                        mypage.theluc--;
                        txtsln.setText("" + _FOOD);
                        exp += 1;
                        if (CLICK_PET == 1) {
                            if (prolength != 1) {
                                prolength = (int) (progressBar3.getProgress() + rankpet1(age) * 0.5);
                                if (prolength > rankpet1(age))
                                    prolength = rankpet1(age);
                                progressBar3.setProgress(prolength);
                                mood += 80;
                                if (mood > 800)
                                    mood = 800;
                                health += 80;
                                if (health > 800)
                                    health = 800;
                                prolength_sleep -= 80;
                                if (prolength_sleep < 5)
                                    prolength_sleep = 5;
                            }
                            _an(age, sleeping, swipe, imgzukan, txtan, runnable_action, runnable_sleep);
                            daitien += 300;
                            if (daitien > rankpet1(age))
                                daitien = 0;
                            life += 3000 * 0.8;
                            if (life > 800)
                                life = 800;
                            friendly += 10 * 0.8;
                            if (friendly >= 800)
                                friendly = 800;
                        } else if (CLICK_PET == 2) {
                            if (prolength2 != 1) {
                                prolength2 = (int) (progressBar32.getProgress() + rankpet1(age2) * 0.5);
                                if (prolength2 > rankpet1(age2))
                                    prolength2 = rankpet1(age2);
                                progressBar32.setProgress(prolength2);
                                mood2 += 80;
                                if (mood2 > 800)
                                    mood2 = 800;
                                health2 += 80;
                                if (health2 > 800)
                                    health2 = 800;
                                prolength_sleep2 -= 80;
                                if (prolength_sleep2 < 5)
                                    prolength_sleep2 = 5;
                            }
                            _an2(age2, sleeping2, swipe2, imgzukan2, txtan2, runnable_action2, runnable_sleep2);
                            daitien2 += 300;
                            if (daitien2 > rankpet1(age2))
                                daitien2 = 0;
                            life2 += 3000 * 0.8;
                            if (life2 > 800)
                                life2 = 800;
                            friendly2 += 10 * 0.8;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                        } else if (CLICK_PET == 3) {
                            if (prolength3 != 1) {
                                prolength3 = (int) (progressBar33.getProgress() + Chat.rankpet3(age3) * 0.5);
                                if (prolength3 > Chat.rankpet3(age3))
                                    prolength3 = Chat.rankpet3(age3);
                                progressBar33.setProgress(prolength3);
                                mood3 += 80;
                                if (mood3 > 1000)
                                    mood3 = 1000;
                                health3 += 80;
                                if (health3 > 1000)
                                    health3 = 1000;
                                prolength_sleep3 -= 80;
                                if (prolength_sleep3 < 5)
                                    prolength_sleep3 = 5;
                            }
                            _an(age3, sleeping3, swipe3, imgzukan3, txtan3, runnable_action3, runnable_sleep3);
                            daitien3 += 300;
                            if (daitien3 > Chat.rankpet3(age3))
                                daitien3 = 0;
                            life3 += 3000 * 0.8;
                            if (life3 > 1000)
                                life3 = 1000;
                            friendly3 += 10 * 0.8;
                            if (friendly3 >= 1000)
                                friendly3 = 1000;
                        } else if (CLICK_PET == 4) {
                            if (prolength4 != 1) {
                                prolength4 = (int) (progressBar34.getProgress() + Chat.rankpet4(age4) * 0.5);
                                if (prolength4 > Chat.rankpet4(age4))
                                    prolength4 = Chat.rankpet4(age4);
                                progressBar34.setProgress(prolength4);
                                mood4 += 80;
                                if (mood4 > 2000)
                                    mood4 = 2000;
                                health4 += 80;
                                if (health4 > 2000)
                                    health4 = 2000;
                                prolength_sleep4 -= 80;
                                if (prolength_sleep4 < 5)
                                    prolength_sleep4 = 5;
                            }
                            _an2(age4, sleeping4, swipe4, imgzukan4, txtan4, runnable_action4, runnable_sleep4);
                            daitien4 += 300;
                            if (daitien4 > Chat.rankpet4(age4))
                                daitien4 = 0;
                            life4 += 3000 * 0.8;
                            if (life4 > 2000)
                                life4 = 2000;
                            friendly4 += 10 * 0.8;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                        } else if (CLICK_PET == 5) {
                            if (prolength5 != 1) {
                                prolength5 = (int) (progressBar35.getProgress() + Chat.rankpet4(age5) * 0.5);
                                if (prolength5 > Chat.rankpet4(age5))
                                    prolength5 = Chat.rankpet4(age5);
                                progressBar35.setProgress(prolength5);
                                mood5 += 80;
                                if (mood5 > 2000)
                                    mood5 = 2000;
                                health5 += 80;
                                if (health5 > 2000)
                                    health5 = 2000;
                                prolength_sleep5 -= 80;
                                if (prolength_sleep5 < 5)
                                    prolength_sleep5 = 5;
                            }
                            _an(age5, sleeping5, swipe5, imgzukan5, txtan5, runnable_action5, runnable_sleep5);
                            daitien5 += 300;
                            if (daitien5 > Chat.rankpet4(age5))
                                daitien5 = 0;
                            life5 += 3000 * 0.8;
                            if (life5 > 2000)
                                life5 = 2000;
                            friendly5 += 10 * 0.8;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                        } else if (CLICK_PET == 6) {
                            if (prolength6 != 1) {
                                prolength6 = (int) (progressBar36.getProgress() + Chat.rankpet4(age6) * 0.5);
                                if (prolength6 > Chat.rankpet4(age6))
                                    prolength6 = Chat.rankpet4(age6);
                                progressBar36.setProgress(prolength6);
                                mood6 += 80;
                                if (mood6 > 2000)
                                    mood6 = 2000;
                                health6 += 80;
                                if (health6 > 2000)
                                    health6 = 2000;
                                prolength_sleep6 -= 80;
                                if (prolength_sleep6 < 5)
                                    prolength_sleep6 = 5;
                            }
                            _an2(age6, sleeping6, swipe6, imgzukan6, txtan6, runnable_action6, runnable_sleep6);
                            daitien6 += 300;
                            if (daitien6 > Chat.rankpet4(age6))
                                daitien6 = 0;
                            life6 += 3000 * 0.8;
                            if (life6 > 2000)
                                life6 = 2000;
                            friendly6 += 10 * 0.8;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                        } else if (CLICK_PET == 7) {
                            if (prolength7 != 1) {
                                prolength7 = (int) (progressBar37.getProgress() + Chat.rankpet7(age7) * 0.5);
                                if (prolength7 > Chat.rankpet7(age7))
                                    prolength7 = Chat.rankpet7(age7);
                                progressBar37.setProgress(prolength7);
                                mood7 += 80;
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += 80;
                                if (health7 > 1500)
                                    health7 = 1500;
                                prolength_sleep7 -= 80;
                                if (prolength_sleep7 < 5)
                                    prolength_sleep7 = 5;
                            }
                            _an2(age7, sleeping7, swipe7, imgzukan7, txtan7, runnable_action7, runnable_sleep7);
                            daitien7 += 300;
                            if (daitien7 > Chat.rankpet7(age7))
                                daitien7 = 0;
                            life7 += 3000 * 0.8;
                            if (life7 > 1500)
                                life7 = 1500;
                            friendly7 += 10 * 0.8;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                        } else if (CLICK_PET == 8) {
                            if (prolength8 != 1) {
                                prolength8 = (int) (progressBar38.getProgress() + Chat.rankpet8(age8) * 0.5);
                                if (prolength8 > Chat.rankpet8(age8))
                                    prolength8 = Chat.rankpet8(age8);
                                progressBar38.setProgress(prolength8);
                                mood8 += 80;
                                if (mood8 > 3000)
                                    mood8 = 3000;
                                health8 += 80;
                                if (health8 > 3000)
                                    health8 = 3000;
                                prolength_sleep8 -= 80;
                                if (prolength_sleep8 < 5)
                                    prolength_sleep8 = 5;
                            }
                            _an(age8, sleeping8, swipe8, imgzukan8, txtan8, runnable_action8, runnable_sleep8);
                            daitien8 += 300;
                            if (daitien8 > Chat.rankpet8(age8))
                                daitien8 = 0;
                            life8 += 3000 * 0.8;
                            if (life8 > 3000)
                                life8 = 3000;
                            friendly8 += 10 * 0.8;
                            if (friendly8 >= 3000)
                                friendly8 = 3000;
                        }
                        txtsln.setText("" + _FOOD);
                        editor.putInt("01001", _FOOD);
                        editor.commit();
                        _ButtonDisable();
                    } else if (_CLICK == 2) {
                        if (mypage.theluc < 1) {
                            CheckTheLuc();
                            return;
                        }
                        if (_DRINK == 0) {
                            return;
                        }
                        _DRINK--;
                        mypage.theluc--;
                        txtsln.setText("" + _DRINK);
                        exp += 1;
                        txtsln.setText("" + _DRINK);
                        editor.putInt("00001", _DRINK);
                        editor.commit();
                        if (CLICK_PET == 1) {
                            if (prolength_uong != 1) {
                                prolength_uong += (int) (prolength_uong + 200 * ratio2);
                                if (prolength_uong > rankpet1(age))
                                    prolength_uong = rankpet1(age);
                                mood += (int) (mood + 100 * ratio2);
                                if (mood > 800)
                                    mood = 800;
                                health += (int) (health + 100 * ratio2);
                                if (health > 800)
                                    health = 800;
                            }
                            if (right == 0)
                                _uong(age, swipe, sleeping, imgzukan, runnable_action, runnable_sleep);
                            if (right == 1)
                                _uongr(age, swipe, sleeping, imgzukan, runnable_action, runnable_sleep);
                            life += 500 * ratio2;
                            if (life > 800)
                                life = 800;
                            friendly += 10 * ratio2;
                            if (friendly >= 800)
                                friendly = 800;
                        } else if (CLICK_PET == 2) {
                            if (prolength_uong2 != 1) {
                                prolength_uong2 += (int) (prolength_uong2 + 200 * ratio2);
                                if (prolength_uong2 > rankpet1(age2))
                                    prolength_uong2 = rankpet1(age2);
                                mood2 += (int) (mood2 + 100 * ratio2);
                                if (mood2 > 800)
                                    mood2 = 800;
                                health2 += (int) (health2 + 100 * ratio2);
                                if (health2 > 800)
                                    health2 = 800;
                            }
                            friendly2 += 8;
                            if (friendly2 >= 800)
                                friendly2 = 800;
                            if (right == 0)
                                _uong2(age2, swipe2, sleeping2, imgzukan2, runnable_action2, runnable_sleep2);
                            if (right == 1)
                                _uong2r(age2, swipe2, sleeping2, imgzukan2, runnable_action2, runnable_sleep2);
                        } else if (CLICK_PET == 3) {
                            if (prolength_uong3 != 1) {
                                prolength_uong3 += (int) (prolength_uong3 + 200 * ratio2);
                                if (prolength_uong3 > Chat.rankpet3(age3))
                                    prolength_uong3 = Chat.rankpet3(age3);
                                mood3 += (int) (mood3 + 100 * ratio2);
                                if (mood3 > 1000)
                                    mood3 = 1000;
                                health3 += (int) (health3 + 100 * ratio2);
                                if (health3 > 1000)
                                    health3 = 1000;
                            }
                            friendly3 += 8;
                            if (friendly3 >= 1000)
                                friendly3 = 1000;
                            if (right == 0)
                                _uong(age3, swipe3, sleeping3, imgzukan3, runnable_action3, runnable_sleep3);
                            if (right == 1)
                                _uongr(age3, swipe3, sleeping3, imgzukan3, runnable_action3, runnable_sleep3);
                        } else if (CLICK_PET == 4) {
                            if (prolength_uong4 != 1) {
                                prolength_uong4 += (int) (prolength_uong4 + 200 * ratio2);
                                if (prolength_uong4 > Chat.rankpet4(age4))
                                    prolength_uong4 = Chat.rankpet4(age4);
                                mood4 += (int) (mood4 + 100 * ratio2);
                                if (mood4 > 2000)
                                    mood4 = 2000;
                                health4 += (int) (health4 + 100 * ratio2);
                                if (health4 > 2000)
                                    health4 = 2000;
                            }
                            friendly4 += 8;
                            if (friendly4 >= 2000)
                                friendly4 = 2000;
                            if (right == 0)
                                _uong2(age4, swipe4, sleeping4, imgzukan4, runnable_action4, runnable_sleep4);
                            if (right == 1)
                                _uong2r(age4, swipe4, sleeping4, imgzukan4, runnable_action4, runnable_sleep4);
                        } else if (CLICK_PET == 5) {
                            if (prolength_uong5 != 1) {
                                prolength_uong5 += (int) (prolength_uong5 + 200 * ratio2);
                                if (prolength_uong5 > Chat.rankpet4(age5))
                                    prolength_uong5 = Chat.rankpet4(age5);
                                mood5 += (int) (mood5 + 100 * ratio2);
                                if (mood5 > 2000)
                                    mood5 = 2000;
                                health5 += (int) (health5 + 100 * ratio2);
                                if (health5 > 2000)
                                    health5 = 2000;
                            }
                            friendly5 += 8;
                            if (friendly5 >= 2000)
                                friendly5 = 2000;
                            if (right == 0)
                                _uong(age5, swipe5, sleeping5, imgzukan5, runnable_action5, runnable_sleep5);
                            if (right == 1)
                                _uongr(age5, swipe5, sleeping5, imgzukan5, runnable_action5, runnable_sleep5);
                        } else if (CLICK_PET == 6) {
                            if (prolength_uong6 != 1) {
                                prolength_uong6 += (int) (prolength_uong6 + 200 * ratio2);
                                if (prolength_uong6 > Chat.rankpet4(age6))
                                    prolength_uong6 = Chat.rankpet4(age6);
                                mood6 += (int) (mood6 + 100 * ratio2);
                                if (mood6 > 2000)
                                    mood6 = 2000;
                                health6 += (int) (health6 + 100 * ratio2);
                                if (health6 > 2000)
                                    health6 = 2000;
                            }
                            friendly6 += 8;
                            if (friendly6 >= 2000)
                                friendly6 = 2000;
                            if (right == 0)
                                _uong2(age6, swipe6, sleeping6, imgzukan6, runnable_action6, runnable_sleep6);
                            if (right == 1)
                                _uong2r(age6, swipe6, sleeping6, imgzukan6, runnable_action6, runnable_sleep6);
                        } else if (CLICK_PET == 7) {
                            if (prolength_uong7 != 1) {
                                prolength_uong7 += (int) (prolength_uong7 + 200 * ratio2);
                                if (prolength_uong7 > Chat.rankpet7(age7))
                                    prolength_uong7 = Chat.rankpet7(age7);
                                mood7 += (int) (mood7 + 100 * ratio2);
                                if (mood7 > 1500)
                                    mood7 = 1500;
                                health7 += (int) (health7 + 100 * ratio2);
                                if (health7 > 1500)
                                    health7 = 1500;
                            }
                            friendly7 += 8;
                            if (friendly7 >= 1500)
                                friendly7 = 1500;
                            if (right == 0)
                                _uong2(age7, swipe7, sleeping7, imgzukan7, runnable_action7, runnable_sleep7);
                            if (right == 1)
                                _uong2r(age7, swipe7, sleeping7, imgzukan7, runnable_action7, runnable_sleep7);
                        } else if (CLICK_PET == 8) {
                            if (prolength_uong8 != 1) {
                                prolength_uong8 += (int) (prolength_uong8 + 200 * ratio2);
                                if (prolength_uong8 > Chat.rankpet8(age8)) {
                                    prolength_uong8 = Chat.rankpet8(age8);
                                }
                                mood8 += (int) (mood8 + 100 * ratio2);
                                if (mood8 > 3000)
                                    mood8 = 3000;
                                health8 += (int) (health8 + 100 * ratio2);
                                if (health8 > 3000)
                                    health8 = 3000;
                            }
                            friendly8 += 8;
                            if (friendly8 >= 3000)
                                friendly8 = 3000;
                            if (right == 0)
                                _uong(age8, swipe8, sleeping8, imgzukan8, runnable_action8, runnable_sleep8);
                            if (right == 1)
                                _uongr(age8, swipe8, sleeping8, imgzukan8, runnable_action8, runnable_sleep8);
                        }
                        _ButtonDisable();

                    } else if (_CLICK == 3) {
                        final Dialog dialog = new Dialog(zukan_main.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setContentView(R.layout.createpet);
                        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                        Button btnno = (Button) dialog.findViewById(R.id.btnno);
                        TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                        TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                        textView20.setText("確認");
                        textView18.setText("成長促進剤 2 倍[幼虫用]を使用しますか？");
                        btnyes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                                SharedPreferences.Editor editor = pre.edit();
                                if (CLICK_PET == 1) {
                                    if (timeUpAge == true)
                                        handler.removeCallbacks(runnable_timeUpAge);
                                    if (UpAge2 == true)
                                        handler.removeCallbacks(runnable_UpAge2);
                                    if (UpAge2Nho == true)
                                        handler.removeCallbacks(runnable_UpAge2Nho);
                                    _USEITEM = 1;
                                    handler.post(runnable_UpAge2Nho);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 2) {
                                    handler.removeCallbacks(runnable_timeUpAge2);
                                    handler.removeCallbacks(runnable_UpAge22);
                                    handler.removeCallbacks(runnable_UpAge2Nho2);
                                    _USEITEM2 = 1;
                                    handler.post(runnable_UpAge2Nho2);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem2", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 3) {
                                    handler.removeCallbacks(runnable_timeUpAge3);
                                    handler.removeCallbacks(runnable_UpAge23);
                                    handler.removeCallbacks(runnable_UpAge2Nho3);
                                    _USEITEM3 = 1;
                                    handler.post(runnable_UpAge2Nho3);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem3", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 4) {
                                    handler.removeCallbacks(runnable_timeUpAge4);
                                    handler.removeCallbacks(runnable_UpAge24);
                                    handler.removeCallbacks(runnable_UpAge2Nho4);
                                    _USEITEM4 = 1;
                                    handler.post(runnable_UpAge2Nho4);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem4", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 5) {
                                    handler.removeCallbacks(runnable_timeUpAge5);
                                    handler.removeCallbacks(runnable_UpAge25);
                                    handler.removeCallbacks(runnable_UpAge2Nho5);
                                    _USEITEM5 = 1;
                                    handler.post(runnable_UpAge2Nho5);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem5", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 6) {
                                    handler.removeCallbacks(runnable_timeUpAge6);
                                    handler.removeCallbacks(runnable_UpAge26);
                                    handler.removeCallbacks(runnable_UpAge2Nho6);
                                    _USEITEM6 = 1;
                                    handler.post(runnable_UpAge2Nho6);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem6", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 7) {
                                    handler.removeCallbacks(runnable_timeUpAge7);
                                    handler.removeCallbacks(runnable_UpAge27);
                                    handler.removeCallbacks(runnable_UpAge2Nho7);
                                    _USEITEM7 = 1;
                                    handler.post(runnable_UpAge2Nho7);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem7", 1);
                                    editor.commit();
                                } else if (CLICK_PET == 8) {
                                    handler.removeCallbacks(runnable_timeUpAge8);
                                    handler.removeCallbacks(runnable_UpAge28);
                                    handler.removeCallbacks(runnable_UpAge2Nho8);
                                    _USEITEM8 = 1;
                                    handler.post(runnable_UpAge2Nho8);
                                    txtsln.setText("" + _ITEM);
                                    if (_ITEM == 0) {
                                        return;
                                    }
                                    _ITEM--;
                                    txtsln.setText("" + _ITEM);
                                    editor.putInt("03001", _ITEM);
                                    editor.putInt("useitem8", 1);
                                    editor.commit();
                                }
                                activeitem.setText("SPx2");
                            }
                        });
                        btnno.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                    } else if (_CLICK == 4) {
                        _actionClean();
                    }
                }
            });
            btnmypage = (ImageView) layout.findViewById(R.id.btnmypage);
            btnmypage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(zukan_main.this, shop.class);
                    if (_CLICK == 1) {
                        intent.putExtra("dialog", "food");
                        intent.putExtra("giatri", "2");
                    } else if (_CLICK == 2) {
                        intent.putExtra("dialog", "drink");
                        intent.putExtra("giatri", "2");
                    } else if (_CLICK == 3) {
                        intent.putExtra("dialog", "item");
                        intent.putExtra("giatri", "2");
                    }
                    intent.putExtra("dialog", "zukan");
                    startActivity(intent);
                }
            });
            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pwindo.dismiss();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void settemp(boolean swipe, boolean sleeping, ImageView imgzukan, int temp) {
        try {
            set1(swipe, sleeping, imgzukan, temp);
            if (sleeping == true) {
                imgupdown.setImageResource(R.drawable.bgup);
                bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                HideAnimation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void _noikhicham(float age) {
        if (age > 0 && age < 1)
            ShowLnmsg(Chat.NoiTaolao.length, Chat.NoiTaolao);
        else if (age > 1 && age < 2)
            ShowLnmsg(Chat.Noi2Tuoi.length, Chat.Noi2Tuoi);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            ShowLnmsg(Chat.NoiTaoLao3Tuoi.length, Chat.NoiTaoLao3Tuoi);
        else if (age > 4)
            ShowLnmsg(Chat.NoiKhiThanhNhong.length, Chat.NoiKhiThanhNhong);
    }

    public void NoiKhiCham() {
        if (CLICK_PET == 1)
            _noikhicham(age);
        else if (CLICK_PET == 2)
            _noikhicham(age2);
        else if (CLICK_PET == 3)
            _noikhicham(age3);
        else if (CLICK_PET == 4)
            _noikhicham(age4);
        else if (CLICK_PET == 5)
            _noikhicham(age5);
        else if (CLICK_PET == 6)
            _noikhicham(age6);
        else if (CLICK_PET == 7)
            _noikhicham(age7);
        else if (CLICK_PET == 8)
            _noikhicham(age8);
    }

    public void KichItemKhiConTrung() {
        ShowLnmsg(Chat.NoiKhiChamConTrung.length, Chat.NoiKhiChamConTrung);
    }

    public void KichItemKhiFalseItem() {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        initiatePopupWindow();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (_ITEM > 0)
            a = 1;
        if (_ITEMBIG > 0)
            b = 1;
        if (_ITEMBIG3 > 0)
            c = 1;
        if (_ITEMBIG4 > 0)
            c = 1;
        if (_ITEMBIG5 > 0)
            e = 1;
        int sum = a + b + c + d + e;
        if (sum >= 3) {
            imgprepopup.setVisibility(View.VISIBLE);
            imgnextpopup.setVisibility(View.VISIBLE);
        }
//        setparamspopup();
        layout.setBackgroundResource(R.mipmap.breeding_item_bg2);
        _CLICK = 3;
        setitem();
    }

    public void setClean() {
        _CLICK = 4;
        initiatePopupWindow();
        layout.setBackgroundResource(R.mipmap.breeding_clean_bg2);
        if (_CLEAN == 0) {
            lnimgn.setVisibility(View.GONE);
            imgn.setVisibility(View.GONE);
        } else if (_CLEAN > 0) {
            lnimgn.setVisibility(View.VISIBLE);
            imgn.setVisibility(View.VISIBLE);
            imgn.setImageResource(R.drawable.icon_clean_command);
            useforn.setText("");

            lnimgl.setVisibility(View.VISIBLE);
            imgl.setVisibility(View.VISIBLE);
            imgl.setImageResource(R.drawable.itm_runpa1);

            txtl.setText("お掃除ルンパ");
            useforl.setText("[幼虫用]");
            txtsll.setText("x " + _CLEAN);
        }
    }

    public void setitem() {
        if (_ITEM == 0) {
            lnimgn.setVisibility(View.GONE);
            imgn.setVisibility(View.GONE);
        } else if (_ITEM > 0) {
            lnimgn.setVisibility(View.VISIBLE);
            imgn.setVisibility(View.VISIBLE);
            txtsln.setText("x " + _ITEM);
            useforn.setText("[幼虫用]");
            txtn.setText("成長促進剤２倍");
            imgn.setImageResource(R.drawable.item_icon);
        }
        if (_ITEMBIG == 0) {
            lnimgl.setVisibility(View.GONE);
            imgl.setVisibility(View.GONE);
        } else if (_ITEMBIG > 0) {
            lnimgl.setVisibility(View.VISIBLE);
            imgl.setVisibility(View.VISIBLE);
            txtsll.setText("x " + _ITEMBIG);
            txtl.setText("成長促進剤１０倍");
            imgl.setImageResource(R.drawable.new_shop_icon_item2);
        }
        if (_ITEMBIG3 == 0) {
            lnimgl2.setVisibility(View.GONE);
            imgl2.setVisibility(View.GONE);
        } else if (_ITEMBIG3 > 0) {
            lnimgl2.setVisibility(View.VISIBLE);
            imgl2.setVisibility(View.VISIBLE);
            txtsll2.setText("x " + _ITEMBIG3);
            txtl2.setText("若返りの薬");
            imgl2.setImageResource(R.drawable.itm_medicine1);
        }
        if (_ITEMBIG4 == 0) {
            lnimgl3.setVisibility(View.GONE);
            imgl3.setVisibility(View.GONE);
        } else if (_ITEMBIG4 > 0) {
            lnimgl3.setVisibility(View.VISIBLE);
            imgl3.setVisibility(View.VISIBLE);
            txtsll3.setText("x " + _ITEMBIG4);
            txtl3.setText("進化の薬");
            imgl3.setImageResource(R.drawable.itm_medicine2);
        }
        if (_ITEMBIG5 == 0) {
            lnimgl4.setVisibility(View.GONE);
            imgl4.setVisibility(View.GONE);
        } else if (_ITEMBIG5 > 0) {
            lnimgl4.setVisibility(View.VISIBLE);
            imgl4.setVisibility(View.VISIBLE);
            txtsll4.setText("x " + _ITEMBIG5);
            txtl4.setText("酸素カプセル");
            imgl4.setImageResource(R.drawable.itm_o2_capsule);
        }
    }

    public void KichItemKhiFlaseDrink() {
        initiatePopupWindow();
//        setparamspopup();
        layout.setBackgroundResource(R.mipmap.breeding_drink_bg2);
        _CLICK = 2;
        setdrink();
    }

    public void setdrink() {
        if (_DRINK == 0) {
            imgn.setVisibility(View.GONE);
            lnimgn.setVisibility(View.GONE);
        } else if (_DRINK > 0) {
            lnimgn.setVisibility(View.VISIBLE);
            imgn.setVisibility(View.VISIBLE);
            imgn.setImageResource(R.drawable.drink_icon);
            txtsln.setText("x " + _DRINK);
            txtn.setText("ミネラルウオーター");
            useforn.setText("[成虫／幼虫兼用]");
        }
        if (_DRINKBIG == 0) {
            lnimgl.setVisibility(View.GONE);
            imgl.setVisibility(View.GONE);
        } else if (_DRINKBIG > 0) {
            lnimgl.setVisibility(View.VISIBLE);
            imgl.setVisibility(View.VISIBLE);
            imgl.setImageResource(R.drawable.new_shop_icon_drink2);
            txtsll.setText("x " + _DRINKBIG);
            txtl.setText("スペシャルジュース");
            useforl.setText("[成虫／幼虫兼用]");
        }
    }

    public void KichItemKhiFalseFood() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        initiatePopupWindow();
        if (CLICK_PET == 1 || CLICK_PET == 3 || CLICK_PET == 5 || CLICK_PET == 8) {
            if (pre.getInt("01001", 0) > 0 && pre.getInt("01003", 0) > 0 && pre.getInt("01013", 0) > 0) {
                imgprepopup.setVisibility(View.VISIBLE);
                imgnextpopup.setVisibility(View.VISIBLE);
            }
        } else if (CLICK_PET == 2 || CLICK_PET == 4 || CLICK_PET == 6 || CLICK_PET == 7) {
            if (pre.getInt("01001", 0) > 0 && pre.getInt("01003", 0) > 0 && pre.getInt("01014", 0) > 0) {
                imgprepopup.setVisibility(View.VISIBLE);
                imgnextpopup.setVisibility(View.VISIBLE);
            }
        }
//        setparamspopup();
        layout.setBackgroundResource(R.mipmap.breeding_food_bg2);
        _CLICK = 1;
        setfood();
    }

    public void setfood() {
        if (_FOOD == 0) {
            imgn.setVisibility(View.GONE);
            lnimgn.setVisibility(View.GONE);
        } else if (_FOOD > 0) {
            lnimgn.setVisibility(View.VISIBLE);
            imgn.setVisibility(View.VISIBLE);
            imgn.setImageResource(R.drawable.food_icon);
            txtn.setText("マットごはん");
            txtsln.setText("x " + _FOOD);
        }
        if (_FOODBIG == 0) {
            imgl.setVisibility(View.GONE);
            lnimgl.setVisibility(View.GONE);
        } else if (_FOODBIG > 0) {
            lnimgl.setVisibility(View.VISIBLE);
            imgl.setVisibility(View.VISIBLE);
            imgl.setImageResource(R.drawable.itm_rice4);
            txtsll.setText("x " + _FOODBIG);
            txtl.setText("マットごはんスペシャル");
        }
        if ((_FOODBIG2 == 0 && CLICK_PET == 1) || (_FOODBIG2 == 0 && CLICK_PET == 3) || (_FOODBIG2 == 0 && CLICK_PET == 5) || (_FOODBIG2 == 0 && CLICK_PET == 8)) {
            imgl2.setVisibility(View.GONE);
            lnimgl2.setVisibility(View.GONE);
        } else if ((_FOODBIG2 > 0 && CLICK_PET == 1) || (_FOODBIG2 > 0 && CLICK_PET == 3) || (_FOODBIG2 > 0 && CLICK_PET == 5) || (_FOODBIG2 > 0 && CLICK_PET == 8)) {
            lnimgl2.setVisibility(View.VISIBLE);
            imgl2.setVisibility(View.VISIBLE);
            imgl2.setImageResource(R.drawable.itm_rice3);
            txtsll2.setText("x " + _FOODBIG2);
            txtl2.setText("腐葉土ごはん");
        }
        if ((_FOODBIG3 == 0 && CLICK_PET == 2) || (_FOODBIG3 == 0 && CLICK_PET == 4) || (_FOODBIG3 == 0 && CLICK_PET == 6) || (_FOODBIG3 == 0 && CLICK_PET == 7)) {
            imgl3.setVisibility(View.GONE);
            lnimgl3.setVisibility(View.GONE);
        } else if ((_FOODBIG3 > 0 && CLICK_PET == 2) || (_FOODBIG3 > 0 && CLICK_PET == 4) || (_FOODBIG3 > 0 && CLICK_PET == 6) || (_FOODBIG3 > 0 && CLICK_PET == 7)) {
            lnimgl3.setVisibility(View.VISIBLE);
            imgl3.setVisibility(View.VISIBLE);
            imgl3.setImageResource(R.drawable.itm_rice2);
            txtsll3.setText("x " + _FOODBIG3);
            txtl3.setText("菌糸ごはん");
        }
    }

    public void SetImageTrung(final ImageView imgzukan) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1)
                                    imgzukan.setImageResource(R.drawable.egg_icon);
                                if (i == 2)
                                    imgzukan.setImageResource(R.drawable.beetle_phase00_p02_a01);
                                if (i == 3)
                                    imgzukan.setImageResource(R.drawable.egg_icon);
                            }
                        });
                        Thread.sleep(400);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void HieuUngKhat2(final float age2, final ImageView imgzukan) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 5; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 0) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p12_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p12_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p12_a01);
                                }
                                if (i == 2) {
                                    _SoundKhatNuoc();
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p12_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p12_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p12_a02);
                                }
                                if (i == 3) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p12_a03);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p12_a03);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p12_a03);
                                }
                                if (i == 4) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p12_a04);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p12_a04);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p12_a04);
                                }
                                if (i == 5) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }


    public void HieuUngKhat(final Runnable runnable_action, final float age, final ImageView imgzukan) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 0) {
                                    handler.removeCallbacks(runnable_action);
                                    if (age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p12_a01);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p12_a01);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p12_a01);
                                }
                                if (i == 1) {
                                    _SoundKhatNuoc();
                                    handler.removeCallbacks(runnable_action);
                                    if (age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p12_a02);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p12_a02);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p12_a02);
                                }
                                if (i == 2) {
                                    if (age < 1)
                                        imgzukan.setImageResource(R.drawable.beetle_phase01_p12_a03);
                                    else if (age > 1 && age < 2)
                                        imgzukan.setImageResource(R.drawable.beetle_phase02_p12_a03);
                                    else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                        imgzukan.setImageResource(R.drawable.beetle_phase03_p12_a03);
                                }
                                if (i == 3)
                                    handler.post(runnable_action);
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void HieuUngDoi() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 3; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1)
                                    txtan.setBackgroundResource(R.drawable.hungryballoon_a01);
                                if (i == 3)
                                    txtan.setBackgroundColor(Color.parseColor("#00000000"));
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {
                    }
                }
            }
        }.start();
    }

    public void CheckTheLuc() {
        final Dialog dialogwhenbuy = new Dialog(zukan_main.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        TextView txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        txtyesbutton.setText("アクションを行う為の体力が不足しています。時間をおくと体力が回復します。");
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogwhenbuy.dismiss();
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    public void ShowLnmsg(int num, String[] str) {
        try {
            Random random = new Random();
            int ran = random.nextInt(num);
            lnmsg.setBackgroundResource(R.drawable.balloon1);
            txtmsg.setVisibility(View.VISIBLE);
            txtmsg.setText(str[ran]);
            new CountDownTimer(3000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                    txtmsg.setVisibility(View.GONE);
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setparamspopup() {
        if (pwindo.isShowing()) {
            if (mypage._Width < 720 && mypage._Height < 1280) {
                LinearLayout.LayoutParams pp = new LinearLayout.LayoutParams(45, 45);
                pp.setMargins(5, 5, 0, 0);
                btnClosePopup.setLayoutParams(pp);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(70, 70);
                params.gravity = Gravity.CENTER;
                imgn.setLayoutParams(params);
                imgl.setLayoutParams(params);
                txtn.setTextSize(7);
                txtl.setTextSize(7);
            }
        }
    }

    AtomicBoolean d = new AtomicBoolean(false);
    AtomicBoolean d2 = new AtomicBoolean(false);
    AtomicBoolean d3 = new AtomicBoolean(false);
    AtomicBoolean d4 = new AtomicBoolean(false);
    AtomicBoolean d5 = new AtomicBoolean(false);
    AtomicBoolean d6 = new AtomicBoolean(false);
    AtomicBoolean d7 = new AtomicBoolean(false);
    AtomicBoolean d8 = new AtomicBoolean(false);

    public void TieuTien() {
        d.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien; i <= rankpet1(age) && d.get(); i++) {
                        mypage.tieutien = i;
                        if (i >= rankpet1(age))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien >= rankpet1(age)) {
                                        prolength_nha -= 200;
                                        if (prolength_nha < 5)
                                            prolength_nha = 5;
                                        if (CLICK_PET == 1)
                                            HieuUngKhat(runnable_action, age, imgzukan);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d.set(true);
        t.start();
    }

    public void TieuTien2() {
        d2.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien2; i <= rankpet1(age2) && d2.get(); i++) {
                        mypage.tieutien2 = i;
                        if (i >= rankpet1(age2))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien2 >= rankpet1(age2)) {
                                        prolength_nha2 -= 200;
                                        if (prolength_nha2 < 5)
                                            prolength_nha2 = 5;
                                        if (CLICK_PET == 2)
                                            HieuUngKhat2(age2, imgzukan2);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d2.set(true);
        t.start();
    }

    public void TieuTien3() {
        d3.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien3; i <= Chat.rankpet3(age3) && d3.get(); i++) {
                        mypage.tieutien3 = i;
                        if (i >= Chat.rankpet3(age3))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien3 >= Chat.rankpet3(age3)) {
                                        prolength_nha3 -= 200;
                                        if (prolength_nha3 < 5)
                                            prolength_nha3 = 5;
                                        if (CLICK_PET == 3)
                                            HieuUngKhat(runnable_action3, age3, imgzukan3);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d3.set(true);
        t.start();
    }

    public void TieuTien4() {
        d4.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien4; i <= Chat.rankpet4(age4) && d4.get(); i++) {
                        mypage.tieutien4 = i;
                        if (i >= Chat.rankpet4(age4))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien4 >= Chat.rankpet4(age4)) {
                                        prolength_nha4 -= 200;
                                        if (prolength_nha4 < 5)
                                            prolength_nha4 = 5;
                                        if (CLICK_PET == 4)
                                            HieuUngKhat2(age4, imgzukan4);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d4.set(true);
        t.start();
    }

    public void TieuTien5() {
        d5.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien5; i <= Chat.rankpet4(age5) && d5.get(); i++) {
                        mypage.tieutien5 = i;
                        if (i >= Chat.rankpet4(age5))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien5 >= Chat.rankpet4(age5)) {
                                        prolength_nha5 -= 200;
                                        if (prolength_nha5 < 5)
                                            prolength_nha5 = 5;
                                        if (CLICK_PET == 5)
                                            HieuUngKhat(runnable_action5, age5, imgzukan5);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d5.set(true);
        t.start();
    }

    public void TieuTien6() {
        d6.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien6; i <= Chat.rankpet4(age6) && d6.get(); i++) {
                        mypage.tieutien6 = i;
                        if (i >= Chat.rankpet4(age6))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien6 >= Chat.rankpet4(age6)) {
                                        prolength_nha6 -= 200;
                                        if (prolength_nha6 < 5)
                                            prolength_nha6 = 5;
                                        if (CLICK_PET == 6)
                                            HieuUngKhat2(age6, imgzukan6);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d6.set(true);
        t.start();
    }

    public void TieuTien7() {
        d7.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien7; i <= Chat.rankpet7(age7) && d7.get(); i++) {
                        mypage.tieutien7 = i;
                        if (i >= Chat.rankpet7(age7))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien7 >= Chat.rankpet7(age7)) {
                                        prolength_nha7 -= 200;
                                        if (prolength_nha7 < 5)
                                            prolength_nha7 = 5;
                                        if (CLICK_PET == 7)
                                            HieuUngKhat2(age7, imgzukan7);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d7.set(true);
        t.start();
    }

    public void TieuTien8() {
        d8.set(false);
        Thread t = new Thread() {

            @Override
            public void run() {
                while (1 < 2) {
                    for (int i = mypage.tieutien8; i <= Chat.rankpet8(age8) && d8.get(); i++) {
                        mypage.tieutien8 = i;
                        if (i >= Chat.rankpet8(age8))
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (mypage.tieutien8 >= Chat.rankpet8(age8)) {
                                        prolength_nha8 -= 200;
                                        if (prolength_nha8 < 5)
                                            prolength_nha8 = 5;
                                        if (CLICK_PET == 8)
                                            HieuUngKhat(runnable_action8, age8, imgzukan8);
                                    }
                                }
                            });
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        d8.set(true);
        t.start();
    }

    public void HieuUngDaiTien(final ImageView imgzukan, final float age, final boolean sleeping) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 5; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1)
                                    _SoundDaiTien();
                                if (i == 0 || i == 2) {
//                                    handler.removeCallbacks(runnable_action);
                                    if (sleeping == false) {
                                        if (age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p13_a01);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p13_a01);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p13_a01);
                                    }
                                }
                                if (i == 1 || i == 3) {
                                    if (sleeping == false) {
                                        if (age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p13_a02);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p13_a02);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p13_a02);
                                    }
                                }
                                if (i == 4)
                                    btndaitien.setBackgroundResource(R.drawable.faces_a01);
                                if (i == 5) {
                                    btndaitien.setBackgroundColor(Color.parseColor("#00000000"));
//                                    handler.post(runnable_action);
                                    if (sleeping == false) {
                                        if (age < 1)
                                            imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
                                        else if (age > 1 && age < 2)
                                            imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
                                        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                                            imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
                                    }
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    public void HieuUngDaiTien2(final ImageView imgzukan, final float age2, final boolean sleeping2) {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 5; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (i == 0) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p13_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p13_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p13_a01);
                                }
                                if (i == 1) {
                                    _SoundDaiTien();
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p13_a02);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p13_a02);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p13_a02);
                                }
                                if (i == 2) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p13_a03);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p13_a03);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p13_a03);
                                }
                                if (i == 4) {
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p13_a04);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p13_a04);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p13_a04);
                                }
                                if (i == 3)
                                    btndaitien.setBackgroundResource(R.drawable.faces_a01);
                                if (i == 5) {
                                    btndaitien.setBackgroundColor(Color.parseColor("#00000000"));
                                    if (age2 < 1)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                                    else if (age2 > 1 && age2 < 2)
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                                    else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
                                        imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p04_a01);
                                }
                            }
                        });
                        Thread.sleep(800);
                    } catch (Exception e) {

                    }
                }
            }
        }.start();
    }

    Runnable dt = new Runnable() {
        @Override
        public void run() {
            daitien++;
            if (daitien < rankpet1(age)) {
                handler.postDelayed(dt, 1000);
                if (daitien >= rankpet1(age)) {
                    prolength_nha -= 300;
                    if (prolength_nha <= 1)
                        prolength_nha = 0;
                    daitien = 1;
                    if (CLICK_PET == 1)
                        HieuUngDaiTien(imgzukan, age, sleeping);
                }
            } else {
                handler.post(dt);
            }
        }
    };
    Runnable dt2 = new Runnable() {
        @Override
        public void run() {
            daitien2++;
            if (daitien2 < rankpet1(age2)) {
                handler.postDelayed(dt2, 1000);
                if (daitien2 >= rankpet1(age2)) {
                    prolength_nha2 -= 300;
                    if (prolength_nha2 <= 1)
                        prolength_nha2 = 0;
                    daitien2 = 1;
                    if (CLICK_PET == 2)
                        HieuUngDaiTien2(imgzukan2, age2, sleeping2);
                }
            } else {
                handler.post(dt2);
            }
        }
    };
    Runnable dt3 = new Runnable() {
        @Override
        public void run() {
            daitien3++;
            if (daitien3 < Chat.rankpet3(age3)) {
                handler.postDelayed(dt3, 1000);
                if (daitien3 >= Chat.rankpet3(age3)) {
                    daitien3 = 1;
                    prolength_nha3 -= 300;
                    if (prolength_nha3 <= 1)
                        prolength_nha3 = 0;
                    if (CLICK_PET == 3)
                        HieuUngDaiTien(imgzukan3, age3, sleeping3);
                }
            } else {
                handler.post(dt3);
            }
        }
    };
    Runnable dt4 = new Runnable() {
        @Override
        public void run() {
            daitien4++;
            if (daitien4 < Chat.rankpet4(age4)) {
                handler.postDelayed(dt4, 1000);
                if (daitien4 >= Chat.rankpet4(age4)) {
                    prolength_nha4 -= 300;
                    if (prolength_nha4 <= 1)
                        prolength_nha4 = 0;
                    daitien4 = 1;
                    if (CLICK_PET == 4)
                        HieuUngDaiTien2(imgzukan4, age4, sleeping4);
                }
            } else {
                handler.post(dt4);
            }
        }
    };
    Runnable dt5 = new Runnable() {
        @Override
        public void run() {
            daitien5++;
            if (daitien5 < Chat.rankpet4(age5)) {
                handler.postDelayed(dt5, 1000);
                if (daitien5 >= Chat.rankpet4(age5)) {
                    prolength_nha5 -= 300;
                    if (prolength_nha5 <= 1)
                        prolength_nha5 = 0;
                    daitien5 = 1;
                    if (CLICK_PET == 5)
                        HieuUngDaiTien(imgzukan5, age5, sleeping5);
                }
            } else {
                handler.post(dt5);
            }
        }
    };
    Runnable dt6 = new Runnable() {
        @Override
        public void run() {
            daitien6++;
            if (daitien6 < Chat.rankpet4(age6)) {
                handler.postDelayed(dt6, 1000);
                if (daitien6 >= Chat.rankpet4(age6)) {
                    prolength_nha6 -= 300;
                    if (prolength_nha6 <= 1)
                        prolength_nha6 = 0;
                    daitien6 = 1;
                    if (CLICK_PET == 6)
                        HieuUngDaiTien2(imgzukan6, age6, sleeping6);
                }
            } else {
                handler.post(dt6);
            }
        }
    };
    Runnable dt7 = new Runnable() {
        @Override
        public void run() {
            daitien7++;
            if (daitien7 < Chat.rankpet7(age7)) {
                handler.postDelayed(dt7, 1000);
                if (daitien7 >= Chat.rankpet7(age7)) {
                    prolength_nha7 -= 300;
                    if (prolength_nha7 <= 1)
                        prolength_nha7 = 0;
                    daitien7 = 1;
                    if (CLICK_PET == 7)
                        HieuUngDaiTien2(imgzukan7, age7, sleeping7);
                }
            } else {
                handler.post(dt7);
            }
        }
    };
    Runnable dt8 = new Runnable() {
        @Override
        public void run() {
            daitien8++;
            if (daitien8 < Chat.rankpet8(age8)) {
                handler.postDelayed(dt8, 1000);
                if (daitien8 >= Chat.rankpet8(age8)) {
                    prolength_nha8 -= 300;
                    if (prolength_nha8 <= 1)
                        prolength_nha8 = 0;
                    daitien8 = 1;
                    if (CLICK_PET == 8)
                        HieuUngDaiTien(imgzukan8, age8, sleeping8);
                }
            } else {
                handler.post(dt8);
            }
        }
    };

    public void BackToMyPage() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        uptime = true;
        handler.removeCallbacks(runnable_bb);
        handler.removeCallbacks(runnable_sk);
        handler.removeCallbacks(runnable2_sk);
        handler.removeCallbacks(runnable3_sk);
        handler.removeCallbacks(runnable4_sk);
        handler.removeCallbacks(runnable5_sk);
        handler.removeCallbacks(runnable6_sk);
        handler.removeCallbacks(runnable7_sk);
        handler.removeCallbacks(runnable8_sk);
        handler.removeCallbacks(runnable_nha);
        handler.removeCallbacks(runnable_nha2);
        handler.removeCallbacks(runnable_nha3);
        handler.removeCallbacks(runnable_nha4);
        handler.removeCallbacks(runnable_nha5);
        handler.removeCallbacks(runnable_nha6);
        handler.removeCallbacks(runnable_nha7);
        handler.removeCallbacks(runnable_nha8);
        handler.removeCallbacks(runnable_timeUpAge);
        handler.removeCallbacks(runnable_timeUpAge2);
        handler.removeCallbacks(runnable_timeUpAge3);
        handler.removeCallbacks(runnable_timeUpAge4);
        handler.removeCallbacks(runnable_timeUpAge5);
        handler.removeCallbacks(runnable_timeUpAge6);
        handler.removeCallbacks(runnable_timeUpAge7);
        handler.removeCallbacks(runnable_timeUpAge8);
        handler.removeCallbacks(runnable_UpAge2);
        handler.removeCallbacks(runnable_UpAge22);
        handler.removeCallbacks(runnable_UpAge23);
        handler.removeCallbacks(runnable_UpAge24);
        handler.removeCallbacks(runnable_UpAge25);
        handler.removeCallbacks(runnable_UpAge26);
        handler.removeCallbacks(runnable_UpAge27);
        handler.removeCallbacks(runnable_UpAge28);
        handler.removeCallbacks(runnable_UpAge2Nho);
        handler.removeCallbacks(runnable_UpAge2Nho2);
        handler.removeCallbacks(runnable_UpAge2Nho3);
        handler.removeCallbacks(runnable_UpAge2Nho4);
        handler.removeCallbacks(runnable_UpAge2Nho5);
        handler.removeCallbacks(runnable_UpAge2Nho6);
        handler.removeCallbacks(runnable_UpAge2Nho7);
        handler.removeCallbacks(runnable_UpAge2Nho8);
        handler.removeCallbacks(runnable_sleep);
        handler.removeCallbacks(runnable_sleep2);
        handler.removeCallbacks(runnable_sleep3);
        handler.removeCallbacks(runnable_sleep4);
        handler.removeCallbacks(runnable_sleep5);
        handler.removeCallbacks(runnable_sleep6);
        handler.removeCallbacks(runnable_sleep7);
        handler.removeCallbacks(runnable_sleep8);

        handler.removeCallbacks(run_age3);
        handler.removeCallbacks(run_age4);
        handler.removeCallbacks(run_age5);
        handler.removeCallbacks(run_age6);
        handler.removeCallbacks(run_age7);
        handler.removeCallbacks(run_age8);
        sleepatomic.set(false);
        sleepatomic2.set(false);
        sleepatomic3.set(false);
        sleepatomic4.set(false);
        sleepatomic5.set(false);
        sleepatomic6.set(false);
        sleepatomic7.set(false);
        sleepatomic8.set(false);
        loadpet1.set(false);
        loadpet2.set(false);
        loadpet3.set(false);
        loadpet4.set(false);
        loadpet5.set(false);
        loadpet6.set(false);
        loadpet7.set(false);
        loadpet8.set(false);
        handler.removeCallbacks(dt);
        handler.removeCallbacks(dt2);
        handler.removeCallbacks(dt3);
        handler.removeCallbacks(dt4);
        handler.removeCallbacks(dt5);
        handler.removeCallbacks(dt6);
        handler.removeCallbacks(dt7);
        handler.removeCallbacks(dt8);
        editor.putString("gotomypage", "gotomypage");
        editor.commit();
        finish();
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void setanim(ImageView imgzukan, TextView txtnuoc, TextView txtan, RelativeLayout lnmsg) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imgzukan.getLayoutParams();
        params.topMargin += 0;
        params.leftMargin -= 80;
        imgzukan.clearAnimation();
        imgzukan.setLayoutParams(params);
        //
        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) txtnuoc.getLayoutParams();
        params2.topMargin += 0;
        params2.leftMargin -= 80;
        txtnuoc.setLayoutParams(params2);
        //
        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams) txtan.getLayoutParams();
        params3.topMargin += 0;
        params3.leftMargin -= 80;
        txtan.setLayoutParams(params3);
        //
//        FrameLayout.LayoutParams params4 = (FrameLayout.LayoutParams) lnmsg.getLayoutParams();
//        params4.topMargin += 0;
//        params4.leftMargin -= 90;
//        lnmsg.setLayoutParams(params4);
    }

    public void setanimelse(ImageView imgzukan, TextView txtnuoc, TextView txtan, RelativeLayout lnmsg) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imgzukan.getLayoutParams();
        params.topMargin += 0;
        params.leftMargin += 80;
        imgzukan.clearAnimation();
        imgzukan.setLayoutParams(params);
        //
        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) txtnuoc.getLayoutParams();
        params2.topMargin += 0;
        params2.leftMargin += 80;
        txtnuoc.setLayoutParams(params2);
        //
        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams) txtan.getLayoutParams();
        params3.topMargin += 0;
        params3.leftMargin += 80;
        txtan.setLayoutParams(params3);
        //
//        FrameLayout.LayoutParams params4 = (FrameLayout.LayoutParams) lnmsg.getLayoutParams();
//        params4.topMargin += 0;
//        params4.leftMargin += 90;
//        lnmsg.setLayoutParams(params4);
    }

    public void SetAnimForPet() {
        anim = new TranslateAnimation(0, -80, 0, 0);
        anim.setDuration(2000);
        anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan, txtnuoc, txtan, lnmsg);
                imgzukan.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet2 = new TranslateAnimation(0, -80, 0, 0);
        animpet2.setDuration(2000);
        animpet2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan2, txtnuoc2, txtan2, lnmsg);
                imgzukan2.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet3 = new TranslateAnimation(0, -80, 0, 0);
        animpet3.setDuration(2000);
        animpet3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan3, txtnuoc3, txtan3, lnmsg);
                imgzukan3.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet4 = new TranslateAnimation(0, -80, 0, 0);
        animpet4.setDuration(2000);
        animpet4.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan4, txtnuoc4, txtan4, lnmsg);
                imgzukan4.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet5 = new TranslateAnimation(0, -80, 0, 0);
        animpet5.setDuration(2000);
        animpet5.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan5, txtnuoc5, txtan5, lnmsg);
                imgzukan5.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet6 = new TranslateAnimation(0, -80, 0, 0);
        animpet6.setDuration(2000);
        animpet6.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan6, txtnuoc6, txtan6, lnmsg);
                imgzukan6.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet7 = new TranslateAnimation(0, -80, 0, 0);
        animpet7.setDuration(2000);
        animpet7.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan7, txtnuoc7, txtan7, lnmsg);
                imgzukan7.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        animpet8 = new TranslateAnimation(0, -80, 0, 0);
        animpet8.setDuration(2000);
        animpet8.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanim(imgzukan8, txtnuoc8, txtan8, lnmsg);
                imgzukan8.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2 = new TranslateAnimation(0, 80, 0, 0);
        anim2.setDuration(2000);
        anim2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan, txtnuoc, txtan, lnmsg);
                imgzukan.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2pet2 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet2.setDuration(2000);
        anim2pet2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan2, txtnuoc2, txtan2, lnmsg);
                imgzukan2.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2pet3 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet3.setDuration(2000);
        anim2pet3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan3, txtnuoc3, txtan3, lnmsg);
                imgzukan3.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan3.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2pet4 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet4.setDuration(2000);
        anim2pet4.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan4, txtnuoc4, txtan4, lnmsg);
                imgzukan4.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan4.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2pet5 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet5.setDuration(2000);
        anim2pet5.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan5, txtnuoc5, txtan5, lnmsg);
                imgzukan5.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan5.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        //
        anim2pet6 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet6.setDuration(2000);
        anim2pet6.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan6, txtnuoc6, txtan6, lnmsg);
                imgzukan6.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan6.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        anim2pet7 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet7.setDuration(2000);
        anim2pet7.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan7, txtnuoc7, txtan7, lnmsg);
                imgzukan7.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan7.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
        anim2pet8 = new TranslateAnimation(0, 80, 0, 0);
        anim2pet8.setDuration(2000);
        anim2pet8.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setanimelse(imgzukan8, txtnuoc8, txtan8, lnmsg);
                imgzukan8.setLayerType(View.LAYER_TYPE_NONE, null);
                imgzukan8.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
        });
    }

    public void toumultizukan2(float age, ImageView imgzukan, boolean sleeping, boolean atomicBoolean) {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        Random rand = new Random();
        int a = rand.nextInt(2);
        if (pre.getBoolean("soundaction", true)) {
            if (a == 0)
                mPTouchZukan.start();
            else if (a == 1)
                mPTouchZukan2.start();
        }
        if (atomicBoolean == true)
            SetImageTrung(imgzukan);
        if (sleeping == true && age < 3)
            _TouchzukanSleep2(age, imgzukan);
        if (sleeping == false || (sleeping && age >= 3 && age < 4))
            _Touchzukan2(age, imgzukan);
        NoiKhiCham();
    }

    public void toumultizukan(float age, ImageView imgzukan, boolean sleeping, boolean atomicBoolean) {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        Random rand = new Random();
        int a = rand.nextInt(2);
        if (pre.getBoolean("soundaction", true)) {
            if (a == 0)
                mPTouchZukan.start();
            else if (a == 1)
                mPTouchZukan2.start();
        }
        if (atomicBoolean == true)
            SetImageTrung(imgzukan);
        if (sleeping == true && age < 3)
            _TouchzukanSleep(age, imgzukan);
        if (sleeping == false || (sleeping && age >= 3 && age < 4))
            _Touchzukan(age, imgzukan);
        NoiKhiCham();
    }

    public void setRank(int size, int health, int mood, int form, int strength, int personality) {
        int rank = (int) calcRank(size, health, mood, form, strength, personality);
        if (rank == 9) txthang.setText("SSSランク");
        else if (rank == 8) txthang.setText("SSランク");
        else if (rank == 7) txthang.setText("Sランク");
        else if (rank == 6) txthang.setText("Aランク");
        else if (rank == 5) txthang.setText("Bランク");
        else if (rank == 4) txthang.setText("Cランク");
        else if (rank == 3) txthang.setText("Dランク");
        else if (rank == 2) txthang.setText("Eランク");
        else if (rank == 1) txthang.setText("Fランク");
        else if (rank == 0) txthang.setText("Gランク");
    }

    public void stopaction() {
        handler.removeCallbacks(runnable_action);
        handler.removeCallbacks(runnable_action2);
        handler.removeCallbacks(runnable_action3);
        handler.removeCallbacks(runnable_action4);
        handler.removeCallbacks(runnable_action5);
        handler.removeCallbacks(runnable_action6);
        handler.removeCallbacks(runnable_action7);
        handler.removeCallbacks(runnable_action8);
    }

    public void settextfordialoginfo(int friendly, String id, int strength, float age, String daload14s) {
        txtbanbe.setText("" + friendly);
        txtid.setText("" + id);
        txtsucmanh.setText("" + strength);
        txttt.setText("" + txttruongthanh.getText().toString());
        if (age < 1) {
            if (daload14s.length() > 0)
                bginfo.setImageResource(R.drawable.beetle_phase01_p01_a01);
        } else if (age > 1 && age < 2)
            bginfo.setImageResource(R.drawable.beetle_phase02_p01_a01);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            bginfo.setImageResource(R.drawable.beetle_phase03_p01_a01);
        else if (age > 4)
            bginfo.setImageResource(R.drawable.beetle_phase05_p01_a01);
    }

    public void settextfordialoginfo2(int friendly, int strength2, String id2, float age2, String daload14s) {
        txtbanbe.setText("" + friendly);
        txtsucmanh.setText("" + strength2);
        txtid.setText("" + id2);
        txttt.setText("" + txttruongthanh.getText().toString());
        if (age2 < 1) {
            if (daload14s.length() > 0)
                bginfo.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
        } else if (age2 > 1 && age2 < 2)
            bginfo.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
        else if (age2 > 2 && age2 < 3)
            bginfo.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        else if (age2 > 3 && age2 < 4)
            bginfo.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        else if (age2 > 4)
            bginfo.setImageResource(R.drawable.stag_beetle_phase05_p01_a01);
    }

    public void setstttruongthanh(float age) {
        if (age < 1)
            txttruongthanh.setText("1 齢幼虫");
        else if (age > 1 && age < 2)
            txttruongthanh.setText("２齢幼虫");
        else if (age > 2 && age < 3)
            txttruongthanh.setText("３齢幼虫");
        else if (age > 3 && age < 4)
            txttruongthanh.setText("前蛹");
        else if (age > 4)
            txttruongthanh.setText("蛹");
    }

    public void setImageIcon(float age, Button btnicon, ImageView imgzukan, TextView txttruongthanh) {
        if (age < 1) {
            btnicon.setBackgroundResource(R.drawable.b01icon);
            txttruongthanh.setText("1 齢幼虫");
            imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
        } else if (age > 1 && age < 2) {
            btnicon.setBackgroundResource(R.drawable.b02icon);
            txttruongthanh.setText("２齢幼虫");
            imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
        } else if ((age > 2 && age < 3)) {
            btnicon.setBackgroundResource(R.drawable.b03icon);
            txttruongthanh.setText("３齢幼虫");
            imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
        } else if ((age > 3 && age < 4)) {
            btnicon.setBackgroundResource(R.drawable.b03icon);
            txttruongthanh.setText("前蛹");
            imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
        } else if (age > 4) {
            btnicon.setBackgroundResource(R.drawable.b04icon);
            txttruongthanh.setText("蛹");
            imgzukan.setImageResource(R.drawable.beetle_phase05_p01_a01);
        }
    }

    public void setImageIcon2(float age2, Button btnicon2, ImageView imgzukan2) {
        if (age2 < 1) {
            btnicon2.setBackgroundResource(R.drawable.s01icon);
            txttruongthanh.setText("1 齢幼虫");
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
        } else if (age2 > 1 && age2 < 2) {
            btnicon2.setBackgroundResource(R.drawable.s02icon);
            txttruongthanh.setText("２齢幼虫");
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
        } else if (age2 > 2 && age2 < 3) {
            btnicon2.setBackgroundResource(R.drawable.s03icon);
            txttruongthanh.setText("３齢幼虫");
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        } else if ((age2 > 3 && age2 < 4)) {
            btnicon2.setBackgroundResource(R.drawable.s03icon);
            txttruongthanh.setText("前蛹");
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        } else if (age2 > 4) {
            btnicon2.setBackgroundResource(R.drawable.s04icon);
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase05_p01_a01);
            txttruongthanh.setText("蛹");
        }
    }

    public void settexttuoichet(float age) {
        if (age > 0 && age < 1)
            txttuoichet.setText("1 齢幼虫");
        else if (age > 1 && age < 2)
            txttuoichet.setText("２齢幼虫");
        else if (age > 2 && age < 3)
            txttuoichet.setText("３齢幼虫");
        else if (age > 3 && age < 4)
            txttuoichet.setText("前蛹");
        else if (age > 4)
            txttuoichet.setText("蛹");
    }

    public void NhaPet(int prolength_nha, boolean swipe, int sum) {
        if (prolength_nha >= sum / 1.5) {
            if (swipe == false)
                _SachNha();
        } else if (prolength_nha >= sum / 4 && prolength_nha < sum / 1.5) {
            if (swipe == false)
                _DoNha();
        } else if (prolength_nha < sum / 4) {
            if (swipe == false)
                _DoNha2();
        }
    }

    public void setsttfor0age() {
        txtno.setText("満腹");
        txttrangthai.setText("フツウ");
        txtsuckhoe.setText("フツウ");
        txtngu.setText("しゃっきり");
        txtkhatnuoc.setText("フツウ");
    }

    public void SettextNgay(float age) {
        if (age > 0 && age < 1)
            txttuoichet.setText("1 齢幼虫");
        else if (age > 1 && age < 2)
            txttuoichet.setText("２齢幼虫");
        else if (age > 2 && age < 3)
            txttuoichet.setText("３齢幼虫");
        else if (age > 3 && age < 4)
            txttuoichet.setText("前蛹");
        else if (age > 4)
            txttuoichet.setText("成虫");
    }

    public void settextforsleep(int prolength_sleep, int max) {
        if (prolength_sleep < 2)
            txtngu.setText("眠い");
        else if (prolength_sleep > 2 && prolength_sleep < max * 0.8)
            txtngu.setText("フツウ");
        else if (prolength_sleep >= max * 0.8)
            txtngu.setText("しゃっきり");
    }

    public void setnhakhikich(String str, float age, boolean sleeping, int prolength_nha, boolean swipe, int max) {
        if (str.length() == 0)
            _SachNha();
        else if (str.length() > 0 && age < 3) {
            if (sleeping == false)
                NhaPet(prolength_nha, swipe, max);
        }
    }

    public void settextfordrink(float age, int prolength_uong, int max) {
        if (prolength_uong > max * 0.4 && prolength_uong < max * 0.8)
            txtkhatnuoc.setText("フツウ");
        else if (prolength_uong >= max * 0.8)
            txtkhatnuoc.setText("潤ってる");
        else if (prolength_uong < max * 0.4)
            txtkhatnuoc.setText("水分不足");
    }

    public void settextformood(int mood, int max) {
        if (mood < max * 0.4)
            txttrangthai.setText("悪い");
        else if (mood > max * 0.4 && mood < max * 0.6)
            txttrangthai.setText("フツウ");
        else if (mood > max * 0.6 && mood < max * 0.8)
            txttrangthai.setText("良い");
        else if (mood > max * 0.8)
            txttrangthai.setText("ごきげん");
    }

    public void settextforhealth(int health, int max) {
        if (health > max * 0.4 && health < max * 0.7)
            txtsuckhoe.setText("フツウ");
        else if (health > max * 0.7)
            txtsuckhoe.setText("良い");
        else if (health < max * 0.4)
            txtsuckhoe.setText("悪い");
    }

    public void settextforeat(int prolength, int max) {
        if (prolength >= max * 0.9)
            txtno.setText("満腹");
        else if (prolength >= max * 0.7 && prolength < max * 0.9)
            txtno.setText("腹八分目");
        else if (prolength >= max * 0.4 && prolength < max * 0.7)
            txtno.setText("ふつう");
        else if (prolength < max * 0.4)
            txtno.setText("空腹");
    }

    public void updatepr(float gioup) {
        indicator.setValue(gioup);
    }

    public void setprload14s(int i, int p, int click) {
        if (i > 30 && i <= 59 && p == 4) {
            if (CLICK_PET == click)
                indicator.setValue(0.1f);
        } else if (i > 0 && i <= 30 && p == 4) {
            if (CLICK_PET == click)
                indicator.setValue(0.2f);
        } else if (i > 30 && i <= 59 && p == 3) {
            if (CLICK_PET == click)
                indicator.setValue(0.3f);
        } else if (i > 0 && i <= 30 && p == 3) {
            if (CLICK_PET == click)
                indicator.setValue(0.4f);
        } else if (i > 30 && i <= 59 && p == 2) {
            if (CLICK_PET == click)
                indicator.setValue(0.5f);
        } else if (i > 0 && i <= 30 && p == 2) {
            if (CLICK_PET == click)
                indicator.setValue(0.6f);
        } else if (i > 30 && i <= 59 && p == 1) {
            if (CLICK_PET == click)
                indicator.setValue(0.7f);
        } else if (i > 0 && i <= 30 && p == 1) {
            if (CLICK_PET == click)
                indicator.setValue(0.8f);
        } else if (i > 30 && i <= 59 && p == 0) {
            if (CLICK_PET == click)
                indicator.setValue(0.9f);
        } else if (i > 20 && i <= 30 && p == 0) {
            if (CLICK_PET == click)
                indicator.setValue(0.93f);
        } else if (i > 4 && i <= 20 && p == 0) {
            if (CLICK_PET == click)
                indicator.setValue(0.96f);
        } else if (i > 1 && i <= 4 && p == 0) {
            if (CLICK_PET == click)
                indicator.setValue(1f);
        }
    }

    public void setdatadown() {
        updown = false;
        imgupdown.setImageResource(R.drawable.bgdown);
        bglayout.setBackgroundResource(R.drawable.breeding_bg);
        ShowAnimation();
        txtan.setBackgroundColor(Color.parseColor("#00000000"));
        txtnuoc.setBackgroundColor(Color.parseColor("#00000000"));
        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
        txtmsg.setVisibility(View.GONE);
        if (CLICK_PET == 1) {
            swipe = false;
            if (sleeping == false)
                imgzukan.setVisibility(View.VISIBLE);
            else if (sleeping == true)
                imgzukan.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe, runpaStartTime, fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 2) {
            swipe2 = false;
            if (sleeping2 == false)
                imgzukan2.setVisibility(View.VISIBLE);
            else if (sleeping2 == true)
                imgzukan2.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe2, runpaStartTime2, fritm_runpa2, fritm_runpa1, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 3) {
            swipe3 = false;
            if (sleeping3 == false)
                imgzukan3.setVisibility(View.VISIBLE);
            else if (sleeping3 == true)
                imgzukan3.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe3, runpaStartTime3, fritm_runpa3, fritm_runpa2, fritm_runpa1,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 4) {
            swipe4 = false;
            if (sleeping4 == false)
                imgzukan4.setVisibility(View.VISIBLE);
            else if (sleeping4 == true)
                imgzukan4.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe4, runpaStartTime4, fritm_runpa4, fritm_runpa2, fritm_runpa3,
                    fritm_runpa1, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 5) {
            swipe5 = false;
            if (sleeping5 == false)
                imgzukan5.setVisibility(View.VISIBLE);
            else if (sleeping5 == true)
                imgzukan5.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe5, runpaStartTime5, fritm_runpa5, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa1, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 6) {
            swipe6 = false;
            if (sleeping6 == false)
                imgzukan6.setVisibility(View.VISIBLE);
            else if (sleeping6 == true)
                imgzukan6.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe6, runpaStartTime6, fritm_runpa6, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa1, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 7) {
            swipe7 = false;
            if (sleeping7 == false)
                imgzukan7.setVisibility(View.VISIBLE);
            else if (sleeping7 == true)
                imgzukan7.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe7, runpaStartTime7, fritm_runpa7, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa1, fritm_runpa8);
        } else if (CLICK_PET == 8) {
            swipe8 = false;
            if (sleeping8 == false)
                imgzukan8.setVisibility(View.VISIBLE);
            else if (sleeping8 == true)
                imgzukan8.setVisibility(View.GONE);
            Chat.ShowRunpa(swipe8, runpaStartTime8, fritm_runpa8, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa1);
        }
    }

    public void setdataup() {
        updown = true;
        imgupdown.setImageResource(R.drawable.bgup);
        bglayout.setBackgroundResource(R.drawable.breeding_bg2);
        HideAnimation();
        txtan.setBackgroundColor(Color.parseColor("#00000000"));
        txtnuoc.setBackgroundColor(Color.parseColor("#00000000"));
        lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
        txtmsg.setVisibility(View.GONE);
        if (CLICK_PET == 1) {
            swipe = true;
            if (sleeping == false)
                imgzukan.setVisibility(View.GONE);
            else if (sleeping == true)
                imgzukan.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 2) {
            swipe2 = true;
            if (sleeping2 == false)
                imgzukan2.setVisibility(View.GONE);
            else if (sleeping2 == true)
                imgzukan2.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 3) {
            swipe3 = true;
            if (sleeping3 == false)
                imgzukan3.setVisibility(View.GONE);
            else if (sleeping3 == true)
                imgzukan3.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 4) {
            swipe4 = true;
            if (sleeping4 == false)
                imgzukan4.setVisibility(View.GONE);
            else if (sleeping4 == true)
                imgzukan4.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 5) {
            swipe5 = true;
            if (sleeping5 == false)
                imgzukan5.setVisibility(View.GONE);
            else if (sleeping5 == true)
                imgzukan5.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 6) {
            swipe6 = true;
            if (sleeping6 == false)
                imgzukan6.setVisibility(View.GONE);
            else if (sleeping6 == true)
                imgzukan6.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 7) {
            swipe7 = true;
            if (sleeping7 == false)
                imgzukan7.setVisibility(View.GONE);
            else if (sleeping7 == true)
                imgzukan7.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        } else if (CLICK_PET == 8) {
            swipe8 = true;
            if (sleeping8 == false)
                imgzukan8.setVisibility(View.GONE);
            else if (sleeping8 == true)
                imgzukan8.setVisibility(View.VISIBLE);
            Chat.HideRunpa(fritm_runpa1, fritm_runpa2, fritm_runpa3,
                    fritm_runpa4, fritm_runpa5, fritm_runpa6, fritm_runpa7, fritm_runpa8);
        }
    }

    public void HideAnimation() {
        layoutOver.setVisibility(View.GONE);
        layoutUnder.setVisibility(View.VISIBLE);
        frcloud.setVisibility(View.GONE);
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        t3.setVisibility(View.GONE);
        t18.setVisibility(View.GONE);
        t22.setVisibility(View.GONE);
        t4.setVisibility(View.GONE);
        t9.setVisibility(View.GONE);
        t11.setVisibility(View.GONE);
        t14.setVisibility(View.GONE);
        t15.setVisibility(View.GONE);
        t16.setVisibility(View.GONE);
        t19.setVisibility(View.GONE);
        tfl1.setVisibility(View.GONE);
        tfl2.setVisibility(View.GONE);
        t6.setVisibility(View.GONE);
        t7.setVisibility(View.GONE);
    }

    public void ShowAnimation() {
        layoutOver.setVisibility(View.VISIBLE);
        layoutUnder.setVisibility(View.GONE);
        frcloud.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t18.setVisibility(View.VISIBLE);
        t22.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        t9.setVisibility(View.VISIBLE);
        t11.setVisibility(View.VISIBLE);
        t14.setVisibility(View.VISIBLE);
        t15.setVisibility(View.VISIBLE);
        t16.setVisibility(View.VISIBLE);
        t19.setVisibility(View.VISIBLE);
        tfl1.setVisibility(View.VISIBLE);
        tfl2.setVisibility(View.VISIBLE);
        t6.setVisibility(View.VISIBLE);
        t7.setVisibility(View.VISIBLE);
    }

    public void DrawLevel(String str, LinearLayout layoutLevel) {
        String[] arr = str.split("");
        int sizelv = 11;
        if (mypage._Width <= 480)
            sizelv = 9;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(sizelv, LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < arr.length; i++) {
            ImageView img = new ImageView(this);
            img.setLayoutParams(params);
            img.setAdjustViewBounds(true);
            if (arr[i].equals("0"))
                img.setImageResource(R.drawable.num0);
            else if (arr[i].equals("1"))
                img.setImageResource(R.drawable.num1);
            else if (arr[i].equals("2"))
                img.setImageResource(R.drawable.num2);
            else if (arr[i].equals("3"))
                img.setImageResource(R.drawable.num3);
            else if (arr[i].equals("4"))
                img.setImageResource(R.drawable.num4);
            else if (arr[i].equals("5"))
                img.setImageResource(R.drawable.num5);
            else if (arr[i].equals("6"))
                img.setImageResource(R.drawable.num6);
            else if (arr[i].equals("7"))
                img.setImageResource(R.drawable.num7);
            else if (arr[i].equals("8"))
                img.setImageResource(R.drawable.num8);
            else if (arr[i].equals("9"))
                img.setImageResource(R.drawable.num9);
            layoutLevel.addView(img);
        }
    }

    boolean b_leaf = false;
    int run_l = 0;
    Runnable run_leaf = new Runnable() {
        @Override
        public void run() {
            if (b_leaf) {
                run_l++;
                if (run_l > 6) {
                    b_leaf = false;
                    run_l = 0;
                }
                if (run_l == 1 || run_l == 4)
                    bglayout.setBackgroundResource(R.drawable.bgleaf1);
                if (run_l == 2 || run_l == 5)
                    bglayout.setBackgroundResource(R.drawable.bgleaf3);
                if (run_l == 3 || run_l == 6)
                    bglayout.setBackgroundResource(R.drawable.breeding_bg);
            }
            handler.postDelayed(run_leaf, 500);
        }
    };

//    public void runLeaf() {
//        Thread t = new Thread() {
//            int i;
//
//            @Override
//            public void run() {
//                for (i = 0; i <= 6; i++) {
//                    try {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (i == 1 || i == 4) {
//                                    if ((CLICK_PET == 1 && !swipe) || (CLICK_PET == 2 && !swipe2) || (CLICK_PET == 3 && !swipe3) || (CLICK_PET == 4 && !swipe4)
//                                            || (CLICK_PET == 5 && !swipe5) || (CLICK_PET == 6 && !swipe6) || (CLICK_PET == 7 && !swipe7) || (CLICK_PET == 8 && !swipe8))
//                                        bglayout.setBackgroundResource(R.drawable.bgleaf1);
//                                }
//                                if (i == 2 || i == 5) {
//                                    if ((CLICK_PET == 1 && !swipe) || (CLICK_PET == 2 && !swipe2) || (CLICK_PET == 3 && !swipe3) || (CLICK_PET == 4 && !swipe4)
//                                            || (CLICK_PET == 5 && !swipe5) || (CLICK_PET == 6 && !swipe6) || (CLICK_PET == 7 && !swipe7) || (CLICK_PET == 8 && !swipe8))
//                                        bglayout.setBackgroundResource(R.drawable.bgleaf3);
//                                }
//                                if (i == 3 || i == 6) {
//                                    if ((CLICK_PET == 1 && !swipe) || (CLICK_PET == 2 && !swipe2) || (CLICK_PET == 3 && !swipe3) || (CLICK_PET == 4 && !swipe4)
//                                            || (CLICK_PET == 5 && !swipe5) || (CLICK_PET == 6 && !swipe6) || (CLICK_PET == 7 && !swipe7) || (CLICK_PET == 8 && !swipe8))
//                                        bglayout.setBackgroundResource(R.drawable.breeding_bg);
//                                }
//                            }
//                        });
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//
//                    }
//                }
//            }
//        };
//        t.start();
//    }

    public void _actionClean() {
        {
            if (mypage.theluc < 1) {
                CheckTheLuc();
                return;
            }
            if (mypage.theluc >= 1)
                mypage.theluc--;
            if (CLICK_PET == 1) {
                if (atomicBoolean == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean == false) {
                    _quetnha();
                    lastCleanTime = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly += 10;
                    if (friendly >= 800)
                        friendly = 800;
                    mood += 200;
                    if (mood >= 800)
                        mood = 800;
                    health += 200;
                    if (health >= 800)
                        health = 800;
                    prolength -= 100;
                    if (prolength <= 100)
                        prolength = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 2) {
                if (atomicBoolean2 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean2 == false) {
                    _quetnha2();
                    lastCleanTime2 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly2 += 10;
                    if (friendly2 >= 800)
                        friendly2 = 800;
                    mood2 += 200;
                    if (mood2 >= 800)
                        mood2 = 800;
                    health2 += 200;
                    if (health2 >= 800)
                        health2 = 800;
                    prolength2 -= 100;
                    if (prolength2 <= 80)
                        prolength2 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 3) {
                if (atomicBoolean3 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean3 == false) {
                    _quetnha3();
                    lastCleanTime3 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly3 += 10;
                    if (friendly3 >= 1000)
                        friendly3 = 1000;
                    mood3 += 200;
                    if (mood3 >= 1000)
                        mood3 = 1000;
                    health3 += 200;
                    if (health3 >= 1000)
                        health3 = 1000;
                    prolength3 -= 100;
                    if (prolength3 <= 80)
                        prolength3 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 4) {
                if (atomicBoolean4 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean4 == false) {
                    _quetnha4();
                    lastCleanTime4 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly4 += 10;
                    if (friendly4 >= 2000)
                        friendly4 = 2000;
                    mood4 += 200;
                    if (mood4 >= 2000)
                        mood4 = 2000;
                    health4 += 200;
                    if (health4 >= 2000)
                        health4 = 2000;
                    prolength4 -= 100;
                    if (prolength4 <= 80)
                        prolength4 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 5) {
                if (atomicBoolean5 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean5 == false) {
                    _quetnha5();
                    lastCleanTime5 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly5 += 10;
                    if (friendly5 >= 2000)
                        friendly5 = 2000;
                    mood5 += 200;
                    if (mood5 >= 2000)
                        mood5 = 2000;
                    health5 += 200;
                    if (health5 >= 2000)
                        health5 = 2000;
                    prolength5 -= 100;
                    if (prolength5 <= 80)
                        prolength5 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 6) {
                if (atomicBoolean6 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean6 == false) {
                    _quetnha6();
                    lastCleanTime6 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly6 += 10;
                    if (friendly6 >= 2000)
                        friendly6 = 2000;
                    mood6 += 200;
                    if (mood6 >= 2000)
                        mood6 = 2000;
                    health6 += 200;
                    if (health6 >= 2000)
                        health6 = 2000;
                    prolength6 -= 100;
                    if (prolength6 <= 80)
                        prolength6 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 7) {
                if (atomicBoolean7 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean7 == false) {
                    _quetnha7();
                    lastCleanTime7 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly7 += 10;
                    if (friendly7 >= 1500)
                        friendly7 = 1500;
                    mood7 += 200;
                    if (mood7 >= 1500)
                        mood7 = 1500;
                    health7 += 200;
                    if (health7 >= 1500)
                        health7 = 1500;
                    prolength7 -= 100;
                    if (prolength7 <= 80)
                        prolength7 = 1;
                    _ButtonDisable();
                }
            }
            if (CLICK_PET == 8) {
                if (atomicBoolean8 == true) {
                    KichItemKhiConTrung();
                } else if (atomicBoolean8 == false) {
                    _quetnha8();
                    lastCleanTime8 = System.currentTimeMillis() / 1000;
                    exp += 1;
                    friendly8 += 10;
                    if (friendly8 >= 3000)
                        friendly8 = 3000;
                    mood8 += 200;
                    if (mood8 >= 3000)
                        mood8 = 3000;
                    health8 += 200;
                    if (health8 >= 3000)
                        health8 = 3000;
                    prolength8 -= 100;
                    if (prolength8 <= 80)
                        prolength8 = 1;
                    _ButtonDisable();
                }
            }
        }
    }

    public void setSizeName() {
        if (CLICK_PET == 1 || CLICK_PET == 2 || CLICK_PET == 4) {
            textView25.setTextSize(9);
            txttruongthanh.setTextSize(9);
        } else if (CLICK_PET == 3 || CLICK_PET == 7 || CLICK_PET == 8) {
            textView25.setTextSize(6);
            txttruongthanh.setTextSize(6);
        } else if (CLICK_PET == 5) {
            textView25.setTextSize(7);
            txttruongthanh.setTextSize(7);
        } else if (CLICK_PET == 6) {
            textView25.setTextSize(5);
            txttruongthanh.setTextSize(5);
        }
    }

    public void _actionRunpa(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa2(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa2(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa3(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa3(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa4(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa4(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa5(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa5(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa6(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa6(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa7(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa7(itm_runpa1);
        _SachNha();
    }

    public void _actionRunpa8(ImageView itm_runpa1, FrameLayout fr) {
        fr.setVisibility(View.VISIBLE);
        _AnimRunpa8(itm_runpa1);
        _SachNha();
    }

    public void _AnimRunpa8(final ImageView itm_runpa1) {
        anim_itm_runpa8 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa8.setDuration(10000);
        anim_itm_runpa8.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after8);
            }
        });

        anim_itm_runpa1_after8 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after8.setDuration(10000);
        anim_itm_runpa1_after8.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa8);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa8);
    }

    public void _AnimRunpa7(final ImageView itm_runpa1) {
        anim_itm_runpa7 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa7.setDuration(10000);
        anim_itm_runpa7.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after7);
            }
        });

        anim_itm_runpa1_after7 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after7.setDuration(10000);
        anim_itm_runpa1_after7.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa7);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa7);
    }

    public void _AnimRunpa6(final ImageView itm_runpa1) {
        anim_itm_runpa6 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa6.setDuration(10000);
        anim_itm_runpa6.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after6);
            }
        });

        anim_itm_runpa1_after6 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after6.setDuration(10000);
        anim_itm_runpa1_after6.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa6);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa6);
    }

    public void _AnimRunpa5(final ImageView itm_runpa1) {
        anim_itm_runpa5 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa5.setDuration(10000);
        anim_itm_runpa5.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after5);
            }
        });

        anim_itm_runpa1_after5 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after5.setDuration(10000);
        anim_itm_runpa1_after5.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa5);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa5);
    }

    public void _AnimRunpa4(final ImageView itm_runpa1) {
        anim_itm_runpa4 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa4.setDuration(10000);
        anim_itm_runpa4.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after4);
            }
        });

        anim_itm_runpa1_after4 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after4.setDuration(10000);
        anim_itm_runpa1_after4.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa4);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa4);
    }

    public void _AnimRunpa3(final ImageView itm_runpa1) {
        anim_itm_runpa3 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa3.setDuration(10000);
        anim_itm_runpa3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after3);
            }
        });

        anim_itm_runpa1_after3 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after3.setDuration(10000);
        anim_itm_runpa1_after3.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa3);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa3);
    }

    public void _AnimRunpa2(final ImageView itm_runpa1) {
        anim_itm_runpa2 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa2.setDuration(10000);
        anim_itm_runpa2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after2);
            }
        });

        anim_itm_runpa1_after2 = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after2.setDuration(10000);
        anim_itm_runpa1_after2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa2);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa2);
    }

    public void _AnimRunpa(final ImageView itm_runpa1) {
        anim_itm_runpa1 = new TranslateAnimation(0, 120, 0, 0);
        anim_itm_runpa1.setDuration(10000);
        anim_itm_runpa1.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa1);
                itm_runpa1.setRotation(30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1_after);
            }
        });

        anim_itm_runpa1_after = new TranslateAnimation(0, -120, 0, 0);
        anim_itm_runpa1_after.setDuration(10000);
        anim_itm_runpa1_after.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                itm_runpa1.setImageResource(R.drawable.itm_runpa2);
                itm_runpa1.setRotation(-30);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) itm_runpa1.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 120;
                itm_runpa1.clearAnimation();
                itm_runpa1.setLayoutParams(params);
                itm_runpa1.startAnimation(anim_itm_runpa1);
            }
        });
        itm_runpa1.startAnimation(anim_itm_runpa1);
    }

    TextView txtyesbutton, zk_title;

    public void Dialog_notify() {
        final Dialog dialogwhenbuy = new Dialog(zukan_main.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        zk_title = (TextView) dialogwhenbuy.findViewById(R.id.textView2);
        zk_title.setText("飼育");
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogwhenbuy.dismiss();
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    Timer timer, timer_load14s;
    TimerTask timerTask, timerTask_load14s;
    int imgCur = 0, cur_load14s = 0;

    public void _StartLoad14s() {
        timer_load14s = new Timer();
        initializeTimerTask_14s();
        timer_load14s.schedule(timerTask_load14s, 0, 500);
    }

    public void initializeTimerTask_14s() {
        timerTask_load14s = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        cur_load14s++;
                        if (cur_load14s > 3) {
                            if (timer_load14s != null) {
                                timer_load14s.cancel();
                                timer_load14s = null;
                            }
                        }
                        if (cur_load14s == 1) {
                            ZoomIMG();
                            Dialog_Level();
                            Dialog_finish();
                            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                            String ten1 = pre.getString("tenzukan", "");
                            String ten2 = pre.getString("tenzukan2", "");
                            String ten3 = pre.getString("tenzukan3", "");
                            String ten4 = pre.getString("tenzukan4", "");
                            String ten5 = pre.getString("tenzukan5", "");
                            String ten6 = pre.getString("tenzukan6", "");
                            String ten7 = pre.getString("tenzukan7", "");
                            String ten8 = pre.getString("tenzukan8", "");
                            if (ten1.length() > 0) {
                                String daload14s = pre.getString("daload14s", "");
                                if (daload14s.length() == 0) {
                                    _Load14s();
                                } else if (daload14s.length() > 0) {
                                    if (age < 3) {
                                        if (health < 2)
                                            handler.post(runnable_sk);
                                        if (runpaStartTime == 0)
                                            handler.post(runnable_nha);
                                        else if (runpaStartTime != 0)
                                            _AnimRunpa(itm_runpa1);
                                        handler.post(runnablehealth);
                                        handler.post(runnablemood);
                                        handler.post(runnable);
                                        handler.post(runnable_uong);
                                        handler.post(dt);
                                        handler.post(runnable_sleep);
                                        if (prolength_sleep < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping = true;
                                            imgzukan.setVisibility(View.GONE);
                                            _SLEEPANIMATION();
                                        }
                                        TieuTien();
                                    }
                                    int _i = pre.getInt("useitem", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge2);
                                    if (CLICK_PET == 1) {
                                        if (pre.getFloat("age", 0) < 3)
                                            NhaPet(prolength_nha, swipe, 800);
                                        else if (pre.getFloat("age", 0) >= 3) {
                                            sleeping = true;
                                            swipe = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action);
                                        _tenzukan.setText("" + ten1);
                                        textView25.setText("カブトムシ");
                                    }
                                    _AGE();
                                }
                            }
                            if (ten2.length() > 0) {
                                String daload14s = pre.getString("daload14s2", "");
                                if (daload14s.length() == 0) {
                                    _Load14s2();
                                } else if (daload14s.length() > 0) {
                                    if (age2 < 3) {
                                        if (health2 < 2)
                                            handler.post(runnable2_sk);
                                        if (runpaStartTime2 == 0)
                                            handler.post(runnable_nha2);
                                        else if (runpaStartTime2 != 0)
                                            _AnimRunpa2(itm_runpa2);
                                        handler.post(runnablehealth2);
                                        handler.post(runnablemood2);
                                        handler.post(runnable2);
                                        handler.post(runnable_uong2);
                                        handler.post(runnable_sleep2);
                                        if (prolength_sleep2 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping2 = true;
                                            imgzukan2.setVisibility(View.GONE);
                                            _SLEEPANIMATION2();
                                        }

                                        TieuTien2();
                                        handler.post(dt2);
                                    }
                                    int _i = pre.getInt("useitem2", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge2);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho2);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge22);
                                    if (CLICK_PET == 2) {
                                        if (pre.getFloat("age2", 0) < 3)
                                            NhaPet(prolength_nha2, swipe2, 800);
                                        else if (pre.getFloat("age2", 0) >= 3) {
                                            sleeping2 = true;
                                            swipe2 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan2.setVisibility(View.VISIBLE);
                                        }
                                        _tenzukan.setText("" + ten2);
                                        textView25.setText("コクワガタ");
                                        handler.post(runnable_action2);
                                    }
                                    handler.post(run_age2);

                                }
                            }
                            if (ten3.length() > 0) {
                                String daload14s = pre.getString("daload14s3", "");
                                if (daload14s.length() == 0) {
                                    _Load14s3();
                                } else if (daload14s.length() > 0) {
                                    if (age3 < 3) {
                                        if (health3 < 2)
                                            handler.post(runnable3_sk);
                                        if (runpaStartTime3 == 0)
                                            handler.post(runnable_nha3);
                                        else if (runpaStartTime3 != 0)
                                            _AnimRunpa3(itm_runpa3);
                                        handler.post(runnablehealth3);
                                        handler.post(runnablemood3);
                                        handler.post(runnable3);
                                        handler.post(runnable_uong3);
                                        handler.post(runnable_sleep3);
                                        if (prolength_sleep3 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping3 = true;
                                            imgzukan3.setVisibility(View.GONE);
                                            _SLEEPANIMATION3();
                                        }
                                        TieuTien3();
                                        handler.post(dt3);
                                    }
                                    int _i = pre.getInt("useitem3", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge3);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho3);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge23);
                                    if (CLICK_PET == 3) {
                                        if (pre.getFloat("age3", 0) < 3)
                                            NhaPet(prolength_nha3, swipe3, 1000);
                                        if (pre.getFloat("age3", 0) >= 3) {
                                            sleeping3 = true;
                                            swipe3 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan3.setVisibility(View.VISIBLE);
                                        }
                                        _tenzukan.setText("" + ten3);
                                        textView25.setText("コーカサスオオカブト");
                                        handler.post(runnable_action3);
                                    }
                                    handler.post(run_age3);
                                }
                            }
                            if (ten4.length() > 0) {
                                String daload14s = pre.getString("daload14s4", "");
                                if (daload14s.length() == 0) {
                                    _Load14s4();
                                } else if (daload14s.length() > 0) {
                                    if (age4 < 3) {
                                        if (health4 < 2)
                                            handler.post(runnable4_sk);
                                        if (runpaStartTime4 == 0)
                                            handler.post(runnable_nha4);
                                        else if (runpaStartTime4 != 0)
                                            _AnimRunpa4(itm_runpa4);
                                        handler.post(runnablehealth4);
                                        handler.post(runnablemood4);
                                        handler.post(runnable4);
                                        handler.post(runnable_uong4);
                                        handler.post(runnable_sleep4);
                                        if (prolength_sleep4 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping4 = true;
                                            imgzukan4.setVisibility(View.GONE);
                                            _SLEEPANIMATION4();
                                        }
                                        TieuTien4();
                                        handler.post(dt4);
                                    }
                                    int _i = pre.getInt("useitem4", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge4);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho4);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge24);
                                    if (CLICK_PET == 4) {
                                        if (pre.getFloat("age4", 0) < 3)
                                            NhaPet(prolength_nha4, swipe4, 2000);
                                        if (pre.getFloat("age4", 0) >= 3) {
                                            sleeping4 = true;
                                            swipe4 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan4.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action4);
                                        _tenzukan.setText("" + ten4);
                                        textView25.setText("オオクワガタ");
                                    }
                                    handler.post(run_age4);
                                }
                            }
                            if (ten5.length() > 0) {
                                String daload14s = pre.getString("daload14s5", "");
                                if (daload14s.length() == 0) {
                                    _Load14s5();
                                } else if (daload14s.length() > 0) {
                                    if (age5 < 3) {
                                        if (health5 < 2)
                                            handler.post(runnable5_sk);
                                        if (runpaStartTime5 == 0)
                                            handler.post(runnable_nha5);
                                        else if (runpaStartTime5 != 0)
                                            _AnimRunpa5(itm_runpa5);
                                        handler.post(runnablehealth5);
                                        handler.post(runnablemood5);
                                        handler.post(runnable5);
                                        handler.post(runnable_uong5);
                                        handler.post(runnable_sleep5);
                                        if (prolength_sleep5 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping5 = true;
                                            imgzukan5.setVisibility(View.GONE);
                                            _SLEEPANIMATION5();
                                        }
                                        TieuTien5();
                                        handler.post(dt5);
                                    }
                                    int _i = pre.getInt("useitem5", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge5);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho5);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge25);
                                    if (CLICK_PET == 5) {
                                        if (pre.getFloat("age5", 0) < 3)
                                            NhaPet(prolength_nha5, swipe5, 2000);
                                        if (pre.getFloat("age5", 0) >= 3) {
                                            sleeping5 = true;
                                            swipe5 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan5.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action5);
                                        _tenzukan.setText("" + ten5);
                                        textView25.setText("サタンオオカブト");
                                    }
                                    handler.post(run_age5);
                                }
                            }
                            if (ten6.length() > 0) {
                                String daload14s = pre.getString("daload14s6", "");
                                if (daload14s.length() == 0) {
                                    _Load14s6();
                                } else if (daload14s.length() > 0) {
                                    if (age6 < 3) {
                                        if (health6 < 2)
                                            handler.post(runnable6_sk);
                                        if (runpaStartTime6 == 0)
                                            handler.post(runnable_nha6);
                                        else if (runpaStartTime6 != 0)
                                            _AnimRunpa6(itm_runpa6);
                                        handler.post(runnablehealth6);
                                        handler.post(runnablemood6);
                                        handler.post(runnable6);
                                        handler.post(runnable_uong6);
                                        handler.post(runnable_sleep6);
                                        if (prolength_sleep6 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping6 = true;
                                            imgzukan6.setVisibility(View.GONE);
                                            _SLEEPANIMATION6();
                                        }
                                        TieuTien6();
                                        handler.post(dt6);
                                    }
                                    int _i = pre.getInt("useitem6", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge6);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho6);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge26);
                                    if (CLICK_PET == 6) {
                                        if (pre.getFloat("age6", 0) < 3)
                                            NhaPet(prolength_nha6, swipe6, 2000);
                                        if (pre.getFloat("age6", 0) >= 3) {
                                            sleeping6 = true;
                                            swipe6 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan6.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action6);
                                        _tenzukan.setText("" + ten6);
                                        textView25.setText("ギラファノコギリクワガタ");
                                    }
                                    handler.post(run_age6);
                                }
                            }
                            if (ten7.length() > 0) {
                                String daload14s = pre.getString("daload14s7", "");
                                if (daload14s.length() == 0) {
                                    _Load14s7();
                                } else if (daload14s.length() > 0) {
                                    if (age7 < 3) {
                                        if (health7 < 2)
                                            handler.post(runnable7_sk);
                                        if (runpaStartTime7 == 0)
                                            handler.post(runnable_nha7);
                                        else if (runpaStartTime7 != 0)
                                            _AnimRunpa7(itm_runpa7);
                                        handler.post(runnablehealth7);
                                        handler.post(runnablemood7);
                                        handler.post(runnable7);
                                        handler.post(runnable_uong7);
                                        handler.post(runnable_sleep7);
                                        if (prolength_sleep7 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping7 = true;
                                            imgzukan7.setVisibility(View.GONE);
                                            _SLEEPANIMATION7();
                                        }
                                        TieuTien7();
                                        handler.post(dt7);
                                    }
                                    int _i = pre.getInt("useitem7", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge7);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho7);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge27);
                                    if (CLICK_PET == 7) {
                                        if (pre.getFloat("age7", 0) < 3)
                                            NhaPet(prolength_nha7, swipe7, 1500);
                                        if (pre.getFloat("age", 0) >= 3) {
                                            sleeping7 = true;
                                            swipe7 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan7.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action7);
                                        _tenzukan.setText("" + ten7);
                                        textView25.setText("オウゴンオニクワガタ");
                                    }
                                    handler.post(run_age7);
                                }
                            }
                            if (ten8.length() > 0) {
                                String daload14s = pre.getString("daload14s8", "");
                                if (daload14s.length() == 0) {
                                    _Load14s8();
                                } else if (daload14s.length() > 0) {
                                    handler.post(run_age8);
                                    if (age8 < 3) {
                                        if (health8 < 2)
                                            handler.post(runnable8_sk);
                                        if (runpaStartTime8 == 0)
                                            handler.post(runnable_nha8);
                                        else if (runpaStartTime8 != 0)
                                            _AnimRunpa8(itm_runpa8);
                                        handler.post(runnablehealth8);
                                        handler.post(runnablemood8);
                                        handler.post(runnable8);
                                        handler.post(runnable_uong8);
                                        handler.post(runnable_sleep8);
                                        if (prolength_sleep8 < 2) {
                                            lnmsg.setBackgroundColor(Color.parseColor("#00000000"));
                                            txtmsg.setVisibility(View.GONE);
                                            sleeping8 = true;
                                            imgzukan8.setVisibility(View.GONE);
                                            _SLEEPANIMATION8();
                                        }
                                        TieuTien8();
                                        handler.post(dt8);
                                    }
                                    int _i = pre.getInt("useitem8", 0);
                                    if (_i == 0)
                                        handler.post(runnable_timeUpAge8);
                                    else if (_i == 1)
                                        handler.post(runnable_UpAge2Nho8);
                                    else if (_i == 2)
                                        handler.post(runnable_UpAge28);
                                    if (CLICK_PET == 8) {
                                        if (pre.getFloat("age8", 0) < 3)
                                            NhaPet(prolength_nha8, swipe8, 3000);
                                        if (pre.getFloat("age8", 0) >= 3) {
                                            sleeping8 = true;
                                            swipe8 = true;
                                            bglayout.setBackgroundResource(R.drawable.breeding_bg2);
                                            HideAnimation();
                                            imgupdown.setImageResource(R.drawable.bgup);
                                            imgzukan8.setVisibility(View.VISIBLE);
                                        }
                                        handler.post(runnable_action8);
                                        _tenzukan.setText("" + ten8);
                                        textView25.setText("ヘラクレスオオカブト");
                                    }
                                }
                            }
                        }
                    }
                });
            }
        };
    }

    public void startTimer() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 0, 10000);
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        imgCur++;
                        if (imgCur > 25)
                            imgCur = 0;
                        if (imgCur == 2) {
                            if (CLICK_PET == 1) {
                                if (!swipe)
                                    b_leaf = true;
                            } else if (CLICK_PET == 2) {
                                if (!swipe2)
                                    b_leaf = true;
                            } else if (CLICK_PET == 3) {
                                if (!swipe3)
                                    b_leaf = true;
                            } else if (CLICK_PET == 4) {
                                if (!swipe4)
                                    b_leaf = true;
                            } else if (CLICK_PET == 5) {
                                if (!swipe5)
                                    b_leaf = true;
                            } else if (CLICK_PET == 6) {
                                if (!swipe6)
                                    b_leaf = true;
                            } else if (CLICK_PET == 7) {
                                if (!swipe7)
                                    b_leaf = true;
                            } else if (CLICK_PET == 8) {
                                if (!swipe8)
                                    b_leaf = true;
                            }
                        }
                        if (imgCur == 3) {
                            frimgbutterfly.setVisibility(View.VISIBLE);
                            frpill.setVisibility(View.GONE);
                            frworm.setVisibility(View.GONE);
                        }
                        if (imgCur == 10) {
                            frpill.setVisibility(View.VISIBLE);
                            frimgbutterfly.setVisibility(View.GONE);
                            frworm.setVisibility(View.GONE);
                        }
                        if (imgCur == 15) {
                            frworm.setVisibility(View.VISIBLE);
                            frpill.setVisibility(View.GONE);
                            frimgbutterfly.setVisibility(View.GONE);
                        }
                        if (imgCur == 20) {
                            frimgbutterfly.setVisibility(View.GONE);
                            frpill.setVisibility(View.GONE);
                            frworm.setVisibility(View.GONE);
                        }
                        if (imgCur == 22)
                            handler.post(run_leaf);
                        if (imgCur == 25)
                            handler.post(run_leaf);
                    }
                });
            }
        };
    }

    public void setimgshowfinish(float age) {
        if (age < 1)
            bginfo.setImageResource(R.drawable.beetle_phase01_p01_a01);
        else if (age > 1 && age < 2)
            bginfo.setImageResource(R.drawable.beetle_phase02_p01_a01);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            bginfo.setImageResource(R.drawable.beetle_phase03_p01_a01);
        else if (age > 4)
            bginfo.setImageResource(R.drawable.beetle_phase05_p01_a01);
    }

    public void setimgshowfinish2(float age2) {
        if (age2 < 1)
            bginfo.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
        else if (age2 > 1 && age2 < 2)
            bginfo.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
        else if (age2 > 2 && age2 < 3)
            bginfo.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        else if (age2 > 3 && age2 < 4)
            bginfo.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
        else if (age2 > 4)
            bginfo.setImageResource(R.drawable.stag_beetle_phase05_p01_a01);
    }

    public void speak_clean(float age) {
        if (age > 0 && age < 1)
            ShowLnmsg(Chat.NoiKhiQuetNha1tuoi.length, Chat.NoiKhiQuetNha1tuoi);
        else if (age > 1 && age < 2)
            ShowLnmsg(Chat.NoiKhiQuetNha2tuoi.length, Chat.NoiKhiQuetNha2tuoi);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            ShowLnmsg(Chat.NoiKhiQuetNha.length, Chat.NoiKhiQuetNha);
    }

    public void speak_eat(float age) {
        if (age > 0 && age < 1)
            ShowLnmsg(Chat.NoiKhiAn1tuoi.length, Chat.NoiKhiAn1tuoi);
        else if (age > 1 && age < 2)
            ShowLnmsg(Chat.NoiKhiAn2tuoi.length, Chat.NoiKhiAn2tuoi);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            ShowLnmsg(Chat.NoiKhiAn.length, Chat.NoiKhiAn);
    }

    public void sleep_1(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p14_a01);
        else if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p14_a01);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p14_a01);
    }

    public void sleep_2(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p14_a02);
        else if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p14_a02);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p14_a02);
    }

    public void sleep_3(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p14_a03);
        else if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p14_a03);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p14_a03);
    }

    public void sleep_5(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p14_a04);
        else if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p14_a04);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p14_a04);
    }

    public void sleep_4(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p14_a05);
        else if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p14_a05);
        else if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p14_a05);
    }

    public void sleep_rank21(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p14_a01);
        else if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p14_a01);
        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p14_a01);
    }

    public void sleep_rank22(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p14_a02);
        else if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p14_a02);
        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p14_a02);
    }

    public void sleep_rank23(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p14_a03);
        else if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p14_a03);
        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p14_a03);
    }

    public void sleep_rank24(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p14_a04);
        else if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p14_a04);
        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p14_a04);
    }

    public void sleep_rank25(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p14_a05);
        else if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p14_a05);
        else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p14_a05);
    }

    public void clean_1(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p06_a03);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p06_a01);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p06_a01);
    }

    public void clean_2(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p06_a02);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p06_a02);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p06_a02);
    }

    public void clean_3(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p06_a03r);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p06_a03);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p06_a03);
    }

    public void clean_rank21(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p06_a01);
        if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p06_a01);
        if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p06_a01);
    }

    public void clean_rank22(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p06_a02);
        if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p06_a02);
        if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p06_a02);
    }

    public void clean_rank23(float age2, ImageView imgzukan2) {
        if (age2 > 0 && age2 < 1)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase01_p06_a03);
        if (age2 > 1 && age2 < 2)
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase02_p06_a03);
        if ((age2 > 2 && age2 < 3) || (age2 > 3 && age2 < 4))
            imgzukan2.setImageResource(R.drawable.stag_beetle_phase03_p06_a03);
    }

    public void speak_mood2(int mood2, float age2, ImageView imgzukan, int max) {
        if ((mood2 == max * 0.8) || (mood2 == max * 0.7) || (mood2 == max * 0.6)) {
            if (age2 < 1)
                ShowLnmsg(Chat.NoiKhiMoodTot1tuoi.length, Chat.NoiKhiMoodTot1tuoi);
            else if (age2 > 1 && age2 < 2)
                ShowLnmsg(Chat.NoiKhiMoodTot2tuoi.length, Chat.NoiKhiMoodTot2tuoi);
            else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4))
                ShowLnmsg(Chat.NoiKhiMoodTot3tuoi.length, Chat.NoiKhiMoodTot3tuoi);
        } else if (mood2 == max * 0.4 || mood2 == max * 0.3 || mood2 == max * 0.2 || mood2 == max * 0.1) {
            if (age2 < 1) {
                ShowLnmsg(Chat.NoiKhiMoodXau1tuoi.length, Chat.NoiKhiMoodXau1tuoi);
                imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p10_a01);
            } else if (age2 > 1 && age2 < 2) {
                ShowLnmsg(Chat.NoiKhiMoodXau2tuoi.length, Chat.NoiKhiMoodXau2tuoi);
                imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p10_a01);
            } else if ((age2 > 2 && age2 < 3) || (age2 > 3 && age < 4)) {
                ShowLnmsg(Chat.NoiKhiMoodXau3tuoi.length, Chat.NoiKhiMoodXau3tuoi);
                imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p10_a01);
            }
        }
    }

    public void speak_mood(int mood, float age, ImageView imgzukan, int max) {
        if ((mood == max * 0.8) || (mood == max * 0.7) || (mood == max * 0.6)) {
            if (age < 1)
                ShowLnmsg(Chat.NoiKhiMoodTot1tuoi.length, Chat.NoiKhiMoodTot1tuoi);
            else if (age > 1 && age < 2)
                ShowLnmsg(Chat.NoiKhiMoodTot2tuoi.length, Chat.NoiKhiMoodTot2tuoi);
            else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                ShowLnmsg(Chat.NoiKhiMoodTot3tuoi.length, Chat.NoiKhiMoodTot3tuoi);
        } else if (mood == max * 0.4 || mood == max * 0.3 || mood == max * 0.2 || mood == max * 0.1) {
            if (age < 1) {
                ShowLnmsg(Chat.NoiKhiMoodXau1tuoi.length, Chat.NoiKhiMoodXau1tuoi);
                imgzukan.setImageResource(R.drawable.beetle_phase01_p10_a01);
            } else if (age > 1 && age < 2) {
                ShowLnmsg(Chat.NoiKhiMoodXau2tuoi.length, Chat.NoiKhiMoodXau2tuoi);
                imgzukan.setImageResource(R.drawable.beetle_phase02_p10_a01);
            } else if ((age > 2 && age < 3) || (age > 3 && age < 4)) {
                ShowLnmsg(Chat.NoiKhiMoodXau3tuoi.length, Chat.NoiKhiMoodXau3tuoi);
                imgzukan.setImageResource(R.drawable.beetle_phase03_p10_a01);
            }
        }
    }

    public void img_eat2(int prolength, int max, float age, ImageView imgzukan, boolean sleeping) {
        if (prolength == max * 0.4 || prolength == max * 0.3 || prolength == max * 0.2) {
            if (age < 1)
                ShowLnmsg(Chat.NoiKhiDoi1tuoi.length, Chat.NoiKhiDoi1tuoi);
            else if (age > 1 && age < 2)
                ShowLnmsg(Chat.NoiKhiDoi2tuoi.length, Chat.NoiKhiDoi2tuoi);
            else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                ShowLnmsg(Chat.NoiKhiDoi3tuoi.length, Chat.NoiKhiDoi3tuoi);
        } else if (prolength == 100 || prolength == 50) {
            if (age < 1)
                imgzukan.setImageResource(R.drawable.stag_beetle_phase01_p10_a01);
            else if (age > 1 && age < 2)
                imgzukan.setImageResource(R.drawable.stag_beetle_phase02_p10_a01);
            else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                imgzukan.setImageResource(R.drawable.stag_beetle_phase03_p10_a01);
        }
        if (prolength == max / 4) {
            if (sleeping == false)
                HieuUngDoi();
        }
    }

    public void img_eat(int prolength, int max, float age, ImageView imgzukan, boolean sleeping) {
        if (prolength == max * 0.4 || prolength == max * 0.3 || prolength == max * 0.2) {
            if (age < 1)
                ShowLnmsg(Chat.NoiKhiDoi1tuoi.length, Chat.NoiKhiDoi1tuoi);
            else if (age > 1 && age < 2)
                ShowLnmsg(Chat.NoiKhiDoi2tuoi.length, Chat.NoiKhiDoi2tuoi);
            else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                ShowLnmsg(Chat.NoiKhiDoi3tuoi.length, Chat.NoiKhiDoi3tuoi);
        } else if (prolength == 100 || prolength == 50) {
            if (age < 1)
                imgzukan.setImageResource(R.drawable.beetle_phase01_p10_a01);
            else if (age > 1 && age < 2)
                imgzukan.setImageResource(R.drawable.beetle_phase02_p10_a01);
            else if ((age > 2 && age < 3) || (age > 3 && age < 4))
                imgzukan.setImageResource(R.drawable.beetle_phase03_p10_a01);
        }
        if (prolength == max / 4) {
            if (sleeping == false)
                HieuUngDoi();
        }
    }

    public void noi_nham(float age) {
        if (age < 1)
            ShowLnmsg(Chat.NoiNham.length, Chat.NoiNham);
        if (age > 1 && age < 2)
            ShowLnmsg(Chat.NoiNham2.length, Chat.NoiNham2);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            ShowLnmsg(Chat.NoiNham3.length, Chat.NoiNham3);
    }

    public void ac_2(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a02);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a02);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a02);
    }

    public void ac_3(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a03);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a03);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a03);
    }

    public void img_normal(float age, ImageView imgzukan) {
        if (age > 0 && age < 1)
            imgzukan.setImageResource(R.drawable.beetle_phase01_p01_a01);
        if (age > 1 && age < 2)
            imgzukan.setImageResource(R.drawable.beetle_phase02_p01_a01);
        if ((age > 2 && age < 3) || (age > 3 && age < 4))
            imgzukan.setImageResource(R.drawable.beetle_phase03_p01_a01);
    }

    public void ac_go1(float age, ImageView imgzukan, int _FLIP) {
        if (age > 0 && age < 1) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a03);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a03l);
        } else if (age > 1 && age < 2) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a03);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a03l);
        } else if (age > 2 && age < 3) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a03);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a03l);
        }
    }

    public void ac_go2(float age, ImageView imgzukan, int _FLIP) {
        if (age > 0 && age < 1) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a02);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase01_p02_a02l);
        } else if (age > 1 && age < 2) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a02);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase02_p02_a02l);
        } else if ((age > 2 && age < 3) || (age > 3 && age < 4)) {
            if (_FLIP % 2 != 0)
                imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a02);
            else if (_FLIP % 2 == 0)
                imgzukan.setImageResource(R.drawable.beetle_phase03_p02_a02l);
        }
    }
}