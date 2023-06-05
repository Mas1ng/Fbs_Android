package com.example.fbs_android.model;

import java.io.Serializable;

public class Bilhete implements Serializable {
    int Preco;
    int numLugar;
    String nomeViagem;
    Extras extras;
    TipoPassageiro tipoPassageiro;
    TipoBilhete tipoBilhete;
    String cc;


    public Bilhete(int numLugar, String nomeViagem, Extras extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc) {
         this.numLugar = numLugar;
         this.nomeViagem= nomeViagem;
         this.extras = extras;
         this.tipoPassageiro = tipoPassageiro;
         this.tipoBilhete = tipoBilhete;
         this.cc = cc;
    }

    public Bilhete(int numLugar, String nomeViagem, TipoBilhete tipoBilhete) {
        this.numLugar = numLugar;
        this.nomeViagem = nomeViagem;
        this.tipoBilhete = tipoBilhete;
        this.extras = new Extras();
    }

    public Bilhete(String nomeViagem, Extras extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc) {
        this.nomeViagem= nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
        this.cc = cc;
    }

    public Bilhete() {
        this.extras = new Extras();
    }
    public int getNumLugar() {
        return numLugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public Extras getExtras() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public void setNumLugar(int numLugar) {
        this.numLugar = numLugar;
    }

    public void setViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public void setTipoPassageiro(TipoPassageiro tipoPassageiro) {
        this.tipoPassageiro = tipoPassageiro;
    }

    public TipoBilhete getTipoBilhete() {
        return tipoBilhete;
    }
    public void setTipoBilhete(TipoBilhete tipoBilhete) {
        this.tipoBilhete = tipoBilhete;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getPreco() {
        return Preco;
    }

    public void setPreco(int preco) {
        Preco = preco;
    }
}
