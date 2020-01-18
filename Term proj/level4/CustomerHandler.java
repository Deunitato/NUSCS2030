import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;
public class CustomerHandler{
	private double finishServiceTime=-1.0;
	private Customer prev = new Customer();
	private List<String> mySTATES = new ArrayList<String>();
	private Queue<Double> serviceTime = new LinkedList<Double>();
	private PriorityQueue<String> eventHandler = new PriorityQueue<String>(new Event_Comparator());
	//private String STATE;
	public int counter=0;
	String onHold;
	
	
	CustomerHandler(){}
	
	
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
	
	//returns the customer time for an event
	public double getCustomer(String event){
		String s = event.substring(0, 6);
		return Double.parseDouble(s);
	}
	
	//returns the customer id for an event
	public int eventID(String event){
		String s = event.substring(6, 10);
		s = s.replaceAll("[^\\d]", "");
		int k = Integer.parseInt(s);
		return k;
	}
	
	
	
	//loads all the arrivals
	public void arrivalLoad(Customer c){
		eventHandler.add(c.getString());
	}
	
	
	//loads the status of the next customer
	public void eventLoader(String event){
		int id = eventID(event);
		Double time = getCustomer(event);
		//System.out.println(id);
		String currentState = mySTATES.get(id-1);
		String s="";
		s = String.format("%.3f",time)+" "+ id+" "+currentState;
		eventHandler.add(s);
		
		//loads the done into buffer if its served
		if(currentState.equals("served")){
			this.onHold =  String.format("%.3f",(time+1.0))+" "+ id+" done";
		}
		
		
	}
	
	//execute the event
	public void executeEvent(String event){
		
		if(event.contains("arrives")){ //if current event is arrived
			eventLoader(event);
			
		}
		else if (event.contains("served")){ //if current event is served
			eventHandler.add(onHold);
		}
		else{ //if current event is done or leaves
			//do nothing
		}
		
	}
	
	//return true if eventstate is empty
	public boolean bufferIsEmpty(){
		return eventHandler.size()==0;
		
	}
	
	//prints current state
	public void printEvent(){
		
		String currentevent = eventHandler.poll();
		String eventString="# Get next event: " + currentevent;
		System.out.println(eventString);
		executeEvent(currentevent);
		Object[] eventArr = eventHandler.toArray(); 
		//prints out one event instance
		for (int j = 0; j < eventArr.length; j++) {
            System.out.println(eventArr[j]); 
			}
			
			System.out.print("\n");
		
		
		
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
	

}