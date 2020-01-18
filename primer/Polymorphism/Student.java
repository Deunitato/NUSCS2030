public class Student {
   
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(this.name + " says hello!");
    }

    public void study() {
        System.out.println("I'm studying!");
    }

}
