package cs2030.simulator;
/**
 * Stores infomation about Customer
 */
public class Customer{
  /** The id of the customer */
    private int id;
  /** The Arrival time of the Customer. */
    private double arrivaltime;
  /**
   * A default constructor for the Customer class.
   */
    Customer(){}
  /**
   * A Overloaded constructor for the Customer class.
   * @param  id, sets the id of the Customer
   */
	Customer(int id){
		this.id = id;
	}
  /**
   * A Overloaded constructor for the Customer class.
   * @param  id, sets the id of the Customer
   * @param  arrivaltime, sets the time of arrival of the Customer
   */
    Customer(int id,double arrivaltime){
        this.id= id;
		this.arrivaltime = arrivaltime;
    }
  /**
   * Gets the ID of the Customer
   * @return the id of the Customer
   */
    public int getID(){
        return this.id;
    }
  /**
   * Gets the arrival time of the Customer
   * @return the arrival time of the Customer
   */
	public double getArr(){
        return this.arrivaltime;
    }
  /**
   * Sets the ID of the Customer
   * @param id, id of the Customer
   */
	public void setID(int id){
		this.id = id;
	}
  /**
   * Sets the arrivaltime of the Customer
   * @param time, arrival time of the Customer
   */
	public void setTime(double time){
		this.arrivaltime = time;
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
