import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student s = new Student("Alice");
        Smartstudent t = new Smartstudent("Bob");
        s.sayHello();
        t.sayHello();
        s.study();
        t.study();
        return;
    }

}
