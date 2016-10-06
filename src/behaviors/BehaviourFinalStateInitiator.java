package behaviors;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourFinalStateInitiator extends Behaviour{

	
	private static final Integer Key=1;
	private boolean fin ;
	
	
	public BehaviourFinalStateInitiator() {
		
	}

	@Override
	public void action() {
		 ACLMessage respuesta=(ACLMessage) getDataStore().get(Key);
		 if(respuesta.getPerformative()==ACLMessage.ACCEPT_PROPOSAL)
			 System.out.println("La propuesta del agente: " + myAgent.getLocalName() + "fue aceptada");
		 else
			 System.out.println("La propuesta del agente: " + myAgent.getLocalName() + "fue rechazada");
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

