class Grab extends Taxi{
private double booking = 3.20;
private double km =1.50;
private boolean book = false;
public void getPrice(double dis){

price = dis*km+booking;

}

public Grab(){
super(3.2,1.5);

}

@Override
public String toString(){

return "im a grab" + super.price;
}


}



