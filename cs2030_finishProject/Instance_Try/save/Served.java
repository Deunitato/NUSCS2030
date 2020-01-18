package cs2030.simulator;
/**
 * An Served instance of the class Event
 */
class Served extends Event{
  /**
   * Default constructor of the Served event
   * evokes the parent class Event
   * @param time, sets the time of event
   * @param c, sets the customer object
   * @param server_id, sets the server id
   */
    protected Served(double time,Customer c,int server_id){
		super(time,c,2,server_id);
    }
   /** 
  * handles served events
  */
    @Override
	public void tryEvent(){
		int servernum = super.getServer();
		Server ser  = EventSimulator.serverList.get(servernum-1);
		ser.isFree(this);
		return;
	}
  /**
   * Return a string representation of the Served event 
   * with customer ID and the Served attachement
   * Checks if server used in event is Human or
   * Self checkout and print accordingly
   * @return The string representation of this event
   */
    @Override
    public String toString(){
		if(super.isHuman()){
			return super.toString()+" "+ super.getCustomer()+ " served by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer() + " served by self-check "+ super.getServer();
		}
    }
}
