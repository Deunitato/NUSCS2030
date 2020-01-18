import java.util.Scanner;


public class  Main{
    


    public static void main(String[] args){
     
    //Cruise[] c;    
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    Cruise[] c = new Cruise[times];

    for(int i=0;i<times ; i++){
    String shipName = scan.next();
    int time = scan.nextInt();
    c[i]= new Cruise(shipName,time); 
    }

    //print out
    //
    for (int j =0 ; j<times ; j++){
    System.out.println(c[j]);
    }




    }



}
