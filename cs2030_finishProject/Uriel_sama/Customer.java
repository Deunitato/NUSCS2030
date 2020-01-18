import java.util.Optional;
import java.util.OptionalDouble;
/**
 * Customer class reprensenting the customer with Arrival time and his ID
 */
public class Customer{
    /**
     * The arrival time of the customer
     */
    private double arrivalTime;
    
    /**
     * The serve time of the customer
     */
    private OptionalDouble serveTime;
    
    /**
     * The serve time of the customer
     */
    private OptionalDouble serveTime;
    
    /**
     * The ID of the customer
     */
    private int customerID;

    /**
     * Gets the ID of the customer
     * @return the ID of the customer
     */
    public Customer(double arrivalTime, int customerID){
        this.arrivalTime = arrivalTime;
        this.customerID  = customerID;
        this.serveTime = OptionalDouble.empty();
    }
    
    
    /**
     * Sets the serve time of the Customer.
     * @param The serve time of the customer.
     */
    public void setServeTime(double serveTime){
    	this.serveTime = OptionalDouble.of(serveTime);
    }

    /**
     * Gets the ID of the customer.
     * @return the ID of the customer.
     */
    public int getID(){
        return this.customerID;
    }
    
    /**
     * Gets the arrival time of the customer.
     * @return the arrival time of the customer.
     */
    public double getTime(){
        return this.ArrivalTime;
    }

    /**
     * Method for Customer to choose which empty server to go to.
     * @param servers List of servers to choose from.
     * @return An Optional value of the Server that the customer chose to go to.
     */
    public Optional<Server> chooseEmptyServer(List<Server> servers){
        for(Server s: servers){
            if(s.canServe(e.getCustomer())){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
    /**
     * Method for Customer to choose which server to go to wait.
     * @param servers List of servers to choose from.
     * @return An Optional value of the Server that the customer chose to go to.
     */
    public Optional<Server> chooseWaitServer(List<Server> servers){
        for(Server s: servers){
            if(s.canWait(e.getCustomer())){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
    
    /**
     * Returns a String representing the Customer.
     * @return a String representing the Customer.
     */
    @Override
    public String toString(){
        return String.format("%.3f %d", getTime(), getNumber());
    }
}