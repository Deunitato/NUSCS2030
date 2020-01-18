import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
class Main {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<>();
		ArrayList<Integer> myGroups = new ArrayList<>();
		ArrayList<Mark> MarksList = new ArrayList<>();
		ArrayList<Student> absenteeList = new ArrayList<>();
		ArrayList<Object[]> participationList = new ArrayList<>();
		int minimum=0;
		int maximum =0;
			//input
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
			
			//===============================================================
			//convert a hash to array
			myGroups=new ArrayList<>(getSet( studentList));
			Collections.sort(myGroups);
			participationList = getParticipants(MarksList,studentList);
			absenteeList = getAbsentee(MarksList,studentList);
			minimum = getMin(MarksList);
			maximum = getMax(MarksList);
			MarksList = getSortedMarks(MarksList,studentList); //get sorted
			
			  
			
			

			//==============================================================
			//======================output================================
			
			//============================
			// print group
			//============================
			System.out.print("Groups("+ myGroups.size() + "):[");
			String s = ""+ myGroups.get(0);
			for(int i = 1 ; i<myGroups.size() ; i++){
				s=s+", "+myGroups.get(i);
			}
			System.out.println(s+"]");
			//============================
			// print students
			//============================
			for(int i = 0 ; i<studentList.size() ; i++){
				System.out.println(studentList.get(i)+"," + MarksList.get(i).getMark());
			}
			//============================
			// print absent
			//============================
			System.out.println("List of absentees:");
			if(absenteeList.size()==0){
				System.out.println("None");
			}
			else{
				for(Student stu : absenteeList){
					System.out.println(stu);
				}
			}
			//============================
			// print marks
			//============================
			System.out.println("Mark frequency from " + minimum + " to " + maximum);
			for(int i = minimum; i<=maximum ; i++){
				System.out.println(getFreq(i,participationList));
			}
			
			for(int groupNum :myGroups){
				if(classAttend(groupNum,participationList)){
				System.out.println("Group #"+groupNum+"...Mark frequency from " + minimum + " to " + maximum);
					for(int i = minimum; i<=maximum ; i++){
						String stri = getGroupFreq(i,groupNum,participationList);
						System.out.println(stri);
					}
				}
			else{
				continue;
				
			}
			}
			
			
	}
	
	public static boolean classAttend(int groupNum,ArrayList<Object[]> objectList){
		boolean attend = false;
		for(Object[] ob : objectList){
			Student stu = (Student)ob[0];
			if(stu.getGroup()==groupNum){
				 attend = true;
			}	
			
		}
		return attend;
	}
	
	public static String getGroupFreq(int num,int groupNum,ArrayList<Object[]> objectList){
		ArrayList<Object[]> list = new ArrayList<>();
		for(Object[] ob : objectList){
			Student stu = (Student)ob[0];
			if(stu.getGroup()==groupNum){
				list.add(ob);
			}	
		}

		
		return getFreq(num,list);
		
	}
	
	public static String getFreq(int num,ArrayList<Object[]> objectList){
		int count = 0;
		for(Object o[] : objectList){
			Mark m = (Mark)o[1];
			if(m.getMark() == num){
				count ++ ;
			}
		}
		return num + " : " + count;
	}
	
	public static int getMin(ArrayList<Mark> markList){
		int min= markList.get(0).getMark();
		for(Mark m : markList){
			if(min> m.getMark()){
				min = m.getMark();
			}
		}
		return min;
	}
	
	public static int getMax(ArrayList<Mark> markList){
		int max= 0;
		for(Mark m : markList){
			if(max< m.getMark()){
				max = m.getMark();
			}
		}
		return max;
	}
	
	public static ArrayList<Student> getAbsentee(ArrayList<Mark> markList,ArrayList<Student> studentList){
		ArrayList<Student> absent = new ArrayList <>();
		boolean isAdded = false;
		for(Student stu : studentList){
			for(Mark m : markList){ //scan trhough the entire marks list to see if exist
				if(m.getPlab().equals(stu.getPlab())){
					isAdded=true;
					break;
				}
			}
			if(!isAdded){ //if the marks were not added(student was absent)
				absent.add(stu);
			}
			isAdded = false;
		}
		return absent;
		
	}
	
	
	public static ArrayList<Object[]> getParticipants(ArrayList<Mark> markList,ArrayList<Student> studentList){
		ArrayList<Object[]> list = new ArrayList<>();
		for(Student stu : studentList){
			for(Mark m : markList){ //scan trhough the entire marks list to see if exist
				if(m.getPlab().equals(stu.getPlab())){
				    Object[] o = new Object[2];
					o[0]= stu;
					o[1]= m;
					list.add(o);
					break;
				}
			}
		}
		return list;
		
	}
	
	
	public static ArrayList<Mark> getSortedMarks(ArrayList<Mark> markList,ArrayList<Student> studentList){
		ArrayList<Mark> marks = new ArrayList<>();
		boolean isAdded = false;
		for(Student stu : studentList){
			for(Mark m : markList){ //scan trhough the entire marks list to see if exist
				if(m.getPlab().equals(stu.getPlab())){
					marks.add(m);
					isAdded=true;
					break;
				}
			}
			if(!isAdded){ //if the marks were not added(student was absent)
				marks.add(new Mark(stu.getPlab(),0));
			}
			isAdded = false;
		}
		return marks;
	}
	
	public static HashSet<Integer> getSet(ArrayList<Student> list){
		HashSet<Integer> set = new HashSet<>();
		for(Student stu: list){
			if(!set.contains(stu.getGroup())){
				set.add(stu.getGroup());
			}
		}
		return set;
	}
}