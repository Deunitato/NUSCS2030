package cs2030.simulator;
public abstract class Event{

    private Customer c= new Customer();
    private double time;
    public final int ARRIVE = 0;
    public final int SERVED = 2;
    public final int LEAVE = 1;
    public final int DONE =3;
    public final int WAIT = 4;
    private int state;
	private int serverID;
   
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
