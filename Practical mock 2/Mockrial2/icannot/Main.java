import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Mark> marksList = new ArrayList<>();
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
			marksList.add(new Mark(plab,sc.nextInt()));
		}
	//========================================================
	
	 List<Integer> tutorialList = studentList.stream().map(x-> x.getGroup()).distinct().sorted().collect(Collectors.toList());
	long Gcount = count(tutorialList);
	List<Student> absentees= new ArrayList<>();
	
	//=================================
	System.out.println("Groups("+Gcount +"):" + tutorialList);
	for(Student s: studentList){
		System.out.print(s+",");
		String plab = s.getPlab();
		int score = marksList.stream().filter(x-> x.getPlab().equals(plab)).map(x-> x.getMark()).findFirst().orElse(0);
		System.out.println(score);
		//get absentees
		

		if(marksList.stream().filter(x->x.getPlab().equals(plab)).findFirst().isPresent()){}
		else{
			absentees.add(s);
		}
		
	}
	//stage 4
	System.out.println("List of absentees:");
	if(absentees.isEmpty()){
		System.out.println("None");
	}
	else{
		for(Student s: absentees){
			System.out.println(s);
		}
	}
	//stage 5
	int max = marksList.stream().map(x-> x.getMark()).max(Integer::compare).get();
	int min = marksList.stream().map(x-> x.getMark()).min(Integer::compare).get();
	System.out.println("Mark frequency from "+min+" to "+max);
	IntStream.rangeClosed(min,max).forEach(x->{
			System.out.print(x+" : ");
			long count = marksList.stream().filter(y-> (y.getMark() == x)).count();
			System.out.println(count);
			
			
		});
		
	//stage 6
	for(int num : tutorialList){
		
		List <String> plabsList = studentList.stream().filter(x-> (x.getGroup() == num)).map(x-> x.getPlab()).collect(Collectors.toList());
		List<Mark> tutorialMark = marksList.stream().filter(x->{
			if(plabsList.cont ains(x.getPlab())){
				return true;
			}
			else{
				return false;
			}
		}).collect(Collectors.toList());
		
		if(tutorialMark.size()==0){
			continue;
		}
		System.out.println("Group #"+num+"...Mark frequency from "+min+" to "+max);
		IntStream.rangeClosed(min,max).forEach(x->{
			System.out.print(x+" : ");
			long count = tutorialMark.stream().filter(y-> (y.getMark() == x)).count();
			System.out.println(count);
			
			
		});
		
		
	   

		
	}
	

	
		
	}
	

	
	static long count(List<Integer> myList){
		return myList.stream().count();
	}
}