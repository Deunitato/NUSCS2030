import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List; 
public class Main{
	
	
	public static void main(String[] args){
		
	
		Scanner sc = new Scanner(System.in);
		
		//list of formators
			List<TextFormatter> myList = new ArrayList<>();
		    SnakeCaseFormatter item1 = new SnakeCaseFormatter();
			myList.add(item1);
			TextEditor e = new TextEditor(myList);
		//=========================================
		String nextline;
		
		while(sc.hasNext()){
			nextline = sc.nextLine();
			e.addString(nextline);
			
			//nextline = sc.next();
		}
		
		
		//Display
		 e.printAll();
		
		
		
		
		
		
	}
	
	
}