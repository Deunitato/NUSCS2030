package cs2030.simulator;
/**
 * Factory class for producing Customers
 */
public class CustomerFactory{
	/**
	 * Parameter for probability of a greedy customer, from 0 to 1.
	 */
    private double greedyProbability;
    
	/**
	 * Supplier function to generate random numbers for probability of greedy customers.
	 */
    private DoubleSupplier genCustomerType = () -> 0.0;
     
    private DoubleSupplier genInterArrivalTime = () -> 1.0;
	/**
	 * Count of number of customers to be produced.
	 */
    private int customerCount;
    
	/**
	 * Count of remaining number of Customers to produce.
	 */
    private int maxCustomers;
    
    /**
 	 * Keeps track of the time which the previous customer arrived.
 	 */
    private double previousCustomerTime;
    
	/**
	 * Constructor for CustomerFactory. Takes in probability of greedy customers, 
	 * a random number generator and number of customers to produce.
	 * @param greedyProbability Probability of generating a greedy customer.
	 * @param randomFunction A random number generator that generates doubles from 0 to 1.
	 * @param maxCustomers The number of customers to be generated;
	 */
    public CustomerFactory(double greedyProbability, DoubleSupplier genCustomerType, int maxCustomers){
        this.greedyProbability      = greedyProbability;
        this.genCustomerType      = genCustomerType;
        this.maxCustomers           = maxCustomers;
        this.customerCount          = 0;
        previousCustomerTime     = 0; 
    }
    
    /**
     * Function that returns a new Customer, if any.
     * @return Optional instance containing the new customer if there is one, otherwise Optional.empty().
     */
    public Optional<Customer> getNewCustomer(){
        if(customerCount >= maxCustomers ){
            return Optional.empty();
        }
        else{
        	if(customerCount != 0){
        		previousCustomerTime = previousCustomerTime + genInterArrivalTime.getAsDouble();
        	}
        	customerCount += 1;
            if(genCustomerType.getAsDouble() >= greedyProbability){
                   return Optional.of(new Customer(previousCustomerTime, customerCount));
            }
            else{
                  return Optional.of(new GreedyCustomer(previousCustomerTime, customerCount));
            }
        }
    }
}