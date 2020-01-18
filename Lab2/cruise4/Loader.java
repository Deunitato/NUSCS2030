import java.util.*;  
public class Loader{

private int time;
private int num;
//private Cruise c[];
private int count;
boolean first;
private Object o;
ArrayList<Object> c = new ArrayList<Object>() ;
 
  

  public Loader(int num){
    //this.c = new Cruise[10];
	//this.c= new ArrayList<Cruise>();
    this.num = num;
	this.first = true;
	this.count =0;

}

public Object getPrev(){
	return this.o;
}

public Loader(){
 this.count =0;

}

public int getNum(){
	
	return this.num;
}
   



public void setCruise(Object a){

    c.add(a);
	this.o = a;
    this.count=this.count +1;


}




private int timeConvert(int a, int me){
	int hr = (a/100)-(me/100);
	int min = (a%100)-(me %100);
	int total = hr *60 +min;
	return total;
	
}



//tells me if the next ship is ready
     public boolean loadReady(Object next){
		 
       if(first){
		   
		  this.first = false;
       return true; //if the loader is empty;
       
       }
	   else if(o ==null){
				return true;
			}
		else{
			//this.o =c.get(count-1);
			int Atime = ((Cruise)(this.o)).getTime();
			//System.out.println(o);
			//int Atime = Integer.parseInt(at);
			//int Btime = Integer.parseInt(((Cruise)next).getTime());
			int Btime = ((Cruise)next).getTime();
			//int timediff = ((Btime / 100)*60 + Btime%100)-((Atime / 100)*60 + Atime%100);
			int timediff = timeConvert(Btime,Atime);
			if(o instanceof Bigcruise){    
				//System.out.println(timediff);
			
				return (timediff)>=60;
			}
			else if(o instanceof Cruise){
				
				return (timediff)>=30;
			}
			else {
				//System.out.println("ok");
				return false;}
        }
	  // return false;
     }


public String toString(){
	
//	for(int i =0;i<2;i++){
  //   System.out.println(c[i]);
     
    // }
	
 String ans="";
 
    for(int i = 0; i<count;i++){ //edit here
		if(i+1== count){
		ans = ans + "    "+c.get(i);}
		else{
			ans = ans + "    "+c.get(i) + "\n";
		}
 }
    
    String k = "Loader " + num + " serves:\n" + ans;
return k;

}
}
