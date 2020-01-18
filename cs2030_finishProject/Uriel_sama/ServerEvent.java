package cs2030.simulator;
/**
 * Event interface
 */
public abstract class ServerEvent{
    /**
     * The server to be simulated in this event.
     */
    protected Server server;
    /**
     * Constructor for ServerEvent.
     * @param server Takes in a server to be simulated in this event.
     */
    public ServerEvent(Server server){
        this.server = server;
    }
    /**
     * Gets time of event to be simulated.
     * @return the time of the event to be simulated.
     */
    public double getTime(){
        return server.getTime();
    }
        
    /**
     * Gets customer ID.
     * @return the ID of the Customer if there is one. Otherwise, returns an OptionalInt.empty()
     */
    public OptionalInt getCustomerID(){
        return OptionalInt.of(server.getCustomerID());
    }
}