package com.daydelight.kabukuwa;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydelight.kabukuwa.R;

/**
 * Created by goood on 5/14/15.
 */
public class AdapterDesLevel extends BaseAdapter {
    Context context;
    Integer integer[];
    String string[];

    public AdapterDesLevel(Context context, String s[], Integer integer[]) {
        this.context = context;
        this.string = s;
        this.integer = integer;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.adapter_deslevel, null);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgzukan);
        img.setImageResource(integer[position]);
        img.setAlpha(0.7f);
        if (position == 8 || position == 9 || position == 10 || position == 11) {
            img.setImageAlpha(0);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.txtzukan);
        textView.setText(string[position]);
        return convertView;
    }
}
