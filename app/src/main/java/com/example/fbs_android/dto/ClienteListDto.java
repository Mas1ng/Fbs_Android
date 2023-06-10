package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="clientes")
public class ClienteListDto {
    @Element(name="cliente")
    private ArrayList<ClienteDto> clientes;

    public ClienteListDto() {
    }
    public ClienteListDto(ArrayList<ClienteDto> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<ClienteDto> getClientes() {
        return clientes;
    }
}
