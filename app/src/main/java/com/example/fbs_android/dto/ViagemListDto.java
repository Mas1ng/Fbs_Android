package com.example.fbs_android.dto;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "viagens")
public class ViagemListDto {
    @ElementList(inline = true, required=false)
    private ArrayList<ViagemListItemDto> viagens;

    public ViagemListDto() {
    }

    public ViagemListDto(ArrayList<ViagemListItemDto> students) {
        this.viagens = students;
    }

    public ArrayList<ViagemListItemDto> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<ViagemListItemDto> viagens) {
        this.viagens = viagens;
    }
}
