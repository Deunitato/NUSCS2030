import java.util.ArrayList;
import java.util.List;

public class ServerHandler{
	
	List<CustomerHandler> myList = new ArrayList<CustomerHandler>();
	private int numOfServe;
	boolean end = false;
	
	
	ServerHandler(int numOfServe){
		this.numOfServe = numOfServe;
		LoadServers();
		
	}
	
	
		//Load servers	
	private void LoadServers(){
		for(int i = 1 ;i<=numOfServe ; i++){
			
			myList.add(new CustomerHandler(i));
			
		}
		
		
	}
	
	
	//gets arrivals
	public void arrivalLoad(Customer c){
		loadCustomers(c.getString());
	}
	

	
	
	
	public void loadCustomers(String arrival){
		int i = 0;
		double time =getCustomer(arrival);
		int id = eventID(arrival);
		boolean fit = false;
		
		//try to fit in into servers
		for(CustomerHandler s : myList){
			if(!s.isBusy(time)){//(server not busy) 
				s.executeEvent(arrival);
				s.printEvent();
				fit = true;
				break;
				
			}
			
		}
		
		//arrival didnt get into any server
		if(fit==false){
		for(CustomerHandler s : myList){
			i++;

			if((s.isBusy(time)&&!s.isWaiting(time))){//(server is busy but no one is waiting)
				s.executeEvent(arrival);
				s.printEvent();
				break;
			}
			else if(i==numOfServe)//no more servers
			{
				System.out.println(arrival);
				s.stats("leaves");
				String t = String.format("%.3f",time);
				System.out.println(t+" "+ id + " leaves");
				break;
			}
			else //server is busy and someone is waiting but theres more servers to handle
			{
				//continue next
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