public class Try{

      double salary;
	  double rate;
	  double bankrate;

    Try(double salary, double rate,double bankrate){
    
    
        this.salary = salary;
        this.rate =rate;
        this.bankrate = bankrate;
    
    }


    public double compute(int month){
    
        double inbank=0;
   
        int j =0;
        for(int i=0;i<month;i++)
        {   j++;
            if(j>12){
			 j=0;
            this.salary = this.salary*this.rate + this.salary;
            }
			inbank=(this.salary + inbank) *(this.bankrate+1);
         }
		 
		 return inbank;

}
}
