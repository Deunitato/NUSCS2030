public class Stats{
	private int normal;
	private int big;
	private int loaders;
	private int reload;
	
	
	
	public Stats(){
	
		this.normal = 0;
		this.big =0;
		this.loaders=0;
		this.reload =0;
		
	}
	
	
	public void setCruise(int normal, int big){
		this.normal = normal;
		this.big = big;
		
		
	}
	
	public void setEquip(int loaders,int reload){
		this.loaders = loaders;
		this.reload =reload;
		
	}
	
	
	//push all the string to the right
	public String justifyRight(int total, int given){ //total refers to the total space provided for output
		String temp = given +"";
		String star = "";
		for(int i = 0;i < (total-temp.length()) ; i++){
			star = " "+star;
			
		}
		
		return star + given;
		
	}
	public String justifyRight(int total, String given){ //total refers to the total space provided for output
		//String temp = given +"";
		String star = "";
		for(int i = 0;i < (total-given.length()) ; i++){
			star = " "+star;
			
		}
		
		return star + given;
		
	}
	
	public String justifyLeft(int total,int given){
		String temp = given +"";
		String star ="";
		for (int i =0;i<(total-temp.length()) ; i++){
		//	System.out.println(i);
			star= " " +star;
		}
		
		return given + star;
		
	}
	public String justifyLeft(int total,String given){
		//String temp = given +"";
		String star ="";
		for (int i =0;i<(total-given.length()) ; i++){
		//	System.out.println(i);
			star= " " +star;
		}
		
		return given + star;
		
	}
	
	public String statsCBuild(){
		
		//spaces provided = 4;
		
		String paddednormal = justifyRight(4,this.normal);
		String paddedbig = justifyRight(4,this.big);
		
		//this is only if number is <10 owo
		String line1 ="| Number of normal cruises   ="+paddednormal+" |\n";
		String line2 = "| Number of big cruises      ="+paddedbig+" |\n";
		return line1 +line2;
	}
	
	public String statsEBuild(){
		
		//spaces provided = 4;
		
		String paddednormal = justifyRight(4,this.loaders);
		String paddedbig = justifyRight(4,this.reload);
		
		//this is only if number is <10 owo
		String line1 ="| Number of loaders          ="+paddednormal+" |\n";
		String line2 = "| Number of recycled loaders ="+paddedbig+" |\n";
		
		return line1 + line2;
		
	}
	
	public String headerBuild(String k){
		
		int offset = 33 - k.length();
		String star = "";
		//build a string of white spaces
		for (int i =0;i<offset ; i++){
		//	System.out.println(i);
			star= star + " ";
			
		}
		
		
		String s = "+==================================+\n"+
		           "| " + k + star +"|\n"+
				   "+----------------------------------+\n";
	
	return s;
		
	}
	
	public void printCruise(Loader l){
		
		String k = "\n"+l + "+==================================+";
		System.out.print(k);
		
	}
	
	
	
	
	
	
}