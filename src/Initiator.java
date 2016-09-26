import jade.core.Agent;

public class Initiator extends Agent{
	
	protected void setup()	{
		addBehaviour(new InitiatorStateMachine());
		
	}
	
}
