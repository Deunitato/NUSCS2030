import java.util.*;  
public class Loader{

private int time;
private int num;
//private Cruise c[];
private int count;
boolean first;
private Object o;
ArrayList<Object> c = new ArrayList<Object>() ;
 private String ans;
  private Stats e = new Stats();

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
			
			int Btime = ((Cruise)next).getTime();
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

	 public String getList(){
		 
		 return this.ans;
	 }


public String toString(){
	
//	for(int i =0;i<2;i++){
  //   System.out.println(c[i]);
     
    // }
	
 String ans="";
 
 
    String x = "Loader "+num +" serves:";
		x = e.justifyLeft(33,x);
 
    for(int i = 0; i<count;i++){ //edit here
		if(i+1== count){
		ans = ans + "|     "+c.get(i)+"                   |\n";}
		else{
			ans = ans + "|     "+c.get(i) + "                   |\n";
		}
 }
    this.ans = ans;
    String k = "| "+x+"|\n" + ans;
return k;

}
}
