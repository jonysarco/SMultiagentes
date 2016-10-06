package behaviors;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BehaviourWaitResponder extends Behaviour {

	private boolean fin = false;
	private int state;
	private static final Integer Key = 1;
	public BehaviourWaitResponder(){
		fin = false;
		state=1;
	}
	
	@Override
	public void action() {
		
		System.out.println("El agente " + myAgent.getName() + " esta esperando la propuesta de una pelicula");
		 
		 /*MessageTemplate filtroOr = null;
				
		 MessageTemplate filtroInformPropose = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);  //filtro para que se reciban solo mensajes de asunto Propose
		 MessageTemplate filtroInformCancel = MessageTemplate.MatchPerformative(ACLMessage.CANCEL); //filtro para que se reciban solo mensajes de asunto Cancel 
		 
		 filtroOr = MessageTemplate.or(filtroInformPropose, filtroInformCancel);
		 */
		 ACLMessage message = myAgent.receive();
		
		 
		 
		 
		//Obtiene la primer pelicula de la cola de mensajes
		 if(message != null)
		 {
			 fin = true;
			 getDataStore().put(Key, message); //Almaceno el mensaje de entrada para que pueda manipularlo el siguiente estado
			 if(message.getPerformative()==ACLMessage.PROPOSE){
				 System.out.println("El agente " + myAgent.getName() + " recibió un mensaje Propose " );
	           	 state=0; //Paso al siguiente estado para analizar propuesta
			 }
			 else{
				 System.out.println("El agente " + myAgent.getName() + " recibió un mensaje Cancel " );
				 state = 2; // Como llego un mensaje Cancel paso al estado final
			 }   
         }
         else
         {
        	 state=1;
             System.out.println(myAgent.getLocalName() +": esta esperando a recibir propuesta de pelicula...");
             block();                 
         }		

	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return fin;
	}
	
	@Override
	public int onEnd() {
	// TODO Auto-generated method stub
	return state;
	}

}
