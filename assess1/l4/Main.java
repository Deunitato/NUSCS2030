import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Read num of month*/
        int months = sc.nextInt();
		EmployeeHandler EHandler = new EmployeeHandler();
 
        /*include to read the list of banks*/
        Bank.BANKS = new Bank[4];
        for(int i =0 ; i<Bank.BANKS.length;i++){
        
            Bank.BANKS[i] = new Bank(sc.next(),sc.nextDouble());
        
        }


        SalaryAdjust adjustment = new Type1Adjustment();
        while (sc.hasNext()) {
            Employee employee = new Employee(sc.next(), sc.next(), sc.nextDouble(),adjustment);
            employee.setSalaryIncrease(sc.nextDouble());
            employee.setSavingAccount(new SavingsAccount(employee,Bank.getBankByName(sc.next())),months);
			EHandler.addEmployee(employee);
			

           // System.out.println(employee +" " + "has balance of "+ String.format("%.2f",account.compute(months)));
        }
		
		EHandler.printAll();

    }
}
