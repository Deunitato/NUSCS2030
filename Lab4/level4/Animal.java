package cs2030.catsanddogs;

public abstract class Animal implements Comparable<Animal>{

    private String name;
    private int appetite;

    Animal(){}
    Animal(String name,int appetite){
    
        this.name = name;
        this.appetite = appetite;
    
    }
    public abstract boolean eat(Food f);
    public abstract void hello();
    public abstract boolean edible(Food f);

    public String getName(){
    
        return this.name;
    
    }

    public boolean isFull(){
    
        if(this.appetite<=0){
        return true;
        }
        else{
        return false;
        
        }
    
    }

    public void decApp(){
    
        this.appetite = this.appetite-1;
    }
    @Override
    public int compareTo(Animal a){
    return this.name.compareTo(a.getName());

    
    }



}
