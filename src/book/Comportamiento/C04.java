package book.Comportamiento;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class C04  extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new OverbearingBehaviour());
    }

    @Override
    protected void takeDown() {
        System.out.println("Adios :))");
    }

   public class OverbearingBehaviour extends Behaviour{
       @Override
       public void action() {
           int i = 0;
           boolean aux = true;
           while (aux){
               if(i>4){
                   aux = false;
               }
               System.out.println("Hola");
               i++;
           }
       }

       @Override
       public boolean done() {
           return true;
       }
   }
}

