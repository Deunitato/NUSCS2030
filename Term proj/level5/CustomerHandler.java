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
	private int waitID;
	private int num_served=0;
	private int num_leaves=0;
	String onHold;
	boolean isWait=false;
	private double waitingTime=0.0;
	CustomerHandler(){}
	
	
		

	
	/*
	*    Return true if there is someone in queue
	*    
	*/
	public boolean isWaiting(){
		return this.isWait;
	}
	
	
	public String getState(int id){
		return this.mySTATES.get(id-1);
	}
	
	/*returns the customer time for an event
	*/
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
	
	
	
	public String getState(String event){
		
		String state = "";
		double time = getCustomer(event);
		
		if(finishServiceTime==-1.0){//first customer
		    finishServiceTime = time+1.0;
			state = "served";
		
		}
		else if(finishServiceTime>time){ //still on going
			if(isWaiting()){//someone waiting{
			state = "leaves";
			}
			else{
				waitingTime=waitingTime+(finishServiceTime-time);
				finishServiceTime = finishServiceTime+1.0;
				waitID = eventID(event);
				isWait = true;
				state = "waits";
				
			}
			
			
		}
		else{ //previous finished
			finishServiceTime = time+1.0;
			state = "served";
			
		}
	
	return state;
		
		
	}
	
	
	//loads the response to executed event
	public void eventLoader(String event){
		int id = eventID(event);
		Double time = getCustomer(event);
		
		String currentState = getState(event);
		String s="";
		s = String.format("%.3f",time)+" "+ id+" "+currentState;
		eventHandler.add(s);
		
		//loads the done into buffer if its served
		if(currentState.equals("served")){
			eventHandler.add(String.format("%.3f",(time+1.0))+" "+ id+" done");
		}
		
		
	}
	
	//execute the current event
	public void executeEvent(String event){
		
		if(event.contains("arrives")){ //if current event is arrived
			eventLoader(event);
			
		}
		else if (event.contains("served")&&(isWaiting())){ //if current event is served
			eventHandler.add(onHold);
		}
		else if(event.contains("done")){
				if(isWaiting()){ //check if waiting
					eventHandler.add(String.format("%.3f",finishServiceTime-1)+" "+ waitID+" served");
					eventHandler.add(String.format("%.3f",finishServiceTime)+" "+ waitID+" done");
				    isWait = false;
				}
			
		}
		else{ //if current event is leaves
			//do nothing
		}
		
	}
	
	//return true if eventstate is empty
	public boolean bufferIsEmpty(){
		return eventHandler.size()==0;
		
	}
	
	
	
	public int leavesCount(){
		return this.num_leaves;
	}
	
	public int servedCount(){
		
		return this.num_served;
		
	}
	
	public String avgWait(){
		
		double avg = this.waitingTime / num_served;
		
		return String.format("%.3f",avg);
		
		
	}
	
	private void stats(String event){
		if(event.contains("served")){
			this.num_served++;
		}
		if(event.contains("leaves")){
			this.num_leaves++;
		}
		
	}
	
	
	
	//prints current state
	public void printEvent(){
		
		String currentevent = eventHandler.poll();
		this.stats(currentevent);

		
		executeEvent(currentevent);
		System.out.println(currentevent);
		
		
		
	}
	
	
	

	
	

	

}