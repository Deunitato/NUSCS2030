public class Leave extends Event{


    Leave(){}
    Leave(double time, Customer c){
    
    super(time,c,1);
    }

    @Override
    public String toString(){
    
        return super.toString()+" "+super.getCustomer().getID() + " leaves";
    
    }


}
