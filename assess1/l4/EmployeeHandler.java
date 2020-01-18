import java.util.Collections;
import java.util.ArrayList;
public class EmployeeHandler{


    private ArrayList<Employee> EmployeeList = new ArrayList<>();

    
    EmployeeHandler(){}
   
     public void addEmployee(Employee e){
		 EmployeeList.add(e);
	 }
	
	public void printAll(){
		
		Collections.sort(EmployeeList);
		for(Employee e : EmployeeList){
			
			System.out.println(e);
			
		}
		
		
	}

    


}
