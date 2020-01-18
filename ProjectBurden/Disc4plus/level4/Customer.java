package cs2030.simulator;
public class Customer{

    private int id;
    private double arrivaltime;

    Customer(){}
	Customer(int id){
		this.id = id;
	}
    Customer(int id,double arrivaltime){
    
        this.id= id;
		this.arrivaltime = arrivaltime;
    
    }
    public int getID(){
    
        return this.id;
    
    }
	 public double getArr(){
    
        return this.arrivaltime;
    
    }
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setTime(double time){
		
		this.arrivaltime = time;
		
	}

	@Override 
	public String toString(){
		return ""+this.id;
	}
    
    



}
