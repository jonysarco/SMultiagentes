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
             System.out.println(myAgent.getLocalName() + ": recibió el mensaje : " + mensaje.toString());
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
             	System.out.println("El agente " +  myAgent.getLocalName() + " esta esperando la respuesta ");
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
	
