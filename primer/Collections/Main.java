
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.LinkedList;



public class Main {

    public static void main(String[] args) {
     PriorityQueue<Cat> list = new PriorityQueue<Cat>();
        
        Cat c1 = new Cat(4);
        Cat c2 = new Cat(6);
        Cat c3 = new Cat(1);
       // c3.sayHello();
       // c1.sayHello();
       // c2.sayHello();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        while(!(list.size()==0)){
        list.poll().sayHello();
        
        }
      //  Dog d1 = new Dog();
       // d1.sayHello();
        return;
    }
}
