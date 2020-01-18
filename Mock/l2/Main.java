import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Main{
    
    public static void main(String[] args) { 
       int j =0;
       Scanner sc = new Scanner(System.in);
       PriorityQueue<Menuitem> mi = new PriorityQueue<Menuitem>();
       while(sc.next().equals("add")){
       
        String type = sc.next();
        String desc = sc.next();
        int price = sc.nextInt();
       // System.out.println(type+" "+desc + " "+ price);
        mi.add(new Menuitem(type,desc,price,j));
        j++;
       }


       while(mi.size()!= 0){
        System.out.println(mi.poll());
       
       }



    }


}
