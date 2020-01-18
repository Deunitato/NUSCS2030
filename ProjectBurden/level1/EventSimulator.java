import java.util.ArrayList;
import java.util.PriorityQueue;

public class EventSimulator{

    ArrayList<Event> eventList = new ArrayList<>();

    ArrayList<Server> serverList = new ArrayList<>();
    EventSimulator(){}
    EventSimulator(Event e){
    
        eventList.add(e);


    
    }
    public void addEvent(Event e){
    
        eventList.add(e);

    
    }

    public void printAll(){
   
        Arrival a = new Arrival();
        for(int i = 0;i<eventList.size();i++){
        System.out.println(eventList.get(i));
        
        }

        System.out.println("Number of customers: "+a.getTotalArrival());
        
    
    
    }




}
