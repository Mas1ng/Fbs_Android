package com.example.fbs_android.dto;

import com.example.fbs_android.model.Companhia;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"nome", "dataP", "dataC"}) // não sei se são estes os nomes certos
@Root(name = "viagem")
public class ViagemDto {
    @Element(name="nomeViagem")    private String nomeViagem;
    @Element(name="lugaresTotais")    private int LugaresTotais;
    @Element(name="companhia")    private Companhia companhia;
    @Element(name="cidadeFinal")    private String cidadeFinal;
    @Element(name="cidadeInicial")    private String cidadeInicial;
    @Element(name="dataPartida")    private DataDto dataPartida;
    @Element(name="dataChegada")    private DataDto dataChegada;

    @Element(name="horarioPartida")    private HorarioDto horarioPartida;
    @Element(name="horarioChegada")    private HorarioDto horarioChegada;
    @Element(name="lugaresEconomicos")    private int lugaresEconomicos;
    @Element(name="lugaresExecutivos")    private int lugaresExecutivos;
    @Element(name="lugaresPrimeiraClasse")    private int lugaresPrimeiraClasse;

    public ViagemDto() {
    }

    public ViagemDto(Companhia companhia, DataDto dataPartida, DataDto dataChegada) {
        this.companhia = companhia;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
    }

    public ViagemDto(String nomeViagem, int lugaresTotais, Companhia companhia, String cidadeInicial, String cidadeFinal, DataDto dataPartida, DataDto dataChegada, HorarioDto horarioPartida,HorarioDto horarioChegada, int lugaresEconomicos, int lugaresExecutivos, int lugaresPrimeiraClasse) {
        this.nomeViagem=nomeViagem;
        this.LugaresTotais = lugaresTotais;
        this.companhia = companhia;
        this.cidadeFinal = cidadeFinal;
        this.cidadeInicial = cidadeInicial;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.horarioPartida=horarioPartida;
        this.horarioChegada=horarioChegada;
        this.lugaresEconomicos = lugaresEconomicos;
        this.lugaresExecutivos = lugaresExecutivos;
        this.lugaresPrimeiraClasse = lugaresPrimeiraClasse;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public int getLugaresTotais() {
        return LugaresTotais;
    }
    public Companhia getCompanhia() {
        return companhia;
    }
    public String getCidadeFinal() {
        return cidadeFinal;
    }
    public String getCidadeInicial() {
        return cidadeInicial;
    }
    public DataDto getDataPartida() {
        return dataPartida;
    }
    public DataDto getDataChegada() {
        return dataChegada;
    }

    public HorarioDto getHorarioPartida() {
        return horarioPartida;
    }

    public HorarioDto getHorarioChegada() {
        return horarioChegada;
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
}
