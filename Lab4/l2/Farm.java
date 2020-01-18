package cs2030.catsanddogs;
import java.util.ArrayList;
public class Farm{

    private ArrayList<Animal> list = new ArrayList<>();
    public Farm(){}

    public void addAnimal(Animal a){
    list.add(a);
    }

    public void readLine(String s){
    
        String[] info = getInfo(s);
        if(info[0].equals("new")){
         addAnimal(createAnimal(info[1],info[2],info[3],info[4]));
            
        
        }
        else{
        System.out.println("prbp");
        
        }
        
    
    
    } 

    private Animal createAnimal(String type,String name, String app, String extra){
    
        int a = Integer.parseInt(app);
        if(type.equals("cat")){
        
            return new Cat(name,a,extra);
        
        }
        else if(type.equals("dog")){
        
        
            return new Dog(name,a,extra);
        }
        else{
        
            return new Cat();
        
        }
    
    }

    private String[] getInfo(String s){
    
        String[] A = s.split("\\s+");
        return A;

    
    }





}
