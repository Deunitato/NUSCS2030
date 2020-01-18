package cs2030.simulator;
public class Wait extends Event{

    Wait(){}
    Wait(double time,Customer c,int serverID){
        super(time,c,4,serverID);
     }

    @Override
    public String toString(){
		
		
		//if(EventSimulator.selfCheckExist()){
		if(super.isHuman()){
        return super.toString()+" "+ super.getCustomer() + " waits to be served by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer()+ " waits to be served by self-check "+ super.getServer();
		}
		/*}
		else{
			return super.toString() +" "+ super.getCustomer().getID() + " waits to be served by " + super.getServer();
		}*/
    
    
        
    
    }
}
