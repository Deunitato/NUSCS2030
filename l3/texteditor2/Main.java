import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List; 
public class Main{
	
	
	public static void main(String[] args){
		
	
		Scanner sc = new Scanner(System.in);
		
		//list of formators
			List<TextFormatter> myList = new ArrayList<>();
		    SnakeCaseFormatter snake = new SnakeCaseFormatter();
			PascalCaseFormatter pascal =new PascalCaseFormatter();
			KebabCaseFormatter kebab = new KebabCaseFormatter();
			
			//load
			myList.add(snake);
			myList.add(kebab);
			myList.add(pascal);
			TextEditor e = new TextEditor(myList);
		//=========================================
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String nextline=null;
		
		//while(!(nextline = sc.nextLine()).isEmpty()){
			// print the token
			
		while(sc.hasNext()){
			nextline = sc.nextLine();
			e.addString(nextline);
			
			//nextline = sc.next();
		}
		
		
		//Display
		 e.printAll();
		
		
		
		
		
		
	}
	
	
}