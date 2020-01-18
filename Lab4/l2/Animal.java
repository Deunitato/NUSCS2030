package cs2030.catsanddogs;

public abstract class Animal{

    private String name;
    private int appetite;

    Animal(){}
    Animal(String name,int appetite){
    
        this.name = name;
        this.appetite = appetite;
    
    }
    public abstract void eat();
    public abstract void hello();





}
