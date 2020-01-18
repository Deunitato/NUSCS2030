package cs2030.simulator;
public class HumanServer{
    /**
     * The probability of the server resting.
     */
	private static double restProbability;
	
    /**
     * The random function for generating probability of the server resting.
     */
	private static DoubleSupplier genRandomRest;
	
    /**
     * The random function for generating rest time.
     */
	private static DoubleSupplier genRestTime;
	
	/**
 	  * Constructor for HumanServer Class. 
 	  * @param serverID ID of the server. 
      */
	public HumanServer(int serverID){
		super(serverID);
	}
	
    /**
     * Sets the probability of the server resting.
     */
	public static void setRestProbability(double restProbability){
		this.restProbability= restProbability;
	}
	
    /**
     * Sets the probability function for generating probability of the server resting.
     */
	public static void setGenRandomRest(DoubleSupplier genRandomRest){
		this.genRandomRest= genRandomRest;
	}	
	
    /**
     * Sets rest period probability function.
     */
	public static void setGenRestPeriod(DoubleSupplier genRestPeriod){
		this.genRestPeriod= genRestPeriod;
	}
	
    /**
     * Checks if the server needs to rest.
     */
	public boolean checkRest(){
		return 	genRandomRest.getAsDouble() > restProbability;
	}
	
    /**
     * Lets the server rest
     */
    public void rest(Customer customer){
        //Handle the customer?
        time = time + genRestPeriod.getAsDouble();
    }
    	
	/**
	 * Returns a String representing the Human Server
	 * @returns a String representing the Human Server.
	 */
	@Override
	public String toString(){
    	return "server " + getNumber();
	}
}