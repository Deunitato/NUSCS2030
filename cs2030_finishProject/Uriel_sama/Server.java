package cs2030.simulator;
/**
 * Server class representing a self-serving server.
 */
public abstract class Server{
    /**
 	  * The current customer at the server.
      */
    private Optional<Customer> current;
    /**
 	  * The queue at the server.
      */
    private Queue<Customer> queue;
    
    /**
 	  * The next available time of the server.
      */
    private double time;
    
    /**
 	  * The ID of the server.
      */
    private int serverID;

    /**
 	  * The amount of customers allowed to queue at the servers.
      */
    private static int queueSize = 1;
    
    /**
 	  * Constructor for Server Class. 
 	  * @param serverID ID of the server. 
      */
    public Server(int serverID){
        this.serverID = serverID;
        queue = new LinkedList<Customer>();
        time = 0;
    }

    /**
 	  * Static method to set the queue size of the servers.
      */
    public static void setQueueSize(int queueSize){
        this.queueSize = queueSize;
    }
    
    /**
 	  * Getter function to get the ID of the server.
      */
    public int getID(){
		return serverID;
    }

    /**
 	  * Method to check if server is available to serve at input time.
 	  * @param time The time to be checked
 	  * @return True if able to serve at input time, False if not able to serve.
      */
    public boolean canServe(double time){
        if(time >= this.time){
            return true;
        }
        return false;
    }

    /**
 	  * Method to check if server is able to accept another customer into the queue.
 	  * @return True if able to accept another customer into the queue, False otherwise.
 	  */
    public boolean canWait(){
        if(queue.size() < queueSize){
            return true;
        }
        return false;
    }

    /**
 	  * Method to check the size of the queue at the server.
 	  * @return The size of the queue.
 	  */
    public int getQueueSize(){
    	return queue.size();
    }
    
    /**
     * Serve the current customer.
     */
    public void serve(Customer customer){
        //Handle the customer?
    }
    
    /**
     * Returns a String representing the Server.
     * @return a String representing the Server.
     */
     @Override
     public String toString(){
    	return "self-check " + getNumber();
     }
}