public class Cruise{
 private int  time;
 private String shipName;
// private int loadingTime;

    public Cruise(String name ,int time){
    this.shipName = name;
	this.time = time;
    /*if(time.equals("0")){
    
    this.time = "0000";
    }
    else{
    this.time =""+ time;
    }*/
    
    }
    public int  getTime(){
    
    return this.time;
    
    }

    public String getName(){
    
        return this.shipName;
    
    }



    @Override 
    public String toString(){
    
        String k = this.shipName +"@" + String.format("%04d",this.time);
        return k;
    
    }



}
