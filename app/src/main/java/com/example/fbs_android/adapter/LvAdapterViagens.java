package com.example.fbs_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.fbs_android.R;
import com.example.fbs_android.model.Viagem;

import java.util.ArrayList;

public class LvAdapterViagens extends BaseAdapter {
    private Context context;
    private int layoutId;
    private final ArrayList<Viagem> items;

    public LvAdapterViagens(Context context, int layoutId, ArrayList<Viagem> items) {
        this.context = context;
        this.layoutId = layoutId;
        this.items = items;
    }
    public void setItems(ArrayList<Viagem> items){
        this.items.clear();
        this.items.addAll(items);
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final Viagem row = this.items.get(position);
        View itemView = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(layoutId, null);
        }else {
            itemView =convertView;
        }

        TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvName.setText(row.getNomeViagem());
        TextView tvdataP = (TextView)  itemView.findViewById(R.id.dataP);
        tvdataP.setText(row.getDataChegada().toString()); // não sei se isto vai funcionar
        TextView tvdataC = (TextView) itemView.findViewById(R.id.dataC);
        tvdataC.setText(row.getDataChegada().toString());
        return itemView;
    }
}
