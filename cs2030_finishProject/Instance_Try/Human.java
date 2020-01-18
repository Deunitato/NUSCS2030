package cs2030.simulator;
import java.util.Queue;
import java.util.LinkedList;
/**
 * A server with the type Human
 */
public class Human extends Server implements Restable{

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
   /** 
  * checks if server is not rest
  * attemps to let the server rest if possible
  * @param event , takes in an event 
  */
    @Override
	public void tryRest(Event event){
		if(EventSimulator.genRestRate() < super.RESTING_PROBABILITY){ //rest
			double rest = EventSimulator.genRestPeriod(); //generates rest period
			//adds to events
			EventSimulator.addEvent(new ServerRest(nextServeTime,super.id));
			super.nextServeTime = super.nextServeTime + rest;
			EventSimulator.addEvent(new ServerBack(this.nextServeTime,super.id));
			if(!myQueue.isEmpty()){
				EventSimulator.addBuffer(new Served(super.nextServeTime,myQueue.peek().getCustomer(),super.id));
			}
		}
		else{ //do per normal
			//return true;
		}
	}
}