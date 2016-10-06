package behaviors;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourWaitInitiator extends Behaviour {

	private boolean fin;
	 private int state;
	private static final Integer Key=1;
	
	public BehaviourWaitInitiator(){
		
	}
	
	@Override
	public void action() {
		
		//obtengo la respuesta del Receptor a la propuesta
		 ACLMessage mensaje = myAgent.receive();
         if (mensaje!= null)
         {
             System.out.println(myAgent.getLocalName() + ": recibió el mensaje : ");
             System.out.println(mensaje.toString());
             getDataStore().put(Key, mensaje); //Almaceno el mensaje que llego 
                          
             if(mensaje.getPerformative()==ACLMessage.ACCEPT_PROPOSAL){ 
            	
            	 state=1;
             }                
             else{ //sino vuelvo a proponer
            	 state=0;
             } 
            fin = true;
         }
         else
         {
             System.out.println("El agente " +  myAgent.getLocalName() + " esta esperando la respuesta ");
             block();
             
         }		
		
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

	
	
	
	/*
	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}
*/
}
