import java.util.Scanner;

public class Main{

    public static void main(String[] args) { 
        Scanner sc =new Scanner(System.in);
        Mcme me = new Mcme();
        int i=0;
        while(sc.next().equals("add")){
            String type = sc.next();
           
            
            if(type.equals("Combo")){
                   Combo c = new Combo(i);
                   int index1 = sc.nextInt();
                   int index2 = sc.nextInt();
                   int index3 = sc.nextInt();
                   try{
                   c.addItems(me.find(index1),me.find(index2),me.find(index3));
                   
                   me.addItem(c);
                   }
                   catch(Exception e){
                   
                       System.out.println("Error: Invalid combo input "+index1+" "+index2+" "+index3);

                       i--;
                   }
                  
                   // c.addItem(me.find(index2));
                  // c.addItem(me.find(index3));
                 
           

            }
           else{
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
