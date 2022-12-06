package uaemex.ia.control;

import jade.content.Concept;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;


public class OntologiaCine extends Ontology {
    // Nombre de la Ontologia
    public static final String ONTOLOGY_NAME = "Ontologia-cine";

    public static final String BOLETOS = "Boletos";
    public static final String BOLETOS_NOMBRE = "Nombre";
    public static final String BOLETOS_ASIENTO = "Asiento";
    public static final String BOLETOS_TIPO_DE_SALA = "Tipo_de_sala";
    public static final String BOLETOS_SALA_ASIGNADA = "Sala_asignada";
    public static final String BOLETOS_PRECIO = "Precio";
    public static final String BOLETOS_FECHA = "Fecha";
    public static final String BOLETOS_CANTIDAD = "Cantidad";


    public static final String PAQUETE = "Paquete";
    public static final String PAQUETE_NOMBRE = "Nombre";
    public static final String PAQUETE_TIPO = "Tipo";
    public static final String PAQUETE_PRECIO = "Precio";
    public static final String PAQUETE_CANTIDAD = "Cantidad";
    public static final String PAQUETE_DESCRIPCION = "Descripcion";


    public static final String PROMOCION = "Promocion";
    public static final String PROMOCION_BOLETOS = "Boletos";

    public static final String COMPRA = "Compra";
    public static final String COMPRA_BOLETOS = "Boletos";
    public static final String COMPRA_PAQUETE = "Paquete";


    private static Ontology instance = new OntologiaCine();

    public static Ontology getInstance(){
        return instance;
    }


    private OntologiaCine(){
        super(ONTOLOGY_NAME, BasicOntology.getInstance());

        try {
            add(new ConceptSchema(BOLETOS), Boletos.class);
            add(new ConceptSchema(PAQUETE), Paquete.class);
            add(new PredicateSchema(PROMOCION), Promocion.class);
            add(new AgentActionSchema(COMPRA), Comprar.class);

            // Schema Boletos
            ConceptSchema conceptSchema =  (ConceptSchema) getSchema(BOLETOS);
            conceptSchema.add(BOLETOS_NOMBRE,(PrimitiveSchema)getSchema((BasicOntology.STRING)));
            conceptSchema.add(BOLETOS_ASIENTO,(PrimitiveSchema)getSchema((BasicOntology.INTEGER)));
            conceptSchema.add(BOLETOS_TIPO_DE_SALA,(PrimitiveSchema)getSchema((BasicOntology.STRING)));
            conceptSchema.add(BOLETOS_SALA_ASIGNADA,(PrimitiveSchema)getSchema((BasicOntology.STRING)));
            conceptSchema.add(BOLETOS_PRECIO,(PrimitiveSchema)getSchema((BasicOntology.FLOAT)));
            conceptSchema.add(BOLETOS_FECHA,(PrimitiveSchema)getSchema((BasicOntology.STRING)));
            conceptSchema.add(BOLETOS_CANTIDAD,(PrimitiveSchema)getSchema((BasicOntology.INTEGER)));

            // Schema Paquetes
            ConceptSchema conceptSchema1 =  (ConceptSchema) getSchema(PAQUETE);
            conceptSchema1.add(PAQUETE_NOMBRE,(PrimitiveSchema)getSchema((BasicOntology.STRING)));
            conceptSchema1.add(PAQUETE_TIPO,(PrimitiveSchema)getSchema((BasicOntology.INTEGER)));
            conceptSchema1.add(PAQUETE_PRECIO,(PrimitiveSchema)getSchema((BasicOntology.FLOAT)));
            conceptSchema1.add(PAQUETE_CANTIDAD,(PrimitiveSchema)getSchema((BasicOntology.INTEGER)));
            conceptSchema1.add(PAQUETE_DESCRIPCION,(PrimitiveSchema)getSchema((BasicOntology.STRING)));

            // Schema promocion
            PredicateSchema predicateSchema = (PredicateSchema) getSchema(PROMOCION);
            predicateSchema.add(PROMOCION_BOLETOS, (ConceptSchema)getSchema(BOLETOS));

            // Schema accion comprar
            AgentActionSchema agentActionSchema = (AgentActionSchema) getSchema(COMPRA);
            agentActionSchema.add(COMPRA_BOLETOS, (ConceptSchema) getSchema(BOLETOS));
            agentActionSchema.add(COMPRA_PAQUETE, (ConceptSchema) getSchema(BOLETOS));

        } catch (OntologyException e){
            e.printStackTrace();
        }


    }


}
