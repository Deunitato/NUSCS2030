public class Employee implements Comparable<Employee>{

    private String firstName;
    private String lastName;
    private double raise;
    private String salary;

    private double doubleSalary;
   private SalaryAdjust sa;// = new SalaryAdjust();
   private SavingsAccount savingAcc;
    


   Employee(){}
   Employee(String firstName, String lastName , double salary, SalaryAdjust sa){

    this.firstName = firstName;
    this.lastName = lastName;                              

    String s = "" + String.format("%.0f",(salary/1000)) +"K";
    this.salary = s;
    this.sa = sa;
    this.doubleSalary = salary;
   }
   
   public void setSavingAccount(SavingsAccount s,int months){
	   
	   this.savingAcc = s;
	   s.compute(months);
	   
   }

   public void setSalaryIncrease(double s){
   
       //do salary here

       double raise = s * 100;
       this.raise = raise - 100;
       sa.setRaise(this.raise); //set raise
       sa.adjust(); //adjust raise
      this.raise =  sa.getRaise(); //reset raise
   
   
   }
   
   public double getRaise(){
	   return this.raise;
   }
   
   public SavingsAccount getSavingAccount(){
	   
	   return this.savingAcc;
   }

   public double getSalary(){
   
       return doubleSalary;
   
   }
   @Override
   public int compareTo(Employee e){
	   return Double.compare(this.savingAcc.getAmount(),e.getSavingAccount().getAmount());
	   
   }

   public String toString(){
   
   return this.firstName +" " + this.lastName +": salary is " + this.salary+", annual raise is " + String.format("%.0f",this.raise) +"%"+ " has balance of " + String.format("%.2f",savingAcc.getAmount());
   
   }
}
