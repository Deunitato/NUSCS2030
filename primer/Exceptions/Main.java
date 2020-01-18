import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static List<Cruise> listOfCruises = new ArrayList<>();


    public static void main(String[] args) {
        int numOfCruises = SCANNER.nextInt();
       try{
        readCruises(numOfCruises);
        for (Cruise c : listOfCruises) {
            System.out.println(c);
        }
        return;
       }
        catch(IllegalTimeException e){
          System.out.println(e);
        }
    }

    public static void readCruises(int numOfCruises) {
        for (int i = 0; i < numOfCruises; ++i) {
            listOfCruises.add(new Cruise(SCANNER.next(), SCANNER.nextInt()));
        }
    }

}
