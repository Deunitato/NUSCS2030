


//import java.util.scanner;
class Point{
 private double x;
 private double y;
// public String midpt="null";
protected Point pt;
 protected double angel=0;

 public Point(double x,double y){

     this.x=x;
     this.y=y;
 
 
 }

public Point(double x){
this.x=x;
}

 public void setX(double x){
 this.x=x;
 
 }



 public void setY(double y){
 this.y=y;
 
 }

public double  getX(){
return x;
}
    
public double  getY(){

return y;

}


public Point midPoint(Point o){
//if(o instanceof Point){
double ptx = (this.x+o.getX())/2;
double pty=(this.y+o.getY())/2;
pt = new Point(ptx,pty);
return pt;

}


public double angleTo(Point o){
	this.angel = (double)Math.atan2(o.y - y, o.x - x);
   return this.angel;
	
	
}


@Override
public String toString(){
	
String x =String.format("%.3f", this.x);
String y =String.format("%.3f", this.y);
return "(" + x +", " +y+")";

}






}