package cs2030.simulator;
public class Done extends Event{

    Done(){}
    Done(double time,Customer c,int s){
      super(time,c,4,s);
    }

    @Override
    public String toString(){
		
		
	//	if(EventSimulator.selfCheckExist()){
		if(super.isHuman()){
        return super.toString()+" "+ super.getCustomer() + " done serving by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer()+ " done serving by self-check "+ super.getServer();
		}
	/*	}
		else{
			 return super.toString() +" "+ super.getCustomer().getID() + " done serving by " + super.getServer();
		}*/
    
  
      
    }

}
