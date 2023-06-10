package com.example.fbs_android.model.view;

import com.example.fbs_android.model.Viagem;

import java.util.ArrayList;

public class ViagemList {
    private ArrayList<Viagem> viagens;

    public ViagemList(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }
}
