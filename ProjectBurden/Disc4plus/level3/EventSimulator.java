package cs2030.simulator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import cs2030.simulator.RandomGenerator;
import java.util.Comparator;	

public class EventSimulator{

   private double restingProb;
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
	private static int serverNum;
	private static int selfCheck;
    public EventSimulator(){
   
     }
	
	public EventSimulator(int num,int servernum,int selfCheck){
	this.numofCustomer = num;
	this.serverNum = servernum;
	this.selfCheck = selfCheck;
    }
	
	public static int serverNum(){
		return serverNum;
	}
	
	public static boolean selfCheckExist(){
		return selfCheck >0 ; 
	}
	
	/**====================
	* Random Functions
	=======================*/
	
	/**
	* @param int seed. the seed of random generator
	* @param double lambda, Arrivalrate
	* @param double mu, service rate
	* @param double rho, rest rate
	*/
	public void setRandom(int seed, double lambda,double mu,double rho){
		this.random = new RandomGenerator(seed,lambda,mu,rho);
		
	}
	public double genRestRate(){
		return random.genRandomRest();
	}
	
	public double genRestPeriod(){
		return random.genRestPeriod();
	}
	/**
	* @returns random service time 
	*/
	public double getServeTime(){
		return random.genServiceTime();
	}
	
	
	/**====================
	* Add Functions
	=======================*/
	
	/**
	* @param s, takes in a server
	* @Desc add server in list
	*/
	public void addServer(Server s){
		
		serverList.add(s);
		
	}
	
	/**
	* @param , takes in an arrival event
	* @Desc Add arrival events
	*/
    public void addArrivals(Event e){
        eventList.add(e);
		simulateList.add(e);
    }
	
    public void addEvent(Event e){
        eventList.add(e);
    }
	
	public void addBuffer(Event e){
        simulateList.add(e);
    }
	
	
	/**====================
	* Stats Functions
	=======================*/
	
	public void incLeave(){
    this.numLeave++;
    }

   public void incServe(){
   this.numServe++;
   } 

    public void addWait(double t){
        this.waitTime = this.waitTime +t;
    }

    private void avgWait(){
		if(numServe==0){
		   this.avg = 0;
		   return;
		}
    
        this.avg= waitTime / numServe;
    
    }
	
	
	/**====================
	* Event simulator Functions
	=======================*/
	
	
	public void simulateEvent(){
		for(int i=0 ; i<this.numofCustomer;i++){
			this.addArrivals(new Arrival(this.time));
			time = time +this.random.genInterArrivalTime();
		}
		
		while(!simulateList.isEmpty()){
			tryEvent(simulateList.poll());
		}
	}

    private void tryEvent(Event e){
		
		//check for wait
		if(e instanceof Served){
			
			int servernum = e.getServer();
			Server ser  = serverList.get(servernum-1);
			ser.isFree(e);
			return;
			
			
		}
		
		if(e instanceof Done){
			
			int servernum = e.getServer();
			Server ser  = serverList.get(servernum-1);
			if (ser instanceof SelfCheckout){
				return;
			}
			ser.TryRest(e);
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
			Event e = eventList.poll();
			System.out.println(e);
			
			if(e instanceof Served){
				addWait(e.getTime()-e.getCustomer().getArr());
			}
			
		}
        

        this.avgWait();
        System.out.println("["+ String.format("%.3f",this.avg)+" "+this.numServe+" "+this.numLeave+"]");
        
    
    
    }




}
