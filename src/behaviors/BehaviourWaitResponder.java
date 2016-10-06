package behaviors;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BehaviourWaitResponder extends Behaviour {

	private boolean fin = false;
	private int state = 0;
	private static final Integer Key = 1;
	public BehaviourWaitResponder(){
		
	}
	
	@Override
	public void action() {
		
		System.out.println("El agente " + myAgent.getName() + " esta esperando la propuesta de una pelicula");
		
				
		 MessageTemplate filtroInform = MessageTemplate.MatchPerformative(ACLMessage.PROPOSE);  //filtro para que se reciban solo mensajes de asunto Propose
		 
		 ACLMessage message = myAgent.receive(filtroInform);
		
		//Obtiene la primer pelicula de la cola de mensajes
		 if(message != null){
			 
			 getDataStore().put(Key, message); //Almaceno el mensaje de entrada para que pueda manipularlo el siguiente estado 
			 
			 System.out.println("El agente " + myAgent.getName() + " recibi� la siguiente pel�cula " + message.getContent());
           	 state=0; //Paso al siguiente estado para analizar propuesta  
         }
         else
         {
        	 state=1;
             System.out.println(myAgent.getLocalName() +": Esperando a recibir propuesta de pelicula...");
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
