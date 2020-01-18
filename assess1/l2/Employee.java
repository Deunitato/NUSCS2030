public class Employee{

    private String firstName;
    private String lastName;
    private double raise;
    private String salary;

   private SalaryAdjust sa;// = new SalaryAdjust();
    


   Employee(String firstName, String lastName , double salary, SalaryAdjust sa){

    this.firstName = firstName;
    this.lastName = lastName;                              

    String s = "" + String.format("%.0f",(salary/1000)) +"K";
    this.salary = s;
    this.sa = sa;
   }

   public void setSalaryIncrease(double s){
   
       //do salary here

       double raise = s * 100;
       this.raise = raise - 100;
       sa.setRaise(this.raise); //set raise
       sa.adjust(); //adjust raise
      this.raise =  sa.getRaise(); //reset raise
   
   
   }

   public String toString(){
   
   return this.firstName +" " + this.lastName +": salary is " + this.salary+", annual raise is " + String.format("%.0f",this.raise) +"%";
   
   }
}
