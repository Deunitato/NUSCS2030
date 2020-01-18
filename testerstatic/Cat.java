public class Cat{
    static Animal ani = new Animal();

    Cat(String name, Animal a){
       ani = a;
       ani.addName(name);
    }

    Cat(String name){
    ani.addName(name);
    }
    public void addName(String name){
    ani.addName(name);
    
    }



}
