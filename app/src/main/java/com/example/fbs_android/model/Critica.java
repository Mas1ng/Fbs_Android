package com.example.fbs_android.model;

import java.io.Serializable;

public class Critica implements Serializable {
    private String emailCliente;
    private Data datacritica;
    private String avaliação;
    private String textocritica;
    private String assunto;
    private String nomeViagem;

    public Critica(String emailCliente, Data datacritica, String avaliação, String textocritica, String assunto, String nomeViagem) {
        this.emailCliente = emailCliente;
        this.datacritica = datacritica;
        this.avaliação = avaliação;
        this.textocritica = textocritica;
        this.assunto = assunto;
        this.nomeViagem = nomeViagem;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Data getDatacritica() {
        return datacritica;
    }

    public void setDatacritica(Data datacritica) {
        this.datacritica = datacritica;
    }

    public String getAvaliação() {
        return avaliação;
    }

    public void setAvaliação(String avaliação) {
        this.avaliação = avaliação;
    }

    public String getTextocritica() {
        return textocritica;
    }

    public void setTextocritica(String textocritica) {
        this.textocritica = textocritica;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getViagem() {
        return nomeViagem;
    }

    public void setViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }
}
