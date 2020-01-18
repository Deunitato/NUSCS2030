package cs2030.simulator;
/**
 * An ServerBack instance of the class Event
 */
public class ServerBack extends Event{
  /**
   * Default constructor of the Served event
   * evokes the parent class Event
   * Use a fake customer as flag for comparator
   * @param time, sets the time of event
   * @param id, sets the server id
   */
	ServerBack(double time, int id)
	{
		super(time,new Customer(-1001),6);
		super.setServerID(id);
	}
  /**
   * Return a string representation of the ServerBack event 
   * with Server id and the back attachement
   * @return The string representation of this event
   */
	@Override 
	public String toString(){
		return super.toString() + " server " + super.getServer() + " back";
	}
}