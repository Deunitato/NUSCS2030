import java.util.Comparator; 
import java.util.PriorityQueue;
class Event_Comparator implements Comparator<String>{
	
	
	
	@Override
     public int compare(String str1, String str2) 
    { 
        
		
		
		
       double str1_time = getTime(str1);
	   double str2_time = getTime(str2);
	   int str1_id = getID(str1);
	   int str2_id = getID(str2);
	   
	   
	   if(str1_time<str2_time){
		   
		   return -1;
		   
	   }
	   else if(str1_time>str2_time){
		   return 1;
	   }
	   else if(str1_id<str2_id){
		   
		   return -1;
		   
		   
	   }
	    else if(str1_id>str2_id){
		   
		   return 1;
		   
		   
	   }
       
	     else if(str1.contains("done")){
		   
		   return -1;
	   }
	   else if(str2.contains("done")){
		   
		   return 1;
	   }
	   else if(str1.contains("arrives")){
		   
		   return -1;
	   }
	   else if(str2.contains("arrives")){
		   
		   return 1;
	   }
	   else {
		   return 0;
	   }
      // int s=Double.compare(first_Str,second_Str);
       //return s;
    } 
	
	
	public double getTime(String event){
		double str;
		str = Double.parseDouble(event.substring(0, 6));
		return str*100;
		
	}
	
	public int getID(String event){
		
		String s = event.substring(6, 10);
	    s = s.replaceAll("[^\\d]", "");
		int k = Integer.parseInt(s);
		return k;
	}




}