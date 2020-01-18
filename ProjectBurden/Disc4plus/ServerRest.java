package cs2030.simulator;
public class ServerRest extends Event{
	//private  final int STATE = 5;
	
	
	ServerRest(double time, int id)
	{
		super(time,new Customer(1000),5);
		super.setServerID(id);
		
	}

	@Override 
	public String toString(){
		return super.toString ()+ " server " + super.getServer() + " rest";
	}

}