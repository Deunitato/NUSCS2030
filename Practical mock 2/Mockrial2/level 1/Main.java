import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		while(true){
				String plab = sc.next();
				if(plab.equals("end")){
					break;
				}
				studentList.add(new Student(plab,sc.next(),sc.nextInt()));
			}
		Stream<Student> student = studentList.stream();
		int number_of_groups = student
		.map(x->getGroup())
		.distinct()
		.count();
		
		
		
		
		//out put
		System.out.println(number_of_groups);
		student.forEach(System.out::println);
		
		
		
		
	}
}