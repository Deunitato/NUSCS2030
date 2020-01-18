import java.util.stream.IntStream;

import java.util.Scanner;
public class Main{

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in);
        System.out.println(isSquare(sc.nextInt()));
        




    }


    static boolean isSquare(int n ){
    
		if(n==0){
			return true;
		}
		if(n==1){
			return true;
		}
    
        long count =IntStream.range(1,n)
            .filter(x-> (x*x)==n)
            .count();

      // System.out.println(count);

        return count!=0;
        

    
    
    }



}
