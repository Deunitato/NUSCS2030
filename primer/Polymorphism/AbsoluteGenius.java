public class AbsoluteGenius extends Student {
   
    private String name;

    public AbsoluteGenius(String name) {
        super(name);
    }
    @Override
    public void sayHello() {
        System.out.println(this.name + " says hello!");
    }

    @Override
    public void study() {
        System.out.println("I created the theory of relativity.");
    }

}
