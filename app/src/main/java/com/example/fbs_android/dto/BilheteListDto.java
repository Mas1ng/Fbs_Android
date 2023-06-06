package com.example.fbs_android.dto;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="bilhetes")
public class BilheteListDto {

    @ElementList(inline = true,required = false)
    private ArrayList<BilheteDto> bilhetes;

    public BilheteListDto() {
    }

    public BilheteListDto(ArrayList<BilheteDto> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<BilheteDto> getBilhetes() {
        return bilhetes;
    }
}
