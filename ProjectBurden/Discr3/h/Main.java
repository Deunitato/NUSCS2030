
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
		//System.out.print(random.getArrival());
		for(int i =0; i<numberOfServers ; i++){
			
			es.addServer(new Server(i+1));
			
			
		}
		
		
        
        es.simulateEvent();
        es.printAll();
    }


}
