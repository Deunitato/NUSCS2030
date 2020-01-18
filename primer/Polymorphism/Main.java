import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Student> mylist = new ArrayList<>();
        Student s = new Student("Alice");
        SmartStudent t = new SmartStudent("Bob");
        AbsoluteGenius g = new AbsoluteGenius("Charlie");
        Student a = new Student("Dog");
        mylist.add(s);
        mylist.add(a);
        mylist.add(g);
        mylist.add(t);

        for(int i=0;i<mylist.size();i++){
        mylist.get(i).study();
        mylist.get(i).sayHello();
        mylist.get(i).study();
        }


        return;
    }

}
