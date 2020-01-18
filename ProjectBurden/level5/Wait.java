public class Wait extends Event{

    Wait(){}
    Wait(double time,Customer c){
        super(time,c,4);
     }

    @Override
    public String toString(){
    
    
        return super.toString() +" "+ super.getCustomer().getID() + " waits";
    
    }
}
