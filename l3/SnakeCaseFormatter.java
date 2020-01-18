import java.util.Queue; 
 import java.util.LinkedList; 
 import java.util.Comparator;
public class SnakeCaseFormatter extends TextFormatter{
	private String str;
	private String formattedStr;
	Queue<String> fmStr = new LinkedList<String>();
	
	
	public SnakeCaseFormatter(){}
	public SnakeCaseFormatter(String str){
		this.str = str;
		this.formattedStr = this.format();
	}
	
	
	
	public void setStr(String s){
		
		this.str = s;
		//fmStr.add(this.format());
		this.formattedStr = this.format();
	}
	
	
	
	
	
	
	@Override
	public String getFormatted(){
		//this.formattedStr=this.format();
		//this.formattedStr = fmStr.poll();
		//System.out.println("the 2:" + this.formattedStr);
		return this.formattedStr;
	}
	
	
	
	/*
	
	public int sum(String s){
		int sum=0;
		if(s==null){return 0;}
		//System.out.println("it is "+s);
	
		for (int i = 0; i < s.length(); i++) { 
            sum += (int)s.charAt(i); 
        }

		
		return sum;
		
	}
	
	
	
	@Override
   public int compareTo(TextFormatter t) 
    { 
		//System.out.println("1"+t1.getFormatted());
		//System.out.println("2"+t2.getFormatted());
		int str1_sum = this.sum(t.getFormatted());
        int str2_sum = this.sum(this.getFormatted());
        
		 if (str1_sum < str2_sum) 
		 {
					return -1; 
		 }
		else if (str1_sum > str2_sum) 
		{
			return 1; 
		}
		else{
			return 0;
		}
		
       
    } */
	
	
	
	
	
	
	
	
	
	@Override
	public String format(){
		
		int n = this.str.length(); 
       String s = ""; 
  
    for (int i = 0; i < n; i++) 
    { 
        // Converting space 
        // to underscor 
        if (this.str.charAt(i) == ' ') 
            s = s + '_'; 
        else
          
          
            s = s + 
                   Character.toLowerCase(str.charAt(i)); 
    } 
   // this.formattedStr=s;  
    return s;
		
		
	}
	
	
	
	
}