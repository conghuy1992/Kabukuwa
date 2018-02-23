package com.daydelight.kabukuwa;


import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.Browser;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.DuLieu;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

/**
 * Created by goood on 5/15/15.
 */
public class mypageMenu5 extends Activity {
    dbHandler db;
    Context context = this;
    List<DuLieu> listDulieu;
    GridView dataList;
    Button button9;
    private PublisherAdView mAdView;
    private CallbackManager callbackManager;
    private LoginManager manager;
    public static Integer[] img;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypagemenu_5);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //
//        FacebookSdk.sdkInitialize(getApplicationContext());

        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //------------------------------------
        db = new dbHandler(this);
        listDulieu = db.getAll();
        dataList = (GridView) findViewById(R.id.list);
        ViewAdapter adapter = new ViewAdapter();
        try {
            dataList.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        db.adddata(getApplicationContext(), "name", "truongthanh", "20000", "loai2", 0, 0, 6, 13);
//        db.removePetLive();    dataList.setOnd
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img = new Integer[]{R.drawable.beetle_phase01_p01_a01, R.drawable.beetle_phase02_p01_a01, R.drawable.beetle_phase03_p01_a01,
                R.drawable.beetle_phase06_p01_a01, R.drawable.stag_beetle_phase01_p01_a01, R.drawable.stag_beetle_phase02_p01_a01,
                R.drawable.stag_beetle_phase03_p01_a01, R.drawable.stag_beetle_phase06_p01_a01, R.drawable.beetle_phase01_p01_a01d,
                R.drawable.beetle_phase02_p01_a01d, R.drawable.beetle_phase03_p01_a01d, R.drawable.stag_beetle_phase01_p01_a01d,
                R.drawable.stag_beetle_phase02_p01_a01d, R.drawable.stag_beetle_phase03_p01_a01d,
        };

    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    int _HINH, idpet, live, sale, hornNo, horn2No, wingNo, headNo, neckNo, faceNo, bodyNo, mat;
    String Name, Hang, Tien, loai;
    float tuoi, nuoi;
    String nameIMG = "";

    public class ViewAdapter extends BaseAdapter {
        public LayoutInflater inflater;

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
        public View getView(final int position, View convertView, final ViewGroup parent) {
            ViewHolder holder = null;
            String stt = "";
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.history_layout, null);
                holder = new ViewHolder();
                holder.idloai = (ImageView) convertView.findViewById(R.id.idloai);
                holder.name = (TextView) convertView.findViewById(R.id.txtten);
                holder.sold = (TextView) convertView.findViewById(R.id.sold);
                holder.level = (TextView) convertView.findViewById(R.id.txthang);
                holder.txtgiaban = (TextView) convertView.findViewById(R.id.txtgiaban);
                holder.frhorn = (ImageView) convertView.findViewById(R.id.horn);
                holder.frhorn2 = (ImageView) convertView.findViewById(R.id.horn2);
                holder.frdau = (ImageView) convertView.findViewById(R.id.dau);
                holder.frbody = (ImageView) convertView.findViewById(R.id.body);
                holder.frcanh = (ImageView) convertView.findViewById(R.id.canh);
                holder.frco = (ImageView) convertView.findViewById(R.id.co);
                holder.frmat = (ImageView) convertView.findViewById(R.id.mat);
                //
                holder.bgfrhorn = (ImageView) convertView.findViewById(R.id.bghorn);
                holder.bgfrhorn2 = (ImageView) convertView.findViewById(R.id.bghorn2);
                holder.bgfrdau = (ImageView) convertView.findViewById(R.id.bgdau);
                holder.bgfrbody = (ImageView) convertView.findViewById(R.id.bgbody);
                holder.bgfrcanh = (ImageView) convertView.findViewById(R.id.bgcanh);
                holder.bgfrco = (ImageView) convertView.findViewById(R.id.bgco);
                holder.bgfrmat = (ImageView) convertView.findViewById(R.id.bgmat);
                holder.setwh = (RelativeLayout) convertView.findViewById(R.id.setwh);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            //
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
            idpet = listDulieu.get(position).getId();
            Name = listDulieu.get(position).getContent();
            Hang = listDulieu.get(position).getHang();
            Tien = listDulieu.get(position).getTien();
            loai = listDulieu.get(position).getLoai();
            live = listDulieu.get(position).getLive();
            sale = listDulieu.get(position).getSale();
            tuoi = listDulieu.get(position).getTuoi();
            nuoi = listDulieu.get(position).getNuoi();
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
            mat = listDulieu.get(position).getMat();

            holder.setwh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    shareit();
//                    Toast.makeText(getApplicationContext(), "horn: " + hornNo + "\n" +
//                            "wingNo: " + wingNo + "\n" + "headNo: " + headNo + "\n" + "neckNo: " + neckNo + "\n"
//                            + "faceNo: " + faceNo + "\n" + "bodyNo: " + bodyNo + "\n" + "horn2No: " + horn2No, Toast.LENGTH_LONG).show();
                    int vt = position;
                    View mv = parent.getChildAt(vt);
//                    Toast.makeText(getApplicationContext(),"pos:"+vt,Toast.LENGTH_SHORT).show();
                    try {
                        View view = mv.findViewById(R.id.setwh);
                        view.getRootView();
                        String state = Environment.getExternalStorageState();
                        if (Environment.MEDIA_MOUNTED.equals(state)) {
                            File picDir = new File(Environment.getExternalStorageDirectory()
                                    + "/Kabukuwa");
                            if (!picDir.exists()) {
                                picDir.mkdir();
                            }
                            view.setDrawingCacheEnabled(true);
                            view.buildDrawingCache(true);
                            Bitmap bitmap = view.getDrawingCache();
                            // Date date = new Date();
                            int rand = new Random().nextInt(100000);
                            nameIMG = "KABUKUWA_" + rand;
                            String fileName = "" + nameIMG + ".png";
                            picFile = new File(picDir + "/" + fileName);
                            try {
                                picFile.createNewFile();
                                FileOutputStream picOut = new FileOutputStream(picFile);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                                        (int) (bitmap.getHeight() / 1.2));
                                boolean saved = bitmap.compress(Bitmap.CompressFormat.PNG, 100,
                                        picOut);
                                if (saved) {
//                    Toast.makeText(
//                            getApplicationContext(),
//                            "Image saved to your device Pictures "
//                                    + "directory!", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Error
                                }
                                picOut.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            view.destroyDrawingCache();
                        } else {
                            // Error
                        }
                        String imagePath = Environment.getExternalStorageDirectory()
                                + "/Kabukuwa/" + "/" + nameIMG + ".png";
                        File imageFileToShare = new File(imagePath);
                        Uri uri = Uri.fromFile(imageFileToShare);
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                "スマホでカブトムシ／クワガタムシを育てよう！\n\n" +
                                        "iPhone版「カブちゃんクワちゃん」 ダウンロードURL → https://itunes.apple.com/jp/app/kabuchan-kuwachan-tsunonoaru/id848144875?mt=8\n" +
                                        "\n" +
                                        "Android版「カブちゃんクワちゃん」 ダウンロードURL → https://play.google.com/store/apps/details?id=com.daydelight.kabukuwa&hl=ja");
                        sendIntent.setType("text/plain");
                        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "カブちゃんクワちゃん この子どう！？");
                        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
                        sendIntent.setType("image/*");
                        startActivity(Intent.createChooser(sendIntent, "Share via Kabukuwa"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            if ((loai.equals("loai2")) || (loai.equals("loai4")) || (loai.equals("loai6")) || (loai.equals("loai7"))) {
                holder.idloai.setImageResource(R.drawable.mypage_breeding_badge_kuwa);
            }
            if ((loai.equals("loai1") && tuoi < 1 && live == 0 && pre.getString("daload14s", "").length() == 0) || (loai.equals("loai3") && tuoi < 1 && live == 0 && pre.getString("daload14s3", "").length() == 0) ||
                    (loai.equals("loai5") && tuoi < 1 && live == 0 && pre.getString("daload14s5", "").length() == 0) || (loai.equals("loai8") && tuoi < 1 && live == 0 && pre.getString("daload14s8", "").length() == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.egg_icon);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
                stt = "卵" + " " + "飼育中";
            }
            if ((loai.equals("loai1") && tuoi < 1 && live == 0 && pre.getString("daload14s", "").length() > 0) || (loai.equals("loai3") && tuoi < 1 && live == 0 && pre.getString("daload14s3", "").length() > 0) ||
                    (loai.equals("loai5") && tuoi < 1 && live == 0 && pre.getString("daload14s5", "").length() > 0) || (loai.equals("loai8") && tuoi < 1 && live == 0 && pre.getString("daload14s8", "").length() > 0)) {
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase01_p01_a01);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
                stt = "1 齢幼虫" + " " + "飼育中";
            }
            if ((loai.equals("loai1") && tuoi > 1 && tuoi < 2 && live == 0) || (loai.equals("loai3") && tuoi > 1 && tuoi < 2 && live == 0) ||
                    (loai.equals("loai5") && tuoi > 1 && tuoi < 2 && live == 0) || (loai.equals("loai8") && tuoi > 1 && tuoi < 2 && live == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase02_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai1") && tuoi > 2 && tuoi < 3 && live == 0) || (loai.equals("loai3") && tuoi > 2 && tuoi < 3 && live == 0) ||
                    (loai.equals("loai5") && tuoi > 2 && tuoi < 3 && live == 0) || (loai.equals("loai8") && tuoi > 2 && tuoi < 3 && live == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase03_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai1") && tuoi > 3 && tuoi < 4 && live == 0) || (loai.equals("loai3") && tuoi > 3 && tuoi < 4 && live == 0) ||
                    (loai.equals("loai5") && tuoi > 3 && tuoi < 4 && live == 0) || (loai.equals("loai8") && tuoi > 3 && tuoi < 4 && live == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase03_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai1") && tuoi > 4 && tuoi < 5 && live == 0) || (loai.equals("loai3") && tuoi > 4 && tuoi < 5 && live == 0) ||
                    (loai.equals("loai5") && tuoi > 4 && tuoi < 5 && live == 0) || (loai.equals("loai8") && tuoi > 4 && tuoi < 5 && live == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase05_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            //
            if (loai.equals("loai1") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
                holder.frdau.setImageResource(Chat.head[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body[bodyNo]);
                holder.frco.setImageResource(Chat.neck[neckNo]);
                holder.frhorn.setImageResource(Chat.horn[hornNo]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0000_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face[faceNo]);
                Chat._setScale(1.2f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if ((loai.equals("loai2") && tuoi < 1 && pre.getString("daload14s2", "").length() == 0) || (loai.equals("loai4") && tuoi < 1 && pre.getString("daload14s4", "").length() == 0) ||
                    (loai.equals("loai6") && tuoi < 1 && pre.getString("daload14s6", "").length() == 0) || (loai.equals("loai7") && tuoi < 1 && pre.getString("daload14s7", "").length() == 0)) {
                holder.bgfrmat.setImageResource(R.drawable.egg_icon);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
                stt = "卵" + " " + "飼育中";

            }
            if ((loai.equals("loai2") && tuoi < 1 && pre.getString("daload14s2", "").length() > 0) || (loai.equals("loai4") && tuoi < 1 && pre.getString("daload14s4", "").length() > 0) ||
                    (loai.equals("loai6") && tuoi < 1 && pre.getString("daload14s6", "").length() > 0) || (loai.equals("loai7") && tuoi < 1 && pre.getString("daload14s7", "").length() > 0)) {
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase01_p01_a01);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
                stt = "1 齢幼虫" + " " + "飼育中";
            }
            if ((loai.equals("loai2") && tuoi > 1 && tuoi < 2) || (loai.equals("loai4") && tuoi > 1 && tuoi < 2) ||
                    (loai.equals("loai6") && tuoi > 1 && tuoi < 2) || (loai.equals("loai7") && tuoi > 1 && tuoi < 2)) {
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase02_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai2") && tuoi > 2 && tuoi < 3) || (loai.equals("loai4") && tuoi > 2 && tuoi < 3) ||
                    (loai.equals("loai6") && tuoi > 2 && tuoi < 3) || (loai.equals("loai7") && tuoi > 2 && tuoi < 3)) {
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai2") && tuoi > 3 && tuoi < 4) || (loai.equals("loai4") && tuoi > 3 && tuoi < 4) ||
                    (loai.equals("loai6") && tuoi > 3 && tuoi < 4) || (loai.equals("loai7") && tuoi > 3 && tuoi < 4)) {
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase03_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((loai.equals("loai2") && tuoi > 4 && tuoi < 5) || (loai.equals("loai4") && tuoi > 4 && tuoi < 5) ||
                    (loai.equals("loai6") && tuoi > 4 && tuoi < 5) || (loai.equals("loai7") && tuoi > 4 && tuoi < 5)) {
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase05_p01_a01);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if (loai.equals("loai2") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
                holder.frdau.setImageResource(Chat.head2[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing2[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body2[bodyNo]);
                holder.frco.setImageResource(Chat.neck2[neckNo]);
                holder.frhorn.setImageResource(Chat.horn2[hornNo]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0100_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face2[faceNo]);
                Chat._setScale(1.1f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
            if (loai.equals("loai3") && tuoi >= 5) {
                if (neckNo > 4)
                    neckNo = 4;
                holder.frdau.setImageResource(Chat.head3[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing3[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body3[bodyNo]);
                holder.frco.setImageResource(Chat.neck3[neckNo]);
                holder.frhorn.setImageResource(Chat.horn3[hornNo]);
                holder.frhorn2.setImageResource(Chat.horn33[horn2No]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0001_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face3[faceNo]);
                Chat._setScale(1.5f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
            //
            if (loai.equals("loai4") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
                holder.frdau.setImageResource(Chat.head4[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing4[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body4[bodyNo]);
                holder.frco.setImageResource(Chat.neck4[neckNo]);
                holder.frhorn.setImageResource(Chat.horn4[hornNo]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0101_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face4[faceNo]);
                Chat._setScale(1.2f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if (loai.equals("loai5") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
                holder.frdau.setImageResource(Chat.head5[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing5[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body5[bodyNo]);
                holder.frco.setImageResource(Chat.neck5[neckNo]);
                holder.frhorn.setImageResource(Chat.horn5[hornNo]);
                holder.frhorn2.setImageResource(Chat.horn55[horn2No]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0002_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face5[faceNo]);
                Chat._setScale(1.2f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if (loai.equals("loai6") && tuoi >= 5) {
                if (neckNo > 2)
                    neckNo = 2;
                holder.frdau.setImageResource(Chat.head6[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing6[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body6[bodyNo]);
                holder.frco.setImageResource(Chat.neck6[neckNo]);
                holder.frhorn.setImageResource(Chat.horn6[hornNo]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0102_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face6[faceNo]);
                Chat._setScale(1.6f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if (loai.equals("loai7") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
                holder.frdau.setImageResource(Chat.head7[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing7[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body7[bodyNo]);
                holder.frco.setImageResource(Chat.neck7[neckNo]);
                holder.frhorn.setImageResource(Chat.horn7[hornNo]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0103_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face7[faceNo]);
                Chat._setScale(1.1f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if (loai.equals("loai8") && tuoi >= 5) {
                if (neckNo > 3)
                    neckNo = 3;
                holder.frdau.setImageResource(Chat.head8[headNo]);
                if (wingNo > 0)
                    holder.frcanh.setImageResource(Chat.wing8[wingNo - 1]);
                holder.frbody.setImageResource(Chat.body8[bodyNo]);
                holder.frco.setImageResource(Chat.neck8[neckNo]);
                holder.frhorn.setImageResource(Chat.horn8[hornNo]);
                holder.frhorn2.setImageResource(Chat.horn88[horn2No]);
                if (mat == 1)
                    holder.frmat.setImageResource(R.drawable.face_0003_10);
                else if (mat == 0)
                    holder.frmat.setImageResource(Chat.face8[faceNo]);
                Chat._setScale(1.7f, holder.frdau, holder.frcanh, holder.frbody, holder.frco, holder.frhorn, holder.frhorn2, holder.frmat);
            }
//
            if (tuoi > 4 && sale == 0) {
                stt = "成虫";
            }
            if (sale == 1) {
                stt = "成虫 売却済";
                holder.sold.setText("売却済");
            }
            //
//            if (tuoi < 1 && live == 0) {
//                stt = "1 齢幼虫" + " " + "飼育中";
//            }
            //
            if (tuoi > 1 && tuoi < 2 && live == 0) {
                stt = "２齢幼虫" + " " + "飼育中";
            }
            if (tuoi > 2 && tuoi < 3 && live == 0) {
                stt = "３齢幼虫" + " " + "飼育中";
            }
            if (tuoi > 3 && tuoi < 4 && live == 0) {
                stt = "前蛹" + " " + "飼育中";
            }
            if (tuoi > 4 && live == 0) {
                stt = "蛹" + " " + "飼育中";
            }
            //
            if ((tuoi < 1 && live == 1 && loai.equals("loai1")) || (tuoi < 1 && live == 1 && loai.equals("loai3")) ||
                    (tuoi < 1 && live == 1 && loai.equals("loai5")) || (tuoi < 1 && live == 1 && loai.equals("loai8"))) {
                stt = "1 齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase01_p01_a01d);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
            }
            if ((tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai1")) || (tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai3")) ||
                    (tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai5")) || tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai8")) {
                stt = "２齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase02_p01_a01d);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai1")) || (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai3")) ||
                    (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai5")) || (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai8"))) {
                stt = "３齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.beetle_phase03_p01_a01d);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            //
            if ((tuoi < 1 && live == 1 && loai.equals("loai2")) || (tuoi < 1 && live == 1 && loai.equals("loai4")) ||
                    tuoi < 1 && live == 1 && loai.equals("loai6") || tuoi < 1 && live == 1 && loai.equals("loai7")) {
                stt = "1 齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase01_p01_a01d);
                holder.bgfrmat.setScaleX(0.5f);
                holder.bgfrmat.setScaleY(0.5f);
            }
            if ((tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai2")) || (tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai4")) ||
                    (tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai6")) || (tuoi > 1 && tuoi < 2 && live == 1 && loai.equals("loai7"))) {
                stt = "２齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase02_p01_a01d);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            if ((tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai2")) || (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai4")) ||
                    (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai6")) || (tuoi > 2 && tuoi < 3 && live == 1 && loai.equals("loai7"))) {
                stt = "３齢幼虫" + " " + "永眠";
                holder.bgfrmat.setImageResource(R.drawable.stag_beetle_phase03_p01_a01d);
                holder.bgfrmat.setScaleX(0.7f);
                holder.bgfrmat.setScaleY(0.7f);
            }
            //
            if (tuoi > 3 && tuoi < 4 && live == 1) {
                stt = "前蛹" + " " + "永眠";
            }
            if (tuoi > 4 && live == 1) {
                stt = "蛹" + " " + "永眠";
            }
            holder.name.setText("" + Name);
            holder.level.setText("" + Hang);
            holder.txtgiaban.setText("" + stt);
            return convertView;
        }

        public class ViewHolder {
            public ImageView idloai, frhorn, frhorn2, frco, frmat, frcanh, frdau, frbody,
                    bgfrhorn, bgfrhorn2, bgfrco, bgfrmat, bgfrcanh, bgfrdau, bgfrbody;
            public TextView name, sold, level, txtgiaban;
            public RelativeLayout setwh;
        }
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
        try {
            if (pre.getBoolean("sound", true) == true) {
                mypage.soundbg.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        callbackManager.onActivityResult(requestCode, responseCode, data);
    }

    private void sharePhotoToFacebook() {
        Uri uri = Uri.parse(picFile.getAbsolutePath());
        Bitmap image = BitmapFactory.decodeResource(getResources(), img[_HINH]);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("スマホでカブトムシ／クワガタムシを育てよう！Android版「カブちゃんクワちゃん」 ダウンロードURL → https://play.google.com/store/apps/details?id=com.daydelight.kabukuwa")
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        ShareApi.share(content, null);
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    File picFile = null;

    public void shareit() {
        View view = findViewById(R.id.setwh);// your layout id
        view.getRootView();
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File picDir = new File(Environment.getExternalStorageDirectory()
                    + "/myPic");
            if (!picDir.exists()) {
                picDir.mkdir();
            }
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            Bitmap bitmap = view.getDrawingCache();
            // Date date = new Date();
            String fileName = "kabukuwa" + ".png";
            picFile = new File(picDir + "/" + fileName);
            try {
                picFile.createNewFile();
                FileOutputStream picOut = new FileOutputStream(picFile);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                        (int) (bitmap.getHeight() / 1.2));
                boolean saved = bitmap.compress(Bitmap.CompressFormat.PNG, 100,
                        picOut);
                if (saved) {
//                    Toast.makeText(
//                            getApplicationContext(),
//                            "Image saved to your device Pictures "
//                                    + "directory!", Toast.LENGTH_SHORT).show();
                } else {
                    // Error
                }
                picOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.destroyDrawingCache();
        } else {
            // Error
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "カブちゃんクワちゃん この子どう！？");
        sharingIntent.putExtra(Intent.EXTRA_TEXT,
                "生体プレゼント（※抽選で１００名様）をご希望の方はお名前と住所をご記入ください。" + "\n" + "お名前："
                        + "\n" + "ご住所：");
        sharingIntent.setType("text/plain");
        sharingIntent.setType("image/jpeg");
        sharingIntent.putExtra(Intent.EXTRA_STREAM,
                Uri.parse(picFile.getAbsolutePath()));
        startActivity(Intent.createChooser(sharingIntent, "Share via kabukuwa"));
    }


}
