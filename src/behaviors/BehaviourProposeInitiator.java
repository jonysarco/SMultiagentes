package behaviors;
import java.util.Vector;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class BehaviourProposeInitiator extends Behaviour {

	private int countMovies,state;
	private Vector<String> movies;
	private boolean end;
	private static final Integer Key = 1;
	
	public BehaviourProposeInitiator(Vector<String> mov) {
		// TODO Auto-generated constructor stub
		countMovies = 0;
		this.movies = mov;
		this.state = 0;
		end = false;
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		 AID id = new AID();
         id.setLocalName("Responder");
         if ( countMovies < movies.size() )	{  
		     //Creo el mensaje 
        	 ACLMessage message = new ACLMessage(ACLMessage.PROPOSE);
        	 message.setSender(myAgent.getAID());
        	 message.setLanguage("Español");
        	 message.addReceiver(id);
        	 message.setContent(movies.get(countMovies));
        	 message.setConversationId("AB-1");
        	 message.setReplyWith("A-001");
        	 countMovies++;
        	 //Envio el mensaje
        	 myAgent.send(message);
        	 state = 0;
         }
         else	{
        	 ACLMessage mensajeRechazo = new ACLMessage(ACLMessage.CANCEL);
        	 mensajeRechazo.setSender(myAgent.getAID());
        	 mensajeRechazo.setLanguage("Español");
        	 mensajeRechazo.addReceiver(id);
        	 mensajeRechazo.setContent("Fallo la conversacion"); 
        	 getDataStore().put(Key, mensajeRechazo); //Almaceno el mensaje que llego 
        	 state = 1;
         }
         end = true;
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return end;
	}

	@Override
	public int onEnd() {
		// TODO Auto-generated method stub
		return state;
	}
}
