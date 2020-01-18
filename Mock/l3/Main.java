import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Main{
    
    public static void main(String[] args) { 
       int j =0;
       Scanner sc = new Scanner(System.in);
       PriorityQueue<Menuitem> mi = new PriorityQueue<Menuitem>();
       ArrayList<Integer> num = new ArrayList<>();
       Object[] arr;
       int cost=0;
       while(sc.next().equals("add")){
       
        String type = sc.next();
        String desc = sc.next();
        int price = sc.nextInt();
       // System.out.println(type+" "+desc + " "+ price);
        mi.add(new Menuitem(type,desc,price,j));
        j++;
       }
       
       while(sc.hasNext()){
        num.add(sc.nextInt());
       }
        System.out.println("--- Order ---");
          arr = mi.toArray();

      for(int i : num){
        for(Menuitem s: mi){
          if(s.getID()==i){
            cost = cost+s.getCost(); 
             System.out.println(s);
             break;
            }
        }
      
      }

      System.out.println("Total: "+cost);
        



    }


}
