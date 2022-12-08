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
import uaemex.ia.control.OntologiaCine;

import java.util.ArrayList;
import java.util.Random;

public class Usuario extends Agent {
    public static final float SALDO_USUARIO = 200;

    private Codec codec = new SLCodec();
    private Ontology ontology = OntologiaCine.getInstance();
    private ArrayList<Boletos> boletos;
    private MessageTemplate mt;


    class ComportamientoUsuario extends SimpleBehaviour {
        private boolean finished = false;
        private boolean saldo_suficiente = true;
        private boolean cuenta_inexistente = true;

        public ComportamientoUsuario(Agent a) {
            super(a);
        }

        @Override
        public void action() {
            //COMUNICACION CON OTRO AGENTE
            System.out.println("\nEsperando accion de Agentes");
            mt = MessageTemplate.and(
                    MessageTemplate.MatchLanguage(codec.getName()),
                    MessageTemplate.MatchOntology(ontology.getName()));
            ACLMessage msg = blockingReceive(mt);

            try {
                if (msg != null) {
                    if (msg.getPerformative() == ACLMessage.INFORM) {
                        ContentElement ec = getContentManager().extractContent(msg);
                        cuenta_inexistente = true;
                    } else {
                        // Recibida una performativa incorrecta
                        ACLMessage reply = msg.createReply();
                        reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                        reply.setContent("Error:_No hay Sistema para acceder a los Datos");
                        send(reply);
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

        private String crearClabe() {
            StringBuilder clabe = new StringBuilder();
            Random numAleatorio = new Random();

            // Constructor pasadole una semilla
            Random numAleatorio1 = new Random(375);
            for (int i = 0; i < 18; i++) {
                clabe.append(Integer.toString(numAleatorio.nextInt(9 - 1 + 1) + 1));
            }
            return clabe.toString();
        }

        private String crearTarjeta() {
            StringBuilder tarjeta = new StringBuilder();
            Random numAleatorio = new Random();
            // Constructor pasadole una semilla
            Random numAleatorio1 = new Random(375);

            for (int i = 1; i <= 16; i++) {
                tarjeta.append(Integer.toString(numAleatorio.nextInt(9 - 1 + 1) + 1));
                if (i % 4 == 0) {
                    tarjeta.append("-");
                }

            }
            tarjeta.deleteCharAt(tarjeta.length() - 1);
            return tarjeta.toString();
        }

    } //Fin de la clase ComportamientoUsuario


    @Override
    protected void setup() {
        System.out.println("INICIE USUARIO");
        //this.cuentas = (ArrayList<CuentaBancaria>) this.getArguments()[0];
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);


        ComportamientoUsuario PingBehaviour;
        PingBehaviour = new ComportamientoUsuario(this);
        addBehaviour(PingBehaviour);
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente Terminado");
    }

}
