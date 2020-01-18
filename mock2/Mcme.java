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
           try{ 
           Menuitem m = this.find(i);
            System.out.println(m);
          
          cost = cost + m.getCost();
       
        }
        catch (Exception e){
        System.out.print("w");
        }
        }

       System.out.println("Total: "+cost);
    
        
        
    }


    public Menuitem find(int id) throws Exception{
        for(int i=0;i<menu.size();i++){
            if(menu.get(i).getID()==id){
                return menu.get(i);
            }
        
        }
        if(true){
        throw new Exception();}

        return new Menuitem();
    
    }



    public void printAll(){
       Collections.sort(menu);    
        for(int i = 0;i<menu.size();i++){
       //     if(menu.get(i).getType()!=3){
            System.out.println(menu.get(i));
           // }
        }
    
    }


}
