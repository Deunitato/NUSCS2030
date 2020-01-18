package cs2030.simulator;
public abstract class Event{

    private Customer c= new Customer();
    private double time;
    private int state;
	private int serverID;
   private int type;
    Event(){}
   
    Event(double time,int s){
    this.time = time;
    this.state =s;

    
    }
	Event(double time, Customer c,int s){
    
        this.time = time;
        this.c = c;
        this.state =s;
		
    
    }

    Event(double time, Customer c,int s,int server){
    
        this.time = time;
        this.c = c;
        this.state =s;
		this.serverID = server;
    
    }
	
	public int getServer(){
		
		return this.serverID;
	}

     public void setServerID(int id){
		 this.serverID = id;
	 }
    
    

    

    public double getTime(){
    
        return this.time;
    
    }
    public Customer getCustomer(){
    
    return this.c;
    
    }

    public int getState(){
     return this.state;
    
    }

    public String toString(){
    
        return String.format("%.3f",this.time);
    
    }
	
	public boolean isHuman(){
		
		if(this.serverID > EventSimulator.serverNum()){
			return false;
		}
		else{
			return true;
		}
	}
	
	/*
    @Override
    public int compareTo(Event e){
  
        if(this.time != e.getTime()){ //if both different tyime
        return Double.compare(this.time,e.getTime());
    
        }
        else if(this.c.getID()!=e.getCustomer().getID())//diff id but same time
        {
            return Integer.compare(this.c.getID(),e.getCustomer().getID());
        
        
        }
        else{ //same time and same id
        
            return Integer.compare(this.state,e.getState());
        
        }

    }*/




}
