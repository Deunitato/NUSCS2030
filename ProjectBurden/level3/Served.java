public class Served extends Event{


    Served(){}
    Served(double time,Customer c){
    super(time,c,2);
    }

    @Override
    public String toString(){
    
        return super.toString()+" "+ super.getCustomer().getID() + " served";
    
    }


}
