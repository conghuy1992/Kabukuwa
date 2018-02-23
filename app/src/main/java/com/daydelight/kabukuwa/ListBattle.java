package com.daydelight.kabukuwa;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ListBattle extends BaseAdapter {

    Context context;
    ArrayList<Integer> arrnum;
    ArrayList<Integer> star;
    ArrayList<String> id_des;
    ArrayList<String> name_pet;
    ArrayList<String> arr_horn;
    ArrayList<String> arr_horn2;
    ArrayList<String> arr_head;
    ArrayList<String> arr_face;
    ArrayList<String> arr_neck;
    ArrayList<String> arr_body;
    ArrayList<String> arr_wing;

    public ListBattle(Context c, ArrayList<Integer> arrnum, ArrayList<Integer> star, ArrayList<String> id_des, ArrayList<String> name_pet,
                      ArrayList<String> arr_horn, ArrayList<String> arr_horn2, ArrayList<String> arr_head, ArrayList<String> arr_face,
                      ArrayList<String> arr_neck, ArrayList<String> arr_body, ArrayList<String> arr_wing) {
        this.context = c;
        this.arrnum = arrnum;
        this.star = star;
        this.id_des = id_des;
        this.name_pet = name_pet;
        this.arr_horn = arr_horn;
        this.arr_horn2 = arr_horn2;
        this.arr_body = arr_body;
        this.arr_face = arr_face;
        this.arr_neck = arr_neck;
        this.arr_head = arr_head;
        this.arr_wing = arr_wing;
    }

    @Override
    public int getCount() {
        return arrnum.size();
    }

    @Override
    public Object getItem(int position) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.custom_listbattle, null);
        TextView number = (TextView) convertView.findViewById(R.id.number);
        TextView des = (TextView) convertView.findViewById(R.id.des);
        ImageView horn = (ImageView) convertView.findViewById(R.id.horn);
        ImageView horn2 = (ImageView) convertView.findViewById(R.id.horn2);
        ImageView head = (ImageView) convertView.findViewById(R.id.head);
        ImageView face = (ImageView) convertView.findViewById(R.id.face);
        ImageView neck = (ImageView) convertView.findViewById(R.id.neck);
        ImageView body = (ImageView) convertView.findViewById(R.id.body);
        FrameLayout root = (FrameLayout) convertView.findViewById(R.id.root);
        Resources res = context.getResources();
        int newColor = res.getColor(R.color.new_color);
        if (Battle.inLevelRegion == 0) {
            if (position > Battle.cur_CPU) {
                root.setAlpha(0.5f);
                number.setText("??");
                des.setText("? ? ? ?");
                horn.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                horn2.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                head.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                face.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                neck.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                body.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
            } else {
                number.setText("" + arrnum.get(position));
                des.setText("" + id_des.get(position));
            }
        }
        if (Battle.inLevelRegion == 1) {
            if (position > Battle.cur_CPU2) {
                root.setAlpha(0.5f);
                number.setText("??");
                des.setText("? ? ? ?");
                horn.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                horn2.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                head.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                face.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                neck.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                body.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
            } else {
                number.setText("" + arrnum.get(position));
                des.setText("" + id_des.get(position));
            }
        }
        if (Battle.inLevelRegion == 2) {
            if (position > Battle.cur_CPU3) {
                root.setAlpha(0.5f);
                number.setText("??");
                des.setText("? ? ? ?");
                horn.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                horn2.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                head.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                face.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                neck.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
                body.setColorFilter(newColor, PorterDuff.Mode.SRC_ATOP);
            } else {
                number.setText("" + arrnum.get(position));
                des.setText("" + id_des.get(position));
            }
        }
        String pImg = gettextimage(arr_horn, position);
        String pImg2 = gettextimage(arr_horn2, position);
        String pImghead = gettextimage(arr_head, position);
        String pImgface = gettextimage(arr_face, position);
        String pImgneck = gettextimage(arr_neck, position);
        String pImgbody = gettextimage(arr_body, position);

        int resID = context.getResources().getIdentifier("@drawable/" + pImg, "drawable", context.getPackageName());
        int resID2 = context.getResources().getIdentifier("@drawable/" + pImg2, "drawable", context.getPackageName());
        int resIDhead = context.getResources().getIdentifier("@drawable/" + pImghead, "drawable", context.getPackageName());
        int resIDface = context.getResources().getIdentifier("@drawable/" + pImgface, "drawable", context.getPackageName());
        int resIDneck = context.getResources().getIdentifier("@drawable/" + pImgneck, "drawable", context.getPackageName());
        int resIDbody = context.getResources().getIdentifier("@drawable/" + pImgbody, "drawable", context.getPackageName());

        horn.setImageResource(resID);
        horn2.setImageResource(resID2);
        head.setImageResource(resIDhead);
        face.setImageResource(resIDface);
        neck.setImageResource(resIDneck);
        body.setImageResource(resIDbody);

        LinearLayout addStar = (LinearLayout) convertView.findViewById(R.id.addStar);
        for (int i = 0; i < star.get(position); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
            params.setMargins(3, 0, 0, 0);
            TextView button = new TextView(context);
            button.setLayoutParams(params);
            button.setBackgroundResource(R.drawable.battle_difficulty_star);
            addStar.addView(button);
        }
        return convertView;
    }

    public String gettextimage(ArrayList<String> arr_horn, int position) {
        String pImg = "";
        String str = arr_horn.get(position);
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
        pImg = "" + name + part + pos;
        return pImg;
    }
}
