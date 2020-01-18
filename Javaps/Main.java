import java.util.Scanner;


class Main{
public static void main(String[] args){
    String type;
    
    Scanner sc = new Scanner(System.in);
    type=sc.next();
    Taxi tx;
    if(type.equals("Go-Jek")){
        tx = new Gojek();
    
    }
    else if(type.equals("Grab"))
    {
    
         tx = new Grab();
    
    }
    else{
        tx = new Taxi();
    
    }
 double distance = sc.nextDouble();
 tx.setPrice(distance);
  System.out.println(tx);


}




}
