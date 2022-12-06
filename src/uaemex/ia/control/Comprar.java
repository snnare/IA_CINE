package uaemex.ia.control;

import jade.content.AgentAction;

public class Comprar implements AgentAction {
    private Boletos boleto;
    private Paquete paquete;

    public Boletos getBoleto(){
        return this.boleto;
    }

    public void setBoleto(Boletos boleto) {
        this.boleto = boleto;
    }


    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
