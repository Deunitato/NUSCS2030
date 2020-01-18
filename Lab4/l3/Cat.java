package cs2030.catsanddogs;
public class Cat extends Animal{

    private String color;

    Cat(){}
    Cat(String name,int appetite, String color){
    super(name,appetite);
    this.color = color;
    System.out.println(name+"("+color+") was created");
    
    
    }

    public String getColor(){
    
        return this.color;

    
    }

    @Override
    public void eat(){
    
    }

    @Override
    public void hello(){
    
    
    }


}
