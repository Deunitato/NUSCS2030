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

	
		long number_of_groups = studentList.stream()
		.map(Student::getGroup)
		.distinct()
		.count();
		
		
		//out put
		//print groups
		System.out.print("Groups("+number_of_groups+"):[");
		Object[] arr = studentList.stream()
		.map(Student::getGroup)
		.distinct()
		.sorted()
		.toArray();
		for(int i = 0; i<arr.length ; i++){
			if(i==0){
				System.out.print(arr[i]);
			}
			else{
				System.out.print(", "+ arr[i]);
			}
		}
		System.out.println("]");
		//print students
		studentList.stream().forEach(System.out::println);
		
		
		
		
	}
}