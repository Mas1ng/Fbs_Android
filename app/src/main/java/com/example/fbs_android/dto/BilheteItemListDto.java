package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="bilhetes")
public class BilheteItemListDto {
    @ElementList(inline = true,required = false)
    @Element(name = "bilhete")
    private ArrayList<BilheteItemDto> bilhetes;

    public BilheteItemListDto() {
    }

    public BilheteItemListDto(ArrayList<BilheteItemDto> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<BilheteItemDto> getBilhetes() {
        return bilhetes;
    }
}
