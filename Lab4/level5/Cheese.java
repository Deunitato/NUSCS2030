package cs2030.catsanddogs;
public class Cheese extends Food{

    Cheese(){}
    Cheese(String brand){
    super(brand);
    System.out.println(brand+ " cheese was added");
    }


    @Override
    public String toString(){
    
        return super.toString()+" cheese";
    
    }

}
