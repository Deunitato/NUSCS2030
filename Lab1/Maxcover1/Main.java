

import java.util.Scanner;

class Main{


    
    public static void  main(String[] args){
  double x=0.0;
  double y=0.0;
  int times = 0;
  Point[] arr;
  
  Scanner scanner =new Scanner(System.in);
  
 //  System.out.println("Times");
   times = scanner.nextInt();
   arr = new Point[times];
   for(int i = 0; i<times ; i++){
   //System.out.println("Type out X");
    x= scanner.nextDouble();       
  // System.out.println("Type out Y:");
     y=scanner.nextDouble();
   arr[i] = new Point(x,y); 
    
   // System.out.println(point);
   }

    for(int j = 0; j<times ; j++){
    System.out.println(arr[j]);
    }






} }
