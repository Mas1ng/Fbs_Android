package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"email","nome","data","cc","pass"})
@Root(name ="cliente")
public class ClienteDto {

    //@ElementList(inline = true,required = false)
    //@Element(name = "bilhete")
    //private BilheteListDto bilheteList;

    @Element(name = "email")
    private String email;

    @Element(name = "nome")
    private String nome;
    @Element(name = "data")
    private DataDto data;
    @Element(name = "cc")
    private long cc;
    @Element(name = "pass")
    private String pass;

        public ClienteDto(String email, String nome, DataDto data, long cc, String pass) {
            this.email = email;
            this.nome = nome;
            this.data = data;
            this.cc=cc;
            this.pass=pass;

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

        public String getPass() { return pass;}
}

