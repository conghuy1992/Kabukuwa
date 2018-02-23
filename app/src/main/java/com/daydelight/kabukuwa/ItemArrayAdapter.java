package com.daydelight.kabukuwa;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> itemNameShop;
    ArrayList<String> coinsShop;
    ArrayList<String> jewelsShop;
    ArrayList<String> rarityShop;
    ArrayList<String> itemIdShop;
    ArrayList<String> numitem;

    public ItemArrayAdapter(Context context, ArrayList<String> arr, ArrayList<String> arr2, ArrayList<String> arr3,
                            ArrayList<String> arr4, ArrayList<String> arr5, ArrayList<String> arr6) {
        this.context = context;
        this.itemNameShop = arr;
        this.coinsShop = arr2;
        this.jewelsShop = arr3;
        this.rarityShop = arr4;
        this.itemIdShop = arr5;
        this.numitem = arr6;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemNameShop.size();
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
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_selllayout, null);
            holder = new ViewHolder();
            holder.txtname = (TextView) convertView.findViewById(R.id.txtname);
            holder.txtcoin = (TextView) convertView.findViewById(R.id.txtcoin);
            holder.txtjewel = (TextView) convertView.findViewById(R.id.txtjewel);
            holder.num = (TextView) convertView.findViewById(R.id.num);
            holder.imgsell = (ImageView) convertView.findViewById(R.id.imgsell);
            holder.imgsellHead = (ImageView) convertView.findViewById(R.id.imgsellHead);
            holder.lnstar = (LinearLayout) convertView.findViewById(R.id.lnstar);
//            Log.e("TAG","Scroll");
            String star = rarityShop.get(position);
            int _inStar = Integer.parseInt(star);
            int size = 25;
            if (mypage._Width < 720)
                size = 20;
            LinearLayout.LayoutParams paramsv = new LinearLayout.LayoutParams(size, size);
            paramsv.setMargins(3, 0, 0, 0);
            for (int i = 0; i < _inStar; i++) {
                TextView button = new TextView(context);
                button.setLayoutParams(paramsv);
                button.setBackgroundResource(R.drawable.battle_difficulty_star2);
                holder.lnstar.addView(button);
            }
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtname.setText(itemNameShop.get(position));
        holder.txtcoin.setText(new DecimalFormat("#,###,###").format(Integer.parseInt(coinsShop.get(position))));
        holder.txtjewel.setText(jewelsShop.get(position));
        holder.num.setText("  x " + numitem.get(position));
        String str = itemIdShop.get(position);
        int a = Integer.parseInt(str);
        if (a == 1 || a == 3)
            holder.txtname.setText(itemNameShop.get(position) + "[成虫／幼虫兼用]");
        else if (a == 1001 || a == 1003 || a == 1013 || a == 1014 || a == 3001 || a == 3002 || a == 3004 || a == 3005 || a == 3006 || a == 3007)
            holder.txtname.setText(itemNameShop.get(position) + "[幼虫用]");
        else if (a == 3003)
            holder.txtname.setText(itemNameShop.get(position) + "[ブリーダー用]");
        else if (a == 1011 || a == 1012 || a == 1015 || a == 1016)
            holder.txtname.setText(itemNameShop.get(position) + "[成虫用]");
        if (a < 100000) {
            setImageForItem(a, holder.imgsell);
        } else if (a >= 100000) {
            String name = "";
            String part = "";
            if (str.substring(0, 3).equals("100"))
                name = "kabutomushi";
            else if (str.substring(0, 3).equals("101"))
                name = "caucasus";
            else if (str.substring(0, 3).equals("102"))
                name = "satanas";
            else if (str.substring(0, 3).equals("103"))
                name = "hercules";
            else if (str.substring(0, 3).equals("110"))
                name = "kokuwagata";
            else if (str.substring(0, 3).equals("111"))
                name = "oukuwagata";
            else if (str.substring(0, 3).equals("112"))
                name = "giraffa";
            else if (str.substring(0, 3).equals("113"))
                name = "golden";
            if (str.substring(3, 4).equals("0"))
                part = "horn";
            else if (str.substring(3, 4).equals("1"))
                part = "horn2";
            else if (str.substring(3, 4).equals("2"))
                part = "head";
            else if (str.substring(3, 4).equals("3"))
                part = "face";
            else if (str.substring(3, 4).equals("4"))
                part = "neck";
            else if (str.substring(3, 4).equals("5"))
                part = "body";
            else if (str.substring(3, 4).equals("6"))
                part = "wing";
            String pos = str.substring(4, 6);
            String pImg = "" + name + part + pos;
            int resID = context.getResources().getIdentifier("@drawable/" + pImg, "drawable", context.getPackageName());
            holder.imgsellHead.setImageResource(resID);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(80, 80);
            params.gravity = Gravity.CENTER | Gravity.LEFT;
            holder.imgsellHead.setScaleX(2.5f);
            holder.imgsellHead.setScaleY(2.5f);
            if (part.equals("horn")) {
                if (mypage._Width < 720) {
                    params.setMargins(4, 20, 0, 0);
                    holder.imgsellHead.setScaleX(2f);
                    holder.imgsellHead.setScaleY(2f);
                } else
                    params.setMargins(5, 35, 0, 0);
                holder.imgsellHead.setLayoutParams(params);

            } else if (part.equals("horn2")) {
                if (mypage._Width < 720) {
                    params.setMargins(4, 20, 0, 0);
                    holder.imgsellHead.setScaleX(2f);
                    holder.imgsellHead.setScaleY(2f);
                } else
                    params.setMargins(5, 40, 0, 0);
                holder.imgsellHead.setLayoutParams(params);
            } else if (part.equals("head")) {
                params.setMargins(5, 15, 0, 0);
                holder.imgsellHead.setLayoutParams(params);
            } else if (part.equals("face")) {
                params.setMargins(5, 5, 0, 0);
                holder.imgsellHead.setLayoutParams(params);
            } else if (part.equals("neck")) {
                params.setMargins(5, 0, 0, 5);
                holder.imgsellHead.setLayoutParams(params);
            } else if (part.equals("body")) {
                if (mypage._Width < 720) {
                    params.setMargins(4, 0, 0, 20);
                    holder.imgsellHead.setScaleX(2f);
                    holder.imgsellHead.setScaleY(2f);
                } else
                    params.setMargins(5, 0, 0, 45);
                holder.imgsellHead.setLayoutParams(params);
            } else if (part.equals("wing")) {
                if (mypage._Width < 720)
                    params.setMargins(15, 0, 0, 20);
                else
                    params.setMargins(20, 0, 0, 40);
                holder.imgsellHead.setLayoutParams(params);
                holder.imgsellHead.setScaleX(2f);
                holder.imgsellHead.setScaleY(2f);
            }
        }
        return convertView;
    }

    public class ViewHolder {
        public ImageView imgsell, imgsellHead;
        public TextView txtname, txtjewel, num, txtcoin;
        LinearLayout lnstar;
    }

    public void setImageForItem(int a, ImageView imggetitem) {
        if (a == 1013)
            imggetitem.setImageResource(R.drawable.itm_rice3);
        else if (a == 1014)
            imggetitem.setImageResource(R.drawable.itm_rice2);
        else if (a == 1001)
            imggetitem.setImageResource(R.drawable.food_icon);
        else if (a == 1011)
            imggetitem.setImageResource(R.drawable.itm_jelly1);
        else if (a == 1)
            imggetitem.setImageResource(R.drawable.drink_icon);
        else if (a == 3001)
            imggetitem.setImageResource(R.drawable.item_icon);
        else if (a == 1012)
            imggetitem.setImageResource(R.drawable.itm_jelly2);
        else if (a == 1003)
            imggetitem.setImageResource(R.drawable.itm_rice4);
        else if (a == 3)
            imggetitem.setImageResource(R.drawable.new_shop_icon_drink2);
        else if (a == 3002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_item2);
        else if (a == 3003)
            imggetitem.setImageResource(R.drawable.itm_liquor);
        else if (a == 3004)
            imggetitem.setImageResource(R.drawable.itm_runpa1);
        else if (a == 2001)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2002)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2003)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2004)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2005)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2006)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2007)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2008)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2009)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2010)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2011)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2012)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2013)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2014)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2015)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 2016)
            imggetitem.setImageResource(R.drawable.new_shop_icon_egg);
        else if (a == 1015)
            imggetitem.setImageResource(R.drawable.itm_sap);
        else if (a == 1016)
            imggetitem.setImageResource(R.drawable.itm_banana);
        else if (a == 3005)
            imggetitem.setImageResource(R.drawable.itm_medicine1);
        else if (a == 3006)
            imggetitem.setImageResource(R.drawable.itm_medicine2);
        else if (a == 3007)
            imggetitem.setImageResource(R.drawable.itm_o2_capsule);
        else if (a == 3008)
            imggetitem.setImageResource(R.drawable.itm_gold_ticket);
    }

}