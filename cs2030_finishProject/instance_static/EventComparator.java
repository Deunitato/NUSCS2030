package cs2030.simulator;
import java.util.Comparator;
/**
 * Event Comparator to compare precedence in PQueue
 */
class EventComparator implements Comparator<Event> {
  /**
   * Compares and sorts for Queue
   * @param   e1, First event to compare
   * @param   e2, Second event to compare against
   * @return  the int representation of compare 
   * Precedences priority goes to time, follow by id, then state
   */
	@Override
	public int compare(Event e1, Event e2) {
		if(e1.getTime() != e2.getTime()){ //if both different tyime
			return Double.compare(e1.getTime(),e2.getTime());
        }
        else if(e1.getCustomer().getID()!=e2.getCustomer().getID())//diff id but same time
        {
            return Integer.compare(e1.getCustomer().getID(),e2.getCustomer().getID());
        }
        else{ //same time and same id
            return Integer.compare(e1.getState(),e2.getState());
        }
	}
}