package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.fbs_android.R;
import com.example.fbs_android.model.view.ViagemListItem;

import java.util.ArrayList;

public class LvAdapterViagens extends BaseAdapter {
    private Context context;
    private int layoutId;
    private final ArrayList<ViagemListItem> items;

    public LvAdapterViagens(Context context, int layoutId, ArrayList<ViagemListItem> items) {
        this.context = context;
        this.layoutId = layoutId;
        this.items = items;
    }
    public void setItems(ArrayList<ViagemListItem> items){
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
        final ViagemListItem row = this.items.get(position);
        View itemView = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(layoutId, null);
        }else {
            itemView =convertView;
        }

        TextView tvName = (TextView) itemView.findViewById(R.id.crudViagens);
        tvName.setText(row.getName());
        TextView tvdataP = (TextView)  itemView.findViewById(R.id.tvdataP);
        tvdataP.setText(row.getDataChegada().toString()); // não sei se isto vai funcionar
        TextView tvdataC = (TextView) itemView.findViewById(R.id.crudViagens);
        tvdataC.setText(row.getDataChegada().toString());
        return itemView;
    }
}
