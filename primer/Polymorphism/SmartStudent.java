public class SmartStudent extends Student {
   
    private String name;

    public SmartStudent(String name) {
        super(name);
    }
    @Override
    public void sayHello() {
        System.out.println(this.name + " says hello!");
    }
    @Override
    public void study() {
        System.out.println("I'm really smart!");
    }

}
