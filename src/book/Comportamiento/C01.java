package book.Comportamiento;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class C01 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new MiComportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("La escala ha termiado");
    }


    private class  MiComportamiento extends Behaviour {
        private int estado = 0;

        @Override
        public void action() {
            switch (estado){
                case 0: System.out.println("Do"); break;
                case 1: System.out.println("Re"); break;
                case 2: System.out.println("Mi"); break;
                case 3: System.out.println("Fa"); break;
                case 4: System.out.println("Sol");break;
                case 5: System.out.println("La"); break;
                case 6: System.out.println("Si"); break;
                case 7:{
                    System.out.println("Do");
                    myAgent.doDelete();
                    break;
                }
            }
            estado++;
        }

        @Override
        public boolean done() {
            return (estado>7);
        }
    }
}
