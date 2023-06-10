package com.example.fbs_android.dto;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"numLugar","nomeViagem"})
@Root(name = "detalhes")
public class NumLugarNomeViagemDto {
    @Element(name="numLugar")
    private int nLugar;
    @Element(name="nomeViagem")
    private String nomeViagem;

    public NumLugarNomeViagemDto(int nLugar, String nomeViagem) {
        this.nLugar = nLugar;
        this.nomeViagem = nomeViagem;
    }

    public NumLugarNomeViagemDto() {
    }

    public int getnLugar() {
        return nLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }
}
