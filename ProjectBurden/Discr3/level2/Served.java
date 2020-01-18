public class Served extends Event{


    Served(){}
    Served(double time,Customer c,int s){
    super(time,c,2,s);
    }

    @Override
    public String toString(){
    
        return super.toString()+" "+ super.getCustomer().getID() + " served by "+ super.getServer();
    
    }


}
