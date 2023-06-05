package com.example.fbs_android.dto;

import com.example.fbs_android.model.Data;
import com.example.fbs_android.model.Fbs;
import com.example.fbs_android.model.Viagem;
import com.example.fbs_android.model.view.ViagemList;
import com.example.fbs_android.model.view.ViagemListItem;

import java.util.ArrayList;

public class Mapper {
    public static Fbs fbsDto2Fbs(FbsDto arg){
        Fbs obj = new Fbs(arg.getNome());
        return obj;
    }
    public static ViagemListItem viagemListItemDto2ViagemListItem(ViagemListItemDto arg){
        Data dP= dataDto2Data(arg.getDataP());
        Data dC = dataDto2Data(arg.getDataC());
        ViagemListItem  obj = new ViagemListItem(arg.getNome(),dP,dC);
        return obj;
    }
    public static ViagemList viagemListDto2ViagemList(ViagemListDto arg){
        ArrayList<ViagemListItem> list = new ArrayList<>();
        for(ViagemListItemDto v : arg.getViagens()){
            ViagemListItem item = viagemListItemDto2ViagemListItem(v);
            list.add(item);
        }
        ViagemList  obj = new ViagemList(list);
        return obj;
    }
    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }
}
