package stateMachines;
import java.util.Vector;

import behaviors.BehaviourFinalStateInitiator;
import behaviors.BehaviourProposeInitiator;
import behaviors.BehaviourWaitInitiator;
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;
import jade.proto.ProposeInitiator;
import jade.util.leap.ArrayList;

public class InitiatorStateMachine extends FSMBehaviour{
	
	public InitiatorStateMachine(Vector<String> mov)	{
		DataStore dataStore = new DataStore();
		
		//Definicion de estados
		BehaviourProposeInitiator propose = new BehaviourProposeInitiator(mov);
		propose.setDataStore(dataStore);
		
		BehaviourWaitInitiator waitResponse = new BehaviourWaitInitiator();
		waitResponse.setDataStore(dataStore);

		BehaviourFinalStateInitiator finalState = new BehaviourFinalStateInitiator();
		finalState.setDataStore(dataStore);
		
		//Registrar estados
		this.registerFirstState(propose, "Propose");
		this.registerState(waitResponse, "Waiting");
		this.registerLastState(finalState, "Final");
		
		//Definir transiciones
		this.registerTransition("Propose", "Waiting", 0);
		this.registerTransition("Propose", "Final", 1);
		this.registerTransition("Waiting", "Propose", 0);
		this.registerTransition("Waiting", "Final", 1);
		
		
	}
	
}
