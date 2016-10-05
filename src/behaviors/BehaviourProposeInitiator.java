package behaviors;
import java.util.Vector;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class BehaviourProposeInitiator extends Behaviour {

	private int countMovies,state;
	private Vector<String> movies;
	
	public BehaviourProposeInitiator(Vector<String> mov) {
		// TODO Auto-generated constructor stub
		countMovies = 0;
		this.movies = mov;
		this.state = 0;
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		 System.out.println(myAgent.getLocalName() +": envio una propuesta al Responder");
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
        	 System.out.println("Se envio una propuesta al emisor");
         }
         else	{
        	 System.out.println("No hay peliculas para recomendar");
         }
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
