package cs2030.catsanddogs;

public class Dog extends Animal{

   private String sound;
    Dog(){}
    Dog(String name,int appetite, String sound){
    
        super(name,appetite);
        this.sound =sound;

        System.out.println(name+" was created");
    
    }


    public String getSound(){
    
        return this.sound;
    
    }

    @Override
    public void eat(){
    
    
    }
    @Override
    public void hello(){
    
    
    
    }

}
