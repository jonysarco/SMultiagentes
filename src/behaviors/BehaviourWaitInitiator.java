package behaviors;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class BehaviourWaitInitiator extends Behaviour {

	private boolean end;
	private int state;
	private static final Integer Key = 1;
	
	public BehaviourWaitInitiator(){
		
	}
	
	@Override
	public void action() {
		//Respuesta del Receptor a la propuesta
		 ACLMessage mensaje = myAgent.receive();
         if ( mensaje!= null )
         {
             getDataStore().put(Key, mensaje); //Almaceno el mensaje que llego 
             if ( mensaje.getPerformative() == ACLMessage.ACCEPT_PROPOSAL )	{ 
            	 state=1;
             }                
             else	{ 
            	 //Vuelvo a proponer
            	 state=0;
             } 
            end = true;
         }
         else	{
             	block();
         }		
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return end;
	}
	
	public int onEnd() {
		// TODO Auto-generated method stub
		return state ;
	}

}	
	
