package com.example.fbs_android.model.view;

import com.example.fbs_android.model.Data;

public class ViagemListItem {
    private String name;
    private Data dataPartida;
    private Data dataChegada;

    public ViagemListItem(String name, Data dataPartida, Data dataChegada) {
        this.name = name;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
    }

    public ViagemListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Data dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Data getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Data dataChegada) {
        this.dataChegada = dataChegada;
    }
}
