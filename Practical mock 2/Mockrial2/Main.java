import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Optional;
class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Mark> MarksList = new ArrayList<>();
		//Inputs
		while(true){
				String plab = sc.next();
				if(plab.equals("end")){
					break;
				}
				studentList.add(new Student(plab,sc.next(),sc.nextInt()));
			}

		while(true){
			String plab = sc.next();
			if(plab.equals("end")){
				break;
			}
			MarksList.add(new Mark(plab,sc.nextInt()));
		}
	//========================================================
		long number_of_groups = studentList.stream()
		.map(Student::getGroup)
		.distinct()
		.count();
		
		MarksList = sortMarks(MarksList,studentList);
		
		Object[] absent = MarksList.stream()
		.filter(x-> x.getMark() == -1)
		.map(Mark::getPlab)
		.toArray();
		
		Object[] absentees = studentList.stream()
		.filter(x-> contains(absent,x.getPlab()))
		.toArray();
		
		//=====================================================
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
		
		for(int i = 0 ; i< studentList.size();i++){
			Student s = studentList.get(i);
			System.out.print(s+",");
			if(MarksList.get(i).getMark() == -1){
				System.out.println(0);
			}
			else{
				System.out.println(MarksList.get(i).getMark());
		}
	}
	
	//for absest
	System.out.println("List of absentees:");
		if(absentees.length == 0){
			System.out.println("None");
		}
		else{
			for(Object s: absentees){
				System.out.println(s);
			}
		}
	

}
	static boolean contains(Object[] arr , String plab){
		for(Object s : arr){
			if(plab.equals(s)){
				return true;
			}
		}
		return false;
		
	}
	static ArrayList<Mark> sortMarks(ArrayList<Mark> marks , ArrayList<Student> students){
			ArrayList<Mark> sortedmarks = new ArrayList<>();
			boolean added = false;
		for(Student s : students){
			for(Mark m: marks){
				if(s.getPlab().equals(m.getPlab())){
					sortedmarks.add(m);
					added = true;
					break;
				}
			}
			if(!added){
				sortedmarks.add(new Mark(s.getPlab(),-1));
				added = false;
			}
		}
		return sortedmarks;
	}
}