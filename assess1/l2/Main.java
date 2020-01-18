import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SalaryAdjust adjustment = new Type1Adjustment();
        while (sc.hasNext()) {
            Employee employee = new Employee(sc.next(), sc.next(), sc.nextDouble(),adjustment);
            employee.setSalaryIncrease(sc.nextDouble());
            System.out.println(employee);
        }
    }
}
