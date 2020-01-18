
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main{
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		List<Customer> myList = new ArrayList<>();
		double arrival;
		Customer c = new Customer();
		double prevTime;
		CustomerHandler ch = new CustomerHandler();
		//ServerHandler sh = new ServerHandler();
		
		int numOfCust=0;
		
		
		//input
		int numOfServers = sc.nextInt();
		ServerHandler sh = new ServerHandler(numOfServers);
		for(int i =1;sc.hasNext();i++){
			//i++;
			arrival = sc.nextDouble();
		    c = new Customer(arrival,i);
			numOfCust = c.getNum();
			myList.add(c);
		}
		
		
		
		
		//===========================================================
		
		
		 
		 
		
		
		
		
		//Display
		//System.out.println("# Adding arrivals");
		for(int i = 0 ;i<numOfCust; i ++ ){
			
			//System.out.println(myList.get(i));
			//ch.arrivalLoad(myList.get(i));//load arrivals
			sh.arrivalLoad(myList.get(i));
		}
		
		//System.out.print("\n");
		
		//print the event log
		
		//while(!ch.bufferIsEmpty()){
			
		//	ch.printEvent();
		//}
		
		ch.assertEvent();
		
	    String stats = "["+ch.avgWait()+" " + ch.servedCount()+" "+ch.leavesCount()+"]";
	
		
		System.out.println(stats);
		
		
		
		
		
		
		
	}
	
	
	
}