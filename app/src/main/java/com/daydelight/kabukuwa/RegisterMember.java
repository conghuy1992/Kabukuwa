package com.daydelight.kabukuwa;

/**
 * Created by goood on 5/14/15.
 */

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daydelight.kabukuwa.*;
import com.daydelight.kabukuwa.main_intro;

import com.daydelight.kabukuwa.R;

public class RegisterMember extends Activity {

    public static ArrayList<String> itemId;
    ArrayList<String> item_id;
    // Progress Dialog
    private ProgressDialog pDialog;
    List<TablePart> _listTablePart;
    Animation animScale;
    JSONParser jsonParser = new JSONParser();
    EditText inputName;
    EditText inputPrice;
    EditText inputDesc;
    String level = "0";
    String rank = "0";
    String exp = "0";
    String curHp = "10";
    String maxHp = "10";
    String numCoins = "1000";
    String numJewels = "10";
    String uuid = "";

    // url to create new product
//    private static String url_create_product = "http://10.0.3.2/android_connect/create_product.php";
    private static String _URL_REGISTER = "http://49.212.208.153/kabukuwa-api/index.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "resultCode";
    dbHandler db2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        db2 = new dbHandler(this);
        _listTablePart = db2.getAllPart();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int gio = c.get(Calendar.HOUR);
        int phut = c.get(Calendar.MINUTE);
        int giay = c.get(Calendar.SECOND);
        String str = "" + year;
        String str2 = str.substring(2, 4);
        uuid = "UUID" + str2 + month + date + gio + phut + giay;
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
//        Toast toast = Toast.makeText(getApplicationContext(),""+uuid,Toast.LENGTH_LONG);
//        toast.show();
        itemId = new ArrayList<String>();
        item_id = new ArrayList<String>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileRegister csvFile = new CSVFileRegister(inputStream);
        List<String[]> scoreList = csvFile.read();
        item_id = new ArrayList<String>();
        for (int i = 1; i < itemId.size(); i++) {
            item_id.add(itemId.get(i));
        }

        // Edit Text
        inputName = (EditText) findViewById(R.id.txtdong1);
        inputPrice = (EditText) findViewById(R.id.txtdong2);
        inputDesc = (EditText) findViewById(R.id.txtdong3);

        // Create button
        Button btnCreateProduct = (Button) findViewById(R.id.btn1);

        // button click event
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                view.startAnimation(animScale);
                if ((inputName.getText().toString().length() < 4)
                        || (inputName.getText().toString().length() > 10)) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ニックネームは４文字から10文字以内で入力してください。");
                    return;
                }
                if ((inputPrice.getText().toString().length() < 4) || (inputPrice.getText().toString().length() > 10)) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ユーザーIDは４文字から10文字以内で入力してください。");
                    return;
                }
                if ((inputDesc.getText().toString().length() < 4) || (inputDesc.getText().toString().length() > 10)) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("パスワードは４文字から10文字以内で入力してください。");
                    return;
                } else {
                    new CreateNewProduct().execute();
                }

            }
        });
        //
        Button button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                if (inputPrice.getText().toString().length() == 0 || inputDesc.getText().toString().length() == 0) {
                    shownotifyWhenBuy();
                    txtyesbutton.setText("ユーザーIDを入力してください。");
                    return;
                }
                String url = "http://49.212.208.153/kabukuwa-api/index.php?act=kkuser.getUser&email="
                        + inputPrice.getText().toString() + "&password=" + inputDesc.getText().toString();
                new GetinforUser().execute(url);

            }
        });
    }

    TextView txtyesbutton;

    public void shownotifyWhenBuy() {
        final Dialog dialogwhenbuy = new Dialog(RegisterMember.this);
        dialogwhenbuy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogwhenbuy.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogwhenbuy.setContentView(R.layout.notify);
        txtyesbutton = (TextView) dialogwhenbuy.findViewById(R.id.textView12);
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

    private class CreateNewProduct extends AsyncTask<String, String, String> {
        int success;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShowCustomDialog();
        }

        protected String doInBackground(String... args) {
            String name = inputName.getText().toString();
            String price = inputPrice.getText().toString();
            String description = inputDesc.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("email", price));
            params.add(new BasicNameValuePair("password", description));

            params.add(new BasicNameValuePair("act", "kkuser.regUser"));
            params.add(new BasicNameValuePair("level", level));
            params.add(new BasicNameValuePair("rank", rank));
            params.add(new BasicNameValuePair("exp", exp));
            params.add(new BasicNameValuePair("curHp", curHp));
            params.add(new BasicNameValuePair("maxHp", maxHp));
            params.add(new BasicNameValuePair("numCoins", numCoins));
            params.add(new BasicNameValuePair("numJewels", numJewels));
            params.add(new BasicNameValuePair("uuid", uuid));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);
                // success = 0 : completed
                if (success == 0) {
                    // successfully created
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pre.edit();
                    int persent = new Random().nextInt(30) + 10;
                    int strength = 800 * persent / 100;
                    int form = new Random().nextInt(800);
                    int personality = new Random().nextInt(800);
                    boolean chx = true;
                    if (!chx) {
                        editor.clear();
                    } else {
                        editor.putString("email", inputPrice.getText().toString());
                        editor.putString("pass", inputDesc.getText().toString());
                        editor.putBoolean("checked", chx);
                        editor.putString("nickname", inputName.getText().toString());
                        editor.putInt("money", 1000);
                        editor.putInt("jewel", 10);
                        editor.putInt("01001", 100);
                        editor.putInt("00001", 100);
                        editor.putInt("01003", 0);
                        editor.putInt("00003", 0);
                        editor.putInt("03001", 0);
                        editor.putInt("03002", 0);
                        editor.putInt("_COUNTUONG", 400);
                        editor.putInt("_COUNTAN", 400);
                        editor.putInt("_COUNTNHA", 800);
                        editor.putFloat("age", 0);
                        editor.putInt("giay", 59);
                        editor.putInt("phut", 59);
                        editor.putInt("gio", 23);
                        editor.putInt("ngay", 0);
                        editor.putInt("friendly", 0);
                        editor.putInt("lv", 1);
                        editor.putInt("exp", 0);
                        editor.putInt("txt25", 0);
                        editor.putString("uuid", uuid);
                        editor.putInt("maxHp", 0);
                        editor.putInt("curHp", 0);
                        editor.putInt("sleep", 800);
                        editor.putInt("health", 800);
                        editor.putInt("mood", 800);
                        editor.putInt("daitien", 0);
                        editor.putInt("tieutien", 0);
                        editor.putInt("strength", strength);
                        editor.putInt("personality", personality);
                        editor.putInt("form", form);
                    }
                    editor.commit();

                    Intent i = new Intent(RegisterMember.this, mypage.class);
                    i.putExtra("name", inputName.getText().toString());
                    db2.update_Sumpart(1, 100);
                    db2.update_Sumpart(1001, 100);
                    startActivity(i);
                    finish();
                } else if (success == 2) {
                    // failed to create product
//                    Toast toast = Toast.makeText(getApplicationContext(), "既に同名で登録しているユーザーがいます。ニックネームを変更してください。", Toast.LENGTH_SHORT);
//                    toast.show();
                    Log.e("result", "sucess =2");
                } else if (success == 3) {
                    // failed to create product
//                    Toast toast = Toast.makeText(getApplicationContext(), "既に同名で登録しているユーザーがいます。ユーザーIDを変更してください", Toast.LENGTH_SHORT);
//                    toast.show();
                    Log.e("result", "sucess =3");
                } else {
                    // failed to create product
//                    Toast toast = Toast.makeText(getApplicationContext(), "サーバーエラーが発生しました。", Toast.LENGTH_SHORT);
//                    toast.show();
                    Log.e("result", "else");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            HideCustomDiaglog();
            if (success == 2) {
                shownotifyWhenBuy();
                txtyesbutton.setText("既に同名で登録しているユーザーがいます。ニックネームを変更してください。");

            } else if (success == 3) {
                shownotifyWhenBuy();
                txtyesbutton.setText("既に同名で登録しているユーザーがいます。ユーザーIDを変更してください");
            }
        }
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
            String name = inputName.getText().toString();
            String price = inputPrice.getText().toString();
            String description = inputDesc.getText().toString();

            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", price));
            params.add(new BasicNameValuePair("password", description));
            params.add(new BasicNameValuePair("act", "kkuser.getUser"));

            JSONObject json = jsonParser.makeHttpRequest(_URL_REGISTER,
                    "POST", params);

            // check log cat fro response
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
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(CONTENT);
                    JSONObject object = jsonObject.getJSONObject("record");
                    int _exp = object.optInt("exp");
                    int level = 0;
                    if (_exp < 10)
                        level = 1;
                    if (_exp >= 10) {
                        for (int i = 1; i > 0; i++) {
                            if (Chat.nextGoalExpAtLevel(i) > _exp) {
                                level = i;
                                break;
                            }
                        }
                    }
                    int numCoins = object.optInt("numCoins");
                    int numJewels = object.optInt("numJewels");
                    String uuidRestore = object.optString("uuid");
                    String name = object.optString("name");
                    int persent = new Random().nextInt(30) + 10;
                    int strength = 800 * persent / 100;
                    int form = new Random().nextInt(800);
                    int personality = new Random().nextInt(800);
                    SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pre.edit();
                    editor.putString("email", object.optString("email"));
                    editor.putString("pass", object.optString("password"));
                    editor.putBoolean("checked", true);
                    editor.putString("uuid", uuidRestore);
                    editor.putInt("lv", level);
                    if (level >= 10)
                        editor.putInt("level10", 1);
                    if (level >= 30)
                        editor.putInt("level30", 1);
                    if (level >= 50)
                        editor.putInt("level50", 1);
                    if (level >= 70)
                        editor.putInt("level70", 1);
                    if (level >= 99)
                        editor.putInt("level99", 1);
                    editor.putInt("rank", object.optInt("rank"));
                    editor.putInt("money", numCoins);
                    editor.putInt("jewel", numJewels);
                    editor.putString("nickname", name);
                    editor.putInt("_COUNTUONG", 400);
                    editor.putInt("_COUNTAN", 400);
                    editor.putInt("_COUNTNHA", 800);
                    editor.putFloat("age", 0);
                    editor.putInt("exp", _exp);
                    editor.putInt("theluc", object.optInt("curHp"));
                    editor.putInt("giay", 59);
                    editor.putInt("phut", 59);
                    editor.putInt("gio", 23);
                    editor.putInt("ngay", 0);
                    editor.putInt("friendly", 0);
                    editor.putInt("txt25", 0);
                    editor.putInt("maxHp", 0);
                    editor.putInt("curHp", 0);
                    editor.putInt("health", 800);
                    editor.putInt("mood", 800);
                    editor.putInt("daitien", 0);
                    editor.putInt("tieutien", 0);
                    editor.putInt("strength", strength);
                    editor.putInt("personality", personality);
                    editor.putInt("form", form);
                    editor.commit();
                    String _url = "http://49.212.208.153/kabukuwa-api/index.php?act=kkuserItem.getItem&uuid=" + pre.getString("uuid", "");
                    new getItem().execute(_url);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (success == 2) {
                HideCustomDiaglog();
                shownotifyWhenBuy();
                txtyesbutton.setText("ユーザーIDとパスワードが一致するユーザーデータが見つかりませんでした。");
            }
        }
    }

    Dialog mcustomdialog;

    public void ShowCustomDialog() {
        try {
            mcustomdialog = new Dialog(RegisterMember.this);
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
        try {
            mcustomdialog.dismiss();
        } catch (Exception ex) {
            Log.e("TaiLog", ex.toString());
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        try {
//            if (isApplicationSentToBackground(this)) {
            if (main_intro.mediaPlayer.isPlaying()) {
                main_intro.mediaPlayer.pause();
            }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        try {
            if (pre.getBoolean("sound", true) == true) {
                main_intro.mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            int foodbig = 0, drinkbig = 0, thuoc = 0, thuocbig = 0;
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
//                int food = ITEM.getInt("01001");
//                int drink = ITEM.getInt("00001");
//                try {
//                    foodbig = ITEM.getInt("01003");
//                    drinkbig = ITEM.getInt("00003");
//                    thuoc = ITEM.getInt("03001");
//                    thuocbig = ITEM.getInt("03002");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                editor.putInt("1001", food);
//                editor.putInt("1003", foodbig);
//                editor.putInt("1", drink);
//                editor.putInt("3", drinkbig);
//                editor.putInt("3001", thuoc);
//                editor.putInt("3002", thuocbig);
//                editor.commit();
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
        int subKind, excreteS, excreteB, friend, personality, rank, satiety, sleep, strength, clearn,
                form, moisture, health, life, mood, islive, facealbino, size, sale, date, hour,
                minute, dateup, hourup, minuteup,
                imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoWingRank, imagoFaceRank, imagoNeckRank, imagoBodyRank,
                imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, imagoLevel;

        long phaseETime, phaseTime, bornTime, lastCleanTime, runpaStartTime;
        float age;
        double imagoCurHpPercent;

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
//            db2.removeAll();
//            db2.removeTabPart();
//            db2.removeTabshowpet();
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
//                    clearn = Integer.parseInt(jsonChildNode.optString("clearn").toString());
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
                    if (!jsonChildNode.isNull("imagoCurHpPercent")) {
                        imagoCurHpPercent = jsonChildNode.optDouble("imagoCurHpPercent");
//                        imagoCurHpPercent = (int) CurHpPercent;
//                        Toast.makeText(getApplicationContext(), "CurHpPercent:" + CurHpPercent, Toast.LENGTH_SHORT).show();
                    }

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
//                    Log.e("TAG", "phaseETime:" + phaseETime + " minuteup:" + minuteup + " hourup:" + hourup + " dateup:" + dateup);
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
                        editor.putString("daload14s", "daload14s");
                        editor.putInt("_COUNTAN", satiety);
                        editor.putInt("_COUNTUONG", moisture);
                        editor.putInt("_COUNTNHA", clearn);
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
                        editor.putString("daload14s2", "daload14s2");
                        editor.putInt("_COUNTAN2", satiety);
                        editor.putInt("_COUNTUONG2", moisture);
                        editor.putInt("_COUNTNHA2", clearn);
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
                        editor.putString("tenzukan4", nickname);
                        editor.putInt("_COUNTAN4", satiety);
                        editor.putInt("_COUNTUONG4", moisture);
                        editor.putInt("_COUNTNHA4", clearn);
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
                        editor.putString("tenzukan5", nickname);
                        editor.putString("id5", stringID);
                        editor.putInt("_COUNTAN5", satiety);
                        editor.putInt("_COUNTUONG5", moisture);
                        editor.putInt("_COUNTNHA5", clearn);
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
                        editor.putString("id6", stringID);
                        editor.putInt("sleep6", sleep);
                        editor.putInt("_COUNTAN6", satiety);
                        editor.putInt("_COUNTUONG6", moisture);
                        editor.putInt("_COUNTNHA6", clearn);
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
                        editor.putString("id7", stringID);
                        editor.putInt("sleep7", sleep);
                        editor.putFloat("age7", age);
                        editor.putInt("_COUNTAN7", satiety);
                        editor.putInt("_COUNTUONG7", moisture);
                        editor.putInt("_COUNTNHA7", clearn);
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
                        editor.putInt("sleep8", sleep);
                        editor.putInt("_COUNTAN8", satiety);
                        editor.putInt("_COUNTUONG8", moisture);
                        editor.putInt("_COUNTNHA8", clearn);
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
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1000) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1) {
                        if (imagoNeckRank > 4)
                            imagoNeckRank = 4;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1001) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 2) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1002) {
                        if (imagoNeckRank > 2)
                            imagoNeckRank = 2;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 1003) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                    if (subKind == 3) {
                        if (imagoNeckRank > 3)
                            imagoNeckRank = 3;
                        if (jsonChildNode.isNull("imagoHornRank"))
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, 0, 0, 0, 0, 0, 0, 0, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, runpaStartTime);
                        if (!jsonChildNode.isNull("imagoHornRank")) {
                            if (hasSold.equals("false"))
                                _update_numpart(subKind, imagoHornRank, imagoHorn2Rank, imagoHeadRank, imagoFaceRank, imagoNeckRank, imagoBodyRank, imagoWingRank);
                            db2.adddata(getApplicationContext(), nickname, namepet, life + "", kind, islive, sale, age,
                                    1, facealbino, imagoHornRank, imagoHorn2Rank, imagoWingRank, imagoHeadRank, imagoNeckRank,
                                    imagoFaceRank, imagoBodyRank, personality,
                                    excreteS, satiety, sleep, phaseETime, strength, bornTime, excreteB, form, phaseTime, size, moisture,
                                    health, mood, clearn, lastCleanTime, stringID, imagoCurHpPercent, 0, 0, 0, 0, 0, 0, 0, imagoLevel,
                                    imagoCurExpAtCurLevel, imagoNumRingTotalBattles, imagoNumRingWinBattles, runpaStartTime);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            HideCustomDiaglog();
            Intent i = new Intent(RegisterMember.this, mypage.class);
            startActivity(i);
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
//        Log.e("WING", "wing:" + _wing);
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
}