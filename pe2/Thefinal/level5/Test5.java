import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Test5{


public static void main(String... args){
	Scanner sc = new Scanner(System.in);
	List <String> list = new ArrayList<>();
	while(sc.hasNext()){
	list.add(sc.nextLine());
	}
  System.out.println(Parser.parse(list).shuffle());

}

}