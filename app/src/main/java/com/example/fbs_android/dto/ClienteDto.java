package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"email","nome","data","cc"})
@Root(name ="cliente")
public class ClienteDto {

    @Element(name = "bilhete")
    private BilheteListDto bilheteList;

    @Element(name = "email")
    private String email;

    @Element(name = "nome")
    private String nome;
    @Element(name = "data")
    private DataDto data;
    @Element(name = "cc")
    private long cc;

        public ClienteDto(String email, String nome, DataDto data, long cc) {
            this.email = email;
            this.nome = nome;
            this.data = data;
            this.cc=cc;

        }

        public ClienteDto() {
        }

        public String getEmail() {
            return email;
        }

        public String getNome() {
            return nome;
        }

        public DataDto getData() {
            return data;
        }

        public long getCc() {
            return cc;
        }
    }

