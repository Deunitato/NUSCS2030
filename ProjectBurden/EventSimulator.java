import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
public class EventSimulator{

   private static ArrayList<Event> eventList = new ArrayList<>();

    private int numLeave=0;
    private static int numServe =0;
    private double avg =0;
    private static double waitTime =0;
    ArrayList<Server> serverList = new ArrayList<>();
    EventSimulator(){
    //serverList.add(new Server());//for pt 2
    
    }
	
	public void addServer(Server s){
		
		serverList.add(s);
		
	}
	
    EventSimulator(Event e){
    
       // eventList.add(e);
       // serverList.add(new Server()); //for pt 2

    
    }
    public void addArrivals(Event e){
    
        eventList.add(e);

        tryEvent(e);
    
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

    public void addWait(double t){
    
        this.waitTime = this.waitTime +t;
    
    }

    private void avgWait(){
    
        this.avg= waitTime / numServe;
    
    }

    private void tryEvent(Event e){
		
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
		
		
    
        //to be changed
       /* Server s = serverList.get(0);
        if(s.isFree(e)){
              
        }
        else if(s.noWait(e)) //tries wait
        {
         
        }
        else{
       
            this.incLeave();
            eventList.add(new Leave(e.getTime(),e.getCustomer()));
            //System.out.println("Customer leaves");
        }*/


    }

    public void printAll(){
   
        Collections.sort(eventList);
        Arrival a = new Arrival();
        for(int i = 0;i<eventList.size();i++){
        System.out.println(eventList.get(i));
        
        }
        

        this.avgWait();
        System.out.println("["+ String.format("%.3f",this.avg)+" "+this.numServe+" "+this.numLeave+"]");
        
    
    
    }




}
