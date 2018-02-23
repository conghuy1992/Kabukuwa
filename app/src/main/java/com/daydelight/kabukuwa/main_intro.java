package com.daydelight.kabukuwa;

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
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.daydelight.kabukuwa.ConnectionDetector;
import com.daydelight.kabukuwa.JSONParser;
import com.daydelight.kabukuwa.RegisterMember;
import com.daydelight.kabukuwa.mypage;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

/**
 * Created by goood on 5/13/15.
 */
public class main_intro extends Activity {
    List<TablePart> _listTablePart;
    VideoView mvideoView;
    public static MediaPlayer mediaPlayer;
    public static int _Nhac = 0;
    ImageView imageView, imgtitle, imglogo;
    Handler handler;
    RelativeLayout relativeLayout;
    Dialog mcustomdialog;
    dbHandler db2;
    private ProgressDialog pDialog;
    MediaPlayer mPClick;
    com.daydelight.kabukuwa.JSONParser jsonParser = new com.daydelight.kabukuwa.JSONParser();
    EditText txt1;
    EditText txt2;
    EditText txt3;
    com.daydelight.kabukuwa.ConnectionDetector cd;
    public static String prefname = "my_data";
    private static String _URL_REGISTER = "http://49.212.208.153/kabukuwa-api/index.php";
    public static ArrayList<String> itemId;
    ArrayList<String> item_id;
    // JSON Node names
    private static final String TAG_SUCCESS = "resultCode";
    private PublisherAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intro);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        db2 = new dbHandler(this);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        itemId = new ArrayList<String>();
        item_id = new ArrayList<String>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileMainIntro csvFile = new CSVFileMainIntro(inputStream);
        List<String[]> scoreList = csvFile.read();
        item_id = new ArrayList<String>();
        for (int i = 1; i < itemId.size(); i++) {
            item_id.add(itemId.get(i));
        }
        int _Height = metrics.heightPixels;
        int _Width = metrics.widthPixels;
        mPClick = MediaPlayer.create(this, R.raw.se065);
        //
        cd = new com.daydelight.kabukuwa.ConnectionDetector(getApplicationContext());
        imgtitle = (ImageView) findViewById(R.id.imgtitle);
        imglogo = (ImageView) findViewById(R.id.imglogo);
        imageView = (ImageView) findViewById(R.id.imageView);
//        if (_Width < 720) {
//            RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(100, 100);
//            p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
//            p.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
//            p.setMargins(0, 0, 0, 100);
//            imageView.setLayoutParams(p);
//        }
        relativeLayout = (RelativeLayout) findViewById(R.id.layoutintro);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                if (pre.getBoolean("soundaction", true)) {
                    mPClick.start();
                }
                if (!checkNetwork(getApplicationContext())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(main_intro.this);
                    builder.setTitle("ネットワークエラー");
                    builder.setMessage("ネットワークに接続出来ません。ネットワーク環境を確認ください。");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.show();
                    dialog.setCanceledOnTouchOutside(false);
                    TextView messageText = (TextView) dialog.findViewById(android.R.id.message);
                    messageText.setGravity(Gravity.CENTER);
                    dialog.show();
                } else if (checkNetwork(getApplicationContext())) {
                    boolean bchk = pre.getBoolean("checked", false);
                    if (bchk && pre.getString("uuid", "").length() > 0) {
//                        loaddatagame();
                        Intent intent = new Intent(main_intro.this, mypage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(main_intro.this, RegisterMember.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                if (pre.getBoolean("soundaction", true)) {
                    mPClick.start();
                }
//                _LayoutRegister();
//                if (!cd.isConnectingToInternet()) {
//                    Toast toast = Toast.makeText(getApplicationContext(), "not connect internet",
//                            Toast.LENGTH_SHORT);
//                    toast.show();
//                    return;
//                }
                if (!checkNetwork(getApplicationContext())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(main_intro.this);
                    builder.setTitle("ネットワークエラー");
                    builder.setMessage("ネットワークに接続出来ません。ネットワーク環境を確認ください。");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.show();
                    dialog.setCanceledOnTouchOutside(false);
                    TextView messageText = (TextView) dialog.findViewById(android.R.id.message);
                    messageText.setGravity(Gravity.CENTER);
                    dialog.show();
                } else if (checkNetwork(getApplicationContext())) {
                    boolean bchk = pre.getBoolean("checked", false);
                    if (bchk && pre.getString("uuid", "").length() > 0) {
//                        loaddatagame();
                        Intent intent = new Intent(main_intro.this, mypage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(main_intro.this, RegisterMember.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(this, R.raw.bgm001);
        mediaPlayer.setLooping(true);
        if (pre.getBoolean("sound", true)) {
            mediaPlayer.start();
        }

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.arg1 == 0) {
                    imageView.setImageResource(R.drawable.tab_1);
                }
                if (msg.arg1 == 1) {
                    imageView.setImageResource(R.drawable.tab_2);
                }
                if (msg.arg1 == 2) {
                    imageView.setImageResource(R.drawable.tab_3);
                }
            }
        };


        String SrcPath = "android.resource://" + getPackageName() + "/" + R.raw.video_intro;
        mvideoView = (VideoView) findViewById(R.id.myvideoview);

        MediaController ctrl = new MediaController(this);
        ctrl.setVisibility(View.GONE);
        mvideoView.setMediaController(ctrl);
        mvideoView.setVideoPath(SrcPath);
        mvideoView.requestFocus();
        mvideoView.start();
        mvideoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mvideoView.setVisibility(View.GONE);
                mvideoView.pause();
                relativeLayout.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                imgtitle.setVisibility(View.VISIBLE);
                imglogo.setVisibility(View.VISIBLE);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int a = 1;
                        do {
                            for (int i = 0; i < 3; i++) {
//                                Log.e("thread", "" + i);
                                SystemClock.sleep(300);
                                Message msg = handler.obtainMessage();
                                msg.arg1 = i;
                                handler.sendMessage(msg);
                            }
                        } while (!flag);
                    }
                });
                thread.start();
                return false;
            }
        });
        mvideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mvideoView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                imgtitle.setVisibility(View.VISIBLE);
                imglogo.setVisibility(View.VISIBLE);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int a = 1;
                        do {
                            for (int i = 0; i < 3; i++) {
//                                Log.e("thread", "" + i);
                                SystemClock.sleep(300);
                                Message msg = handler.obtainMessage();
                                msg.arg1 = i;
                                handler.sendMessage(msg);
                            }
                        } while (!flag);
                    }
                });
                thread.start();
            }
        });
    }

    boolean flag = false;

    public void _LayoutRegister() {
        setContentView(R.layout.layout_register);
        TextView des = (TextView) findViewById(R.id.txtDes);
        des.setText(getResources().getString(R.string._des));
        txt1 = (EditText) findViewById(R.id.txtdong1);
        txt2 = (EditText) findViewById(R.id.txtdong2);
        txt3 = (EditText) findViewById(R.id.txtdong3);
        Button btnRegister = (Button) findViewById(R.id.btn1);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt1.getText().toString().length() == 0) {
//                    Toast toast = Toast.makeText(getApplicationContext(),"show",Toast.LENGTH_SHORT);
//                    toast.show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(main_intro.this);
                    builder.setMessage("!= 0");
                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.create().show();

                }
                new CreateNewProduct().execute();
            }
        });
    }

    /**
     * Background Async Task to Create new product
     */
    class CreateNewProduct extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(main_intro.this);
            pDialog.setMessage("Creating...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         */
        protected String doInBackground(String... args) {
            String name = txt1.getText().toString();
            String price = txt2.getText().toString();
            String description = txt3.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("price", price));
            params.add(new BasicNameValuePair("description", description));

            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully created product
//                    Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
//                    startActivity(i);

                    // closing this screen
//                    finish();
//                    Toast toast = Toast.makeText(getApplicationContext(),"register success",Toast.LENGTH_SHORT);
//                    toast.show();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }
    }


    int stopPosition;

    @Override
    protected void onPause() {
        flag = true;
        stopPosition = mvideoView.getCurrentPosition(); //stopPosition is an int
        mvideoView.pause();
        if (mAdView != null) {
            mAdView.pause();
        }
        try {
//            if (isApplicationSentToBackground(this)) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        try {
//            if (main_intro.mediaPlayer.isPlaying()) {
//                main_intro.mediaPlayer.pause();
//            }
//        } catch (Exception e) {
//
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        if (pre.getBoolean("sound", true) == true)
            main_intro.mediaPlayer.start();

        mvideoView.seekTo(stopPosition);
        mvideoView.start();
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public static boolean checkNetwork(Context con) {
        ConnectivityManager conMgr = (ConnectivityManager) con
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr != null) {

            if (conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                    .isConnected()
                    || conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                    .isConnected()) {
                return true;
            } else {
//                  not connect
                return false;
            }
        }
        return true;
    }

    public void loaddatagame() {
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        String url = "http://49.212.208.153/kabukuwa-api/index.php?act=kkuser.getUser&email="
                + pre.getString("email", "") + "&password=" + pre.getString("pass", "");
        new GetinforUser().execute(url);
    }

    private class GetinforUser extends AsyncTask<String, String, String> {
        int success;
        String CONTENT;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShowCustomDialog();
        }

        protected String doInBackground(String... args) {
            SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", pre.getString("email", "")));
            params.add(new BasicNameValuePair("password", pre.getString("pass", "")));
            params.add(new BasicNameValuePair("act", "kkuser.getUser"));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);
            Log.d("Create Response", json.toString());
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

                } else if (success == 2) {
                    Log.e("result", "sucess =2");
                } else if (success == 3) {
                    Log.e("result", "sucess =3");
                } else {
                    Log.e("result", "else");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            if (success == 0) {
                db2.removeAll();
                db2.removeTabSTT();
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(CONTENT);
                    JSONObject object = jsonObject.getJSONObject("record");
                    int level = object.optInt("level") + 1;
                    int numCoins = object.optInt("numCoins");
                    int numJewels = object.optInt("numJewels");
                    uuid = object.optString("uuid");
                    name = object.optString("name");
                    l = level;
                    m = numCoins;
                    j = numJewels;
                    //
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pre.edit();
                    //
                    editor.putString("tenzukan", "");
                    editor.putString("tenzukan2", "");
                    editor.putString("tenzukan3", "");
                    editor.putString("tenzukan4", "");
                    editor.putString("tenzukan5", "");
                    editor.putString("tenzukan6", "");
                    editor.putString("tenzukan7", "");
                    editor.putString("tenzukan8", "");
                    editor.putString("daload14s", "");
                    editor.putString("daload14s2", "");
                    editor.putString("daload14s3", "");
                    editor.putString("daload14s4", "");
                    editor.putString("daload14s5", "");
                    editor.putString("daload14s6", "");
                    editor.putString("daload14s7", "");
                    editor.putString("daload14s8", "");
                    editor.putInt("no1", 0);
                    editor.putInt("no2", 0);
                    editor.putInt("no3", 0);
                    editor.putInt("no4", 0);
                    editor.putInt("no5", 0);
                    editor.putInt("no6", 0);
                    editor.putInt("no7", 0);
                    editor.putInt("no8", 0);
                    //
                    editor.putString("uuid", object.optString("uuid"));
                    editor.putInt("lv", level);
                    editor.putInt("money", m);
                    editor.putInt("jewel", j);
                    editor.putInt("exp", object.optInt("exp"));
                    editor.putInt("theluc", object.optInt("curHp"));
//                    editor.putString("nickname", object.optString("name"));
//                    editor.putString("email", inputPrice.getText().toString());
//                    editor.putString("pass", inputDesc.getText().toString());
//                    editor.putInt("tc", 1);
                    int expuplv = level - 1;
                    editor.putInt("exp", nextGoalExpAtLevel(expuplv));
                    editor.commit();
                    //
                    String _url = "http://49.212.208.153/kabukuwa-api/index.php?act=kkuserItem.getItem&uuid=" + pre.getString("uuid", "");
                    new getItem().execute(_url);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (success == 2) {
//                HideCustomDiaglog();
//                shownotifyWhenBuy();
//                txtyesbutton.setText("ユーザーIDとパスワードが一致するユーザーデータが見つかりませんでした。");
            }
        }
    }

    int l, m, j;
    String name = "";
    String uuid = "";

    public int nextGoalExpAtLevel(int inLevel) {
        int goalExp = 10;
        int nextGoalExp = 0;
        for (int level = 0; level < inLevel; ++level) {
            nextGoalExp += goalExp;
            goalExp += 10;
        }
        return (nextGoalExp);
    }

    public class getItem extends AsyncTask<String, Void, Void> {
        String CONTENT = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(params[0]);
                ResponseHandler<String> handler = new BasicResponseHandler();
                CONTENT = client.execute(get, handler);
            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            JSONObject object;
            try {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                object = new JSONObject(CONTENT);
                JSONObject record = object.getJSONObject("record");
                String jsonStr = record.getString("jsonStr");
                JSONObject ITEM = new JSONObject(jsonStr);

                for (int i = 0; i < item_id.size(); i++) {
                    String key = item_id.get(i);
                    if (key.length() == 1)
                        key = "0000" + key;
                    if (key.length() == 2)
                        key = "000" + key;
                    if (key.length() == 3)
                        key = "00" + key;
                    if (key.length() == 4)
                        key = "0" + key;
                    editor.putInt(key, 0);
                    editor.commit();
                    db2.update_Sumpart(Long.parseLong(key), 0);
                    db2.update_Numpart(Long.parseLong(key), 0);
                    try {
                        if (!ITEM.isNull(key)) {
                            editor.putInt(key, ITEM.getInt(key));
                            editor.commit();
                            int a = pre.getInt(key, 0);
                            db2.update_Sumpart(Long.parseLong(key), a);
                        }
                    } catch (Exception e) {
//                        db2.update_Sumpart(Long.parseLong(item_id.get(i)), 0);
                        e.printStackTrace();
                    }
                }
                String _URLPET = "http://49.212.208.153/kabukuwa-api/index.php?act=kkuserPet.getPet&uuid=" + pre.getString("uuid", "");
                new getinfor().execute(_URLPET);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class getinfor extends AsyncTask<String, Void, Void> {
        String CONTENT = "", namepet = "", kind = "";
        String alive = "", nickname = "", albino = "", hasSold = "", beetleID = "";
        int subKind, excreteS, excreteB, friend, personality, rank, satiety, sleep, strength,
                form, moisture, health, life, mood, islive, facealbino, size, sale, date, hour,
                minute, dateup, hourup, minuteup, clearn,
                _hp, _attack, _criticalAttack, _defense, _critical, _avoid, _lucky, _speed, _level,
                imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoWingRank, imagoFaceRank, imagoNeckRank, imagoBodyRank,
                imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, imagoLevel;
        long phaseETime, phaseTime, bornTime, lastCleanTime, runpaStartTime;
        float age;

        @Override

        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(params[0]);
                ResponseHandler<String> handler = new BasicResponseHandler();
                CONTENT = client.execute(get, handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            JSONObject object;
            JSONObject jsonResponse;
            try {
                SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                SharedPreferences.Editor editor = pre.edit();
                object = new JSONObject(CONTENT);
                JSONObject object1 = object.getJSONObject("record");
                jsonResponse = new JSONObject(object1.optString("jsonStr"));
                JSONArray cageInfos = jsonResponse.optJSONArray("cageInfos");
//                for (int i = 0; i < cageInfos.length(); i++) {
//                    JSONObject jsonChildNode = cageInfos.getJSONObject(i);
//                    clearn = jsonChildNode.optInt("clearn");
//                    Log.e("clearn", "" + clearn);
//                    double lct = Double.parseDouble(jsonChildNode.optString("lastCleanTime").toString());
//                    lastCleanTime = (long) lct;
//                }
                JSONArray jsonMainNode = jsonResponse.optJSONArray("petInfos");
                for (int i = 0; i < jsonMainNode.length(); i++) {

                    JSONObject jsoncageInfos = cageInfos.getJSONObject(i);
                    clearn = jsoncageInfos.optInt("clearn");
                    double lct = Double.parseDouble(jsoncageInfos.optString("lastCleanTime").toString());
                    lastCleanTime = (long) lct;
                    double rst = Double.parseDouble(jsoncageInfos.optString("runpaStartTime").toString());
                    runpaStartTime = (long) rst;

                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                    if (!jsonChildNode.isNull("imagoLevel"))
                        imagoLevel = jsonChildNode.optInt("imagoLevel") + 1;
                    if (!jsonChildNode.isNull("imagoCurExpAtCurLevel"))
                        imagoCurExpAtCurLevel = jsonChildNode.optInt("imagoCurExpAtCurLevel");
                    if (!jsonChildNode.isNull("imagoNumRingTotalBattles"))
                        imagoNumRingTotalBattles = jsonChildNode.optInt("imagoNumRingTotalBattles");
                    if (!jsonChildNode.isNull("imagoNumRingWinBattles"))
                        imagoNumRingWinBattles = jsonChildNode.optInt("imagoNumRingWinBattles");
                    if (!jsonChildNode.isNull("imagoHornRank"))
                        imagoHornRank = jsonChildNode.optInt("imagoHornRank");
                    if (!jsonChildNode.isNull("imagoHorn2Rank"))
                        imagoHorn2Rank = jsonChildNode.optInt("imagoHorn2Rank");
                    if (!jsonChildNode.isNull("imagoHeadRank"))
                        imagoHeadRank = jsonChildNode.optInt("imagoHeadRank");
                    if (!jsonChildNode.isNull("imagoFaceRank"))
                        imagoFaceRank = jsonChildNode.optInt("imagoFaceRank");
                    if (!jsonChildNode.isNull("imagoNeckRank"))
                        imagoNeckRank = jsonChildNode.optInt("imagoNeckRank");
                    if (!jsonChildNode.isNull("imagoWingRank"))
                        imagoWingRank = jsonChildNode.optInt("imagoWingRank");
                    if (!jsonChildNode.isNull("imagoBodyRank"))
                        imagoBodyRank = jsonChildNode.optInt("imagoBodyRank");

                    if (imagoHornRank > 7)
                        imagoHornRank = 7;
                    if (imagoHorn2Rank > 7)
                        imagoHorn2Rank = 7;
                    if (imagoHorn2Rank < 0)
                        imagoHorn2Rank = 0;
                    if (imagoHeadRank > 7)
                        imagoHeadRank = 7;
                    if (imagoBodyRank > 7)
                        imagoBodyRank = 7;
                    if (imagoWingRank > 4)
                        imagoWingRank = 4;
                    if (imagoWingRank < 0)
                        imagoWingRank = 0;
                    if (imagoFaceRank > 5)
                        imagoFaceRank = 5;
                    personality = Integer.parseInt(jsonChildNode.optString("personality").toString());
                    rank = Integer.parseInt(jsonChildNode.optString("rank").toString());
                    satiety = Integer.parseInt(jsonChildNode.optString("satiety").toString());
                    sleep = Integer.parseInt(jsonChildNode.optString("sleep").toString());
                    strength = Integer.parseInt(jsonChildNode.optString("strength").toString());
                    form = Integer.parseInt(jsonChildNode.optString("form").toString());
                    health = Integer.parseInt(jsonChildNode.optString("health").toString());
                    moisture = Integer.parseInt(jsonChildNode.optString("moisture").toString());
                    life = Integer.parseInt(jsonChildNode.optString("life").toString());
                    mood = Integer.parseInt(jsonChildNode.optString("mood").toString());
                    excreteS = Integer.parseInt(jsonChildNode.optString("excreteS").toString());
                    excreteB = Integer.parseInt(jsonChildNode.optString("excreteB").toString());
                    friend = Integer.parseInt(jsonChildNode.optString("friend").toString());
                    subKind = Integer.parseInt(jsonChildNode.optString("subKind").toString());
                    size = Integer.parseInt(jsonChildNode.optString("size").toString());
                    age = (float) (Float.parseFloat(jsonChildNode.optString("phase").toString()) + 0.2 - 1);
                    if (age < 0) {
                        age = 0;
                    }
//                    Log.e("AGE", "" + age);
                    double BT = Double.parseDouble(jsonChildNode.optString("bornTime").toString());
                    bornTime = (long) BT;
                    double PT = Double.parseDouble(jsonChildNode.optString("phaseTime").toString());
                    phaseTime = (long) PT;
                    double PETime = Double.parseDouble(jsonChildNode.optString("phaseETime").toString());
                    phaseETime = (long) PETime;
                    minute = (int) (phaseTime / 60);
                    hour = minute / 60;
                    date = hour / 24;
                    if (minute >= 60) {
                        minute = minute % 60;
                    }
                    if (hour >= 24) {
                        hour = hour % 24;
                    }
                    //
                    minuteup = (int) (phaseETime / 60);
                    hourup = minuteup / 60;
                    dateup = hourup / 24;
                    if (minuteup >= 60) {
                        minuteup = minuteup % 60;
                    }
                    if (hourup >= 24) {
                        hourup = hourup % 24;
                    }
                    beetleID = jsonChildNode.optString("beetleID").toString();
                    String stringID = "" + beetleID;
                    alive = jsonChildNode.optString("alive").toString();
                    albino = jsonChildNode.optString("albino").toString();
                    nickname = jsonChildNode.optString("nickname").toString();
                    hasSold = jsonChildNode.optString("hasSold").toString();
                    if (hasSold.equals("false")) {
                        sale = 0;
                    }
                    if (hasSold.equals("true")) {
                        sale = 1;
                    }
                    if (albino.equals("false")) {
                        facealbino = 0;
                    }
                    if (!albino.equals("false")) {
                        facealbino = 1;
                    }
                    if (life == 0) {
                        islive = 1;
                    }
                    if (life > 0 && age < 4) {
                        islive = 0;
                    }
                    if (life > 0 && age > 4) {
                        islive = 2;
                    }
                    if (subKind == 0) {
                        namepet = "カブトムシ";
                        kind = "loai1";
                    }
                    if (subKind == 1000) {
                        namepet = "コクワガタ";
                        kind = "loai2";
                    }
                    if (subKind == 1) {
                        namepet = "コーカサスオオカブト";
                        kind = "loai3";
                    }
                    if (subKind == 1001) {
                        namepet = "オオクワガタ";
                        kind = "loai4";
                    }
                    if (subKind == 2) {
                        namepet = "サタンオオカブト";
                        kind = "loai5";
                    }
                    if (subKind == 1002) {
                        namepet = "ギラファノコギリクワガタ";
                        kind = "loai6";
                    }
                    if (subKind == 1003) {
                        namepet = "オウゴンオニクワガタ";
                        kind = "loai7";
                    }
                    if (subKind == 3) {
                        namepet = "ヘラクレスオオカブト";
                        kind = "loai8";
                    }
                    if (subKind == 0 && age >= 5) {
                        editor.putInt("no1", 1);
                        editor.commit();
                    }
                    if (subKind == 1 && age >= 5) {
                        editor.putInt("no2", 1);
                        editor.commit();
                    }
                    if (subKind == 3 && age >= 5) {
                        editor.putInt("no3", 1);
                        editor.commit();
                    }
                    if (subKind == 2 && age >= 5) {
                        editor.putInt("no4", 1);
                        editor.commit();
                    }
                    if (subKind == 1000 && age >= 5) {
                        editor.putInt("no5", 1);
                        editor.commit();
                    }
                    if (subKind == 1001 && age >= 5) {
                        editor.putInt("no6", 1);
                        editor.commit();
                    }
                    if (subKind == 1002 && age >= 5) {
                        editor.putInt("no7", 1);
                        editor.commit();
                    }
                    if (subKind == 1003 && age >= 5) {
                        editor.putInt("no8", 1);
                        editor.commit();
                    }
                    if (alive.equals("true") && subKind == 0 && islive == 0) {
                        editor.putInt("_COUNTAN", satiety);
                        editor.putInt("_COUNTUONG", moisture);
                        editor.putInt("_COUNTNHA", clearn);
                        editor.putString("daload14s", "daload14s");
                        editor.putString("tenzukan", nickname);
                        editor.putString("id", stringID);
                        editor.putInt("sleep", sleep);
                        editor.putFloat("age", age);
                        editor.putInt("ngay", date);
                        editor.putInt("gio", hour);
                        editor.putInt("phut", minute);
                        editor.putInt("strength", strength);
                        editor.putInt("gioup", hourup);
                        editor.putInt("phutup", minuteup);
                        editor.putInt("ngayup", dateup);
                        editor.putInt("health", health);
                        editor.putInt("mood", mood);
                        editor.putInt("friendly", friend);
                        editor.putInt("daitien", excreteB);
                        editor.putInt("tieutien", excreteS);
                        editor.putInt("personality", personality);
                        editor.putInt("form", form);
                        editor.putInt("size", size);
                        editor.putLong("bornTime", bornTime);
                        editor.putLong("runpaStartTime", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 1);
                    }
                    if (alive.equals("true") && subKind == 1000 && islive == 0) {
                        editor.putInt("_COUNTAN2", satiety);
                        editor.putInt("_COUNTUONG2", moisture);
                        editor.putInt("_COUNTNHA2", clearn);
                        editor.putString("daload14s2", "daload14s2");
                        editor.putString("tenzukan2", nickname);
                        editor.putString("id2", stringID);
                        editor.putInt("sleep2", sleep);
                        editor.putFloat("age2", age);
                        editor.putInt("ngay2", date);
                        editor.putInt("gio2", hour);
                        editor.putInt("phut2", minute);
                        editor.putInt("strength2", strength);
                        editor.putInt("gioup2", hourup);
                        editor.putInt("phutup2", minuteup);
                        editor.putInt("ngayup2", dateup);
                        editor.putInt("health2", health);
                        editor.putInt("mood2", mood);
                        editor.putInt("friendly2", friend);
                        editor.putInt("daitien2", excreteB);
                        editor.putInt("tieutien2", excreteS);
                        editor.putInt("personality2", personality);
                        editor.putInt("form2", form);
                        editor.putInt("size2", size);
                        editor.putLong("bornTime2", bornTime);
                        editor.putLong("runpaStartTime2", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 2);
                    }
                    if (alive.equals("true") && subKind == 1 && islive == 0) {
                        editor.putString("daload14s3", "daload14s3");
                        editor.putInt("_COUNTAN3", satiety);
                        editor.putInt("_COUNTUONG3", moisture);
                        editor.putInt("_COUNTNHA3", clearn);
                        editor.putString("tenzukan3", nickname);
                        editor.putString("id3", stringID);
                        editor.putInt("sleep3", sleep);
                        editor.putFloat("age3", age);
                        editor.putInt("ngay3", date);
                        editor.putInt("gio3", hour);
                        editor.putInt("phut3", minute);
                        editor.putInt("strength3", strength);
                        editor.putInt("gioup3", hourup);
                        editor.putInt("phutup3", minuteup);
                        editor.putInt("ngayup3", dateup);
                        editor.putInt("health3", health);
                        editor.putInt("mood3", mood);
                        editor.putInt("friendly3", friend);
                        editor.putInt("daitien3", excreteB);
                        editor.putInt("tieutien3", excreteS);
                        editor.putInt("personality3", personality);
                        editor.putInt("form3", form);
                        editor.putInt("size3", size);
                        editor.putLong("bornTime3", bornTime);
                        editor.putLong("runpaStartTime3", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 3);
                    }
                    if (alive.equals("true") && subKind == 1001 && islive == 0) {
                        editor.putString("daload14s4", "daload14s4");
                        editor.putInt("_COUNTAN4", satiety);
                        editor.putInt("_COUNTUONG4", moisture);
                        editor.putInt("_COUNTNHA4", clearn);
                        editor.putString("tenzukan4", nickname);
                        editor.putString("id4", stringID);
                        editor.putInt("sleep4", sleep);
                        editor.putFloat("age4", age);
                        editor.putInt("ngay4", date);
                        editor.putInt("gio4", hour);
                        editor.putInt("phut4", minute);
                        editor.putInt("strength4", strength);
                        editor.putInt("gioup4", hourup);
                        editor.putInt("phutup4", minuteup);
                        editor.putInt("ngayup4", dateup);
                        editor.putInt("health4", health);
                        editor.putInt("mood4", mood);
                        editor.putInt("friendly4", friend);
                        editor.putInt("daitien4", excreteB);
                        editor.putInt("tieutien4", excreteS);
                        editor.putInt("personality4", personality);
                        editor.putInt("form4", form);
                        editor.putInt("size4", size);
                        editor.putLong("bornTime4", bornTime);
                        editor.putLong("runpaStartTime4", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 4);
                    }
                    if (alive.equals("true") && subKind == 2 && islive == 0) {
                        editor.putString("daload14s5", "daload14s5");
                        editor.putInt("_COUNTAN5", satiety);
                        editor.putInt("_COUNTUONG5", moisture);
                        editor.putInt("_COUNTNHA5", clearn);
                        editor.putString("tenzukan5", nickname);
                        editor.putString("id5", stringID);
                        editor.putInt("sleep5", sleep);
                        editor.putFloat("age5", age);
                        editor.putInt("ngay5", date);
                        editor.putInt("gio5", hour);
                        editor.putInt("phut5", minute);
                        editor.putInt("strength5", strength);
                        editor.putInt("gioup5", hourup);
                        editor.putInt("phutup5", minuteup);
                        editor.putInt("ngayup5", dateup);
                        editor.putInt("health5", health);
                        editor.putInt("mood5", mood);
                        editor.putInt("friendly5", friend);
                        editor.putInt("daitien5", excreteB);
                        editor.putInt("tieutien5", excreteS);
                        editor.putInt("personality5", personality);
                        editor.putInt("form5", form);
                        editor.putInt("size5", size);
                        editor.putLong("bornTime5", bornTime);
                        editor.putLong("runpaStartTime5", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 5);
                    }
                    if (alive.equals("true") && subKind == 1002 && islive == 0) {
                        editor.putString("daload14s6", "daload14s6");
                        editor.putString("tenzukan6", nickname);
                        editor.putInt("_COUNTAN6", satiety);
                        editor.putInt("_COUNTUONG6", moisture);
                        editor.putInt("_COUNTNHA6", clearn);
                        editor.putString("id6", stringID);
                        editor.putInt("sleep6", sleep);
                        editor.putFloat("age6", age);
                        editor.putInt("ngay6", date);
                        editor.putInt("gio6", hour);
                        editor.putInt("phut6", minute);
                        editor.putInt("strength6", strength);
                        editor.putInt("gioup6", hourup);
                        editor.putInt("phutup6", minuteup);
                        editor.putInt("ngayup6", dateup);
                        editor.putInt("health6", health);
                        editor.putInt("mood6", mood);
                        editor.putInt("friendly6", friend);
                        editor.putInt("daitien6", excreteB);
                        editor.putInt("tieutien6", excreteS);
                        editor.putInt("personality6", personality);
                        editor.putInt("form6", form);
                        editor.putInt("size6", size);
                        editor.putLong("bornTime6", bornTime);
                        editor.putLong("runpaStartTime6", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 6);
                    }
                    if (alive.equals("true") && subKind == 1003 && islive == 0) {
                        editor.putString("daload14s7", "daload14s7");
                        editor.putString("tenzukan7", nickname);
                        editor.putInt("_COUNTAN7", satiety);
                        editor.putInt("_COUNTUONG7", moisture);
                        editor.putInt("_COUNTNHA7", clearn);
                        editor.putString("id7", stringID);
                        editor.putInt("sleep7", sleep);
                        editor.putFloat("age7", age);
                        editor.putInt("ngay7", date);
                        editor.putInt("gio7", hour);
                        editor.putInt("phut7", minute);
                        editor.putInt("strength7", strength);
                        editor.putInt("gioup7", hourup);
                        editor.putInt("phutup7", minuteup);
                        editor.putInt("ngayup7", dateup);
                        editor.putInt("health7", health);
                        editor.putInt("mood7", mood);
                        editor.putInt("friendly7", friend);
                        editor.putInt("daitien7", excreteB);
                        editor.putInt("tieutien7", excreteS);
                        editor.putInt("personality7", personality);
                        editor.putInt("form7", form);
                        editor.putInt("size7", size);
                        editor.putLong("bornTime7", bornTime);
                        editor.putLong("runpaStartTime7", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 7);
                    }
                    if (alive.equals("true") && subKind == 3 && islive == 0) {
                        editor.putString("daload14s8", "daload14s8");
                        editor.putString("tenzukan8", nickname);
                        editor.putString("id8", stringID);
                        editor.putInt("_COUNTAN8", satiety);
                        editor.putInt("_COUNTUONG8", moisture);
                        editor.putInt("_COUNTNHA8", clearn);
                        editor.putInt("sleep8", sleep);
                        editor.putFloat("age8", age);
                        editor.putInt("ngay8", date);
                        editor.putInt("gio8", hour);
                        editor.putInt("phut8", minute);
                        editor.putInt("strength8", strength);
                        editor.putInt("gioup8", hourup);
                        editor.putInt("phutup8", minuteup);
                        editor.putInt("ngayup8", dateup);
                        editor.putInt("health8", health);
                        editor.putInt("mood8", mood);
                        editor.putInt("friendly8", friend);
                        editor.putInt("daitien8", excreteB);
                        editor.putInt("tieutien8", excreteS);
                        editor.putInt("personality8", personality);
                        editor.putInt("form8", form);
                        editor.putInt("size8", size);
                        editor.putLong("bornTime8", bornTime);
                        editor.putLong("runpaStartTime8", runpaStartTime);
                        editor.commit();
                        db2.adddatastt(getApplicationContext(), 8);
                    }
                    if (subKind == 0) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1000) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1) {
                        if (imagoNeckRank > 4)
                            imagoNeckRank = 4;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1001) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 2) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1002) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1003) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 3) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, "0", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, imagoLevel, imagoCurExpAtCurLevel,
                                    imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            HideCustomDiaglog();
            Intent intent = new Intent(main_intro.this, mypage.class);
            startActivity(intent);
            finish();
        }
    }

    public void _update_numpart(int subkind, int horn, int horn2, int head, int face, int neck, int body, int wing) {
        _listTablePart = db2.getAllPart();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        String _num = Chat._Strpart(horn);
        String _num2 = Chat._Strpart(horn2);
        String _num3 = Chat._Strpart(head);
//        String _num4 = Chat._Strpart(face);
        String _num4 = "";
        if (face >= 5)
            _num4 = "10";
        if (face < 5)
            _num4 = "0" + face;
//        String _num5 = Chat._Strpart(neck);
        String _num5 = Chat._StrpartNeck(neck, subkind);
        String _num6 = Chat._Strpart(body);
//        String _num7 = Chat._Strpart(wing);
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
        for (int i = 0; i < _listTablePart.size(); i++) {
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_horn)))
                db2.update_Numpart(Long.parseLong(_horn), _listTablePart.get(i).getNum() + 1);
            if (subkind == 1 || subkind == 2 || subkind == 3)
                if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_horn2)))
                    db2.update_Numpart(Long.parseLong(_horn2), _listTablePart.get(i).getNum() + 1);
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_head)))
                db2.update_Numpart(Long.parseLong(_head), _listTablePart.get(i).getNum() + 1);
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_face)))
                db2.update_Numpart(Long.parseLong(_face), _listTablePart.get(i).getNum() + 1);
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_neck)))
                db2.update_Numpart(Long.parseLong(_neck), _listTablePart.get(i).getNum() + 1);
            if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_body)))
                db2.update_Numpart(Long.parseLong(_body), _listTablePart.get(i).getNum() + 1);
            if (wing > 0)
                if (_listTablePart.get(i).getName() == Long.parseLong(String.valueOf(_wing)))
                    db2.update_Numpart(Long.parseLong(_wing), _listTablePart.get(i).getNum() + 1);
        }
    }

    public void ShowCustomDialog() {
        try {
            mcustomdialog = new Dialog(main_intro.this);
            mcustomdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mcustomdialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mcustomdialog.setCanceledOnTouchOutside(false);
            mcustomdialog.setContentView(R.layout.dialog_item);
            mcustomdialog.show();
        } catch (Exception ex) {
            Log.e("TaiLog", ex.toString());
        }
    }

    public void HideCustomDiaglog() {
        mcustomdialog.dismiss();
    }
}
