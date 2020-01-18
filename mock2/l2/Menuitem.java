public class Menuitem implements Comparable<Menuitem>{

    private int id;
    private int cost;
    private String name;
    private int type;
    Menuitem(){}
    Menuitem(int id){
    
    this.id = id;
    }

    Menuitem(int id,String name,int cost){
        this.id =id;
        this.name =name;
        this.cost = cost;
    
    }

    public void setType(int i){
        this.type = i;
    
    }

    public int getType(){
       return this.type;
    
    }
    public int getID(){
    
    return this.id;
    }

    public int getCost(){
    
    return this.cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    
    }
    @Override
    public String toString(){
    String type ="";
        
        if(this.type==0){
        type = "Burger";
        }
        else if(this.type ==1){
        type="Snack";
        }
        else{
        type ="Drink";
        }
    return "#"+this.id + " "+type+": "+this.name +" ("+this.cost +")"; 
    
    }

    @Override 
    public int compareTo(Menuitem m){
        int other = m.getType();
        if(this.type!=other){
        return Integer.compare(this.type,other);
        }
        else{
        return Integer.compare(this.id,m.getID());
        
        }
    
    }



}
