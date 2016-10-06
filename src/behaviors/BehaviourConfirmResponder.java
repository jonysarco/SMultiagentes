package behaviors;

import jade.core.behaviours.Behaviour;
import jade.domain.introspection.ACLMessage;

public class BehaviourConfirmResponder extends Behaviour {

	private boolean fin;
	private int state;
	private static final Integer Key = 1;
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		//obtengo el mensaje de propuesta
		ACLMessage respuesta=(ACLMessage) getDataStore().get(Key);
		
		//como aceptar o rechazar una pelicula.. 
		/*
		 
		 */
		
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return fin;
	}
	public int onEnd() {
		// TODO Auto-generated method stub
		return state ;
		}

}
