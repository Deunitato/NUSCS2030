public class Done extends Event{

    Done(){}
    Done(double time,Customer c,int s){
      super(time,c,4,s);
    }

    @Override
    public String toString(){
    
  
      return super.toString() +" "+ super.getCustomer().getID() + " done serving by " + super.getServer();
    }

}
