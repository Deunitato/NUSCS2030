import java.util.Scanner;
class Main{

public static void main(String[] args){

 double x=0.0;
 double y=0.0;
  int times = 0;
  Point[] arr;
  Point first;
  Point second;
  
  Scanner scanner =new Scanner(System.in);

Point ans;
double ang =0;
//System.out.println("Times");
times = scanner.nextInt();
arr = new Point[times];


//ask for user input
   for(int i = 0; i<times ; i++){
  // System.out.println("Type out X");
    x= scanner.nextDouble();       
   //System.out.println("Type out Y:");
     y=scanner.nextDouble();
   arr[i] = new Point(x,y); 
   }

   //this is where we output everything....
    for(int j = 0; j<times-1 ; j++){
	first = arr[j];
	second = arr[j+1];
	if(second!=null){
     ans = first.midPoint(second);
     ang = first.angleTo(second);
	 String an =String.format("%.3f", ang);
    System.out.println(first + " and "+ second + " has mid-point " +ans + " and angle " + an);
	
	}
	else{}
    }
}






}


/*    

   for(int i = 0; i<times ; i++){



   System.out.println("Type out X");
    x= scanner.nextDouble();       
   System.out.println("Type out Y:");
     y=scanner.nextDouble();
   arr[i] = new Point(x,y); 
    
   // System.out.println(point);
   }

    for(int j = 0; j<times ; j++){
    System.out.println(arr[j]);
    }






} }

*/