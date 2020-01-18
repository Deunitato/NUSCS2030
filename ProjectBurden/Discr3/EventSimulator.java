package cs2030.simulator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;	

public class EventSimulator{

   
    private int numLeave=0;
	private double time=0.0;
    private static int numServe =0;
	private static RandomGenerator random;
    private double avg =0;
	private int numofCustomer;
    private static double waitTime =0;
    ArrayList<Server> serverList = new ArrayList<>();
	private static PriorityQueue<Event> eventList = new PriorityQueue<Event>(new EventComparator());
	private static PriorityQueue<Event> simulateList = new PriorityQueue <Event> (new EventComparator());
    public EventSimulator(){
    //serverList.add(new Server());//for pt 2
    
    }
	
	public EventSimulator(int num){
    //serverList.add(new Server());//for pt 2
	this.numofCustomer = num;
    
    }
	
	public void setRandom(int seed, double lambda,double mu,double rho){
		this.random = new RandomGenerator(seed,lambda,mu,rho);
	}
	
	
	public void addServer(Server s){
		
		serverList.add(s);
		
	}
	
    
	
	public double getServeTime(){
		return random.genServiceTime();
	}
	
	
    public void addArrivals(Event e){
    
        eventList.add(e);
		simulateList.add(e);

        //tryEvent(e);
    
    }
	
	public void simulateEvent(){
		
		for(int i=0 ; i<this.numofCustomer;i++){
        
            
            this.addArrivals(new Arrival(this.time));
			time = time +this.random.genInterArrivalTime();
        }
		
		while(!simulateList.isEmpty()){
			tryEvent(simulateList.poll());
		}
		
		
	}
	

    public void incLeave(){
    this.numLeave++;
    }

   public void incServe(){
   this.numServe++;
   
   } 

    public void addEvent(Event e){
    
        eventList.add(e);
    
    }
	
	public void addBuffer(Event e){
    
        simulateList.add(e);
    
    }
	

    public void addWait(double t){
    
        this.waitTime = this.waitTime +t;
    
    }

    private void avgWait(){
    
        this.avg= waitTime / numServe;
    
    }

    private void tryEvent(Event e){
		
		//check for wait
		if(e instanceof Served){
			
			int servernum = e.getServer();
			Server ser  = serverList.get(servernum-1);
			ser.isFree(e);
			return;
			
			
		}
		
		
	    //attempt to serve
		for(Server s: serverList){
			if(s.isFree(e)){
				return;
			}
			else{
				continue;
			}
			
			
		}
		
		//if cannot serve attempt to wait
		for(Server s: serverList){
			if(s.noWait(e)){
				return;
			}
			else{
				continue;
			}
			
			
		}
		
		//if not
		this.incLeave();
        eventList.add(new Leave(e.getTime(),e.getCustomer()));
		

    }

    public void printAll(){
   
        //Collections.sort(eventList,new EventComparator());
        Arrival a = new Arrival();
       /* for(int i = 0;i<eventList.size();i++){
        System.out.println(eventList.get(i));
        
        }*/
		
		while(eventList.size()!=0){
			System.out.println(eventList.poll());
			
		}
        

        this.avgWait();
        System.out.println("["+ String.format("%.3f",this.avg)+" "+this.numServe+" "+this.numLeave+"]");
        
    
    
    }




}
