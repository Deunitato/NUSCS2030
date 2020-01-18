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
