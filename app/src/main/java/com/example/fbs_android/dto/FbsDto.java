package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "fbs")
public class FbsDto {
    @Element(name = "nome")
    private String nome;

    public FbsDto() {
    }

    public FbsDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
