package cs2030.simulator;
public class Served extends Event{


    Served(){}
    Served(double time,Customer c,int s){
    super(time,c,2,s);
    }

    @Override
    public String toString(){
		
		//if(EventSimulator.selfCheckExist()){
		if(super.isHuman()){
        return super.toString()+" "+ super.getCustomer()+ " served by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer() + " served by self-check "+ super.getServer();
		}
		/*}
		else{
			 return super.toString()+" "+ super.getCustomer().getID() + " served by "+ super.getServer();
		}*/
    
    }


}
