package cs2030.simulator;
/**
 * Self check out server class
 */ 
public class SelfCheckServer extends Server{
	/**
	 * Constructor for SelfCheckServer class.
	 * @param serverID The ID for the server.
	 */
	public SelfCheckServer(int serverID){
		super(serverID);
	}
	
	/**
	 * Returns a String representing the Self Check Server.
	 * @returns a String representing the Self Check Server.
	 */
	@Override
	public String toString(){
    	return "self-check " + getNumber();
	}
}