package cs2030.simulator;
import java.util.Queue;
import java.util.LinkedList;
public class Human extends Server{
	
	private final double RESTING_PROBABILITY;
	/**
	* @param id, id of server
	* @param queueSize, size of the queue
	*/
	public Human(int id,int queueSize, double restingProb){
		super(id,queueSize);
		this.RESTING_PROBABILITY = restingProb;
		
	}
	
	
	
	


}