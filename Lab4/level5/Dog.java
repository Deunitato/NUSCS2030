package cs2030.catsanddogs;

public class Dog extends Animal{
//dog can only eat tuna and cheese
//everytime a dog makes a sound,it will makemore in the future
//woof now then woofwoof second then woofwoofwoof the third;
   private String sound;
   private String longSound="";
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
    public boolean edible(Food f){
    
        if(f instanceof Tuna || f instanceof Cheese){
        
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
			System.out.println(super.getName()+" eats "+ f);
		
			return true;
		}
		else{
		
			  return false;
		}
    
    }
    @Override
    public void hello(){
   
        this.longSound = this.longSound + this.sound;
        System.out.println(super.getName()+" says "+this.longSound);
        
    
    
    }

}
