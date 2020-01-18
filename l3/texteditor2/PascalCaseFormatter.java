public class PascalCaseFormatter implements TextFormatter{
	String str;
	public PascalCaseFormatter(){}
	
	public PascalCaseFormatter(String str){
		
		this.str = str;
		
	}
	
	public void setStr(String s){
		
		this.str = s;
		
	}
	
	
	
	@Override
	public String format(){
		
	 int n = this.str.length(); 
     String s = ""; 
  
    for (int i = 0; i < n; i++) 
    { 


		if(i==0)//first
		{
			s=s+Character.toUpperCase(str.charAt(i));


		}
        // Converting space 
        else if (this.str.charAt(i) == ' ') 
		{
			s=s+Character.toUpperCase(str.charAt(i+1));
			i++; //skip the space
		}
        else{
			 s = s + Character.toLowerCase(str.charAt(i)); 
		}
          
    } 
	//this.formattedStr=s;
      
    return s;
		
		
	}
	
	
	
	
}