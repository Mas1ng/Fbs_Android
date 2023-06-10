package com.example.fbs_android.dto;


import com.example.fbs_android.model.TipoBilhete;
import com.example.fbs_android.model.TipoPassageiro;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"numLugar", "nomeViagem"})
@Root(name = "bilhete")
public class BilheteItemDto {

    @Element(name="numLugar")
    private int numLugar;
    @Element(name="nomeViagem")
    private String nomeViagem;

    public BilheteItemDto() {
    }

    public BilheteItemDto(int numLugar, String nomeViagem) {
        this.numLugar = numLugar;
        this.nomeViagem = nomeViagem;
    }
    public String getNomeViagem() {
        return nomeViagem;
    }

    public int getNumLugar() {
        return numLugar;
    }
}
