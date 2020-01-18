import java.util.Scanner;


public class  Main{
    


    public static void main(String[] args){
     
    //Cruise[] c;    
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    Cruise[] c = new Cruise[times];
	boolean loop = true;
    Loader l[] = new Loader[100];
    int loadercount=1;
	
	//input
    for(int i=0;i<times ; i++){
    String shipName = scan.next();
    int time = scan.nextInt();
	
	
	//sort into big
	if(shipName.charAt(0)=='B'){
		
		c[i]= new Bigcruise(shipName,time);
	}
	else{
    c[i]= new Cruise(shipName,time); }
    }
	
	
	
	
	//init
	l[0] = new Loader(1);
    for (int j =0 ; j<times ; j++){     
	 for(int k =0 ;k<100 ; k++){
	
		if(l[k].loadReady(c[j])){ //check if  previous ship is done
            //System.out.println(l[k]);
			if(c[j] instanceof Bigcruise && loop){
				l[k].setCruise(c[j]); //setCruise
				k=-1; //go back down one slot
				loop = false;
				continue;
			}
			else if (c[j] instanceof Bigcruise){
				l[k].setCruise(c[j]);
				loop = true;
				//System.out.println("success");
				break;
			}
			else if(c[j] instanceof Cruise){
				l[k].setCruise(c[j]);
				//System.out.println("success");
				break;
				}
			
		 }
		 else if(l[k+1]!=null){
			 continue;
		 }
		 else{ //if ithe previous ship haven done and theres no more ship
			 
			 loadercount++;
			 l[k+1] = new Loader(k+2);
			 continue;
		 //put in next load
		 
		 
		 }
		 
     //   System.out.println(c[j]);
    }
	}
    
    //display the loader:
    //
     for(int i =0;i<loadercount;i++){
     System.out.println(l[i]);
     
     }

}}
