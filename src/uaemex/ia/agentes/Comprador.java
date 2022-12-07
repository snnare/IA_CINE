package uaemex.ia.agentes;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import uaemex.ia.control.Boletos;
import uaemex.ia.control.Comprar;
import uaemex.ia.control.OntologiaCine;
import uaemex.ia.control.Promocion;

public class Comprador extends Agent {
    private Codec codec = new SLCodec();
    private Ontology ontology = OntologiaCine.getInstance();

    class WaitPingAndReplyBehaviour extends SimpleBehaviour{
        private boolean finished = false;

        public WaitPingAndReplyBehaviour(Agent  agent){
            super(agent);
        }


        @Override
        public void action() {
            System.out.println("Eseprando promocion del Vededor de Taquilla...");

            MessageTemplate messageTemplate = MessageTemplate.and(
                    MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontology.getName())
            );
            ACLMessage msg = blockingReceive(messageTemplate);

            try {
                if(msg != null){
                    if(msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD){
                        System.out.println("Mensaje NOT UNDERSTOOD recibido");
                    } else {
                        if(msg.getPerformative() == ACLMessage.INFORM){
                            ContentElement element = getContentManager().extractContent(msg);

                            if(element instanceof Promocion){
                                Promocion promocion = (Promocion) element;
                                Boletos boletos = promocion.getBoleto();

                                System.out.println("Mensaje recibido");
                                System.out.println(boletos.toString());

                                // Compramos
                                Comprar compra =  new Comprar();
                                compra.setBoleto(boletos);

                                ACLMessage message2 = new ACLMessage(ACLMessage.REQUEST);
                                message2.setLanguage(codec.getName());
                                message2.setOntology(ontology.getName());
                                message2.setSender(getAID());
                                message2.addReceiver(msg.getSender());
                                getContentManager().fillContent(message2, compra);
                                send(message2);
                                System.out.println("Compra solicitada");
                            } else {
                                // En este caso se recibe un INFORM con el contenido incorrecto
                                ACLMessage reply = msg.createReply();
                                reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                                reply.setContent("(UnexpectedContect (expected ping))");
                                send(reply);

                            }
                        } else {
                            // Recibiendo una performativa incorrecta
                            ACLMessage reply = msg.createReply();
                            reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                            reply.setContent("Unexpected-act "+ACLMessage.getPerformative(msg.getPerformative()));
                            send(reply);
                        }

                    }
                }
            } catch (OntologyException e) {
                throw new RuntimeException(e);
            } catch (Codec.CodecException e) {
                throw new RuntimeException(e);
            }


        }


        @Override
        public boolean done() {
            return finished;
        }
    }


    @Override
    protected void setup() {
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);
        WaitPingAndReplyBehaviour PingBehaviour =  new WaitPingAndReplyBehaviour(this);
        addBehaviour(PingBehaviour);
    }
}
