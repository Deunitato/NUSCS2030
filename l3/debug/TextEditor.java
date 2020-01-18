import java.util.ArrayList; 
import java.util.List; 
import java.util.PriorityQueue;
import java.util.Comparator;

public class TextEditor{
	private ArrayList<String> l;
	private List<TextFormatter> formats = new ArrayList<TextFormatter>();
	private PriorityQueue<TextFormatter> textPriorityQueue;
	
	public TextEditor(){
	}
	
	//list of formatters
	public TextEditor(List<TextFormatter> formatter){ 
	    this.formats = formatter;	
        this.textPriorityQueue = new PriorityQueue<TextFormatter>();
	    this.l = new ArrayList<>();
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
			String str = l.get(i);
			
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
				
			}
			 
			i++;
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
