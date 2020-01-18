package cs2030.simulator;
/**
 * DoneEvent class
 */
public class DoneEvent extends ServerEvent{
	
    /**
     * Constructor for Done class
     * @param server Server to be simulated
     */
    public DoneEvent(Server server){
        super(server);
    }

    /**
     * Simulates the Done event
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
    	server.doneServing();
    	if(server instanceof HumanServer ){
    		if( ((HumanServer) server).checkRest()){
            	((HumanServer) server).rest();
            	eventConsumer.accept(new ServerRest(server));
            	return;
            }
    	}
        if(server.hasWait()){
        	server.prepareNext();
    		pq.add(new ServeEvent(server));
        }
    }

    /**
     * Returns a String representing the done event.
     * @return a String representing the done event.
     */
    @Override
    public String toString(){
        return server.getCustomer() + " done serving by " + server;
    }
}