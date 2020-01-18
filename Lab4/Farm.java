package cs2030.catsanddogs;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
import cs2030.catsanddogs.IllegalInstructionException;
public class Farm{

    private ArrayList<Animal> list = new ArrayList<>();
    private ArrayList<Food> foodList = new ArrayList<>();
    public Farm(){}

    public void addAnimal(Animal a){
    list.add(a);
    }

    public void addFood(Food f){
    
    
        foodList.add(f);
    
    }
    public void readLine(String s){

       String[] info = getInfo(s);
  
	  try{
        if(info[0].equals("new")){

            if(!(info[1].equals("cat")||info[1].equals("dog"))){
            
                throw new IllegalInstructionException(info[1]+" is not a valid species");
            
            }
            else  if(info.length!=5){
            
                throw new IllegalInstructionException("Too few arguments");
            }
            else{  
         
                
                addAnimal(createAnimal(info[1],info[2],info[3],info[4]));
            }  
        
        
        }
        else if(info[0].equals("add")){
        
            if(info.length ==4){ //this is choco
                if(info[1].equals("tuna")||info[1].equals("cheese")){
                
                    throw new IllegalInstructionException("Too few arguments");
                
                }
            
                addFood(createFood(info[1],info[2],info[3]));
            }
            else{ //this is tuna or cheese
                if(info[1].equals("chocolate")){
                
                
                    throw new IllegalInstructionException("Too few arguments");
                }
				if(!(info[1].equals("cheese")||info[1].equals("tuna")))
				{
					throw new IllegalInstructionException(info[1] + " is not a valid food type");
				}
				if(info.length<3){
					throw new IllegalInstructionException("Too few arguments");
				}
 
                addFood(createFood(info[1],info[2]));
            
            }
           
        
        }
        else if(info[0].equals("eat")){
            Collections.sort(list);
            for(Animal a:list){
                
			   for(int i=0;i<foodList.size();i++){
				  if(a.eat(foodList.get(i))){
					//foodList.remove(i);
					foodList.set(i, new EmptyFood());
					
				    }
                  if(a.isFull()){
                  
                      break;
                  }
					
				}
                
                
            }
        
        }
        else if (info[0].equals("hello")){
       
            Collections.sort(list);
            for(Animal a:list){
            
                a.hello();
            }
        
        }
        else{
       // System.out.println("prbp");
        throw new IllegalInstructionException(info[0]+" is not a valid instruction");

        }
       
       }
       catch(IllegalInstructionException e){
       

      
           System.err.println(e);
       }
	   catch(Exception e){
		   
		   e.printStackTrace();
	   }
        
    
    
    } 

    private Food createFood(String type,String brand) throws IllegalInstructionException//for not choc
    {
        if(type.equals("cheese")){
        
            return new Cheese(brand);
        }
        else if(type.equals("tuna")){
        
            return new Tuna(brand);
        
        }
        else{
        
            throw new IllegalInstructionException(type+ " is not a valid food type");
        }
    
    
    }
    private Food createFood(String type,String brand,String flavour) throws IllegalInstructionException//for choco
    {
        if(type.equals("chocolate")){
        return new Choco(brand,flavour);
        
        }
        else {
        
            throw new IllegalInstructionException(type+ " is not a valid food type");
        }
    
    
    }
    private Animal createAnimal(String type,String name, String app, String extra) throws IllegalInstructionException{
    
        int a = Integer.parseInt(app);
        if(type.equals("cat")){
        
            return new Cat(name,a,extra);
        
        }
        else if(type.equals("dog")){
        
        
            return new Dog(name,a,extra);
        }
        else{
        
            throw new IllegalInstructionException(type+ "is not a valid species");
        
        }
    
    }

    private String[] getInfo(String s){
    
        String[] A = s.split("\\s+");
        return A;

    
    }





}
