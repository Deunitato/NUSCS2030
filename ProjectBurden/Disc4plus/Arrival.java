package cs2030.simulator;
public class Arrival extends Event{

    private static int ArrivalCount =0 ;

//    Customer c = new Customer();
   
    Arrival(){}

    public Arrival(double time,Customer c){
   // super(time,new Customer(ArrivalCount+1,time),0);
    super(time,c,0);
	c.setID(ArrivalCount+1);
	c.setTime(time);
    ArrivalCount ++;
    }

    public static int getTotalArrival(){
    
    return ArrivalCount;
    
    }

   

    @Override
    public String toString(){
    
    
        return super.toString()+" "+super.getCustomer() + " arrives";
    
    }



}
