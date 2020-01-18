
//import java.util.scanner;
class Point{
 private double x;
 private double y;

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


public double midPoint(Point o){
if(o instanceof Point){
double oX= o.getX();
double oY = o.getY();
return (this.x+oX)/2+(this.y+oY)/2;

}
else{
return 0;}



}


@Override
public String toString(){
String x =String.format("%.3f", this.x);
String y =String.format("%.3f", this.y);
return "(" + x +", " +y+")";

}
    

    







}
