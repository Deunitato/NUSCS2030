public class ReLoaders extends Loader{
	
	Cruise re;
	
	public ReLoaders(int num){
		super(num);
		
		
	}
	
	//@Override 
	public boolean loadReady(Object next){
		

		if(super.loadReady(next)&& super.getPrev()!= null){
			Object o =super.getPrev();
			//System.out.println("o :"+ o);
			int Atime = ((Cruise)(o)).getTime();
			//System.out.println(o);
			//int Atime = Integer.parseInt(at);
			//int Btime = Integer.parseInt(((Cruise)next).getTime());
			int Btime =((Cruise)next).getTime();
			int A = (Atime / 100)*60 + Atime%100;
			int B = (Btime / 100)*60 + Btime%100;
			//System.out.println("1");
			//add extra
		   return (A+120) < B; //60 maintainence;
		}
		else{
			return super.loadReady(next);
		}
		
		//int timediff = ((Btime / 100)*60 + Btime%100)-((Atime / 100)*60 + Atime%100);
		
		
	}
	
	//@Override 
	public void setCruise(Object a){
		
		this.re = (Cruise)a;
		super.setCruise(a);
		
	}

	@Override 
	public String toString(){
		
		String s = "Loader " + super.getNum() + " (recycled) serves:\n    "+this.re;
		return s;
	}
	
	
}