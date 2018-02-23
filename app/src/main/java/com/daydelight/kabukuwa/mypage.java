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
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.DataStt;
import com.daydelight.kabukuwa.DesLevel;
import com.daydelight.kabukuwa.JSONParser;
import com.daydelight.kabukuwa.main_intro;
import com.daydelight.kabukuwa.mypageMenu3;
import com.daydelight.kabukuwa.mypageMenu4;
import com.daydelight.kabukuwa.shop;
import com.daydelight.kabukuwa.zukan_main;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.daydelight.kabukuwa.R;

/**
 * Created by goood on 5/14/15.
 */
public class mypage extends Activity {
    String tempid = "", tempdis = "", tempjewel = "", temprarity = "", tempnumitem = "", tempcoin = "";
    TranslateAnimation anim_butterfly, anim_butterfly2, anim_pill, anim_pilllui, rd_pet, rd_pet_l;
    ImageView mphead, mpface, mphorn, mphorn2, bgmphead, bgmpface, bgmphorn, bgmphorn2, battle_ring,
            word_battle_b, word_battle_a, word_battle_t1, word_battle_t2, word_battle_l, word_battle_e, word_battle_ex_mark,
            word_asura1, word_asura2, word_asura3, word_asura4, asura_forest, home_parasol1_new,
            random_horn, random_horn2, random_head, random_face, random_neck, random_body, random_wing,
            f_coin, f_jewel, f_shin1, f_shin2, forest_a1;
    AnimationDrawable anim_coin, anim_jewel, anim_shin1, anim_shin2, anim_forest_a1, anim_asura_forest,
            anim_home_parasol1_new, frameAnimation, animpill, animpilllui;
    FrameLayout frmypage, frpill, frbutterfly, button10, fr_random_pet;
    GridView gridView, gviewoncreate;
    ProgressIndicator indicator;
    LinearLayout lnlvpet;
    Animation anim_alpha;
    public static Animation animScale;
    public static String _title[] = {"ひよっこブリーダー", "半人前ブリーダー", "初心者ブリーダー", "一般ブリーダー", "中級ブリーダー", "上級ブリーダー",
            "プロブリーダー", "カブクワブリーダー", "伝説のブリーダー", "蟲マスター"};
    private PublisherAdView mAdView;
    public static int _Width, _Height;
    ImageView img_menu, img_shop, mochimono, btnimgbreeding, imggacha, imgfriend;
    TextView nickname, coin, jewel, txtlv, txtphantram, txttitle, formatcoin, formatjewel, cap, txtnampet, txtkind, txtHp;
    EditText editText;
    public static String _URL_REGISTER = "http://49.212.208.153/kabukuwa-api/index.php";
    public static final String TAG_SUCCESS = "resultCode";
    public static int _COUNTUONG, _COUNTUONG2, _COUNTUONG3, _COUNTUONG4, _COUNTUONG5, _COUNTUONG6, _COUNTUONG7, _COUNTUONG8;
    public static int _COUNTAN, _COUNTAN2, _COUNTAN3, _COUNTAN4, _COUNTAN5, _COUNTAN6, _COUNTAN7, _COUNTAN8;
    public static int _COUNTNHA, _COUNTNHA2, _COUNTNHA3, _COUNTNHA4, _COUNTNHA5, _COUNTNHA6, _COUNTNHA7, _COUNTNHA8;
    public static int age, age2, age3, age4, age5, age6, age7, age8;
    public static int giay, giay2, giay3, giay4, giay5, giay6, giay7, giay8;
    public static int phut, phut2, phut3, phut4, phut5, phut6, phut7, phut8;
    public static int gio, gio2, gio3, gio4, gio5, gio6, gio7, gio8;
    public static int ngay, ngay2, ngay3, ngay4, ngay5, ngay6, ngay7, ngay8;
    public static int phutup, phutup2, phutup3, phutup4, phutup5, phutup6, phutup7, phutup8;
    public static int gioup, gioup2, gioup3, gioup4, gioup5, gioup6, gioup7, gioup8;
    public static int ngayup, ngayup2, ngayup3, ngayup4, ngayup5, ngayup6, ngayup7, ngayup8;
    public static int friendly, friendly2, friendly3, friendly4, friendly5, friendly6, friendly7, friendly8;
    public static int exp;
    public static int kn, kn2;
    public static int temp, temp2, temp3, temp4, temp5, temp6, temp7, temp8;
    public static int sleep, sleep2, sleep3, sleep4, sleep5, sleep6, sleep7, sleep8;
    public static int useitem, useitem2, useitem3, useitem4, useitem5, useitem6, useitem7, useitem8;
    public static int health, health2, health3, health4, health5, health6, health7, health8;
    public static int mood, mood2, mood3, mood4, mood5, mood6, mood7, mood8;
    public static int theluc;
    public static int p, p2, p3, p4, p5, p6, p7, p8;
    public static int s, s2, s3, s4, s5, s6, s7, s8;
    public static int ngu, ngu2, ngu3, ngu4, ngu5, ngu6, ngu7, ngu8;
    public static int daitien, daitien2, daitien3, daitien4, daitien5, daitien6, daitien7, daitien8;
    public static int tieutien, tieutien2, tieutien3, tieutien4, tieutien5, tieutien6, tieutien7, tieutien8;
    public static int form, form2, form3, form4, form5, form6, form7, form8;
    public static int personality, personality2, personality3, personality4, personality5, personality6, personality7, personality8;
    public static int strength, strength2, strength3, strength4, strength5, strength6, strength7, strength8;
    public static int size, size2, size3, size4, size5, size6, size7, size8;
    public static long lastCleanTime, lastCleanTime2, lastCleanTime3, lastCleanTime4, lastCleanTime5, lastCleanTime6, lastCleanTime7, lastCleanTime8;
    public static long runpaStartTime, runpaStartTime2, runpaStartTime3, runpaStartTime4, runpaStartTime5, runpaStartTime6, runpaStartTime7, runpaStartTime8;
    ProgressBar progressBar3, prhp;
    long mLastClickTime = 0;
    MediaPlayer mediaPlayer;
    boolean bsound = false;
    public static MediaPlayer kSECommand, soundbg;
    ArrayList<String> content;
    ArrayList<String> coinmp;
    ArrayList<String> jewelmp;
    ArrayList<String> fooddong2;
    ArrayList<String> fooddong3;
    ArrayList<String> star;
    ArrayList<String> arrnumber;
    ArrayList<String> contentShow;
    ArrayList<String> coinShow;
    ArrayList<String> jewelShow;
    ArrayList<String> fooddong2Show;
    ArrayList<String> fooddong3Show;
    ArrayList<String> starShow;
    ArrayList<String> arrnumberShow;
    ArrayList<Integer> img;
    ArrayList<Integer> imgShow;
    ArrayList<String> contentItem;
    ArrayList<String> coinItem;
    ArrayList<String> jewelItem;
    ArrayList<String> fooddong2Item;
    ArrayList<String> fooddong3Item;
    ArrayList<String> starItem;
    ArrayList<String> arrnumberItem;
    ArrayList<String> contentItemShow;
    ArrayList<String> coinItemShow;
    ArrayList<String> jewelItemShow;
    ArrayList<String> fooddong2ItemShow;
    ArrayList<String> fooddong3ItemShow;
    ArrayList<String> starItemShow;
    ArrayList<String> arrnumberItemShow;
    ArrayList<Integer> imgItem;
    ArrayList<Integer> imgItemShow;

    ArrayList<String> contentDrink;
    ArrayList<String> coinDrink;
    ArrayList<String> jewelDrink;
    ArrayList<String> fooddong2Drink;
    ArrayList<String> fooddong3Drink;
    ArrayList<String> starDrink;
    ArrayList<String> arrnumberDrink;
    ArrayList<String> contentDrinkShow;
    ArrayList<String> coinDrinkShow;
    ArrayList<String> jewelDrinkShow;
    ArrayList<String> fooddong2DrinkShow;
    ArrayList<String> fooddong3DrinkShow;
    ArrayList<String> starDrinkShow;
    ArrayList<String> arrnumberDrinkShow;
    ArrayList<Integer> imgDrink;
    ArrayList<Integer> imgDrinkShow;
    LinearLayout lnstar;

    ArrayList<String> arr_horn;
    ArrayList<String> arr_horn2;
    ArrayList<String> arr_wing;
    ArrayList<String> arr_neck;
    ArrayList<String> arr_face;
    ArrayList<String> arr_body;
    ArrayList<String> arr_head;
    ArrayList<Integer> arr_subkind;

    public static ArrayList<String> itemId;
    public static ArrayList<String> itemDes;
    public static ArrayList<String> itemName;
    public static ArrayList<String> rarity;
    public static ArrayList<String> coins;
    public static ArrayList<String> jewels;
    public static ArrayList<String> itemIdShop;
    public static ArrayList<String> itemNameShop;
    public static ArrayList<String> rarityShop;
    public static ArrayList<String> coinsShop;
    public static ArrayList<String> jewelsShop;
    public static ArrayList<String> itemDesShop;
    public static ArrayList<String> itemDesName;

    public static ArrayList<String> CSV_hp_parts;
    public static ArrayList<String> CSV_attack_parts;
    public static ArrayList<String> CSV_criticalAttack_parts;
    public static ArrayList<String> CSV_defense_parts;
    public static ArrayList<String> CSV_critical_parts;
    public static ArrayList<String> CSV_avoid_parts;
    public static ArrayList<String> CSV_lucky_parts;
    public static ArrayList<String> CSV_speed_parts;
    public static ArrayList<String> CSV_species_parts;
    public static ArrayList<String> CSV_part_parts;
    public static ArrayList<String> CSV_rank_parts;

    public static ArrayList<String> CSV_hp_supplement;
    public static ArrayList<String> CSV_attack_supplement;
    public static ArrayList<String> CSV_criticalAttack_supplement;
    public static ArrayList<String> CSV_defense_supplement;
    public static ArrayList<String> CSV_critical_supplement;
    public static ArrayList<String> CSV_avoid_supplement;
    public static ArrayList<String> CSV_lucky_supplement;
    public static ArrayList<String> CSV_speed_supplement;
    public static ArrayList<String> CSV_species_supplement;
    public static ArrayList<String> CSV_lv_supplement;

    public static ArrayList<String> CSV_hp;
    public static ArrayList<String> CSV_attack;
    public static ArrayList<String> CSV_criticalAttack;
    public static ArrayList<String> CSV_defense;
    public static ArrayList<String> CSV_critical;
    public static ArrayList<String> CSV_avoid;
    public static ArrayList<String> CSV_lucky;
    public static ArrayList<String> CSV_speed;
    public static ArrayList<String> CSV_species;
    public static ArrayList<String> CSV_lv;

    public static ArrayList<String> arr_hp_parts;
    public static ArrayList<String> arr_attack_parts;
    public static ArrayList<String> arr_criticalAttack_parts;
    public static ArrayList<String> arr_defense_parts;
    public static ArrayList<String> arr_critical_parts;
    public static ArrayList<String> arr_avoid_parts;
    public static ArrayList<String> arr_lucky_parts;
    public static ArrayList<String> arr_speed_parts;
    public static ArrayList<String> arr_species_parts;
    public static ArrayList<String> arr_part_parts;
    public static ArrayList<String> arr_rank_parts;

    public static ArrayList<String> arr_hp;
    public static ArrayList<String> arr_attack;
    public static ArrayList<String> arr_criticalAttack;
    public static ArrayList<String> arr_defense;
    public static ArrayList<String> arr_critical;
    public static ArrayList<String> arr_avoid;
    public static ArrayList<String> arr_lucky;
    public static ArrayList<String> arr_speed;
    public static ArrayList<String> arr_species;
    public static ArrayList<String> arr_lv;

    public static ArrayList<String> arr_hp_supplement;
    public static ArrayList<String> arr_attack_supplement;
    public static ArrayList<String> arr_criticalAttack_supplement;
    public static ArrayList<String> arr_defense_supplement;
    public static ArrayList<String> arr_critical_supplement;
    public static ArrayList<String> arr_avoid_supplement;
    public static ArrayList<String> arr_lucky_supplement;
    public static ArrayList<String> arr_speed_supplement;
    public static ArrayList<String> arr_species_supplement;
    public static ArrayList<String> arr_lv_supplement;

    ArrayList<String> numitem;
    ArrayList<String> numitemDisplay;
    ArrayList<String> rarityDisplay;
    ArrayList<String> itemIdShopDisplay;
    ArrayList<String> DesnameDisplay;
    ArrayList<String> coinDisplay;
    ArrayList<String> jewelDisplay;

    ArrayList<Integer> _idItem;
    ArrayList<Integer> _idItemShow;
    ArrayList<Integer> _idFood;
    ArrayList<Integer> _idFoodShow;
    ArrayList<Integer> _idDrink;
    ArrayList<Integer> _idDrinkShow;

    LinearLayout layoutLevel;
    int _move = 0;

    Dialog mcustomdialog, mpdialogitem;

    public void ShowCustomDialog() {
        try {
            mcustomdialog = new Dialog(mypage.this);
            mcustomdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mcustomdialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mcustomdialog.setCanceledOnTouchOutside(false);
            mcustomdialog.setContentView(R.layout.dialog_item);
            mcustomdialog.show();
        } catch (Exception ex) {
        }
    }

    public void HideCustomDiaglog() {
        try {
            mcustomdialog.dismiss();
        } catch (Exception ex) {
        }
    }

    //
    Dialog mdialog2;

    public void ShowCustomDialog2() {
        try {
            mdialog2 = new Dialog(mypage.this);
            mdialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mdialog2.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mdialog2.setCanceledOnTouchOutside(false);
            mdialog2.setContentView(R.layout.dialog_item);
            mdialog2.show();
        } catch (Exception ex) {
        }
    }

    public void HideCustomDiaglog2() {
        try {
            mdialog2.dismiss();
        } catch (Exception ex) {
        }
    }

    DisplayMetrics metrics;
    dbHandler db;
    DataStt stt = new DataStt();
    List<DataStt> listDataStt;
    DecimalFormat formatter;
    List<TablePart> _listTablePart;
    TextView fighttext, foresttext;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mypage);
        handler = new Handler();
        anim_alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        getpartCSVfile();
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        animation = AnimationUtils.loadAnimation(mypage.this, R.anim.trans_left_in);
        jump_anim = AnimationUtils.loadAnimation(this, R.anim.jump);
        _Height = metrics.heightPixels;
        _Width = metrics.widthPixels;
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        formatter = new DecimalFormat("#,###,###");
        db = new dbHandler(this);
        word_battle_b = (ImageView) findViewById(R.id.word_battle_b);
        word_battle_a = (ImageView) findViewById(R.id.word_battle_a);
        word_battle_t1 = (ImageView) findViewById(R.id.word_battle_t1);
        word_battle_t2 = (ImageView) findViewById(R.id.word_battle_t2);
        word_battle_l = (ImageView) findViewById(R.id.word_battle_l);
        word_battle_e = (ImageView) findViewById(R.id.word_battle_e);
        word_asura1 = (ImageView) findViewById(R.id.word_asura1);
        word_asura2 = (ImageView) findViewById(R.id.word_asura2);
        word_asura3 = (ImageView) findViewById(R.id.word_asura3);
        word_asura4 = (ImageView) findViewById(R.id.word_asura4);
        word_battle_ex_mark = (ImageView) findViewById(R.id.word_battle_ex_mark);
        lnlvpet = (LinearLayout) findViewById(R.id.lnlvpet);
        txtnampet = (TextView) findViewById(R.id.txtnampet);
        fighttext = (TextView) findViewById(R.id.fighttext);
        foresttext = (TextView) findViewById(R.id.foresttext);
        txtkind = (TextView) findViewById(R.id.txtkind);
        txtHp = (TextView) findViewById(R.id.txthp);
        mphead = (ImageView) findViewById(R.id.mphead);
        mpface = (ImageView) findViewById(R.id.mpface);
        mphorn = (ImageView) findViewById(R.id.mphorn);
        mphorn2 = (ImageView) findViewById(R.id.mphorn2);
        bgmphead = (ImageView) findViewById(R.id.bgmphead);
        bgmpface = (ImageView) findViewById(R.id.bgmpface);
        bgmphorn = (ImageView) findViewById(R.id.bgmphorn);
        bgmphorn2 = (ImageView) findViewById(R.id.bgmphorn2);
        battle_ring = (ImageView) findViewById(R.id.battle_ring);

        f_coin = (ImageView) findViewById(R.id.f_coin);
        f_jewel = (ImageView) findViewById(R.id.f_jewel);
        f_shin1 = (ImageView) findViewById(R.id.f_shin1);
        f_shin2 = (ImageView) findViewById(R.id.f_shin2);
        forest_a1 = (ImageView) findViewById(R.id.forest_a1);
        asura_forest = (ImageView) findViewById(R.id.asura_forest);
        home_parasol1_new = (ImageView) findViewById(R.id.home_parasol1_new);

        f_coin.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        f_jewel.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        f_shin1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        f_shin2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        forest_a1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        asura_forest.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        home_parasol1_new.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        f_coin.setBackgroundResource(R.drawable.animation_coin);
        anim_coin = (AnimationDrawable) f_coin.getBackground();
        f_jewel.setBackgroundResource(R.drawable.animation_jewel);
        anim_jewel = (AnimationDrawable) f_jewel.getBackground();
        f_shin1.setBackgroundResource(R.drawable.animation_shine);
        anim_shin1 = (AnimationDrawable) f_shin1.getBackground();
        f_shin2.setBackgroundResource(R.drawable.animation_shine);
        anim_shin2 = (AnimationDrawable) f_shin2.getBackground();
        forest_a1.setBackgroundResource(R.drawable.animation_forest);
        anim_forest_a1 = (AnimationDrawable) forest_a1.getBackground();
        asura_forest.setBackgroundResource(R.drawable.animation_asura_forest);
        anim_asura_forest = (AnimationDrawable) asura_forest.getBackground();
        home_parasol1_new.setBackgroundResource(R.drawable.animation_home_parasol);
        anim_home_parasol1_new = (AnimationDrawable) home_parasol1_new.getBackground();

        random_horn = (ImageView) findViewById(R.id.random_horn);
        random_horn2 = (ImageView) findViewById(R.id.random_horn2);
        random_head = (ImageView) findViewById(R.id.random_head);
        random_face = (ImageView) findViewById(R.id.random_face);
        random_neck = (ImageView) findViewById(R.id.random_neck);
        random_wing = (ImageView) findViewById(R.id.random_wing);
        random_body = (ImageView) findViewById(R.id.random_body);
        fr_random_pet = (FrameLayout) findViewById(R.id.fr_random_pet);
        frmypage = (FrameLayout) findViewById(R.id.frmypage);
        frpill = (FrameLayout) findViewById(R.id.frpill);
        frbutterfly = (FrameLayout) findViewById(R.id.frbutterfly);
        button10 = (FrameLayout) findViewById(R.id.button10);
        imgfriend = (ImageView) findViewById(R.id.imgfriend);
        imgfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                v.startAnimation(animScale);
                mLastClickTime = SystemClock.elapsedRealtime();
                shownotifyWhenBuy();
            }
        });
        imggacha = (ImageView) findViewById(R.id.imggacha);
        imggacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                v.startAnimation(animScale);
                Intent intent = new Intent(mypage.this, Gacha.class);
                intent.putExtra("flag", "mypage");
                startActivity(intent);
            }
        });
        layoutLevel = (LinearLayout) findViewById(R.id.layoutLevel);
        nickname = (TextView) findViewById(R.id.txtten);
        coin = (TextView) findViewById(R.id.txtcoin);
        jewel = (TextView) findViewById(R.id.txtjewel);
        txttitle = (TextView) findViewById(R.id.txttitle);
        formatcoin = (TextView) findViewById(R.id.formatcoin);
        formatjewel = (TextView) findViewById(R.id.formatjewel);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        prhp = (ProgressBar) findViewById(R.id.prhp);

        cap = (TextView) findViewById(R.id.lv);
        //
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        txtlv = (TextView) findViewById(R.id.txtlv);
        txtlv.setText("" + pre.getInt("lv", 1));

        progressBar3.setMax(pre.getInt("lv", 1) * 10);
        progressBar3.setProgress(pre.getInt("theluc", pre.getInt("lv", 1) * 10));

        img_menu = (ImageView) findViewById(R.id.imgmenu);
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                v.startAnimation(animScale);
                mLastClickTime = SystemClock.elapsedRealtime();
                _ShowDialog();
            }
        });
        //
        img_shop = (ImageView) findViewById(R.id.imgshop);
        img_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                v.startAnimation(animScale);
                mLastClickTime = SystemClock.elapsedRealtime();
                Intent intent = new Intent(mypage.this, shop.class);
                intent.putExtra("dialog", "mypage");
                intent.putExtra("giatri", "1");
                intent.putExtra("flag", "mypage");
                intent.putExtra("namesell", namesell);
                intent.putExtra("_hp", _hp);
                intent.putExtra("hangsell", hangsell);
                intent.putExtra("loaisale", loaisale);
                intent.putExtra("wingNosale", wingNosale);
                intent.putExtra("faceNosale", faceNosale);
                intent.putExtra("neckNosale", neckNosale);
                intent.putExtra("matsale", matsale);
                intent.putExtra("bodyNosale", bodyNosale);
                intent.putExtra("horn2Nosale", horn2Nosale);
                intent.putExtra("hornNosale", hornNosale);
                intent.putExtra("headNosale", headNosale);
                intent.putExtra("_level", _level);
                startActivity(intent);
            }
        });
        //
        btnimgbreeding = (ImageView) findViewById(R.id.imgbreeding);
        btnimgbreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                v.startAnimation(animScale);
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                String ten1 = pre.getString("tenzukan", "");
                String ten2 = pre.getString("tenzukan2", "");
                String ten3 = pre.getString("tenzukan3", "");
                String ten4 = pre.getString("tenzukan4", "");
                String ten5 = pre.getString("tenzukan5", "");
                String ten6 = pre.getString("tenzukan6", "");
                String ten7 = pre.getString("tenzukan7", "");
                String ten8 = pre.getString("tenzukan8", "");
                if (ten1.length() > 0 || ten2.length() > 0 || ten3.length() > 0 || ten4.length() > 0
                        || ten5.length() > 0 || ten6.length() > 0 || ten7.length() > 0 || ten8.length() > 0) {
                    Intent intent = new Intent(mypage.this, zukan_main.class);
                    intent.putExtra("flag", "mypage");
                    startActivity(intent);
                } else if (ten1.length() == 0 || ten2.length() == 0 || ten3.length() == 0 || ten4.length() == 0
                        || ten5.length() == 0 || ten6.length() == 0 || ten7.length() == 0 || ten8.length() == 0) {
                    DialogCreatePet();
                }
            }
        });
        mochimono = (ImageView) findViewById(R.id.imgmochimono);
        mochimono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                v.startAnimation(animScale);
                mLastClickTime = SystemClock.elapsedRealtime();
                Dialog_Mochimono();
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.se018);
        soundbg = MediaPlayer.create(this, R.raw.bgmypage);
        soundbg.setLooping(true);
        kSECommand = MediaPlayer.create(this, R.raw.se022);

        txtphantram = (TextView) findViewById(R.id.txtphantram);

        String mail = pre.getString("email", "");
        String pass = pre.getString("pass", "");
        String uuid = pre.getString("uuid", "");

        RestoreTime();
        hP();

        indicator = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator1);
        indicator.setForegroundColor(Color.parseColor("#ebbd36"));
        indicator.setBackgroundColor(Color.parseColor("#000000"));
        indicator.setPieStyle(true);
        itemId = new ArrayList<String>();
        itemDes = new ArrayList<String>();
        itemName = new ArrayList<String>();
        rarity = new ArrayList<String>();
        coins = new ArrayList<String>();
        jewels = new ArrayList<String>();
        kind_temp = new ArrayList<String>();
        hp_temp = new ArrayList<Double>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileMypage csvFile = new CSVFileMypage(inputStream);
        List<String[]> scoreList = csvFile.read();
        _createCPU();
        anim_animal();
        level_account = pre.getInt("lv", 1);
        int _lvNext = level_account;
        exp_next = Chat.nextGoalExpAtLevel(_lvNext);
    }

    public static int Player_species, inKind;
    ArrayList<Integer> arrtemp;

    public void showpetlogin() {
        for (int i = 0; i < frmypage.getChildCount(); i++) {
            View view = frmypage.getChildAt(i);
            view.clearAnimation();
//            frmypage.removeView(view);
        }
        frmypage.removeAllViews();
        arrtemp = new ArrayList<Integer>();
        listPetLogin = db.getPetTruongThanh();
        listDataShowpet = db.getAllShowpet();
        final Dialog dialogwhenbuy = new Dialog(mypage.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.showpetwhenlogin);
        ImageView btnclose = (ImageView) dialogwhenbuy.findViewById(R.id.btnclose);
        TextView txtcontent = (TextView) dialogwhenbuy.findViewById(R.id.txtcontent);
        gridView = (GridView) dialogwhenbuy.findViewById(R.id.gridView);
        try {
            gridView.setAdapter(new ViewAdapter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtcontent.setText("お気に入りのカブクワを３匹まで選んでね♪");
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                arrtemp.clear();
                if (check > 0) {
                    db.removeTabshowpet();
                    for (int i = gridView.getChildCount() - 1; i >= 0; i--) {
                        View view = gridView.getChildAt(i);
                        CheckBox chk = (CheckBox) view.findViewById(R.id.chbx);
                        if (chk.isChecked()) {
                            _setNewValue(i);
                            db.addshowpet(mypage.this, i, idpetsell, 0);
                            int size_screen = (int) Chat.convertDpToPixel(100);
                            int size_pet = (int) Chat.convertDpToPixel(75);
                            if (_Width <= 480) {
                                size_screen = (int) Chat.convertDpToPixel(80);
                                size_pet = (int) Chat.convertDpToPixel(60);
                            }
                            FrameLayout.LayoutParams paramsroot = null;
                            if (_Width >= 720) {
                                paramsroot = new FrameLayout.LayoutParams(size_screen, size_screen);
                                int a = new Random().nextInt(3);
                                if (a == 1) {
                                    int l = new Random().nextInt(size_screen) + 100;
                                    int t = new Random().nextInt(size_screen) + size_screen;
                                    int r = new Random().nextInt(100);
                                    int b = new Random().nextInt(100);
                                    paramsroot.setMargins(l, t, r, b);
                                } else if (a == 2) {
                                    int l = new Random().nextInt(size_screen) + size_screen;
                                    int t = new Random().nextInt(size_screen) + 300;
                                    int r = new Random().nextInt(150);
                                    int b = new Random().nextInt(size_screen);
                                    paramsroot.setMargins(l, t, r, b);
                                } else if (a == 0) {
                                    int l = new Random().nextInt(size_screen) + 150;
                                    int t = new Random().nextInt(size_screen) + 400;
                                    int r = new Random().nextInt(size_screen);
                                    int b = new Random().nextInt(size_screen);
                                    paramsroot.setMargins(l, t, r, b);
                                }
                            } else if (_Width < 720) {
                                paramsroot = new FrameLayout.LayoutParams(size_screen, size_screen);
                                int a = new Random().nextInt(3);
                                if (a == 1) {
                                    int l = new Random().nextInt(size_screen) + 50;
                                    int t = new Random().nextInt(size_screen) + size_screen;
                                    int r = new Random().nextInt(50);
                                    int b = new Random().nextInt(50);
                                    paramsroot.setMargins(l, t, r, b);
                                } else if (a == 2) {
                                    int l = new Random().nextInt(size_screen) + size_screen;
                                    int t = new Random().nextInt(size_screen) + 150;
                                    int r = new Random().nextInt(100);
                                    int b = new Random().nextInt(size_screen);
                                    paramsroot.setMargins(l, t, r, b);
                                } else if (a == 0) {
                                    int l = new Random().nextInt(size_screen) + 100;
                                    int t = new Random().nextInt(size_screen) + 200;
                                    int r = new Random().nextInt(size_screen);
                                    int b = new Random().nextInt(size_screen);
                                    paramsroot.setMargins(l, t, r, b);
                                }
                            }
                            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size_pet, size_pet);
                            params.gravity = Gravity.CENTER;
                            final FrameLayout root = new FrameLayout(mypage.this);
                            root.setLayoutParams(paramsroot);
                            //
                            ImageView horn2sell = new ImageView(mypage.this);
                            ImageView hornsell = new ImageView(mypage.this);
                            ImageView dausell = new ImageView(mypage.this);
                            final ImageView bodysell = new ImageView(mypage.this);
                            ImageView necksell = new ImageView(mypage.this);
                            ImageView canhsell = new ImageView(mypage.this);
                            ImageView facesell = new ImageView(mypage.this);
                            ImageView shadow = new ImageView(mypage.this);
                            ImageView effect = new ImageView(mypage.this);
                            //
                            hornsell.setAdjustViewBounds(true);
                            horn2sell.setAdjustViewBounds(true);
                            dausell.setAdjustViewBounds(true);
                            bodysell.setAdjustViewBounds(true);
                            necksell.setAdjustViewBounds(true);
                            canhsell.setAdjustViewBounds(true);
                            facesell.setAdjustViewBounds(true);
                            shadow.setAdjustViewBounds(true);
                            effect.setAdjustViewBounds(true);
                            //
                            shadow.setLayoutParams(params);
                            hornsell.setLayoutParams(params);
                            horn2sell.setLayoutParams(params);
                            dausell.setLayoutParams(params);
                            bodysell.setLayoutParams(params);
                            necksell.setLayoutParams(params);
                            canhsell.setLayoutParams(params);
                            facesell.setLayoutParams(params);
                            FrameLayout.LayoutParams params_effect = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                                    FrameLayout.LayoutParams.WRAP_CONTENT);
                            params.gravity = Gravity.CENTER;
                            effect.setLayoutParams(params_effect);
                            //
                            shadow.setImageResource(R.drawable.imago_shadow);
                            if (loaisale.equals("loai1") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                if (neckNosale > 3)
                                    neckNosale = 3;
                                dausell.setImageResource(Chat.head[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body[bodyNosale]);
                                necksell.setImageResource(Chat.neck[neckNosale]);
                                hornsell.setImageResource(Chat.horn[hornNosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0000_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face[faceNosale]);
                                Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.1f);
                                shadow.setScaleY(1.1f);
                            } else if (loaisale.equals("loai2") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 2)
                                    neckNosale = 2;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head2[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing2[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body2[bodyNosale]);
                                necksell.setImageResource(Chat.neck2[neckNosale]);
                                hornsell.setImageResource(Chat.horn2[hornNosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0100_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face2[faceNosale]);
                            } else if (loaisale.equals("loai3") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 4)
                                    neckNosale = 4;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head3[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing3[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body3[bodyNosale]);
                                necksell.setImageResource(Chat.neck3[neckNosale]);
                                hornsell.setImageResource(Chat.horn3[hornNosale]);
                                horn2sell.setImageResource(Chat.horn33[horn2Nosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0001_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face3[faceNosale]);
                                Chat._setScale(1.3f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.3f);
                                shadow.setScaleY(1.3f);
                            } else if (loaisale.equals("loai4") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 2)
                                    neckNosale = 2;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head4[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing4[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body4[bodyNosale]);
                                necksell.setImageResource(Chat.neck4[neckNosale]);
                                hornsell.setImageResource(Chat.horn4[hornNosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0101_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face4[faceNosale]);
                                Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.1f);
                                shadow.setScaleY(1.1f);
                            } else if (loaisale.equals("loai5") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 3)
                                    neckNosale = 3;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head5[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing5[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body5[bodyNosale]);
                                necksell.setImageResource(Chat.neck5[neckNosale]);
                                hornsell.setImageResource(Chat.horn5[hornNosale]);
                                horn2sell.setImageResource(Chat.horn55[horn2Nosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0002_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face5[faceNosale]);
                                Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.1f);
                                shadow.setScaleY(1.1f);
                            } else if (loaisale.equals("loai6") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 2)
                                    neckNosale = 2;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head6[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing6[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body6[bodyNosale]);
                                necksell.setImageResource(Chat.neck6[neckNosale]);
                                hornsell.setImageResource(Chat.horn6[hornNosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0102_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face6[faceNosale]);
                                Chat._setScale(1.3f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.3f);
                                shadow.setScaleY(1.3f);
                            } else if (loaisale.equals("loai7") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 3)
                                    neckNosale = 3;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head7[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing7[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body7[bodyNosale]);
                                necksell.setImageResource(Chat.neck7[neckNosale]);
                                hornsell.setImageResource(Chat.horn7[hornNosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0103_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face7[faceNosale]);
                            } else if (loaisale.equals("loai8") && tuoisale >= 5) {
                                if (wingNosale > 4)
                                    wingNosale = 4;
                                if (neckNosale > 3)
                                    neckNosale = 3;
                                if (faceNosale > 5)
                                    faceNosale = 5;
                                dausell.setImageResource(Chat.head8[headNosale]);
                                if (wingNosale > 0)
                                    canhsell.setImageResource(Chat.wing8[wingNosale - 1]);
                                bodysell.setImageResource(Chat.body8[bodyNosale]);
                                necksell.setImageResource(Chat.neck8[neckNosale]);
                                hornsell.setImageResource(Chat.horn8[hornNosale]);
                                horn2sell.setImageResource(Chat.horn88[horn2Nosale]);
                                if (matsale == 1)
                                    facesell.setImageResource(R.drawable.face_0003_10);
                                else if (matsale == 0)
                                    facesell.setImageResource(Chat.face8[faceNosale]);
                                Chat._setScale(1.4f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                                shadow.setScaleX(1.4f);
                                shadow.setScaleY(1.4f);
                            }
                            //
                            root.addView(shadow);
                            root.addView(canhsell);
                            root.addView(horn2sell);
                            root.addView(dausell);
                            root.addView(bodysell);
                            root.addView(necksell);
                            root.addView(facesell);
                            root.addView(hornsell);
                            root.addView(effect);
                            effect.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            effect.setBackgroundResource(R.drawable.animation_effect);
                            AnimationDrawable anim_effect = (AnimationDrawable) effect.getBackground();
                            anim_effect.start();
                            effect.setLayerType(View.LAYER_TYPE_NONE, null);
                            //
                            final ArrayList<String> arr = new ArrayList<String>();
                            _addArray(arr);
                            root.setTag(arr);
                            frmypage.addView(root);
                            root.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            final TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 0);
                            anim.setDuration(15000);
                            anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    int a = new Random().nextInt(25);
                                    int b = new Random().nextInt(25);
                                    int c = new Random().nextInt(4);
                                    if (c == 1) a *= -1;
                                    else if (c == 2) b *= -1;
                                    else if (c == 3) {
                                        a *= -1;
                                        b *= -1;
                                    }
                                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) root.getLayoutParams();
                                    params.topMargin += a;
                                    params.leftMargin += b;
                                    root.clearAnimation();
                                    root.setLayoutParams(params);
                                    root.setLayerType(View.LAYER_TYPE_NONE, null);
                                    root.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                                    root.startAnimation(anim);
                                }
                            });
                            root.startAnimation(anim);
                            root.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View view, MotionEvent event) {
                                    final int X = (int) event.getRawX();
                                    final int Y = (int) event.getRawY();

                                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                                        case MotionEvent.ACTION_DOWN:
                                            _ActionDown(view, X, Y, arr);
                                            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                                                return false;
                                            }
                                            mLastClickTime = SystemClock.elapsedRealtime();
                                            break;
                                        case MotionEvent.ACTION_UP:
                                            _ActionUp(view);
                                            startTimer2(loaisale, bodysell, bodyNosale);
                                            break;
                                        case MotionEvent.ACTION_POINTER_DOWN:
                                            break;
                                        case MotionEvent.ACTION_POINTER_UP:
                                            break;
                                        case MotionEvent.ACTION_MOVE:
                                            if (_timer_test == 0) {
                                                setCurPet(bodysell, loaisale, bodyNosale);
                                                _timer_test = 1;
                                            }
                                            _move = 0;
                                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view
                                                    .getLayoutParams();
                                            layoutParams.leftMargin = X - _xDelta;
                                            layoutParams.topMargin = Y - _yDelta;
                                            layoutParams.rightMargin = +50;
                                            layoutParams.bottomMargin = +50;
                                            view.setLayoutParams(layoutParams);
                                            break;
                                    }
                                    frmypage.invalidate();
                                    return true;
                                }
                            });
                        }
                    }
                    getparam();
                    txtnampet.setText(namesell);
                    txtkind.setText(hangsell);
                    for (int i = 0; i < kind_temp.size(); i++) {
                        if (kind_temp.get(i).equals(loaisale)) {
                            ratio_hp = hp_temp.get(i);
                        }
                    }
                    _hp = (int) ratio_hp * pl_hp / 100;
                    if (_hp == 0) {
                        _hp = 1;
                        db.update_hp(idpetsell, 1);
                    }
                    if (_hp >= pl_hp) {
                        _hp = pl_hp;
                        db.update_hp(idpetsell, 100);
                    }
                    prhp.setMax(pl_hp);
                    txtHp.setText(_hp + "/" + pl_hp);
                    prhp.setProgress(_hp);
                    fighttext.setText("" + _fightSum + "戦 " + _fightWin + "勝");
                    foresttext.setText("0戦 0勝");
                    int sizelv = 11;
                    if (_Width <= 480)
                        sizelv = 9;
                    DrawLevel(lnlvpet, _level, sizelv);
                    if (loaisale.equals("loai1")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        mphead.setImageResource(Chat.head[headNosale]);
                        mphorn.setImageResource(Chat.horn[hornNosale]);
                        bgmphead.setImageResource(Chat.bghead[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn[hornNosale]);
                        mphorn2.setImageResource(R.drawable.trans);
                        bgmphorn2.setImageResource(R.drawable.trans);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0000_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face[faceNosale]);
                    } else if (loaisale.equals("loai2")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head2[headNosale]);
                        mphorn.setImageResource(Chat.horn2[hornNosale]);
                        bgmphead.setImageResource(Chat.bghead2[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn2[hornNosale]);
                        mphorn2.setImageResource(R.drawable.trans);
                        bgmphorn2.setImageResource(R.drawable.trans);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0100_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face2[faceNosale]);
                    } else if (loaisale.equals("loai3")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 4)
                            neckNosale = 4;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head3[headNosale]);
                        mphorn.setImageResource(Chat.horn3[hornNosale]);
                        mphorn2.setImageResource(Chat.horn33[horn2Nosale]);
                        bgmphead.setImageResource(Chat.bghead3[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn3[hornNosale]);
                        bgmphorn2.setImageResource(Chat.bghorn33[horn2Nosale]);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0001_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face3[faceNosale]);
                    } else if (loaisale.equals("loai4")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head4[headNosale]);
                        mphorn.setImageResource(Chat.horn4[hornNosale]);
                        bgmphead.setImageResource(Chat.bghead4[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn4[hornNosale]);
                        mphorn2.setImageResource(R.drawable.trans);
                        bgmphorn2.setImageResource(R.drawable.trans);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0101_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face4[faceNosale]);
                    } else if (loaisale.equals("loai5")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head5[headNosale]);
                        mphorn.setImageResource(Chat.horn5[hornNosale]);
                        mphorn2.setImageResource(Chat.horn55[horn2Nosale]);
                        bgmphead.setImageResource(Chat.bghead5[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn5[hornNosale]);
                        bgmphorn2.setImageResource(Chat.bghorn55[horn2Nosale]);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0002_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face5[faceNosale]);
                    } else if (loaisale.equals("loai6")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head6[headNosale]);
                        mphorn.setImageResource(Chat.horn6[hornNosale]);
                        bgmphead.setImageResource(Chat.bghead6[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn6[hornNosale]);
                        mphorn2.setImageResource(R.drawable.trans);
                        bgmphorn2.setImageResource(R.drawable.trans);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0102_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face6[faceNosale]);
                    } else if (loaisale.equals("loai7")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head7[headNosale]);
                        mphorn.setImageResource(Chat.horn7[hornNosale]);
                        bgmphead.setImageResource(Chat.bghead7[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn7[hornNosale]);
                        mphorn2.setImageResource(R.drawable.trans);
                        bgmphorn2.setImageResource(R.drawable.trans);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0103_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face7[faceNosale]);
                    } else if (loaisale.equals("loai8")) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        mphead.setImageResource(Chat.head8[headNosale]);
                        mphorn.setImageResource(Chat.horn8[hornNosale]);
                        mphorn2.setImageResource(Chat.horn88[horn2Nosale]);
                        bgmphead.setImageResource(Chat.bghead8[headNosale]);
                        bgmphorn.setImageResource(Chat.bghorn8[hornNosale]);
                        bgmphorn2.setImageResource(Chat.bghorn88[horn2Nosale]);
                        if (matsale == 1)
                            mpface.setImageResource(R.drawable.face_0003_10);
                        else if (matsale == 0)
                            mpface.setImageResource(Chat.face8[faceNosale]);
                    }
                    dialogwhenbuy.dismiss();
                    try {
                        if (dialogchoosepet.isShowing())
                            dialogchoosepet.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (check == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("最低１匹は表示させるカブクワを選んでね♪");
                }
                check = 0;
                pet_shown = 0;
                if (_pet1 == 0) {
                    _pet1++;
//                    _dialogNotify();
//                    txtcontent_dialogNotify.setText("リングに育てたキャラをドラッグ&ドロップするとバトルができるよ！");
                }
            }
        });
        dialogwhenbuy.setCanceledOnTouchOutside(false);
        dialogwhenbuy.show();
    }

    private int _xDelta;
    private int _yDelta;
    int check = 0, checkclick = 0;
//    int temp_lv;

    public void hP() {
//        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        Thread th = new Thread() {
            int i;

            @Override
            public void run() {
                while (1 < 2) {
                    android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
                    for (i = 1; i <= 60; i++) {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (i == 15 && !bsound || i == 45 && !bsound)
                                        fr_random_pet.startAnimation(rd_pet);
                                    if (i == 30 && !bsound || i == 60 && !bsound)
                                        fr_random_pet.startAnimation(rd_pet_l);
//                                    temp_lv = level_account;
//                                    Log.e("temp_lv", "temp_lv:" + temp_lv);
                                    if (i == 2 && !bsound) {
                                        if (!frpill.isShown())
                                            frpill.setVisibility(View.VISIBLE);
                                        if (frbutterfly.isShown())
                                            frbutterfly.setVisibility(View.GONE);
                                    }
                                    if (i == 30 && !bsound) {
                                        if (frpill.isShown())
                                            frpill.setVisibility(View.GONE);
                                        if (!frbutterfly.isShown())
                                            frbutterfly.setVisibility(View.VISIBLE);
                                    }
                                    if (i == 60) {
                                        theluc++;
                                        if (theluc > level_account * 10)
                                            theluc = level_account * 10;
                                        if (!bsound) {
                                            txtphantram.setText("" + theluc + "/" + level_account * 10);
                                            progressBar3.setMax(level_account * 10);
                                            progressBar3.setProgress(theluc);
                                        }
                                        if (Battle.progressBar3 != null) {
                                            Battle.progressBar3.setProgress(theluc);
                                            Battle.txtphantram.setText("" + theluc + "/" + level_account * 10);
                                        }
                                        if (shop.progressBar3 != null) {
                                            shop.progressBar3.setProgress(theluc);
                                            shop.txtphantram.setText("" + theluc + "/" + level_account * 10);
                                        }
                                        if (_checkpet == 1) {
                                            if (_hp < pl_hp) {
                                                _hp++;
                                                double _curHP = _hp * 100 / pl_hp;
                                                if (!bsound) {
                                                    for (int i = 0; i < kind_temp.size(); i++) {
                                                        if (kind_temp.get(i).equals(loaisale)) {
                                                            hp_temp.set(i, _curHP);
//                                                            ratio_hp = hp_temp.get(i);
                                                        }
                                                    }
                                                    txtHp.setText(_hp + "/" + pl_hp);
                                                    prhp.setProgress(_hp);
                                                }
                                                if (Battle.txtHp != null) {
                                                    Battle.txtHp.setText(_hp + "/" + pl_hp);
                                                    Battle.prhp.setProgress(_hp);
                                                }
                                                if (shop.txtHp != null) {
                                                    shop.txtHp.setText(_hp + "/" + pl_hp);
                                                    shop.prhp.setProgress(_hp);
                                                }
                                                db.update_hp(idpetsell, _curHP);
                                                if (hppet != null)
                                                    hppet.setText("HP     " + _hp + "/ " + pl_hp);
                                            }
                                        }
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
        th.start();
    }


    Dialog dialogmochimono, createcharacter;

    public void Create_Character() {
        createcharacter = new Dialog(mypage.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(mypage.this);
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
//                    createcharacter.dismiss();
                }
            }
        });
        Button btnOK = (Button) createcharacter.findViewById(R.id.button15);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(mypage.this);
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
//                    createcharacter.dismiss();
                }
            }
        });
        createcharacter.setCanceledOnTouchOutside(false);
        createcharacter.show();
    }

    public void Dialog_Mochimono() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        dialogmochimono = new Dialog(mypage.this);
        dialogmochimono.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogmochimono.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogmochimono.setContentView(R.layout.mochimono_layout);
        dialogmochimono.setCanceledOnTouchOutside(false);
        layoutitem = (LinearLayout) dialogmochimono.findViewById(R.id.layoutitem);
        drinkitem = (ListView) dialogmochimono.findViewById(R.id.drinkitem);
        fooditem = (ListView) dialogmochimono.findViewById(R.id.fooditem);
        partitem = (ListView) dialogmochimono.findViewById(R.id.partitem);
        //
        itemIdShop = new ArrayList<String>();
        itemNameShop = new ArrayList<String>();
        rarityShop = new ArrayList<String>();
        coinsShop = new ArrayList<String>();
        jewelsShop = new ArrayList<String>();
        itemDesShop = new ArrayList<String>();
        itemDesName = new ArrayList<String>();
        numitem = new ArrayList<String>();
        numitemDisplay = new ArrayList<String>();
        rarityDisplay = new ArrayList<String>();
        itemIdShopDisplay = new ArrayList<String>();
        DesnameDisplay = new ArrayList<String>();
        coinDisplay = new ArrayList<String>();
        jewelDisplay = new ArrayList<String>();
        for (int i = 1; i < itemId.size(); i++) {
            if (Integer.parseInt(itemId.get(i)) >= 100000) {
                itemIdShop.add(itemId.get(i));
                rarityShop.add(rarity.get(i));
                jewelsShop.add(jewels.get(i));
                String str = coins.get(i);
                int a = Integer.parseInt(str) / 10;
                String b = "" + a;
                coinsShop.add(b);
                itemDesName.add(itemDes.get(i));
                String key = itemId.get(i);
                if (key.length() == 1)
                    key = "0000" + key;
                else if (key.length() == 2)
                    key = "000" + key;
                else if (key.length() == 3)
                    key = "00" + key;
                else if (key.length() == 4)
                    key = "0" + key;
                int _num = pre.getInt(key, 0);
                String value = "" + _num;
                numitem.add(value);
            }
        }
        for (int i = 0; i < numitem.size(); i++) {
            if (!numitem.get(i).equals("0")) {
                numitemDisplay.add(numitem.get(i));
                rarityDisplay.add(rarityShop.get(i));
                DesnameDisplay.add(itemDesName.get(i));
                coinDisplay.add(coinsShop.get(i));
                itemIdShopDisplay.add(itemIdShop.get(i));
                if (jewelsShop.get(i).equals(""))
                    jewelDisplay.add("0");
                else if (!jewelsShop.get(i).equals(""))
                    jewelDisplay.add(jewelsShop.get(i));
            }
        }

        for (int i = 0; i < itemIdShopDisplay.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (Integer.parseInt(itemIdShopDisplay.get(i)) <= Integer.parseInt(itemIdShopDisplay.get(j))) {
                    tempid = itemIdShopDisplay.get(i);
                    itemIdShopDisplay.set(i, itemIdShopDisplay.get(j));
                    itemIdShopDisplay.set(j, "" + tempid);
                    tempnumitem = numitemDisplay.get(i);
                    numitemDisplay.set(i, numitemDisplay.get(j));
                    numitemDisplay.set(j, tempnumitem);
                    temprarity = rarityDisplay.get(i);
                    rarityDisplay.set(i, rarityDisplay.get(j));
                    rarityDisplay.set(j, temprarity);
                    tempjewel = jewelDisplay.get(i);
                    jewelDisplay.set(i, jewelDisplay.get(j));
                    jewelDisplay.set(j, tempjewel);
                    tempcoin = coinDisplay.get(i);
                    coinDisplay.set(i, coinDisplay.get(j));
                    coinDisplay.set(j, tempcoin);
                    tempdis = DesnameDisplay.get(i);
                    DesnameDisplay.set(i, DesnameDisplay.get(j));
                    DesnameDisplay.set(j, tempdis);
                }
            }
        }
        partitemAdapter = new ItemArrayAdapter(this, DesnameDisplay, coinDisplay, jewelDisplay, rarityDisplay, itemIdShopDisplay, numitemDisplay);
        try {
            partitem.setAdapter(partitemAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        partitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mypagedialogitem();
                txtdong1.setText(DesnameDisplay.get(position));
                txtdong2.setText(DesnameDisplay.get(position));
                String kind = "";
                String str = itemIdShopDisplay.get(position);
                String name = "";
                String part = "";
                if (str.substring(0, 3).equals("100")) {
                    name = "kabutomushi";
                    kind = "カブトムシ";
                } else if (str.substring(0, 3).equals("101")) {
                    name = "caucasus";
                    kind = "コーカサスオオカブト";
                } else if (str.substring(0, 3).equals("102")) {
                    name = "satanas";
                    kind = "サタンオオカブト";
                } else if (str.substring(0, 3).equals("103")) {
                    name = "hercules";
                    kind = "ヘラクレスオオカブト";
                } else if (str.substring(0, 3).equals("110")) {
                    name = "kokuwagata";
                    kind = "コクワガタ";
                } else if (str.substring(0, 3).equals("111")) {
                    name = "oukuwagata";
                    kind = "オオクワガタ";
                } else if (str.substring(0, 3).equals("112")) {
                    name = "giraffa";
                    kind = "ギラファノコギリクワガタ";
                } else if (str.substring(0, 3).equals("113")) {
                    name = "golden";
                    kind = "オウゴンオニクワガタ";
                }
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
                int resID = context.getResources().getIdentifier("@drawable/" + pImg, "drawable", context.getPackageName());
                mpdialogitemicon.setImageResource(resID);
                txtdong3.setText("[" + kind + "]用パーツ\n" + "「そうび変更」画面でそうびできます。");
                int a = Integer.parseInt(str);
                for (int i = 0; i < Integer.parseInt(rarityDisplay.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(mypage.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        arrnumber = new ArrayList<String>();
        content = new ArrayList<String>();
        coinmp = new ArrayList<String>();
        jewelmp = new ArrayList<String>();
        star = new ArrayList<String>();
        fooddong2 = new ArrayList<String>();
        fooddong3 = new ArrayList<String>();
        arrnumberShow = new ArrayList<String>();
        contentShow = new ArrayList<String>();
        coinShow = new ArrayList<String>();
        jewelShow = new ArrayList<String>();
        starShow = new ArrayList<String>();
        fooddong2Show = new ArrayList<String>();
        fooddong3Show = new ArrayList<String>();
        img = new ArrayList<Integer>();
        imgShow = new ArrayList<Integer>();
        //
        contentItem = new ArrayList<String>();
        coinItem = new ArrayList<String>();
        jewelItem = new ArrayList<String>();
        fooddong2Item = new ArrayList<String>();
        fooddong3Item = new ArrayList<String>();
        starItem = new ArrayList<String>();
        arrnumberItem = new ArrayList<String>();
        contentItemShow = new ArrayList<String>();
        coinItemShow = new ArrayList<String>();
        jewelItemShow = new ArrayList<String>();
        fooddong2ItemShow = new ArrayList<String>();
        fooddong3ItemShow = new ArrayList<String>();
        starItemShow = new ArrayList<String>();
        arrnumberItemShow = new ArrayList<String>();
        imgItem = new ArrayList<Integer>();
        imgItemShow = new ArrayList<Integer>();
        //
        contentDrink = new ArrayList<String>();
        coinDrink = new ArrayList<String>();
        jewelDrink = new ArrayList<String>();
        fooddong2Drink = new ArrayList<String>();
        fooddong3Drink = new ArrayList<String>();
        starDrink = new ArrayList<String>();
        arrnumberDrink = new ArrayList<String>();
        contentDrinkShow = new ArrayList<String>();
        coinDrinkShow = new ArrayList<String>();
        jewelDrinkShow = new ArrayList<String>();
        fooddong2DrinkShow = new ArrayList<String>();
        fooddong3DrinkShow = new ArrayList<String>();
        starDrinkShow = new ArrayList<String>();
        arrnumberDrinkShow = new ArrayList<String>();
        imgDrink = new ArrayList<Integer>();
        imgDrinkShow = new ArrayList<Integer>();

        _idItem = new ArrayList<Integer>();
        _idItemShow = new ArrayList<Integer>();
        _idFood = new ArrayList<Integer>();
        _idFoodShow = new ArrayList<Integer>();
        _idDrink = new ArrayList<Integer>();
        _idDrinkShow = new ArrayList<Integer>();

        _idDrink.add(1);
        _idDrink.add(3);
        _idFood.add(1001);
        _idFood.add(1003);
        _idFood.add(1011);
        _idFood.add(1012);
        _idFood.add(1013);
        _idFood.add(1014);
        _idFood.add(1015);
        _idFood.add(1016);
        _idItem.add(3001);
        _idItem.add(3002);
        _idItem.add(3003);
        _idItem.add(3004);
        _idItem.add(3005);
        _idItem.add(3006);
        _idItem.add(3007);
        _idItem.add(3008);

        contentDrink.add("ミネラルウォーター[成虫／幼虫兼用]");
        contentDrink.add("スペシャルジュース[成虫／幼虫兼用]");
        jewelDrink.add("0");
        jewelDrink.add("0");
        coinDrink.add("10");
        coinDrink.add("30");
        starDrink.add("1");
        starDrink.add("2");
        arrnumberDrink.add("" + _DRINK);
        arrnumberDrink.add("" + _DRINKBIG);
        imgDrink.add(R.drawable.drink_icon);
        imgDrink.add(R.drawable.new_shop_icon_drink2);

        fooddong2Drink.add("富士山の雪解け水が濾過されたミネラルたっぷりな水。");
        fooddong2Drink.add("昆虫に必要な栄養素も含んだスペシャルドリンク");
        fooddong3Drink.add("[" + namesell + "]" + "に使用しますか？");
        fooddong3Drink.add("[" + namesell + "]" + "に使用しますか？");
        //
        imgItem.add(R.drawable.item_icon);
        imgItem.add(R.drawable.new_shop_icon_item2);
        imgItem.add(R.drawable.itm_liquor);
        imgItem.add(R.drawable.itm_runpa1);
        imgItem.add(R.drawable.itm_medicine1);
        imgItem.add(R.drawable.itm_medicine2);
        imgItem.add(R.drawable.itm_o2_capsule);
        imgItem.add(R.drawable.itm_gold_ticket);

        starItem.add("1");
        starItem.add("2");
        starItem.add("2");
        starItem.add("2");
        starItem.add("6");
        starItem.add("6");
        starItem.add("5");
        starItem.add("5");
        contentItem.add("成長促進剤2倍[幼虫用]");
        contentItem.add("成長促進剤10倍[幼虫用]");
        contentItem.add("鞆の浦の保命酒[ブリーダー用]");
        contentItem.add("お掃除ルンパ[幼虫用]");
        contentItem.add("若返りの薬[幼虫用]");
        contentItem.add("進化の薬[幼虫用]");
        contentItem.add("酸素カプセル[幼虫用]");
        contentItem.add("ゴールドガチャチケット");

        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        coinItem.add("0");
        jewelItem.add("0");
        jewelItem.add("0");
        jewelItem.add("0");
        jewelItem.add("2");
        jewelItem.add("5");
        jewelItem.add("5");
        jewelItem.add("3");
        jewelItem.add("1");
        arrnumberItem.add("" + _ITEM);
        arrnumberItem.add("" + _ITEMBIG);
        arrnumberItem.add("" + _FOODBIG6);
        arrnumberItem.add("" + _ITEMBIG2);
        arrnumberItem.add("" + _ITEMBIG3);
        arrnumberItem.add("" + _ITEMBIG4);
        arrnumberItem.add("" + _ITEMBIG5);
        arrnumberItem.add("" + _ITEMGOLD);
        fooddong2Item.add("成長を促すためのホルモン剤。1段階のみ有効。");
        fooddong2Item.add("10倍のスピードで成長。ぐぐっと成長する。１段階のみ有効。");
        fooddong2Item.add("広島県福山市鞆町名産の薬味酒。ブリーダーのスタミナが100%回復します。");
        fooddong2Item.add("お掃除がきらいな人に最適。");
        fooddong2Item.add("１段階前の発達フェーズに戻る");
        fooddong2Item.add("発達フェーズを次に進めることが出来る");
        fooddong2Item.add("幼虫のストレス解消にオススメ。");
        fooddong2Item.add("ゴールドガチャを一度回せるレアチケット");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("[" + pre.getString("nickname", "") + "]" + "に使用しますか？");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        fooddong3Item.add("飼育時に使用できます。");
        //
        img.add(R.drawable.food_icon);
        img.add(R.drawable.itm_rice4);
        img.add(R.drawable.itm_jelly1);
        img.add(R.drawable.itm_jelly2);
        img.add(R.drawable.itm_rice3);
        img.add(R.drawable.itm_rice2);
        img.add(R.drawable.itm_sap);
        img.add(R.drawable.itm_banana);

        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("[" + namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + namesell + "]" + "に使用しますか？");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("[" + namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + namesell + "]" + "に使用しますか？");
        fooddong2.add("カブトムシ／クワガタムシ幼虫のごはん。");
        fooddong2.add("マットごはんに改良を加えたスペシャルごはん。");
        fooddong2.add("一般的な昆虫ゼリー。成虫のHPが100回復します。");
        fooddong2.add("栄養満点の昆虫ゼリー。滋養強壮も良いため体づくりに最適。成虫のHPが300回復します。");
        fooddong2.add("広葉樹の発酵が進んだカブトムシ幼虫のごはん。");
        fooddong2.add("クワガタムシ幼虫のごはん。");
        fooddong2.add("成虫のえさ。カブトムシ、クワガタムシはこのにおいが大好き。成虫のHPが50%回復します。");
        fooddong2.add("成虫のえさ。野外でカブトムシ、クワガタムシを取るための必須アイテム。成虫のHPが100%回復します。");
        star.add("1");
        star.add("2");
        star.add("1");
        star.add("2");
        star.add("1");
        star.add("1");
        star.add("3");
        star.add("3");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("0");
        jewelmp.add("1");
        coinmp.add("10");
        coinmp.add("30");
        coinmp.add("10");
        coinmp.add("30");
        coinmp.add("30");
        coinmp.add("30");
        coinmp.add("0");
        coinmp.add("0");
        content.add("マットごはん[幼虫用]");
        content.add("マットごはんスペシャル[幼虫用]");
        content.add("昆虫ゼリー[成虫用]");
        content.add("スペシャルゼリー[成虫用]");
        content.add("腐葉土ごはん[幼虫用]");
        content.add("菌糸ごはん[幼虫用]");
        content.add("樹液[成虫用]");
        content.add("焼酎バナナ[成虫用]");
        String str1 = "" + _FOOD;
        String str2 = "" + _FOODBIG;
        String str3 = "" + _FOODBIG4;
        String str4 = "" + _FOODBIG5;
        String str5 = "" + _FOODBIG2;
        String str6 = "" + _FOODBIG3;
        String str7 = "" + _FOODBIG7;
        String str8 = "" + _FOODBIG8;
        arrnumber.add(str1);
        arrnumber.add(str2);
        arrnumber.add(str3);
        arrnumber.add(str4);
        arrnumber.add(str5);
        arrnumber.add(str6);
        arrnumber.add(str7);
        arrnumber.add(str8);
        for (int i = 0; i < arrnumber.size(); i++) {
            if (!arrnumber.get(i).equals("0")) {
                arrnumberShow.add(arrnumber.get(i));
                contentShow.add(content.get(i));
                coinShow.add(coinmp.get(i));
                jewelShow.add(jewelmp.get(i));
                fooddong2Show.add(fooddong2.get(i));
                fooddong3Show.add(fooddong3.get(i));
                starShow.add(star.get(i));
                imgShow.add(img.get(i));
                _idFoodShow.add(_idFood.get(i));
            }
        }
        adapterMono = new AdapterMono(this, contentShow, coinShow, jewelShow, starShow, arrnumberShow, imgShow, _idFoodShow);
        fooditem.setAdapter(adapterMono);
        fooditem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _item = 2;
                _pos = position;
                iddrink = _idFoodShow.get(position);
                mypagedialogitem();
                if (contentShow.get(position).equals("昆虫ゼリー[成虫用]") || contentShow.get(position).equals("スペシャルゼリー[成虫用]")
                        || contentShow.get(position).equals("樹液[成虫用]") || contentShow.get(position).equals("焼酎バナナ[成虫用]")) {
                    if (_checkpet == 1) {
                        btnok.setVisibility(View.GONE);
                        shop_yes.setVisibility(View.VISIBLE);
                        shop_no.setVisibility(View.VISIBLE);
                    }
                }
                txtdong1.setText(contentShow.get(position));
                txtdong2.setText(fooddong2Show.get(position));
                txtdong3.setText(fooddong3Show.get(position));
                mpdialogitemicon.setImageResource(imgShow.get(position));
                for (int i = 0; i < Integer.parseInt(starShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(mypage.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        itemitem = (ListView) dialogmochimono.findViewById(R.id.itemitem);
        for (int i = 0; i < arrnumberItem.size(); i++) {
            if (!arrnumberItem.get(i).equals("0")) {
                arrnumberItemShow.add(arrnumberItem.get(i));
                contentItemShow.add(contentItem.get(i));
                coinItemShow.add(coinItem.get(i));
                jewelItemShow.add(jewelItem.get(i));
                fooddong2ItemShow.add(fooddong2Item.get(i));
                fooddong3ItemShow.add(fooddong3Item.get(i));
                starItemShow.add(starItem.get(i));
                imgItemShow.add(imgItem.get(i));
                _idItemShow.add(_idItem.get(i));
            }
        }
        adapterMonoItem = new AdapterMono(this, contentItemShow, coinItemShow, jewelItemShow, starItemShow, arrnumberItemShow, imgItemShow, _idItemShow);
        itemitem.setAdapter(adapterMonoItem);
        itemitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _click = position;
                _item = 0;
                mypagedialogitem();
                if (contentItemShow.get(position).equals("鞆の浦の保命酒[ブリーダー用]")) {
                    shop_yes.setVisibility(View.VISIBLE);
                    shop_no.setVisibility(View.VISIBLE);
                    btnok.setVisibility(View.GONE);
                }
                txtdong1.setText(contentItemShow.get(position));
                txtdong2.setText(fooddong2ItemShow.get(position));
                txtdong3.setText(fooddong3ItemShow.get(position));
                mpdialogitemicon.setImageResource(imgItemShow.get(position));
                for (int i = 0; i < Integer.parseInt(starItemShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(mypage.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });

        for (int i = 0; i < arrnumberDrink.size(); i++) {
            if (!arrnumberDrink.get(i).equals("0")) {
                arrnumberDrinkShow.add(arrnumberDrink.get(i));
                contentDrinkShow.add(contentDrink.get(i));
                coinDrinkShow.add(coinDrink.get(i));
                jewelDrinkShow.add(jewelDrink.get(i));
                fooddong2DrinkShow.add(fooddong2Drink.get(i));
                fooddong3DrinkShow.add(fooddong3Drink.get(i));
                starDrinkShow.add(starDrink.get(i));
                imgDrinkShow.add(imgDrink.get(i));
                _idDrinkShow.add(_idDrink.get(i));
            }
        }
        adapterMonoDrink = new AdapterMono(this, contentDrinkShow, coinDrinkShow, jewelDrinkShow, starDrinkShow, arrnumberDrinkShow, imgDrinkShow, _idDrinkShow);
        drinkitem.setAdapter(adapterMonoDrink);
        drinkitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _item = 1;
                _pos = position;
                iddrink = _idDrinkShow.get(position);
                mypagedialogitem();
                if (_checkpet == 1) {
                    shop_yes.setVisibility(View.VISIBLE);
                    shop_no.setVisibility(View.VISIBLE);
                    btnok.setVisibility(View.GONE);
                }
                txtdong1.setText(contentDrinkShow.get(position));
                txtdong2.setText(fooddong2DrinkShow.get(position));
                txtdong3.setText(fooddong3DrinkShow.get(position));
                mpdialogitemicon.setImageResource(imgDrinkShow.get(position));
                for (int i = 0; i < Integer.parseInt(starDrinkShow.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(mypage.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        btncloselayoutitem = (Button) dialogmochimono.findViewById(R.id.btncloselayoutitem);
        ImageView dialogitemfood = (ImageView) dialogmochimono.findViewById(R.id.dialogitemfood);
        ImageView dialogitemdrink = (ImageView) dialogmochimono.findViewById(R.id.dialogitemdrink);
        ImageView dialogitemitem = (ImageView) dialogmochimono.findViewById(R.id.dialogitemitem);
        ImageView dialogitempart = (ImageView) dialogmochimono.findViewById(R.id.dialogitempart);
        dialogitempart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                HideLayoutItem();
                ShowPartItem();
            }
        });
        dialogitemfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                HideLayoutItem();
                ShowFoodItem();
            }
        });
        dialogitemdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                HideLayoutItem();
                ShowDrinkItem();
            }
        });
        dialogitemitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                HideLayoutItem();
                ShowItemItem();
            }
        });
        btncloselayoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (!flagBack) {
                    dialogmochimono.dismiss();
                } else if (flagBack) {
                    HideAllItem();
                    ShowLayoutItem();
                }
            }
        });
        dialogmochimono.show();
    }

    public void ShowPartItem() {
        partitem.setVisibility(View.VISIBLE);
    }

    String _uuid = "";

    private class GetinforUser extends AsyncTask<String, String, String> {
        int success;
        String CONTENT;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShowCustomDialog2();
        }

        protected String doInBackground(String... args) {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            String price = pre.getString("email", "");
            String description = pre.getString("pass", "");

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", price));
            params.add(new BasicNameValuePair("password", description));
            params.add(new BasicNameValuePair("act", "kkuser.getUser"));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);

            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                success = json.getInt(TAG_SUCCESS);
                // success = 0 : completed
                if (success == 0) {
                    try {
                        HttpClient httpClient = new DefaultHttpClient();
                        HttpGet get = new HttpGet(args[0]);
                        ResponseHandler<String> handler = new BasicResponseHandler();
                        CONTENT = httpClient.execute(get, handler);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            HideCustomDiaglog2();
            if (success == 0) {
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(CONTENT);
                    JSONObject object = jsonObject.getJSONObject("record");
                    int level = object.optInt("level") + 1;
                    int numCoins = object.optInt("numCoins");
                    int numJewels = object.optInt("numJewels");
                    String uuid = object.optString("uuid");
                    _uuid = uuid;
                    Log.e("uuid", "" + _uuid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (success == 2) {
            }
        }
    }

    String jsonStr = "";
    Dialog dialog_comingson;

    public void Dialog_ComingSon() {
        dialog_comingson = new Dialog(mypage.this);
        dialog_comingson.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_comingson.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog_comingson.setContentView(R.layout.comingson_layout);

        ImageView button17 = (ImageView) dialog_comingson.findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                dialog_comingson.dismiss();
            }
        });
        dialog_comingson.show();
    }

    public void DialogCreatePet() {
        final Dialog dialog = new Dialog(mypage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.createpet);
        Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
        Button btnno = (Button) dialog.findViewById(R.id.btnno);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                dialog.cancel();
                Create_Character();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void _ShowDialog() {
        final Dialog dialog = new Dialog(mypage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_menudetail);
        Button img = (Button) dialog.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                dialog.dismiss();
            }
        });

        TextView button = (TextView) dialog.findViewById(R.id.button);
        TextView button2 = (TextView) dialog.findViewById(R.id.button2);
        TextView button3 = (TextView) dialog.findViewById(R.id.button3);
        TextView button4 = (TextView) dialog.findViewById(R.id.button4);
        TextView button5 = (TextView) dialog.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(animScale);
                    Intent intent = new Intent(mypage.this, DesLevel.class);
                    intent.putExtra("flag", "mypage");
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(animScale);
                    Intent intent = new Intent(mypage.this, mypageMenu2.class);
                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(animScale);
                    Intent intent = new Intent(mypage.this, mypageMenu3.class);
                    startActivity(intent);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(animScale);
                    Intent intent = new Intent(mypage.this, mypageMenu4.class);
                    startActivity(intent);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(animScale);
                    Intent intent = new Intent(mypage.this, mypageMenu5.class);
                    startActivity(intent);
                }
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void CreateNewPet() {
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
        boolean dataonhanvat = true;
        long bornTime = System.currentTimeMillis() / 1000;
        editor.putLong("bornTime", bornTime);
        if (!dataonhanvat) {
            editor.putString("tenzukan", "");
        } else {
            editor.putBoolean("dataonhanvat", dataonhanvat);
            editor.putString("tenzukan", editText.getText().toString());
            editor.putString("tenhis", editText.getText().toString());
            editor.putString("id", stringID);
            editor.commit();
            db.adddatastt(getApplicationContext(), 1);
        }
        editor.commit();
        Intent intent = new Intent(mypage.this, story.class);
        startActivity(intent);
    }

    public void SaveTime() {
        SharedPreferences pre = getSharedPreferences
                (main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("ngaylast", Calendar.getInstance().get(Calendar.DATE));
        editor.putInt("thanglast", Calendar.getInstance().get(Calendar.MONTH) + 1);
        editor.putInt("namlast", Calendar.getInstance().get(Calendar.YEAR));
        editor.putInt("giolast", Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        editor.putInt("phutlast", Calendar.getInstance().get(Calendar.MINUTE));
        editor.commit();
    }

    int exp_next;

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        for (int i = 0; i < frmypage.getChildCount(); i++) {
            View view = frmypage.getChildAt(i);
            view.clearAnimation();
        }
        frmypage.removeAllViews();
        if (timer_anim != null) {
            timer_anim.cancel();
            timer_anim = null;
        }
        bsound = true;

        kind_temp.clear();
        hp_temp.clear();
        SaveTime();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
//        editor.putInt("3008", 3); test
        editor.putString("lan1", "lan1");
        editor.putInt("time_click", time_click);
        editor.putInt("pet1", 1);
        editor.putInt("kich1", 1);
        editor.putInt("rank", rank);
        if (_kich2 == 0)
            _kich2 = 1;
        editor.putInt("kich2", _kich2);
        editor.putInt("theluc", theluc);
        editor.putInt("exp", exp);
        editor.putInt("lv", Integer.parseInt(txtlv.getText().toString()));
        editor.putInt("money", Integer.parseInt(coin.getText().toString()));
        editor.putInt("jewel", Integer.parseInt(jewel.getText().toString()));
//        editor.putString("uuid", _uuid);
        editor.commit();
        try {
            if (soundbg.isPlaying())
                soundbg.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    int _FOOD, _FOODBIG, _FOODBIG2, _FOODBIG3, _FOODBIG4, _FOODBIG5, _FOODBIG6, _FOODBIG7, _FOODBIG8,
            _DRINK, _DRINKBIG, _ITEM, _ITEMBIG, _ITEMBIG2, _ITEMBIG3, _ITEMBIG4, _ITEMBIG5, _ITEMGOLD;

    public static float valueindicator;
    List<DuLieuShowPet> listDataShowpet;
    int _pet1, _kich1, _kich2, level_account, time_click;

    @Override
    protected void onResume() {
        super.onResume();
        if (zukan_main.timer_age1 != null) {
            zukan_main.timer_age1.cancel();
            zukan_main.timer_age1 = null;
        }
        if (Battle.timer != null) {
            Battle.timer.cancel();
            Battle.timer = null;
        }
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
//        root.startAnimation(anim_alpha);
        startTimer_anim();
        for (int i = 0; i < frmypage.getChildCount(); i++) {
            View view = frmypage.getChildAt(i);
            view.clearAnimation();
        }
        frmypage.removeAllViews();
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        level_account = pre.getInt("lv", 1);
        listDataStt = db.getAllDataStt();
        _listTablePart = db.getAllPart();
        bsound = false;
        if (mAdView != null) {
            mAdView.resume();
        }

        if (pre.getString("create", "").length() > 0) {
            editor.putString("create", "");
            editor.commit();
            Intent intent = new Intent(mypage.this, story.class);
            startActivity(intent);
        }
        time_click = pre.getInt("time_click", 0);
        rank = pre.getInt("rank", 0);
        txttitle.setText(_title[rank]);
        _pet1 = pre.getInt("pet1", 0);
        _kich1 = pre.getInt("kich1", 0);
        _kich2 = pre.getInt("kich2", 0);
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
        _ITEMGOLD = pre.getInt("03008", 0);
        _COUNTUONG = pre.getInt("_COUNTUONG", 400);
        _COUNTUONG2 = pre.getInt("_COUNTUONG2", 400);
        _COUNTUONG3 = pre.getInt("_COUNTUONG3", 400);
        _COUNTUONG4 = pre.getInt("_COUNTUONG4", 400);
        _COUNTUONG5 = pre.getInt("_COUNTUONG5", 400);
        _COUNTUONG6 = pre.getInt("_COUNTUONG6", 400);
        _COUNTUONG7 = pre.getInt("_COUNTUONG7", 400);
        _COUNTUONG8 = pre.getInt("_COUNTUONG8", 400);
        _COUNTAN = pre.getInt("_COUNTAN", 400);
        _COUNTAN2 = pre.getInt("_COUNTAN2", 400);
        _COUNTAN3 = pre.getInt("_COUNTAN3", 400);
        _COUNTAN4 = pre.getInt("_COUNTAN4", 400);
        _COUNTAN5 = pre.getInt("_COUNTAN5", 400);
        _COUNTAN6 = pre.getInt("_COUNTAN6", 400);
        _COUNTAN7 = pre.getInt("_COUNTAN7", 400);
        _COUNTAN8 = pre.getInt("_COUNTAN8", 400);
        _COUNTNHA = pre.getInt("_COUNTNHA", 800);
        _COUNTNHA2 = pre.getInt("_COUNTNHA2", 800);
        _COUNTNHA3 = pre.getInt("_COUNTNHA3", 800);
        _COUNTNHA4 = pre.getInt("_COUNTNHA4", 800);
        _COUNTNHA5 = pre.getInt("_COUNTNHA5", 800);
        _COUNTNHA6 = pre.getInt("_COUNTNHA6", 800);
        _COUNTNHA7 = pre.getInt("_COUNTNHA7", 800);
        _COUNTNHA8 = pre.getInt("_COUNTNHA8", 800);
        age = (int) pre.getFloat("age", 0);
        age2 = (int) pre.getFloat("age2", 0);
        age3 = (int) pre.getFloat("age3", 0);
        age4 = (int) pre.getFloat("age4", 0);
        age5 = (int) pre.getFloat("age5", 0);
        age6 = (int) pre.getFloat("age6", 0);
        age7 = (int) pre.getFloat("age7", 0);
        age8 = (int) pre.getFloat("age8", 0);
        giay = pre.getInt("giay", 0);
        giay2 = pre.getInt("giay2", 0);
        giay3 = pre.getInt("giay3", 0);
        giay4 = pre.getInt("giay4", 0);
        giay5 = pre.getInt("giay5", 0);
        giay6 = pre.getInt("giay6", 0);
        giay7 = pre.getInt("giay7", 0);
        giay8 = pre.getInt("giay8", 0);
        phut = pre.getInt("phut", 59);
        phut2 = pre.getInt("phut2", 59);
        phut3 = pre.getInt("phut3", 59);
        phut4 = pre.getInt("phut4", 59);
        phut5 = pre.getInt("phut5", 59);
        phut6 = pre.getInt("phut6", 59);
        phut7 = pre.getInt("phut7", 59);
        phut8 = pre.getInt("phut8", 59);
        gio = pre.getInt("gio", 23);
        gio3 = pre.getInt("gio3", 23);
        gio2 = pre.getInt("gio2", 23);
        gio4 = pre.getInt("gio4", 23);
        gio5 = pre.getInt("gio5", 23);
        gio6 = pre.getInt("gio6", 23);
        gio7 = pre.getInt("gio7", 23);
        gio8 = pre.getInt("gio8", 23);
        ngay = pre.getInt("ngay", 0);
        ngay2 = pre.getInt("ngay2", 0);
        ngay3 = pre.getInt("ngay3", 0);
        ngay4 = pre.getInt("ngay4", 0);
        ngay5 = pre.getInt("ngay5", 0);
        ngay6 = pre.getInt("ngay6", 0);
        ngay7 = pre.getInt("ngay7", 0);
        ngay8 = pre.getInt("ngay8", 0);
        phutup = pre.getInt("phutup", 0);
        phutup2 = pre.getInt("phutup2", 0);
        phutup3 = pre.getInt("phutup3", 0);
        phutup4 = pre.getInt("phutup4", 0);
        phutup5 = pre.getInt("phutup5", 0);
        phutup6 = pre.getInt("phutup6", 0);
        phutup7 = pre.getInt("phutup7", 0);
        phutup8 = pre.getInt("phutup8", 0);
        gioup = pre.getInt("gioup", 0);
        gioup2 = pre.getInt("gioup2", 0);
        gioup3 = pre.getInt("gioup3", 0);
        gioup4 = pre.getInt("gioup4", 0);
        gioup5 = pre.getInt("gioup5", 0);
        gioup6 = pre.getInt("gioup6", 0);
        gioup7 = pre.getInt("gioup7", 0);
        gioup8 = pre.getInt("gioup8", 0);
        ngayup = pre.getInt("ngayup", 0);
        ngayup2 = pre.getInt("ngayup2", 0);
        ngayup3 = pre.getInt("ngayup3", 0);
        ngayup4 = pre.getInt("ngayup4", 0);
        ngayup5 = pre.getInt("ngayup5", 0);
        ngayup6 = pre.getInt("ngayup6", 0);
        ngayup7 = pre.getInt("ngayup7", 0);
        ngayup8 = pre.getInt("ngayup8", 0);
        friendly = pre.getInt("friendly", 0);
        friendly2 = pre.getInt("friendly2", 0);
        friendly3 = pre.getInt("friendly3", 0);
        friendly4 = pre.getInt("friendly4", 0);
        friendly5 = pre.getInt("friendly5", 0);
        friendly6 = pre.getInt("friendly6", 0);
        friendly7 = pre.getInt("friendly7", 0);
        friendly8 = pre.getInt("friendly8", 0);
        exp = pre.getInt("exp", Chat.nextGoalExpAtLevel(level_account));

        temp = pre.getInt("nhietdo", 6);
        temp2 = pre.getInt("nhietdo2", 6);
        temp3 = pre.getInt("nhietdo3", 6);
        temp4 = pre.getInt("nhietdo4", 6);
        temp5 = pre.getInt("nhietdo5", 6);
        temp6 = pre.getInt("nhietdo6", 6);
        temp7 = pre.getInt("nhietdo7", 6);
        temp8 = pre.getInt("nhietdo8", 6);
        sleep = pre.getInt("sleep", 800);
        sleep2 = pre.getInt("sleep2", 800);
        sleep3 = pre.getInt("sleep3", 800);
        sleep4 = pre.getInt("sleep4", 800);
        sleep5 = pre.getInt("sleep5", 800);
        sleep6 = pre.getInt("sleep6", 800);
        sleep7 = pre.getInt("sleep7", 800);
        sleep8 = pre.getInt("sleep8", 800);
        useitem = pre.getInt("useitem", 0);
        useitem2 = pre.getInt("useitem2", 0);
        useitem3 = pre.getInt("useitem3", 0);
        useitem4 = pre.getInt("useitem4", 0);
        useitem5 = pre.getInt("useitem5", 0);
        useitem6 = pre.getInt("useitem6", 0);
        useitem7 = pre.getInt("useitem7", 0);
        useitem8 = pre.getInt("useitem8", 0);
        //
        health = pre.getInt("health", 800);
        health2 = pre.getInt("health2", 800);
        health3 = pre.getInt("health3", 800);
        health4 = pre.getInt("health4", 800);
        health5 = pre.getInt("health5", 800);
        health6 = pre.getInt("health6", 800);
        health7 = pre.getInt("health7", 800);
        health8 = pre.getInt("health8", 800);
        mood = pre.getInt("mood", 800);
        mood2 = pre.getInt("mood2", 800);
        mood3 = pre.getInt("mood3", 800);
        mood4 = pre.getInt("mood4", 800);
        mood5 = pre.getInt("mood5", 800);
        mood6 = pre.getInt("mood6", 800);
        mood7 = pre.getInt("mood7", 800);
        mood8 = pre.getInt("mood8", 800);
        //
        p = pre.getInt("p", 4);
        p2 = pre.getInt("p2", 4);
        p3 = pre.getInt("p3", 4);
        p4 = pre.getInt("p4", 4);
        p5 = pre.getInt("p5", 4);
        p6 = pre.getInt("p6", 4);
        p7 = pre.getInt("p7", 4);
        p8 = pre.getInt("p8", 4);
        //
        s = pre.getInt("g", 59);
        s2 = pre.getInt("g2", 59);
        s3 = pre.getInt("g3", 59);
        s4 = pre.getInt("g4", 59);
        s5 = pre.getInt("g5", 59);
        s6 = pre.getInt("g6", 59);
        s7 = pre.getInt("g7", 59);
        s8 = pre.getInt("g8", 59);
        //
        ngu = pre.getInt("ngu", 1);
        ngu2 = pre.getInt("ngu2", 1);
        ngu3 = pre.getInt("ngu3", 1);
        ngu4 = pre.getInt("ngu4", 1);
        ngu5 = pre.getInt("ngu5", 1);
        ngu6 = pre.getInt("ngu6", 1);
        ngu7 = pre.getInt("ngu7", 1);
        ngu8 = pre.getInt("ngu8", 1);
        //
        daitien = pre.getInt("daitien", 0);
        daitien2 = pre.getInt("daitien2", 0);
        daitien3 = pre.getInt("daitien3", 0);
        daitien4 = pre.getInt("daitien4", 0);
        daitien5 = pre.getInt("daitien5", 0);
        daitien6 = pre.getInt("daitien6", 0);
        daitien7 = pre.getInt("daitien7", 0);
        daitien8 = pre.getInt("daitien8", 0);
        //
        tieutien = pre.getInt("tieutien", 0);
        tieutien2 = pre.getInt("tieutien2", 0);
        tieutien3 = pre.getInt("tieutien3", 0);
        tieutien4 = pre.getInt("tieutien4", 0);
        tieutien5 = pre.getInt("tieutien5", 0);
        tieutien6 = pre.getInt("tieutien6", 0);
        tieutien7 = pre.getInt("tieutien7", 0);
        tieutien8 = pre.getInt("tieutien8", 0);
        //
        form = pre.getInt("form", 0);
        form2 = pre.getInt("form2", 0);
        form3 = pre.getInt("form3", 0);
        form4 = pre.getInt("form4", 0);
        form5 = pre.getInt("form5", 0);
        form6 = pre.getInt("form6", 0);
        form7 = pre.getInt("form7", 0);
        form8 = pre.getInt("form8", 0);
        //
        personality = pre.getInt("personality", 0);
        personality2 = pre.getInt("personality2", 0);
        personality3 = pre.getInt("personality3", 0);
        personality4 = pre.getInt("personality4", 0);
        personality5 = pre.getInt("personality5", 0);
        personality6 = pre.getInt("personality6", 0);
        personality7 = pre.getInt("personality7", 0);
        personality8 = pre.getInt("personality8", 0);
        //
        strength = pre.getInt("strength", 0);
        strength2 = pre.getInt("strength2", 0);
        strength3 = pre.getInt("strength3", 0);
        strength4 = pre.getInt("strength4", 0);
        strength5 = pre.getInt("strength5", 0);
        strength6 = pre.getInt("strength6", 0);
        strength7 = pre.getInt("strength7", 0);
        strength8 = pre.getInt("strength8", 0);
        //
        size = pre.getInt("size", 3000);
        size2 = pre.getInt("size2", 0);
        size3 = pre.getInt("size3", 0);
        size4 = pre.getInt("size4", 0);
        size5 = pre.getInt("size5", 0);
        size6 = pre.getInt("size6", 0);
        size7 = pre.getInt("size7", 0);
        size8 = pre.getInt("size8", 0);
        //
        lastCleanTime = pre.getLong("lastCleanTime", 0);
        lastCleanTime2 = pre.getLong("lastCleanTime2", 0);
        lastCleanTime3 = pre.getLong("lastCleanTime3", 0);
        lastCleanTime4 = pre.getLong("lastCleanTime4", 0);
        lastCleanTime5 = pre.getLong("lastCleanTime5", 0);
        lastCleanTime6 = pre.getLong("lastCleanTime6", 0);
        lastCleanTime7 = pre.getLong("lastCleanTime7", 0);
        lastCleanTime8 = pre.getLong("lastCleanTime8", 0);

        runpaStartTime = pre.getLong("runpaStartTime", 0);
        runpaStartTime2 = pre.getLong("runpaStartTime2", 0);
        runpaStartTime3 = pre.getLong("runpaStartTime3", 0);
        runpaStartTime4 = pre.getLong("runpaStartTime4", 0);
        runpaStartTime5 = pre.getLong("runpaStartTime5", 0);
        runpaStartTime6 = pre.getLong("runpaStartTime6", 0);
        runpaStartTime7 = pre.getLong("runpaStartTime7", 0);
        runpaStartTime8 = pre.getLong("runpaStartTime8", 0);

        txtlv.setText("" + level_account);
        if (layoutLevel != null)
            layoutLevel.removeAllViews();
        int sizelv = 12;
        if (_Width <= 480)
            sizelv = 9;
        DrawLevel(layoutLevel, level_account, sizelv);
        String _nickname = pre.getString("nickname", "");
        int smoney = pre.getInt("money", 0);
        int sjewel = pre.getInt("jewel", 0);
        String yourFormattedString = formatter.format(smoney);
        formatcoin.setText(yourFormattedString);
        formatjewel.setText(formatter.format(sjewel));
        nickname.setText("" + _nickname);
        coin.setText("" + smoney);
        jewel.setText("" + sjewel);
//        int trc = Integer.parseInt(txtlv.getText().toString()) * 10;
        int sau = Integer.parseInt(txtlv.getText().toString()) * 10;
        progressBar3.setMax(sau);
        progressBar3.setProgress(theluc);
        txtphantram.setText("" + theluc + "/" + sau);

//        }
        int lv_cur = Integer.parseInt(txtlv.getText().toString());
//        kn = Chat.nextGoalExpAtLevel(Integer.parseInt(txtlv.getText().toString()));
//        int prelv = Integer.parseInt(txtlv.getText().toString()) - 1;
        kn = Chat.nextGoalExpAtLevel(lv_cur);
        int prelv = lv_cur - 1;
        kn2 = Chat.nextGoalExpAtLevel(prelv);
        int expuplv = kn - kn2;
        int expcurrent = pre.getInt("exp", Chat.nextGoalExpAtLevel(level_account)) - kn2;
        valueindicator = (float) expcurrent / expuplv;
        indicator.setValue(valueindicator);
        if (exp_next <= exp) {
            for (int i = 1; i > 0; i++) {
                if (Chat.nextGoalExpAtLevel(i) > exp) {
                    level_account = i;
                    txtlv.setText("" + level_account);
                    break;
                }
            }
//            editor.putInt("exp", exp);
//            editor.commit();
            if (new Random().nextInt(10) == 0) {
                rank++;
                if (rank >= _title.length)
                    rank = _title.length - 1;
            }
            txttitle.setText(_title[rank]);
            showdialog();
//            int cap = (int) (exp / kn);
            int bonusCoins = (Integer.parseInt(txtlv.getText().toString()) + 1) * 100;
            int bonusJewels = (Integer.parseInt(txtlv.getText().toString()) + 1) / 10;
            int tien = bonusCoins + Integer.parseInt(coin.getText().toString());
            int kimcuong = bonusJewels + Integer.parseInt(jewel.getText().toString());
            coin.setText("" + tien);
            jewel.setText("" + kimcuong);
            formatcoin.setText("" + formatter.format(tien));
            formatjewel.setText("" + formatter.format(kimcuong));
            //
            int b = Integer.parseInt(txtlv.getText().toString());
            theluc = b * 10;
            if (level_account >= 10 && level_account < 30 && pre.getInt("level10", 0) == 0) {
                gold_ticker = 1;
                int a = pre.getInt("03008", 0) + gold_ticker;
                editor.putInt("03008", a);
                editor.putInt("level10", 1);
                editor.commit();
                db.update_Sumpart(3008, a);
                bonus_goldticker();
            } else if (level_account >= 30 && level_account < 50 && pre.getInt("level30", 0) == 0) {
                gold_ticker = 3;
                int a = pre.getInt("03008", 0) + gold_ticker;
                editor.putInt("03008", a);
                editor.putInt("level30", 1);
                editor.commit();
                db.update_Sumpart(3008, a);
                bonus_goldticker();
            } else if (level_account >= 50 && level_account < 70 && pre.getInt("level50", 0) == 0) {
                gold_ticker = 5;
                int a = pre.getInt("03008", 0) + gold_ticker;
                editor.putInt("03008", a);
                editor.putInt("level50", 1);
                editor.commit();
                db.update_Sumpart(3008, a);
                bonus_goldticker();
            } else if (level_account >= 70 && level_account < 99 && pre.getInt("level70", 0) == 0) {
                gold_ticker = 7;
                int a = pre.getInt("03008", 0) + gold_ticker;
                editor.putInt("03008", a);
                editor.putInt("level70", 1);
                editor.commit();
                db.update_Sumpart(3008, a);
                bonus_goldticker();
            } else if (level_account >= 99 && pre.getInt("level99", 0) == 0) {
                gold_ticker = 10;
                int a = pre.getInt("03008", 0) + gold_ticker;
                editor.putInt("03008", a);
                editor.putInt("level99", 1);
                editor.commit();
                db.update_Sumpart(3008, a);
                bonus_goldticker();
            }
//            Toast.makeText(getApplicationContext(), "theluc:" + theluc, Toast.LENGTH_SHORT).show();
//            Log.e("theluc", "" + theluc);
            txtphantram.setText("" + theluc + "/" + theluc);
            progressBar3.setMax(theluc);
            progressBar3.setProgress(theluc);
            int _lvNext2 = Integer.parseInt(txtlv.getText().toString());
            exp_next = Chat.nextGoalExpAtLevel(_lvNext2);
            if (layoutLevel != null)
                layoutLevel.removeAllViews();
            String strup = "" + b;
            int sizelv2 = 12;
            if (_Width <= 480)
                sizelv2 = 9;
            DrawLevel(layoutLevel, b, sizelv2);
            kn = Chat.nextGoalExpAtLevel(Integer.parseInt(txtlv.getText().toString()));
            int prelv2 = Integer.parseInt(txtlv.getText().toString()) - 1;
            kn2 = Chat.nextGoalExpAtLevel(prelv2);
            int expuplv2 = kn - kn2;
            int expcurrent2 = pre.getInt("exp", Chat.nextGoalExpAtLevel(level_account)) - kn2;

            float valueindicator2 = (float) expcurrent2 / expuplv2;
            indicator.setValue(valueindicator2);
            tienbonus.setText("+ " + formatter.format(bonusCoins));
            kimcuongbonus.setText("+ " + formatter.format(bonusJewels));
            mediaPlayer.start();
            _ITEMGOLD = pre.getInt("03008", 0);
        }
        cd = new ConnectionDetector(getApplicationContext());
        if (!cd.isConnectingToInternet()) {
            ErrorNetwork();
        } else if (cd.isConnectingToInternet()) {
            new syncdata().execute();
        }
        try {
            if (pre.getBoolean("sound", true) == true)
                soundbg.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listPetLogin = db.getPetTruongThanh();
        listDataShowpet = db.getAllShowpet();
        if (listPetLogin.size() > 0 && listDataShowpet.size() < 1) {
            showpetlogin();
            _checkpet = 1;
        } else if (listDataShowpet.size() >= 1 && listPetLogin.size() > 0) {
            showpetwhenstart();
            _checkpet = 1;
            if (_kich2 == 1) {
                _kich2 = 5;
                _dialogNotify();
                txtcontent_dialogNotify.setText("おお！我が子が育ったようだな！\n君の森「マイページ」では３匹まで成虫の面倒を見ることができるぞ！\n３匹以上育てた場合には、成虫を入れ替えてみんなの面倒を見てくれ！");
            }
        }
        if (pre.getString("lan1", "").length() == 0) {
            _dialogNotify();
            txtcontent_dialogNotify.setText("おはよう！\nここが君の昆虫が住む森だ！\nさっそく我が子を育ててもらうぞ！\n下の「飼育」ボタンを押してくれ！\n育てた成虫はリングや修羅の森で対戦ができるようになるぞ！\n強い子に育ててくれよな！");
        }
        editor.putString("gotomypage", "");
        editor.commit();
    }

    int gold_ticker;

    public void RestoreTime() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        theluc = pre.getInt("theluc", pre.getInt("lv", 1) * 10);
        int ngay = pre.getInt("ngaylast", 0);
        int thang = pre.getInt("thanglast", 0);
        int nam = pre.getInt("namlast", 0);
        int gio = pre.getInt("giolast", 0);
        int phut = pre.getInt("phutlast", 0);
        int a = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int b = Calendar.getInstance().get(Calendar.MINUTE);
        int c = Calendar.getInstance().get(Calendar.DATE);
        int d = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int e = Calendar.getInstance().get(Calendar.YEAR);
        int checktime = (a * 60 + b + c * 24 * 60 + d * 30 * 24 * 60 + e * 12 * 30 * 24 * 60) - (gio * 60 + phut + ngay * 24 * 60 + thang * 30 * 24 * 60 + nam * 12 * 30 * 24 * 60);
        theluc += checktime;
        if (theluc > pre.getInt("lv", 1) * 10) {
            theluc = pre.getInt("lv", 1) * 10;
        }
//        txtphantram.setText("" + theluc + "/" + pre.getInt("lv", 1) * 10);
    }

    TextView tienbonus, kimcuongbonus;

    public void bonus_goldticker() {
        final Dialog dialog = new Dialog(mypage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_gold_ticket);
        ImageView imgok = (ImageView) dialog.findViewById(R.id.imgok);
        TextView imgtitle = (TextView) dialog.findViewById(R.id.imgtitle);
        imgok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        imgtitle.setText("ゴールドガチャ券 x " + gold_ticker + " GET!");
        dialog.show();
//        new Thread() {
//            int i;
//
//            @Override
//            public void run() {
//                for (i = 0; i <= 5; i++) {
//                    try {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (i == 5) {
//                                    dialog.dismiss();
//                                }
//                            }
//                        });
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//
//                    }
//                }
//            }
//        }.start();
    }

    public void showdialog() {
        final Dialog dialog = new Dialog(mypage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.levelup);
        tienbonus = (TextView) dialog.findViewById(R.id.tienbonus);
        kimcuongbonus = (TextView) dialog.findViewById(R.id.kimcuongbonus);
        dialog.show();
        new Thread() {
            int i;

            @Override
            public void run() {
                for (i = 0; i <= 5; i++) {
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 5) {
                                    dialog.dismiss();
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

    //sync data
    JSONParser jsonParser = new JSONParser();

    private class syncdata extends AsyncTask<String, String, String> {
        int success;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShowCustomDialog();
        }

        protected String doInBackground(String... args) {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            String name = pre.getString("nickname", "");
            String mail = pre.getString("email", "");
            String pass = pre.getString("pass", "");
            int l = pre.getInt("lv", 1) - 1;
            String level = "" + l;
            String _rank = "" + rank;
            int e = pre.getInt("exp", Chat.nextGoalExpAtLevel(pre.getInt("lv", 1)));
            String exp = "" + e;
            int m = l * 10;
            String maxHp = "" + m;
            int c = pre.getInt("theluc", pre.getInt("lv", 1) * 10);
            String curHp = "" + c;
            int nc = pre.getInt("money", 0);
            String numCoins = "" + nc;
            int nj = pre.getInt("jewel", 0);
            String numJewels = "" + nj;
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("email", mail));
            params.add(new BasicNameValuePair("password", pass));

            params.add(new BasicNameValuePair("act", "kkuser.regUser"));
            params.add(new BasicNameValuePair("level", level));
            params.add(new BasicNameValuePair("rank", _rank));
            params.add(new BasicNameValuePair("exp", exp));
            params.add(new BasicNameValuePair("curHp", curHp));
            params.add(new BasicNameValuePair("maxHp", maxHp));
            params.add(new BasicNameValuePair("numCoins", numCoins));
            params.add(new BasicNameValuePair("numJewels", numJewels));

            params.add(new BasicNameValuePair("uuid", pre.getString("uuid", "")));
//            params.add(new BasicNameValuePair("curDate", ""));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);

            Log.d("Create Response", json.toString());

            try {
                success = json.getInt(TAG_SUCCESS);
                // success = 0 : completed
                if (success == 0) {
                    // successfully created

                } else if (success == 2) {
                    Log.e("result", "sucess =2");
                } else if (success == 3) {
                    Log.e("result", "sucess =3");
                } else {
                    Log.e("result", "else");
                }
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String file_url) {
            new syncitem().execute();
        }
    }

    private class syncitem extends AsyncTask<String, String, String> {
        int success;

        @Override
        protected String doInBackground(String... params) {
            String Strjson = "";
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            try {
                JSONObject json = new JSONObject();
                for (int i = 0; i < _listTablePart.size(); i++) {
                    String key = "" + _listTablePart.get(i).getName();
                    if (key.length() == 1)
                        key = "0000" + key;
                    else if (key.length() == 2)
                        key = "000" + key;
                    else if (key.length() == 3)
                        key = "00" + key;
                    else if (key.length() == 4)
                        key = "0" + key;
                    if (_listTablePart.get(i).getSum() > 0)
                        json.put(key, _listTablePart.get(i).getSum());
                }
                Strjson = json.toString();
//                Log.e("JSON", "Strjson:" + Strjson);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<NameValuePair> params2 = new ArrayList<NameValuePair>();
            params2.add(new BasicNameValuePair("act", "kkuserItem.regItem"));
            params2.add(new BasicNameValuePair("uuid", pre.getString("uuid", "")));
            params2.add(new BasicNameValuePair("jsonStr", Strjson));
            params2.add(new BasicNameValuePair("curDate", ""));
            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params2);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);
                if (success == 0) {
                    // successfully created
                }
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            new SyncPet().execute();
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
    public void onBackPressed() {

        try {
            if (main_intro.mediaPlayer.isPlaying())
                main_intro.mediaPlayer.pause();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
//        finish();
    }

    AdapterMono adapterMono, adapterMonoItem, adapterMonoDrink;
    private ItemArrayAdapter partitemAdapter;
    LinearLayout layoutitem;
    ListView fooditem, itemitem, drinkitem, partitem;
    Animation animation;
    Button btncloselayoutitem;
    ImageView mpdialogitemicon;
    boolean flagBack = false;

    public void HideLayoutItem() {
        flagBack = true;
        layoutitem.setVisibility(View.GONE);
        btncloselayoutitem.setBackgroundResource(R.drawable.btn_back);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowLayoutItem() {
        flagBack = false;
//        btncloselayoutitem.setBackgroundResource(R.drawable.btn_close);
//        animation.setDuration(500);
        layoutitem.setVisibility(View.VISIBLE);
//        layoutitem.setAnimation(animation);
//        layoutitem.animate();
//        animation.start();
    }

    public void ShowFoodItem() {
        fooditem.setVisibility(View.VISIBLE);
    }

    public void ShowDrinkItem() {
        drinkitem.setVisibility(View.VISIBLE);
    }

    public void ShowItemItem() {
        itemitem.setVisibility(View.VISIBLE);
    }

    public void HideAllItem() {
        fooditem.setVisibility(View.GONE);
        drinkitem.setVisibility(View.GONE);
        itemitem.setVisibility(View.GONE);
        partitem.setVisibility(View.GONE);
    }

    TextView txtdong1, txtdong2, txtdong3;
    ImageView shop_yes, shop_no, btnok;
    int _item = 0, iddrink, _pos;

    public void mypagedialogitem() {
        mpdialogitem = new Dialog(mypage.this);
        mpdialogitem.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mpdialogitem.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mpdialogitem.setCanceledOnTouchOutside(false);
        mpdialogitem.setContentView(R.layout.mypagedialogitem);
        txtdong1 = (TextView) mpdialogitem.findViewById(R.id.txttitle);
        txtdong2 = (TextView) mpdialogitem.findViewById(R.id.txtcontent);
        txtdong3 = (TextView) mpdialogitem.findViewById(R.id.txtbottom);
        shop_yes = (ImageView) mpdialogitem.findViewById(R.id.shop_yes);
        shop_no = (ImageView) mpdialogitem.findViewById(R.id.shop_no);
        lnstar = (LinearLayout) mpdialogitem.findViewById(R.id.lnstar);
        btnok = (ImageView) mpdialogitem.findViewById(R.id.btnok);
        mpdialogitemicon = (ImageView) mpdialogitem.findViewById(R.id.mpdialogitemicon);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpdialogitem.dismiss();
            }
        });
        shop_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                if (pre.getBoolean("soundaction", true) && bsound == false)
                    kSECommand.start();
                int value = 0;
                String kkey = "";
                if (_item == 0) {
                    theluc = level_account * 10;
                    editor.putInt("theluc", theluc);
                    progressBar3.setProgress(theluc);
                    txtphantram.setText("" + theluc + "/" + theluc);
                    _FOODBIG6--;
                    String _a = "" + _FOODBIG6;
                    arrnumberItemShow.set(_click, _a);
                    if (Integer.parseInt(_a) == 0) {
                        arrnumberItemShow.remove(_click);
                        contentItemShow.remove(_click);
                        coinItemShow.remove(_click);
                        jewelItemShow.remove(_click);
                        fooddong2ItemShow.remove(_click);
                        fooddong3ItemShow.remove(_click);
                        starItemShow.remove(_click);
                        imgItemShow.remove(_click);
                        _idItemShow.remove(_click);
                    }
                    adapterMonoItem.notifyDataSetChanged();
                    String key = "" + _idItemShow.get(_click);
                    if (key.length() == 1)
                        key = "0000" + key;
                    else if (key.length() == 2)
                        key = "000" + key;
                    else if (key.length() == 3)
                        key = "00" + key;
                    else if (key.length() == 4)
                        key = "0" + key;
                    editor.putInt(key, _FOODBIG6);
                    long k = Long.parseLong(key);
                    db.update_Sumpart(k, _FOODBIG6);
                } else if (_item == 1) {
                    kkey = "" + iddrink;
                    if (iddrink == 1) {
                        _hp += 25;
                        _DRINK--;
                        value = _DRINK;
                    } else if (iddrink == 3) {
                        _hp += 50;
                        _DRINKBIG--;
                        value = _DRINKBIG;
                    }
                    if (_hp > pl_hp)
                        _hp = pl_hp;
                    txtHp.setText(_hp + "/" + pl_hp);
                    prhp.setProgress(_hp);
                    db.update_Sumpart(iddrink, value);
                    double _curHP = _hp * 100 / pl_hp;
                    for (int i = 0; i < kind_temp.size(); i++) {
                        if (kind_temp.get(i).equals(loaisale)) {
                            hp_temp.set(i, _curHP);
                            ratio_hp = hp_temp.get(i);
                        }
                    }
                    db.update_hp(idpetsell, _curHP);
                    editor.putInt(kkey, value);
                    editor.commit();
                    String vv = "" + value;
                    arrnumberDrinkShow.set(_pos, vv);
                    if (Integer.parseInt(vv) == 0) {
                        arrnumberDrinkShow.remove(_pos);
                        contentDrinkShow.remove(_pos);
                        coinDrinkShow.remove(_pos);
                        jewelDrinkShow.remove(_pos);
                        fooddong2DrinkShow.remove(_pos);
                        fooddong3DrinkShow.remove(_pos);
                        starDrinkShow.remove(_pos);
                        imgDrinkShow.remove(_pos);
                        _idDrinkShow.remove(_pos);
                    }
                    adapterMonoDrink.notifyDataSetChanged();
                } else if (_item == 2) {
                    kkey = "" + iddrink;
                    if (iddrink == 1011) {
                        _hp += 100;
                        _FOODBIG4--;
                        value = _FOODBIG4;
                    } else if (iddrink == 1012) {
                        _hp += 300;
                        _FOODBIG5--;
                        value = _FOODBIG5;
                    } else if (iddrink == 1015) {
                        _hp += pl_hp / 2;
                        _FOODBIG7--;
                        value = _FOODBIG7;
                    } else if (iddrink == 1016) {
                        _hp = pl_hp;
                        _FOODBIG8--;
                        value = _FOODBIG8;
                    }
                    if (_hp > pl_hp)
                        _hp = pl_hp;
                    txtHp.setText(_hp + "/" + pl_hp);
                    prhp.setProgress(_hp);
                    db.update_Sumpart(iddrink, value);
                    double a = _hp * 100 / pl_hp;
                    for (int i = 0; i < kind_temp.size(); i++) {
                        if (kind_temp.get(i).equals(loaisale)) {
                            hp_temp.set(i, a);
                            ratio_hp = hp_temp.get(i);
                        }
                    }
                    db.update_hp(idpetsell, a);
                    if (kkey.length() == 1)
                        kkey = "0000" + kkey;
                    else if (kkey.length() == 2)
                        kkey = "000" + kkey;
                    else if (kkey.length() == 3)
                        kkey = "00" + kkey;
                    else if (kkey.length() == 4)
                        kkey = "0" + kkey;
                    editor.putInt(kkey, value);
                    editor.commit();
                    String vv = "" + value;
                    arrnumberShow.set(_pos, vv);
                    if (Integer.parseInt(vv) == 0) {
                        arrnumberShow.remove(_pos);
                        contentShow.remove(_pos);
                        coinShow.remove(_pos);
                        jewelShow.remove(_pos);
                        fooddong2Show.remove(_pos);
                        fooddong3Show.remove(_pos);
                        starShow.remove(_pos);
                        imgShow.remove(_pos);
                        _idFoodShow.remove(_pos);
                    }
                    adapterMono.notifyDataSetChanged();
                }
                mpdialogitem.dismiss();
            }
        });
        shop_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpdialogitem.dismiss();
            }
        });
        mpdialogitem.show();
    }

    int _click;
    TextView txtyesbutton;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(mypage.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
        txtyesbutton.setText("この機能はただいま準備中です。しばらくお待ち下さい。");
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

    public double calcRank(int size, int health, int mood, int form, int strength, int personality) {
        double percent;
        percent = (double) (health + mood + form + strength + personality) / 5.0 / 10.0;
        if (size > 7000)
            percent += (size - 7000.0) / 10.0;
        int rank = (int) (percent / 10.0);
        if (rank >= 10)
            rank = 10 - 1;
        if (rank < 0)
            rank = 0;
        return rank;
    }

    public void getJsonStringPet() {
        listDulieu = db.getAll();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        _uuid = pre.getString("uuid", "");
        try {
            JSONObject json = new JSONObject();
            JSONObject valueJson = new JSONObject();
            JSONArray valuesarray = new JSONArray();
            JSONArray valuesarray2 = new JSONArray();

            for (int i = 0; i < listDulieu.size(); i++) {
                // Create values jsonObject
                JSONObject valuesJson = new JSONObject();
                JSONObject valuesJson2 = new JSONObject();
                String hasSold = "";
                int sale = listDulieu.get(i).getSale();
                if (sale == 1)
                    hasSold = "true";
                else if (sale != 1)
                    hasSold = "false";
                valuesJson.put("hasSold", hasSold);
                valuesJson.put("friend", listDulieu.get(i).getNuoi());
                valuesJson.put("personality", listDulieu.get(i).getPersonality());
                valuesJson.put("excreteS", listDulieu.get(i).getExcreteS());
                int rank = (int) calcRank(listDulieu.get(i).getSize(), listDulieu.get(i).getHealth(), listDulieu.get(i).getMood(),
                        listDulieu.get(i).getForm(), listDulieu.get(i).getStrength(), listDulieu.get(i).getPersonality());
                valuesJson.put("rank", rank);
                valuesJson.put("satiety", listDulieu.get(i).getSatiety());
                valuesJson.put("nowSleeping", "false");
                valuesJson.put("sleepingETime", 0);
                String albino = "";
                int abn = listDulieu.get(i).getMat();
                if (abn == 0)
                    albino = "false";
                else if (abn == 1)
                    albino = "true";
                valuesJson.put("albino", albino);
                valuesJson.put("sex", "0");
                valuesJson.put("sleep", listDulieu.get(i).getSleep());
                valuesJson.put("phaseETime", listDulieu.get(i).getPhaseETime());
                valuesJson.put("strength", listDulieu.get(i).getStrength());
                int phase = (int) listDulieu.get(i).getTuoi() + 1;
                valuesJson.put("phase", phase);
                valuesJson.put("bornTime", listDulieu.get(i).getBornTime());
                String subKind = listDulieu.get(i).getLoai();
                if (subKind.equals("loai1"))
                    subKind = "0";
                else if (subKind.equals("loai2"))
                    subKind = "1000";
                else if (subKind.equals("loai3"))
                    subKind = "1";
                else if (subKind.equals("loai4"))
                    subKind = "1001";
                else if (subKind.equals("loai5"))
                    subKind = "2";
                else if (subKind.equals("loai6"))
                    subKind = "1002";
                else if (subKind.equals("loai7"))
                    subKind = "1003";
                else if (subKind.equals("loai8"))
                    subKind = "3";
                valuesJson.put("subKind", subKind);
                valuesJson.put("parID", 0);
                valuesJson.put("excreteB", listDulieu.get(i).getExcreteB());
                valuesJson.put("form", listDulieu.get(i).getForm());
                valuesJson.put("breederID", pre.getString("uuid", ""));
                valuesJson.put("phaseTime", listDulieu.get(i).getPhaseTime());
                String alive = "";
                int live = listDulieu.get(i).getLive();
                if (live == 1)
                    alive = "false";
                else if (live != 1)
                    alive = "true";
                valuesJson.put("alive", "true");
                valuesJson.put("kind", 0);
                valuesJson.put("color", 0);
                valuesJson.put("size", listDulieu.get(i).getSize());
                valuesJson.put("moisture", listDulieu.get(i).getMoisture());
                valuesJson.put("health", listDulieu.get(i).getHealth());
                valuesJson.put("age", 5);
                int life = listDulieu.get(i).getLive();
                if (life == 1)
                    life = 0;
                else if (life != 1)
                    life = Integer.parseInt(listDulieu.get(i).getTien());
                valuesJson.put("life", life);
                valuesJson.put("nowBreeding", "false");
                valuesJson.put("mood", listDulieu.get(i).getMood());
                valuesJson.put("timeSpeedIndex", 0);
                valuesJson.put("nickname", listDulieu.get(i).getContent());
                valuesJson.put("beetleID", listDulieu.get(i).getBeetleID());
                if (listDulieu.get(i).getLive() == 2) {
                    valuesJson.put("imagoDropPartsIndex", "0");
                    int horn = listDulieu.get(i).getHornNo();
                    int head = listDulieu.get(i).getHeadNo();
                    int face = listDulieu.get(i).getFaceNo();
                    int neck = listDulieu.get(i).getNeckNo();
                    int wing = listDulieu.get(i).getWingNo();
                    int body = listDulieu.get(i).getBodyNo();
                    if (horn >= 7) horn = 10;
                    if (head >= 7) head = 10;
                    if (body >= 7) body = 10;
                    if (face >= 5) face = 10;
                    if (wing >= 4) wing = 10;
                    if (listDulieu.get(i).getLoai().equals("loai1") || listDulieu.get(i).getLoai().equals("loai5") ||
                            listDulieu.get(i).getLoai().equals("loai7") || listDulieu.get(i).getLoai().equals("loai8")) {
                        if (neck >= 3)
                            neck = 10;
                    }
                    if (listDulieu.get(i).getLoai().equals("loai2") || listDulieu.get(i).getLoai().equals("loai4")
                            || listDulieu.get(i).getLoai().equals("loai6")) {
                        if (neck >= 2)
                            neck = 10;
                    }
                    if (listDulieu.get(i).getLoai().equals("loai3")) {
                        if (neck >= 4)
                            neck = 10;
                    }
                    int _putLevel = listDulieu.get(i).getLevel() - 1;
                    valuesJson.put("imagoLevel", _putLevel);
                    valuesJson.put("imagoHornRank", horn);
                    valuesJson.put("imagoHeadRank", head);
                    valuesJson.put("imagoFaceRank", face);
                    valuesJson.put("imagoNeckRank", neck);
                    valuesJson.put("imagoWingRank", wing);
                    valuesJson.put("imagoBodyRank", body);
                    if (listDulieu.get(i).getLoai().equals("loai3") || listDulieu.get(i).getLoai().equals("loai5") ||
                            listDulieu.get(i).getLoai().equals("loai8")) {
                        int horn2 = listDulieu.get(i).getHorn2No();
                        if (horn2 > 7) horn2 = 10;
                        valuesJson.put("imagoHorn2Rank", horn2);
                    } else {
                        valuesJson.put("imagoHorn2Rank", "-1");
                    }
                    valuesJson.put("imagoCurExpAtCurLevel", listDulieu.get(i).getExp());
                    valuesJson.put("imagoNumRingTotalBattles", listDulieu.get(i).getFightsum());
                    valuesJson.put("imagoNumRingWinBattles", listDulieu.get(i).getFightwin());
                    valuesJson.put("imagoCurHpPercent", listDulieu.get(i).getHp());
                }
                //
                valuesJson2.put("runpaStartTime", listDulieu.get(i).getRunpaStartTime());
                valuesJson2.put("lastCleanTime", listDulieu.get(i).getLastCleanTime());
                valuesJson2.put("clearn", listDulieu.get(i).getClearn());
                valuesJson2.put("cageID", 0);
                valuesJson2.put("beetleID", listDulieu.get(i).getBeetleID());
                valuesJson2.put("temperatureIndex", 0);
                valuesarray.put(valuesJson);
                valuesarray2.put(valuesJson2);
            }
            valueJson.put("petInfos", valuesarray);
            valueJson.put("cageInfos", valuesarray2);
            jsonStrSyncPet = valueJson.toString();
//            Log.e("jsonStrSyncPet", "jsonStrSyncPet:" + jsonStrSyncPet);
//            json.put("petInfos", valuesarray);
//            Toast.makeText(getApplicationContext(), "json:" + valueJson.toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String jsonStrSyncPet = "";

    private class SyncPet extends AsyncTask<String, String, String> {
        int success;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... args) {
            getJsonStringPet();

//            Log.e("JSON", "" + jsonStrSyncPet);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("act", "kkuserPet.regPet"));
            params.add(new BasicNameValuePair("uuid", _uuid));
            params.add(new BasicNameValuePair("jsonStr", jsonStrSyncPet));
            params.add(new BasicNameValuePair("curDate", ""));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);
            try {
                success = json.getInt(TAG_SUCCESS);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (success == 0)
                HideCustomDiaglog();
        }
    }

    Context context = this;
    Dialog d_sellpet;
    TextView txtnamesell, txtpricesell, txtpriceformat;
    ImageView btnno, btnyes;
    ImageView canhsell, hornsell, dausell, bodysell, necksell, facesell, horn2sell;
    List<DuLieu> listDulieu, listPetLogin;
    int idpetsell, nuoi, mat, hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, sale, live,
            wingNosale, neckNosale, bodyNosale, salesale, livesale,
            _excreteSsale, _satietysale, _sleepsale, _excreteBsale, _moisturesale,
            _healthsale, _mood, clearn, _attack, _criticalAttack, _defense, _critical, _avoid, _lucky, _speed, id_pet_show;
    float tuoi, tuoisale;
    long _phaseETime, _bornTime, _phaseTime, _lastCleanTime;
    String Name, Hang, Tien, Tiensale, loai, beetleID;
    public static String namesell, loaisale, hangsell;
    public static int _hp, _fightWin, _exp, _level, _fightSum, _life, _strengthsale, _formsale,
            _sizesale, nuoisale, personalitysale, _checkpet = 0, rank, faceNosale, headNosale, horn2Nosale, hornNosale, matsale;
    public static double ratio_hp;

    public class ViewAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public ViewAdapter() {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return listPetLogin.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return getCount();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.custompetlogin, null);
            }
            Name = listPetLogin.get(position).getContent();
            Hang = listPetLogin.get(position).getHang();
            Tien = listPetLogin.get(position).getTien();
            loai = listPetLogin.get(position).getLoai();
            live = listPetLogin.get(position).getLive();
            sale = listPetLogin.get(position).getSale();
            tuoi = listPetLogin.get(position).getTuoi();
            nuoi = listPetLogin.get(position).getNuoi();
            mat = listPetLogin.get(position).getMat();
            hornNo = listPetLogin.get(position).getHornNo();
            if (hornNo > 7)
                hornNo = 7;
            horn2No = listPetLogin.get(position).getHorn2No();
            if (horn2No > 7)
                horn2No = 7;
            wingNo = listPetLogin.get(position).getWingNo();
            headNo = listPetLogin.get(position).getHeadNo();
            if (headNo > 7)
                headNo = 7;
            neckNo = listPetLogin.get(position).getNeckNo();
            faceNo = listPetLogin.get(position).getFaceNo();
            bodyNo = listPetLogin.get(position).getBodyNo();
            if (bodyNo > 7)
                bodyNo = 7;
            //
            FrameLayout frhorn = (FrameLayout) convertView.findViewById(R.id.horn);
            FrameLayout frhorn2 = (FrameLayout) convertView.findViewById(R.id.horn2);
            FrameLayout frdau = (FrameLayout) convertView.findViewById(R.id.dau);
            FrameLayout frbody = (FrameLayout) convertView.findViewById(R.id.body);
            FrameLayout frcanh = (FrameLayout) convertView.findViewById(R.id.canh);
            FrameLayout frco = (FrameLayout) convertView.findViewById(R.id.co);
            FrameLayout frmat = (FrameLayout) convertView.findViewById(R.id.mat);
            final ImageView setbg = (ImageView) convertView.findViewById(R.id.setbg);
            LinearLayout rootbg = (LinearLayout) convertView.findViewById(R.id.rootbg);
            TextView petloginlv = (TextView) convertView.findViewById(R.id.petloginlv);
            final TextView petloginname = (TextView) convertView.findViewById(R.id.petloginname);
            final CheckBox chbx = (CheckBox) convertView.findViewById(R.id.chbx);

            chbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        check++;
                        if (pet_shown == 0 && listDataShowpet.size() > 0) {
                            if (check > listDataShowpet.size()) {
                                pet_shown = 1;
                                check = listDataShowpet.size();
                                return;
//                                Log.e("CHECK", "ShowCheck:" + check + "  pet_shown:" + pet_shown);
                            }
                        }
//                        Log.e("CHECK", "check++:" + check);
                        setbg.setVisibility(View.VISIBLE);
                        arrtemp.add(position);
                        if (arrtemp.size() > 3) {
                            View view = gridView.getChildAt(arrtemp.get(0));
                            CheckBox chk = (CheckBox) view.findViewById(R.id.chbx);
                            chk.setChecked(false);
                            arrtemp.remove(0);
                        }
                    } else {
                        check--;
//                        Log.e("CHECK", "check--" + check);
                        setbg.setVisibility(View.GONE);
                        if (checkclick == 1) {
                            for (int i = 0; i < arrtemp.size(); i++) {
                                if (position == arrtemp.get(i))
                                    arrtemp.remove(i);
                            }
                            checkclick = 0;
                        }
                    }
                    if (check > 3)
                        check = 3;
                    else if (check < 0)
                        check = 0;
                }
            });
            if (listDataShowpet.size() > 0) {
//                if (check > listDataShowpet.size())
//                    check = listDataShowpet.size();
//                Log.e("CHECK", "ShowCheck:" + check);
                for (int i = 0; i < listDataShowpet.size(); i++) {
                    if (position == listDataShowpet.get(i).getPos()) {
                        chbx.setChecked(true);
//                        Log.e("pos", "pos:" + position);
                    }
                }
            }
//            int a = 0;
//            if (a == 0 && listDataShowpet.size() > 0) {
//                a = 1;
//                if (check > listDataShowpet.size())
//                    check = listDataShowpet.size();
//                Log.e("CHECK","ShowCheck:"+check);
//            }
            petloginlv.setText("Lv." + listPetLogin.get(position).getLevel());
            petloginname.setText("" + Name);
            rootbg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (chbx.isChecked()) {
                        checkclick = 1;
                        chbx.setChecked(false);
                    } else {
                        chbx.setChecked(true);
                    }
                }
            });
            //
            if (loai.equals("loai1") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (faceNo > 5)
                    faceNo = 5;
                if (neckNo > 3)
                    neckNo = 3;
                frdau.setBackgroundResource(Chat.head[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body[bodyNo]);
                frco.setBackgroundResource(Chat.neck[neckNo]);
                frhorn.setBackgroundResource(Chat.horn[hornNo]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0000_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face[faceNo]);
            } else if (loai.equals("loai2") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 2)
                    neckNo = 2;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head2[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing2[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body2[bodyNo]);
                frco.setBackgroundResource(Chat.neck2[neckNo]);
                frhorn.setBackgroundResource(Chat.horn2[hornNo]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0100_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face2[faceNo]);
            } else if (loai.equals("loai3") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 4)
                    neckNo = 4;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head3[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing3[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body3[bodyNo]);
                frco.setBackgroundResource(Chat.neck3[neckNo]);
                frhorn.setBackgroundResource(Chat.horn3[hornNo]);
                frhorn2.setBackgroundResource(Chat.horn33[horn2No]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0001_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face3[faceNo]);
            } else if (loai.equals("loai4") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 2)
                    neckNo = 2;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head4[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing4[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body4[bodyNo]);
                frco.setBackgroundResource(Chat.neck4[neckNo]);
                frhorn.setBackgroundResource(Chat.horn4[hornNo]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0101_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face4[faceNo]);
            } else if (loai.equals("loai5") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 3)
                    neckNo = 3;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head5[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing5[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body5[bodyNo]);
                frco.setBackgroundResource(Chat.neck5[neckNo]);
                frhorn.setBackgroundResource(Chat.horn5[hornNo]);
                frhorn2.setBackgroundResource(Chat.horn55[horn2No]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0002_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face5[faceNo]);
            } else if (loai.equals("loai6") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 2)
                    neckNo = 2;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head6[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing6[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body6[bodyNo]);
                frco.setBackgroundResource(Chat.neck6[neckNo]);
                frhorn.setBackgroundResource(Chat.horn6[hornNo]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0102_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face6[faceNo]);
            } else if (loai.equals("loai7") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 3)
                    neckNo = 3;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head7[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing7[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body7[bodyNo]);
                frco.setBackgroundResource(Chat.neck7[neckNo]);
                frhorn.setBackgroundResource(Chat.horn7[hornNo]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0103_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face7[faceNo]);
            } else if (loai.equals("loai8") && tuoi >= 5) {
                if (wingNo > 4)
                    wingNo = 4;
                if (neckNo > 3)
                    neckNo = 3;
                if (faceNo > 5)
                    faceNo = 5;
                frdau.setBackgroundResource(Chat.head8[headNo]);
                if (wingNo > 0)
                    frcanh.setBackgroundResource(Chat.wing8[wingNo - 1]);
                frbody.setBackgroundResource(Chat.body8[bodyNo]);
                frco.setBackgroundResource(Chat.neck8[neckNo]);
                frhorn.setBackgroundResource(Chat.horn8[hornNo]);
                frhorn2.setBackgroundResource(Chat.horn88[horn2No]);
                if (mat == 1)
                    frmat.setBackgroundResource(R.drawable.face_0003_10);
                else if (mat == 0)
                    frmat.setBackgroundResource(Chat.face8[faceNo]);
            }
            return convertView;
        }
    }

    ImageView headchoose, neckchoose, bodychoose, hornchoose, horn2choose, wingchoose, facechoose;
    Dialog dialogchoosepet;
    TextView dialogname, dialogkind, lvpet, exppet, hppet;

    public void Dialog_choosepet() {
        dialogchoosepet = new Dialog(mypage.this);
        dialogchoosepet.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogchoosepet.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogchoosepet.setCanceledOnTouchOutside(false);
        dialogchoosepet.setContentView(R.layout.choosepetmypage);
        dialogchoosepet.getWindow().setLayout(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        headchoose = (ImageView) dialogchoosepet.findViewById(R.id.head);
        neckchoose = (ImageView) dialogchoosepet.findViewById(R.id.neck);
        bodychoose = (ImageView) dialogchoosepet.findViewById(R.id.body);
        hornchoose = (ImageView) dialogchoosepet.findViewById(R.id.horn);
        horn2choose = (ImageView) dialogchoosepet.findViewById(R.id.horn2);
        wingchoose = (ImageView) dialogchoosepet.findViewById(R.id.wing);
        facechoose = (ImageView) dialogchoosepet.findViewById(R.id.face);
        dialogname = (TextView) dialogchoosepet.findViewById(R.id.dialogname);
        dialogkind = (TextView) dialogchoosepet.findViewById(R.id.dialogkind);
        lvpet = (TextView) dialogchoosepet.findViewById(R.id.lvpet);
        exppet = (TextView) dialogchoosepet.findViewById(R.id.exppet);
        hppet = (TextView) dialogchoosepet.findViewById(R.id.hppet);
        dialogname.setText(namesell);
        dialogkind.setText(hangsell);
        lvpet.setText("Lv.     " + _level);
        exppet.setText("EXP   " + _exp + "/ " + Sum_Exp);
        hppet.setText("HP     " + _hp + "/ " + pl_hp);
        ImageView ft_button1 = (ImageView) dialogchoosepet.findViewById(R.id.ft_button1);
        ImageView ft_button2 = (ImageView) dialogchoosepet.findViewById(R.id.ft_button2);
        ImageView ft_button3 = (ImageView) dialogchoosepet.findViewById(R.id.ft_button3);
        FrameLayout frdismiss = (FrameLayout) dialogchoosepet.findViewById(R.id.dissmiss);
        frdismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogchoosepet.dismiss();
            }
        });
        ft_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogchoosepet.dismiss();
                Intent i = new Intent(mypage.this, FittingRoom.class);
                i.putExtra("loaisale", loaisale);
                i.putExtra("wingNosale", wingNosale);
                i.putExtra("faceNosale", faceNosale);
                i.putExtra("neckNosale", neckNosale);
                i.putExtra("matsale", matsale);
                i.putExtra("bodyNosale", bodyNosale);
                i.putExtra("horn2Nosale", horn2Nosale);
                i.putExtra("hornNosale", hornNosale);
                i.putExtra("headNosale", headNosale);
                i.putExtra("namesell", namesell);
                i.putExtra("_hp", _hp);
                i.putExtra("_attack", _attack);
                i.putExtra("_criticalAttack", _criticalAttack);
                i.putExtra("_defense", _defense);
                i.putExtra("_critical", _critical);
                i.putExtra("_avoid", _avoid);
                i.putExtra("_lucky", _lucky);
                i.putExtra("_speed", _speed);
                i.putExtra("_level", _level);
                i.putExtra("_exp", _exp);
                i.putExtra("idpetsell", idpetsell);
                startActivity(i);
            }
        });
        ft_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                mpchoosepeteat();
            }
        });
        ft_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpetlogin();
            }
        });
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            headchoose.setImageResource(Chat.head[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body[bodyNosale]);
            neckchoose.setImageResource(Chat.neck[neckNosale]);
            hornchoose.setImageResource(Chat.horn[hornNosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0000_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face[faceNosale]);
        } else if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head2[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing2[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body2[bodyNosale]);
            neckchoose.setImageResource(Chat.neck2[neckNosale]);
            hornchoose.setImageResource(Chat.horn2[hornNosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0100_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face2[faceNosale]);
        } else if (loaisale.equals("loai3")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 4)
                neckNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head3[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing3[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body3[bodyNosale]);
            neckchoose.setImageResource(Chat.neck3[neckNosale]);
            hornchoose.setImageResource(Chat.horn3[hornNosale]);
            horn2choose.setImageResource(Chat.horn33[horn2Nosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0001_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face3[faceNosale]);
        } else if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head4[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing4[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body4[bodyNosale]);
            neckchoose.setImageResource(Chat.neck4[neckNosale]);
            hornchoose.setImageResource(Chat.horn4[hornNosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0101_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face4[faceNosale]);
        } else if (loaisale.equals("loai5")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head5[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing5[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body5[bodyNosale]);
            neckchoose.setImageResource(Chat.neck5[neckNosale]);
            hornchoose.setImageResource(Chat.horn5[hornNosale]);
            horn2choose.setImageResource(Chat.horn55[horn2Nosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0002_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face5[faceNosale]);
        } else if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head6[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing6[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body6[bodyNosale]);
            neckchoose.setImageResource(Chat.neck6[neckNosale]);
            hornchoose.setImageResource(Chat.horn6[hornNosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0102_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face6[faceNosale]);
        } else if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head7[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing7[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body7[bodyNosale]);
            neckchoose.setImageResource(Chat.neck7[neckNosale]);
            hornchoose.setImageResource(Chat.horn7[hornNosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0103_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face7[faceNosale]);
        } else if (loaisale.equals("loai8")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            headchoose.setImageResource(Chat.head8[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing8[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body8[bodyNosale]);
            neckchoose.setImageResource(Chat.neck8[neckNosale]);
            hornchoose.setImageResource(Chat.horn8[hornNosale]);
            horn2choose.setImageResource(Chat.horn88[horn2Nosale]);
            if (matsale == 1)
                facechoose.setImageResource(R.drawable.face_0003_10);
            else if (matsale == 0)
                facechoose.setImageResource(Chat.face8[faceNosale]);
        }
        dialogchoosepet.show();
    }

    int pet_shown = 0;
    Dialog mpchoosepeteat;
    TextView choosecontent;
    ListView listchooseeat;
    AdapterMono adapterChoosepetEat;

    public void mpchoosepeteat() {
        mpchoosepeteat = new Dialog(mypage.this);
        mpchoosepeteat.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mpchoosepeteat.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mpchoosepeteat.setContentView(R.layout.mpchoosepeteat);
        mpchoosepeteat.setCanceledOnTouchOutside(false);
        Button btnclose = (Button) mpchoosepeteat.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpchoosepeteat.dismiss();
            }
        });
        choosecontent = (TextView) mpchoosepeteat.findViewById(R.id.choosecontent);
        choosecontent.setText("[" + namesell + "]に使ってあげてね！");
        listchooseeat = (ListView) mpchoosepeteat.findViewById(R.id.listchooseeat);
        ArrayList<String> detail = new ArrayList<String>();
        final ArrayList<Integer> _c = new ArrayList<Integer>();
        _c.add(1);
        _c.add(3);
        _c.add(1011);
        _c.add(1012);
        _c.add(1015);
        _c.add(1016);
        detail.add("富士山の雪解け水が濾過されたミネラルたっぷりな水。");
        detail.add("昆虫に必要な栄養素も含んだスペシャルドリンク");
        detail.add("一般的な昆虫ゼリー。成虫のHPが100回復します。");
        detail.add("栄養満点の昆虫ゼリー。滋養強壮も良いため体づくりに最適。" +
                "成虫のHPが300回復します。");
        detail.add("成虫のえさ。カブトムシ、クワガタムシはこのにおいが大好き。成虫のHPが50%回復します。");
        detail.add("成虫のえさ。野外でカブトムシ、クワガタムシを取るための必須アイテム。成虫のHPが100%回復します。");
        ArrayList<String> content = new ArrayList<String>();
        content.add("ミネラルウオーター[成虫／幼虫兼用]");
        content.add("スペシャルジュース[成虫／幼虫兼用]");
        content.add("昆虫ゼリー [成虫用]");
        content.add("スペシャルゼリー[成虫用]");
        content.add("樹液[成虫用]");
        content.add("焼酎バナナ[成虫用]");
        ArrayList<String> coin = new ArrayList<String>();
        coin.add("10");
        coin.add("30");
        coin.add("10");
        coin.add("30");
        coin.add("0");
        coin.add("0");
        ArrayList<String> jewel = new ArrayList<String>();
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("1");
        ArrayList<String> star = new ArrayList<String>();
        star.add("1");
        star.add("2");
        star.add("1");
        star.add("2");
        star.add("3");
        star.add("3");
        ArrayList<String> number = new ArrayList<String>();
        number.add("" + _DRINK);
        number.add("" + _DRINKBIG);
        number.add("" + _FOODBIG4);
        number.add("" + _FOODBIG5);
        number.add("" + _FOODBIG7);
        number.add("" + _FOODBIG8);
        ArrayList<Integer> img = new ArrayList<Integer>();
        img.add(R.drawable.drink_icon);
        img.add(R.drawable.new_shop_icon_drink2);
        img.add(R.drawable.itm_jelly1);
        img.add(R.drawable.itm_jelly2);
        img.add(R.drawable.itm_sap);
        img.add(R.drawable.itm_banana);
        final ArrayList<String> detail2 = new ArrayList<String>();
        final ArrayList<String> content2 = new ArrayList<String>();
        final ArrayList<Integer> _c2 = new ArrayList<Integer>();
        ArrayList<String> coin2 = new ArrayList<String>();
        ArrayList<String> jewel2 = new ArrayList<String>();
        final ArrayList<String> star2 = new ArrayList<String>();
        final ArrayList<String> number2 = new ArrayList<String>();
        final ArrayList<Integer> img2 = new ArrayList<Integer>();
        for (int i = 0; i < number.size(); i++) {
            int a = Integer.parseInt(number.get(i));
            if (a > 0) {
                content2.add(content.get(i));
                coin2.add(coin.get(i));
                jewel2.add(jewel.get(i));
                star2.add(star.get(i));
                number2.add(number.get(i));
                img2.add(img.get(i));
                detail2.add(detail.get(i));
                _c2.add(_c.get(i));
            }
        }
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        adapterChoosepetEat = new AdapterMono(this, content2, coin2, jewel2, star2, number2, img2, _c2);
        listchooseeat.setAdapter(adapterChoosepetEat);
        listchooseeat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Dialog mpinfor = new Dialog(mypage.this);
                mpinfor.requestWindowFeature(Window.FEATURE_NO_TITLE);
                mpinfor.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));
                mpinfor.setCanceledOnTouchOutside(false);
                mpinfor.setContentView(R.layout.mpchooseinfo);
                ImageView imgno = (ImageView) mpinfor.findViewById(R.id.btnno);
                ImageView imgyes = (ImageView) mpinfor.findViewById(R.id.btnyes);
                mpicon = (ImageView) mpinfor.findViewById(R.id.mpicon);
                mptitle = (TextView) mpinfor.findViewById(R.id.mptitle);
                mpcontent = (TextView) mpinfor.findViewById(R.id.mpcontent);
                mpuse = (TextView) mpinfor.findViewById(R.id.mpuse);
                mpstar = (LinearLayout) mpinfor.findViewById(R.id.mpstar);

                imgno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mpinfor.dismiss();
                    }
                });
                imgyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (pre.getBoolean("soundaction", true) && bsound == false)
                            kSECommand.start();
                        int key = _c2.get(position);
                        int value = 0;
                        String k = "" + key;
                        if (key == 1) {
                            _hp += 25;
                            _DRINK--;
                            value = _DRINK;
                        } else if (key == 3) {
                            _hp += 50;
                            _DRINKBIG--;
                            value = _DRINKBIG;
                        } else if (key == 1011) {
                            _hp += 100;
                            _FOODBIG4--;
                            value = _FOODBIG4;
                        } else if (key == 1012) {
                            _hp += 300;
                            _FOODBIG5--;
                            value = _FOODBIG5;
                        } else if (key == 1015) {
                            _hp += pl_hp / 2;
                            _FOODBIG7--;
                            value = _FOODBIG7;
                        } else if (key == 1016) {
                            _hp = pl_hp;
                            _FOODBIG8--;
                            value = _FOODBIG8;
                        }
                        if (_hp > pl_hp)
                            _hp = pl_hp;
                        hppet.setText("HP     " + _hp + "/ " + pl_hp);
                        txtHp.setText(_hp + "/" + pl_hp);
                        prhp.setProgress(_hp);
                        db.update_Sumpart(key, value);
                        double a = _hp * 100 / pl_hp;
                        for (int i = 0; i < kind_temp.size(); i++) {
                            if (kind_temp.get(i).equals(loaisale)) {
                                hp_temp.set(i, a);
                                ratio_hp = hp_temp.get(i);
                            }
                        }
                        db.update_hp(idpetsell, a);
                        editor.putInt(k, value);
                        editor.commit();
                        String vv = "" + value;
                        number2.set(position, vv);
                        adapterChoosepetEat.notifyDataSetChanged();
                        mpinfor.dismiss();
                    }
                });
                mpinfor.show();

                mptitle.setText(content2.get(position));
                mpcontent.setText(detail2.get(position));
                mpicon.setImageResource(img2.get(position));
                mpuse.setText("[" + namesell + "]に使用しますか？");
                for (int i = 0; i < Integer.parseInt(star2.get(position)); i++) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
                    params.setMargins(3, 0, 0, 0);
                    TextView t = new TextView(mypage.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    mpstar.addView(t);
                }
            }
        });
        mpchoosepeteat.show();
    }

    ImageView mpicon;
    TextView mptitle, mpcontent, mpuse;
    LinearLayout mpstar;
    Animation jump_anim;

    public void showpetwhenstart() {
        listPetLogin = db.getPetTruongThanh();
        listDataShowpet = db.getAllShowpet();
        gviewoncreate = (GridView) findViewById(R.id.gviewoncreate);
        try {
            gviewoncreate.setAdapter(new ViewAdapter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 0; j < listDataShowpet.size(); j++) {
            int pos = listDataShowpet.get(j).getPos();
            id_pet_show = listDataShowpet.get(j).getIdpet();
            for (int i = gviewoncreate.getCount() - 1; i >= 0; i--) {
                if (i == pos) {
                    _setNewValue(i);
//                    int size_screen = 200;
//                    int size_pet = 150;
                    int size_screen = (int) Chat.convertDpToPixel(100);
                    int size_pet = (int) Chat.convertDpToPixel(75);
                    if (_Width <= 480) {
                        size_screen = (int) Chat.convertDpToPixel(80);
                        size_pet = (int) Chat.convertDpToPixel(60);
                    }
                    FrameLayout.LayoutParams paramsroot = null;
                    if (_Width >= 720) {
                        paramsroot = new FrameLayout.LayoutParams(size_screen, size_screen);
                        int a = new Random().nextInt(3);
                        if (a == 1) {
                            int l = new Random().nextInt(size_screen) + 100;
                            int t = new Random().nextInt(size_screen) + size_screen;
                            int r = new Random().nextInt(100);
                            int b = new Random().nextInt(100);
                            paramsroot.setMargins(l, t, r, b);
                        } else if (a == 2) {
                            int l = new Random().nextInt(size_screen) + size_screen;
                            int t = new Random().nextInt(size_screen) + 300;
                            int r = new Random().nextInt(150);
                            int b = new Random().nextInt(size_screen);
                            paramsroot.setMargins(l, t, r, b);
                        } else if (a == 0) {
                            int l = new Random().nextInt(size_screen) + 150;
                            int t = new Random().nextInt(size_screen) + 400;
                            int r = new Random().nextInt(size_screen);
                            int b = new Random().nextInt(size_screen);
                            paramsroot.setMargins(l, t, r, b);
                        }
                    } else if (_Width < 720) {
                        paramsroot = new FrameLayout.LayoutParams(size_screen, size_screen);
                        int a = new Random().nextInt(3);
                        if (a == 1) {
                            int l = new Random().nextInt(size_screen) + 50;
                            int t = new Random().nextInt(size_screen) + size_screen;
                            int r = new Random().nextInt(50);
                            int b = new Random().nextInt(50);
                            paramsroot.setMargins(l, t, r, b);
                        } else if (a == 2) {
                            int l = new Random().nextInt(size_screen) + size_screen;
                            int t = new Random().nextInt(size_screen) + 150;
                            int r = new Random().nextInt(100);
                            int b = new Random().nextInt(size_screen);
                            paramsroot.setMargins(l, t, r, b);
                        } else if (a == 0) {
                            int l = new Random().nextInt(size_screen) + 100;
                            int t = new Random().nextInt(size_screen) + 200;
                            int r = new Random().nextInt(size_screen);
                            int b = new Random().nextInt(size_screen);
                            paramsroot.setMargins(l, t, r, b);
                        }
                    }
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size_pet, size_pet);
                    params.gravity = Gravity.CENTER;
                    final FrameLayout root = new FrameLayout(mypage.this);
                    root.setLayoutParams(paramsroot);

                    ImageView hornsell = new ImageView(mypage.this);
                    ImageView horn2sell = new ImageView(mypage.this);
                    ImageView dausell = new ImageView(mypage.this);
                    final ImageView bodysell = new ImageView(mypage.this);
                    ImageView necksell = new ImageView(mypage.this);
                    ImageView canhsell = new ImageView(mypage.this);
                    ImageView facesell = new ImageView(mypage.this);
                    ImageView shadow = new ImageView(mypage.this);
                    ImageView effect = new ImageView(mypage.this);

                    hornsell.setAdjustViewBounds(true);
                    horn2sell.setAdjustViewBounds(true);
                    dausell.setAdjustViewBounds(true);
                    bodysell.setAdjustViewBounds(true);
                    necksell.setAdjustViewBounds(true);
                    canhsell.setAdjustViewBounds(true);
                    facesell.setAdjustViewBounds(true);
                    shadow.setAdjustViewBounds(true);
                    effect.setAdjustViewBounds(true);

                    shadow.setLayoutParams(params);
                    hornsell.setLayoutParams(params);
                    horn2sell.setLayoutParams(params);
                    dausell.setLayoutParams(params);
                    bodysell.setLayoutParams(params);
                    necksell.setLayoutParams(params);
                    canhsell.setLayoutParams(params);
                    facesell.setLayoutParams(params);
                    FrameLayout.LayoutParams params_effect = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT);
                    params.gravity = Gravity.CENTER;
                    effect.setLayoutParams(params_effect);

                    shadow.setImageResource(R.drawable.imago_shadow);
                    if (loaisale.equals("loai1") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        dausell.setImageResource(Chat.head[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body[bodyNosale]);
                        necksell.setImageResource(Chat.neck[neckNosale]);
                        hornsell.setImageResource(Chat.horn[hornNosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0000_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face[faceNosale]);
                        Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.1f);
                        shadow.setScaleY(1.1f);
                    } else if (loaisale.equals("loai2") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head2[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing2[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body2[bodyNosale]);
                        necksell.setImageResource(Chat.neck2[neckNosale]);
                        hornsell.setImageResource(Chat.horn2[hornNosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0100_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face2[faceNosale]);
                    } else if (loaisale.equals("loai3") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 4)
                            neckNosale = 4;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head3[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing3[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body3[bodyNosale]);
                        necksell.setImageResource(Chat.neck3[neckNosale]);
                        hornsell.setImageResource(Chat.horn3[hornNosale]);
                        horn2sell.setImageResource(Chat.horn33[horn2Nosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0001_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face3[faceNosale]);
                        Chat._setScale(1.3f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.3f);
                        shadow.setScaleY(1.3f);
                    } else if (loaisale.equals("loai4") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head4[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing4[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body4[bodyNosale]);
                        necksell.setImageResource(Chat.neck4[neckNosale]);
                        hornsell.setImageResource(Chat.horn4[hornNosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0101_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face4[faceNosale]);
                        Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.1f);
                        shadow.setScaleY(1.1f);
                    } else if (loaisale.equals("loai5") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head5[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing5[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body5[bodyNosale]);
                        necksell.setImageResource(Chat.neck5[neckNosale]);
                        hornsell.setImageResource(Chat.horn5[hornNosale]);
                        horn2sell.setImageResource(Chat.horn55[horn2Nosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0002_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face5[faceNosale]);
                        Chat._setScale(1.1f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.1f);
                        shadow.setScaleY(1.1f);
                    } else if (loaisale.equals("loai6") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 2)
                            neckNosale = 2;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head6[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing6[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body6[bodyNosale]);
                        necksell.setImageResource(Chat.neck6[neckNosale]);
                        hornsell.setImageResource(Chat.horn6[hornNosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0102_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face6[faceNosale]);
                        Chat._setScale(1.3f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.3f);
                        shadow.setScaleY(1.3f);
                    } else if (loaisale.equals("loai7") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head7[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing7[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body7[bodyNosale]);
                        necksell.setImageResource(Chat.neck7[neckNosale]);
                        hornsell.setImageResource(Chat.horn7[hornNosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0103_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face7[faceNosale]);
                    } else if (loaisale.equals("loai8") && tuoisale >= 5) {
                        if (wingNosale > 4)
                            wingNosale = 4;
                        if (neckNosale > 3)
                            neckNosale = 3;
                        if (faceNosale > 5)
                            faceNosale = 5;
                        dausell.setImageResource(Chat.head8[headNosale]);
                        if (wingNosale > 0)
                            canhsell.setImageResource(Chat.wing8[wingNosale - 1]);
                        bodysell.setImageResource(Chat.body8[bodyNosale]);
                        necksell.setImageResource(Chat.neck8[neckNosale]);
                        hornsell.setImageResource(Chat.horn8[hornNosale]);
                        horn2sell.setImageResource(Chat.horn88[horn2Nosale]);
                        if (matsale == 1)
                            facesell.setImageResource(R.drawable.face_0003_10);
                        else if (matsale == 0)
                            facesell.setImageResource(Chat.face8[faceNosale]);
                        Chat._setScale(1.4f, dausell, canhsell, bodysell, necksell, hornsell, horn2sell, facesell);
                        shadow.setScaleX(1.4f);
                        shadow.setScaleY(1.4f);
                    }

                    root.addView(shadow);
                    root.addView(canhsell);
                    root.addView(horn2sell);
                    root.addView(dausell);
                    root.addView(bodysell);
                    root.addView(necksell);
                    root.addView(facesell);
                    root.addView(hornsell);
                    root.addView(effect);
                    effect.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                    effect.setBackgroundResource(R.drawable.animation_effect);
                    AnimationDrawable anim_effect = (AnimationDrawable) effect.getBackground();
                    anim_effect.start();
                    effect.setLayerType(View.LAYER_TYPE_NONE, null);

                    final ArrayList<String> arr = new ArrayList<String>();
                    _addArray(arr);
                    root.setTag(arr);
                    frmypage.addView(root);
                    root.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                    int fromXDelta = 0, toXDelta = 0, fromYDelta = 0, toYDelta = 0;
                    final TranslateAnimation anim = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
                    anim.setDuration(15000);
                    anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            int a = new Random().nextInt(25);
                            int b = new Random().nextInt(25);
                            int c = new Random().nextInt(4);
                            if (c == 1) a *= -1;
                            else if (c == 2) b *= -1;
                            else if (c == 3) {
                                a *= -1;
                                b *= -1;
                            }
                            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) root.getLayoutParams();
                            params.topMargin += a;
                            params.leftMargin += b;
                            root.clearAnimation();
                            root.setLayoutParams(params);
                            root.setLayerType(View.LAYER_TYPE_NONE, null);
                            root.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            root.startAnimation(anim);
                        }
                    });
                    root.startAnimation(anim);

                    root.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent event) {
                            final int X = (int) event.getRawX();
                            final int Y = (int) event.getRawY();

                            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                                case MotionEvent.ACTION_DOWN:
                                    _ActionDown(view, X, Y, arr);
                                    if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                                        return false;
                                    }
                                    mLastClickTime = SystemClock.elapsedRealtime();
                                    break;
                                case MotionEvent.ACTION_UP:
                                    _ActionUp(view);
                                    startTimer2(loaisale, bodysell, bodyNosale);
                                    break;
                                case MotionEvent.ACTION_POINTER_DOWN:
                                    break;
                                case MotionEvent.ACTION_POINTER_UP:
                                    break;
                                case MotionEvent.ACTION_MOVE:
                                    if (_timer_test == 0) {
                                        setCurPet(bodysell, loaisale, bodyNosale);
                                        _timer_test = 1;
                                    }
                                    _move = 0;
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view
                                            .getLayoutParams();
                                    layoutParams.leftMargin = X - _xDelta;
                                    layoutParams.topMargin = Y - _yDelta;
                                    layoutParams.rightMargin = +50;
                                    layoutParams.bottomMargin = +50;
                                    view.setLayoutParams(layoutParams);
                                    break;
                            }
                            frmypage.invalidate();
                            return true;
                        }
                    });
                }
            }
        }
        getparam();
        txtnampet.setText(namesell);
        txtkind.setText(hangsell);
        for (int i = 0; i < kind_temp.size(); i++) {
            if (kind_temp.get(i).equals(loaisale)) {
                ratio_hp = hp_temp.get(i);
            }
        }
        _hp = (int) ratio_hp * pl_hp / 100;
        if (_hp == 0) {
            _hp = 1;
            db.update_hp(idpetsell, 1);
        }
        if (_hp >= pl_hp) {
            _hp = pl_hp;
            db.update_hp(idpetsell, 100);
        }
        prhp.setMax(pl_hp);
        txtHp.setText(_hp + "/" + pl_hp);
        prhp.setProgress(_hp);
        fighttext.setText("" + _fightSum + "戦 " + _fightWin + "勝");
        foresttext.setText("0戦 0勝");
        int sizelv = 11;
        if (_Width <= 480)
            sizelv = 9;
        DrawLevel(lnlvpet, _level, sizelv);
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head[headNosale]);
            mphorn.setImageResource(Chat.horn[hornNosale]);
            bgmphead.setImageResource(Chat.bghead[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0000_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face[faceNosale]);
        } else if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head2[headNosale]);
            mphorn.setImageResource(Chat.horn2[hornNosale]);
            bgmphead.setImageResource(Chat.bghead2[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn2[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0100_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face2[faceNosale]);
        } else if (loaisale.equals("loai3")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head3[headNosale]);
            mphorn.setImageResource(Chat.horn3[hornNosale]);
            mphorn2.setImageResource(Chat.horn33[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead3[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn3[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn33[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0001_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face3[faceNosale]);
        } else if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head4[headNosale]);
            mphorn.setImageResource(Chat.horn4[hornNosale]);
            bgmphead.setImageResource(Chat.bghead4[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn4[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0101_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face4[faceNosale]);
        } else if (loaisale.equals("loai5")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head5[headNosale]);
            mphorn.setImageResource(Chat.horn5[hornNosale]);
            mphorn2.setImageResource(Chat.horn55[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead5[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn5[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn55[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0002_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face5[faceNosale]);
        } else if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head6[headNosale]);
            mphorn.setImageResource(Chat.horn6[hornNosale]);
            bgmphead.setImageResource(Chat.bghead6[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn6[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0102_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face6[faceNosale]);
        } else if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head7[headNosale]);
            mphorn.setImageResource(Chat.horn7[hornNosale]);
            bgmphead.setImageResource(Chat.bghead7[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn7[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0103_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face7[faceNosale]);
        } else if (loaisale.equals("loai8")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head8[headNosale]);
            mphorn.setImageResource(Chat.horn8[hornNosale]);
            mphorn2.setImageResource(Chat.horn88[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead8[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn8[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn88[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0003_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face8[faceNosale]);
        }
    }

    public boolean CheckCollision(View v1, View v2) {
        Rect R1 = new Rect(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
        Rect R2 = new Rect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom());
        return R1.intersect(R2);
    }

    public void DrawLevel(LinearLayout layoutLevel, int lv, int size) {
        if (layoutLevel != null)
            layoutLevel.removeAllViews();
        String str = "" + lv;
        String[] arr = str.split("");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, LinearLayout.LayoutParams.WRAP_CONTENT);
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

    public void _addArray(ArrayList<String> arr) {
        arr.add("" + loaisale);
        arr.add("" + hornNosale);
        arr.add("" + wingNosale);
        arr.add("" + horn2Nosale);
        arr.add("" + headNosale);
        arr.add("" + neckNosale);
        arr.add("" + faceNosale);
        arr.add("" + bodyNosale);
        arr.add("" + matsale);
        arr.add("" + namesell);
        arr.add("" + hangsell);
        arr.add("" + ratio_hp);
        arr.add("" + _attack);
        arr.add("" + _criticalAttack);
        arr.add("" + _defense);
        arr.add("" + _critical);
        arr.add("" + _avoid);
        arr.add("" + _lucky);
        arr.add("" + _speed);
        arr.add("" + _level);
        arr.add("" + _exp);
        arr.add("" + idpetsell);
        arr.add("" + _fightSum);
        arr.add("" + _fightWin);
        arr.add("" + _strengthsale);
        arr.add("" + _formsale);
        arr.add("" + nuoisale);
        arr.add("" + personalitysale);
        arr.add("" + _sizesale);
        arr.add("" + _life);
        arr.add("" + id_pet_show);
    }

    ArrayList<String> kind_temp;
    ArrayList<Double> hp_temp;

    public void _ActionDown(View view, int X, int Y, ArrayList<String> arr) {
        time_click++;
        db.updateTabshowpetWithTIME(id_pet_show, time_click);
        listDataShowpet = db.getAllShowpet();
        _move = 1;
        FrameLayout.LayoutParams lParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        _xDelta = X - lParams.leftMargin;
        _yDelta = Y - lParams.topMargin;
        loaisale = arr.get(0);
        hornNosale = Integer.parseInt(arr.get(1));
        wingNosale = Integer.parseInt(arr.get(2));
        horn2Nosale = Integer.parseInt(arr.get(3));
        headNosale = Integer.parseInt(arr.get(4));
        neckNosale = Integer.parseInt(arr.get(5));
        faceNosale = Integer.parseInt(arr.get(6));
        bodyNosale = Integer.parseInt(arr.get(7));
        matsale = Integer.parseInt(arr.get(8));
        namesell = arr.get(9);
        hangsell = arr.get(10);
        ratio_hp = Double.parseDouble(arr.get(11));
        for (int i = 0; i < kind_temp.size(); i++) {
            if (kind_temp.get(i).equals(loaisale)) {
                ratio_hp = hp_temp.get(i);
            }
        }
        _attack = Integer.parseInt(arr.get(12));
        _criticalAttack = Integer.parseInt(arr.get(13));
        _defense = Integer.parseInt(arr.get(14));
        _critical = Integer.parseInt(arr.get(15));
        _avoid = Integer.parseInt(arr.get(16));
        _lucky = Integer.parseInt(arr.get(17));
        _speed = Integer.parseInt(arr.get(18));
        _level = Integer.parseInt(arr.get(19));
        _exp = Integer.parseInt(arr.get(20));
        idpetsell = Integer.parseInt(arr.get(21));
        _fightSum = Integer.parseInt(arr.get(22));
        _fightWin = Integer.parseInt(arr.get(23));

        _strengthsale = Integer.parseInt(arr.get(24));
        _formsale = Integer.parseInt(arr.get(25));
        nuoisale = Integer.parseInt(arr.get(26));
        personalitysale = Integer.parseInt(arr.get(27));
        _sizesale = Integer.parseInt(arr.get(28));
        _life = Integer.parseInt(arr.get(29));
        id_pet_show = Integer.parseInt(arr.get(30));
        if (anim_asura_forest.isRunning()) {
            anim_asura_forest.stop();
            asura_forest.setLayerType(View.LAYER_TYPE_NONE, null);
            asura_forest.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        anim_asura_forest.start();
    }

    public void _setNewValue(int i) {
        namesell = listPetLogin.get(i).getContent();
        hangsell = listPetLogin.get(i).getHang();
        matsale = listPetLogin.get(i).getMat();
        loaisale = listPetLogin.get(i).getLoai();
        tuoisale = listPetLogin.get(i).getTuoi();
        hornNosale = listPetLogin.get(i).getHornNo();
        horn2Nosale = listPetLogin.get(i).getHorn2No();
        wingNosale = listPetLogin.get(i).getWingNo();
        headNosale = listPetLogin.get(i).getHeadNo();
        neckNosale = listPetLogin.get(i).getNeckNo();
        faceNosale = listPetLogin.get(i).getFaceNo();
        if (matsale == 1) faceNosale = 5;
        bodyNosale = listPetLogin.get(i).getBodyNo();
        if (hornNosale > 7) hornNosale = 7;
        if (horn2Nosale > 7) horn2Nosale = 7;
        if (bodyNosale > 7) bodyNosale = 7;
        if (headNosale > 7) headNosale = 7;
        if (faceNosale > 5) faceNosale = 5;
        if (wingNosale > 4) wingNosale = 4;
        idpetsell = listPetLogin.get(i).getId();
        beetleID = listPetLogin.get(i).getBeetleID();

        personalitysale = listPetLogin.get(i).getPersonality();
        _excreteSsale = listPetLogin.get(i).getExcreteS();
        _satietysale = listPetLogin.get(i).getSatiety();
        _sleepsale = listPetLogin.get(i).getSleep();
        _phaseETime = listPetLogin.get(i).getPhaseETime();
        _strengthsale = listPetLogin.get(i).getStrength();
        _life = Integer.parseInt(listPetLogin.get(i).getTien());
        _bornTime = listPetLogin.get(i).getBornTime();
        _excreteBsale = listPetLogin.get(i).getExcreteB();
        _formsale = listPetLogin.get(i).getForm();
        _phaseTime = listPetLogin.get(i).getPhaseTime();
        _sizesale = listPetLogin.get(i).getSize();
        _moisturesale = listPetLogin.get(i).getMoisture();
        _healthsale = listPetLogin.get(i).getHealth();
        _mood = listPetLogin.get(i).getMood();
        clearn = listPetLogin.get(i).getClearn();
        _lastCleanTime = listPetLogin.get(i).getLastCleanTime();
        livesale = listPetLogin.get(i).getLive();
        salesale = listPetLogin.get(i).getSale();
        nuoisale = listPetLogin.get(i).getNuoi();
        ratio_hp = listPetLogin.get(i).getHp();
        kind_temp.add(loaisale);
        hp_temp.add(ratio_hp);
//        getparam();
//        _hp = ratio_hp * pl_hp / 100;
//        Toast.makeText(getApplicationContext(), "pl_hp:" + pl_hp, Toast.LENGTH_SHORT).show();
        _attack = listPetLogin.get(i).getAttack();
        _criticalAttack = listPetLogin.get(i).getCriticalAttack();
        _defense = listPetLogin.get(i).getDefense();
        _critical = listPetLogin.get(i).getCritical();
        _avoid = listPetLogin.get(i).getAvoid();
        _lucky = listPetLogin.get(i).getLucky();
        _level = listPetLogin.get(i).getLevel();
//        Log.e("_level","_level"+_level);
        _speed = listPetLogin.get(i).getSpeed();
        _exp = listPetLogin.get(i).getExp();
        _fightSum = listPetLogin.get(i).getFightsum();
        _fightWin = listPetLogin.get(i).getFightwin();

    }

    TextView txtcontent_dialogNotify;

    public void _dialogNotify() {
        final Dialog dialogwhenbuy = new Dialog(mypage.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.mydialog_forest);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.btnok);
        txtcontent_dialogNotify = (TextView) dialogwhenbuy.findViewById(R.id.txtcontent);
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

    public void _ActionUp(View root) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        _timer_test = 0;
        getparam();
        if (_move == 0) {
            int a = (int) (asura_forest.getHeight() - root.getHeight() / 1.5 - 50);
            int b = root.getRight() - root.getHeight() / 2;
            int d = root.getLeft() + root.getHeight() / 2;
            if (root.getTop() <= a && d >= asura_forest.getLeft()) {
                _dialogNotify();
                txtcontent_dialogNotify.setText("「修羅の森」では、ユーザー同士のネット対戦が可能になります！！\n現在調整中ですので、開催までに強いキャラを育てておいてくださいね。");
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) root.getLayoutParams();
                layoutParams.topMargin = asura_forest.getHeight() - root.getHeight() / 2;
                root.setLayoutParams(layoutParams);
            }
//            if (CheckCollision(root, asura_forest)) {
//                Log.e("TAG", "top:" + asura_forest.getTop() + " left:" + asura_forest.getLeft() +
//                        " width:" + asura_forest.getWidth() + " height:" + asura_forest.getHeight());
//                _dialogNotify();
//                txtcontent_dialogNotify.setText("「修羅の森」では、ユーザー同士のネット対戦が可能になります！！\n現在調整中ですので、開催までに強いキャラを育てておいてくださいね。");
//                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) root.getLayoutParams();
//                layoutParams.topMargin = asura_forest.getHeight() - root.getHeight() / 2;
//                root.setLayoutParams(layoutParams);
//            }
            else if (CheckCollision(root, button10)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) root.getLayoutParams();
                layoutParams.topMargin = _Height - root.getHeight() - root.getHeight() / 2 - button10.getHeight() - btnimgbreeding.getHeight() - 20;
                root.setLayoutParams(layoutParams);
            } else if (root.getLeft() < 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) root.getLayoutParams();
                layoutParams.leftMargin = -30;
                root.setLayoutParams(layoutParams);
            } else if (root.getRight() >= _Width) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) root.getLayoutParams();
                layoutParams.leftMargin = _Width - root.getWidth() + root.getWidth() / 3;
                root.setLayoutParams(layoutParams);
            }
//            if (CheckCollision(root, battle_ring)) {
            int c = (int) (battle_ring.getHeight() - root.getHeight() / 1.5);
            if (root.getTop() <= c && !CheckCollision(root, asura_forest) && b <= _Width / 2) {
                Intent i = new Intent(mypage.this, Battle.class);
                i.putExtra("dialog", "mp");
                i.putExtra("loaisale", loaisale);
                i.putExtra("wingNosale", wingNosale);
                i.putExtra("faceNosale", faceNosale);
                i.putExtra("neckNosale", neckNosale);
                i.putExtra("matsale", matsale);
                i.putExtra("bodyNosale", bodyNosale);
                i.putExtra("horn2Nosale", horn2Nosale);
                i.putExtra("hornNosale", hornNosale);
                i.putExtra("headNosale", headNosale);
                i.putExtra("pl_hp", pl_hp);
                i.putExtra("pl_at", pl_at);
                i.putExtra("pl_criat", pl_criat);
                i.putExtra("pl_de", pl_de);
                i.putExtra("pl_cri", pl_cri);
                i.putExtra("pl_avoid", pl_avoid);
                i.putExtra("pl_luc", pl_luc);
                i.putExtra("pl_spe", pl_spe);
                i.putExtra("_hp", _hp);
                i.putExtra("_attack", _attack);
                i.putExtra("_criticalAttack", _criticalAttack);
                i.putExtra("_defense", _defense);
                i.putExtra("_critical", _critical);
                i.putExtra("_avoid", _avoid);
                i.putExtra("_lucky", _lucky);
                i.putExtra("_speed", _speed);
                i.putExtra("_level", _level);
                i.putExtra("_exp", _exp);
                i.putExtra("idpetsell", idpetsell);
                i.putExtra("hangsell", hangsell);
                i.putExtra("namesell", namesell);

                i.putExtra("_strengthsale", _strengthsale);
                i.putExtra("_formsale", _formsale);
                i.putExtra("nuoisale", nuoisale);
                i.putExtra("personalitysale", personalitysale);
                i.putExtra("_sizesale", _sizesale);
                i.putExtra("_fightSum", _fightSum);
                startActivity(i);
            }
        }
        txtnampet.setText(namesell);
        txtkind.setText(hangsell);
        for (int i = 0; i < kind_temp.size(); i++) {
            if (kind_temp.get(i).equals(loaisale)) {
                ratio_hp = hp_temp.get(i);
            }
        }
        for (int i = 0; i < kind_temp.size(); i++) {
            if (kind_temp.get(i).equals(loaisale)) {
                ratio_hp = hp_temp.get(i);
            }
        }
        _hp = (int) ratio_hp * pl_hp / 100;
        if (_hp == 0) {
            _hp = 1;
            db.update_hp(idpetsell, 1);
        }
        if (_hp >= pl_hp) {
            _hp = pl_hp;
            db.update_hp(idpetsell, 100);
        }
        if (_move == 1)
            Dialog_choosepet();
        prhp.setMax(pl_hp);
        txtHp.setText(_hp + "/" + pl_hp);
        prhp.setProgress(_hp);
        fighttext.setText("" + _fightSum + "戦 " + _fightWin + "勝");
        foresttext.setText("0戦 0勝");
        int sizelv = 11;
        if (_Width <= 480)
            sizelv = 9;
        DrawLevel(lnlvpet, _level, sizelv);
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
            mphead.setImageResource(Chat.head[headNosale]);
            mphorn.setImageResource(Chat.horn[hornNosale]);
            bgmphead.setImageResource(Chat.bghead[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0000_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face[faceNosale]);
        } else if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head2[headNosale]);
            mphorn.setImageResource(Chat.horn2[hornNosale]);
            bgmphead.setImageResource(Chat.bghead2[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn2[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0100_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face2[faceNosale]);
        } else if (loaisale.equals("loai3")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 4)
                neckNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head3[headNosale]);
            mphorn.setImageResource(Chat.horn3[hornNosale]);
            mphorn2.setImageResource(Chat.horn33[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead3[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn3[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn33[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0001_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face3[faceNosale]);
        } else if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head4[headNosale]);
            mphorn.setImageResource(Chat.horn4[hornNosale]);
            bgmphead.setImageResource(Chat.bghead4[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn4[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0101_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face4[faceNosale]);
        } else if (loaisale.equals("loai5")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head5[headNosale]);
            mphorn.setImageResource(Chat.horn5[hornNosale]);
            mphorn2.setImageResource(Chat.horn55[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead5[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn5[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn55[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0002_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face5[faceNosale]);
        } else if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head6[headNosale]);
            mphorn.setImageResource(Chat.horn6[hornNosale]);
            bgmphead.setImageResource(Chat.bghead6[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn6[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0102_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face6[faceNosale]);
        } else if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head7[headNosale]);
            mphorn.setImageResource(Chat.horn7[hornNosale]);
            bgmphead.setImageResource(Chat.bghead7[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn7[hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0103_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face7[faceNosale]);
        } else if (loaisale.equals("loai8")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
            mphead.setImageResource(Chat.head8[headNosale]);
            mphorn.setImageResource(Chat.horn8[hornNosale]);
            mphorn2.setImageResource(Chat.horn88[horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead8[headNosale]);
            bgmphorn.setImageResource(Chat.bghorn8[hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn88[horn2Nosale]);
            if (matsale == 1)
                mpface.setImageResource(R.drawable.face_0003_10);
            else if (matsale == 0)
                mpface.setImageResource(Chat.face8[faceNosale]);
        }
    }

    public void getpartCSVfile() {
        CSV_hp_parts = new ArrayList<String>();
        CSV_attack_parts = new ArrayList<String>();
        CSV_criticalAttack_parts = new ArrayList<String>();
        CSV_defense_parts = new ArrayList<String>();
        CSV_critical_parts = new ArrayList<String>();
        CSV_avoid_parts = new ArrayList<String>();
        CSV_lucky_parts = new ArrayList<String>();
        CSV_speed_parts = new ArrayList<String>();
        CSV_species_parts = new ArrayList<String>();
        CSV_part_parts = new ArrayList<String>();
        CSV_rank_parts = new ArrayList<String>();

        CSV_hp_supplement = new ArrayList<String>();
        CSV_attack_supplement = new ArrayList<String>();
        CSV_criticalAttack_supplement = new ArrayList<String>();
        CSV_defense_supplement = new ArrayList<String>();
        CSV_critical_supplement = new ArrayList<String>();
        CSV_avoid_supplement = new ArrayList<String>();
        CSV_lucky_supplement = new ArrayList<String>();
        CSV_speed_supplement = new ArrayList<String>();
        CSV_species_supplement = new ArrayList<String>();
        CSV_lv_supplement = new ArrayList<String>();

        CSV_hp = new ArrayList<String>();
        CSV_attack = new ArrayList<String>();
        CSV_criticalAttack = new ArrayList<String>();
        CSV_defense = new ArrayList<String>();
        CSV_critical = new ArrayList<String>();
        CSV_avoid = new ArrayList<String>();
        CSV_lucky = new ArrayList<String>();
        CSV_speed = new ArrayList<String>();
        CSV_species = new ArrayList<String>();
        CSV_lv = new ArrayList<String>();

        arr_hp_parts = new ArrayList<String>();
        arr_attack_parts = new ArrayList<String>();
        arr_criticalAttack_parts = new ArrayList<String>();
        arr_defense_parts = new ArrayList<String>();
        arr_critical_parts = new ArrayList<String>();
        arr_avoid_parts = new ArrayList<String>();
        arr_lucky_parts = new ArrayList<String>();
        arr_speed_parts = new ArrayList<String>();
        arr_species_parts = new ArrayList<String>();
        arr_part_parts = new ArrayList<String>();
        arr_rank_parts = new ArrayList<String>();

        arr_hp = new ArrayList<String>();
        arr_attack = new ArrayList<String>();
        arr_criticalAttack = new ArrayList<String>();
        arr_defense = new ArrayList<String>();
        arr_critical = new ArrayList<String>();
        arr_avoid = new ArrayList<String>();
        arr_lucky = new ArrayList<String>();
        arr_speed = new ArrayList<String>();
        arr_species = new ArrayList<String>();
        arr_lv = new ArrayList<String>();

        arr_hp_supplement = new ArrayList<String>();
        arr_attack_supplement = new ArrayList<String>();
        arr_criticalAttack_supplement = new ArrayList<String>();
        arr_defense_supplement = new ArrayList<String>();
        arr_critical_supplement = new ArrayList<String>();
        arr_avoid_supplement = new ArrayList<String>();
        arr_lucky_supplement = new ArrayList<String>();
        arr_speed_supplement = new ArrayList<String>();
        arr_species_supplement = new ArrayList<String>();
        arr_lv_supplement = new ArrayList<String>();

        InputStream inputStream2 = getResources().openRawResource(R.raw.kabukuwabaseparameter);
        CSVbaseparameter csvFile2 = new CSVbaseparameter(inputStream2);
        List<String[]> scoreList2 = csvFile2.read();

        InputStream inputStream4 = getResources().openRawResource(R.raw.kabukuwaparts);
        CSVparts csvFile4 = new CSVparts(inputStream4);
        List<String[]> scoreList4 = csvFile4.read();

        InputStream inputStream3 = getResources().openRawResource(R.raw.kabukuwasupplementparameter);
        CSVSupplement csvFile3 = new CSVSupplement(inputStream3);
        List<String[]> scoreList3 = csvFile3.read();
        for (int i = 1; i < CSV_hp_parts.size(); i++) {
            arr_species_parts.add(CSV_species_parts.get(i));
            arr_hp_parts.add(CSV_hp_parts.get(i));
            arr_attack_parts.add(CSV_attack_parts.get(i));
            arr_criticalAttack_parts.add(CSV_criticalAttack_parts.get(i));
            arr_defense_parts.add(CSV_defense_parts.get(i));
            arr_critical_parts.add(CSV_critical_parts.get(i));
            arr_avoid_parts.add(CSV_avoid_parts.get(i));
            arr_lucky_parts.add(CSV_lucky_parts.get(i));
            arr_speed_parts.add(CSV_speed_parts.get(i));
            arr_part_parts.add(CSV_part_parts.get(i));
            arr_rank_parts.add(CSV_rank_parts.get(i));
        }

        for (int i = 1; i < CSV_hp.size(); i++) {
            arr_species.add(CSV_species.get(i));
            arr_hp.add(CSV_hp.get(i));
            arr_attack.add(CSV_attack.get(i));
            arr_criticalAttack.add(CSV_criticalAttack.get(i));
            arr_defense.add(CSV_defense.get(i));
            arr_critical.add(CSV_critical.get(i));
            arr_avoid.add(CSV_avoid.get(i));
            arr_lucky.add(CSV_lucky.get(i));
            arr_speed.add(CSV_speed.get(i));
            arr_lv.add(CSV_lv.get(i));
        }

        for (int i = 1; i < CSV_hp_supplement.size(); i++) {
            arr_species_supplement.add(CSV_species_supplement.get(i));
            arr_hp_supplement.add(CSV_hp_supplement.get(i));
            arr_attack_supplement.add(CSV_attack_supplement.get(i));
            arr_criticalAttack_supplement.add(CSV_criticalAttack_supplement.get(i));
            arr_defense_supplement.add(CSV_defense_supplement.get(i));
            arr_critical_supplement.add(CSV_critical_supplement.get(i));
            arr_avoid_supplement.add(CSV_avoid_supplement.get(i));
            arr_lucky_supplement.add(CSV_lucky_supplement.get(i));
            arr_speed_supplement.add(CSV_speed_supplement.get(i));
            arr_lv_supplement.add(CSV_lv_supplement.get(i));
        }
    }

    public void getparam() {
        pl_at_temp = 0;
        pl_hp_temp = 0;
        pl_criat_temp = 0;
        pl_de_temp = 0;
        pl_cri_temp = 0;
        pl_avoid_temp = 0;
        pl_luc_temp = 0;
        pl_spe_temp = 0;
        if (loaisale.equals("loai1"))
            inKind = 0;
        else if (loaisale.equals("loai2"))
            inKind = 1000;
        else if (loaisale.equals("loai3")) {
            if (wingNosale < 4)
                wingtemp = wingNosale;
            if (wingNosale >= 4)
                wingtemp = 10;
            if (neckNosale < 4)
                necktemp = neckNosale;
            if (neckNosale >= 4)
                necktemp = 10;
            if (faceNosale < 5)
                facetemp = faceNosale;
            if (faceNosale >= 5)
                facetemp = 10;
            inKind = 1;
        } else if (loaisale.equals("loai4"))
            inKind = 1001;
        else if (loaisale.equals("loai5"))
            inKind = 2;
        else if (loaisale.equals("loai6"))
            inKind = 1002;
        else if (loaisale.equals("loai7"))
            inKind = 1003;
        else if (loaisale.equals("loai8"))
            inKind = 3;
        if (headNosale < 7)
            headtemp = headNosale;
        if (headNosale >= 7)
            headtemp = 10;
        if (bodyNosale < 7)
            bodytemp = bodyNosale;
        if (bodyNosale >= 7)
            bodytemp = 10;
        if (hornNosale < 7)
            horntemp = hornNosale;
        if (hornNosale >= 7)
            horntemp = 10;
        if (horn2Nosale < 7)
            horn2temp = horn2Nosale;
        if (horn2Nosale >= 7)
            horn2temp = 10;
        if (loaisale.equals("loai1") || loaisale.equals("loai5") || loaisale.equals("loai7") || loaisale.equals("loai8")) {
            if (wingNosale < 4)
                wingtemp = wingNosale;
            if (wingNosale >= 4)
                wingtemp = 10;
            if (faceNosale < 5)
                facetemp = faceNosale;
            if (faceNosale >= 5)
                facetemp = 10;
            if (neckNosale < 3)
                necktemp = neckNosale;
            if (neckNosale >= 3)
                necktemp = 10;
        } else if (loaisale.equals("loai2") || loaisale.equals("loai4") || loaisale.equals("loai6")) {
            if (wingNosale < 4)
                wingtemp = wingNosale;
            if (wingNosale >= 4)
                wingtemp = 10;
            if (neckNosale < 2)
                necktemp = neckNosale;
            if (neckNosale >= 2)
                necktemp = 10;
            if (faceNosale < 5)
                facetemp = faceNosale;
            if (faceNosale >= 5)
                facetemp = 10;
        }
        Sum_Exp = Chat.needExpTilLevelUpAtImagoLevel(_level, inKind) - 30;
        Player_species = Chat.convertSpeciesValue(inKind);
        pl_getTotalPartsParameter(Player_species);
    }

    public static int Sum_Exp, pl_at = 0, pl_hp = 0, pl_criat = 0, pl_de = 0, pl_cri = 0, pl_avoid = 0, pl_luc = 0, pl_spe = 0;
    public int pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement, pl_Defense_supplement, pl_Critical_supplement,
            pl_Avoid_supplement, pl_Lucky_supplement, pl_Speed_supplement;
    public int pl_curHp, pl_attack, pl_CriticalAttack, pl_Defense, pl_Critical, pl_Avoid, pl_Lucky, pl_Speed;
    public int pl_at_temp = 0, pl_hp_temp = 0, pl_criat_temp = 0, pl_de_temp = 0, pl_cri_temp = 0, pl_avoid_temp = 0, pl_luc_temp = 0, pl_spe_temp = 0;
    int setup_parts_hp, setup_parts_attack, setup_parts_CriticalAttack,
            setup_parts_Defense, setup_parts_Critical, setup_parts_Avoid, setup_parts_Lucky, setup_parts_Speed;
    int horntemp, horn2temp, headtemp, facetemp, necktemp, bodytemp, wingtemp;

    public void setup_getPartsParameterSpeciesAndPartAndRank(int species, int part, int rank) {
        if (part < 0)
            return;
        for (int i = 0; i < mypage.arr_species_parts.size(); i++) {
            if (Integer.parseInt(mypage.arr_species_parts.get(i)) == species &&
                    Integer.parseInt(mypage.arr_rank_parts.get(i)) == rank &&
                    Integer.parseInt(mypage.arr_part_parts.get(i)) == part) {
                setup_parts_hp = Integer.parseInt(mypage.arr_hp_parts.get(i));
                setup_parts_attack = Integer.parseInt(mypage.arr_attack_parts.get(i));
                setup_parts_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack_parts.get(i));
                setup_parts_Defense = Integer.parseInt(mypage.arr_defense_parts.get(i));
                setup_parts_Critical = Integer.parseInt(mypage.arr_critical_parts.get(i));
                setup_parts_Avoid = Integer.parseInt(mypage.arr_avoid_parts.get(i));
                setup_parts_Lucky = Integer.parseInt(mypage.arr_lucky_parts.get(i));
                setup_parts_Speed = Integer.parseInt(mypage.arr_speed_parts.get(i));
//                if (setup_parts_Speed < 0)
//                    setup_parts_Speed *= -1;
            }
        }
        if ((species != 2 && part == 1) || (species != 4 && part == 1) || (species != 7 && part == 1))
            setup_parts_attack = 0;
    }

    public void pl_getTotalPartsParameter(int species) {
        for (int i = 0; i < Chat.KABUKUWA_PARTS; i++) {
            int partsRank = pl_getEquipedPartsRank(i, species);
            if (partsRank == -1) {
                // 情報が不正のとき
                continue;
            }
            setup_getPartsParameterSpeciesAndPartAndRank(species, i, partsRank);
            pl_hp_temp += setup_parts_hp;
            pl_at_temp += setup_parts_attack;
            pl_criat_temp += setup_parts_CriticalAttack;
            pl_de_temp += setup_parts_Defense;
            pl_cri_temp += setup_parts_Critical;
            pl_avoid_temp += setup_parts_Avoid;
            pl_luc_temp += setup_parts_Lucky;
            pl_spe_temp += setup_parts_Speed;
//            if (pl_spe_temp < 0)
//                pl_spe_temp = 0;
        }

        int s = Chat.convertSpeciesValue(inKind);
        for (int i = 0; i < mypage.arr_species.size(); i++) {
            if (Integer.parseInt(mypage.arr_species.get(i)) == s && Integer.parseInt(mypage.arr_lv.get(i)) == _level) {
                pl_curHp = Integer.parseInt(mypage.arr_hp.get(i));
                pl_attack = Integer.parseInt(mypage.arr_attack.get(i));
                pl_CriticalAttack = Integer.parseInt(mypage.arr_criticalAttack.get(i));
                pl_Defense = Integer.parseInt(mypage.arr_defense.get(i));
                pl_Critical = Integer.parseInt(mypage.arr_critical.get(i));
                pl_Avoid = Integer.parseInt(mypage.arr_avoid.get(i));
                pl_Lucky = Integer.parseInt(mypage.arr_lucky.get(i));
                pl_Speed = Integer.parseInt(mypage.arr_speed.get(i));
            }
        }
        for (int i = 0; i < mypage.arr_species_supplement.size(); i++) {
            if (Integer.parseInt(mypage.arr_species_supplement.get(i)) == s && Integer.parseInt(mypage.arr_lv_supplement.get(i)) == _level) {
                pl_hp_supplement = Integer.parseInt(mypage.arr_hp_supplement.get(i));
                pl_attack_supplement = Integer.parseInt(mypage.arr_attack_supplement.get(i));
                pl_CriticalAttack_supplement = Integer.parseInt(mypage.arr_criticalAttack_supplement.get(i));
                pl_Defense_supplement = Integer.parseInt(mypage.arr_defense_supplement.get(i));
                pl_Critical_supplement = Integer.parseInt(mypage.arr_critical_supplement.get(i));
                pl_Avoid_supplement = Integer.parseInt(mypage.arr_avoid_supplement.get(i));
                pl_Lucky_supplement = Integer.parseInt(mypage.arr_lucky_supplement.get(i));
                pl_Speed_supplement = Integer.parseInt(mypage.arr_speed_supplement.get(i));
            }
        }
        pl_hp = _returnHp2(pl_curHp, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement, pl_Defense_supplement,
                pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement, pl_Speed_supplement, pl_hp_temp, inKind);

        pl_at = _returnAttack2(pl_attack, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_at_temp, inKind);
        pl_criat = _returnAttackCri2(pl_CriticalAttack, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_criat_temp, inKind);
        pl_de = _returnDefence2(pl_Defense, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_de_temp, inKind);
        pl_cri = _returnCritical2(pl_Critical, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_cri_temp, inKind);
        pl_avoid = _returnAvoid2(pl_Avoid, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_avoid_temp, inKind);
        pl_luc = _returnLucky2(pl_Lucky, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_luc_temp, inKind);

//        Log.e("pl_Speed", "pl_Speed:" + pl_Speed);
//        Log.e("pl_spe_temp", "pl_spe_temp:" + pl_spe_temp);
        pl_spe = _return2(pl_Speed, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_spe_temp, inKind);
//        Log.e("param", "" + pl_hp + "-" + pl_at + "-" + pl_criat + "-" + pl_de + "-" + pl_cri + "-" + pl_avoid + "-" + pl_luc + "-" + pl_spe);
    }

    public int _returnHp2(int param_hp, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement, int param_Defense_supplement,
                          int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement, int param_Speed_supplement, int parts_hp, int kind) {
        int hp = param_hp + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 1) + parts_hp;
        return hp;
    }

    public int _returnAttack2(int param_attack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                              int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                              int param_Speed_supplement, int parts_attack, int kind) {
        int a = param_attack + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 2) + parts_attack;
        return a;
    }

    public int _returnAttackCri2(int param_CriticalAttack, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                 int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                 int param_Speed_supplement, int parts_CriticalAttack, int kind) {
        int a = param_CriticalAttack + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 3) + parts_CriticalAttack;
        return a;
    }

    public int _returnDefence2(int param_Defense, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                               int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                               int param_Speed_supplement, int parts_Defense, int kind) {
        int obj_defence = param_Defense + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 4) + parts_Defense;
        return obj_defence;
    }

    public int _returnCritical2(int param_Critical, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                int param_Speed_supplement, int parts_Critical, int kind) {
        int obj_critical = param_Critical + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 5) + parts_Critical;
        return obj_critical;
    }

    public int _returnAvoid2(int param_Avoid, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                             int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                             int param_Speed_supplement, int parts_Avoid, int kind) {
        int obj_avoid = param_Avoid + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 6) + parts_Avoid;
        return obj_avoid;
    }

    public int _returnLucky2(int param_Lucky, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                             int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                             int param_Speed_supplement, int parts_Lucky, int kind) {
        int obj_lucky = param_Lucky + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 7) + parts_Lucky;
        return obj_lucky;
    }

    public int _return2(int param_Speed, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                        int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                        int param_Speed_supplement, int parts_Speed, int kind) {
        int obj_speed = param_Speed + calcExtraParamAtBeetle2(kind, param_hp_supplement, param_attack_supplement, param_CriticalAttack_supplement,
                param_Defense_supplement, param_Critical_supplement, param_Avoid_supplement, param_Lucky_supplement,
                param_Speed_supplement, 8) + parts_Speed;
        return obj_speed;
    }

    public int calcExtraParamAtBeetle2(int inKind, int param_hp_supplement, int param_attack_supplement, int param_CriticalAttack_supplement,
                                       int param_Defense_supplement, int param_Critical_supplement, int param_Avoid_supplement, int param_Lucky_supplement,
                                       int param_Speed_supplement, int part) {
        int result = 0;
        double lifeMax = 0, strengthMax = 0, formMax = 0, friendlyMax = 0, personalityMax = 0;
        lifeMax = Chat.kBeetleLife_Max * Chat.parameterRatio(inKind);
        strengthMax = Chat.kBeetleStrength_Max * Chat.parameterRatio(inKind);
        formMax = Chat.kBeetleForm_Max * Chat.parameterRatio(inKind);
        friendlyMax = Chat.kBeetleFriendly_Max * Chat.parameterRatio(inKind);
        personalityMax = Chat.kBeetlePersonality_Max * Chat.parameterRatio(inKind);
        switch (part) {
            case 1: {
                double extraParamBaseRatio = (double) param_hp_supplement;
                // HP補正   (パラメータlife / 生命力Max) * パラメータ補正
                result = (int) Math.floor((double) _life / (double) lifeMax *
                        extraParamBaseRatio);
//                Log.e("TAG", "result:" + result);
            }
            break;
            case 2: {
                double extraParamBaseRatio = (double) param_attack_supplement;
                // こうげき補正 (パラメータStrength / 強さMax) * パラメータ補正
                result = (int) Math.floor((double) _strengthsale / (double) strengthMax *
                        extraParamBaseRatio);
            }
            break;
            case 3: {
                double extraParamBaseRatio = (double) param_CriticalAttack_supplement;
                // こうげき(クリティカル)補正 ((パラメータStrength / 強さMax) - (パラメータForm / かっこよさMax)) * パラメータ補正   値が大きくなりすぎると面白くないので
                double strength = ((double) _strengthsale / (double) strengthMax);
                double form = ((double) _formsale / (double) formMax);
                result = (int) Math.floor((strength - form) * extraParamBaseRatio);
            }
            break;
            case 4: {
                double extraParamBaseRatio = (double) param_Defense_supplement;
//                 ぼうぎょ補正 (パラメータSize - 0.6 * サイズmax) / (0.4 * サイズmax) * パラメータ補正  サイズはmax値の6割までは確実に成長するので伸びしろで計算をする
                double size = ((double) _sizesale - 0.6 * (double) Chat.kBeetleSizeMax);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 5: {
                double extraParamBaseRatio = (double) param_Critical_supplement;
                // クリティカル発動補正 (パラメータForm / かっこよさMax - (パラメータFriendluw / なつき度Max)) * パラメータ補正  なつき度が高いと野生の感がなくなるイメージ
                double form = ((double) _formsale / (double) formMax);
                double friendly = ((double) nuoisale / (double) friendlyMax);
                result = (int) Math.floor((form - friendly) * extraParamBaseRatio);
            }
            break;
            case 6: {
                double extraParamBaseRatio = (double) param_Avoid_supplement;
                //かいひ補正    (パラメータpersonality / パーソナリティMax -  (パラメータFriendluw / なつき度Max)) * パラメータ補正    なつき度が高いと野生の感がなくなるイメージ
                double personality = ((double) personalitysale / (double) personalityMax);
                double friendly = ((double) nuoisale / (double) friendlyMax);
                result = (int) Math.floor((personality - friendly) * extraParamBaseRatio);
            }
            break;
            case 7: {
                double extraParamBaseRatio = (double) param_Lucky_supplement;
                // ラッキー補正 (1 - (パラメータStrength / 強さMax + パラメータForm / かっこよさMax + パラメータpersonality / パーソナリティMax) / 3 + (パラメータFriendluw / なつき度Max)) * パラメータ補正    あまり強すぎる個体を作らないために攻撃、クリティカル発動率、回避のパラメータとのバランスを取る。ただしある程度こまめに世話をした方が強くなるように生命力とは独立をさせて、friendlyが高いほど高くなるようにする。
                double strength = ((double) _strengthsale / (double) strengthMax);
                double form = ((double) _formsale / (double) formMax);
                double personality = ((double) personalitysale / (double) personalityMax);
                double friendly = ((double) nuoisale / (double) friendlyMax);
                result = (int) Math.floor((1 - (strength + form + personality) / 3.0 + friendly) * extraParamBaseRatio);
            }
            break;
            case 8: {
                double extraParamBaseRatio = (double) param_Speed_supplement;
                //すばやさ補正   (サイズmax - パラメータSize) / (0.4 * サイズmax) * パラメータ補正    ぼうぎょと同様に確実に成長する部分は無視をする
                double size = ((double) Chat.kBeetleSizeMax - (double) _sizesale);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 0:
                break;
        }
        return (result);
    }

    public int pl_getEquipedPartsRank(int part, int s) {
        int a = 0;
        if (part == 0)
            a = horntemp;
        if (part == 1) {
            if (s == 2 || s == 4 || s == 7)
                a = horn2temp;
            else
                a = -1;
        }
        if (part == 2)
            a = bodytemp;
        if (part == 3)
            a = facetemp;
        if (part == 4)
            a = headtemp;
        if (part == 5)
            a = necktemp;
        if (part == 6)
            a = wingtemp;
        return a;
    }

    public void _createCPU() {
        arr_horn = new ArrayList<String>();
        arr_horn2 = new ArrayList<String>();
        arr_neck = new ArrayList<String>();
        arr_body = new ArrayList<String>();
        arr_wing = new ArrayList<String>();
        arr_face = new ArrayList<String>();
        arr_head = new ArrayList<String>();
        arr_subkind = new ArrayList<Integer>();

        head_cpu = new ArrayList<Integer>();
        horn_cpu = new ArrayList<Integer>();
        horn2_cpu = new ArrayList<Integer>();
        wing_cpu = new ArrayList<Integer>();
        body_cpu = new ArrayList<Integer>();
        face_cpu = new ArrayList<Integer>();
        neck_cpu = new ArrayList<Integer>();
        partsIndexes = new ArrayList<Integer>();
        for (int index = 0; index < 8; ++index) {
            makeEnemyBeetleAtLevel(0, index, 8);
        }
        int position = new Random().nextInt(8);
        String phorn = Chat.gettextimage(arr_horn, position);
        String phorn2 = Chat.gettextimage(arr_horn2, position);
        String pImghead = Chat.gettextimage(arr_head, position);
        String pImgface = Chat.gettextimage(arr_face, position);
        String pImgneck = Chat.gettextimage(arr_neck, position);
        String pImgwing = Chat.gettextimage(arr_wing, position);
        String pImgbody = Chat.gettextimage(arr_body, position);
        int resID = context.getResources().getIdentifier("@drawable/" + phorn, "drawable", context.getPackageName());
        int resID2 = context.getResources().getIdentifier("@drawable/" + phorn2, "drawable", context.getPackageName());
        int resIDhead = context.getResources().getIdentifier("@drawable/" + pImghead, "drawable", context.getPackageName());
        int resIDface = context.getResources().getIdentifier("@drawable/" + pImgface, "drawable", context.getPackageName());
        int resIDneck = context.getResources().getIdentifier("@drawable/" + pImgneck, "drawable", context.getPackageName());
        int resIDwing = context.getResources().getIdentifier("@drawable/" + pImgwing, "drawable", context.getPackageName());
        int resIDbody = context.getResources().getIdentifier("@drawable/" + pImgbody, "drawable", context.getPackageName());
        random_horn.setImageResource(resID);
        random_horn2.setImageResource(resID2);
        random_head.setImageResource(resIDhead);
        random_face.setImageResource(resIDface);
        random_neck.setImageResource(resIDneck);
        random_wing.setImageResource(resIDwing);
        random_body.setImageResource(resIDbody);

        fr_random_pet.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        rd_pet = new TranslateAnimation(0, 0, 0, 0);
        rd_pet.setDuration(500);
        rd_pet.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) fr_random_pet.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin += 40;
                fr_random_pet.clearAnimation();
                fr_random_pet.setLayerType(View.LAYER_TYPE_NONE, null);
                fr_random_pet.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                fr_random_pet.setLayoutParams(params);
            }
        });
        rd_pet_l = new TranslateAnimation(0, 0, 0, 0);
        rd_pet_l.setDuration(500);
        rd_pet_l.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) fr_random_pet.getLayoutParams();
                params.topMargin += 0;
                params.leftMargin -= 40;
                fr_random_pet.clearAnimation();
                fr_random_pet.setLayoutParams(params);
            }
        });
    }

    int imagoHornRank, imagoHorn2Rank, imagoHeadRank,
            imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank;
    String part_horn = "", part_horn2 = "", part_head = "", part_face = "", part_neck = "", part_body = "", part_wing = "";
    public ArrayList<Integer> head_cpu;
    public ArrayList<Integer> horn_cpu;
    public ArrayList<Integer> horn2_cpu;
    public ArrayList<Integer> wing_cpu;
    public ArrayList<Integer> body_cpu;
    public ArrayList<Integer> neck_cpu;
    public ArrayList<Integer> face_cpu;
    ArrayList<Integer> partsIndexes;

    public void makeEnemyBeetleAtLevel(int inLevelRegion, int inTableIndex, int inNumTables) {
        int levelTable[][] = {
                {0, 1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 12, 14, 16, 18, 20},
                {22, 24, 28, 32, 36, 40, 44, 48},
                {50, 55, 60, 65, 70, 75, 80, 85}
        };
        int rank = inTableIndex / (inNumTables / 8);
        if (rank >= 8)
            rank = 7;
//        Log.e("imagoLevel", "" + imagoLevel);
        // レベルにより、種類を選定
        int subKindTable[][] =
                {
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_Hercules,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_AllotopusRosenbergi,
                        },
                        {
                                Chat.kBeetleSubKind_JapanBeetle,
                                Chat.kBeetleSubKind_Caucasus,
                                Chat.kBeetleSubKind_Satanas,
                                Chat.kBeetleSubKind_Hercules,
                                Chat.kBeetleSubKind_JapanDorcusRectus,
                                Chat.kBeetleSubKind_JapanDorcusCurvidens,
                                Chat.kBeetleSubKind_ProsopocoilusGiraffa,
                                Chat.kBeetleSubKind_AllotopusRosenbergi,
                        },
                };
        int subKind = subKindTable[inLevelRegion][new Random().nextInt(8)];
//        Log.e("subKind", "" + subKind);
        arr_subkind.add(subKind);
        int kind = subKind / 1000;
        int CPU_species = Chat.convertSpeciesValue(subKind);
//        Log.e("inKind", "" + inKind);
        // ツノ
        int hornTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHornRank = hornTable[inLevelRegion][rank];
        part_horn = Chat.get_part(subKind, 0, imagoHornRank);
        arr_horn.add(part_horn);
        horn_cpu.add(imagoHornRank);
//        Log.e("part_horn", "" + part_horn);
        // ツノ２
        int horn2Table[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHorn2Rank = horn2Table[inLevelRegion][rank];
        horn2_cpu.add(imagoHorn2Rank);
        if (Chat.beetleHasBackHornAtSubKind(subKind)) {
            part_horn2 = Chat.get_part(subKind, 1, imagoHorn2Rank);
            arr_horn2.add(part_horn2);
        } else if (!Chat.beetleHasBackHornAtSubKind(subKind)) {
            arr_horn2.add("111222"); // dont exist id 111222
        }
        // ヘッド
        int headTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoHeadRank = headTable[inLevelRegion][rank];
        part_head = Chat.get_part(subKind, 2, imagoHeadRank);
        arr_head.add(part_head);
        head_cpu.add(imagoHeadRank);
//        Log.e("part_head", "" + part_head);
        // 顔
        int faceTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 4, 3, 4, 3, 4, 3, 4},
                        {4, 10, 4, 10, 4, 10, 4, 10},    // 10はアルビノ
                };
        imagoFaceRank = faceTable[inLevelRegion][rank];
        part_face = Chat.get_part(subKind, 3, imagoFaceRank);
        arr_face.add(part_face);
        face_cpu.add(imagoFaceRank);
        // 首
        int neckTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoNeckRank = neckTable[inLevelRegion][rank];
        part_neck = Chat.get_part(subKind, 4, imagoNeckRank);
        arr_neck.add(part_neck);
        if ((subKind == 0) || (subKind == 2) || (subKind == 3) || (subKind == 1003)) {
            if (imagoNeckRank > 2 && imagoNeckRank != 10)
                imagoNeckRank = 2;
        }
        if ((subKind == 1000) || (subKind == 1001) || (subKind == 1002)) {
            if (imagoNeckRank > 1 && imagoNeckRank != 10)
                imagoNeckRank = 1;
        }
        neck_cpu.add(imagoNeckRank);
        // 体
        int bodyTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {2, 3, 2, 3, 2, 3, 2, 3},
                        {4, 5, 6, 4, 5, 6, 5, 6},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoBodyRank = bodyTable[inLevelRegion][rank];
        part_body = Chat.get_part(subKind, 5, imagoBodyRank);
        arr_body.add(part_body);
        body_cpu.add(imagoBodyRank);
        // ハネ
        int wingTable[][] =
                {
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {1, 2, 3, 1, 2, 3, 1, 2},
                        {3, 3, 3, 3, 3, 3, 3, 3},
                        {10, 10, 10, 10, 10, 10, 10, 10},
                };
        imagoWingRank = wingTable[inLevelRegion][rank];
        part_wing = Chat.get_part(subKind, 6, imagoWingRank);
        arr_wing.add(part_wing);
        wing_cpu.add(imagoWingRank);
    }

    public void Runhome_parasol1_new() {
        if (anim_home_parasol1_new.isRunning()) {
            anim_home_parasol1_new.stop();
            home_parasol1_new.setLayerType(View.LAYER_TYPE_NONE, null);
            home_parasol1_new.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        anim_home_parasol1_new.start();
    }

    public void _anim_coin() {
        if (anim_coin.isRunning()) {
            anim_coin.stop();
            f_coin.setLayerType(View.LAYER_TYPE_NONE, null);
            f_coin.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        if (anim_jewel.isRunning()) {
            anim_jewel.stop();
            f_jewel.setLayerType(View.LAYER_TYPE_NONE, null);
            f_jewel.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        if (anim_shin1.isRunning()) {
            anim_shin1.stop();
            f_shin1.setLayerType(View.LAYER_TYPE_NONE, null);
            f_shin1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        if (anim_shin2.isRunning()) {
            anim_shin2.stop();
            f_shin2.setLayerType(View.LAYER_TYPE_NONE, null);
            f_shin2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        anim_coin.start();
        anim_jewel.start();
        anim_shin1.start();
        anim_shin2.start();
    }

    ImageView imgbutterfly, pill;
    int xX = 650, yY = 130;

    public void anim_animal() {
        imgbutterfly = (ImageView) findViewById(R.id.imgbutterfly);
        pill = (ImageView) findViewById(R.id.pill);
        pill.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        pill.setBackgroundResource(R.drawable.animation_pill);
        animpill = (AnimationDrawable) pill.getBackground();
        anim_pill = new TranslateAnimation(0, 450, 0, 0);
        anim_pill.setDuration(35000);
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
                params.leftMargin += 450;
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
        anim_pilllui = new TranslateAnimation(0, -450, 0, 0);
        anim_pilllui.setDuration(35000);
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
                params.leftMargin -= 450;
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
        imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        imgbutterfly.setBackgroundResource(R.drawable.animation_butterfly);
        frameAnimation = (AnimationDrawable) imgbutterfly.getBackground();
        anim_butterfly = new TranslateAnimation(0, xX, 0, -yY);
        anim_butterfly.setDuration(30000);
        anim_butterfly.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                if (frameAnimation.isRunning())
                    frameAnimation.stop();
                frameAnimation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgbutterfly.clearAnimation();
                imgbutterfly.setLayerType(View.LAYER_TYPE_NONE, null);
                imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                imgbutterfly.startAnimation(anim_butterfly2);
            }
        });
        anim_butterfly2 = new TranslateAnimation(0, xX, 0, yY);
        anim_butterfly2.setDuration(30000);
        anim_butterfly2.setAnimationListener(new TranslateAnimation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgbutterfly.clearAnimation();
                imgbutterfly.setLayerType(View.LAYER_TYPE_NONE, null);
                imgbutterfly.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                imgbutterfly.startAnimation(anim_butterfly);
            }
        });
        imgbutterfly.startAnimation(anim_butterfly);
    }

    ConnectionDetector cd;

    public void ErrorNetwork() {
        final Dialog dialogwhenbuy = new Dialog(mypage.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.dialogmenu4);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.txtcontent);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.btnOK);
        TextView txttitle = (TextView) dialogwhenbuy.findViewById(R.id.txttitle);
        TextView txtcontent = (TextView) dialogwhenbuy.findViewById(R.id.txtcontent);
        txtcontent.setText("情報を更新できませんでした。");
        txttitle.setText("ネットワークエラー");
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

    Timer timer;
    TimerTask timerTask;
    int _timer_test = 0, imgCur = 0;

    public void startTimer(ImageView root, int arr[]) {
        timer = new Timer();
        initializeTimerTask(root, arr);
        timer.schedule(timerTask, 0, 200);
    }

    public void initializeTimerTask(final ImageView root, final int arr[]) {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        root.setImageResource(arr[imgCur]);
                        imgCur++;
                        if (imgCur == arr.length) imgCur = 0;
                    }
                });
            }
        };
    }

    public void setCurPet(ImageView bodysell, String loai, int part) {
        if (loai.equals("loai1") && part == 0)
            startTimer(bodysell, Chat.body1_1);
        else if (loai.equals("loai1") && part == 1)
            startTimer(bodysell, Chat.body1_2);
        else if (loai.equals("loai1") && part == 2)
            startTimer(bodysell, Chat.body1_3);
        else if (loai.equals("loai1") && part == 3)
            startTimer(bodysell, Chat.body1_4);
        else if (loai.equals("loai1") && part == 4)
            startTimer(bodysell, Chat.body1_5);
        else if (loai.equals("loai1") && part == 5)
            startTimer(bodysell, Chat.body1_6);
        else if (loai.equals("loai1") && part == 6)
            startTimer(bodysell, Chat.body1_7);
        else if (loai.equals("loai1") && part == 7)
            startTimer(bodysell, Chat.body1_8);

        if (loai.equals("loai2") && part == 0)
            startTimer(bodysell, Chat.body2_1);
        else if (loai.equals("loai2") && part == 1)
            startTimer(bodysell, Chat.body2_2);
        else if (loai.equals("loai2") && part == 2)
            startTimer(bodysell, Chat.body2_3);
        else if (loai.equals("loai2") && part == 3)
            startTimer(bodysell, Chat.body2_4);
        else if (loai.equals("loai2") && part == 4)
            startTimer(bodysell, Chat.body2_5);
        else if (loai.equals("loai2") && part == 5)
            startTimer(bodysell, Chat.body2_6);
        else if (loai.equals("loai2") && part == 6)
            startTimer(bodysell, Chat.body2_7);
        else if (loai.equals("loai2") && part == 7)
            startTimer(bodysell, Chat.body2_8);

        if (loai.equals("loai3") && part == 0)
            startTimer(bodysell, Chat.body3_1);
        else if (loai.equals("loai3") && part == 1)
            startTimer(bodysell, Chat.body3_2);
        else if (loai.equals("loai3") && part == 2)
            startTimer(bodysell, Chat.body3_3);
        else if (loai.equals("loai3") && part == 3)
            startTimer(bodysell, Chat.body3_4);
        else if (loai.equals("loai3") && part == 4)
            startTimer(bodysell, Chat.body3_5);
        else if (loai.equals("loai3") && part == 5)
            startTimer(bodysell, Chat.body3_6);
        else if (loai.equals("loai3") && part == 6)
            startTimer(bodysell, Chat.body3_7);
        else if (loai.equals("loai3") && part == 7)
            startTimer(bodysell, Chat.body3_8);

        if (loai.equals("loai4") && part == 0)
            startTimer(bodysell, Chat.body4_1);
        else if (loai.equals("loai4") && part == 1)
            startTimer(bodysell, Chat.body4_2);
        else if (loai.equals("loai4") && part == 2)
            startTimer(bodysell, Chat.body4_3);
        else if (loai.equals("loai4") && part == 3)
            startTimer(bodysell, Chat.body4_4);
        else if (loai.equals("loai4") && part == 4)
            startTimer(bodysell, Chat.body4_5);
        else if (loai.equals("loai4") && part == 5)
            startTimer(bodysell, Chat.body4_6);
        else if (loai.equals("loai4") && part == 6)
            startTimer(bodysell, Chat.body4_7);
        else if (loai.equals("loai4") && part == 7)
            startTimer(bodysell, Chat.body4_8);

        if (loai.equals("loai5") && part == 0)
            startTimer(bodysell, Chat.body5_1);
        else if (loai.equals("loai5") && part == 1)
            startTimer(bodysell, Chat.body5_2);
        else if (loai.equals("loai5") && part == 2)
            startTimer(bodysell, Chat.body5_3);
        else if (loai.equals("loai5") && part == 3)
            startTimer(bodysell, Chat.body5_4);
        else if (loai.equals("loai5") && part == 4)
            startTimer(bodysell, Chat.body5_5);
        else if (loai.equals("loai5") && part == 5)
            startTimer(bodysell, Chat.body5_6);
        else if (loai.equals("loai5") && part == 6)
            startTimer(bodysell, Chat.body5_7);
        else if (loai.equals("loai5") && part == 7)
            startTimer(bodysell, Chat.body5_8);

        if (loai.equals("loai6") && part == 0)
            startTimer(bodysell, Chat.body6_1);
        else if (loai.equals("loai6") && part == 1)
            startTimer(bodysell, Chat.body6_2);
        else if (loai.equals("loai6") && part == 2)
            startTimer(bodysell, Chat.body6_3);
        else if (loai.equals("loai6") && part == 3)
            startTimer(bodysell, Chat.body6_4);
        else if (loai.equals("loai6") && part == 4)
            startTimer(bodysell, Chat.body6_5);
        else if (loai.equals("loai6") && part == 5)
            startTimer(bodysell, Chat.body6_6);
        else if (loai.equals("loai6") && part == 6)
            startTimer(bodysell, Chat.body6_7);
        else if (loai.equals("loai6") && part == 7)
            startTimer(bodysell, Chat.body6_8);

        if (loai.equals("loai7") && part == 0)
            startTimer(bodysell, Chat.body7_1);
        else if (loai.equals("loai7") && part == 1)
            startTimer(bodysell, Chat.body7_2);
        else if (loai.equals("loai7") && part == 2)
            startTimer(bodysell, Chat.body7_3);
        else if (loai.equals("loai7") && part == 3)
            startTimer(bodysell, Chat.body7_4);
        else if (loai.equals("loai7") && part == 4)
            startTimer(bodysell, Chat.body7_5);
        else if (loai.equals("loai7") && part == 5)
            startTimer(bodysell, Chat.body7_6);
        else if (loai.equals("loai7") && part == 6)
            startTimer(bodysell, Chat.body7_7);
        else if (loai.equals("loai7") && part == 7)
            startTimer(bodysell, Chat.body7_8);

        if (loai.equals("loai8") && part == 0)
            startTimer(bodysell, Chat.body8_1);
        else if (loai.equals("loai8") && part == 1)
            startTimer(bodysell, Chat.body8_2);
        else if (loai.equals("loai8") && part == 2)
            startTimer(bodysell, Chat.body8_3);
        else if (loai.equals("loai8") && part == 3)
            startTimer(bodysell, Chat.body8_4);
        else if (loai.equals("loai8") && part == 4)
            startTimer(bodysell, Chat.body8_5);
        else if (loai.equals("loai8") && part == 5)
            startTimer(bodysell, Chat.body8_6);
        else if (loai.equals("loai8") && part == 6)
            startTimer(bodysell, Chat.body8_7);
        else if (loai.equals("loai8") && part == 7)
            startTimer(bodysell, Chat.body8_8);
    }

    public void Restorebody(String loaisale, ImageView bodysell, int bodyNosale) {
        if (loaisale.equals("loai1"))
            bodysell.setImageResource(Chat.body[bodyNosale]);
        else if (loaisale.equals("loai2"))
            bodysell.setImageResource(Chat.body2[bodyNosale]);
        else if (loaisale.equals("loai3"))
            bodysell.setImageResource(Chat.body3[bodyNosale]);
        else if (loaisale.equals("loai4"))
            bodysell.setImageResource(Chat.body4[bodyNosale]);
        else if (loaisale.equals("loai5"))
            bodysell.setImageResource(Chat.body5[bodyNosale]);
        else if (loaisale.equals("loai6"))
            bodysell.setImageResource(Chat.body6[bodyNosale]);
        else if (loaisale.equals("loai7"))
            bodysell.setImageResource(Chat.body7[bodyNosale]);
        else if (loaisale.equals("loai8"))
            bodysell.setImageResource(Chat.body8[bodyNosale]);
    }

    Timer timer2;
    TimerTask timerTask2;

    public void startTimer2(String loaisale, ImageView bodysell, int bodyNosale) {
        timer2 = new Timer();
        initializeTimerTask2(loaisale, bodysell, bodyNosale);
        timer2.schedule(timerTask2, 0, 10000);
    }

    public void initializeTimerTask2(final String loaisale, final ImageView bodysell, final int bodyNosale) {
        timerTask2 = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        Restorebody(loaisale, bodysell, bodyNosale);
                        if (timer2 != null) {
                            timer2.cancel();
                            timer2 = null;
                        }
                    }
                });
            }
        };
    }

    Timer timer_anim;
    TimerTask timerTask_anim;
    int cur_flag = 0;

    public void startTimer_anim() {
        timer_anim = new Timer();
        initializeTimerTask_anim();
        timer_anim.schedule(timerTask_anim, 0, 6000);
    }

    public void initializeTimerTask_anim() {
        timerTask_anim = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        cur_flag++;
//                        Log.e("TAG", "cur_flag:" + cur_flag);
                        if (cur_flag > 5)
                            cur_flag = 0;
                        if (cur_flag == 1) {
                            if (anim_asura_forest.isRunning()) {
                                anim_asura_forest.stop();
                                asura_forest.setLayerType(View.LAYER_TYPE_NONE, null);
                                asura_forest.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            }
                            anim_asura_forest.start();
                            Runhome_parasol1_new();
                            _anim_coin();
                        }
                        if (cur_flag == 2) {
                            if (anim_forest_a1.isRunning()) {
                                anim_forest_a1.stop();
                                forest_a1.setLayerType(View.LAYER_TYPE_NONE, null);
                                forest_a1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            }
                            anim_forest_a1.start();
                        }
                        if (cur_flag == 2 || cur_flag == 4) {
                            handler.postDelayed(jump_battle, 300);
                        }
                        if (cur_flag == 3) {
                            handler.postDelayed(jump_asura, 300);
                            _anim_coin();
                        }
                        if (cur_flag == 5) {
                            handler.postDelayed(jump_battle, 300);
                            Runhome_parasol1_new();
                            _anim_coin();
                            if (anim_forest_a1.isRunning()) {
                                anim_forest_a1.stop();
                                forest_a1.setLayerType(View.LAYER_TYPE_NONE, null);
                                forest_a1.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                            }
                            anim_forest_a1.start();
                        }
                    }
                });
            }
        };
    }

    int cur_runBattle = 0, cur_runAsura = 0;
    Runnable jump_battle = new Runnable() {
        @Override
        public void run() {
            cur_runBattle++;
            handler.postDelayed(this, 300);
            if (cur_runBattle > 7) {
                cur_runBattle = 0;
                handler.removeCallbacks(jump_battle);
            }
            if (cur_runBattle == 1 && !bsound)
                word_battle_b.startAnimation(jump_anim);
            if (cur_runBattle == 2 && !bsound)
                word_battle_a.startAnimation(jump_anim);
            if (cur_runBattle == 3 && !bsound)
                word_battle_t1.startAnimation(jump_anim);
            if (cur_runBattle == 4 && !bsound)
                word_battle_t2.startAnimation(jump_anim);
            if (cur_runBattle == 5 && !bsound)
                word_battle_l.startAnimation(jump_anim);
            if (cur_runBattle == 6 && !bsound)
                word_battle_e.startAnimation(jump_anim);
            if (cur_runBattle == 7 && !bsound)
                word_battle_ex_mark.startAnimation(jump_anim);
        }
    };
    Runnable jump_asura = new Runnable() {
        @Override
        public void run() {
            cur_runAsura++;
            handler.postDelayed(this, 300);
            if (cur_runAsura > 4) {
                cur_runAsura = 0;
                handler.removeCallbacks(jump_asura);
            }
            if (cur_runAsura == 1 && !bsound)
                word_asura1.startAnimation(jump_anim);
            if (cur_runAsura == 2 && !bsound)
                word_asura2.startAnimation(jump_anim);
            if (cur_runAsura == 3 && !bsound)
                word_asura3.startAnimation(jump_anim);
            if (cur_runAsura == 4 && !bsound)
                word_asura4.startAnimation(jump_anim);
        }
    };
}