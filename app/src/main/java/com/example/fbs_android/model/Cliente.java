package com.example.fbs_android.model;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private BilheteList bilheteList;
    private String nome;
    private Data data;
    private String email;
    private String pass;
    private long cc;

    @Override
    public long getCc() {
        return cc;
    }

    public Cliente(String email, String nome, Data data, long cc, String pass, BilheteList bilheteList) {
        super(email, nome, data,cc,pass);
        this.bilheteList = bilheteList;
    }
    public Cliente(String email, String nome, Data data, long cc, String pass) {
        super(email, nome, data,cc,pass);
        bilheteList = new BilheteList();
    }

    public BilheteList getBilhetes(){
        return bilheteList;
    }

    public void setBilhetes(BilheteList bilheteList) {
        this.bilheteList = bilheteList;
    }

}
