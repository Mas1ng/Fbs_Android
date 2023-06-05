package com.example.fbs_android.model;

import java.io.Serializable;

public class Admin extends Pessoa implements Serializable {

    public Admin(String email, String nome, Data data, long cc, String pass) {
        super(email, nome, data, cc,pass);
    }
    public Admin() {
        super();
    }
}
