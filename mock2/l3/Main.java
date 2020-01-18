import java.util.Scanner;

public class Main{

    public static void main(String[] args) { 
        Scanner sc =new Scanner(System.in);
        Mcme me = new Mcme();
        int i=0;
        while(sc.next().equals("add")){
            String type = sc.next();
            String desc = sc.next();
            int price = sc.nextInt();
            if(type.equals("Burger")){
            me.addItem(new Burger(i,desc,price));
            
            }
            else if (type.equals("Drink")){
             me.addItem(new Drink(i,desc,price));
             
            }
            else{
            
                me.addItem(new Snack(i,desc,price));         
             }
            i++;
        }
        

         me.printAll();
         //read all
         while(sc.hasNext()){
         me.addOrder(sc.nextInt());
         
         }

         me.printOrder();
    }



}
