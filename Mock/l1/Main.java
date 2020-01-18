import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    
    public static void main(String[] args) { 
       int j =0;
       Scanner sc = new Scanner(System.in);
       ArrayList<Menuitem> mi = new ArrayList<>();
       while(sc.next().equals("add")){
       
        String type = sc.next();
        String desc = sc.next();
        int price = sc.nextInt();
       // System.out.println(type+" "+desc + " "+ price);
        mi.add(new Menuitem(type,desc,price,j));
        j++;
       }


       for(int i = 0; i<mi.size(); i++){
        System.out.println(mi.get(i));
       
       }



    }


}
