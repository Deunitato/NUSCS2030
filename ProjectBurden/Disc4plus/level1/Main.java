
import java.util.Scanner;
import  cs2030.simulator.EventSimulator;
import  cs2030.simulator.Human;
import  cs2030.simulator.Arrival;
public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int seed = sc.nextInt();
		int numberOfServers = sc.nextInt();
		int queueSize = sc.nextInt();	
		int numCustomer = sc.nextInt();
		double arrivalRate = sc.nextDouble();
		double serviceRate = sc.nextDouble();
		double restingRate = 0;//sc.nextDouble();
		double restingProbability = 0;//sc.nextDouble();
		double time=0.0;
		EventSimulator es = new EventSimulator(numCustomer); 
		
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
		
		
        
        es.simulateEvent();
        es.printAll();
    }


}
