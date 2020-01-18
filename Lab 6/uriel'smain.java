import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main{
    public static IntStream primeFactors(int x){
    	return IntStream.rangeClosed(2, x)
                        .filter( y -> x % y == 0 )
                        .filter( y -> IntStream.range(2,y).noneMatch( z -> y%z == 0 ));
    }
    public static OptionalDouble variance(int[] array){
        if(array.length < 2){
            return OptionalDouble.empty();
        }
        double mean = Arrays.stream(array).sum() * 1.0 / array.length;
        double variance = Arrays.stream(array)
                                .asDoubleStream()
                                .map( x -> ((x - mean) * (x - mean)))
                                .sum() / (array.length - 1);
        return OptionalDouble.of(variance);
    }
    public static long countRepeats(int[] array){
        return IntStream.range(-1, array.length-2)
                  .filter(x->((x<0||array[x]!=array[x+1])&&(array[x+1]==array[x+2])))
                  .count();
    }
    public static boolean isSquare(int input){
        return IntStream.rangeClosed(0, input)
                        .map( x -> x*x )
                        .anyMatch( x -> x == input );
    }

    public static boolean isPerfect(int input){
        return IntStream.range(1, input)
                        .filter( x -> input % x == 0 )
                        .sum() == input;
    }
    public static void main(String[] args){
    	//woot woot
    }
}
