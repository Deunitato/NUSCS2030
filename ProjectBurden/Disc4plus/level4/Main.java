
import java.util.Scanner;
import  cs2030.simulator.EventSimulator;
import  cs2030.simulator.Human;
import  cs2030.simulator.Arrival;
import  cs2030.simulator.SelfCheckout;
public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int seed = sc.nextInt();
		int numberOfServers = sc.nextInt();
		int numOfSelf = sc.nextInt();
		int queueSize = sc.nextInt();	
		int numCustomer = sc.nextInt();
		double arrivalRate = sc.nextDouble();
		double serviceRate = sc.nextDouble();
		double restingRate = sc.nextDouble();
		double restingProbability = sc.nextDouble();
		double greedyProbability = sc.nextDouble();
		double time=0.0;
		EventSimulator es = new EventSimulator(numCustomer,numberOfServers,numOfSelf,greedyProbability); 
		es.setRandom(seed,arrivalRate,serviceRate,restingRate);
		
		/*System.out.println("Seed: " +seed);
		System.out.println("Servers: " +numberOfServers);
		System.out.println("Queue: " +queueSize);
		System.out.println("Cust: " +numCustomer);
		System.out.println("Arr: " +arrivalRate);
		System.out.println("serviceRate: " +serviceRate);*/
		
		
		for(int i =0; i<numberOfServers ; i++){
			
			es.addServer(new Human(i+1,queueSize,restingProbability));
			
			
		}
		for(int i =numberOfServers; i<numOfSelf+numberOfServers ; i++){
			
			es.addServer(new SelfCheckout(i+1,queueSize));
			
			
		}
		
		
		
		
        
        es.simulateEvent();
        es.printAll();
    }


}
