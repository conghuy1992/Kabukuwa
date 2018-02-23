package com.daydelight.kabukuwa;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by goood on 10/5/15.
 */
public class Gacha extends Activity {
    dbHandler db;
    Animation animScale;
    MediaPlayer soundbg;
    private PublisherAdView mAdView;
    FrameLayout frcoin, frjewel, frmenu1, frmenu2;
    ImageView gotojewel, gotocoin, gachaHead1, gachaHead2, handle1, handle2, ball, ball2, imgback, imgbacktomypage,
            imgresult, imgresulthead, imgresultface, imgresultbody, imgresultwing, imgresultneck, imgresulthorn,
            imgresultoutside, shineright, shineleft;
    TextView txtcoin, txtjewel;
    int _money = 0, _jewel = 0;
    DecimalFormat formatter;
    MediaPlayer mediaPlayer;
    Animation myRotation;
    public static ArrayList<String> arrDes;
    public static ArrayList<String> arrName;
    public static ArrayList<String> arrID;
    public static ArrayList<String> numItems;
    public static ArrayList<String> rarity;
    public static ArrayList<String> capsuleIdx;
    List<TablePart> _listTablePart;
    long mLastClickTime = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gacha_layout);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        handler = new Handler();
        if (SystemClock.elapsedRealtime() - mLastClickTime < 2000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_shinescale);
        db = new dbHandler(this);
        _listTablePart = db.getAllPart();
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        formatter = new DecimalFormat("#,###,###");
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        soundbg = MediaPlayer.create(this, R.raw.bgm004);
        soundbg.setLooping(true);
        mediaPlayer = MediaPlayer.create(this, R.raw.se018);
        gachaHead1 = (ImageView) findViewById(R.id.gachaHead1);
        gachaHead2 = (ImageView) findViewById(R.id.gachaHead2);
        imgback = (ImageView) findViewById(R.id.imgback);
        imgbacktomypage = (ImageView) findViewById(R.id.imgbacktomypage);
        ball = (ImageView) findViewById(R.id.ball);
        ball2 = (ImageView) findViewById(R.id.ball2);
        imgresult = (ImageView) findViewById(R.id.imgresult);
        imgresulthead = (ImageView) findViewById(R.id.imgresulthead);
        shineright = (ImageView) findViewById(R.id.shineright);
        shineleft = (ImageView) findViewById(R.id.shineleft);
        imgresultneck = (ImageView) findViewById(R.id.imgresultneck);
        imgresultface = (ImageView) findViewById(R.id.imgresultface);
        imgresultwing = (ImageView) findViewById(R.id.imgresultwing);
        imgresulthorn = (ImageView) findViewById(R.id.imgresulthorn);
        imgresultbody = (ImageView) findViewById(R.id.imgresultbody);
        imgresultoutside = (ImageView) findViewById(R.id.imgresultoutside);
        frcoin = (FrameLayout) findViewById(R.id.frcoin);
        frjewel = (FrameLayout) findViewById(R.id.frjewel);
        frmenu1 = (FrameLayout) findViewById(R.id.frmenu1);
        frmenu2 = (FrameLayout) findViewById(R.id.frmenu2);
        gotojewel = (ImageView) findViewById(R.id.imggotojewel);
        gotocoin = (ImageView) findViewById(R.id.imggotocoin);
        txtcoin = (TextView) findViewById(R.id.txtcoin);
        txtjewel = (TextView) findViewById(R.id.txtjewel);
        handle1 = (ImageView) findViewById(R.id.handle1);
        handle2 = (ImageView) findViewById(R.id.handle2);
        myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final String flag = getIntent().getStringExtra("flag");
        imgbacktomypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                editor.putString("gotomypage", "gotomypage");
                editor.commit();
                finish();
            }
        });
        gotojewel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
//                mLastClickTime = SystemClock.elapsedRealtime();
                if (_jewel < 100) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ゴールドガチャをするには\n「ゴールドガチャチケット」\nもしくは100ジュエルが必要です。");
                } else {
                    frcoin.setVisibility(View.GONE);
                    frjewel.setVisibility(View.VISIBLE);
                }
            }
        });
        gotocoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                frcoin.setVisibility(View.VISIBLE);
                frjewel.setVisibility(View.GONE);
            }
        });
        _money = pre.getInt("money", 0);
        _jewel = pre.getInt("jewel", 0);
        txtcoin.setText("" + formatter.format(_money));
        txtjewel.setText("" + formatter.format(_jewel));
        frmenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 2000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (_money < 100) {
                    v.startAnimation(mypage.animScale);
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コインが足りません！");
                } else {
                    v.startAnimation(mypage.animScale);
                    Random rdm = new Random();
                    int a = rdm.nextInt(434);
                    if (a <= 127) {
                        positionItem = rdm.nextInt(6);
                    } else if (a > 127 && a <= 255) {
                        positionItem = rdm.nextInt(6) + 6;
                    } else if (a > 255 && a <= 383) {
                        positionItem = rdm.nextInt(51) + 12;
                    } else if (a > 383 && a <= 415) {
                        positionItem = rdm.nextInt(50) + 63;
                    } else if (a > 415 && a <= 423) {
                        positionItem = rdm.nextInt(61) + 113;
                    } else if (a > 423 && a <= 428) {
                        positionItem = rdm.nextInt(58) + 174;
                    } else if (a > 428 && a <= 431) {
                        positionItem = rdm.nextInt(77) + 232;
                    } else if (a > 431 && a <= 433) {
                        positionItem = rdm.nextInt(51) + 309;
                    }
//                    positionItem = 15;
//                    Log.e("TAG", "positionItem:" + positionItem + " value:" + arrIDGold.get(positionItem));

                    if ((arrIDGold.get(positionItem).equals("2001") && pre.getString("tenzukan", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2002") && pre.getString("tenzukan", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2003") && pre.getString("tenzukan2", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2004") && pre.getString("tenzukan2", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2005") && pre.getString("tenzukan3", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2006") && pre.getString("tenzukan3", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2007") && pre.getString("tenzukan4", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2008") && pre.getString("tenzukan4", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2009") && pre.getString("tenzukan5", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2010") && pre.getString("tenzukan5", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2011") && pre.getString("tenzukan6", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2012") && pre.getString("tenzukan6", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2013") && pre.getString("tenzukan7", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2014") && pre.getString("tenzukan7", "").length() > 0)) {
                        positionItem += 20;
                    } else if ((arrIDGold.get(positionItem).equals("2015") && pre.getString("tenzukan8", "").length() > 0) ||
                            (arrIDGold.get(positionItem).equals("2016") && pre.getString("tenzukan8", "").length() > 0)) {
                        positionItem += 20;
                    }
                    _money -= 100;
                    txtcoin.setText("" + formatter.format(_money));
                    key = arrIDGold.get(positionItem);
                    if (key.length() == 1)
                        key = "0000" + key;
                    else if (key.length() == 2)
                        key = "000" + key;
                    else if (key.length() == 3)
                        key = "00" + key;
                    else if (key.length() == 4)
                        key = "0" + key;
                    if (arrIDGold.get(positionItem).equals("2001") || arrIDGold.get(positionItem).equals("2002") ||
                            arrIDGold.get(positionItem).equals("2003") || arrIDGold.get(positionItem).equals("2004") ||
                            arrIDGold.get(positionItem).equals("2005") || arrIDGold.get(positionItem).equals("2006") ||
                            arrIDGold.get(positionItem).equals("2007") || arrIDGold.get(positionItem).equals("2008") ||
                            arrIDGold.get(positionItem).equals("2009") || arrIDGold.get(positionItem).equals("2010") ||
                            arrIDGold.get(positionItem).equals("2011") || arrIDGold.get(positionItem).equals("2012") ||
                            arrIDGold.get(positionItem).equals("2013") || arrIDGold.get(positionItem).equals("2014") ||
                            arrIDGold.get(positionItem).equals("2015") || arrIDGold.get(positionItem).equals("2016")) {
                    } else {
                        value = Integer.parseInt(numItemsGold.get(positionItem)) + pre.getInt(key, 0);
//                        Log.e("TAG", "value:" + value);
                        editor.putInt(key, value);
                        editor.commit();
                        db.update_Sumpart(Long.parseLong(key), value);
                    }
//                    AnimationHead();
                    handler.postDelayed(runnable, 200);
                }
            }
        });
        frmenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 2000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (_jewel < 100) {
                    v.startAnimation(mypage.animScale);
                    shownotify_jewel();
                    txtyesbutton.setText("ゴールドガチャをするには\n「ゴールドガチャチケット」\nもしくは100ジュエルが必要です。");
                } else {
                    v.startAnimation(mypage.animScale);
                    if (pre.getInt("03008", 0) > 0) {
                        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                        final SharedPreferences.Editor editor = pre.edit();
                        final Dialog dialogwhenbuy = new Dialog(Gacha.this);
                        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialogwhenbuy.getWindow().setBackgroundDrawable(
                                new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialogwhenbuy.setContentView(R.layout.playjewel);
                        TextView textView12 = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
                        final int _it = pre.getInt("03008", 0);
                        textView12.setText("ゴールドチケットが" + _it + "枚あります。ゴールドガチャではチケットを優先的に使用します。チケットを使用してゴールドガチャを一回しますか？");
                        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.btnno);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                v.startAnimation(mypage.animScale);
                                dialogwhenbuy.dismiss();
                            }
                        });
                        ImageView btnyes = (ImageView) dialogwhenbuy.findViewById(R.id.btnyes);
                        btnyes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int b = _it - 1;
                                editor.putInt("03008", b);
                                editor.commit();
                                Random rdm = new Random();
                                int a = rdm.nextInt(5);
                                if (a <= 2)
                                    positionItem = rdm.nextInt(77);
                                if (a > 2 && a <= 4)
                                    positionItem = rdm.nextInt(51) + 77;
//                                _jewel -= 100;
//                                txtjewel.setText("" + formatter.format(_jewel));
                                key = arrIDJewel.get(positionItem);
                                if (key.length() == 1)
                                    key = "0000" + key;
                                if (key.length() == 2)
                                    key = "000" + key;
                                if (key.length() == 3)
                                    key = "00" + key;
                                if (key.length() == 4)
                                    key = "0" + key;
                                value = Integer.parseInt(numItemsJewel.get(positionItem)) + pre.getInt(key, 0);
                                editor.putInt(key, value);
                                editor.commit();
                                db.update_Sumpart(Long.parseLong(key), value);
                                AnimationHead2();
                                dialogwhenbuy.dismiss();
                            }
                        });
                        dialogwhenbuy.setCanceledOnTouchOutside(false);
                        dialogwhenbuy.show();

                    } else if (pre.getInt("03008", 0) <= 0)
                        Dialog_PlayJewel();
                }
            }
        });
        arrDes = new ArrayList<String>();
        arrDesGold = new ArrayList<String>();
        arrDesJewel = new ArrayList<String>();
        arrName = new ArrayList<String>();
        arrNameGold = new ArrayList<String>();
        arrNameJewel = new ArrayList<String>();
        arrID = new ArrayList<String>();
        arrIDGold = new ArrayList<String>();
        arrIDJewel = new ArrayList<String>();
        numItems = new ArrayList<String>();
        numItemsGold = new ArrayList<String>();
        numItemsJewel = new ArrayList<String>();
        rarity = new ArrayList<String>();
        rarityGold = new ArrayList<String>();
        rarityJewel = new ArrayList<String>();
        capsuleIdx = new ArrayList<String>();
        capsuleIdxGold = new ArrayList<String>();
        capsuleIdxJewel = new ArrayList<String>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> scoreList = csvFile.read();
        for (int i = 1; i < capsuleIdx.size(); i++) {
            String str = capsuleIdx.get(i);
            int a = Integer.parseInt(str);
//            if (a < 6) {
            capsuleIdxGold.add(str);
            arrDesGold.add(arrDes.get(i));
            arrNameGold.add(arrName.get(i));
            arrIDGold.add(arrID.get(i));
            numItemsGold.add(numItems.get(i));
            rarityGold.add(rarity.get(i));
//            }
            if (a >= 6) {
                capsuleIdxJewel.add(str);
                arrDesJewel.add(arrDes.get(i));
                arrNameJewel.add(arrName.get(i));
                arrIDJewel.add(arrID.get(i));
                numItemsJewel.add(numItems.get(i));
                rarityJewel.add(rarity.get(i));
            }
        }
//        Toast.makeText(getApplicationContext(), "arrIDGold:" + arrIDGold.size(), Toast.LENGTH_SHORT).show();
    }

    int positionItem = 0;
    ArrayList<String> capsuleIdxGold;
    ArrayList<String> arrDesGold;
    ArrayList<String> arrNameGold;
    ArrayList<String> arrIDGold;
    ArrayList<String> numItemsGold;
    ArrayList<String> rarityGold;
    ArrayList<String> arrDesJewel;
    ArrayList<String> arrNameJewel;
    ArrayList<String> arrIDJewel;
    ArrayList<String> numItemsJewel;
    ArrayList<String> rarityJewel;
    ArrayList<String> capsuleIdxJewel;

    public void AnimationHead2() {
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 1; i <= 30; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
                            @Override
                            public void run() {
                                if (i == 1) {
                                    frmenu1.setEnabled(false);
                                    frmenu2.setEnabled(false);
                                    gotocoin.setEnabled(false);
                                    gotojewel.setEnabled(false);
                                    imgback.setEnabled(false);
                                    imgbacktomypage.setEnabled(false);
                                }
                                if (i == 5) {
                                    int capIndex = capsuleIndexAsLotteryResultJewel();
                                    int rdm = new Random().nextInt(3);
                                    int expectation = (capIndex >= 2) ? rdm : 0;
                                    if (expectation == 1) {
                                        int a = new Random().nextInt(2);
                                        if (a == 0) {
                                            shineright.setVisibility(View.VISIBLE);
                                            shineright.startAnimation(animScale);
                                        } else if (a == 1) {
                                            shineleft.setVisibility(View.VISIBLE);
                                            shineleft.startAnimation(animScale);
                                        }
                                    } else if (expectation == 2) {
                                        shineleft.setVisibility(View.VISIBLE);
                                        shineleft.startAnimation(animScale);
                                        shineright.setVisibility(View.VISIBLE);
                                        shineright.startAnimation(animScale);
                                    }

                                }
                                if (i == 10) {
                                    shineleft.setVisibility(View.GONE);
                                    shineright.setVisibility(View.GONE);
                                }
                                if (i == 20) {
                                    ball2.setVisibility(View.GONE);
                                    imgresultoutside.setVisibility(View.VISIBLE);
                                    String strcapsuleIdx = capsuleIdxJewel.get(positionItem);
                                    int numcapsuleIdx = Integer.parseInt(strcapsuleIdx);
                                    setImagecapsuleIdx(numcapsuleIdx, imgresultoutside);
                                    String str = arrIDJewel.get(positionItem);
                                    int a = Integer.parseInt(str);
                                    if (a < 100000) {
                                        imgresult.setVisibility(View.VISIBLE);
                                        setImageForItem(a, imgresult);
                                    } else if (a >= 100000) {
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
                                        if (part.equals("body")) {
                                            imgresultbody.setVisibility(View.VISIBLE);
                                            imgresultbody.setImageResource(resID);
                                        } else if (part.equals("wing")) {
                                            imgresultwing.setVisibility(View.VISIBLE);
                                            imgresultwing.setImageResource(resID);
                                        } else if (part.equals("head")) {
                                            imgresulthead.setVisibility(View.VISIBLE);
                                            imgresulthead.setImageResource(resID);
                                        } else if (part.equals("horn")) {
                                            imgresulthorn.setVisibility(View.VISIBLE);
                                            imgresulthorn.setImageResource(resID);
                                        } else if (part.equals("horn2")) {
                                            imgresulthorn.setVisibility(View.VISIBLE);
                                            imgresulthorn.setImageResource(resID);
                                        } else if (part.equals("neck")) {
                                            imgresultneck.setVisibility(View.VISIBLE);
                                            imgresultneck.setImageResource(resID);
                                        } else if (part.equals("face")) {
                                            imgresultface.setVisibility(View.VISIBLE);
                                            imgresultface.setImageResource(resID);
                                        }
//                                        if ((!part.equals("neck")) && (!part.equals("body")) && (!part.equals("wing")) && (!part.equals("head"))
//                                                && (!part.equals("horn")) && (!part.equals("horn2")))
//                                            imgresult.setImageResource(resID);
                                    }
                                }
                                if (i == 30) {
                                    frmenu1.setEnabled(true);
                                    frmenu2.setEnabled(true);
                                    gotocoin.setEnabled(true);
                                    gotojewel.setEnabled(true);
                                    imgback.setEnabled(true);
                                    imgbacktomypage.setEnabled(true);
                                    imgresult.setVisibility(View.GONE);
                                    imgresulthorn.setVisibility(View.GONE);
                                    imgresultface.setVisibility(View.GONE);
                                    imgresulthead.setVisibility(View.GONE);
                                    imgresultwing.setVisibility(View.GONE);
                                    imgresultneck.setVisibility(View.GONE);
                                    imgresultbody.setVisibility(View.GONE);
                                    imgresultoutside.setVisibility(View.GONE);
                                    Dialog_getitem2();
                                    String star = rarityJewel.get(positionItem);
                                    int _inStar = Integer.parseInt(star);
                                    for (int i = 0; i < _inStar; i++) {
                                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                                        params.setMargins(3, 0, 0, 0);
                                        Button button = new Button(Gacha.this);
                                        button.setLayoutParams(params);
                                        button.setBackgroundResource(R.drawable.battle_difficulty_star);
                                        lnstar.addView(button);
                                    }
                                    String str = arrIDJewel.get(positionItem);
                                    int a = Integer.parseInt(str);
                                    if (a < 100000) {
                                        setImageForItem(a, imggetitem);
                                    } else if (a >= 100000) {
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
                                        if (part.equals("body"))
                                            imggetitembody.setImageResource(resID);
                                        else if (part.equals("wing"))
                                            imggetitemwing.setImageResource(resID);
                                        else if (part.equals("head"))
                                            imggetitemhead.setImageResource(resID);
                                        else if (part.equals("horn"))
                                            imggetitemhorn.setImageResource(resID);
                                        else if (part.equals("horn2"))
                                            imggetitemhorn.setImageResource(resID);
                                        else if (part.equals("neck"))
                                            imggetitemneck.setImageResource(resID);
                                        else if (part.equals("face"))
                                            imggetitemface.setImageResource(resID);
                                    }
                                    txtName.setText("" + arrNameJewel.get(positionItem) + " x " + numItemsJewel.get(positionItem));
                                    txtdes.setText("" + arrDesJewel.get(positionItem));
                                }
                                if (i == 15)
                                    handle2.startAnimation(myRotation);
                                if (i == 18) {
                                    String str = capsuleIdxJewel.get(positionItem);
                                    int a = Integer.parseInt(str);
                                    setImagecapsuleIdx(a, ball2);
                                    Animation animation = AnimationUtils.loadAnimation(Gacha.this, R.anim.trans_top_in);
                                    animation.setDuration(500);
                                    ball2.setVisibility(View.VISIBLE);
                                    ball2.setAnimation(animation);
                                    ball2.animate();
                                    animation.start();
                                }
                                if (i == 1 || i == 4 || i == 7 || i == 10 || i == 13 || i == 16 || i == 19)
                                    gachaHead2.setImageResource(R.drawable.c_gacha_gold_head1);
                                if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20)
                                    gachaHead2.setImageResource(R.drawable.c_gacha_gold_head2);
                                if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 18)
                                    gachaHead2.setImageResource(R.drawable.c_gacha_gold_head3);
                            }
                        });
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    Timer timer;
    TimerTask timerTask;
    int imgCur = 0;

    public void AnimationHead() {
        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 0, 200);
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
                    public void run() {
                        imgCur++;
                        if (imgCur > 30) {
                            imgCur = 0;
                            if (timer != null) {
                                timer.cancel();
                                timer = null;
                            }
                        }
                        if (imgCur == 1) {
                            frmenu1.setEnabled(false);
                            frmenu2.setEnabled(false);
                            gotocoin.setEnabled(false);
                            gotojewel.setEnabled(false);
                            imgback.setEnabled(false);
                            imgbacktomypage.setEnabled(false);
                        }
                        if (imgCur == 5) {
                            int capIndex = capsuleIndexAsLotteryResultGold();
                            int rdm = new Random().nextInt(3);
                            int expectation = (capIndex >= 2) ? rdm : 0;
                            if (expectation == 1) {
                                int a = new Random().nextInt(2);
                                if (a == 0) {
                                    shineright.setVisibility(View.VISIBLE);
                                    shineright.startAnimation(animScale);
                                } else if (a == 1) {
                                    shineleft.setVisibility(View.VISIBLE);
                                    shineleft.startAnimation(animScale);
                                }
                            } else if (expectation == 2) {
                                shineleft.setVisibility(View.VISIBLE);
                                shineleft.startAnimation(animScale);
                                shineright.setVisibility(View.VISIBLE);
                                shineright.startAnimation(animScale);
                            }

                        }
                        if (imgCur == 10) {
                            shineleft.setVisibility(View.GONE);
                            shineright.setVisibility(View.GONE);
                        }
                        if (imgCur == 20) {
                            ball.setVisibility(View.GONE);
                            imgresultoutside.setVisibility(View.VISIBLE);
                            String strcapsuleIdx = capsuleIdxGold.get(positionItem);
                            int numcapsuleIdx = Integer.parseInt(strcapsuleIdx);
                            setImagecapsuleIdx(numcapsuleIdx, imgresultoutside);
                            String str = arrIDGold.get(positionItem);
                            int a = Integer.parseInt(str);
                            if (a < 100000) {
                                imgresult.setVisibility(View.VISIBLE);
                                setImageForItem(a, imgresult);
                            } else if (a >= 100000) {
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
                                if (part.equals("body")) {
                                    imgresultbody.setVisibility(View.VISIBLE);
                                    imgresultbody.setImageResource(resID);
                                } else if (part.equals("wing")) {
                                    imgresultwing.setVisibility(View.VISIBLE);
                                    imgresultwing.setImageResource(resID);
                                } else if (part.equals("head")) {
                                    imgresulthead.setVisibility(View.VISIBLE);
                                    imgresulthead.setImageResource(resID);
                                } else if (part.equals("horn")) {
                                    imgresulthorn.setVisibility(View.VISIBLE);
                                    imgresulthorn.setImageResource(resID);
                                } else if (part.equals("horn2")) {
                                    imgresulthorn.setVisibility(View.VISIBLE);
                                    imgresulthorn.setImageResource(resID);
                                } else if (part.equals("neck")) {
                                    imgresultneck.setVisibility(View.VISIBLE);
                                    imgresultneck.setImageResource(resID);
                                } else if (part.equals("face")) {
                                    imgresultface.setVisibility(View.VISIBLE);
                                    imgresultface.setImageResource(resID);
                                }
                            }
                        }
                        if (imgCur == 30) {
                            frmenu1.setEnabled(true);
                            frmenu2.setEnabled(true);
                            gotocoin.setEnabled(true);
                            gotojewel.setEnabled(true);
                            imgback.setEnabled(true);
                            imgbacktomypage.setEnabled(true);
                            imgresult.setVisibility(View.GONE);
                            imgresulthorn.setVisibility(View.GONE);
                            imgresultface.setVisibility(View.GONE);
                            imgresulthead.setVisibility(View.GONE);
                            imgresultwing.setVisibility(View.GONE);
                            imgresultneck.setVisibility(View.GONE);
                            imgresultbody.setVisibility(View.GONE);
                            imgresultoutside.setVisibility(View.GONE);
                            Dialog_getitem();
                            String star = rarityGold.get(positionItem);
                            int _inStar = Integer.parseInt(star);
                            for (int i = 0; i < _inStar; i++) {
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
                                params.setMargins(3, 0, 0, 0);
                                Button button = new Button(Gacha.this);
                                button.setLayoutParams(params);
                                button.setBackgroundResource(R.drawable.battle_difficulty_star);
                                lnstar.addView(button);
                            }
                            String str = arrIDGold.get(positionItem);
                            int a = Integer.parseInt(str);
                            if (a < 100000) {
                                setImageForItem(a, imggetitem);
                            } else if (a >= 100000) {
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
                                if (part.equals("body"))
                                    imggetitembody.setImageResource(resID);
                                else if (part.equals("wing"))
                                    imggetitemwing.setImageResource(resID);
                                else if (part.equals("head"))
                                    imggetitemhead.setImageResource(resID);
                                else if (part.equals("horn"))
                                    imggetitemhorn.setImageResource(resID);
                                else if (part.equals("horn2"))
                                    imggetitemhorn.setImageResource(resID);
                                else if (part.equals("neck"))
                                    imggetitemneck.setImageResource(resID);
                                else if (part.equals("face"))
                                    imggetitemface.setImageResource(resID);
                            }
                            txtName.setText("" + arrNameGold.get(positionItem) + " x " + numItemsGold.get(positionItem));
                            txtdes.setText("" + arrDesGold.get(positionItem));
                        }
                        if (imgCur == 15)
                            handle1.startAnimation(myRotation);
                        if (imgCur == 18) {
                            String str = capsuleIdxGold.get(positionItem);
                            int a = Integer.parseInt(str);
                            setImagecapsuleIdx(a, ball);
                            Animation animation = AnimationUtils.loadAnimation(Gacha.this, R.anim.trans_top_in);
                            animation.setDuration(500);
                            ball.setVisibility(View.VISIBLE);
                            ball.setAnimation(animation);
                            ball.animate();
                            animation.start();
                        }
                        if (imgCur == 1 || imgCur == 4 || imgCur == 7 || imgCur == 10 || imgCur == 13 || imgCur == 16 || imgCur == 19)
                            gachaHead1.setImageResource(R.drawable.c_gacha_head1);
                        if (imgCur == 2 || imgCur == 5 || imgCur == 8 || imgCur == 11 || imgCur == 14 || imgCur == 17 || imgCur == 20)
                            gachaHead1.setImageResource(R.drawable.c_gacha_head2);
                        if (imgCur == 3 || imgCur == 6 || imgCur == 9 || imgCur == 12 || imgCur == 15 || imgCur == 18)
                            gachaHead1.setImageResource(R.drawable.c_gacha_head3);
                    }
                });
            }
        };
    }

//    public void AnimationHead() {
//        new Thread() {
//            int i;
//
//            @Override
//            public void run() {
//                for (i = 1; i <= 30; i++) {
//                    try {
//                        runOnUiThread(new Runnable() {
//                            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
//                            @Override
//                            public void run() {
//
//                            }
//                        });
//                        Thread.sleep(200);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//    }

    TextView txtyesbutton, zk_title;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(Gacha.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        zk_title = (TextView) dialogwhenbuy.findViewById(R.id.textView2);

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

    public void shownotify_jewel() {
        final Dialog dialogwhenbuy = new Dialog(Gacha.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogwhenbuy.dismiss();
                frcoin.setVisibility(View.VISIBLE);
                frjewel.setVisibility(View.GONE);

            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    public void Dialog_PlayJewel() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        final Dialog dialogwhenbuy = new Dialog(Gacha.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.playjewel);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.btnno);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogwhenbuy.dismiss();
            }
        });
        ImageView btnyes = (ImageView) dialogwhenbuy.findViewById(R.id.btnyes);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rdm = new Random();
                int a = rdm.nextInt(5);
                if (a <= 2)
                    positionItem = rdm.nextInt(77);
                else if (a > 2 && a <= 4)
                    positionItem = rdm.nextInt(51) + 77;
                _jewel -= 100;
                txtjewel.setText("" + formatter.format(_jewel));
                key = arrIDJewel.get(positionItem);
                if (key.length() == 1)
                    key = "0000" + key;
                else if (key.length() == 2)
                    key = "000" + key;
                else if (key.length() == 3)
                    key = "00" + key;
                else if (key.length() == 4)
                    key = "0" + key;
                value = Integer.parseInt(numItemsJewel.get(positionItem)) + pre.getInt(key, 0);
                editor.putInt(key, value);
                editor.commit();
                db.update_Sumpart(Long.parseLong(key), value);
                AnimationHead2();
                dialogwhenbuy.dismiss();
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();

    }

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("money", _money);
        editor.putInt("jewel", _jewel);
        editor.commit();
        try {
            if (soundbg.isPlaying()) {
                soundbg.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        try {
            if (pre.getBoolean("sound", true) == true)
                soundbg.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            mAdView.destroy();
        }
    }

    Dialog dialoggetitem;
    TextView txtName, txtdes;
    ImageView imggetitem, imggetitembody, imggetitemwing, imggetitemhead, imggetitemhorn, imggetitemneck, imggetitemface;
    LinearLayout lnstar;

    public void Dialog_getitem2() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        dialoggetitem = new Dialog(Gacha.this);
        dialoggetitem.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoggetitem.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialoggetitem.setContentView(R.layout.layout_getitem);
        dialoggetitem.setCanceledOnTouchOutside(false);
        ImageView btnOk = (ImageView) dialoggetitem.findViewById(R.id.btnok);
        imggetitem = (ImageView) dialoggetitem.findViewById(R.id.imggetitem);
        imggetitembody = (ImageView) dialoggetitem.findViewById(R.id.imggetitembody);
        imggetitemwing = (ImageView) dialoggetitem.findViewById(R.id.imggetitemwing);
        imggetitemhead = (ImageView) dialoggetitem.findViewById(R.id.imggetitemhead);
        imggetitemhorn = (ImageView) dialoggetitem.findViewById(R.id.imggetitemhorn);
        imggetitemneck = (ImageView) dialoggetitem.findViewById(R.id.imggetitemneck);
        imggetitemface = (ImageView) dialoggetitem.findViewById(R.id.imggetitemface);
        lnstar = (LinearLayout) dialoggetitem.findViewById(R.id.lnstar);
        txtName = (TextView) dialoggetitem.findViewById(R.id.txtName);
        txtdes = (TextView) dialoggetitem.findViewById(R.id.txtdes);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialoggetitem.dismiss();
            }
        });

        dialoggetitem.show();
        _Sound();
    }

    public void Dialog_getitem() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        dialoggetitem = new Dialog(Gacha.this);
        dialoggetitem.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialoggetitem.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialoggetitem.setContentView(R.layout.layout_getitem);
        dialoggetitem.setCanceledOnTouchOutside(false);
        ImageView btnOk = (ImageView) dialoggetitem.findViewById(R.id.btnok);
        imggetitem = (ImageView) dialoggetitem.findViewById(R.id.imggetitem);
        imggetitembody = (ImageView) dialoggetitem.findViewById(R.id.imggetitembody);
        imggetitemwing = (ImageView) dialoggetitem.findViewById(R.id.imggetitemwing);
        imggetitemhead = (ImageView) dialoggetitem.findViewById(R.id.imggetitemhead);
        imggetitemhorn = (ImageView) dialoggetitem.findViewById(R.id.imggetitemhorn);
        imggetitemneck = (ImageView) dialoggetitem.findViewById(R.id.imggetitemneck);
        imggetitemface = (ImageView) dialoggetitem.findViewById(R.id.imggetitemface);
        lnstar = (LinearLayout) dialoggetitem.findViewById(R.id.lnstar);
        txtName = (TextView) dialoggetitem.findViewById(R.id.txtName);
        txtdes = (TextView) dialoggetitem.findViewById(R.id.txtdes);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialoggetitem.dismiss();
                if (arrIDGold.get(positionItem).equals("2001") || arrIDGold.get(positionItem).equals("2002") ||
                        arrIDGold.get(positionItem).equals("2003") || arrIDGold.get(positionItem).equals("2004") ||
                        arrIDGold.get(positionItem).equals("2005") || arrIDGold.get(positionItem).equals("2006") ||
                        arrIDGold.get(positionItem).equals("2007") || arrIDGold.get(positionItem).equals("2008") ||
                        arrIDGold.get(positionItem).equals("2009") || arrIDGold.get(positionItem).equals("2010") ||
                        arrIDGold.get(positionItem).equals("2011") || arrIDGold.get(positionItem).equals("2012") ||
                        arrIDGold.get(positionItem).equals("2013") || arrIDGold.get(positionItem).equals("2014") ||
                        arrIDGold.get(positionItem).equals("2015") || arrIDGold.get(positionItem).equals("2016")) {
                    Create_Character();
                }
            }
        });

        dialoggetitem.show();
        _Sound();
    }

    String key = "";
    int value = 0;

    public void setImagecapsuleIdx(int a, ImageView imageView) {
        if (a == 0)
            imageView.setImageResource(R.drawable.c_ball_pink);
        else if (a == 1)
            imageView.setImageResource(R.drawable.c_ball_orange);
        else if (a == 2)
            imageView.setImageResource(R.drawable.c_ball_yellow);
        else if (a == 3)
            imageView.setImageResource(R.drawable.c_ball_green);
        else if (a == 4)
            imageView.setImageResource(R.drawable.c_ball_blue);
        else if (a == 5)
            imageView.setImageResource(R.drawable.c_ball_navy);
        else if (a == 6)
            imageView.setImageResource(R.drawable.c_ball_silver);
        else if (a == 7)
            imageView.setImageResource(R.drawable.c_ball_gold);
    }

    public void setImageForItem(int a, ImageView imggetitem) {
        if (a == 1013)
            imggetitem.setImageResource(R.drawable.itm_rice3);
        else if (a == 1014)
            imggetitem.setImageResource(R.drawable.itm_rice2);
        else if (a == 1001)
            imggetitem.setImageResource(R.drawable.food_icon);
        else if (a == 1011)
            imggetitem.setImageResource(R.drawable.itm_jelly1);
        else if (a == 1)
            imggetitem.setImageResource(R.drawable.drink_icon);
        else if (a == 3001)
            imggetitem.setImageResource(R.drawable.item_icon);
        else if (a == 1012)
            imggetitem.setImageResource(R.drawable.itm_jelly2);
        else if (a == 1003)
            imggetitem.setImageResource(R.drawable.itm_rice4);
        else if (a == 3)
            imggetitem.setImageResource(R.drawable.new_shop_icon_drink2);
        else if (a == 3002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_item2);
        else if (a == 3003)
            imggetitem.setImageResource(R.drawable.itm_liquor);
        else if (a == 3004)
            imggetitem.setImageResource(R.drawable.itm_runpa1);
        else if (a == 2001)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2003)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2004)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2005)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2006)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2007)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2008)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2009)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2010)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2011)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2012)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2013)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2014)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2015)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2016)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 1015)
            imggetitem.setImageResource(R.drawable.itm_sap);
        else if (a == 1016)
            imggetitem.setImageResource(R.drawable.itm_banana);
        else if (a == 3005)
            imggetitem.setImageResource(R.drawable.itm_medicine1);
        else if (a == 3006)
            imggetitem.setImageResource(R.drawable.itm_medicine2);
        else if (a == 3007)
            imggetitem.setImageResource(R.drawable.itm_o2_capsule);
        else if (a == 3008)
            imggetitem.setImageResource(R.drawable.itm_gold_ticket);

    }

    public void _Sound() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("soundaction", true))
            mediaPlayer.start();
    }

    public int capsuleIndexAsLotteryResultGold() {
        int dProbabilityMax_Gold = 434;
        Integer[] probabilityTableNml = {128, 128, 128, 32, 8, 5, 3, 2};
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        Random rdm = new Random();
        int a = rdm.nextInt(dProbabilityMax_Gold);
        for (int tblIndex = 0, fraction = 0; tblIndex < 8; ++tblIndex) {
            fraction += probabilityTableNml[tblIndex];
            if (a < fraction)
                return arr[tblIndex];
        }
        return 7;
    }

    public int capsuleIndexAsLotteryResultJewel() {
        int dProbabilityMax_Gold = 5;
        Integer[] probabilityTableNml = {0, 0, 0, 0, 0, 0, 3, 2};
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        Random rdm = new Random();
        int a = rdm.nextInt(dProbabilityMax_Gold);
        for (int tblIndex = 0, fraction = 0; tblIndex < 8; ++tblIndex) {
            fraction += probabilityTableNml[tblIndex];
            if (a < fraction)
                return arr[tblIndex];
        }
        return 7;
    }

    Dialog createcharacter, mcustomdialog;
    EditText editText;

    public void Create_Character() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        createcharacter = new Dialog(Gacha.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        TextView textView21 = (TextView) createcharacter.findViewById(R.id.textView21);
        if (arrIDGold.get(positionItem).equals("2001") || arrIDGold.get(positionItem).equals("2002"))
            textView21.setText("カブトムシ");
        else if (arrIDGold.get(positionItem).equals("2003") || arrIDGold.get(positionItem).equals("2004"))
            textView21.setText("コクワガタ");
        else if (arrIDGold.get(positionItem).equals("2005") || arrIDGold.get(positionItem).equals("2006"))
            textView21.setText("コーカサスオオカブト");
        else if (arrIDGold.get(positionItem).equals("2007") || arrIDGold.get(positionItem).equals("2008"))
            textView21.setText("オオクワガタ");
        else if (arrIDGold.get(positionItem).equals("2009") || arrIDGold.get(positionItem).equals("2010"))
            textView21.setText("サタンオオカブト");
        else if (arrIDGold.get(positionItem).equals("2011") || arrIDGold.get(positionItem).equals("2012"))
            textView21.setText("ギラファノコギリクワガタ");
        else if (arrIDGold.get(positionItem).equals("2013") || arrIDGold.get(positionItem).equals("2014"))
            textView21.setText("オウゴンオニクワガタ");
        else if (arrIDGold.get(positionItem).equals("2015") || arrIDGold.get(positionItem).equals("2016"))
            textView21.setText("ヘラクレスオオカブト");
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    zk_title.setText("飼育");
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    zk_title.setText("飼育");
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                } else if (Chat.check_name_create(editText.getText().toString(),
                        pre.getString("tenzukan", ""), pre.getString("tenzukan2", ""),
                        pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                        pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                        pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                    shownotifyWhenBuy();
                    zk_title.setText("飼育");
                    txtyesbutton.setText("既にその名前は使用されています。\n" +
                            "名前を変えてください。");
                } else {
                    final Dialog dialogchange = new Dialog(Gacha.this);
                    dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogchange.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialogchange.setContentView(R.layout.dialog_change);
                    dialogchange.setCanceledOnTouchOutside(false);
                    TextView txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
                    ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
                    btnyes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                            CreateNewPet();
                            createcharacter.dismiss();
                        }
                    });
                    btnno.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                        }
                    });
                    dialogchange.show();
                }
            }
        });
        Button btnOK = (Button) createcharacter.findViewById(R.id.button15);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    zk_title.setText("飼育");
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    zk_title.setText("飼育");
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                } else if (Chat.check_name_create(editText.getText().toString(),
                        pre.getString("tenzukan", ""), pre.getString("tenzukan2", ""),
                        pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                        pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                        pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                    shownotifyWhenBuy();
                    zk_title.setText("飼育");
                    txtyesbutton.setText("既にその名前は使用されています。\n" +
                            "名前を変えてください。");
                } else {
                    final Dialog dialogchange = new Dialog(Gacha.this);
                    dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogchange.getWindow().setBackgroundDrawable(
                            new ColorDrawable(android.graphics.Color.TRANSPARENT));
                    dialogchange.setContentView(R.layout.dialog_change);
                    dialogchange.setCanceledOnTouchOutside(false);
                    TextView txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
                    ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
                    btnyes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                            CreateNewPet();
                            createcharacter.dismiss();
                        }
                    });
                    btnno.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogchange.dismiss();
                        }
                    });
                    dialogchange.show();
                }
            }
        });
        createcharacter.setCanceledOnTouchOutside(false);
        createcharacter.show();
    }

    public void CreateNewPet() {
        //
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int gio = c.get(Calendar.HOUR);
        int phut = c.get(Calendar.MINUTE);
        int giay = c.get(Calendar.SECOND);
        String str = "" + year;
        String str2 = str.substring(2, 4);
        String stringID = "" + str2 + month + date + gio + phut + giay;
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        int lv = pre.getInt("lv", 1);
        int personality = new Random().nextInt(800);
        int personality2 = new Random().nextInt(800);
        int personality3 = new Random().nextInt(1000);
        int personality4 = new Random().nextInt(2000);
        int personality5 = new Random().nextInt(2000);
        int personality6 = new Random().nextInt(2000);
        int personality7 = new Random().nextInt(1500);
        int personality8 = new Random().nextInt(3000);
        int form = new Random().nextInt(800);
        int form2 = new Random().nextInt(800);
        int form3 = new Random().nextInt(1000);
        int form4 = new Random().nextInt(2000);
        int form5 = new Random().nextInt(2000);
        int form6 = new Random().nextInt(2000);
        int form7 = new Random().nextInt(1500);
        int form8 = new Random().nextInt(3000);
        int persent = new Random().nextInt(30) + 10;
        int strength = 800 * persent / 100;
        int strength2 = 800 * persent / 100;
        int strength3 = 1000 * persent / 100;
        int strength4 = 2000 * persent / 100;
        int strength5 = 2000 * persent / 100;
        int strength6 = 2000 * persent / 100;
        int strength7 = 1500 * persent / 100;
        int strength8 = 3000 * persent / 100;
        long bornTime = System.currentTimeMillis() / 1000;
        if ((arrIDGold.get(positionItem).equals("2001")) || (arrIDGold.get(positionItem).equals("2002"))) {
            editor.putString("tenzukan", editText.getText().toString());
            editor.putString("id", stringID);
            editor.putInt("txt25", 0);
            editor.putInt("gio", 23);
            editor.putInt("phut", 59);
            editor.putInt("strength", strength);
            editor.putInt("sleep", 800);
            editor.putInt("gioup", 0);
            editor.putInt("phutup", 0);
            editor.putInt("ngayup", 0);
            editor.putInt("nhietdo", 6);
            editor.putInt("nuoi1", 0);
            editor.putInt("health", 800);
            editor.putInt("mood", 800);
            editor.putInt("friendly", 0);
            editor.putInt("ngay", 0);
            editor.putInt("daitien", 0);
            editor.putInt("tieutien", 0);
            editor.putInt("personality", personality);
            editor.putInt("form", form);
            editor.putInt("size", 3000);
            editor.putLong("bornTime", bornTime);
            db.adddatastt(getApplicationContext(), 1);
            if (arrIDGold.get(positionItem).equals("2002"))
                editor.putInt("mat1", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2015")) || (arrIDGold.get(positionItem).equals("2016"))) {
            editor.putString("tenzukan8", editText.getText().toString());
            editor.putString("id8", stringID);
            editor.putInt("txt25", 1);
            editor.putInt("sleep8", 3000);
            editor.putInt("gio8", 23);
            editor.putFloat("age8", 0);
            editor.putInt("_COUNTAN8", 1500);
            editor.putInt("_COUNTUONG8", 1500);
            editor.putInt("_COUNTNHA8", 3000);
            editor.putInt("phut8", 59);
            editor.putInt("strength8", strength8);
            editor.putInt("gioup8", 0);
            editor.putInt("phutup8", 0);
            editor.putInt("ngayup8", 0);
            editor.putInt("nhietdo8", 6);
            editor.putInt("nuoi8", 0);
            editor.putInt("health8", 3000);
            editor.putInt("mood8", 3000);
            editor.putInt("friendly8", 0);
            editor.putInt("ngay8", 0);
            editor.putInt("daitien8", 0);
            editor.putInt("tieutien8", 0);
            editor.putInt("personality8", personality8);
            editor.putInt("form8", form8);
            editor.putInt("size8", 3000);
            editor.putLong("bornTime8", bornTime);
            db.adddatastt(getApplicationContext(), 8);
            if (arrIDGold.get(positionItem).equals("2016"))
                editor.putInt("mat8", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2003")) || (arrIDGold.get(positionItem).equals("2004"))) {
            editor.putString("tenzukan2", editText.getText().toString());
            editor.putString("id2", stringID);
            editor.putInt("sleep2", 800);
            editor.putInt("gio2", 23);
            editor.putInt("txt25", 3);
            editor.putFloat("age2", 0);
            editor.putInt("_COUNTAN2", 400);
            editor.putInt("_COUNTUONG2", 400);
            editor.putInt("phut2", 59);
            editor.putInt("strength2", strength2);
            editor.putInt("_COUNTNHA2", 800);
            editor.putInt("gioup2", 0);
            editor.putInt("phutup2", 0);
            editor.putInt("ngayup2", 0);
            editor.putInt("nhietdo2", 6);
            editor.putInt("nuoi2", 0);
            editor.putInt("health2", 800);
            editor.putInt("mood2", 800);
            editor.putInt("friendly2", 0);
            editor.putInt("ngay2", 0);
            editor.putInt("daitien2", 0);
            editor.putInt("tieutien2", 0);
            editor.putInt("personality2", personality2);
            editor.putInt("form2", form2);
            editor.putInt("size2", 3000);
            editor.putLong("bornTime2", bornTime);
            db.adddatastt(getApplicationContext(), 2);
            if (arrIDGold.get(positionItem).equals("2004"))
                editor.putInt("mat2", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2005")) || (arrIDGold.get(positionItem).equals("2006"))) {
            editor.putString("tenzukan3", editText.getText().toString());
            editor.putString("id3", stringID);
            editor.putInt("txt25", 5);
            editor.putInt("sleep3", 1000);
            editor.putInt("gio3", 23);
            editor.putFloat("age3", 0);
            editor.putInt("_COUNTAN3", 500);
            editor.putInt("_COUNTUONG3", 500);
            editor.putInt("phut3", 59);
            editor.putInt("strength3", strength3);
            editor.putInt("_COUNTNHA3", 1000);
            editor.putInt("gioup3", 0);
            editor.putInt("phutup3", 0);
            editor.putInt("ngayup3", 0);
            editor.putInt("nhietdo3", 6);
            editor.putInt("nuoi3", 0);
            editor.putInt("health3", 1000);
            editor.putInt("mood3", 1000);
            editor.putInt("friendly3", 0);
            editor.putInt("ngay3", 0);
            editor.putInt("daitien3", 0);
            editor.putInt("tieutien3", 0);
            editor.putInt("personality3", personality3);
            editor.putInt("form3", form3);
            editor.putInt("size3", 3000);
            editor.putLong("bornTime3", bornTime);
            db.adddatastt(getApplicationContext(), 3);
            if (arrIDGold.get(positionItem).equals("2006"))
                editor.putInt("mat3", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2007")) || (arrIDGold.get(positionItem).equals("2008"))) {
            editor.putString("tenzukan4", editText.getText().toString());
            editor.putString("id4", stringID);
            editor.putInt("txt25", 7);
            editor.putInt("sleep4", 2000);
            editor.putInt("gio4", 23);
            editor.putFloat("age4", 0);
            editor.putInt("_COUNTAN4", 1000);
            editor.putInt("_COUNTUONG4", 1000);
            editor.putInt("phut4", 59);
            editor.putInt("strength4", strength4);
            editor.putInt("_COUNTNHA4", 2000);
            editor.putInt("gioup4", 0);
            editor.putInt("phutup4", 0);
            editor.putInt("ngayup4", 0);
            editor.putInt("nhietdo4", 6);
            editor.putInt("nuoi4", 0);
            editor.putInt("health4", 2000);
            editor.putInt("mood4", 2000);
            editor.putInt("friendly4", 0);
            editor.putInt("ngay4", 0);
            editor.putInt("daitien4", 0);
            editor.putInt("tieutien4", 0);
            editor.putInt("personality4", personality4);
            editor.putInt("form4", form4);
            editor.putInt("size4", 3000);
            editor.putLong("bornTime4", bornTime);
            db.adddatastt(getApplicationContext(), 4);
            if (arrIDGold.get(positionItem).equals("2008"))
                editor.putInt("mat4", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2009")) || (arrIDGold.get(positionItem).equals("2010"))) {
            editor.putString("tenzukan5", editText.getText().toString());
            editor.putString("id5", stringID);
            editor.putInt("txt25", 9);
            editor.putInt("sleep5", 2000);
            editor.putInt("gio5", 23);
            editor.putFloat("age5", 0);
            editor.putInt("_COUNTAN5", 1000);
            editor.putInt("_COUNTUONG5", 1000);
            editor.putInt("phut5", 59);
            editor.putInt("strength5", strength5);
            editor.putInt("_COUNTNHA5", 2000);
            editor.putInt("gioup5", 0);
            editor.putInt("phutup5", 0);
            editor.putInt("ngayup5", 0);
            editor.putInt("nhietdo5", 6);
            editor.putInt("nuoi5", 0);
            editor.putInt("health5", 2000);
            editor.putInt("mood5", 2000);
            editor.putInt("friendly5", 0);
            editor.putInt("ngay5", 0);
            editor.putInt("daitien5", 0);
            editor.putInt("tieutien5", 0);
            editor.putInt("personality5", personality5);
            editor.putInt("form5", form5);
            editor.putInt("size5", 3000);
            editor.putLong("bornTime5", bornTime);
            db.adddatastt(getApplicationContext(), 5);
            if (arrIDGold.get(positionItem).equals("2010"))
                editor.putInt("mat5", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2011")) || (arrIDGold.get(positionItem).equals("2012"))) {
            editor.putString("tenzukan6", editText.getText().toString());
            editor.putString("id6", stringID);
            editor.putInt("txt25", 11);
            editor.putInt("sleep6", 2000);
            editor.putInt("gio6", 23);
            editor.putFloat("age6", 0);
            editor.putInt("_COUNTAN6", 1000);
            editor.putInt("_COUNTUONG6", 1000);
            editor.putInt("phut6", 59);
            editor.putInt("strength6", strength6);
            editor.putInt("_COUNTNHA6", 2000);
            editor.putInt("gioup6", 0);
            editor.putInt("phutup6", 0);
            editor.putInt("ngayup6", 0);
            editor.putInt("nhietdo6", 6);
            editor.putInt("nuoi6", 0);
            editor.putInt("health6", 2000);
            editor.putInt("mood6", 2000);
            editor.putInt("friendly6", 0);
            editor.putInt("ngay6", 0);
            editor.putInt("daitien6", 0);
            editor.putInt("tieutien6", 0);
            editor.putInt("personality6", personality6);
            editor.putInt("form6", form6);
            editor.putInt("size6", 3000);
            editor.putLong("bornTime6", bornTime);
            db.adddatastt(getApplicationContext(), 6);
            if (arrIDGold.get(positionItem).equals("2012"))
                editor.putInt("mat6", 1);
            editor.commit();
        } else if ((arrIDGold.get(positionItem).equals("2013")) || (arrIDGold.get(positionItem).equals("2014"))) {
            editor.putString("tenzukan7", editText.getText().toString());
            editor.putString("id7", stringID);
            editor.putInt("txt25", 13);
            editor.putInt("sleep7", 1500);
            editor.putInt("gio7", 23);
            editor.putFloat("age7", 0);
            editor.putInt("_COUNTAN7", 750);
            editor.putInt("_COUNTUONG7", 750);
            editor.putInt("phut7", 59);
            editor.putInt("strength7", strength7);
            editor.putInt("_COUNTNHA7", 1500);
            editor.putInt("gioup7", 0);
            editor.putInt("phutup7", 0);
            editor.putInt("ngayup7", 0);
            editor.putInt("nhietdo7", 6);
            editor.putInt("nuoi7", 0);
            editor.putInt("health7", 1500);
            editor.putInt("mood7", 1500);
            editor.putInt("friendly7", 0);
            editor.putInt("ngay7", 0);
            editor.putInt("daitien7", 0);
            editor.putInt("tieutien7", 0);
            editor.putInt("personality7", personality7);
            editor.putInt("form7", form7);
            editor.putInt("size7", 3000);
            editor.putLong("bornTime7", bornTime);
            db.adddatastt(getApplicationContext(), 7);
            if (arrIDGold.get(positionItem).equals("2014"))
                editor.putInt("mat7", 1);
            editor.commit();
        }
    }

    Runnable runnable = new Runnable() {
        @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
        @Override
        public void run() {
            imgCur++;
//            Log.e("TAG", "i:" + imgCur);
            handler.postDelayed(this, 200);
            if (imgCur > 30) {
                imgCur = 0;
                handler.removeCallbacks(runnable);
            }
            if (imgCur == 1) {
                frmenu1.setEnabled(false);
                frmenu2.setEnabled(false);
                gotocoin.setEnabled(false);
                gotojewel.setEnabled(false);
                imgback.setEnabled(false);
                imgbacktomypage.setEnabled(false);
            }
            if (imgCur == 5) {
                int capIndex = capsuleIndexAsLotteryResultGold();
                int rdm = new Random().nextInt(3);
                int expectation = (capIndex >= 2) ? rdm : 0;
                if (expectation == 1) {
                    int a = new Random().nextInt(2);
                    if (a == 0) {
                        shineright.setVisibility(View.VISIBLE);
                        shineright.startAnimation(animScale);
                    } else if (a == 1) {
                        shineleft.setVisibility(View.VISIBLE);
                        shineleft.startAnimation(animScale);
                    }
                } else if (expectation == 2) {
                    shineleft.setVisibility(View.VISIBLE);
                    shineleft.startAnimation(animScale);
                    shineright.setVisibility(View.VISIBLE);
                    shineright.startAnimation(animScale);
                }

            }
            if (imgCur == 10) {
                shineleft.setVisibility(View.GONE);
                shineright.setVisibility(View.GONE);
            }
            if (imgCur == 20) {
                ball.setVisibility(View.GONE);
                imgresultoutside.setVisibility(View.VISIBLE);
                String strcapsuleIdx = capsuleIdxGold.get(positionItem);
                int numcapsuleIdx = Integer.parseInt(strcapsuleIdx);
                setImagecapsuleIdx(numcapsuleIdx, imgresultoutside);
                String str = arrIDGold.get(positionItem);
                int a = Integer.parseInt(str);
                if (a < 100000) {
                    imgresult.setVisibility(View.VISIBLE);
                    setImageForItem(a, imgresult);
                } else if (a >= 100000) {
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
                    if (part.equals("body")) {
                        imgresultbody.setVisibility(View.VISIBLE);
                        imgresultbody.setImageResource(resID);
                    } else if (part.equals("wing")) {
                        imgresultwing.setVisibility(View.VISIBLE);
                        imgresultwing.setImageResource(resID);
                    } else if (part.equals("head")) {
                        imgresulthead.setVisibility(View.VISIBLE);
                        imgresulthead.setImageResource(resID);
                    } else if (part.equals("horn")) {
                        imgresulthorn.setVisibility(View.VISIBLE);
                        imgresulthorn.setImageResource(resID);
                    } else if (part.equals("horn2")) {
                        imgresulthorn.setVisibility(View.VISIBLE);
                        imgresulthorn.setImageResource(resID);
                    } else if (part.equals("neck")) {
                        imgresultneck.setVisibility(View.VISIBLE);
                        imgresultneck.setImageResource(resID);
                    } else if (part.equals("face")) {
                        imgresultface.setVisibility(View.VISIBLE);
                        imgresultface.setImageResource(resID);
                    }
                }
            }
            if (imgCur == 30) {
                frmenu1.setEnabled(true);
                frmenu2.setEnabled(true);
                gotocoin.setEnabled(true);
                gotojewel.setEnabled(true);
                imgback.setEnabled(true);
                imgbacktomypage.setEnabled(true);
                imgresult.setVisibility(View.GONE);
                imgresulthorn.setVisibility(View.GONE);
                imgresultface.setVisibility(View.GONE);
                imgresulthead.setVisibility(View.GONE);
                imgresultwing.setVisibility(View.GONE);
                imgresultneck.setVisibility(View.GONE);
                imgresultbody.setVisibility(View.GONE);
                imgresultoutside.setVisibility(View.GONE);
                Dialog_getitem();
                String star = rarityGold.get(positionItem);
                int _inStar = Integer.parseInt(star);
                for (int i = 0; i < _inStar; i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
                    params.setMargins(3, 0, 0, 0);
                    Button button = new Button(Gacha.this);
                    button.setLayoutParams(params);
                    button.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(button);
                }
                String str = arrIDGold.get(positionItem);
                int a = Integer.parseInt(str);
                if (a < 100000) {
                    setImageForItem(a, imggetitem);
                } else if (a >= 100000) {
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
                    if (part.equals("body"))
                        imggetitembody.setImageResource(resID);
                    else if (part.equals("wing"))
                        imggetitemwing.setImageResource(resID);
                    else if (part.equals("head"))
                        imggetitemhead.setImageResource(resID);
                    else if (part.equals("horn"))
                        imggetitemhorn.setImageResource(resID);
                    else if (part.equals("horn2"))
                        imggetitemhorn.setImageResource(resID);
                    else if (part.equals("neck"))
                        imggetitemneck.setImageResource(resID);
                    else if (part.equals("face"))
                        imggetitemface.setImageResource(resID);
                }
                txtName.setText("" + arrNameGold.get(positionItem) + " x " + numItemsGold.get(positionItem));
                txtdes.setText("" + arrDesGold.get(positionItem));
            }
            if (imgCur == 15)
                handle1.startAnimation(myRotation);
            if (imgCur == 18) {
                String str = capsuleIdxGold.get(positionItem);
                int a = Integer.parseInt(str);
                setImagecapsuleIdx(a, ball);
                Animation animation = AnimationUtils.loadAnimation(Gacha.this, R.anim.trans_top_in);
                animation.setDuration(500);
                ball.setVisibility(View.VISIBLE);
                ball.setAnimation(animation);
                ball.animate();
                animation.start();
            }
            if (imgCur == 1 || imgCur == 4 || imgCur == 7 || imgCur == 10 || imgCur == 13 || imgCur == 16 || imgCur == 19)
                gachaHead1.setImageResource(R.drawable.c_gacha_head1);
            if (imgCur == 2 || imgCur == 5 || imgCur == 8 || imgCur == 11 || imgCur == 14 || imgCur == 17 || imgCur == 20)
                gachaHead1.setImageResource(R.drawable.c_gacha_head2);
            if (imgCur == 3 || imgCur == 6 || imgCur == 9 || imgCur == 12 || imgCur == 15 || imgCur == 18)
                gachaHead1.setImageResource(R.drawable.c_gacha_head3);
        }
    };
}
