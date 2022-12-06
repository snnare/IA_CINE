package book.Comportamiento;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class C00 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new MiComportamiento());
    }

    private class MiComportamiento extends Behaviour{
        @Override
        public void action() {
            System.out.println("My nombre es: "+getName());
            System.out.println("Soy el primer comportamiento");
            myAgent.addBehaviour(new MiComportamiento2());
        }

        @Override
        public boolean done() {
            return true;
        }
    }

    private class MiComportamiento2 extends Behaviour{
        @Override
        public void action() {
            System.out.println("2do Comportamiento");
        }

        @Override
        public boolean done() {
            return true;
        }
    }

}
