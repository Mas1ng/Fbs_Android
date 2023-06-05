package com.example.fbs_android.model;

import com.example.fbs_android.exceptions.InvalidDataException;

import java.io.Serializable;

public class Data implements Serializable {
    private int dia;
    private int mes; // 1- january, ... 12- December
    private int ano;
    private boolean isLeapYear(int year){
        // If a year is multiple of 400,
        // then it is a leap year
        if (year % 400 == 0)
            return true;
        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;
        // Else If a year is multiple of 4,
        // then it is a leap year
        if (year % 4 == 0)
            return true;
        return false;

    }
    private boolean isValid(int day, int month, int year){
        boolean result = true;
        if(day <= 0 || day > 31 || month <= 0 || month > 12){
            result = false;
        }else{
            switch(month){
                case 2:
                    if(isLeapYear(year) == true){
                        if(day > 29){
                            result = false;
                        }
                    }else{
                        if(day > 28){
                            result = false;
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day > 30){
                        result = false;
                    }
                    break;
            }
        }
        return result;
    }
    public Data(){
        //default date
        setDate(1,1, 1900);
    }
    public Data(int dia, int mes, int ano){
        setDate(dia, mes, ano);
    }

    public void setDate(int day, int month, int year){
        if(isValid(day, month, year)){
            this.dia = day;
            this.mes = month;
            this.ano = year;
        }
        else{
            String msg = day + "/" + month +"/"+ year;
            throw new InvalidDataException(msg);
        }
    }
    public void getDate(int [] dmy) {
        dmy[0] = this.dia;
        dmy[1] = this.mes;
        dmy[2] = this.ano;
    };

    public boolean isEqualTo(Data obj) {
        if(this.dia == obj.dia && this.mes == obj.mes && this.ano == obj.ano){
            return true;
        }
        return false;
    }
    public boolean isGreaterThan (Data obj) {
        if(this.ano > obj.ano){
            return true;
        }
        if(this.mes > obj.mes){
            return true;
        }
        if(this.dia == obj.dia){
            return true;
        }
        return false;
    }

    public boolean isSmallerThan (Data obj){
        if(this.isEqualTo(obj)){
            return false;
        }
        if(this.isGreaterThan(obj)){
            return false;
        }
        return true;
    }



}
