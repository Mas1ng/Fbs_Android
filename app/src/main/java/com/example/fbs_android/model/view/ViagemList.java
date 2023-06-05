package com.example.fbs_android.model.view;

import java.util.ArrayList;

public class ViagemList {
    private ArrayList<ViagemListItem> viagens;

    public ViagemList(ArrayList<ViagemListItem> viagens) {
        this.viagens = viagens;
    }

    public ArrayList<ViagemListItem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<ViagemListItem> viagens) {
        this.viagens = viagens;
    }
}
