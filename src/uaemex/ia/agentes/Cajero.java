package uaemex.ia.agentes;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import uaemex.ia.control.Boletos;
import java.util.List;



public class Cajero extends Agent {

    @Override
    protected void setup() {
        DFAgentDescription description = new DFAgentDescription();
        description.addLanguages("Español");
        description.setName(getAID());

        ServiceDescription servicio = new ServiceDescription();
        servicio.setType("Cobrar Cuenta");
        servicio.setName("Cajero");

        description.addServices(servicio);

        initComponents();
        //abrirPuesto();

        Cajero.WaitPingAndReplyBehaviour PingBehaviour;
        PingBehaviour =  new Cajero.WaitPingAndReplyBehaviour(this);
        addBehaviour(PingBehaviour);
    }

    private void initComponents(){
        ArmarPuesto();
    }

    private void ArmarPuesto(){

    }

    class WaitPingAndReplyBehaviour extends SimpleBehaviour{
        private boolean finished = true;
        private int suma = 0;

        public WaitPingAndReplyBehaviour(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            while (finished){
                System.out.println("Esperando la cuenta del mesero...");

                try {
                    ACLMessage msg  = blockingReceive();
                    if("J".equals((msg.getLanguage()))){
                        List<Boletos> boletosList = (List<Boletos>) msg.getContentObject();
                        String dialogo;
                        dialogo = "Sumando....Cajero\n";

                        for (int i = 0; i < boletosList.size(); i++) {
                            suma += boletosList.get(i).getPrecio();
                            dialogo+="C:"+boletosList.get(i).getNombre() + " $"+ boletosList.get(i).getPrecio() + "\n";
                        }
                        System.out.println(dialogo);
                        dialogo+="\nLa cuenta es: $" +suma;


                        System.out.println("C: Entregando la cuenta: ");
                        System.out.println("C: Cuenta entregada");
                    } else {
                        System.out.println(getLocalName()+"C: Esto no esta bien :,v");
                    }

                } catch (UnreadableException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public boolean done() {
            return finished;
        }
    }

}
