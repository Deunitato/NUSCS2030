package cs2030.simulator;
/**
 * ServerBack class representing the event which the server comes back.
 */
public class ServerBack{
    /**
     * Constructor for ServerBack class.
     * @param server Server to be simulated.
     */
    public ServerBack(Server server){
        super(server);
    }

    /**
     * Simulates the Server coming back from rest.
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
        if(server.hasWait()){
        	server.prepareNext();
    		eventConsumer.accept(ServeEvent(server));
    	}
    }
    
    
    /**
     * Returns a String representing the server back event.
     * @return a String representing the server back event.
     */
    @Override
    public String toString(){
        return  String.format("%.3f ",getServer().getTime()) + server +  " back";
    }
}