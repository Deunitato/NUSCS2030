import java.util.Collections;
import java.util.ArrayList;
public class Mcme{
private ArrayList<Menuitem> menu = new ArrayList<>();

    Mcme(){}
    public void addItem(Menuitem m){
     menu.add(m);
    
    }

    public void printAll(){
       Collections.sort(menu);    
        for(int i = 0;i<menu.size();i++){
            System.out.println(menu.get(i));
        }
    
    }


}
