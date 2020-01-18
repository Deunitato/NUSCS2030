package cs2030.simulator;
/**
 * An Wait instance of the class Event
 */
public class Wait extends Event{
  /**
   * Default constructor of the Served event
   * evokes the parent class Event
   * @param time, sets the time of event
   * @param c, sets the customer object
   * @param server_id, sets the server id
   */
    Wait(double time,Customer c,int serverID){
        super(time,c,4,serverID);
    }
  /**
   * Return a string representation of the Wait event 
   * with customer ID and the waits to be serve attachment
   * Attached the server id
   * Checks if Event is served by human or self-check
   * @return The string representation of this event
   */
    @Override
    public String toString(){
		if(super.isHuman()){
			return super.toString()+" "+ super.getCustomer() + " waits to be served by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer()+ " waits to be served by self-check "+ super.getServer();
		}
    }
}
