package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"nome", "dataP", "dataC"}) // não sei se são estes os nomes certos
@Root(name = "viagem")
public class ViagemListItemDto {
    @Element(name = "nome")
    private String nome;
    @Element(name = "dataP")
    private DataDto dataP;
    @Element(name = "dataC")
    private DataDto dataC;

    public ViagemListItemDto() {
    }

    public ViagemListItemDto(String nome, DataDto dataP, DataDto dataC) {
        this.nome = nome;
        this.dataP = dataP;
        this.dataC = dataC;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DataDto getDataP() {
        return dataP;
    }

    public void setDataP(DataDto dataP) {
        this.dataP = dataP;
    }

    public DataDto getDataC() {
        return dataC;
    }

    public void setDataC(DataDto dataC) {
        this.dataC = dataC;
    }
}
