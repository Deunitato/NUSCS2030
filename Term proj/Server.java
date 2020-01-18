public class Server{

	boolean isWait=false;
	String onHold;
	private int waitID;
	private double finishServiceTime=-1.0;
	private int serverID;
	static CustomerHandler ch = new CustomerHandler();
	private boolean busy = false;
	/*
	*    Return true if there is someone in queue
	*    
	*/
	
	Server(CustomerHandler ch){
		this.ch = ch;
	
	}
	Server(int id){
		this.serverID = id;
	}
	
	//return true if its busy
	public boolean isBusy(){
		
		return this.busy;
	}
	
	//returns true when someone is in queue
	public boolean isWaiting(){
		return this.isWait;
	}
	
	public void setServerID(int id){
		this.serverID = id;
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
	
	
	
	public String getState(String event){
		
		String state = "";
		double time = getCustomer(event);
		
		if(finishServiceTime==-1.0){//first customer
		    finishServiceTime = time+1.0;
			state = "served";
			this.busy = true;
		
		}
		else if(finishServiceTime>time){ //still on going
			if(!(isWaiting())){//someone waiting{
				ch.addWaitingTime(finishServiceTime-time);
				finishServiceTime = finishServiceTime+1.0;
				waitID = eventID(event);
				isWait = true;
				state = "waits";
				
			}
			
			
		}
		else{ //previous finished
		    this.busy = true;
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
		s = String.format("%.3f",time)+" "+ id+" "+currentState + " by "+this.serverID;
		ch.submitEvent(s);
		
		//loads the done into buffer if its served
		if(currentState.equals("served")){
			this.busy = false;
			ch.submitEvent(String.format("%.3f",(time+1.0))+" "+ id+" done by "+this.serverID);
			if(isWaiting()){ //check if waiting
					this.busy = false;
					ch.submitEvent(String.format("%.3f",finishServiceTime-1)+" "+ waitID+" served by " + this.serverID);
					ch.submitEvent(String.format("%.3f",finishServiceTime)+" "+ waitID+" done serving by " + this.serverID);
				    isWait = false;
				}
			
		}
		
		
	}
	
	//execute the current event
	public void executeEvent(String event){
		
		if(event.contains("arrives")){ //if current event is arrived
			eventLoader(event);
			
		}
		else if (event.contains("served")&&(isWaiting())){ //if current event is served
			//ch.submitEvent(onHold);
			//already handled
		}
		else if(event.contains("done")){
				if(isWaiting()){ //check if waiting
					this.busy = false;
					ch.submitEvent(String.format("%.3f",finishServiceTime-1)+" "+ waitID+" served by " + this.serverID);
					ch.submitEvent(String.format("%.3f",finishServiceTime)+" "+ waitID+" done serving by " + this.serverID);
				    isWait = false;
				}
			
		}
		else{ //if current event is leaves
			//do nothing
		}
		
	}
	
	
	
	
	

}