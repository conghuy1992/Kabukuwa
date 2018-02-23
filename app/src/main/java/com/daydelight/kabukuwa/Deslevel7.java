package com.daydelight.kabukuwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydelight.kabukuwa.mypage;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.daydelight.kabukuwa.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

/**
 * Created by goood on 5/15/15.
 */
public class Deslevel7 extends Activity {
    int pos=0;
    Bundle bundle;
    ImageView img6;
    Gallery gallery;
    Integer imageIDs[] = {R.drawable.pic_01021, R.drawable.pic_01022, R.drawable.pic_01023, R.drawable.pic_01024};
    Integer imageIDs2[] = {R.drawable.pic_01021_1, R.drawable.pic_01022_1, R.drawable.pic_01023_1, R.drawable.pic_01024_1};
    ImageView ivSoloPicture, btnBack;
    TextView description, title4;
    ImageView btnmypage;
    private PublisherAdView mAdView;
    String []str={"No.0007 ギラファノコギリクワガタ - 1","No.0007 ギラファノコギリクワガタ - 2","No.0007 ギラファノコギリクワガタ - 3","No.0007 ギラファノコギリクワガタ - 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.des_level1);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        //admob
        mAdView = (PublisherAdView) findViewById(R.id.adView);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnmypage = (ImageView) findViewById(R.id.imgbtnmypage);
        btnmypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mypage.animScale);
                Intent i = new Intent(Deslevel7.this, DesLevel.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("flag", "DesLevel1");
                startActivity(i);
                finish();
            }
        });
        description = (TextView) findViewById(R.id.textView5);
        title4 = (TextView) findViewById(R.id.textView4);
        title4.setText("No.0007 ギラファノコギリクワガタ");
        gallery = (Gallery) findViewById(R.id.gallery);
        img6 = (ImageView) findViewById(R.id.imageView6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                pos=position;
                showdetail(position);
            }
        });
        readData();


    }

    public void readData() {
        String data;
        InputStream in = getResources().openRawResource(R.raw.text_0102);
        InputStreamReader inreader = new InputStreamReader(in);
        BufferedReader bufreader = new BufferedReader(inreader);
        StringBuilder builder = new StringBuilder();
        if (in != null) {
            try {
                while ((data = bufreader.readLine()) != null) {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                description.setText(builder.toString());
            } catch (IOException ex) {
//                Log.e("ERROR", ex.getMessage());
            }
        }
    }
    TextView txttitle;
    public void showdetail(int posistion) {
        setContentView(R.layout.layout_deslevel11);
        ivSoloPicture = (ImageView) findViewById(R.id.imageView8);
        ivSoloPicture.setImageResource(imageIDs2[posistion]);
        btnBack = (ImageView) findViewById(R.id.imageView9);
        txttitle = (TextView) findViewById(R.id.txttitle);
        txttitle.setText(str[posistion]);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                onCreate(bundle);
                gallery.setSelection(pos);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context c) {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a = obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }

        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }

        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }

        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }

        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);

            try {
                imageView.setImageResource(imageIDs[position]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            imageView.setLayoutParams(new Gallery.LayoutParams(500, 400));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
        try {
            if (mypage.soundbg.isPlaying()) {
                mypage.soundbg.pause();
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
                mypage.soundbg.start();

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
