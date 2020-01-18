public class Done extends Event{

    Done(){}
    Done(double time,Customer c){
      super(time,c,4);
    }

    @Override
    public String toString(){
    
  
      return super.toString() +" "+ super.getCustomer().getID() + " done";
    }

}
