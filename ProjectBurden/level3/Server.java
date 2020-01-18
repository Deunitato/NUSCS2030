public class Server{

    EventSimulator es = new EventSimulator(new Leave());
    private double nextServeTime =0;
    Server(){}
    

    //return true if its free to do smt
    public boolean isFree(Event arrival){
    
       double incoming = arrival.getTime();
       if(incoming>=nextServeTime){ //check if can serve
      
           this.nextServeTime = incoming + 1;
           es.addEvent(new Served(incoming,arrival.getCustomer()));
          // System.out.println("Customer served; next service @ "+ this.nextServeTime );
           return true;
       }
       else{
           return false;
       }
    
    }



}
