package com.example.fbs_android.dto;


import com.example.fbs_android.model.TipoBilhete;
import com.example.fbs_android.model.TipoPassageiro;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"numLugar", "nomeViagem", "extras", "tipoPassageiro", "tipoBilhete", "cc", "preco"})
@Root(name = "bilhete")
public class BilheteNumLugarDto {

    @Element(name="numLugar")
    private int numLugar;
    @Element(name="nomeViagem")
    private String nomeViagem;
    @Element(name="extras")
    private ExtrasDto extras;
    @Element(name="tipoPassageiro")
    private TipoPassageiro tipoPassageiro;
    @Element(name="tipoBilhete")
    private TipoBilhete tipoBilhete;
    @Element(name="cc")
    private String cc;
    @Element(name="preco")
    private int preco;


    public BilheteNumLugarDto() {
    }

    public BilheteNumLugarDto(int numLugar, String nomeViagem, ExtrasDto extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc, int preco) {
        this.numLugar=numLugar;
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
        this.cc=cc;
        this.preco=preco;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public ExtrasDto getExtrasDto() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public TipoBilhete getTipoBilhete() {
        return tipoBilhete;
    }

    public String getCc() {
        return cc;
    }

    public int getPreco() {
        return preco;
    }
}
