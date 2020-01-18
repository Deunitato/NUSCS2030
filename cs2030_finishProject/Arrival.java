package cs2030.simulator;
/**
 * An Arrival instance of the class Event
 */
class Arrival extends Event{
  /** The static count of Arrivals */
    private static int ArrivalCount =0 ;
  /**
   * Default constructor of the Arrival event
   */
    Arrival(){}
  /**
   * Overloaded constructor of the Arrival event
   * evokes the parent class Event
   * Set id of Customer
   * Set the arrival time of the Customer
   * Count the number of arrivals
   * @param time, sets the time of event
   * @param c, sets the customer object
   */
    protected Arrival(double time,Customer c){
    super(time,c,0);
	c.setID(ArrivalCount+1);
	c.setTime(time);
    ArrivalCount ++;
    }
  /**
   * Return a string representation of the Arrive event 
   * with customer ID and the arrives attachement
   * @return The string representation of this event
   */
    @Override
    public String toString(){
        return super.toString()+" "+super.getCustomer() + " arrives";
    }
}
