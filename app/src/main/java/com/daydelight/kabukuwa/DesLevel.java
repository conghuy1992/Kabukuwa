package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.Deslevel7;
import com.daydelight.kabukuwa.Deslevel8;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import com.daydelight.kabukuwa.R;

import java.util.List;

/**
 * Created by goood on 5/14/15.
 */
public class DesLevel extends Activity {
    private PublisherAdView mAdView;
    GridView gridView;
    Integer integer[];
    String string[] = {"No.001", "No.002", "No.003", "No.004", "No.005", "No.006", "No.007", "No.008", "", "", "", ""};
    ImageView img5;
    ImageView no1, no2, no3, no4, no5, no6, no7, no8;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, textView6;
    float tyle;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.des_level);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //

        img5 = (ImageView) findViewById(R.id.imageView5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                finish();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txt1 = (TextView) findViewById(R.id.txtname1);
        txt2 = (TextView) findViewById(R.id.txtname2);
        txt3 = (TextView) findViewById(R.id.txtname3);
        txt4 = (TextView) findViewById(R.id.txtname4);
        txt5 = (TextView) findViewById(R.id.txtname5);
        txt6 = (TextView) findViewById(R.id.txtname6);
        txt7 = (TextView) findViewById(R.id.txtname7);
        txt8 = (TextView) findViewById(R.id.txtname8);
        textView6 = (TextView) findViewById(R.id.textView6);
        no1 = (ImageView) findViewById(R.id.no1);
        no2 = (ImageView) findViewById(R.id.no2);
        no3 = (ImageView) findViewById(R.id.no3);
        no4 = (ImageView) findViewById(R.id.no4);
        no5 = (ImageView) findViewById(R.id.no5);
        no6 = (ImageView) findViewById(R.id.no6);
        no7 = (ImageView) findViewById(R.id.no7);
        no8 = (ImageView) findViewById(R.id.no8);
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getInt("no1", 0) == 1) {
            no1.setImageResource(R.drawable.no1);
            no1.setAlpha(1f);
            txt1.setText("カブトムシ");
            tyle += 12.5;
        }
        if (pre.getInt("no1", 0) == 0) {
            no1.setEnabled(false);
        }
        if (pre.getInt("no5", 0) == 1) {
            no5.setImageResource(R.drawable.no5);
            no5.setAlpha(1f);
            txt5.setText("コクワガタ");
            tyle += 12.5;
        }
        if (pre.getInt("no5", 0) == 0) {
            no5.setEnabled(false);
        }
        if (pre.getInt("no2", 0) == 1) {
            no2.setImageResource(R.drawable.no2);
            no2.setAlpha(1f);
            txt2.setText("コーカサスオオカブト");
            tyle += 12.5;
        }
        if (pre.getInt("no2", 0) == 0) {
            no2.setEnabled(false);
        }
        if (pre.getInt("no4", 0) == 1) {
            no4.setImageResource(R.drawable.no4);
            no4.setAlpha(1f);
            txt4.setText("ヘラクレスオオカブト");
            tyle += 12.5;
        }
        if (pre.getInt("no4", 0) == 0) {
            no4.setEnabled(false);
        }
        if (pre.getInt("no7", 0) == 1) {
            no7.setImageResource(R.drawable.no7);
            no7.setAlpha(1f);
            txt7.setText("ギラファノコギリクワガタ");
            tyle += 12.5;
        }
        if (pre.getInt("no7", 0) == 0) {
            no7.setEnabled(false);
        }
        if (pre.getInt("no8", 0) == 1) {
            no8.setImageResource(R.drawable.no8);
            no8.setAlpha(1f);
            txt8.setText("オウゴンオニクワガタ");
            tyle += 12.5;
        }
        if (pre.getInt("no8", 0) == 0) {
            no8.setEnabled(false);
        }
        if (pre.getInt("no3", 0) == 1) {
            no3.setImageResource(R.drawable.no3);
            no3.setAlpha(1f);
            txt3.setText("サタンオオカブト");
            tyle += 12.5;
        }
        if (pre.getInt("no3", 0) == 0) {
            no3.setEnabled(false);
        }
        if (pre.getInt("no6", 0) == 1) {
            no6.setImageResource(R.drawable.no6);
            no6.setAlpha(1f);
            txt6.setText("オオクワガタ");
            tyle += 12.5;
        }
        if (pre.getInt("no6", 0) == 0) {
            no6.setEnabled(false);
        }
        textView6.setText("" + tyle + "%");
        progressBar.setProgress((int) tyle);

        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, DesLevel1.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, DesLevel2.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, DesLevel3.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, Deslevel4.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, Deslevel5.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, DesLevel6.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, Deslevel7.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        no8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(DesLevel.this, Deslevel8.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
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
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("sound", true) == true) {
            mypage.soundbg.start();
        }
        String flag = getIntent().getStringExtra("flag");
        if (flag.equals("DesLevel1"))
            finish();
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
