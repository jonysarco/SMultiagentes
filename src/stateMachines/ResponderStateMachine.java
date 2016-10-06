package stateMachines;

import behaviors.BehaviourConfirmResponder;
import behaviors.BehaviourFinalResponder;
import behaviors.BehaviourWaitResponder;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;

public class ResponderStateMachine extends FSMBehaviour {

		
	DataStore dataStateResponder = new DataStore();	
	
	public ResponderStateMachine() {
		super();
		
	    BehaviourWaitResponder waitResponder = new BehaviourWaitResponder();
		waitResponder.setDataStore(dataStateResponder);
			
		BehaviourConfirmResponder confirmResponder = new BehaviourConfirmResponder();
		confirmResponder.setDataStore(dataStateResponder);
		
		
		BehaviourFinalResponder finalResponder = new BehaviourFinalResponder();
		finalResponder.setDataStore(dataStateResponder);
		
		
		//Registrar Estados
		this.registerFirstState(waitResponder,"waitResp");
		this.registerState(confirmResponder, "confirmResp");
		this.registerState(finalResponder, "finalResp");
		
		this.registerTransition("waitResp", "confirmResp",0 ); 	//Voy al estado siguiente para analizar la pelicula  
		this.registerTransition("waitResp", "waitResp",1 ); 	//Me quedo esperando que llegue un mensaje
		this.registerTransition("waitResp", "finalResp", 2);	//Voy a estado final por rechazo
				
		this.registerTransition("confirmResp", "finalResp",1); 	//Voy a estado final
		this.registerTransition("confirmResp", "waitResp",0 ); 	//Vuelvo a esperar otra propuesta
		
		this.registerDefaultTransition("waitResp", "confirmResp");
		
	}
	
	
}

