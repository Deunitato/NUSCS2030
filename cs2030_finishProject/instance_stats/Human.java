package cs2030.simulator;
import java.util.Queue;
import java.util.LinkedList;
/**
 * A server with the type Human
 */
public class Human extends Server{

  /**
   * Default constructor of the Human
   * Server class, evokes the parent class Server
   * @param id, id of server
   * @param queueSize, size of the queue
   * @param restingProb, probability of human resting
   */
	public Human(int id,int queueSize, double restingProb){
		super(id,queueSize,restingProb);
		
	}
}