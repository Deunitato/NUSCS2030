package  cs2030.simulator;

public class RandomEvent extends RandomGenerator{
	
	/*RandomGenerator​(int seed,
                double lambda,
                double mu,
                double rho)*/
	
	//public RandomEvent(){}
	public RandomEvent(int seed, double lambda,double mu,double rho){
		
		super(seed,lambda,mu,rho);
					
		
	}
	
	public double getArrival(){
		return super.genInterArrivalTime();
	}
	
	public double getService(){
		return super.genServiceTime();
	}
	
	public double getRest(){
		return super.genRandomRest();
	}
	
	public double getRestperiod(){
		return super.genRestPeriod();
	}
	
	public double getCustomerType(){
		return super.genCustomerType();
	}
	
	
	
}