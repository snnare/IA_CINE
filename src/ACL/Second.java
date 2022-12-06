package ACL;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

public class Second extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                // recive msg
                ACLMessage msg = receive();
                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "MSG receive: "+msg.getContent());
                }else {
                    block();
                }

            }
        });
    }
}
