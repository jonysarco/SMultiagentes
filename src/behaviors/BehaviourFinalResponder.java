package behaviors;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourFinalResponder extends Behaviour {

  private boolean fin ;
  private static final Integer Key = 1;
	 public BehaviourFinalResponder() {
			
		}
	 
	@Override
	public void action() {
		ACLMessage respuesta=(ACLMessage) getDataStore().get(Key);
		System.out.println("El agente "+ myAgent.getLocalName() +" acepto la película "+ respuesta.getContent());
		fin=true;
	}

	
	protected void takeDown() {
        System.out.println("Agente "+myAgent.getLocalName()+" termino de ejecutarse.");
    }

	@Override
	public boolean done() {
		if(fin==true)
			myAgent.doDelete();
		return fin;
	}


}
