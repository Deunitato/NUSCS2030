

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
	
	public double getTime(){
		return this.arrivalTime;
	}
	
	
	public int getID(){
		return this.id;
	}
	
	public int getNum(){
		return this.customers;
	}
	
	public String getString(){
		String s=String.format("%.3f",this.arrivalTime)+" "+ this.id+" arrives";
		return s;
	}
	
	
	@Override 
	public String toString(){
		//String s = this.id + " arrives at " + String.format("%.3f",this.arrivalTime); 
		String s=String.format("%.3f",this.arrivalTime)+" "+ this.id+" arrives";
		return s;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}