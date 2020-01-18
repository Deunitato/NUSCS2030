package cs2030.simulator;
/**
 * An ServerRest instance of the class Event
 */
 class ServerRest extends Event{
  /**
   * Default constructor of the Served event
   * evokes the parent class Event
   * @param time, sets the time of event
   * @param c, sets the customer object
   * @param server_id, sets the server id
   */
	protected ServerRest(double time, int id)
	{
		super(time,new Customer(1000),5);
		super.setServerID(id);
	}
  /**
   * Return a string representation of the ServerRest event 
   * with Serevr ID and the rest attachement
   * @return The string representation of this event
   */
	@Override 
	public String toString(){
		return super.toString ()+ " server " + super.getServer() + " rest";
	}
}