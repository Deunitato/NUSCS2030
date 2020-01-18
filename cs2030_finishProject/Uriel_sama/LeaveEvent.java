package cs2030.simulator;
/**
 * LeaveEvent class
 */
public class LeaveEvent{
	/**
	 * Count of how many times leaveEvent is invoked
	 */
	private static int count = 0;
    /**
     * Constructor for LeaveEvent class
     * @param customer Customer to be simulated
     */
    public LeaveEvent(Customer customer){
        super(customer);
    }

    /**
     * Simulates the Leave
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
        count = count + 1;
        Customer.setState(CustomerState.LEAVE);
    }
    
    /**
     * Returns a String representing the leave event.
     * @return a String representing the leave event.
     */
    @Override
    public String toString(){
        return c + " leaves";
    }
}