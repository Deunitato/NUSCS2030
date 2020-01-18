package cs2030.simulator;
/**
 * TryWait interface for Customer implementation
 */
interface TryWait{
   /** 
  * try to make normal Customers wait
  * @return true if can wait, false if cant
  */
   boolean tryWait();
}