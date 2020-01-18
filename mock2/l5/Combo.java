import java.util.ArrayList;
public class Combo extends Menuitem{
private ArrayList<Menuitem> list = new ArrayList<>();


    Combo(){}
    Combo(int id){
     super(id);
     super.addCost(-50);
     super.setType(3);
    }
    public void addItems(Menuitem m,Menuitem c,Menuitem b)throws Exception{
       if(m.getType()!=0||c.getType()!=1||b.getType()!=2){
       throw new Exception();
       }
        
        list.add(m);
        list.add(c);
        list.add(b);
        super.addCost(m.getCost());
        super.addCost(c.getCost());
        super.addCost(b.getCost());
    }


    @Override 
    public String toString(){
    
        String s = super.getID()+" Combo ("+super.getCost()+")\n";
        for(Menuitem m : list){
        s=s+"   "+m+"\n";
        
        }

        return s;
    
    
    }

}
