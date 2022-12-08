package uaemex.ia.agentes;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import uaemex.ia.control.Boletos;
import uaemex.ia.control.OntologiaCine;
import uaemex.ia.control.Paquete;

import java.util.List;

public class VendedorDulceria extends Agent {
    // Estructura de Datos
    private static List<Paquete> Orden;
    private static List<Paquete> OrdenCompleta;

    //Objetos de comunicacion
    private Codec codec = new SLCodec();
    private Ontology ontology = OntologiaCine.getInstance();

    @Override
    protected void setup() {
        DFAgentDescription description = new DFAgentDescription();

        //Describimos el servicio que impartira
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType("Vender Paquetes");
        serviceDescription.setName("Dulceria");

        // Agregamos el servicio que hara
        description.addServices(serviceDescription);

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);
    }
}
