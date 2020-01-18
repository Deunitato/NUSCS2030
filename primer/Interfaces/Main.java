import java.util.ArrayList;
import java.util.List;
public class Main {
    
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat t = new Cat();
        Plant p = new Plant();
        Doggie doggie = new Doggie();
        
        List<Livingthings> list = new ArrayList<>();
        list.add(d);
        list.add(t);
        list.add(doggie);
        list.add(p);
        for(int i=0;i<list.size();i++){
        list.get(i).makeSound();
        
        }
        return;
    }

}
