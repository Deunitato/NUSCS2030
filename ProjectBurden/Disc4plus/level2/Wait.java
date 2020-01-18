package cs2030.simulator;
public class Wait extends Event{

    Wait(){}
    Wait(double time,Customer c,int serverID){
        super(time,c,4,serverID);
     }

    @Override
    public String toString(){
    
    
        return super.toString() +" "+ super.getCustomer().getID() + " waits to be served by " + super.getServer();
    
    }
}
