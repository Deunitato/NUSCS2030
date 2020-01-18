import java.util.stream.IntStream;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
public class Main{

    static int y=-1;
    static boolean flag = false;
    
    static boolean bigChungus(int x){
        if(y==-1){
            y=x;
            return false;
        }
        else if(y==x && !flag){
            flag = true;
            return true;
        }
        else if(y!=x){
        
            y=x;
            flag = false;
            return false;
        }
        else{
			return false;
        }
    
    }

    static long countRepeats(int[] array){
		
    
   //  IntStream  Arrays.stream(array);
    

       long  count= Arrays.stream(array)
           .filter(x->bigChungus(x))
           .count();
       //System.out.println(count);
          


           return count;

    
    }



}
