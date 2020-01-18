import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
class Parser{

    private List<String> myStringList = new ArrayList<>();

    Parser(List<String> s){
        this.myStringList = s;
    }
    public static Parser  parse(List<String> lines){
		List<String> myList = new ArrayList<String>();

        for(String s : lines){
			myList.add(s);
        }
        return new Parser(myList);
    }

    public Parser linecount(){
		List<String> myList = new ArrayList<String>();
		myList.add(myStringList.size()+"");
		 return new Parser(myList);
    }

    private Parser countWord(){
    
        List <String> mylist= new ArrayList<>();
        String[] arr =  this.toString().split("\\n?\\s");
		int count = 0;
        for(String s : arr){
            if(s.equals(""))
            {
			}
            else{
            
                count++;
            }
        }
		mylist.add(count+"");
    
        return new Parser(mylist);
    }
    public Parser wordcount(){
    
        //String[] arr = str.split("\\n?\\s");
           
                return countWord();
    
    }



    public Parser grab(String stri){
    
      
       
        List<String> list = new ArrayList<>();
        for(String s : myStringList){
        
            if(s.contains(stri))
            {
            
                list.add(s);
            }
        
        }
        return new Parser(list);
    }
	
	public Parser echo(){
		String [] arr = this.toString().split("\\n?\\s+");
		return new Parser(Stream.of(Arrays.stream(arr).map(x->  (x.equals(arr[arr.length-1]))? x : x+" ").collect(Collectors.joining())).collect(Collectors.toList()));
	}


    public Parser chop(int start,int end){
    
       
        List<String> myList = new ArrayList<>();
		if(start <= 0 ) {
			start = 1;
		}
        for(String s: myStringList )
        {
			if(s.length()<start){
				myList.add("");
			   continue;
			}
			else if(s.length()-1<end){
				 myList.add(s.substring(start-1,s.length()));
				continue;
			}
            myList.add(s.substring(start-1,end));

        
        
        
        }

        return new Parser(myList);

    
    }
	
	private String plsShuffle(String str){
	if(str.length() <= 0 || str.length()-3 < 0 ){
	 return str;
     }
	String first ="";
	String last = "";
	String temp = "";
	int start;
	int end;
	//get the first part
	boolean is_first = true;
	for(start = 0 ; start < str.length(); start++){
		char nextChar = str.charAt(start);
	    if(is_first){ //test if its first
		   first = first + nextChar;
		   if(Character.isLetter(nextChar)){
			   is_first = false; //we have found the first letter
			}	
		}
		else{ //after first
			if(Character.isLetter(nextChar)){
				break;
			}
			first = first + nextChar;
		}
	}
	 is_first = true;	
	//get the second part
	for(end=str.length()-1 ; end >=0 ; end -- ){
		char nextChar = str.charAt(end);
		 if(is_first){ //test if its first
		   last= nextChar +last;
		   
		   if(Character.isLetter(nextChar)){
				is_first = false; //we found the first letter
			}
		}
		else{//check second letter
			if(Character.isLetter(nextChar)){
				break;
			}
			last= nextChar +last;
		}
	}
	//shuffle
	for(int i = start +1; i< end +1; i++){
		temp = temp+  str.charAt(i) ;
	}

      return first + temp +str.charAt(start) + last;
}
	
	public Parser shuffle(){
    
	 List<String> myList = new ArrayList<>();
	 for(String s : myStringList){
		 String [] arr_spli = s.split("\\s+");
		 String shuffledString ="";
		 //boolean first = true;
		 int count = 0;
		 for(String word: arr_spli){
			 count++;
			word = plsShuffle(word);
			if(count==arr_spli.length){
				shuffledString = shuffledString + word ;
			}
			else{
				shuffledString = shuffledString + word  + " ";
			}
		 }
		 myList.add(shuffledString);
		// myList.add(Arrays.stream(arr_spli).map(x->plsShuffle(x)).map(x->  (x.equals(plsShuffle(arr_spli[arr_spli.length-1])))? x : x+" ").collect(Collectors.joining()));
	 }
		 return new Parser(myList);
	}

	@Override
	public String toString(){
		String s = "";
        for(int i = 0 ; i <myStringList.size();i++){
        
             if(i+1 == myStringList.size()){
            s=s+myStringList.get(i);
            }
			else{
            s=s+myStringList.get(i)+ "\n";
            }
        }
		return s;
	}

   




}
