public abstract class Event{

    private Customer c= new Customer();
    private double time;
    public final int ARRIVE = 0;
    public final int SERVED = 1;
    public final int DONE =3;
    public final int WAIT = 2;
    Event(){}
   
    Event(double time){
    this.time = time;

    
    }

    Event(double time, Customer c){
    
        this.time = time;
        this.c = c;
    
    }

    public Customer getCustomer(){
    
    return this.c;
    
    }

    public String toString(){
    
        return String.format("%.3f",this.time);
    
    }




}
