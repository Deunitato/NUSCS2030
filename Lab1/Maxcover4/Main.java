import java.util.Scanner;
class Main{
public static void main(String[] args){

  double x=0.0;
  double y=0.0;
  int times = 0;
  Point[] arr;
  Point first;
  Point second;
  int count = 0;
	int temp;
  Circle c1 = new Circle();
  
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
//=============================================


   //this is where we output everything....
    for(int j = 0; j<times ; j++){
		first = arr[j];
		for(int i = 0 ; i< times; i++){
			second = arr[i];	   
			Point cent = c1.getCenter(first, second);
			c1.setCenter(cent);
			temp = 0;
			if(!(first.withinCircle(second))){
				continue;
			}
			else if(first.getDistance(second)!=0){ //check if same point
				//temp =2;
				for(int f = 0 ; f<times; f++){
					Point next = arr[f];
					if(c1.isInside(next)){
						temp++;
							
							//System.out.println(temp);
					}
				}
					
			}
			else{
				temp=1;
			}		
			count = isBigger(count,temp);	
		}
    }
	System.out.println("Maximum Disc Coverage: " + count);
}

public static int isBigger(int x, int y){
	if(x>y){
		return x;
	}
	else {
		return y;
	}
	
}

/*public int maxCover(Point[] pt,Point c){
	int count = 0;
	
	for(int i = 0 ; i< times; i++){
	
	
		
		if(!(pt[i].withinCircle(pt[i+1]))){
			break;
		}
		else{
			
			for(int j = 0 ; j< times; j++){
			
			}
			
		}
		

		
		
	}
	
	return count;
	
	
	
	
}
*/

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