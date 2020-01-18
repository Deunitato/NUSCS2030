package cs2030.simulator;
public class Server{

    EventSimulator es = new EventSimulator();
    private double nextServeTime =0;
    private double waitTime =0;
    private boolean waiting = false;
	private int id;
	private Customer waitingCustomer;
	//private event 
    Server(){}
	public Server(int id){
		this.id = id;
	}
    

    //return true if its free to do smt and is successful
    public boolean isFree(Event event){
    
	//System.out.println(es.getServeTime());
       double incoming = event.getTime();
       if(incoming>=nextServeTime){ //check if can serve
      
           es.incServe();
		   double randomTime = es.getServeTime();
		   
           this.nextServeTime = incoming + randomTime;
           es.addEvent(new Served(incoming,event.getCustomer(),this.id));
           es.addEvent(new Done(this.nextServeTime,event.getCustomer(),this.id));
          // System.out.println("Customer served; next service @ "+ this.nextServeTime );
           return true;
       }
       else{
           return false;
       }
    
    
    }


   //returns true if theres no one waiting
    public boolean noWait(Event arrival){
    
        double incoming = arrival.getTime();
        if(incoming>=waitTime){ //theres no one waiting
            waitTime = this.nextServeTime;
            es.addWait(this.nextServeTime-incoming);
            //this.nextServeTime = this.nextServeTime + es.getServeTime();
            es.addEvent(new Wait(incoming,arrival.getCustomer(),this.id));
            es.addBuffer(new Served(waitTime,arrival.getCustomer(),this.id));
            //es.addEvent(new Done(this.nextServeTime,arrival.getCustomer(),this.id));
      // add the new served event to newqueue too

           
            
            
            return true;
        }
		else{
			return false;
		}
	}
	
	public int getID(){
		return this.id;
	}



}
