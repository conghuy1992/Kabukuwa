package com.daydelight.kabukuwa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daydelight.kabukuwa.R;

/**
 * Created by goood on 5/15/15.
 */
public class AdapterMenu2 extends BaseAdapter {
    Context context;
    String Str[];

    public AdapterMenu2(Context context, String Str[]) {
        this.context = context;
        this.Str = Str;
    }

    @Override
    public int getCount() {
        return Str.length;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.adapter_menu2, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView8);
        textView.setText(Str[position]);
        return convertView;
    }
}
