package cs2030.simulator;
public class Server{

    //EventSimulator es = new EventSimulator(new Leave());
    private double nextServeTime =0;
    private double waitTime =0;
    private boolean waiting = false;
	private int id;
	private static RandomGenerator random;
	//private static RandomGenerator randomForWait;
	//private Customer waitingCustomer;
    Server(){}
	public Server(int id){
		this.id = id;
	}
    

    //return true if successfully served
    public boolean isFree(Event arrival){
    
	//System.out.println(es.getServeTime());
       double incoming = arrival.getTime();
       if(incoming>=nextServeTime){ //check if can serve
      
           EventSimulator.incServe();
		   double randomTime = random.genServiceTime();
		  
           this.nextServeTime = incoming + randomTime;
		    System.out.println(arrival.getCustomer().getID()+": serve "+this.nextServeTime +" by adding a "+ randomTime);
           EventSimulator.addEvent(new Served(incoming,arrival.getCustomer(),this.id));
           EventSimulator.addEvent(new Done(this.nextServeTime,arrival.getCustomer(),this.id));
          // System.out.println("Customer served; next service @ "+ this.nextServeTime );
           return true;
       }
       else{
           return false;
       }
    
    
    }


    //returns true if successfully waits
    public boolean noWait(Event arrival){
    
        double incoming = arrival.getTime();
        if(incoming>=waitTime){ //theres no one waiting
			//assign previous servetime to next waittime
			double randomTime = random.genServiceTime();
			//System.out.println(arrival.getCustomer().getID()+": waiting tine"+this.nextServeTime);
            waitTime = this.nextServeTime;
			//add wait event counter
            EventSimulator.addWait(this.nextServeTime-incoming);
			//calculate nextsevertime including time to serve waiting
            this.nextServeTime = this.nextServeTime + randomTime;
			System.out.println(arrival.getCustomer().getID()+": waiting serve time finish"+this.nextServeTime + "by adding a  "+ randomTime);
			//assert
            EventSimulator.addEvent(new Wait(incoming,arrival.getCustomer(),this.id));
            EventSimulator.addEvent(new Served(waitTime,arrival.getCustomer(),this.id));
            EventSimulator.addEvent(new Done(this.nextServeTime,arrival.getCustomer(),this.id));


           
            EventSimulator.incServe();
            
            return true;
        }
        else{
        
            return false;
        
        }


    
    
    }
	
	public void setRandom(int seed, double lambda,double mu,double rho){
		this.random = new RandomGenerator(seed,lambda,mu,rho);
		
	}
	
	public int getID(){
		return this.id;
	}



}
