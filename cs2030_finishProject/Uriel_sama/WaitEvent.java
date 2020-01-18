package cs2030.simulator;
/**
 * WaitEvent class
 */
public class WaitEvent{
    /**
     * Constructor for WaitEvent class
     * @param server Server to be simulated
     */
    public WaitEvent(Server server){
        super(server);
    }

    /**
     * Simulates the WaitEvent
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
    	//Customer is waiting...
    }
    
    
    /**
     * Returns a String representing the wait event.
     * @return a String representing the wait event.
     */
    @Override
    public String toString(){
        return server.getCustomer() + " waits to be served by " + server;
    }
}