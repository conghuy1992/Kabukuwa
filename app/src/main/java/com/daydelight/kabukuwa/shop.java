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
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.daydelight.kabukuwa.util.IabHelper;
import com.daydelight.kabukuwa.util.IabResult;
import com.daydelight.kabukuwa.util.Inventory;
import com.daydelight.kabukuwa.util.Purchase;
import com.daydelight.kabukuwa.util.Security;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.daydelight.kabukuwa.R;

/**
 * Created by goood on 5/18/15.
 */
public class shop extends Activity {
    MediaPlayer soundbg;
    Animation animScale;
    private static final String TAG = "com.daydelight.kabukuwa";
    IabHelper mHelper;
    String tempid = "", tempdis = "", tempjewel = "", temprarity = "", tempnumitem = "", tempcoin = "";
    static final String ITEM_SKU = "kabukuwacoin_1000";
    static final String ITEM_SKU2 = "kabukuwacoin_5000";
    static final String ITEM_SKU3 = "kabukuwajewel_10";
    static final String ITEM_SKU4 = "kabukuwajewel_50";
    ImageView mphead, mpface, mphorn, mphorn2, bgmphead, bgmpface, bgmphorn, bgmphorn2, f_coin, f_jewel, f_shin1, f_shin2;
    AnimationDrawable anim_coin, anim_jewel, anim_shin1, anim_shin2;
    ImageView imgback, img_11, btnBuy, btnSell, imgbreeding, imgmochimono, imggacha, imgfriend, imgshop, imgmenu;
    TextView txtdong1, txtdong2, txtdong3, txtnampet, txtkind, fighttext, foresttext;
    TextView txtcoin, txtjewel, formatcoin, formatjewel, textView21, txtlv;
    public static TextView txtphantram, txtHp;
    int _PAY, _BUY, _FOODSMALL, _FOODBIG, _FOODBIG2, _FOODBIG3, _FOODBIG4, _FOODBIG5, _FOODBIG6, _FOODBIG7, _FOODBIG8,
            _DRINKSMALL, _DRINKBIG, _ITEMSMALL, _ITEMBIG, _ITEMBIG2, _ITEMBIG3, _ITEMBIG4, _ITEMBIG5, _ITEMGOLD, _price_sale, SubType;
    DataStt stt = new DataStt();
    List<DataStt> listDataStt;
    private long mLastClickTime = 0;
    int postemp;
    List<TablePart> _listTablePart;
    ViewAdapter adapter;
    FrameLayout topdialog;
    private PublisherAdView mAdView;
    DecimalFormat formatter;
    ProgressIndicator indicator;
    public static ProgressBar progressBar3, prhp;
    AdapterMono adapterMono, adapterMonoItem, adapterMonoDrink;
    ArrayList<String> content;
    ArrayList<String> coin;
    ArrayList<String> jewel;
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

    ArrayList<Integer> _idItem;
    ArrayList<Integer> _idItemShow;
    ArrayList<Integer> _idFood;
    ArrayList<Integer> _idFoodShow;
    ArrayList<Integer> _idDrink;
    ArrayList<Integer> _idDrinkShow;

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
    ArrayList<String> numitem;
    ArrayList<String> numitemDisplay;
    ArrayList<String> rarityDisplay;
    ArrayList<String> itemIdShopDisplay;
    ArrayList<String> DesnameDisplay;
    ArrayList<String> coinDisplay;
    ArrayList<String> jewelDisplay;

    LinearLayout layoutLevel, lnlvpet;

    private ItemArrayAdapter itemArrayAdapter, partitemAdapter;
    String strclose = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_shopdetail);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        animation = AnimationUtils.loadAnimation(shop.this, R.anim.trans_left_in);
        soundbg = MediaPlayer.create(this, R.raw.bgm003);
        soundbg.setLooping(true);
        Button btn = (Button) findViewById(R.id.button21);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtcoin.setText("100000");
                formatjewel.setText("1,000");
                formatcoin.setText("100,000");
                txtjewel.setText("1000");
                _ITEMBIG4 = 99;
            }
        });
        Dialog_Buy();
        DialogFood();
        DialogDrink();
        DialogItem();
        Dialog_Egg();
        Dialog_Coin();
        Dialog_Jewel();
        lnlvpet = (LinearLayout) findViewById(R.id.lnlvpet);
        txtnampet = (TextView) findViewById(R.id.txtnampet);
        txtkind = (TextView) findViewById(R.id.txtkind);
        txtHp = (TextView) findViewById(R.id.txthp);
        fighttext = (TextView) findViewById(R.id.fighttext);
        foresttext = (TextView) findViewById(R.id.foresttext);
        layoutLevel = (LinearLayout) findViewById(R.id.layoutLevel);
        indicator = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator1);
        indicator.setForegroundColor(Color.parseColor("#ebbd36"));
        indicator.setBackgroundColor(Color.parseColor("#000000"));
        indicator.setPieStyle(true);
        indicator.setValue(mypage.valueindicator);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
        formatter = new DecimalFormat("#,###,###");
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlncjDDV6AiqlkAeGzt/QW/lNWmCf5SYf2wAOQc9mx0wMwg1B2La/xu7qnuVgyng/Pb8PPVWQzkq3rQvNXMdiglEufxnjkYnGY7u1rIqWvMj5ddreOMsjhab15FfNJNQ1kAi85P8nMXjYu8L+3hs9mRJkujLV6CC5lI+R/XZb2/wSqjtKzOwuz5DgWx7cjN+Hzdv2/4/gzvlsfzaQjDlzBDM5bhpZheQB4tJGlWePVGsOznGiXsnaTJCadJ4SDlMyRybnW0xyfQ5WvB8lOvgmM4lSGJMMz2MV0y90n42P9xIegmzVzfHEqfZmvH5rP4DdcgRd83Ez++bzYdXwlYynmQIDAQAB";
        mHelper = new IabHelper(shop.this, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    Log.e("TAG", "" + "In-app Billing setup failed: " + result);
                } else {
                    consume();
//                    Log.e("TAG", "" + "In-app Billing is set up OK");
                }
            }
        });
        //
        db = new dbHandler(this);
        listDataStt = db.getAllDataStt();
        //
        topdialog = (FrameLayout) findViewById(R.id.topdialog);
        btnBuy = (ImageView) findViewById(R.id.btnBuy);
        btnSell = (ImageView) findViewById(R.id.btnSell);
        formatcoin = (TextView) findViewById(R.id.formatcoin);
        formatjewel = (TextView) findViewById(R.id.formatjewel);
        f_coin = (ImageView) findViewById(R.id.f_coin);
        f_jewel = (ImageView) findViewById(R.id.f_jewel);
        f_shin1 = (ImageView) findViewById(R.id.f_shin1);
        f_shin2 = (ImageView) findViewById(R.id.f_shin2);
        f_coin.setBackgroundResource(R.drawable.animation_coin);
        anim_coin = (AnimationDrawable) f_coin.getBackground();
        f_jewel.setBackgroundResource(R.drawable.animation_jewel);
        anim_jewel = (AnimationDrawable) f_jewel.getBackground();
        f_shin1.setBackgroundResource(R.drawable.animation_shine);
        anim_shin1 = (AnimationDrawable) f_shin1.getBackground();
        f_shin2.setBackgroundResource(R.drawable.animation_shine);
        anim_shin2 = (AnimationDrawable) f_shin2.getBackground();
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                HideTopLayout();
                dialogBuy.show();
            }
        });
        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                HideTopLayout();
                Dialog_Sale();
            }
        });
        //
        txtcoin = (TextView) findViewById(R.id.txtcoin);
        txtjewel = (TextView) findViewById(R.id.txtjewel);
        img_11 = (ImageView) findViewById(R.id.imageView11);
        imgback = (ImageView) findViewById(R.id.imgback);
        img_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
//                if (strclose.equals("zukan")) {
//                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
//                    SharedPreferences.Editor editor = pre.edit();
//                    editor.putInt("exitfromzukan", 1);
//                    editor.commit();
//                }
//                if (strclose.equals("mypage")) {
//                    finish();
//                }
//                if (strclose.equals("battle")) {
//                    Intent i = new Intent(shop.this, Battle.class);
//                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    i.putExtra("dialog", "shop");
//                    startActivity(i);
//                    finish();
//                }
//                if (!strclose.equals("mypage") && !strclose.equals("battle")) {
//                    Intent i = new Intent(shop.this, zukan_main.class);
//                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    i.putExtra("flag", "shop");
//                    startActivity(i);
//                    finish();
//                }
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                editor.putString("gotomypage", "gotomypage");
                editor.commit();
                finish();
            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                finish();
            }
        });
        mphead = (ImageView) findViewById(R.id.mphead);
        mpface = (ImageView) findViewById(R.id.mpface);
        mphorn = (ImageView) findViewById(R.id.mphorn);
        mphorn2 = (ImageView) findViewById(R.id.mphorn2);
        bgmphead = (ImageView) findViewById(R.id.bgmphead);
        bgmpface = (ImageView) findViewById(R.id.bgmpface);
        bgmphorn = (ImageView) findViewById(R.id.bgmphorn);
        bgmphorn2 = (ImageView) findViewById(R.id.bgmphorn2);
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        Intent intent = getIntent();

        String _loai = intent.getStringExtra("loaisale");
//        int _wing = intent.getIntExtra("wingNosale", 0);
        int _face = intent.getIntExtra("faceNosale", 0);
//        int _neck = intent.getIntExtra("neckNosale", 0);
//        int _body = intent.getIntExtra("bodyNosale", 0);
        int _horn2 = intent.getIntExtra("horn2Nosale", 0);
        int _horn = intent.getIntExtra("hornNosale", 0);
        int _head = intent.getIntExtra("headNosale", 0);
        int _mat = intent.getIntExtra("matsale", 0);
//        int _lv = intent.getIntExtra("_level", 0);
        int _lv = mypage._level;
        if (mypage._checkpet == 1) {
            lnlvpet.setVisibility(View.VISIBLE);
//            txtHp.setText("" + intent.getIntExtra("_hp", 0) + "/" + mypage.pl_hp);
            txtHp.setText("" + mypage._hp + "/" + mypage.pl_hp);

//            txtnampet.setText("" + intent.getStringExtra("namesell"));
            txtnampet.setText("" + mypage.namesell);
//            txtkind.setText("" + intent.getStringExtra("hangsell"));
            txtkind.setText("" + mypage.hangsell);
            fighttext.setText("" + mypage._fightSum + "戦 " + mypage._fightWin + "勝");
            foresttext.setText("0戦 0勝");
        }
        final String mypage = intent.getStringExtra("dialog");
        strclose = intent.getStringExtra("dialog");
//        if (mypage.equals("gacha"))
//            finish();
        if (mypage.equals("mypage"))
            ShowTopLayout();
        if (mypage.equals("food"))
            dialogFood.show();
        if (mypage.equals("drink"))
            dialogDrink.show();
        if (mypage.equals("item"))
            dialogItem.show();
        int sizelvnick = 11;
        if (com.daydelight.kabukuwa.mypage._Width <= 480)
            sizelvnick = 9;
        DrawLevel(lnlvpet, _lv, sizelvnick);
        try {
            if (com.daydelight.kabukuwa.mypage._checkpet == 1)
                _setIMG(com.daydelight.kabukuwa.mypage.loaisale, _face, _head, _horn, _horn2, _mat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean bchk = pre.getBoolean("checked", false);
        if (bchk == true) {
            int smoney = pre.getInt("money", 0);
            int sjewel = pre.getInt("jewel", 0);
            formatcoin.setText(formatter.format(smoney));
            formatjewel.setText(formatter.format(sjewel));
            txtcoin.setText("" + smoney);
            txtjewel.setText("" + sjewel);

        }
        imgbreeding = (ImageView) findViewById(R.id.imgbreeding);
        imgmochimono = (ImageView) findViewById(R.id.imgmochimono);
        imggacha = (ImageView) findViewById(R.id.imggacha);
        imgfriend = (ImageView) findViewById(R.id.imgfriend);
        imgshop = (ImageView) findViewById(R.id.imgshop);
        imgmenu = (ImageView) findViewById(R.id.imgmenu);
        imgbreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (strclose.equals("zukan")) {
//                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
//                    SharedPreferences.Editor editor = pre.edit();
//                    editor.putInt("exitfromzukan", 1);
//                    editor.commit();
                    finish();
                }
                if (!strclose.equals("zukan")) {
                    EGG_CLICK = -1;
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
                        Intent intent = new Intent(shop.this, zukan_main.class);
                        intent.putExtra("flag", "mypage");
                        startActivity(intent);
                        finish();
                    } else if (ten1.length() == 0 || ten2.length() == 0 || ten3.length() == 0 || ten4.length() == 0
                            || ten5.length() == 0 || ten6.length() == 0 || ten7.length() == 0 || ten8.length() == 0) {
                        DialogCreatePet();
                    }
                }
            }
        });
        imgmochimono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                Dialog_Mochimono();
            }
        });
        imggacha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                Intent i = new Intent(shop.this, Gacha.class);
                i.putExtra("flag", "shop");
                startActivity(i);
            }

        });
        imgfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                shownotifyWhenBuy();
                txtyesbutton.setText("この機能はただいま準備中です。しばらくお待ち下さい。");
            }
        });
        imgshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
            }
        });
        imgmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _ShowDialog();
            }
        });
        txtphantram = (TextView) findViewById(R.id.txtphantram);
        txtlv = (TextView) findViewById(R.id.txtlv);
        txtlv.setText("" + pre.getInt("lv", 1));
        String str = "" + pre.getInt("lv", 1);
        String[] arr = str.split("");
        int sizelv_nick = 12;
        if (com.daydelight.kabukuwa.mypage._Width <= 480)
            sizelv_nick = 9;
        for (int i = 0; i < arr.length; i++) {
            ImageView img = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(sizelv_nick, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(1, 0, 0, 0);
            img.setLayoutParams(params);
            img.setAdjustViewBounds(true);
            if (arr[i].equals("0"))
                img.setImageResource(R.drawable.num0);
            if (arr[i].equals("1"))
                img.setImageResource(R.drawable.num1);
            if (arr[i].equals("2"))
                img.setImageResource(R.drawable.num2);
            if (arr[i].equals("3"))
                img.setImageResource(R.drawable.num3);
            if (arr[i].equals("4"))
                img.setImageResource(R.drawable.num4);
            if (arr[i].equals("5"))
                img.setImageResource(R.drawable.num5);
            if (arr[i].equals("6"))
                img.setImageResource(R.drawable.num6);
            if (arr[i].equals("7"))
                img.setImageResource(R.drawable.num7);
            if (arr[i].equals("8"))
                img.setImageResource(R.drawable.num8);
            if (arr[i].equals("9"))
                img.setImageResource(R.drawable.num9);
            layoutLevel.addView(img);
        }
        int maxHp = pre.getInt("lv", 1) * 10;
        txtphantram.setText("" + com.daydelight.kabukuwa.mypage.theluc + "/" + maxHp);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        prhp = (ProgressBar) findViewById(R.id.prhp);
        prhp.setMax(com.daydelight.kabukuwa.mypage.pl_hp);
        prhp.setProgress(com.daydelight.kabukuwa.mypage._hp);
        progressBar3.setMax(pre.getInt("lv", 1) * 10);
        progressBar3.setProgress(pre.getInt("theluc", pre.getInt("lv", 1) * 10));
        txtten = (TextView) findViewById(R.id.txtten);
        txtten.setText("" + pre.getString("nickname", ""));
        TextView txttitle = (TextView) findViewById(R.id.txttitle);
        int curLv = pre.getInt("lv", 1) - 1;
        if (curLv >= com.daydelight.kabukuwa.mypage._title.length)
            curLv = com.daydelight.kabukuwa.mypage._title.length - 1;
        txttitle.setText(com.daydelight.kabukuwa.mypage._title[com.daydelight.kabukuwa.mypage.rank]);
        runAnim();
    }

    public void Dialog_Mochimono() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        dialogmochimono = new Dialog(shop.this);
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
        itemId = new ArrayList<String>();
        itemDes = new ArrayList<String>();
        itemName = new ArrayList<String>();
        rarity = new ArrayList<String>();
        coins = new ArrayList<String>();
        jewels = new ArrayList<String>();
        itemIdShop = new ArrayList<String>();
        itemNameShop = new ArrayList<String>();
        rarityShop = new ArrayList<String>();
        coinsShop = new ArrayList<String>();
        jewelsShop = new ArrayList<String>();
        itemDesShop = new ArrayList<String>();
        itemDesName = new ArrayList<String>();
        final ArrayList<String> numitem = new ArrayList<String>();
        final ArrayList<String> numitemDisplay = new ArrayList<String>();
        final ArrayList<String> rarityDisplay = new ArrayList<String>();
        final ArrayList<String> itemIdShopDisplay = new ArrayList<String>();
        final ArrayList<String> DesnameDisplay = new ArrayList<String>();
        final ArrayList<String> coinDisplay = new ArrayList<String>();
        final ArrayList<String> jewelDisplay = new ArrayList<String>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileShop csvFile = new CSVFileShop(inputStream);
        List<String[]> scoreList = csvFile.read();
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
                if (key.length() == 2)
                    key = "000" + key;
                if (key.length() == 3)
                    key = "00" + key;
                if (key.length() == 4)
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
                if (!jewelsShop.get(i).equals(""))
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
                }
                if (str.substring(0, 3).equals("101")) {
                    name = "caucasus";
                    kind = "コーカサスオオカブト";
                }
                if (str.substring(0, 3).equals("102")) {
                    name = "satanas";
                    kind = "サタンオオカブト";
                }
                if (str.substring(0, 3).equals("103")) {
                    name = "hercules";
                    kind = "ヘラクレスオオカブト";
                }
                if (str.substring(0, 3).equals("110")) {
                    name = "kokuwagata";
                    kind = "コクワガタ";
                }
                if (str.substring(0, 3).equals("111")) {
                    name = "oukuwagata";
                    kind = "オオクワガタ";
                }
                if (str.substring(0, 3).equals("112")) {
                    name = "giraffa";
                    kind = "ギラファノコギリクワガタ";
                }
                if (str.substring(0, 3).equals("113")) {
                    name = "golden";
                    kind = "オウゴンオニクワガタ";
                }
                if (str.substring(3, 4).equals("0"))
                    part = "horn";
                if (str.substring(3, 4).equals("1"))
                    part = "horn2";
                if (str.substring(3, 4).equals("2"))
                    part = "head";
                if (str.substring(3, 4).equals("3"))
                    part = "face";
                if (str.substring(3, 4).equals("4"))
                    part = "neck";
                if (str.substring(3, 4).equals("5"))
                    part = "body";
                if (str.substring(3, 4).equals("6"))
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
                    TextView t = new TextView(shop.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
        arrnumber = new ArrayList<String>();
        content = new ArrayList<String>();
        coin = new ArrayList<String>();
        jewel = new ArrayList<String>();
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
        arrnumberDrink.add("" + _DRINKSMALL);
        arrnumberDrink.add("" + _DRINKBIG);
        imgDrink.add(R.drawable.drink_icon);
        imgDrink.add(R.drawable.new_shop_icon_drink2);
        fooddong2Drink.add("富士山の雪解け水が濾過されたミネラルたっぷりな水。");
        fooddong2Drink.add("昆虫に必要な栄養素も含んだスペシャルドリンク");
        fooddong3Drink.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3Drink.add("[" + mypage.namesell + "]" + "に使用しますか？");
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
        arrnumberItem.add("" + _ITEMSMALL);
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
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("飼育時に使用できます。");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
        fooddong3.add("[" + mypage.namesell + "]" + "に使用しますか？");
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
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("0");
        jewel.add("1");
        coin.add("10");
        coin.add("30");
        coin.add("10");
        coin.add("30");
        coin.add("30");
        coin.add("30");
        coin.add("0");
        coin.add("0");
        content.add("マットごはん[幼虫用]");
        content.add("マットごはんスペシャル[幼虫用]");
        content.add("昆虫ゼリー[成虫用]");
        content.add("スペシャルゼリー[成虫用]");
        content.add("腐葉土ごはん[幼虫用]");
        content.add("菌糸ごはん[幼虫用]");
        content.add("樹液[成虫用]");
        content.add("焼酎バナナ[成虫用]");
        String str1 = "" + _FOODSMALL;
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
                coinShow.add(coin.get(i));
                jewelShow.add(jewel.get(i));
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
                    if (mypage._checkpet == 1) {
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
                    TextView t = new TextView(shop.this);
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
                    TextView t = new TextView(shop.this);
                    t.setLayoutParams(params);
                    t.setBackgroundResource(R.drawable.battle_difficulty_star);
                    lnstar.addView(t);
                }
            }
        });
        //
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
                if (mypage._checkpet == 1) {
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
                    TextView t = new TextView(shop.this);
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

    public void HideLayoutItem() {
        flagBack = true;
        layoutitem.setVisibility(View.GONE);
        btncloselayoutitem.setBackgroundResource(R.drawable.btn_back);
    }

    Button btncloselayoutitem;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowLayoutItem() {
        flagBack = false;
        btncloselayoutitem.setBackgroundResource(R.drawable.btn_close);
//        animation.setDuration(500);
        layoutitem.setVisibility(View.VISIBLE);
//        layoutitem.setAnimation(animation);
//        layoutitem.animate();
//        animation.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowFoodItem() {
//        animation.setDuration(500);
        fooditem.setVisibility(View.VISIBLE);
//        fooditem.setAnimation(animation);
//        fooditem.animate();
//        animation.start();
    }

    public void ShowPartItem() {
//        animation.setDuration(500);
        partitem.setVisibility(View.VISIBLE);
//        fooditem.setAnimation(animation);
//        fooditem.animate();
//        animation.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowDrinkItem() {
//        animation.setDuration(500);
        drinkitem.setVisibility(View.VISIBLE);
//        drinkitem.setAnimation(animation);
//        drinkitem.animate();
//        animation.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowItemItem() {
//        animation.setDuration(500);
        itemitem.setVisibility(View.VISIBLE);
//        itemitem.setAnimation(animation);
//        itemitem.animate();
//        animation.start();
    }

    public void HideAllItem() {
        fooditem.setVisibility(View.GONE);
        drinkitem.setVisibility(View.GONE);
        itemitem.setVisibility(View.GONE);
        partitem.setVisibility(View.GONE);
    }

    ImageView mpdialogitemicon;
    ListView fooditem, itemitem, drinkitem, partitem;
    LinearLayout layoutitem;
    Animation animation;
    Dialog dialogmochimono, mpdialogitem;
    boolean flagBack = false;

    public void _ShowDialog() {
        final Dialog dialog = new Dialog(shop.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_menudetail);
        Button img = (Button) dialog.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
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
//                dialog.dismiss();
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(shop.this, DesLevel.class);
                    intent.putExtra("flag", "shop");
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                dialog.dismiss();
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(shop.this, mypageMenu2.class);
                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                dialog.dismiss();
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(shop.this, mypageMenu3.class);
                    startActivity(intent);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                dialog.dismiss();
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(shop.this, mypageMenu4.class);
                    startActivity(intent);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                dialog.dismiss();
                if (!bsound) {
                    bsound = true;
                    v.startAnimation(mypage.animScale);
                    Intent intent = new Intent(shop.this, mypageMenu5.class);
                    startActivity(intent);
                }
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void HideTopLayout() {
        topdialog.setVisibility(View.GONE);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void ShowTopLayout() {
//        Animation animation = AnimationUtils.loadAnimation(shop.this, R.anim.trans_left_in);
//        animation.setDuration(500);
        topdialog.setVisibility(View.VISIBLE);
//        topdialog.setAnimation(animation);
//        topdialog.animate();
//        animation.start();
    }


    Dialog dialogBuy, dialogJewel, dialogFood, dialogDrink, dialogItem, dialogEgg, dialogCoin, dialogbuyshop, dialogSale;
    TextView txtten, txthang, txtgiaban;

    TextView txtyesbutton, zk_title;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(shop.this);
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

    dbHandler db;
    DuLieu duLieu;
    GridView listView;
    ListView listItemSell;

    public void Dialog_Sale() {
        dialogSale = new Dialog(shop.this);
        dialogSale.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogSale.setContentView(R.layout.sell_layout);
        dialogSale.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogSale.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogSale.setCanceledOnTouchOutside(false);
        //
        TextView nopet = (TextView) dialogSale.findViewById(R.id.nopet);
        int gia = db.getCount();
        if (gia == 0) {
            nopet.setVisibility(View.VISIBLE);
        }
        listItemSell = (ListView) dialogSale.findViewById(R.id.listItemSell);
        Button btnback = (Button) dialogSale.findViewById(R.id.button13);
        final Button btnleftright = (Button) dialogSale.findViewById(R.id.btnleftright);
        final TextView txtleft = (TextView) dialogSale.findViewById(R.id.txtleft);
        final TextView txtright = (TextView) dialogSale.findViewById(R.id.txtright);
        final FrameLayout layoutsellpet = (FrameLayout) dialogSale.findViewById(R.id.layoutsellpet);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogSale.dismiss();
                ShowTopLayout();
            }
        });
        listView = (GridView) dialogSale.findViewById(R.id.listView1);
        listDulieu = db.getPetTruongThanh();
        _listTablePart = db.getAllPart();
        duLieu = new DuLieu();
        adapter = new ViewAdapter();
        try {
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                btnleftright.setBackgroundResource(R.drawable.tab_left);
                txtright.setTextSize(10);
                txtleft.setTextSize(13);
                listItemSell.setVisibility(View.VISIBLE);
                layoutsellpet.setVisibility(View.GONE);
            }
        });
        txtright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                btnleftright.setBackgroundResource(R.drawable.tab_right);
                txtright.setTextSize(13);
                txtleft.setTextSize(10);
                listItemSell.setVisibility(View.GONE);
                layoutsellpet.setVisibility(View.VISIBLE);
            }
        });
        //
        itemId = new ArrayList<String>();
        itemDes = new ArrayList<String>();
        itemName = new ArrayList<String>();
        rarity = new ArrayList<String>();
        coins = new ArrayList<String>();
        jewels = new ArrayList<String>();
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
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileShop csvFile = new CSVFileShop(inputStream);
        List<String[]> scoreList = csvFile.read();
        for (int i = 1; i < itemId.size(); i++) {
            itemIdShop.add(itemId.get(i));
            rarityShop.add(rarity.get(i));
            jewelsShop.add(jewels.get(i));
            String str = coins.get(i);
            int a = Integer.parseInt(str) / 10;
            String b = "" + a;
            coinsShop.add(b);
            String key = itemId.get(i);
            if (Integer.parseInt(key) < 100000) {
                if (key.length() == 1)
                    key = "0000" + key;
                if (key.length() == 2)
                    key = "000" + key;
                if (key.length() == 3)
                    key = "00" + key;
                if (key.length() == 4)
                    key = "0" + key;
                int _num = pre.getInt(key, 0);
                String value = "" + _num;
                if (key.equals("01001"))
                    value = "" + _FOODSMALL;
                if (key.equals("01003"))
                    value = "" + _FOODBIG;
                if (key.equals("01013"))
                    value = "" + _FOODBIG2;
                if (key.equals("01014"))
                    value = "" + _FOODBIG3;
                if (key.equals("01011"))
                    value = "" + _FOODBIG4;
                if (key.equals("01012"))
                    value = "" + _FOODBIG5;
                if (key.equals("03003"))
                    value = "" + _FOODBIG6;
                if (key.equals("01015"))
                    value = "" + _FOODBIG7;
                if (key.equals("01016"))
                    value = "" + _FOODBIG8;
                if (key.equals("00001"))
                    value = "" + _DRINKSMALL;
                if (key.equals("00003"))
                    value = "" + _DRINKBIG;
                if (key.equals("03001"))
                    value = "" + _ITEMSMALL;
                if (key.equals("03002"))
                    value = "" + _ITEMBIG;
                if (key.equals("03004"))
                    value = "" + _ITEMBIG2;
                if (key.equals("03005"))
                    value = "" + _ITEMBIG3;
                if (key.equals("03006"))
                    value = "" + _ITEMBIG4;
                if (key.equals("03007"))
                    value = "" + _ITEMBIG5;
                long k = Long.parseLong(key);
                int v = Integer.parseInt(value);
                db.update_Sumpart(k, v);
            }
            if (Integer.parseInt(itemId.get(i)) < 100000) {
                itemDesName.add(itemName.get(i));
                String s = "" + _listTablePart.get(i - 1).getSum();
                numitem.add(s);
            }
            if (Integer.parseInt(itemId.get(i)) >= 100000) {
                itemDesName.add(itemDes.get(i));
                int remaining = _listTablePart.get(i - 1).getSum() - _listTablePart.get(i - 1).getNum();
                String s = "" + remaining;
                numitem.add(s);
            }
        }
        for (int i = 0; i < numitem.size(); i++) {
            if (Integer.parseInt(numitem.get(i)) > 0) {
                numitemDisplay.add(numitem.get(i));
                rarityDisplay.add(rarityShop.get(i));
                DesnameDisplay.add(itemDesName.get(i));
                coinDisplay.add(coinsShop.get(i));
                itemIdShopDisplay.add(itemIdShop.get(i));
                if (jewelsShop.get(i).equals(""))
                    jewelDisplay.add("0");
                if (!jewelsShop.get(i).equals(""))
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

        itemArrayAdapter = new ItemArrayAdapter(this, DesnameDisplay, coinDisplay, jewelDisplay, rarityDisplay, itemIdShopDisplay, numitemDisplay);
        try {
            listItemSell.setAdapter(itemArrayAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listItemSell.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                CreateNumberPicker(Integer.parseInt(numitemDisplay.get(position)));
                txttop.setText("[" + DesnameDisplay.get(position) + "]を何個売りますか？");
            }
        });
        dialogSale.show();
    }

    int pos = 0;

    public void Dialog_Buy() {
        dialogBuy = new Dialog(shop.this);
        dialogBuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBuy.setContentView(R.layout.dialogbuy_icon);
        dialogBuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogBuy.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        Button button16 = (Button) dialogBuy.findViewById(R.id.button16);
        ImageView btnfood = (ImageView) dialogBuy.findViewById(R.id.btnfood);
        ImageView btndrink = (ImageView) dialogBuy.findViewById(R.id.btndrink);
        ImageView btnitem = (ImageView) dialogBuy.findViewById(R.id.btnitem);
        ImageView btnegg = (ImageView) dialogBuy.findViewById(R.id.btnegg);
        ImageView btncoin = (ImageView) dialogBuy.findViewById(R.id.btncoin);
        ImageView btnjewel = (ImageView) dialogBuy.findViewById(R.id.btnjewel);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogBuy.dismiss();
                ShowTopLayout();
            }
        });
        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogFood.show();
            }
        });
        btndrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogDrink.show();
            }
        });
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogItem.show();
            }
        });
        btnegg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogEgg.show();
            }
        });
        btncoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogCoin.show();
            }
        });
        btnjewel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                dialogBuy.dismiss();
                dialogJewel.show();
            }
        });
        dialogBuy.setCanceledOnTouchOutside(false);
    }

    public void Dialog_Jewel() {
        dialogJewel = new Dialog(shop.this);
        dialogJewel.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogJewel.setContentView(R.layout.jewel_layout);
        dialogJewel.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogJewel.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        Button btnBack = (Button) dialogJewel.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogJewel.dismiss();
                dialogBuy.show();
            }
        });
        ImageView _ln1 = (ImageView) dialogJewel.findViewById(R.id.img1);
        ImageView _ln2 = (ImageView) dialogJewel.findViewById(R.id.img2);
        _ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _PAY = 3;
                DialogBuyShop_COIN();
                btnCoin.setVisibility(View.GONE);
                _price.setText("¥ " + "120");
                formatprice.setText("¥ " + "120");
                imageView12.setImageResource(R.drawable.itm_jewel_handful);
                txt16.setText("ひとつかみのジュエル");
            }
        });
        _ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _PAY = 4;
                DialogBuyShop_COIN();
                btnCoin.setVisibility(View.GONE);
                _price.setText("¥ " + "360");
                formatprice.setText("¥ " + "360");
                imageView12.setImageResource(R.drawable.itm_jewel_many);
                txt16.setText("一袋のジュエル");
            }
        });
        dialogJewel.setCanceledOnTouchOutside(false);
    }

    public void Dialog_Coin() {
        dialogCoin = new Dialog(shop.this);
        dialogCoin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCoin.setContentView(R.layout.coin_layout);
        dialogCoin.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogCoin.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogCoin.setCanceledOnTouchOutside(false);
        Button btnBack = (Button) dialogCoin.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogCoin.dismiss();
                dialogBuy.show();
            }
        });
        ImageView _ln1 = (ImageView) dialogCoin.findViewById(R.id.img1);
        ImageView _ln2 = (ImageView) dialogCoin.findViewById(R.id.img2);
        _ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _PAY = 1;
                DialogBuyShop_COIN();
                btnCoin.setVisibility(View.GONE);
                _price.setText("¥ " + "120");
                formatprice.setText("¥ " + "120");
                imageView12.setImageResource(R.drawable.itm_coin_handful);
                txt16.setText("ひとつかみのコイン");
            }
        });
        _ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop_COIN();
                _PAY = 2;
                btnCoin.setVisibility(View.GONE);
                _price.setText("¥ " + "360");
                formatprice.setText("¥ " + "360");
                imageView12.setImageResource(R.drawable.itm_coin_many);
                txt16.setText("一袋のコイン");
            }
        });
    }

    int EGG_CLICK = 0;

    public void Dialog_Egg() {
        dialogEgg = new Dialog(shop.this);
        dialogEgg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEgg.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogEgg.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogEgg.setContentView(R.layout.egg_layout);
        Button btnBack = (Button) dialogEgg.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogEgg.dismiss();
                dialogBuy.show();
            }
        });
        dialogEgg.setCanceledOnTouchOutside(false);
        FrameLayout fr1 = (FrameLayout) dialogEgg.findViewById(R.id.fr1);
        FrameLayout fr2 = (FrameLayout) dialogEgg.findViewById(R.id.fr2);
        FrameLayout fr3 = (FrameLayout) dialogEgg.findViewById(R.id.fr3);
        FrameLayout fr4 = (FrameLayout) dialogEgg.findViewById(R.id.fr4);
        FrameLayout fr5 = (FrameLayout) dialogEgg.findViewById(R.id.fr5);
        FrameLayout fr6 = (FrameLayout) dialogEgg.findViewById(R.id.fr6);
        FrameLayout fr7 = (FrameLayout) dialogEgg.findViewById(R.id.fr7);
        FrameLayout fr8 = (FrameLayout) dialogEgg.findViewById(R.id.fr8);
        FrameLayout fr9 = (FrameLayout) dialogEgg.findViewById(R.id.fr9);
        FrameLayout fr10 = (FrameLayout) dialogEgg.findViewById(R.id.fr10);
        FrameLayout fr11 = (FrameLayout) dialogEgg.findViewById(R.id.fr11);
        FrameLayout fr12 = (FrameLayout) dialogEgg.findViewById(R.id.fr12);
        FrameLayout fr13 = (FrameLayout) dialogEgg.findViewById(R.id.fr13);
        FrameLayout fr14 = (FrameLayout) dialogEgg.findViewById(R.id.fr14);
        FrameLayout fr15 = (FrameLayout) dialogEgg.findViewById(R.id.fr15);
        FrameLayout fr16 = (FrameLayout) dialogEgg.findViewById(R.id.fr16);
        fr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 1;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("カブトムシは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("1000");
                    formatprice.setText("1,000");
                    txt16.setText("カブトムシ");
                }
            }
        });
        fr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 3;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan2", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("2000");
                    formatprice.setText("2,000");
                    txt16.setText("コクワガタ");
                }
            }
        });
        fr5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                EGG_CLICK = 5;
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan3", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コーカサスオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("5000");
                    formatprice.setText("5,000");
                    txt16.setText("コーカサスオオカブト");
                }

            }
        });
        fr7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                EGG_CLICK = 7;
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan4", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("オオクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("10000");
                    formatprice.setText("10,000");
                    txt16.setText("オオクワガタ");
                }
            }
        });
        fr9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 9;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan5", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("サタンオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("10000");
                    formatprice.setText("10,000");
                    txt16.setText("サタンオオカブト");
                }
            }
        });
        fr11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 11;

                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan6", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ギラファノコギリクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("20000");
                    formatprice.setText("20,000");
                    txt16.setText("ギラファノコギリクワガタ");
                }

            }
        });
        fr13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                EGG_CLICK = 13;
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan7", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("オウゴンオニクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("40000");
                    formatprice.setText("40,000");
                    txt16.setText("オウゴンオニクワガタ");
                }
            }
        });
        fr15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 20;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan8", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ヘラクレスオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    Dialogbuyshop_Egg();
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price.setText("50000");
                    formatprice.setText("50,000");
                    txt16.setText("ヘラクレスオオカブト");
                }
            }
        });
        fr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 1;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("カブトムシは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("2");
                    _price.setText("1000");
                    formatprice.setText("1,000");
                    txt16.setText("カブトムシ");
                }
            }
        });
        fr4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 3;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan2", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("4");
                    _price.setText("2000");
                    formatprice.setText("2,000");
                    txt16.setText("コクワガタ");
                }
            }
        });
        fr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 5;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan3", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コーカサスオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("10");
                    _price.setText("5000");
                    formatprice.setText("5,000");
                    txt16.setText("コーカサスオオカブト");
                }
            }
        });
        fr8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 7;

                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan4", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("オオクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("10");
                    _price.setText("10000");
                    formatprice.setText("10,000");
                    txt16.setText("オオクワガタ");
                }
            }
        });
        fr10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 9;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan5", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("サタンオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("20");
                    _price.setText("10000");
                    formatprice.setText("10,000");
                    txt16.setText("サタンオオカブト");
                }
            }
        });
        fr12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 11;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan6", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ギラファノコギリクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("40");
                    _price.setText("20000");
                    formatprice.setText("20,000");
                    txt16.setText("ギラファノコギリクワガタ");
                }
            }
        });
        fr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                EGG_CLICK = 13;
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan7", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("オウゴンオニクワガタは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("80");
                    _price.setText("40000");
                    formatprice.setText("40,000");
                    txt16.setText("オウゴンオニクワガタ");
                }
            }
        });
        fr16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                EGG_CLICK = 20;
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                String ten = pre.getString("tenzukan8", "");
                if (ten.length() > 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ヘラクレスオオカブトは現在飼育中です。" + "\n"
                            + "同種の飼育が終わるまでは購入" + "\n" + "できません。");
                } else {
                    DialogBuyShop_EGG();
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                    imageView12.setImageResource(R.drawable.new_shop_icon_egg);
                    _price2.setText("100");
                    formatprice.setText("50,000");
                    _price.setText("50000");
                    txt16.setText("ヘラクレスオオカブト");
                }
            }
        });

    }

    public void DialogItem() {
        dialogItem = new Dialog(shop.this);
        dialogItem.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogItem.setContentView(R.layout.item_layout);
        dialogItem.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogItem.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogItem.setCanceledOnTouchOutside(false);
        Button btnBack = (Button) dialogItem.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogItem.dismiss();
                dialogBuy.show();
            }
        });
        ImageView imageView_shopItem = (ImageView) dialogItem.findViewById(R.id.imageView_shopItem);
        ImageView img2 = (ImageView) dialogItem.findViewById(R.id.img2);
        ImageView img3 = (ImageView) dialogItem.findViewById(R.id.img3);
        ImageView img4 = (ImageView) dialogItem.findViewById(R.id.img4);
        ImageView img5 = (ImageView) dialogItem.findViewById(R.id.img5);
        ImageView img6 = (ImageView) dialogItem.findViewById(R.id.img6);
        imageView_shopItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop_ITEM();
                _BUY = 5;
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("1");
                _price.setText("1");
                formatprice.setText("1");
                imageView12.setImageResource(R.drawable.item_icon);
                txt16.setText("成長促進剤2倍 x 1");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop_ITEM();
                _BUY = 6;
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("5");
                _price.setText("5");
                formatprice.setText("5");
                imageView12.setImageResource(R.drawable.new_shop_icon_item2);
                txt16.setText("成長促進剤10倍 x 1");
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 14;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("20");
                _price.setText("20");
                formatprice.setText("20");
                imageView12.setImageResource(R.drawable.itm_runpa1);
                txt16.setText("お掃除ルンパ x 1");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 15;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("50");
                _price.setText("50");
                formatprice.setText("50");
                imageView12.setImageResource(R.drawable.itm_medicine1);
                txt16.setText("若返りの薬 x 1");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 16;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("50");
                _price.setText("50");
                formatprice.setText("50");
                imageView12.setImageResource(R.drawable.itm_medicine2);
                txt16.setText("進化の薬 x 1");
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 17;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("30");
                _price.setText("30");
                formatprice.setText("30");
                imageView12.setImageResource(R.drawable.itm_o2_capsule);
                txt16.setText("酸素カプセル x 1");
            }
        });
    }

    public void DialogDrink() {
        dialogDrink = new Dialog(shop.this);
        dialogDrink.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogDrink.setContentView(R.layout.drink_layout);
        dialogDrink.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogDrink.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialogDrink.setCanceledOnTouchOutside(false);
        Button btnBack = (Button) dialogDrink.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogDrink.dismiss();
                dialogBuy.show();
            }
        });
        ImageView imageView_shopDrink = (ImageView) dialogDrink.findViewById(R.id.imageView_shopDrink);
        ImageView img2 = (ImageView) dialogDrink.findViewById(R.id.img2);
        imageView_shopDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 3;
                imageView12.setImageResource(R.drawable.drink_icon);
                txt16.setText("ミネラルウオーターｘ１０");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 4;
                imageView12.setImageResource(R.drawable.new_shop_icon_drink2);
                _price.setText("300");
                formatprice.setText("300");
                txt16.setText("スペシャルジュースｘ１０ ");

            }
        });

    }

    ImageView imageView12, buysellshop, btnCoin, btnCoin2;
    TextView _price, _price2, formatprice;

    TextView txt16;

    public void DialogBuyShop_COIN() {
        dialogbuyshop = new Dialog(shop.this);
        dialogbuyshop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop.findViewById(R.id.btnitem);
        _price = (TextView) dialogbuyshop.findViewById(R.id.txtprice);
        _price2 = (TextView) dialogbuyshop.findViewById(R.id.txtprice2);
        formatprice = (TextView) dialogbuyshop.findViewById(R.id.formatprice);
        btnCoin = (ImageView) dialogbuyshop.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop.findViewById(R.id.textView16);
        dialogbuyshop.setCanceledOnTouchOutside(false);
        ImageView yes = (ImageView) dialogbuyshop.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop.findViewById(R.id.btnno);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (_PAY == 1) {
                    mHelper.launchPurchaseFlow(shop.this, ITEM_SKU, 10001,
                            mPurchaseFinishedListener, "coin1000");
                }
                if (_PAY == 2) {
                    mHelper.launchPurchaseFlow(shop.this, ITEM_SKU2, 10005,
                            mPurchaseFinishedListener, "coin5000");
                }
                if (_PAY == 3) {
                    mHelper.launchPurchaseFlow(shop.this, ITEM_SKU3, 10003,
                            mPurchaseFinishedListener, "jewel10");
                }
                if (_PAY == 4) {
                    mHelper.launchPurchaseFlow(shop.this, ITEM_SKU4, 10007,
                            mPurchaseFinishedListener, "jewel50");
                }
                dialogbuyshop.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
            }
        });
        dialogbuyshop.show();
    }

    int moneyj = 0;
    int jewelj = 0;

    public void DialogBuyShop_EGG() {
        dialogbuyshop = new Dialog(shop.this);
        dialogbuyshop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop.findViewById(R.id.btnitem);
        _price = (TextView) dialogbuyshop.findViewById(R.id.txtprice);
        formatprice = (TextView) dialogbuyshop.findViewById(R.id.formatprice);
        _price2 = (TextView) dialogbuyshop.findViewById(R.id.txtprice2);
        btnCoin = (ImageView) dialogbuyshop.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop.findViewById(R.id.textView16);
        dialogbuyshop.setCanceledOnTouchOutside(false);
        ImageView yes = (ImageView) dialogbuyshop.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop.findViewById(R.id.btnno);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
                int a, b, c, j, b2, d;
                a = Integer.parseInt(txtcoin.getText().toString());
                b = Integer.parseInt(_price.getText().toString());
                moneyj = b;
                //
                j = Integer.parseInt(txtjewel.getText().toString());
                b2 = Integer.parseInt(_price2.getText().toString());
                jewelj = b2;
                if (j < b2) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ジュエルが足りません。");
                    return;
                }

                if (a < b) {
//                    AlertDialog.Builder dialog2 = new AlertDialog.Builder(shop.this);
//                    dialog2.setMessage("コインが足りません。");
//                    dialog2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    AlertDialog dialog = dialog2.show();
//                    dialog.setCanceledOnTouchOutside(false);
//                    TextView messageText = (TextView) dialog.findViewById(android.R.id.message);
//                    messageText.setGravity(Gravity.CENTER);
//                    dialog.show();
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コインが足りません。");
                    return;
                }
                //
                tienShop = b;
                Create_Character2();
                //


            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
            }
        });
        dialogbuyshop.show();

    }

    public void DialogBuyShop_ITEM() {
        dialogbuyshop = new Dialog(shop.this);
        dialogbuyshop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop.findViewById(R.id.btnitem);
        _price = (TextView) dialogbuyshop.findViewById(R.id.txtprice);
        formatprice = (TextView) dialogbuyshop.findViewById(R.id.formatprice);
        _price2 = (TextView) dialogbuyshop.findViewById(R.id.txtprice2);
        btnCoin = (ImageView) dialogbuyshop.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop.findViewById(R.id.textView16);

        ImageView yes = (ImageView) dialogbuyshop.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop.findViewById(R.id.btnno);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
                int j = Integer.parseInt(txtjewel.getText().toString());
                int b2 = Integer.parseInt(_price2.getText().toString());
                if (j < b2) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ジュエルが足りません。");
                    return;
                }
                int d = j - b2;
                txtjewel.setText("" + d);
                formatjewel.setText(formatter.format(d));
                if (_BUY == 5) {
                    _ITEMSMALL += 1;
//                    db.update_Sumpart(3001,_ITEMSMALL);
                }
                if (_BUY == 6) {
                    _ITEMBIG += 1;
//                    db.update_Sumpart(3002,_ITEMBIG);
                }
                if (_BUY == 11) {
                    _FOODBIG6 += 1;
//                    db.update_Sumpart(3003,_FOODBIG6);
                }
                if (_BUY == 12) {
                    _FOODBIG7 += 10;
//                    db.update_Sumpart(1015,_FOODBIG7);
                }
                if (_BUY == 13) {
                    _FOODBIG8 += 10;
//                    db.update_Sumpart(1016,_FOODBIG8);
                }
                if (_BUY == 14) {
                    _ITEMBIG2 += 1;
//                    db.update_Sumpart(3004,_ITEMBIG2);
                }
                if (_BUY == 15) {
                    _ITEMBIG3 += 1;
//                    db.update_Sumpart(3005,_ITEMBIG3);
                }
                if (_BUY == 16) {
                    _ITEMBIG4 += 1;
//                    db.update_Sumpart(3006,_ITEMBIG4);
                }
                if (_BUY == 17) {
                    _ITEMBIG5 += 1;
//                    db.update_Sumpart(3007,_ITEMBIG5);
                }
                shownotifyWhenBuy();
                txtyesbutton.setText("[" + txt16.getText().toString() + "]" + "を購入しました。");
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
            }
        });
        dialogbuyshop.setCanceledOnTouchOutside(false);
        dialogbuyshop.show();

    }

    Dialog dialogbuyshop_egg;

    public void Dialogbuyshop_Egg() {
        dialogbuyshop_egg = new Dialog(shop.this);
        dialogbuyshop_egg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop_egg.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop_egg.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop_egg.findViewById(R.id.btnitem);
        _price = (TextView) dialogbuyshop_egg.findViewById(R.id.txtprice);
        formatprice = (TextView) dialogbuyshop_egg.findViewById(R.id.formatprice);
        _price2 = (TextView) dialogbuyshop_egg.findViewById(R.id.txtprice2);
        btnCoin = (ImageView) dialogbuyshop_egg.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop_egg.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop_egg.findViewById(R.id.textView16);
        dialogbuyshop_egg.setCanceledOnTouchOutside(false);
        ImageView yes = (ImageView) dialogbuyshop_egg.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop_egg.findViewById(R.id.btnno);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop_egg.dismiss();
                int a = Integer.parseInt(txtcoin.getText().toString());
                int b = Integer.parseInt(_price.getText().toString());
                if (a < b) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コインが足りません。");
                    return;
                }
                tienShop = b;
                Create_Character();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop_egg.dismiss();
            }
        });
        dialogbuyshop_egg.show();

    }

    public void DialogBuyShop() {
        dialogbuyshop = new Dialog(shop.this);
        dialogbuyshop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop.findViewById(R.id.btnitem);
        _price = (TextView) dialogbuyshop.findViewById(R.id.txtprice);
        formatprice = (TextView) dialogbuyshop.findViewById(R.id.formatprice);
        _price2 = (TextView) dialogbuyshop.findViewById(R.id.txtprice2);
        btnCoin = (ImageView) dialogbuyshop.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop.findViewById(R.id.textView16);

        ImageView yes = (ImageView) dialogbuyshop.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop.findViewById(R.id.btnno);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogbuyshop.dismiss();
                int a = Integer.parseInt(txtcoin.getText().toString());
                int b = Integer.parseInt(_price.getText().toString());
                if (a < b) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("コインが足りません。");
                    return;
                }
                int c = a - b;
                txtcoin.setText("" + c);
                formatcoin.setText(formatter.format(c));
                if (_BUY == 1) {
                    _FOODSMALL += 10;
//                    db.update_Sumpart(1001, _FOODSMALL);
                }
                if (_BUY == 2) {
                    _FOODBIG += 10;
//                    db.update_Sumpart(1003, _FOODBIG);
                }
                if (_BUY == 3) {
                    _DRINKSMALL += 10;
//                    db.update_Sumpart(1, _DRINKSMALL);
                }
                if (_BUY == 4) {
                    _DRINKBIG += 10;
//                    db.update_Sumpart(3, _DRINKBIG);
                }
                if (_BUY == 7) {
                    _FOODBIG2 += 10;
//                    db.update_Sumpart(1013, _FOODBIG2);
                }
                if (_BUY == 8) {
                    _FOODBIG3 += 10;
//                    db.update_Sumpart(1014, _FOODBIG3);
                }
                if (_BUY == 9) {
                    _FOODBIG4 += 10;
//                    db.update_Sumpart(1011, _FOODBIG4);
                }
                if (_BUY == 10) {
                    _FOODBIG5 += 10;
//                    db.update_Sumpart(1012, _FOODBIG5);
                }
                shownotifyWhenBuy();
                txtyesbutton.setText("[" + txt16.getText().toString() + "]" + "を購入しました。");
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogbuyshop.dismiss();
            }
        });
        dialogbuyshop.setCanceledOnTouchOutside(false);
        dialogbuyshop.show();

    }

    public void DialogFood() {
        dialogFood = new Dialog(shop.this);
        dialogFood.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogFood.setContentView(R.layout.food_layout);
        dialogFood.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogFood.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        Button btnBack = (Button) dialogFood.findViewById(R.id.button12);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                dialogFood.dismiss();
                dialogBuy.show();
            }
        });
        ImageView imageView_shopCoin = (ImageView) dialogFood.findViewById(R.id.imageView_shopCoin);
        ImageView img2 = (ImageView) dialogFood.findViewById(R.id.img2);
        ImageView img3 = (ImageView) dialogFood.findViewById(R.id.img3);
        ImageView img4 = (ImageView) dialogFood.findViewById(R.id.img4);
        ImageView img5 = (ImageView) dialogFood.findViewById(R.id.img5);
        ImageView img6 = (ImageView) dialogFood.findViewById(R.id.img6);
        ImageView img7 = (ImageView) dialogFood.findViewById(R.id.img7);
        ImageView img8 = (ImageView) dialogFood.findViewById(R.id.img8);
        ImageView img9 = (ImageView) dialogFood.findViewById(R.id.img9);
        imageView_shopCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 1;
                _price.setText("100");
                formatprice.setText("100");
                txt16.setText("マットごはん x 10");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 2;
                _price.setText("300");
                formatprice.setText("300");
                txt16.setText("マットごはんスペシャル x 10");
                imageView12.setImageResource(R.drawable.itm_rice4);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 7;
                _price.setText("300");
                formatprice.setText("300");
                imageView12.setImageResource(R.drawable.itm_rice3);
                txt16.setText("腐葉土ごはん x 10");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 8;
                _price.setText("300");
                formatprice.setText("300");
                imageView12.setImageResource(R.drawable.itm_rice2);
                txt16.setText("菌糸ごはん x 10");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 9;
                _price.setText("100");
                formatprice.setText("100");
                imageView12.setImageResource(R.drawable.itm_jelly1);
                txt16.setText("昆虫ゼリー x 10");
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                DialogBuyShop();
                _BUY = 10;
                _price.setText("300");
                formatprice.setText("300");
                imageView12.setImageResource(R.drawable.itm_jelly2);
                txt16.setText("スペシャルゼリー x 10");
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 11;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("5");
                _price.setText("5");
                formatprice.setText("5");
                imageView12.setImageResource(R.drawable.itm_liquor);
                txt16.setText("鞆の浦の保命酒 x 1");
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 12;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("5");
                _price.setText("5");
                formatprice.setText("5");
                imageView12.setImageResource(R.drawable.itm_sap);
                txt16.setText("樹液 x 10");
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                _BUY = 13;
                DialogBuyShop_ITEM();
                btnCoin.setImageResource(R.drawable.jewel_icon);
                _price2.setText("10");
                _price.setText("10");
                formatprice.setText("10");
                imageView12.setImageResource(R.drawable.itm_banana);
                txt16.setText("焼酎バナナ x 10");
            }
        });
        dialogFood.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bsound = false;
        flaganim.set(true);
        if (mAdView != null) {
            mAdView.resume();
        }
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        txtcoin.setText("" + pre.getInt("money", 0));
        formatcoin.setText("" + formatter.format(pre.getInt("money", 0)));
        txtjewel.setText("" + pre.getInt("jewel", 0));
        formatjewel.setText("" + formatter.format(pre.getInt("jewel", 0)));
        _FOODSMALL = pre.getInt("01001", 0);
        _FOODBIG = pre.getInt("01003", 0);
        _FOODBIG2 = pre.getInt("01013", 0);
        _FOODBIG3 = pre.getInt("01014", 0);
        _FOODBIG4 = pre.getInt("01011", 0);
        _FOODBIG5 = pre.getInt("01012", 0);
        _FOODBIG6 = pre.getInt("03003", 0);
        _FOODBIG7 = pre.getInt("01015", 0);
        _FOODBIG8 = pre.getInt("01016", 0);

        _DRINKSMALL = pre.getInt("00001", 0);
        _DRINKBIG = pre.getInt("00003", 0);
        _ITEMSMALL = pre.getInt("03001", 0);
        _ITEMBIG = pre.getInt("03002", 0);
        _ITEMBIG2 = pre.getInt("03004", 0);
        _ITEMBIG3 = pre.getInt("03005", 0);
        _ITEMBIG4 = pre.getInt("03006", 0);
        _ITEMBIG5 = pre.getInt("03007", 0);
        _ITEMGOLD = pre.getInt("03008", 0);
        try {
            if (pre.getBoolean("sound", true) == true) {
                soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pre.getString("gotomypage", "").equals("gotomypage")) {
            finish();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
        if (mHelper != null)
            mHelper.dispose();
        mHelper = null;
    }


    boolean bsound = false;

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        flaganim.set(false);
        bsound = true;
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        //
        editor.putInt("03001", _ITEMSMALL);
        editor.putInt("03002", _ITEMBIG);
        editor.putInt("03004", _ITEMBIG2);
        editor.putInt("03005", _ITEMBIG3);
        editor.putInt("03006", _ITEMBIG4);
        editor.putInt("03007", _ITEMBIG5);
        editor.putInt("01001", _FOODSMALL);
        editor.putInt("01003", _FOODBIG);
        editor.putInt("01013", _FOODBIG2);
        editor.putInt("01014", _FOODBIG3);
        editor.putInt("01011", _FOODBIG4);
        editor.putInt("01012", _FOODBIG5);
        editor.putInt("03003", _FOODBIG6);
        editor.putInt("01015", _FOODBIG7);
        editor.putInt("01016", _FOODBIG8);
        editor.putInt("00001", _DRINKSMALL);
        editor.putInt("00003", _DRINKBIG);
        editor.putInt("money", Integer.parseInt(txtcoin.getText().toString()));
        editor.putInt("jewel", Integer.parseInt(txtjewel.getText().toString()));
        editor.commit();
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

    Context context = this;
    List<DuLieu> listDulieu;
    List<DuLieuShowPet> listDataShowpet;
    int idpetsell, nuoi, mat, hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, sale, live,
            nuoisale, matsale, hornNosale, horn2Nosale, wingNosale, headNosale, neckNosale, faceNosale, bodyNosale, salesale, livesale,
            personalitysale, _excreteSsale, _satietysale, _sleepsale, _strengthsale, _excreteBsale, _formsale, _sizesale, _moisturesale,
            _healthsale, mood, clearn, _attack, _criticalAttack, _defense, _critical, _avoid, _lucky, _speed, _level, _exp;
    float tuoi, tuoisale;
    double _hp;
    long _phaseETime, _bornTime, _phaseTime, lastCleanTime;
    String Name, Hang, Tien, Tiensale, loai, loaisale, namesell, hangsell, beetleID;

    public class ViewAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public ViewAdapter() {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return listDulieu.size();
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
                convertView = inflater.inflate(R.layout.custom_layout, null);
            }
            Name = listDulieu.get(position).getContent();
            Hang = listDulieu.get(position).getHang();
            Tien = listDulieu.get(position).getTien();
            loai = listDulieu.get(position).getLoai();
            live = listDulieu.get(position).getLive();
            sale = listDulieu.get(position).getSale();
            tuoi = listDulieu.get(position).getTuoi();
            nuoi = listDulieu.get(position).getNuoi();
            mat = listDulieu.get(position).getMat();
            hornNo = listDulieu.get(position).getHornNo();
            if (hornNo > 7)
                hornNo = 7;
            horn2No = listDulieu.get(position).getHorn2No();
            if (horn2No > 7)
                horn2No = 7;
            wingNo = listDulieu.get(position).getWingNo();
            if (wingNo > 4)
                wingNo = 4;
            headNo = listDulieu.get(position).getHeadNo();
            if (headNo > 7)
                headNo = 7;
            neckNo = listDulieu.get(position).getNeckNo();
            faceNo = listDulieu.get(position).getFaceNo();
            if (faceNo > 5)
                faceNo = 5;
            bodyNo = listDulieu.get(position).getBodyNo();
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
            //
            FrameLayout bgfrhorn = (FrameLayout) convertView.findViewById(R.id.bghorn);
            FrameLayout bgfrhorn2 = (FrameLayout) convertView.findViewById(R.id.bghorn2);
            FrameLayout bgfrdau = (FrameLayout) convertView.findViewById(R.id.bgdau);
            FrameLayout bgfrbody = (FrameLayout) convertView.findViewById(R.id.bgbody);
            FrameLayout bgfrcanh = (FrameLayout) convertView.findViewById(R.id.bgcanh);
            FrameLayout bgfrco = (FrameLayout) convertView.findViewById(R.id.bgco);
            FrameLayout bgfrmat = (FrameLayout) convertView.findViewById(R.id.bgmat);
            //
            TextView textView = (TextView) convertView.findViewById(R.id.txtten);
            TextView txthang = (TextView) convertView.findViewById(R.id.txthang);
            TextView txtgiaban = (TextView) convertView.findViewById(R.id.txtgiaban);
            TextView formatgiaban = (TextView) convertView.findViewById(R.id.formatgiaban);
            FrameLayout btnsell = (FrameLayout) convertView.findViewById(R.id.btnsell);
//            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(150,
//                    200);
//            params.gravity = Gravity.CENTER;
//            btnsell.setLayoutParams(params);
            textView.setText("" + Name);
            txthang.setText("" + Hang);
            int beetleSubType = Chat.converkind(loai);
            int _pricesale = Chat.priceImageWithType(beetleSubType, wingNo, bodyNo, neckNo, headNo, faceNo, hornNo, horn2No);
            txtgiaban.setText("" + _pricesale);
            formatgiaban.setText("" + formatter.format(_pricesale));
            //
            if (loai.equals("loai1") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
//                bgfrdau.setBackgroundResource(Chat.bghead[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn[hornNo]);
                //
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
            }
            if (loai.equals("loai2") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
//                bgfrdau.setBackgroundResource(Chat.bghead2[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing2[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody2[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck2[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn2[hornNo]);
                //
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
            }
            if (loai.equals("loai3") && tuoi >= 5) {
                if (neckNo > 4)
                    neckNo = 4;
//                bgfrdau.setBackgroundResource(Chat.bghead3[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing3[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody3[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck3[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn3[hornNo]);
//                bgfrhorn2.setBackgroundResource(Chat.bghorn33[horn2No]);
                //
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
            }
            //
            if (loai.equals("loai4") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
//                bgfrdau.setBackgroundResource(Chat.bghead4[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing4[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody4[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck4[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn4[hornNo]);
                //
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
            }
//
            if (loai.equals("loai5") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
//                bgfrdau.setBackgroundResource(Chat.bghead5[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing5[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody5[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck5[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn5[hornNo]);
//                bgfrhorn2.setBackgroundResource(Chat.bghorn55[horn2No]);
                //
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
            }
//
            if (loai.equals("loai6") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
//                bgfrdau.setBackgroundResource(Chat.bghead6[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing6[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody6[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck6[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn6[hornNo]);
                //
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
            }
//
            if (loai.equals("loai7") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
//                bgfrdau.setBackgroundResource(Chat.bghead7[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing7[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody7[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck7[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn7[hornNo]);
                //
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
            }
//
            if (loai.equals("loai8") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
//                bgfrdau.setBackgroundResource(Chat.bghead8[headNo]);
//                bgfrcanh.setBackgroundResource(mypage.bgwing8[wingNo]);
//                bgfrbody.setBackgroundResource(mypage.bgbody8[bodyNo]);
//                bgfrco.setBackgroundResource(mypage.bgneck8[neckNo]);
//                bgfrhorn.setBackgroundResource(Chat.bghorn8[hornNo]);
//                bgfrhorn2.setBackgroundResource(Chat.bghorn88[horn2No]);
                //
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
            //
            btnsell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.startAnimation(mypage.animScale);
                    if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                        return;
                    }
                    mLastClickTime = SystemClock.elapsedRealtime();
                    listDataShowpet = db.getAllShowpet();
                    postemp = position;
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    idpetsell = listDulieu.get(position).getId();
                    namesell = listDulieu.get(position).getContent();
                    hangsell = listDulieu.get(position).getHang();
                    Tiensale = listDulieu.get(position).getTien();
                    loaisale = listDulieu.get(position).getLoai();
                    livesale = listDulieu.get(position).getLive();
                    salesale = listDulieu.get(position).getSale();
                    tuoisale = listDulieu.get(position).getTuoi();
                    nuoisale = listDulieu.get(position).getNuoi();
                    matsale = listDulieu.get(position).getMat();
                    hornNosale = listDulieu.get(position).getHornNo();
                    if (hornNosale > 7) hornNosale = 7;
                    horn2Nosale = listDulieu.get(position).getHorn2No();
                    if (horn2Nosale > 7) horn2Nosale = 7;
                    wingNosale = listDulieu.get(position).getWingNo();
                    if (wingNosale > 4) wingNosale = 4;
                    headNosale = listDulieu.get(position).getHeadNo();
                    if (headNosale > 7) headNosale = 7;
                    neckNosale = listDulieu.get(position).getNeckNo();
                    faceNosale = listDulieu.get(position).getFaceNo();
                    if (faceNosale > 5) faceNosale = 5;
                    bodyNosale = listDulieu.get(position).getBodyNo();
                    if (bodyNosale > 7) bodyNosale = 7;
                    personalitysale = listDulieu.get(position).getPersonality();
                    _excreteSsale = listDulieu.get(position).getExcreteS();
                    _satietysale = listDulieu.get(position).getSatiety();
                    _sleepsale = listDulieu.get(position).getSleep();
                    _phaseETime = listDulieu.get(position).getPhaseETime();
                    _strengthsale = listDulieu.get(position).getStrength();
                    _bornTime = listDulieu.get(position).getBornTime();
                    _excreteBsale = listDulieu.get(position).getExcreteB();
                    _formsale = listDulieu.get(position).getForm();
                    _phaseTime = listDulieu.get(position).getPhaseTime();
                    _sizesale = listDulieu.get(position).getSize();
                    _moisturesale = listDulieu.get(position).getMoisture();
                    _healthsale = listDulieu.get(position).getHealth();
                    mood = listDulieu.get(position).getMood();
                    clearn = listDulieu.get(position).getClearn();
                    lastCleanTime = listDulieu.get(position).getLastCleanTime();
                    beetleID = listDulieu.get(position).getBeetleID();

                    _hp = listDulieu.get(position).getHp();
                    _attack = listDulieu.get(position).getAttack();
                    _criticalAttack = listDulieu.get(position).getCriticalAttack();
                    _defense = listDulieu.get(position).getDefense();
                    _critical = listDulieu.get(position).getCritical();
                    _avoid = listDulieu.get(position).getAvoid();
                    _lucky = listDulieu.get(position).getLucky();
                    _speed = listDulieu.get(position).getSpeed();
                    _level = listDulieu.get(position).getLevel();
                    _exp = listDulieu.get(position).getExp();
                    DialogSellPet();
                    txtnamesell.setText("" + namesell + " Lv." + _level);
                    SubType = Chat.converkind(loaisale);
//                    Log.e("TAG", "kind:" + SubType + ":" + wingNosale + ":" + bodyNosale + ":" + neckNosale + ":" + headNosale
//                            + ":" + faceNosale + ":" + hornNosale + ":" + horn2Nosale);
                    _price_sale = Chat.priceImageWithType(SubType, wingNosale, bodyNosale, neckNosale, headNosale,
                            faceNosale, hornNosale, horn2Nosale);
                    txtpricesell.setText("" + _price_sale);
                    txtpriceformat.setText("" + formatter.format(Integer.parseInt("" + _price_sale)));
                    if (loaisale.equals("loai1") && tuoisale >= 5) {
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
                    }
                    //
                    if (loaisale.equals("loai2") && tuoisale >= 5) {
                        if (neckNosale > 2)
                            neckNosale = 2;
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
                    }

                    if (loaisale.equals("loai3") && tuoisale >= 5) {
                        if (neckNosale > 4)
                            neckNosale = 4;
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
                    }

                    if (loaisale.equals("loai4") && tuoisale >= 5) {
                        if (neckNosale > 2)
                            neckNosale = 2;
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
                    }
                    //
                    if (loaisale.equals("loai5") && tuoisale >= 5) {
                        if (neckNosale > 3)
                            neckNosale = 3;
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
                    }
                    //
                    if (loaisale.equals("loai6") && tuoisale >= 5) {
                        if (neckNosale > 2)
                            neckNosale = 2;
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
                    }
                    //
                    if (loaisale.equals("loai7") && tuoisale >= 5) {
                        if (neckNosale > 3)
                            neckNosale = 3;
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
                    }
                    //
                    if (loaisale.equals("loai8") && tuoisale >= 5) {
                        if (neckNosale > 3)
                            neckNosale = 3;
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
                    }
                }
            });

            return convertView;
        }
    }

    Dialog createcharacter;
    EditText editText;

    public void Create_Character() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        createcharacter = new Dialog(shop.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        textView21 = (TextView) createcharacter.findViewById(R.id.textView21);
        if (EGG_CLICK == 3) {
            textView21.setText("コクワガタ");
        }
        if (EGG_CLICK == 5) {
            textView21.setText("コーカサスオオカブト");
        }
        if (EGG_CLICK == 7) {
            textView21.setText("オオクワガタ");
        }
        if (EGG_CLICK == 9) {
            textView21.setText("サタンオオカブト");
        }
        if (EGG_CLICK == 11) {
            textView21.setText("ギラファノコギリクワガタ");
        }
        if (EGG_CLICK == 13) {
            textView21.setText("オウゴンオニクワガタ");
        }
        if (EGG_CLICK == 20) {
            textView21.setText("ヘラクレスオオカブト");
        }
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                createcharacter.dismiss();
            }
        });
        Button btnOK = (Button) createcharacter.findViewById(R.id.button15);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
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
                    DialogChange();
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    createcharacter.dismiss();
                }
            }
        });
        createcharacter.setCanceledOnTouchOutside(false);
        createcharacter.show();
    }

    TextView txtcontent;

    public void DialogChange() {
        final Dialog dialogchange = new Dialog(shop.this);
        dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogchange.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogchange.setContentView(R.layout.dialog_change);
        dialogchange.setCanceledOnTouchOutside(false);
        txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
        ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
        ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(txtcoin.getText().toString());
                int money = a - tienShop;
                txtcoin.setText("" + money);
                formatcoin.setText(formatter.format(money));
                CreateNewPet();
                dialogchange.dismiss();
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

    //
    TextView txtname;

    public void Create_Character2() {
        final SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        createcharacter = new Dialog(shop.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        txtname = (TextView) createcharacter.findViewById(R.id.textView21);
        if (EGG_CLICK == 3) {
            txtname.setText("コクワガタ");
        }
        if (EGG_CLICK == 5) {
            txtname.setText("コーカサスオオカブト");
        }
        if (EGG_CLICK == 7) {
            txtname.setText("オオクワガタ");
        }
        if (EGG_CLICK == 9) {
            txtname.setText("サタンオオカブト");
        }
        if (EGG_CLICK == 11) {
            txtname.setText("ギラファノコギリクワガタ");
        }
        if (EGG_CLICK == 13) {
            txtname.setText("オウゴンオニクワガタ");
        }
        if (EGG_CLICK == 20) {
            txtname.setText("ヘラクレスオオカブト");
        }
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                createcharacter.dismiss();
            }
        });
        Button btnOK = (Button) createcharacter.findViewById(R.id.button15);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    zk_title.setText("飼育");
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    zk_title.setText("飼育");
                } else if (Chat.check_name_create(editText.getText().toString(),
                        pre.getString("tenzukan", ""), pre.getString("tenzukan2", ""),
                        pre.getString("tenzukan3", ""), pre.getString("tenzukan4", ""),
                        pre.getString("tenzukan5", ""), pre.getString("tenzukan6", ""),
                        pre.getString("tenzukan7", ""), pre.getString("tenzukan8", "")) == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("既にその名前は使用されています。\n" +
                            "名前を変えてください。");
                    zk_title.setText("飼育");
                } else {
                    DialogChange2();
                    txtcontent.setText("[" + editText.getText().toString() + "]" + " でよろしいですか？");
                    createcharacter.dismiss();
                }
            }
        });
        createcharacter.show();
    }

    public void DialogChange2() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        final Dialog dialogchange = new Dialog(shop.this);
        dialogchange.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogchange.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogchange.setContentView(R.layout.dialog_change);
        dialogchange.setCanceledOnTouchOutside(false);
        txtcontent = (TextView) dialogchange.findViewById(R.id.txtcontent);
        ImageView btnyes = (ImageView) dialogchange.findViewById(R.id.btnyes);
        ImageView btnno = (ImageView) dialogchange.findViewById(R.id.btnno);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a, j, c, d;
                a = Integer.parseInt(txtcoin.getText().toString());
                j = Integer.parseInt(txtjewel.getText().toString());
                c = a - moneyj;
                txtcoin.setText("" + c);
                formatcoin.setText(formatter.format(c));
                d = j - jewelj;
                txtjewel.setText("" + d);
                formatjewel.setText(formatter.format(d));
                CreateNewPet();
                if (EGG_CLICK == 1) {
                    editor.putInt("mat1", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 3) {
                    editor.putInt("mat2", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 5) {
                    editor.putInt("mat3", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 7) {
                    editor.putInt("mat4", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 9) {
                    editor.putInt("mat5", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 11) {
                    editor.putInt("mat6", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 13) {
                    editor.putInt("mat7", 1);
                    editor.commit();
                }
                if (EGG_CLICK == 20) {
                    editor.putInt("mat8", 1);
                    editor.commit();
                }
                dialogchange.dismiss();
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
    //

    int tienShop;
    private ProgressDialog pDialog;
    private static String _URL_REGISTER = "http://49.212.208.153/kabukuwa-api/index.php";
    private static final String TAG_SUCCESS = "resultCode";
    JSONParser jsonParser = new JSONParser();

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
        if (EGG_CLICK == 1) {
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
        }
        if (EGG_CLICK == 20) {
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

        }
        if (EGG_CLICK == 3) {
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
        }
        if (EGG_CLICK == 5) {
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
        }
        if (EGG_CLICK == 7) {
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
        }
        if (EGG_CLICK == 9) {
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
        }
        if (EGG_CLICK == 11) {
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
        }
        if (EGG_CLICK == 13) {
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
        }
        editor.commit();
    }

    IabHelper.OnConsumeFinishedListener listener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {

                    } else {
                        // handle error
                    }
                }
            };


    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        if (_PAY == 1) {
                            int a = Integer.parseInt(txtcoin.getText().toString()) + 1000;
                            txtcoin.setText("" + a);
                            formatcoin.setText(formatter.format(a));
                        }
                    } else {
                        // handle error
                    }
                }
            };
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener2 =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        if (_PAY == 2) {
                            int a = Integer.parseInt(txtcoin.getText().toString()) + 5000;
                            txtcoin.setText("" + a);
                            formatcoin.setText(formatter.format(a));
                        }
                    } else {
                        // handle error
                    }
                }
            };
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener3 =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        if (_PAY == 3) {
                            int a = Integer.parseInt(txtjewel.getText().toString()) + 10;
                            txtjewel.setText("" + a);
                            formatjewel.setText(formatter.format(a));
                        }
                    } else {
                        // handle error
                    }
                }
            };
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener4 =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        if (_PAY == 4) {
                            int a = Integer.parseInt(txtjewel.getText().toString()) + 50;
                            txtjewel.setText("" + a);
                            formatjewel.setText(formatter.format(a));
                        }
                    } else {
                        // handle error
                    }
                }
            };


    public void consume() {
        final List<String> allSkus = new ArrayList<String>();
        allSkus.add("kabukuwajewel_10");
        allSkus.add("kabukuwajewel_50");
        allSkus.add("kabukuwacoin_1000");
        allSkus.add("kabukuwacoin_5000");
        mHelper.queryInventoryAsync(true, allSkus,
                new IabHelper.QueryInventoryFinishedListener() {

                    @Override
                    public void onQueryInventoryFinished(IabResult result,
                                                         Inventory inv) {
                        if (inv == null)
                            return;

                        List<Purchase> purchases = new ArrayList<Purchase>();
                        for (String sku : allSkus) {
                            Purchase purchase = inv.getPurchase(sku);
                            if (purchase == null) {
                                continue;
                            }
                            purchases.add(purchase);
                        }
                        mHelper.consumeAsync(purchases, new IabHelper.OnConsumeMultiFinishedListener() {

                            @Override
                            public void onConsumeMultiFinished(List<Purchase> purchases, List<IabResult> results) {
                                for (int i = 0; i < results.size(); i++) {
                                    IabResult result = results.get(i);
                                    Purchase purchase = purchases.get(i);
                                    if (purchase.getSku().equals("kabukuwacoin_1000") && result.isSuccess()) {
                                        int a = Integer.parseInt(txtcoin.getText().toString()) + 1000;
                                        txtcoin.setText("" + a);
                                        formatcoin.setText(formatter.format(a));
                                    } else if (purchase.getSku().equals("kabukuwacoin_5000") && result.isSuccess()) {
                                        int a = Integer.parseInt(txtcoin.getText().toString()) + 5000;
                                        txtcoin.setText("" + a);
                                        formatcoin.setText(formatter.format(a));
                                    } else if (purchase.getSku().equals("kabukuwajewel_10") && result.isSuccess()) {
                                        int a = Integer.parseInt(txtjewel.getText().toString()) + 10;
                                        txtjewel.setText("" + a);
                                        formatjewel.setText(formatter.format(a));
                                    } else if (purchase.getSku().equals("kabukuwajewel_50") && result.isSuccess()) {
                                        int a = Integer.parseInt(txtjewel.getText().toString()) + 50;
                                        txtjewel.setText("" + a);
                                        formatjewel.setText(formatter.format(a));
                                    }
                                }

                            }
                        });

                    }
                });

    }

    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
    }

    public void consumeItem2() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener2);
    }

    public void consumeItem3() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener3);
    }

    public void consumeItem4() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener4);
    }

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU),
                        mConsumeFinishedListener);
            }
        }
    };
    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener2
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU2),
                        mConsumeFinishedListener2);
            }
        }
    };
    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener3
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU3),
                        mConsumeFinishedListener3);
            }
        }
    };
    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener4
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU4),
                        mConsumeFinishedListener4);
            }
        }
    };

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
            = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result,
                                          Purchase purchase) {
            if (result.isFailure()) {
                // Handle error
                return;
            } else if (purchase.getSku().equals(ITEM_SKU)) {
                consumeItem();
            } else if (purchase.getSku().equals(ITEM_SKU2)) {
                consumeItem2();
            } else if (purchase.getSku().equals(ITEM_SKU3)) {
                consumeItem3();
            } else if (purchase.getSku().equals(ITEM_SKU4)) {
                consumeItem4();
            }

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (!mHelper.handleActivityResult(requestCode,
                resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public static boolean verifyPurchase(String base64PublicKey,
                                         String signedData, String signature) {
        if (TextUtils.isEmpty(signedData) ||
                TextUtils.isEmpty(base64PublicKey) ||
                TextUtils.isEmpty(signature)) {
            Log.e("TAG", "Purchase verification failed: missing data.");
            if (BuildConfig.DEBUG) {
                return true;
            }
            return false;
        }

        PublicKey key = Security.generatePublicKey(base64PublicKey);
        return Security.verify(key, signedData, signature);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            if (main_intro.mediaPlayer.isPlaying()) {
                main_intro.mediaPlayer.pause();
            }
        } catch (Exception e) {

        }
    }

    int _NUMSELL = 1, _MONEYSELL = 0, _JEWELSELL = 0;
    Dialog d;
    TextView txttop;

    public void CreateNumberPicker(int max) {
        d = new Dialog(shop.this);
        d.getWindow().setGravity(Gravity.BOTTOM);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        d.setContentView(R.layout.numberpicker);
        d.setCanceledOnTouchOutside(false);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        txttop = (TextView) d.findViewById(R.id.txttop);
        np.setMaxValue(max);
        np.setMinValue(1);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                _NUMSELL = newVal;
            }
        });
        ImageView btnno = (ImageView) d.findViewById(R.id.button11);
        ImageView btnyes = (ImageView) d.findViewById(R.id.button14);
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                _MONEYSELL = 0;
                _JEWELSELL = 0;
                _NUMSELL = 1;
                d.dismiss();
            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                DialogSellShop();
                buysellshop.setImageResource(R.drawable.new_shop_dialogue_sell);
                txt16.setText("" + DesnameDisplay.get(pos) + " x " + _NUMSELL);
                String str = itemIdShopDisplay.get(pos);
                int a = Integer.parseInt(str);
                if (a < 100000) {
                    setImageForItem(a, imageView12);
                }
                if (a >= 100000) {
                    String name = "";
                    String part = "";
                    if (str.substring(0, 3).equals("100"))
                        name = "kabutomushi";
                    if (str.substring(0, 3).equals("101"))
                        name = "caucasus";
                    if (str.substring(0, 3).equals("102"))
                        name = "satanas";
                    if (str.substring(0, 3).equals("103"))
                        name = "hercules";
                    if (str.substring(0, 3).equals("110"))
                        name = "kokuwagata";
                    if (str.substring(0, 3).equals("111"))
                        name = "oukuwagata";
                    if (str.substring(0, 3).equals("112"))
                        name = "giraffa";
                    if (str.substring(0, 3).equals("113"))
                        name = "golden";
                    if (str.substring(3, 4).equals("0"))
                        part = "horn";
                    if (str.substring(3, 4).equals("1"))
                        part = "horn2";
                    if (str.substring(3, 4).equals("2"))
                        part = "head";
                    if (str.substring(3, 4).equals("3"))
                        part = "face";
                    if (str.substring(3, 4).equals("4"))
                        part = "neck";
                    if (str.substring(3, 4).equals("5"))
                        part = "body";
                    if (str.substring(3, 4).equals("6"))
                        part = "wing";
                    String pos = str.substring(4, 6);
                    String pImg = "" + name + part + pos;
                    int resID = getResources().getIdentifier("@drawable/" + pImg, "drawable", getPackageName());
                    imageView12.setImageResource(resID);
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(60, 60);
                    params.gravity = Gravity.CENTER;
                    imageView12.setLayoutParams(params);
                    imageView12.setScaleY(3f);
                    imageView12.setScaleX(3f);
                    if (part.equals("horn")) {
                        params.setMargins(0, 20, 0, 0);
                        imageView12.setLayoutParams(params);
                    }
                    if (part.equals("horn2")) {
                        params.setMargins(0, 10, 0, 0);
                        imageView12.setLayoutParams(params);
                    }
                    if (part.equals("head")) {
                        params.setMargins(0, 10, 0, 0);
                        imageView12.setLayoutParams(params);
                    }
                    if (part.equals("face")) {
                        params.setMargins(0, 10, 0, 0);
                        imageView12.setLayoutParams(params);
                    }
                    if (part.equals("neck")) {

                    }
                    if (part.equals("body")) {
                        params.setMargins(0, 0, 0, 20);
                        imageView12.setLayoutParams(params);
                    }
                    if (part.equals("wing")) {
                        params.setMargins(0, 0, 0, 20);
                        imageView12.setLayoutParams(params);

                    }
                }
                int coin = Integer.parseInt(coinDisplay.get(pos));
                _MONEYSELL = _NUMSELL * Integer.parseInt(coinDisplay.get(pos));
                formatprice.setText(formatter.format(_MONEYSELL));
                _price.setText("" + _MONEYSELL);
                if (coin == 0) {
                    btnCoin.setVisibility(View.GONE);
                    formatprice.setVisibility(View.GONE);
                }
                int jewel = Integer.parseInt(jewelDisplay.get(pos));
                _JEWELSELL = _NUMSELL * Integer.parseInt(jewelDisplay.get(pos));
                _price2.setText("" + _JEWELSELL);
                if (jewel > 0) {
                    btnCoin2.setVisibility(View.VISIBLE);
                    _price2.setVisibility(View.VISIBLE);
                }
            }
        });
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int h = metrics.heightPixels;
        int w = metrics.widthPixels;
        d.getWindow().setLayout(w, LinearLayout.LayoutParams.WRAP_CONTENT);
        d.show();
    }

    public void DialogSellShop() {
        dialogbuyshop = new Dialog(shop.this);
        dialogbuyshop.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogbuyshop.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogbuyshop.setContentView(R.layout.buyshop_layout);
        imageView12 = (ImageView) dialogbuyshop.findViewById(R.id.btnitem);
        buysellshop = (ImageView) dialogbuyshop.findViewById(R.id.buysellshop);
        _price = (TextView) dialogbuyshop.findViewById(R.id.txtprice);
        formatprice = (TextView) dialogbuyshop.findViewById(R.id.formatprice);
        _price2 = (TextView) dialogbuyshop.findViewById(R.id.txtprice2);
        btnCoin = (ImageView) dialogbuyshop.findViewById(R.id.btncoin);
        btnCoin2 = (ImageView) dialogbuyshop.findViewById(R.id.btncoin2);
        txt16 = (TextView) dialogbuyshop.findViewById(R.id.textView16);

        ImageView yes = (ImageView) dialogbuyshop.findViewById(R.id.btnyes);
        ImageView no = (ImageView) dialogbuyshop.findViewById(R.id.btnno);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                v.startAnimation(mypage.animScale);
                int a = Integer.parseInt(txtcoin.getText().toString());
                int b = Integer.parseInt(_price.getText().toString());
                int c = a + b;
                txtcoin.setText("" + c);
                formatcoin.setText(formatter.format(c));
                //
                int j = Integer.parseInt(txtjewel.getText().toString());
                int b2 = Integer.parseInt(_price2.getText().toString());
                int e = j + b2;
                txtjewel.setText("" + e);
                formatjewel.setText(formatter.format(e));
                int remaining = Integer.parseInt(numitemDisplay.get(pos)) - _NUMSELL;
                String strChanger = "" + remaining;
                numitemDisplay.set(pos, strChanger);
                itemArrayAdapter.notifyDataSetChanged();
                //
                for (int i = 0; i < itemIdShopDisplay.size(); i++) {
                    String key = itemIdShopDisplay.get(i);
                    if (key.length() == 1)
                        key = "0000" + key;
                    if (key.length() == 2)
                        key = "000" + key;
                    if (key.length() == 3)
                        key = "00" + key;
                    if (key.length() == 4)
                        key = "0" + key;
                    if (key.equals("01001"))
                        _FOODSMALL = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01003"))
                        _FOODBIG = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01013"))
                        _FOODBIG2 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01014"))
                        _FOODBIG3 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01011"))
                        _FOODBIG4 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01012"))
                        _FOODBIG5 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03003"))
                        _FOODBIG6 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01015"))
                        _FOODBIG7 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("01016"))
                        _FOODBIG8 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("00001"))
                        _DRINKSMALL = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("00003"))
                        _DRINKBIG = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03001"))
                        _ITEMSMALL = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03002"))
                        _ITEMBIG = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03004"))
                        _ITEMBIG2 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03005"))
                        _ITEMBIG3 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03006"))
                        _ITEMBIG4 = Integer.parseInt(numitemDisplay.get(i));
                    if (key.equals("03007"))
                        _ITEMBIG5 = Integer.parseInt(numitemDisplay.get(i));

                    int value = Integer.parseInt(numitemDisplay.get(i));
                    editor.putInt(key, value);
                    editor.commit();
                    long k = Long.parseLong(key);
                    db.update_Sumpart(k, value);
                }
                //
                _MONEYSELL = 0;
                _JEWELSELL = 0;
                _NUMSELL = 1;
                dialogbuyshop.dismiss();
                d.dismiss();
                if (remaining == 0) {
                    dialogSale.dismiss();
                    ShowTopLayout();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                _MONEYSELL = 0;
                _JEWELSELL = 0;
                _NUMSELL = 1;
                dialogbuyshop.dismiss();
            }
        });
        dialogbuyshop.setCanceledOnTouchOutside(false);
        dialogbuyshop.show();
    }

    Dialog d_sellpet;
    TextView txtnamesell, txtpricesell, txtpriceformat;
    ImageView btnno, btnyes;
    ImageView canhsell, hornsell, dausell, bodysell, necksell, facesell, horn2sell;

    public void DialogSellPet() {
        d_sellpet = new Dialog(shop.this);
        d_sellpet.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d_sellpet.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        d_sellpet.setContentView(R.layout.sellpetdialog);
        d_sellpet.setCanceledOnTouchOutside(false);
        txtnamesell = (TextView) d_sellpet.findViewById(R.id.txtname);
        txtpricesell = (TextView) d_sellpet.findViewById(R.id.txtprice);
        txtpriceformat = (TextView) d_sellpet.findViewById(R.id.txtpriceformat);
        btnno = (ImageView) d_sellpet.findViewById(R.id.btnno);
        btnyes = (ImageView) d_sellpet.findViewById(R.id.btnyes);
        canhsell = (ImageView) d_sellpet.findViewById(R.id.canhsell);
        hornsell = (ImageView) d_sellpet.findViewById(R.id.hornsell);
        dausell = (ImageView) d_sellpet.findViewById(R.id.dausell);
        bodysell = (ImageView) d_sellpet.findViewById(R.id.bodysell);
        necksell = (ImageView) d_sellpet.findViewById(R.id.necksell);
        facesell = (ImageView) d_sellpet.findViewById(R.id.facesell);
        horn2sell = (ImageView) d_sellpet.findViewById(R.id.horn2sell);
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                d_sellpet.dismiss();
            }
        });
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                d_sellpet.dismiss();
                for (int i = 0; i < listDataShowpet.size(); i++) {
                    if (listDataShowpet.get(i).getPos() > postemp) {
                        db.updateTabshowpetWithPOS(listDataShowpet.get(i).getIdpet(), listDataShowpet.get(i).getPos() - 1);
                    }
                }
                db.removeTabshowpetWithID(idpetsell);
                db.update(idpetsell, 1);
//                int a = Integer.parseInt(txtcoin.getText().toString()) + Integer.parseInt(Tiensale);// sua cho nay
                int a = Integer.parseInt(txtcoin.getText().toString()) + _price_sale;
                txtcoin.setText("" + a);
                formatcoin.setText(formatter.format(a));
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                editor.putInt("money", Integer.parseInt(txtcoin.getText().toString()));
                editor.commit();
//                db.update_Numpart(100004, 0);
//                db.update_Sumpart(100004, 0);
                _update_numpart(SubType, hornNosale, horn2Nosale, headNosale, faceNosale, neckNosale, bodyNosale, wingNosale);
                dialogSale.dismiss();
                ShowTopLayout();
//                listDulieu = db.getPetTruongThanh();
//                adapter.notifyDataSetChanged();
            }
        });
        d_sellpet.show();
    }

    public void setImageForItem(int a, ImageView imggetitem) {
        if (a == 1013)
            imggetitem.setImageResource(R.drawable.itm_rice3);
        if (a == 1014)
            imggetitem.setImageResource(R.drawable.itm_rice2);
        if (a == 1001)
            imggetitem.setImageResource(R.drawable.food_icon);
        if (a == 1011)
            imggetitem.setImageResource(R.drawable.itm_jelly1);
        if (a == 1)
            imggetitem.setImageResource(R.drawable.drink_icon);
        if (a == 3001)
            imggetitem.setImageResource(R.drawable.item_icon);
        if (a == 1012)
            imggetitem.setImageResource(R.drawable.itm_jelly2);
        if (a == 1003)
            imggetitem.setImageResource(R.drawable.itm_rice4);
        if (a == 3)
            imggetitem.setImageResource(R.drawable.new_shop_icon_drink2);
        if (a == 3002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_item2);
        if (a == 3003)
            imggetitem.setImageResource(R.drawable.itm_liquor);
        if (a == 3004)
            imggetitem.setImageResource(R.drawable.itm_runpa1);
        if (a == 2001)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2003)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2004)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2005)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2006)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2007)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2008)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2009)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2010)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2011)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2012)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2013)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2014)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2015)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 2016)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        if (a == 1015)
            imggetitem.setImageResource(R.drawable.itm_sap);
        if (a == 1016)
            imggetitem.setImageResource(R.drawable.itm_banana);
        if (a == 3005)
            imggetitem.setImageResource(R.drawable.itm_medicine1);
        if (a == 3006)
            imggetitem.setImageResource(R.drawable.itm_medicine2);
        if (a == 3007)
            imggetitem.setImageResource(R.drawable.itm_o2_capsule);
        if (a == 3008)
            imggetitem.setImageResource(R.drawable.itm_gold_ticket);
    }

    LinearLayout lnstar;
    ImageView shop_yes, shop_no, btnok;
    int _item, _pos, _click, iddrink;

    public void mypagedialogitem() {
        mpdialogitem = new Dialog(shop.this);
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
                    mypage.kSECommand.start();
                int value = 0;
                String kkey = "";
                if (_item == 0) {
                    mypage.theluc = pre.getInt("lv", 1) * 10;
                    editor.putInt("theluc", mypage.theluc);
                    progressBar3.setProgress(mypage.theluc);
                    txtphantram.setText("" + mypage.theluc + "/" + mypage.theluc);
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
                    if (key.length() == 2)
                        key = "000" + key;
                    if (key.length() == 3)
                        key = "00" + key;
                    if (key.length() == 4)
                        key = "0" + key;
                    editor.putInt(key, _FOODBIG6);
                    long k = Long.parseLong(key);
                    db.update_Sumpart(k, _FOODBIG6);
                }
                if (_item == 1) {
                    kkey = "" + iddrink;
                    if (iddrink == 1) {
                        mypage._hp += 25;
                        _DRINKSMALL--;
                        value = _DRINKSMALL;
                    }
                    if (iddrink == 3) {
                        mypage._hp += 50;
                        _DRINKBIG--;
                        value = _DRINKBIG;
                    }
                    if (mypage._hp > mypage.pl_hp)
                        mypage._hp = mypage.pl_hp;
                    txtHp.setText(mypage._hp + "/" + mypage.pl_hp);
                    prhp.setProgress(mypage._hp);
                    db.update_Sumpart(iddrink, value);
                    double _curHp = mypage._hp * 100 / mypage.pl_hp;
                    db.update_hp(idpetsell, _curHp);
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
                }
                if (_item == 2) {
                    kkey = "" + iddrink;
                    if (iddrink == 1011) {
                        mypage._hp += 100;
                        _FOODBIG4--;
                        value = _FOODBIG4;
                    }
                    if (iddrink == 1012) {
                        mypage._hp += 300;
                        _FOODBIG5--;
                        value = _FOODBIG5;
                    }
                    if (iddrink == 1015) {
                        mypage._hp += mypage.pl_hp / 2;
                        _FOODBIG7--;
                        value = _FOODBIG7;
                    }
                    if (iddrink == 1016) {
                        mypage._hp = mypage.pl_hp;
                        _FOODBIG8--;
                        value = _FOODBIG8;
                    }
                    if (mypage._hp > mypage.pl_hp)
                        mypage._hp = mypage.pl_hp;
                    txtHp.setText(mypage._hp + "/" + mypage.pl_hp);
                    prhp.setProgress(mypage._hp);
                    db.update_Sumpart(iddrink, value);
                    double _curHp = mypage._hp * 100 / mypage.pl_hp;
                    db.update_hp(idpetsell, _curHp);
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

    public void _setIMG(String _loai, int _face, int _head, int _horn, int _horn2, int _mat) {
        if (_loai.equals("loai1")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn[mypage.hornNosale]);
            bgmphead.setImageResource(Chat.bghead[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn[mypage.hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0000_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face[mypage.faceNosale]);
        }

        if (_loai.equals("loai2")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head2[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn2[mypage.hornNosale]);
            bgmphead.setImageResource(Chat.bghead2[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn2[mypage.hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0100_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face2[mypage.faceNosale]);
        }

        if (_loai.equals("loai3")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head3[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn3[mypage.hornNosale]);
            mphorn2.setImageResource(Chat.horn33[mypage.horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead3[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn3[mypage.hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn33[mypage.horn2Nosale]);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0001_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face3[mypage.faceNosale]);
        }

        if (_loai.equals("loai4")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head4[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn4[mypage.hornNosale]);
            bgmphead.setImageResource(Chat.bghead4[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn4[mypage.hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0101_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face4[mypage.faceNosale]);
        }

        if (_loai.equals("loai5")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head5[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn5[mypage.hornNosale]);
            mphorn2.setImageResource(Chat.horn55[mypage.horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead5[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn5[mypage.hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn55[mypage.horn2Nosale]);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0002_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face5[mypage.faceNosale]);
        }

        if (_loai.equals("loai6")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head6[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn6[mypage.hornNosale]);
            bgmphead.setImageResource(Chat.bghead6[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn6[mypage.hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0102_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face6[mypage.faceNosale]);
        }

        if (_loai.equals("loai7")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head7[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn7[mypage.hornNosale]);
            bgmphead.setImageResource(Chat.bghead7[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn7[mypage.hornNosale]);
            mphorn2.setImageResource(R.drawable.trans);
            bgmphorn2.setImageResource(R.drawable.trans);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0103_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face7[mypage.faceNosale]);
        }
//
        if (_loai.equals("loai8")) {
            if (_face > 5)
                _face = 5;
            mphead.setImageResource(Chat.head8[mypage.headNosale]);
            mphorn.setImageResource(Chat.horn8[mypage.hornNosale]);
            mphorn2.setImageResource(Chat.horn88[mypage.horn2Nosale]);
            bgmphead.setImageResource(Chat.bghead8[mypage.headNosale]);
            bgmphorn.setImageResource(Chat.bghorn8[mypage.hornNosale]);
            bgmphorn2.setImageResource(Chat.bghorn88[mypage.horn2Nosale]);
            if (_mat == 1)
                mpface.setImageResource(R.drawable.face_0003_10);
            else if (_mat == 0)
                mpface.setImageResource(Chat.face8[mypage.faceNosale]);
        }
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

    public void _update_numpart(int subkind, int horn, int horn2, int head, int face, int neck, int body, int wing) {
        _listTablePart = db.getAllPart();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        String _num = Chat._Strpart(horn);
        String _num2 = Chat._Strpart(horn2);
        String _num3 = Chat._Strpart(head);
        String _num4 = "";
        if (face >= 5)
            _num4 = "10";
        if (face < 5)
            _num4 = "0" + face;
        String _num5 = Chat._StrpartNeck(neck, subkind);
        String _num6 = Chat._Strpart(body);
        String _num7 = "";
        if (wing >= 4)
            _num7 = "10";
        if (wing < 4)
            _num7 = "0" + wing;
        String specices = Chat._Strspecies(subkind);
        String _horn = specices + "0" + _num;
        String _horn2 = specices + "1" + _num2;
        String _head = specices + "2" + _num3;
        String _face = specices + "3" + _num4;
        String _neck = specices + "4" + _num5;
        String _body = specices + "5" + _num6;
        String _wing = specices + "6" + _num7;
//        Log.e("_horn", "_horn:" + _horn);
//        Log.e("_horn", "_horn2:" + _horn2);
//        Log.e("_horn", "_head:" + _head);
//        Log.e("_horn", "_face:" + _face);
//        Log.e("_horn", "_neck:" + _neck);
//        Log.e("_horn", "_body:" + _body);
//        Log.e("_horn", "_wing:" + _wing);
        for (int i = 0; i < _listTablePart.size(); i++) {
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_horn))) {
                int a = _listTablePart.get(i).getNum() - 1;
                int b = _listTablePart.get(i).getSum() - 1;
                db.update_Numpart(Long.parseLong(_horn), a);
                db.update_Sumpart(Long.parseLong(_horn), b);
                editor.putInt(_horn, b);
                editor.commit();
            }
            if (subkind == 1 || subkind == 2 || subkind == 3) {
                if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_horn2))) {
                    db.update_Numpart(Long.parseLong(_horn2), _listTablePart.get(i).getNum() - 1);
                    int b = _listTablePart.get(i).getSum() - 1;
                    db.update_Sumpart(Long.parseLong(_horn2), b);
                    editor.putInt(_horn2, b);
                    editor.commit();
                }
            }
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_head))) {
                db.update_Numpart(Long.parseLong(_head), _listTablePart.get(i).getNum() - 1);
                int b = _listTablePart.get(i).getSum() - 1;
                db.update_Sumpart(Long.parseLong(_head), b);
                editor.putInt(_head, b);
                editor.commit();
            }
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_face))) {
                db.update_Numpart(Long.parseLong(_face), _listTablePart.get(i).getNum() - 1);
                int b = _listTablePart.get(i).getSum() - 1;
                db.update_Sumpart(Long.parseLong(_face), b);
                editor.putInt(_face, b);
                editor.commit();
            }
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_neck))) {
                db.update_Numpart(Long.parseLong(_neck), _listTablePart.get(i).getNum() - 1);
                int b = _listTablePart.get(i).getSum() - 1;
                db.update_Sumpart(Long.parseLong(_neck), b);
                editor.putInt(_neck, b);
                editor.commit();
            }
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_body))) {
                db.update_Numpart(Long.parseLong(_body), _listTablePart.get(i).getNum() - 1);
                int b = _listTablePart.get(i).getSum() - 1;
                db.update_Sumpart(Long.parseLong(_body), b);
                editor.putInt(_body, b);
                editor.commit();
            }
            if (wing > 0) {
                if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_wing))) {
                    db.update_Numpart(Long.parseLong(_wing), _listTablePart.get(i).getNum() - 1);
                    int b = _listTablePart.get(i).getSum() - 1;
                    db.update_Sumpart(Long.parseLong(_wing), b);
                    editor.putInt(_wing, b);
                    editor.commit();
                }
            }
        }
    }

    AtomicBoolean flaganim = new AtomicBoolean(false);

    public void runAnim() {
        flaganim.set(false);
        Thread t = new Thread() {
            int i;

            @Override
            public void run() {
                while (1 < 2) {
                    for (i = 0; i >= 0 && flaganim.get(); i++) {
//                        Log.e("TAG", "i:" + i);
                        if (i > 5)
                            i = 0;
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (i == 1)
                                        _anim_coin();
                                    if (i == 3)
                                        _anim_coin();
                                    if (i == 5)
                                        _anim_coin();
                                }
                            });
                            Thread.sleep(5000);
                        } catch (Exception e) {

                        }
                    }
                }
            }
        };
        flaganim.set(true);
        t.start();
    }

    public void _anim_coin() {
        if (anim_coin.isRunning())
            anim_coin.stop();
        if (anim_jewel.isRunning())
            anim_jewel.stop();
        if (anim_shin1.isRunning())
            anim_shin1.stop();
        if (anim_shin2.isRunning())
            anim_shin2.stop();
        anim_coin.start();
        anim_jewel.start();
        anim_shin1.start();
        anim_shin2.start();
    }

    public void DialogCreatePet() {
        final Dialog dialog = new Dialog(shop.this);
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
                if (EGG_CLICK == -1) {
                    Create_Character3();
                } else {
                    Create_Character();
                }
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

    public void Create_Character3() {
        createcharacter = new Dialog(shop.this);
        createcharacter.requestWindowFeature(Window.FEATURE_NO_TITLE);
        createcharacter.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        createcharacter.setContentView(R.layout.createcharacter_layout);
        editText = (EditText) createcharacter.findViewById(R.id.editText);
        ImageView imageViewback = (ImageView) createcharacter.findViewById(R.id.imageView12);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                v.startAnimation(mypage.animScale);
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(shop.this);
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
                            CreateNewPet3();
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
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                v.startAnimation(mypage.animScale);
                if (editText.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前をつけてあげてください。");
                    return;
                } else if (editText.getText().toString().length() > 10) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("名前は10文字以内にしてください。");
                    return;
                } else {
                    final Dialog dialogchange = new Dialog(shop.this);
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
                            CreateNewPet3();
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

    private void CreateNewPet3() {
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
//                    Intent intent = new Intent(shop.this, story.class);
//                    startActivity(intent);
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
            editor.putString("create", "create");
            editor.commit();
            db.adddatastt(getApplicationContext(), 1);
        }
        editor.commit();

    }
}