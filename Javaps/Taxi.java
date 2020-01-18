class Taxi{
private double booking=100;
private double km = 10;
private String type;
private boolean book=false;
protected double price=0;


public Taxi(double booking,double km){
 this.booking = booking;
 this.km = km;
}

public Taxi(){
this(100,10);
}


public void setPrice(double dis){
    
   this.price=dis*km + booking;

}



@Override
public String toString(){
return "Im a taxi and The price is " + this.price;

}





}
