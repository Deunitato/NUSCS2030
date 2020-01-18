package cs2030.simulator;
import java.util.Queue;
import java.util.LinkedList;
public class Server{

    protected EventSimulator es = new EventSimulator();
    protected double nextServeTime =0;
    protected double waitTime =0;
	protected int id;
	private final int MAX_QUEUE_SIZE;
	private Queue<Event> myQueue = new LinkedList<>();
	private final double RESTING_PROBABILITY;
	private boolean isdone = false;
	private boolean isRest = false;
    Server(){
		this.MAX_QUEUE_SIZE=0;
		this.RESTING_PROBABILITY = 0;
	}
	
	public Server(int id,int queueSize){
		this.id = id;
		this.MAX_QUEUE_SIZE = queueSize;
		this.RESTING_PROBABILITY = 0;
	}
	
	public Server(int id,int queueSize,double restingprob){
		this.id = id;
		this.MAX_QUEUE_SIZE = queueSize;
		this.RESTING_PROBABILITY = restingprob;
	}
    
	
	/**=========================
	       Queue functions
	==========================*/
	/**
	* @param voids
	* @return true if Customer can queue, return false if cant
	*/
	public boolean canQueue(){
		if(myQueue.size()<MAX_QUEUE_SIZE){
			return true;
		}
		else{
			return false;
		}	
	}
	/**
	* @param e takes in object event
	*/
	public void addQueue(Event e){
		myQueue.add(e);
	}
	
	/**
	* @param void
	* @return Event
	* Returns and polls event in queue
	*/
	public Event pollQueue(){	
		return myQueue.poll();
	}
	
	public int getQueueSize(){
		return myQueue.size();
	}
	
	
	
	
	/**=========================
	       Server functions
	==========================*/
	
	/** 
	* @param event , takes in an event 
	* @return true if not resting, false if resting
	* @Description checks if server is not rest
	*/
	public void TryRest(Event event){
		
		if(this.es.genRestRate() < RESTING_PROBABILITY){ //rest
			double rest = this.es.genRestPeriod();
			this.es.addEvent(new ServerRest(nextServeTime,this.id));
			this.nextServeTime = this.nextServeTime + rest;
			this.es.addEvent(new ServerBack(this.nextServeTime,this.id));
			if(!myQueue.isEmpty()){
				this.es.addBuffer(new Served(this.nextServeTime,myQueue.peek().getCustomer(),this.id));
			}
		}
		else{ //do per normal
			//return true;
		}
		
	}
	
	
	
	
    /**
	* @param event , takes in an event to try to be served
	* @return true if incoming can be served, return false if cant
	*/
    public boolean serveIncoming(Event event){
		
       double incoming = event.getTime();
	   
       if((incoming>=nextServeTime)){ //check if can serve
      
           es.incServe();
		   double randomTime = es.getServeTime();
		   
           this.nextServeTime = incoming + randomTime;
		   
           es.addEvent(new Served(incoming,event.getCustomer(),this.id));
           es.addEvent(new Done(this.nextServeTime,event.getCustomer(),this.id));
		   es.addBuffer(new Done(this.nextServeTime,event.getCustomer(),this.id));
		   
           return true;
       }
       else{
           return false;
       }
    
    
    }
	
	/** 
	* @param event , takes in an event 
	* @return true if customer is served, false when cant serve
	* @Description also flush the queue ensure that all waiting will be served
	*/
	public boolean isFree(Event event){
		if(this.serveIncoming(event)){ //check if can serve
	    
		   //check if customer being served is the one in the queue 
		   if(this.myQueue.size()>0&&(myQueue.peek().getCustomer().getID() == event.getCustomer().getID())){
			   this.pollQueue(); //remove it
			   //flush the queue if not empty
			   if(myQueue.size() > 0){
				  Event e = new Served(this.nextServeTime,myQueue.peek().getCustomer(),this.id);
				  this.es.addBuffer(e);	
				 
				   
			   }
		   }
		   return true;
       }
       else{
		       
           return false;
       }
	}


   	/**
	* @param arrival , takes in an arrival event 
	* @return true if Customer can wait, return false if cant
	*/
    public boolean noWait(Event arrival){
    
        double incoming = arrival.getTime();
		 if(canQueue()){
			 
			this.waitTime = this.nextServeTime;
            this. es.addEvent(new Wait(incoming,arrival.getCustomer(),this.id));
            this.es.addBuffer(new Served(this.waitTime,arrival.getCustomer(),this.id)); 
			addQueue(new Wait(incoming,arrival.getCustomer(),this.id));
            return true;
		 }
		 else{
			 return false;
		 }
	}
	
	/**
	* @param void 
	* @return Id of the server
	*/
	public int getID(){
		return this.id;
	}



}
