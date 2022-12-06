package test;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;

public class OntologiaCliente extends  Ontology{
    public static final String ONTOLOGY_NAME = "Ontologia-Cliente";

    public static  final String PERSONA = "Persona";
    public static  final String PERSONA_NOMBRE ="nombre";
    public static  final String CIUDAD = "Ciudad";
    public static  final String CIUDAD_NOMBRE = "nombre";
    public static  final String PERSONA_EDAD = "edad";

    public static final String CLIENTE = "Cliente";
    public static final String CLIENTE_NUMERO = "numCliente";

    private static Ontology instance =  new OntologiaCliente();

    public static Ontology getInstance(){
        return instance;
    }

    private OntologiaCliente(){
        super(ONTOLOGY_NAME, BasicOntology.getInstance());

        try {
            add(new ConceptSchema(PERSONA), Persona.class);
            add(new ConceptSchema(CLIENTE), Cliente.class);
            add(new ConceptSchema(CIUDAD), Ciudad.class);
            //add(new PredicateSchema(ES_))
        }catch (OntologyException oe){
            oe.printStackTrace();
        }
    }






}
