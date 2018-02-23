package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class FittingRoom extends Activity {
    //    public static ArrayList<String> arrID;
    public static ArrayList<String> arrIDPartHorn;
    public static ArrayList<String> arrIDPartHorn2;
    public static ArrayList<String> arrIDface;
    public static ArrayList<String> arrIDhead;
    public static ArrayList<String> arrIDwing;
    public static ArrayList<String> arrIDneck;
    public static ArrayList<String> arrIDbody;
    ArrayList<Integer> arrNum;
    ArrayList<Integer> arrNumhead;
    ArrayList<Integer> arrNumhorn2;
    ArrayList<Integer> arrNumwing;
    ArrayList<Integer> arrNumbody;
    ArrayList<Integer> arrNumneck;
    ArrayList<Integer> arrNumface;

    ArrayList<Integer> arrUserHorn;
    ArrayList<Integer> arrUserHorn2;
    ArrayList<Integer> arrUserHead;
    ArrayList<Integer> arrUserFace;
    ArrayList<Integer> arrUserWing;
    ArrayList<Integer> arrUserBody;
    ArrayList<Integer> arrUserNeck;

    ArrayList<Integer> SLHorn, SLHorn_temp;
    ArrayList<Integer> SLHorn2, SLHorn2_temp;
    ArrayList<Integer> SLHead, SLHead_temp;
    ArrayList<Integer> SLFace, SLFace_temp;
    ArrayList<Integer> SLWing, SLWing_temp;
    ArrayList<Integer> SLBody, SLBody_temp;
    ArrayList<Integer> SLNeck, SLNeck_temp;

    int a, b, c;
    ImageView back, headchoose, hornchoose, horn2choose, facechoose, wingchoose, neckchoose, bodychoose,
            hornpart, horn2part, headpart, facepart, neckpart, wingpart, bodypart, btnChange, btnReset, b_arrow_r, b_arrow_l;
    TextView name, hp, hp2, attack, attack2, criticalAttack, criticalAttack2, defense, defense2, critical, critical2, avoid, avoid2, lucky, lucky2, speed, speed2;
    LinearLayout containerpart, lnlv;
    FrameLayout frhorn, frhorn2, frhead, frface, frbody, frwing, frneck;
    SharedPreferences pre;
    int nuoi, mat, hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, sale, live,
            nuoisale, matsale, hornNosale, horn2Nosale, wingNosale, headNosale, neckNosale, faceNosale, bodyNosale, salesale, livesale,
            personalitysale, _excreteSsale, _satietysale, _sleepsale, _strengthsale, _excreteBsale, _formsale, _sizesale, _moisturesale,
            _healthsale, mood, clearn, _hp, _attack, _criticalAttack, _defense, _critical, _avoid, _lucky, _speed, _level, _exp;
    float tuoi, tuoisale;
    long _phaseETime, _bornTime, _phaseTime, lastCleanTime;
    String Name, Hang, Tien, Tiensale, loai, loaisale, namesell, hangsell, beetleID;
    int horntemp, horn2temp, facetemp, headtemp, bodytemp, wingtemp, necktemp, idpetsell, _CHOOSE = 1, _POS, mattemp;
    dbHandler db;
    List<TablePart> _listTablePart;
    private PublisherAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fittingroom);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Intent intent = getIntent();
        db = new dbHandler(this);
        _listTablePart = db.getAllPart();
        pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
//        db.update_fittingroom(idpetsell, 1, horntemp, horn2temp, wingtemp, headtemp, necktemp, facetemp, bodytemp);
//        db.update_Sumpart(101601, 1);
//        db.update_Sumpart(101602, 1);
//        db.update_Sumpart(101603, 1);
//        db.update_Sumpart(101610, 1);
//        db.update_Numpart(103505, 0);

        frhorn = (FrameLayout) findViewById(R.id.frhorn);
        frhorn2 = (FrameLayout) findViewById(R.id.frhorn2);
        frbody = (FrameLayout) findViewById(R.id.frbody);
        frhead = (FrameLayout) findViewById(R.id.frhead);
        frface = (FrameLayout) findViewById(R.id.frface);
        frwing = (FrameLayout) findViewById(R.id.frwing);
        frneck = (FrameLayout) findViewById(R.id.frneck);

        lnlv = (LinearLayout) findViewById(R.id.Lnlv);

        name = (TextView) findViewById(R.id.name);
        hp = (TextView) findViewById(R.id._hp);
        attack = (TextView) findViewById(R.id._attack);
        criticalAttack = (TextView) findViewById(R.id._criticalAttack);
        defense = (TextView) findViewById(R.id._defense);
        critical = (TextView) findViewById(R.id._critical);
        avoid = (TextView) findViewById(R.id._avoid);
        lucky = (TextView) findViewById(R.id._lucky);
        speed = (TextView) findViewById(R.id._speed);
        hp2 = (TextView) findViewById(R.id._hp2);
        attack2 = (TextView) findViewById(R.id._attack2);
        criticalAttack2 = (TextView) findViewById(R.id._criticalAttack2);
        defense2 = (TextView) findViewById(R.id._defense2);
        critical2 = (TextView) findViewById(R.id._critical2);
        avoid2 = (TextView) findViewById(R.id._avoid2);
        lucky2 = (TextView) findViewById(R.id._lucky2);
        speed2 = (TextView) findViewById(R.id._speed2);

        btnChange = (ImageView) findViewById(R.id.btnChange);
        btnReset = (ImageView) findViewById(R.id.btnReset);
        b_arrow_r = (ImageView) findViewById(R.id.b_arrow_r);
        b_arrow_l = (ImageView) findViewById(R.id.b_arrow_l);

        back = (ImageView) findViewById(R.id.back);
        headchoose = (ImageView) findViewById(R.id.head);
        hornchoose = (ImageView) findViewById(R.id.horn);
        horn2choose = (ImageView) findViewById(R.id.horn2);
        facechoose = (ImageView) findViewById(R.id.face);
        neckchoose = (ImageView) findViewById(R.id.neck);
        wingchoose = (ImageView) findViewById(R.id.wing);
        bodychoose = (ImageView) findViewById(R.id.body);

        bodypart = (ImageView) findViewById(R.id.bodypart);
        hornpart = (ImageView) findViewById(R.id.hornpart);
        horn2part = (ImageView) findViewById(R.id.horn2part);
        facepart = (ImageView) findViewById(R.id.facepart);
        headpart = (ImageView) findViewById(R.id.headpart);
        wingpart = (ImageView) findViewById(R.id.wingpart);
        neckpart = (ImageView) findViewById(R.id.neckpart);

        girdhorn = (GridView) findViewById(R.id.girdhorn);
        girdhorn2 = (GridView) findViewById(R.id.girdhorn2);
        girdbody = (GridView) findViewById(R.id.girdbody);
        girdhead = (GridView) findViewById(R.id.girdhead);
        girdwing = (GridView) findViewById(R.id.girdwing);
        girdneck = (GridView) findViewById(R.id.girdneck);
        girdface = (GridView) findViewById(R.id.girdface);

        containerpart = (LinearLayout) findViewById(R.id.containerpart);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
        if (matsale == 1)
            faceNosale = 5;
        idpetsell = intent.getIntExtra("idpetsell", 0);

        horntemp = hornNosale;
        horn2temp = horn2Nosale;
        facetemp = faceNosale;
        headtemp = headNosale;
        bodytemp = bodyNosale;
        necktemp = neckNosale;
        wingtemp = wingNosale;
        mattemp = matsale;

        ft_horn = hornNosale;
        ft_horn2 = horn2Nosale;
        ft_face = faceNosale;
        ft_head = headNosale;
        ft_body = bodyNosale;
        ft_neck = neckNosale;
        ft_wing = wingNosale;

//        _hp = intent.getIntExtra("_hp", 0);
//        _attack = intent.getIntExtra("_attack", 0);
//        _criticalAttack = intent.getIntExtra("_criticalAttack", 0);
//        _defense = intent.getIntExtra("_defense", 0);
//        _critical = intent.getIntExtra("_critical", 0);
//        _avoid = intent.getIntExtra("_avoid", 0);
//        _lucky = intent.getIntExtra("_lucky", 0);
//        _speed = intent.getIntExtra("_speed", 0);
        _level = intent.getIntExtra("_level", 0);
        _exp = intent.getIntExtra("_exp", 0);

        name.setText("" + namesell);
        hp.setText("" + mypage.pl_hp);
        attack.setText("" + mypage.pl_at);
        criticalAttack.setText("" + mypage.pl_criat);
        defense.setText("" + mypage.pl_de);
        critical.setText("" + mypage.pl_cri);
        avoid.setText("" + mypage.pl_avoid);
        lucky.setText("" + mypage.pl_luc);
        speed.setText("" + mypage.pl_spe);
        int sizelv = 11;
        if (mypage._Width <= 480)
            sizelv = 9;
        DrawLevel(lnlv, _level, sizelv);
        if (loaisale.equals("loai1")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
            if (neckNosale > 3)
                neckNosale = 3;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0)
                wingpart.setImageResource(Chat.wing[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head[headNosale]);
            bodypart.setImageResource(Chat.body[bodyNosale]);
            neckpart.setImageResource(Chat.neck[neckNosale]);
            hornpart.setImageResource(Chat.horn[hornNosale]);
            //
            headchoose.setImageResource(Chat.head[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body[bodyNosale]);
            neckchoose.setImageResource(Chat.neck[neckNosale]);
            hornchoose.setImageResource(Chat.horn[hornNosale]);
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0000_10);
                facepart.setImageResource(R.drawable.face_0000_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face[faceNosale]);
                facepart.setImageResource(Chat.face[faceNosale]);
            }
        }
        if (loaisale.equals("loai2")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing2[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head2[headNosale]);
            bodypart.setImageResource(Chat.body2[bodyNosale]);
            neckpart.setImageResource(Chat.neck2[neckNosale]);
            hornpart.setImageResource(Chat.horn2[hornNosale]);
            //
            headchoose.setImageResource(Chat.head2[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing2[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body2[bodyNosale]);
            neckchoose.setImageResource(Chat.neck2[neckNosale]);
            hornchoose.setImageResource(Chat.horn2[hornNosale]);
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0100_10);
                facepart.setImageResource(R.drawable.face_0100_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face2[faceNosale]);
                facepart.setImageResource(Chat.face2[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai3")) {
            frhorn2.setVisibility(View.VISIBLE);
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 4)
                neckNosale = 4;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing3[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head3[headNosale]);
            bodypart.setImageResource(Chat.body3[bodyNosale]);
            neckpart.setImageResource(Chat.neck3[neckNosale]);
            hornpart.setImageResource(Chat.horn3[hornNosale]);
            horn2part.setImageResource(Chat.horn33[horn2Nosale]);
            //
            headchoose.setImageResource(Chat.head3[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing3[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body3[bodyNosale]);
            neckchoose.setImageResource(Chat.neck3[neckNosale]);
            hornchoose.setImageResource(Chat.horn3[hornNosale]);
            horn2choose.setImageResource(Chat.horn33[horn2Nosale]);
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0001_10);
                facepart.setImageResource(R.drawable.face_0001_10);
            } else if (matsale == 0) {
                facepart.setImageResource(Chat.face3[faceNosale]);
                facechoose.setImageResource(Chat.face3[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai4")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing4[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head4[headNosale]);
            bodypart.setImageResource(Chat.body4[bodyNosale]);
            neckpart.setImageResource(Chat.neck4[neckNosale]);
            hornpart.setImageResource(Chat.horn4[hornNosale]);
            //
            headchoose.setImageResource(Chat.head4[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing4[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body4[bodyNosale]);
            neckchoose.setImageResource(Chat.neck4[neckNosale]);
            hornchoose.setImageResource(Chat.horn4[hornNosale]);
            if (matsale == 1) {
                facepart.setImageResource(R.drawable.face_0101_10);
                facechoose.setImageResource(R.drawable.face_0101_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face4[faceNosale]);
                facepart.setImageResource(Chat.face4[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai5")) {
            frhorn2.setVisibility(View.VISIBLE);
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing5[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head5[headNosale]);
            bodypart.setImageResource(Chat.body5[bodyNosale]);
            neckpart.setImageResource(Chat.neck5[neckNosale]);
            hornpart.setImageResource(Chat.horn5[hornNosale]);
            horn2part.setImageResource(Chat.horn55[horn2Nosale]);
            //
            headchoose.setImageResource(Chat.head5[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing5[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body5[bodyNosale]);
            neckchoose.setImageResource(Chat.neck5[neckNosale]);
            hornchoose.setImageResource(Chat.horn5[hornNosale]);
            horn2choose.setImageResource(Chat.horn55[horn2Nosale]);
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0002_10);
                facepart.setImageResource(R.drawable.face_0002_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face5[faceNosale]);
                facepart.setImageResource(Chat.face5[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai6")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing6[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head6[headNosale]);
            bodypart.setImageResource(Chat.body6[bodyNosale]);
            neckpart.setImageResource(Chat.neck6[neckNosale]);
            hornpart.setImageResource(Chat.horn6[hornNosale]);
            //
            headchoose.setImageResource(Chat.head6[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing6[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body6[bodyNosale]);
            neckchoose.setImageResource(Chat.neck6[neckNosale]);
            hornchoose.setImageResource(Chat.horn6[hornNosale]);
            if (matsale == 1) {
                facepart.setImageResource(R.drawable.face_0102_10);
                facechoose.setImageResource(R.drawable.face_0102_10);
            } else if (matsale == 0) {
                facepart.setImageResource(Chat.face6[faceNosale]);
                facechoose.setImageResource(Chat.face6[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai7")) {
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 2)
                neckNosale = 2;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing7[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head7[headNosale]);
            bodypart.setImageResource(Chat.body7[bodyNosale]);
            neckpart.setImageResource(Chat.neck7[neckNosale]);
            hornpart.setImageResource(Chat.horn7[hornNosale]);
            //
            headchoose.setImageResource(Chat.head7[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing7[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body7[bodyNosale]);
            neckchoose.setImageResource(Chat.neck7[neckNosale]);
            hornchoose.setImageResource(Chat.horn7[hornNosale]);
            if (matsale == 1) {
                facepart.setImageResource(R.drawable.face_0103_10);
                facechoose.setImageResource(R.drawable.face_0103_10);
            } else if (matsale == 0) {
                facepart.setImageResource(Chat.face7[faceNosale]);
                facechoose.setImageResource(Chat.face7[faceNosale]);
            }
        }
//
        if (loaisale.equals("loai8")) {
            frhorn2.setVisibility(View.VISIBLE);
            if (wingNosale > 4)
                wingNosale = 4;
            if (neckNosale > 3)
                neckNosale = 3;
            if (faceNosale > 5)
                faceNosale = 5;
//            if (wingNosale == 0) wingpart.setImageResource(R.drawable.wing0);
            if (wingNosale > 0) wingpart.setImageResource(Chat.wing8[wingNosale - 1]);
            if (wingNosale == 0)
                wingpart.setImageResource(R.drawable.wing0);
            headpart.setImageResource(Chat.head8[headNosale]);
            bodypart.setImageResource(Chat.body8[bodyNosale]);
            neckpart.setImageResource(Chat.neck8[neckNosale]);
            hornpart.setImageResource(Chat.horn8[hornNosale]);
            horn2part.setImageResource(Chat.horn88[horn2Nosale]);
            //
            headchoose.setImageResource(Chat.head8[headNosale]);
            if (wingNosale > 0)
                wingchoose.setImageResource(Chat.wing8[wingNosale - 1]);
            bodychoose.setImageResource(Chat.body8[bodyNosale]);
            neckchoose.setImageResource(Chat.neck8[neckNosale]);
            hornchoose.setImageResource(Chat.horn8[hornNosale]);
            horn2choose.setImageResource(Chat.horn88[horn2Nosale]);
            if (matsale == 1) {
                facepart.setImageResource(R.drawable.face_0003_10);
                facechoose.setImageResource(R.drawable.face_0003_10);
            } else if (matsale == 0) {
                facepart.setImageResource(Chat.face8[faceNosale]);
                facechoose.setImageResource(Chat.face8[faceNosale]);
            }
        }
        frhorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 1;
                setGridview(_CHOOSE);
            }
        });
        frhorn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 2;
                setGridview(_CHOOSE);
            }
        });
        frhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 3;
                setGridview(_CHOOSE);
            }
        });
        frface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 4;
                setGridview(_CHOOSE);
            }
        });
        frneck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 5;
                setGridview(_CHOOSE);
            }
        });
        frbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 6;
                setGridview(_CHOOSE);
            }
        });
        frwing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _CHOOSE = 7;
                setGridview(_CHOOSE);
            }
        });
        btnChange.setEnabled(false);
        btnReset.setEnabled(false);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                if (_CHOOSE == 1) {
                    db.update_horn(idpetsell, _POS);
                    _setAdapterTest(_NumCr, _NumPos, _IDCurrent, _IDPosition);
                    hornNosale = _POS;
                    getpart(arrNum, arrIDPartHorn, phorn, arrUserHorn, SLHorn);
                    _NumCr = SLHorn.get(hornNosale);
                    _IDCurrent = Long.parseLong(arrIDPartHorn.get(hornNosale));
                    adapterHorn = new PartHorn(FittingRoom.this, arrIDPartHorn, arrNum, hornNosale, arrUserHorn, SLHorn);
                    girdhorn.setAdapter(adapterHorn);
                    mypage.pl_at += a;
                    mypage.pl_criat += b;
                    attack.setText("" + mypage.pl_at);
                    criticalAttack.setText("" + mypage.pl_criat);
                    setnulltext();
                }
                if (_CHOOSE == 2) {
                    db.update_horn2(idpetsell, _POS);
                    _setAdapterTest(_NumCr2, _NumPos2, _IDCurrent2, _IDPosition2);
                    horn2Nosale = _POS;
                    getpart(arrNumhorn2, arrIDPartHorn2, phorn2, arrUserHorn2, SLHorn2);
                    _NumCr2 = SLHorn2.get(horn2Nosale);
                    _IDCurrent2 = Long.parseLong(arrIDPartHorn2.get(horn2Nosale));
                    adapterHorn2 = new PartHorn(FittingRoom.this, arrIDPartHorn2, arrNumhorn2, horn2Nosale, arrUserHorn2, SLHorn2);
                    girdhorn2.setAdapter(adapterHorn2);
                    mypage.pl_criat += a;
                    mypage.pl_avoid += b;
                    mypage.pl_spe += c;
                    criticalAttack.setText("" + mypage.pl_criat);
                    avoid.setText("" + mypage.pl_avoid);
                    speed.setText("" + mypage.pl_spe);
                    setnulltext();
                }
                if (_CHOOSE == 3) {
                    db.update_head(idpetsell, _POS);
                    _setAdapterTest(_NumCrhead, _NumPoshead, _IDCurrenthead, _IDPositionhead);
                    headNosale = _POS;
                    getpart(arrNumhead, arrIDhead, phead, arrUserHead, SLHead);
                    _NumCrhead = SLHead.get(headNosale);
                    _IDCurrenthead = Long.parseLong(arrIDhead.get(headNosale));
                    adapterHead = new PartHorn(FittingRoom.this, arrIDhead, arrNumhead, headNosale, arrUserHead, SLHead);
                    girdhead.setAdapter(adapterHead);
                    mypage.pl_hp += a;
                    hp.setText("" + mypage.pl_hp);
                    setnulltext();
                }
                if (_CHOOSE == 4) {
                    if (_POS < 5) {
                        matsale = 0;
                        db.update_face(idpetsell, _POS, matsale);
                    }
                    if (_POS >= 5) {
                        matsale = 1;
                        db.update_face(idpetsell, _POS, matsale);
                    }
                    _setAdapterTest(_NumCrface, _NumPosface, _IDCurrentface, _IDPositionface);
                    faceNosale = _POS;
                    getpart(arrNumface, arrIDface, pface, arrUserFace, SLFace);
                    _NumCrface = SLFace.get(faceNosale);
                    _IDCurrentface = Long.parseLong(arrIDface.get(faceNosale));
                    adapterFace = new PartHorn(FittingRoom.this, arrIDface, arrNumface, faceNosale, arrUserFace, SLFace);
                    girdface.setAdapter(adapterFace);
                    mypage.pl_avoid += a;
                    avoid.setText("" + mypage.pl_avoid);
                    setnulltext();
                }
                if (_CHOOSE == 5) {
                    db.update_neck(idpetsell, _POS);
                    _setAdapterTest(_NumCrneck, _NumPosneck, _IDCurrentneck, _IDPositionneck);
                    neckNosale = _POS;

                    getpart(arrNumneck, arrIDneck, pneck, arrUserNeck, SLNeck);
                    _NumCrneck = SLNeck.get(neckNosale);
                    _IDCurrentneck = Long.parseLong(arrIDneck.get(neckNosale));
                    adapterNeck = new PartHorn(FittingRoom.this, arrIDneck, arrNumneck, neckNosale, arrUserNeck, SLNeck);
                    girdneck.setAdapter(adapterNeck);

                    mypage.pl_luc += a;
                    lucky.setText("" + mypage.pl_luc);
                    setnulltext();
                }
                if (_CHOOSE == 6) {
                    db.update_body(idpetsell, _POS);
                    _setAdapterTest(_NumCrbody, _NumPosbody, _IDCurrentbody, _IDPositionbody);
                    bodyNosale = _POS;

                    getpart(arrNumbody, arrIDbody, pbody, arrUserBody, SLBody);
                    _NumCrbody = SLBody.get(bodyNosale);
                    _IDCurrentbody = Long.parseLong(arrIDbody.get(bodyNosale));
                    adapterBody = new PartHorn(FittingRoom.this, arrIDbody, arrNumbody, bodyNosale, arrUserBody, SLBody);
                    girdbody.setAdapter(adapterBody);

                    mypage.pl_de += a;
                    defense.setText("" + mypage.pl_de);
                    setnulltext();
                }
                if (_CHOOSE == 7) {
                    db.update_wing(idpetsell, _POS + 1);
                    _setAdapterTest(_NumCrwing, _NumPoswing, _IDCurrentwing, _IDPositionwing);
                    wingNosale = _POS + 1;

                    getpart(arrNumwing, arrIDwing, pwing, arrUserWing, SLWing);
                    _NumCrwing = SLWing.get(wingNosale - 1);
                    _IDCurrentwing = Long.parseLong(arrIDwing.get(wingNosale - 1));
                    adapterWing = new PartWing(FittingRoom.this, arrIDwing, arrNumwing, wingNosale - 1, arrUserWing, SLWing);
                    girdwing.setAdapter(adapterWing);

                    mypage.pl_spe += a;
                    speed.setText("" + mypage.pl_spe);
                    setnulltext();
                }
                _setbuttondisable();
                btnReset.setEnabled(true);
                btnReset.setAlpha(1f);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                final Dialog dialog = new Dialog(FittingRoom.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(R.layout.createpet);
                dialog.setCanceledOnTouchOutside(false);
                TextView textView20 = (TextView) dialog.findViewById(R.id.textView20);
                textView20.setText("確認");
                TextView textView18 = (TextView) dialog.findViewById(R.id.textView18);
                textView18.setText("装備を全てもとに戻します。よろしいですか？");
                Button btnno = (Button) dialog.findViewById(R.id.btnno);
                Button btnyes = (Button) dialog.findViewById(R.id.btnyes);
                btnno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _restorebtn();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        b_arrow_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                _CHOOSE++;
                if (_CHOOSE > 7)
                    _CHOOSE = 1;
                if (_CHOOSE == 2)
                    if (loaisale.equals("loai1") || loaisale.equals("loai2") || loaisale.equals("loai4")
                            || loaisale.equals("loai6") || loaisale.equals("loai7"))
                        _CHOOSE = 3;
                setGridview(_CHOOSE);
            }
        });
        b_arrow_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                _CHOOSE--;
                if (_CHOOSE < 1)
                    _CHOOSE = 7;
                if (_CHOOSE == 2)
                    if (loaisale.equals("loai1") || loaisale.equals("loai2") || loaisale.equals("loai4")
                            || loaisale.equals("loai6") || loaisale.equals("loai7"))
                        _CHOOSE = 1;
                setGridview(_CHOOSE);
            }
        });
        getlistcsv();
        getparam();
    }

    public void setbackgroundcolor() {
        frhorn.setBackgroundColor(Color.parseColor("#00000000"));
        frhorn2.setBackgroundColor(Color.parseColor("#00000000"));
        frface.setBackgroundColor(Color.parseColor("#00000000"));
        frhead.setBackgroundColor(Color.parseColor("#00000000"));
        frwing.setBackgroundColor(Color.parseColor("#00000000"));
        frbody.setBackgroundColor(Color.parseColor("#00000000"));
        frneck.setBackgroundColor(Color.parseColor("#00000000"));
    }

    PartHorn adapterHorn, adapterHorn2, adapterHead, adapterFace, adapterNeck, adapterBody;
    PartWing adapterWing;
    GridView girdhorn, girdhorn2, girdface, girdneck, girdwing, girdbody, girdhead;
    String phorn = "", phorn2 = "", pneck = "", pwing = "", pbody = "", phead = "", pface = "";

    public void getlistcsv() {
//        arrID = new ArrayList<String>();
        arrIDPartHorn2 = new ArrayList<String>();
        arrIDface = new ArrayList<String>();
        arrIDhead = new ArrayList<String>();
        arrIDneck = new ArrayList<String>();
        arrIDbody = new ArrayList<String>();
        arrIDwing = new ArrayList<String>();
        arrIDPartHorn = new ArrayList<String>();
        arrNum = new ArrayList<Integer>();
        arrNumhorn2 = new ArrayList<Integer>();
        arrNumface = new ArrayList<Integer>();
        arrNumhead = new ArrayList<Integer>();
        arrNumwing = new ArrayList<Integer>();
        arrNumneck = new ArrayList<Integer>();
        arrNumbody = new ArrayList<Integer>();

        arrUserHorn = new ArrayList<Integer>();
        arrUserHorn2 = new ArrayList<Integer>();
        arrUserFace = new ArrayList<Integer>();
        arrUserNeck = new ArrayList<Integer>();
        arrUserBody = new ArrayList<Integer>();
        arrUserWing = new ArrayList<Integer>();
        arrUserHead = new ArrayList<Integer>();

        SLHorn = new ArrayList<Integer>();
        SLHorn2 = new ArrayList<Integer>();
        SLFace = new ArrayList<Integer>();
        SLNeck = new ArrayList<Integer>();
        SLBody = new ArrayList<Integer>();
        SLWing = new ArrayList<Integer>();
        SLHead = new ArrayList<Integer>();

        SLHorn_temp = new ArrayList<Integer>();
        SLHorn2_temp = new ArrayList<Integer>();
        SLFace_temp = new ArrayList<Integer>();
        SLNeck_temp = new ArrayList<Integer>();
        SLBody_temp = new ArrayList<Integer>();
        SLWing_temp = new ArrayList<Integer>();
        SLHead_temp = new ArrayList<Integer>();

//        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
//        CSVFileFittingRoom csvFile = new CSVFileFittingRoom(inputStream);
//        List<String[]> scoreList = csvFile.read();
        if (loaisale.equals("loai1")) {
            phorn = "1000";
            phorn2 = "1001";
            phead = "1002";
            pface = "1003";
            pneck = "1004";
            pbody = "1005";
            pwing = "1006";
        }
        if (loaisale.equals("loai2")) {
            phorn = "1100";
            phorn2 = "1101";
            phead = "1102";
            pface = "1103";
            pneck = "1104";
            pbody = "1105";
            pwing = "1106";
        }
        if (loaisale.equals("loai3")) {
            phorn = "1010";
            phorn2 = "1011";
            phead = "1012";
            pface = "1013";
            pneck = "1014";
            pbody = "1015";
            pwing = "1016";
        }
        if (loaisale.equals("loai4")) {
            phorn = "1110";
            phorn2 = "1111";
            phead = "1112";
            pface = "1113";
            pneck = "1114";
            pbody = "1115";
            pwing = "1116";
        }
        if (loaisale.equals("loai5")) {
            phorn = "1020";
            phorn2 = "1021";
            phead = "1022";
            pface = "1023";
            pneck = "1024";
            pbody = "1025";
            pwing = "1026";
        }
        if (loaisale.equals("loai6")) {
            phorn = "1120";
            phorn2 = "1121";
            phead = "1122";
            pface = "1123";
            pneck = "1124";
            pbody = "1125";
            pwing = "1126";
        }
        if (loaisale.equals("loai7")) {
            phorn = "1130";
            phorn2 = "1131";
            phead = "1132";
            pface = "1133";
            pneck = "1134";
            pbody = "1135";
            pwing = "1136";
        }
        if (loaisale.equals("loai8")) {
            phorn = "1030";
            phorn2 = "1031";
            phead = "1032";
            pface = "1033";
            pneck = "1034";
            pbody = "1035";
            pwing = "1036";
        }
        if (matsale == 1)
            faceNosale = 5;
        getpart(arrNum, arrIDPartHorn, phorn, arrUserHorn, SLHorn);
//        Toast.makeText(getApplicationContext(), "SLHorn:" + SLHorn, Toast.LENGTH_SHORT).show();
        if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
            getpart(arrNumhorn2, arrIDPartHorn2, phorn2, arrUserHorn2, SLHorn2);
        getpart(arrNumhead, arrIDhead, phead, arrUserHead, SLHead);
        getpart(arrNumface, arrIDface, pface, arrUserFace, SLFace);
        getpart(arrNumneck, arrIDneck, pneck, arrUserNeck, SLNeck);
        getpart(arrNumbody, arrIDbody, pbody, arrUserBody, SLBody);
        getpart(arrNumwing, arrIDwing, pwing, arrUserWing, SLWing);
        for (int i = 0; i < SLHorn.size(); i++) {
            SLHorn_temp.add(SLHorn.get(i));
            SLHead_temp.add(SLHead.get(i));
            SLBody_temp.add(SLBody.get(i));
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                SLHorn2_temp.add(SLHorn2.get(i));
        }
        for (int i = 0; i < SLFace.size(); i++) {
            SLFace_temp.add(SLFace.get(i));
        }
        for (int i = 0; i < SLNeck.size(); i++) {
            SLNeck_temp.add(SLNeck.get(i));
        }
        for (int i = 0; i < SLWing.size(); i++) {
            SLWing_temp.add(SLWing.get(i));
        }
        adapterHorn = new PartHorn(this, arrIDPartHorn, arrNum, hornNosale, arrUserHorn, SLHorn);
        if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
            adapterHorn2 = new PartHorn(this, arrIDPartHorn2, arrNumhorn2, horn2Nosale, arrUserHorn2, SLHorn2);
        adapterFace = new PartHorn(this, arrIDface, arrNumface, faceNosale, arrUserFace, SLFace);
        adapterNeck = new PartHorn(this, arrIDneck, arrNumneck, neckNosale, arrUserNeck, SLNeck);
        adapterWing = new PartWing(this, arrIDwing, arrNumwing, wingNosale - 1, arrUserWing, SLWing);
        adapterBody = new PartHorn(this, arrIDbody, arrNumbody, bodyNosale, arrUserBody, SLBody);
        adapterHead = new PartHorn(this, arrIDhead, arrNumhead, headNosale, arrUserHead, SLHead);
        girdhorn.setAdapter(adapterHorn);
        if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
            girdhorn2.setAdapter(adapterHorn2);
        girdface.setAdapter(adapterFace);
        girdneck.setAdapter(adapterNeck);
        girdwing.setAdapter(adapterWing);
        girdbody.setAdapter(adapterBody);
        girdhead.setAdapter(adapterHead);

        _NumCr = SLHorn.get(hornNosale);
        _NumCrneck = SLNeck.get(neckNosale);
        _NumCrbody = SLBody.get(bodyNosale);
        _NumCrhead = SLHead.get(headNosale);
        if (wingNosale > 0)
            _NumCrwing = SLWing.get(wingNosale - 1);
        _NumCrface = SLFace.get(faceNosale);
        try {
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                _NumCr2 = SLHorn2.get(horn2Nosale);
        } catch (Exception e) {
            e.printStackTrace();
        }

        _NumCurChange = arrUserHorn.get(hornNosale);
        _NumCurChangebody = arrUserBody.get(bodyNosale);
        _NumCurChangeneck = arrUserNeck.get(neckNosale);
        if (wingNosale > 0)
            _NumCurChangewing = arrUserWing.get(wingNosale - 1);
        _NumCurChangeface = arrUserFace.get(faceNosale);
        _NumCurChangehead = arrUserHead.get(headNosale);
        try {
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                _NumCurChange2 = arrUserHorn2.get(horn2Nosale);
        } catch (Exception e) {
            e.printStackTrace();
        }

        _IDCurrent = Long.parseLong(arrIDPartHorn.get(hornNosale));
        _IDCurrentbody = Long.parseLong(arrIDbody.get(bodyNosale));
        if (wingNosale > 0)
            _IDCurrentwing = Long.parseLong(arrIDwing.get(wingNosale - 1));
        _IDCurrentneck = Long.parseLong(arrIDneck.get(neckNosale));
        _IDCurrentface = Long.parseLong(arrIDface.get(faceNosale));
        _IDCurrenthead = Long.parseLong(arrIDhead.get(headNosale));
        try {
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                _IDCurrent2 = Long.parseLong(arrIDPartHorn2.get(horn2Nosale));
        } catch (Exception e) {
            e.printStackTrace();
        }

        _PosCur = hornNosale;
        _PosCurface = faceNosale;
        _PosCurhead = headNosale;
        _PosCurneck = neckNosale;
        _PosCurwing = wingNosale;
        _PosCurbody = bodyNosale;
        try {
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                _PosCur2 = horn2Nosale;
        } catch (Exception e) {
            e.printStackTrace();
        }
        girdhorn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNum, girdhorn, hornchoose, arrIDPartHorn, arrUserHorn, hornNosale, SLHorn);
                if (arrNum.get(position) > 0) {
                    if (position < 7)
                        ft_horn = position;
                    if (position >= 7)
                        ft_horn = 10;
                    getparam();
                    a = pl_at - mypage.pl_at;
                    b = pl_criat - mypage.pl_criat;
                    setcolorfortext(b, criticalAttack2);
                    setcolorfortext(a, attack2);
                }
            }
        });
        girdhorn2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNumhorn2, girdhorn2, horn2choose, arrIDPartHorn2, arrUserHorn2, horn2Nosale, SLHorn2);
                if (arrNumhorn2.get(position) > 0) {
                    if (position < 7)
                        ft_horn2 = position;
                    if (position >= 7)
                        ft_horn2 = 10;
                    getparam();
                    a = pl_criat - mypage.pl_criat;
                    b = pl_avoid - mypage.pl_avoid;
                    c = pl_spe - mypage.pl_spe;
                    c *= -1;
                    setcolorfortext(a, criticalAttack2);
                    setcolorfortext(b, avoid2);
                    if (c < 0) {
                        speed2.setText("" + c);
                        speed2.setTextColor(Color.parseColor("#ff8b0f"));
                    }
                    if (c > 0) {
                        speed2.setText("+" + c);
                        speed2.setTextColor(Color.parseColor("#0000ff"));
                    }
                    if (c == 0)
                        speed2.setText("");
                }
            }
        });
        girdhead.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNumhead, girdhead, headchoose, arrIDhead, arrUserHead, headNosale, SLHead);
                if (arrNumhead.get(position) > 0) {
                    if (position < 7)
                        ft_head = position;
                    if (position >= 7)
                        ft_head = 10;
                    getparam();
                    a = pl_hp - mypage.pl_hp;
                    setcolorfortext(a, hp2);
                }
            }
        });
        girdwing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNumwing, girdwing, wingchoose, arrIDwing, arrUserWing, wingNosale - 1, SLWing);
                if (arrNumwing.get(position) > 0) {
                    if (position < 3)
                        ft_wing = position + 1;
                    if (position >= 3)
                        ft_wing = 10;
                    getparam();
                    a = pl_spe - mypage.pl_spe;
                    setcolorfortext(a, speed2);
                }
            }
        });
        girdneck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNumneck, girdneck, neckchoose, arrIDneck, arrUserNeck, neckNosale, SLNeck);
                if (arrNumneck.get(position) > 0) {
                    if (loaisale.equals("loai3")) {
                        if (position < 4)
                            ft_neck = position;
                        if (position >= 4)
                            ft_neck = 10;
                    }
                    if (loaisale.equals("loai1") || loaisale.equals("loai5") || loaisale.equals("loai7") || loaisale.equals("loai8")) {
                        if (position < 3)
                            ft_neck = position;
                        if (position >= 3)
                            ft_neck = 10;
                    }
                    if (loaisale.equals("loai2") || loaisale.equals("loai4") || loaisale.equals("loai6")) {
                        if (position < 2)
                            ft_neck = position;
                        if (position >= 2)
                            ft_neck = 10;
                    }
                    getparam();
                    a = pl_luc - mypage.pl_luc;
                    setcolorfortext(a, lucky2);
                }
            }
        });
        girdbody.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _setclickgridview(position, arrNumbody, girdbody, bodychoose, arrIDbody, arrUserBody, bodyNosale, SLBody);
                if (arrNumbody.get(position) > 0) {
                    if (position < 7)
                        ft_body = position;
                    if (position >= 7)
                        ft_body = 10;
                    getparam();
                    a = pl_de - mypage.pl_de;
                    setcolorfortext(a, defense2);
                }
            }
        });
        girdface.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                _setclickgridview(position, arrNumface, girdface, facechoose, arrIDface, arrUserFace, faceNosale, SLFace);
//                if (arrUserFace.get(position) > 0) {
//                    if (position < 5)
//                        ft_face = position;
//                    if (position >= 5)
//                        ft_face = 10;
//                    getparam();
//                    a = pl_avoid - mypage.pl_avoid;
//                    Log.e("TAG", "pl_avoid:" + pl_avoid + " mypage.pl_avoid:" + mypage.pl_avoid);
//                    if (a == 0)
//                        avoid2.setText("");
//                    if (a > 0) {
//                        avoid2.setText("+" + a);
//                        avoid2.setTextColor(Color.parseColor("#0000ff"));
//                    }
//                    if (a < 0) {
//                        avoid2.setText("" + a);
//                        avoid2.setTextColor(Color.parseColor("#ff8b0f"));
//                    }
//                }
                _setclickgridview(position, arrNumface, girdface, facechoose, arrIDface, arrUserFace, faceNosale, SLFace);
                if (arrNumface.get(position) > 0) {
                    if (position < 5)
                        ft_face = position;
                    if (position >= 5)
                        ft_face = 10;
                    getparam();
                    a = pl_avoid - mypage.pl_avoid;
                    setcolorfortext(a, avoid2);
                }
            }
        });
    }

    public void getpart(ArrayList<Integer> arrNum, ArrayList<String> arrIDPartHorn, String part,
                        ArrayList<Integer> arrUsePart, ArrayList<Integer> SL) {
        arrNum.clear();
        arrIDPartHorn.clear();
        arrUsePart.clear();
        SL.clear();
        _NumCr = 0;
        _NumPos = 0;
        _IDCurrent = 0;
        _IDPosition = 0;

        _listTablePart = db.getAllPart();
        for (int i = 0; i < _listTablePart.size(); i++) {
            String str = "" + _listTablePart.get(i).getName();
            int a = Integer.parseInt(str);
            if (a >= 100000) {
                if (str.substring(0, 4).equals(part)) {
                    arrIDPartHorn.add("" + _listTablePart.get(i).getName());
                    arrNum.add(_listTablePart.get(i).getSum());
                    SL.add(_listTablePart.get(i).getNum());
                    int remaining = _listTablePart.get(i).getSum() - _listTablePart.get(i).getNum();
                    if (remaining < 0) remaining = 0;
                    arrUsePart.add(remaining);
                }
            }
        }
    }

    public void setHideList() {
        girdface.setVisibility(View.GONE);
        girdhead.setVisibility(View.GONE);
        girdhorn.setVisibility(View.GONE);
        girdhorn2.setVisibility(View.GONE);
        girdwing.setVisibility(View.GONE);
        girdbody.setVisibility(View.GONE);
        girdneck.setVisibility(View.GONE);
    }

    public void ChangeImagePet(int position, ArrayList<String> arrIDPartHorn, ImageView hornchoose) {
        String str = "" + arrIDPartHorn.get(position);
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
        hornchoose.setImageResource(resID);
    }

    public void DrawLevel(LinearLayout layoutLevel, int lv, int size) {
        if (layoutLevel != null)
            layoutLevel.removeAllViews();
        String str = "" + lv;
        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            ImageView img = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, LinearLayout.LayoutParams.WRAP_CONTENT);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        try {
            if (pre.getBoolean("sound", true) == true) {
                mypage.soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mAdView != null) {
            mAdView.pause();
        }
        try {
//            if (isApplicationSentToBackground(this)) {
            if (mypage.soundbg.isPlaying()) {
                mypage.soundbg.pause();
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public void _RestoreImageChoosePart() {
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
            if (wingNosale == 0)
                wingchoose.setImageResource(R.drawable.trans);
            bodychoose.setImageResource(Chat.body[bodyNosale]);
            neckchoose.setImageResource(Chat.neck[neckNosale]);
            hornchoose.setImageResource(Chat.horn[hornNosale]);
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0000_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face[faceNosale]);
            }
        }
        if (loaisale.equals("loai2")) {
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0100_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face2[faceNosale]);
            }
        }

        if (loaisale.equals("loai3")) {
            frhorn2.setVisibility(View.VISIBLE);
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0001_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face3[faceNosale]);
            }
        }

        if (loaisale.equals("loai4")) {
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0101_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face4[faceNosale]);
            }
        }

        if (loaisale.equals("loai5")) {
            frhorn2.setVisibility(View.VISIBLE);
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0002_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face5[faceNosale]);
            }
        }

        if (loaisale.equals("loai6")) {
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0102_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face6[faceNosale]);
            }
        }

        if (loaisale.equals("loai7")) {
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0103_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face7[faceNosale]);
            }
        }

        if (loaisale.equals("loai8")) {
            frhorn2.setVisibility(View.VISIBLE);
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
            if (matsale == 1) {
                facechoose.setImageResource(R.drawable.face_0003_10);
            } else if (matsale == 0) {
                facechoose.setImageResource(Chat.face8[faceNosale]);
            }
        }
    }

    public void _setbuttonenable() {
        btnChange.setAlpha(1f);
        btnChange.setEnabled(true);
    }

    public void _setbuttondisable() {
        btnChange.setAlpha(0.7f);
        btnChange.setEnabled(false);
    }

    public void _set0Value() {
        hp2.setText("");
        attack2.setText("");
        criticalAttack2.setText("");
        defense2.setText("");
        critical2.setText("");
        avoid2.setText("");
        lucky2.setText("");
        speed2.setText("");
    }

    long _IDCurrent, _IDPosition;
    long _IDCurrent2, _IDPosition2;
    long _IDCurrentbody, _IDPositionbody;
    long _IDCurrentwing, _IDPositionwing;
    long _IDCurrentneck, _IDPositionneck;
    long _IDCurrenthead, _IDPositionhead;
    long _IDCurrentface, _IDPositionface;
    int _NumCr, _NumPos, _PosChange, _PosCur, _NumCurChange;
    int _NumCr2, _NumPos2, _PosChange2, _PosCur2, _NumCurChange2;
    int _NumCrhead, _NumPoshead, _PosChangehead, _PosCurhead, _NumCurChangehead;
    int _NumCrface, _NumPosface, _PosChangeface, _PosCurface, _NumCurChangeface;
    int _NumCrneck, _NumPosneck, _PosChangeneck, _PosCurneck, _NumCurChangeneck;
    int _NumCrwing, _NumPoswing, _PosChangewing, _PosCurwing, _NumCurChangewing;
    int _NumCrbody, _NumPosbody, _PosChangebody, _PosCurbody, _NumCurChangebody;

    public void _setclickgridview(int position, ArrayList<Integer> arrNum, GridView girdhorn, ImageView hornchoose,
                                  ArrayList<String> arrIDPartHorn, ArrayList<Integer> arrUserHorn, int hornNosale, ArrayList<Integer> SL) {
//        _NumCr = SL.get(hornNosale);
//        _NumCurChange = arrUserHorn.get(hornNosale);
//        _IDCurrent = Long.parseLong(arrIDPartHorn.get(hornNosale));
//        _PosCur = hornNosale;
//        Log.e("TAG", "_NumCr: " + _NumCr);
//        Log.e("TAG", "_NumCurChange: " + _NumCurChange);
        if (arrNum.get(position) == 0) {

        } else {
            if (_CHOOSE == 1) {
                _NumPos = SL.get(position);
                _IDPosition = Long.parseLong(arrIDPartHorn.get(position));
                _PosChange = arrUserHorn.get(position);
            }
            if (_CHOOSE == 2) {
                _NumPos2 = SL.get(position);
                _IDPosition2 = Long.parseLong(arrIDPartHorn.get(position));
                _PosChange2 = arrUserHorn.get(position);
            }
            if (_CHOOSE == 3) {
                _NumPoshead = SL.get(position);
                _IDPositionhead = Long.parseLong(arrIDPartHorn.get(position));
                _PosChangehead = arrUserHorn.get(position);
            }
            if (_CHOOSE == 4) {
                _NumPosface = SL.get(position);
                _IDPositionface = Long.parseLong(arrIDPartHorn.get(position));
                _PosChangeface = arrUserHorn.get(position);
            }
            if (_CHOOSE == 5) {
                _NumPosneck = SL.get(position);
                _IDPositionneck = Long.parseLong(arrIDPartHorn.get(position));
                _PosChangeneck = arrUserHorn.get(position);
            }
            if (_CHOOSE == 6) {
                _NumPosbody = SL.get(position);
                _IDPositionbody = Long.parseLong(arrIDPartHorn.get(position));
                _PosChangebody = arrUserHorn.get(position);
            }
            if (_CHOOSE == 7) {
                _NumPoswing = SL.get(position);
                _IDPositionwing = Long.parseLong(arrIDPartHorn.get(position));
                _PosChangewing = arrUserHorn.get(position);
            }
//            Log.e("TAG", "_PosChange: " + _PosChange);
            for (int i = 0; i < girdhorn.getChildCount(); i++) {
//                Log.e("TAG", "arrIDPartHorn: " + arrIDPartHorn.get(i));
                View v = girdhorn.getChildAt(i);
                ImageView layout = (ImageView) v.findViewById(R.id.iconcircle);
                if (position == i) {
                    if (arrNum.get(position) > 0) {
                        layout.setBackgroundResource(R.drawable.ft_parts_choice_circle);
                        ChangeImagePet(position, arrIDPartHorn, hornchoose);
                        if (arrUserHorn.get(position) > 0) {
                            _POS = position;
//                            Log.e("TAG", "position: " + position + " - " + " hornNosale:" + hornNosale);
                            if (position != hornNosale)
                                _setbuttonenable();
                        }
                        if (position == hornNosale) {
                            _setbuttondisable();
//                            Log.e("TAG","===");
                        }
                    }
                } else {
                    layout.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        }
    }

    public void _setAdapterTest(int _NumCr, int _NumPos, long _IDCurrent, long _IDPosition) {
        int c = _NumCr - 1;
        if (c < 0)
            c = 0;
        int p = _NumPos + 1;
        db.update_Numpart(_IDCurrent, c);
        db.update_Numpart(_IDPosition, p);
    }

    public void _setAdapter(ArrayList<Integer> arrUser, int _NumCurChange, int _PosCur, int _PosChange, int _NumCr, int _NumPos, long _IDCurrent, long _IDPosition) {
        int c = _NumCr - 1;
        if (c < 0)
            c = 0;
        int p = _NumPos + 1;
        db.update_Numpart(_IDCurrent, c);
        db.update_Numpart(_IDPosition, p);

        int b = _NumCurChange + 1;
        arrUser.set(_PosCur, b);
        int a = _PosChange - 1;
        arrUser.set(_POS, a);
        _PosCur = _POS;
//        Log.e("TAG", "_PosCur: " + _PosCur + " - b:" + b);
//        Log.e("TAG", "_PosCur: " + _POS + " - a:" + a);
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
                result = (int) Math.floor((double) mypage._life / (double) lifeMax *
                        extraParamBaseRatio);
            }
            break;
            case 2: {
                double extraParamBaseRatio = (double) param_attack_supplement;
                // こうげき補正 (パラメータStrength / 強さMax) * パラメータ補正
                result = (int) Math.floor((double) mypage._strengthsale / (double) strengthMax *
                        extraParamBaseRatio);
            }
            break;
            case 3: {
                double extraParamBaseRatio = (double) param_CriticalAttack_supplement;
                // こうげき(クリティカル)補正 ((パラメータStrength / 強さMax) - (パラメータForm / かっこよさMax)) * パラメータ補正   値が大きくなりすぎると面白くないので
                double strength = ((double) mypage._strengthsale / (double) strengthMax);
                double form = ((double) mypage._formsale / (double) formMax);
                result = (int) Math.floor((strength - form) * extraParamBaseRatio);
            }
            break;
            case 4: {
                double extraParamBaseRatio = (double) param_Defense_supplement;
                // ぼうぎょ補正 (パラメータSize - 0.6 * サイズmax) / (0.4 * サイズmax) * パラメータ補正  サイズはmax値の6割までは確実に成長するので伸びしろで計算をする
                double size = ((double) mypage._sizesale - 0.6 * (double) Chat.kBeetleSizeMax);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 5: {
                double extraParamBaseRatio = (double) param_Critical_supplement;
                // クリティカル発動補正 (パラメータForm / かっこよさMax - (パラメータFriendluw / なつき度Max)) * パラメータ補正  なつき度が高いと野生の感がなくなるイメージ
                double form = ((double) mypage._formsale / (double) formMax);
                double friendly = ((double) mypage.nuoisale / (double) friendlyMax);
                result = (int) Math.floor((form - friendly) * extraParamBaseRatio);
            }
            break;
            case 6: {
                double extraParamBaseRatio = (double) param_Avoid_supplement;
                //かいひ補正    (パラメータpersonality / パーソナリティMax -  (パラメータFriendluw / なつき度Max)) * パラメータ補正    なつき度が高いと野生の感がなくなるイメージ
                double personality = ((double) mypage.personalitysale / (double) personalityMax);
                double friendly = ((double) mypage.nuoisale / (double) friendlyMax);
                result = (int) Math.floor((personality - friendly) * extraParamBaseRatio);
            }
            break;
            case 7: {
                double extraParamBaseRatio = (double) param_Lucky_supplement;
                // ラッキー補正 (1 - (パラメータStrength / 強さMax + パラメータForm / かっこよさMax + パラメータpersonality / パーソナリティMax) / 3 + (パラメータFriendluw / なつき度Max)) * パラメータ補正    あまり強すぎる個体を作らないために攻撃、クリティカル発動率、回避のパラメータとのバランスを取る。ただしある程度こまめに世話をした方が強くなるように生命力とは独立をさせて、friendlyが高いほど高くなるようにする。
                double strength = ((double) mypage._strengthsale / (double) strengthMax);
                double form = ((double) mypage._formsale / (double) formMax);
                double personality = ((double) mypage.personalitysale / (double) personalityMax);
                double friendly = ((double) mypage.nuoisale / (double) friendlyMax);
                result = (int) Math.floor((1 - (strength + form + personality) / 3.0 + friendly) * extraParamBaseRatio);
            }
            break;
            case 8: {
                double extraParamBaseRatio = (double) param_Speed_supplement;
                //すばやさ補正   (サイズmax - パラメータSize) / (0.4 * サイズmax) * パラメータ補正    ぼうぎょと同様に確実に成長する部分は無視をする
                double size = ((double) Chat.kBeetleSizeMax - (double) mypage._sizesale);
                double size2 = (0.4 * Chat.kBeetleSizeMax);
                result = (int) Math.floor(size / size2 * extraParamBaseRatio);
            }
            break;
            case 0:
                break;
        }
        return (result);
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
        if (loaisale.equals("loai3")) {
            if (ft_neck >= 4)
                ft_neck = 10;
        }
        if (ft_face >= 5)
            ft_face = 10;
        if (ft_wing >= 4)
            ft_wing = 10;
        if (ft_head >= 7)
            ft_head = 10;
        if (ft_body >= 7)
            ft_body = 10;
        if (ft_horn >= 7)
            ft_horn = 10;
        if (ft_horn2 >= 7)
            ft_horn2 = 10;
        if (loaisale.equals("loai1") || loaisale.equals("loai5") || loaisale.equals("loai7") || loaisale.equals("loai8")) {
            if (ft_neck >= 3)
                ft_neck = 10;
        }
        if (loaisale.equals("loai2") || loaisale.equals("loai4") || loaisale.equals("loai6")) {
            if (ft_neck >= 2)
                ft_neck = 10;
        }
//        Log.e("TAG", "" + ft_horn + ":" + ft_horn2 + ":" + ft_head + ":" + ft_face + ":" + ft_neck + ":" + ft_body + ":" + ft_wing);
        pl_getTotalPartsParameter(mypage.Player_species);
    }

    int setup_parts_hp, setup_parts_attack, setup_parts_CriticalAttack,
            setup_parts_Defense, setup_parts_Critical, setup_parts_Avoid, setup_parts_Lucky, setup_parts_Speed;
    int pl_at_temp = 0, pl_hp_temp = 0, pl_criat_temp = 0, pl_de_temp = 0, pl_cri_temp = 0, pl_avoid_temp = 0, pl_luc_temp = 0, pl_spe_temp = 0;
    int pl_at = 0, pl_hp = 0, pl_criat = 0, pl_de = 0, pl_cri = 0, pl_avoid = 0, pl_luc = 0, pl_spe = 0;
    int pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement, pl_Defense_supplement, pl_Critical_supplement,
            pl_Avoid_supplement, pl_Lucky_supplement, pl_Speed_supplement;
    int pl_curHp, pl_attack, pl_CriticalAttack, pl_Defense, pl_Critical, pl_Avoid, pl_Lucky, pl_Speed;

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

        int s = Chat.convertSpeciesValue(mypage.inKind);
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
                pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement, pl_Speed_supplement, pl_hp_temp, mypage.inKind);
        pl_at = _returnAttack2(pl_attack, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_at_temp, mypage.inKind);
        pl_criat = _returnAttackCri2(pl_CriticalAttack, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_criat_temp, mypage.inKind);
        pl_de = _returnDefence2(pl_Defense, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_de_temp, mypage.inKind);
        pl_cri = _returnCritical2(pl_Critical, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_cri_temp, mypage.inKind);
        pl_avoid = _returnAvoid2(pl_Avoid, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_avoid_temp, mypage.inKind);
        pl_luc = _returnLucky2(pl_Lucky, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_luc_temp, mypage.inKind);
        pl_spe = _return2(pl_Speed, pl_hp_supplement, pl_attack_supplement, pl_CriticalAttack_supplement,
                pl_Defense_supplement, pl_Critical_supplement, pl_Avoid_supplement, pl_Lucky_supplement,
                pl_Speed_supplement, pl_spe_temp, mypage.inKind);
        Log.e("param", "" + pl_hp + "-" + pl_at + "-" + pl_criat + "-" + pl_de + "-" + pl_cri + "-" + pl_avoid + "-" + pl_luc + "-" + pl_spe);
    }

    int ft_horn, ft_horn2, ft_head, ft_face, ft_neck, ft_body, ft_wing;

    public int pl_getEquipedPartsRank(int part, int s) {
        int a = 0;
        if (part == 0)
            a = ft_horn;
        if (part == 1) {
            if (s == 2 || s == 4 || s == 7)
                a = ft_horn2;
            else
                a = -1;
        }
        if (part == 2)
            a = ft_body;
        if (part == 3)
            a = ft_face;
        if (part == 4)
            a = ft_head;
        if (part == 5)
            a = ft_neck;
        if (part == 6)
            a = ft_wing;
        return a;
    }

    public void setnulltext() {
        hp2.setText("");
        attack2.setText("");
        criticalAttack2.setText("");
        critical2.setText("");
        defense2.setText("");
        avoid2.setText("");
        lucky2.setText("");
        speed2.setText("");
    }

    public void setGridview(int Choose) {
        if (Choose == 1) {
            setbackgroundcolor();
            setHideList();
            girdhorn.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frhorn.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterHorn.notifyDataSetChanged();
        }

        if (Choose == 2) {
            setbackgroundcolor();
            setHideList();
            girdhorn2.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frhorn2.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterHorn2.notifyDataSetChanged();
        }
        if (Choose == 3) {
            setbackgroundcolor();
            setHideList();
            girdhead.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frhead.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterHead.notifyDataSetChanged();
        }
        if (Choose == 4) {
            setbackgroundcolor();
            setHideList();
            girdface.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frface.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterFace.notifyDataSetChanged();
        }
        if (Choose == 5) {
            setbackgroundcolor();
            setHideList();
            girdneck.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frneck.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterNeck.notifyDataSetChanged();
        }
        if (Choose == 6) {
            setbackgroundcolor();
            setHideList();
            girdbody.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frbody.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterBody.notifyDataSetChanged();
        }
        if (Choose == 7) {
            setbackgroundcolor();
            setHideList();
            girdwing.setVisibility(View.VISIBLE);
            _setbuttondisable();
            _set0Value();
            _RestoreImageChoosePart();
            frwing.setBackgroundColor(Color.parseColor("#8fccf7"));
            adapterWing.notifyDataSetChanged();
        }
    }

    public void _restorebtn() {
        attack2.setText("");
        criticalAttack2.setText("");
        avoid2.setText("");
        speed2.setText("");
        hp2.setText("");
        avoid2.setText("");
        lucky2.setText("");
        defense2.setText("");
        hornNosale = horntemp;
        horn2Nosale = horn2temp;
        faceNosale = facetemp;
        headNosale = headtemp;
        bodyNosale = bodytemp;
        neckNosale = necktemp;
        wingNosale = wingtemp;
        matsale = mattemp;
        db.update_fittingroom(idpetsell, mattemp, horntemp, horn2temp, wingtemp, headtemp, necktemp, facetemp, bodytemp);
        btnReset.setAlpha(0.7f);
        btnReset.setEnabled(false);
        _RestoreImageChoosePart();
        for (int i = 0; i < arrIDPartHorn.size(); i++) {
            db.update_Numpart(Integer.parseInt(arrIDPartHorn.get(i)), SLHorn_temp.get(i));
            db.update_Numpart(Integer.parseInt(arrIDhead.get(i)), SLHead_temp.get(i));
            db.update_Numpart(Integer.parseInt(arrIDbody.get(i)), SLBody_temp.get(i));
            if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8"))
                db.update_Numpart(Integer.parseInt(arrIDPartHorn2.get(i)), SLHorn2_temp.get(i));
        }
        for (int i = 0; i < arrIDneck.size(); i++) {
            db.update_Numpart(Integer.parseInt(arrIDneck.get(i)), SLNeck_temp.get(i));
        }
        for (int i = 0; i < arrIDface.size(); i++) {
            db.update_Numpart(Integer.parseInt(arrIDface.get(i)), SLFace_temp.get(i));
        }
        for (int i = 0; i < arrIDwing.size(); i++) {
            db.update_Numpart(Integer.parseInt(arrIDwing.get(i)), SLWing_temp.get(i));
        }
        //rs horn
        getpart(arrNum, arrIDPartHorn, phorn, arrUserHorn, SLHorn);
        _NumCr = SLHorn.get(hornNosale);
        _IDCurrent = Long.parseLong(arrIDPartHorn.get(hornNosale));
        adapterHorn = new PartHorn(FittingRoom.this, arrIDPartHorn, arrNum, hornNosale, arrUserHorn, SLHorn);
        girdhorn.setAdapter(adapterHorn);
        //rs horn 2
        if (loaisale.equals("loai3") || loaisale.equals("loai5") || loaisale.equals("loai8")) {
            getpart(arrNumhorn2, arrIDPartHorn2, phorn2, arrUserHorn2, SLHorn2);
            _NumCr2 = SLHorn2.get(horn2Nosale);
            _IDCurrent2 = Long.parseLong(arrIDPartHorn2.get(horn2Nosale));
            adapterHorn2 = new PartHorn(FittingRoom.this, arrIDPartHorn2, arrNumhorn2, horn2Nosale, arrUserHorn2, SLHorn2);
            girdhorn2.setAdapter(adapterHorn2);
        }
        getpart(arrNumhead, arrIDhead, phead, arrUserHead, SLHead);
        _NumCrhead = SLHead.get(headNosale);
        _IDCurrenthead = Long.parseLong(arrIDhead.get(headNosale));
        adapterHead = new PartHorn(FittingRoom.this, arrIDhead, arrNumhead, headNosale, arrUserHead, SLHead);
        girdhead.setAdapter(adapterHead);

        getpart(arrNumface, arrIDface, pface, arrUserFace, SLFace);
        _NumCrface = SLFace.get(faceNosale);
        _IDCurrentface = Long.parseLong(arrIDface.get(faceNosale));
        adapterFace = new PartHorn(FittingRoom.this, arrIDface, arrNumface, faceNosale, arrUserFace, SLFace);
        girdface.setAdapter(adapterFace);

        getpart(arrNumneck, arrIDneck, pneck, arrUserNeck, SLNeck);
        _NumCrneck = SLNeck.get(neckNosale);
        _IDCurrentneck = Long.parseLong(arrIDneck.get(neckNosale));
        adapterNeck = new PartHorn(FittingRoom.this, arrIDneck, arrNumneck, neckNosale, arrUserNeck, SLNeck);
        girdneck.setAdapter(adapterNeck);

        getpart(arrNumbody, arrIDbody, pbody, arrUserBody, SLBody);
        _NumCrbody = SLBody.get(bodyNosale);
        _IDCurrentbody = Long.parseLong(arrIDbody.get(bodyNosale));
        adapterBody = new PartHorn(FittingRoom.this, arrIDbody, arrNumbody, bodyNosale, arrUserBody, SLBody);
        girdbody.setAdapter(adapterBody);

        getpart(arrNumwing, arrIDwing, pwing, arrUserWing, SLWing);
        if (wingNosale > 0) {
            _NumCrwing = SLWing.get(wingNosale - 1);
            _IDCurrentwing = Long.parseLong(arrIDwing.get(wingNosale - 1));
        }
        adapterWing = new PartWing(FittingRoom.this, arrIDwing, arrNumwing, wingNosale - 1, arrUserWing, SLWing);
        girdwing.setAdapter(adapterWing);
    }

    public void setcolorfortext(int a, TextView avoid2) {
        if (a == 0)
            avoid2.setText("");
        if (a < 0) {
            avoid2.setText("" + a);
            avoid2.setTextColor(Color.parseColor("#ff8b0f"));
        }
        if (a > 0) {
            avoid2.setText("+" + a);
            avoid2.setTextColor(Color.parseColor("#0000ff"));
        }
    }
}