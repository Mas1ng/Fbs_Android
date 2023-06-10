package com.example.fbs_android.model;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.fbs_android.model.Mala.*;
import static com.example.fbs_android.model.TipoBilhete.*;
import static com.example.fbs_android.model.TipoPassageiro.*;


public class BilheteList implements Serializable {
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public BilheteList() {
        bilhetes = new ArrayList<Bilhete>();
    }
    public BilheteList(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }
}
