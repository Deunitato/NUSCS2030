

public class Customer{

	private double arrivalTime;
	private static int customers=0;
	private int id;
	
	Customer(){};
	Customer(double arrival,int id){
		this.customers++;
		this.arrivalTime = arrival;
		this.id = id;
		
		
	}
	
	public int getNum(){
		return this.customers;
	}
	

	
	@Override 
	public String toString(){
		String s = this.id + " arrives at " + String.format("%.3f",this.arrivalTime); 
		return s;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}