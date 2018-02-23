package com.daydelight.kabukuwa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goood on 10/9/15.
 */
public class AdapterMono extends BaseAdapter {
    Context context;
    ArrayList<String> content;
    ArrayList<String> coin;
    ArrayList<String> jewel;
    ArrayList<String> star;
    ArrayList<String> number;
    ArrayList<Integer> img;
    ArrayList<Integer> id;

    public AdapterMono(Context c, ArrayList<String> content, ArrayList<String> coin, ArrayList<String> jewel,
                       ArrayList<String> star, ArrayList<String> number,
                       ArrayList<Integer> img, ArrayList<Integer> id) {
        this.context = c;
        this.content = content;
        this.coin = coin;
        this.jewel = jewel;
        this.star = star;
        this.number = number;
        this.img = img;
        this.id = id;
    }

    @Override
    public int getCount() {
        return content.size();
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
        convertView = inflater.inflate(R.layout.mono_food, null);
        TextView txtct = (TextView) convertView.findViewById(R.id.content);
        TextView txtcoin = (TextView) convertView.findViewById(R.id.coin);
        TextView txtjewel = (TextView) convertView.findViewById(R.id.jewel);
        TextView txtnumber = (TextView) convertView.findViewById(R.id.number);
        ImageView imgicon = (ImageView) convertView.findViewById(R.id.imgitem);
        LinearLayout lnstar = (LinearLayout) convertView.findViewById(R.id.lnstar);
        LinearLayout root = (LinearLayout) convertView.findViewById(R.id.root);
        for (int i = 0; i < Integer.parseInt(star.get(position)); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
            params.setMargins(3, 0, 0, 0);
            TextView t = new TextView(context);
            t.setLayoutParams(params);
            t.setBackgroundResource(R.drawable.battle_difficulty_star);
            lnstar.addView(t);
        }
        txtct.setText(content.get(position));
        txtcoin.setText(coin.get(position));
        txtjewel.setText(jewel.get(position));
        txtnumber.setText(" x " + number.get(position));
        imgicon.setImageResource(img.get(position));
        return convertView;
    }
}
