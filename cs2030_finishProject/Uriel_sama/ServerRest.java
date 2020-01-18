package cs2030.simulator;
/**
 * ServerRest class
 */
public class ServerRest{
    /**
     * Constructor for LeaveEvent class
     * @param customer Customer to be simulated
     */
    public ServerRest(Server server){
        super(server);
    }

    /**
     * Simulates the Leave
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
    	server.rest();
        eventConsumer.accept(new ServerBack(server));
    }
    
    /**
     * Returns a String representing the wait event.
     * @return a String representing the wait event.
     */
    @Override
    public String toString(){
        return  String.format("%.3f ",server.getTime()) + server +  " rest";
    }
}