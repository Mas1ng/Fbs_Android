package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

@Order(elements = {"hora", "minuto"}) // não sei se são estes os nomes certos
@Root(name = "horario")
public class HorarioDto {
    @Element(name="hora")    private int hora;
    @Element(name="minuto")    private int minuto;

    public HorarioDto(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public HorarioDto() {
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
}
