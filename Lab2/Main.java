import java.util.Scanner;


public class  Main{
    


    public static void main(String[] args){
     Stats s = new Stats();
    //Cruise[] c;    
    Scanner scan = new Scanner(System.in);
    int times = scan.nextInt();
    Cruise[] c = new Cruise[times];
	boolean loop = true;
    Loader l[] = new Loader[100];
    int loadercount=1;
	int big =0;
	int small =0;
	
	
    for(int i=0;i<times ; i++){
    String shipName = scan.next();
    int time = scan.nextInt();
	//sort into big
	
	if(shipName.charAt(0)=='B'){
		big ++;
		c[i]= new Bigcruise(shipName,time);
	}
	else{
		small ++;
    c[i]= new Cruise(shipName,time); }
    }
	
	
	
	
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
			 if(((k+2)%3)==0){
				 l[k+1] = new ReLoaders(k+2);
			 }
			 else{
			 l[k+1] = new Loader(k+2);}
			 continue;
		 //put in next load
		 
		 
		 }
		 
     //   System.out.println(c[j]);
    }
	}
	
	//Stats//
	
	s.setEquip(loadercount-(loadercount/3), loadercount/3);//set loaders and reloaders
	s.setCruise(small,big); //set number of ships
	String p = s.headerBuild("Cruise Statistics") +s.statsCBuild() + s.headerBuild("Equipment statistics") + s .statsEBuild() +"+==================================+";
	System.out.print(p);
	
    
    //display the loader:
    //
	//dispplay normal
     for(int i =0;i<loadercount;i++){
     if((i+1)%3!= 0 ){
	 s.printCruise(l[i]);}
     
     }
	 //display reloaders
	 for(int i =0;i<loadercount;i++){
     if((i+1)%3== 0 ){
	 s.printCruise(l[i]);}
     
     }
  System.out.print("\n");
}}
