import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;
public class CustomerHandler{

	private PriorityQueue<String> eventHandler = new PriorityQueue<String>(new Event_Comparator());
	private int num_served=0;
	private int num_leaves=0;
	
	
	private double waitingTime=0.0;
	CustomerHandler(){}
	
	//loads all the arrivals
	
	
	
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
	
	public void addWaitingTime(double wait){
		
		this.waitingTime = this.waitingTime+wait;
	}
	
	private void stats(String event){
		if(event.contains("served")){
			this.num_served++;
		}
		if(event.contains("leaves")){
			this.num_leaves++;
		}
		
	}
	
	public void submitEvent(String event){
		
		this.eventHandler.add(event);
	}
	
	
	
	//prints current state
	public void printEvent(){
		
		String currentevent = eventHandler.poll();
		this.stats(currentevent);

		
		//executeEvent(currentevent);
		System.out.println(currentevent);
		
		
		
	}
	
	
	

	
	

	

}