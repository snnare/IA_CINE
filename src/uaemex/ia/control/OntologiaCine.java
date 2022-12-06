package uaemex.ia.control;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.schema.ConceptSchema;
import test.OntologiaCliente;

public class OntologiaCine extends Ontology {
    // Nombre de la Ontologia
    public static final String ONTOLOGY_NAME = "Ontologia-cine";

    private static Ontology instance = new OntologiaCine();

    public static Ontology getInstance(){
        return instance;
    }


    private OntologiaCine(){
        super(ONTOLOGY_NAME, BasicOntology.getInstance());


    }


}
