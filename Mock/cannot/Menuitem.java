import java.util.Comparator;

public class Menuitem implements Comparable<Menuitem>{
    private String type;
    private String desc;
    private int id;
    private int cost=0;
    
    Menuitem(){}
    Menuitem(int i){
    this.id = i;
    
    }    
     
    Menuitem(String type,String desc,int cost,int id){
    this.type = type;
    this.desc = desc;
    this.cost= cost;
    this.id = id; 
    
    }
    public void addCost(int cost){
    this.cost  = this.cost +cost;
    
    }
    public int getCost(){
    return this.cost;
    }
    public String getType(){
        return this.type;
    
    }

    public int getID(){
     return this.id;
    }

	
	

   /* @Override
    public int compareTo(Menuitem i){
    
       if(this.getType().equals("Burger")&&i.getType().equals("Burger")){
            return Integer.compare(this.getID(),i.getID());
       } 
       else if(this.getType().equals("Burger")){
        return -1;
       }
       else if(i.getType().equals("Burger")){
        return 1;
       }
       else if(this.getType().equals("Snack")&&i.getType().equals("Snack")){   
            return Integer.compare(this.getID(),i.getID());                 
            } 
        else if(this.getType().equals("Snack")){
            return -1;
             }
        else if(i.getType().equals("Snack")){
          return 1;
            }
		  else if(this.getType().equals("Drink")&&i.getType().equals("Drink")){   
            return Integer.compare(this.getID(),i.getID());                 
            } 
        else if(this.getType().equals("Drink")){
            return -1;
             }
        else if(i.getType().equals("Drink")){
          return 1;
            }	
			
        else {
        
        return Integer.compare(this.getID(),i.getID());
        }
    }*/
	
	
	@Override 
	public int compareTo(Menuitem i){
		if(this.type.equals("Burger")){
           if(i.type.equals("Snack") || i.type.equals("Drink")){
               return -1;
           } else {
               return Integer.compare(this.getID(),i.getID());
           }
       } else if(this.type.equals("Snack")){
           if(i.type.equals("Burger")){
               return 1;
           } else if(i.type.equals("Drink")){
               return -1;
           } else {
               return Integer.compare(this.getID(),i.getID());
           }
       } else if(this.type.equals("Drink")){
           if(i.type.equals("Burger") || i.type.equals("Snack")){
               return 1;
           } else {
               return Integer.compare(this.getID(),i.getID());
           }
       }
	   else{//this combo
	   
			if(i.type.equals("Burger") || i.type.equals("Snack")|| i.type.equals("Drink")){
               return 1;
           } else {
               return Integer.compare(this.getID(),i.getID());
           }
	   
	   }
	}





    @Override
    public String toString(){
    
        return "#"+this.id + " "+ this.type +": "+ this.desc +" ("+this.cost+")";
    
    
    }



}
