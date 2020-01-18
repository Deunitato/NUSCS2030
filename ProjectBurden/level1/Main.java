import java.util.Scanner;
public class Main{

    public static void main(String[] args) {

       EventSimulator es = new EventSimulator(); 
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        
            double time = sc.nextDouble();
            es.addEvent(new Arrival(time));
        }
        es.printAll();
    }


}
