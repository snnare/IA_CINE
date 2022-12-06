package book.Comportamiento;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class C03 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new MyBehaviour());
    }

    private class MyBehaviour extends Behaviour{
        @Override
        public void onStart() {
            System.out.println("Se ejecuta al inicio del comportamiento :))");
        }

        @Override
        public void action() {
            System.out.println("Hola :))");

            block(1000);
            System.out.println("Despues de 1s");

        }

        @Override
        public boolean done() {
            return true;
        }

        @Override
        public int onEnd() {
            reset();
            myAgent.addBehaviour(this);
            return  0;
        }
    }
}
