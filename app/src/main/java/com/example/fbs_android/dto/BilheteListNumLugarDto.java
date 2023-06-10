package com.example.fbs_android.dto;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;


@Root(name="bilhetes")
public class BilheteListNumLugarDto {
    @ElementList(inline = true,required = false)
    @Element(name = "bilhete")
    private ArrayList<BilheteNumLugarDto> bilhetes;

    public BilheteListNumLugarDto(ArrayList<BilheteNumLugarDto> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<BilheteNumLugarDto> getBilhetes() {
        return bilhetes;
    }
}
