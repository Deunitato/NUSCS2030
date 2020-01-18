import java.util.Optional;
/**
 * Customer class reprensenting the customer with Arrival time and his ID
 */
public class GreedyCustomer extends Customer{
    public GreedyCustomer(double arrivalTime, int customerID){
        super(arrivalTime, customerID);
    }
    /**
     * Method for GreedyCustomer to choose which server to go to.
     * @param servers List of servers to choose from.
     * @return An Optional value of the Server that the customer chose to go to.
     */
    public Optional<Server> chooseWaitServer(List<Server> servers){
        int bestQueueLength = 1000000000;
        Optional<Server> bestServer = Optional.empty();
        for(Server s: servers){
            if(s.getQueueSize() < bestQueueLength){
            	bestServer = Optional.of(s);
            	bestQueueLength = s.getQueueSize();
            }
        }
        return bestServer;
    }
    
    /**
     * Returns a String representing the Greedy Customer.
     * @return a String representing the Greedy Customer.
     */
    @Override
    public String toString(){
        return String.format("%.3f %d", getTime(), getNumber());
    }
}