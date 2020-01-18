import java.util.OptionalInt;
/**
 * CustomerEvent class
 */
public abstract class CustomerEvent{
    /**
     * Customer to be simulated
     */
    protected Customer customer;
    
    /**
     * Constructor for CustomerEvent class
     * @param customer Customer to be simulated
     */
    public CustomerEvent(Customer customer){
        this.customer = customer;
    }
    
    /**
     * Gets time of event to be simulated.
     * @return the time of the event to be simulated.
     */
    public double getTime(){
        return customer.getTime();
    }

    /**
     * Gets customer ID.
     * @return the ID of the Customer.
     */
    public OptionalInt getCustomerID(){
        return OptionalInt.of(customer.getID());
    }

}