public class KebabCaseFormatter implements TextFormatter{
	String str;
	public KebabCaseFormatter(){}
	
	public KebabCaseFormatter(String str){
		
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
        // Converting space 
        // to underscor 
        if (this.str.charAt(i) == ' ') 
            s = s + '-'; 
        else
   
            s = s + 
                   Character.toLowerCase(str.charAt(i)); 
    } 
      
    return s;
		
		
	}
	
	
	
	
}