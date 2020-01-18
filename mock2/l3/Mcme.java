import java.util.Collections;
import java.util.ArrayList;
public class Mcme{
private ArrayList<Menuitem> menu = new ArrayList<>();
private ArrayList<Integer> num = new ArrayList<>();
    Mcme(){}
    public void addItem(Menuitem m){
     menu.add(m);
    
    }

    public void addOrder(int i){
    num.add(i);
    
    }

    public void printOrder(){
    System.out.println("--- Order ---");
        int cost =0;
        for(int i: num){
           Menuitem m = this.find(i);
            System.out.println(m);
          cost = cost + m.getCost();
       
        }

       System.out.println("Total: "+cost);
        
        
        
        
        
    
    
    
    }


    private Menuitem find(int id){
        for(int i=0;i<menu.size();i++){
            if(menu.get(i).getID()==id){
                return menu.get(i);
            }
        
        }

        return new Menuitem();
    
    }



    public void printAll(){
       Collections.sort(menu);    
        for(int i = 0;i<menu.size();i++){
            System.out.println(menu.get(i));
        }
    
    }


}
