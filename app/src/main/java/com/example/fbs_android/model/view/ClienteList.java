package com.example.fbs_android.model.view;

import com.example.fbs_android.model.Cliente;

import java.util.ArrayList;

public class ClienteList {
    private ArrayList<Cliente> clientes;

    public ClienteList() {
        clientes = new ArrayList<Cliente>();
    }

    public ClienteList(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public Cliente getClienteByEmail(String email){
        for (int i =0;i<clientes.size();i++) {
            Cliente cliente = clientes.get(i);
            if(cliente.getEmail().equals(email)){
                return cliente;
            }
        }return null;
    }
}
