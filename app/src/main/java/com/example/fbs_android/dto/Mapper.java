package com.example.fbs_android.dto;

import com.example.fbs_android.model.*;
import com.example.fbs_android.model.view.ClienteList;
import com.example.fbs_android.model.view.ViagemList;
import com.example.fbs_android.model.view.ViagemListItem;

import java.util.ArrayList;

public class Mapper {
    public static Fbs fbsDto2Fbs(FbsDto arg){
        Fbs obj = new Fbs(arg.getNome());
        return obj;
    }
    public static Viagem viagemDto2Viagem(ViagemDto arg){
        Data dP= dataDto2Data(arg.getDataPartida());
        Data dC = dataDto2Data(arg.getDataChegada());
        Viagem  obj = new Viagem(arg.getNomeViagem(),dP,dC);
        return obj;
    }
    public static ViagemList viagemListDto2ViagemList(ViagemListDto arg){
        ArrayList<Viagem> list = new ArrayList<>();
        for(ViagemDto v : arg.getViagens()){
            Viagem item = viagemDto2Viagem(v);
            list.add(item);
        }
        ViagemList  obj = new ViagemList(list);
        return obj;
    }
    public static Data dataDto2Data(DataDto arg){
        Data  obj = new Data(arg.getDia(),arg.getMes(),arg.getAno());
        return obj;
    }

    public static DataDto data2DataDto(Data arg){
        if (arg == null) {
            return null;
        }
        int [] dmy = {0,0,0};
        arg.getDate(dmy);
        DataDto  obj = new DataDto(dmy[0],dmy[1],dmy[2]);
        return obj;
    }
    public static ClienteDto cliente2ClienteDto(Cliente args){
        DataDto data = data2DataDto(args.getData());
        ClienteDto obj = new ClienteDto(args.getEmail(), args.getNome(), data, args.getCc(), args.getPass());
        return obj;
    }
    public static ClienteList clienteListDto2ClienteList(ClienteListDto arg) {
            ArrayList<Cliente> list = new ArrayList<>();
            for(ClienteDto c : arg.getClientes())
            {
                Cliente item = clienteDto2Cliente(c);
                list.add(item);
            }
            ClienteList obj = new ClienteList(list);
            return obj;
    }
    public static Cliente clienteDto2Cliente(ClienteDto arg){
        Data date = dataDto2Data(arg.getData());
        //Email email = emailDto2Email(arg.getEmail());
        Cliente  obj = new Cliente(arg.getEmail(),arg.getNome(),date,arg.getCc(),arg.getPass());
        return obj;
    }
    public static Bilhete bilheteNumLugarDto2Bilhete(BilheteNumLugarDto arg){
        Extras extras = extrasDto2Extra(arg.getExtrasDto());
        Bilhete obj = new Bilhete(arg.getPreco(), arg.getNumLugar(), arg.getNomeViagem(), extras, arg.getTipoPassageiro(), arg.getTipoBilhete(), arg.getCc());
        return obj;
    }

    public static BilheteList bilheteItemListDto2BilheteList(BilheteItemListDto arg){
        ArrayList<Bilhete> list = new ArrayList<>();
        for(BilheteItemDto b : arg.getBilhetes()){
            Bilhete item = bilheteItemDto2bilhete(b);
            list.add(item);
        }
        BilheteList  obj = new BilheteList(list);
        return obj;
    }
    public static Bilhete bilheteNumLugarDto2bilhete(BilheteNumLugarDto args){
        Extras extras = extrasDto2Extra(args.getExtrasDto());
        Bilhete obj = new Bilhete(args.getPreco(), args.getNumLugar(), args.getNomeViagem(), extras, args.getTipoPassageiro(),args.getTipoBilhete(), args.getCc());
        return obj;
    }
    public static Bilhete bilheteItemDto2bilhete(BilheteItemDto args){
        Bilhete obj = new Bilhete( args.getNumLugar(), args.getNomeViagem());
        return obj;
    }
    public static Extras extrasDto2Extra (ExtrasDto arg)
    {
        Extras obj = new Extras(arg.isComida(), arg.isSeguro(), arg.getMala());
        return obj;
    }
    public static NumLugarNomeViagemDto numLugarNomeviagem2NumLugarNomeViagemDto(NumLugarNomeViagem n)
    {
        NumLugarNomeViagemDto obj = new NumLugarNomeViagemDto(n.getNumlugar(), n.getNomeViagem());
        return obj;
    }
}
