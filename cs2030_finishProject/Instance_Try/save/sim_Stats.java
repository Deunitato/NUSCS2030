package cs2030.simulator;
/**
 * Stats Class for Calculating Stats
 */
class sim_Stats{
  /** waiting time total*/
    private static double waitTime =0;
  /** avg  waiting time*/
    private static double avg =0;
  /** number of customer served*/
    private static int numServe =0;
  /** Number of customers leaving*/
    private static int numLeave=0;
   /**====================
  *  Stats Functions
  *=======================*/
   /** 
  * inc number of customers leaving
  */	
	protected static void incLeave(){
		numLeave++;
    }
   /** 
  * @return number of customers left
  */	
   protected static int getLeave(){
		return numLeave;
	}
   /** 
  * inc number of customer served
  */
   protected static void incServe(){
		numServe++;
   } 
   /** 
  * @return number of customers served
  */	
   protected static int getServe(){
		return numServe;
	}
   /** 
  * add time waited 
  * @param t, time that customer wait
  */
    protected static void addWait(double t){
        waitTime = waitTime +t;
    }
   /** 
  * Calculates avg waiting time
  * @return avg waiting time
  */
    protected static double avgWait(){
		if(numServe==0){
		   avg = 0;
		   return avg;
		}
        avg= waitTime / numServe;
		return avg;
    }
}