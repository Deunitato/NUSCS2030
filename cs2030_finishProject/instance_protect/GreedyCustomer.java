package cs2030.simulator;
  /**
   * Flag the Customer as Greedy
   */
class GreedyCustomer extends Customer{
  /**
   * A constructor for the GreedyCustomer class.
   */
	protected GreedyCustomer(){}
  /**
   * Return a string representation of the customer 
   * with the attachment (Greedy)
   * @return The string representation of this customer
   */
	@Override 
	public String toString(){
		return super.toString()+"(greedy)";
	}

}