import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
//import java.util.Collectors;
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
/*
    private int countLines(){
    
        return str.split("\\n?\\s").length;
    
    }

    public static int linecount(){
        return new Parser(str).countLines();
    }

    private int countWord(){
    
        List <String> mylist= new ArrayList<>();
        String[] arr =  str.split("\\n?\\s");
        for(String s : arr){
        
            if(s.equals(""))
            {}
            else{
            
                mylist.add(s);
            }
        }
    
        return mylist.size();
    }
    public static int wordcount(){
    
        //String[] arr = str.split("\\n?\\s");
           
                return new Parser(str).countWord(); 
    
    }


    private String getString(){
    

    
    }
    public static String grab(String stri){
    
        String[] arr = str.split("\\n?\\s");
       
        List<String> list = new ArrayList<>();
        for(String s : arr){
        
            if(s.contains(stri))
            {
            
                list.add(s);
            }
        
        }



        return parse(list);
    
    
    
    }


    static String chop(int start,int end){
    
        String[] newString = (new String(str)).split("");
        //help;a
        List<String> myList = new ArrayList<>();
        for(String s: newString )
        {
        
            myList.add(s.substring(start,end));
            //for(int i = 0 ; i < s.length ; i++){
            
            
           // }
        
        
        
        }

        return new parse(myList);

    
    }
*/
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
