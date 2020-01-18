public class Employee{

    private String firstName;
    private String lastName;
    private double raise;
    private String salary;



   Employee(String firstName, String lastName , double salary){

    this.firstName = firstName;
    this.lastName = lastName;                              

    String s = "" + String.format("%.0f",(salary/1000)) +"K";
    this.salary = s;
   }

   public void setSalaryIncrease(double s){
   
       //do salary here

       double raise = s * 100;
       this.raise = raise - 100;
   
   
   }

   public String toString(){
   
   return this.firstName +" " + this.lastName +": salary is " + this.salary+", annual raise is " + String.format("%.0f",this.raise) +"%";
   
   }
}
