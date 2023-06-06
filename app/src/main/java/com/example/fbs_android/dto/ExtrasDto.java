package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import com.example.fbs_android.model.*;


@Order(elements={"seguro","comida","mala"})
@Root(name = "extras")
public class ExtrasDto {

        @Element(name="seguro")
        private boolean seguro;
        @Element(name="comida")
        private boolean comida;
        @Element(name="mala")
        private Mala mala;

        public ExtrasDto() {
        }

        public ExtrasDto(boolean seguro, boolean comida, Mala mala) {
            this.seguro = seguro;
            this.comida = comida;
            this.mala = mala;
        }

        public boolean isSeguro() {
            return seguro;
        }

        public boolean isComida() {
            return comida;
        }

        public Mala getMala() {
            return mala;
        }
}
