
import java.util.Scanner;
import  cs2030.simulator.EventSimulator;
import  cs2030.simulator.Server;
import  cs2030.simulator.Arrival;
public class Main{

    public static void main(String[] args) {
		
		
		

        
        Scanner sc = new Scanner(System.in);
		int seed = sc.nextInt();
		int numberOfServers = sc.nextInt();
		int numCustomer = sc.nextInt();
		double arrivalRate = sc.nextDouble();
		double serviceRate = sc.nextDouble();
		double time=0.0;
		EventSimulator es = new EventSimulator(numCustomer); 
		
		es.setRandom(seed,arrivalRate,serviceRate,0);
		/*System.out.println("Seed: " +seed);
		System.out.println("Arr: " +arrivalRate);
		System.out.println("serviceRate: " +serviceRate);
		System.out.println("Servers: " +numberOfServers);
		System.out.println("Cust: " +numCustomer);*/
		for(int i =0; i<numberOfServers ; i++){
			
			es.addServer(new Server(i+1));
			
			
		}
		
		
        
        es.simulateEvent();
        es.printAll();
    }


}
