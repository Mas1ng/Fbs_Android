package com.example.fbs_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.fbs_android.R;
import com.example.fbs_android.model.Bilhete;
import com.example.fbs_android.model.Viagem;

import java.util.ArrayList;

public class LvAdapterBilhetes extends BaseAdapter {
    private Context context;
    private int layoutId;
    private final ArrayList<Bilhete> items;

    public LvAdapterBilhetes(Context context, int layoutId, ArrayList<Bilhete> items) {
        this.context = context;
        this.layoutId = layoutId;
        this.items = items;
    }
    public void setItems(ArrayList<Bilhete> items){
        this.items.clear();
        this.items.addAll(items);
    }
    @Override
    public int getCount() {
        return 0;
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
        final Bilhete row = this.items.get(position);
        View itemView = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(layoutId, null);
        }else {
            itemView =convertView;
        }

        TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvName.setText(row.getNomeViagem());
        TextView cc = (TextView)  itemView.findViewById(R.id.CC);
        cc.setText(row.getCc().toString()); // não sei se isto vai funcionar
        return itemView;
    }
}
