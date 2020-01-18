import java.util.ArrayList;
import java.util.List;

public class ServerHandler{
	
	List<Server> myList = new ArrayList<Server>();
	private int numOfServe;
	Server server = new Server();
	boolean end = false;
	CustomerHandler ch = new CustomerHandler();
	
	ServerHandler(int numOfServe, CustomerHandler ch){
		server = new Server(ch);
		this.numOfServe = numOfServe;
		LoadServers();
		
	}
	
	
		//Load servers	
	private void LoadServers(){
		for(int i = 1 ;i<=numOfServe ; i++){
			
			myList.add(new Server(i));
			
		}
		
		
	}
	
	
	//gets arrivals
	public void arrivalLoad(Customer c){
		ch.submitEvent(c.getString());
		loadCustomers(c.getString());
	}
	

	
	
	
	public void loadCustomers(String arrivals){
		int i = 0;
		double time =getCustomer(arrivals);
		
			int id = eventID(arrivals);
		boolean fit = false;
		
		
		//fit into busy one first
		for(Server s : myList){
			if(!s.isBusy(time)||s.isFirst()){ //server idle or is the first event
				s.setFirst(false);
				s.executeEvent(time,id,"served");
				fit = true;
				break;
			}
			
			
		}
		
		if(fit ==false){
		for(Server s : myList){
			
			i++;
			if(!s.isWaiting(time)) //current server has no one waiting but is busy
			{
				s.executeEvent(time,id,"waits");
				break;
				
			}
			else if(i==numOfServe){// is busy and someone waiting and theres no more servers
				//System.out.println("llll");
				s.executeEvent(time,id,"leaves");
				break;
			}
			else { //is busy and has someone waiting
				//next server
				continue;
				
			}
			
		}
		}
		
		
		
		
	}
	
	
	
	
	
	public double getCustomer(String event){
		String s = event.substring(0, 6);
		return Double.parseDouble(s);
			}
	
	//returns the customer id for an event
	public int eventID(String event){
		String s = event.substring(6, 10);
		s = s.replaceAll("[^\\d]", "");
		int k = Integer.parseInt(s);
		return k;
	}
	
	
	
	
	

	
	
	
	
	
	
	
}