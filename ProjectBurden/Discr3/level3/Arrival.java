package cs2030.simulator;
public class Arrival extends Event{

    private static int ArrivalCount =0 ;

//    Customer c = new Customer();
   
    Arrival(){}

    public Arrival(double time){
    super(time,new Customer(ArrivalCount+1),0);
    //c.setID(ArrivalCount);
    ArrivalCount ++;
    }

    public static int getTotalArrival(){
    
    return ArrivalCount;
    
    }

   

    @Override
    public String toString(){
    
    
        return super.toString()+" "+super.getCustomer().getID() + " arrives";
    
    }



}
