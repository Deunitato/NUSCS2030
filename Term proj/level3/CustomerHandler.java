import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import java.util.List;
public class CustomerHandler{
	private double finishServiceTime=-1.0;
	private Customer prev = new Customer();
	private List<String> mySTATES = new ArrayList<String>();
	private Queue<Double> serviceTime = new LinkedList<Double>();
	//private String STATE;
	public int counter=0;
	
	
	CustomerHandler(){
		//this.prev= c;
		//stateLoader(c);
	}
	
	
	public void stateLoader(Customer c){
		if(finishServiceTime==-1.0){//first customer
		    finishServiceTime = c.getTime()+1.0;
			serviceTime.add(finishServiceTime);
			mySTATES.add("served");
			counter++;
		}
		else if(finishServiceTime>c.getTime()){
			mySTATES.add("leaves");
			counter++;
			
		}
		else{
			finishServiceTime = c.getTime()+1.0;
			serviceTime.add(finishServiceTime);
			mySTATES.add("served");
			counter++;
		}
	}
	
	
	
	
	
	
	public String getState(int id){
		return this.mySTATES.get(id-1);
	}
	
	

	public String printState(int id,Customer c){
		String s="";
		String currentState = mySTATES.get(id-1); // assume smallest id is 1
		//s = "Customer "+ currentState+ ";";
       /* if(currentState.equals("leaves")){
			s = "Customer "+ currentState;
			//do nothing
		}
		else{
			s = "Customer "+ currentState+ ";";
			s = s+" next service @ " + String.format("%.3f",serviceTime.poll());
		
		}	*/
		
		s = String.format("%.3f",c.getTime())+" "+ c.getID()+" "+currentState;
		
		return s;
	}
	
	/*@Override 
	public String toString(){
		String s="";
		String currentState;
		for(int i=0;i<counter;i++){
		currentState = mySTATES.get(i);
		s = "Customer "+ currentState+ ";";
        if(currentState.equals("leaves")){
			
			s=s+"\n";
		}
		else{
			s = s+" next service @ " + serviceTime.poll()+"\n";
		
		}
		
		
		}
		return s;
	}*/

}