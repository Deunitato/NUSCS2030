package cs2030.simulator;
/**
 * ServeEvent class
 */
public class ServeEvent{
    /**
     * Counter for how many people are served. 
     */
    private static int served = 0;
    
    /**
     * Static supplier function to generate service time in the form of a double
     */
    private static DoubleSupplier genServiceTime = ()->1.0;
    
    /**
     * Constructor for ServeEvent class
     * @param server Server to be simulated
     */
    public ServeEvent(Server server){
        super(server);
    }

    /**
     * Simulates the Server back
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
        served++;
        server.serve(genServiceTime.getAsDouble());
        eventConsumer.accept(new DoneEvent(server));
    }
    
    /**
     * Gets the number of people served.
     * @return the number of people served.
     */
    public int getServed(){
    	return served;
    }
    
    /**
     * Sets the double supplier function for generating service time.
     * @param genServiceTime The double supplier function for generating service time.
     */
    public void setGenServiceTime(DoubleSupplier genServiceTime){
    	this.genServiceTime = genServiceTime;
	}	
	
    /**
     * Returns a String representing the serve event.
     * @return a String representing the serve event.
     */
    @Override
    public String toString(){
        return server.getCustomer() + " served by " + server;
    }
}