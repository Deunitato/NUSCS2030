public class Cat extends Animal implements Comparable<Cat> {

    int id;

    public Cat(int id) {
        this.id = id;
    }

    @Override
    public void sayHello() {
        System.out.println("cat " + this.id + " meows");
    }



    @Override
    public int compareTo(Cat c){
    
        return this.id - c.id;
    
    }


}
