import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;
public class CustomerHandler{
	private double finishServiceTime=0.0;
	private Queue<Double> serviceTime = new LinkedList<Double>();
	private static PriorityQueue<String> eventHandler = new PriorityQueue<String>(new Event_Comparator());
	//private String STATE;
	private int waitID;
	private static int num_served=0;
	private static int num_leaves=0;
	String onHold;
	private int serverID;
	boolean isWait=false;
	private static double avgWaitingtime = 0.0;
	private double waitingTime=0.0;
	
	
	/*===================================
	*    Constructors   
	=====================================*/
	CustomerHandler(){}
	
	CustomerHandler(int id){
		this.serverID = id;
	}
	

	
	
	/*====================================
	*    Boolean methods    
	=======================================*/
	
	//Return true if there is someone in queue
	public boolean isWaiting(double time){
		return time<waitingTime;
	}
	
	//returns true if customer comes when server is busy
	public boolean isBusy(double time){
		return time<finishServiceTime;
	}
	
	//return true if eventstate is empty
	public boolean bufferIsEmpty(){
		return eventHandler.size()==0;
		
	}
	
	/*====================================
	*    get methods    
	=======================================*/

	
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
	
	

	
	public String getState(String event){
		
		String state = "";
		double time = getCustomer(event);
		
		if(finishServiceTime==0.0){//first customer
		    finishServiceTime = time+1.0;
			state = "served";
		
		}
		else if(isBusy(time)){ //still on going
			//if(isWaiting()){//someone waiting{
			//state = "leaves";
			//}
			//else{
				avgWaitingtime=avgWaitingtime+(finishServiceTime-time);
				
				waitingTime = finishServiceTime;
				finishServiceTime = finishServiceTime+1.0;
				//waitID = eventID(event);
				//isWait = true;
				state = "waits";
				
		//	}
			
			
		}
		else{ //previous finished
			finishServiceTime = time+1.0;
			state = "served";
			
		}
	
	return state;
		
		
	}
	
	
	//loads the response to executed event
	//anything in here can either means its to be served or wait
	public void eventLoader(String event){ 
		int id = eventID(event);
		double time = getCustomer(event);
		
		String currentState = getState(event);
		String s="";
		if(currentState.equals("waits"))
			//eventHandler.add(event);
			s = String.format("%.3f",time)+" "+ id+" "+currentState+" to be served by "+this.serverID;
		if(currentState.equals("served")){
		
			s = String.format("%.3f",time)+" "+ id+" "+currentState+ " by "+this.serverID;
			eventHandler.add(String.format("%.3f",(finishServiceTime))+" "+ id+" done serving by "+ this.serverID); //loads intro buffer
		}
	
		eventHandler.add(s);
		
	
		
		
	}
	
	//execute the current event
	public void executeEvent(String event){
		
		if(event.contains("arrives")){ //if current event is arrived
			eventHandler.add(event);
			eventLoader(event);
			
		}
		else if(event.contains("waits")){
					
					int id = eventID(event);
					//double time = getCustomer(event);
					eventHandler.add(String.format("%.3f",finishServiceTime)+" "+ id+" done serving by "+ this.serverID);
					eventHandler.add(String.format("%.3f",waitingTime)+" "+ id+" served by "+ this.serverID);
					
				    
		}
		else if (event.contains("served")){ //if current event is served

		}
		else{ //if current event is leaves
			//do nothing
		}
		
		
		
	}
	

	
	
	
	public int leavesCount(){
		return this.num_leaves;
	}
	
	public int servedCount(){
		
		return this.num_served;
		
	}
	
	public String avgWait(){
		
		double avg = this.avgWaitingtime / num_served;
		
		return String.format("%.3f",avg);
		
		
	}
	
	public void stats(String event){
		if(event.contains("served")&&!event.contains("waits")){
			this.num_served++;
		}
		if(event.contains("leaves")){
			this.num_leaves++;
		}
		
	}
	
	
	public void addEvent(String event){
		eventHandler.add(event);
	}
	
	
	public void printState(String event){
		
		
		String time = String.format("%.3f",getCustomer(event));
		while(!bufferIsEmpty()){
		if(eventHandler.peek().contains(time)){
			String polled = eventHandler.poll();
			this.stats(polled);
			System.out.println(polled);
			if(polled.contains("waits")){
				executeEvent(polled);
				//break;
				
			}
			
		}
		else{
			break;
		}
		}
		
	}
	
	//prints current state
	public void printEvent(){
		
		String currentevent = eventHandler.peek();

		if(!currentevent.contains("waits")&&!currentevent.contains("arrive")){
		executeEvent(currentevent);}
		
		//print out all that happen at that certain time
		printState(currentevent); 
		
		
		
	}
	
	public void assertEvent(){
		
		while(!bufferIsEmpty()){
			String polled = eventHandler.poll();
			//System.out.println("1");
			this.stats(polled);
			System.out.println(polled);
		}
		
	}
	
	
	

	
	

	

}