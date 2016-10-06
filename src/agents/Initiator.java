package agents;
import java.util.Vector;

import jade.core.Agent;
import jade.util.leap.ArrayList;
import stateMachines.InitiatorStateMachine;

public class Initiator extends Agent{
	
	private Vector<String> movies = null;
	
	public Initiator()	{
		//this.movies = mov;
		
	}
	
	protected void setup()	{
		//Agrego comportamiento al agente
		movies = new Vector<>();
		movies.add("peli1");
		movies.add("peli2");
		addBehaviour(new InitiatorStateMachine(this.movies));
		
		System.out.println("El agente"+this.getAID().getName()+" se encuentra activo");
	}
}
