public class Arrival extends Event{

    private static int ArrivalCount =0 ;

//    Customer c = new Customer();
   
    Arrival(){}

    Arrival(double time){
    super(time,new Customer(ArrivalCount+1));
    //c.setID(ArrivalCount);
    ArrivalCount ++;
    }

    public static int getTotalArrival(){
    
    return ArrivalCount;
    
    }

   

    @Override
    public String toString(){
    
    
        return super.getCustomer().getID() + " arrives at "+super.toString();
    
    }



}
