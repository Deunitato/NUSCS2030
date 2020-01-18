import java.util.Comparator;
class EventComparator implements Comparator<Event> {
	
	EventComparator(){}
	
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