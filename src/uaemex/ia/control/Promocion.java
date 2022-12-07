package uaemex.ia.control;

import jade.content.Predicate;

import java.io.Serializable;

public class Promocion implements Predicate {
    private Boletos boleto;

    public Boletos getBoleto() {
        return boleto;
    }

    public void setBoleto(Boletos boleto) {
        this.boleto = boleto;
    }
}
