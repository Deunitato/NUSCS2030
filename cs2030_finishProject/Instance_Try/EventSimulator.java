package cs2030.simulator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import cs2030.simulator.RandomGenerator;
import java.util.Comparator;	
/**
 * Simulates events
 */
public class EventSimulator{
  /** Probability for greedy customer*/
	private double greedyProb;
  /** Probability for server resting*/
    private double restingProb;
  /** arrival time clock*/
	private double time=0.0;
  /** Random generator*/
	private static RandomGenerator random;
  /** number of customer*/
	private int numofCustomer;
  /** my list of servers*/
    protected static ArrayList<Server> serverList = new ArrayList<>();
  /** Event queue for printing*/
	private static PriorityQueue<Event> eventList = new PriorityQueue<Event>(new EventComparator());
  /** Buffer event queue for execution*/
	private static PriorityQueue<Event> simulateList = new PriorityQueue <Event> (new EventComparator());
  /** number of normal servers*/
	private static int serverNum;
  /** number of selfcheck servers*/
	private static int selfCheck;
  /**
   * A Default constructor for the Event Simulator class.
   */
    public EventSimulator(){}
  /**
   * A Overloaded constructor for the Event Simulator class.
   * @param num, number of customer
   * @param  servernum, total number of server
   * @param selfCheck, number of self check
   * @param greedprob, set the probability of greedy customer
   */
	public EventSimulator(int num,int servernum,int selfCheck,double greedprob){
		this.numofCustomer = num;
		this.serverNum = servernum;
		this.selfCheck = selfCheck;
		this.greedyProb = greedprob;
    }
   /** 
  * returns the number  of servers
  * Necessary to check for server type
  * human or selfcheck
  * @return servers amt
  */
	protected static int serverNum(){
		return serverNum;
	}
   /**====================
  * Random Gen Functions
  *======================*/
   /**
  * sets the random generators para
  * @param int seed. the seed of random generator
  * @param double lambda, Arrivalrate
  * @param double mu, service rate
  * @param double rho, rest rate
  */
	public void setRandom(int seed, double lambda,double mu,double rho){
		this.random = new RandomGenerator(seed,lambda,mu,rho);
	}
   /**
  * generates rest rate
  * @return random generated rest rates
  */
	protected static double genRestRate(){
		return random.genRandomRest();
	}
   /**
  * generates rest period
  * @return random generated rest period
  */	
	protected static double genRestPeriod(){
		return random.genRestPeriod();
	}
	/**
	* generates random service time
	* @return random service time 
	*/
	protected static double getServeTime(){
		return random.genServiceTime();
	}
   /**
  * generates customers 
  * @return greedy or normal customer
  */
	protected Customer genCustomer(){
		if(random.genCustomerType()<this.greedyProb){ //generate a greedy
			return new GreedyCustomer();
		}
		else{
			return new Customer();
		}
	}
   /**====================
  *  Load/add Functions
  *======================*/
   /**
  * adds server into server list
  * @param s , takes in an server
  */
	public void addServer(Server s){
		serverList.add(s);
	}
   /**
  * adds arrival event into events list
  * @param e , takes in an arrival event
  */
    protected void addArrivals(Event e){
        eventList.add(e);
		simulateList.add(e);
    }
   /**
  * adds  event into events list
  * events here are only printable
  * @param e , takes in an arrival event
  */
    protected static void addEvent(Event e){
        eventList.add(e);
    }
   /**
  * adds event into buffer
  * events to be executed
  * @param e , takes in an arrival event
  */
	protected static void addBuffer(Event e){
        simulateList.add(e);
    }

   /**====================
  *  Event simulator Functions
  *======================*/
   /** 
  * The main method for simulating event
  * Starts the event simulator
  */
	public void simulateEvent(){
		for(int i=0 ; i<this.numofCustomer;i++){
			Customer c = genCustomer(); //determine if greedy or not
			this.addArrivals(new Arrival(this.time,c)); //stuff the arrivals
			time = time +this.random.genInterArrivalTime();
		}
		while(!simulateList.isEmpty()){ //my clock for event simulator
			Event e = simulateList.poll();
				e.tryEvent();
		}
	}
   /** 
  * try to serve incoming customers
  * attempt to serve free befor waiting
  * handles greedy and normal customers
  * makes the customer leave if cannot serve
  * @param event , takes in an event 
  */
	protected static void tryServe(Event e){
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
		if(e.getCustomer().tryWait()){
           return;
		}
		//leave event
		sim_Stats.incLeave(); //inc leave counter
        eventList.add(new Leave(e.getTime(),e.getCustomer()));
	}	
   /** 
  * Helper class for Greedy Customer
  * Checks a list of servers for server with
  *  smallest queue size
  * @param list, list of servers
  * @return the server with the smallest queue size
  */
	protected static Server scanServer(ArrayList<Server> list){
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
  *  Prints all happenings of event simulator
  *  Calculates avg wait and print pq
  */
    public void printAll(){
		while(eventList.size()!=0){
			Event e = eventList.poll();
			System.out.println(e);
			if(e instanceof Served){
				sim_Stats.addWait(e.getTime()-e.getCustomer().getArr());
			}
		}
        double avg = sim_Stats.avgWait();
        System.out.println("["+ String.format("%.3f",avg)+" "+sim_Stats.getServe()+" "+sim_Stats.getLeave()+"]");
    }
}
