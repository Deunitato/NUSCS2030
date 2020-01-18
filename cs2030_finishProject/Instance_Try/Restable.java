package cs2030.simulator;
/**
 * An interface for Restable Servers
 */
interface Restable{
   /** 
  * Overridable interface
  * attemps to let the server rest if possible
  * @param event , takes in an event 
  */
   void tryRest(Event e);
}