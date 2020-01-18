public class SavingsAccount{


    SavingsAccount(){}

    private Employee e= new Employee();
    private Bank b=new Bank();
    private double amount;
    SavingsAccount(Employee e,Bank b){
    
    
        this.e = e;
        this.b = b;
    
    }

    public double compute(int month){

    double bankRate = b.getRate();
	
    double salary = e.getSalary(); 

    double salRate = e.getRaise()/100;
	//System.out.println(bankRate +" ," + salary +" " +salRate);
		
		double inbank=0;
   
        int j =0;
        for(int i=0;i<month;i++)
        {   j++;
            if(j>12){
			 j = j-12;
            salary = salary*salRate + salary;
            }
			inbank=(salary + inbank) *(bankRate+1);
         }
		 
		 return inbank;
		
		
    
    }


}
