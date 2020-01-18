import java.util.Scanner;
import  cs2030.simulator.EventSimulator;
import  cs2030.simulator.Human;
import  cs2030.simulator.Arrival;
import  cs2030.simulator.SelfCheckout;
/**
 * Main is the main driver class for simulating an Event
 * Inputs: seed,number of servers, number of self servers
 * queue size, number of customer, 
 * rate of arrival,service , resting , resting probability
 * and greedy probability
 *
 * Generates servers and self check out based on inputs and add them
 * To event simulator
 *  Simulates the event and print results
 */
public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner obj
		int seed = sc.nextInt(); //seed 
		int numberOfServers = sc.nextInt(); //servers(normal) number
		int numOfSelf = sc.nextInt(); // number of self servers
		int queueSize = sc.nextInt();	//allowed queue size
		int numCustomer = sc.nextInt(); //amount of customers
		double arrivalRate = sc.nextDouble(); //rate of arrival
		double serviceRate = sc.nextDouble(); //rate of service
		double restingRate = sc.nextDouble(); //rate of resting
		double restingProbability = sc.nextDouble(); //probability of resting
		double greedyProbability = sc.nextDouble(); //probability of being greedy
		EventSimulator es = new EventSimulator(numCustomer,numberOfServers,numOfSelf,greedyProbability); //event simulator object
		es.setRandom(seed,arrivalRate,serviceRate,restingRate); //set random rates
		//generates servers (normal) and add them into server list in eventSimulator
		for(int i =0; i<numberOfServers ; i++){
			es.addServer(new Human(i+1,queueSize,restingProbability));
		}
		//generates self check out servers and add them into server list in Event Simulator
		for(int i =numberOfServers; i<numOfSelf+numberOfServers ; i++){
			es.addServer(new SelfCheckout(i+1,queueSize));
		}
		//simulates the event
        es.simulateEvent();
		//print outcome
        es.printAll();
    }
}
