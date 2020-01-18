import java.util.stream.Stream;
import java.util.Scanner;
public class Main{

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //whyyyyy
    fib(sc.nextInt());


}


static void fib(int m){

    Stream.iterate(new int[]{0,1} , n-> new int[]{n[1],n[0]+n[1]}) 
        .limit(m+1)
        .filter(n-> !(n[0]==0))
        .forEach(x->{
        System.out.println(x[0]);
        
        });



}



}
