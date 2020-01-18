package cs2030.simulator;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Event Simulator class to simulate the customer and servers
 * Note: there should be no dependency on this class, this depends on all other classes
 */
public class EventSimulator{

    /**
     * Priority queue containing next event to execute
     */
    private PriorityQueue<Event> pq;

    /**
     * ArrayList of all servers
     */
    private ArrayList<Server> servers;


    /**
     * Count of remaining customers that have not arrived
     */
    private int remainingCustomers;



    /**
     * Constructor of Event Simulator class
     * @param serverCount The number of human servers.
     * @param customerCount The number of Customers.
     * @param seed The seed for the random number generator.
     * @param queueSize The maximum queue size of each server.
     * @param selfCheckoutNumber The number of self-checkout servers.
     * @param arrivalRate The customer arrival rate (lambda).
     * @param serviceRate The customer service rate (mu).
     * @param restingRate The server resting rate (rho).
     * @param restingProbability The probability of a human server resting (Pr).
     * @param greedyProbability The probability of a greedy customer occuring (Pg).
     */
    public EventSimulator(int serverNumber, int customerCount, int seed, int queueSize,
    	int selfCheckoutNumber, double arrivalRate, double serviceRate, double restingRate, 
        double restingProbability, double greedyProbability){
        
        RandomGenerator rngesus = new RandomGenerator(seed, arrivalRate, serviceRate, restingRate);
        CustomerFactory cf = new CustomerFactory(greedyProbability, rngesus::genCustomerType, customerCount);
	
		Server.setQueueSize(queueSize);
        ArrivalEvent.setGetNewCustomer(cf::getNewCustomer);
        HumanServer.setGenRandomRest(rngesus::genRandomRest);
        HumanServer.setGenRestPeriod(rngesus::genRestPeriod);
        HumanServer.setRestingProbability(restingProbability);
        
        List<Server> serverList= new ArrayList<Server>();
        for(int i = 0; i < serverNumber; i++){
        	serverList.add(new HumanServer(i + 1));
        }
        for(int i = serverNumber; i < serverNumber + selfCheckoutNumber; i++){
        	serverList.add(new SelfCheckServer(i + 1));
        }
        ArrivalEvent.setServerList(serverList);
        
    }
    
    /**
      * Adds a customer to the simulator
      * @param time The arrival time of the customer.
      */
    private void addCustomer(Double time){
        customerCount++;
        Customer newCustomer = new Customer(time, customerCount);
        pq.add(new ArrivalEvent(newCustomer));
    }
    
    /**
      * Starts the simulation of the events.
      */
    public void simulate(){
       if (remainingCustomers > 0) {
           remainingCustomers--;
           addCustomer(0.0);
           flushEvents();
       }
    }
    
    /**
      * Simulates all events and prints out each event before simulated.
      */
    private void flushEvents(){
        while(!pq.isEmpty()){
            Event e = pq.poll();
            System.out.println(e);
            e.simulateAndAddNext(pq::add);
        }

		/*
        //statistics class
        if(served == 0){
        	System.out.printf("[0.000 0 %d]\n", left);
        }
        else{
        	System.out.printf("[%.3f %d %d]\n",totalWait/served, served, left);
        }
        */
    }
    
	/**
	 * Print out the current queue of events to be executed for Stage 1 level 4.
	 * @deprecated
	 */
	@Deprecated
    private void printQueue(){
        PriorityQueue<Event> temp = new PriorityQueue<Event>();
        while(!pq.isEmpty()){
            Event e = pq.poll();
            System.out.println(e);
            temp.add(e);
        }
        while(!temp.isEmpty()){
            pq.add(temp.poll());
        }
        System.out.println();
    }
}
