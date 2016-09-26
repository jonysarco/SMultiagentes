import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;
import jade.proto.ProposeInitiator;

public class InitiatorStateMachine extends FSMBehaviour {
	
	public InitiatorStateMachine()	{
		DataStore dataStore = new DataStore();
		
		Propose propose = new Propose();
		Wait waitResponse = new Wait();
		FinalState finalState = new FinalState();
		
		this.registerFirstState(propose, "Propose");
		this.registerState(waitResponse, "Waiting");
		this.registerLastState(finalState, "Final");
		
		this.registerTransition("Propose", "Waiting", 0);
		this.registerTransition("Waiting", "Propose", 1);
		this.registerTransition("Propose", "Final", 2);
		
	}
	
}
