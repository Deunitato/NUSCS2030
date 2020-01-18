public class Bigcruise extends Cruise{
	
	private int loadertime = 60;
	
	public Bigcruise(String name ,int time){
		
		super(name,time);
		
	}
	
	public int getLoad(){
		
		return this.loadertime;
	}
    	
	
	
	
	
	
}