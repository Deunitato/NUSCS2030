package cs2030.catsanddogs;
public class Choco extends Food{

    private String flavour;
    Choco(){}
    Choco(String brand, String flavour){
    
        super(brand);
        this.flavour = flavour;
        System.out.println(brand+" "+flavour+" chocolate was added");
    
    }

    public String getFlavour(){
    
        return this.flavour;
    
    }

      @Override
       public String toString(){

       return super.toString()+" "+this.flavour+" chocolate";
       }
       
  }

