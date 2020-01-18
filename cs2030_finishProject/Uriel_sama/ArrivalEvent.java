import java.util.Optional;
import java.util.function.Supplier;
/**
 * ArrivalEvent class, extends CustomerEvent
 */
public class ArrivalEvent extends CustomerEvent{

    /**
     * List of servers that all customers can consider.
     */
	private static List<Server> servers;
	
    /**
     * Supplier method to get next customer, if any.
     */
	private static Supplier<Optional<Customer>> getNewCustomer;
     
    /**
     * Static method for setting list of servers available for customer.
     * @param servers List
     */
    public static void setServerList(List<Server> servers){
    	this.servers = servers;
    }
    
    /**
     * Static method for setting the Customer generator.
     * @param getNewCustomer The supplier of new Customers.
     */
    public static void setGetNewCustomer(Supplier<Optional<Customer>> getNewCustomer){
    	this.getNewCustomer = getNewCustomer;
    }
    
    /**
     * Constructor for ArrivalEvent class
     * @param customer Customer to be simulated
     */
    public ArrivalEvent(Customer customer){
        super(customer);
    }
    
    /**
     * Simulates a customer arriving and adds the next customer, if any.
     * @param Takes in a consumer function that handles additional generated events
     */
    public void simulateAndAddNext(Consumer<Event> eventConsumer){
        Optional<Customer> newCustomer = getNewCustomer();
        if(newCustomer.isPresent()){
            eventConsumer.accept(newCustomer.get());
        }
        Optional<Server> optionalServer = customer.chooseEmptyServer(servers);
        if(optionalServer.isPresent()){
        	optionalServer.get().setCurrent(customer);
        	eventConsumer.accept(optionalServer.get());
        }
        else{
        	optionalServer = Customer.chooseWaitServer(servers);
			if(optionalServer.isPresent()){
        		optionalServer.get().addArrival(customer);
        		eventConsumer.accept(optionalServer.get());
        	}
        	else{
        		eventConsumer.accept(new LeaveEvent(customer));
        	}
        }
    }

}