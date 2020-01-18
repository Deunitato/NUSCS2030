import java.util.ArrayList; 
import java.util.List; 
import java.util.PriorityQueue;
import java.util.Comparator;
public class TextEditor{
	private ArrayList<String> l = new ArrayList<String>();
	private List<TextFormatter> formats = new ArrayList<TextFormatter>();
	PriorityQueue<TextFormatter> textPriorityQueue = new PriorityQueue<TextFormatter>();
	
	public TextEditor(){
	}
	
	//list of formatters
	public TextEditor(List<TextFormatter> formatter){ 
		(this.formats).addAll(formatter);
		
	}
	
	//adds a string into the Text Editor
	public void addString(String s){
		l.add(s);
	}
	
	//to print all formatted strings.
	public void printAll(){
	int i =0;
		for(String s : l){ //through the list of strings
			//get first string
			/*String str = l.get(i);
			for(TextFormatter f : formats){
				if(f instanceof SnakeCaseFormatter)
				{
					((SnakeCaseFormatter)f).setStr(str);
					textPriorityQueue.add(f);
					//System.out.println(f.format());
				}
				else if(f instanceof KebabCaseFormatter)
				{
					((KebabCaseFormatter)f).setStr(str);
					textPriorityQueue.add(f);
					//System.out.println(f.format());
				}
				else if(f instanceof PascalCaseFormatter)
				{
					((PascalCaseFormatter)f).setStr(str);
					textPriorityQueue.add(f);
					//System.out.println(f.format());
				}
				
			}*/
			
			//just brute force
			SnakeCaseFormatter snake = new SnakeCaseFormatter(s);
			snake.setStr(s);
			textPriorityQueue.add(snake);
			KebabCaseFormatter kebab = new KebabCaseFormatter(s);
			kebab.setStr(s);
			textPriorityQueue.add(kebab);
			PascalCaseFormatter pas = new PascalCaseFormatter(s);
			pas.setStr(s);
			textPriorityQueue.add(pas);
			 
			//i++;
		}
		/*while (!textPriorityQueue.isEmpty()) { 
                System.out.println(textPriorityQueue.poll().getFormatted()); 
        } */
		
		
		while (!textPriorityQueue.isEmpty()) {
			//System.out.println("1");
            System.out.println((textPriorityQueue.poll()).getFormatted()); 
        }
		
	}
	
}