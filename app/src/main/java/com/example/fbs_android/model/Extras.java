package com.example.fbs_android.model;

import java.io.Serializable;

public class Extras implements Serializable {
    boolean seguro;
    boolean comida;
    Mala mala;

    public Extras(boolean seguro, boolean comida, Mala mala) {
        this.seguro = seguro;
        this.comida = comida;
        this.mala = mala;
    }

    public Extras() {
    }

    public void getextra(String [] args)
    {
        args[0] = String.valueOf(this.seguro);
        args[1] = String.valueOf(this.comida);
        args[2] = String.valueOf(this.mala);
    }

    public boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean getComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public Mala getMala() {
        return mala;
    }

    public void setMala(Mala mala) {
        this.mala = mala;
    }
}
