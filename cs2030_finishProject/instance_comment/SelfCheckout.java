package cs2030.simulator;
/**
 * An Server with type SelfCheckout
 */
public class SelfCheckout extends Server{
  /**
   * Default constructor of the SelfCheckout class
   * evokes the parent class Server
   * @param id, sets the server id
   * @param queueSize, sets the size of the Queue
   */
	public SelfCheckout(int id,int queueSize){
		super(id,queueSize);
	}
}