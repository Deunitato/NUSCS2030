package cs2030.simulator;
/**
 * An Leave instance of the class Event
 */
class Leave extends Event{
  /**
   * Default constructor of the Leave event
   * evokes the parent class Event
   * @param time, sets the time of event
   * @param c, sets the customer object
   */
    protected Leave(double time, Customer c){
    super(time,c,1);
    }
  /**
   * Return a string representation of the Leave event 
   * with customer ID and the leave attachement
   * @return The string representation of this event
   */
    @Override
    public String toString(){
        return super.toString()+" "+super.getCustomer() + " leaves";
    }
}
