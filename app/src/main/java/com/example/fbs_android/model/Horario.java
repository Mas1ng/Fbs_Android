package com.example.fbs_android.model;

import java.io.Serializable;

public class Horario implements Serializable {
    private int hora;
    private int minuto;

    public int getHora() {
        return hora;
    }

    public void setHoraMinuto(int hora,int minuto) {
        if(eValidaHora(hora,minuto)) {
            this.hora = hora;
            this.minuto=minuto;
        }else {
            String msg ="Horario invalido";
            throw new RuntimeException(msg);
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public Horario(int hora, int minuto) {
        setHoraMinuto(hora,minuto);
    }

    public void getHorario(int [] hm) {
        hm[0] = this.hora;
        hm[1] = this.minuto;
    };


    public static boolean eValidaHora(int hora, int minuto) {
        if(hora>=0  && hora <=24) {
            if(minuto>=0  && minuto <=60) {
                return true;
            } else return false;
        } else return false;
    }

    public boolean isGreaterThan (Horario obj) {
        if(this.hora > obj.hora){
            return true;
        }
        if(this.minuto > obj.minuto){
            return true;
        }
        return false;
    }
}
