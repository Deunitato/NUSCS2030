package cs2030.simulator;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Server class that for normal servers
 */
public class Server{
  /** Event Simulator instance*/
    protected EventSimulator es = new EventSimulator();
  /** time for the next avail serve*/
    protected double nextServeTime =0;
  /** Time before server can serve*/
    protected double waitTime =0;
  /** ID of server*/
	protected final int id;
  /** Size of Queue*/
	private final int MAX_QUEUE_SIZE;
  /** Queue for customer waiting*/
	private Queue<Event> myQueue = new LinkedList<>();
  /** Probability of server resting*/
	private final double RESTING_PROBABILITY;
  /**
   * A Default constructor for the Server class.
   */
    Server(){
		this.MAX_QUEUE_SIZE=0;
		this.RESTING_PROBABILITY = 0;
		this.id = 0;
	}
  /**
   * A Overloaded constructor for the Server class.
   * @param id, server ID
   * @param  queueSize, size of server queue
   */
	public Server(int id,int queueSize){
		this.id = id;
		this.MAX_QUEUE_SIZE = queueSize;
		this.RESTING_PROBABILITY = 0; //sets it to 0 as default
	}
  /**
   * A Overloaded constructor for the Server class.
   * @param id, server ID
   * @param  queueSize, size of server queue
   * @param restingprob, probability of server resting
   */
	public Server(int id,int queueSize,double restingprob){
		this.id = id;
		this.MAX_QUEUE_SIZE = queueSize;
		this.RESTING_PROBABILITY = restingprob;
	}
   /**=======================
  *       Queue functions
  *=========================*/
   /**
  * checks if Customer can queue
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
  * Returns and polls event in queue
  * @return Event
  */
	public Event pollQueue(){	
		return myQueue.poll();
	}
   /**
  * get queue size
  * @return size of queue
  */
	public int getQueueSize(){
		return myQueue.size();
	}
   /**=========================
  *       Server functions
  *=========================*/
   /** 
  * checks if server is not rest
  * attemps to let the server rest if possible
  * @param event , takes in an event 
  */
	public void TryRest(Event event){
		if(this.es.genRestRate() < RESTING_PROBABILITY){ //rest
			double rest = this.es.genRestPeriod(); //generates rest period
			//adds to events
			EventSimulator.addEvent(new ServerRest(nextServeTime,this.id));
			this.nextServeTime = this.nextServeTime + rest;
			EventSimulator.addEvent(new ServerBack(this.nextServeTime,this.id));
			if(!myQueue.isEmpty()){
				EventSimulator.addBuffer(new Served(this.nextServeTime,myQueue.peek().getCustomer(),this.id));
			}
		}
		else{ //do per normal
			//return true;
		}
	}
   /**
  * Checks if server can serve incoming 
  * attempt to serve if possible
  * @param event , takes in an event to try to be served
  * @return true if incoming can be served, return false if cant
  */
    public boolean serveIncoming(Event event){
       double incoming = event.getTime(); //get incoming time
       if((incoming>=nextServeTime)){ //check if can serve
           sim_Stats.incServe(); //inc number of served
		   double randomTime = es.getServeTime(); //gen random serve time
           this.nextServeTime = incoming + randomTime; //next serve time
		   //add to events
           EventSimulator.addEvent(new Served(incoming,event.getCustomer(),this.id));
           EventSimulator.addEvent(new Done(this.nextServeTime,event.getCustomer(),this.id));
		   EventSimulator.addBuffer(new Done(this.nextServeTime,event.getCustomer(),this.id)); 
           return true;
        }
       else{
           return false;
        }
    }
   /** 
  * checks if the server is free to serve
  * attempt to serve if possible
  * also flush the queue ensure that all waiting will be served
  * @param event , takes in an event 
  * @return true if customer is served, false when cant serve
  */
	public boolean isFree(Event event){
		if(this.serveIncoming(event)){ //check if can serve
		   //check if customer being served is the one in the queue 
		   if(this.myQueue.size()>0&&(myQueue.peek().getCustomer().getID() == event.getCustomer().getID())){
			   this.pollQueue(); //remove it
			   //flush the queue if not empty
			   if(myQueue.size() > 0){
				  Event e = new Served(this.nextServeTime,myQueue.peek().getCustomer(),this.id);
				  EventSimulator.addBuffer(e);	
			   }
		    }
		   return true;
        }
       else{
           return false;
        }
	}
   /**
  * Attemps to make arrivals wait
  * @param arrival , takes in an arrival event 
  * @return true if Customer can wait, return false if cant
  */
    public boolean noWait(Event arrival){
        double incoming = arrival.getTime();
		 if(canQueue()){ //checks if can queue
			this.waitTime = this.nextServeTime;
			//adds accordingly
            EventSimulator.addEvent(new Wait(incoming,arrival.getCustomer(),this.id));
            EventSimulator.addBuffer(new Served(this.waitTime,arrival.getCustomer(),this.id)); 
			addQueue(new Wait(incoming,arrival.getCustomer(),this.id));
            return true;
		 }
		 else{
			 return false;
		 }
	}
   /**
  * Gets the id of the server
  * @return Id of the server
  */
	public int getID(){
		return this.id;
	}
}
