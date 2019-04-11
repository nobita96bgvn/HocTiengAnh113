package com.nvh.hoannguyen.hoctienganh.Lop1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nvh.hoannguyen.hoctienganh.R;

import java.util.List;



public class BaihocAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Baihoctuvung> baihoctuvungList;

    public BaihocAdapter(Context context, int layout, List<Baihoctuvung> baihoctuvungList) {
        this.context = context;
        this.layout = layout;
        this.baihoctuvungList = baihoctuvungList;
    }

    @Override
    public int getCount() {
        return baihoctuvungList.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView txtten = (TextView) convertView.findViewById(R.id.textviewTen);
        TextView txtmota = (TextView) convertView.findViewById(R.id.textviewmota);
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);
        Baihoctuvung bh = baihoctuvungList.get(position);
        txtten.setText(bh.getTen());
        txtmota.setText(bh.getMota());
        imgHinh.setImageResource(bh.getHinh());
        return convertView;
    }
}
