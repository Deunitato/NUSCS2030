package cs2030.simulator;
import java.util.ArrayList;
/**
 * Stores infomation about Customer
 */
class Customer implements TryWait{
  /** The id of the customer */
    private int id;
  /** The Arrival time of the Customer. */
    private double arrivaltime;
  /**
   * A default constructor for the Customer class.
   */
   protected  Customer(){}
  /**
   * A Overloaded constructor for the Customer class.
   * @param  id, sets the id of the Customer
   */
	protected Customer(int id){
		this.id = id;
	}
  /**
   * A Overloaded constructor for the Customer class.
   * @param  id, sets the id of the Customer
   * @param  arrivaltime, sets the time of arrival of the Customer
   */
    protected Customer(int id,double arrivaltime){
        this.id= id;
		this.arrivaltime = arrivaltime;
    }
  /**
   * Gets the ID of the Customer
   * @return the id of the Customer
   */
    protected int getID(){
        return this.id;
    }
  /**
   * Gets the arrival time of the Customer
   * @return the arrival time of the Customer
   */
	protected double getArr(){
        return this.arrivaltime;
    }
  /**
   * Sets the ID of the Customer
   * @param id, id of the Customer
   */
	protected void setID(int id){
		this.id = id;
	}
  /**
   * Sets the arrivaltime of the Customer
   * @param time, arrival time of the Customer
   */
	protected void setTime(double time){
		this.arrivaltime = time;
	}
   /** 
  * try to make normal Customers wait
  * @return true if can wait, false if cant
  */
    @Override
	public boolean tryWait(){
		ArrayList<Server> serverList = EventSimulator.serverList;
		for(Server s: serverList){
			if(s.noWait(this)){
				return true;
			}
			else{
				continue;
			}
	    }	
	  return false;
	}
	
  /**
   * Return a string representation of a Customer
   * @return The string representation of this event
   */
	@Override 
	public String toString(){
		return ""+this.id;
	}
}
