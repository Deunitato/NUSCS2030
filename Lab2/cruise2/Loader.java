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
/*
public void setNum(int num){
	
	this.num = num;
}
  */  



public void setCruise(Cruise a){

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
     public boolean  loadReady(Cruise next){
    
       if(first){
		  // System.out.println("ok");
		  this.first = false;
       return true; //if the loader is empty;
       
       }
       else{
        int Atime = ((Cruise)(this.o)).getTime();	
			int Btime = ((Cruise)next).getTime();
			int timediff = timeConvert(Btime,Atime);
            
      return (timediff)>30;
       }
     }

@Override
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
