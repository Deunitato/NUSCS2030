public class Menuitem{
    private String type;
    private String desc;
    private int id;
    private int cost;
    
    Menuitem(){}
    
    
    Menuitem(String type,String desc,int cost,int id){
    this.type = type;
    this.desc = desc;
    this.cost= cost;
    this.id = id; 
    
    }

    public void setID(int id){
    this.id = id;
    }


    @Override
    public String toString(){
    
        return "#"+this.id + " "+ this.type +": "+ this.desc +" ("+this.cost+")";
    
    
    }



}
