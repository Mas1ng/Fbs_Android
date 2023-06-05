package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements ={"dia","mes","ano"})
@Root(name = "data")
public class DataDto {
    @Element(name="dia")
    private int dia;
    @Element(name="mes")
    private int mes;
    @Element(name="ano")
    private int ano;

    public DataDto(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public DataDto() {
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
}
