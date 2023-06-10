package com.example.fbs_android.dto;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "viagens")
public class ViagemListDto {
    @ElementList(inline = true, required=false)
    private ArrayList<ViagemDto> viagens;

    public ViagemListDto() {
    }

    public ViagemListDto(ArrayList<ViagemDto> students) {
        this.viagens = students;
    }

    public ArrayList<ViagemDto> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<ViagemDto> viagens) {
        this.viagens = viagens;
    }
}
