public class ServerHandler{
	
	List<Server> myList = new ArrayList<Server>();
	private int numOfServe;
	Server server;
	
	ServerHandler(int numOfServe, CustomerHandler ch){
		this.server = new Server(ch);
		this.numOfServe = numOfServe;
		LoadServers();
		
	}
	
	
	//gets arrivals
	public void arrivalLoad(Customer c){
		ch.submitEvent(c.getString());
		loadCustomers(c.getString());
	}
	
	//Load servers	
	private void LoadServers(){
		for(int i = 1 ;i<=numOfServe ; i++){
			
			myList.add(new Server(i));
			
		}
		
		
	}
	
	public void loadCustomers(String arrivals){
		
		//try the first server
		for(Server s : myList){
			if(!s.isBusy()){ //current server not busy
				s.executeEvent(arrivals);
				break;
			}
			else if(!s.isWaiting()) //current server has no one waiting but is busy
			{
				s.executeEvent(arrivals);
				
			}
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}