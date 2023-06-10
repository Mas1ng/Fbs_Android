package com.example.fbs_android.model;

public class NumLugarNomeViagem {
    private int numlugar;
    private String nomeViagem;

    public NumLugarNomeViagem(int numlugar, String nomeViagem) {
        this.numlugar = numlugar;
        this.nomeViagem = nomeViagem;
    }

    public int getNumlugar() {
        return numlugar;
    }

    public void setNumlugar(int numlugar) {
        this.numlugar = numlugar;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }
}
