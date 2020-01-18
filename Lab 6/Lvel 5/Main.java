import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class Main{

    static int y=0;
    static boolean flag = false;
    public static void main(String[] args) { 


        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        System.out.print("Prime factors of " + num +" are:");
         primeFactors(num)
            .forEach(x-> System.out.print(" "+x));

         System.out.println("");
       

      
       
       
       

       
       
       
       


      // .toArray();
 //    canner(System.in);
      
      




    }

    static IntStream factors(int x){
    
        return IntStream.rangeClosed(1,x)
            .filter(n-> x%n ==0);
        
    
    
    }


    static boolean isPrime(int x){
    
        if(x==1){
        return false;
        }
        else if (x==2){
       
            return true;
        }

        long count = IntStream.range(2,x)
            .filter(y-> x%y==0)
            .count();
        if(count==0){
        return true;
        }
        else{

            //System.out.println(count);
        return false;
        }

    
    }


    static IntStream primeFactors(int x){
    
        return factors(x)
            .filter(y->isPrime(y));
           // .toArray();
    
   //return list; 
    }








}
