package cs2030.simulator;
public class ServerBack extends Event{
	
	
	
	ServerBack(double time, int id)
	{
		super(time,new Customer(-1001),6);
		super.setServerID(id);
		
	}

	@Override 
	public String toString(){
		return super.toString() + " server " + super.getServer() + " back";
	}

}