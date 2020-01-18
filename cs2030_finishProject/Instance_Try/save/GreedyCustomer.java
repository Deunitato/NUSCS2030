package cs2030.simulator;
import java.util.ArrayList;
  /**
   * Flag the Customer as Greedy
   */
class GreedyCustomer extends Customer{
  /**
   * A constructor for the GreedyCustomer class.
   */
	protected GreedyCustomer(){}
   /** 
  * try to make greedy Customers wait
  * @return true if can wait, false if cant
  */
    @Override
	public boolean tryWait(){
		ArrayList<Server> clonedCopy = new ArrayList<>();
		ArrayList<Server> serverList = EventSimulator.serverList;
		for (Server obj : serverList) {
			clonedCopy.add(obj);
		}
		for(int i = 0; i<serverList.size() ; i++){	
			Server choosen = EventSimulator.scanServer(clonedCopy);
				if(choosen.noWait(this)){
					return true;
			    }
				else{
					clonedCopy.remove(choosen);
					continue;
				}
		}
		return false;
	}
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