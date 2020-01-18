

import java.util.Scanner;

class Main{


    
    public static void  main(String[] args){
  double x=0.0;
  double y=0.0;
  int times =0
   Scanner scanner =new Scanner(System.in);
  times = scanner.nextInt(); 
  for(int i=0;i<times;i++){
   System.out.println("Type out X");
    x= scanner.nextDouble();       
   System.out.println("Type out Y:");
     y=scanner.nextDouble();
   Point point = new Point(x,y); 
    
    System.out.println(point);
    
    
    }}






}
