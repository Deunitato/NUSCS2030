package cs2030.simulator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import cs2030.simulator.RandomGenerator;
import java.util.Comparator;	

public class EventSimulator{

	private double greedyProb;
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
	
	/**====================
	* Constuctors 
	=======================*/
	/**
    * @Desc default constructor
	*/
    public EventSimulator(){}
	
	/**
	* @param int num. the number of customer
	* @param int servernum, number of server
	* @param int selfCheck, number of self check servers
	* @param double greedprob, the probability that a greedy customer will spawn
	*/
	public EventSimulator(int num,int servernum,int selfCheck,double greedprob){
	this.numofCustomer = num;
	this.serverNum = servernum;
	this.selfCheck = selfCheck;
	this.greedyProb = greedprob;
    }
	
	
	/**====================
	* Boolean Functions
	=======================*/
	
	/**
	* @returns Server number
	*/
	public static int serverNum(){
		return serverNum;
	}
	
	/**
	* @returns true if selfcheck exist
	*/
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
	
	/**
	* @returns random Rest Rate
	*/
	public double genRestRate(){
		return random.genRandomRest();
	}
	
	/**
	* @returns random rest Period
	*/
	public double genRestPeriod(){
		return random.genRestPeriod();
	}
	/**
	* @returns random service time 
	*/
	public double getServeTime(){
		return random.genServiceTime();
	}
	
	
	/**
	* @returns Random Customer (Greedy or Typical)
	*/
	public Customer genCustomer(){
		if(random.genCustomerType()<this.greedyProb){ //generate a greedy
			return new GreedyCustomer();
		}
		else{
			return new Customer();
		}
		
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
	* @param e , takes in an arrival event
	* @Desc Add arrival events
	*/
    public void addArrivals(Event e){
        eventList.add(e);
		simulateList.add(e);
    }
	/**
	* @param e , takes in an event
	* @Desc Add events to PQ
	*/
    public void addEvent(Event e){
        eventList.add(e);
    }
	/**
	* @param e , takes in an event
	* @Desc Add events to Buffer Queue
	*/
	public void addBuffer(Event e){
        simulateList.add(e);
    }
	
	
	/**====================
	* Stats Functions
	=======================*/
	
	/**
	* @Desc Increases number of customers who left
	*/
	public void incLeave(){
    this.numLeave++;
    }
	/**
	* @Desc Increases number of customers who was served
	*/
   public void incServe(){
   this.numServe++;
   } 
	/**
	* @param t, time needed to be added
	* @Desc Increases wait time
	*/
    public void addWait(double t){
        this.waitTime = this.waitTime +t;
    }

	/**
	* @Desc Calculates the Average serve time
	*/
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
	
	/**
	* @Desc Simulate events
	*/
	public void simulateEvent(){
		for(int i=0 ; i<this.numofCustomer;i++){
			Customer c = genCustomer(); //determine if greedy or not
			this.addArrivals(new Arrival(this.time,c));
			time = time +this.random.genInterArrivalTime();
		}
		
		while(!simulateList.isEmpty()){
			tryEvent(simulateList.poll());
		}
	}

	/**
	* @Desc Handles event excecution
	*/
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
		if(e.getCustomer() instanceof GreedyCustomer){
			ArrayList<Server> clonedCopy = new ArrayList();
			for (Server obj : serverList) {
			
			    clonedCopy.add(obj);
				
			}
			
			for(int i = 0; i<serverList.size() ; i++){	
				Server choosen = scanServer(clonedCopy);
				 if(choosen.noWait(e)){
					 return;
				 }
				 else{
					 clonedCopy.remove(choosen);
					 continue;
				 }
			}
		
			
		
		}
		else if(e.getCustomer() instanceof Customer){
			
			for(Server s: serverList){
				if(s.noWait(e)){
					return;
				}
				else{
					continue;
				}
		    }
		}
		
		//if not leave
		this.incLeave();
        eventList.add(new Leave(e.getTime(),e.getCustomer()));
    }
	
	/**
	* @param ArrayList list , a copy of the original server list
	* @return Server choosen , server in the list with most empty queue
	* @Desc Helper function for tryEvents, return the most empty queue
	*/
	public Server scanServer(ArrayList<Server> list){
		Server choosen = serverList.get(0);
		int temp;
		for(Server s: list){
			temp = s.getQueueSize();
	     	if(temp<choosen.getQueueSize()){
				choosen = s;
			}
			else{
				continue;
			}
		}
		return choosen;
		
	}
	
	

	/**
	* @Desc Prints out events and does stats
	*/
    public void printAll(){
   
        Arrival a = new Arrival();
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
