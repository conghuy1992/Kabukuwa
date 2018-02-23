package com.daydelight.kabukuwa;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.changinfo;
import com.daydelight.kabukuwa.main_intro;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by goood on 5/15/15.
 */
public class mypageMenu4 extends Activity {
    Button button;
    Button btnchangedinfo;
    ToggleButton toggle1, toggle2;
    private PublisherAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypagemenu_4);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnchangedinfo = (Button) findViewById(R.id.btnchangedinfo);
        btnchangedinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mypageMenu4.this, changinfo.class);
                startActivity(intent);
            }
        });
        toggle2 = (ToggleButton) findViewById(R.id.toggle2);
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean("soundaction", true);
                    editor.commit();
                } else {
                    editor.putBoolean("soundaction", false);
                    editor.commit();
                }
            }
        });
        toggle1 = (ToggleButton) findViewById(R.id.toggle1);
        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mypage.soundbg.start();
                    editor.putBoolean("sound", true);
                    editor.commit();
                } else {
                    if (mypage.soundbg.isPlaying()) {
                        mypage.soundbg.pause();
                        editor.putBoolean("sound", false);
                        editor.commit();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        toggle1.setChecked(pre.getBoolean("sound", true));
        toggle2.setChecked(pre.getBoolean("soundaction", true));
        if (pre.getBoolean("sound", true) == true) {
            mypage.soundbg.start();
        }
        if (mAdView != null) {
            mAdView.resume();
        }
        if (pre.getInt("tc", 0) == 1) {
            shownotifyWhenBuy();
            txtyesbutton.setText("ユーザーデータを復元しました。");
            editor.putInt("loginfirst", 0);
            editor.putInt("tc", 0);
            editor.commit();
        }

    }

    TextView txtyesbutton;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(mypageMenu4.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.dialogmenu4);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.txtcontent);
        ImageView button = (ImageView) dialogwhenbuy.findViewById(R.id.btnOK);
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
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
