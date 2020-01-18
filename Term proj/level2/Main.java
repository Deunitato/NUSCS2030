
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main{
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		List<Customer> myList = new ArrayList<>();
		double arrival;
		int numOfCust = 0;
		Customer c = new Customer();
		double prevTime;
		CustomerHandler ch = new CustomerHandler();
		
		
		//input
		for(int i =1;sc.hasNext();i++){
			//i++;
			arrival = sc.nextDouble();
		    c = new Customer(arrival,i);
			myList.add(c);
			ch.stateLoader(c); //load the customer in stateloader
			numOfCust = c.getNum(); //I will get the num of customers
		}
		//===========================================================
		
		
		 
		 
		
		
		
		
		//Display
		for(int i = 0 ;i<numOfCust; i ++ ){
			
			System.out.println(myList.get(i));
			System.out.println(ch.printState((myList.get(i)).getID()));
		}
		//System.out.println(ch);
		System.out.println("Number of customers: "+ numOfCust);
		
		
		
		
		
		
		
	}
	
	
	
}