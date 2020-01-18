import java.util.ArrayList; 
import java.util.List; 
public class TextEditor{
	private ArrayList<String> l = new ArrayList<String>();
	private List<TextFormatter> formats = new ArrayList<TextFormatter>();
	
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
			String str = l.get(i);
			for(TextFormatter f : formats){
				if(f instanceof SnakeCaseFormatter){
				((SnakeCaseFormatter)f).setStr(str);
				System.out.println(f.format());}
				
			}
			i++;
		}
		
	}
}