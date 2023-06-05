package com.example.fbs_android.model;



import com.example.fbs_android.exceptions.InvalidDataException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa implements Serializable {
    private String nome;
    private Data data;
    private String email;
    private String pass;
    private long cc;
    private boolean isNameValid(String name){
        if(name.length() < 3){
            return false;
        }
        return true;
    }

    private boolean isCcValid(long cc){
        if(cc < 100000000 || cc > 999999999){
            return false;
        }
        return true;
    }
    public Pessoa(String email, String nome, Data data, long cc, String pass){
        setEmail(email);
        setNome(nome);
        setData(data);
        setCc(cc);
        setPass(pass);
    }

    public Pessoa(String nome, Data data, long cc){
        setNome(nome);
        setData(data);
        setCc(cc);
    }

    public Pessoa(){
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        if(isNameValid(nome)){
            this.nome = nome;
        }else{
            String msg = "Person: " + nome;
            throw new InvalidDataException(msg);
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            String msg = "Email invalido";
            throw new InvalidDataException(msg);
        }
    }

    public void setPass(String pass) {
        if(validatePss(pass)) {
            this.pass = pass;
        } else {
            String msg = "pass invalida";
            throw new InvalidDataException(msg);
        }
    }

    public boolean validateEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }

    public boolean validatePss(String pass) {
        int upC =0;
        int lowC =0;
        int special =0;
        int dig = 0;
        char ch;

        if(pass.length()<8)
        {
            String msg = "Palavra passe deve ter pelo menos 8 carateres";
            throw new InvalidDataException(msg);
        }
        else
        {
            for(int i=0; i<pass.length(); i++)
            {
                ch = pass.charAt(i);
                if(Character.isUpperCase(ch))
                    upC = 1;
                else if(Character.isLowerCase(ch))
                    lowC = 1;
                else if(Character.isDigit(ch))
                    dig = 1;
                else
                    special = 1;
            }
        }
        if(upC==1 && lowC==1 && dig==1 && special==1) {
            //System.out.println("\nThe Password is Strong.");
            return true;
        }
        else {
            String m = "A pass é fraca";
            throw new InvalidDataException(m);
        }
    }


    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        if(isCcValid(cc)) {
            this.cc=cc;
        }
        else {
            String msg = "Numero cc invalido";
            throw new InvalidDataException(msg);
        }
    }

    public String getPass() {
        return pass;
    }
}
