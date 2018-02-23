package com.daydelight.kabukuwa;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goood on 10/26/15.
 */
public class PartHorn extends BaseAdapter {
    Context context;
    ArrayList<String> arrID;
    ArrayList<Integer> arrNum;
    ArrayList<Integer> arrUsePart;
    ArrayList<Integer> soluong;
    int horn;

    public PartHorn(Context context, ArrayList<String> arrID, ArrayList<Integer> arrNum, int horn, ArrayList<Integer> arrUsePart, ArrayList<Integer> soluong) {
        this.context = context;
        this.arrID = arrID;
        this.arrNum = arrNum;
        this.horn = horn;
        this.arrUsePart = arrUsePart;
        this.soluong = soluong;
    }

    @Override
    public int getCount() {
        return arrID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlisthornpart, null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        ImageView ft_question = (ImageView) convertView.findViewById(R.id.ft_question);
        ImageView iconcircle = (ImageView) convertView.findViewById(R.id.iconcircle);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        text.setText("" + arrUsePart.get(position) + "/" + arrNum.get(position));
        String str = arrID.get(position);
        int a = Integer.parseInt(str);
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
//        String partwing = "" + name + part;
        String pImg = "" + name + part + pos;
        int resID = context.getResources().getIdentifier("@drawable/" + pImg, "drawable", context.getPackageName());
        icon.setImageResource(resID);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) Chat.convertDpToPixel(60), (int) Chat.convertDpToPixel(60));
        params.gravity = Gravity.CENTER;
        if (part.equals("horn")) {
            params.setMargins(0, 60, 0, 0);
            icon.setLayoutParams(params);
        }
        if (part.equals("horn2")) {
            params.setMargins(0, 55, 0, 0);
            icon.setLayoutParams(params);
        }
        if (part.equals("head")) {
            params.setMargins(0, 20, 0, 0);
            icon.setLayoutParams(params);
        }
        if (part.equals("face")) {
            params.setMargins(0, 10, 0, 0);
            icon.setLayoutParams(params);
        }
        if (part.equals("neck")) {
            params.setMargins(0, 0, 0, 10);
            icon.setLayoutParams(params);
        }
        if (part.equals("body")) {
            params.setMargins(0, 0, 0, 45);
            icon.setLayoutParams(params);
        }
        if (arrNum.get(position) == 0) {
            FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams((int) Chat.convertDpToPixel(25), (int) Chat.convertDpToPixel(25));
            params2.gravity = Gravity.CENTER;
            icon.setLayoutParams(params2);
            icon.setImageResource(R.drawable.ft_question);
        }
        if (position == horn)
            iconcircle.setBackgroundResource(R.drawable.ft_parts_choice_circle);
        return convertView;
    }
}
