package book.Comportamiento;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class C02 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new MiComportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("Adios :))");
    }

    private class MiComportamiento extends Behaviour{
        int numExecution = 1;

        @Override
        public void action() {
            System.out.println("Ejecucion #: "+numExecution);
            block(1000);
            System.out.println("Termina el action y ejecuta el done. Despues se bloquea: 1s");
            numExecution++;
        }

        @Override
        public boolean done() {
            if(numExecution> 10){
                return  true;
            } else {
                return  false;
            }
        }
    }
}
