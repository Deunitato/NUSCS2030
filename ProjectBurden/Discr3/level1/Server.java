public class Server{

    EventSimulator es = new EventSimulator(new Leave());
    private double nextServeTime =0;
    private double waitTime =0;
    private boolean waiting = false;
	private int id;
    Server(){}
	Server(int id){
		this.id = id;
	}
    

    //return true if its free to do smt and is successful
    public boolean isFree(Event arrival){
    
       double incoming = arrival.getTime();
       if(incoming>=nextServeTime){ //check if can serve
      
           es.incServe();
           this.nextServeTime = incoming + 1;
           es.addEvent(new Served(incoming,arrival.getCustomer(),this.id));
           es.addEvent(new Done(this.nextServeTime,arrival.getCustomer(),this.id));
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
            this.nextServeTime = this.nextServeTime + 1;
            es.addEvent(new Wait(incoming,arrival.getCustomer(),this.id));
            es.addEvent(new Served(waitTime,arrival.getCustomer(),this.id));
            es.addEvent(new Done(this.nextServeTime,arrival.getCustomer(),this.id));


           
            es.incServe();
            
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
