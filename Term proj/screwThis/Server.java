
public class Server{

	boolean isWait=false;
	String onHold;
	double waitTime = 0.0;
	private int waitID;
	private double finishServiceTime=0.0;
	private int serverID;
	private static CustomerHandler ch = new CustomerHandler();
	private boolean first = true;
	double waitingTime=0;
	/*
	*    Return true if there is someone in queue
	*    
	*/
	
	public boolean isWaiting(double time){
		return time<waitingTime;
	}
	
	//returns true if customer comes when server is busy
	public boolean isBusy(double time){
		return time<finishServiceTime;
	}
	
	//modification methods
	Server(){}
	
	Server(CustomerHandler ch){
		this.ch = ch;
	
	}
	Server(int id){
		this.serverID = id;
	}
	
	public int getID(){
		return this.serverID;
	}
	
	
	public double getFinishedTime(){
		return this.finishServiceTime;
	}
	public double getWaittime(){
		return this.waitTime;
	}
	
	
	
	//toggle methods
	public void setFirst(boolean b){
		this.first = b;
	}
	
	public boolean isFirst(){
		return this.first;
	}
	
	public void setWait(boolean b){
		this.isWait = b;
	}
	
	
	
	//status check methods
	
	//return true if its busy
	
	
	//returns true when someone is in queue
	public boolean isWaiting(){
		return this.isWait;
	}
	
	
	
	
	

	
	
	
	
	//returns server response
	public String getState(double time, int id , String event){
		
		String state = "";
		if (event.contains("served")){//subsequent served
				finishServiceTime = time+1.0;
				state = String.format("%.3f",finishServiceTime)+" "+ id+" "+"done serving by "+this.getID();
				//this.busy = true; //its busy
			
		}
		else if(event.contains("waits")){
			    ch.setWaitingTime(finishServiceTime-time);
				waitingTime = finishServiceTime;
				finishServiceTime = finishServiceTime+1.0;
				//isWait = false;
				waitTime = finishServiceTime;
				state = String.format("%.3f",finishServiceTime-1)+" "+ id+" "+"served by "+this.getID();
				//executeEvent(finishServiceTime ,id , "done");
			    ch.submitEvent(String.format("%.3f",finishServiceTime)+" "+ id+" "+"done serving by "+this.getID());
				
		}
		else if(event.contains("done")){ 
		    isWait = false;
		    //this.busy = false;
			//finishServiceTime = finishServiceTime+1.0;
		   state = String.format("%.3f",finishServiceTime+1)+" "+ id+" "+"done serving by "+this.getID();
		} 
		else{
			
			/*		if(time<s.getFinishedTime()){
				s.toggleBusy(true);
		}
			*/
			//do nth
		}
	
	return state;
		
		
	}
	
	
	
	
		//assert events - served and wait
		public void executeEvent(double time, int id,String state){
		String s="";
		
		
		if(state.contains("served")){
		s = String.format("%.3f",time)+" "+ id+" "+ "served by "+this.getID();
		//System.out.println("s");
		}
		if(state.contains("waits")){
			s = String.format("%.3f",time)+" "+ id+" "+ "waits" + " to be served by "+this.getID();	
		}
		if(state.contains("leaves")){
			s = String.format("%.3f",time)+" "+ id+" leaves";
		}

		
		if(!state.contains("done")){
		ch.submitEvent(s);}
		
		
		//throws served and waits
		if(!state.contains("leaves")){
		String response = this.getState(time,id,state); 
		ch.submitEvent(response);}
		
		//ch.printEvent();
		
		
		}
		
		

	
	
	
	
	
	
	
	

	
	

	
	
	
	
	

}