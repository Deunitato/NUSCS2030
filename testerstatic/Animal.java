import java.util.ArrayList;

public class Animal{

    ArrayList<String> a = new ArrayList<>();
    Animal(){
    
    
    
    }

    public void addName(String name){
    
        a.add(name);
    
    }

    public void printAll(){
    
        for(int i = 0;i<a.size();i++){
            
            System.out.println(a.get(i));
        
        
        
        }
    
    
    }




}
