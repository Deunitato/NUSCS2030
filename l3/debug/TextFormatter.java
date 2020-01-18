public interface TextFormatter extends Comparable<TextFormatter>{
  // Return a formatted string
  //public int count=0;
  public abstract String format();
  public abstract String getFormatted();
  
  @Override
   public default int compareTo(TextFormatter t) 
    { 
		String s1 = t.getFormatted();
		String s2 = this.getFormatted();
		//System.out.println("1"+s1);
		//System.out.println(s2);
		int str1_sum = this.sum(s1);
        int str2_sum = this.sum(s2);

		return Integer.compare(str2_sum, str1_sum);
       
    } 
	public default int sum(String s){
		int sum=0;
		if(s==null){return 0;}
		
	
		for (int i = 0; i < s.length(); i++) { 
            sum += (int)s.charAt(i); 
        }

		
		return sum;
		
	}
	
  
  
}