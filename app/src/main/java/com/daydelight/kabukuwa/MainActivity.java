package com.daydelight.kabukuwa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.daydelight.kabukuwa.main_intro;

import com.daydelight.kabukuwa.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    RelativeLayout relativeLayout;
    dbHandler db;
    public static ArrayList<String> arrID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.layoutmain);
        relativeLayout.setBackgroundResource(R.mipmap.default_2x);
        db = new dbHandler(this);
        arrID = new ArrayList<String>();
        InputStream inputStream = getResources().openRawResource(R.raw.item_master);
        CSVFileMainActivity csvFile = new CSVFileMainActivity(inputStream);
        List<String[]> scoreList = csvFile.read();

        SharedPreferences pre = getSharedPreferences(main_intro.prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        if (pre.getInt("database", 0) == 0) {
            for (int i = 1; i < arrID.size(); i++) {
                int a = Integer.parseInt(arrID.get(i));
//                Log.e("TAG", "ID:" + a);
                db.addpart(this, a, 0, 0, 0);
            }
            editor.putInt("database", 1);
            editor.commit();
        }
//        isInternetOn();
        _doStart();
    }

    //
    public void _doStart() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    SystemClock.sleep(1000);
                    if (i == 2) {
                        Intent intent = new Intent(MainActivity.this, main_intro.class);
                        startActivity(intent);
//                        overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_top);
                        finish();
                    }
                }
            }
        });
        thread.start();
    }

    //
//    public final boolean isInternetOn() {
//
//        // get Connectivity Manager object to check connection
//        ConnectivityManager connec =
//                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
//
//        // Check for network connections
//        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
//                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
//                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
//                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
//
//
//            return true;
//
//        } else if (
//                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
//                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
//
//            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
//            return false;
//        }
//        return false;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
