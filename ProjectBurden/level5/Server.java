public class Server{

    EventSimulator es = new EventSimulator(new Leave());
    private double nextServeTime =0;
    private double waitTime =0;
    private boolean waiting = false;
    Server(){}
    

    //return true if its free to do smt
    public boolean isFree(Event arrival){
    
       double incoming = arrival.getTime();
       if(incoming>=nextServeTime){ //check if can serve
      
           es.incServe();
           this.nextServeTime = incoming + 1;
           es.addEvent(new Served(incoming,arrival.getCustomer()));
           es.addEvent(new Done(this.nextServeTime,arrival.getCustomer()));
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
            es.addEvent(new Wait(incoming,arrival.getCustomer()));
            es.addEvent(new Served(waitTime,arrival.getCustomer()));
            es.addEvent(new Done(this.nextServeTime,arrival.getCustomer()));


           
            es.incServe();
            
            return true;
        }
        else{
        
            return false;
        
        }


    
    
    }



}
