
import java.util.Queue; 
 import java.util.LinkedList; 
 import java.util.Comparator;



public class MixedFormat extends TextFormatter{
	String str;
	String formattedStr;
	
	//Queue<String> fmStr = new LinkedList<String>();
	//ArrayList<String> fmStr = new ArrayList<String>();
	public MixedFormat(){}
	
	public MixedFormat(String str){
		
		this.str = str;
		
	}
	

	
	public void setStr(String s){
		
		this.str = s;
		this.formattedStr = this.format(); //get from format
	}
	

	@Override
	public String getFormatted(){
		//this.formattedStr=this.format();
		//this.formattedStr = fmStr.poll();
		//System.out.println("the 2:" + this.formattedStr);
		return this.formattedStr;
	}
	
	
	
	@Override
	public String format(){
		
	 String st;
     TextFormatter s;
	 int r = ((int)str.charAt(0))%3; 
  
		//create the bloody
		SnakeCaseFormatter t = new SnakeCaseFormatter("I Love CS2030");
    
		
		
		if(r==0){
			 s = new SnakeCaseFormatter(str);
	
		}
		else if(r==1){
			
	         s = new KebabCaseFormatter(str);
		}
		else{ 
			 s = new PascalCaseFormatter(str);
			
		}
		
		
		if(s.compareTo(t)<0){
			st=t.getFormatted();
		}
		else if(s.compareTo(t)>0){
			st=s.getFormatted();
		}
		else{
			st=t.getFormatted();
		}
	//this.formattedStr=s;
      
    return st;
		
		
	}
	
	
	
	
}