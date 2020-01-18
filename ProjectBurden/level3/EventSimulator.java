import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
public class EventSimulator{

   private static ArrayList<Event> eventList = new ArrayList<>();

    ArrayList<Server> serverList = new ArrayList<>();
    EventSimulator(){
    serverList.add(new Server());//for pt 2
    
    }
    EventSimulator(Event e){
    
       // eventList.add(e);
       // serverList.add(new Server()); //for pt 2

    
    }
    public void addArrivals(Event e){
    
        eventList.add(e);

        tryEvent(e);
    
    }

    public void addEvent(Event e){
    
        eventList.add(e);
    
    }

    private void tryEvent(Event e){
    
        //to be changed
        Server s = serverList.get(0);
        if(s.isFree(e)){
        
        }
        else{
        
            eventList.add(new Leave(e.getTime(),e.getCustomer()));
            //System.out.println("Customer leaves");
        }


    }

    public void printAll(){
   
        Collections.sort(eventList);
        Arrival a = new Arrival();
        for(int i = 0;i<eventList.size();i++){
        System.out.println(eventList.get(i));
        
        }

        System.out.println("Number of customers: "+a.getTotalArrival());
        
    
    
    }




}
