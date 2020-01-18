package cs2030.catsanddogs;
public class Cat extends Animal{
	//cats oni eat tuna and choco

    private String color;

    private boolean isLazy =false;
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
    public boolean edible(Food f){
    
        if(f instanceof Tuna || f instanceof Choco){
        return true;
        
        }
        else{
        return false;
        
        }
    
    
    }

    @Override
    public boolean eat(Food f){
    
        if(this.edible(f)){
            super.decApp();
        
            System.out.println(super.getName()+"("+this.color+") eats "+f);
       
            return true;
        }
        else{
        return false;
        }
    }

    @Override
    public void hello(){
    
        if(isLazy){
        
            this.isLazy = false;
            System.out.println(super.getName()+"("+color+") is lazy");
        }
        else{
        
            System.out.println(super.getName()+"("+this.color+") says meow and gets lazy");
            this.isLazy = true;
        
        }
    
    }


}
