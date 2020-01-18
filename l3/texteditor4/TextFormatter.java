public abstract class TextFormatter implements Comparable<TextFormatter>{
  // Return a formatted string
  //public int count=0;
  public abstract String format();
  public abstract String getFormatted();
  @Override
   public int compareTo(TextFormatter t) 
    { 
		
		int str1_sum = this.sum(t.getFormatted());
        int str2_sum = this.sum(this.getFormatted());
       // System.out.println("1."+str1_sum);
		//System.out.println("2."+str2_sum);
		/* if (str1_sum < str2_sum) 
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
		*/

		return Integer.compare(str2_sum, str1_sum);
       
    } 
	public int sum(String s){
		int sum=0;
		if(s==null){return 0;}
		
	
		for (int i = 0; i < s.length(); i++) { 
            sum += (int)s.charAt(i); 
        }

		
		return sum;
		
	}
	
  
  
}