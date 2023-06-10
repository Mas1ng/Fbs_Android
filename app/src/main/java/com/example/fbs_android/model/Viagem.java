package com.example.fbs_android.model;

import java.io.Serializable;
import java.util.Arrays;



public class Viagem implements Serializable {
    private static int counter=0;
    private int counterNum;
    private String nomeViagem;
    BilheteList bilhetesParaVender;
    BilheteList bilhetesVendidos;
    Companhia companhia;
    int lugaresTotais;
    String cidadeFinal;
    String cidadeInicial;

    Data dataPartida;
    Data dataChegada;

    Horario horaPartida;

    Horario horaChegada;

    int lugaresEconomicos;
    int lugaresExecutivos;
    int lugaresPrimeiraClasse;

    private String[] cidades_possiveis = new String [] {"Portugal","Vienna", "Salzburg", "Baku", "Ganja", "Minsk", "Gomel", "Brussels", "Antwerp", "Sarajevo", "Banja Luka", "Sofia", "Varna", "Zagreb", "Split", "Nicosia", "Larnaca", "Prague", "Brno", "Copenhagen", "Billund", "Tallinn", "Tartu", "Helsinki", "Turku", "Bordeaux", "Nice", "Berlin", "Munich", "Athens", "Thessaloniki", "Budapest", "Debrecen", "Reykjavik", "Keflavik", "Dublin", "Cork", "Rome", "Milan", "Pristina", "Përnambuc", "Riga", "Liepāja", "Vilnius", "Kaunas", "Luxembourg City", "Esch-sur-Alzette", "Valletta", "Gozo", "Chisinau", "Bălți", "Monaco", "Monte Carlo", "Podgorica", "Tivat", "Amsterdam", "Rotterdam", "Oslo", "Bergen", "Kraków", "Warsaw", "Lisboa", "Porto", "Bucharest", "Cluj-Napoca", "Moscow", "St. Petersburg", "Belgrade", "Niš", "Bratislava", "Košice", "Ljubljana", "Maribor", "Madrid", "Barcelona", "Stockholm", "Gothenburg", "Bern", "Zurich", "Istanbul", "Ankara", "Kyiv", "Lviv", "Liverpool", "Manchester", "London", "Manchester", "Zagreb", "Split", "Paris", "Nice", "Athens", "Thessaloniki"};

    public String getNomeViagem() {
        return nomeViagem;
    }
    public int getLugaresTotais() {
        return lugaresTotais;
    }
    public void setLugaresTotais(int lugaresTotais) {
        this.lugaresTotais = lugaresTotais;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public void setCidadeFinal(String cidadeFinal) {
        if(validadeCidade(cidadeFinal)){
            this.cidadeFinal = cidadeFinal;
        } else {
            String msg ="Cidade invalida";
            throw new RuntimeException(msg);
        }
    }
    public boolean validadeCidade(String cidade) {
        if(Arrays.asList(cidades_possiveis).contains(cidade)) {
            return true;
        } return false;
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public void setCidadeInicial(String cidadeInicial) {
        if(validadeCidade(cidadeInicial)){
            this.cidadeInicial = cidadeInicial;
        } else {
            String msg ="Cidade invalida";
            throw new RuntimeException(msg);
        }
    }

    public Viagem(String nomeViagem, Data dataPartida, Data dataChegada) {
        this.nomeViagem = nomeViagem;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
    }

    public Data getDataPartida() {
        return dataPartida;
    }
    public void setDataPartida(Data dataPartida) {
        this.dataPartida = dataPartida;
    }
    public Data getDataChegada() {
        return dataChegada;
    }
    public void setDataChegada(Data dataChegada) {
        this.dataChegada = dataChegada;
    }
    public int getLugaresEconomicos() {
        return lugaresEconomicos;
    }
    public int getLugaresExecutivos() {
        return lugaresExecutivos;
    }
    public int getLugaresPrimeiraClasse() {
        return lugaresPrimeiraClasse;
    }

    public void setLugaresEconomicos(int lugaresEconomicos) {
        this.lugaresEconomicos = lugaresEconomicos;
    }
    public void setLugaresExecutivos(int lugaresExecutivos) {
        this.lugaresExecutivos = lugaresExecutivos;
    }

    public void setLugaresPrimeiraClasse(int lugaresPrimeiraClasse) {
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }


    public BilheteList getBilhetesParaVender() {
        return bilhetesParaVender;
    }
    public void setBilhetesParaVender(BilheteList bilhetesParaVender) {
        this.bilhetesParaVender = bilhetesParaVender;
    }

    public BilheteList getBilhetesVendidos() {
        return bilhetesVendidos;
    }

    public void setBilhetesVendidos(BilheteList bilhetesVendidos) {
        this.bilhetesVendidos = bilhetesVendidos;
    }

    public Horario getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Horario horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Horario getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Horario horaChegada) {
        this.horaChegada = horaChegada;
    }
}
