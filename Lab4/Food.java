package cs2030.catsanddogs;

public abstract class Food{

    String brand;

    Food(){}

    Food(String brand){
    
    this.brand = brand;
    }

//    public abstract boolean edible();

    @Override
    public String toString(){
    
    
        return brand;
    
    }





}
