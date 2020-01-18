package cs2030.simulator;
/**
 * Event interface
 */
public interface Event{
    /**
     * Gets time of event to be simulated.
     * @return the time of the event to be simulated.
     */
    public double getTime();

    /**
     * Gets customer ID.
     * @return the ID of the Customer if there is one. Otherwise, returns an OptionalInt.empty()
     */
    public OptionalInt getCustomerID();

    /**
     * Simulates the event and also gets the next event if there is one.
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer);
}