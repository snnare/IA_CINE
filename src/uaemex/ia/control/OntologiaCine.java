package uaemex.ia.control;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.schema.ConceptSchema;
import test.OntologiaCliente;

public class OntologiaCine extends Ontology {
    // Nombre de la Ontologia
    public static final String ONTOLOGY_NAME = "Ontologia-cine";

    //Concepto de cliente
    public static final String CLIENTE = "Cliente";
    public static final String CLIENTE_NOMBRE = "nombre";
    public static final String CLIENTE_TELEFONO = "";

    // Concepto de Cuenta de Cine
    public static final String CUENTA_CINE = "CuentaCine";
    public static final String CUENTA_CINE_CLIENTE = "cliente";
    public static final String CUENTA_CINE_MONTO = "monto";
    public static final String CUENTA_CINE_NUMERO_CUENTA = "numero_tarjeta";

    // Concepto de Cuenta de Cine
    public static final String PELICULA = "Pelicula";
    public static final String PELICULA_NOMBRE = "nombre";
    public static final String PELICULA_DURACION = "duracion";
    public static final String PELICULA_COSTO = "costo";

    // Concepto de Pago
    public static final String TRANSACCION = "Transaccion";
    public static final String TRANSACCION_CLABE_ORIGEN = "clabe_origen";
    public static final String TRANSACCION_CLABE_DESTINO = "clabe_destino";
    public static final String TRANSACCION_MONTO = "monto";

    // Predicado de Activacion de cuenta
    public static final String ACTIVACION_CUENTA_CINE = "ActivacionAhorro";

    //Predicado de Cancelacion
    public static final String CANCELACION_CUENTA_CINE  = "CancelacionAhorro";


    private static Ontology instance = new OntologiaCine();

    public static Ontology getInstance(){
        return instance;
    }


    private OntologiaCine(){
        super(ONTOLOGY_NAME, BasicOntology.getInstance());


    }


}
