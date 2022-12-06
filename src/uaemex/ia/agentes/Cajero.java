package uaemex.ia.agentes;

import jade.core.Agent;
import jade.core.UnreachableException;
import jade.core.behaviours.SimpleBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

import java.util.logging.Level;
import java.util.logging.Logger;


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
        abrirPuesto();

        Cajero.WaitPingAndReplyBehaviour PingBehaviour;
        PingBehaviour =  new Cajero().WWaitPingAndReplyBehaviour(this);
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



                }catch (UnreachableException ex){
                    Logger.getLogger(VendedorTaquilla.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        @Override
        public boolean done() {
            return false;
        }
    }

}
