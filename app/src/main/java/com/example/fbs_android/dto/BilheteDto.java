package com.example.fbs_android.dto;

import com.example.fbs_android.model.TipoBilhete;
import com.example.fbs_android.model.TipoPassageiro;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements={"nomeViagem","extras","tipoPassageiro","tipoBilhete","cc"})
@Root(name = "bilhete")
public class BilheteDto {
    @Element(name="nomeViagem")
    private String nomeViagem;
    @Element(name="extras")
    private ExtrasDto extras;
    @Element(name="tipoPassageiro")
    private TipoPassageiro tipoPassageiro;
    @Element(name="tipoBilhete")
    private TipoBilhete tipoBilhete;
    @Element(name="cc")
    private String cc;


    public BilheteDto() {
    }

    public BilheteDto(String nomeViagem, ExtrasDto extras, TipoPassageiro tipoPassageiro, TipoBilhete tipoBilhete, String cc) {
        this.nomeViagem = nomeViagem;
        this.extras = extras;
        this.tipoPassageiro = tipoPassageiro;
        this.tipoBilhete = tipoBilhete;
        this.cc=cc;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public ExtrasDto getExtrasDto() {
        return extras;
    }

    public TipoPassageiro getTipoPassageiro() {
        return tipoPassageiro;
    }

    public TipoBilhete getTipoBilhete() {
        return tipoBilhete;
    }

    public String getCc() {
        return cc;
    }
}
