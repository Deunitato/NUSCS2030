package cs2030.simulator;
/**
 * An Done instance of the class Event
 */
public class Done extends Event{

  /**
   * Default constructor of the Done event
   * evokes the parent class Event
   * @param time, sets the time of event
   * @param c, sets the customer object
   * @param server_id, sets id of server
   */
    Done(double time,Customer c,int server_id){
      super(time,c,4,server_id);
    }
  /**
   * Return a string representation of the Done event 
   * with customer ID and the done attachement
   * Checks if id is human or selfcheck instance and print
   * accordingly
   * @return The string representation of this event
   */
    @Override
    public String toString(){
		if(super.isHuman()){
        return super.toString()+" "+ super.getCustomer() + " done serving by server "+ super.getServer();
		}
		else{
			return super.toString()+" "+ super.getCustomer()+ " done serving by self-check "+ super.getServer();
		}
    }

}
